package com.obric.aiagent.executionengine.eventstaskmanager.timertask.data;

import android.app.Application;
import android.content.Context;
import androidx.room.a.b;
import androidx.room.o;
import androidx.room.p;
import com.obric.aiagent.platform.depend.IAppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.h;

/* JADX INFO: compiled from: TimerTaskDatabase.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class TimerTaskDatabase extends p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f17911e = null;
    private static final f<TimerTaskDatabase> f = null;

    /* JADX INFO: compiled from: TimerTaskDatabase.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    public static /* synthetic */ TimerTaskDatabase lambda$ITFX_oF8o4yWgW3LlMeKGcU1NX8() {
        return o();
    }

    public TimerTaskDatabase() {
    }

    static {
        f17911e = new a(null);
        f = g.a($$Lambda$TimerTaskDatabase$ITFX_oF8o4yWgW3LlMeKGcU1NX8.INSTANCE);
    }

    private static final TimerTaskDatabase o() {
        return (TimerTaskDatabase) ZeusTransformUtils.preCheckCast(o.a((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), TimerTaskDatabase.class, "timer_task_db").a(new b[]{com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.a.f17913a.a()}).a(new b[]{com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.a.f17913a.b()}).a().b(), TimerTaskDatabase.class, "com.obric.aiagent.plugin");
    }
}
