package com.bytedance.android.ec.opt.asynctask;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes44.dex */
public interface IDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f48026a = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Lazy f48027a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f48028b = null;

        public Companion() {
        }

        static {
            f48028b = new Companion();
            f48027a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, IDispatcher$Companion$INSTANCE$2.INSTANCE);
        }
    }

    static {
        f48026a = Companion.f48028b;
    }
}
