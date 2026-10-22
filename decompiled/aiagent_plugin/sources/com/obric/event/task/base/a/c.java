package com.obric.event.task.base.a;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.obric.aiagent.platform.depend.IAppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.k;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: ExperimentConfigManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private static final String TAG = "ExperimentConfigManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f32676a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f32677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Object> f32678c = null;

    /* JADX INFO: compiled from: ExperimentConfigManager.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f32679a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final JSONObject f32680b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f32679a, r6.f32679a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f32680b, r6.f32680b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f32679a.hashCode() * 31) + this.f32680b.hashCode();
        }

        public String toString() {
            return "ConfigSnapshot(rawConfig=" + this.f32679a + ", config=" + this.f32680b + ')';
        }

        public a(String r2, JSONObject r3) {
            o.e(r2, "rawConfig");
            o.e(r3, "config");
            this.f32679a = r2;
            this.f32680b = r3;
        }

        public final String a() {
            return this.f32679a;
        }

        public final JSONObject b() {
            return this.f32680b;
        }
    }

    /* JADX INFO: compiled from: ExperimentConfigManager.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32681a = null;

        static {
            int[] r0 = new int[com.obric.event.task.base.a.a.b.values().length];
            r0[com.obric.event.task.base.a.a.b.f32667a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[com.obric.event.task.base.a.a.b.f32668b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[com.obric.event.task.base.a.a.b.f32669c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[com.obric.event.task.base.a.a.b.f32670d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f32681a = r0;
        }
    }

    public static /* synthetic */ void lambda$tP7M70DrAN5f9iUIG2p8in0wy_U(Application r0, String r1) {
        a(r0, r1);
    }

    private c() {
    }

    static {
        f32676a = new c();
        f32678c = new ConcurrentHashMap();
    }

    public static final int a(com.obric.event.task.base.a.a<Integer> r3) {
        o.e(r3, "key");
        Object r0 = f32676a.b(r3);
        if (ZeusTransformUtils.instanceOf(r0, Number.class) == false) goto L5;
        Object r4 = ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin");
    L7:
        return ((Number) r4).intValue();
    L5:
        r4 = ZeusTransformUtils.preCheckCast(r3.b(), Number.class, "com.obric.aiagent.plugin");
        goto L7
    }

    private final Object b(com.obric.event.task.base.a.a<?> r4) {
        if (com.obric.event.task.base.a.b.a(r4) == true) goto L7;
        com.obric.event.task.base.b.b.f32684a.d(TAG, "reject undeclared experiment key, name=" + r4.a());
        c(r4);
        return r4.b();
    L7:
        if (r4.c() == false) goto L11;
        Object r0 = f32678c.get(r4.a());
        if (r0 == null) goto L11;
        return r0;
    L11:
        Object r3 = a(a(), r4);
        if (r4.c() == false) goto L18;
        Object r5 = f32678c.putIfAbsent(r4.a(), r3);
        if (r5 != null) goto L17;
        return r3;
    L17:
        return r5;
    L18:
        return r3;
    }

    private final void c(com.obric.event.task.base.a.a<?> r5) {
    L11:
        th = move-exception;
        com.obric.event.task.base.b.b.f32684a.b(TAG, "show undeclared key toast failed, key=" + r5.a() + ", err=" + th.getMessage(), th);
        return;
    L4:
        if (o.a(IAppContext.Companion.getBuildChannel(), "local_test") == true) goto L6;
        return;
    L6:
        final Application r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        final String r1 = "实验配置 key=" + r5.a() + " 未声明，请先在 ExperimentConfigKeys 中增加";     // Catch: Throwable -> L11
        if (o.a(Looper.myLooper(), Looper.getMainLooper()) == false) goto L9;
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), 1).show();     // Catch: Throwable -> L11
    L14:
        return;
    L9:
        new Handler(Looper.getMainLooper()).post(new $$Lambda$c$tP7M70DrAN5f9iUIG2p8in0wy_U(r0, r1));     // Catch: Throwable -> L11
        goto L14
    }

    private static final void a(Application r2, String r3) {
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"), 1).show();
    }

    private final Object a(JSONObject r4, com.obric.event.task.base.a.a<?> r5) {
        if (r4.has(r5.a()) == true) goto L6;
        com.obric.event.task.base.b.b.f32684a.b(TAG, "experiment key missing, name=" + r5.a());
        return r5.b();
    L6:
        Object r6 = r4.opt(r5.a());
        if (r6 != null) goto L9;
    L16:
        com.obric.event.task.base.b.b.f32684a.b(TAG, "experiment key value is null, name=" + r5.a());
        return r5.b();
    L9:
        if (o.a(r6, JSONObject.NULL) == true) goto L16;
        if (a(r6, r5.getType()) == true) goto L18;
        com.obric.event.task.base.b.b.f32684a.d(TAG, "experiment key type mismatch, name=" + r5.a() + ", expect=" + r5.getType() + ", actual=" + r6.getClass().getSimpleName());
        return r5.b();
    L18:
        return r6;
    }

    private final boolean a(Object r1, com.obric.event.task.base.a.a.b r2) {
        int r0 = b.f32681a[r2.ordinal()];
        if (r0 == 1) goto L16;
        if (r0 == 2) goto L19;
        if (r0 == 3) goto L18;
        if (r0 != 4) goto L12;
        return ZeusTransformUtils.instanceOf(r1, JSONObject.class);
    L12:
        throw new k();
    L18:
        return ZeusTransformUtils.instanceOf(r1, String.class);
    L19:
        return ZeusTransformUtils.instanceOf(r1, Number.class);
    L16:
        return ZeusTransformUtils.instanceOf(r1, Boolean.class);
    }

    private final JSONObject a() {
        String r0 = b();
        a r1 = f32677b;
        if (r1 != null) goto L5;
    L8:
        monitor-enter(this);
        a r2 = f32677b;     // Catch: Throwable -> L22
        if (r2 != null) goto L12;
    L16:
        JSONObject r3 = f32676a.a(r0, true);     // Catch: Throwable -> L22
        if (r0 != null) goto L19;
        r0 = "";
    L19:
        f32677b = new a(r0, r3);     // Catch: Throwable -> L22
        monitor-exit(this);
        return r3;
    L12:
        if (o.a(r2.a(), r0) == false) goto L16;
        JSONObject r4 = r2.b();     // Catch: Throwable -> L22
        monitor-exit(this);
        return r4;
    L22:
        th = move-exception;
        throw th;
    L5:
        if (o.a(r1.a(), r0) == false) goto L8;
        return r1.b();
    }

    private final String b() {
        String r2 = com.obric.event.task.base.c.a.f32688a.a("obric_event_task_experiment_config", "");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L6;
        com.obric.event.task.base.b.b.f32684a.b(TAG, "experiment setting missing, key=obric_event_task_experiment_config");
        return null;
    L6:
        return r2;
    }

    private final JSONObject a(String r4, boolean r5) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == true) goto L11;
        return new JSONObject(r4);
    L14:
        th = move-exception;
        com.obric.event.task.base.b.b.f32684a.b(TAG, "parse experiment config failed, rawLength=" + r4.length(), th);
        if (r5 == false) goto L23;
        a r7 = f32677b;
        if (r7 == null) goto L27;
        JSONObject r8 = r7.b();
        if (r8 == null) goto L27;
        return r8;
    L27:
        return new JSONObject();
    L23:
        return new JSONObject();
    L11:
        return new JSONObject();
    L5:
        if (d.o.o.d(r3) == true) goto L8;
        r6 = false;
        goto L9
    }
}
