package com.stepos.core.ota.confirmui;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.stepos.core.download.IDownloadCallback;
import java.util.Collection;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class n implements zb.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7519a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f7520b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f7521c;

    public /* synthetic */ n(int i10, int i11, Object obj) {
        this.f7519a = i11;
        this.f7520b = i10;
        this.f7521c = obj;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        switch (this.f7519a) {
            case 0:
                return ModelConfirmFlow$internalCb$1.onError$lambda$3(this.f7520b, (String) this.f7521c, (IDownloadCallback) obj);
            default:
                return Boolean.valueOf(SnapshotStateList.addAll$lambda$4(this.f7520b, (Collection) this.f7521c, (List) obj));
        }
    }
}
