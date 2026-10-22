package com.android.server.media;

import java.util.function.Predicate;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class MediaRoute2Provider$SessionCreationOrTransferRequest$$ExternalSyntheticLambda1 implements Predicate {
    public final /* synthetic */ String f$0;

    public /* synthetic */ MediaRoute2Provider$SessionCreationOrTransferRequest$$ExternalSyntheticLambda1(String r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object r2) {
        return this.f$0.equals((String) r2);
    }
}
