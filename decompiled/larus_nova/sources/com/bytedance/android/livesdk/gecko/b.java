package com.bytedance.android.livesdk.gecko;

import android.util.Pair;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import io.reactivex.ObservableEmitter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends GeckoUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ObservableEmitter f125795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j.f f125796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j.a f125797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function1 f125798d;

    public final void a(boolean r100) {
        Set<j.a> r101 = d.f125800a;
        d.f125800a.add(this.f125797c);
        ALogger.i("AAM.Source.GeckoHelper", "[" + this.f125795a.hashCode() + "] update resource success[" + this.f125796b.f125814a + "], cache: " + r100 + " version: " + this.f125796b.f125815b);
        Function1 r102 = this.f125798d;
        String r103 = this.f125796b.f125814a;
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        String r104 = (String) r102.invoke(r103);
        if (r104 == null) goto L8;
        PolarisFileWrapper r105 = new PolarisFileWrapper(r104);
        if (r105.exists() == false) goto L14;
        this.f125795a.onNext(new j.d(r100, r105.getAbsolutePath()));
    L16:
        this.f125795a.onComplete();
        return;
    L14:
        if (this.f125795a.isDisposed() == true) goto L16;
        this.f125795a.onError(new Throwable("download channel success but not exist: " + this.f125796b.f125814a));
        goto L16
    L8:
        if (this.f125795a.isDisposed() == true) goto L16;
        this.f125795a.onError(new Throwable("download channel success but not found: " + this.f125796b.f125814a));
        goto L16
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onCheckServerVersionFail(Map<String, List<Pair<String, Long>>> r100, Throwable r101) {
        super.onCheckServerVersionFail(r100, r101);
        ALogger.e("AAM.Source.GeckoHelper", "[" + this.f125795a.hashCode() + "] check version error" + this.f125796b.f125815b + ": " + r101);
        if (this.f125795a.isDisposed() == true) goto L8;
        ObservableEmitter r102 = this.f125795a;
        if (r101 != null) goto L7;
        r101 = new Throwable("update " + this.f125796b.f125814a + " failed");
    L7:
        r102.onError(r101);
    L8:
        this.f125795a.onComplete();
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onCheckServerVersionSuccess(Map<String, List<Pair<String, Long>>> r110, Map<String, List<UpdatePackage>> r111) {
        super.onCheckServerVersionSuccess(r110, r111);
        if (r111 == null) goto L9;
        Iterator<Map.Entry<String, List<UpdatePackage>>> r112 = r111.entrySet().iterator();
    L6:
        if (r112.hasNext() == false) goto L9;
        Map.Entry<String, List<UpdatePackage>> r100 = r112.next();
        ALogger.i("AAM.Source.GeckoHelper", r100.getKey() + ' ' + CollectionsKt.joinToString$default(r100.getValue(), HiAnalyticsConstant.REPORT_VAL_SEPARATOR, null, null, 0, null, null, 62, null));
    L9:
        if (r111 != null) goto L11;
    L14:
        boolean r113 = true;
    L15:
        if (r113 == false) goto L19;
        a(true);
        return;
    L19:
        return;
    L11:
        if (r111.isEmpty() == true) goto L14;
        r113 = false;
        goto L15
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdateFailed(String r100, Throwable r101) {
        super.onUpdateFailed(r100, r101);
        ALogger.e("AAM.Source.GeckoHelper", "[" + this.f125795a.hashCode() + "] update resource error[" + r100 + "] " + this.f125796b.f125815b + ": " + r101);
        if (this.f125795a.isDisposed() == true) goto L8;
        ObservableEmitter r102 = this.f125795a;
        if (r101 != null) goto L7;
        r101 = new Throwable("update " + this.f125796b.f125814a + " failed");
    L7:
        r102.onError(r101);
    L8:
        this.f125795a.onComplete();
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdateSuccess(String r100, long r101) {
        super.onUpdateSuccess(r100, r101);
        a(false);
    }

    public b(ObservableEmitter r100, j.f r101, j.a r102, Function1 r103) {
        this.f125795a = r100;
        this.f125796b = r101;
        this.f125797c = r102;
        this.f125798d = r103;
    }
}
