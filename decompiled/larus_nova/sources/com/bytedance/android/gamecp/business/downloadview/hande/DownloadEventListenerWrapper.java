package com.bytedance.android.gamecp.business.downloadview.hande;

import android.os.SystemClock;
import com.bytedance.android.gamecp.base.core.service.depend.n;
import com.bytedance.android.gamecp.business.download.p;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class DownloadEventListenerWrapper extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f53051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f53052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f53053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f53054e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f53055f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p f53056g;

    public final HashMap<String, String> b(String r100) {
        HashMap<String, String> r101 = new HashMap();
        r101.put("event_scene", r100);
        r101.put("game_id", this.f53056g.f52855k);
        r101.put(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_SCENE, String.valueOf(this.f53056g.f52859m));
        r101.put("anchor_id", this.f53056g.f52849h);
        r101.put("room_id", this.f53056g.f52851i);
        r101.put("video_id", this.f53056g.f52869r);
        r101.put(AudienceGamePromoteDetailActionHandler.PROMOTE_INSTANCE_ID, this.f53056g.U);
        r101.put("enter_from_host", this.f53056g.f52863o);
        r101.put("enter_from", this.f53056g.f52861n);
        r101.put("page", this.f53056g.f52845f);
        r101.put("start_page", this.f53056g.f52847g);
        return r101;
    }

    @Override // com.bytedance.android.gamecp.business.downloadview.hande.a, com.bytedance.android.gamecp.base.core.service.depend.n
    public final void passThrough(int r110) {
        super.passThrough(r110);
        if (this.f53053d.compareAndSet(false, true) == false) goto L5;
        HashMap<String, String> r100 = b("download_btn_show");
        r100.put("download_state", String.valueOf(r110));
        r100.put("duration", String.valueOf(SystemClock.elapsedRealtime() - this.f53051b));
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3("dygame_technology_duration", r100);
    L5:
        Integer r101 = this.f53055f;
        if (r101 != null) goto L8;
        return;
    L8:
        if (this.f53054e == false) goto L26;
        if (r101 != null) goto L12;
    L19:
        this.f53054e = false;
        Integer r102 = this.f53055f;
        Intrinsics.checkNotNull(r102);
        int r103 = r102.intValue();
        if (this.f53052c != 0) goto L22;
        long r104 = -1;
    L23:
        HashMap<String, String> r105 = b("download_btn_click");
        r105.put("dest_state", String.valueOf(r103));
        r105.put("target_state", String.valueOf(r110));
        r105.put("click_intercept", "0");
        r105.put("duration", String.valueOf(r104));
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3("dygame_technology_duration", r105);
        return;
    L22:
        r104 = SystemClock.elapsedRealtime() - this.f53052c;
        goto L23
    L12:
        if (r101.intValue() != r110) goto L19;
        Integer r106 = this.f53055f;
        if (r106 == null) goto L19;
        if (r106.intValue() != 1) goto L19;
        return;
    }

    public DownloadEventListenerWrapper(p r100, n r101) {
        Intrinsics.checkNotNullParameter(r100, "downloadInfo");
        super(r101);
        this.f53056g = r100;
        this.f53051b = SystemClock.elapsedRealtime();
        this.f53053d = new AtomicBoolean(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Function2<Boolean, Pair<Integer, String>, Unit> a(final Integer r100, final Function2<? super Boolean, ? super Pair<Integer, String>, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (r100 != null) goto L6;
        return r101;
    L6:
        if (this.f53054e == true) goto L9;
        this.f53054e = true;
        this.f53055f = r100;
        this.f53052c = SystemClock.elapsedRealtime();
        return new DownloadEventListenerWrapper$getCallback$1(this, r101, r100);
    L9:
        c(r100.intValue(), -1, "no last response", 0);
        return r101;
    }

    public final void c(int r100, int r101, String r102, long r103) {
        HashMap<String, String> r104 = b("download_btn_click");
        r104.put("dest_state", String.valueOf(r100));
        r104.put("errorCode", String.valueOf(r101));
        r104.put("errorMsg", r102);
        r104.put("duration", String.valueOf(r103));
        r104.put("click_intercept", "1");
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3("dygame_technology_duration", r104);
    }
}
