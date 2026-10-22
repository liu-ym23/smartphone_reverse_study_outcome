package com.bytedance.ai.applet.moa;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes43.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f34845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f34846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f34847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<Context> f34848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f34849e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n f34850f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Job f34851g;

    public final o a() {
        g r100 = this.f34845a;
        return new o(r100.f34840c, r100.f34839b, this.f34846b, this.f34848d);
    }

    public final g getContext() {
        return this.f34845a;
    }

    public h(g r100, String r101, boolean r102, WeakReference<Context> r103, Function0<Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attemptID");
        this.f34845a = r100;
        this.f34846b = r101;
        this.f34847c = r102;
        this.f34848d = r103;
        this.f34849e = r104;
    }
}
