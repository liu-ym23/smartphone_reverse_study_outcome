package com.obric.autogui.database;

import android.content.Context;
import androidx.room.p;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.database.a.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AutoActionDatabase.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AutoActionDatabase extends p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f29019e = null;
    private static volatile AutoActionDatabase f;

    /* JADX INFO: compiled from: AutoActionDatabase.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final AutoActionDatabase a(Context r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            o.e(r6, "context");
            AutoActionDatabase r0 = AutoActionDatabase.p();
            if (r0 != null) goto L11;
            monitor-enter(this);
            p r7 = androidx.room.o.a(r6, AutoActionDatabase.class, "autoaction_database").a(new androidx.room.a.b[]{new com.obric.autogui.database.b.a()}).a(new androidx.room.a.b[]{new com.obric.autogui.database.b.b()}).a(new androidx.room.a.b[]{new com.obric.autogui.database.b.c()}).a(new androidx.room.a.b[]{new com.obric.autogui.database.b.d()}).b();     // Catch: Throwable -> L8
            o.c(r7, "build(...)");     // Catch: Throwable -> L8
            r0 = (AutoActionDatabase) ZeusTransformUtils.preCheckCast(r7, AutoActionDatabase.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
            a r8 = AutoActionDatabase.f29019e;     // Catch: Throwable -> L8
            AutoActionDatabase.a(r0);     // Catch: Throwable -> L8
            monitor-exit(this);
        L8:
            th = move-exception;
            throw th;
        L11:
            return r0;
        }

        public final AutoActionDatabase a() {
            AutoActionDatabase r0 = AutoActionDatabase.p();
            if (r0 != null) goto L11;
            monitor-enter(this);
            p r1 = androidx.room.o.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), AutoActionDatabase.class, "autoaction_database").a(new androidx.room.a.b[]{new com.obric.autogui.database.b.a()}).a(new androidx.room.a.b[]{new com.obric.autogui.database.b.b()}).a(new androidx.room.a.b[]{new com.obric.autogui.database.b.c()}).a(new androidx.room.a.b[]{new com.obric.autogui.database.b.d()}).b();     // Catch: Throwable -> L8
            o.c(r1, "build(...)");     // Catch: Throwable -> L8
            r0 = (AutoActionDatabase) ZeusTransformUtils.preCheckCast(r1, AutoActionDatabase.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
            a r2 = AutoActionDatabase.f29019e;     // Catch: Throwable -> L8
            AutoActionDatabase.a(r0);     // Catch: Throwable -> L8
            monitor-exit(this);
        L8:
            th = move-exception;
            throw th;
        L11:
            return r0;
        }
    }

    static {
        f29019e = new a(null);
    }

    public static final /* synthetic */ void a(AutoActionDatabase r0) {
        f = r0;
    }

    public static final /* synthetic */ AutoActionDatabase p() {
        return f;
    }

    public AutoActionDatabase() {
    }

    public final e o() {
        return (e) ZeusTransformUtils.preCheckCast(new defpackage.b(), e.class, "com.obric.aiagent.plugin");
    }
}
