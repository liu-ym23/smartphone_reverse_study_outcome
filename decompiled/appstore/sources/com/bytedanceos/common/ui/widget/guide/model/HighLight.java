package com.bytedanceos.common.ui.widget.guide.model;

import android.graphics.RectF;
import android.view.View;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface HighLight {

    public static final enum Shape extends Enum<Shape> {
        private static final /* synthetic */ Shape[] $VALUES = null;
        public static final Shape CIRCLE = null;
        public static final Shape OVAL = null;
        public static final Shape RECTANGLE = null;
        public static final Shape ROUND_RECTANGLE = null;

        private static /* synthetic */ Shape[] $values() {
            return new Shape[]{CIRCLE, RECTANGLE, OVAL, ROUND_RECTANGLE};
        }

        static {
            CIRCLE = new Shape("CIRCLE", 0);
            RECTANGLE = new Shape("RECTANGLE", 1);
            OVAL = new Shape("OVAL", 2);
            ROUND_RECTANGLE = new Shape("ROUND_RECTANGLE", 3);
            $VALUES = $values();
        }

        private Shape(String r10, int r11) {
            super(r10, r11);
        }

        public static Shape valueOf(String r10) {
            return (Shape) Enum.valueOf(Shape.class, r10);
        }

        public static Shape[] values() {
            return (Shape[]) $VALUES.clone();
        }
    }

    @Nullable
    HighlightOptions getOptions();

    float getRadius();

    RectF getRectF(View r10);

    int getRound();

    Shape getShape();
}
