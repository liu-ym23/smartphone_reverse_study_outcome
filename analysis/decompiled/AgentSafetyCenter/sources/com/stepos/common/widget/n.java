package com.stepos.common.widget;

import t.c1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n extends c1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2732a = 0;

    @Override // t.c1
    public final float i(Object obj) {
        switch (this.f2732a) {
            case 0:
                return ((Switch) obj).f2650q;
            default:
                return ((u6.c) obj).getDisplayedWidthIncrease();
        }
    }

    @Override // t.c1
    public final void m(float f5, Object obj) {
        switch (this.f2732a) {
            case 0:
                ((Switch) obj).setThumbPosition(f5);
                break;
            default:
                ((u6.c) obj).setDisplayedWidthIncrease(f5);
                break;
        }
    }
}
