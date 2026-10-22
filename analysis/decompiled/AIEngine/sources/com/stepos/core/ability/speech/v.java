package com.stepos.core.ability.speech;

import android.net.NetworkCapabilities;
import com.stepos.core.ability.speech.AsrSseStreamSessionManager;
import java.io.File;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class v implements zb.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7344a;

    public /* synthetic */ v(int i10) {
        this.f7344a = i10;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        switch (this.f7344a) {
            case 0:
                return AsrSseStreamSessionManager.C03341.invokeSuspend$lambda$0((String) obj);
            case 1:
                return Boolean.valueOf(AsrMultiFilesFileStore.dirSize$lambda$20$lambda$18((File) obj));
            case 2:
                return AsrSseStreamSessionManager.onFeedInput$lambda$5((String) obj);
            case 3:
                return AsrSseStreamSessionManager.completeInput$lambda$8((String) obj);
            default:
                return Boolean.valueOf(CloudNetworkWatcher.queryValidated$lambda$0((NetworkCapabilities) obj));
        }
    }
}
