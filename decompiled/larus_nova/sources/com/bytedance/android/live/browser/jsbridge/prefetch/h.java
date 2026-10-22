package com.bytedance.android.live.browser.jsbridge.prefetch;

import com.bytedance.android.live.browser.jsbridge.protobuf.ExternalProtobufMessageDefinitions;
import com.bytedance.android.live.browser.jsbridge.protobuf.ExternalProtobufShrinkConfigs;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes45.dex */
public final class h<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f63802a = null;

    static {
        f63802a = new h();
    }

    public h() {
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        ExternalProtobufMessageDefinitions.f63828b.a();
        ExternalProtobufShrinkConfigs.f63838b.a();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
