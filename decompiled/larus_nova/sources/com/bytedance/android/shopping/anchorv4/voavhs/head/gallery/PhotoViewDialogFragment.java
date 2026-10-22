package com.bytedance.android.shopping.anchorv4.voavhs.head.gallery;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView;
import com.bytedance.android.ui.ec.widget.photodraweeview.OnPageSelectedListener;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/gallery/PhotoViewDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PhotoViewDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView f168619d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f168620e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OnPageSelectedListener f168621f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Unit> f168622g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f168623h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f168624i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList<IIndicatorView> f168625j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f168626k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f168627l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TransitionPagerAdapter<?> f168628m;

    public void T90(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
    }

    public void U90(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
    }

    public void onPageSelected(int r100, boolean r101) {
    }

    public final RecyclerView V90() {
        RecyclerView r100 = this.f168619d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pager");
    L5:
        return r100;
    }

    public final FrameLayout W90() {
        FrameLayout r100 = this.f168620e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
    L5:
        return r100;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismiss() {
        this.f168628m.onDestroy();
        super.dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L12;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public void Y90() {
        dismiss();     // Catch: Exception -> L4
    L8:
        FragmentActivity r100 = getActivity();
        if (r100 == null) goto L14;
        r100.finish();
        return;
    L14:
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L8;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Dialog r100 = getDialog();
        if (r100 != null) goto L5;
    L12:
        this.f168628m.onDestroy();
    L13:
        Function0<Unit> r101 = this.f168622g;
        if (r101 == null) goto L19;
        Unit r102 = r101.invoke();
        return;
    L19:
        return;
    L5:
        if (r100.isShowing() != true) goto L12;
        dismiss();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r103 = DialogFragmentLancet.sLastShowStack;
        if (r103 == null) goto L13;
        com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L13
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Dialog r100 = getDialog();
        if (r100 == null) goto L12;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L13;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r101.setLayout(-1, -1);
        r101.setBackgroundDrawable(new ColorDrawable(0));
        r101.clearFlags(2);
        int r103 = Build.VERSION.SDK_INT;
        r101.addFlags(Integer.MIN_VALUE);
        S90(r101).setSystemUiVisibility(1280);
        if (r103 <= 28) goto L10;
        r102.layoutInDisplayCutoutMode = 1;
    L10:
        S90(r101).setPadding(0, 0, 0, 0);
        return;
    L13:
        return;
    }

    public PhotoViewDialogFragment(TransitionPagerAdapter<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "transitionAdapter");
        this.f168628m = r100;
        this.f168623h = -1;
        Rect r101 = new Rect();
        Dialog r102 = getDialog();
        int r103 = 0;
        if (r102 == null) goto L11;
        Window r104 = r102.getWindow();
        if (r104 == null) goto L11;
        WindowManager r105 = r104.getWindowManager();
        if (r105 == null) goto L11;
        Display r106 = r105.getDefaultDisplay();
        if (r106 == null) goto L11;
        int r107 = r106.getWidth();
    L12:
        Dialog r108 = getDialog();
        if (r108 == null) goto L21;
        Window r109 = r108.getWindow();
        if (r109 == null) goto L21;
        WindowManager r110 = r109.getWindowManager();
        if (r110 == null) goto L21;
        Display r111 = r110.getDefaultDisplay();
        if (r111 == null) goto L21;
        r103 = r111.getHeight();
    L21:
        int r112 = r107 / 2;
        r101.left = r112;
        int r113 = r103 / 2;
        r101.top = r113;
        r101.right = r112;
        r101.bottom = r113;
        Unit r114 = Unit.INSTANCE;
        this.f168625j = new ArrayList();
        this.f168626k = 1.0f;
        this.f168627l = 1.0f;
        return;
    L11:
        r107 = 0;
        goto L12
    }

    public static View S90(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public void X90(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        FrameLayout r101 = new FrameLayout(r100);
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Unit r102 = Unit.INSTANCE;
        this.f168620e = r101;
        RecyclerView r103 = new RecyclerView(r100);
        r103.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f168619d = r103;
        final LinearLayoutManager r104 = new LinearLayoutManager(r100);
        RecyclerView r105 = this.f168619d;
        if (r105 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pager");
    L5:
        r104.setOrientation(0);
        r105.setLayoutManager(r104);
        PagerSnapHelper r106 = new PagerSnapHelper();
        RecyclerView r107 = this.f168619d;
        if (r107 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("pager");
    L8:
        r106.attachToRecyclerView(r107);
        FrameLayout r108 = this.f168620e;
        if (r108 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
    L11:
        RecyclerView r109 = this.f168619d;
        if (r109 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("pager");
    L14:
        r108.addView(r109, 0);
        RecyclerView r110 = this.f168619d;
        if (r110 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("pager");
    L17:
        r110.addOnScrollListener(new PhotoViewDialogFragment$initAllViews$4(this, r104));
        RecyclerView r111 = this.f168619d;
        if (r111 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("pager");
    L20:
        r111.setAdapter(this.f168628m);
        this.f168628m.setInternalTransitionListener(new k(this));
        this.f168628m.registerAdapterDataObserver(new PhotoViewDialogFragment$initAdapter$2(this));
    }

    public final void Z90(int r100) {
        if (this.f168623h == r100) goto L13;
        this.f168623h = r100;
        Iterator<IIndicatorView> r101 = this.f168625j.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        r101.next().onPageSelected(this.f168623h);
        goto L6
    L8:
        onPageSelected(this.f168623h, false);
        OnPageSelectedListener r102 = this.f168621f;
        if (r102 == null) goto L14;
        r102.onPageSelected(this.f168623h);
        return;
    L14:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        X90(r100);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, 0);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        FrameLayout r103 = this.f168620e;
        if (r103 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
    L17:
        r103.setBackgroundColor(com.bytedance.android.shopping.extensions.j.b(R.color.black));     // Catch: Throwable -> L8
    L11:
        if (this.f168624i == false) goto L16;
        FrameLayout r104 = this.f168620e;
        if (r104 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
    L15:
        r104.getBackground().setAlpha(0);
        this.f168626k = 0.0f;
    L16:
        return r103;
    L8:
        th = move-exception;
        ECExceptionMonitor.e(th);
        goto L11
    }
}
