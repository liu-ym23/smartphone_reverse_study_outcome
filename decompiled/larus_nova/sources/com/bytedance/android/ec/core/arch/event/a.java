package com.bytedance.android.ec.core.arch.event;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.BroadcastChannelImpl;
import kotlinx.coroutines.flow.o;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f43828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f43829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Object f43830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BroadcastChannel<Object> f43831d;

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.arch.event.a$a, reason: collision with other inner class name */
    public static final class C0791a {
    }

    static {
    }

    public a(BroadcastChannelImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "normalEventChannel");
        this.f43831d = r100;
        this.f43828a = new o(r100);
    }
}
