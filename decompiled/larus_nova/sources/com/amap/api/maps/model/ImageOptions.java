package com.amap.api.maps.model;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;

/* JADX INFO: loaded from: classes28.dex */
public class ImageOptions {
    public int color;
    public String content;
    public int fontSize;
    public float radius;
    public double[] rgba;
    public int type;

    public static final enum ShapeType extends Enum<ShapeType> {
        private static final /* synthetic */ ShapeType[] $VALUES = null;
        public static final ShapeType CIRCLE = null;
        public static final ShapeType DEFAULT = null;
        public static final ShapeType TEXT = null;
        private int index;

        static {
            ShapeType r100 = new ShapeType("DEFAULT", 0, 0);
            DEFAULT = r100;
            ShapeType r101 = new ShapeType("CIRCLE", 1, 1);
            CIRCLE = r101;
            ShapeType r102 = new ShapeType(CardAdapter.TEXT, 2, 2);
            TEXT = r102;
            $VALUES = new ShapeType[]{r100, r101, r102};
        }

        public static ShapeType[] values() {
            return (ShapeType[]) $VALUES.clone();
        }

        public int value() {
            return this.index;
        }

        public static ShapeType valueOf(String r100) {
            return (ShapeType) r27.a.a(ShapeType.class, r100);
        }

        private ShapeType(String r100, int r101, int r102) {
            super(r100, r101);
            this.index = r102;
        }
    }

    public ImageOptions() {
    }
}
