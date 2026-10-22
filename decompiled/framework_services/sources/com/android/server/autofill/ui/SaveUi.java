package com.android.server.autofill.ui;

import android.R;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.metrics.LogMaker;
import android.os.Handler;
import android.os.IBinder;
import android.service.autofill.BatchUpdates;
import android.service.autofill.CustomDescription;
import android.service.autofill.InternalOnClickAction;
import android.service.autofill.InternalTransformation;
import android.service.autofill.InternalValidator;
import android.service.autofill.SaveInfo;
import android.service.autofill.ValueFinder;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.ArraySet;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.ScrollView;
import android.widget.TextView;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.util.ArrayUtils;
import com.android.server.UiThread;
import com.android.server.autofill.Helper;
import com.android.server.utils.Slogf;
import com.obric.oui.framework.material.MaterialConfigCore;
import com.obric.oui.framework.material.MaterialTokenCore;
import com.obric.oui.framework.material.OMaterialHelperCore;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
final class SaveUi {
    private static final float PASSWORD_DIALOG_CORNER_RADIUS_DP = 36.0f;
    private static final int SCROLL_BAR_DEFAULT_DELAY_BEFORE_FADE_MS = 500;
    private static final String TAG = "SaveUi";
    private static final int THEME_ID_DARK = 16975025;
    private static final int THEME_ID_LIGHT = 16975037;
    private final boolean mCompatMode;
    private final ComponentName mComponentName;
    private boolean mDestroyed;
    private final Dialog mDialog;
    private final Handler mHandler;
    private final OneActionThenDestroyListener mListener;
    private final MetricsLogger mMetricsLogger;
    private final OverlayControl mOverlayControl;
    private final PendingUi mPendingUi;
    private final String mServicePackageName;
    private final CharSequence mSubTitle;
    private final int mThemeId;
    private final CharSequence mTitle;
    private final int mType;

    public interface OnSaveListener {
        void onCancel(IntentSender r1);

        void onDestroy();

        void onSave();

        void startIntentSender(IntentSender r1, Intent r2);
    }

    private class OneActionThenDestroyListener implements OnSaveListener {
        private boolean mDone;
        private final OnSaveListener mRealListener;

        OneActionThenDestroyListener(SaveUi r1, OnSaveListener realListener) {
            this.mRealListener = realListener;
        }

        @Override // com.android.server.autofill.ui.SaveUi.OnSaveListener
        public void onSave() {
            if (Helper.sDebug == false) goto L6;
            Slog.d(SaveUi.TAG, "OneTimeListener.onSave(): " + this.mDone);
        L6:
            if (this.mDone == false) goto L8;
            return;
        L8:
            this.mRealListener.onSave();
        }

        @Override // com.android.server.autofill.ui.SaveUi.OnSaveListener
        public void onCancel(IntentSender listener) {
            if (Helper.sDebug == false) goto L6;
            Slog.d(SaveUi.TAG, "OneTimeListener.onCancel(): " + this.mDone);
        L6:
            if (this.mDone == false) goto L8;
            return;
        L8:
            this.mRealListener.onCancel(listener);
        }

        @Override // com.android.server.autofill.ui.SaveUi.OnSaveListener
        public void onDestroy() {
            if (Helper.sDebug == false) goto L6;
            Slog.d(SaveUi.TAG, "OneTimeListener.onDestroy(): " + this.mDone);
        L6:
            if (this.mDone == false) goto L8;
            return;
        L8:
            this.mDone = true;
            this.mRealListener.onDestroy();
        }

