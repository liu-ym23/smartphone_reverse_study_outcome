package com.android.server.appfunctions;

import android.app.appsearch.AppSearchResult;
import com.android.internal.infra.AndroidFuture;
import java.util.function.Consumer;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FutureAppSearchSessionImpl$$ExternalSyntheticLambda1 implements Consumer {
    public final /* synthetic */ AndroidFuture f$0;

    public /* synthetic */ FutureAppSearchSessionImpl$$ExternalSyntheticLambda1(AndroidFuture r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r2) {
        this.f$0.complete((AppSearchResult) r2);
    }
}
