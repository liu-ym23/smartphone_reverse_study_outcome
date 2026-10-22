package com.bytedance.android.livesdk.ktvimpl.mv.opus;

import android.content.Context;
import android.text.TextUtils;
import android.view.Surface;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.r;
import com.bytedance.android.livesdk.chatroom.model.interact.IMVBaseInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.IMVUrlStruct;
import com.bytedance.android.livesdk.ktvapi.model.mv.f;
import com.bytedance.android.livesdk.ktvapi.model.mv.g;
import com.bytedance.android.livesdk.ktvapi.model.mv.h;
import com.bytedance.android.livesdk.ktvapi.model.mv.k;
import com.bytedance.android.livesdk.ktvimpl.mv.KtvMvPlayer;
import com.bytedance.android.livesdk.ktvimpl.mv.t;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.ag;
import com.bytedance.android.livesdk.message.model.dd;
import com.bytedance.android.livesdk.message.model.ed;
import com.bytedance.android.livesdk.message.model.gd;
import com.bytedance.android.livesdk.message.model.od;
import com.bytedance.android.livesdkapi.depend.message.MVUrlStruct;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.message.RoomSongInfo;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer;
import com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import vlc.l;

/* JADX INFO: loaded from: classes10.dex */
public final class OpusServiceImpl implements g, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KtvMvPlayer f146154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f146155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f146156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f146157d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f146158e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public od f146159f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<f> f146160g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f146161h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f146162i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f146163j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f146164k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public r f146165l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Function1<? super od, Boolean> f146166m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.bytedance.android.livesdk.ktvapi.model.mv.l f146167n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f146168o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f146169p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Long f146170q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final lb0.b f146171r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.bytedance.android.livesdk.ktvimpl.mv.b f146172s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Long f146173t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Context f146174u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final com.bytedance.android.live.pushstream.d f146175v;

    public static final class a<T> implements IMediaPlayer.OnErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpusServiceImpl f146176a;

        public a(OpusServiceImpl r100) {
            this.f146176a = r100;
        }

        @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer.OnErrorListener
        public final void a(AbsPlayer r100, int r101, int r102, String r103) {
            String r104 = "code:" + r101 + ",desc:" + r103;
            Intrinsics.checkNotNullParameter(r104, "str");
            ALogger.e("ktv-opus", r104);
            OpusServiceImpl r105 = this.f146176a;
            if (r105.f146159f == null) goto L6;
            r105.s();
            return;
        }
    }

    public static final class b<T> implements IMediaPlayer.OnFirstFrameListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpusServiceImpl f146177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f146178b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RoomSongInfo f146179c;

        public b(OpusServiceImpl r100, Function0 r101, RoomSongInfo r102) {
            this.f146177a = r100;
            this.f146178b = r101;
            this.f146179c = r102;
        }

        @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer.OnFirstFrameListener
        public final void a(AbsPlayer r100) {
            this.f146178b.invoke();
            ed r101 = OpusServiceImpl.p(this.f146177a, this.f146179c, 0);
            if (r101 == null) goto L6;
            this.f146177a.f146172s.b(r101);
            return;
        }
    }

    public final void s() {
        if (r(false) == false) goto L11;
        od r100 = this.f146159f;
        if (r100 == null) goto L7;
        r100.h();
    L7:
        com.bytedance.android.livesdk.ktvapi.model.mv.l r101 = this.f146167n;
        if (r101 == null) goto L12;
        r101.a(3, this.f146159f);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.c
    public final Float m() {
        lb0.b r100 = this.f146171r;
        Integer r101 = r100.f508303c;
        Integer r102 = r100.f508304d;
        int r103 = 0;
        if (r101 == null) goto L5;
        int r104 = (r101.intValue() >> 16) & 255;
        int r105 = Math.max(r101.intValue() & 255, Math.max((r101.intValue() >> 8) & 255, r104));
    L6:
        if (r102 == null) goto L9;
        int r106 = (r102.intValue() >> 16) & 255;
        r103 = Math.max(r102.intValue() & 255, Math.max((r102.intValue() >> 8) & 255, r106));
    L9:
        return Float.valueOf(Math.max(r105, r103) / 255.0f);
    L5:
        r105 = 0;
        goto L6
    }

    public final void q() {
        if (this.f146170q == null) goto L10;
        int r100 = this.f146169p;
        long r101 = System.currentTimeMillis();
        Long r102 = this.f146170q;
        if (r102 == null) goto L7;
        long r103 = r102.longValue();
    L8:
        this.f146169p = r100 + ((int) (r101 - r103));
        return;
    L7:
        r103 = 0;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.c
    public final void release() {
        this.f146154a.release();
        this.f146165l = null;
        Iterator<T> r100 = this.f146160g.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((f) r100.next()).release();
        goto L4
    L6:
        this.f146160g.clear();
        q();
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.c
    public final void stop() {
        this.f146154a.stop();
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.g
    public final int n() {
        q();
        return this.f146169p;
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.g, com.bytedance.android.livesdk.ktvapi.model.mv.c
    public final h<?> a() {
        return this.f146154a;
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.c
    public final lb0.b b() {
        return this.f146171r;
    }

    public final Context getContext() {
        return this.f146174u;
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.g
    public final od k() {
        return this.f146159f;
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.c
    public final void c(Surface r100) {
        this.f146154a.setSurface(r100);
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.c
    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f146154a.q(new t(r100, null, null, 14));
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof gd) == true) goto L5;
        r100 = null;
    L5:
        gd r101 = (gd) r100;
        if (r101 == null) goto L17;
        dd r102 = r101.videoContent;
        if (r102 == null) goto L18;
        Long r103 = r102.c();
        if (r103 == null) goto L12;
        long r104 = r103.longValue();
    L13:
        String r105 = r102.a();
        od r106 = r102.b();
        if (r106 == null) goto L19;
        d(r106, new k(r104, r105), false);
        return;
    L19:
        return;
    L12:
        r104 = 0;
        goto L13
    L18:
        return;
    }

    public final boolean r(boolean r100) {
        String r101 = this.f146163j;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (KtvSettingHelper.w() == false) goto L12;
        if (r100 == false) goto L8;
    L15:
        com.bytedance.android.live.ktv.common.util.g.f("playDefaultOffical");
        this.f146154a.q(new t(r101, this.f146155b, this.f146164k, 8));
        com.bytedance.android.live.pushstream.d r102 = this.f146175v;
        if (r102 == null) goto L18;
        f(false, r102, false);
    L18:
        this.f146159f = null;
        return true;
    L8:
        if (Intrinsics.areEqual(this.f146154a.f145955g, r101) == false) goto L15;
        com.bytedance.android.live.ktv.common.util.g.f("playDefaultUrlMv repeat");
        return false;
    L12:
        if (Intrinsics.areEqual(this.f146154a.f145955g, r101) == false) goto L15;
        com.bytedance.android.live.ktv.common.util.g.f("playDefaultUrlMv repeat");
        return false;
    }

    public final void u(OpusMvManager.a r100) {
        Intrinsics.checkNotNullParameter(r100, "l");
        this.f146167n = r100;
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.g
    public final void g(List<MusicPanel> r110, Function1<? super Long, Boolean> r111) {
        Intrinsics.checkNotNullParameter(r111, "removeInterceptor");
        ArrayList r100 = null;
        if (r110 == null) goto L8;
        List<MusicPanel> r112 = r110;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator<T> r113 = r112.iterator();
    L6:
        if (r113.hasNext() == false) goto L9;
        r101.add(((MusicPanel) r113.next()).f153577a);
    L9:
        ArrayList r114 = new ArrayList();
        Iterator<f> r102 = this.f146160g.iterator();
    L11:
        if (r102.hasNext() == false) goto L33;
        f r103 = r102.next();
        if (r101 == null) goto L27;
        Iterator r104 = r101.iterator();
    L16:
        if (r104.hasNext() == false) goto L25;
        Object r105 = r104.next();
        KtvMusic r106 = (KtvMusic) r105;
        if (r103.getMId() == r106.getMId()) goto L20;
    L22:
        boolean r107 = false;
    L23:
        if (r107 == false) goto L16;
    L26:
        KtvMusic r108 = (KtvMusic) r105;
    L28:
        if (r108 != null) goto L11;
        if (r111.invoke(Long.valueOf(r103.getMId())).booleanValue() == false) goto L11;
        r114.add(r103);
        goto L11
    L20:
        if (Intrinsics.areEqual(r103.getSingerId(), r106.getOrderUserIdString()) == false) goto L22;
        r107 = true;
        goto L23
    L25:
        r105 = null;
        goto L26
    L27:
        r108 = null;
        goto L28
    L33:
        if ((!r114.isEmpty()) == false) goto L35;
        r100 = r114;
    L35:
        if (r100 == null) goto L51;
        this.f146160g.removeAll(r100);
        return;
    L51:
        return;
    L8:
        r101 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.g
    public final void j(vlc.d r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "messageManager");
        r100.addMessageListener(MessageType.KTV_MV_VIDEO_MESSAGE.getIntType(), this);
        this.f146162i = r101;
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.g
    public final f l(long r100, String r110) {
        Intrinsics.checkNotNullParameter(r110, "singerId");
        Iterator<T> r101 = this.f146160g.iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        Object r102 = r101.next();
        f r103 = (f) r102;
        if (r103.getMId() == r100) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == false) goto L4;
    L14:
        f r105 = (f) r102;
        if (r105 != null) goto L21;
        Long r106 = this.f146173t;
        if (r106 == null) goto L19;
        long r107 = r106.longValue();
    L20:
        r105 = new rb0.a(r107, r110, r100);
        this.f146160g.add(r105);
        goto L21
    L19:
        r107 = 0;
    L21:
        return r105;
    L8:
        if (Intrinsics.areEqual(r110, r103.getSingerId()) == false) goto L10;
        r104 = true;
        goto L11
    L13:
        r102 = null;
        goto L14
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.g
    public final void o(k r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "songInfo");
        f r102 = l(r100.f142333e, r100.f142334f);
        this.f146161h = r102;
        r102.a(r100);
        if (r101 == false) goto L8;
        f r103 = this.f146161h;
        if (r103 == null) goto L9;
        r103.h();
        return;
    L9:
        return;
    }

    public static final ed p(OpusServiceImpl r100, RoomSongInfo r101, int r102) {
        r100.getClass();
        IMVBaseInfo r103 = r101.getMvBaseInfo();
        if (r103 == null) goto L5;
        int r104 = r103.getDuration();
    L7:
        if (r104 <= 0) goto L20;
        List<ed> r105 = r101.getMvColorList();
        if (r105 != null) goto L12;
        return null;
    L12:
        if ((!r105.isEmpty()) != true) goto L21;
        int r106 = (int) ((r102 / r104) * r105.size());
        if (r106 < r105.size()) goto L18;
        r106 = r105.size() - 1;
    L18:
        return (ed) ListProtector.get(r105, r106);
    L21:
        return null;
    L20:
        return null;
    L5:
        r104 = r100.f146154a.h();
        goto L7
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.g
    public final void d(od r100, k r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "mvInfo");
        Intrinsics.checkNotNullParameter(r101, "mvSongInfo");
        com.bytedance.android.live.ktv.common.util.g.f("handelPlayMvInfo:" + r101 + "---" + r100);
        f r103 = l(r101.f142333e, r101.f142334f);
        String r104 = r101.f142329a;
        if (r104 != null) goto L5;
    L10:
        MusicPanel r105 = r101.f142330b;
        if (r105 == null) goto L14;
        r103.i().f142330b = r105;
    L14:
        if (this.f146161h != null) goto L16;
        this.f146161h = r103;
    L16:
        r103.g(r100);
        f r106 = this.f146161h;
        if (r106 == null) goto L22;
        NextLiveData<od> r107 = r106.e();
        if (r107 == null) goto L22;
        r107.setValue(r100);
    L22:
        if (this.f146162i == true) goto L24;
        if (r102 == true) goto L24;
        return;
    L24:
        t(r100, false, false);
        return;
    L5:
        if ((!TextUtils.isEmpty(r104)) == true) goto L8;
        r104 = null;
    L8:
        if (r104 == null) goto L10;
        r103.i().f142329a = r104;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.c
    public final void f(boolean r100, com.bytedance.android.live.pushstream.d r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "liveStream");
        if (r100 == true) goto L5;
    L9:
        if (r100 == false) goto L11;
    L16:
        if (r102 == false) goto L24;
        Function1<? super Boolean, Unit> r103 = this.f146168o;
        if (r103 == null) goto L25;
        Unit r104 = r103.invoke(Boolean.valueOf(r100));
        return;
    L25:
        return;
    L24:
        return;
    L11:
        if (this.f146165l == null) goto L16;
        this.f146154a.o().setExtraSurface(null, 3);
        Function1<? super Boolean, Unit> r105 = this.f146168o;
        if (r105 == null) goto L15;
        Unit r106 = r105.invoke(Boolean.FALSE);
    L15:
        this.f146165l = null;
        return;
    L5:
        if (this.f146165l != null) goto L9;
        r r107 = new r(r101, this.f146157d, this.f146158e);
        r107.a();
        Unit r108 = Unit.INSTANCE;
        this.f146165l = r107;
        Function1<? super Boolean, Unit> r109 = this.f146168o;
        if (r109 == null) goto L21;
        Unit r110 = r109.invoke(Boolean.TRUE);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.c
    public final void i(final RoomSongInfo r100, Function0<Unit> r101, final Function1<? super Integer, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "songInfo");
        Intrinsics.checkNotNullParameter(r101, "onFirstFrameCallback");
        Intrinsics.checkNotNullParameter(r102, "onProgressCallback");
        KtvMvPlayer r103 = this.f146154a;
        r103.f451188f = new b(this, r101, r100);
        r103.k(new OpusServiceImpl$fetchSongInfo$2(this, r100, r102));
        IMVBaseInfo r104 = r100.getMvBaseInfo();
        if (r104 == null) goto L10;
        IMVUrlStruct r105 = r104.getDownloadAddr();
        if (r105 == null) goto L10;
        List<String> r106 = r105.getUrlList();
        if (r106 == null) goto L10;
        String r107 = (String) ListProtector.get(r106, 0);
        if (r107 == null) goto L10;
    L11:
        h(r107);
        return;
    L10:
        r107 = "";
        goto L11
    }

    public final void t(od r110, boolean r111, boolean r210) {
        com.bytedance.android.live.ktv.common.util.g.f("playThisMvInfo:" + r110);
        if (Intrinsics.areEqual(this.f146159f, r110) == false) goto L7;
        if (r111 == true) goto L7;
        com.bytedance.android.live.ktv.common.util.g.f("playThisMvInfo fail");
        return;
    L7:
        boolean r100 = Intrinsics.areEqual(r110.f(), this.f146156c);
        String r101 = r110.d();
        if (r101 == null) goto L78;
        Function1<? super od, Boolean> r102 = this.f146166m;
        if (r102 != null) goto L12;
    L14:
        f r103 = this.f146161h;
        if (r103 == null) goto L17;
        k r104 = r103.i();
    L18:
        if (r104 == null) goto L31;
        if (r110.g() == false) goto L23;
        if (r100 == true) goto L23;
        r104.f142332d++;
    L25:
        r110.f153678c = Long.valueOf(r104.f142333e);
        MusicPanel r105 = r104.f142330b;
        if (r105 == null) goto L28;
        String r106 = r105.f153580d;
    L29:
        r110.f153680e = r106;
        r110.f153679d = r104.f142329a;
        goto L31
    L28:
        r106 = null;
    L23:
        if (r100 == true) goto L25;
        r104.f142331c++;
    L31:
        if ((!Intrinsics.areEqual(this.f146159f, r110)) == false) goto L41;
        od r107 = this.f146159f;
        if (r107 == null) goto L35;
        r107.h();
    L35:
        com.bytedance.android.livesdk.ktvapi.model.mv.l r108 = this.f146167n;
        if (r108 == null) goto L38;
        r108.a(3, this.f146159f);
    L38:
        od r109 = this.f146159f;
        if (r109 == null) goto L41;
        r109.f153676a = null;
        r109.f153677b = null;
    L41:
        this.f146159f = r110;
        r110.h();
        if (r110.g() == true) goto L61;
        ag r112 = r110.a();
        if (r112 == null) goto L46;
        MVUrlStruct r113 = r112.b();
    L47:
        if (r113 == null) goto L54;
        Long r114 = Long.valueOf(r113.getHeight());
        if (r114.longValue() <= 0) goto L51;
        boolean r115 = true;
    L52:
        if (r115 == false) goto L54;
    L55:
        if (r114 != null) goto L58;
        this.f146154a.u(2);
    L63:
        if (this.f146170q != null) goto L65;
        this.f146170q = Long.valueOf(System.currentTimeMillis());
    L65:
        if (r100 == false) goto L67;
        r(r111);
    L68:
        com.bytedance.android.livesdk.ktvapi.model.mv.l r116 = this.f146167n;
        if (r116 == null) goto L72;
        r116.a(2, this.f146159f);
    L72:
        if (this.f146175v != null) goto L74;
        return;
    L74:
        if (r110.g() == false) goto L76;
        f(false, this.f146175v, r210);
        return;
    L76:
        f(true, this.f146175v, r210);
        return;
    L67:
        this.f146154a.q(new t(r101, null, null, 14));
        goto L68
    L58:
        if ((r113.getWidth() / r113.getHeight()) <= ((Number) vm2.h.f556207p4.getValue(null, vm2.h.f556082a[274(0x112, float:3.84E-43)])).floatValue()) goto L60;
        this.f146154a.u(4);
        goto L63
    L60:
        this.f146154a.u(2);
        goto L63
    L51:
        r115 = false;
    L54:
        r114 = null;
        goto L55
    L46:
        r113 = null;
        goto L47
    L61:
        this.f146154a.u(2);
        goto L63
    L17:
        r104 = null;
        goto L18
    L12:
        if (r102.invoke(r110).booleanValue() != true) goto L14;
        return;
    }

    public OpusServiceImpl(Long r100, Context r101, HashMap<Integer, Integer> r102, com.bytedance.android.live.pushstream.d r103) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f146173t = r100;
        this.f146174u = r101;
        this.f146175v = r103;
        KtvMvPlayer r104 = new KtvMvPlayer(r101, r102);
        r104.setLooping(true);
        r104.o().setIsMute(true);
        Unit r105 = Unit.INSTANCE;
        this.f146154a = r104;
        this.f146155b = "ttlive_ktv_opus_default_mv";
        ReadOnlyProperty r106 = vm2.h.f556215q4;
        KProperty<?>[] r107 = vm2.h.f556082a;
        this.f146156c = (String) r106.getValue(null, r107[275(0x113, float:3.85E-43)]);
        this.f146157d = ((Number) vm2.h.f556199o4.getValue(null, r107[273(0x111, float:3.83E-43)])).intValue();
        this.f146158e = ((Number) vm2.h.f556191n4.getValue(null, r107[272(0x110, float:3.81E-43)])).intValue();
        this.f146160g = new ArrayList();
        lb0.b r108 = new lb0.b();
        this.f146171r = r108;
        this.f146172s = new com.bytedance.android.livesdk.ktvimpl.mv.b(r108);
        r104.f451187e = new a(this);
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.g
    public final void e(k r100, String r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "songInfo");
        Intrinsics.checkNotNullParameter(r101, "videoId");
        l(r100.f142333e, r100.f142334f).d(r101, r102, r103);
    }
}
