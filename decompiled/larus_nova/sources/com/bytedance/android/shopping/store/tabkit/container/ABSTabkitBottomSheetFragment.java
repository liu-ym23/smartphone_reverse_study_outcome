package com.bytedance.android.shopping.store.tabkit.container;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.n1;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/container/ABSTabkitBottomSheetFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ABSTabkitBottomSheetFragment extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TabKitBottomSheetBehavior<View> f186638d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f186639e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Boolean> f186640f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedList<b> f186641g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f186642h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f186643i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f186644j;

    public static final class a {
    }

    public interface b {
        void a();
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ABSTabkitBottomSheetFragment f186645a;

        public c(ABSTabkitBottomSheetFragment r100) {
            this.f186645a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Dialog r100 = this.f186645a.getDialog();     // Catch: Throwable -> L8
            if (r100 == null) goto L11;
            Window r101 = r100.getWindow();     // Catch: Throwable -> L8
            if (r101 == null) goto L15;
            r101.setWindowAnimations(R.style.commerce_dialog_dim_non_enter_animation);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    static {
    }

    public abstract int S90();

    public void U90(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    public void V90(boolean r100) {
    }

    public void W90(float r100) {
    }

    public abstract int getLayoutId();

    public int T90() {
        if (this.f186642h != 3) goto L5;
        return 0;
    L5:
        n1.f45660i.getClass();
        return n1.a.b();
    }

    public ABSTabkitBottomSheetFragment() {
        this.f186641g = new LinkedList();
        this.f186642h = 1;
        this.f186643i = true;
        this.f186644j = true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        View r100 = getView();     // Catch: Exception -> L7
        if (r100 == null) goto L12;
        r100.postDelayed(new c(this), 300);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public final void X90(int r100) {
        this.f186642h = r100;
        if (r100 == 1) goto L18;
        if (r100 == 2) goto L8;
        return;
    L8:
        if (this.f186644j == true) goto L14;
        TabKitBottomSheetBehavior<View> r101 = this.f186638d;
        if (r101 == null) goto L12;
        r101.f186662e = true;
    L12:
        if (r101 == null) goto L14;
        r101.f186667j = true;
    L14:
        TabKitBottomSheetBehavior<View> r102 = this.f186638d;
        if (r102 == null) goto L28;
        r102.setState(3);
        return;
    L28:
        return;
    L18:
        if (this.f186644j == true) goto L24;
        TabKitBottomSheetBehavior<View> r103 = this.f186638d;
        if (r103 == null) goto L22;
        r103.f186662e = false;
    L22:
        if (r103 == null) goto L24;
        r103.f186667j = false;
    L24:
        TabKitBottomSheetBehavior<View> r104 = this.f186638d;
        if (r104 == null) goto L30;
        r104.setState(4);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        if (this.f186642h != 3) goto L5;
    L23:
        Dialog r101 = getDialog();
        if (r101 == null) goto L28;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L28;
        r102.setBackgroundDrawableResource(R.color.commerce_color_00000000);
    L28:
        Dialog r103 = getDialog();
        if (r103 == null) goto L31;
        r103.setOnDismissListener(this);
    L31:
        Dialog r104 = getDialog();
        if (r104 == null) goto L34;
        r104.setOnShowListener(new com.bytedance.android.shopping.store.tabkit.container.a(this));
    L34:
        Dialog r105 = getDialog();
        if (r105 == null) goto L37;
        r105.setOnKeyListener(new com.bytedance.android.shopping.store.tabkit.container.b(this));
    L37:
        Dialog r106 = getDialog();
        if (r106 == null) goto L43;
        View r107 = r106.findViewById(R.id.touch_outside);
        if (r107 == null) goto L44;
        r107.setOnClickListener(new com.bytedance.android.shopping.store.tabkit.container.c(this));
        return;
    L44:
        return;
    L43:
        return;
    L5:
        if (this.f186639e != null) goto L23;
        Dialog r108 = getDialog();
        ViewGroup.LayoutParams r109 = null;
        if (r108 == null) goto L11;
        Window r110 = r108.getWindow();
        if (r110 == null) goto L11;
        View r111 = r110.findViewById(R.id.ec_tabkit_commerce_design_bottom_sheet);
    L12:
        this.f186639e = r111;
        this.f186638d = new TabKitBottomSheetBehavior();
        View r112 = this.f186639e;
        if (r112 == null) goto L15;
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
    L17:
        if ((r113 instanceof CoordinatorLayout.LayoutParams) == false) goto L20;
        r109 = r113;
    L20:
        CoordinatorLayout.LayoutParams r114 = (CoordinatorLayout.LayoutParams) r109;
        if (r114 == null) goto L23;
        r114.setBehavior(this.f186638d);
        goto L23
    L15:
        r113 = null;
    L11:
        r111 = null;
        goto L12
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        Dialog r101 = getDialog();
        if (r101 == null) goto L5;
        r101.requestWindowFeature(1);
    L5:
        super.onCreate(r100);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        return new TabKitToggleBottomSheetDialog(requireContext(), S90());
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Context r103 = getContext();
        if (r103 != null) goto L7;
        return null;
    L7:
        return th.a.c(r103, getLayoutId(), r101, false);
    }
}
