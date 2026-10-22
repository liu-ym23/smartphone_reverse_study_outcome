package com.bytedance.android.livesdk;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.pannel.SheetBaseBehavior;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment;
import com.bytedance.android.livesdk.widget.LiveStandardSheetDialog;
import com.bytedance.android.livesdkapi.util.JavaCalls;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 C2\u00020\u0001:\u0001DB\u0007¢\u0006\u0004\bA\u0010BJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u001a\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010 \u001a\u00020\u001fH\u0014R*\u0010\"\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f8\u0006@DX\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\u00020\u001f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b'\u0010#\u001a\u0004\b'\u0010$\"\u0004\b(\u0010&R\"\u0010)\u001a\u00020\u001f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b)\u0010#\u001a\u0004\b*\u0010$\"\u0004\b+\u0010&R\"\u0010,\u001a\u00020\u001f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b,\u0010#\u001a\u0004\b-\u0010$\"\u0004\b.\u0010&R*\u00101\u001a\u00020/2\u0006\u00100\u001a\u00020/8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R*\u00108\u001a\u0002072\u0006\u00100\u001a\u0002078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0018\u0010>\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0011\u0010@\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b@\u0010$¨\u0006E"}, d2 = {"Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/livesdk/widget/LiveBottomSheetDialogFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", WidgetCostModule.TYPE_ON_CREATE, "Landroid/app/Dialog;", "onCreateDialog", "Landroid/view/View;", "view", "onViewCreated", "onActivityCreated", "", "getContentViewHeight", "onDestroyView", "Landroid/content/DialogInterface;", "dialog", "onCancel", "Landroid/content/DialogInterface$OnDismissListener;", "listener", "setOnDismissListener", "onDismiss", "Landroidx/fragment/app/FragmentTransaction;", "transaction", "", "tag", "show", "Landroidx/fragment/app/FragmentManager;", "manager", "showNow", "dismiss", "", "onBackPressed", "<set-?>", "isViewValid", "Z", "()Z", "setViewValid", "(Z)V", "isVertical", "setVertical", "banLandscapeStyleSetting", "getBanLandscapeStyleSetting", "setBanLandscapeStyleSetting", "noTitleAndCancelOutside", "getNoTitleAndCancelOutside", "setNoTitleAndCancelOutside", "Lcom/bytedance/android/livesdk/widget/LiveBottomSheetDialog$m;", "value", "bottomSheetSlideProcessor", "Lcom/bytedance/android/livesdk/widget/LiveBottomSheetDialog$m;", "getBottomSheetSlideProcessor", "()Lcom/bytedance/android/livesdk/widget/LiveBottomSheetDialog$m;", "setBottomSheetSlideProcessor", "(Lcom/bytedance/android/livesdk/widget/LiveBottomSheetDialog$m;)V", "Lcom/bytedance/android/livesdk/widget/LiveBottomSheetDialog$l;", "bottomSheetPullUpProcessor", "Lcom/bytedance/android/livesdk/widget/LiveBottomSheetDialog$l;", "getBottomSheetPullUpProcessor", "()Lcom/bytedance/android/livesdk/widget/LiveBottomSheetDialog$l;", "setBottomSheetPullUpProcessor", "(Lcom/bytedance/android/livesdk/widget/LiveBottomSheetDialog$l;)V", "onDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "isShowing", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveDialogFragment extends LiveBottomSheetDialogFragment {
    public static final a Companion = null;
    private boolean banLandscapeStyleSetting;
    private LiveBottomSheetDialog.l bottomSheetPullUpProcessor;
    private LiveBottomSheetDialog.m bottomSheetSlideProcessor;
    private boolean isVertical;
    private boolean isViewValid;
    private boolean noTitleAndCancelOutside;
    private DialogInterface.OnDismissListener onDismissListener;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static void a(FragmentActivity r100, DialogFragment r101) {
            FragmentManager r102 = null;
            if (r101 == null) goto L5;
            String r103 = r101.getClass().getCanonicalName();
        L6:
            if (r100 == null) goto L8;
            r102 = r100.getSupportFragmentManager();
        L8:
            b(r102, r101, r103);
            return;
        L5:
            r103 = null;
            goto L6
        }

        @JvmStatic
        public static void b(FragmentManager r100, DialogFragment r101, String r102) {
            if (r100 == null) goto L16;
            if (r101 == null) goto L17;
            if (r102 != null) goto L7;
            r102 = r101.getClass().getCanonicalName();
        L7:
            LandscapeRestrictionOperation r103 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r101, r102, r103);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, r101, r103) == true) goto L18;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
        L11:
            r101.show(r100, r102);
            return;
        L18:
            return;
        L17:
            return;
        }
    }

    public static final class b implements LiveBottomSheetDialog.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f102949a = null;

        static {
            f102949a = new b();
        }

        public b() {
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.l
        public final /* synthetic */ boolean a() {
            return true;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.l
        public final /* synthetic */ boolean b() {
            return false;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.l
        public final /* synthetic */ boolean c() {
            return true;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.l
        public final /* synthetic */ boolean d() {
            return true;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.l
        public final boolean e() {
            return false;
        }
    }

    public static final class c implements LiveBottomSheetDialog.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveDialogFragment f102950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveBottomSheetDialog.l f102951b;

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.l
        public final boolean a() {
            return this.f102951b.a();
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.l
        public final boolean b() {
            return this.f102951b.b();
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.l
        public final boolean c() {
            return this.f102951b.c();
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.l
        public final boolean d() {
            return this.f102951b.d();
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.l
        public final boolean e() {
            if (this.f102951b.e() == true) goto L5;
        L7:
            return false;
        L5:
            if (this.f102950a.isVertical() == false) goto L7;
            return true;
        }

        public c(LiveDialogFragment r100, LiveBottomSheetDialog.l r101) {
            this.f102950a = r100;
            this.f102951b = r101;
        }
    }

    public static final class d implements LiveBottomSheetDialog.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveDialogFragment f102952a;

        public d(LiveDialogFragment r100) {
            this.f102952a = r100;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final /* synthetic */ boolean shouldInterceptSlide(int r100) {
            return true;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final boolean disableDragDown() {
            return !this.f102952a.isVertical();
        }
    }

    public static final class e implements LiveBottomSheetDialog.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveDialogFragment f102953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveBottomSheetDialog.m f102954b;

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final boolean disableDragDown() {
            if (this.f102954b.disableDragDown() == false) goto L5;
        L8:
            return true;
        L5:
            if (this.f102953a.isVertical() == false) goto L8;
            return false;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final boolean shouldInterceptSlide(int r100) {
            return this.f102954b.shouldInterceptSlide(r100);
        }

        public e(LiveDialogFragment r100, LiveBottomSheetDialog.m r101) {
            this.f102953a = r100;
            this.f102954b = r101;
        }
    }

    public static final class f implements DialogInterface.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveDialogFragment f102955a;

        public f(LiveDialogFragment r100) {
            this.f102955a = r100;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
            Intrinsics.checkNotNullParameter(r102, "event");
            if (4 == r101) goto L5;
            return false;
        L5:
            if (1 == r102.getAction()) goto L7;
            return false;
        L7:
            return this.f102955a.onBackPressed();
        }
    }

    @JvmStatic
    public static final void show(FragmentActivity r100, DialogFragment r101) {
        Companion.getClass();
        a.a(r100, r101);
    }

    @JvmStatic
    public static final void show(FragmentManager r100, DialogFragment r101, String r102) {
        Companion.getClass();
        a.b(r100, r101, r102);
    }

    public boolean onBackPressed() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.isViewValid = false;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r100) {
        com_bytedance_android_livesdk_LiveDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_onDismiss(this, r100);
    }

    static {
        Companion = new a();
    }

    public LiveDialogFragment() {
        this.isVertical = true;
        this.bottomSheetSlideProcessor = new d(this);
        this.bottomSheetPullUpProcessor = b.f102949a;
    }

    public int getContentViewHeight() {
        View r100 = getView();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getHeight();
    }

    public final boolean isShowing() {
        Dialog r100 = getDialog();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isShowing() != true) goto L7;
        return true;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        INVOKEVIRTUAL_com_bytedance_android_livesdk_LiveDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(this);
    }

    public final boolean getBanLandscapeStyleSetting() {
        return this.banLandscapeStyleSetting;
    }

    public final LiveBottomSheetDialog.l getBottomSheetPullUpProcessor() {
        return this.bottomSheetPullUpProcessor;
    }

    public final LiveBottomSheetDialog.m getBottomSheetSlideProcessor() {
        return this.bottomSheetSlideProcessor;
    }

    public final boolean getNoTitleAndCancelOutside() {
        return this.noTitleAndCancelOutside;
    }

    @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment
    public boolean isVertical() {
        return this.isVertical;
    }

    public final boolean isViewValid() {
        return this.isViewValid;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_livesdk_LiveDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismiss(LiveDialogFragment r100) {
        r100.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_livesdk_LiveDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(LiveDialogFragment r100) {
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public void com_bytedance_android_livesdk_LiveDialogFragment__onDismiss$___twin___(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        super.onDismiss(r100);
        DialogInterface.OnDismissListener r101 = this.onDismissListener;
        if (r101 == null) goto L6;
        r101.onDismiss(r100);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        if (this.banLandscapeStyleSetting == false) goto L6;
        return;
    L6:
        if (isVertical() == true) goto L13;
        x8.b(getDialog());
        Dialog r101 = getDialog();
        if (r101 == null) goto L14;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L15;
        r102.addFlags(1024);
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        if (this.isViewValid == false) goto L10;
        INVOKEVIRTUAL_com_bytedance_android_livesdk_LiveDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismiss(this);     // Catch: IllegalStateException -> L6
        return;
    L6:
        INVOKEVIRTUAL_com_bytedance_android_livesdk_LiveDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(this);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.isViewValid = false;
    }

    @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        if (this.noTitleAndCancelOutside == true) goto L12;
    L11:
        return r101;
    L12:
        r101.requestWindowFeature(1);     // Catch: Exception -> L7
    L9:
        if (r101 == null) goto L11;
        r101.setCanceledOnTouchOutside(true);
    L7:
        e = move-exception;
        ALogger.e(getClass().getSimpleName(), String.valueOf(e.getMessage()));
        goto L9
    }

    public final void setBanLandscapeStyleSetting(boolean r100) {
        this.banLandscapeStyleSetting = r100;
    }

    public final void setBottomSheetPullUpProcessor(LiveBottomSheetDialog.l r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.bottomSheetPullUpProcessor = new c(this, r100);
        Dialog r101 = getDialog();
        Dialog r102 = null;
        if ((r101 instanceof LiveBottomSheetDialog) == true) goto L5;
        r101 = null;
    L5:
        LiveBottomSheetDialog r103 = (LiveBottomSheetDialog) r101;
        if (r103 == null) goto L8;
        r103.setBottomSheetPullUpProcessor(this.bottomSheetPullUpProcessor);
    L8:
        Dialog r104 = getDialog();
        if ((r104 instanceof LiveStandardSheetDialog) == false) goto L12;
        r102 = r104;
    L12:
        LiveStandardSheetDialog r105 = (LiveStandardSheetDialog) r102;
        if (r105 == null) goto L18;
        LiveBottomSheetDialog.l r106 = this.bottomSheetPullUpProcessor;
        Intrinsics.checkNotNullParameter(r106, "bottomSheetPullUpProcessor");
        com.bytedance.android.livesdk.pannel.b r107 = new com.bytedance.android.livesdk.pannel.b(r105, new com.bytedance.android.livesdk.widget.h1(r106));
        r105.f154343h = r107;
        SheetBaseBehavior<?> r108 = r105.f154336a;
        if (r108 == null) goto L19;
        r108.f154335e = r107;
        return;
    L19:
        return;
    }

    public final void setBottomSheetSlideProcessor(LiveBottomSheetDialog.m r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.bottomSheetSlideProcessor = new e(this, r100);
        Dialog r101 = getDialog();
        Dialog r102 = null;
        if ((r101 instanceof LiveBottomSheetDialog) == true) goto L5;
        r101 = null;
    L5:
        LiveBottomSheetDialog r103 = (LiveBottomSheetDialog) r101;
        if (r103 == null) goto L8;
        r103.setBottomSheetSlideProcessor(this.bottomSheetSlideProcessor);
    L8:
        Dialog r104 = getDialog();
        if ((r104 instanceof LiveStandardSheetDialog) == false) goto L12;
        r102 = r104;
    L12:
        LiveStandardSheetDialog r105 = (LiveStandardSheetDialog) r102;
        if (r105 == null) goto L16;
        r105.setBottomSheetSlideProcessor(this.bottomSheetSlideProcessor);
        return;
    }

    public final void setNoTitleAndCancelOutside(boolean r100) {
        this.noTitleAndCancelOutside = r100;
    }

    public final void setOnDismissListener(DialogInterface.OnDismissListener r100) {
        this.onDismissListener = r100;
    }

    @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment
    public void setVertical(boolean r100) {
        this.isVertical = r100;
    }

    public final void setViewValid(boolean r100) {
        this.isViewValid = r100;
    }

    public static void com_bytedance_android_livesdk_LiveDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_onDismiss(LiveDialogFragment r100, DialogInterface r101) {
        r100.com_bytedance_android_livesdk_LiveDialogFragment__onDismiss$___twin___(r101);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(r100.getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(r100);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(r100);
        return;
    L5:
        th = move-exception;
        if ((r100 instanceof DialogFragment) == false) goto L9;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(r100.getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(r100);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(r100);
    L9:
        throw th;
    }

    @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.isViewValid = true;
        Dialog r102 = getDialog();
        if (r102 == null) goto L5;
        r102.setOnKeyListener(new f(this));
    L5:
        Dialog r103 = getDialog();
        Dialog r104 = null;
        if ((r103 instanceof LiveBottomSheetDialog) == true) goto L8;
        r103 = null;
    L8:
        LiveBottomSheetDialog r105 = (LiveBottomSheetDialog) r103;
        if (r105 == null) goto L11;
        r105.setCancelable(true);
        r105.setBottomSheetSlideProcessor(this.bottomSheetSlideProcessor);
        r105.setBottomSheetPullUpProcessor(this.bottomSheetPullUpProcessor);
    L11:
        Dialog r106 = getDialog();
        if ((r106 instanceof LiveStandardSheetDialog) == false) goto L15;
        r104 = r106;
    L15:
        LiveStandardSheetDialog r107 = (LiveStandardSheetDialog) r104;
        if (r107 == null) goto L21;
        r107.setCancelable(true);
        r107.setBottomSheetSlideProcessor(this.bottomSheetSlideProcessor);
        LiveBottomSheetDialog.l r108 = this.bottomSheetPullUpProcessor;
        Intrinsics.checkNotNullParameter(r108, "bottomSheetPullUpProcessor");
        com.bytedance.android.livesdk.pannel.b r109 = new com.bytedance.android.livesdk.pannel.b(r107, new com.bytedance.android.livesdk.widget.h1(r108));
        r107.f154343h = r109;
        SheetBaseBehavior<?> r110 = r107.f154336a;
        if (r110 == null) goto L22;
        r110.f154335e = r109;
        return;
    L22:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment
    public int show(FragmentTransaction r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "transaction");
        if (isAdded() == false) goto L6;
        return 0;
    L6:
        Boolean r102 = Boolean.FALSE;
        JavaCalls.setField(this, "mDismissed", r102);
        JavaCalls.setField(this, "mShownByMe", Boolean.TRUE);
        INVOKEVIRTUAL_com_bytedance_android_livesdk_LiveDialogFragment_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r100, this, r101);
        JavaCalls.setField(this, "mViewDestroyed", r102);
        int r103 = r100.commitAllowingStateLoss();
        JavaCalls.setField(this, "mBackStackId", Integer.valueOf(r103));
        return r103;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void showNow(FragmentManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        if (isAdded() == false) goto L5;
        return;
    L5:
        JavaCalls.setField(this, "mDismissed", Boolean.FALSE);
        JavaCalls.setField(this, "mShownByMe", Boolean.TRUE);
        FragmentTransaction r102 = r100.beginTransaction();
        if (r102 != null) goto L8;
        return;
    L8:
        INVOKEVIRTUAL_com_bytedance_android_livesdk_LiveDialogFragment_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r102, this, r101);
        r102.commitNowAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        if (isAdded() == false) goto L5;
        return;
    L5:
        JavaCalls.setField(this, "mDismissed", Boolean.FALSE);
        JavaCalls.setField(this, "mShownByMe", Boolean.TRUE);
        FragmentTransaction r102 = r100.beginTransaction();
        if (r102 != null) goto L8;
        return;
    L8:
        INVOKEVIRTUAL_com_bytedance_android_livesdk_LiveDialogFragment_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r102, this, r101);
        r102.commitAllowingStateLoss();
    }

    @JvmStatic
    public static final void show(FragmentManager r100, DialogFragment r101) {
        a r102 = Companion;
        if (r101 == null) goto L5;
        String r103 = r101.getClass().getCanonicalName();
    L6:
        r102.getClass();
        a.b(r100, r101, r103);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_bytedance_android_livesdk_LiveDialogFragment_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r100, Fragment r101, String r102) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, r101, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r102, 0) == false) goto L6;
        return r100;
    L6:
        return r100.add(r101, r102);
    }

    @JvmStatic
    public static final void show(FragmentActivity r100, DialogFragment r101, String r102) {
        Companion.getClass();
        if (r100 == null) goto L5;
        FragmentManager r103 = r100.getSupportFragmentManager();
    L6:
        a.b(r103, r101, r102);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
