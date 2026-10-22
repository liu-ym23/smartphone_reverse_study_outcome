package com.bytedance.android.livesdk.ktvimpl.base.frame;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidgetViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvStageWidget;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/frame/AbsRecycleViewKWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/base/frame/AbsKWidgetViewModel;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/livesdk/ktvimpl/base/frame/AbsViewKWidget;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class AbsRecycleViewKWidget<T extends AbsKWidgetViewModel> extends AbsViewKWidget<T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f142493g;

    public static final class a {
    }

    static {
    }

    public boolean i() {
        return false;
    }

    public void j(c r100) {
        Intrinsics.checkNotNullParameter(r100, "outFuncProvider");
    }

    public AbsRecycleViewKWidget(KtvStageWidget r100, ViewGroup r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "containerView");
        super(r100, r101, r102);
        this.f142493g = 0;
    }

    public void k(LifecycleOwner r100, ViewGroup r101, c r102, Function1<? super Boolean, Unit> r103) {
        Intrinsics.checkNotNullParameter(r101, "newContainer");
        if (Intrinsics.areEqual(this.f142497e, r101) == false) goto L5;
        return;
    L5:
        ViewGroup r104 = this.f142495c;
        if (r104 == null) goto L30;
        ViewParent r105 = r104.getParent();
        if ((r105 instanceof ViewGroup) == true) goto L10;
        r105 = null;
    L10:
        ViewGroup r106 = (ViewGroup) r105;
        if (r106 == null) goto L17;
        ViewGroup r107 = this.f142495c;
        if (r107 == null) goto L16;
        r106.removeView(r107);
        goto L17
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L17:
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f142497e = r101;
        View r108 = this.f142495c;
        if (r108 != null) goto L21;
        r108 = e();
    L21:
        Unit r109 = r103.invoke(Boolean.FALSE);
        r101.addView(r108, d());
        Unit r110 = r103.invoke(Boolean.TRUE);
        if (r100 == null) goto L24;
        Intrinsics.checkNotNullParameter(r100, "newOner");
        this.f142492a.getLifecycle().removeObserver(this);
        r100.getLifecycle().addObserver(this);
    L24:
        this.f142498f = r102;
        if (r102 == null) goto L27;
        j(r102);
    L27:
        c();
        return;
    L30:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
