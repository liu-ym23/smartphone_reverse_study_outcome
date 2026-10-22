package com.bytedance.ai.utils;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f37633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f37634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Job f37635c;

    public d() {
        MainCoroutineDispatcher r100 = Dispatchers.getMain();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f37633a = 500;
        this.f37634b = CoroutineScopeKt.CoroutineScope(r100);
    }

    public final void a(Object r110, Function2 r111) {
        Intrinsics.checkNotNullParameter(r111, "action");
        if (CoroutineScopeKt.isActive(this.f37634b) == true) goto L6;
        g.f37637a.e("CoroutineDebouncer", "Debouncer is canceled");
        return;
    L6:
        Job r100 = this.f37635c;
        if (r100 == null) goto L9;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L9:
        this.f37635c = BuildersKt.launch$default(this.f37634b, null, null, new CoroutineDebouncer$debounce$2(this, r111, r110, null), 3, null);
    }
}
