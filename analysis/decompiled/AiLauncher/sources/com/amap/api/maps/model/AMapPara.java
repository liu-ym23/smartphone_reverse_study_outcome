package com.amap.api.maps.model;

/* loaded from: classes.dex */
public class AMapPara {
    public static final int DOTTEDLINE_TYPE_CIRCLE = 1;
    public static final int DOTTEDLINE_TYPE_DEFAULT = -1;
    public static final int DOTTEDLINE_TYPE_SQUARE = 0;

    public enum LineCapType {
        LineCapButt(0),
        LineCapSquare(1),
        LineCapArrow(2),
        LineCapRound(3);

        private int type;

        LineCapType(int i10) {
            this.type = i10;
        }

        public int getTypeValue() {
            return this.type;
        }

        public static LineCapType valueOf(int i10) {
            return values()[Math.max(0, Math.min(i10, 4))];
        }
    }

    public enum LineJoinType {
        LineJoinBevel(0),
        LineJoinMiter(1),
        LineJoinRound(2);

        private int type;

        LineJoinType(int i10) {
            this.type = i10;
        }

        public int getTypeValue() {
            return this.type;
        }

        public static LineJoinType valueOf(int i10) {
            return values()[Math.max(0, Math.min(i10, 3))];
        }
    }
}
