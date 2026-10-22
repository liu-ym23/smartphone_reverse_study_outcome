package com.bytedance.android.live.liveinteract.animation;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.animation.tasklet.IconMoveAnimationTasklet;
import com.bytedance.android.live.liveinteract.animation.tasklet.PathEffectAnimationTasklet;
import com.bytedance.android.live.liveinteract.animation.tasklet.WebPAnimationTasklet;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TaskState;
import com.bytedance.android.livesdk.config.i8;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.o0;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes46.dex */
public final class InteractFlyMicAnimationTask extends com.bytedance.android.live.liveinteract.animation.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f70946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f70947e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.animation.e f70948f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.videotalk.emoji.model.m f70949g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public o0 f70950h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f70951i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f70952j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.animation.tasklet.c f70953k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, Integer> f70954l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CompositeDisposable f70955m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Set<com.bytedance.android.live.liveinteract.animation.tasklet.d> f70956n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Set<com.bytedance.android.live.liveinteract.animation.tasklet.d> f70957o;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractFlyMicAnimationTask f70958a;

        public b(InteractFlyMicAnimationTask r100) {
            this.f70958a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            InteractFlyMicAnimationTask r102 = this.f70958a;
            if (r102.f70951i == true) goto L10;
            com.bytedance.android.live.liveinteract.animation.tasklet.b r103 = r102.n(3);
            if (r103 == null) goto L9;
            r103.start();
            return;
        L9:
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.emoji.model.f f70959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InteractFlyMicAnimationTask f70960b;

        public c(com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r100, InteractFlyMicAnimationTask r101) {
            this.f70959a = r100;
            this.f70960b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            InteractFlyMicAnimationTask r102 = this.f70960b;
            if (r102.f70951i == false) goto L6;
            return;
        L6:
            if (this.f70959a.getType() == 0) goto L8;
            int r103 = this.f70959a.getType();
        L9:
            com.bytedance.android.live.liveinteract.animation.tasklet.b r104 = r102.n(r103);
            if (r104 == null) goto L13;
            r104.start();
            return;
        L13:
            return;
        L8:
            r103 = 1;
            goto L9
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractFlyMicAnimationTask f70961a;

        public d(InteractFlyMicAnimationTask r100) {
            this.f70961a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            InteractFlyMicAnimationTask r102 = this.f70961a;
            if (r102.f70951i == true) goto L10;
            com.bytedance.android.live.liveinteract.animation.tasklet.b r103 = r102.n(4);
            if (r103 == null) goto L9;
            r103.start();
            return;
        L9:
            return;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractFlyMicAnimationTask f70962a;

        public e(InteractFlyMicAnimationTask r100) {
            this.f70962a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Long r111 = (Long) r110;
            if (this.f70962a.f70951i == false) goto L5;
            i.a("InteractAnimation.InteractFlyMicAnimationTask" + this.f70962a.f70971b, "sender anim stopped, currentAnimation is cleared");
            return;
        L5:
            com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r100 = this.f70962a.f70949g;
            if (r100 == null) goto L8;
            com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r101 = r100.getRevenueData();
        L9:
            Intrinsics.checkNotNull(r101);
            InteractFlyMicAnimationTask r102 = this.f70962a;
            com.bytedance.android.live.liveinteract.animation.e r103 = r102.f70948f;
            Intrinsics.checkNotNull(r103);
            com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r104 = this.f70962a.f70949g;
            if (r104 == null) goto L12;
            com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r105 = r104.getReceiverEmoji();
        L13:
            Intrinsics.checkNotNull(r105);
            com.bytedance.android.live.liveinteract.animation.tasklet.c r106 = this.f70962a.f70953k;
            Intrinsics.checkNotNull(r106);
            InteractFlyMicAnimationTask r107 = this.f70962a;
            new com.bytedance.android.live.liveinteract.animation.tasklet.n(r101, r102, r103, r105, r106, r107.f70954l, r107.f70952j, r107.f70971b, r107.f70972c, true, new InteractFlyMicAnimationTask$startAnimation$4$1(this.f70962a)).start();
            return;
        L12:
            r105 = null;
            goto L13
        L8:
            r101 = null;
            goto L9
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void c() {
        this.f70948f = null;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final int f() {
        return 3;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final long b() {
        return ((i8) vm2.d.J5.getValue(null, vm2.d.f555776a[345(0x159, float:4.83E-43)])).b();
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void recycle() {
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r100 = this.f70949g;
        if (r100 == null) goto L7;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r101 = r100.getReceiverEmoji();
        if (r101 == null) goto L7;
        r101.getSoundUrl();
    L7:
        Iterator r102 = CollectionsKt.toList(this.f70956n).iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        ((com.bytedance.android.live.liveinteract.animation.tasklet.d) r102.next()).stop();
        goto L9
    L11:
        this.f70956n.clear();
        this.f70955m.dispose();
        this.f70951i = true;
        this.f70970a.clear();
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void startAnimation() {
        if (this.f70948f == null) goto L88;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r100 = this.f70949g;
        if (r100 == null) goto L89;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r101 = r100.getRevenueData();
        if (r101 != null) goto L9;
        return;
    L9:
        if ((!r101.f79403d.f79397b.isEmpty()) != true) goto L91;
        ((LinkedHashMap) this.f70954l).clear();
        if (((ArrayList) this.f70947e).size() <= 1) goto L29;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r102 = this.f70949g;
        if (r102 == null) goto L18;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r103 = r102.getPathEmoji();
        if (r103 == null) goto L18;
        int r104 = r103.getTimeOffset();
    L19:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r105 = this.f70949g;
        if (r105 == null) goto L24;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r106 = r105.getReceiverEmoji();
        if (r106 == null) goto L24;
        int r107 = r106.getTimeOffset();
    L25:
        int r108 = Math.max(r104, r107);
        Iterator r109 = ((ArrayList) this.f70947e).iterator();
    L27:
        if (r109.hasNext() == false) goto L29;
        this.f70954l.put((String) r109.next(), Integer.valueOf(RangesKt.random(new IntRange(0, r108), Random.Default)));
    L24:
        r107 = 0;
    L18:
        r104 = 0;
    L29:
        CompositeDisposable r110 = this.f70955m;
        TimeUnit r111 = TimeUnit.MILLISECONDS;
        r110.add(Observable.timer(10000, r111).observeOn(AndroidSchedulers.mainThread()).subscribe(new x(this)));
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r112 = this.f70949g;
        if (r112 == null) goto L34;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r113 = r112.getSenderEmoji();
        if (r113 == null) goto L34;
        this.f70955m.add(Observable.timer(r113.getStart(), r111).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this)));
    L34:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r114 = this.f70949g;
        if (r114 == null) goto L39;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r115 = r114.getPathEmoji();
        if (r115 == null) goto L39;
        this.f70955m.add(Observable.timer(r115.getStart(), r111).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(r115, this)));
    L39:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r116 = this.f70949g;
        if (r116 == null) goto L44;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r117 = r116.getReceiverEmoji();
        if (r117 == null) goto L44;
        this.f70955m.add(Observable.timer(r117.getStart(), r111).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this)));
    L44:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r118 = this.f70949g;
        Intrinsics.checkNotNull(r118);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r119 = r118.getReceiverEmoji();
        if (r119 == null) goto L56;
        if (r119.getReshape() != true) goto L56;
        if (this.f70952j == false) goto L56;
        CompositeDisposable r120 = this.f70955m;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r121 = this.f70949g;
        Intrinsics.checkNotNull(r121);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r122 = r121.getReceiverEmoji();
        Intrinsics.checkNotNull(r122);
        Long r123 = r122.getReshapeStart();
        if (r123 == null) goto L53;
        long r124 = r123.longValue();
    L54:
        r120.add(Observable.timer(r124, r111).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this)));
        goto L56
    L53:
        r124 = 0;
    L56:
        if (this.f70950h == null) goto L68;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r125 = this.f70949g;
        if (r125 == null) goto L68;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r126 = r125.getRevenueData();
        if (r126 == null) goto L68;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.o r127 = r126.f79403d;
        if (r127 == null) goto L68;
        if (r127.f79399d != true) goto L68;
        com.bytedance.android.live.liveinteract.animation.tasklet.b r128 = n(5);
        if (r128 == null) goto L68;
        r128.start();
    L68:
        MultiLinkEventModule r129 = yc0.a.f567117a;
        yc0.b.a r130 = new yc0.b.a();
        if (this.f70972c != 4) goto L71;
        String r131 = "normal-big";
    L72:
        Intrinsics.checkNotNullParameter(r131, "flymicType");
        r130.f567125c = r131;
        Intrinsics.checkNotNullParameter("success", "reason");
        r130.f567123a = "success";
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r132 = this.f70949g;
        h2 r133 = null;
        if (r132 == null) goto L77;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r134 = r132.getRevenueData();
        if (r134 == null) goto L77;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r135 = r134.f79401b;
    L78:
        r130.f567127e = r135;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r136 = this.f70949g;
        if (r136 == null) goto L85;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r137 = r136.getRevenueData();
        if (r137 == null) goto L85;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r138 = r137.f79401b;
        if (r138 == null) goto L85;
        r133 = r138.f79383k;
    L85:
        r130.f567124b = r133;
        yc0.a.d(new yc0.b(r130));
        return;
    L77:
        r135 = null;
        goto L78
    L71:
        r131 = "normal";
        goto L72
    L91:
        return;
    L89:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final String getToUserId() {
        return this.f70946d;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final boolean e(InteractAnimationController r100) {
        Intrinsics.checkNotNullParameter(r100, "interactAnimationController");
        if (r100.k(1) == false) goto L6;
        r100.b(1);
    L6:
        if (r100.k(2) == false) goto L8;
        r100.b(2);
    L8:
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void g(com.bytedance.android.live.liveinteract.animation.e r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f70948f = r100;
        this.f70953k = new com.bytedance.android.live.liveinteract.animation.tasklet.c(r100.vj().getContext());
    }

    public final com.bytedance.android.live.liveinteract.animation.tasklet.b n(int r110) {
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r100 = this.f70949g;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r101 = null;
        if (r100 == null) goto L5;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r102 = r100.getRevenueData();
    L6:
        if (r102 != null) goto L9;
        return null;
    L9:
        if (r110 != 1) goto L11;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r103 = this.f70949g;
        if (r103 == null) goto L71;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r104 = r103.getRevenueData();
    L72:
        Intrinsics.checkNotNull(r104);
        com.bytedance.android.live.liveinteract.animation.e r105 = this.f70948f;
        Intrinsics.checkNotNull(r105);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r106 = this.f70949g;
        if (r106 == null) goto L75;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r107 = r106.getPathEmoji();
    L76:
        Intrinsics.checkNotNull(r107);
        com.bytedance.android.live.liveinteract.animation.tasklet.c r108 = this.f70953k;
        Intrinsics.checkNotNull(r108);
        com.bytedance.android.live.liveinteract.animation.tasklet.b r109 = new IconMoveAnimationTasklet(r104, this, r105, r107, r108, this.f70954l, new InteractFlyMicAnimationTask$buildTasklet$1(this));
    L78:
        return r109;
    L75:
        r107 = null;
        goto L76
    L71:
        r104 = null;
        goto L72
    L11:
        if (r110 != 2) goto L13;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r111 = this.f70949g;
        if (r111 == null) goto L62;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r112 = r111.getRevenueData();
    L63:
        Intrinsics.checkNotNull(r112);
        com.bytedance.android.live.liveinteract.animation.e r113 = this.f70948f;
        Intrinsics.checkNotNull(r113);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r114 = this.f70949g;
        if (r114 == null) goto L66;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r115 = r114.getPathEmoji();
    L67:
        Intrinsics.checkNotNull(r115);
        com.bytedance.android.live.liveinteract.animation.tasklet.c r116 = this.f70953k;
        Intrinsics.checkNotNull(r116);
        r109 = new PathEffectAnimationTasklet(r112, this, r113, r115, r116, this.f70954l, new InteractFlyMicAnimationTask$buildTasklet$2(this));
        goto L78
    L66:
        r115 = null;
        goto L67
    L62:
        r112 = null;
        goto L63
    L13:
        if (r110 != 3) goto L15;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r117 = this.f70949g;
        if (r117 == null) goto L53;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r118 = r117.getRevenueData();
    L54:
        Intrinsics.checkNotNull(r118);
        com.bytedance.android.live.liveinteract.animation.e r119 = this.f70948f;
        Intrinsics.checkNotNull(r119);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r120 = this.f70949g;
        if (r120 == null) goto L57;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r121 = r120.getSenderEmoji();
    L58:
        Intrinsics.checkNotNull(r121);
        com.bytedance.android.live.liveinteract.animation.tasklet.c r122 = this.f70953k;
        Intrinsics.checkNotNull(r122);
        return new WebPAnimationTasklet(r118, this, r119, r121, r122, new InteractFlyMicAnimationTask$buildTasklet$3(this));
    L57:
        r121 = null;
        goto L58
    L53:
        r118 = null;
        goto L54
    L15:
        if (r110 != 4) goto L17;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r123 = this.f70949g;
        if (r123 == null) goto L44;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r124 = r123.getRevenueData();
    L45:
        Intrinsics.checkNotNull(r124);
        com.bytedance.android.live.liveinteract.animation.e r125 = this.f70948f;
        Intrinsics.checkNotNull(r125);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r126 = this.f70949g;
        if (r126 == null) goto L48;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r127 = r126.getReceiverEmoji();
    L49:
        Intrinsics.checkNotNull(r127);
        com.bytedance.android.live.liveinteract.animation.tasklet.c r128 = this.f70953k;
        Intrinsics.checkNotNull(r128);
        return new com.bytedance.android.live.liveinteract.animation.tasklet.n(r124, this, r125, r127, r128, this.f70954l, this.f70952j, this.f70971b, this.f70972c, false, new InteractFlyMicAnimationTask$buildTasklet$4(this));
    L48:
        r127 = null;
        goto L49
    L44:
        r124 = null;
        goto L45
    L17:
        if (r110 != 5) goto L86;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r129 = this.f70949g;
        if (r129 == null) goto L22;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r130 = r129.getRevenueData();
    L23:
        if (r130 == null) goto L79;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r131 = this.f70949g;
        if (r131 == null) goto L27;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r132 = r131.getPathEmoji();
    L28:
        if (r132 != null) goto L30;
        return null;
    L30:
        if (this.f70948f != null) goto L32;
        return null;
    L32:
        if (this.f70953k == null) goto L82;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r133 = this.f70949g;
        if (r133 == null) goto L36;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r134 = r133.getRevenueData();
    L37:
        Intrinsics.checkNotNull(r134);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r135 = this.f70949g;
        if (r135 == null) goto L40;
        r101 = r135.getPathEmoji();
    L40:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r136 = r101;
        Intrinsics.checkNotNull(r136);
        o0 r137 = this.f70950h;
        com.bytedance.android.live.liveinteract.animation.e r138 = this.f70948f;
        Intrinsics.checkNotNull(r138);
        com.bytedance.android.live.liveinteract.animation.tasklet.c r139 = this.f70953k;
        Intrinsics.checkNotNull(r139);
        return new com.bytedance.android.live.liveinteract.animation.tasklet.z(r134, r136, r137, r138, r139);
    L36:
        r134 = null;
        goto L37
    L82:
        return null;
    L27:
        r132 = null;
        goto L28
    L79:
        return null;
    L22:
        r130 = null;
        goto L23
    L86:
        return null;
    L5:
        r102 = null;
        goto L6
    }

    public final void o(com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r100) {
        Intrinsics.checkNotNullParameter(r100, "talkRoomInteractEmoji");
        this.f70949g = r100;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r101 = r100.getPathEmoji();
        if (r101 == null) goto L9;
        py.k r102 = r101.dynamicImage();
        if (r102 == null) goto L9;
        if (r102.isValid() != true) goto L9;
        int r103 = com.bytedance.android.live.liveinteract.voicechat.emoji.a.f80165a;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r104 = this.f70949g;
        Intrinsics.checkNotNull(r104);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r105 = r104.getPathEmoji();
        Intrinsics.checkNotNull(r105);
        py.k r106 = r105.dynamicImage();
        Intrinsics.checkNotNull(r106);
        com.bytedance.android.live.liveinteract.voicechat.emoji.a.a(r106);
    L9:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r107 = this.f70949g;
        if (r107 == null) goto L19;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r108 = r107.getReceiverEmoji();
        if (r108 == null) goto L20;
        py.k r109 = r108.dynamicImage();
        if (r109 != null) goto L16;
        return;
    L16:
        if (r109.isValid() != true) goto L22;
        int r110 = com.bytedance.android.live.liveinteract.voicechat.emoji.a.f80165a;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r111 = this.f70949g;
        Intrinsics.checkNotNull(r111);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r112 = r111.getReceiverEmoji();
        Intrinsics.checkNotNull(r112);
        py.k r113 = r112.dynamicImage();
        Intrinsics.checkNotNull(r113);
        com.bytedance.android.live.liveinteract.voicechat.emoji.a.a(r113);
        return;
    L22:
        return;
    L20:
        return;
    }

    public InteractFlyMicAnimationTask(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        super(r100, r101);
        this.f70946d = "";
        this.f70947e = new ArrayList();
        this.f70954l = new LinkedHashMap();
        this.f70955m = new CompositeDisposable();
        this.f70956n = new LinkedHashSet();
        this.f70957o = new LinkedHashSet();
    }

    public static final void m(InteractFlyMicAnimationTask r100, com.bytedance.android.live.liveinteract.animation.tasklet.d r101, boolean r102) {
        if (r102 == true) goto L5;
        r100.f70956n.remove(r101);
        r100.f70957o.add(r101);
        if (r100.f70956n.size() != 0) goto L54;
        int r103 = r100.f70957o.size();
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r104 = r100.f70949g;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r105 = null;
        if (r104 == null) goto L23;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r106 = r104.getSenderEmoji();
    L24:
        int r107 = 1;
        if (r106 == null) goto L27;
        int r108 = 1;
    L28:
        int r109 = r108 + 0;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r110 = r100.f70949g;
        if (r110 == null) goto L31;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r111 = r110.getPathEmoji();
    L32:
        if (r111 == null) goto L34;
        int r112 = 1;
    L35:
        int r113 = r109 + r112;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r114 = r100.f70949g;
        if (r114 == null) goto L38;
        r105 = r114.getReceiverEmoji();
    L38:
        if (r105 != null) goto L42;
        r107 = 0;
    L42:
        if (r103 != (r113 + r107)) goto L55;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r115 = r100.f70949g;
        if (r115 == null) goto L56;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r116 = r115.getRevenueData();
        if (r116 == null) goto L57;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.g r117 = r116.f79400a;
        if (r117 == null) goto L51;
        r117.c(r116.f79401b, TaskState.COMPLETE);
    L51:
        r100.h(r100);
        ALogger.i("InteractAnimation.InteractFlyMicAnimationTask", "onTaskletStop#GiftInfo:" + r116.f79401b);
        return;
    L57:
        return;
    L56:
        return;
    L55:
        return;
    L34:
        r112 = 0;
        goto L35
    L31:
        r111 = null;
        goto L32
    L27:
        r108 = 0;
        goto L28
    L23:
        r106 = null;
        goto L24
    L54:
        return;
    L5:
        if (r100.f70956n.size() == 0) goto L7;
    L17:
        r100.f70956n.add(r101);
        return;
    L7:
        if (r100.f70957o.size() != 0) goto L17;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r118 = r100.f70949g;
        if (r118 == null) goto L17;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r119 = r118.getRevenueData();
        if (r119 == null) goto L17;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.g r120 = r119.f79400a;
        if (r120 == null) goto L16;
        r120.c(r119.f79401b, TaskState.START);
    L16:
        ALogger.i("InteractAnimation.InteractFlyMicAnimationTask", "onTaskletStart.GiftInfo:" + r119.f79401b);
        goto L17
    }
}