        @Override // com.android.server.autofill.ui.SaveUi.OnSaveListener
        public void startIntentSender(IntentSender intentSender, Intent intent) {
            if (Helper.sDebug == false) goto L6;
            Slog.d(SaveUi.TAG, "OneTimeListener.startIntentSender(): " + this.mDone);
        L6:
            if (this.mDone == false) goto L8;
            return;
        L8:
            this.mRealListener.startIntentSender(intentSender, intent);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$6-7oZbjHZXM6-c3jAaL4ruR8cfQ, reason: not valid java name */
    public static /* synthetic */ void m2461$r8$lambda$67oZbjHZXM6c3jAaL4ruR8cfQ(SaveUi r0, DialogInterface r1) {
        r0.lambda$new$2(r1);
    }

    public static /* synthetic */ void $r8$lambda$MPlvvaSiGliSHwe0KHTdun7lGbg(SaveUi r0, View r1) {
        r0.lambda$new$9(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$QobbS7Fk1Vu-KIXMmAWuree2skk, reason: not valid java name */
    public static /* synthetic */ void m2462$r8$lambda$QobbS7Fk1VuKIXMmAWuree2skk(SaveUi r0, View r1) {
        r0.lambda$new$5(r1);
    }

    public static /* synthetic */ void $r8$lambda$SXY8sgvnPfp62TChFILwcmaJFGg(SaveUi r0, View r1) {
        r0.lambda$new$6(r1);
    }

    public static /* synthetic */ void $r8$lambda$Z70JPQZ6ZZSyAiZi07hdCscS1Do(SaveUi r0, SaveInfo r1, View r2) {
        r0.lambda$new$0(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$ZSOry0EYrJKu6sPBQOm-AImkBgM, reason: not valid java name */
    public static /* synthetic */ void m2463$r8$lambda$ZSOry0EYrJKu6sPBQOmAImkBgM(SaveUi r0, View r1) {
        r0.lambda$new$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$ZiqMNctJ5KAZM3tHdehSFaTJUzY(SaveUi r0, DialogInterface r1) {
        r0.lambda$new$7(r1);
    }

    public static /* synthetic */ void $r8$lambda$_efTorfq5_VnOO77zQVZ6BiAxp8(SaveUi r0, ScrollView r1, View r2) {
        r0.lambda$new$3(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$e62Rn-YFXGRzAfz-ztwJQKICJYk, reason: not valid java name */
    public static /* synthetic */ void m2464$r8$lambda$e62RnYFXGRzAfzztwJQKICJYk(SaveUi r0, View r1) {
        r0.lambda$new$8(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$mhLamk0gDr-hrphpogI6y_Msvi0, reason: not valid java name */
    public static /* synthetic */ boolean m2465$r8$lambda$mhLamk0gDrhrphpogI6y_Msvi0(SaveUi r0, View r1, PendingIntent r2, RemoteViews.RemoteResponse r3) {
        return r0.lambda$applyCustomDescription$11(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$nKFB9DYwDcKhDv1-yEj7dRzDg2M, reason: not valid java name */
    public static /* synthetic */ void m2466$r8$lambda$nKFB9DYwDcKhDv1yEj7dRzDg2M(SaveUi r0, DialogInterface r1) {
        r0.lambda$new$10(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$naYLVIb_ERgLPAfWnYPUif0x7dI(List r0, View r1) {
        return lambda$applyTextViewStyle$13(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$u6KRMxyyo5Totp5YIsJ4K7_FrEI(InternalOnClickAction r0, ViewGroup r1, View r2) {
        lambda$applyCustomDescription$12(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$yPrSOdRyeWGhy-iDQCx_HaulqZg, reason: not valid java name */
    public static /* synthetic */ void m2467$r8$lambda$yPrSOdRyeWGhyiDQCx_HaulqZg(SaveUi r0, ScrollView r1, View r2) {
        r0.lambda$new$4(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mstartIntentSenderWithRestore, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2468$$Nest$mstartIntentSenderWithRestore(SaveUi r0, PendingIntent r1, Intent r2) {
        r0.startIntentSenderWithRestore(r1, r2);
    }

    SaveUi(Context context, PendingUi pendingUi, CharSequence serviceLabel, Drawable serviceIcon, String servicePackageName, ComponentName componentName, final SaveInfo info, ValueFinder valueFinder, OverlayControl overlayControl, OnSaveListener listener, boolean nightMode, boolean isUpdate, boolean compatMode, boolean showServiceIcon) {
        this.mHandler = UiThread.getHandler();
        this.mMetricsLogger = new MetricsLogger();
        if (Helper.sVerbose == false) goto L5;
        Slogf.v(TAG, "nightMode: %b displayId: %d", new Object[]{Boolean.valueOf(nightMode), Integer.valueOf(context.getDisplayId())});
    L5:
        if (nightMode == false) goto L7;
        int r3 = 16975025;
    L8:
        this.mThemeId = r3;
        this.mPendingUi = pendingUi;
        this.mListener = new OneActionThenDestroyListener(this, listener);
        this.mOverlayControl = overlayControl;
        this.mServicePackageName = servicePackageName;
        this.mComponentName = componentName;
        this.mCompatMode = compatMode;
        final Context r11 = Helper.getUserContext(context);
        final int r12 = this.mThemeId;
        Context context2 = new AnonymousClass1(this, r11, r12);
        LayoutInflater inflater = LayoutInflater.from(context2);
        View view = inflater.inflate(R.layout.calendar_view, null);
        TextView titleView = (TextView) view.findViewById(R.id.autofill_save_yes);
        ArraySet<String> types = new ArraySet(3);
        this.mType = info.getType();
        if ((this.mType & 1) == 0) goto L12;
        types.add(context2.getString(R.string.biometric_dialog_default_subtitle));
    L12:
        if ((this.mType & 2) == 0) goto L14;
        types.add(context2.getString(R.string.bg_user_sound_notification_message));
    L14:
        int count = Integer.bitCount(this.mType & 100);
        if (count <= 1) goto L17;
    L28:
        types.add(context2.getString(R.string.biometric_dangling_notification_action_set_up));
    L30:
        if ((this.mType & 8) == 0) goto L33;
        types.add(context2.getString(R.string.biometric_error_canceled));
    L33:
        if ((this.mType & 16) == 0) goto L36;
        types.add(context2.getString(R.string.biometric_dangling_notification_action_not_now));
    L36:
        switch(types.size()) {
            case 1: goto L52;
            case 2: goto L47;
            case 3: goto L42;
            default: goto L37;
        };
    L37:
        if (isUpdate == false) goto L39;
        int r5 = R.string.biometric_error_generic;
    L40:
        this.mTitle = Html.fromHtml(context2.getString(r5, new Object[]{serviceLabel}), 0);
    L56:
        titleView.setText(this.mTitle);
        if (showServiceIcon == false) goto L60;
        setServiceIcon(context2, view, serviceIcon);
    L60:
        boolean hasCustomDescription = applyCustomDescription(context2, view, valueFinder, info);
        if (hasCustomDescription == false) goto L66;
        this.mSubTitle = null;
        if (Helper.sDebug == false) goto L73;
        Slog.d(TAG, "on constructor: applied custom description");
    L73:
        TextView noButton = (TextView) view.findViewById(R.id.autofill_save_title);
        int negativeActionStyle = info.getNegativeActionStyle();
        switch(negativeActionStyle) {
            case 1: goto L77;
            case 2: goto L76;
            default: goto L75;
        };
    L75:
        noButton.setText(R.string.battery_saver_description_with_learn_more);
    L78:
        noButton.setOnClickListener(new SaveUi$$ExternalSyntheticLambda0(this, info));
        TextView yesButton = (TextView) view.findViewById(R.id.autofill_service_icon);
        if (info.getPositiveActionStyle() != 1) goto L81;
        yesButton.setText(R.string.autofill_update_yes);
    L83:
        yesButton.setOnClickListener(new SaveUi$$ExternalSyntheticLambda1(this));
        this.mDialog = new Dialog(context2, this.mThemeId);
        this.mDialog.setContentView(view);
        this.mDialog.setOnDismissListener(new SaveUi$$ExternalSyntheticLambda2(this));
        Window window = this.mDialog.getWindow();
        window.setType(2038);
        window.addFlags(131074);
        window.setDimAmount(0.6f);
        window.addPrivateFlags(16);
        window.setSoftInputMode(32);
        window.setGravity(81);
        window.setCloseOnTouchOutside(true);
        WindowManager.LayoutParams params = window.getAttributes();
        params.accessibilityTitle = context2.getString(R.string.battery_saver_charged_notification_summary);
        params.windowAnimations = R.style.DialogWindowTitle.DeviceDefault.Light;
        params.setTrustedOverlay();
        final ScrollView scrollView = (ScrollView) view.findViewById(R.id.azerty);
        final View divider = view.findViewById(R.id.autofill_sheet_scroll_view_space);
        ViewTreeObserver observer = scrollView.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new SaveUi$$ExternalSyntheticLambda3(this, scrollView, divider));
        scrollView.getViewTreeObserver().addOnScrollChangedListener(new SaveUi$$ExternalSyntheticLambda4(this, scrollView, divider));
        show();
        return;
    L81:
        if (isUpdate == false) goto L83;
        yesButton.setText(R.string.biometric_not_recognized);
        goto L83
    L76:
        noButton.setText(R.string.battery_saver_description);
        goto L78
    L77:
        noButton.setText(R.string.battery_saver_notification_channel_name);
        goto L78
    L66:
        this.mSubTitle = info.getDescription();
        if (this.mSubTitle == null) goto L71;
        writeLog(1131);
        ViewGroup subtitleContainer = (ViewGroup) view.findViewById(R.id.autofill_save_icon);
        TextView subtitleView = new TextView(context2);
        subtitleView.setText(this.mSubTitle);
        applyMovementMethodIfNeed(subtitleView);
        subtitleContainer.addView(subtitleView, new ViewGroup.LayoutParams(-1, -2));
        subtitleContainer.setVisibility(0);
        subtitleContainer.setScrollBarDefaultDelayBeforeFade(500);
    L71:
        if (Helper.sDebug == false) goto L73;
        Slog.d(TAG, "on constructor: title=" + this.mTitle + ", subTitle=" + this.mSubTitle);
        goto L73
    L39:
        r5 = R.string.battery_saver_off_notification_title;
        goto L40
    L42:
        if (isUpdate == false) goto L44;
        int r4 = R.string.biometric_error_user_canceled;
    L45:
        this.mTitle = Html.fromHtml(context2.getString(r4, new Object[]{types.valueAt(0), types.valueAt(1), types.valueAt(2), serviceLabel}), 0);
        goto L56
    L44:
        r4 = R.string.bg_user_sound_notification_button_mute;
        goto L45
    L47:
        if (isUpdate == false) goto L49;
        int r6 = R.string.biometric_error_hw_unavailable;
    L50:
        this.mTitle = Html.fromHtml(context2.getString(r6, new Object[]{types.valueAt(0), types.valueAt(1), serviceLabel}), 0);
        goto L56
    L49:
        r6 = R.string.beforeOneMonthDurationPast;
        goto L50
    L52:
        if (isUpdate == false) goto L54;
        int r7 = R.string.biometric_face_not_recognized;
    L55:
        this.mTitle = Html.fromHtml(context2.getString(r7, new Object[]{types.valueAt(0), serviceLabel}), 0);
        goto L56
    L54:
        r7 = R.string.bg_user_sound_notification_button_switch_user;
        goto L55
    L17:
        if ((this.mType & 128) != 0) goto L28;
        if ((this.mType & 64) == 0) goto L23;
        types.add(context2.getString(R.string.biometric_dialog_default_title));
        goto L30
    L23:
        if ((this.mType & 4) == 0) goto L26;
        types.add(context2.getString(R.string.bg_user_sound_notification_title_alarm));
        goto L30
    L26:
        if ((this.mType & 32) == 0) goto L30;
        types.add(context2.getString(R.string.biometric_app_setting_name));
        goto L30
    L7:
        r3 = 16975037;
        goto L8
    }

    private /* synthetic */ void lambda$new$0(SaveInfo info, View v) {
        this.mListener.onCancel(info.getNegativeActionListener());
    }

    private /* synthetic */ void lambda$new$1(View v) {
        this.mListener.onSave();
    }

    private /* synthetic */ void lambda$new$2(DialogInterface d) {
        this.mListener.onCancel(null);
    }

    private /* synthetic */ void lambda$new$3(ScrollView scrollView, View divider) {
        adjustDividerVisibility(scrollView, divider);
    }

    private /* synthetic */ void lambda$new$4(ScrollView scrollView, View divider) {
        adjustDividerVisibility(scrollView, divider);
    }

    SaveUi(final Context context, PendingUi pendingUi, CharSequence serviceLabel, String servicePackageName, ComponentName componentName, SaveInfo info, ValueFinder valueFinder, OverlayControl overlayControl, OnSaveListener listener, boolean nightMode, boolean isUpdate, boolean compatMode, boolean showServiceIcon, String saveStr, IExtAutoFillUI autoFillUIImpl, int dialogWidth) {
        this.mHandler = UiThread.getHandler();
        this.mMetricsLogger = new MetricsLogger();
        if (Helper.sVerbose == false) goto L5;
        Slogf.v(TAG, "nightMode: %b displayId: %d", new Object[]{Boolean.valueOf(nightMode), Integer.valueOf(context.getDisplayId())});
    L5:
        if (nightMode == false) goto L7;
        int r2 = 16975025;
    L8:
        this.mThemeId = r2;
        this.mPendingUi = pendingUi;
        this.mListener = new OneActionThenDestroyListener(this, listener);
        this.mOverlayControl = overlayControl;
        this.mServicePackageName = servicePackageName;
        this.mComponentName = componentName;
        this.mCompatMode = compatMode;
        final int r9 = this.mThemeId;
        Context context2 = new AnonymousClass2(this, context, r9);
        LayoutInflater inflater = LayoutInflater.from(context2);
        if ("savePasswd".equals(saveStr) == false) goto L11;
        View view = inflater.inflate(R.layout.car_alert_dialog, null);
        TextView r12 = (TextView) view.findViewById(R.id.bevel);
        TextView r14 = (TextView) view.findViewById(R.id.behind);
        this.mTitle = "";
        this.mSubTitle = "";
        this.mType = info.getType();
        ImageView icon = (ImageView) view.findViewById(R.id.autofill_sheet_divider);
        final float radius = view.getContext().getResources().getDimensionPixelSize(17106310);
        icon.setOutlineProvider(new AnonymousClass3(this, radius));
        icon.setClipToOutline(true);
        Button yesButton = (Button) view.findViewById(R.id.big_picture);
        yesButton.setOnClickListener(new SaveUi$$ExternalSyntheticLambda7(this));
        Button cancelButton = (Button) view.findViewById(R.id.beginning);
        cancelButton.setOnClickListener(new SaveUi$$ExternalSyntheticLambda8(this));
        this.mDialog = new Dialog(context2, this.mThemeId);
        this.mDialog.setContentView(view);
        this.mDialog.setOnDismissListener(new SaveUi$$ExternalSyntheticLambda9(this));
        Window window = this.mDialog.getWindow();
        window.setType(2038);
        window.addFlags(131074);
        window.setDimAmount(0.6f);
        window.addPrivateFlags(16);
        window.setSoftInputMode(32);
        window.setGravity(81);
        window.setBackgroundDrawableResource(17304797);
        WindowManager.LayoutParams params = window.getAttributes();
        params.accessibilityTitle = context2.getString(R.string.battery_saver_charged_notification_summary);
        params.windowAnimations = R.style.DialogWindowTitle.DeviceDefault.Light;
        params.setTrustedOverlay();
        params.width = dialogWidth;
        params.height = -2;
        window.setAttributes(params);
        setupPasswordDialogMaterial(context2, window, view, "AutofillSavePasswordDialog");
        show();
        return;
    L11:
        View view2 = inflater.inflate(R.layout.car_alert_dialog_button_bar, null);
        TextView r3 = (TextView) view2.findViewById(R.id.blocksDescendants);
        this.mTitle = "";
        this.mSubTitle = "";
        this.mType = info.getType();
        ImageView icon2 = (ImageView) view2.findViewById(R.id.beforeDescendants);
        final float radius2 = view2.getContext().getResources().getDimensionPixelSize(17106310);
        icon2.setOutlineProvider(new AnonymousClass4(this, radius2));
        icon2.setClipToOutline(true);
        Button yesButton2 = (Button) view2.findViewById(R.id.body);
        yesButton2.setOnClickListener(new SaveUi$$ExternalSyntheticLambda10(this));
        Button cancelButton2 = (Button) view2.findViewById(R.id.big_text);
        cancelButton2.setOnClickListener(new SaveUi$$ExternalSyntheticLambda11(this));
        this.mDialog = new Dialog(context2, this.mThemeId);
        this.mDialog.setContentView(view2);
        this.mDialog.setOnDismissListener(new SaveUi$$ExternalSyntheticLambda12(this));
        Window window2 = this.mDialog.getWindow();
        window2.setType(2038);
        window2.addFlags(131074);
        window2.setDimAmount(0.6f);
        window2.addPrivateFlags(16);
        window2.setSoftInputMode(32);
        window2.setGravity(81);
        window2.setBackgroundDrawableResource(17304797);
        WindowManager.LayoutParams params2 = window2.getAttributes();
        params2.accessibilityTitle = context2.getString(R.string.battery_saver_charged_notification_summary);
        params2.windowAnimations = R.style.DialogWindowTitle.DeviceDefault.Light;
        params2.setTrustedOverlay();
        params2.width = dialogWidth;
        params2.height = -2;
        window2.setAttributes(params2);
        setupPasswordDialogMaterial(context2, window2, view2, "AutofillUpdatePasswordDialog");
        show();
        return;
    L7:
        r2 = 16975037;
        goto L8
    }

    private /* synthetic */ void lambda$new$5(View v) {
        this.mListener.onSave();
    }

    private /* synthetic */ void lambda$new$6(View v) {
        this.mListener.onCancel(null);
    }

    private /* synthetic */ void lambda$new$7(DialogInterface d) {
        this.mListener.onCancel(null);
    }

    private /* synthetic */ void lambda$new$8(View v) {
        this.mListener.onSave();
    }

    private /* synthetic */ void lambda$new$9(View v) {
        this.mListener.onCancel(null);
    }

    private /* synthetic */ void lambda$new$10(DialogInterface d) {
        this.mListener.onCancel(null);
    }

    private static void setupPasswordDialogMaterial(Context context, Window window, View materialSurface, String ownerName) {
        Slog.i(TAG, "setupPasswordDialogMaterial: start, owner=" + ownerName);
        if (context == null) goto L22;
        if (window == null) goto L22;
        if (materialSurface == null) goto L22;
        if (OMaterialHelperCore.isObricMaterialEnabled(context, ownerName) == true) goto L24;
        return;
    L24:
        boolean isLight = OMaterialHelperCore.isLightMode(context);     // Catch: RuntimeException -> L16
        MaterialConfigCore[] materials = copyModalMaterials(isLight);     // Catch: RuntimeException -> L16
        if (materials == null) goto L18;
        if (materials.length == 0) goto L18;
        window.setBackgroundDrawableResource(R.color.transparent);     // Catch: RuntimeException -> L16
        configurePasswordDialogMaterialSurface(context, materialSurface);     // Catch: RuntimeException -> L16
        OMaterialHelperCore.setMaterials(materialSurface, 3, materials);     // Catch: RuntimeException -> L16
        materialSurface.invalidate();     // Catch: RuntimeException -> L16
        Slog.i(TAG, "setupPasswordDialogMaterial: applied OUI_Bg_Modal material, owner=" + ownerName + ", isLight=" + isLight);     // Catch: RuntimeException -> L16
        return;
    L18:
        Slog.w(TAG, "setupPasswordDialogMaterial: missing OUI_Bg_Modal token, owner=" + ownerName);     // Catch: RuntimeException -> L16
        return;
    L16:
        e = move-exception;
        Slog.w(TAG, "setupPasswordDialogMaterial: material setup failed, owner=" + ownerName, e);
        return;
    L22:
        Slog.e(TAG, "setupPasswordDialogMaterial: missing context/window/surface, owner=" + ownerName);
    }

    private static void configurePasswordDialogMaterialSurface(Context context, View materialSurface) {
        GradientDrawable background = new GradientDrawable();
        background.setShape(0);
        background.setColor(0);
        background.setCornerRadius(OMaterialHelperCore.dpToPx(context, PASSWORD_DIALOG_CORNER_RADIUS_DP));
        materialSurface.setBackground(background);
        materialSurface.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        materialSurface.setClipToOutline(true);
        Slog.i(TAG, "configurePasswordDialogMaterialSurface: configured transparent rounded surface");
    }

    private static MaterialConfigCore[] copyModalMaterials(boolean isLight) {
        return OMaterialHelperCore.copyMaterials((MaterialConfigCore[]) MaterialTokenCore.OUI_Bg_Modal.invoke(Boolean.valueOf(isLight)));
    }

    private void adjustDividerVisibility(ScrollView scrollView, View divider) {
        boolean canScrollDown = scrollView.canScrollVertically(1);
        if (canScrollDown == false) goto L5;
        int r1 = 0;
    L6:
        divider.setVisibility(r1);
        return;
    L5:
        r1 = 4;
        goto L6
    }

    private boolean applyCustomDescription(Context r23, View r24, ValueFinder r25, SaveInfo r26) {
        CustomDescription r4 = r26.getCustomDescription();
        boolean r5 = false;
        if (r4 != null) goto L5;
        return false;
    L5:
        writeLog(1129);
        RemoteViews r6 = Helper.sanitizeRemoteView(r4.getPresentation());
        if (r6 != null) goto L9;
        Slog.w(TAG, "No remote view on custom description");
        return false;
    L9:
        ArrayList r8 = r4.getTransformations();
        if (Helper.sVerbose == false) goto L12;
        Slog.v(TAG, "applyCustomDescription(): transformations = " + r8);
    L12:
        if (r8 != null) goto L14;
    L17:
        RemoteViews.InteractionHandler r9 = new SaveUi$$ExternalSyntheticLambda5(this);
        View r0 = r6.applyWithTheme(r23, null, r9, this.mThemeId);     // Catch: Exception -> L75
        ArrayList r10 = r4.getUpdates();     // Catch: Exception -> L75
        if (Helper.sVerbose == false) goto L25;
        Slog.v(TAG, "applyCustomDescription(): view = " + r0 + " updates=" + r10);     // Catch: Exception -> L22
    L22:
        e = e;
    L108:
        Slog.e(TAG, "Error applying custom description. ", e);
        return false;
    L25:
        if (r10 != null) goto L125;
        CustomDescription r17 = r4;
        boolean r16 = false;
    L87:
        SparseArray r7 = r17.getActions();     // Catch: Exception -> L62
        if (r7 == null) goto L102;
        int r11 = r7.size();     // Catch: Exception -> L62
        if (Helper.sDebug == false) goto L93;
        Slog.d(TAG, "custom description has " + r11 + " actions");     // Catch: Exception -> L62
    L93:
        if ((r0 instanceof ViewGroup) == true) goto L95;
        Slog.w(TAG, "cannot apply actions because custom description root is not a ViewGroup: " + r0);     // Catch: Exception -> L62
        goto L102
    L95:
        final ViewGroup r12 = (ViewGroup) r0;     // Catch: Exception -> L62
        int r13 = 0;
    L96:
        if (r13 >= r11) goto L102;
        int r14 = r7.keyAt(r13);     // Catch: Exception -> L62
        final InternalOnClickAction r15 = (InternalOnClickAction) r7.valueAt(r13);     // Catch: Exception -> L62
        View r18 = r12.findViewById(r14);     // Catch: Exception -> L62
        if (r18 != null) goto L100;
        Slog.w(TAG, "Ignoring action " + r15 + " for view " + r14 + " because it's not on " + r12);     // Catch: Exception -> L62
    L101:
        r13 = r13 + 1;     // Catch: Exception -> L62
        goto L96
    L100:
        r18.setOnClickListener(new SaveUi$$ExternalSyntheticLambda6(r15, r12));     // Catch: Exception -> L62
    L102:
        applyTextViewStyle(r0);     // Catch: Exception -> L62
        ViewGroup r19 = (ViewGroup) r24.findViewById(R.id.autofill_save_icon);     // Catch: Exception -> L107
        r19.addView(r0);     // Catch: Exception -> L107
        r19.setVisibility(r16 ? 1 : 0);     // Catch: Exception -> L107
        r19.setScrollBarDefaultDelayBeforeFade(500);     // Catch: Exception -> L107
        return true;
    L107:
        e = e;
        goto L108
    L125:
        int r110 = r10.size();     // Catch: Exception -> L78
        if (Helper.sDebug == false) goto L29;
        Slog.d(TAG, "custom description has " + r110 + " batch updates");     // Catch: Exception -> L22
    L29:
        int r111 = 0;
    L30:
        if (r111 >= r110) goto L85;
        Pair r112 = (Pair) r10.get(r111);     // Catch: Exception -> L78
        InternalValidator r113 = (InternalValidator) r112.first;     // Catch: Exception -> L78
        if (r113 == null) goto L124;
        if (r113.isValid(r25) == false) goto L124;
        r5 = r5;
        BatchUpdates r20 = (BatchUpdates) r112.second;     // Catch: Exception -> L75
        RemoteViews r114 = Helper.sanitizeRemoteView(r20.getUpdates());     // Catch: Exception -> L75
        if (r114 != null) goto L120;
        r4 = r4;
        r20 = r20;
        RemoteViews r21 = r114;
    L116:
        ArrayList r22 = r20.getTransformations();     // Catch: Exception -> L72
        if (r22 == null) goto L74;
        if (Helper.sDebug == false) goto L68;
        StringBuilder r27 = new StringBuilder();     // Catch: Exception -> L64
        r27.append("Applying child transformation for batch update #");     // Catch: Exception -> L62
        r27.append(r111);     // Catch: Exception -> L62
        r27.append(": ");     // Catch: Exception -> L62
        r27.append(r22);     // Catch: Exception -> L62
        Slog.d(TAG, r27.toString());     // Catch: Exception -> L62
    L64:
        e = e;
    L68:
        if (InternalTransformation.batchApply(r25, r6, r22) == false) goto L69;
        r6.reapply(r23, r0);     // Catch: Exception -> L62
    L84:
        r111 = r111 + 1;     // Catch: Exception -> L62
        r5 = r5;
        r4 = r4;
        r8 = r8;
        r9 = r9;
        goto L30
    L69:
        Slog.w(TAG, "Could not apply child transformation for batch update #" + r111 + ": " + r22);     // Catch: Exception -> L62
        return r5;
    L74:
        r8 = r8;
        r9 = r9;
    L72:
        e = e;
        goto L108
    L120:
        if (Helper.sDebug == false) goto L47;
        Slog.d(TAG, "Applying template updates for batch update #" + r111);     // Catch: Exception -> L44
    L44:
        e = e;
    L47:
        r21 = r114;
        r21.reapply(r23, r0);     // Catch: Exception -> L44
    L49:
        e = e;
    L124:
    L62:
        e = e;
        goto L108
    L82:
        if (Helper.sDebug == false) goto L84;
        Slog.d(TAG, "Skipping batch update #" + r111);     // Catch: Exception -> L62
        goto L84
    L85:
        r17 = r4;
        r16 = r5;
    L78:
        e = e;
    L75:
        e = e;
        goto L108
    L14:
        if (InternalTransformation.batchApply(r25, r6, r8) == true) goto L17;
        Slog.w(TAG, "could not apply main transformations on custom description");
        return false;
    }

    private /* synthetic */ boolean lambda$applyCustomDescription$11(View view, PendingIntent pendingIntent, RemoteViews.RemoteResponse response) {
        Intent intent = (Intent) response.getLaunchOptions(view).first;
        boolean isValid = isValidLink(pendingIntent, intent);
        if (isValid == true) goto L6;
        LogMaker log = newLogMaker(1132, this.mType);
        log.setType(0);
        this.mMetricsLogger.write(log);
        return false;
    L6:
        startIntentSenderWithRestore(pendingIntent, intent);
        return true;
    }

    private static /* synthetic */ void lambda$applyCustomDescription$12(InternalOnClickAction action, ViewGroup rootView, View v) {
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "Applying " + action + " after " + v + " was clicked");
    L5:
        action.onClick(rootView);
    }

    private void startIntentSenderWithRestore(PendingIntent pendingIntent, Intent intent) {
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "Intercepting custom description intent");
    L5:
        IBinder token = this.mPendingUi.getToken();
        intent.putExtra("android.view.autofill.extra.RESTORE_SESSION_TOKEN", token);
        this.mListener.startIntentSender(pendingIntent.getIntentSender(), intent);
        this.mPendingUi.setState(2);
        if (Helper.sDebug == false) goto L8;
        Slog.d(TAG, "hiding UI until restored with token " + token);
    L8:
        hide();
        LogMaker log = newLogMaker(1132, this.mType);
        log.setType(1);
        this.mMetricsLogger.write(log);
    }

    private void applyTextViewStyle(View rootView) {
        final List<TextView> textViews = new ArrayList();
        Predicate<View> predicate = new SaveUi$$ExternalSyntheticLambda13(textViews);
        rootView.findViewByPredicate(predicate);
        int size = textViews.size();
        int i = 0;
    L3:
        if (i >= size) goto L6;
        applyMovementMethodIfNeed(textViews.get(i));
        i = i + 1;
        goto L3
    }

    private static /* synthetic */ boolean lambda$applyTextViewStyle$13(List textViews, View view) {
        if ((view instanceof TextView) == false) goto L7;
        textViews.add((TextView) view);
        return false;
    L7:
        return false;
    }

    private void applyMovementMethodIfNeed(TextView textView) {
        CharSequence message = textView.getText();
        if (TextUtils.isEmpty(message) == false) goto L5;
        return;
    L5:
        SpannableStringBuilder ssb = new SpannableStringBuilder(message);
        ClickableSpan[] spans = (ClickableSpan[]) ssb.getSpans(0, ssb.length(), ClickableSpan.class);
        if (ArrayUtils.isEmpty(spans) == false) goto L8;
        return;
    L8:
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void setServiceIcon(Context context, View view, Drawable serviceIcon) {
        ImageView iconView = (ImageView) view.findViewById(R.id.autofill_save_no);
        context.getResources();
        iconView.setImageDrawable(serviceIcon);
    }

    private static boolean isValidLink(PendingIntent pendingIntent, Intent intent) {
        if (pendingIntent != null) goto L7;
        Slog.w(TAG, "isValidLink(): custom description without pending intent");
        return false;
    L7:
        if (pendingIntent.isActivity() == true) goto L10;
        Slog.w(TAG, "isValidLink(): pending intent not for activity");
        return false;
    L10:
        if (intent != null) goto L13;
        Slog.w(TAG, "isValidLink(): no intent");
        return false;
    L13:
        return true;
    }

    private LogMaker newLogMaker(int category, int saveType) {
        return newLogMaker(category).addTaggedData(1130, Integer.valueOf(saveType));
    }

    private LogMaker newLogMaker(int category) {
        return Helper.newLogMaker(category, this.mComponentName, this.mServicePackageName, this.mPendingUi.sessionId, this.mCompatMode);
    }

    private void writeLog(int category) {
        this.mMetricsLogger.write(newLogMaker(category, this.mType));
    }

    void onPendingUi(int operation, IBinder token) {
        if (this.mPendingUi.matches(token) == true) goto L6;
        Slog.w(TAG, "restore(" + operation + "): got token " + token + " instead of " + this.mPendingUi.getToken());
        return;
    L6:
        LogMaker log = newLogMaker(1134);
        switch(operation) {
            case 1: goto L16;
            case 2: goto L13;
            default: goto L9;
        };
    L16:
        log.setType(5);     // Catch: Throwable -> L10
        if (Helper.sDebug == false) goto L19;
        Slog.d(TAG, "Cancelling pending save dialog for " + token);     // Catch: Throwable -> L10
    L19:
        hide();     // Catch: Throwable -> L10
    L20:
        this.mMetricsLogger.write(log);
        this.mPendingUi.setState(4);
        return;
    L9:
        log.setType(11);     // Catch: Throwable -> L10
        Slog.w(TAG, "restore(): invalid operation " + operation);     // Catch: Throwable -> L10
        goto L20
    L13:
        if (Helper.sDebug == false) goto L15;
        Slog.d(TAG, "Restoring save dialog for " + token);     // Catch: Throwable -> L10
    L15:
        log.setType(1);     // Catch: Throwable -> L10
        show();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mMetricsLogger.write(log);
        throw th;
    }

    private void show() {
        Slog.i(TAG, "Showing save dialog: " + this.mTitle);
        this.mDialog.show();
        this.mOverlayControl.hideOverlays();
    }

    PendingUi hide() {
        if (Helper.sVerbose == false) goto L11;
        Slog.v(TAG, "Hiding save dialog.");
    L11:
        this.mDialog.hide();     // Catch: Throwable -> L8
        this.mOverlayControl.showOverlays();
        return this.mPendingUi;
    L8:
        th = move-exception;
        this.mOverlayControl.showOverlays();
        throw th;
    }

    boolean isShowing() {
        return this.mDialog.isShowing();
    }

    void destroy() {
    L5:
        th = move-exception;
        this.mOverlayControl.showOverlays();
        throw th;
    L3:
        if (Helper.sDebug == false) goto L7;
        Slog.d(TAG, "destroy()");     // Catch: Throwable -> L5
    L7:
        throwIfDestroyed();     // Catch: Throwable -> L5
        this.mListener.onDestroy();     // Catch: Throwable -> L5
        this.mHandler.removeCallbacksAndMessages(this.mListener);     // Catch: Throwable -> L5
        this.mDialog.dismiss();     // Catch: Throwable -> L5
        this.mDestroyed = true;     // Catch: Throwable -> L5
        this.mOverlayControl.showOverlays();
    }

    private void throwIfDestroyed() {
        if (this.mDestroyed == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("cannot interact with a destroyed instance");
    }

    public String toString() {
        if (this.mTitle != null) goto L6;
        return "NO TITLE";
    L6:
        return this.mTitle.toString();
    }

    void dump(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.print("title: ");
        pw.println(this.mTitle);
        pw.print(prefix);
        pw.print("subtitle: ");
        pw.println(this.mSubTitle);
        pw.print(prefix);
        pw.print("pendingUi: ");
        pw.println(this.mPendingUi);
        pw.print(prefix);
        pw.print("service: ");
        pw.println(this.mServicePackageName);
        pw.print(prefix);
        pw.print("app: ");
        pw.println(this.mComponentName.toShortString());
        pw.print(prefix);
        pw.print("compat mode: ");
        pw.println(this.mCompatMode);
        pw.print(prefix);
        pw.print("theme id: ");
        pw.print(this.mThemeId);
        switch(this.mThemeId) {
            case 16975025: goto L6;
            case 16975037: goto L5;
            default: goto L4;
        };
    L4:
        pw.println("(UNKNOWN_MODE)");
    L7:
        View view = this.mDialog.getWindow().getDecorView();
        int[] loc = view.getLocationOnScreen();
        pw.print(prefix);
        pw.print("coordinates: ");
        pw.print('(');
        pw.print(loc[0]);
        pw.print(',');
        pw.print(loc[1]);
        pw.print(')');
        pw.print('(');
        pw.print(loc[0] + view.getWidth());
        pw.print(',');
        pw.print(loc[1] + view.getHeight());
        pw.println(')');
        pw.print(prefix);
        pw.print("destroyed: ");
        pw.println(this.mDestroyed);
        return;
    L5:
        pw.println(" (light)");
        goto L7
    L6:
        pw.println(" (dark)");
        goto L7
    }
}
