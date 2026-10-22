package com.bytedance.applog.adaptor;

import com.bytedance.applog.c;
import com.bytedance.applog.store.DbStore;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: OldAppLogDataMigrator.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f5500a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f5501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f5502c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile int f5503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f5504e;
    private static volatile boolean f;
    private static volatile boolean g;

    static /* synthetic */ String a(boolean r0) {
        return b(r0);
    }

    static /* synthetic */ List a() {
        return f5500a;
    }

    static /* synthetic */ int b() {
        return f5503d;
    }

    static /* synthetic */ String c() {
        return f5502c;
    }

    static /* synthetic */ int d() {
        return f5501b;
    }

    static {
        f5500a = Collections.singletonList("OldAppLogDataMigrator");
        f5501b = 10;
        f5502c = "select _id from queue order by _id asc limit " + f5501b;
        f5503d = 1000;
        f5504e = false;
        f = false;
        g = false;
    }

    private static String b(boolean r2) {
        StringBuilder r0 = new StringBuilder().append("SELECT event._id as _id, category, tag, label, event.value, ext_value, ext_json, user_id, event.timestamp, event.event_index as event_index, user_type, user_is_login, user_is_auth, uid, s.value as session_id ");
        if (r2 == false) goto L5;
        String r3 = ", disable_personalization";
    L7:
        return r0.append(r3).append(" FROM event left join session s on event.session_id  = s._id order by event._id asc limit ?").toString();
    L5:
        r3 = "";
        goto L7
    }

    public static void a(final c r4, final DbStore r5) {
        if (f == true) goto L5;
        return;
    L5:
        if (r4.ab() == false) goto L10;
        r4.Z().a(f5500a, "Start to migrate stay duration data with pages...", new Object[0]);
        com.bytedance.applog.c.a.b().submit(new AnonymousClass1(r4, r5));
        return;
    }

    public static void b(final c r4, final DbStore r5) {
        if (f5504e == true) goto L5;
        return;
    L5:
        if (r4.ab() == false) goto L10;
        r4.Z().a(f5500a, "Start to migrate events...", new Object[0]);
        com.bytedance.applog.c.a.b().submit(new AnonymousClass2(r4, r5));
        return;
    }

    public static void c(final c r4, final DbStore r5) {
        if (g == true) goto L5;
        return;
    L5:
        if (r4.ab() == false) goto L10;
        r4.Z().a(f5500a, "Start to migrate packed logs data...", new Object[0]);
        com.bytedance.applog.c.a.b().submit(new AnonymousClass3(r4, r5));
        return;
    }
}
