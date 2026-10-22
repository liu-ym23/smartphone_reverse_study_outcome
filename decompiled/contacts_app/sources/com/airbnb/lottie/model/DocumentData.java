package com.airbnb.lottie.model;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes.dex */
public class DocumentData {
    public float baselineShift;
    public PointF boxPosition;
    public PointF boxSize;
    public int color;
    public String fontName;
    public Justification justification;
    public float lineHeight;
    public float size;
    public int strokeColor;
    public boolean strokeOverFill;
    public float strokeWidth;
    public String text;
    public int tracking;

    public static final enum Justification extends Enum<Justification> {
        private static final /* synthetic */ Justification[] $VALUES = null;
        public static final Justification CENTER = null;
        public static final Justification LEFT_ALIGN = null;
        public static final Justification RIGHT_ALIGN = null;

        private static /* synthetic */ Justification[] $values() {
            return new Justification[]{LEFT_ALIGN, RIGHT_ALIGN, CENTER};
        }

        private Justification(String r1, int r2) {
            super(r1, r2);
        }

        public static Justification valueOf(String r1) {
            return (Justification) Enum.valueOf(Justification.class, r1);
        }

        public static Justification[] values() {
            return (Justification[]) $VALUES.clone();
        }

        static {
            LEFT_ALIGN = new Justification("LEFT_ALIGN", 0);
            RIGHT_ALIGN = new Justification("RIGHT_ALIGN", 1);
            CENTER = new Justification("CENTER", 2);
            $VALUES = $values();
        }
    }

    public DocumentData(String r1, String r2, float r3, Justification r4, int r5, float r6, float r7, int r8, int r9, float r10, boolean r11, PointF r12, PointF r13) {
        set(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public DocumentData() {
    }

    public void set(String r1, String r2, float r3, Justification r4, int r5, float r6, float r7, int r8, int r9, float r10, boolean r11, PointF r12, PointF r13) {
        this.text = r1;
        this.fontName = r2;
        this.size = r3;
        this.justification = r4;
        this.tracking = r5;
        this.lineHeight = r6;
        this.baselineShift = r7;
        this.color = r8;
        this.strokeColor = r9;
        this.strokeWidth = r10;
        this.strokeOverFill = r11;
        this.boxPosition = r12;
        this.boxSize = r13;
    }

    public int hashCode() {
        int r0 = (((((int) ((((this.text.hashCode() * 31) + this.fontName.hashCode()) * 31) + this.size)) * 31) + this.justification.ordinal()) * 31) + this.tracking;
        long r1 = Float.floatToRawIntBits(this.lineHeight);
        return (((r0 * 31) + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.color;
    }
}
