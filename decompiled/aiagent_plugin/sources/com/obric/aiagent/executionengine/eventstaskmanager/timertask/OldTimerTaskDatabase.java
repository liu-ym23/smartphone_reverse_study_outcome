package com.obric.aiagent.executionengine.eventstaskmanager.timertask;

import android.app.Application;
import android.content.Context;
import androidx.room.p;
import com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.d;
import com.obric.aiagent.platform.depend.IAppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.io.File;

/* JADX INFO: compiled from: OldTimerTaskDatabase.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class OldTimerTaskDatabase extends p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f17859e = null;

    /* JADX INFO: compiled from: OldTimerTaskDatabase.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        public final String a() {
            return "timer_task_db";
        }

        private a() {
        }

        public final String a(String r2) {
            o.e(r2, "userId");
            return "old_timer_task_" + r2 + ".db";
        }

        public final OldTimerTaskDatabase b(String r5) {
            o.e(r5, "userId");
            p r4 = androidx.room.o.a((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), OldTimerTaskDatabase.class, a(r5)).a(new androidx.room.a.b[]{com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.a.f17913a.a()}).a(new androidx.room.a.b[]{com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.a.f17913a.b()}).a().b();
            o.c(r4, "build(...)");
            return (OldTimerTaskDatabase) ZeusTransformUtils.preCheckCast(r4, OldTimerTaskDatabase.class, "com.obric.aiagent.plugin");
        }

        public final OldTimerTaskDatabase a(Context r3, File r4, String r5) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r2, "context");
            o.e(r4, "importedDbFile");
            o.e(r5, "newDbName");
            p r6 = androidx.room.o.a(r2, OldTimerTaskDatabase.class, r5).a(r4).a(new androidx.room.a.b[]{com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.a.f17913a.a()}).a(new androidx.room.a.b[]{com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.a.f17913a.b()}).b();
            o.c(r6, "build(...)");
            return (OldTimerTaskDatabase) ZeusTransformUtils.preCheckCast(r6, OldTimerTaskDatabase.class, "com.obric.aiagent.plugin");
        }
    }

    static {
        f17859e = new a(null);
    }

    public abstract com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a o();

    public abstract d p();

    public OldTimerTaskDatabase() {
    }
}
