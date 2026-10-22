package com.bytedance.android.shopping.anchorv3.detail.widget.playerblock;

import com.bytedance.android.ec.model.response.ECPDPBaseVideo;
import com.bytedance.android.ec.model.response.g0;
import com.bytedance.android.ec.model.response.u1;
import com.bytedance.android.ec.model.video.UrlModel;
import com.bytedance.android.ec.sdk.ECSdk;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f164968f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f164969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fj.d f164970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ECPDPBaseVideo f164971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fj.f f164972d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PlayerViewScene f164973e;

    public static final class a {
    }

    static {
        if (com.bytedance.android.ec.core.opt.ab.c.f() == 1) goto L6;
        com.bytedance.android.ec.core.opt.ab.c.f();
        return;
    }

    public final Map<String, Object> g() {
        fj.d r100 = this.f164970b;
        if (r100 == null) goto L5;
        Object r101 = r100.f477450q;
    L7:
        if ((r101 instanceof u1) == true) goto L9;
        r101 = null;
    L9:
        u1 r102 = (u1) r101;
        if (r102 == null) goto L15;
        g0 r103 = r102.b();
        if (r103 != null) goto L14;
        return null;
    L14:
        return r103.a();
    L15:
        return null;
    L5:
        r101 = null;
        goto L7
    }

    public final Boolean i() {
        fj.d r100 = this.f164970b;
        if (r100 == null) goto L5;
        Object r101 = r100.f477450q;
    L7:
        if ((r101 instanceof u1) == true) goto L9;
        r101 = null;
    L9:
        u1 r102 = (u1) r101;
        if (r102 == null) goto L16;
        g0 r103 = r102.b();
        if (r103 != null) goto L14;
        return null;
    L14:
        return r103.b();
    L16:
        return Boolean.FALSE;
    L5:
        r101 = null;
        goto L7
    }

    public final boolean p() {
        int r100 = ECSdk.f48106a;
        s83.g r101 = (s83.g) ECSdk.a(s83.g.class);
        if (r101 == null) goto L9;
        s83.f r102 = r101.p();
        if (r102 == null) goto L10;
        r102.i();
        return false;
    L10:
        return false;
    L9:
        return false;
    }

    public final long a() {
        if (p() == false) goto L7;
        ECPDPBaseVideo r100 = this.f164971c;
        if (r100 != null) goto L12;
        return 0;
    L12:
        return r100.getDuration();
    L7:
        fj.d r101 = this.f164970b;
        if (r101 != null) goto L10;
        return 0;
    L10:
        return r101.f477439f;
    }

    public final u1 b() {
        Object r100 = null;
        if (p() == false) goto L10;
        ECPDPBaseVideo r101 = this.f164971c;
        if (r101 == null) goto L7;
        u1 r102 = r101.getExtraInfo();
    L8:
        if (r102 == null) goto L10;
        return this.f164971c.getExtraInfo();
    L7:
        r102 = null;
    L10:
        fj.d r103 = this.f164970b;
        if (r103 == null) goto L13;
        Object r104 = r103.f477450q;
    L15:
        if ((r104 instanceof u1) == false) goto L19;
        r100 = r104;
    L19:
        return (u1) r100;
    L13:
        r104 = null;
        goto L15
    }

    public final Integer c() {
        if (p() == false) goto L7;
        ECPDPBaseVideo r100 = this.f164971c;
        if (r100 != null) goto L12;
        return null;
    L12:
        return Integer.valueOf(r100.getHeight());
    L7:
        fj.d r101 = this.f164970b;
        if (r101 != null) goto L10;
        return null;
    L10:
        return Integer.valueOf((int) r101.f477438e);
    }

    public final String e() {
        String r100 = null;
        if (p() == false) goto L13;
        ECPDPBaseVideo r101 = this.f164971c;
        if (r101 == null) goto L11;
        UrlModel r102 = r101.getPlayAddr();
        if (r102 == null) goto L11;
        List<String> r103 = r102.getUrlList();
        if (r103 == null) goto L11;
        r100 = (String) CollectionsKt.firstOrNull(r103);
    L11:
        if (r100 != null) goto L19;
        return "";
    L19:
        return r100;
    L13:
        fj.d r104 = this.f164970b;
        if (r104 == null) goto L16;
        r100 = r104.f477434a;
    L16:
        if (r100 != null) goto L19;
        return "";
    }

    public final String f() {
        if (p() == false) goto L11;
        ECPDPBaseVideo r100 = this.f164971c;
        if (r100 == null) goto L15;
        UrlModel r101 = r100.getCover();
        if (r101 == null) goto L16;
        List<String> r102 = r101.getUrlList();
        if (r102 != null) goto L18;
        return null;
    L18:
        return (String) CollectionsKt.firstOrNull(r102);
    L16:
        return null;
    L15:
        return null;
    L11:
        fj.d r103 = this.f164970b;
        if (r103 != null) goto L14;
        return null;
    L14:
        return r103.f477440g;
    }

    public final Integer h() {
        if (p() == true) goto L10;
        fj.d r100 = this.f164970b;
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.f477446m;
    L10:
        return null;
    }

    public final String j() {
        if (p() == false) goto L7;
        ECPDPBaseVideo r100 = this.f164971c;
        if (r100 != null) goto L12;
        return null;
    L12:
        return r100.getVideoId();
    L7:
        fj.d r101 = this.f164970b;
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.f477436c;
    }

    public final Integer l() {
        if (p() == false) goto L7;
        ECPDPBaseVideo r100 = this.f164971c;
        if (r100 != null) goto L12;
        return null;
    L12:
        return Integer.valueOf(r100.getWidth());
    L7:
        fj.d r101 = this.f164970b;
        if (r101 != null) goto L10;
        return null;
    L10:
        return Integer.valueOf((int) r101.f477437d);
    }

    public final boolean m() {
        if (p() == false) goto L7;
        ECPDPBaseVideo r100 = this.f164971c;
        if (r100 != null) goto L12;
        return false;
    L12:
        return r100.getAutoPlay();
    L7:
        fj.d r101 = this.f164970b;
        if (r101 != null) goto L10;
        return false;
    L10:
        return r101.f477441h;
    }

    public final boolean n() {
        if (p() == false) goto L7;
        ECPDPBaseVideo r100 = this.f164971c;
        if (r100 != null) goto L12;
        return true;
    L12:
        return r100.isMute();
    L7:
        fj.d r101 = this.f164970b;
        if (r101 != null) goto L10;
        return true;
    L10:
        return r101.f477442i;
    }

    public static String d(b r100) {
        r100.p();
        fj.d r101 = r100.f164970b;
        if (r101 == null) goto L5;
        String r102 = r101.f477449p;
    L6:
        if (r102 != null) goto L9;
        return "";
    L9:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public final String k(String r100) {
        Integer r101 = l();
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L6:
        Integer r103 = c();
        if (r103 == null) goto L9;
        int r104 = r103.intValue();
    L10:
        String r105 = "others";
        if (r104 == 0) goto L25;
        float r106 = r102 / r104;
        if (r106 != 1.0f) goto L17;
        r105 = com.bytedance.android.ec.core.event.a.VALUE_MAIN_PIC_SQUARE;
        goto L25
    L17:
        if (r106 != 0.75f) goto L20;
        r105 = com.bytedance.android.ec.core.event.a.VALUE_MAIN_PIC_THREE_QUARTERS;
        goto L25
    L20:
        if (r106 != 1.7777778f) goto L23;
        r105 = "16_9";
        goto L25
    L23:
        if (r106 != 0.5625f) goto L25;
        r105 = "9_16";
    L25:
        if (r100 == null) goto L27;
        fj.d.f477433s.getClass();
        fj.d.f477432r.put(r100, r105);
    L27:
        return r105;
    L9:
        r104 = 1;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final void o(long r100) {
        fj.d r101 = this.f164970b;
        if (r101 == null) goto L5;
        r101.f477448o = r100;
    L5:
        ECPDPBaseVideo r102 = this.f164971c;
        if (r102 == null) goto L9;
        r102.setInitialStartTimeMs(r100);
        return;
    }

    public b(fj.d r100, ECPDPBaseVideo r101, fj.f r102, PlayerViewScene r103) {
        Intrinsics.checkNotNullParameter(r103, "scene");
        this.f164970b = r100;
        this.f164971c = r101;
        this.f164972d = r102;
        this.f164973e = r103;
    }
}
