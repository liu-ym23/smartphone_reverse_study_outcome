package com.bytedance.android.ec.core.hybrid.bridges;

import android.content.Context;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.helper.p;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECAlbumScanMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "Ltf3/c;", "result", "", "onMessage", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECAlbumScanMethod extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ECBaseBridgeMethod.a f44108e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f44109f;

    public ECAlbumScanMethod() {
        this.f44109f = "ecAlbumScan";
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return this.f44109f;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessage(tf3.c r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        if (this.f44108e != null) goto L6;
        this.f44108e = null;
        EventBus.getDefault().unregister(this);
        return;
    L6:
        new JSONObject();
        throw null;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        Context r102 = getContext();
        if (r102 == null) goto L6;
        this.f44108e = r101;
        EventBus.getDefault().unregister(this);
        EventBus.getDefault().register(this);
        p.f48130a.openSchema(r102, "sslocal://aweme/scanAlbum");
        return;
    }
}
