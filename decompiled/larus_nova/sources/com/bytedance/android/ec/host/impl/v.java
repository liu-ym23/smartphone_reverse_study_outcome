package com.bytedance.android.ec.host.impl;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class v implements yj.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f46221a = null;

    static {
        f46221a = new v();
    }

    public v() {
    }

    @Override // yj.u
    public final boolean a() {
        return true;
    }

    @Override // yj.u
    public final List<String> c() {
        return CollectionsKt.emptyList();
    }

    @Override // yj.u
    public final void b(Context r100, Function2<? super String, ? super Boolean, Unit> r101, Function2<? super String, ? super Boolean, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "onSuccess");
        Intrinsics.checkNotNullParameter(r102, "onFail");
        r101.invoke("host_builtin", Boolean.TRUE);
    }
}
