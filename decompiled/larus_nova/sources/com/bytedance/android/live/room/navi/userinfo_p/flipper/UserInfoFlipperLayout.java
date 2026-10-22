package com.bytedance.android.live.room.navi.userinfo_p.flipper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.core.BaseTabFlipper;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import r91.d;
import w91.e;
import w91.f;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/UserInfoFlipperLayout;", "Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/core/BaseTabFlipper;", "Lv91/a;", "m", "Lv91/a;", "getTabFlipSynchronizer", "()Lv91/a;", "setTabFlipSynchronizer", "(Lv91/a;)V", "tabFlipSynchronizer", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoFlipperLayout extends BaseTabFlipper {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f99914n = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public v91.a f99915m;

    public static final class a {
    }

    public static final class b implements w91.a.InterfaceC8082a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w91.a f99916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UserInfoFlipperLayout f99917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f99918c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ f f99919d;

        @Override // w91.a.InterfaceC8082a
        public final void a() {
            this.f99916a.d();
            e r100 = com.bytedance.android.live.room.navi.userinfo_p.flipper.core.e.b(this.f99918c);
            ALogger.i("UserInfoFlipperLayout", "on execute done.the fliperData is :" + r100);
            UserInfoFlipperLayout r101 = this.f99917b;
            int r102 = UserInfoFlipperLayout.f99914n;
            if (Intrinsics.areEqual(r101.getNextTabExecutor(), this.f99916a) == false) goto L11;
            WeakReference<View> r103 = this.f99917b.getDisplayView();
            if (r103 == null) goto L7;
            View r104 = r103.get();
        L9:
            if (Intrinsics.areEqual(r104, this.f99918c) == false) goto L11;
            this.f99917b.l(this.f99919d);
            return;
        L7:
            r104 = null;
        L11:
            ALogger.i("UserInfoFlipperLayout", "don't execute next because the executor has changed." + r100);
            ALogger.i("UserInfoFlipperLayout", "curPos:" + this.f99917b.getCurShowPos() + "\tthe fipperData" + r100 + "\tisAutoFlip:" + this.f99917b.getFlipping() + "\tisExecutingNext:" + this.f99917b.g());
        }

        public b(w91.a r100, UserInfoFlipperLayout r101, View r102, f r103) {
            this.f99916a = r100;
            this.f99917b = r101;
            this.f99918c = r102;
            this.f99919d = r103;
        }
    }

    static {
    }

    public UserInfoFlipperLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public UserInfoFlipperLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.core.BaseTabFlipper
    public final void d() {
        WeakReference<View> r100 = getDisplayView();
        if (r100 == null) goto L5;
        View r101 = r100.get();
    L6:
        w91.b<? extends Object, ? extends f> r102 = getAdapter();
        if ((r102 instanceof w91.b) == true) goto L9;
        r102 = null;
    L9:
        if (r102 == null) goto L11;
        int r103 = r102.getItemSize();
    L12:
        setExpectAdapterCount(r103);
        if (r101 == null) goto L32;
        BaseTabFlipper.LayoutParams r104 = com.bytedance.android.live.room.navi.userinfo_p.flipper.core.e.a(r101);
        if (r104 == null) goto L33;
        Object r105 = r104.f100027b;
        if (r105 != 0) goto L19;
        return;
    L19:
        f r106 = r104.f100026a;
        if (r106 != null) goto L23;
        return;
    L23:
        if (r102 == null) goto L25;
        int r107 = r102.getDataPosition(r105);
    L26:
        if (r107 >= 0) goto L34;
        c();
        if (r103 > 0) goto L30;
        setDisplayView(null);
        setCurShowPos(-1);
        b();
        h();
        return;
    L30:
        l(r106);
        return;
    L34:
        return;
    L25:
        r107 = -1;
        goto L26
    L33:
        return;
    L32:
        return;
    L11:
        r103 = 0;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    public final v91.a getTabFlipSynchronizer() {
        return this.f99915m;
    }

    public final void l(f r100) {
        if (r100.d(com.bytedance.android.live.room.navi.userinfo_p.flipper.core.e.c(r100)) == false) goto L11;
        v91.a r101 = this.f99915m;
        if (r101 == null) goto L11;
        if (r101.a(this) != true) goto L11;
        ALogger.i("UserInfoFlipperLayout", "execute：do sync");
        v91.a r102 = this.f99915m;
        if (r102 == null) goto L13;
        r102.b(this);
        return;
    L13:
        return;
    L11:
        ALogger.i("UserInfoFlipperLayout", "execute：to show next");
        i();
    }

    public final void setTabFlipSynchronizer(v91.a r100) {
        this.f99915m = r100;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.core.BaseTabFlipper
    public final void e(f r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "enterHolder");
        Intrinsics.checkNotNullParameter(r101, "enterView");
        ALogger.i("UserInfoFlipperLayout", "start executeNextTabJob,the flipper data is:" + com.bytedance.android.live.room.navi.userinfo_p.flipper.core.e.b(r101));
        c();
        if (getFlipping() == false) goto L10;
        com.bytedance.android.live.room.navi.userinfo_p.flipper.core.e.c(r100);
        if (r100.f() == false) goto L7;
        w91.a r102 = d.f536700c;
    L8:
        b r103 = new b(r102, this, r101, r100);
        r102.b(r103);
        Unit r104 = Unit.INSTANCE;
        setExecutorCallback(r103);
        setNextTabExecutor(r102);
        setNextTabDisposable(r102.execute());
        return;
    L7:
        r102 = r100.g();
        goto L8
    }

    public UserInfoFlipperLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ UserInfoFlipperLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
