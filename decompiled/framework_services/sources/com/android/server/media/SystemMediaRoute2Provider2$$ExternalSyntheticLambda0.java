package com.android.server.media;

import android.media.MediaRoute2Info;
import java.util.function.Function;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SystemMediaRoute2Provider2$$ExternalSyntheticLambda0 implements Function {
    public /* synthetic */ SystemMediaRoute2Provider2$$ExternalSyntheticLambda0() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object r1) {
        return ((MediaRoute2Info) r1).getOriginalId();
    }
}
