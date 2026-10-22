package com.bytedance.android.live.ktv.common.karaokestation.model;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<y> f69576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y f69577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f69578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f69579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, String> f69580e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a0 f69581f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f69582g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<MusicPanel> f69583h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<Object> f69584i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f69585j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f69586k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f69587l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f69588m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f69589n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f69590o;

    public y() {
        this(0, 0, 65535);
    }

    public final boolean a() {
        ArrayList<y> r100 = this.f69576a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if ((!r100.isEmpty()) != true) goto L7;
        return true;
    }

    public y(int r100, int r110, int r111) {
        String r101 = "";
        if ((r111 & 1) == 0) goto L5;
        String r102 = "";
    L7:
        if ((r111 & 2) != 0) goto L11;
        r101 = null;
    L11:
        if ((r111 & 16) == 0) goto L13;
        a0 r103 = new a0();
    L15:
        if ((r111 & 128) == 0) goto L17;
        ArrayList r104 = new ArrayList();
    L19:
        if ((r111 & 256) == 0) goto L21;
        ArrayList r105 = new ArrayList();
    L23:
        if ((r111 & 1024) == 0) goto L26;
        r100 = FirstLevelTab.Unknown.getValue();
    L26:
        if ((r111 & 2048) == 0) goto L28;
        boolean r106 = true;
    L30:
        if ((r111 & 16384) == 0) goto L32;
        r110 = 0;
    L32:
        Intrinsics.checkNotNullParameter(r102, "name");
        Intrinsics.checkNotNullParameter(r101, "description");
        Intrinsics.checkNotNullParameter(r103, "titleFont");
        Intrinsics.checkNotNullParameter(r104, "musicList");
        Intrinsics.checkNotNullParameter(r105, "businessDataList");
        this.f69578c = r102;
        this.f69579d = r101;
        this.f69580e = null;
        this.f69581f = r103;
        this.f69582g = 0;
        this.f69583h = r104;
        this.f69584i = r105;
        this.f69585j = false;
        this.f69586k = r100;
        this.f69587l = r106;
        this.f69588m = 0;
        this.f69589n = r110;
        this.f69590o = false;
        return;
    L28:
        r106 = false;
        goto L30
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = null;
        goto L15
    L5:
        r102 = null;
        goto L7
    }
}
