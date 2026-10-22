package com.android.ttcjpaysdk.base.ui.component.keyboard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.base.imageloader.ImageLoader;
import com.android.ttcjpaysdk.base.ktextension.CJPayColorHelper;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.settings.bean.InsuranceConfiguration;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.android.ttcjpaysdk.base.theme.CJPayThemeManager;
import com.android.ttcjpaysdk.base.theme.CJPayThemeUtils;
import com.android.ttcjpaysdk.base.ui.Utils.CJPayFontUtils;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.base.utils.CJPayFakeBoldUtils;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.xelement.keyboard.Theme;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import ie4.a;
import ie4.d;
import ie4.e;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b(\u0018\u0000 \u0095\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0006\u0095\u0001\u0096\u0001\u0097\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001B$\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0007\u0010\u0093\u0001\u001a\u00020\u0013¢\u0006\u0006\b\u0091\u0001\u0010\u0094\u0001J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J \u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0003J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\bH\u0002J\"\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\"\u0010\"\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010!\u001a\u0004\u0018\u00010 H\u0002J\u0018\u0010#\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J \u0010$\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010%\u001a\u00020\bH\u0002J\u0018\u0010)\u001a\u00020\u00132\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u0013H\u0002J\u0012\u0010*\u001a\u00020\u00172\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u0010,\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u0017J\u000e\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u0017J\u0010\u00100\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u00010\fJ\u0006\u00101\u001a\u00020\bJ\u0006\u00102\u001a\u00020\bJ\u0006\u00103\u001a\u00020\bJ\u0006\u00104\u001a\u00020\bJ\u0010\u00106\u001a\u00020\b2\b\u00105\u001a\u0004\u0018\u00010\fJ\u0018\u00109\u001a\u00020\b2\u0006\u00107\u001a\u00020\u00172\b\u00108\u001a\u0004\u0018\u00010\fJ\u0010\u0010:\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010<\u001a\u00020\b2\u0006\u0010;\u001a\u00020\u0013H\u0016J\u0010\u0010=\u001a\u00020\b2\u0006\u0010;\u001a\u00020\u0013H\u0016J\u0018\u0010@\u001a\u00020\b2\u0006\u0010;\u001a\u00020\u00132\u0006\u0010?\u001a\u00020>H\u0016J\u0010\u0010C\u001a\u00020\b2\u0006\u0010B\u001a\u00020AH\u0016J\b\u0010D\u001a\u00020\bH\u0016J\b\u0010E\u001a\u00020\bH\u0016J\b\u0010F\u001a\u00020\bH\u0016J\b\u0010G\u001a\u00020\bH\u0016J\u0010\u0010J\u001a\u00020\b2\b\u0010I\u001a\u0004\u0018\u00010HJ\u0010\u0010M\u001a\u00020\b2\b\u0010L\u001a\u0004\u0018\u00010KJ\u0010\u0010O\u001a\u00020\b2\b\u0010I\u001a\u0004\u0018\u00010NJ.\u0010V\u001a\u00020U2\u0006\u0010P\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020\u00132\u0006\u0010R\u001a\u00020\u00132\u0006\u0010S\u001a\u00020\u00132\u0006\u0010T\u001a\u00020\u0013J \u0010\\\u001a\u00020[2\u0006\u0010W\u001a\u00020\u00132\u0006\u0010X\u001a\u00020\u00132\b\u0010Z\u001a\u0004\u0018\u00010YJ\u0018\u0010`\u001a\u00020\b2\u0006\u0010^\u001a\u00020]2\u0006\u0010_\u001a\u00020\u0013H\u0014J\u0012\u0010a\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010c\u001a\u00020\b2\u0006\u0010I\u001a\u00020bH\u0016J\u0012\u0010e\u001a\u00020\b2\b\u0010d\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010h\u001a\u00020\b2\u0006\u0010g\u001a\u00020fH\u0016R\u0018\u0010j\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010kR\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010mR\u0016\u0010n\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010q\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010s\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010u\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010w\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010mR\u0016\u00108\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010xR\u0016\u0010y\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010mR\u0016\u0010z\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010mR\u0016\u0010{\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010vR\u0018\u0010|\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010xR\u0016\u0010}\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010mR\u0016\u0010~\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010mR\u0019\u0010\u007f\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R \u0010\u0085\u0001\u001a\u00020[8BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0016\u0010\u0086\u0001\u001a\u00020i8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010kR \u0010\u008a\u0001\u001a\u00020i8BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0087\u0001\u0010\u0082\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0019\u0010I\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bI\u0010\u008b\u0001R\u001b\u0010\u008c\u0001\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0014\u0010\u0090\u0001\u001a\u00020U8F¢\u0006\b\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001¨\u0006\u0098\u0001"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/keyboard/CJAmountKeyboardView;", "Landroid/inputmethodservice/KeyboardView;", "Landroid/inputmethodservice/KeyboardView$OnKeyboardActionListener;", "Lie4/a;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "initAll", "initTheme", "init", "", "url", "setInsuranceImage", "checkTitleLayoutVisible", "Landroid/graphics/Canvas;", "canvas", "drawDividerLine", "", "calculateFirstRowTop", "Landroid/inputmethodservice/Keyboard$Key;", "key", "", "enablePressed", "drawDoneKeyBackground", "drawFoldView", "recalculateKeyboardHeight", "Landroid/graphics/Bitmap;", SimplayerImageStrategy.RESULT_BITMAP, "drawInsuranceView", "drawKeyBackground", "Landroid/graphics/drawable/Drawable;", "iconDrawable", "drawKeyIcon", "drawKeyLabel", "drawKeyWriteLabel", "initTextPaint", "", "alpha", "baseColor", "getColorWithAlpha", "hideCustomKeyboardAnimated", "isNight", "setNightMode", "enableDone", "setEnableDone", "iconUrl", "showInsurance", "hideInsurance", "setUseStdModeAndLayoutMode", "showFoldBtn", "hideFoldBtn", "btnText", "showDoneBtn", "visible", "doneKeyWriteLabelStr", "setDoneKeyVisible", "onDraw", "primaryCode", "onPress", "onRelease", "", "keyCodes", "onKey", "", "charSequence", "onText", "swipeLeft", "swipeRight", "swipeDown", "swipeUp", "Lcom/android/ttcjpaysdk/base/ui/component/keyboard/CJAmountKeyboardView$OnKeyListener;", "listener", "setOnKeyListener", "Lcom/android/ttcjpaysdk/base/ui/component/keyboard/CJNumKeyboardView$OnKeyboardShowListener;", SendEventContainerMethodParamModel.EventKinds.onShow, "setOnShowListener", "Lcom/android/ttcjpaysdk/base/ui/component/keyboard/CJAmountKeyboardView$OnDoneListener;", "setOnDoneListener", "radius", "startBgColor", "endBgColor", "pressedStartBgColor", "pressedEndBgColor", "Landroid/graphics/drawable/StateListDrawable;", "getDrawable", "start", "end", "", "radii", "Landroid/graphics/drawable/GradientDrawable;", "createDrawable", "Landroid/view/View;", "changedView", RemoteMessageConst.Notification.VISIBILITY, "onVisibilityChanged", "setKeyboardWaterMark", "Lie4/d;", "setListener", "text", "setConfirmText", "Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/xelement/keyboard/Theme;", "theme", "setTheme", "Landroid/graphics/Paint;", "textPaint", "Landroid/graphics/Paint;", "doneKeyPaint", "Z", "mDisableAlpha", FaceService.girlLabel, "Lcom/android/ttcjpaysdk/base/settings/bean/InsuranceConfiguration;", "insuranceConfiguration", "Lcom/android/ttcjpaysdk/base/settings/bean/InsuranceConfiguration;", "insuranceIcon", "Landroid/graphics/Bitmap;", "themeMode", "I", "doneKeyVisible", "Ljava/lang/String;", "useStdMode", "isLightMode", "layoutMode", "insIconUrl", "needShowFold", "needShowInsurance", "onKeyboardShowListener", "Lcom/android/ttcjpaysdk/base/ui/component/keyboard/CJNumKeyboardView$OnKeyboardShowListener;", "keyBackground$delegate", "Lkotlin/Lazy;", "getKeyBackground", "()Landroid/graphics/drawable/GradientDrawable;", "keyBackground", "dividePaint", "foldBgPaint$delegate", "getFoldBgPaint", "()Landroid/graphics/Paint;", "foldBgPaint", "Lcom/android/ttcjpaysdk/base/ui/component/keyboard/CJAmountKeyboardView$OnKeyListener;", "onDoneListener", "Lcom/android/ttcjpaysdk/base/ui/component/keyboard/CJAmountKeyboardView$OnDoneListener;", "getDoneKeyBackground", "()Landroid/graphics/drawable/StateListDrawable;", "doneKeyBackground", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "OnDoneListener", "OnKeyListener", "base-context_release"}, k = 1, mv = {1, 6, 0})
public final class CJAmountKeyboardView extends KeyboardView implements KeyboardView.OnKeyboardActionListener, a {
    public static final Companion Companion = null;
    private static final int KEY_EMPTY = -9999;
    private static final int KEY_FOLD = -601;
    private static final int KEY_INSURANCE_TIPS = -600;
    private static final String TAG = "AmountKeyboardView";
    public static final int THEME_MODE_DARK = 1;
    public static final int THEME_MODE_LIGHT = 0;
    private final Paint dividePaint;
    private Paint doneKeyPaint;
    private boolean doneKeyVisible;
    private String doneKeyWriteLabelStr;
    private boolean enablePressed;
    private final Lazy foldBgPaint$delegate;
    private String insIconUrl;
    private InsuranceConfiguration insuranceConfiguration;
    private Bitmap insuranceIcon;
    private boolean isLightMode;
    private final Lazy keyBackground$delegate;
    private int layoutMode;
    private OnKeyListener listener;
    private float mDisableAlpha;
    private boolean needShowFold;
    private boolean needShowInsurance;
    private OnDoneListener onDoneListener;
    private CJNumKeyboardView.OnKeyboardShowListener onKeyboardShowListener;
    private Paint textPaint;
    private int themeMode;
    private boolean useStdMode;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/keyboard/CJAmountKeyboardView$Companion;", "", "()V", "KEY_EMPTY", "", "KEY_FOLD", "KEY_INSURANCE_TIPS", "TAG", "", "THEME_MODE_DARK", "THEME_MODE_LIGHT", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J3\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/keyboard/CJAmountKeyboardView$OnDoneListener;", "", "onDone", "", "onDoneKeyStyleUpdate", "bgDrawable", "Landroid/graphics/drawable/StateListDrawable;", "str", "", "strColor", "", "enabled", "", "(Landroid/graphics/drawable/StateListDrawable;Ljava/lang/String;ILjava/lang/Boolean;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnDoneListener {
        void onDone();

