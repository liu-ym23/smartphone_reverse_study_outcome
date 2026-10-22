package com.bytedance.android.live.liveinteract.animation.glflymic;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationController;
import com.bytedance.android.live.liveinteract.animation.e;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TaskState;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.f;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.g;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.m;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.p;
import com.bytedance.android.livesdk.config.i8;
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
public final class GLFlyMicAnimationTask extends com.bytedance.android.live.liveinteract.animation.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f70978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public m f70979e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Integer> f70980f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f70981g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f70982h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f70983i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Set<com.bytedance.android.live.liveinteract.animation.tasklet.d> f70984j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Set<com.bytedance.android.live.liveinteract.animation.tasklet.d> f70985k;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.liveinteract.animation.tasklet.b f70986a;

        public b(com.bytedance.android.live.liveinteract.animation.tasklet.b r100) {
            this.f70986a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            com.bytedance.android.live.liveinteract.animation.tasklet.b r102 = this.f70986a;
            if (r102 == null) goto L6;
            r102.start();
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.liveinteract.animation.tasklet.b f70987a;

        public c(com.bytedance.android.live.liveinteract.animation.tasklet.b r100) {
            this.f70987a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            com.bytedance.android.live.liveinteract.animation.tasklet.b r102 = this.f70987a;
            if (r102 == null) goto L6;
            r102.start();
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.liveinteract.animation.tasklet.b f70988a;

        public d(com.bytedance.android.live.liveinteract.animation.tasklet.b r100) {
            this.f70988a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            com.bytedance.android.live.liveinteract.animation.tasklet.b r102 = this.f70988a;
            if (r102 == null) goto L6;
            r102.start();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void c() {
        this.f70978d = null;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final int f() {
        return 3;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final String getToUserId() {
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final long b() {
        return ((i8) vm2.d.J5.getValue(null, vm2.d.f555776a[345(0x159, float:4.83E-43)])).b();
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void recycle() {
        m r100 = this.f70979e;
        if (r100 == null) goto L7;
        f r101 = r100.getReceiverEmoji();
        if (r101 == null) goto L7;
        r101.getSoundUrl();
    L7:
        Iterator r102 = CollectionsKt.toList(this.f70984j).iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        ((com.bytedance.android.live.liveinteract.animation.tasklet.d) r102.next()).stop();
        goto L9
    L11:
        this.f70984j.clear();
        this.f70982h.dispose();
        this.f70970a.clear();
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void startAnimation() {
        if (this.f70978d == null) goto L58;
        m r100 = this.f70979e;
        if (r100 == null) goto L59;
        p r101 = r100.getRevenueData();
        if (r101 == null) goto L60;
        int r102 = 1;
        if ((!r101.f79403d.f79397b.isEmpty()) != true) goto L63;
        ALogger.d("InteractAnimation.GLFlyMicAnimationTask", "startAnimation: " + this.f70979e);
        ((LinkedHashMap) this.f70980f).clear();
        if (((ArrayList) this.f70983i).size() <= 1) goto L29;
        m r103 = this.f70979e;
        if (r103 == null) goto L18;
        f r104 = r103.getPathEmoji();
        if (r104 == null) goto L18;
        int r105 = r104.getTimeOffset();
    L19:
        m r106 = this.f70979e;
        if (r106 == null) goto L24;
        f r107 = r106.getReceiverEmoji();
        if (r107 == null) goto L24;
        int r108 = r107.getTimeOffset();
    L25:
        int r109 = Math.max(r105, r108);
        Iterator r110 = ((ArrayList) this.f70983i).iterator();
    L27:
        if (r110.hasNext() == false) goto L29;
        this.f70980f.put((String) r110.next(), Integer.valueOf(RangesKt.random(new IntRange(0, r109), Random.Default)));
    L24:
        r108 = 0;
    L18:
        r105 = 0;
    L29:
        m r111 = this.f70979e;
        if (r111 == null) goto L37;
        f r112 = r111.getSenderEmoji();
        if (r112 == null) goto L37;
        com.bytedance.android.live.liveinteract.animation.tasklet.b r113 = n(3);
        if (r113 == null) goto L36;
        r113.a();
    L36:
        this.f70982h.add(Observable.timer(r112.getStart(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r113)));
    L37:
        m r114 = this.f70979e;
        if (r114 == null) goto L48;
        f r115 = r114.getPathEmoji();
        if (r115 == null) goto L48;
        if (r115.getType() == 0) goto L44;
        r102 = r115.getType();
    L44:
        com.bytedance.android.live.liveinteract.animation.tasklet.b r116 = n(r102);
        if (r116 == null) goto L47;
        r116.a();
    L47:
        this.f70982h.add(Observable.timer(r115.getStart(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(r116)));
    L48:
        m r117 = this.f70979e;
        if (r117 == null) goto L61;
        f r118 = r117.getReceiverEmoji();
        if (r118 == null) goto L62;
        com.bytedance.android.live.liveinteract.animation.tasklet.b r119 = n(4);
        if (r119 == null) goto L55;
        r119.a();
    L55:
        this.f70982h.add(Observable.timer(r118.getStart(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(r119)));
        return;
    L62:
        return;
    L61:
        return;
    L63:
        return;
    L60:
        return;
    L59:
        return;
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
    public final void g(e r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f70978d = r100;
    }

    public final com.bytedance.android.live.liveinteract.animation.tasklet.b n(int r210) {
        m r100 = this.f70979e;
        q50.a r101 = null;
        if (r100 == null) goto L5;
        p r102 = r100.getRevenueData();
    L6:
        if (r102 != null) goto L9;
        return null;
    L9:
        if (r210 != 1) goto L11;
        m r103 = this.f70979e;
        if (r103 == null) goto L62;
        p r110 = r103.getRevenueData();
    L63:
        Intrinsics.checkNotNull(r110);
        m r104 = this.f70979e;
        if (r104 == null) goto L66;
        f r111 = r104.getPathEmoji();
    L67:
        Intrinsics.checkNotNull(r111);
        e r105 = this.f70978d;
        if (r105 == null) goto L72;
        q50.b r106 = r105.jq();
        if (r106 == null) goto L72;
        r101 = r106.f531723b;
    L72:
        com.bytedance.android.live.liveinteract.animation.tasklet.b r107 = new GLIconMoveAnimationTasklet(r110, r111, r101, this.f70978d, this.f70980f, new GLFlyMicAnimationTask$buildTasklet$1(this));
    L74:
        return r107;
    L66:
        r111 = null;
        goto L67
    L62:
        r110 = null;
        goto L63
    L11:
        if (r210 != 2) goto L13;
        m r108 = this.f70979e;
        if (r108 == null) goto L48;
        p r109 = r108.getRevenueData();
    L49:
        Intrinsics.checkNotNull(r109);
        m r112 = this.f70979e;
        if (r112 == null) goto L52;
        f r113 = r112.getPathEmoji();
    L53:
        Intrinsics.checkNotNull(r113);
        e r114 = this.f70978d;
        if (r114 == null) goto L58;
        q50.b r115 = r114.jq();
        if (r115 == null) goto L58;
        r101 = r115.f531723b;
    L58:
        r107 = new GLPathAnimationTasklet(r109, r113, r101, this.f70978d, this.f70980f, new GLFlyMicAnimationTask$buildTasklet$2(this));
        goto L74
    L52:
        r113 = null;
        goto L53
    L48:
        r109 = null;
        goto L49
    L13:
        if (r210 != 3) goto L15;
        m r116 = this.f70979e;
        if (r116 == null) goto L34;
        p r117 = r116.getRevenueData();
    L35:
        Intrinsics.checkNotNull(r117);
        m r118 = this.f70979e;
        if (r118 == null) goto L38;
        f r119 = r118.getSenderEmoji();
    L39:
        Intrinsics.checkNotNull(r119);
        e r120 = this.f70978d;
        if (r120 == null) goto L44;
        q50.b r121 = r120.jq();
        if (r121 == null) goto L44;
        r101 = r121.f531723b;
    L44:
        r107 = new GLWebPAnimationTasklet(r117, r119, r101, this.f70978d, new GLFlyMicAnimationTask$buildTasklet$3(this));
        goto L74
    L38:
        r119 = null;
        goto L39
    L34:
        r117 = null;
        goto L35
    L15:
        if (r210 != 4) goto L75;
        m r122 = this.f70979e;
        if (r122 == null) goto L20;
        p r123 = r122.getRevenueData();
    L21:
        Intrinsics.checkNotNull(r123);
        m r124 = this.f70979e;
        if (r124 == null) goto L24;
        f r125 = r124.getReceiverEmoji();
    L25:
        Intrinsics.checkNotNull(r125);
        e r126 = this.f70978d;
        if (r126 == null) goto L30;
        q50.b r127 = r126.jq();
        if (r127 == null) goto L30;
        r101 = r127.f531723b;
    L30:
        r107 = new GLMicSeatAnimationTasklet(r123, r125, r101, this.f70978d, this.f70980f, this.f70971b, this.f70972c, this.f70981g, new GLFlyMicAnimationTask$buildTasklet$4(this));
        goto L74
    L24:
        r125 = null;
        goto L25
    L20:
        r123 = null;
        goto L21
    L75:
        return null;
    L5:
        r102 = null;
        goto L6
    }

    public GLFlyMicAnimationTask(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        super(r100, r101);
        this.f70980f = new LinkedHashMap();
        this.f70982h = new CompositeDisposable();
        this.f70983i = new ArrayList();
        this.f70984j = new LinkedHashSet();
        this.f70985k = new LinkedHashSet();
    }

    public static final void m(GLFlyMicAnimationTask r100, com.bytedance.android.live.liveinteract.animation.tasklet.d r101, boolean r102) {
        if (r102 == true) goto L5;
        r100.f70984j.remove(r101);
        r100.f70985k.add(r101);
        if (r100.f70984j.size() != 0) goto L54;
        int r103 = r100.f70985k.size();
        m r104 = r100.f70979e;
        f r105 = null;
        if (r104 == null) goto L23;
        f r106 = r104.getSenderEmoji();
    L24:
        int r107 = 1;
        if (r106 == null) goto L27;
        int r108 = 1;
    L28:
        int r109 = r108 + 0;
        m r110 = r100.f70979e;
        if (r110 == null) goto L31;
        f r111 = r110.getPathEmoji();
    L32:
        if (r111 == null) goto L34;
        int r112 = 1;
    L35:
        int r113 = r109 + r112;
        m r114 = r100.f70979e;
        if (r114 == null) goto L38;
        r105 = r114.getReceiverEmoji();
    L38:
        if (r105 != null) goto L42;
        r107 = 0;
    L42:
        if (r103 != (r113 + r107)) goto L55;
        m r115 = r100.f70979e;
        if (r115 == null) goto L56;
        p r116 = r115.getRevenueData();
        if (r116 == null) goto L57;
        g r117 = r116.f79400a;
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
        if (r100.f70984j.size() == 0) goto L7;
    L17:
        r100.f70984j.add(r101);
        return;
    L7:
        if (r100.f70985k.size() != 0) goto L17;
        m r118 = r100.f70979e;
        if (r118 == null) goto L17;
        p r119 = r118.getRevenueData();
        if (r119 == null) goto L17;
        g r120 = r119.f79400a;
        if (r120 == null) goto L16;
        r120.c(r119.f79401b, TaskState.START);
    L16:
        ALogger.i("InteractAnimation.InteractFlyMicAnimationTask", "onTaskletStart.GiftInfo:" + r119.f79401b);
        goto L17
    }
}
