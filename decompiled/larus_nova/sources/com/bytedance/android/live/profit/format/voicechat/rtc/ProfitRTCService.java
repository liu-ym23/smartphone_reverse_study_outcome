package com.bytedance.android.live.profit.format.voicechat.rtc;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.scope.o;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class ProfitRTCService implements b, o {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f87677i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f87678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<com.bytedance.android.live.profit.format.voicechat.rtc.a> f87679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f87680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet<String> f87681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f87682e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ku0.c f87683f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f87684g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f87685h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.rtc.b
    public final void stopAndRelease() {
        this.f87680c = false;
        this.f87679b.clear();
        ku0.c r100 = this.f87683f;
        if (r100 == null) goto L5;
        r100.b();
    L5:
        this.f87683f = null;
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.rtc.b
    public final void f() {
        if (this.f87680c == true) goto L14;
        ku0.c r100 = this.f87683f;
        if (r100 == null) goto L12;
        ALogger.i("ProfitRTCEngine", "publishStream");
        ku0.a r101 = r100.f506179d;
        if (r101 == null) goto L10;
        r101.c();
    L10:
        if (r100.f506176a == true) goto L12;
        r100.f506176a = true;
        ALogger.i("ProfitRTCEngine", "updateLocalAudioCaptureStatus:true");
    L12:
        this.f87680c = true;
        return;
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.rtc.b
    public final void g() {
        if (this.f87680c == false) goto L14;
        ku0.c r100 = this.f87683f;
        if (r100 == null) goto L12;
        ALogger.i("ProfitRTCEngine", "unpublishStream");
        ku0.a r101 = r100.f506179d;
        if (r101 == null) goto L10;
        r101.c();
    L10:
        if (r100.f506176a == false) goto L12;
        r100.f506176a = false;
        ALogger.i("ProfitRTCEngine", "updateLocalAudioCaptureStatus:false");
    L12:
        this.f87680c = false;
        return;
    }

    public ProfitRTCService() {
        this.f87678a = "";
        this.f87679b = new CopyOnWriteArrayList();
        this.f87681d = new HashSet();
        this.f87684g = LazyKt.lazy(new ProfitRTCService$rtcEngineEventListener$2(this));
        this.f87685h = LazyKt.lazy(new ProfitRTCService$rtcRoomListener$2(this));
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.rtc.b
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        if (this.f87683f == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "content");
        return;
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.rtc.b
    public final void h(hu0.a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listerner");
        this.f87679b.add(r100);
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.rtc.b
    public final void d(Context r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r2.a(r104) == false) goto L8;
        if (r104 != null) goto L6;
        String r107 = "";
    L7:
        this.f87678a = r107;
        goto L8
    L6:
        r107 = r104;
    L8:
        this.f87683f = new ku0.c(r100, (ku0.a) this.f87684g.getValue(), (ku0.b) this.f87685h.getValue());
        lu0.a r108 = new lu0.a();
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        ku0.c r109 = this.f87683f;
        if (r109 == null) goto L15;
        r109.a(r108);
        return;
    }
}
