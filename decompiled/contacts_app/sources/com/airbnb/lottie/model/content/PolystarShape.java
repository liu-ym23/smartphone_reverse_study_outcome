package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.PolystarContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* JADX INFO: loaded from: classes.dex */
public class PolystarShape implements ContentModel {
    private final boolean hidden;
    private final AnimatableFloatValue innerRadius;
    private final AnimatableFloatValue innerRoundedness;
    private final boolean isReversed;
    private final String name;
    private final AnimatableFloatValue outerRadius;
    private final AnimatableFloatValue outerRoundedness;
    private final AnimatableFloatValue points;
    private final AnimatableValue<PointF, PointF> position;
    private final AnimatableFloatValue rotation;
    private final Type type;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type POLYGON = null;
        public static final Type STAR = null;
        private final int value;

        private static /* synthetic */ Type[] $values() {
            return new Type[]{STAR, POLYGON};
        }

        public static Type valueOf(String r1) {
            return (Type) Enum.valueOf(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        static {
            STAR = new Type("STAR", 0, 1);
            POLYGON = new Type("POLYGON", 1, 2);
            $VALUES = $values();
        }

        private Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static Type forValue(int r5) {
            Type[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            Type r3 = r0[r2];
            if (r3.value == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }
    }

    public PolystarShape(String r1, Type r2, AnimatableFloatValue r3, AnimatableValue<PointF, PointF> r4, AnimatableFloatValue r5, AnimatableFloatValue r6, AnimatableFloatValue r7, AnimatableFloatValue r8, AnimatableFloatValue r9, boolean r10, boolean r11) {
        this.name = r1;
        this.type = r2;
        this.points = r3;
        this.position = r4;
        this.rotation = r5;
        this.innerRadius = r6;
        this.outerRadius = r7;
        this.innerRoundedness = r8;
        this.outerRoundedness = r9;
        this.hidden = r10;
        this.isReversed = r11;
    }

    public String getName() {
        return this.name;
    }

    public Type getType() {
        return this.type;
    }

    public AnimatableFloatValue getPoints() {
        return this.points;
    }

    public AnimatableValue<PointF, PointF> getPosition() {
        return this.position;
    }

    public AnimatableFloatValue getRotation() {
        return this.rotation;
    }

    public AnimatableFloatValue getInnerRadius() {
        return this.innerRadius;
    }

    public AnimatableFloatValue getOuterRadius() {
        return this.outerRadius;
    }

    public AnimatableFloatValue getInnerRoundedness() {
        return this.innerRoundedness;
    }

    public AnimatableFloatValue getOuterRoundedness() {
        return this.outerRoundedness;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public boolean isReversed() {
        return this.isReversed;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable r1, LottieComposition r2, BaseLayer r3) {
        return new PolystarContent(r1, r3, this);
    }
}
