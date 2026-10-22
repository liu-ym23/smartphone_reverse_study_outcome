package com.bytedanceos.appstore;

import android.content.Intent;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.x1;

/* JADX INFO: loaded from: classes2.dex */
public final class AppStoreApplicationKtx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f8256a;

    public AppStoreApplicationKtx() {
        this.f8256a = d0.a(x1.b(null, 1, null).plus(l0.c()));
    }

    public final void a(Function0 r10) {
        q.g(r10, "block");
        h.d(this.f8256a, null, null, new AppStoreApplicationKtx$awaitPrivacyPolicyAgreed$1(r10, null), 3, null);
    }

    public final void b(Intent r10) {
        q.g(r10, MemorySourceLinkType.INTENT);
        h.d(this.f8256a, null, null, new AppStoreApplicationKtx$startStoreCache$1(r10, null), 3, null);
    }
}
