package com.bytedance.android.annie.monitor.common.timing;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<String> f39619d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Long> f39620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f39621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f39622c;

    /* JADX INFO: renamed from: com.bytedance.android.annie.monitor.common.timing.a$a, reason: collision with other inner class name */
    public static final class C0736a {
        public static a a(JSONObject r110, a r111) {
            Intrinsics.checkNotNullParameter(r110, "data");
            LinkedHashMap r100 = new LinkedHashMap();
            LinkedHashMap r101 = new LinkedHashMap();
            Iterator<String> r102 = r110.keys();
            String r103 = null;
            if (r102 != null) goto L5;
        L18:
            String r112 = r110.optString("ttwebview_new_metrics");
            if (r112 == null) goto L22;
            r103 = r112;
        L22:
            if ((!r100.isEmpty()) == false) goto L24;
        L25:
            if (r111 != null) goto L27;
            r111 = new a();
        L27:
            r111.f39620a.putAll(r100);
            r111.f39621b.putAll(r101);
        L28:
            if (r103 == null) goto L32;
            if (r111 == null) goto L32;
            r111.f39622c = r103;
        L32:
            return r111;
        L24:
            if ((!r101.isEmpty()) == false) goto L28;
        L5:
            if (r102.hasNext() == false) goto L18;
            String r104 = r102.next();
            if (StringsKt.startsWith$default(r104, "tick_", false, 2, null) == false) goto L12;
            long r105 = r110.optLong(r104);
            if (r105 <= 0) goto L12;
            r100.put(r104, Long.valueOf(r105));
        L12:
            if (a.f39619d.contains(r104) == true) goto L15;
            if (StringsKt.startsWith$default(r104, "flag_", false, 2, null) == false) goto L5;
        L15:
            Object r106 = r110.opt(r104);
            if (r106 == null) goto L5;
            r101.put(r104, r106);
            goto L5
        }
    }

    static {
        f39619d = CollectionsKt.listOf(new String[]{"loadso", "webview_count_on_load", "webview_count_on_get", "net_error_code", "render_process_status_on_load_url", "render_process_status_on_get", "dur_render_block", "render_block_reason"});
    }

    public a() {
        this.f39620a = new LinkedHashMap();
        this.f39621b = new LinkedHashMap();
    }
}
