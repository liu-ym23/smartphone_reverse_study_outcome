package com.bytedance.android.live.revenue.platform.hybrid.impl.ui;

import android.content.DialogInterface;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class HybridDialogImpl extends BaseHybridComponentContainer<HybridDialog> implements zy0.d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final bz0.e f91464e;

    public static final class a implements HybridDialog.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HybridDialogImpl f91465a;

        @Override // com.bytedance.android.annie.api.container.HybridDialog.a
        public final /* synthetic */ void onScroll(int r100) {
        }

        @Override // com.bytedance.android.annie.api.container.HybridDialog.a
        public final void onDismiss() {
            HybridDialogImpl r100 = this.f91465a;
            r100.f91464e.f21818f.c(new Object[]{((HybridDialog) r100.f91463d).getDialog()});
            if (((Boolean) f.f91477b.getValue(null, f.f91476a[0])).booleanValue() == false) goto L6;
            HybridDialogImpl.e(this.f91465a);
            return;
        }

        @Override // com.bytedance.android.annie.api.container.HybridDialog.a
        public final void onShow() {
            HybridDialogImpl r100 = this.f91465a;
            r100.f91464e.f21817e.c(new Object[]{((HybridDialog) r100.f91463d).getDialog()});
        }

        public a(HybridDialogImpl r100) {
            this.f91465a = r100;
        }
    }

    @Override // zy0.d
    public final void i() {
    }

    @Override // com.bytedance.android.live.revenue.common.j
    public final void d() {
        ((ArrayList) this.f91462c).clear();
        ((HybridDialog) this.f91463d).close();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // zy0.d
    public final DialogFragment p1() {
        return (DialogFragment) this.f91463d;
    }

    public static final void e(HybridDialogImpl r100) {
        ((ArrayList) r100.f91462c).clear();
    }

    public final void j(Function1<? super DialogInterface, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f91464e.f21817e.a(r100);
    }

    @Override // zy0.d
    public final void j0(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f91464e.f21819g.a(r100);
    }

    @Override // zy0.d
    public final void m1(Function1<? super DialogInterface, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f91464e.f21818f.a(r100);
    }

    public HybridDialogImpl(bz0.e r100, HybridDialog r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "originalDialog");
        super(r101, r100);
        this.f91464e = r100;
        ((HybridDialog) this.f91463d).T90(new a(this));
        ((HybridDialog) this.f91463d).X90(new AnonymousClass2(this));
    }
}
