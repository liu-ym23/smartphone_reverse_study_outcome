package com.android.ttcjpaysdk.base.framework;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.PopupWindow;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.android.ttcjpaysdk.base.ktextension.CJResult;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.base.utils.CJPayLargeScreenUtils;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.home.impl.utils.c;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.lynx.serval.svg.SVGRenderEngine;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import el9.a;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0003BCDB+\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\n\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u000208H\u0003J\u001a\u00109\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010:\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010;\u001a\u00020\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010<\u001a\u000208H\u0002J\u0006\u0010=\u001a\u000208J\b\u0010\u001e\u001a\u00020\u000bH\u0002J\b\u0010>\u001a\u000208H\u0016J\b\u0010?\u001a\u000208H\u0002J\u0010\u0010@\u001a\u0002082\b\u0010A\u001a\u0004\u0018\u00010-R\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u000e\u0010\u001e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006E"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/KeyboardStatePopupWindow;", "Landroid/widget/PopupWindow;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Lcom/android/ttcjpaysdk/base/ktextension/ICJTag;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "anchorView", "Landroid/view/View;", "windowCurrent", "Landroid/view/Window;", "bottomAnimatorOpt", "", "(Landroid/content/Context;Landroid/view/View;Landroid/view/Window;Ljava/lang/Boolean;)V", "OPEN_KEYBOARD", "", "getAnchorView", "()Landroid/view/View;", "getBottomAnimatorOpt", "()Ljava/lang/Boolean;", "setBottomAnimatorOpt", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "canGlobalLayoutFocus", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "hasFocus", "getHasFocus", "setHasFocus", "isMiui", "isSoftKeyboardOpened", "lastKeyboardHeight", "getLastKeyboardHeight", "()I", "setLastKeyboardHeight", "(I)V", "lastScreenHeight", "mHandler", "Landroid/os/Handler;", "maxHeight", "miuiHeightGap", "onKeyboardAnimatorCallback", "Lcom/android/ttcjpaysdk/base/framework/KeyboardStatePopupWindow$OnKeyboardAnimatorCallback;", "onKeyboardStateListener", "Lcom/android/ttcjpaysdk/base/framework/KeyboardStatePopupWindow$OnKeyboardStateListener;", FilterData.FilterOptionItem.Type.RANGE, SVGRenderEngine.RECT, "Landroid/graphics/Rect;", "getWindowCurrent", "()Landroid/view/Window;", "setWindowCurrent", "(Landroid/view/Window;)V", "CJTag", "", "addWindowCallback", "", "computeMaxHeight", LiveEndPageData.TAG_WINDOW, "getScreenHeight", "handleKeyBoardChange", "handleMsg", "onGlobalLayout", "onGlobalLayoutOnlyOnce", "setOnKeyboardStateListener", "listener", "KeyboardConfig", "OnKeyboardAnimatorCallback", "OnKeyboardStateListener", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class KeyboardStatePopupWindow extends PopupWindow implements ViewTreeObserver.OnGlobalLayoutListener, ICJTag {
    private final int OPEN_KEYBOARD;
    private final View anchorView;
    private Boolean bottomAnimatorOpt;
    private Boolean canGlobalLayoutFocus;
    private Context context;
    private Boolean hasFocus;
    private final boolean isMiui;
    private boolean isSoftKeyboardOpened;
    private int lastKeyboardHeight;
    private int lastScreenHeight;
    private final Handler mHandler;
    private int maxHeight;
    private int miuiHeightGap;
    private OnKeyboardAnimatorCallback onKeyboardAnimatorCallback;
    private OnKeyboardStateListener onKeyboardStateListener;
    private final int range;
    private final Rect rect;
    private Window windowCurrent;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/KeyboardStatePopupWindow$KeyboardConfig;", "", "height", "", "heightGap", "scale", "", "(IIF)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class KeyboardConfig {
        public int height;
        public int heightGap;
        public float scale;

        public KeyboardConfig() {
            this(0, 0, 0.0f, 7, null);
        }

        public KeyboardConfig(int r100, int r101, float r102) {
            this.height = r100;
            this.heightGap = r101;
            this.scale = r102;
        }

        public /* synthetic */ KeyboardConfig(int r100, int r101, float r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = 0;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = 0.0f;
        L11:
            this(r100, r101, r102);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/KeyboardStatePopupWindow$OnKeyboardAnimatorCallback;", "", "onKeyboardAnimationEnd", "", "duration", "", "onKeyboardAnimationStart", "onKeyboardProgress", "height", "", "nativeBarHeight", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnKeyboardAnimatorCallback {
        void onKeyboardAnimationEnd(long r100);

        void onKeyboardAnimationStart();

        void onKeyboardProgress(int r100, int r101);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/KeyboardStatePopupWindow$OnKeyboardStateListener;", "", "onClosed", "", "onOpened", "keyboardHeight", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnKeyboardStateListener {
        void onClosed();

        void onOpened(int r100);
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public String CJTag() {
        return "KeyboardStatePopupWindow";
    }

    private final void addWindowCallback() {
        Window r100 = this.windowCurrent;
        if (r100 == null) goto L8;
        View r101 = INVOKEVIRTUAL_com_android_ttcjpaysdk_base_framework_KeyboardStatePopupWindow_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100);
        if (r101 == null) goto L9;
        r101.setWindowInsetsAnimationCallback(new C88301(this));
        return;
    L9:
        return;
    }

    private final void handleKeyBoardChange() {
        int r100 = this.lastKeyboardHeight;
        Context r101 = this.context;
        LifecycleOwner r102 = null;
        if ((r101 instanceof Activity) == false) goto L5;
        Activity r103 = (Activity) r101;
    L6:
        int r104 = r100 - CJPayBasicUtils.getNavigationBarHeight(r103);
        if (r104 <= 0) goto L9;
        boolean r105 = true;
    L10:
        Object r106 = this.context;
        if ((r106 instanceof LifecycleOwner) == false) goto L13;
        r102 = (LifecycleOwner) r106;
    L13:
        if (r102 == null) goto L21;
        Lifecycle r107 = r102.getLifecycle();
        if (r107 == null) goto L21;
        Lifecycle.State r108 = r107.getCurrentState();
        if (r108 == null) goto L21;
        if (r108.isAtLeast(Lifecycle.State.RESUMED) == true) goto L21;
        boolean r109 = true;
    L22:
        if (r109 == true) goto L24;
    L27:
        i("handleKeyBoardChange keyboardHeight:" + r104);
        if (r105 == false) goto L33;
        this.isSoftKeyboardOpened = true;
        OnKeyboardStateListener r110 = this.onKeyboardStateListener;
        if (r110 == null) goto L40;
        r110.onOpened(r104);
        return;
    L40:
        return;
    L33:
        if (this.isSoftKeyboardOpened == false) goto L42;
        if (r105 == true) goto L43;
        this.isSoftKeyboardOpened = false;
        OnKeyboardStateListener r111 = this.onKeyboardStateListener;
        if (r111 == null) goto L44;
        r111.onClosed();
        return;
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L24:
        if (this.isSoftKeyboardOpened == false) goto L26;
        if (r105 == false) goto L27;
        return;
    L26:
        return;
    L21:
        r109 = false;
        goto L22
    L9:
        r105 = false;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    private final void onGlobalLayoutOnlyOnce() {
        if (this.canGlobalLayoutFocus != null) goto L5;
        this.canGlobalLayoutFocus = this.hasFocus;
    L5:
        Boolean r100 = this.bottomAnimatorOpt;
        Boolean r101 = Boolean.TRUE;
        if (Intrinsics.areEqual(r100, r101) == true) goto L8;
    L9:
        Message r102 = this.mHandler.obtainMessage(this.OPEN_KEYBOARD);
        this.mHandler.removeMessages(this.OPEN_KEYBOARD);
        this.mHandler.sendMessageDelayed(r102, 40);
        return;
    L8:
        if (Intrinsics.areEqual(this.canGlobalLayoutFocus, r101) == false) goto L9;
    }

    public final void handleMsg() {
        int r100 = getScreenHeight(this.context);
        KeyboardConfig r101 = new KeyboardConfig(2950, 650, 0.75f);
        getContentView().getWindowVisibleDisplayFrame(this.rect);
        if (CJPayLargeScreenUtils.isCashierLargeScreenAdaptEnabled() == false) goto L8;
        int r102 = this.lastScreenHeight;
        if (r102 == 0) goto L8;
        if (r102 == r100) goto L8;
        i("screen height changed " + this.lastScreenHeight + " -> " + r100 + ", reset maxHeight from " + this.maxHeight + " to " + this.rect.bottom);
        this.maxHeight = this.rect.bottom;
        this.miuiHeightGap = 0;
    L8:
        this.lastScreenHeight = r100;
        int r103 = this.rect.bottom;
        int r104 = this.maxHeight;
        if (r103 <= r104) goto L15;
        if (this.isMiui == false) goto L13;
        this.miuiHeightGap = r103 - r104;
    L13:
        this.maxHeight = r103;
    L15:
        if (this.isMiui == true) goto L17;
    L21:
        int r105 = this.maxHeight - r103;
    L22:
        i("keyboardHeight:" + r105 + ", rect.bottom: " + this.rect.bottom + ", maxHeight: " + this.maxHeight + ", screenHeight: " + r100 + " lastKeyboardHeight =" + this.lastKeyboardHeight);
        if (r105 <= (r100 / this.range)) goto L25;
        boolean r106 = true;
    L26:
        LifecycleOwner r107 = null;
        this.canGlobalLayoutFocus = null;
        Object r108 = this.context;
        if ((r108 instanceof LifecycleOwner) == false) goto L29;
        r107 = (LifecycleOwner) r108;
    L29:
        if (r107 == null) goto L37;
        Lifecycle r109 = r107.getLifecycle();
        if (r109 == null) goto L37;
        Lifecycle.State r110 = r109.getCurrentState();
        if (r110 == null) goto L37;
        if (r110.isAtLeast(Lifecycle.State.RESUMED) == true) goto L37;
        boolean r111 = true;
    L38:
        if (r111 == true) goto L40;
    L43:
        if (r106 == false) goto L48;
        this.isSoftKeyboardOpened = true;
        OnKeyboardStateListener r112 = this.onKeyboardStateListener;
        if (r112 == null) goto L55;
        r112.onOpened(r105);
        return;
    L55:
        return;
    L48:
        if (this.isSoftKeyboardOpened == false) goto L57;
        if (r106 == true) goto L58;
        this.isSoftKeyboardOpened = false;
        OnKeyboardStateListener r113 = this.onKeyboardStateListener;
        if (r113 == null) goto L59;
        r113.onClosed();
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L40:
        if (this.isSoftKeyboardOpened == false) goto L42;
        if (r106 == false) goto L43;
        return;
    L42:
        return;
    L37:
        r111 = false;
        goto L38
    L25:
        r106 = false;
        goto L26
    L17:
        if (this.miuiHeightGap <= r101.heightGap) goto L21;
        int r114 = this.maxHeight;
        if (r114 <= r101.height) goto L21;
        r105 = (int) ((r114 - r103) * r101.scale);
        goto L22
    }

    private final boolean isMiui() {
        String r100 = CJTag();
        String r101 = "runCatching";
        if (r100 != null) goto L5;
        String r102 = "runCatching";
    L10:
        if (StringsKt.isBlank(r102) == false) goto L17;
        String r103 = CJTag();
        if (r103 != null) goto L14;
    L18:
        String r104 = CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 5), "\n ", null, null, 0, null, null, 62, null);
        CJLogger.a(r101, "Debug\n " + CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 10), "\n ", null, null, 0, null, null, 62, null));
        long r105 = System.currentTimeMillis();
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L26
    L25:
        return false;
    L21:
        if (INVOKESTATIC_com_android_ttcjpaysdk_base_framework_KeyboardStatePopupWindow_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("miui.os.Build") == null) goto L23;
        return true;
    L23:
        return StringsKt.contains(Build.MANUFACTURER, DimLocationCheckUtil.XIAOMI, true);
    L26:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Object r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        String r110 = null;
        if (Result.m9456isSuccessimpl(r108) == false) goto L30;
        CJLogger.d(r101, "onSuccess\n " + r104);
        Object r111 = r108;
        boolean r109 = true;
    L31:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r108);
        if (r112 == null) goto L34;
        CJBasicCommonUtils.reportCatchException("CJResult#unknown", r112);
        CJLogger.c(r101, "onFailure", r112);
        r109 = false;
    L35:
        long r113 = System.currentTimeMillis() - r105;
        CJLogger.d(r101, "is_success: " + r109 + ", duration: " + r113);
        CJReporter r114 = CJReporter.f202294a;
        Set<String> r115 = CJContext.f202254w;
        String r116 = "";
        CJContext r117 = CJContext.c.a(r102, "", "", new HashMap());
        Pair[] r118 = new Pair[5];
        r118[0] = TuplesKt.to("tag", r102);
        r118[1] = TuplesKt.to("is_success", KtSafeMethodExtensionKt.tf(r109, "1", "0"));
        if (r112 == null) goto L38;
        r110 = r112.getMessage();
    L38:
        if (r110 == null) goto L41;
        r116 = r110;
    L41:
        r118[2] = TuplesKt.to("error_msg", r116);
        r118[3] = TuplesKt.to("trace", r104);
        r118[4] = TuplesKt.to("duration", Long.valueOf(r113));
        CJReporter.o(r117, "cjpay_run_catch_result", MapsKt.mapOf(r118));
        new CJResult(r111, r109, r112);
        return false;
    L34:
        r112 = null;
        goto L35
    L30:
        r111 = null;
        r109 = false;
        goto L31
    L14:
        if (StringsKt.isBlank(r103) == true) goto L18;
        r101 = r103;
        goto L18
    L17:
        r101 = r102;
        goto L18
    L5:
        if (StringsKt.isBlank(r100) == false) goto L7;
        r100 = "runCatching";
    L7:
        r102 = r100;
        goto L10
    }

    public final View getAnchorView() {
        return this.anchorView;
    }

    public final Boolean getBottomAnimatorOpt() {
        return this.bottomAnimatorOpt;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Boolean getHasFocus() {
        return this.hasFocus;
    }

    public final int getLastKeyboardHeight() {
        return this.lastKeyboardHeight;
    }

    public final Window getWindowCurrent() {
        return this.windowCurrent;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        onGlobalLayoutOnlyOnce();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_android_ttcjpaysdk_base_framework_KeyboardStatePopupWindow_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static View INVOKEVIRTUAL_com_android_ttcjpaysdk_base_framework_KeyboardStatePopupWindow_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_android_ttcjpaysdk_base_framework_KeyboardStatePopupWindow_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static final /* synthetic */ OnKeyboardAnimatorCallback access$getOnKeyboardAnimatorCallback$p(KeyboardStatePopupWindow r100) {
        return r100.onKeyboardAnimatorCallback;
    }

    public static final /* synthetic */ void access$handleKeyBoardChange(KeyboardStatePopupWindow r100) {
        r100.handleKeyBoardChange();
    }

    private final int getScreenHeight(Context r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        DisplayMetrics r101 = INVOKEVIRTUAL_com_android_ttcjpaysdk_base_framework_KeyboardStatePopupWindow_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources());
        if (r101 != null) goto L8;
        return 0;
    L8:
        return r101.heightPixels;
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void d(String r100) {
        ICJTag.DefaultImpls.d(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void i(String r100) {
        ICJTag.DefaultImpls.i(this, r100);
    }

    public final void setBottomAnimatorOpt(Boolean r100) {
        this.bottomAnimatorOpt = r100;
    }

    public final void setContext(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.context = r100;
    }

    public final void setHasFocus(Boolean r100) {
        this.hasFocus = r100;
    }

    public final void setLastKeyboardHeight(int r100) {
        this.lastKeyboardHeight = r100;
    }

    public final void setOnKeyboardStateListener(OnKeyboardStateListener r100) {
        this.onKeyboardStateListener = r100;
    }

    public final void setWindowCurrent(Window r100) {
        this.windowCurrent = r100;
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void w(String r100) {
        ICJTag.DefaultImpls.w(this, r100);
    }

    public static final /* synthetic */ void access$setMaxHeight$p(KeyboardStatePopupWindow r100, int r101) {
        r100.maxHeight = r101;
    }

    private final int computeMaxHeight(Context r100, Window r101) {
        if (r101 == null) goto L9;
        View r102 = INVOKEVIRTUAL_com_android_ttcjpaysdk_base_framework_KeyboardStatePopupWindow_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r101).findViewById(R.id.content);
        if (r102 == null) goto L21;
        return r102.getHeight();
    L21:
        return getScreenHeight(r100);
    L9:
        if ((r100 instanceof Activity) == false) goto L19;
        Window r103 = ((Activity) r100).getWindow();
        if (r103 == null) goto L23;
        View r104 = INVOKEVIRTUAL_com_android_ttcjpaysdk_base_framework_KeyboardStatePopupWindow_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r103);
        if (r104 == null) goto L23;
        View r105 = r104.findViewById(R.id.content);
        if (r105 == null) goto L23;
        return r105.getHeight();
    L23:
        return getScreenHeight(r100);
    L19:
        return getScreenHeight(r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void e(String r100, Throwable r101) {
        ICJTag.DefaultImpls.e(this, r100, r101);
    }

    public static final /* synthetic */ int access$computeMaxHeight(KeyboardStatePopupWindow r100, Context r101, Window r102) {
        return r100.computeMaxHeight(r101, r102);
    }

    public KeyboardStatePopupWindow(Context r100, View r101, Window r102, Boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "anchorView");
        this.context = r100;
        this.anchorView = r101;
        this.windowCurrent = r102;
        this.bottomAnimatorOpt = r103;
        View r104 = new View(this.context);
        setContentView(r104);
        setWidth(0);
        setHeight(-1);
        setBackgroundDrawable(new ColorDrawable(0));
        setSoftInputMode(16);
        setInputMethodMode(1);
        int r105 = Build.VERSION.SDK_INT;
        if (r105 < 23) goto L5;
        setWindowLayoutType(1003);
    L5:
        r104.getViewTreeObserver().addOnGlobalLayoutListener(this);
        if (r101.getWindowToken() == null) goto L8;
        INVOKEVIRTUAL_com_android_ttcjpaysdk_base_framework_KeyboardStatePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(this, this.anchorView, 0, 0, 0);
    L9:
        r101.post(new AnonymousClass2(this));
        if (Intrinsics.areEqual(this.bottomAnimatorOpt, Boolean.TRUE) == true) goto L12;
    L14:
        this.range = 6;
        this.isMiui = isMiui();
        final Looper r106 = Looper.getMainLooper();
        this.mHandler = new KeyboardStatePopupWindow$mHandler$1(this, r106);
        this.rect = new Rect();
        this.OPEN_KEYBOARD = 1000;
        return;
    L12:
        if (r105 < 30) goto L14;
        addWindowCallback();
        goto L14
    L8:
        r101.addOnAttachStateChangeListener(new AnonymousClass1(this));
        goto L9
    }

    public static void INVOKEVIRTUAL_com_android_ttcjpaysdk_base_framework_KeyboardStatePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(KeyboardStatePopupWindow r100, View r101, int r102, int r110, int r111) {
        if (PopupWindowLancet.hasSubWindowToken(r101) == false) goto L6;
        return;
    L6:
        if ((r100 instanceof PopupWindow) == true) goto L8;
    L11:
        OverlaySource r103 = PopupWindowLancet.resolveSource(r101);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r100, r101, r103, r102, r110, r111) == false) goto L14;
        return;
    L14:
        r100.showAtLocation(r101, r102, r110, r111);
        PopupWindowLancet.trackAfterShow(r100, r103, r101);
        return;
    L8:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r100) == false) goto L11;
        r100.showAtLocation(r101, r102, r110, r111);
    }

    public /* synthetic */ KeyboardStatePopupWindow(Context r100, View r101, Window r102, Boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 8) == 0) goto L5;
        r103 = null;
    L5:
        this(r100, r101, r102, r103);
    }
}
