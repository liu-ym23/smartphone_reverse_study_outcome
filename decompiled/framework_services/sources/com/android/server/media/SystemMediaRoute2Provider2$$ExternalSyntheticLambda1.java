package com.android.server.media;

import android.media.RoutingSessionInfo;
import java.util.function.Consumer;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SystemMediaRoute2Provider2$$ExternalSyntheticLambda1 implements Consumer {
    public final /* synthetic */ RoutingSessionInfo.Builder f$0;

    public /* synthetic */ SystemMediaRoute2Provider2$$ExternalSyntheticLambda1(RoutingSessionInfo.Builder r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r2) {
        this.f$0.addTransferableRoute((String) r2);
    }
}
