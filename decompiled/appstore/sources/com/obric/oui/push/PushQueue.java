package com.obric.oui.push;

import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.b;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class PushQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16510a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f16511b = null;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f16510a = new a(null);
        f16511b = b.a(LazyThreadSafetyMode.SYNCHRONIZED, PushQueue$Companion$instance$2.INSTANCE);
    }

    public /* synthetic */ PushQueue(DefaultConstructorMarker r10) {
        this();
    }

    public PushQueue() {
    }
}
