package com.stepos.core.model.callback;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface StreamCallback {
    void onComplete();

    void onError(int i10, String str);

    void onToken(String str);
}
