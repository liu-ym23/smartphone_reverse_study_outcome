package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.room.navi.userinfo_p.UserInfoContextExtKt;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.ElementBasicVM;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.ElementMiddleVM;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.UserInfoVM;
import com.bytedance.android.livesdk.widget.r;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class k extends CommonTabHolder {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f99977k = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f99978h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HSImageView f99979i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewGroup.MarginLayoutParams f99980j;

    public static final class a {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void k(u91.a r100) {
    }

    static {
        f99977k = s1.f(32.0f);
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder, w91.f
    public final q91.a c() {
        return new q91.a();
    }

    public final boolean r() {
        if (a0.i(this.f99932e) == false) goto L5;
    L12:
        boolean r100 = true;
    L13:
        if (r100 == false) goto L15;
        return false;
    L15:
        if (((IMiddlewareRoomService) jc1.k.n(IMiddlewareRoomService.class)).isNewFeedStyle(this.f99932e) == false) goto L17;
    L18:
        return true;
    L17:
        if (((IMiddlewareRoomService) jc1.k.n(IMiddlewareRoomService.class)).isNewStyleForTTLite(this.f99932e) == true) goto L18;
        return false;
    L5:
        if (a0.h(this.f99932e) == true) goto L12;
        if (a0.f(this.f99932e) == true) goto L12;
        if (a0.g(this.f99932e) == true) goto L12;
        r100 = false;
        goto L13
    }

    public final void s() {
        IRoom r100 = this.f99931d;
        if (r100 == null) goto L23;
        IBaseUser r101 = r100.getOwner();
        if (r101 == null) goto L24;
        UserInfoVM.Companion.getClass();
        aa1.a r102 = UserInfoVM.b.b();
        if (r102 == null) goto L11;
        ElementBasicVM r103 = r102.getBasicVm();
        if (r103 == null) goto L11;
        ElementBasicVM.updateAccessibilityDesc$default(r103, r101.getRemarkNameOrRealNickName(), null, 2, null);
    L11:
        String r104 = r101.getRemarkNameOrNickname();
        TextView r105 = this.f99978h;
        if (r105 == null) goto L27;
        r105.setText(r104);
        if (r() == true) goto L17;
        return;
    L17:
        if (r105.getIncludeFontPadding() == true) goto L26;
        boolean r106 = false;
        r105.measure(0, 0);
        if (r105.getMeasuredHeight() <= s1.f(18.0f)) goto L21;
        r106 = true;
    L21:
        r105.setIncludeFontPadding(r106);
        return;
    L26:
        return;
    L27:
        return;
    L24:
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void l() {
        View r100 = null;
        if (r() == true) goto L5;
    L20:
        View r101 = this.f99933f.findViewById(R.id.user_name);
        if ((r101 instanceof TextView) == false) goto L24;
        r100 = r101;
    L24:
        this.f99978h = (TextView) r100;
    L26:
        if (UIUtils.getScreenWidth(this.f99933f.getContext()) >= 500) goto L31;
        TextView r102 = this.f99978h;
        if (r102 == null) goto L31;
        r102.setMaxWidth(100);
    L31:
        if (r.b() == false) goto L35;
        int r103 = s1.f(26.0f);
        TextView r104 = this.f99978h;
        if (r104 == null) goto L38;
        r104.setMinWidth(r103);
    L38:
        UIUtils.setViewVisibility(this.f99978h, 0);
        return;
    L35:
        int r105 = f99977k;
        TextView r106 = this.f99978h;
        if (r106 == null) goto L38;
        r106.setMinWidth(r105);
        goto L38
    L5:
        if (r.b() == false) goto L20;
        View r107 = this.f99933f.findViewById(R.id.user_name);
        if ((r107 instanceof View) == true) goto L9;
        r107 = null;
    L9:
        UIUtils.setViewVisibility(r107, 8);
        View r108 = this.f99933f.findViewById(R.id.user_name_with_tag_layout);
        if ((r108 instanceof View) == true) goto L12;
        r108 = null;
    L12:
        UIUtils.setViewVisibility(r108, 0);
        View r109 = this.f99933f.findViewById(R.id.user_name_new);
        if ((r109 instanceof TextView) == true) goto L15;
        r109 = null;
    L15:
        this.f99978h = (TextView) r109;
        View r110 = this.f99933f.findViewById(R.id.user_verify_tag);
        if ((r110 instanceof HSImageView) == false) goto L19;
        r100 = r110;
    L19:
        this.f99979i = (HSImageView) r100;
        goto L26
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void n() {
        s();
        UserInfoVM.Companion.getClass();
        aa1.a r100 = UserInfoVM.b.b();
        if (r100 == null) goto L8;
        ElementMiddleVM r101 = r100.getMiddleVm();
        if (r101 == null) goto L9;
        j(UserInfoContextExtKt.b(r101.getUserNameViewVisibility(), new UserInfoNicknameHolder$initEvent$$inlined$run$lambda$1(this)));
        j(RxUtilKt.h(r101.getChangeHeightWhenEmpty().onEvent()).subscribe(new l(this)));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void p() {
        super.p();
        ViewGroup.MarginLayoutParams r100 = this.f99980j;
        if (r100 == null) goto L11;
        TextView r101 = this.f99978h;
        if (r101 == null) goto L9;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L9;
        r102.height = r100.height;
    L9:
        UIUtils.updateLayoutMargin(this.f99933f, r100.leftMargin, r100.topMargin, r100.rightMargin, r100.bottomMargin);
    L11:
        if (this.f99978h != null) goto L13;
    L17:
        UIUtils.setViewVisibility(this.f99979i, 8);
        return;
    L13:
        if (r() == false) goto L17;
        TextView r103 = this.f99978h;
        if (r103 == null) goto L17;
        r103.setIncludeFontPadding(false);
        goto L17
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder, w91.f
    public final w91.a g() {
        return r91.e.f536703b;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void o(IRoom r100) {
        this.f99931d = r100;
        if (r100 == null) goto L7;
        IBaseUser r101 = r100.getOwner();
        if (r101 == null) goto L7;
        int r102 = r.f161945a;
        r.a(this.f99979i, r101);
    L7:
        s();
    }

    public k(IRoom r100, DataCenter r101, View r102) {
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, "itemView");
        super(r100, r101, r102);
    }
}
