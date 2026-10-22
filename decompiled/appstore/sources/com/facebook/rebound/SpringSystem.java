package com.facebook.rebound;

/* JADX INFO: loaded from: classes2.dex */
public class SpringSystem extends BaseSpringSystem {
    private SpringSystem(SpringLooper r10) {
        super(r10);
    }

    public static SpringSystem create() {
        return new SpringSystem(AndroidSpringLooperFactory.createSpringLooper());
    }
}
