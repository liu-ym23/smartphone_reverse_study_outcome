package com.byted.cast.common.api;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public class CodecType {

    public static final enum ACODEC_ID extends Enum<ACODEC_ID> {
        private static final /* synthetic */ ACODEC_ID[] $VALUES = null;
        public static final ACODEC_ID AAC = null;
        public static final ACODEC_ID AUTO = null;
        public static final ACODEC_ID G729FEC1 = null;
        public static final ACODEC_ID G729FEC2 = null;
        public static final ACODEC_ID ILBC = null;
        public static final ACODEC_ID ISACFIX = null;
        public static final ACODEC_ID OPUS = null;
        public static final ACODEC_ID OPUSFEC1 = null;
        public static final ACODEC_ID OPUSFEC2 = null;
        public static final ACODEC_ID OPUS_8K = null;
        public static final ACODEC_ID PCM = null;

        static {
            ACODEC_ID r100 = new ACODEC_ID("AUTO", 0);
            AUTO = r100;
            ACODEC_ID r101 = new ACODEC_ID("ISACFIX", 1);
            ISACFIX = r101;
            ACODEC_ID r102 = new ACODEC_ID("ILBC", 2);
            ILBC = r102;
            ACODEC_ID r103 = new ACODEC_ID("OPUS", 3);
            OPUS = r103;
            ACODEC_ID r104 = new ACODEC_ID("G729FEC2", 4);
            G729FEC2 = r104;
            ACODEC_ID r105 = new ACODEC_ID("G729FEC1", 5);
            G729FEC1 = r105;
            ACODEC_ID r110 = new ACODEC_ID("OPUSFEC1", 6);
            OPUSFEC1 = r110;
            ACODEC_ID r111 = new ACODEC_ID("OPUSFEC2", 7);
            OPUSFEC2 = r111;
            ACODEC_ID r112 = new ACODEC_ID("OPUS_8K", 8);
            OPUS_8K = r112;
            ACODEC_ID r113 = new ACODEC_ID("AAC", 9);
            AAC = r113;
            ACODEC_ID r114 = new ACODEC_ID("PCM", 10);
            PCM = r114;
            $VALUES = new ACODEC_ID[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        }

        public static ACODEC_ID[] values() {
            return (ACODEC_ID[]) $VALUES.clone();
        }

        public static ACODEC_ID valueOf(String r100) {
            return (ACODEC_ID) a.a(ACODEC_ID.class, r100);
        }

        private ACODEC_ID(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum VCODEC_ID extends Enum<VCODEC_ID> {
        private static final /* synthetic */ VCODEC_ID[] $VALUES = null;
        public static final VCODEC_ID AUTO = null;
        public static final VCODEC_ID H264 = null;
        public static final VCODEC_ID H265 = null;
        public static final VCODEC_ID LOSSLESS = null;

        static {
            VCODEC_ID r100 = new VCODEC_ID("AUTO", 0);
            AUTO = r100;
            VCODEC_ID r101 = new VCODEC_ID("H264", 1);
            H264 = r101;
            VCODEC_ID r102 = new VCODEC_ID("H265", 2);
            H265 = r102;
            VCODEC_ID r103 = new VCODEC_ID("LOSSLESS", 3);
            LOSSLESS = r103;
            $VALUES = new VCODEC_ID[]{r100, r101, r102, r103};
        }

        public static VCODEC_ID[] values() {
            return (VCODEC_ID[]) $VALUES.clone();
        }

        public static VCODEC_ID valueOf(String r100) {
            return (VCODEC_ID) a.a(VCODEC_ID.class, r100);
        }

        private VCODEC_ID(String r100, int r101) {
            super(r100, r101);
        }
    }

    public CodecType() {
    }

    public static ACODEC_ID valueOfAudio(int r100) {
        if (r100 == 1) goto L22;
        if (r100 == 3) goto L20;
        switch(r100) {
            case 6: goto L18;
            case 7: goto L16;
            case 8: goto L14;
            case 9: goto L12;
            case 10: goto L10;
            default: goto L8;
        };
    L8:
        return ACODEC_ID.AUTO;
    L10:
        return ACODEC_ID.PCM;
    L12:
        return ACODEC_ID.AAC;
    L14:
        return ACODEC_ID.OPUS_8K;
    L16:
        return ACODEC_ID.OPUSFEC2;
    L18:
        return ACODEC_ID.OPUSFEC1;
    L20:
        return ACODEC_ID.OPUS;
    L22:
        return ACODEC_ID.ISACFIX;
    }

    public static VCODEC_ID valueOfVideo(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return VCODEC_ID.AUTO;
    L11:
        return VCODEC_ID.LOSSLESS;
    L13:
        return VCODEC_ID.H265;
    L15:
        return VCODEC_ID.H264;
    }
}
