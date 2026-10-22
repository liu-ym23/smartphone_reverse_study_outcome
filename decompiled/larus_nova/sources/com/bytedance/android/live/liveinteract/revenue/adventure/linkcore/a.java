package com.bytedance.android.live.liveinteract.revenue.adventure.linkcore;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.ILiveWrappedRtcService;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedMediaStreamType;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import uf2.h0;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f77913l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m00.g f77914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ei6.a f77915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public mi6.b f77916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ci0.a f77917d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f77918e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f77919f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f77920g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public l f77921h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public k f77922i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f77923j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Set<String> f77924k;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a$a, reason: collision with other inner class name */
    public static final class C1201a {
    }

    public static final class b implements h0.c {
        public b(a r100) {
        }
    }

    static {
    }

    public final void c() {
        ALogger.i("AdventureLinkEngine", "destroyEngine");
        mi6.b r100 = this.f77916c;
        if (r100 == null) goto L5;
        r100.destroy();
    L5:
        this.f77916c = null;
        ILiveWrappedRtcService.Companion.getClass();
        ILiveWrappedRtcService.a.a().destroyRTCEngine();
        m00.g r101 = this.f77914a;
        if (r101 == null) goto L10;
        com.bytedance.android.live.pushstream.d r102 = r101.getLiveStream();
        if (r102 == null) goto L10;
        r102.release();
    L10:
        this.f77914a = null;
        this.f77915b = null;
        this.f77918e = false;
        this.f77919f = false;
    }

    public final void d() {
        Iterator<String> r100 = this.f77924k.iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        String r101 = r100.next();
        ei6.a r102 = this.f77915b;
        if (r102 == null) goto L4;
        gi6.e r103 = r102.getEventManager();
        if (r103 == null) goto L4;
        r103.c(r101);
        goto L4
    L10:
        this.f77924k.clear();
    }

    public final void e() {
        ALogger.i("AdventureLinkEngine", "pause");
        if (this.f77918e == false) goto L21;
        ALogger.i("AdventureLinkEngine", "pause start");
        m00.g r100 = this.f77914a;
        if (r100 == null) goto L9;
        com.bytedance.android.live.pushstream.d r101 = r100.getLiveStream();
        if (r101 == null) goto L9;
        r101.Q0(true, LiveCommonConstants.REASON_ADVENTURE_BACKGROUND_PAUSE, new uv0.a(LiveRequestSourceRole.Business, "AdventureLinkEngine.pause.setAudioMute", null));
    L9:
        m00.g r102 = this.f77914a;
        if (r102 == null) goto L14;
        com.bytedance.android.live.pushstream.d r103 = r102.getLiveStream();
        if (r103 == null) goto L14;
        r103.J0(LiveCommonConstants.REASON_ADVENTURE_BACKGROUND_PAUSE, new uv0.a(LiveRequestSourceRole.Business, "AdventureLinkEngine.pauseBackground", null));
    L14:
        mi6.b r104 = this.f77916c;
        if (r104 == null) goto L17;
        r104.e();
    L17:
        k r105 = this.f77922i;
        if (r105 == null) goto L22;
        r105.a(false);
        return;
    L22:
        return;
    }

    public final void f() {
        g.b r100 = g.f77943j;
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f77922i = r100;
    }

    public final void g() {
        g.c r100 = g.f77942i;
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f77921h = r100;
    }

    public final void h() {
        ALogger.i("AdventureLinkEngine", "resume");
        if (this.f77918e == false) goto L21;
        ALogger.i("AdventureLinkEngine", "resume start");
        m00.g r100 = this.f77914a;
        if (r100 == null) goto L9;
        com.bytedance.android.live.pushstream.d r101 = r100.getLiveStream();
        if (r101 == null) goto L9;
        r101.q1(LiveCommonConstants.REASON_ADVENTURE_BACKGROUND_RESUME, new uv0.a(LiveRequestSourceRole.Business, "AdventureLinkEngine.resumeBackground", null));
    L9:
        m00.g r102 = this.f77914a;
        if (r102 == null) goto L14;
        com.bytedance.android.live.pushstream.d r103 = r102.getLiveStream();
        if (r103 == null) goto L14;
        r103.Q0(false, LiveCommonConstants.REASON_ADVENTURE_BACKGROUND_RESUME, new uv0.a(LiveRequestSourceRole.Business, "AdventureLinkEngine.resume.setAudioMute", null));
    L14:
        mi6.b r104 = this.f77916c;
        if (r104 == null) goto L17;
        r104.e();
    L17:
        k r105 = this.f77922i;
        if (r105 == null) goto L22;
        r105.a(true);
        return;
    L22:
        return;
    }

    public a() {
        this.f77920g = true;
        this.f77923j = new b(this);
        this.f77924k = new LinkedHashSet();
    }

    public static final void a(a r100, String r101, LiveWrappedMediaStreamType r102) {
        r100.getClass();
        StringBuilder r103 = new StringBuilder("onUserPublishStream, uid: ");
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r103.append(r101);
        r103.append(", type: ");
        r103.append(r102);
        ALogger.i("AdventureLinkEngine", r103.toString());
    }

    public static final void b(a r100, String r101, LiveWrappedMediaStreamType r102) {
        r100.getClass();
        ALogger.i("AdventureLinkEngine", "onUserUnpublishStream, uid: " + r101 + ", type: " + r102 + ", reason: null");
    }
}
