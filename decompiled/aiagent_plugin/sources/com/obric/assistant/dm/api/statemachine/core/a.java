package com.obric.assistant.dm.api.statemachine.core;

import com.obric.autogui.common.api.presentation.api.IAssistInputHost;
import d.a.ao;
import d.m;
import d.s;
import java.util.Map;

/* JADX INFO: compiled from: DMConstants.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22459a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f22460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f22461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f22462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<String, TaskType> f22463e = null;

    private a() {
    }

    static {
        f22459a = new a();
        f22460b = 1200000;
        f22461c = 900000;
        f22462d = 120000;
        f22463e = ao.a(new m[]{s.a("simple_task", TaskType.SIMPLE), s.a(IAssistInputHost.TaskType.TASK_TYPE_AUTO_GUI, TaskType.OAUTO), s.a(IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK, TaskType.COMPLEX)});
    }

    public final long a() {
        return f22460b;
    }

    public final void a(long r1) {
        f22460b = r1;
    }

    public final long b() {
        return f22461c;
    }

    public final void b(long r1) {
        f22461c = r1;
    }

    public final long c() {
        return f22462d;
    }

    public final void c(long r1) {
        f22462d = r1;
    }

    public final Map<String, TaskType> d() {
        return f22463e;
    }
}
