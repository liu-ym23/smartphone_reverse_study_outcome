package com.bytedance.android.livesdk.gecko;

import android.util.Pair;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.UpdatePackage;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes8.dex */
public abstract class f extends GeckoUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GeckoUpdateListener f125802a;

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdateFinish() {
        super.onUpdateFinish();
        GeckoUpdateListener r100 = this.f125802a;
        if (r100 == null) goto L6;
        r100.onUpdateFinish();
        return;
    }

    public f(GeckoUpdateListener r100) {
        this.f125802a = r100;
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onActivateSuccess(UpdatePackage r100) {
        super.onActivateSuccess(r100);
        GeckoUpdateListener r101 = this.f125802a;
        if (r101 == null) goto L6;
        r101.onActivateSuccess(r100);
        return;
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onClean(String r100) {
        super.onClean(r100);
        GeckoUpdateListener r101 = this.f125802a;
        if (r101 == null) goto L6;
        r101.onClean(r100);
        return;
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onDownloadSuccess(UpdatePackage r100) {
        super.onDownloadSuccess(r100);
        GeckoUpdateListener r101 = this.f125802a;
        if (r101 == null) goto L6;
        r101.onDownloadSuccess(r100);
        return;
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdateStart(UpdatePackage r100) {
        super.onUpdateStart(r100);
        GeckoUpdateListener r101 = this.f125802a;
        if (r101 == null) goto L5;
        r101.onUpdateStart(r100);
    L5:
        if (r100 == null) goto L8;
        ALogger.i("GeckoUpdateProxyListener", "accessKey= " + r100 + '.' + r100.getAccessKey() + ", channel = " + r100 + '.' + r100.getChannel() + ", version = " + r100 + '.' + r100.getVersion());
        return;
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdating(String r100) {
        super.onUpdating(r100);
        GeckoUpdateListener r101 = this.f125802a;
        if (r101 == null) goto L6;
        r101.onUpdating(r100);
        return;
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onActivateFail(UpdatePackage r100, Throwable r101) {
        super.onActivateFail(r100, r101);
        GeckoUpdateListener r102 = this.f125802a;
        if (r102 == null) goto L6;
        r102.onActivateFail(r100, r101);
        return;
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onCheckServerVersionFail(Map<String, List<Pair<String, Long>>> r100, Throwable r101) {
        super.onCheckServerVersionFail(r100, r101);
        GeckoUpdateListener r102 = this.f125802a;
        if (r102 == null) goto L6;
        r102.onCheckServerVersionFail(r100, r101);
        return;
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onCheckServerVersionSuccess(Map<String, List<Pair<String, Long>>> r100, Map<String, List<UpdatePackage>> r101) {
        super.onCheckServerVersionSuccess(r100, r101);
        GeckoUpdateListener r102 = this.f125802a;
        if (r102 == null) goto L6;
        r102.onCheckServerVersionSuccess(r100, r101);
        return;
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onDownloadFail(UpdatePackage r100, Throwable r101) {
        super.onDownloadFail(r100, r101);
        GeckoUpdateListener r102 = this.f125802a;
        if (r102 == null) goto L5;
        r102.onDownloadFail(r100, r101);
    L5:
        if (r100 == null) goto L8;
        ALogger.i("GeckoUpdateProxyListener", "accessKey= " + r100 + '.' + r100.getAccessKey() + ", channel = " + r100 + '.' + r100.getChannel() + ", version = " + r100 + '.' + r100.getVersion());
        return;
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    @Deprecated(message = "")
    public final void onUpdateFailed(String r100, Throwable r101) {
        super.onUpdateFailed(r100, r101);
        GeckoUpdateListener r102 = this.f125802a;
        if (r102 == null) goto L6;
        r102.onUpdateFailed(r100, r101);
        return;
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    @Deprecated(message = "")
    public final void onUpdateSuccess(String r100, long r101) {
        super.onUpdateSuccess(r100, r101);
        GeckoUpdateListener r102 = this.f125802a;
        if (r102 == null) goto L6;
        r102.onUpdateSuccess(r100, r101);
        return;
    }
}
