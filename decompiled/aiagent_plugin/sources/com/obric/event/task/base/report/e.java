package com.obric.event.task.base.report;

import com.obric.aiagent.applog.IAppLog;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.obric.eventkit.task.model.ConditionTask;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: ConditionTaskMobHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f32759a = null;

    /* JADX INFO: compiled from: ConditionTaskMobHelper.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f32760a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f32761b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f32762c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f32763d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f32764e = null;
        public static final a f = null;
        public static final a g = null;
        private static final /* synthetic */ a[] i = null;
        private static final /* synthetic */ d.d.a j = null;
        private final String h;

        private static final /* synthetic */ a[] b() {
            return new a[]{f32760a, f32761b, f32762c, f32763d, f32764e, f, g};
        }

        private a(String r1, int r2, String r3) {
            super(r1, r2);
            this.h = r3;
        }

        public final String a() {
            return this.h;
        }

        static {
            f32760a = new a("ALARM_TRIGGER", 0, "alarm_trigger");
            f32761b = new a("LOCATION_TRIGGER", 1, "location_trigger");
            f32762c = new a("WIFI_TRIGGER", 2, "wifi_trigger");
            f32763d = new a("BLUETOOTH_TRIGGER", 3, "bluetooth_trigger");
            f32764e = new a("BATTERY_TRIGGER", 4, "battery_trigger");
            f = new a("STORAGE_TRIGGER", 5, "storage_trigger");
            g = new a("SMS_TRIGGER", 6, "sms_trigger");
            a[] r0 = b();
            i = r0;
            j = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(i.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: ConditionTaskMobHelper.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f32765a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f32766b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f32767c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f32768d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f32769e = null;
        public static final b f = null;
        public static final b g = null;
        public static final b h = null;
        public static final b i = null;
        public static final b j = null;
        public static final b k = null;
        public static final b l = null;
        private static final /* synthetic */ b[] n = null;
        private static final /* synthetic */ d.d.a o = null;
        private final int m;

        private static final /* synthetic */ b[] b() {
            return new b[]{f32765a, f32766b, f32767c, f32768d, f32769e, f, g, h, i, j, k, l};
        }

        private b(String r1, int r2, int r3) {
            super(r1, r2);
            this.m = r3;
        }

        public final int a() {
            return this.m;
        }

        static {
            f32765a = new b("UNKNOWN", 0, -1);
            f32766b = new b("SUCCESS", 1, 0);
            f32767c = new b("LOCATION_CHECK_FAIL", 2, 1);
            f32768d = new b("TIME_CHECK_FAIL", 3, 2);
            f32769e = new b("LOCATION_PERMISSION_FAIL", 4, 3);
            f = new b("SKIP_TASK", 5, 4);
            g = new b("TRIGGER_FREQUENCY_LIMIT", 6, 5);
            h = new b("WIFI_CHECK_FAIL", 7, 6);
            i = new b("BLUETOOTH_CHECK_FAIL", 8, 7);
            j = new b("BATTERY_CHECK_FAIL", 9, 8);
            k = new b("STORAGE_CHECK_FAIL", 10, 9);
            l = new b("SMS_CHECK_FAIL", 11, 10);
            b[] r0 = b();
            n = r0;
            o = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(n.clone(), b[].class, "com.obric.aiagent.plugin");
        }
    }

    static {
        f32759a = new e();
    }

    private e() {
    }

    public final void a(a r3, ConditionTask r4, b r5, long r6) {
        d.h.b.o.e(r3, "triggerType");
        d.h.b.o.e(r4, "conditionTask");
        JSONObject r2 = new JSONObject();
        r2.put("trigger_type", r3.a());
        r2.put(KnowledgeActivity.KEY_TASK_ID, r4.getId());
        if (r5 == null) goto L5;
        Integer r7 = Integer.valueOf(r5.a());
    L6:
        r2.put("result", r7);
        if (r6 <= 0) goto L9;
        long r0 = System.currentTimeMillis() - r6;
    L10:
        r2.put("time_since_last_trigger", r0);
        String r8 = c.a(r4);
        if (r8 != null) goto L13;
        r8 = "";
    L13:
        r2.put("task_create_from", r8);
        IAppLog r9 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L17;
        r9.reportToFlow("condition_task_trigger_result", r2);
        return;
    L17:
        return;
    L9:
        r0 = -1;
        goto L10
    L5:
        r7 = null;
        goto L6
    }

    public final void a(String r7, boolean r8, boolean r9) {
        JSONObject r6 = new JSONObject();
        int r3 = 1;
        String r5 = "";
        if (d.h.b.o.a(r7, "0") == false) goto L6;
        if (r8 == true) goto L6;
    L5:
        r3 = 0;
    L25:
        d.n.a r10 = d.n.f38560a;     // Catch: Throwable -> L19
        r6.put("status", r3);     // Catch: Throwable -> L19
        r6.put("reason", r5);     // Catch: Throwable -> L19
        d.n.f(r6.put("ipc_is_null", r9));     // Catch: Throwable -> L19
    L21:
        IAppLog r11 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L27;
        r11.reportToFlow("o_event_task_register", r6);
        return;
    L27:
        return;
    L19:
        th = move-exception;
        d.n.a r12 = d.n.f38560a;
        d.n.f(d.o.a(th));
    L6:
        if (r7 != null) goto L8;
    L10:
        boolean r1 = false;
    L11:
        if (r1 == false) goto L14;
        r5 = "uid is null";
        goto L25
    L14:
        if (d.h.b.o.a(r7, "0") == false) goto L5;
        if (r8 == false) goto L5;
        r5 = "uid is 0 and isLogin is true";
        goto L25
    L8:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")) != true) goto L10;
        r1 = true;
        goto L11
    }

    public final void a(String r2, String r3) {
        d.h.b.o.e(r2, "className");
        d.h.b.o.e(r3, DBDefinition.SEGMENT_INFO);
        JSONObject r1 = new JSONObject();
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        r1.put("obric_oauto_class", r2);     // Catch: Throwable -> L5
        d.n.f(r1.put("obric_oauto_info", r3));     // Catch: Throwable -> L5
    L7:
        IAppLog r4 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L13;
        r4.reportToFlow("obric_oauto_task_tech_monitor", r1);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        d.n.a r5 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L7
    }
}
