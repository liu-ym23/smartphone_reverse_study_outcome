package com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.CommonShelfDisplayViewModel;
import com.bytedance.android.livesdk.chatroom.widget.SpaceItemDecoration;
import com.bytedance.android.livesdk.e;
import com.bytedance.android.livesdk.f;
import com.bytedance.android.livesdk.widget.MaxHeightRecyclerView;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;
import zo0.g;
import zo0.h;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b&\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u00020\u00032\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/CommonShelfDisplayDialog;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/viewmodel/CommonShelfDisplayViewModel;", "VM", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class CommonShelfDisplayDialog<VM extends CommonShelfDisplayViewModel<?>> extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f85060i = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f85061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f85062e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f85063f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f85064g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MultiTypeAdapter f85065h;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonShelfDisplayDialog f85066a;

        public b(CommonShelfDisplayDialog r100) {
            this.f85066a = r100;
        }

        public final void a() {
            MaxHeightRecyclerView r100 = (MaxHeightRecyclerView) this.f85066a.T90(R.id.shelf_page_list);
            Integer r101 = Integer.valueOf(this.f85066a.U90());
            if (r101.intValue() == 0) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == true) goto L9;
            r101 = null;
        L9:
            if (r101 == null) goto L11;
            int r103 = r101.intValue();
        L12:
            r100.setMaxHeight(r103 - this.f85066a.X90().getHeight());
            ((MaxHeightRecyclerView) this.f85066a.T90(R.id.shelf_page_list)).requestLayout();
            return;
        L11:
            int r104 = CommonShelfDisplayDialog.f85060i;
            r103 = CommonShelfDisplayDialog.f85060i;
            goto L12
        L5:
            r102 = false;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements LinkCastItemViewHolder.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonShelfDisplayDialog f85067a;

        @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.LinkCastItemViewHolder.a
        public final void onClick() {
            this.f85067a.W90().openLinkCastPage();
        }

        public c(CommonShelfDisplayDialog r100) {
            this.f85067a = r100;
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonShelfDisplayDialog f85068a;

        public d(CommonShelfDisplayDialog r100) {
            this.f85068a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == true) goto L12;
            return;
        L12:
            this.f85068a.dismissAllowingStateLoss();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L15;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public abstract int U90();

    public final VM W90() {
        return (VM) this.f85062e.getValue();
    }

    public abstract View Y90(View r100);

    public abstract VM Z90();

    static {
        f85060i = UtilityKotlinExtentionsKt.i(592);
    }

    public void S90() {
        this.f85061d.clear();
    }

    public final MultiTypeAdapter V90() {
        MultiTypeAdapter r100 = this.f85065h;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("shelfDisplayAdapter");
    L5:
        return r100;
    }

    public final View X90() {
        View r100 = this.f85064g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topView");
    L5:
        return r100;
    }

    public CommonShelfDisplayDialog() {
        new CompositeDisposable();
        this.f85061d = new LinkedHashMap();
        this.f85062e = InfraKotlinExtsKt.mainThreadLazy(new CommonShelfDisplayDialog$shelfDisplayViewModel$2(this));
    }

    public void initView() {
        ((MaxHeightRecyclerView) T90(R.id.shelf_page_list)).post(new b(this));
        ((MaxHeightRecyclerView) T90(R.id.shelf_page_list)).setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        ((MaxHeightRecyclerView) T90(R.id.shelf_page_list)).addItemDecoration(new SpaceItemDecoration(1, UtilityKotlinExtentionsKt.i(8), true));
        MultiTypeAdapter r100 = new MultiTypeAdapter();
        ((MaxHeightRecyclerView) T90(R.id.shelf_page_list)).setAdapter(r100);
        Unit r101 = Unit.INSTANCE;
        this.f85065h = r100;
        r100.z2(wq0.a.class, new com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.a(new c(this)));
        W90().getDismiss().observe(this, new d(this));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    public View T90(int r100) {
        if (this.f85061d != null) goto L5;
        this.f85061d = new LinkedHashMap();
    L5:
        Map<Integer, View> r101 = this.f85061d;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        View r103 = (View) r102.get(Integer.valueOf(R.id.shelf_page_list));
        if (r103 != null) goto L14;
        View r104 = getView();
        if (r104 == null) goto L12;
        View r105 = r104.findViewById(R.id.shelf_page_list);
        if (r105 == null) goto L12;
        this.f85061d.put(Integer.valueOf(R.id.shelf_page_list), r105);
        return r105;
    L12:
        return null;
    L14:
        return r103;
    }

    public final void aa0(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "fragmentActivity");
        FragmentManager r101 = r100.getSupportFragmentManager();
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, "CommonShelfDisplayDialog", r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, this, r102) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        show(r101, "CommonShelfDisplayDialog");
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L12
        super.dismissAllowingStateLoss();     // Catch: Exception -> L5 Throwable -> L12
    L9:
        e.b().d();     // Catch: Throwable -> L12
        f.d().f();     // Catch: Throwable -> L12
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r101 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r101 == null) goto L9;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Dialog r102 = getDialog();
        if (r102 == null) goto L28;
        Window r103 = r102.getWindow();
        if (r103 == null) goto L28;
        r103.setLayout(-1, -1);
        int r104 = U90();
        FrameLayout r105 = (FrameLayout) r103.findViewById(R.id.design_bottom_sheet);
        if (r105 == null) goto L9;
        r105.getLayoutParams().width = -1;
        r105.getLayoutParams().height = -2;
        r105.setBackgroundResource(android.R.color.transparent);
    L9:
        BottomSheetBehavior r106 = BottomSheetBehavior.from(r105);
        r106.setHideable(false);
        Integer r107 = Integer.valueOf(r104);
        if (r107.intValue() == 0) goto L12;
        boolean r108 = true;
    L13:
        if (r108 == true) goto L16;
        r107 = null;
    L16:
        if (r107 == null) goto L18;
        int r109 = r107.intValue();
    L19:
        r106.setPeekHeight(r109);
        if (r104 == 0) goto L28;
        View r110 = this.f85063f;
        if (r110 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L24:
        if (r110 == null) goto L27;
        ConstraintLayout r111 = (ConstraintLayout) r110;
        Intrinsics.checkNotNullParameter(r111, "$this$setHeight");
        r111.getLayoutParams().height = r104;
        r111.requestLayout();
        r111.setMinHeight(0);
        r111.setMaxHeight(Integer.MAX_VALUE);
        goto L28
    L27:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    L18:
        r109 = f85060i;
        goto L19
    L12:
        r108 = false;
    L28:
        W90().initData();
        initView();
        HashMap<String, zo0.f> r112 = g.f573094a;
        zo0.f r113 = h.b(PerformanceScene.SHELF_DIALOG);
        int r114 = zo0.f.f573090d;
        r113.l("view_created", null);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void show(FragmentManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        if (isAdded() == false) goto L6;
        return;
    L6:
        if (r100.findFragmentByTag(r101) == null) goto L8;
        return;
    L8:
        e.b().a();
        f.d().a();
        FragmentTransaction r102 = r100.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r102, this, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r101, 0) == true) goto L12;
        r102.add(this, r101);
    L12:
        r102.commitAllowingStateLoss();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.ttlive_miniapp_shelf_page, r101, false);
        this.f85063f = r103;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        this.f85064g = Y90(r103);
        View r104 = this.f85063f;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L8:
        return r104;
    }
}
