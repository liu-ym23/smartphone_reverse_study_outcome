package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.api.userinfo.INavigationProxyService;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.ElementBasicVM;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.UserInfoVM;
import com.bytedance.android.livesdk.utils.r1;
import com.bytedance.android.livesdk.widget.rollingTextView.RollingTextView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public class g extends CommonTabHolder {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f99961n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f99962o = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public u91.a f99963h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f99964i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Disposable f99965j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RollingTextView f99966k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f99967l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Disposable f99968m;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f99969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f99970b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f99969a, r101.f99969a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f99970b, r101.f99970b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f99969a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f99970b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "DiggCount(num=" + this.f99969a + ", unit=" + this.f99970b + ")";
        }

        public b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "num");
            Intrinsics.checkNotNullParameter(r101, Scraps.INNER_UNIT);
            this.f99969a = r100;
            this.f99970b = r101;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f99971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ n f99972b;

        public c(g r100, n r101) {
            this.f99971a = r100;
            this.f99972b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            u32.k r101 = (u32.k) sh6.c.b((sh6.b) r100);
            if (r101 == null) goto L6;
            g r102 = this.f99971a;
            r102.getClass();
            r102.f99965j = r101.Lo().compose(RxUtil.rxSchedulerHelper()).subscribe(new h(r102));
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f99973a;

        public d(g r100) {
            this.f99973a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            g r102 = this.f99973a;
            int r103 = g.r(r102);
            Intrinsics.checkNotNullParameter(r102, "$this$setTextColor");
            View r104 = r102.a().findViewById(R.id.tv_common_text);
            if ((r104 instanceof TextView) == true) goto L5;
            r104 = null;
        L5:
            TextView r105 = (TextView) r104;
            if (r105 == null) goto L8;
            r105.setTextColor(r103);
        L8:
            g r106 = this.f99973a;
            RollingTextView r107 = r106.f99966k;
            if (r107 == null) goto L12;
            r107.setTextColor(g.r(r106));
            return;
        }
    }

    public static int t(long r100) {
        if (r100 >= 10000) goto L6;
        return 0;
    L6:
        if (r100 < 100000000) goto L11;
        return 100000000;
    L11:
        return 10000;
    }

    static {
        f99961n = ColorProtector.parseColor("#FACE15");
        f99962o = ColorProtector.parseColor("#b3ffffff");
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void l() {
        q("like_cnt");
        View r100 = this.f99933f.findViewById(R.id.tv_common_text_dynamic);
        Disposable r101 = null;
        if ((r100 instanceof RollingTextView) == true) goto L5;
        r100 = null;
    L5:
        RollingTextView r102 = (RollingTextView) r100;
        this.f99966k = r102;
        if (r102 != null) goto L8;
    L12:
        INavigationProxyService r103 = (INavigationProxyService) jc1.k.f(INavigationProxyService.class);
        if (r103 == null) goto L21;
        l81.d r104 = r103.getDiggContext(this.f99932e);
        if (r104 == null) goto L21;
        m<Boolean> r105 = r104.d(this.f99932e);
        if (r105 == null) goto L21;
        Observable<Boolean> r106 = r105.a();
        if (r106 == null) goto L21;
        r101 = r106.subscribe(new d(this));
    L21:
        this.f99968m = r101;
        return;
    L8:
        if (a0.d(this.f99932e, false) == false) goto L10;
        r102.b(1, 12.0f);
    L11:
        r102.setTextColor(f99962o);
        goto L12
    L10:
        r102.b(1, 8.0f);
        goto L11
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void p() {
        super.p();
        this.f99964i = false;
        Disposable r100 = this.f99965j;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f99965j = null;
        Disposable r101 = this.f99968m;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        this.f99968m = null;
    }

    public static final int r(g r100) {
        r100.getClass();
        INavigationProxyService r101 = (INavigationProxyService) jc1.k.f(INavigationProxyService.class);
        if (r101 == null) goto L12;
        l81.d r102 = r101.getDiggContext(r100.f99932e);
        if (r102 == null) goto L12;
        m<Boolean> r103 = r102.d(r100.f99932e);
        if (r103 == null) goto L12;
        if (r103.getValue().booleanValue() != true) goto L12;
        return f99961n;
    L12:
        return f99962o;
    }

    public static b s(long r100) {
        int r101 = t(r100);
        if (r101 == 0) goto L12;
        if (r101 == 10000) goto L15;
        if (r101 == 100000000) goto L14;
        return new b(String.valueOf(r100), "");
    L14:
        return new b(r1.a(Double.valueOf((r100 * 1.0d) / ((double) 100000000))), s1.B(R.string.live_room_current_room_digg_count_hundred_million));
    L15:
        return new b(r1.a(Double.valueOf((r100 * 1.0d) / ((double) 10000))), s1.B(R.string.live_room_current_room_digg_count_ten_thousand));
    L12:
        return new b(String.valueOf(r100), "");
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void k(u91.a r100) {
        this.f99963h = r100;
        if (this.f99964i == true) goto L43;
        this.f99964i = true;
        if (r100 != null) goto L7;
    L10:
        if (r100 != null) goto L12;
    L41:
        com.bytedance.android.live.room.navi.userinfo_p.flipper.core.e.e(this, s1.C(R.string.live_room_current_room_digg_count, new Object[]{""}));
        return;
    L12:
        if (r100.f549199b == true) goto L41;
    L13:
        INavigationProxyService r101 = (INavigationProxyService) jc1.k.f(INavigationProxyService.class);
        Long r102 = null;
        if (r101 == null) goto L18;
        l81.d r103 = r101.getDiggContext(this.f99932e);
        if (r103 == null) goto L18;
        n<u32.k> r104 = r103.b(this.f99932e);
    L19:
        if (r104 == null) goto L23;
        u32.k r105 = r104.getValue();
        if (r105 == null) goto L23;
        this.f99965j = r105.Lo().compose(RxUtil.rxSchedulerHelper()).subscribe(new h(this));
    L24:
        if (r105 != null) goto L31;
        if (r104 == null) goto L31;
        Observable<sh6.b<u32.k>> r106 = r104.a();
        if (r106 == null) goto L31;
        Disposable r107 = r106.subscribe(new c(this, r104));
        if (r107 == null) goto L31;
        RxUtilKt.c(r107, this.f99930c);
    L31:
        if (r105 == null) goto L33;
        long r108 = r105.getDiggCount();
    L36:
        r102 = Long.valueOf(r108);
    L37:
        if (r102 == null) goto L39;
        long r109 = r102.longValue();
    L40:
        v(r109);
        return;
    L39:
        r109 = 0;
        goto L40
    L33:
        IRoom r110 = this.f99931d;
        if (r110 == null) goto L37;
        r108 = r110.getDiggCount();
    L23:
        r105 = null;
    L18:
        r104 = null;
        goto L19
    L7:
        if (r100.f549199b != true) goto L10;
        if (r100.f549200c == 1) goto L13;
    }

    public final void v(long r100) {
        if (a0.d(this.f99932e, false) == false) goto L17;
        u91.a r101 = this.f99963h;
        if (r101 != null) goto L7;
    L24:
        this.f99967l = r100;
        return;
    L7:
        if (r101.f549200c != 1) goto L24;
        b r102 = s(r100);
        String r103 = r102.f99969a;
        String r104 = r102.f99970b;
        String r105 = r103 + r104;
        UserInfoVM.Companion.getClass();
        aa1.a r106 = UserInfoVM.b.b();
        if (r106 == null) goto L13;
        ElementBasicVM r107 = r106.getBasicVm();
        if (r107 == null) goto L13;
        ElementBasicVM.updateAccessibilityDesc$default(r107, r105, null, 2, null);
    L13:
        RollingTextView r108 = this.f99966k;
        if (r108 == null) goto L16;
        r108.a(r103, u(r100, this.f99967l));
    L16:
        com.bytedance.android.live.room.navi.userinfo_p.flipper.core.e.e(this, r104);
        goto L24
    L17:
        b r109 = s(r100);
        String r110 = r109.f99969a;
        String r111 = r109.f99970b;
        String r112 = s1.B(R.string.live_room_current_room_digg_count_static);
        if (r112 != null) goto L20;
        r112 = "";
    L20:
        RollingTextView r113 = this.f99966k;
        if (r113 == null) goto L23;
        r113.a(r110, u(r100, this.f99967l));
    L23:
        com.bytedance.android.live.room.navi.userinfo_p.flipper.core.e.e(this, r111 + r112);
        goto L24
    }

    public final boolean u(long r100, long r101) {
        INavigationProxyService r102 = (INavigationProxyService) jc1.k.f(INavigationProxyService.class);
        if (r102 == null) goto L12;
        l81.d r103 = r102.getDiggContext(this.f99932e);
        if (r103 == null) goto L12;
        m<Boolean> r104 = r103.d(this.f99932e);
        if (r104 == null) goto L12;
        if (r104.getValue().booleanValue() == true) goto L12;
        return false;
    L12:
        if (t(r100) == t(r101)) goto L14;
        return false;
    L14:
        return true;
    }

    public g(IRoom r100, DataCenter r101, View r102) {
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, "itemView");
        super(r100, r101, r102);
    }
}
