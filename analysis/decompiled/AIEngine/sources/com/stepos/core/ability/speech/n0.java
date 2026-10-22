package com.stepos.core.ability.speech;

import android.net.NetworkCapabilities;
import com.stepos.core.ability.speech.AsrFileResult;
import com.stepos.core.ability.speech.VadSessionManager;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class n0 implements zb.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7319a;

    public /* synthetic */ n0(int i10) {
        this.f7319a = i10;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        switch (this.f7319a) {
            case 0:
                return VadSessionManager.C03661.invokeSuspend$lambda$0((String) obj);
            case 1:
                return AsrLocalFileInferencer.recognizePcmSegments_hUnOzRk$lambda$3((AsrFileResult.Utterance) obj);
            case 2:
                return Boolean.valueOf(CloudNetworkWatcher.queryHasInternet$lambda$1((NetworkCapabilities) obj));
            case 3:
                return VadSessionManager.completeInput$lambda$9((String) obj);
            default:
                return VadSessionManager.onFeedInput$lambda$6((String) obj);
        }
    }
}
