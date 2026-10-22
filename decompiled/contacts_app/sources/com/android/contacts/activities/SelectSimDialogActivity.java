package com.android.contacts.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.core.content.ContextCompat;
import com.GlobalProxyLancet;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.android.contacts.numberassistant.MarkInfoUtil;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.alert.style.DialogContainer;
import com.obric.oui.dialog.v2.alert.style.OViewStyleController;
import com.obric.oui.dialog.v2.alert.style.StyleController;
import com.obric.oui.dialog.v2.common.ODialogListItemView;
import com.obric.tracker.CallScreenShowUtils;
import com.obric.tracker.event.CallScreenShowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: SelectSimDialogActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0012\u0010\u0018\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\nH\u0014J:\u0010\u001c\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/android/contacts/activities/SelectSimDialogActivity;", "Landroid/app/Activity;", "()V", "currentDialog", "Landroid/app/Dialog;", "buildSimDisplayText", "", "simId", "", "configureSystemBars", "", "createSimItemDivider", "Landroid/view/View;", "context", "Landroid/content/Context;", "dismissDialog", "finishSafely", "formatSimNumber", "number", "getExampleBodyStyleController", "Lcom/obric/oui/dialog/v2/alert/style/StyleController;", "isStranger", "", "isVideoCall", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "showCustomDialog", "title", "negativeButtonText", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SelectSimDialogActivity extends Activity {
    public static final Companion Companion = null;
    private static final String EXTRA_IS_STRANGER = "extra_is_stranger";
    private static final String EXTRA_IS_VIDEO_CALL = "extra_is_video_call";
    private static final String EXTRA_NAME = "extra_name";
    private static final String EXTRA_NUMBER = "extra_number";
    private static final String TAG = "SelectSimDialogActivity";
    private Dialog currentDialog;

    /* JADX INFO: compiled from: SelectSimDialogActivity.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/android/contacts/activities/SelectSimDialogActivity$Companion;", "", "()V", "EXTRA_IS_STRANGER", "", "EXTRA_IS_VIDEO_CALL", "EXTRA_NAME", "EXTRA_NUMBER", "TAG", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "name", "number", "isStranger", "", "isVideoCall", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final Intent createIntent(Context r2, String r3, String r4, boolean r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r4, "number");
            Intent r1 = new Intent(r2, SelectSimDialogActivity.class);
            r1.putExtra(SelectSimDialogActivity.EXTRA_NAME, r3);
            r1.putExtra("extra_number", r4);
            r1.putExtra(SelectSimDialogActivity.EXTRA_IS_STRANGER, r5);
            r1.putExtra(SelectSimDialogActivity.EXTRA_IS_VIDEO_CALL, r6);
            r1.addFlags(268435456);
            r1.addFlags(MarkInfoUtil.MARK_CLASSIFY_ZTE_BLACKLIST);
            r1.addFlags(65536);
            return r1;
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.activities.SelectSimDialogActivity$getExampleBodyStyleController$1, reason: invalid class name */
    /* JADX INFO: compiled from: SelectSimDialogActivity.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "dialogContainer", "Lcom/obric/oui/dialog/v2/alert/style/DialogContainer;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function1<DialogContainer, Unit> {
        final /* synthetic */ Context $context;
        final /* synthetic */ boolean $isStranger;
        final /* synthetic */ boolean $isVideoCall;
        final /* synthetic */ String $number;
        final /* synthetic */ SelectSimDialogActivity this$0;

        public static /* synthetic */ void $r8$lambda$6wEsWIn0rCYzr02hgbxeSUjP4L0(boolean r0, Context r1, String r2, boolean r3, SelectSimDialogActivity r4, View r5) {
            invoke$lambda$8$lambda$7$lambda$0(r0, r1, r2, r3, r4, r5);
        }

        public static /* synthetic */ void $r8$lambda$vyLPoHMvN_c9OgFxWPFcEoz9afA(boolean r0, Context r1, String r2, boolean r3, SelectSimDialogActivity r4, View r5) {
            invoke$lambda$8$lambda$7$lambda$1(r0, r1, r2, r3, r4, r5);
        }

        AnonymousClass1(Context r1, SelectSimDialogActivity r2, boolean r3, String r4, boolean r5) {
            this.$context = r1;
            this.this$0 = r2;
            this.$isVideoCall = r3;
            this.$number = r4;
            this.$isStranger = r5;
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DialogContainer r1) {
            invoke2(r1);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DialogContainer r23) {
            Intrinsics.checkNotNullParameter(r23, "dialogContainer");
            FrameLayout r1 = r23.getBodySlot();
            ScrollView r2 = new ScrollView(this.$context);
            final Context r3 = this.$context;
            final SelectSimDialogActivity r10 = this.this$0;
            final boolean r11 = this.$isVideoCall;
            final String r12 = this.$number;
            final boolean r0 = this.$isStranger;
            int r13 = 2;
            r2.setOverScrollMode(2);
            float r4 = 8;
            int r15 = 0;
            r2.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r4, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, 0, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r4, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics())));
            LinearLayout r9 = new LinearLayout(r3);
            r9.setOrientation(1);
            List r16 = CollectionsKt.listOf(new String[]{SelectSimDialogActivity.access$buildSimDisplayText(r10, 0), SelectSimDialogActivity.access$buildSimDisplayText(r10, 1)});
            String r5 = DSUtils.getSimNumber(r3, 0);
            Intrinsics.checkNotNullExpressionValue(r5, "getSimNumber(context, DSUtils.SIM_1)");
            String r6 = DSUtils.getSimNumber(r3, 1);
            Intrinsics.checkNotNullExpressionValue(r6, "getSimNumber(context, DSUtils.SIM_2)");
            List r8 = CollectionsKt.listOf(new String[]{SelectSimDialogActivity.access$formatSimNumber(r10, r5), SelectSimDialogActivity.access$formatSimNumber(r10, r6)});
            List r19 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(R.drawable.sim_1_icon), Integer.valueOf(R.drawable.sim_2_icon)});
            LinearLayout r21 = r9;
            ArrayList r7 = CollectionsKt.arrayListOf(new View.OnClickListener[]{new SelectSimDialogActivity$getExampleBodyStyleController$1$$ExternalSyntheticLambda0(r11, r3, r12, r0, r10), new SelectSimDialogActivity$getExampleBodyStyleController$1$$ExternalSyntheticLambda1(r11, r3, r12, r0, r10)});
            Iterator r14 = r16.iterator();
        L4:
            if (r14.hasNext() == false) goto L12;
            Object r17 = r14.next();
            int r18 = r15 + 1;
            if (r15 >= 0) goto L8;
            CollectionsKt.throwIndexOverflow();
        L8:
            ODialogListItemView r20 = new ODialogListItemView(r3, null, r13, 0 == true ? 1 : 0);
            r20.setTitle((String) r17);
            r20.setSubtitle((CharSequence) r8.get(r15));
            FrameLayout r110 = new FrameLayout(r3);
            ImageView r111 = new ImageView(r3);
            List r112 = r19;
            r111.setImageResource(((Number) r112.get(r15)).intValue());
            r111.setImageTintList(r111.getResources().getColorStateList(R.color.oui_basic_text_1, null));
            float r22 = 24;
            Iterator r113 = r14;
            FrameLayout.LayoutParams r24 = new FrameLayout.LayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, r22, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r22, Resources.getSystem().getDisplayMetrics())));
            r24.gravity = 17;
            Unit r25 = Unit.INSTANCE;
            r110.addView(r111, r24);
            float r26 = 48;
            r20.setLeadingView(r110, new FrameLayout.LayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, r26, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r26, Resources.getSystem().getDisplayMetrics()))));
            r20.setOnClickListener((View.OnClickListener) r7.get(r15));
            LinearLayout r27 = r21;
            r27.addView(r20, new ViewGroup.LayoutParams(-1, MathKt.roundToInt(TypedValue.applyDimension(1, 60, Resources.getSystem().getDisplayMetrics()))));
            if (r15 == (r16.size() - 1)) goto L11;
            r27.addView(SelectSimDialogActivity.access$createSimItemDivider(r10, r3));
        L11:
            r21 = r27;
            r15 = r18;
            r19 = r112;
            r14 = r113;
            r13 = 2;
            goto L4
        L12:
            r2.addView(r21, new ViewGroup.LayoutParams(-1, -2));
            r1.addView(r2);
        }

        private static final void invoke$lambda$8$lambda$7$lambda$0(boolean r1, Context r2, String r3, boolean r4, SelectSimDialogActivity r5, View r6) {
            Intrinsics.checkNotNullParameter(r2, "$context");
            Intrinsics.checkNotNullParameter(r3, "$number");
            Intrinsics.checkNotNullParameter(r5, "this$0");
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(SelectSimDialogActivity.TAG, "select sim, simId=0, isVideoCall=" + r1);
            DSUtils.callBySim1(r2, r3, r4, r1);
            CallScreenShowUtils.INSTANCE.start(new CallScreenShowEvent(null, 1, null));
            SelectSimDialogActivity.access$dismissDialog(r5);
        }

        private static final void invoke$lambda$8$lambda$7$lambda$1(boolean r1, Context r2, String r3, boolean r4, SelectSimDialogActivity r5, View r6) {
            Intrinsics.checkNotNullParameter(r2, "$context");
            Intrinsics.checkNotNullParameter(r3, "$number");
            Intrinsics.checkNotNullParameter(r5, "this$0");
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(SelectSimDialogActivity.TAG, "select sim, simId=1, isVideoCall=" + r1);
            DSUtils.callBySim2(r2, r3, r4, r1);
            CallScreenShowUtils.INSTANCE.start(new CallScreenShowEvent(null, 1, null));
            SelectSimDialogActivity.access$dismissDialog(r5);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$vAQ5nvVl0ALbX5jkCKsL-ZE_Ggk, reason: not valid java name */
    public static /* synthetic */ void m126$r8$lambda$vAQ5nvVl0ALbX5jkCKsLZE_Ggk(SelectSimDialogActivity r0, DialogInterface r1) {
        showCustomDialog$lambda$3$lambda$2(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    public void com_android_contacts_activities_SelectSimDialogActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_contacts_activities_SelectSimDialogActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public SelectSimDialogActivity() {
    }

    public static final /* synthetic */ String access$buildSimDisplayText(SelectSimDialogActivity r0, int r1) {
        return r0.buildSimDisplayText(r1);
    }

    public static final /* synthetic */ View access$createSimItemDivider(SelectSimDialogActivity r0, Context r1) {
        return r0.createSimItemDivider(r1);
    }

    public static final /* synthetic */ void access$dismissDialog(SelectSimDialogActivity r0) {
        r0.dismissDialog();
    }

    public static final /* synthetic */ String access$formatSimNumber(SelectSimDialogActivity r0, String r1) {
        return r0.formatSimNumber(r1);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r10) {
        super.onCreate(r10);
        overridePendingTransition(0, 0);
        configureSystemBars();
        String r4 = getIntent().getStringExtra("extra_number");
        String r0 = r4;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "finish, empty number");
        finishSafely();
        return;
    L13:
        boolean r6 = getIntent().getBooleanExtra(EXTRA_IS_STRANGER, false);
        boolean r7 = getIntent().getBooleanExtra(EXTRA_IS_VIDEO_CALL, false);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "show select sim dialog, isStranger=" + r6 + ", isVideoCall=" + r7);
        String r5 = getResources().getString(R.string.select_sim_dialog_title);
        Intrinsics.checkNotNullExpressionValue(r5, "resources.getString(R.st….select_sim_dialog_title)");
        showCustomDialog(this, r4, r5, r6, r7, getResources().getString(R.string.btn_cancel));
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    private final void configureSystemBars() {
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().getDecorView().setSystemUiVisibility(1792);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        getWindow().setNavigationBarContrastEnforced(false);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        Dialog r0 = this.currentDialog;
        if (r0 == null) goto L5;
        r0.setOnDismissListener(null);
    L5:
        Dialog r1 = this.currentDialog;
        boolean r2 = false;
        if (r1 != null) goto L8;
    L10:
        if (r2 == false) goto L14;
        Dialog r3 = this.currentDialog;
        if (r3 == null) goto L14;
        r3.dismiss();
    L14:
        this.currentDialog = null;
        super.onDestroy();
        return;
    L8:
        if (r1.isShowing() != true) goto L10;
        r2 = true;
        goto L10
    }

    private final String buildSimDisplayText(int r3) {
        String r0 = DSUtils.getOperatorNameBySimSlotId(r3);
        if (StringsKt.isBlank(r0) == false) goto L5;
        r0 = DSUtils.getSimName(this, r3);
    L5:
        Intrinsics.checkNotNullExpressionValue(r0, "getOperatorNameBySimSlot…me(this, simId)\n        }");
        return r0;
    }

    private final String formatSimNumber(String r6) {
        String r5 = new Regex("\\s+").replace(r6, "");
        if (r5.length() != 11) goto L17;
        String r0 = r5;
        int r3 = 0;
    L6:
        if (r3 >= r0.length()) goto L11;
        if (Character.isDigit(r0.charAt(r3)) == false) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        boolean r1 = false;
    L12:
        if (r1 == false) goto L18;
        StringBuilder r7 = new StringBuilder();
        String r2 = r5.substring(0, 3);
        Intrinsics.checkNotNullExpressionValue(r2, "substring(...)");
        StringBuilder r8 = r7.append(r2).append(' ');
        String r4 = r5.substring(3, 7);
        Intrinsics.checkNotNullExpressionValue(r4, "substring(...)");
        StringBuilder r9 = r8.append(r4).append(' ');
        String r10 = r5.substring(7, 11);
        Intrinsics.checkNotNullExpressionValue(r10, "substring(...)");
        return r9.append(r10).toString();
    L18:
        return r6;
    L11:
        r1 = true;
        goto L12
    L17:
        return r6;
    }

    private final void dismissDialog() {
        Dialog r1 = this.currentDialog;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isShowing() == false) goto L9;
        r1.dismiss();
        return;
    }

    private final void finishSafely() {
        if (isFinishing() == true) goto L6;
        finish();
        overridePendingTransition(0, 0);
        return;
    }

    private final void showCustomDialog(Context r8, String r9, String r10, boolean r11, boolean r12, String r13) {
        boolean r3 = false;
        OAlertDialogBuilder r0 = OAlertDialogBuilder.title$default(new OAlertDialogBuilder(r8), r10, false, 2, null).body(getExampleBodyStyleController(r8, r9, r11, r12));
        OAlertDialogBuilder.horizontalButton$default(r0, false, 1, null);
        String r2 = r13;
        if (r2 != null) goto L5;
    L6:
        r3 = true;
    L7:
        if (r3 == true) goto L9;
        OAlertDialogBuilder.negativeButton$default(r0, r2, null, null, 4, null);
    L9:
        r0.onDismiss(new SelectSimDialogActivity$$ExternalSyntheticLambda0(this));
        OAlertDialog r1 = r0.build();
        OAlertDialog r4 = r1;
        r4.setCancelable(true);
        r4.setCanceledOnTouchOutside(true);
        OAlertDialog r5 = r1;
        this.currentDialog = r5;
        Intrinsics.checkNotNull(r5);
        r5.show();
        return;
    L5:
        if (r2.length() != 0) goto L7;
        goto L6
    }

    private static final void showCustomDialog$lambda$3$lambda$2(SelectSimDialogActivity r0, DialogInterface r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.finishSafely();
    }

    private final StyleController getExampleBodyStyleController(Context r9, String r10, boolean r11, boolean r12) {
        return new OViewStyleController(new AnonymousClass1(r9, this, r12, r10, r11));
    }

    private final View createSimItemDivider(Context r4) {
        View r3 = new View(r4);
        r3.setBackgroundColor(ContextCompat.getColor(r4, R.color.oui_basic_line_1));
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(-1, (int) Math.ceil(TypedValue.applyDimension(1, (float) 0.6d, Resources.getSystem().getDisplayMetrics())));
        r5.leftMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 48, Resources.getSystem().getDisplayMetrics()));
        r5.rightMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics()));
        float r0 = 2;
        r5.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r0, Resources.getSystem().getDisplayMetrics()));
        r5.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r0, Resources.getSystem().getDisplayMetrics()));
        r3.setLayoutParams(r5);
        return r3;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_activities_SelectSimDialogActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(SelectSimDialogActivity r1) {
        r1.com_android_contacts_activities_SelectSimDialogActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
