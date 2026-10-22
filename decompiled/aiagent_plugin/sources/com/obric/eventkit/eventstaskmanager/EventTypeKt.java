package com.obric.eventkit.eventstaskmanager;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import d.r;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class EventTypeKt {
    private static final List<r<String, Class<? extends AppEvent>, d.h.a.a<AppEvent>>> EVENTS = null;

    public static final class a extends p implements d.h.a.a<NotificationEvent> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f33209a = null;

        static {
            f33209a = new a();
        }

        public a() {
            super(0);
        }

        public final NotificationEvent a() {
            return new NotificationEvent(null, null, null, 7, null);
        }

        @Override // d.h.a.a
        public /* synthetic */ NotificationEvent invoke() {
            return a();
        }
    }

    public static final class b extends p implements d.h.a.a<ActiveAgentEvent> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f33210a = null;

        static {
            f33210a = new b();
        }

        public b() {
            super(0);
        }

        public final ActiveAgentEvent a() {
            return new ActiveAgentEvent(null, null, null, false, false, null, null, null, 255, null);
        }

        @Override // d.h.a.a
        public /* synthetic */ ActiveAgentEvent invoke() {
            return a();
        }
    }

    static {
        EVENTS = d.a.p.b(new r[]{new r("NOTIFICATION_EVENT", NotificationEvent.class, a.f33209a), new r("ACTIVE_AGENT_EVENT", ActiveAgentEvent.class, b.f33210a)});
    }

    public static final String a(AppEvent r5) {
        o.e(r5, "<this>");
        Iterator<T> r0 = EVENTS.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        r r3 = (r) ZeusTransformUtils.preCheckCast(r1, r.class, "com.obric.aiagent.plugin");
        if (o.a(r5.getClass(), r3.b()) == false) goto L4;
    L9:
        r r6 = (r) ZeusTransformUtils.preCheckCast(r1, r.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L13;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.a(), String.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L13;
        return r7;
    L13:
        return "UNKNOWN";
    L8:
        r1 = null;
        goto L9
    }

    public static final List<r<String, Class<? extends AppEvent>, d.h.a.a<AppEvent>>> a() {
        return EVENTS;
    }

    public static final <T extends AppEvent> T newInstanceByEventType(String r5) {
        Iterator<T> r0 = EVENTS.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (o.a(((r) ZeusTransformUtils.preCheckCast(r1, r.class, "com.obric.aiagent.plugin")).a(), r5) == false) goto L4;
    L9:
        r r6 = (r) ZeusTransformUtils.preCheckCast(r1, r.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L14;
        d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.preCheckCast(r6.c(), d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L14;
        AppEvent r8 = (AppEvent) ZeusTransformUtils.preCheckCast(r7.invoke(), AppEvent.class, "com.obric.aiagent.plugin");
    L16:
        if (ZeusTransformUtils.instanceOf(r8, AppEvent.class) == true) goto L18;
        return null;
    L18:
        return (T) r8;
    L14:
        r8 = null;
        goto L16
    L8:
        r1 = null;
        goto L9
    }
}
