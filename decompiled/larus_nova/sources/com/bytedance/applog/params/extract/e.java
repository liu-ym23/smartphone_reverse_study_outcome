package com.bytedance.applog.params.extract;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f192569c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ParamsExtractDao f192570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f192571b;

    public static final class a {
    }

    static {
        f192569c = CollectionsKt.listOf("ParamsExtractManager");
    }

    public e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Context r101 = r100.getApplicationContext();
        this.f192570a = new ParamsExtractDao(r101, new d(r101));
        this.f192571b = new b();
    }
}
