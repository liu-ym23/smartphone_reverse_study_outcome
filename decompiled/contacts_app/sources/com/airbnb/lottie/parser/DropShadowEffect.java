package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;

/* JADX INFO: loaded from: classes.dex */
public class DropShadowEffect {
    private final AnimatableColorValue color;
    private final AnimatableFloatValue direction;
    private final AnimatableFloatValue distance;
    private final AnimatableFloatValue opacity;
    private final AnimatableFloatValue radius;

    DropShadowEffect(AnimatableColorValue r1, AnimatableFloatValue r2, AnimatableFloatValue r3, AnimatableFloatValue r4, AnimatableFloatValue r5) {
        this.color = r1;
        this.opacity = r2;
        this.direction = r3;
        this.distance = r4;
        this.radius = r5;
    }

    public AnimatableColorValue getColor() {
        return this.color;
    }

    public AnimatableFloatValue getOpacity() {
        return this.opacity;
    }

    public AnimatableFloatValue getDirection() {
        return this.direction;
    }

    public AnimatableFloatValue getDistance() {
        return this.distance;
    }

    public AnimatableFloatValue getRadius() {
        return this.radius;
    }
}
