package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ogc;

import am2.x;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.z;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.j;
import io.reactivex.l;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import pp1.g;
import py.k;
import vr1.u;

/* JADX INFO: loaded from: classes8.dex */
public final class OgcVSWebActivityBehavior extends fm3.b implements c0.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f116625o = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Disposable> f116626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DataCenter f116627e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f116628f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f116629g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f116630h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f116631i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f116632j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final k f116633k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Integer f116634l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final k f116635m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f116636n;

    public static final class a<T> implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OgcVSWebActivityBehavior f116637a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ogc.OgcVSWebActivityBehavior$a$a, reason: collision with other inner class name */
        public static final class C1738a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ j f116638a;

            public C1738a(j r100) {
                this.f116638a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Bitmap r101 = (Bitmap) r100;
                if (r101 != null) goto L5;
            L8:
                this.f116638a.onError(new Throwable("invalide bitmap"));
                return;
            L5:
                if (r101.isRecycled() == true) goto L8;
                this.f116638a.onSuccess(new BitmapDrawable(s1.getResources(), r101));
                this.f116638a.onComplete();
            }
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ j f116639a;

            public b(j r100) {
                this.f116639a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Throwable r101 = (Throwable) r100;
                Intrinsics.checkNotNullParameter(r101, "e");
                this.f116639a.onError(r101);
            }
        }

        public a(OgcVSWebActivityBehavior r100) {
            this.f116637a = r100;
        }

        @Override // io.reactivex.l
        public final void a(j<Drawable> r100) {
            Intrinsics.checkNotNullParameter(r100, "emitter");
            Disposable r101 = a1.k(this.f116637a.f116633k).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new C1738a(r100), new b(r100));
            ((ArrayList) this.f116637a.f116626d).add(r101);
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.a
    public final Maybe<Drawable> getIcon() {
        return Maybe.create(new a(this));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.a
    public final Maybe<String> getTitle() {
        return Maybe.just("活动");
    }

    @Override // fm3.b
    public final void a(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Integer r101 = this.f116634l;
        if (r101 != null) goto L8;
    L9:
        Integer r102 = this.f116634l;
        if (r102 != null) goto L13;
    L18:
        fq1.d.a().handleSchema(r100.getContext(), UriProtector.parse(new UrlBuilder(this.f116632j).build()));
        Pair[] r103 = new Pair[1];
        if (this.f116636n == true) goto L21;
        String r104 = NewBroadcastMonitor.STAGE.TOOLBAR;
    L22:
        r103[0] = TuplesKt.to("vs_scene_source", r104);
        Map<String, String> r105 = MapsKt.mutableMapOf(r103);
        j0.l().sendLog("livesdk_ogc_icon_click", r105, new Object[]{x.class, IRoom.class});
        return;
    L21:
        r104 = "more";
        goto L22
    L13:
        if (r102.intValue() != 2) goto L18;
    L15:
        if (r.r().isRecording(this.f116627e) == false) goto L18;
        f2.b(R.string.ttlive_record_ban_toolbar_click_tip, 0);
        return;
    L8:
        if (r101.intValue() == 1) goto L15;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
        Intrinsics.checkNotNullParameter(r100, "command");
        if ((r100 instanceof g) == true) goto L5;
    L7:
        DataCenter r101 = this.f116627e;
        if (r101 != null) goto L10;
        return;
    L10:
        final View r102 = this.f116628f;
        if (r102 != null) goto L14;
        return;
    L14:
        if ((r100 instanceof pp1.c) == false) goto L26;
        u r103 = r.u(r101, null, 2);
        if (r103 == null) goto L27;
        z<pp1.c> r104 = r.y().createToolbarBubble(this.f116627e, r102.getContext(), r102);
        if (r104 != null) goto L20;
        return;
    L20:
        com.bytedance.live.datacontext.j<a0<pp1.c>> r105 = r103.e1();
        if (r105 == null) goto L28;
        a0<pp1.c> r106 = r105.getValue();
        if (r106 == null) goto L29;
        r106.addBubble(r100, ((pp1.c) r100).f530177k, r104, new OgcVSWebActivityBehavior$onCommand$1(this, r102));
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L5:
        if (((g) r100).f530187a == false) goto L7;
        y3.f(this.f116627e).k(ToolbarButton.VS_ACTIVITY_ONE, (OgcVSWebActivityBehavior) this.f116631i.getValue());
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f116627e = null;
        this.f116628f = null;
        Iterator<T> r102 = this.f116626d.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((Disposable) r102.next()).dispose();
        goto L4
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f116627e = r101;
        this.f116628f = r100;
        this.f116629g = r100.findViewById(R.id.icon);
        if (this.f116636n == false) goto L5;
    L7:
        Pair[] r102 = new Pair[1];
        if (this.f116636n == true) goto L10;
        String r103 = NewBroadcastMonitor.STAGE.TOOLBAR;
    L11:
        r102[0] = TuplesKt.to("vs_scene_source", r103);
        Map<String, String> r104 = MapsKt.mutableMapOf(r102);
        j0.l().sendLog("livesdk_ogc_icon_show", r104, new Object[]{x.class, IRoom.class});
    L12:
        View r105 = this.f116628f;
        if (r105 == null) goto L15;
        r105.setContentDescription(getTitle().toString());
    L15:
        getIcon().observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this), new e(this));
        Disposable r106 = r.f().k(new OgcVSWebActivityBehavior$onLoad$d$1(this));
        if (r106 == null) goto L19;
        ((ArrayList) this.f116626d).add(r106);
        return;
    L19:
        return;
    L10:
        r103 = "more";
        goto L11
    L5:
        if (y3.m(this.f116627e).n(ToolbarButton.VS_ACTIVITY_ONE) == true) goto L7;
        goto L7
    }

    public OgcVSWebActivityBehavior(String r100, k r101, Integer r102, k r103, boolean r104) {
        super(0);
        this.f116632j = r100;
        this.f116633k = r101;
        this.f116634l = r102;
        this.f116635m = r103;
        this.f116636n = r104;
        this.f116626d = new ArrayList();
        this.f116631i = LazyKt.lazy(new OgcVSWebActivityBehavior$foldOgcBehavior$2(this));
    }
}
