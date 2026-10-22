package com.bytedance.android.livesdk.ktvimpl.base.frame;

import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidgetViewModel;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/frame/AbsViewKWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/base/frame/AbsKWidgetViewModel;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/livesdk/ktvimpl/base/frame/AbsLifeCycleKWidget;", "", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class AbsViewKWidget<T extends AbsKWidgetViewModel> extends AbsLifeCycleKWidget<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewModelStore f142494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f142495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final T f142496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f142497e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f142498f;

    public void c() {
    }

    public int d() {
        return -1;
    }

    public abstract View e();

    public void f() {
    }

    public void h() {
        f();
        c();
    }

    @Override // com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat
    public final ViewModelStore tf() {
        return this.f142494b;
    }

    public final void g(ViewGroup.LayoutParams r100) {
        View r101 = e();
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r101 instanceof ViewGroup) == true) goto L7;
        View r102 = null;
    L8:
        this.f142495c = (ViewGroup) r102;
        if (r100 == null) goto L11;
        this.f142497e.addView(r101, d(), r100);
    L12:
        h();
        return;
    L11:
        this.f142497e.addView(r101, d());
        goto L12
    L7:
        r102 = r101;
        goto L8
    }

    public AbsViewKWidget(LifecycleOwner r100, ViewGroup r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "containerView");
        super(r100);
        this.f142497e = r101;
        this.f142498f = r102;
        this.f142494b = new ViewModelStore();
        T r103 = (T) IKWidget.a.a(this);
        if (r103 == null) goto L5;
        r103.setMDataCenter(r103.getMDataCenter());
    L6:
        this.f142496d = r103;
        new CompositeDisposable();
        return;
    L5:
        r103 = null;
        goto L6
    }
}