        void onDoneKeyStyleUpdate(StateListDrawable r100, String r101, int r102, Boolean r103);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/keyboard/CJAmountKeyboardView$OnKeyListener;", "", "onDelete", "", "onInput", "text", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnKeyListener {
        void onDelete();

        void onInput(String r100);
    }

    static {
        Companion = new Companion(null);
    }

    public final void hideFoldBtn() {
        this.needShowFold = false;
        checkTitleLayoutVisible();
        postInvalidate();
    }

    public final void hideInsurance() {
        this.needShowInsurance = false;
        checkTitleLayoutVisible();
    }

    @Override // ie4.a
    public void hideKeyBoardX() {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onRelease(int r100) {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "charSequence");
    }

    public final void setUseStdModeAndLayoutMode() {
        this.useStdMode = true;
        this.layoutMode = 1;
        setKeyboard(new Keyboard(getContext(), R.xml.cj_pay_amount_key_board_number_std));
        setEnableDone(true);
    }

    public final void showFoldBtn() {
        this.needShowFold = true;
        checkTitleLayoutVisible();
        List<Keyboard.Key> r100 = getKeyboard().getKeys();
        Keyboard.Key r101 = (Keyboard.Key) CollectionsKt.getOrNull(r100, 0);
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.y);
    L6:
        Iterator<Keyboard.Key> r103 = r100.iterator();
    L8:
        if (r103.hasNext() == false) goto L15;
        Keyboard.Key r104 = r103.next();
        int r105 = r104.y;
        if (r102 == null) goto L8;
        if (r105 != r102.intValue()) goto L8;
        r104.height = CJPayBasicUtils.dipToPX(getContext(), 38.0f);
        goto L8
    L15:
        recalculateKeyboardHeight();
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // ie4.a
    public void showKeyBoardX() {
    }

    @Override // android.inputmethodservice.KeyboardView, android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void swipeDown() {
    }

    @Override // android.inputmethodservice.KeyboardView, android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void swipeLeft() {
    }

    @Override // android.inputmethodservice.KeyboardView, android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void swipeRight() {
    }

    @Override // android.inputmethodservice.KeyboardView, android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void swipeUp() {
    }

    private final void checkTitleLayoutVisible() {
        if (this.needShowInsurance == false) goto L5;
    L12:
        Context r100 = getContext();
        if (this.layoutMode != 1) goto L15;
        int r101 = R.xml.cj_pay_amount_key_board_number_with_insurance_std;
    L16:
        setKeyboard(new Keyboard(r100, r101));
        return;
    L15:
        r101 = R.xml.cj_pay_amount_key_board_number_with_insurance;
        goto L16
    L5:
        if (this.needShowFold == true) goto L12;
        Context r102 = getContext();
        if (this.layoutMode != 1) goto L10;
        int r103 = R.xml.cj_pay_amount_key_board_number_std;
    L11:
        setKeyboard(new Keyboard(r102, r103));
        return;
    L10:
        r103 = R.xml.cj_pay_amount_key_board_number;
        goto L11
    }

    private final Paint getFoldBgPaint() {
        return (Paint) this.foldBgPaint$delegate.getValue();
    }

    private final GradientDrawable getKeyBackground() {
        return (GradientDrawable) this.keyBackground$delegate.getValue();
    }

    private final void initTextPaint() {
        Paint r100 = new Paint(1);
        this.textPaint = r100;
        Intrinsics.checkNotNull(r100);
        r100.setTextAlign(Paint.Align.CENTER);
        Paint r101 = new Paint(1);
        this.doneKeyPaint = r101;
        Intrinsics.checkNotNull(r101);
        r101.setTextAlign(Paint.Align.CENTER);
    }

    public final StateListDrawable getDoneKeyBackground() {
        if (this.layoutMode != 1) goto L5;
        int r100 = 0;
    L22:
    L10:
        e = move-exception;
        CJBasicCommonUtils.logCatch("CJCatch", "CJAmountKeyboardView#drawDoneKeyBackground", e);
    L13:
        if (TextUtils.isEmpty("") == true) goto L15;
    L17:
        int r101 = r100;
        StateListDrawable r102 = getDrawable(r101, CJPayColorHelper.safeParseColor$default("", 0, 2, null), CJPayColorHelper.safeParseColor$default("", 0, 2, null), CJPayColorHelper.safeParseColor$default("", 0, 2, null), CJPayColorHelper.safeParseColor$default("", 0, 2, null));
    L19:
        if (this.enablePressed == false) goto L24;
        int r103 = r100;
        return getDrawable(r103, CJPayColorHelper.safeParseColor$default(CJPayColorConstants.CJ_PAY_RED, 0, 2, null), CJPayColorHelper.safeParseColor$default(CJPayColorConstants.CJ_PAY_RED, 0, 2, null), CJPayColorHelper.safeParseColor$default(CJPayColorConstants.CJ_PAY_RED_F02B52, 0, 2, null), CJPayColorHelper.safeParseColor$default(CJPayColorConstants.CJ_PAY_RED_F02B52, 0, 2, null));
    L24:
        return r102;
    L15:
        if (TextUtils.isEmpty("") == false) goto L17;
        int r104 = r100;
        r102 = getDrawable(r104, getColorWithAlpha(this.mDisableAlpha, CJPayColorHelper.safeParseColor$default(CJPayColorConstants.CJ_PAY_RED, 0, 2, null)), getColorWithAlpha(this.mDisableAlpha, CJPayColorHelper.safeParseColor$default(CJPayColorConstants.CJ_PAY_RED, 0, 2, null)), getColorWithAlpha(this.mDisableAlpha, CJPayColorHelper.safeParseColor$default(CJPayColorConstants.CJ_PAY_RED, 0, 2, null)), getColorWithAlpha(this.mDisableAlpha, CJPayColorHelper.safeParseColor$default(CJPayColorConstants.CJ_PAY_RED, 0, 2, null)));
        goto L19
    L7:
        if (CastIntegerProtector.parseInt("") < 0) goto L13;
        r100 = CastIntegerProtector.parseInt("");     // Catch: Exception -> L10
        goto L13
    L5:
        r100 = 8;
        goto L22
    }

    private final int calculateFirstRowTop() {
        Iterator<Keyboard.Key> r100 = getKeyboard().getKeys().iterator();
        int r101 = Integer.MAX_VALUE;
    L4:
        if (r100.hasNext() == false) goto L8;
        int r102 = r100.next().y;
        if (r102 >= r101) goto L4;
        r101 = r102;
        goto L4
    L8:
        return r101;
    }

    private final void recalculateKeyboardHeight() {
        Iterator<Keyboard.Key> r100 = getKeyboard().getKeys().iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L8;
        Keyboard.Key r102 = r100.next();
        int r103 = r102.y;
        int r104 = r102.height + r103;
        if (r104 <= r101) goto L4;
        r101 = r104;
        goto L4
    L8:
        ViewGroup.LayoutParams r105 = getLayoutParams();
        r105.height = r101;
        setLayoutParams(r105);
        requestLayout();
    }

    private final void drawDividerLine(Canvas r100) {
        float r101 = calculateFirstRowTop();
        r100.drawLine(0.0f, r101, getWidth(), r101, this.dividePaint);
    }

    private final boolean hideCustomKeyboardAnimated(final Context r100) {
        if (getVisibility() != 8) goto L5;
        return false;
    L5:
        if (getAnimation() != null) goto L11;
        post(new AnonymousClass1(r100, this));
        return true;
    L11:
        return false;
    }

    private final void initTheme(Context r100) {
        this.themeMode = !CJPayThemeManager.getInstance().isThemeLight(r100) ? 1 : 0;
        this.isLightMode = !CJPayThemeManager.getInstance().isThemeDark(r100);
    }

    private final void setInsuranceImage(String r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        Boolean r102 = Boolean.valueOf(!StringsKt.isBlank(r100));
    L6:
        boolean r103 = false;
        if (r102 == null) goto L9;
        boolean r104 = r102.booleanValue();
    L10:
        if (r104 == false) goto L12;
        ImageLoader.Companion.getInstance().loadImage(r100, new C88921(this));
        return;
    L12:
        InsuranceConfiguration r105 = CJPaySettingsManager.getInstance().getInsuranceConfig();
        this.insuranceConfiguration = r105;
        if (r105 == null) goto L15;
        Boolean r106 = Boolean.valueOf(r105.show);
    L16:
        if (r106 == null) goto L18;
        r103 = r106.booleanValue();
    L18:
        if (r103 == false) goto L47;
        int r107 = this.themeMode;
        if (r107 != 0) goto L29;
        if (r105 == null) goto L23;
        String r108 = r105.unified_keyboard_icon;
    L25:
        if (TextUtils.isEmpty(r108) == true) goto L44;
        if (r105 == null) goto L44;
        String r109 = r105.unified_keyboard_icon;
    L28:
        r101 = r109;
    L44:
        ImageLoader.Companion.getInstance().loadImage(r101, new AnonymousClass2(this));
        return;
    L23:
        r108 = null;
        goto L25
    L29:
        if (r107 != 1) goto L37;
        if (r105 == null) goto L32;
        String r110 = r105.unified_keyboard_icon;
    L34:
        if (TextUtils.isEmpty(r110) == true) goto L44;
        if (r105 == null) goto L44;
        r109 = r105.unified_keyboard_icon;
        goto L28
    L32:
        r110 = null;
        goto L34
    L37:
        if (r105 == null) goto L39;
        String r111 = r105.unified_keyboard_icon;
    L41:
        if (TextUtils.isEmpty(r111) == true) goto L44;
        if (r105 == null) goto L44;
        r109 = r105.unified_keyboard_icon;
        goto L28
    L39:
        r111 = null;
        goto L41
    L47:
        return;
    L15:
        r106 = null;
        goto L16
    L9:
        r104 = false;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.inputmethodservice.KeyboardView, android.view.View
    public void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        if (this.layoutMode == 1) goto L5;
    L9:
        Iterator<Keyboard.Key> r100 = getKeyboard().getKeys().iterator();
    L11:
        if (r100.hasNext() == false) goto L53;
        Keyboard.Key r101 = r100.next();
        int r102 = 0;
        int r103 = r101.codes[0];
        if (r103 == (-4)) goto L20;
        if (r103 == (-5)) goto L20;
        if (r103 == (-9999)) goto L20;
        if (r103 == (-600)) goto L20;
        if (r103 == (-601)) goto L20;
        drawKeyBackground(r101, r110);
        drawKeyLabel(r101, r110);
    L20:
        if (r101.codes[0] != (-4)) goto L23;
        drawDoneKeyBackground(r101, r110, this.enablePressed);
        drawKeyWriteLabel(r101, r110, this.enablePressed);
    L23:
        if (r101.codes[0] != (-5)) goto L34;
        drawKeyBackground(r101, r110);
        if (getContext() == null) goto L34;
        Drawable r104 = CJPayThemeUtils.getDrawable(getContext(), R.attr.cj_pay_amount_keyboard_delete);
        if (r104 == null) goto L29;
    L32:
        drawKeyIcon(r101, r110, r104);
        goto L34
    L29:
        if (this.isLightMode == false) goto L31;
        r104 = getContext().getDrawable(R.drawable.cj_pay_icon_pwd_delete_noise_reduction);
        goto L32
    L31:
        r104 = getContext().getDrawable(R.drawable.cj_pay_icon_pwd_delete_noise_reduction_dark);
    L34:
        if (r101.codes[0] != (-600)) goto L39;
        GradientDrawable r105 = getKeyBackground();
        int r106 = r101.x;
        int r107 = r101.y;
        r105.setBounds(r106, r107, r101.width + r106, r101.height + r107);
        r105.draw(r110);
        if (this.needShowInsurance == false) goto L39;
        drawInsuranceView(r110, this.insuranceIcon, r101);
    L39:
        if (r101.codes[0] != (-9999)) goto L42;
        GradientDrawable r108 = getKeyBackground();
        int r109 = r101.x;
        int r111 = r101.y;
        r108.setBounds(r109, r111, r101.width + r109, r101.height + r111);
        r108.draw(r110);
    L42:
        if (r101.codes[0] != (-601)) goto L11;
        if (this.needShowFold == false) goto L11;
        r101.width = CJPayBasicUtils.dipToPX(getContext(), 48.0f);
        if (r101.pressed == true) goto L48;
    L51:
        getFoldBgPaint().setColor(r102);
        int r112 = r101.x;
        int r113 = r101.y;
        r110.drawRect(r112, r113, r112 + r101.width, r113 + r101.height, getFoldBgPaint());
        drawFoldView(r110, r101);
        goto L11
    L48:
        if (this.isLightMode == false) goto L50;
        r102 = getContext().getResources().getColor(R.color.cj_pay_color_bg_6p_light);
        goto L51
    L50:
        r102 = getContext().getResources().getColor(R.color.cj_pay_color_bg_6p_dark);
        goto L51
    L53:
        if (this.layoutMode == 1) goto L55;
        return;
    L55:
        if (this.needShowInsurance == true) goto L66;
        drawDividerLine(r110);
        return;
    L66:
        return;
    L5:
        if (this.isLightMode == false) goto L7;
        Drawable r114 = getContext().getDrawable(R.color.cj_pay_color_bg_keyboard);
    L8:
        setBackground(r114);
        goto L9
    L7:
        r114 = getContext().getDrawable(R.color.cj_pay_color_bg_keyboard_dark);
        goto L8
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onPress(int r100) {
        if (this.listener != null) goto L5;
        return;
    L5:
        if (r100 != (-9999)) goto L7;
        return;
    L7:
        if (r100 != (-601)) goto L9;
        return;
    L9:
        if (r100 != (-600)) goto L11;
        return;
    L11:
        if (r100 != (-5)) goto L13;
        return;
    L13:
        if (r100 != (-4)) goto L15;
        return;
    L15:
        if (this.useStdMode == true) goto L17;
        return;
    L17:
        if (Build.VERSION.SDK_INT < 23) goto L27;
        performHapticFeedback(3);
        return;
    }

    @Override // ie4.a
    public void setConfirmText(String r100) {
        setDoneKeyVisible(true, r100);
    }

    public final void setEnableDone(boolean r100) {
        this.enablePressed = r100;
        invalidate();
        OnDoneListener r101 = this.onDoneListener;
        if (r101 == null) goto L10;
        Intrinsics.checkNotNull(r101);
        StateListDrawable r102 = getDoneKeyBackground();
        String r103 = this.doneKeyWriteLabelStr;
        if (this.enablePressed == false) goto L7;
        int r104 = ContextCompat.getColor(getContext(), R.color.cj_pay_color_white);
    L8:
        r101.onDoneKeyStyleUpdate(r102, r103, r104, Boolean.valueOf(this.enablePressed));
        return;
    L7:
        r104 = getColorWithAlpha(this.mDisableAlpha, ContextCompat.getColor(getContext(), R.color.cj_pay_color_white));
        goto L8
    }

    @Override // ie4.a
    public void setKeyboardWaterMark(String r100) {
        if (r100 == null) goto L4;
        Boolean r101 = Boolean.valueOf(!StringsKt.isBlank(r100));
    L5:
        if (r101 == null) goto L7;
        boolean r102 = r101.booleanValue();
    L8:
        if (r102 == false) goto L10;
        showInsurance(r100);
        return;
    L10:
        hideInsurance();
        return;
    L7:
        r102 = false;
        goto L8
    L4:
        r101 = null;
        goto L5
    }

    @Override // ie4.a
    public void setListener(final d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        setOnKeyListener(new C88931(r100));
        setOnDoneListener(new C88942(r100));
    }

    public final void setNightMode(boolean r100) {
        this.isLightMode = !r100;
        postInvalidate();
    }

    public final void setOnDoneListener(OnDoneListener r100) {
        this.onDoneListener = r100;
    }

    public final void setOnKeyListener(OnKeyListener r100) {
        this.listener = r100;
    }

    public final void setOnShowListener(CJNumKeyboardView.OnKeyboardShowListener r100) {
        this.onKeyboardShowListener = r100;
    }

    @Override // ie4.a
    public void setTheme(Theme r100) {
        Intrinsics.checkNotNullParameter(r100, "theme");
        if (r100 != Theme.NIGHT) goto L5;
        setNightMode(true);
        return;
    L5:
        setNightMode(false);
    }

    @Override // ie4.a
    public void setTopRightBtnConfig(e r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
    }

    public final void showDoneBtn(String r100) {
        setDoneKeyVisible(true, r100);
    }

    public final void showInsurance(String r100) {
        InsuranceConfiguration r101 = CJPaySettingsManager.getInstance().getInsuranceConfig();
        this.insuranceConfiguration = r101;
        this.insIconUrl = r100;
        Boolean r102 = null;
        if (r101 == null) goto L5;
        Boolean r103 = Boolean.valueOf(r101.show);
    L6:
        boolean r104 = false;
        if (r103 == null) goto L9;
        boolean r105 = r103.booleanValue();
    L11:
        if (r105 == false) goto L17;
        if (r101 == null) goto L14;
        String r106 = r101.unified_keyboard_icon;
    L16:
        if (TextUtils.isEmpty(r106) == true) goto L17;
    L22:
        Context r107 = getContext();
        if (this.layoutMode != 1) goto L25;
        int r108 = R.xml.cj_pay_amount_key_board_number_with_insurance_std;
    L26:
        setKeyboard(new Keyboard(r107, r108));
        setInsuranceImage(r100);
        this.needShowInsurance = true;
    L27:
        checkTitleLayoutVisible();
        return;
    L25:
        r108 = R.xml.cj_pay_amount_key_board_number_with_insurance;
        goto L26
    L14:
        r106 = null;
    L17:
        if (r100 == null) goto L19;
        r102 = Boolean.valueOf(!StringsKt.isBlank(r100));
    L19:
        if (r102 == null) goto L21;
        r104 = r102.booleanValue();
    L21:
        if (r104 == false) goto L27;
    L9:
        r105 = false;
        goto L11
    L5:
        r103 = null;
        goto L6
    }

    public CJAmountKeyboardView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.mDisableAlpha = 0.34f;
        this.doneKeyVisible = true;
        this.doneKeyWriteLabelStr = getContext().getString(R.string.cj_pay_amount_key_board_view);
        this.isLightMode = true;
        this.layoutMode = 2;
        this.insIconUrl = "";
        this.keyBackground$delegate = LazyKt.lazy(CJAmountKeyboardView$keyBackground$2.INSTANCE);
        Paint r102 = new Paint();
        r102.setColor(getContext().getResources().getColor(R.color.cj_pay_color_bg_6p_light));
        r102.setStrokeWidth(2.0f);
        this.dividePaint = r102;
        this.foldBgPaint$delegate = LazyKt.lazy(CJAmountKeyboardView$foldBgPaint$2.INSTANCE);
        initAll(r100, r101);
    }

    public static final /* synthetic */ void access$setInsuranceIcon$p(CJAmountKeyboardView r100, Bitmap r101) {
        r100.insuranceIcon = r101;
    }

    private final void drawFoldView(Canvas r100, Keyboard.Key r101) {
        if (getContext() != null) goto L5;
        return;
    L5:
        if (this.needShowFold == false) goto L13;
        int r102 = CJPayBasicUtils.dipToPX(getContext(), 16.0f);
        int r103 = CJPayBasicUtils.dipToPX(getContext(), 16.0f);
        int r104 = (r101.x + (r101.width / 2)) - (r102 / 2);
        int r105 = r101.y + CJPayBasicUtils.dipToPX(getContext(), 9.0f);
        if (this.isLightMode == false) goto L9;
        Drawable r106 = getResources().getDrawable(R.drawable.cj_pay_icon_down_arrow);
    L10:
        r106.setBounds(r104, r105, r102 + r104, r103 + r105);
        r106.draw(r100);
        return;
    L9:
        r106 = getResources().getDrawable(R.drawable.cj_pay_icon_down_arrow_dark);
        goto L10
    }

    private final void drawKeyBackground(Keyboard.Key r110, Canvas r111) {
        if (getContext() == null) goto L69;
        int r100 = this.layoutMode;
        if (r100 != 1) goto L7;
        int r101 = 0;
    L8:
        int r102 = R.color.cj_pay_amount_keyboard_item_pressed_bg_color_dark;
        if (r100 != 1) goto L27;
        Context r103 = getContext();
        boolean r104 = this.isLightMode;
        int r105 = R.color.cj_pay_color_bg_keyboard_key_dark;
        if (r104 == true) goto L13;
        int r106 = R.color.cj_pay_color_bg_keyboard_key_dark;
    L14:
        int r107 = CJPayThemeUtils.getColorWithDefaultColor(r103, R.attr.cj_std_amount_keyboard_item_bg_color, r106);
        Context r108 = getContext();
        if (this.isLightMode == false) goto L18;
        r105 = R.color.cj_pay_color_bg_keyboard_key;
    L18:
        int r109 = CJPayThemeUtils.getColorWithDefaultColor(r108, R.attr.cj_std_amount_keyboard_item_bg_color, r105);
        Context r112 = getContext();
        if (this.isLightMode == true) goto L21;
        int r113 = R.color.cj_pay_amount_keyboard_item_pressed_bg_color_dark;
    L22:
        int r114 = CJPayThemeUtils.getColorWithDefaultColor(r112, R.attr.cj_pay_amount_keyboard_item_pressed_bg_color, r113);
        Context r115 = getContext();
        if (this.isLightMode == false) goto L26;
        r102 = R.color.cj_pay_amount_keyboard_item_pressed_bg_color_light;
    L26:
        int r116 = r101;
        StateListDrawable r117 = getDrawable(r116, r107, r109, r114, CJPayThemeUtils.getColorWithDefaultColor(r115, R.attr.cj_pay_amount_keyboard_item_pressed_bg_color, r102));
    L44:
        Context r118 = getContext();
        boolean r119 = this.isLightMode;
        int r120 = R.color.cj_pay_amount_keyboard_item_normal_shadow_bg_color_dark;
        if (r119 == true) goto L47;
        int r121 = R.color.cj_pay_amount_keyboard_item_normal_shadow_bg_color_dark;
    L48:
        int r122 = CJPayThemeUtils.getColorWithDefaultColor(r118, R.attr.cj_pay_amount_keyboard_item_normal_shadow_bg_color, r121);
        Context r123 = getContext();
        if (this.isLightMode == false) goto L52;
        r120 = R.color.cj_pay_amount_keyboard_item_normal_shadow_bg_color_light;
    L52:
        int r124 = CJPayThemeUtils.getColorWithDefaultColor(r123, R.attr.cj_pay_amount_keyboard_item_normal_shadow_bg_color, r120);
        Context r125 = getContext();
        boolean r126 = this.isLightMode;
        int r127 = R.color.cj_pay_amount_keyboard_item_pressed_shadow_bg_color_dark;
        if (r126 == true) goto L55;
        int r128 = R.color.cj_pay_amount_keyboard_item_pressed_shadow_bg_color_dark;
    L56:
        int r129 = CJPayThemeUtils.getColorWithDefaultColor(r125, R.attr.cj_pay_amount_keyboard_item_pressed_shadow_bg_color, r128);
        Context r130 = getContext();
        if (this.isLightMode == false) goto L60;
        r127 = R.color.cj_pay_amount_keyboard_item_pressed_shadow_bg_color_light;
    L60:
        int r131 = r101;
        StateListDrawable r132 = getDrawable(r131, r122, r124, r129, CJPayThemeUtils.getColorWithDefaultColor(r130, R.attr.cj_pay_amount_keyboard_item_pressed_shadow_bg_color, r127));
        int[] r133 = r110.getCurrentDrawableState();
        if (r110.codes[0] == 0) goto L64;
        r117.setState(r133);
    L64:
        if (this.layoutMode != 1) goto L66;
        float r134 = 0.5f;
    L67:
        int r135 = r110.x;
        r117.setBounds(r135, r110.y, (r110.width + r135) - CJPayBasicUtils.dipToPX(getContext(), r134), (r110.y + r110.height) - CJPayBasicUtils.dipToPX(getContext(), r134));
        int r136 = r110.x;
        int r137 = r110.y;
        r132.setBounds(r136, r137, r110.width + r136, r110.height + r137);
        r132.draw(r111);
        r117.draw(r111);
        return;
    L66:
        r134 = 1.0f;
        goto L67
    L55:
        r128 = R.color.cj_pay_amount_keyboard_item_pressed_shadow_bg_color_light;
        goto L56
    L47:
        r121 = R.color.cj_pay_amount_keyboard_item_normal_shadow_bg_color_light;
        goto L48
    L21:
        r113 = R.color.cj_pay_amount_keyboard_item_pressed_bg_color_light;
        goto L22
    L13:
        r106 = R.color.cj_pay_color_bg_keyboard_key;
        goto L14
    L27:
        Context r138 = getContext();
        boolean r139 = this.isLightMode;
        int r140 = R.color.cj_pay_amount_keyboard_item_normal_bg_color_dark;
        if (r139 == true) goto L30;
        int r141 = R.color.cj_pay_amount_keyboard_item_normal_bg_color_dark;
    L31:
        int r142 = CJPayThemeUtils.getColorWithDefaultColor(r138, R.attr.cj_pay_amount_keyboard_item_normal_bg_color, r141);
        Context r143 = getContext();
        if (this.isLightMode == false) goto L35;
        r140 = R.color.cj_pay_amount_keyboard_item_normal_bg_color_light;
    L35:
        int r144 = CJPayThemeUtils.getColorWithDefaultColor(r143, R.attr.cj_pay_amount_keyboard_item_normal_bg_color, r140);
        Context r145 = getContext();
        if (this.isLightMode == true) goto L38;
        int r146 = R.color.cj_pay_amount_keyboard_item_pressed_bg_color_dark;
    L39:
        int r147 = CJPayThemeUtils.getColorWithDefaultColor(r145, R.attr.cj_pay_amount_keyboard_item_pressed_bg_color, r146);
        Context r148 = getContext();
        if (this.isLightMode == false) goto L43;
        r102 = R.color.cj_pay_amount_keyboard_item_pressed_bg_color_light;
    L43:
        int r149 = r101;
        r117 = getDrawable(r149, r142, r144, r147, CJPayThemeUtils.getColorWithDefaultColor(r148, R.attr.cj_pay_amount_keyboard_item_pressed_bg_color, r102));
        goto L44
    L38:
        r146 = R.color.cj_pay_amount_keyboard_item_pressed_bg_color_light;
        goto L39
    L30:
        r141 = R.color.cj_pay_amount_keyboard_item_normal_bg_color_light;
        goto L31
    L7:
        r101 = 4;
        goto L8
    }

    private final void drawKeyLabel(Keyboard.Key r100, Canvas r101) {
        if (r100.label == null) goto L10;
        Paint r102 = this.textPaint;
        Intrinsics.checkNotNull(r102);
        Context r103 = getContext();
        if (this.isLightMode == true) goto L7;
        int r104 = R.color.cj_pay_amount_keyboard_text_color_dark;
    L8:
        r102.setColor(CJPayThemeUtils.getColorWithDefaultColor(r103, R.attr.cj_pay_amount_keyboard_text_color, r104));
        Paint r105 = this.textPaint;
        Intrinsics.checkNotNull(r105);
        r105.setAntiAlias(true);
        Paint r106 = this.textPaint;
        Intrinsics.checkNotNull(r106);
        r106.setTextSize(getContext().getResources().getDimension(R.dimen.cj_pay_font_size_24));
        CJPayFontUtils.setDouYinMediumTypeface(getContext(), this.textPaint);
        int r107 = r100.x;
        int r108 = r100.y;
        Rect r109 = new Rect(r107, r108, r100.width + r107, r100.height + r108);
        Paint r110 = this.textPaint;
        Intrinsics.checkNotNull(r110);
        Paint.FontMetricsInt r111 = r110.getFontMetricsInt();
        int r112 = (((r109.bottom + r109.top) - r111.bottom) - r111.top) / 2;
        String r113 = r100.label.toString();
        float r114 = r109.centerX();
        float r115 = r112;
        Paint r116 = this.textPaint;
        Intrinsics.checkNotNull(r116);
        r101.drawText(r113, r114, r115, r116);
        return;
    L7:
        r104 = R.color.cj_pay_amount_keyboard_text_color_light;
        goto L8
    }

    private final int getColorWithAlpha(float r100, int r101) {
        return (Math.min(255, Math.max(0, (int) (r100 * 255))) << 24) + (r101 & 16777215);
    }

    private final void init(Context r100, AttributeSet r101) {
        this.mDisableAlpha = 0.34f;
        if (this.layoutMode != 1) goto L5;
        int r102 = R.xml.cj_pay_amount_key_board_number_std;
    L6:
        setKeyboard(new Keyboard(r100, r102));
        setEnabled(true);
        setFocusable(true);
        setPreviewEnabled(false);
        setOnKeyboardActionListener(this);
        initTextPaint();
        return;
    L5:
        r102 = R.xml.cj_pay_amount_key_board_number_with_insurance;
        goto L6
    }

    private final void initAll(Context r100, AttributeSet r101) {
        initTheme(r100);
        init(r100, r101);
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onKey(int r100, int[] r101) {
        Intrinsics.checkNotNullParameter(r101, "keyCodes");
        OnKeyListener r102 = this.listener;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r100 != (-9999)) goto L7;
        return;
    L7:
        if (r100 == (-601)) goto L32;
        if (r100 != (-600)) goto L11;
        return;
    L11:
        if (r100 == (-5)) goto L26;
        if (r100 == (-4)) goto L16;
        Intrinsics.checkNotNull(r102);
        r102.onInput(String.valueOf((char) r100));
        return;
    L16:
        if (this.useStdMode == true) goto L18;
    L20:
        OnDoneListener r103 = this.onDoneListener;
        if (r103 != null) goto L23;
        return;
    L23:
        if (this.enablePressed == false) goto L42;
        Intrinsics.checkNotNull(r103);
        r103.onDone();
        return;
    L42:
        return;
    L18:
        if (Build.VERSION.SDK_INT < 23) goto L20;
        performHapticFeedback(3);
        goto L20
    L26:
        if (this.useStdMode == true) goto L28;
    L30:
        OnKeyListener r104 = this.listener;
        Intrinsics.checkNotNull(r104);
        r104.onDelete();
        return;
    L28:
        if (Build.VERSION.SDK_INT < 23) goto L30;
        performHapticFeedback(3);
        goto L30
    L32:
        if (this.useStdMode == true) goto L34;
        return;
    L34:
        if (this.needShowFold == false) goto L46;
        hideCustomKeyboardAnimated(getContext());
        return;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        if (Intrinsics.areEqual(r100, this) == false) goto L13;
        CJNumKeyboardView.OnKeyboardShowListener r102 = this.onKeyboardShowListener;
        if (r102 == null) goto L14;
        if (r102 != null) goto L8;
        return;
    L8:
        if (getVisibility() != 0) goto L10;
        boolean r103 = true;
    L11:
        r102.onShow(r103);
        return;
    L10:
        r103 = false;
        goto L11
    L14:
        return;
    }

    public final void setDoneKeyVisible(boolean r100, String r101) {
        this.doneKeyVisible = r100;
        if (r101 == null) goto L5;
        this.doneKeyWriteLabelStr = r101;
    L5:
        invalidate();
        OnDoneListener r102 = this.onDoneListener;
        if (r102 == null) goto L13;
        Intrinsics.checkNotNull(r102);
        StateListDrawable r103 = getDoneKeyBackground();
        if (this.enablePressed == false) goto L10;
        int r104 = ContextCompat.getColor(getContext(), R.color.cj_pay_color_white);
    L11:
        r102.onDoneKeyStyleUpdate(r103, r101, r104, Boolean.valueOf(this.enablePressed));
        return;
    L10:
        r104 = getColorWithAlpha(this.mDisableAlpha, ContextCompat.getColor(getContext(), R.color.cj_pay_color_white));
        goto L11
    }

    public CJAmountKeyboardView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        this.mDisableAlpha = 0.34f;
        this.doneKeyVisible = true;
        this.doneKeyWriteLabelStr = getContext().getString(R.string.cj_pay_amount_key_board_view);
        this.isLightMode = true;
        this.layoutMode = 2;
        this.insIconUrl = "";
        this.keyBackground$delegate = LazyKt.lazy(CJAmountKeyboardView$keyBackground$2.INSTANCE);
        Paint r103 = new Paint();
        r103.setColor(getContext().getResources().getColor(R.color.cj_pay_color_bg_6p_light));
        r103.setStrokeWidth(2.0f);
        this.dividePaint = r103;
        this.foldBgPaint$delegate = LazyKt.lazy(CJAmountKeyboardView$foldBgPaint$2.INSTANCE);
        initAll(r100, r101);
    }

    private final void drawDoneKeyBackground(Keyboard.Key r100, Canvas r101, boolean r102) {
        StateListDrawable r103 = getDoneKeyBackground();
        if (r102 == false) goto L7;
        int[] r104 = r100.getCurrentDrawableState();
        if (r100.codes[0] == 0) goto L8;
        r103.setState(r104);
    L8:
        int r105 = r100.x;
        int r106 = r100.y;
        r103.setBounds(r105, r106, r100.width + r105, r100.height + r106);
        if (this.doneKeyVisible == false) goto L12;
        r103.draw(r101);
        return;
    L12:
        return;
    L7:
        r100.pressed = false;
        goto L8
    }

    private final void drawInsuranceView(Canvas r100, Bitmap r101, Keyboard.Key r102) {
        if (getContext() == null) goto L10;
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.layoutMode != 1) goto L8;
        int r103 = CJPayBasicUtils.dipToPX(getContext(), 200.0f);
        int r104 = CJPayBasicUtils.dipToPX(getContext(), 20.0f);
        float r105 = r101.getWidth();
        float r106 = r101.getHeight();
        float r107 = Math.min(r103 / r105, r104 / r106);
        int r108 = (int) (r105 * r107);
        int r109 = (int) (r106 * r107);
        int r110 = r102.x + ((r102.width - r108) / 2);
        int r111 = r102.y + ((r102.height - r109) / 2);
        BitmapDrawable r112 = new BitmapDrawable(getContext().getResources(), r101);
        r112.setBounds(r110, r111, r108 + r110, r109 + r111);
        r112.draw(r100);
        return;
    L8:
        int r113 = CJPayBasicUtils.dipToPX(getContext(), 200);
        int r114 = CJPayBasicUtils.dipToPX(getContext(), 20);
        int r115 = (CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(getContext()) - r113) / 2;
        int r116 = CJPayBasicUtils.dipToPX(getContext(), 6.0f);
        BitmapDrawable r117 = new BitmapDrawable(getContext().getResources(), r101);
        r117.setBounds(r115, r116, r113 + r115, r114 + r116);
        r117.draw(r100);
        return;
    }

    private final void drawKeyIcon(Keyboard.Key r100, Canvas r101, Drawable r102) {
        if (r102 != null) goto L4;
        return;
    L4:
        int r103 = CJPayBasicUtils.dipToPX(getContext(), 24.0f);
        int r104 = CJPayBasicUtils.dipToPX(getContext(), 24.0f);
        int r105 = r100.x + ((r100.width - r103) / 2);
        int r106 = r100.y + ((r100.height - r104) / 2);
        Rect r107 = new Rect(r105, r106, r103 + r105, r104 + r106);
        if (r107.isEmpty() == true) goto L8;
        r102.setBounds(r107.left, r107.top, r107.right, r107.bottom);
        r102.draw(r101);
        return;
    }

    private final void drawKeyWriteLabel(Keyboard.Key r100, Canvas r101, boolean r102) {
        if (r100.label == null) goto L12;
        int r103 = ContextCompat.getColor(getContext(), R.color.cj_pay_color_white);
        Paint r104 = this.doneKeyPaint;
        Intrinsics.checkNotNull(r104);
        if (r102 == true) goto L8;
        r103 = getColorWithAlpha(this.mDisableAlpha, r103);
    L8:
        r104.setColor(r103);
        Paint r105 = this.doneKeyPaint;
        Intrinsics.checkNotNull(r105);
        r105.setAntiAlias(true);
        CJPayFakeBoldUtils.fakeBold(this.doneKeyPaint, 0.5f);
        Paint r106 = this.doneKeyPaint;
        Intrinsics.checkNotNull(r106);
        r106.setTextSize(getContext().getResources().getDimension(R.dimen.cj_pay_font_size_16));
        int r107 = r100.x;
        int r108 = r100.y;
        Rect r109 = new Rect(r107, r108, r100.width + r107, r100.height + r108);
        Paint r110 = this.doneKeyPaint;
        Intrinsics.checkNotNull(r110);
        Paint.FontMetricsInt r111 = r110.getFontMetricsInt();
        int r112 = (((r109.bottom + r109.top) - r111.bottom) - r111.top) / 2;
        if (this.doneKeyVisible == false) goto L13;
        Paint r113 = this.doneKeyPaint;
        Intrinsics.checkNotNull(r113);
        r101.drawText(this.doneKeyWriteLabelStr, r109.centerX(), r112, r113);
        return;
    L13:
        return;
    }

    public final GradientDrawable createDrawable(int r100, int r101, float[] r102) {
        GradientDrawable r103 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{r100, r101});
        r103.setCornerRadii(r102);
        return r103;
    }

    public final StateListDrawable getDrawable(int r100, int r101, int r110, int r111, int r112) {
        StateListDrawable r102 = new StateListDrawable();
        Context r103 = getContext();
        if (r100 >= 0) goto L6;
        r100 = 4;
    L6:
        float r104 = CJPayBasicUtils.dipToPX(r103, r100);
        float[] r105 = {r104, r104, r104, r104, r104, r104, r104, r104};
        GradientDrawable r106 = createDrawable(r101, r110, r105);
        GradientDrawable r107 = createDrawable(r111, r112, r105);
        r102.addState(new int[]{android.R.attr.state_pressed, android.R.attr.state_window_focused}, r107);
        r102.addState(new int[]{android.R.attr.state_pressed, -16842908}, r107);
        r102.addState(new int[]{android.R.attr.state_selected}, r107);
        r102.addState(new int[]{android.R.attr.state_focused}, r107);
        r102.addState(new int[0], r106);
        return r102;
    }
}
