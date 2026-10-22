package com.bytedance.applog.priority;

import d.a.p;
import java.util.List;

/* JADX INFO: compiled from: PriorityConst.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f5951a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f5952b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<String> f5953c = null;

    static {
        f5951a = new d();
        f5952b = p.b(new String[]{"backoff_priority", "group_priority", "event_priority_config"});
        f5953c = p.b(new String[]{"backoff_priority_list", "event_priority_config", "group_priority_list"});
    }

    private d() {
    }

    public final List<String> a() {
        return f5952b;
    }

    public final List<String> b() {
        return f5953c;
    }
}
