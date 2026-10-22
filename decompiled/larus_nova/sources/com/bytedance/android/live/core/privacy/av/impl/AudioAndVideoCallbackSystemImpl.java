package com.bytedance.android.live.core.privacy.av.impl;

import android.os.Handler;
import android.util.Log;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.privacy.av.api.AudioAndVideoException;
import com.bytedance.android.live.core.privacy.av.api.PrivacyConfig;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class AudioAndVideoCallbackSystemImpl implements com.bytedance.android.live.core.privacy.av.api.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f65145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f65146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PrivacyConfig f65147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.live.core.privacy.av.api.h f65148e;

    public static final class a {
    }

    static {
    }

    public AudioAndVideoCallbackSystemImpl(PrivacyConfig r100, com.bytedance.android.live.core.privacy.av.api.h r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "logger");
        this.f65147d = r100;
        this.f65148e = r101;
        this.f65146c = LazyKt.lazy(AudioAndVideoCallbackSystemImpl$mainHandler$2.INSTANCE);
    }

    public static void e(String r100, String r101, String r102, String r103, Map r104) {
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L17
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L17
        r106.put("status", r100);     // Catch: Throwable -> L17
        r106.put("biz", r101);     // Catch: Throwable -> L17
        r106.put("sense", r102);     // Catch: Throwable -> L17
        r106.put("type", r103);     // Catch: Throwable -> L17
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L17
        Iterator r108 = r104.entrySet().iterator();     // Catch: Throwable -> L17
    L4:
        if (r108.hasNext() == false) goto L6;
        Map.Entry r109 = (Map.Entry) r108.next();     // Catch: Throwable -> L17
        r107.put((String) r109.getKey(), r109.getValue());     // Catch: Throwable -> L17
        goto L4
    L6:
        LiveTracingMonitor.i("ttlive_audio_and_video_check_all", r106, null, r107);     // Catch: Throwable -> L17
        if (Intrinsics.areEqual(r100, "error") == true) goto L9;
    L15:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
        return;
    L9:
        if (Intrinsics.areEqual(r101, "common") == false) goto L14;
        Iterator r110 = r104.entrySet().iterator();     // Catch: Throwable -> L17
    L12:
        if (r110.hasNext() == false) goto L14;
        Map.Entry r111 = (Map.Entry) r110.next();     // Catch: Throwable -> L17
        r106.put((String) r111.getKey(), r111.getValue());     // Catch: Throwable -> L17
    L14:
        LiveTracingMonitor.i("ttlive_audio_and_video_check_failed", r106, null, r107);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.b
    public final void b(String r110, String r111, String r112, Map<String, String> r113, com.bytedance.android.live.core.privacy.av.api.a r114) {
        Intrinsics.checkNotNullParameter(r110, "biz");
        Intrinsics.checkNotNullParameter(r111, "sense");
        Intrinsics.checkNotNullParameter(r112, "type");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r114, "ensureConfig");
        this.f65148e.a("onStart# seq=" + r114.f65133a + ", biz=" + r110 + ", sense=" + r111 + ", type=" + r112);
        if (this.f65147d.h() == false) goto L10;
        List<String> r115 = this.f65147d.d();
        if (r115 != null) goto L7;
        return;
    L7:
        if (r115.contains("trigger_detection") != true) goto L12;
        this.f65148e.c(new com.bytedance.android.live.core.privacy.av.api.i("trigger_detection", "start", 0, r112.concat("-start"), r110, r111, r112, r113));
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.b
    public final void c(String r110, String r111, String r112, Map<String, String> r113, com.bytedance.android.live.core.privacy.av.api.a r114) {
        Intrinsics.checkNotNullParameter(r110, "biz");
        Intrinsics.checkNotNullParameter(r111, "sense");
        Intrinsics.checkNotNullParameter(r112, "type");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r114, "ensureConfig");
        this.f65148e.a("onCancel# seq=" + r114.f65133a + ", biz=" + r110 + ", sense=" + r111 + ", type=" + r112);
        e("cancel", r110, r111, r112, r113);
        if (this.f65147d.h() == false) goto L10;
        List<String> r115 = this.f65147d.d();
        if (r115 != null) goto L7;
        return;
    L7:
        if (r115.contains("trigger_detection") != true) goto L12;
        this.f65148e.c(new com.bytedance.android.live.core.privacy.av.api.i("trigger_detection", "cancel", -1, r112.concat("-cancel"), r110, r111, r112, r113));
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.b
    public final void d(String r110, String r111, String r112, Map<String, String> r113, com.bytedance.android.live.core.privacy.av.api.a r114) {
        Intrinsics.checkNotNullParameter(r110, "biz");
        Intrinsics.checkNotNullParameter(r111, "sense");
        Intrinsics.checkNotNullParameter(r112, "type");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r114, "ensureConfig");
        this.f65148e.a("trackSuccess# seq=" + r114.f65133a + ", biz=" + r110 + ", sense=" + r111 + ", type=" + r112);
        e("success", r110, r111, r112, r113);
        if (this.f65147d.h() == false) goto L10;
        List<String> r115 = this.f65147d.d();
        if (r115 != null) goto L7;
        return;
    L7:
        if (r115.contains("trigger_detection") != true) goto L12;
        this.f65148e.c(new com.bytedance.android.live.core.privacy.av.api.i("trigger_detection", "success", 0, r112.concat("-success"), r110, r111, r112, r113));
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.b
    public final void a(String r110, String r111, String r112, Map r113, com.bytedance.android.live.core.privacy.av.api.a r210, AudioAndVideoException r211) {
        Intrinsics.checkNotNullParameter(r110, "biz");
        Intrinsics.checkNotNullParameter(r111, "sense");
        Intrinsics.checkNotNullParameter(r112, "type");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r210, "ensureConfig");
        Intrinsics.checkNotNullParameter(r211, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        this.f65148e.b("trackError# seq=" + r210.f65133a + ", biz=" + r110 + ", sense=" + r111 + ", type=" + r112 + ", e=" + r211, null);
        e("error", r110, r111, r112, r113);
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L39
        if (this.f65147d.g() == false) goto L33;
        if (Intrinsics.areEqual(r110, "common") == true) goto L9;
        com.bytedance.crash.d.e(r211, r110 + '-' + r111 + '-' + r112 + " check failed", r113);     // Catch: Throwable -> L39
        goto L33
    L9:
        if (r113.isEmpty() == true) goto L29;
        StringBuilder r101 = new StringBuilder();     // Catch: Throwable -> L39
        Iterator r114 = r113.entrySet().iterator();     // Catch: Throwable -> L39
    L12:
        if (r114.hasNext() == false) goto L28;
        Map.Entry r115 = (Map.Entry) r114.next();     // Catch: Throwable -> L39
        CharSequence r116 = (CharSequence) r115.getKey();     // Catch: Throwable -> L39
        boolean r117 = false;
        if (r116 != null) goto L16;
    L19:
        boolean r118 = true;
    L20:
        if (r118 == true) goto L12;
        CharSequence r119 = (CharSequence) r115.getValue();     // Catch: Throwable -> L39
        if (r119 != null) goto L24;
    L25:
        r117 = true;
    L26:
        if (r117 == true) goto L12;
        r101.append("-");     // Catch: Throwable -> L39
        r101.append((String) r115.getKey());     // Catch: Throwable -> L39
        r101.append(":");     // Catch: Throwable -> L39
        r101.append((String) r115.getValue());     // Catch: Throwable -> L39
        goto L12
    L24:
        if (StringsKt.isBlank(r119) == false) goto L26;
    L16:
        if (StringsKt.isBlank(r116) == true) goto L19;
        r118 = false;
        goto L20
    L28:
        String r102 = r101.toString();     // Catch: Throwable -> L39
    L30:
        com.bytedance.crash.d.e(r211, r110 + '-' + r111 + '-' + r112 + r102 + " check failed", r113);     // Catch: Throwable -> L39
        goto L33
    L29:
        r102 = "";
    L33:
        if (this.f65147d.f() == true) goto L35;
    L37:
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L39
    L41:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L45;
        this.f65148e.b("upload monitor failed:" + r104.getMessage(), null);
    L45:
        if (this.f65147d.h() == false) goto L61;
        List<String> r105 = this.f65147d.d();
        if (r105 != null) goto L49;
        return;
    L49:
        if (r105.contains("trigger_detection") != true) goto L63;
        this.f65148e.c(new com.bytedance.android.live.core.privacy.av.api.i("trigger_detection", "error", 1, r112 + "-error-" + Log.getStackTraceString(r211), r110, r111, r112, r113));
        return;
    L63:
        return;
    L61:
        return;
    L35:
        if (this.f65145b == true) goto L37;
        ((Handler) this.f65146c.getValue()).postDelayed(new com.bytedance.android.live.core.privacy.av.impl.a(this, r110, r113, r111), this.f65147d.b());     // Catch: Throwable -> L39
        this.f65145b = true;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L41
    }
}
