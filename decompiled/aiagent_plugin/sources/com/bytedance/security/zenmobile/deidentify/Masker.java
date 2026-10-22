package com.bytedance.security.zenmobile.deidentify;

import com.bytedance.security.zenmobile.helpers.CharMatch;
import com.bytedance.security.zenmobile.helpers.Utf8;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.bytedance.security.zenmobile.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class Masker extends Deidentifier {
    public static final String TAG = "ZenMobile-Masker";
    static Map<Byte, List<CharMatch>> bankSkipSet;
    static Map<Byte, List<CharMatch>> dateSkipSet;
    static Map<Byte, List<CharMatch>> emailSkipSet;
    static Map<Byte, List<CharMatch>> macSkipSet;
    static Map<Byte, List<CharMatch>> phoneSkipSet;
    private String mask;
    private byte maskByte;

    static {
        phoneSkipSet = CharMatch.forwardSetFromString("()-+ .");
        emailSkipSet = CharMatch.forwardSetFromString("@");
        bankSkipSet = CharMatch.forwardSetFromString(" -");
        dateSkipSet = CharMatch.forwardSetFromString("-/ :,");
        macSkipSet = CharMatch.forwardSetFromString("-:");
    }

    public Masker(String r3) {
        this.mask = r3;
        byte[] r4 = r3.getBytes(StandardCharsets.UTF_8);
        if (r4.length != 1) goto L7;
        this.maskByte = r4[0];
        return;
    L7:
        throw new IllegalArgumentException("mask must be 1 byte long");
    }

    @Override // com.bytedance.security.zenmobile.deidentify.Deidentifier
    public String deidentify(String r3, String r4) {
        byte[] r5 = r3.getBytes(StandardCharsets.UTF_8);
        maskBytes(r5, 0, r5.length, r4);
        return new String(r5, StandardCharsets.UTF_8);
    }

    @Override // com.bytedance.security.zenmobile.deidentify.Deidentifier
    public void deidentify(byte[] r4, int r5, int r6, String r7) {
        LogUtils.d(TAG, "full.length: " + r4.length);
        LogUtils.d(TAG, "from: " + r5);
        LogUtils.d(TAG, "to: " + r6);
        maskBytes(r4, r5, r6, r7);
    }

    void maskBytes(byte[] r17, int r18, int r19, String r20) {
        r20.hashCode();
        byte r2 = -1;
        switch(r20.hashCode()) {
            case -1825227990: goto L90;
            case -1181815352: goto L86;
            case -1147692044: goto L82;
            case -1068855134: goto L78;
            case -952950034: goto L74;
            case -884593524: goto L70;
            case -482270773: goto L66;
            case -193681183: goto L62;
            case -133689903: goto L58;
            case 3236040: goto L54;
            case 3236474: goto L50;
            case 3347635: goto L46;
            case 3361099: goto L42;
            case 96619420: goto L38;
            case 100017508: goto L34;
            case 722989291: goto L30;
            case 783201284: goto L26;
            case 1216777234: goto L22;
            case 1216985755: goto L18;
            case 1243174504: goto L14;
            case 1661266179: goto L10;
            case 1984987798: goto L6;
            default: goto L93;
        };
    L93:
        switch(r2) {
            case 0: goto L109;
            case 1: goto L108;
            case 2: goto L107;
            case 3: goto L106;
            case 4: goto L105;
            case 5: goto L104;
            case 6: goto L105;
            case 7: goto L103;
            case 8: goto L102;
            case 9: goto L105;
            case 10: goto L100;
            case 11: goto L105;
            case 12: goto L105;
            case 13: goto L99;
            case 14: goto L105;
            case 15: goto L105;
            case 16: goto L98;
            case 17: goto L105;
            case 18: goto L97;
            case 19: goto L105;
            case 20: goto L96;
            case 21: goto L95;
            default: goto L101;
        };
    L95:
        maskBytesGeneral(r17, r18, r19, 6, 6, true);
        return;
    L96:
        maskBytesGeneral(r17, r18, r19, 1, 1, false);
        return;
    L97:
        maskBytesGeneral(r17, r18, r19, 0, 0, true);
        return;
    L98:
        maskBytesGeneralWithSkipSet(r17, r18, r19, 0, 4, false, phoneSkipSet);
        return;
    L99:
        maskBytesGeneralWithSkipSet(r17, r18, r19, 1, 0, false, emailSkipSet);
        return;
    L100:
        maskBytesGeneral(r17, r18, r19, 7, 2, false);
        goto L101
    L102:
        maskBytesGeneralWithSkipSet(r17, r18, r19, 4, 2, false, phoneSkipSet);
        return;
    L103:
        maskBytesGeneralWithSkipSet(r17, r18, r19, 0, 0, false, macSkipSet);
        return;
    L104:
        maskRealName(r17, r18, r19);
        return;
    L105:
        maskBytesGeneral(r17, r18, r19, 2, 2, false);
        return;
    L106:
        maskBytesGeneralWithSkipSet(r17, r18, r19, 3, 2, false, phoneSkipSet);
        return;
    L107:
        maskBytesGeneralWithSkipSet(r17, r18, r19, 2, 0, false, bankSkipSet);
        return;
    L108:
        maskBytesGeneralWithSkipSet(r17, r18, r19, 0, 0, false, dateSkipSet);
        return;
    L109:
        maskBytesGeneralWithSkipSet(r17, r18, r19, 0, 4, false, bankSkipSet);
        return;
    L101:
        maskBytesGeneral(r17, r18, r19, 0, 0, false);
        return;
    L6:
        if (r20.equals(SensitiveType.SESSION) == false) goto L93;
        r2 = 21;
        goto L93
    L10:
        if (r20.equals(SensitiveType.CHINA_ID) == false) goto L93;
        r2 = 20;
        goto L93
    L14:
        if (r20.equals(SensitiveType.HK_MO_EXIT_ENTRY_PERMIT) == false) goto L93;
        r2 = 19;
        goto L93
    L18:
        if (r20.equals(SensitiveType.PASSWORD) == false) goto L93;
        r2 = 18;
        goto L93
    L22:
        if (r20.equals(SensitiveType.PASSPORT) == false) goto L93;
        r2 = 17;
        goto L93
    L26:
        if (r20.equals(SensitiveType.TELEPHONE) == false) goto L93;
        r2 = 16;
        goto L93
    L30:
        if (r20.equals(SensitiveType.ANDROID_ID) == false) goto L93;
        r2 = 15;
        goto L93
    L34:
        if (r20.equals(SensitiveType.ICCID) == false) goto L93;
        r2 = 14;
        goto L93
    L38:
        if (r20.equals(SensitiveType.EMAIL) == false) goto L93;
        r2 = 13;
        goto L93
    L42:
        if (r20.equals(SensitiveType.MSIN) == false) goto L93;
        r2 = 12;
        goto L93
    L46:
        if (r20.equals(SensitiveType.MEID) == false) goto L93;
        r2 = 11;
        goto L93
    L50:
        if (r20.equals(SensitiveType.IMSI) == false) goto L93;
        r2 = 10;
        goto L93
    L54:
        if (r20.equals(SensitiveType.IMEI) == false) goto L93;
        r2 = 9;
        goto L93
    L58:
        if (r20.equals(SensitiveType.TRACKING_NUMBER) == false) goto L93;
        r2 = 8;
        goto L93
    L62:
        if (r20.equals(SensitiveType.MAC) == false) goto L93;
        r2 = 7;
        goto L93
    L66:
        if (r20.equals(SensitiveType.DEVICE_SERIAL_NUMBER) == false) goto L93;
        r2 = 6;
        goto L93
    L70:
        if (r20.equals(SensitiveType.REAL_NAME) == false) goto L93;
        r2 = 5;
        goto L93
    L74:
        if (r20.equals(SensitiveType.CHINA_SERVICE_MEMBER_ID) == false) goto L93;
        r2 = 4;
        goto L93
    L78:
        if (r20.equals(SensitiveType.MOBILE) == false) goto L93;
        r2 = 3;
        goto L93
    L82:
        if (r20.equals(SensitiveType.ADDRESS) == false) goto L93;
        r2 = 2;
        goto L93
    L86:
        if (r20.equals(SensitiveType.DATE_OF_BIRTH) == false) goto L93;
        r2 = 1;
        goto L93
    L90:
        if (r20.equals(SensitiveType.BANK_ACCOUNT) == false) goto L93;
        r2 = 0;
        goto L93
    }

    void maskRealName(byte[] r5, int r6, int r7) {
        boolean r1 = true;
    L3:
        if (r6 >= r7) goto L14;
        if (r5[r6] != 32) goto L7;
        r1 = true;
    L13:
        r6 = r6 + 1;
        goto L3
    L7:
        if (r1 == false) goto L12;
        int r2 = Utf8.getByteClass(r5[r6]);
        if (r2 <= 0) goto L11;
        r6 = r6 + (r2 - 1);
    L11:
        r1 = false;
        goto L13
    L12:
        r5[r6] = this.maskByte;
        goto L13
    }

    void maskBytesGeneral(byte[] r3, int r4, int r5, int r6, int r7, boolean r8) {
        int r9 = getLeftUft8(r3, r4, r5, r6);
        int r10 = getRightUft8(r3, r4, r5, r7);
        if ((r9 + r10) < (r5 - r4)) goto L7;
        if (r8 == false) goto L9;
        Arrays.fill(r3, r4, r5, this.maskByte);
        return;
    L9:
        return;
    L7:
        Arrays.fill(r3, r4 + r9, r5 - r10, this.maskByte);
    }

    void maskBytesGeneralWithSkipSet(byte[] r9, int r10, int r11, int r12, int r13, boolean r14, Map<Byte, List<CharMatch>> r15) {
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.aiagent.plugin");
        int r17 = getLeftUft8(r9, r10, r11, r12);
        int r18 = getRightUft8(r9, r10, r11, r13);
        if ((r17 + r18) < (r11 - r10)) goto L7;
        if (r14 == false) goto L52;
        Arrays.fill(r9, r10, r11, this.maskByte);
        return;
    L52:
        return;
    L7:
        int r19 = r10 + r17;
    L8:
        int r110 = r11 - r18;
        if (r19 >= r110) goto L37;
        List r111 = (List) ZeusTransformUtils.preCheckCast(r16.get(Byte.valueOf(r9[r19])), List.class, "com.obric.aiagent.plugin");
        int r0 = 0;
        if (r111 != null) goto L13;
    L33:
        if (r0 != 0) goto L35;
        r9[r19] = this.maskByte;
    L36:
        r19 = r19 + 1;
        goto L8
    L35:
        r19 = r19 + (r0 - 1);
        goto L36
    L13:
        if (r111.isEmpty() == true) goto L33;
        Iterator r112 = r111.iterator();
        int r3 = 0;
    L16:
        if (r112.hasNext() == false) goto L32;
        CharMatch r4 = (CharMatch) ZeusTransformUtils.preCheckCast(r112.next(), CharMatch.class, "com.obric.aiagent.plugin");
        if ((r4.getLength() + r19) > r110) goto L16;
        int r5 = 0;
    L22:
        if (r5 >= r4.getLength()) goto L27;
        if (r9[r19 + r5] != r4.getFull()[r5]) goto L25;
        r5 = r5 + 1;
        goto L22
    L25:
        boolean r6 = false;
    L28:
        if (r6 == false) goto L16;
        if (r4.getLength() <= r3) goto L16;
        r3 = r4.getLength();
        goto L16
    L27:
        r6 = true;
        goto L28
    L32:
        r0 = r3;
        goto L33
    }

    int getLeftUft8(byte[] r3, int r4, int r5, int r6) {
        int r2 = 0;
        int r0 = r4;
        int r7 = 0;
    L3:
        if (r2 >= r6) goto L10;
        if (r0 >= r5) goto L5;
        int r1 = Utf8.getByteClass(r3[r0]);
        if (r1 <= 0) goto L8;
        r7 = r7 + r1;
        r0 = r0 + r1;
        r2 = r2 + 1;
        goto L3
    L8:
        return r6;
    L5:
        return r6;
    L10:
        return r7;
    }

    int getRightUft8(byte[] r3, int r4, int r5, int r6) {
        int r2 = r5 - 1;
        int r0 = 0;
    L3:
        if (r2 < r4) goto L12;
        if (r0 >= r6) goto L12;
        int r1 = Utf8.getByteClass(r3[r2]);
        if (r1 <= 0) goto L8;
        r0 = r0 + 1;
    L10:
        r2 = r2 - 1;
        goto L3
    L8:
        if (r1 >= 0) goto L10;
        return r6;
    L12:
        return (r5 - r2) - 1;
    }
}
