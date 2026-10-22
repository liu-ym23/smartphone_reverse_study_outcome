package com.android.server.am;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.UserInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserManager;
import android.util.Slog;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.internal.util.ObjectUtils;
import com.android.internal.util.UserIcons;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class UserSwitchingDialog extends Dialog {
    private static final int ANIMATION_TIMEOUT_MS = 1000;
    protected static final boolean DEBUG = true;
    private static final long DIALOG_SHOW_HIDE_ANIMATION_DURATION_MS = 300;
    private static final String TAG = "UserSwitchingDialog";
    private static final long TRACE_TAG = 64;
    protected final Context mContext;
    private final boolean mDisableAnimations;
    private final Handler mHandler;
    protected final UserInfo mNewUser;
    protected final UserInfo mOldUser;
    private final String mSwitchingFromUserMessage;
    private final String mSwitchingToUserMessage;
    private final int mTraceCookie;

    /* JADX INFO: renamed from: $r8$lambda$5NqD0_Luw6ZsTDBo6jEY0-IO8uM, reason: not valid java name */
    public static /* synthetic */ void m1601$r8$lambda$5NqD0_Luw6ZsTDBo6jEY0IO8uM(String r0, Runnable r1) {
        lambda$animationWithTimeout$6(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$GwAb5XTAMKnNSVU65IcCzTsB9Gk(Runnable r0) {
        lambda$show$0(r0);
    }

    public static /* synthetic */ void $r8$lambda$Urx1na3xSUj5v9yusgmvPu5vAGE(UserSwitchingDialog r0, Runnable r1) {
        r0.lambda$startDismissAnimation$4(r1);
    }

    public static /* synthetic */ void $r8$lambda$n6zjrmfI_HhnfLq6s4lpiNHuDDU(UserSwitchingDialog r0, Runnable r1) {
        r0.lambda$startShowAnimation$3(r1);
    }

    public static /* synthetic */ void $r8$lambda$uyKSDbOYwNPshkGOB_1BSiTEufY(UserSwitchingDialog r0, AtomicBoolean r1, Runnable r2) {
        r0.lambda$animationWithTimeout$5(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$xsDK0cmiZottOh-oAYlXeDXggdw, reason: not valid java name */
    public static /* synthetic */ void m1602$r8$lambda$xsDK0cmiZottOhoAYlXeDXggdw(UserSwitchingDialog r0, Runnable r1) {
        r0.lambda$dismiss$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$yPbG8DIBNhoIbmE7hkNB-ds1z3Y, reason: not valid java name */
    public static /* synthetic */ void m1603$r8$lambda$yPbG8DIBNhoIbmE7hkNBds1z3Y(UserSwitchingDialog r0, Runnable r1) {
        r0.lambda$startShowAnimation$2(r1);
    }

    UserSwitchingDialog(Context context, UserInfo oldUser, UserInfo newUser, Handler handler, String switchingFromUserMessage, String switchingToUserMessage) {
        super(context, R.style.Theme.Material.NoActionBar.Fullscreen);
        this.mContext = context;
        this.mOldUser = oldUser;
        this.mNewUser = newUser;
        this.mHandler = handler;
        this.mSwitchingFromUserMessage = switchingFromUserMessage;
        this.mSwitchingToUserMessage = switchingToUserMessage;
        this.mDisableAnimations = SystemProperties.getBoolean("debug.usercontroller.disable_user_switching_dialog_animations", false);
        this.mTraceCookie = (oldUser.id * 21473) + newUser.id;
        inflateContent();
        configureWindow();
    }

    private void configureWindow() {
        Window window = getWindow();
        WindowManager.LayoutParams attrs = window.getAttributes();
        attrs.privateFlags = 272;
        attrs.layoutInDisplayCutoutMode = 3;
        window.setAttributes(attrs);
        window.setBackgroundDrawableResource(R.color.transparent);
        window.setType(2010);
        window.setDecorFitsSystemWindows(false);
    }

    void inflateContent() {
        setCancelable(false);
        setContentView(17367527);
        TextView textView = (TextView) findViewById(R.id.message);
        if (textView == null) goto L5;
        String message = getTextMessage();
        textView.setAccessibilityPaneTitle(message);
        textView.setText(message);
    L5:
        ImageView imageView = (ImageView) findViewById(R.id.icon);
        if (imageView == null) goto L8;
        imageView.setImageBitmap(getUserIconRounded());
    L8:
        ImageView progressCircular = (ImageView) findViewById(R.id.showVoiceSearchButton);
        if (progressCircular != null) goto L11;
        return;
    L11:
        if (this.mDisableAnimations == false) goto L13;
        progressCircular.setVisibility(8);
        return;
    L13:
        TypedValue value = new TypedValue();
        getContext().getTheme().resolveAttribute(R.^attr-private.colorListDivider, value, true);
        progressCircular.setColorFilter(value.data);
    }

    private Bitmap getUserIconRounded() {
        Bitmap bmp = (Bitmap) ObjectUtils.getOrElse(BitmapFactory.decodeFile(this.mNewUser.iconPath), defaultUserIcon(this.mNewUser.id));
        int w = bmp.getWidth();
        int h = bmp.getHeight();
        Bitmap bmpRounded = Bitmap.createBitmap(w, h, bmp.getConfig());
        Paint paint = new Paint(1);
        paint.setShader(new BitmapShader(bmp, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        new Canvas(bmpRounded).drawRoundRect(new RectF(0.0f, 0.0f, w, h), w / 2.0f, h / 2.0f, paint);
        return bmpRounded;
    }

    private Bitmap defaultUserIcon(int userId) {
        Resources res = getContext().getResources();
        Drawable icon = UserIcons.getDefaultUserIcon(res, userId, false);
        return UserIcons.convertToBitmapAtUserIconSize(res, icon);
    }

    private String getTextMessage() {
        Resources res = getContext().getResources();
        if (UserManager.isDeviceInDemoMode(this.mContext) == false) goto L11;
        if (this.mOldUser.isDemo() == false) goto L7;
        int r1 = R.string.editTextMenuTitle;
    L9:
        return res.getString(r1);
    L7:
        r1 = R.string.edit_accessibility_shortcut_menu_button;
        goto L9
    L11:
        if (this.mSwitchingFromUserMessage != null) goto L18;
        if (this.mSwitchingToUserMessage != null) goto L18;
        return res.getString(17042326, new Object[]{this.mNewUser.name});
    L18:
        if (this.mSwitchingFromUserMessage == null) goto L24;
        if (this.mSwitchingToUserMessage == null) goto L24;
        return this.mSwitchingFromUserMessage + " " + this.mSwitchingToUserMessage;
    L24:
        return (String) Objects.requireNonNullElse(this.mSwitchingFromUserMessage, this.mSwitchingToUserMessage);
    }

    @Override // android.app.Dialog
    public void show() {
        asyncTraceBegin("dialog", 0);
        super.show();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        asyncTraceEnd("dialog", 0);
    }

    public void show(final Runnable onShown) {
        Slog.d(TAG, "show called");
        show();
        startShowAnimation(new UserSwitchingDialog$$ExternalSyntheticLambda6(onShown));
    }

    private static /* synthetic */ void lambda$show$0(Runnable onShown) {
        onShown.run();
    }

    public void dismiss(final Runnable onDismissed) {
        Slog.d(TAG, "dismiss called");
        if (onDismissed != null) goto L5;
        dismiss();
        return;
    L5:
        startDismissAnimation(new UserSwitchingDialog$$ExternalSyntheticLambda3(this, onDismissed));
    }

    private /* synthetic */ void lambda$dismiss$1(Runnable onDismissed) {
        dismiss();
        onDismissed.run();
    }

    private void startShowAnimation(final Runnable onAnimationEnd) {
        if (this.mDisableAnimations == false) goto L6;
        onAnimationEnd.run();
        return;
    L6:
        asyncTraceBegin("showAnimation", 1);
        startDialogAnimation("show", new AlphaAnimation(0.0f, 1.0f), new UserSwitchingDialog$$ExternalSyntheticLambda2(this, onAnimationEnd));
    }

    private /* synthetic */ void lambda$startShowAnimation$3(final Runnable onAnimationEnd) {
        asyncTraceEnd("showAnimation", 1);
        asyncTraceBegin("spinnerAnimation", 2);
        startProgressAnimation(new UserSwitchingDialog$$ExternalSyntheticLambda5(this, onAnimationEnd));
    }

    private /* synthetic */ void lambda$startShowAnimation$2(Runnable onAnimationEnd) {
        asyncTraceEnd("spinnerAnimation", 2);
        onAnimationEnd.run();
    }

    private void startDismissAnimation(final Runnable onAnimationEnd) {
        if (this.mDisableAnimations == false) goto L6;
        onAnimationEnd.run();
        return;
    L6:
        asyncTraceBegin("dismissAnimation", 3);
        startDialogAnimation("dismiss", new AlphaAnimation(1.0f, 0.0f), new UserSwitchingDialog$$ExternalSyntheticLambda4(this, onAnimationEnd));
    }

    private /* synthetic */ void lambda$startDismissAnimation$4(Runnable onAnimationEnd) {
        asyncTraceEnd("dismissAnimation", 3);
        onAnimationEnd.run();
    }

    private void startProgressAnimation(Runnable onAnimationEnd) {
        AnimatedVectorDrawable avd = getSpinnerAVD();
        if (this.mDisableAnimations == true) goto L8;
        if (avd == null) goto L8;
        final Runnable onAnimationEndWithTimeout = animationWithTimeout("spinner", onAnimationEnd);
        avd.registerAnimationCallback(new AnonymousClass1(this, onAnimationEndWithTimeout));
        avd.start();
        return;
    L8:
        onAnimationEnd.run();
    }

    private AnimatedVectorDrawable getSpinnerAVD() {
        ImageView view = (ImageView) findViewById(R.id.showVoiceSearchButton);
        if (view == null) goto L8;
        Drawable drawable = view.getDrawable();
        if ((drawable instanceof AnimatedVectorDrawable) == true) goto L7;
        return null;
    L7:
        return (AnimatedVectorDrawable) drawable;
    L8:
        return null;
    }

    private void startDialogAnimation(String name, Animation animation, Runnable onAnimationEnd) {
        View view = findViewById(R.id.content);
        if (this.mDisableAnimations == true) goto L8;
        if (view == null) goto L8;
        final Runnable onAnimationEndWithTimeout = animationWithTimeout(name, onAnimationEnd);
        animation.setDuration(DIALOG_SHOW_HIDE_ANIMATION_DURATION_MS);
        animation.setAnimationListener(new AnonymousClass2(this, onAnimationEndWithTimeout));
        view.startAnimation(animation);
        return;
    L8:
        onAnimationEnd.run();
    }

    private Runnable animationWithTimeout(final String name, final Runnable onAnimationEnd) {
        final AtomicBoolean isFirst = new AtomicBoolean(true);
        final Runnable onAnimationEndOrTimeout = new UserSwitchingDialog$$ExternalSyntheticLambda0(this, isFirst, onAnimationEnd);
        this.mHandler.postDelayed(new UserSwitchingDialog$$ExternalSyntheticLambda1(name, onAnimationEndOrTimeout), 160, 1000);
        return onAnimationEndOrTimeout;
    }

    private /* synthetic */ void lambda$animationWithTimeout$5(AtomicBoolean isFirst, Runnable onAnimationEnd) {
        if (isFirst.getAndSet(false) == false) goto L6;
        this.mHandler.removeMessages(160);
        onAnimationEnd.run();
        return;
    }

    private static /* synthetic */ void lambda$animationWithTimeout$6(String name, Runnable onAnimationEndOrTimeout) {
        Slog.w(TAG, name + " animation not completed in 1000 ms");
        onAnimationEndOrTimeout.run();
    }

    private void asyncTraceBegin(String subTag, int subCookie) {
        Slog.d(TAG, "asyncTraceBegin-" + subTag);
        Trace.asyncTraceBegin(64, TAG + subTag, this.mTraceCookie + subCookie);
    }

    private void asyncTraceEnd(String subTag, int subCookie) {
        Trace.asyncTraceEnd(64, TAG + subTag, this.mTraceCookie + subCookie);
        Slog.d(TAG, "asyncTraceEnd-" + subTag);
    }
}
