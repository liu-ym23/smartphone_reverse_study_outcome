package com.bytedance.security.zenmobile.detect.extension;

import com.bytedance.security.zenmobile.helpers.CharMatch;
import com.bytedance.security.zenmobile.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CharacterSetExtender extends Extender {
    public static final String TAG = "ZenMobile-CharacterSetExtender";
    public static Map<String, String> globalCharacterSets;
    Map<Byte, List<CharMatch>> backwardSet;
    List<CharMatch> charMatches;
    Map<Byte, List<CharMatch>> forwardSet;

    static {
        HashMap r0 = new HashMap();
        globalCharacterSets = r0;
        r0.put("$alphabets", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
        globalCharacterSets.put("$numbers", "0123456789");
        globalCharacterSets.put("$kvconnection", "sS\\'\"` :=是为：u[“”");
    }

    public CharacterSetExtender(int r9, List<String> r10, int r11, int r12, boolean r13, Map<String, Object> r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.aiagent.plugin");
        super(r9, r15, r11, r12, r13);
        this.mode = "character_set";
        ArrayList r17 = new ArrayList();
        HashMap r18 = new HashMap();
        HashMap r19 = new HashMap();
        Iterator r110 = r15.iterator();
    L4:
        if (r110.hasNext() == false) goto L11;
        String r111 = (String) ZeusTransformUtils.preCheckCast(r110.next(), String.class, "com.obric.aiagent.plugin");
        if (r111.startsWith("$") == false) goto L10;
        r111 = (String) ZeusTransformUtils.preCheckCast(globalCharacterSets.get(r111), String.class, "com.obric.aiagent.plugin");
        if (r111 == null) goto L4;
    L10:
        r17.addAll(CharMatch.fromString(r111));
        goto L4
    L11:
        Iterator r112 = r17.iterator();
    L13:
        if (r112.hasNext() == false) goto L15;
        CharMatch r113 = (CharMatch) ZeusTransformUtils.preCheckCast(r112.next(), CharMatch.class, "com.obric.aiagent.plugin");
        ((List) ZeusTransformUtils.preCheckCast(r18.computeIfAbsent(Byte.valueOf(r113.getStart()), $$Lambda$CharacterSetExtender$_q3JF3GQ9GodBIpWH6y9KgaHB3s.INSTANCE), List.class, "com.obric.aiagent.plugin")).add(r113);
        ((List) ZeusTransformUtils.preCheckCast(r19.computeIfAbsent(Byte.valueOf(r113.getEnd()), $$Lambda$CharacterSetExtender$2NLl8kB6_jLcRPwYdY0xJuh1l0.INSTANCE), List.class, "com.obric.aiagent.plugin")).add(r113);
        goto L13
    L15:
        this.charMatches = r17;
        this.forwardSet = r18;
        this.backwardSet = r19;
    }

    static /* synthetic */ List lambda$new$0(Byte r0) {
        return new ArrayList();
    }

    static /* synthetic */ List lambda$new$1(Byte r0) {
        return new ArrayList();
    }

    @Override // com.bytedance.security.zenmobile.detect.extension.Extender
    public ExtensionResult extend(byte[] r4, int r5) {
        if (r4 != null) goto L5;
    L19:
        LogUtils.e(TAG, "invalid params(bytes == null || bytes.length == 0)");
        return new ExtensionResult(false, r5);
    L5:
        if (r4.length == 0) goto L19;
        if (r5 >= 0) goto L9;
    L17:
        LogUtils.e(TAG, "invalid offset: " + r5);
        return new ExtensionResult(false, r5);
    L9:
        if (r5 > r4.length) goto L17;
        LogUtils.d(TAG, "direction: " + this.direction);
        if (this.direction != (-1)) goto L16;
        return extendBackward(r4, r5);
    L16:
        return extendForward(r4, r5);
    }

    public ExtensionResult extendForward(byte[] r13, int r14) {
        LogUtils.d(TAG, "bytes.length: " + r13.length);
        LogUtils.d(TAG, "offset + this.maxLength: " + (this.maxLength + r14));
        int r0 = Math.min(r13.length, this.maxLength + r14);
        LogUtils.d(TAG, "boundary: " + r0);
        int r2 = r14;
        int r3 = r2;
    L3:
        boolean r4 = true;
        if (r2 >= r0) goto L32;
        List r5 = (List) ZeusTransformUtils.preCheckCast(this.forwardSet.get(Byte.valueOf(r13[r2])), List.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L8;
    L27:
        int r6 = 0;
    L28:
        r3 = r2 + r6;
        if (r6 == 0) goto L32;
        r2 = r3;
        goto L3
    L8:
        if (r5.isEmpty() == true) goto L27;
        Iterator r7 = r5.iterator();
        r6 = 0;
    L11:
        if (r7.hasNext() == false) goto L28;
        CharMatch r8 = (CharMatch) ZeusTransformUtils.preCheckCast(r7.next(), CharMatch.class, "com.obric.aiagent.plugin");
        if ((r8.getLength() + r2) > r0) goto L11;
        int r9 = 0;
    L17:
        if (r9 >= r8.getLength()) goto L22;
        if (r13[r2 + r9] != r8.getFull()[r9]) goto L20;
        r9 = r9 + 1;
        goto L17
    L20:
        boolean r10 = false;
    L23:
        if (r10 == false) goto L11;
        if (r8.getLength() <= r6) goto L11;
        r6 = r8.getLength();
        goto L11
    L22:
        r10 = true;
    L32:
        int r15 = r3 - r14;
        LogUtils.d(TAG, "length: " + r15);
        LogUtils.d(TAG, "this.minLength: " + this.minLength);
        LogUtils.d(TAG, "this.maxLength: " + this.maxLength);
        if (r15 >= this.minLength) goto L35;
    L37:
        r4 = false;
    L39:
        return new ExtensionResult(r4, r3);
    L35:
        if (r15 > this.maxLength) goto L37;
        goto L37
    }

    public ExtensionResult extendBackward(byte[] r14, int r15) {
        boolean r1 = false;
        int r0 = Math.max(0, r15 - this.maxLength);
        int r2 = r15;
        int r3 = r2;
    L4:
        if (r2 <= r0) goto L32;
        int r5 = r2 - 1;
        List r4 = (List) ZeusTransformUtils.preCheckCast(this.backwardSet.get(Byte.valueOf(r14[r5])), List.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L8;
    L27:
        int r6 = 0;
    L28:
        r3 = r2 - r6;
        if (r6 == 0) goto L32;
        r2 = r3;
        goto L4
    L8:
        if (r4.isEmpty() == true) goto L27;
        Iterator r7 = r4.iterator();
        r6 = 0;
    L11:
        if (r7.hasNext() == false) goto L28;
        CharMatch r8 = (CharMatch) ZeusTransformUtils.preCheckCast(r7.next(), CharMatch.class, "com.obric.aiagent.plugin");
        if ((r2 - r8.getLength()) < r0) goto L11;
        int r9 = 0;
    L17:
        if (r9 >= r8.getLength()) goto L22;
        if (r14[r5 - r9] != r8.getFull()[(r8.getLength() - 1) - r9]) goto L20;
        r9 = r9 + 1;
        goto L17
    L20:
        boolean r10 = false;
    L23:
        if (r10 == false) goto L11;
        if (r8.getLength() <= r6) goto L11;
        r6 = r8.getLength();
        goto L11
    L22:
        r10 = true;
    L32:
        int r16 = r15 - r3;
        if (r16 < this.minLength) goto L38;
        if (r16 > this.maxLength) goto L38;
        r1 = true;
    L38:
        return new ExtensionResult(r1, r3);
    }
}
