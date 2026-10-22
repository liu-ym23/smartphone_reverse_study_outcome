package com.bytedance.ai.utils;

import androidx.collection.LruCache;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class k implements k5.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j.a f37674a;

    public k(j.a r100) {
        this.f37674a = r100;
    }

    @Override // k5.j
    public final void a(AppletMonitorableEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        r100.f(MusicAppletPage.KEY_MESSAGE_ID, String.valueOf(this.f37674a.f37641a));
        r100.f("questionId", String.valueOf(this.f37674a.f37642b));
        String r101 = this.f37674a.f37643c;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.f("apiName", r101);
        String r102 = this.f37674a.f37644d;
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        r100.f("applet_id", r102);
        r100.e(MessageIndication.STATUS_RECEIVED, this.f37674a.f37646f);
        r100.d("sendAckTimes", this.f37674a.f37648h);
        r100.g("sendAckSucceed", Intrinsics.areEqual(this.f37674a.f37649i, j.b.d.f37668c));
        r100.d("errorCode", this.f37674a.f37649i.f37664a);
        r100.f("errorMsg", this.f37674a.f37649i.a());
        j.a r103 = this.f37674a;
        Iterator<T> r104 = r103.f37663w.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        j.c r105 = (j.c) r104.next();
        String r106 = r105.f37671b;
        LruCache<Long, j.a> r107 = j.f37639a;
        r100.e(r106, j.a(r105.f37673d, Long.valueOf(r103.f37646f)));
        goto L10
    L12:
        LruCache<Long, j.a> r108 = j.f37639a;
        j.a r109 = this.f37674a;
        monitor-enter(r109);
        Map<String, Object> r110 = r109.f37647g;     // Catch: Throwable -> L51
        Map r111 = null;
        if (r110 == null) goto L18;
        Map r112 = MapsKt.toMap(r110);     // Catch: Throwable -> L51
    L19:
        monitor-exit(r109);
        if (r112 == null) goto L34;
        Map r113 = MapsKt.toMutableMap(r112);
        if (r113 == null) goto L34;
        if (r113.containsKey("client_tool_result_success") == true) goto L33;
        r113.put("client_tool_result_success", 0);
        if (r113.containsKey("client_tool_failure_reason") == true) goto L33;
        r113.put("client_tool_failure_stage", "execute");
        if (r109.f37649i.f37664a != 101) goto L31;
        String r114 = "outer_timeout";
    L32:
        r113.put("client_tool_failure_reason", r114);
        goto L33
    L31:
        r114 = "pipeline_error";
    L33:
        r111 = r113;
    L34:
        if (r111 == null) goto L50;
        Iterator r115 = r111.entrySet().iterator();
    L37:
        if (r115.hasNext() == false) goto L71;
        Map.Entry r116 = (Map.Entry) r115.next();
        String r117 = (String) r116.getKey();
        Object r118 = r116.getValue();
        if ((r118 instanceof String) == true) goto L40;
        if ((r118 instanceof Integer) == true) goto L43;
        if ((r118 instanceof Long) == true) goto L46;
        if ((r118 instanceof Boolean) == false) goto L37;
        r100.g(r117, ((Boolean) r118).booleanValue());
        goto L37
    L46:
        r100.e(r117, ((Number) r118).longValue());
        goto L37
    L43:
        r100.d(r117, ((Number) r118).intValue());
        goto L37
    L40:
        r100.f(r117, (String) r118);
        goto L37
    L71:
        return;
    L50:
        return;
    L18:
        r112 = null;
    L51:
        th = move-exception;
        throw th;
    }
}
