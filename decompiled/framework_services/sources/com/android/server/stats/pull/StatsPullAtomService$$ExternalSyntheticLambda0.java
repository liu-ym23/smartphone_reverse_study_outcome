package com.android.server.stats.pull;

import android.app.AppOpsManager;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class StatsPullAtomService$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ CompletableFuture f$0;

    public /* synthetic */ StatsPullAtomService$$ExternalSyntheticLambda0(CompletableFuture r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r2) {
        this.f$0.complete((AppOpsManager.HistoricalOps) r2);
    }
}
