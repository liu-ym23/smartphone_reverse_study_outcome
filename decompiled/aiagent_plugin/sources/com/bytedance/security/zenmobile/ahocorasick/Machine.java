package com.bytedance.security.zenmobile.ahocorasick;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class Machine {
    static final int END_NODE_BASE = -1;
    static final int FAIL_STATE = -1;
    static final int ROOT_NODE_BASE = 1;
    static final int ROOT_NODE_INDEX = 0;
    static final int ROOT_STATE = 1;
    static Comparator<byte[]> byteArrayComparator;
    DoubleArrayTrie dat;
    List<byte[]> keywords;
    LinkedListTrie llt;
    Map<Integer, List<byte[]>> outputLinks;
    int[] suffixLinks;

    static {
        byteArrayComparator = $$Lambda$Machine$6eKKaMQQhp2yzwrt4MMtAPKkcaI.INSTANCE;
    }

    static /* synthetic */ int lambda$static$0(byte[] r5, byte[] r6) {
        int r0 = r5.length;
        int r1 = r6.length;
        int r2 = 0;
    L4:
        if (r2 >= Math.min(r0, r1)) goto L11;
        if (r5[r2] != r6[r2]) goto L8;
        r2 = r2 + 1;
        goto L4
    L8:
        return Integer.compare(r5[r2] & 255, r6[r2] & 255);
    L11:
        return Integer.compare(r0, r1);
    }

    public Machine(List<byte[]> r3) {
        build((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    public List<Match> multiPatternSearch(byte[] r10) {
        ArrayList r0 = new ArrayList();
        if (r10 != null) goto L5;
    L19:
        return r0;
    L5:
        if (r10.length == 0) goto L19;
        int r1 = 0;
        int r3 = 1;
    L9:
        if (r1 >= r10.length) goto L19;
        byte r4 = r10[r1];
    L11:
        int r5 = nextState(r3, r4);
        r3 = getSuffixLink(r3);
        if (r5 == (-1)) goto L11;
        if (r5 == 1) goto L18;
        if (this.outputLinks.containsKey(Integer.valueOf(r5)) == false) goto L18;
        r0.add(new Match(r1 + 1, (List) ZeusTransformUtils.preCheckCast(this.outputLinks.get(Integer.valueOf(r5)), List.class, "com.obric.aiagent.plugin")));
    L18:
        r1 = r1 + 1;
        r3 = r5;
        goto L9
    }

    public List<Match> multiPatternSearchWithStep(byte[] r13, int r14) {
        if (r14 > 0) goto L5;
    L6:
        r14 = 1;
    L7:
        ArrayList r1 = new ArrayList();
        int[] r2 = new int[r14];
        int[] r3 = new int[r14];
        Arrays.fill(r2, 1);
        if (r13 != null) goto L10;
    L31:
        return r1;
    L10:
        if (r13.length == 0) goto L31;
        int r5 = 0;
    L14:
        if (r5 >= r13.length) goto L31;
        int r6 = 0;
    L16:
        if (r6 >= r14) goto L30;
        int r7 = r5 + r6;
        if (r7 >= r13.length) goto L30;
        byte r8 = r13[r7];
    L21:
        r3[r6] = nextState(r2[r6], r8);
        r2[r6] = getSuffixLink(r2[r6]);
        if (r3[r6] == (-1)) goto L21;
        r2[r6] = r3[r6];
        if (r2[r6] == 1) goto L29;
        if (this.outputLinks.containsKey(Integer.valueOf(r2[r6])) == false) goto L29;
        r1.add(new Match(r7 + 1, (List) ZeusTransformUtils.preCheckCast(this.outputLinks.get(Integer.valueOf(r2[r6])), List.class, "com.obric.aiagent.plugin")));
    L29:
        r6 = r6 + 1;
    L30:
        r5 = r5 + r14;
        goto L14
    L5:
        if (r14 <= 10) goto L7;
        goto L6
    }

    private void build(List<byte[]> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        DoubleArrayTrie r0 = new DoubleArrayTrie();
        this.dat = r0;
        r0.resize(512);
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.isEmpty() == true) goto L59;
        ArrayList r1 = new ArrayList(r11);
        this.keywords = r1;
        r1.sort(byteArrayComparator);
        this.outputLinks = new HashMap(this.keywords.size());
        this.dat.base[0] = 1;
        this.dat.nextCheckPos = 0;
        LinkedListTrieNode r12 = new LinkedListTrieNode(0, 0, 0, this.keywords.size(), new byte[0]);
        r12.index = 0;
        r12.base = 1;
        this.llt = new LinkedListTrie(r12);
        List<LinkedListTrieNode> r13 = fetch(r12);
        Iterator<LinkedListTrieNode> r3 = r13.iterator();
    L9:
        if (r3.hasNext() == false) goto L13;
        LinkedListTrieNode r4 = (LinkedListTrieNode) ZeusTransformUtils.preCheckCast(r3.next(), LinkedListTrieNode.class, "com.obric.aiagent.plugin");
        if (r4.code <= 0) goto L9;
        r4.subKey = new byte[]{r4.getByteCode()};
        goto L9
    L13:
        insert(r13);
        this.suffixLinks = new int[this.dat.size];
        LinkedList r14 = new LinkedList();
        Iterator<LinkedListTrieNode> r2 = this.llt.root.children.iterator();
    L15:
        if (r2.hasNext() == false) goto L21;
        LinkedListTrieNode r5 = (LinkedListTrieNode) ZeusTransformUtils.preCheckCast(r2.next(), LinkedListTrieNode.class, "com.obric.aiagent.plugin");
        if (r5.code == 0) goto L15;
        this.suffixLinks[r5.base] = 1;
        r14.add(r5);
    L21:
        if (r14.isEmpty() == true) goto L60;
        LinkedListTrieNode r6 = (LinkedListTrieNode) ZeusTransformUtils.preCheckCast(r14.poll(), LinkedListTrieNode.class, "com.obric.aiagent.plugin");
        Iterator<LinkedListTrieNode> r7 = r6.children.iterator();
    L24:
        if (r7.hasNext() == false) goto L21;
        LinkedListTrieNode r8 = (LinkedListTrieNode) ZeusTransformUtils.preCheckCast(r7.next(), LinkedListTrieNode.class, "com.obric.aiagent.plugin");
        r14.add(r8);
        if (r8.base == (-1)) goto L24;
        int r9 = getSuffixLink(r6.base);
    L29:
        int r15 = nextState(r9, r8.getByteCode());
        r9 = getSuffixLink(r9);
        if (r15 == (-1)) goto L29;
        setSuffixLink(r8.base, r15);
        List r16 = (List) ZeusTransformUtils.preCheckCast(this.outputLinks.get(Integer.valueOf(r15)), List.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L24;
        if (r16.isEmpty() == true) goto L24;
        ((List) ZeusTransformUtils.preCheckCast(this.outputLinks.computeIfAbsent(Integer.valueOf(r8.base), $$Lambda$Machine$Ttr8PsMtf7YGo4Lw9kh4O76MB8.INSTANCE), List.class, "com.obric.aiagent.plugin")).addAll(r16);
        goto L24
    L60:
        return;
    }

    static /* synthetic */ List lambda$build$1(Integer r0) {
        return new ArrayList();
    }

    private List<LinkedListTrieNode> fetch(LinkedListTrieNode r12) {
        r12.children = new ArrayList();
        int r0 = r12.left;
        int r2 = 0;
    L4:
        if (r0 >= r12.right) goto L28;
        byte[] r3 = (byte[]) ZeusTransformUtils.preCheckCast(this.keywords.get(r0), byte[].class, "com.obric.aiagent.plugin");
        if (r3.length < r12.depth) goto L24;
        if (r3.length <= r12.depth) goto L11;
        int r9 = (r3[r12.depth] & 255) + 1;
    L12:
        if (r2 > r9) goto L26;
        if (r9 == r2) goto L15;
    L16:
        if (r9 == 0) goto L18;
        byte[] r4 = Arrays.copyOf(r12.subKey, r12.subKey.length + 1);
        r4[r4.length - 1] = (byte) (r9 - 1);
    L19:
        int r5 = r9;
        int r6 = r0;
        LinkedListTrieNode r10 = new LinkedListTrieNode(r5, r12.depth + 1, r6, r0 + 1, r4);
        if (r12.children.isEmpty() == true) goto L22;
        ((LinkedListTrieNode) ZeusTransformUtils.preCheckCast(r12.children.get(r12.children.size() - 1), LinkedListTrieNode.class, "com.obric.aiagent.plugin")).right = r0;
    L22:
        r12.children.add(r10);
    L23:
        r2 = r9;
        goto L24
    L18:
        r4 = Arrays.copyOf(r12.subKey, r12.subKey.length);
        goto L19
    L15:
        if (r12.children.isEmpty() == false) goto L23;
    L26:
        throw new RuntimeException("fetch error");
    L11:
        r9 = 0;
    L24:
        r0 = r0 + 1;
        goto L4
    L28:
        if (r12.children.isEmpty() == true) goto L31;
        ((LinkedListTrieNode) ZeusTransformUtils.preCheckCast(r12.children.get(r12.children.size() - 1), LinkedListTrieNode.class, "com.obric.aiagent.plugin")).right = r12.right;
    L31:
        return r12.children;
    }

    private int insert(List<LinkedListTrieNode> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L5;
    L52:
        return 0;
    L5:
        if (r13.isEmpty() == true) goto L52;
        int r2 = Math.max(((LinkedListTrieNode) ZeusTransformUtils.preCheckCast(r13.get(0), LinkedListTrieNode.class, "com.obric.aiagent.plugin")).code + 1, this.dat.nextCheckPos) - 1;
        if (this.dat.size > r2) goto L10;
        this.dat.resize(r2 + 1);
    L10:
        boolean r4 = false;
        int r5 = 0;
    L11:
        r2 = r2 + 1;
        if (this.dat.size > r2) goto L15;
        this.dat.resize(r2 + 1);
    L15:
        if (this.dat.check[r2] > 0) goto L16;
        if (r4 == true) goto L19;
        this.dat.nextCheckPos = r2;
        r4 = true;
    L19:
        int r6 = r2 - ((LinkedListTrieNode) ZeusTransformUtils.preCheckCast(r13.get(0), LinkedListTrieNode.class, "com.obric.aiagent.plugin")).code;
        if (this.dat.size > (((LinkedListTrieNode) ZeusTransformUtils.preCheckCast(r13.get(r13.size() - 1), LinkedListTrieNode.class, "com.obric.aiagent.plugin")).code + r6)) goto L23;
        this.dat.resize((((LinkedListTrieNode) ZeusTransformUtils.preCheckCast(r13.get(r13.size() - 1), LinkedListTrieNode.class, "com.obric.aiagent.plugin")).code + r6) + 512);
    L23:
        if (this.dat.used[r6] == true) goto L11;
        int r7 = 1;
    L27:
        if (r7 >= r13.size()) goto L32;
        if (this.dat.check[((LinkedListTrieNode) ZeusTransformUtils.preCheckCast(r13.get(r7), LinkedListTrieNode.class, "com.obric.aiagent.plugin")).code + r6] != 0) goto L30;
        r7 = r7 + 1;
        goto L27
    L30:
        boolean r8 = true;
    L33:
        if (r8 == true) goto L11;
        if ((r5 / ((r2 - this.dat.nextCheckPos) + 1)) < 0.95d) goto L37;
        this.dat.nextCheckPos = r2;
    L37:
        this.dat.used[r6] = true;
        Iterator r0 = r13.iterator();
    L39:
        if (r0.hasNext() == false) goto L41;
        this.dat.check[((LinkedListTrieNode) ZeusTransformUtils.preCheckCast(r0.next(), LinkedListTrieNode.class, "com.obric.aiagent.plugin")).code + r6] = r6;
        goto L39
    L41:
        Iterator r14 = r13.iterator();
    L43:
        if (r14.hasNext() == false) goto L51;
        LinkedListTrieNode r1 = (LinkedListTrieNode) ZeusTransformUtils.preCheckCast(r14.next(), LinkedListTrieNode.class, "com.obric.aiagent.plugin");
        List<LinkedListTrieNode> r3 = fetch(r1);
        if (r3.isEmpty() == true) goto L46;
        int r9 = insert(r3);
        if (r9 < 1) goto L49;
        this.dat.base[r1.code + r6] = r9;
        r1.index = r1.code + r6;
        r1.base = r9;
        goto L43
    L49:
        return -1;
    L46:
        this.dat.base[r1.code + r6] = (-r1.left) - 1;
        ((List) ZeusTransformUtils.preCheckCast(this.outputLinks.computeIfAbsent(Integer.valueOf(r1.code + r6), $$Lambda$Machine$XlXHfDkQrK_l6_CAXbIUk1JYL2s.INSTANCE), List.class, "com.obric.aiagent.plugin")).add(r1.subKey);
        r1.index = r1.code + r6;
        r1.base = -1;
        goto L43
    L51:
        return r6;
    L32:
        r8 = false;
        goto L33
    L16:
        r5 = r5 + 1;
        goto L11
    }

    static /* synthetic */ List lambda$insert$2(Integer r0) {
        return new ArrayList();
    }

    private int getSuffixLink(int r2) {
        if (r2 < 0) goto L8;
        int[] r1 = this.suffixLinks;
        if (r2 < r1.length) goto L7;
        return 1;
    L7:
        return r1[r2];
    L8:
        return 1;
    }

    private void setSuffixLink(int r2, int r3) {
        if (r2 < 0) goto L8;
        int[] r1 = this.suffixLinks;
        if (r2 >= r1.length) goto L9;
        r1[r2] = r3;
        return;
    L9:
        return;
    }

    private int nextState(int r4, byte r5) {
        if (r4 != (-1)) goto L5;
        return 1;
    L5:
        int r6 = ((r5 & 255) + r4) + 1;
        if (r6 < this.dat.size) goto L11;
        if (r4 == 1) goto L9;
        return -1;
    L9:
        return 1;
    L11:
        if (this.dat.check[r6] == r4) goto L13;
        if (r4 == 1) goto L16;
        return -1;
    L16:
        return 1;
    L13:
        return this.dat.base[r6];
    }
}
