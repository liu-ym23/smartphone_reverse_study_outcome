package com.bytedance.security.zenmobile.detect.anchor;

import com.bytedance.security.zenmobile.ahocorasick.Machine;
import com.bytedance.security.zenmobile.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class FinderStore {
    public static final String TAG = "ZenMobile-FinderStore";
    Machine ahoCorasickMachine;
    boolean compiled;
    Map<String, Finder> finders;
    Map<Integer, Machine> steppedAhoCorasickMachines;
    Map<String, List<MatchRule>> wordToRules;

    public FinderStore() {
        HashMap r0 = new HashMap();
        this.finders = r0;
        r0.put("word", new WordFinder());
        this.finders.put("scanner", new ScannerFinder());
        this.finders.put("exact_match", new ExactMatchFinder());
        this.wordToRules = new HashMap();
        this.steppedAhoCorasickMachines = new HashMap();
        this.compiled = false;
    }

    public boolean isCompiled() {
        return this.compiled;
    }

    public Finder getFinder(String r2) {
        Map<String, Finder> r1 = this.finders;
        if (r1 != null) goto L7;
        return null;
    L7:
        return (Finder) ZeusTransformUtils.preCheckCast(r1.get(r2), Finder.class, "com.obric.aiagent.plugin");
    }

    public void compile() {
        final ArrayList r0 = new ArrayList();
        final HashMap r1 = new HashMap();
        this.finders.forEach(new $$Lambda$FinderStore$v46CqwVT18OFCTpnzJpx288GBZA(this, r0, r1));
        this.ahoCorasickMachine = new Machine(r0);
        this.steppedAhoCorasickMachines = new HashMap();
        if (r1.isEmpty() == true) goto L5;
        r1.forEach(new $$Lambda$FinderStore$IH1tfHy4lDjrOxuTpCSASwDU9Go(this));
    L5:
        this.compiled = true;
    }

    public /* synthetic */ void lambda$compile$4$FinderStore(List r2, Map r3, String r4, Finder r5) {
        final List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        final Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        Map<String, List<MatchRule>> r8 = r5.getWordToRules();
        if (r8 != null) goto L5;
        return;
    L5:
        r8.forEach(new $$Lambda$FinderStore$4Y4gFe5Bhru9_v3Ktbo4LG0uJkg(this, r6, r7));
    }

    static /* synthetic */ List lambda$compile$0(String r0) {
        return new ArrayList();
    }

    public /* synthetic */ void lambda$compile$3$FinderStore(List r3, Map r4, String r5, List r6) {
        final List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        final Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        ((List) ZeusTransformUtils.preCheckCast(this.wordToRules.computeIfAbsent(r5, $$Lambda$FinderStore$6MoraVaRoseQ3wFIbRFqP68202s.INSTANCE), List.class, "com.obric.aiagent.plugin")).addAll(r9);
        r9.forEach(new $$Lambda$FinderStore$7hIMvcE9y4gvVojY_KMMkNh8_mY(r7, r8));
    }

    static /* synthetic */ void lambda$compile$2(List r3, Map r4, MatchRule r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if (r5.getStep() != 1) goto L5;
        LogUtils.d(TAG, "rule.getWord(): " + r5.getWord());
        r6.add(r5.getWord().getBytes(StandardCharsets.UTF_8));
        return;
    L5:
        ((List) ZeusTransformUtils.preCheckCast(r7.computeIfAbsent(Integer.valueOf(r5.getStep()), $$Lambda$FinderStore$w_v3IfTsvbTFnfShRq4Hok6_WWs.INSTANCE), List.class, "com.obric.aiagent.plugin")).add(r5.getWord().getBytes(StandardCharsets.UTF_8));
    }

    static /* synthetic */ List lambda$compile$1(Integer r0) {
        return new ArrayList();
    }

    public /* synthetic */ void lambda$compile$5$FinderStore(Integer r3, List r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isEmpty() == true) goto L9;
        Machine r0 = new Machine(r5);
        this.steppedAhoCorasickMachines.put(r3, r0);
        return;
    }

    public List<Match> search(String r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.isEmpty() == false) goto L7;
        return null;
    L7:
        return search(r2.getBytes(StandardCharsets.UTF_8));
    }

    public List<Match> search(byte[] r15) {
        if (r15 != null) goto L5;
    L38:
        LogUtils.e(TAG, "bytes is null / empty");
        return null;
    L5:
        if (r15.length == 0) goto L38;
        if (this.compiled == true) goto L11;
        LogUtils.e(TAG, "compiled == false");
        return null;
    L11:
        ArrayList r1 = new ArrayList();
        new ArrayList();
        List<com.bytedance.security.zenmobile.ahocorasick.Match> r3 = this.ahoCorasickMachine.multiPatternSearch(r15);
        LogUtils.d(TAG, "acMatches.size(): " + r3.size());
        Iterator<com.bytedance.security.zenmobile.ahocorasick.Match> r4 = r3.iterator();
    L13:
        if (r4.hasNext() == false) goto L21;
        com.bytedance.security.zenmobile.ahocorasick.Match r5 = (com.bytedance.security.zenmobile.ahocorasick.Match) ZeusTransformUtils.preCheckCast(r4.next(), com.bytedance.security.zenmobile.ahocorasick.Match.class, "com.obric.aiagent.plugin");
        Iterator<byte[]> r6 = r5.getTerms().iterator();
    L16:
        if (r6.hasNext() == false) goto L13;
        byte[] r7 = (byte[]) ZeusTransformUtils.preCheckCast(r6.next(), byte[].class, "com.obric.aiagent.plugin");
        String r8 = new String(r7, StandardCharsets.UTF_8);
        LogUtils.d(TAG, "termString: " + r8);
        if (this.wordToRules.containsKey(r8) == false) goto L16;
        LogUtils.d(TAG, "this.wordToRules.containsKey(termString)");
        LogUtils.d(TAG, "term.length：" + r7.length);
        LogUtils.d(TAG, "acMatch.getEnd() - term.length：" + (r5.getEnd() - r7.length));
        LogUtils.d(TAG, "acMatch.getEnd()：" + r5.getEnd());
        r1.add(new Match(r5.getEnd() - r7.length, r5.getEnd(), r8, (List) ZeusTransformUtils.preCheckCast(this.wordToRules.get(r8), List.class, "com.obric.aiagent.plugin")));
        LogUtils.d(TAG, "matches.size(): " + r1.size());
        goto L16
    L21:
        if (this.steppedAhoCorasickMachines.isEmpty() == true) goto L37;
        Iterator<Integer> r2 = this.steppedAhoCorasickMachines.keySet().iterator();
    L24:
        if (r2.hasNext() == false) goto L37;
        int r9 = ((Integer) ZeusTransformUtils.preCheckCast(r2.next(), Integer.class, "com.obric.aiagent.plugin")).intValue();
        Machine r10 = (Machine) ZeusTransformUtils.preCheckCast(this.steppedAhoCorasickMachines.get(Integer.valueOf(r9)), Machine.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L24;
        Iterator<com.bytedance.security.zenmobile.ahocorasick.Match> r11 = r10.multiPatternSearchWithStep(r15, r9).iterator();
    L30:
        if (r11.hasNext() == false) goto L24;
        com.bytedance.security.zenmobile.ahocorasick.Match r12 = (com.bytedance.security.zenmobile.ahocorasick.Match) ZeusTransformUtils.preCheckCast(r11.next(), com.bytedance.security.zenmobile.ahocorasick.Match.class, "com.obric.aiagent.plugin");
        Iterator<byte[]> r13 = r12.getTerms().iterator();
    L33:
        if (r13.hasNext() == false) goto L30;
        byte[] r14 = (byte[]) ZeusTransformUtils.preCheckCast(r13.next(), byte[].class, "com.obric.aiagent.plugin");
        int r16 = ((r14.length * r9) - r9) + 1;
        String r17 = new String(r14, StandardCharsets.UTF_8);
        if (this.wordToRules.containsKey(r17) == false) goto L33;
        r1.add(new Match(r12.getEnd() - r16, r12.getEnd(), r17, (List) ZeusTransformUtils.preCheckCast(this.wordToRules.get(r17), List.class, "com.obric.aiagent.plugin")));
    L37:
        return r1;
    }
}
