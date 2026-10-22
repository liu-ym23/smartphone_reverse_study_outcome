package com.bytedance.android.shopping.collect.monitor.error;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.utils.x0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.instruction.monitor.SuggestPromptErrorType;
import com.ss.ttvideoengine.model.VideoRef;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, a> f172238b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f172239a;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.collect.monitor.error.a$a, reason: collision with other inner class name */
    public static final class C2585a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f172240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CollectErrorMonitorType f172241b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f172242c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f172243d;

        public b(a r100, CollectErrorMonitorType r101, String r102, JSONObject r103) {
            this.f172240a = r100;
            this.f172241b = r101;
            this.f172242c = r102;
            this.f172243d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r100 = this.f172240a;     // Catch: Throwable -> L4
            String r101 = this.f172241b.getValue();     // Catch: Throwable -> L4
            String r102 = this.f172242c;     // Catch: Throwable -> L4
            JSONObject r103 = this.f172243d;     // Catch: Throwable -> L4
            r100.getClass();     // Catch: Throwable -> L4
            a.a(r101, r102, r103);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f172238b = new LinkedHashMap();
    }

    public a(JSONObject r100) {
        this.f172239a = r100;
    }

    public static void a(String r100, String r101, JSONObject r110) {
        ECProcessMonitor.l("yata_collect_or_ultimate", r100, r101, r110, null, null, null, VideoRef.VALUE_VIDEO_REF_CODEC_HAS_BYTEVC2);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        ECExceptionMonitor.e(e);
        int r102 = ECMonitorService.f45110b;
        JSONObject r103 = new JSONObject();
        r103.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        r103.put("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
        r103.put("error_type", SuggestPromptErrorType.ERROR_TYPE_CRASH);
        JSONObject r111 = new JSONObject();
        r111.put("error_msg", e.getMessage());
        Unit r104 = Unit.INSTANCE;
        r103.put("extra", r111);
        ECMonitorService.a.a("collect_error_monitor", r103, null, null);
    }

    public final void b(CollectErrorMonitorType r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "errorType");
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        JSONObject r103 = x0.a(this.f172239a);
        r103.put("error_type", r100.getValue());
        r103.put("error_msg", r101);
        r103.put("extra", r102);
        int r104 = ECMonitorService.f45110b;
        ECMonitorService.a.a("collect_error_monitor", r103, null, null);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        a(r100.getValue(), r101, r103);
        return;
    L5:
        new Handler(Looper.getMainLooper()).post(new b(this, r100, r101, r103));
    }
}
