package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.privilege.model.paygrade.PayGrade;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class y extends BaseMVIDataStore<y> implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f127340h = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ReadOnlyProperty f127341e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.anya.t f127342f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompositeDisposable f127343g;

    static {
        f127340h = new KProperty[]{Reflection.property1(new PropertyReference1Impl(y.class, "currentPayGrade", "getCurrentPayGrade()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(y.class, "_currentPayGrade", "get_currentPayGrade()Lcom/bytedance/android/live/profit/privilege/model/paygrade/PayGrade;", 0))};
    }

    public y() {
        com.bytedance.android.live.profit.privilege.a r100 = yt0.c.i();
        if (r100 == null) goto L8;
        com.bytedance.live.datacontext.m<? extends PayGrade> r101 = r100.getPayGrade();
        if (r101 == null) goto L8;
        PayGrade r102 = r101.getValue();
        if (r102 == null) goto L8;
    L9:
        com.bytedance.android.anya.internal.k r103 = i(r102).a();
        KProperty<?>[] r104 = f127340h;
        com.bytedance.android.anya.internal.h r105 = r103.a(r104[0]);
        this.f127341e = r105;
        this.f127342f = (com.bytedance.android.anya.t) r105.getValue(this, r104[0]);
        this.f127343g = new CompositeDisposable();
        return;
    L8:
        r102 = new PayGrade(0, 0, 0, 0, null, null, null, null, false, 0, null, 0, null, null, null, null, 0, 0, null, 524287, null);
        goto L9
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f127343g.clear();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        com.bytedance.android.live.profit.privilege.a r100 = yt0.c.i();
        if (r100 == null) goto L6;
        RxUtilKt.c(RxUtilKt.h(r100.getPayGrade().a().subscribeOn(Schedulers.io())).subscribe(new x(this)), this.f127343g);
        return;
    }
}
