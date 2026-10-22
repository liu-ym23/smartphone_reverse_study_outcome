package com.bytedance.security.zenmobile.detect.helpers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CharMatch {
    byte end;
    byte[] full;
    int length;
    byte start;

    public static int getUtf8EncodingSize(int r1) {
        if (r1 < 65536) goto L9;
        if (r1 > 1114111) goto L9;
        return 4;
    L9:
        if (r1 < 2048) goto L15;
        if (r1 > 65535) goto L15;
        return 3;
    L15:
        if (r1 >= 128) goto L17;
    L20:
        if (r1 >= 0) goto L22;
        return 0;
    L22:
        if (r1 > 127) goto L27;
        return 1;
    L27:
        return 0;
    L17:
        if (r1 > 2047) goto L20;
        return 2;
    }

    public CharMatch(byte r4) {
        this.start = r4;
        this.end = r4;
        this.full = new byte[]{r4};
        this.length = 1;
    }

    public CharMatch(byte[] r2) {
        if (r2.length == 0) goto L7;
        this.start = r2[0];
        this.end = r2[r2.length - 1];
        this.full = r2;
        this.length = r2.length;
        return;
    L7:
        throw new IllegalArgumentException("must be a non-empty byte array");
    }

    public static List<CharMatch> fromString(String r9) {
        if (r9 == null) goto L16;
        ArrayList r0 = new ArrayList(r9.length());
        byte[] r1 = r9.getBytes(StandardCharsets.UTF_8);
        int r3 = 0;
        int r4 = 0;
    L5:
        if (r3 >= r9.length()) goto L14;
        int r5 = Character.codePointAt(r9, r3);
        int r6 = Character.charCount(r5);
        int r7 = getUtf8EncodingSize(r5);
        if (r7 <= 0) goto L14;
        if (r7 != 1) goto L12;
        r0.add(new CharMatch(r1[r4]));
    L13:
        r3 = r3 + r6;
        r4 = r4 + r7;
        goto L5
    L12:
        byte[] r8 = new byte[r7];
        System.arraycopy(r1, r4, r8, 0, r7);
        r0.add(new CharMatch(r8));
    L14:
        return r0;
    L16:
        throw new IllegalArgumentException("string must not be null");
    }

    public static Map<Byte, List<CharMatch>> forwardSetFromString(String r5) {
        List<CharMatch> r6 = fromString(r5);
        HashMap r0 = new HashMap();
        Iterator<CharMatch> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        CharMatch r1 = (CharMatch) ZeusTransformUtils.preCheckCast(r7.next(), CharMatch.class, "com.obric.aiagent.plugin");
        ((List) ZeusTransformUtils.preCheckCast(r0.computeIfAbsent(Byte.valueOf(r1.getStart()), $$Lambda$CharMatch$9LvsYienulWkafx01hHgDNG2M6E.INSTANCE), List.class, "com.obric.aiagent.plugin")).add(r1);
        goto L4
    L6:
        return r0;
    }

    static /* synthetic */ List lambda$forwardSetFromString$0(Byte r0) {
        return new ArrayList();
    }

    public static Map<Byte, List<CharMatch>> backwardSetFromString(String r5) {
        List<CharMatch> r6 = fromString(r5);
        HashMap r0 = new HashMap();
        Iterator<CharMatch> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        CharMatch r1 = (CharMatch) ZeusTransformUtils.preCheckCast(r7.next(), CharMatch.class, "com.obric.aiagent.plugin");
        ((List) ZeusTransformUtils.preCheckCast(r0.computeIfAbsent(Byte.valueOf(r1.getEnd()), $$Lambda$CharMatch$4l_nJrpVEfgGaLdpW_20M6FNiU.INSTANCE), List.class, "com.obric.aiagent.plugin")).add(r1);
        goto L4
    L6:
        return r0;
    }

    static /* synthetic */ List lambda$backwardSetFromString$1(Byte r0) {
        return new ArrayList();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        byte[] r6 = this.full;
        int r1 = r6.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        r0.append(String.format("%02X", new Object[]{Byte.valueOf(r6[r3])}));
        r3 = r3 + 1;
        goto L3
    L6:
        return r0.toString();
    }

    public byte getStart() {
        return this.start;
    }

    public void setStart(byte r1) {
        this.start = r1;
    }

    public byte getEnd() {
        return this.end;
    }

    public void setEnd(byte r1) {
        this.end = r1;
    }

    public byte[] getFull() {
        return this.full;
    }

    public void setFull(byte[] r1) {
        this.full = r1;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int r1) {
        this.length = r1;
    }
}
