package com.google.android.material.button;

import androidx.dynamicanimation.animation.FloatPropertyCompat;
import com.stepos.common.widget.Switch;

/* loaded from: classes3.dex */
public final class a extends FloatPropertyCompat {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2365a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(String str, int i) {
        super(str);
        this.f2365a = i;
    }

    @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
    public final float getValue(Object obj) {
        switch (this.f2365a) {
            case 0:
                return ((MaterialButton) obj).getDisplayedWidthIncrease();
            default:
                return ((Switch) obj).m;
        }
    }

    @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
    public final void setValue(Object obj, float f) {
        switch (this.f2365a) {
            case 0:
                ((MaterialButton) obj).setDisplayedWidthIncrease(f);
                break;
            default:
                ((Switch) obj).setThumbPosition(f);
                break;
        }
    }
}
