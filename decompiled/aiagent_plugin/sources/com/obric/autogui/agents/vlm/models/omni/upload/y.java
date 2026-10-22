package com.obric.autogui.agents.vlm.models.omni.upload;

import com.bytedance.keva.Keva;
import com.obric.autogui.common.api.logging.OmniDataFeedbackLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: OmniUploadTaskLifecycle.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class y {
    private static final String TAG = "OmniUploadLifecycleStore";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f28885a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Keva f28886b;

    /* JADX INFO: compiled from: OmniUploadTaskLifecycle.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f28885a = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ d.m lambda$kExqxMi2VC5S71fI5__wIq6je5w(y r0, JSONObject r1, String r2) {
        return a(r0, r1, r2);
    }

    public y(Keva r2) {
        d.h.b.o.e(r2, "keva");
        this.f28886b = r2;
    }

    public /* synthetic */ y(Keva r1, int r2, d.h.b.h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = Keva.getRepo("omni_upload_task_lifecycle_store", 0);
    L5:
        this(r1);
    }

    public final x a(String r2) {
        d.h.b.o.e(r2, DBDefinition.TASK_ID);
        x r1 = (x) ZeusTransformUtils.preCheckCast(c().get(r2), x.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        return x.f28880a;
    }

    public final void a(String r2, x r3) {
        d.h.b.o.e(r2, DBDefinition.TASK_ID);
        d.h.b.o.e(r3, "state");
        if (r3 != x.f28880a) goto L6;
        b(r2);
        return;
    L6:
        Map<String, ? extends x> r0 = ao.e(c());
        r0.put(r2, r3);
        a(r0);
    }

    public final void b(String r2) {
        d.h.b.o.e(r2, DBDefinition.TASK_ID);
        Map<String, ? extends x> r0 = ao.e(c());
        if (r0.remove(r2) == null) goto L6;
        a(r0);
        return;
    }

    public final Set<String> a() {
        Map<String, x> r5 = c();
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Map.Entry<String, x>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L12;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (((x) ZeusTransformUtils.preCheckCast(r1.getValue(), x.class, "com.obric.aiagent.plugin")) != x.f28883d) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
        r0.put(r1.getKey(), r1.getValue());
        goto L4
    L8:
        r2 = false;
        goto L9
    L12:
        return ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).keySet();
    }

    public final void b() {
        Map<String, x> r0 = c();
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator<Map.Entry<String, x>> r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L17;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin");
        x r6 = w.a((x) ZeusTransformUtils.preCheckCast(r4.getValue(), x.class, "com.obric.aiagent.plugin"));
        if (r6 != x.f28880a) goto L8;
        boolean r7 = true;
    L9:
        d.m r8 = null;
        if (r7 == false) goto L13;
        r6 = null;
    L13:
        if (r6 == null) goto L15;
        r8 = d.s.a(r5, r6);
    L15:
        if (r8 == null) goto L4;
        r1.add(r8);
        goto L4
    L8:
        r7 = false;
        goto L9
    L17:
        Map<String, ? extends x> r3 = ao.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
        if (d.h.b.o.a(r3, r0) == true) goto L26;
        a(r3);
        return;
    }

    private final Map<String, x> c() {
        CharSequence r0 = "{}";
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L12
        final y r4 = (y) ZeusTransformUtils.preCheckCast(this, y.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        String r3 = r4.f28886b.getString("task_states_v2", "{}");     // Catch: Throwable -> L12
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        if (d.o.o.d(r5) == true) goto L10;
        r0 = r5;
    L10:
        final JSONObject r6 = new JSONObject((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L12
        Iterator<String> r1 = r6.keys();     // Catch: Throwable -> L12
        d.h.b.o.c(r1, "keys(...)");     // Catch: Throwable -> L12
        Object r7 = d.n.f(ao.a(d.n.m.e(d.n.m.a(r1), new $$Lambda$y$kExqxMi2VC5S71fI5__wIq6je5w(r4, r6))));     // Catch: Throwable -> L12
    L14:
        Throwable r8 = d.n.c(r7);
        if (r8 == null) goto L19;
        OmniDataFeedbackLog.INSTANCE.e(TAG, "read lifecycle state failed", r8);
        r7 = ao.b();
    L19:
        return (Map) ZeusTransformUtils.preCheckCast(r7, Map.class, "com.obric.aiagent.plugin");
    L12:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;
        r7 = d.n.f(d.o.a(th));
        goto L14
    }

    private static final d.m a(y r1, JSONObject r2, String r3) {
        d.n.a r4 = d.n.f38560a;     // Catch: Throwable -> L4
        String r5 = r2.optString(r3, "UNKNOWN");     // Catch: Throwable -> L4
        d.h.b.o.c(r5, "optString(...)");     // Catch: Throwable -> L4
        Object r6 = d.n.f(x.valueOf(r5));     // Catch: Throwable -> L4
    L6:
        x r7 = x.f28880a;
        if (d.n.b(r6) == false) goto L9;
        r6 = r7;
    L9:
        x r8 = (x) ZeusTransformUtils.preCheckCast(r6, x.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r3);
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L13;
        r3 = null;
    L13:
        if (r3 != null) goto L15;
        return null;
    L15:
        return d.s.a(r3, r8);
    L4:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;
        r6 = d.n.f(d.o.a(th));
        goto L6
    }

    private final void a(Map<String, ? extends x> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L14
        y r6 = (y) ZeusTransformUtils.preCheckCast(this, y.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r8.isEmpty() == false) goto L7;
        r6.f28886b.erase("task_states_v2");     // Catch: Throwable -> L14
    L12:
        Object r9 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L14
    L16:
        Throwable r10 = d.n.c(r9);
        if (r10 == null) goto L23;
        OmniDataFeedbackLog.INSTANCE.e(TAG, "write lifecycle state failed", r10);
        return;
    L23:
        return;
    L7:
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L14
        Iterator r11 = ((Map) ZeusTransformUtils.preCheckCast(ao.b(r8), Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();     // Catch: Throwable -> L14
    L9:
        if (r11.hasNext() == false) goto L11;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        r1.put((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin"), ((x) ZeusTransformUtils.preCheckCast(r3.getValue(), x.class, "com.obric.aiagent.plugin")).name());     // Catch: Throwable -> L14
        goto L9
    L11:
        r6.f28886b.storeString("task_states_v2", r1.toString());     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        d.n.a r12 = d.n.f38560a;
        r9 = d.n.f(d.o.a(th));
        goto L16
    }
}
