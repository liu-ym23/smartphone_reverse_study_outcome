package com.bytedance.android.livesdk.gift.platform.business;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectedStatus;
import com.bytedance.android.livesdk.gift.platform.core.model.n;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class l implements h, f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Context> f129748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f129749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f129750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ k f129751d;

    public boolean A(AbsPanel<?> r110, int r111, int r210, IBaseUser r211, boolean r212, List<? extends IBaseUser> r213, boolean r214, n r215, com.bytedance.android.livesdk.gift.platform.core.model.k r216, com.bytedance.android.livesdk.gift.platform.core.model.k r217, l1 r218, com.bytedance.android.livesdk.gift.model.n r219, String r310, String r311, com.bytedance.android.livesdk.gift.platform.core.model.a r312) {
        Intrinsics.checkNotNullParameter(r211, "toUser");
        Intrinsics.checkNotNullParameter(r215, "showInfo");
        this.f129751d.A(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312);
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.h
    public com.bytedance.android.livesdk.gift.platform.business.dialog.topview.i<?> E() {
        this.f129750c.getClass();
        return null;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.h
    public final void a() {
        this.f129750c.getClass();
    }

    public void c() {
        this.f129751d.getClass();
    }

    public void d(AbsPanel r100) {
        this.f129751d.getClass();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.f
    public final void h() {
        this.f129751d.getClass();
    }

    public void j(long r100, Integer r101) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.f
    public final void n() {
        this.f129751d.getClass();
    }

    public boolean o(AbsPanel<?> r110, int r111, int r210, IBaseUser r211, boolean r212, List<? extends IBaseUser> r213, n r214, com.bytedance.android.livesdk.gift.platform.core.model.k r215, com.bytedance.android.livesdk.gift.platform.core.model.k r216, l1 r217, com.bytedance.android.livesdk.gift.model.n r218, String r219, int r310, String r311, com.bytedance.android.livesdk.gift.platform.core.model.a r312) {
        Intrinsics.checkNotNullParameter(r211, "toUser");
        Intrinsics.checkNotNullParameter(r214, "showInfo");
        this.f129751d.o(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312);
        return false;
    }

    public void q() {
        this.f129751d.getClass();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.f
    public void s() {
        this.f129751d.getClass();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.h
    public void w() {
        this.f129750c.getClass();
    }

    public boolean x(AbsPanel<?> r100, SelectedStatus r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r101, "selectedStatus");
        return false;
    }

    public GiftPluginType F() {
        this.f129750c.getClass();
        return k.f129746a;
    }

    public final Context getContext() {
        return this.f129748a.get();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.h
    public void onDestroy() {
        this.f129748a.clear();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.h
    public AbsPanel<?> f(h1 r100) {
        Intrinsics.checkNotNullParameter(r100, PbRequest.SwitchType.GIFT);
        this.f129750c.getClass();
        Intrinsics.checkNotNullParameter(r100, PbRequest.SwitchType.GIFT);
        return null;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.h
    public void g(w1 r100) {
        Intrinsics.checkNotNullParameter(r100, "page");
        this.f129750c.getClass();
        Intrinsics.checkNotNullParameter(r100, "page");
    }

    public void i(h1 r100) {
        Intrinsics.checkNotNullParameter(r100, PbRequest.SwitchType.GIFT);
        this.f129751d.getClass();
        Intrinsics.checkNotNullParameter(r100, PbRequest.SwitchType.GIFT);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.h
    public void k(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f129750c.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public void y(p2 r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        this.f129751d.getClass();
        Intrinsics.checkNotNullParameter(r100, "result");
    }

    public l(DataCenter r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        k r102 = k.f129747b;
        this.f129750c = r102;
        this.f129751d = r102;
        this.f129749b = r100;
        this.f129748a = new WeakReference(r101);
    }
}
