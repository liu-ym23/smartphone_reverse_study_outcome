package com.bytedance.android.live.broadcastgame.xplay.servermergecast;

import androidx.camera.video.AudioStats;
import com.bytedance.android.live.broadcastgame.api.xplay.p;
import com.bytedance.android.live.broadcastgame.api.xplay.r;
import com.bytedance.android.live.broadcastgame.api.xplay.s;
import com.bytedance.android.live.broadcastgame.xplay.XplayLog;
import com.bytedance.android.live.broadcastgame.xplay.q1;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiCreator;
import com.bytedance.android.livesdk.utils.r2;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ti6.j;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public fi6.a f62415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f62416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f62417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f62418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f62419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f62420f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompositeDisposable f62421g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p f62422h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Pair<Integer, Integer> f62423i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.live.broadcastgame.xplay.servermergecast.a f62424j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final r f62425k;

    public static final class a {
    }

    static {
    }

    @Override // ti6.j
    public final /* synthetic */ boolean b(aj6.d r100, aj6.b r101) {
        ti6.a.a(r100, r101);
        return false;
    }

    @Override // ti6.j
    public final String a(int r110, int r111, List<ti6.f> r210) {
        Intrinsics.checkNotNullParameter(r210, "mixRegions");
        s r100 = this.f62422h.f59510j;
        if (r100 != null) goto L5;
    L7:
        c r101 = this.f62424j.a(this.f62423i.getFirst().intValue(), this.f62423i.getSecond().intValue());
    L8:
        r r102 = this.f62425k;
        if (r102 == null) goto L11;
        String r103 = r102.f59524i;
    L12:
        List r104 = CollectionsKt.toMutableList(r210);
        Iterator r105 = r104.iterator();
    L14:
        if (r105.hasNext() == false) goto L28;
        ti6.f r106 = (ti6.f) r105.next();
        if (Intrinsics.areEqual(r106.f546160b, r103) == false) goto L24;
        if (this.f62416b == false) goto L23;
        if (r101.f62410f == 8) goto L21;
        r106.f546159a = 1;
        float r112 = r101.f62407c;
        float r113 = r101.f62405a;
        double r114 = r112 - r113;
        float r115 = r101.f62408d;
        float r116 = r101.f62406b;
        List r117 = r104;
        r106.f546164f = r114;
        r106.f546165g = r115 - r116;
        r106.f546162d = r113;
        r106.f546163e = r116;
        r106.f546170l = true;
        r106.f546173o = 1;
    L27:
        r104 = r117;
        goto L14
    L21:
        r106.f546159a = 1;
        r106.f546164f = AudioStats.AUDIO_AMPLITUDE_NONE;
        r106.f546165g = AudioStats.AUDIO_AMPLITUDE_NONE;
        r106.f546162d = AudioStats.AUDIO_AMPLITUDE_NONE;
        r106.f546163e = AudioStats.AUDIO_AMPLITUDE_NONE;
        r106.f546170l = true;
        r106.f546173o = 1;
        goto L14
    L23:
        r117 = r104;
        r106.f546159a = 1;
        r106.f546164f = 1.0d;
        r106.f546165g = 1.0d;
        r106.f546162d = AudioStats.AUDIO_AMPLITUDE_NONE;
        r106.f546163e = AudioStats.AUDIO_AMPLITUDE_NONE;
        r106.f546173o = 1;
        goto L27
    L24:
        r117 = r104;
        r106.f546173o = 0;
        if (q1.c(this.f62422h.f59508h.f59485b) == false) goto L27;
        r106.f546177s = 2;
        goto L27
    L28:
        List r118 = r104;
        this.f62418d = LiveSeiCreator.a(r118, this.f62415a, 0).toString();
        if (r118 == null) goto L40;
        Iterator r107 = r118.iterator();
    L32:
        if (r107.hasNext() == false) goto L40;
        ti6.f r108 = (ti6.f) r107.next();
        if ((!Intrinsics.areEqual(r108.f546160b, r103)) == false) goto L32;
        if (this.f62417c == false) goto L32;
        if (r2.a(this.f62420f) == false) goto L32;
        r108.c("");
        r108.b("");
        r108.a("");
        r108.f546183y = this.f62420f;
    L40:
        if (r118 == null) goto L47;
        ArrayList r109 = new ArrayList();
        Iterator r119 = r118.iterator();
    L43:
        if (r119.hasNext() == false) goto L48;
        Object r120 = r119.next();
        if (Intrinsics.areEqual(((ti6.f) r120).f546160b, r103) == false) goto L43;
        r109.add(r120);
    L48:
        s r121 = this.f62422h.f59510j;
        if (r121 != null) goto L51;
    L54:
        r210.clear();
        if (r118 == null) goto L57;
        List r122 = r118;
    L58:
        r210.addAll(r122);
        s r123 = this.f62422h.f59510j;
        if (r123 != null) goto L61;
    L72:
        String r124 = LiveSeiCreator.a(r210, this.f62415a, 0).toString();
        int r125 = XplayLog.f61931a;
        XplayLog.c("XplayStreamMixer", "mix stream, rtcSeiJson = " + r124 + ", isFirstRemoteVideoArrived = " + this.f62416b);
        return r124;
    L61:
        if (r123.f59533g != true) goto L72;
        ArrayList r126 = new ArrayList();
        Iterator<T> r127 = r210.iterator();
    L64:
        if (r127.hasNext() == false) goto L68;
        Object r128 = r127.next();
        if ((!Intrinsics.areEqual(((ti6.f) r128).f546160b, r103)) == false) goto L64;
        r126.add(r128);
        goto L64
    L68:
        Iterator r129 = r126.iterator();
    L70:
        if (r129.hasNext() == false) goto L72;
        ti6.f r130 = (ti6.f) r129.next();
        int r131 = this.f62419e;
        r130.f546173o = r131;
        this.f62419e = r131 ^ 1;
        goto L70
    L57:
        r122 = new ArrayList();
        goto L58
    L51:
        if (r121.f59533g != true) goto L54;
        if (r109 == null) goto L54;
        r118.removeAll(r109);
        goto L54
    L47:
        r109 = null;
        goto L48
    L11:
        r103 = null;
        goto L12
    L5:
        if (r100.f59534h != true) goto L7;
        r101 = new c(0);
        goto L8
    }

    public g(p r100, Pair<Integer, Integer> r101, com.bytedance.android.live.broadcastgame.xplay.servermergecast.a r102, r r103) {
        Intrinsics.checkNotNullParameter(r100, "newEnv");
        Intrinsics.checkNotNullParameter(r101, "xplayCanvasSize");
        Intrinsics.checkNotNullParameter(r102, "xplayLittleWindowCastManager");
        this.f62422h = r100;
        this.f62423i = r101;
        this.f62424j = r102;
        this.f62425k = r103;
        this.f62418d = "";
        this.f62421g = new CompositeDisposable();
    }
}
