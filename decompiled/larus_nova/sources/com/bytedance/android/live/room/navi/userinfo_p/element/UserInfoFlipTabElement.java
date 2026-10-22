package com.bytedance.android.live.room.navi.userinfo_p.element;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement;
import com.bytedance.android.live.room.navi.userinfo_p.presenter.UserInfoFlipPresenter;
import com.bytedance.android.livesdk.popup.manager.LivePopupWindow;
import com.bytedance.android.livesdk.utils.w0;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/element/UserInfoFlipTabElement;", "Lcom/bytedance/android/live/room/navi/userinfo_p/element/base/BaseElement;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoFlipTabElement extends BaseElement {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f99854o = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public UserInfoFlipPresenter f99855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f99856e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f99857f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.android.livesdk.user.e f99858g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ValueAnimator f99859h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CompositeDisposable f99860i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public o91.c f99861j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LivePopupWindow f99862k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f99863l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ViewGroup f99864m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ViewGroup f99865n;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void f() {
        this.f99861j = null;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final String g() {
        return "UserInfoFlipTabElement";
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void h() {
        ViewGroup r100 = this.f99865n;
        ViewGroup.LayoutParams r101 = null;
        if (r100 == null) goto L5;
        TextView r102 = (TextView) r100.findViewById(R.id.add_ticket_number);
    L6:
        this.f99856e = r102;
        ViewGroup r103 = this.f99865n;
        if (r103 == null) goto L9;
        TextView r104 = (TextView) r103.findViewById(R.id.add_ticket_name);
    L10:
        this.f99857f = r104;
        if (com.bytedance.android.live.misc.c.f83225a.getValue().booleanValue() == true) goto L13;
    L38:
        ViewGroup r105 = this.f99864m;
        if (r105 == null) goto L41;
        r101 = r105.getLayoutParams();
    L41:
        if (r101 == null) goto L46;
        r101.width = this.f99863l;
        ViewGroup r106 = this.f99864m;
        if (r106 == null) goto L46;
        r106.setLayoutParams(r101);
    L46:
        if (isAnchor() == true) goto L63;
        com.bytedance.android.livesdk.user.e r107 = this.f99858g;
        if (r107 == null) goto L63;
        IRoom r108 = getRoom();
        if (r108 == null) goto L53;
        String r109 = r108.getOwnerUserIdString();
        if (r109 == null) goto L53;
    L54:
        Observable<FollowPair> r110 = r107.u0(r109);
        if (r110 == null) goto L63;
        Observable<FollowPair> r111 = r110.subscribeOn(Schedulers.io());
        if (r111 == null) goto L63;
        Observable<FollowPair> r112 = r111.observeOn(AndroidSchedulers.mainThread());
        if (r112 == null) goto L63;
        Disposable r113 = r112.subscribe(new e(this), RxUtil.getNoOpThrowable());
        if (r113 == null) goto L63;
        this.f99860i.add(r113);
    L53:
        r109 = "0";
    L63:
        m(b().getMiddleVm().getShowProfileViewAnim().onEvent(), new UserInfoFlipTabElement$initVm$$inlined$run$lambda$1(this));
        return;
    L13:
        if (this.f99896c.isAnchor() == false) goto L38;
        if (a0.g(this.f99896c.getDataCenter()) == true) goto L38;
        ViewGroup r114 = this.f99864m;
        if (r114 == null) goto L19;
        r114.setOnClickListener(new w0(UserInfoFlipTabElement$onInit$1.INSTANCE, 1000));
    L19:
        xs1.a r115 = com.bytedance.android.live.misc.d.f83226a.getValue();
        if (r115 != null) goto L22;
    L26:
        boolean r116 = false;
    L27:
        if (r116 == false) goto L38;
        SharedPrefHelper r117 = SharedPrefHelper.b(this.f99896c.getContext());
        if (r117.f("live.pred.PREF_ANCHOR_BIZ_PABEL_POPUP", false) == true) goto L38;
        if (this.f99896c.a() == false) goto L38;
        ViewGroup r118 = this.f99864m;
        if (r118 == null) goto L35;
        r118.postDelayed(new f(this, r117), 15000);
    L35:
        ViewGroup r119 = this.f99864m;
        if (r119 == null) goto L38;
        r119.postDelayed(new g(this), 22000);
        goto L38
    L22:
        if (r115.a() == true) goto L26;
        if (r115.c() == false) goto L26;
        r116 = true;
        goto L27
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void j() {
        LivePopupWindow r100 = this.f99862k;
        if (r100 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        r100.dismiss();
    L5:
        this.f99860i.clear();
        o91.c r101 = this.f99861j;
        if (r101 == null) goto L9;
        r101.c();
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void i() {
        super.i();
        UserInfoFlipPresenter r100 = new UserInfoFlipPresenter(this.f99896c);
        Unit r101 = Unit.INSTANCE;
        this.f99855d = r100;
        this.f99858g = (com.bytedance.android.livesdk.user.e) getDataCenter().get("data_user_center", null);
        UserInfoFlipPresenter r102 = this.f99855d;
        if (r102 == null) goto L11;
        IRoom r103 = r102.b();
        if (r103 == null) goto L11;
        IBaseUser r104 = r103.getOwner();
        if (r104 == null) goto L11;
        py.j r105 = r104.getFollowInfo();
        if (r105 == null) goto L11;
        r105.getFollowerCount();
    L11:
        ViewGroup r106 = this.f99864m;
        if (r106 == null) goto L14;
        m91.c r107 = this.f99896c;
        this.f99861j = new o91.c(r107.getContext(), r107.getDataCenter(), r107.getRoomContext(), r106);
    L14:
        IRoom r108 = getRoom();
        if (r108 == null) goto L22;
        UserInfoFlipPresenter r109 = this.f99855d;
        if (r109 == null) goto L23;
        int r110 = r108.getAnchorTabType();
        int r111 = com.bytedance.android.live.room.navi.userinfo_p.utils.a.f100154a;
        int r112 = com.bytedance.android.live.room.navi.userinfo_p.utils.a.a(r110, r109.f100070e.getDataCenter());
        o91.c r113 = this.f99861j;
        if (r113 == null) goto L24;
        r113.e(r112);
        return;
    L24:
        return;
    L23:
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void k() {
        super.k();
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void l(IRoom r100) {
        super.l(r100);
    }

    public UserInfoFlipTabElement(m91.d r100, ViewGroup r101, ViewGroup r102) {
        Intrinsics.checkNotNullParameter(r100, "userInfoAbility");
        super(r100);
        this.f99864m = r101;
        this.f99865n = r102;
        this.f99860i = new CompositeDisposable();
        this.f99863l = UtilityKotlinExtentionsKt.i(66);
    }
}
