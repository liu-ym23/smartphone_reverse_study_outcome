package com.bytedance.android.livesdk.authorize;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.user.IUserService;
import com.facebook.keyframes.model.KFAnimation;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes7.dex */
public final class r extends f {
    @Override // com.bytedance.android.livesdk.authorize.f
    public final int d() {
        return R.string.ttlive_authorize_account_content_button_done;
    }

    @Override // com.bytedance.android.livesdk.authorize.f
    public final int e() {
        return R.string.ttlive_authorize_account_content_button;
    }

    @Override // com.bytedance.android.livesdk.authorize.f
    public final int f() {
        return R.string.ttlive_authorize_relationship_chain_content;
    }

    @Override // com.bytedance.android.livesdk.authorize.f
    public final int g() {
        return R.string.ttlive_authorize_relationship_chain_title;
    }

    @Override // com.bytedance.android.livesdk.authorize.f
    public final void a() {
        AuthorizeGuideViewModel r100 = this.f104210f;
        AuthorizeGuideViewModel.d r101 = r100.f104131m;
        KProperty[] r102 = AuthorizeGuideViewModel.f104117r;
        KProperty r103 = r102[1];
        r101.getClass();
        Intrinsics.checkNotNullParameter(r103, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        if (r101.f104140a != null) goto L12;
        AuthorizeGuideViewModel.i r104 = new AuthorizeGuideViewModel.i(r100);
        IUserService r105 = (IUserService) jc1.k.n(IUserService.class);
        FragmentActivity r106 = r100.f104135q;
        gc1.c r107 = r100.f104121c.getValue();
        if (r107 == null) goto L9;
        String r108 = r107.b();
        if (r108 == null) goto L9;
    L10:
        r105.showVcdRelationshipGrant(r106, r108, r100.f104133o, r104);
        Unit r109 = Unit.INSTANCE;
        r100.f104131m.a(r102[1], r104);
        r100.a("relation");
        return;
    L9:
        r108 = "";
        goto L10
    }

    public r(AuthorizeGuideViewModel r100, AuthorizeGuideService.AuthorizeGuideDialog r101) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        super(r100, r101);
        AuthorizeGuideViewModel.e r102 = AuthorizeGuideViewModel.f104118s;
        b(AuthorizeGuideViewModel.e.a(r102, r100.f104124f));
        ((ObservableSubscribeProxy) AuthorizeGuideViewModel.e.a(r102, r100.f104123e).as(AutoDispose.bind(r101))).subscribe(new q(this));
    }
}
