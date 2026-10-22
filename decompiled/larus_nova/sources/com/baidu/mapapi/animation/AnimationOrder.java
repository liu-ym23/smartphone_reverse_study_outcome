package com.baidu.mapapi.animation;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum AnimationOrder extends Enum<AnimationOrder> {
    public static final AnimationOrder ANIM_ORDER_THEN = null;
    public static final AnimationOrder ANIM_ORDER_WITH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AnimationOrder[] f30522a = null;

    static {
        AnimationOrder r100 = new AnimationOrder("ANIM_ORDER_WITH", 0);
        ANIM_ORDER_WITH = r100;
        AnimationOrder r101 = new AnimationOrder("ANIM_ORDER_THEN", 1);
        ANIM_ORDER_THEN = r101;
        f30522a = new AnimationOrder[]{r100, r101};
    }

    public static AnimationOrder[] values() {
        return (AnimationOrder[]) f30522a.clone();
    }

    public static AnimationOrder valueOf(String r100) {
        return (AnimationOrder) a.a(AnimationOrder.class, r100);
    }

    private AnimationOrder(String r100, int r101) {
        super(r100, r101);
    }
}
