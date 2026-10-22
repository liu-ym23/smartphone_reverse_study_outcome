package com.amap.api.maps.model;

/* JADX INFO: loaded from: classes28.dex */
public class AMapPara {
    public static final int DOTTEDLINE_TYPE_CIRCLE = 1;
    public static final int DOTTEDLINE_TYPE_DEFAULT = -1;
    public static final int DOTTEDLINE_TYPE_SQUARE = 0;

    public static final enum LineCapType extends Enum<LineCapType> {
        private static final /* synthetic */ LineCapType[] $VALUES = null;
        public static final LineCapType LineCapArrow = null;
        public static final LineCapType LineCapButt = null;
        public static final LineCapType LineCapRound = null;
        public static final LineCapType LineCapSquare = null;
        private int type;

        static {
            LineCapType r100 = new LineCapType("LineCapButt", 0, 0);
            LineCapButt = r100;
            LineCapType r101 = new LineCapType("LineCapSquare", 1, 1);
            LineCapSquare = r101;
            LineCapType r102 = new LineCapType("LineCapArrow", 2, 2);
            LineCapArrow = r102;
            LineCapType r103 = new LineCapType("LineCapRound", 3, 3);
            LineCapRound = r103;
            $VALUES = new LineCapType[]{r100, r101, r102, r103};
        }

        public static LineCapType[] values() {
            return (LineCapType[]) $VALUES.clone();
        }

        public int getTypeValue() {
            return this.type;
        }

        public static LineCapType valueOf(int r100) {
            return values()[Math.max(0, Math.min(r100, 4))];
        }

        public static LineCapType valueOf(String r100) {
            return (LineCapType) r27.a.a(LineCapType.class, r100);
        }

        private LineCapType(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public static final enum LineJoinType extends Enum<LineJoinType> {
        private static final /* synthetic */ LineJoinType[] $VALUES = null;
        public static final LineJoinType LineJoinBevel = null;
        public static final LineJoinType LineJoinMiter = null;
        public static final LineJoinType LineJoinRound = null;
        private int type;

        static {
            LineJoinType r100 = new LineJoinType("LineJoinBevel", 0, 0);
            LineJoinBevel = r100;
            LineJoinType r101 = new LineJoinType("LineJoinMiter", 1, 1);
            LineJoinMiter = r101;
            LineJoinType r102 = new LineJoinType("LineJoinRound", 2, 2);
            LineJoinRound = r102;
            $VALUES = new LineJoinType[]{r100, r101, r102};
        }

        public static LineJoinType[] values() {
            return (LineJoinType[]) $VALUES.clone();
        }

        public int getTypeValue() {
            return this.type;
        }

        public static LineJoinType valueOf(int r100) {
            return values()[Math.max(0, Math.min(r100, 3))];
        }

        public static LineJoinType valueOf(String r100) {
            return (LineJoinType) r27.a.a(LineJoinType.class, r100);
        }

        private LineJoinType(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public AMapPara() {
    }
}
