package com.bytedance.android.gamecp.common.track;

import android.os.SystemClock;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import wu.o;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f56779a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, a> f56780b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, String> f56781c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f56782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f56783b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f56784c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f56785d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f56786e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f56787f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f56788g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f56789h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f56790i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f56791j;

        public a() {
        }
    }

    static {
        f56779a = o.f561359a.getValue().d();
        f56780b = new LinkedHashMap();
        f56781c = new LinkedHashMap();
    }

    public static a b(String r100) {
        Map<String, a> r101 = f56780b;
        a r102 = (a) ((LinkedHashMap) r101).get(r100);
        if (r102 != null) goto L6;
        a r103 = new a();
        r101.put(r100, r103);
        return r103;
    L6:
        return r102;
    }

    public static Map a(int r100, String r101, String r110, String r111) {
        yr.c.a("GameTrackerForDownload", "getRouteTimeInfo:scene=" + r100 + ",roomId=" + r101 + ",videoId=" + r110 + ",gameId=" + r111);
        if (f56779a == false) goto L5;
        if (r100 == 0) goto L10;
        r101 = r110;
    L10:
        if (r101 != null) goto L12;
    L15:
        boolean r102 = true;
    L16:
        if (r102 == true) goto L44;
        if (r111 != null) goto L19;
    L22:
        boolean r103 = true;
    L23:
        if (r103 == true) goto L44;
        a r104 = (a) ((LinkedHashMap) f56780b).get(r101 + '_' + r111);
        if (r104 != null) goto L30;
        return new LinkedHashMap();
    L30:
        if (r104.f56782a == 0) goto L45;
        long r105 = SystemClock.elapsedRealtime();
        if (r104.f56783b == false) goto L36;
        r104.f56785d += r105 - r104.f56784c;
        r104.f56784c = r105;
    L36:
        if (r104.f56786e == false) goto L39;
        r104.f56788g += r105 - r104.f56787f;
        r104.f56787f = r105;
    L39:
        if (r104.f56789h == false) goto L42;
        r104.f56791j += r105 - r104.f56790i;
        r104.f56790i = r105;
    L42:
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("anchor_is_show", String.valueOf(false)), TuplesKt.to("anchor_duration", String.valueOf(0)), TuplesKt.to("room_is_show", String.valueOf(r104.f56783b)), TuplesKt.to("room_duration", String.valueOf(r104.f56785d)), TuplesKt.to("promote_is_show", String.valueOf(r104.f56786e)), TuplesKt.to("promote_duration", String.valueOf(r104.f56788g)), TuplesKt.to("detail_is_show", String.valueOf(r104.f56789h)), TuplesKt.to("detail_duration", String.valueOf(r104.f56791j))});
    L45:
        return new LinkedHashMap();
    L19:
        if (r111.length() == 0) goto L22;
        r103 = false;
    L44:
        return new LinkedHashMap();
    L12:
        if (r101.length() == 0) goto L15;
        r102 = false;
        goto L16
    L5:
        return new LinkedHashMap();
    }
}
