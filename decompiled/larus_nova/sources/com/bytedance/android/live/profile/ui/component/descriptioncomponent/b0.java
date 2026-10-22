package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileBusinessArea;
import com.bytedance.android.live.base.model.user.ProfileOpenArea;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.livesdk.config.yk0;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.nova.R;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b0 extends com.bytedance.android.live.profile.ui.base.k implements qt0.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f86498g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f86499h = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f86500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f86501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c0 f86502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Context f86503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.profile.ui.base.h f86504f;

    public static final class a {
    }

    @Override // qt0.b
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
    }

    @Override // qt0.b
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r100) {
        Intrinsics.checkNotNullParameter(r100, "newUser");
    }

    static {
        f86498g = UtilityKotlinExtentionsKt.i(108);
        f86499h = UtilityKotlinExtentionsKt.i(38);
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
        c0 r100 = this.f86502d;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        this.f86502d = null;
        ViewGroup r101 = this.f86501c;
        if (r101 == null) goto L9;
        r101.removeAllViews();
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.MultiLinkPermanentRoom.INSTANCE;
    }

    public b0(com.bytedance.android.live.profile.profilecontext.a r100) {
        Intrinsics.checkNotNullParameter(r100, "profileContext");
        this.f86504f = r100;
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r100) {
        Context r101 = r100.getContext();
        if (r101 == null) goto L13;
        this.f86503e = r101;
        View r102 = ((com.bytedance.android.live.profile.ui.base.e) r100).f(R.layout.ttlive_profile_multi_link_permanent_chat_room_component, true);
        ViewGroup r103 = null;
        if (r102 == null) goto L7;
        View r104 = r102.findViewById(R.id.permanent_chat_room_root);
    L8:
        this.f86500b = r104;
        if (r104 == null) goto L11;
        r103 = (ViewGroup) r104.findViewById(R.id.lynx_dynamic_view);
    L11:
        this.f86501c = r103;
        return;
    L7:
        r104 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Context r101 = this.f86503e;
        if (r101 == null) goto L50;
        String r102 = yk0.f121697a.getValue();
        c0 r103 = this.f86502d;
        if (r103 == null) goto L8;
        r103.release();
    L8:
        ViewGroup.LayoutParams r104 = null;
        this.f86502d = null;
        ViewGroup r105 = this.f86501c;
        if (r105 == null) goto L11;
        r105.removeAllViews();
    L11:
        ProfileOpenArea r106 = r100.openArea;
        if (r106 == null) goto L16;
        ProfileBusinessArea r107 = r106.businessAreaV3;
        if (r107 == null) goto L16;
        com.bytedance.android.live.base.model.user.i0 r108 = r107.residentGuestBanner;
    L17:
        if (r108 == null) goto L19;
        List<IBaseUser> r109 = r108.a();
    L20:
        List<IBaseUser> r110 = r109;
        boolean r111 = true;
        int r112 = 0;
        if (r110 != null) goto L23;
    L26:
        boolean r113 = true;
    L27:
        boolean r114 = !r113;
        if (r108 == null) goto L30;
        IBaseUser r115 = r108.b();
    L31:
        if (r115 != null) goto L34;
        r111 = false;
    L34:
        String r116 = GsonProtectorUtils.toJson(GsonHelper.get(), r108);
        if (r114 == false) goto L37;
        r112 = f86498g;
    L39:
        ViewGroup r117 = this.f86501c;
        if (r117 == null) goto L45;
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
        if (r118 == null) goto L44;
        r118.height = r112;
        Unit r119 = Unit.INSTANCE;
        r104 = r118;
    L44:
        r117.setLayoutParams(r104);
    L45:
        this.f86502d = new c0(this, r101, x6.a.d(r102), s1.y());
        LinkedHashMap r120 = new LinkedHashMap();
        r120.put("resident_guest_data", r116);
        r120.put("target_user_id", r100.baseProfileInfo.getIdStr());
        c0 r121 = this.f86502d;
        if (r121 == null) goto L49;
        r121.d(r102, r120);
        return;
    L49:
        return;
    L37:
        if (r111 == false) goto L39;
        r112 = f86499h;
        goto L39
    L30:
        r115 = null;
        goto L31
    L23:
        if (r110.isEmpty() == true) goto L26;
        r113 = false;
        goto L27
    L19:
        r109 = null;
    L16:
        r108 = null;
        goto L17
    }
}
