package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder;

import am2.x;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.room.navi.userinfo.model.TabLabelType;
import com.bytedance.android.live.room.navi.userinfo_p.UserInfoContextExtKt;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.core.BaseTabFlipper;
import com.bytedance.android.live.room.y;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTabLabel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class CommonTabHolder implements w91.f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f99927g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f99928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vlc.d f99929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f99930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IRoom f99931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DataCenter f99932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f99933f;

    public static final class a {
        @JvmStatic
        public static View a(boolean r100, int r101, DataCenter r102, ViewGroup r103) {
            Intrinsics.checkNotNullParameter(r102, "dataCenter");
            Intrinsics.checkNotNullParameter(r103, "parent");
            if (r100 == true) goto L5;
            int r104 = R.layout.ttlive_view_user_info_tab_audience_common_dynamic_text;
        L10:
            return LayoutInflater.from(r103.getContext()).inflate(r104, r103, false);
        L5:
            if (r101 != 1) goto L7;
            r104 = R.layout.ttlive_view_user_info_tab_anchor_first_common_dynamic_text;
            goto L10
        L7:
            r104 = R.layout.ttlive_view_user_info_tab_anchor_second_common_text;
            goto L10
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonTabHolder f99934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f99935b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f99936a;

            public a(b r100) {
                this.f99936a = r100;
            }

            public final void a() {
                j0 r100 = j0.l();
                Pair[] r101 = new Pair[2];
                r101[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE, this.f99936a.f99935b);
                CommonTabHolder r102 = this.f99936a.f99934a;
                Intrinsics.checkNotNullParameter(r102, "$this$getAdapterPos");
                ViewParent r103 = r102.a().getParent();
            L3:
                if (r103 == null) goto L8;
                if ((r103 instanceof BaseTabFlipper) == true) goto L6;
                r103 = r103.getParent();
                goto L3
            L6:
                int r104 = ((BaseTabFlipper) r103).f(r102.a());
            L9:
                r101[1] = TuplesKt.to("tag_order", String.valueOf(r104 + 1));
                Map<String, String> r105 = MapsKt.mutableMapOf(r101);
                this.f99936a.f99934a.i(r105);
                Unit r106 = Unit.INSTANCE;
                r100.sendLog("livesdk_tag_show", r105, new Object[]{x.class, IRoom.class});
                return;
            L8:
                r104 = -1;
                goto L9
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(CommonTabHolder r100, String r101) {
            this.f99934a = r100;
            this.f99935b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f99934a.f99933f.post(new a(this));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // w91.f
    public boolean d(w91.e r100) {
        return false;
    }

    public void i(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
    }

    public abstract void k(u91.a r100);

    public void l() {
    }

    public void n() {
    }

    @Override // w91.f
    public q91.a c() {
        return new q91.a();
    }

    @Override // w91.f
    public boolean f() {
        return a0.d(this.f99932e, false);
    }

    @Override // w91.f
    public w91.a g() {
        return new r91.a();
    }

    public void p() {
        this.f99930c.clear();
    }

    public final void m() {
        l();
        o81.a r100 = com.bytedance.android.live.room.navi.userinfo_p.viewmodel.a.a(this.f99932e);
        if (r100 == null) goto L5;
        j(UserInfoContextExtKt.b(r100.getOnWidgetLoad(), new CommonTabHolder$onInitHolder$$inlined$run$lambda$1(this)));
        j(UserInfoContextExtKt.b(r100.getOnWidgetViewPrepared(), new CommonTabHolder$onInitHolder$$inlined$run$lambda$2(this)));
        j(UserInfoContextExtKt.b(r100.getOnWidgetRoomEnter(), new CommonTabHolder$onInitHolder$$inlined$run$lambda$3(this)));
        j(UserInfoContextExtKt.b(r100.getOnWidgetUnload(), new CommonTabHolder$onInitHolder$$inlined$run$lambda$4(this)));
        return;
    L5:
        ALogger.e("CommonTabHolder", "UserInfoWidgetLifecycleContext获取为null");
    }

    @Override // w91.f
    public final View a() {
        return this.f99933f;
    }

    @Override // w91.f
    public int b() {
        return this.f99928a;
    }

    @Override // w91.f
    public void e(int r100) {
        this.f99928a = r100;
    }

    public final void h(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        IRoom r101 = this.f99931d;
        if (r101 == null) goto L11;
        AnchorTabLabel r102 = r101.getAnchorTabLabel();
        if (r102 == null) goto L12;
        int r103 = Integer.valueOf(r102.getType()).intValue();
        if (r103 != TabLabelType.QualityGeek.value) goto L9;
        r100.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
    L9:
        r100.put("tag_name", String.valueOf(r103));
        return;
    L12:
        return;
    }

    public final void j(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$autoBind");
        this.f99930c.add(r100);
    }

    public void o(IRoom r100) {
        this.f99931d = r100;
    }

    public final void q(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tagType");
        int r101 = y.f100451a;
        y.a(this.f99932e, this.f99930c, "sendTagShowLog", new b(this, r100));
    }

    public CommonTabHolder(IRoom r100, DataCenter r101, View r102) {
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, "itemView");
        this.f99931d = r100;
        this.f99932e = r101;
        this.f99933f = r102;
        this.f99929b = (vlc.d) r101.get("data_message_manager", null);
        this.f99930c = new CompositeDisposable();
    }
}
