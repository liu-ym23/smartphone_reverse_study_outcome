package com.obric.appstore.util;

import android.content.Context;
import com.obric.apptools.sdk.common.Event;
import com.obric.apptools.sdk.common.IMetricsReporter;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements IMetricsReporter {
    public p() {
    }

    @Override // com.obric.apptools.sdk.common.IMetricsReporter
    public void init(Context r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        com.slardaros.client.d.c(r10);
    }

    @Override // com.obric.apptools.sdk.common.IMetricsReporter
    public void report(@NotNull Event r10) {
        kotlin.jvm.internal.q.g(r10, "event");
        com.slardaros.client.d.e(kotlin.collections.t.g(new com.slardaros.client.a[]{new com.slardaros.client.c(r10.e(), com.obric.apptools.sdk.common.a.f11138a.a(r10))}));
    }
}
