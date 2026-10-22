package com.bytedance.android.ec.core.utils.rotation;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class BaseRotationAdapter<T> extends e<T> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f45696j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f45697k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ViewGroup f45698l;

    public BaseRotationAdapter(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "rootLayout");
        this.f45698l = r100;
        LazyThreadSafetyMode r101 = LazyThreadSafetyMode.NONE;
        this.f45696j = LazyKt.lazy(r101, new BaseRotationAdapter$itemView1$2(this));
        this.f45697k = LazyKt.lazy(r101, new BaseRotationAdapter$itemView2$2(this));
    }

    @Override // com.bytedance.android.ec.core.utils.rotation.e
    public final View f(int r100) {
        if (r100 != 0) goto L4;
        View r101 = (View) this.f45696j.getValue();
    L6:
        if ((!Intrinsics.areEqual(r101.getParent(), this.f45698l)) == false) goto L14;
        ViewParent r102 = r101.getParent();
        if ((r102 instanceof ViewGroup) == true) goto L10;
        r102 = null;
    L10:
        ViewGroup r103 = (ViewGroup) r102;
        if (r103 == null) goto L13;
        r103.removeView(r101);
    L13:
        ViewGroup r104 = this.f45698l;
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-1, -2);
        int r106 = (int) UtilityKotlinExtentionsKt.c(16);
        r105.setMarginStart(r106);
        r105.leftMargin = r106;
        r105.gravity = 8388659;
        r104.addView(r101, r105);
    L14:
        return r101;
    L4:
        r101 = (View) this.f45697k.getValue();
        goto L6
    }
}
