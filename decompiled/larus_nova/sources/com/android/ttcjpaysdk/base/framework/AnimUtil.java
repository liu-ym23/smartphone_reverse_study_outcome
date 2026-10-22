package com.android.ttcjpaysdk.base.framework;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJResult;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPaySettingService;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayAnimationUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.base.utils.CJPayLargeScreenUtils;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.caijing.sdk.infra.base.task.b;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u000bklmnopqrstuB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011J\u0016\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0013J2\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\"H\u0002J2\u0010#\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010$\u001a\u00020\"H\u0002J\u0012\u0010%\u001a\u00020\u00132\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J(\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u0004H\u0002J0\u0010/\u001a\u00020\u00132\b\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u00020\"2\b\b\u0002\u00103\u001a\u00020\"2\b\b\u0002\u00104\u001a\u00020\bH\u0007J\u0006\u00105\u001a\u000206J\b\u00107\u001a\u0004\u0018\u00010\u0011J(\u00108\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u0004H\u0002J\u0006\u00109\u001a\u00020\"J\u0010\u0010:\u001a\u00020\"2\u0006\u0010;\u001a\u000206H\u0007J\u0012\u0010<\u001a\u00020\u00162\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\b\u0010=\u001a\u00020\"H\u0007J\u0010\u0010>\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\u0011H\u0007J\u0010\u0010?\u001a\u00020\u00162\u0006\u0010&\u001a\u000201H\u0007J\u0010\u0010@\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0007J\u001c\u0010A\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007J\u001c\u0010B\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007J\u001c\u0010C\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007JE\u0010D\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\"H\u0007¢\u0006\u0002\u0010HJ\u001c\u0010I\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007J\u001c\u0010J\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007J\u001c\u0010K\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007J\b\u0010L\u001a\u00020\u0016H\u0002J\u0010\u0010M\u001a\u00020\u00162\u0006\u0010&\u001a\u000201H\u0002J\u0010\u0010N\u001a\u00020\u00162\u0006\u0010;\u001a\u000206H\u0002J\u000e\u0010O\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011J\u001c\u0010P\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010Q\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0007J\u0010\u0010R\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0007J\u0018\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020+2\u0006\u0010V\u001a\u00020\u0013H\u0002JJ\u0010W\u001a\u00020\u00132\b\u00100\u001a\u0004\u0018\u0001012\b\u0010\u001d\u001a\u0004\u0018\u00010\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u00112\b\u0010X\u001a\u0004\u0018\u00010+2\b\u0010Y\u001a\u0004\u0018\u00010+2\u0006\u0010Z\u001a\u00020\u00132\u0006\u0010[\u001a\u00020\"H\u0002J\u0010\u0010\\\u001a\u00020\b2\u0006\u00104\u001a\u00020\bH\u0002J\u001c\u0010]\u001a\u00020\"2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011H\u0002J\u001c\u0010^\u001a\u00020\"2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010_\u001a\u00020\"2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011H\u0007J\u0010\u0010`\u001a\u00020\"2\u0006\u0010&\u001a\u00020'H\u0002J\u000e\u0010a\u001a\u0004\u0018\u00010+*\u00020\u0011H\u0002J\u000e\u0010b\u001a\u0004\u0018\u00010+*\u00020\u0011H\u0002J\u000e\u0010c\u001a\u0004\u0018\u00010+*\u00020\u0011H\u0002J&\u0010d\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u00110\u00102\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\"0fH\u0002J\u0018\u0010g\u001a\u00020\u0016*\u0004\u0018\u00010\u00112\b\b\u0002\u00102\u001a\u00020\"H\u0002J\u001f\u0010h\u001a\u0004\u0018\u0001Hi\"\u0004\b\u0000\u0010i*\b\u0012\u0004\u0012\u0002Hi0\u0010H\u0002¢\u0006\u0002\u0010jR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006v"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/AnimUtil;", "", "()V", "ANIM_DURATION", "", "CROSS_ACTIVITY_PUSH_ANIM_DELAY_MILLIS", "CROSS_FRAGMENT_PUSH_ANIM_DELAY_MILLIS", "NEVER_BACK", "", "TAG", "navHeightGetMethod", "getNavHeightGetMethod", "()Ljava/lang/String;", "navHeightGetMethod$delegate", "Lkotlin/Lazy;", "pageStack", "Ljava/util/Stack;", "Lcom/android/ttcjpaysdk/base/framework/AnimUtil$IAnimView;", "screenHeight", "", "screenWidth", "addPwdVerifyPage", "", "page", "Lcom/android/ttcjpaysdk/base/framework/AnimUtil$IOldAnimView;", "adjustPageWhenHideKeyboard", "adjustPageWhenPopKeyboard", "keyboardHeight", "beginPopAnimNew", "prePage", "curPage", "animCallback", "Lcom/android/ttcjpaysdk/base/framework/AnimUtil$IAnimationCallback;", "keepCurPageStill", "", "beginPushAnimNew", "useMaxNavMethod", "getFullScreenHeight", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getHeightAnimator", "Landroid/animation/ValueAnimator;", "targetView", "Landroid/view/View;", "startValue", "endValue", "duration", "getScreenHeight", "activity", "Landroid/app/Activity;", "withStatusBar", "withNavigationBar", "navMethodOverride", "getTopAnimGroup", "Lcom/android/ttcjpaysdk/base/framework/AnimUtil$AnimGroup;", "getTopAnimView", "getTransXAnimator", "hasLynxActivity", "hasPreviousPageOutsideGroup", "group", "initScreenSize", "isPageStackEmpty", "isTop", "onActivityDestroy", LiveCommonConstants.REASON_ON_DEDTROY, "onResume", "popPage", "popTopPageAndRemoveAll", "popTopPageAndRemoveGroup", "needEndPageAnim", "shouldDisallowShowLastPage", "shouldKeepPreviousPageStill", "(Lcom/android/ttcjpaysdk/base/framework/AnimUtil$IAnimView;Lcom/android/ttcjpaysdk/base/framework/AnimUtil$IAnimationCallback;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "pushPage", "pushPageWithoutDelayWithAnim", "pushPageWithoutDelayWithoutAnim", "removeAllPage", "removeContextPage", "removeGroupPage", "removePage", "removePreviousPageAfterNextPagePushIfNeeded", "removeSameContextPageExceptSelf", BasicTestActionHandler.TEST_ACTION_RESET, "resolveFullOffscreenTranslationX", "", "view", "animationWidth", "resolveHorizontalAnimationWidth", "preView", "curView", "fallbackScreenWidth", "movePreviousPage", "resolveNavHeightGetMethod", "shouldKeepOffscreenAfterCrossActivityPush", "shouldMovePreviousPageOnLargeScreenPush", "shouldUseLargeScreenAnimationWidth", "tryInitFreeformWindowSize", "getBottomView", "getRealAnimBackgroundView", "getRealAnimView", "remove", "predicate", "Lkotlin/Function1;", "resetPage", "safeLastElement", "R", "(Ljava/util/Stack;)Ljava/lang/Object;", "AnimGroup", "ErrorType", "IAnimView", "IAnimationCallback", "ICrossActivityOffscreenTransformGate", "ICrossActivityPreviousPageAnimGate", "ILargeScreenAnimWidthGate", "ILargeScreenAnimWidthView", "ILynxAnimView", "IOldAnimView", "IRemoveAfterNextPagePush", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AnimUtil {
    private static final long ANIM_DURATION = 300;
    private static final long CROSS_ACTIVITY_PUSH_ANIM_DELAY_MILLIS = 300;
    private static final long CROSS_FRAGMENT_PUSH_ANIM_DELAY_MILLIS = 150;
    public static final AnimUtil INSTANCE = null;
    public static final String NEVER_BACK = "never_back";
    private static final String TAG = "AnimUtil";
    private static final Lazy navHeightGetMethod$delegate = null;
    private static final Stack<IAnimView> pageStack = null;
    private static int screenHeight;
    private static int screenWidth;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/AnimUtil$AnimGroup;", "", SocialConstants.PARAM_APP_DESC, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "DEFAULT", "INTEGRATED", "VERIFY", "PAY_AGAIN", "PAY_AFTER_GUIDE", "DY_VERIFY", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum AnimGroup extends Enum<AnimGroup> {
        private static final /* synthetic */ AnimGroup[] $VALUES = null;
        public static final AnimGroup DEFAULT = null;
        public static final AnimGroup DY_VERIFY = null;
        public static final AnimGroup INTEGRATED = null;
        public static final AnimGroup PAY_AFTER_GUIDE = null;
        public static final AnimGroup PAY_AGAIN = null;
        public static final AnimGroup VERIFY = null;
        private final String desc;

        private static final /* synthetic */ AnimGroup[] $values() {
            return new AnimGroup[]{DEFAULT, INTEGRATED, VERIFY, PAY_AGAIN, PAY_AFTER_GUIDE, DY_VERIFY};
        }

        public static AnimGroup valueOf(String r100) {
            return (AnimGroup) a.a(AnimGroup.class, r100);
        }

        public static AnimGroup[] values() {
            return (AnimGroup[]) $VALUES.clone();
        }

        static {
            DEFAULT = new AnimGroup("DEFAULT", 0, "默认");
            INTEGRATED = new AnimGroup("INTEGRATED", 1, "聚合");
            VERIFY = new AnimGroup("VERIFY", 2, "验证组件");
            PAY_AGAIN = new AnimGroup("PAY_AGAIN", 3, "二次支付");
            PAY_AFTER_GUIDE = new AnimGroup("PAY_AFTER_GUIDE", 4, "支付后引导");
            DY_VERIFY = new AnimGroup("DY_VERIFY", 5, "核身");
            $VALUES = $values();
        }

        public final String getDesc() {
            return this.desc;
        }

        private AnimGroup(String r100, int r101, String r102) {
            super(r100, r101);
            this.desc = r102;
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/AnimUtil$ErrorType;", "", SocialConstants.PARAM_APP_DESC, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "NOT_EXIST_IN_STACK_TOP_EXIST_IN_STACK", "NOT_EXIST_IN_STACK", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ErrorType extends Enum<ErrorType> {
        private static final /* synthetic */ ErrorType[] $VALUES = null;
        public static final ErrorType NOT_EXIST_IN_STACK = null;
        public static final ErrorType NOT_EXIST_IN_STACK_TOP_EXIST_IN_STACK = null;
        private final String desc;

        private static final /* synthetic */ ErrorType[] $values() {
            return new ErrorType[]{NOT_EXIST_IN_STACK_TOP_EXIST_IN_STACK, NOT_EXIST_IN_STACK};
        }

        public static ErrorType valueOf(String r100) {
            return (ErrorType) a.a(ErrorType.class, r100);
        }

        public static ErrorType[] values() {
            return (ErrorType[]) $VALUES.clone();
        }

        static {
            NOT_EXIST_IN_STACK_TOP_EXIST_IN_STACK = new ErrorType("NOT_EXIST_IN_STACK_TOP_EXIST_IN_STACK", 0, "操作的页面不在栈顶，在栈中");
            NOT_EXIST_IN_STACK = new ErrorType("NOT_EXIST_IN_STACK", 1, "操作的页面不在栈中");
            $VALUES = $values();
        }

        public final String getDesc() {
            return this.desc;
        }

        private ErrorType(String r100, int r101, String r102) {
            super(r100, r101);
            this.desc = r102;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0017¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/AnimUtil$IAnimView;", "", "getAnimGroup", "Lcom/android/ttcjpaysdk/base/framework/AnimUtil$AnimGroup;", "getAnimViewContext", "Landroid/app/Activity;", "getAnimViewHeight", "", "getNewAnimView", "Lcom/android/ttcjpaysdk/base/framework/CJPayAnimRootView;", "getOldRootView", "Landroid/view/View;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface IAnimView {

        /* JADX INFO: loaded from: classes28.dex */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static Activity getAnimViewContext(IAnimView r100) {
                return null;
            }

            public static int getAnimViewHeight(IAnimView r100) {
                return 0;
            }

            public static CJPayAnimRootView getNewAnimView(IAnimView r100) {
                return null;
            }

            @Deprecated(message = "使用getNewAnimView代替")
            public static View getOldRootView(IAnimView r100) {
                return null;
            }

            public static AnimGroup getAnimGroup(IAnimView r100) {
                return AnimGroup.DEFAULT;
            }
        }

        AnimGroup getAnimGroup();

        Activity getAnimViewContext();

        int getAnimViewHeight();

        CJPayAnimRootView getNewAnimView();

        @Deprecated(message = "使用getNewAnimView代替")
        View getOldRootView();
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/AnimUtil$IAnimationCallback;", "", "onEndCallback", "", LynxVideoManagerLite.EVENT_ON_ERROR, "errorType", "Lcom/android/ttcjpaysdk/base/framework/AnimUtil$ErrorType;", "onStartCallback", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface IAnimationCallback {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void onEndCallback(IAnimationCallback r100) {
            }

            public static void onError(IAnimationCallback r100, ErrorType r101) {
                Intrinsics.checkNotNullParameter(r101, "errorType");
            }

            public static void onStartCallback(IAnimationCallback r100) {
            }
        }

        void onEndCallback();

        void onError(ErrorType r100);

        void onStartCallback();
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/AnimUtil$ICrossActivityOffscreenTransformGate;", "", "shouldKeepOffscreenAfterCrossActivityPush", "", "curPage", "Lcom/android/ttcjpaysdk/base/framework/AnimUtil$IAnimView;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ICrossActivityOffscreenTransformGate {
        boolean shouldKeepOffscreenAfterCrossActivityPush(IAnimView r100);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/AnimUtil$ICrossActivityPreviousPageAnimGate;", "", "shouldMoveAsPreviousPageOnLargeScreenPush", "", "curPage", "Lcom/android/ttcjpaysdk/base/framework/AnimUtil$IAnimView;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ICrossActivityPreviousPageAnimGate {
        boolean shouldMoveAsPreviousPageOnLargeScreenPush(IAnimView r100);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/AnimUtil$ILargeScreenAnimWidthGate;", "Lcom/android/ttcjpaysdk/base/framework/AnimUtil$ILargeScreenAnimWidthView;", "shouldUseLargeScreenAnimationWidth", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ILargeScreenAnimWidthGate extends ILargeScreenAnimWidthView {
        boolean shouldUseLargeScreenAnimationWidth();
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/AnimUtil$ILargeScreenAnimWidthView;", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ILargeScreenAnimWidthView {
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/AnimUtil$ILynxAnimView;", "Lcom/android/ttcjpaysdk/base/framework/AnimUtil$IAnimView;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ILynxAnimView extends IAnimView {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static AnimGroup getAnimGroup(ILynxAnimView r100) {
                return IAnimView.DefaultImpls.getAnimGroup(r100);
            }

            public static Activity getAnimViewContext(ILynxAnimView r100) {
                return IAnimView.DefaultImpls.getAnimViewContext(r100);
            }

            public static int getAnimViewHeight(ILynxAnimView r100) {
                return IAnimView.DefaultImpls.getAnimViewHeight(r100);
            }

            public static CJPayAnimRootView getNewAnimView(ILynxAnimView r100) {
                return IAnimView.DefaultImpls.getNewAnimView(r100);
            }

            @Deprecated(message = "使用getNewAnimView代替")
            public static View getOldRootView(ILynxAnimView r100) {
                return IAnimView.DefaultImpls.getOldRootView(r100);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/AnimUtil$IOldAnimView;", "Lcom/android/ttcjpaysdk/base/framework/AnimUtil$IAnimView;", "isUseNewAnim", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface IOldAnimView extends IAnimView {

        /* JADX INFO: loaded from: classes28.dex */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static AnimGroup getAnimGroup(IOldAnimView r100) {
                return IAnimView.DefaultImpls.getAnimGroup(r100);
            }

            public static Activity getAnimViewContext(IOldAnimView r100) {
                return IAnimView.DefaultImpls.getAnimViewContext(r100);
            }

            public static int getAnimViewHeight(IOldAnimView r100) {
                return IAnimView.DefaultImpls.getAnimViewHeight(r100);
            }

            public static CJPayAnimRootView getNewAnimView(IOldAnimView r100) {
                return IAnimView.DefaultImpls.getNewAnimView(r100);
            }

            @Deprecated(message = "使用getNewAnimView代替")
            public static View getOldRootView(IOldAnimView r100) {
                return IAnimView.DefaultImpls.getOldRootView(r100);
            }
        }

        boolean isUseNewAnim();
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/AnimUtil$IRemoveAfterNextPagePush;", "", "shouldRemoveAfterNextPagePush", "", "curPage", "Lcom/android/ttcjpaysdk/base/framework/AnimUtil$IAnimView;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface IRemoveAfterNextPagePush {
        boolean shouldRemoveAfterNextPagePush(IAnimView r100);
    }

    private AnimUtil() {
    }

    @JvmStatic
    public static final void popTopPageAndRemoveGroup(IAnimView r100) {
        Intrinsics.checkNotNullParameter(r100, "page");
        popTopPageAndRemoveGroup$default(r100, null, null, null, null, 30, null);
    }

    @JvmStatic
    public static final void popTopPageAndRemoveGroup(IAnimView r100, IAnimationCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "page");
        popTopPageAndRemoveGroup$default(r100, r101, null, null, null, 28, null);
    }

    @JvmStatic
    public static final void popTopPageAndRemoveGroup(IAnimView r100, IAnimationCallback r101, Boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "page");
        popTopPageAndRemoveGroup$default(r100, r101, r110, null, null, 24, null);
    }

    @JvmStatic
    public static final void popTopPageAndRemoveGroup(IAnimView r100, IAnimationCallback r101, Boolean r110, Boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "page");
        popTopPageAndRemoveGroup$default(r100, r101, r110, r111, null, 16, null);
    }

    static {
        INSTANCE = new AnimUtil();
        navHeightGetMethod$delegate = LazyKt.lazy(AnimUtil$navHeightGetMethod$2.INSTANCE);
        screenWidth = -1;
        screenHeight = -1;
        pageStack = new Stack();
    }

    @JvmStatic
    public static final boolean isPageStackEmpty() {
        return pageStack.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void removeAllPage() {
        if (StringsKt.isBlank(TAG) == true) goto L5;
        String r100 = TAG;
    L13:
        String r101 = CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 5), "\n ", null, null, 0, null, null, 62, null);
        CJLogger.a(r100, "Debug\n " + CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 10), "\n ", null, null, 0, null, null, 62, null));
        long r102 = System.currentTimeMillis();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L16
        pageStack.clear();     // Catch: Throwable -> L16
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        String r110 = null;
        if (Result.m9456isSuccessimpl(r104) == false) goto L21;
        CJLogger.d(r100, "onSuccess\n " + r101);
        Object r111 = r104;
        boolean r105 = true;
    L22:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r104);
        if (r106 == null) goto L25;
        CJBasicCommonUtils.reportCatchException("CJResult#unknown", r106);
        CJLogger.c(r100, "onFailure", r106);
        r105 = false;
    L26:
        long r112 = System.currentTimeMillis() - r102;
        CJLogger.d(r100, "is_success: " + r105 + ", duration: " + r112);
        CJReporter r107 = CJReporter.f202294a;
        Set<String> r108 = CJContext.f202254w;
        String r109 = "";
        CJContext r113 = CJContext.c.a(TAG, "", "", new HashMap());
        Pair[] r114 = new Pair[5];
        r114[0] = TuplesKt.to("tag", TAG);
        r114[1] = TuplesKt.to("is_success", KtSafeMethodExtensionKt.tf(r105, "1", "0"));
        if (r106 == null) goto L29;
        r110 = r106.getMessage();
    L29:
        if (r110 == null) goto L32;
        r109 = r110;
    L32:
        r114[2] = TuplesKt.to("error_msg", r109);
        r114[3] = TuplesKt.to("trace", r101);
        r114[4] = TuplesKt.to("duration", Long.valueOf(r112));
        CJReporter.o(r113, "cjpay_run_catch_result", MapsKt.mapOf(r114));
        new CJResult(r111, r105, r106);
        return;
    L25:
        r106 = null;
        goto L26
    L21:
        r111 = null;
        r105 = false;
    L16:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    L5:
        if ((this instanceof ICJTag) == false) goto L10;
        String r116 = ((ICJTag) this).CJTag();
        if (r116 == null) goto L10;
        if (StringsKt.isBlank(r116) == true) goto L10;
    L11:
        r100 = r116;
    L10:
        r116 = "runCatching";
        goto L11
    }

    public final String getNavHeightGetMethod() {
        return (String) navHeightGetMethod$delegate.getValue();
    }

    public final AnimGroup getTopAnimGroup() {
        Stack<IAnimView> r100 = pageStack;     // Catch: Exception -> L6
        if (r100.isEmpty() == true) goto L9;
        return r100.peek().getAnimGroup();
    L9:
        return AnimGroup.DEFAULT;
    L6:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("AnimUtil#getTopAnimGroup", e);
        CJLogger.b(TAG, "getTopAnimGroup: " + e.getMessage());
        goto L9
    }

    public final IAnimView getTopAnimView() {
        Stack<IAnimView> r100 = pageStack;
        if ((!r100.isEmpty()) == true) goto L7;
        return null;
    L7:
        return r100.peek();
    }

    public final boolean hasLynxActivity() {
        Iterator<T> r100 = pageStack.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Object r101 = r100.next();
        if ((((IAnimView) r101) instanceof ILynxAnimView) == false) goto L4;
    L9:
        if (r101 == null) goto L11;
        return true;
    L11:
        return false;
    L8:
        r101 = null;
        goto L9
    }

    public static final /* synthetic */ Stack access$getPageStack$p() {
        return pageStack;
    }

    public static View INVOKEVIRTUAL_com_android_ttcjpaysdk_base_framework_AnimUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static final /* synthetic */ void access$removeAllPage(AnimUtil r100) {
        r100.removeAllPage();
    }

    @JvmStatic
    public static final void addPwdVerifyPage(final IOldAnimView r100) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Handler r101 = b.f202770a;
        Runnable r102 = new AnonymousClass1(r100);
        Intrinsics.checkNotNullParameter(r102, "<this>");
        b.i(r102);
    }

    private final View getBottomView(IAnimView r100) {
        CJPayAnimRootView r101 = r100.getNewAnimView();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getBottomView();
    }

    private final int getFullScreenHeight(Context r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        initScreenSize(r100);
        CJLogger.d(TAG, "getFullScreenHeight: screenHeight " + screenHeight);
        int r101 = screenHeight;
        if (r101 > 0) goto L8;
        return 0;
    L8:
        return r101;
    }

    private final View getRealAnimBackgroundView(IAnimView r100) {
        CJPayAnimRootView r101 = r100.getNewAnimView();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getAnimBackgroundView();
    }

    private final View getRealAnimView(IAnimView r100) {
        CJPayAnimRootView r101 = r100.getNewAnimView();
        if (r101 == null) goto L8;
        LinearLayout r102 = r101.getContainerView();
        if (r102 == null) goto L8;
        return r102;
    L8:
        return r100.getOldRootView();
    }

    @JvmStatic
    public static final boolean hasPreviousPageOutsideGroup(AnimGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "group");
        Stack<IAnimView> r101 = pageStack;
        boolean r102 = false;
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L23;
        IAnimView r104 = (IAnimView) r103.next();
        if (r104.getAnimGroup() == r100) goto L20;
        Activity r105 = r104.getAnimViewContext();
        if (r105 != null) goto L15;
    L17:
        boolean r106 = false;
    L18:
        if (r106 == true) goto L20;
        boolean r107 = true;
    L21:
        if (r107 == false) goto L9;
        r102 = true;
        goto L23
    L15:
        if (r105.isDestroyed() != true) goto L17;
        r106 = true;
    L20:
        r107 = false;
    L23:
        CJLogger.d(TAG, "hasPreviousPageOutsideGroup group=" + r100 + ", hasPreviousPage=" + r102);
        return r102;
    L5:
        if (r101.isEmpty() == false) goto L7;
        goto L7
    }

    private final void initScreenSize(Context r100) {
        if (r100 != null) goto L15;
        return;
    L15:
    L12:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("AnimUtil#initScreenSize", e);
        CJBasicCommonUtils.logCatch("CJCatch", "AnimUtil#initScreenSize", e);
        return;
    L5:
        if (tryInitFreeformWindowSize(r100) == false) goto L7;
        return;
    L7:
        Object r101 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.WindowManager");     // Catch: Exception -> L12
        Display r102 = ((WindowManager) r101).getDefaultDisplay();     // Catch: Exception -> L12
        Point r103 = new Point();     // Catch: Exception -> L12
        if (r102 != null) goto L10;
        return;
    L10:
        r102.getRealSize(r103);     // Catch: Exception -> L12
        screenHeight = r103.y;     // Catch: Exception -> L12
        screenWidth = r103.x;     // Catch: Exception -> L12
    }

    @JvmStatic
    public static final boolean isTop(IAnimView r100) {
        Intrinsics.checkNotNullParameter(r100, "page");
        return Intrinsics.areEqual(r100, INSTANCE.safeLastElement(pageStack));
    }

    @JvmStatic
    public static final void onActivityDestroy(final Activity r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Handler r101 = b.f202770a;
        Runnable r102 = new RunnableC88201(r100);
        Intrinsics.checkNotNullParameter(r102, "<this>");
        b.i(r102);
    }

    @JvmStatic
    public static final void onDestroy(final IAnimView r100) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Handler r101 = b.f202770a;
        Runnable r102 = new RunnableC88211(r100);
        Intrinsics.checkNotNullParameter(r102, "<this>");
        b.i(r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void removeContextPage(Activity r110) {
        if (StringsKt.isBlank(TAG) == true) goto L5;
        String r100 = TAG;
    L13:
        String r101 = CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 5), "\n ", null, null, 0, null, null, 62, null);
        CJLogger.a(r100, "Debug\n " + CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 10), "\n ", null, null, 0, null, null, 62, null));
        long r102 = System.currentTimeMillis();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L26
        Stack<IAnimView> r104 = pageStack;     // Catch: Throwable -> L26
        ArrayList r105 = new ArrayList();     // Catch: Throwable -> L26
        Iterator<T> r106 = r104.iterator();     // Catch: Throwable -> L26
    L16:
        if (r106.hasNext() == false) goto L20;
        Object r107 = r106.next();     // Catch: Throwable -> L26
        if (Intrinsics.areEqual(((IAnimView) r107).getAnimViewContext(), r110) == false) goto L16;
        r105.add(r107);     // Catch: Throwable -> L26
        goto L16
    L20:
        Iterator r108 = r105.iterator();     // Catch: Throwable -> L26
    L22:
        if (r108.hasNext() == false) goto L24;
        pageStack.remove((IAnimView) r108.next());     // Catch: Throwable -> L26
        goto L22
    L24:
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L28:
        String r111 = null;
        if (Result.m9456isSuccessimpl(r109) == false) goto L31;
        CJLogger.d(r100, "onSuccess\n " + r101);
        Object r112 = r109;
        boolean r113 = true;
    L32:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r109);
        if (r114 == null) goto L35;
        CJBasicCommonUtils.reportCatchException("CJResult#unknown", r114);
        CJLogger.c(r100, "onFailure", r114);
        r113 = false;
    L36:
        long r115 = System.currentTimeMillis() - r102;
        CJLogger.d(r100, "is_success: " + r113 + ", duration: " + r115);
        CJReporter r116 = CJReporter.f202294a;
        Set<String> r117 = CJContext.f202254w;
        String r118 = "";
        CJContext r119 = CJContext.c.a(TAG, "", "", new HashMap());
        Pair[] r120 = new Pair[5];
        r120[0] = TuplesKt.to("tag", TAG);
        r120[1] = TuplesKt.to("is_success", KtSafeMethodExtensionKt.tf(r113, "1", "0"));
        if (r114 == null) goto L39;
        r111 = r114.getMessage();
    L39:
        if (r111 == null) goto L42;
        r118 = r111;
    L42:
        r120[2] = TuplesKt.to("error_msg", r118);
        r120[3] = TuplesKt.to("trace", r101);
        r120[4] = TuplesKt.to("duration", Long.valueOf(r115));
        CJReporter.o(r119, "cjpay_run_catch_result", MapsKt.mapOf(r120));
        new CJResult(r112, r113, r114);
        return;
    L35:
        r114 = null;
        goto L36
    L31:
        r112 = null;
        r113 = false;
    L26:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    L5:
        if ((this instanceof ICJTag) == false) goto L10;
        String r122 = ((ICJTag) this).CJTag();
        if (r122 == null) goto L10;
        if (StringsKt.isBlank(r122) == true) goto L10;
    L11:
        r100 = r122;
    L10:
        r122 = "runCatching";
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void removeGroupPage(AnimGroup r110) {
        if (StringsKt.isBlank(TAG) == true) goto L5;
        String r100 = TAG;
    L13:
        String r101 = CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 5), "\n ", null, null, 0, null, null, 62, null);
        CJLogger.a(r100, "Debug\n " + CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 10), "\n ", null, null, 0, null, null, 62, null));
        long r102 = System.currentTimeMillis();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L29
        Stack<IAnimView> r104 = pageStack;     // Catch: Throwable -> L29
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L29
        Iterator<T> r105 = r104.iterator();     // Catch: Throwable -> L29
    L16:
        if (r105.hasNext() == false) goto L23;
        Object r112 = r105.next();     // Catch: Throwable -> L29
        if (((IAnimView) r112).getAnimGroup() != r110) goto L20;
        boolean r113 = true;
    L21:
        if (r113 == false) goto L16;
        r111.add(r112);     // Catch: Throwable -> L29
        goto L16
    L20:
        r113 = false;
        goto L21
    L23:
        Iterator r106 = r111.iterator();     // Catch: Throwable -> L29
    L25:
        if (r106.hasNext() == false) goto L27;
        pageStack.remove((IAnimView) r106.next());     // Catch: Throwable -> L29
        goto L25
    L27:
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        String r114 = null;
        if (Result.m9456isSuccessimpl(r107) == false) goto L34;
        CJLogger.d(r100, "onSuccess\n " + r101);
        Object r115 = r107;
        boolean r116 = true;
    L35:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L38;
        CJBasicCommonUtils.reportCatchException("CJResult#unknown", r108);
        CJLogger.c(r100, "onFailure", r108);
        r116 = false;
    L39:
        long r117 = System.currentTimeMillis() - r102;
        CJLogger.d(r100, "is_success: " + r116 + ", duration: " + r117);
        CJReporter r109 = CJReporter.f202294a;
        Set<String> r118 = CJContext.f202254w;
        String r119 = "";
        CJContext r120 = CJContext.c.a(TAG, "", "", new HashMap());
        Pair[] r121 = new Pair[5];
        r121[0] = TuplesKt.to("tag", TAG);
        r121[1] = TuplesKt.to("is_success", KtSafeMethodExtensionKt.tf(r116, "1", "0"));
        if (r108 == null) goto L42;
        r114 = r108.getMessage();
    L42:
        if (r114 == null) goto L45;
        r119 = r114;
    L45:
        r121[2] = TuplesKt.to("error_msg", r119);
        r121[3] = TuplesKt.to("trace", r101);
        r121[4] = TuplesKt.to("duration", Long.valueOf(r117));
        CJReporter.o(r120, "cjpay_run_catch_result", MapsKt.mapOf(r121));
        new CJResult(r115, r116, r108);
        return;
    L38:
        r108 = null;
        goto L39
    L34:
        r115 = null;
        r116 = false;
    L29:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L31
    L5:
        if ((this instanceof ICJTag) == false) goto L10;
        String r123 = ((ICJTag) this).CJTag();
        if (r123 == null) goto L10;
        if (StringsKt.isBlank(r123) == true) goto L10;
    L11:
        r100 = r123;
    L10:
        r123 = "runCatching";
        goto L11
    }

    @JvmStatic
    public static final void removeSameContextPageExceptSelf(IAnimView r110) {
        Intrinsics.checkNotNullParameter(r110, "page");
        Object r100 = INSTANCE;
        if (StringsKt.isBlank(TAG) == true) goto L5;
        String r101 = TAG;
    L12:
        String r102 = CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 5), "\n ", null, null, 0, null, null, 62, null);
        CJLogger.a(r101, "Debug\n " + CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 10), "\n ", null, null, 0, null, null, 62, null));
        long r103 = System.currentTimeMillis();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L30
        Stack<IAnimView> r105 = pageStack;     // Catch: Throwable -> L30
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L30
        Iterator<T> r106 = r105.iterator();     // Catch: Throwable -> L30
    L15:
        if (r106.hasNext() == false) goto L24;
        Object r112 = r106.next();     // Catch: Throwable -> L30
        IAnimView r113 = (IAnimView) r112;     // Catch: Throwable -> L30
        if (Intrinsics.areEqual(r113.getAnimViewContext(), r110.getAnimViewContext()) == true) goto L19;
    L21:
        boolean r114 = false;
    L22:
        if (r114 == false) goto L15;
        r111.add(r112);     // Catch: Throwable -> L30
        goto L15
    L19:
        if (Intrinsics.areEqual(r113, r110) == true) goto L21;
        r114 = true;
        goto L22
    L24:
        Iterator r107 = r111.iterator();     // Catch: Throwable -> L30
    L26:
        if (r107.hasNext() == false) goto L28;
        pageStack.remove((IAnimView) r107.next());     // Catch: Throwable -> L30
        goto L26
    L28:
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L30
    L32:
        String r115 = null;
        if (Result.m9456isSuccessimpl(r108) == false) goto L35;
        CJLogger.d(r101, "onSuccess\n " + r102);
        Object r116 = r108;
        boolean r109 = true;
    L36:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r108);
        if (r117 == null) goto L39;
        CJBasicCommonUtils.reportCatchException("CJResult#unknown", r117);
        CJLogger.c(r101, "onFailure", r117);
        r109 = false;
    L40:
        long r118 = System.currentTimeMillis() - r103;
        CJLogger.d(r101, "is_success: " + r109 + ", duration: " + r118);
        CJReporter r119 = CJReporter.f202294a;
        Set<String> r120 = CJContext.f202254w;
        String r121 = "";
        CJContext r122 = CJContext.c.a(TAG, "", "", new HashMap());
        Pair[] r123 = new Pair[5];
        r123[0] = TuplesKt.to("tag", TAG);
        r123[1] = TuplesKt.to("is_success", KtSafeMethodExtensionKt.tf(r109, "1", "0"));
        if (r117 == null) goto L43;
        r115 = r117.getMessage();
    L43:
        if (r115 == null) goto L46;
        r121 = r115;
    L46:
        r123[2] = TuplesKt.to("error_msg", r121);
        r123[3] = TuplesKt.to("trace", r102);
        r123[4] = TuplesKt.to("duration", Long.valueOf(r118));
        CJReporter.o(r122, "cjpay_run_catch_result", MapsKt.mapOf(r123));
        new CJResult(r116, r109, r117);
        return;
    L39:
        r117 = null;
        goto L40
    L35:
        r116 = null;
        r109 = false;
    L30:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L32
    L5:
        if ((r100 instanceof ICJTag) == false) goto L10;
        r101 = ((ICJTag) r100).CJTag();
        if (r101 == null) goto L10;
        if (StringsKt.isBlank(r101) == false) goto L12;
    L10:
        r101 = "runCatching";
        goto L12
    }

    @JvmStatic
    public static final void reset(final IAnimView r100) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Handler r101 = b.f202770a;
        Runnable r102 = new RunnableC88291(r100);
        Intrinsics.checkNotNullParameter(r102, "<this>");
        b.i(r102);
    }

    private final String resolveNavHeightGetMethod(String r100) {
        if (r100.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return r100;
    L9:
        if (CJPayLargeScreenUtils.isCashierLargeScreenAdaptEnabled() == false) goto L12;
        return "windowInsets";
    L12:
        return "";
    L5:
        r101 = false;
        goto L6
    }

    private final <R> R safeLastElement(Stack<R> r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        if (r100.isEmpty() == true) goto L13;
        return r100.lastElement();
    L13:
        return null;
    L8:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    @JvmStatic
    public static final boolean shouldUseLargeScreenAnimationWidth(IAnimView r100) {
        if (CJPayLargeScreenUtils.isCashierLargeScreenAdaptEnabled() == true) goto L6;
        return false;
    L6:
        if ((r100 instanceof ILargeScreenAnimWidthGate) == false) goto L9;
        return ((ILargeScreenAnimWidthGate) r100).shouldUseLargeScreenAnimationWidth();
    L9:
        if ((r100 instanceof ILargeScreenAnimWidthView) == false) goto L13;
        return true;
    L13:
        return false;
    }

    private final boolean tryInitFreeformWindowSize(Context r100) {
        if (CJPayLargeScreenUtils.isCashierLargeScreenAdaptEnabled() == true) goto L5;
        return false;
    L5:
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= 24) goto L9;
        return false;
    L9:
        if ((r100 instanceof Activity) == false) goto L11;
        Activity r102 = (Activity) r100;
    L12:
        if (r102 != null) goto L15;
        return false;
    L15:
        if (r102.isInMultiWindowMode() == false) goto L17;
    L19:
        Rect r103 = new Rect();
        if (r101 < 30) goto L22;
        r103.set(r102.getWindowManager().getCurrentWindowMetrics().getBounds());
    L23:
        screenHeight = r103.height();
        int r104 = r103.width();
        screenWidth = r104;
        if (r104 > 0) goto L26;
    L29:
        CJLogger.d(TAG, "initScreenSize skip invalid freeform window bounds, width: " + screenWidth + ", height: " + screenHeight);
        return false;
    L26:
        if (screenHeight <= 0) goto L29;
        CJLogger.d(TAG, "initScreenSize use freeform window bounds, width: " + screenWidth + ", height: " + screenHeight);
        return true;
    L22:
        r102.getWindowManager().getDefaultDisplay().getRectSize(r103);
        goto L23
    L17:
        if (CJPayLargeScreenUtils.isLargeScreen(r102, INVOKEVIRTUAL_com_android_ttcjpaysdk_base_framework_AnimUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r102.getWindow())) == true) goto L19;
        return false;
    L11:
        r102 = null;
        goto L12
    }

    public final void adjustPageWhenHideKeyboard(IAnimView r210) {
        Intrinsics.checkNotNullParameter(r210, "page");
        View r100 = getRealAnimView(r210);
        final View r101 = getRealAnimBackgroundView(r210);
        View r102 = getBottomView(r210);
        if (r100 == null) goto L7;
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if (r103 == null) goto L7;
        int r104 = r103.height;
    L8:
        int r105 = getScreenHeight$default(r210.getAnimViewContext(), true, false, null, 12, null);
        int r106 = CJPayBasicExtensionKt.dip2px(r210.getAnimViewHeight(), r210.getAnimViewContext());
        if (r102 == null) goto L11;
        int r107 = r102.getHeight();
    L12:
        if (r104 == 0) goto L28;
        if (r104 == r105) goto L29;
        if (r100 == null) goto L30;
        AnimatorSet r110 = new AnimatorSet();
        AnimUtil r111 = INSTANCE;
        r110.playTogether(new Animator[]{r111.getHeightAnimator(r100, r104, r105, 300)});
        if (r101 == null) goto L26;
        if (r107 <= 0) goto L20;
        boolean r108 = true;
    L21:
        if (r108 == true) goto L24;
        r101 = null;
    L24:
        if (r101 == null) goto L26;
        int r112 = r106 / 2;
        r110.playTogether(new Animator[]{r111.getHeightAnimator(r101, r112 + r107, r112, 300)});
        r110.addListener(new AnimUtil$adjustPageWhenHideKeyboard$1$2$1(r101));
        goto L26
    L20:
        r108 = false;
    L26:
        r110.start();
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L11:
        r107 = 0;
    L7:
        r104 = 0;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void removePage(IAnimView r110) {
        Intrinsics.checkNotNullParameter(r110, "page");
        if (StringsKt.isBlank(TAG) == true) goto L5;
        String r100 = TAG;
    L12:
        String r101 = CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 5), "\n ", null, null, 0, null, null, 62, null);
        CJLogger.a(r100, "Debug\n " + CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 10), "\n ", null, null, 0, null, null, 62, null));
        long r102 = System.currentTimeMillis();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L15
        Object r104 = Result.m9449constructorimpl(Boolean.valueOf(pageStack.remove(r110)));     // Catch: Throwable -> L15
    L17:
        String r111 = null;
        if (Result.m9456isSuccessimpl(r104) == false) goto L20;
        CJLogger.d(r100, "onSuccess\n " + r101);
        Object r112 = r104;
        boolean r105 = true;
    L21:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r104);
        if (r106 == null) goto L24;
        CJBasicCommonUtils.reportCatchException("CJResult#unknown", r106);
        CJLogger.c(r100, "onFailure", r106);
        r105 = false;
    L25:
        long r113 = System.currentTimeMillis() - r102;
        CJLogger.d(r100, "is_success: " + r105 + ", duration: " + r113);
        CJReporter r107 = CJReporter.f202294a;
        Set<String> r108 = CJContext.f202254w;
        String r109 = "";
        CJContext r114 = CJContext.c.a(TAG, "", "", new HashMap());
        Pair[] r115 = new Pair[5];
        r115[0] = TuplesKt.to("tag", TAG);
        r115[1] = TuplesKt.to("is_success", KtSafeMethodExtensionKt.tf(r105, "1", "0"));
        if (r106 == null) goto L28;
        r111 = r106.getMessage();
    L28:
        if (r111 == null) goto L31;
        r109 = r111;
    L31:
        r115[2] = TuplesKt.to("error_msg", r109);
        r115[3] = TuplesKt.to("trace", r101);
        r115[4] = TuplesKt.to("duration", Long.valueOf(r113));
        CJReporter.o(r114, "cjpay_run_catch_result", MapsKt.mapOf(r115));
        new CJResult(r112, r105, r106);
        return;
    L24:
        r106 = null;
        goto L25
    L20:
        r112 = null;
        r105 = false;
    L15:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    L5:
        if ((this instanceof ICJTag) == false) goto L10;
        r100 = ((ICJTag) this).CJTag();
        if (r100 == null) goto L10;
        if (StringsKt.isBlank(r100) == false) goto L12;
    L10:
        r100 = "runCatching";
        goto L12
    }

    public static final /* synthetic */ View access$getRealAnimView(AnimUtil r100, IAnimView r101) {
        return r100.getRealAnimView(r101);
    }

    public static final /* synthetic */ void access$removeContextPage(AnimUtil r100, Activity r101) {
        r100.removeContextPage(r101);
    }

    public static final /* synthetic */ void access$removeGroupPage(AnimUtil r100, AnimGroup r101) {
        r100.removeGroupPage(r101);
    }

    public static final /* synthetic */ Object access$safeLastElement(AnimUtil r100, Stack r101) {
        return r100.safeLastElement(r101);
    }

    @JvmStatic
    public static final void onResume(final IAnimView r100, IAnimationCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Handler r102 = b.f202770a;
        Runnable r103 = new RunnableC88221(r100);
        Intrinsics.checkNotNullParameter(r103, "<this>");
        b.i(r103);
    }

    @JvmStatic
    public static final void popPage(final IAnimView r100, final IAnimationCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Handler r102 = b.f202770a;
        Runnable r103 = new RunnableC88231(r100, r101);
        Intrinsics.checkNotNullParameter(r103, "<this>");
        b.i(r103);
    }

    @JvmStatic
    public static final void popTopPageAndRemoveAll(final IAnimView r100, final IAnimationCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Handler r102 = b.f202770a;
        Runnable r103 = new RunnableC88241(r100, r101);
        Intrinsics.checkNotNullParameter(r103, "<this>");
        b.i(r103);
    }

    @JvmStatic
    public static final void pushPage(final IAnimView r100, final IAnimationCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Handler r102 = b.f202770a;
        Runnable r103 = new RunnableC88261(r100, r101);
        Intrinsics.checkNotNullParameter(r103, "<this>");
        b.i(r103);
    }

    @JvmStatic
    public static final void pushPageWithoutDelayWithAnim(final IAnimView r100, final IAnimationCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Handler r102 = b.f202770a;
        Runnable r103 = new RunnableC88271(r100, r101);
        Intrinsics.checkNotNullParameter(r103, "<this>");
        b.i(r103);
    }

    @JvmStatic
    public static final void pushPageWithoutDelayWithoutAnim(final IAnimView r100, final IAnimationCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Handler r102 = b.f202770a;
        Runnable r103 = new RunnableC88281(r100, r101);
        Intrinsics.checkNotNullParameter(r103, "<this>");
        b.i(r103);
    }

    private final void remove(Stack<IAnimView> r100, Function1<? super IAnimView, Boolean> r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L14
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L14
        Iterator<T> r104 = r100.iterator();     // Catch: Throwable -> L14
    L4:
        if (r104.hasNext() == false) goto L8;
        Object r105 = r104.next();     // Catch: Throwable -> L14
        if (r101.invoke((IAnimView) r105).booleanValue() == false) goto L4;
        r103.add(r105);     // Catch: Throwable -> L14
        goto L4
    L8:
        Iterator r106 = r103.iterator();     // Catch: Throwable -> L14
    L10:
        if (r106.hasNext() == false) goto L12;
        r100.remove((IAnimView) r106.next());     // Catch: Throwable -> L14
        goto L10
    L12:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void removePreviousPageAfterNextPagePushIfNeeded(IAnimView r210, IAnimView r211) {
        if ((r210 instanceof IRemoveAfterNextPagePush) == true) goto L5;
        return;
    L5:
        if (((IRemoveAfterNextPagePush) r210).shouldRemoveAfterNextPagePush(r211) == false) goto L61;
        StringBuilder r100 = new StringBuilder("remove previous page after next page push, prePage=");
        r100.append(r210.getClass().getSimpleName());
        r100.append(", curPage=");
        String r101 = null;
        if (r211 == null) goto L10;
        String r102 = r211.getClass().getSimpleName();
    L11:
        r100.append(r102);
        CJLogger.d(TAG, r100.toString());
        removePage(r210);
        if ((r210 instanceof BaseFragment) == false) goto L14;
        BaseFragment r103 = (BaseFragment) r210;
    L16:
        if (r103 == null) goto L19;
        r103.onHide(false);
    L19:
        if ((r210 instanceof Fragment) == false) goto L21;
        Fragment r104 = (Fragment) r210;
    L22:
        if (r104 == null) goto L60;
        Object r105 = INSTANCE;
        if (StringsKt.isBlank(TAG) == true) goto L26;
        String r106 = TAG;
    L33:
        String r107 = CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 5), "\n ", null, null, 0, null, null, 62, null);
        CJLogger.a(r106, "Debug\n " + CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 10), "\n ", null, null, 0, null, null, 62, null));
        long r108 = System.currentTimeMillis();
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L39
        if (r104.isAdded() == false) goto L37;
        r104.getParentFragmentManager().beginTransaction().remove(r104).commitAllowingStateLoss();     // Catch: Throwable -> L39
    L37:
        Object r110 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L39
    L42:
        if (Result.m9456isSuccessimpl(r110) == false) goto L44;
        CJLogger.d(r106, "onSuccess\n " + r107);
        Object r111 = r110;
        boolean r112 = true;
    L45:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r110);
        if (r113 == null) goto L48;
        CJBasicCommonUtils.reportCatchException("CJResult#unknown", r113);
        CJLogger.c(r106, "onFailure", r113);
        r112 = false;
    L49:
        long r114 = System.currentTimeMillis() - r108;
        CJLogger.d(r106, "is_success: " + r112 + ", duration: " + r114);
        CJReporter r115 = CJReporter.f202294a;
        Set<String> r116 = CJContext.f202254w;
        String r117 = "";
        CJContext r118 = CJContext.c.a(TAG, "", "", new HashMap());
        Pair[] r119 = new Pair[5];
        r119[0] = TuplesKt.to("tag", TAG);
        r119[1] = TuplesKt.to("is_success", KtSafeMethodExtensionKt.tf(r112, "1", "0"));
        if (r113 == null) goto L52;
        r101 = r113.getMessage();
    L52:
        if (r101 == null) goto L55;
        r117 = r101;
    L55:
        r119[2] = TuplesKt.to("error_msg", r117);
        r119[3] = TuplesKt.to("trace", r107);
        r119[4] = TuplesKt.to("duration", Long.valueOf(r114));
        CJReporter.o(r118, "cjpay_run_catch_result", MapsKt.mapOf(r119));
        new CJResult(r111, r112, r113);
        return;
    L48:
        r113 = null;
        goto L49
    L44:
        r111 = null;
        r112 = false;
    L39:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L42
    L26:
        if ((r105 instanceof ICJTag) == false) goto L31;
        r106 = ((ICJTag) r105).CJTag();
        if (r106 == null) goto L31;
        if (StringsKt.isBlank(r106) == false) goto L33;
    L31:
        r106 = "runCatching";
        goto L33
    L60:
        return;
    L21:
        r104 = null;
        goto L22
    L14:
        r103 = null;
        goto L16
    L10:
        r102 = null;
        goto L11
    }

    private final void resetPage(IAnimView r100, boolean r101) {
        if (r100 == null) goto L11;
        View r102 = getRealAnimView(r100);
        if (r102 == null) goto L12;
        int r103 = getScreenHeight$default(r100.getAnimViewContext(), r101, false, null, 12, null);
        r102.setTranslationX(0.0f);
        ViewGroup.LayoutParams r104 = r102.getLayoutParams();
        if (r104 == null) goto L9;
        r104.height = r103;
    L9:
        r102.requestLayout();
        return;
    L12:
        return;
    }

    private final float resolveFullOffscreenTranslationX(View r100, int r101) {
        View r102 = r100.getRootView();
        if (r102 == null) goto L5;
        int r103 = r102.getWidth();
    L6:
        int r104 = Math.max(r101, Math.max(r103, r100.getWidth())) + 2;
        if (r100.getTranslationX() < 0.0f) goto L9;
        float r105 = 1.0f;
    L10:
        float r106 = r105 * r104;
        CJLogger.d(TAG, "resolveFullOffscreenTranslationX rootWidth=" + r103 + ", viewWidth=" + r100.getWidth() + ", animationWidth=" + r101 + ", targetTranslationX=" + r106);
        return r106;
    L9:
        r105 = -1.0f;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    private final boolean shouldKeepOffscreenAfterCrossActivityPush(IAnimView r100, IAnimView r101) {
        boolean r102 = false;
        if (CJPayLargeScreenUtils.isCashierLargeScreenAdaptEnabled() == true) goto L5;
        return false;
    L5:
        String r103 = null;
        if ((r100 instanceof ICrossActivityOffscreenTransformGate) == false) goto L8;
        ICrossActivityOffscreenTransformGate r104 = (ICrossActivityOffscreenTransformGate) r100;
    L9:
        if (r104 == null) goto L11;
        r102 = r104.shouldKeepOffscreenAfterCrossActivityPush(r101);
    L11:
        StringBuilder r105 = new StringBuilder("shouldKeepOffscreenAfterCrossActivityPush shouldKeepOffscreen=");
        r105.append(r102);
        r105.append(", prePage=");
        if (r100 == null) goto L14;
        String r106 = r100.getClass().getSimpleName();
    L15:
        r105.append(r106);
        r105.append(", curPage=");
        if (r101 == null) goto L18;
        r103 = r101.getClass().getSimpleName();
    L18:
        r105.append(r103);
        CJLogger.d(TAG, r105.toString());
        return r102;
    L14:
        r106 = null;
        goto L15
    L8:
        r104 = null;
        goto L9
    }

    private final boolean shouldMovePreviousPageOnLargeScreenPush(IAnimView r100, IAnimView r101) {
        boolean r102 = CJPayLargeScreenUtils.isCashierLargeScreenAdaptEnabled();
        boolean r103 = true;
        String r104 = null;
        if (r102 == true) goto L14;
        StringBuilder r105 = new StringBuilder("shouldMovePreviousPageOnLargeScreenPush shouldMove=true, experimentEnabled=false, prePage=");
        if (r100 == null) goto L7;
        String r106 = r100.getClass().getSimpleName();
    L8:
        r105.append(r106);
        r105.append(", curPage=");
        if (r101 == null) goto L11;
        r104 = r101.getClass().getSimpleName();
    L11:
        r105.append(r104);
        CJLogger.d(TAG, r105.toString());
        return true;
    L7:
        r106 = null;
        goto L8
    L14:
        if ((r100 instanceof ICrossActivityPreviousPageAnimGate) == false) goto L16;
        ICrossActivityPreviousPageAnimGate r107 = (ICrossActivityPreviousPageAnimGate) r100;
    L17:
        if (r107 == null) goto L19;
        r103 = r107.shouldMoveAsPreviousPageOnLargeScreenPush(r101);
    L19:
        StringBuilder r108 = new StringBuilder("shouldMovePreviousPageOnLargeScreenPush shouldMove=");
        r108.append(r103);
        r108.append(", experimentEnabled=");
        r108.append(r102);
        r108.append(", prePage=");
        if (r100 == null) goto L22;
        String r109 = r100.getClass().getSimpleName();
    L23:
        r108.append(r109);
        r108.append(", curPage=");
        if (r101 == null) goto L26;
        r104 = r101.getClass().getSimpleName();
    L26:
        r108.append(r104);
        CJLogger.d(TAG, r108.toString());
        return r103;
    L22:
        r109 = null;
        goto L23
    L16:
        r107 = null;
        goto L17
    }

    public final void adjustPageWhenPopKeyboard(IAnimView r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "page");
        View r100 = getRealAnimView(r110);
        final View r101 = getRealAnimBackgroundView(r110);
        if (r100 == null) goto L7;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L7;
        int r103 = r102.height;
    L8:
        int r104 = r103 - r111;
        int r112 = CJPayBasicExtensionKt.dip2px(r110.getAnimViewHeight(), r110.getAnimViewContext());
        if (r103 == 0) goto L18;
        if (r103 == r104) goto L19;
        if (r100 == null) goto L20;
        AnimatorSet r113 = new AnimatorSet();
        AnimUtil r114 = INSTANCE;
        r113.playTogether(new Animator[]{r114.getHeightAnimator(r100, r103, r104, 300)});
        if (r101 == null) goto L16;
        r113.playTogether(new Animator[]{r114.getHeightAnimator(r101, r112, (r112 / 2) + r111, 300)});
        r113.addListener(new AnimUtil$adjustPageWhenPopKeyboard$1$1$1(r101));
    L16:
        r113.start();
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L7:
        r103 = 0;
        goto L8
    }

    public static final /* synthetic */ void access$remove(AnimUtil r100, Stack r101, Function1 r102) {
        r100.remove(r101, r102);
    }

    public static final /* synthetic */ void access$removePreviousPageAfterNextPagePushIfNeeded(AnimUtil r100, IAnimView r101, IAnimView r102) {
        r100.removePreviousPageAfterNextPagePushIfNeeded(r101, r102);
    }

    public static final /* synthetic */ float access$resolveFullOffscreenTranslationX(AnimUtil r100, View r101, int r102) {
        return r100.resolveFullOffscreenTranslationX(r101, r102);
    }

    private final void beginPopAnimNew(final IAnimView r310, final IAnimView r311, final IAnimationCallback r312, boolean r313) {
        if (r310 == null) goto L53;
        if (r311 == null) goto L53;
        CJLogger.a(TAG, "prePage != null && curPage != null");
        Activity r100 = r311.getAnimViewContext();
        int r101 = CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(r311.getAnimViewContext());
        Boolean r110 = null;
        int r111 = getScreenHeight$default(r311.getAnimViewContext(), true, false, null, 12, null);
        CJPayBasicExtensionKt.dip2px(r310.getAnimViewHeight(), r100);
        int r112 = CJPayBasicExtensionKt.dip2px(r311.getAnimViewHeight(), r100);
        int r113 = CJPayBasicExtensionKt.dip2px(r310.getAnimViewHeight() - r311.getAnimViewHeight(), r100);
        View r102 = getRealAnimView(r311);
        View r103 = getRealAnimView(r310);
        if (r313 == false) goto L8;
        View r104 = null;
    L9:
        if (r313 == false) goto L11;
        View r210 = null;
    L12:
        if (r313 == false) goto L14;
        View r211 = null;
    L15:
        if (r313 == false) goto L17;
        int r212 = r111;
    L18:
        if (r313 == false) goto L20;
        int r314 = r111;
    L21:
        final View r114 = r104;
        int r105 = resolveHorizontalAnimationWidth(r100, r310, r311, r103, r102, r101, !r313);
        CJLogger.d(TAG, "beginPopAnimNew animationWidth=" + r105 + ", keepCurPageStill=" + r313 + ", prePage=" + r310.getClass().getSimpleName() + ", curPage=" + r311.getClass().getSimpleName());
        if (r102 == null) goto L52;
        if (r103 == null) goto L52;
        AnimatorSet r106 = new AnimatorSet();
        ICJPaySettingService r107 = (ICJPaySettingService) CJPayServiceManager.getInstance().getIService(ICJPaySettingService.class);
        if (r107 == null) goto L28;
        r110 = Boolean.valueOf(r107.useNewAnimType1());
    L28:
        if (r110 == null) goto L30;
        boolean r108 = r110.booleanValue();
    L32:
        if (r108 == false) goto L34;
        AnimUtil r109 = INSTANCE;
        r106.playTogether(new Animator[]{r109.getTransXAnimator(r102, 0, 0, 300), r109.getTransXAnimator(r103, 0, r105, 300), r109.getHeightAnimator(r102, r212, r111, 300), r109.getHeightAnimator(r103, r111, r314, 300)});
    L51:
        r106.addListener(new AnimUtil$beginPopAnimNew$1$5(r312, r310, r311));
        r106.start();
        return;
    L34:
        Animator[] r115 = new Animator[4];
        AnimUtil r116 = INSTANCE;
        if (r313 == false) goto L37;
        int r213 = 0;
    L38:
        r115[0] = r116.getTransXAnimator(r102, r213, 0, 300);
        r115[1] = r116.getTransXAnimator(r103, 0, r105, 300);
        r115[2] = r116.getHeightAnimator(r102, r212, r111, 300);
        r115[3] = r116.getHeightAnimator(r103, r111, r314, 300);
        r106.playTogether(r115);
        if (r210 == null) goto L45;
        Animator[] r117 = new Animator[1];
        if (r313 == false) goto L43;
        int r214 = 0;
    L44:
        r117[0] = r116.getTransXAnimator(r210, r214, 0, 300);
        r106.playTogether(r117);
        goto L45
    L43:
        r214 = -r105;
    L45:
        if (r211 == null) goto L47;
        r106.playTogether(new Animator[]{r116.getTransXAnimator(r211, 0, r105, 300)});
    L47:
        if (r114 == null) goto L51;
        ValueAnimator r118 = r116.getHeightAnimator(r114, r112 + r113, r112, 300);
        if (r118 == null) goto L51;
        r106.playTogether(new Animator[]{r118});
        r106.addListener(new AnimUtil$beginPopAnimNew$1$4$1(r114));
        goto L51
    L37:
        r213 = -r105;
        goto L38
    L30:
        r108 = false;
    L52:
        CJLogger.a(TAG, "curView == null || preView == null, curView: " + r102 + ", preView: " + r103);
        return;
    L20:
        r314 = r111 + r113;
        goto L21
    L17:
        r212 = r111 - r113;
        goto L18
    L14:
        r211 = getBottomView(r310);
        goto L15
    L11:
        r210 = getBottomView(r311);
        goto L12
    L8:
        r104 = getRealAnimBackgroundView(r311);
    L53:
        if (r310 == null) goto L61;
        CJLogger.a(TAG, "prePage != null");
        int r119 = getScreenHeight$default(r310.getAnimViewContext(), true, false, null, 12, null);
        int r120 = r119 + CJPayBasicExtensionKt.dip2px(r310.getAnimViewHeight(), r310.getAnimViewContext());
        View r121 = getRealAnimView(r310);
        if (r121 == null) goto L57;
        ValueAnimator r122 = getHeightAnimator(r121, r119, r120, 300);
        r122.addListener(new AnimUtil$beginPopAnimNew$2$1(r312, r310, r311));
        r122.start();
        return;
    L57:
        CJLogger.a(TAG, "curView == null");
        return;
    }

    private final void beginPushAnimNew(final IAnimView r310, final IAnimView r311, final IAnimationCallback r312, boolean r313) {
        if (r310 == null) goto L65;
        if (r311 == null) goto L65;
        CJLogger.a(TAG, "prePage != null && curPage != null");
        Activity r100 = r311.getAnimViewContext();
        int r101 = CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(r311.getAnimViewContext());
        if (r313 == false) goto L8;
        int r102 = getScreenHeight$default(r311.getAnimViewContext(), true, false, BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, 4, null);
    L9:
        int r210 = r102;
        View r110 = getRealAnimView(r311);
        View r111 = getRealAnimView(r310);
        int r211 = CJPayBasicExtensionKt.dip2px(r310.getAnimViewHeight(), r100);
        CJPayBasicExtensionKt.dip2px(r311.getAnimViewHeight(), r100);
        int r212 = CJPayBasicExtensionKt.dip2px(r310.getAnimViewHeight() - r311.getAnimViewHeight(), r100);
        final boolean r103 = shouldMovePreviousPageOnLargeScreenPush(r310, r311);
        final boolean r104 = shouldKeepOffscreenAfterCrossActivityPush(r310, r311);
        if (r103 == false) goto L13;
        if (r104 == true) goto L13;
        boolean r105 = true;
    L14:
        Boolean r112 = null;
        if (r105 == false) goto L17;
        View r106 = getRealAnimBackgroundView(r310);
    L18:
        if (r105 == false) goto L20;
        View r314 = getBottomView(r311);
    L21:
        if (r105 == false) goto L23;
        View r315 = getBottomView(r310);
    L24:
        boolean r107 = CJPaySettingsManager.getInstance().isDegradeStdHomeSwitchAnimFix();
        if (r103 == true) goto L29;
        if (r107 == true) goto L29;
        int r113 = r210;
    L30:
        if (r103 == false) goto L32;
        int r114 = r210 + r212;
    L33:
        final View r108 = r106;
        final int r109 = resolveHorizontalAnimationWidth(r100, r310, r311, r111, r110, r101, r103);
        CJLogger.d(TAG, "beginPushAnimNew fillerBackground shouldUse=" + r105 + ", movePreviousPage=" + r103 + ", shouldKeepPrePageOffscreen=" + r104 + ", degradeStdHomeSwitchAnimFix=" + r107 + ", curViewStartHeight=" + r113 + ", preViewEndHeight=" + r114 + ", prePage=" + r310.getClass().getSimpleName() + ", curPage=" + r311.getClass().getSimpleName());
        if (r110 == null) goto L63;
        if (r111 == null) goto L63;
        AnimatorSet r115 = new AnimatorSet();
        ICJPaySettingService r116 = (ICJPaySettingService) CJPayServiceManager.getInstance().getIService(ICJPaySettingService.class);
        if (r116 == null) goto L39;
        r112 = Boolean.valueOf(r116.useNewAnimType1());
    L39:
        if (r112 == null) goto L41;
        boolean r117 = r112.booleanValue();
    L43:
        if (r117 == false) goto L45;
        AnimUtil r118 = INSTANCE;
        final View r119 = r111;
        r115.playTogether(new Animator[]{r118.getTransXAnimator(r110, r109, 0, 300), r118.getTransXAnimator(r119, 0, 0, 300), r118.getHeightAnimator(r110, r113, r210, 300), r118.getHeightAnimator(r119, r210, r114, 300)});
        r115.addListener(new AnimUtil$beginPushAnimNew$1$1(r119, r103, r109, r104, r310));
    L62:
        final View r120 = r119;
        r115.addListener(new AnimUtil$beginPushAnimNew$1$6(r312, r310, r104, r120, r109, r311));
        r115.start();
    L75:
        return;
    L45:
        r119 = r111;
        Animator[] r121 = new Animator[4];
        AnimUtil r122 = INSTANCE;
        r121[0] = r122.getTransXAnimator(r110, r109, 0, 300);
        if (r103 == false) goto L48;
        int r213 = -r109;
    L49:
        r121[1] = r122.getTransXAnimator(r119, 0, r213, 300);
        r121[2] = r122.getHeightAnimator(r110, r113, r210, 300);
        r121[3] = r122.getHeightAnimator(r119, r210, r114, 300);
        r115.playTogether(r121);
        if (r314 == null) goto L52;
        r115.playTogether(new Animator[]{r122.getTransXAnimator(r314, r109, 0, 300)});
    L52:
        if (r315 == null) goto L58;
        Animator[] r123 = new Animator[1];
        if (r103 == false) goto L56;
        int r124 = -r109;
    L57:
        r123[0] = r122.getTransXAnimator(r315, 0, r124, 300);
        r115.playTogether(r123);
        goto L58
    L56:
        r124 = 0;
    L58:
        if (r108 == null) goto L62;
        ValueAnimator r125 = r122.getHeightAnimator(r108, r211, r211 - r212, 300);
        if (r125 == null) goto L62;
        r115.playTogether(new Animator[]{r125});
        r115.addListener(new AnimUtil$beginPushAnimNew$1$5$1(r108));
        goto L62
    L48:
        r213 = 0;
        goto L49
    L41:
        r117 = false;
    L63:
        CJLogger.a(TAG, "curView == null || preView == null, curView: " + r110 + ", preView: " + r111);
        removePreviousPageAfterNextPagePushIfNeeded(r310, r311);
        goto L75
    L32:
        r114 = r210;
    L29:
        r113 = r210 - r212;
        goto L30
    L23:
        r315 = null;
        goto L24
    L20:
        r314 = null;
        goto L21
    L17:
        r106 = null;
    L13:
        r105 = false;
        goto L14
    L8:
        r102 = getScreenHeight$default(r311.getAnimViewContext(), true, false, null, 12, null);
    L65:
        if (r311 == null) goto L75;
        CJLogger.a(TAG, "curPage != null");
        if (r313 == false) goto L69;
        int r126 = getScreenHeight$default(r311.getAnimViewContext(), true, false, BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, 4, null);
    L70:
        int r127 = r126;
        int r128 = r127 + CJPayBasicExtensionKt.dip2px(r311.getAnimViewHeight(), r311.getAnimViewContext());
        final View r129 = getRealAnimView(r311);
        if (r129 == null) goto L73;
        ValueAnimator r130 = getHeightAnimator(r129, r128, r127, 300);
        r130.addListener(new AnimUtil$beginPushAnimNew$2$1(r129, r312, r310, r311));
        r130.start();
        return;
    L73:
        CJLogger.a(TAG, "curView == null");
        return;
    L69:
        r126 = getScreenHeight$default(r311.getAnimViewContext(), true, false, null, 12, null);
        goto L70
    }

    private final ValueAnimator getHeightAnimator(final View r100, int r101, int r102, long r103) {
        ValueAnimator r104 = ValueAnimator.ofInt(new int[]{r101, r102});
        r104.setDuration(r103);
        Interpolator r105 = CJPayAnimationUtils.getBaseAnimationInterpolator();
        if (r105 == null) goto L5;
        r104.setInterpolator(r105);
    L5:
        r104.addUpdateListener(new AnimUtil$getHeightAnimator$1$2(r100));
        return r104;
    }

    @JvmStatic
    public static final int getScreenHeight(Activity r110, boolean r111, boolean r112, String r113) {
        Intrinsics.checkNotNullParameter(r113, "navMethodOverride");
        Activity r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L10
        if (r110 != null) goto L6;
        return 0;
    L6:
        AnimUtil r102 = INSTANCE;     // Catch: Throwable -> L10
        int r103 = r102.getFullScreenHeight(r110);     // Catch: Throwable -> L10
        int r114 = ((Number) KtSafeMethodExtensionKt.tf(r112, 0, Integer.valueOf(CJPayBasicUtils.getNavigationBarHeight(r110)))).intValue();     // Catch: Throwable -> L10
        int r115 = ((Number) KtSafeMethodExtensionKt.tf(r112, 0, Integer.valueOf(CJPayBasicUtils.getAccurateNavigationBarHeight(r110)))).intValue();     // Catch: Throwable -> L10
        int r104 = ((Number) KtSafeMethodExtensionKt.tf(r112, 0, Integer.valueOf(CJPayBasicUtils.getNavigationBarHeightViaInsets(r110)))).intValue();     // Catch: Throwable -> L10
        if (Math.abs(r114 - r115) <= 6) goto L13;
        CJReporter r116 = CJReporter.f202294a;     // Catch: Throwable -> L10
        CJReporter.k(null, "navBarDisMatch", 2, "navHeight: " + r114 + " , navHeightBackup: " + r115);     // Catch: Throwable -> L10
    L13:
        if (Math.abs(r114 - r104) <= 6) goto L15;
        CJReporter r117 = CJReporter.f202294a;     // Catch: Throwable -> L10
        CJReporter.k(null, "navBarInsetsDisMatch", 2, "navHeight: " + r114 + " , navHeightBackupInsets: " + r104);     // Catch: Throwable -> L10
    L15:
        String r105 = r102.resolveNavHeightGetMethod(r113);     // Catch: Throwable -> L10
        int r106 = r105.hashCode();     // Catch: Throwable -> L10
        if (r106 == (-2088865610)) goto L35;
        if (r106 == (-1406609658)) goto L32;
        if (r106 == 107876) goto L23;
    L36:
        int r107 = r114;
    L38:
        int r108 = (r103 - r107) - ((Number) KtSafeMethodExtensionKt.tf(r111, 0, Integer.valueOf(CJPayBasicUtils.getStatusBarHeight(r110)))).intValue();     // Catch: Throwable -> L10
        if (r108 > 0) goto L42;
        r108 = r102.getFullScreenHeight(CJPayHostInfo.applicationContext);     // Catch: Throwable -> L10
    L42:
        CJLogger.d(TAG, "getScreenHeight finalHeight: " + r108 + " , navHeightFinal:" + r107 + " , navHeightGetMethod: " + r105 + " navHeight: " + r114 + " , navHeightBackup: " + r115 + ", navHeightBackupInsets: " + r104);     // Catch: Throwable -> L10
        return r108;
    L23:
        if (r105.equals(BitableFieldEditAnalytic.ProgressFieldEditScene.MAX) == false) goto L36;
        if (r104 < r115) goto L28;
        if (r104 < r114) goto L28;
    L33:
        r107 = r104;
    L28:
        if (r115 < r104) goto L36;
        if (r115 < r114) goto L36;
    L37:
        r107 = r115;
        goto L38
    L32:
        if (r105.equals("windowInsets") == false) goto L36;
    L35:
        if (r105.equals("systemResources") == true) goto L37;
    L10:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Throwable r118 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r118 == null) goto L51;
        CJBasicCommonUtils.reportCatchException("AnimUtil#getScreenHeight", r118);
        CJLogger.c(TAG, "getScreenHeight error", r118);
        if ((r110 instanceof Context) == false) goto L50;
        r100 = r110;
    L50:
        return CJPayBasicUtils.getScreenHeight(r100) + ((Number) KtSafeMethodExtensionKt.tf(r111, Integer.valueOf(CJPayBasicUtils.getStatusBarHeight(r110)), 0)).intValue();
    L51:
        return 0;
    }

    private final ValueAnimator getTransXAnimator(View r100, int r101, int r102, long r103) {
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r101, r102});
        r104.setDuration(r103);
        r104.setInterpolator(CJPayAnimationUtils.getBaseAnimationInterpolator());
        return r104;
    }

    public static /* synthetic */ void onResume$default(IAnimView r100, IAnimationCallback r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        onResume(r100, r101);
    }

    public static /* synthetic */ void popPage$default(IAnimView r100, IAnimationCallback r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        popPage(r100, r101);
    }

    public static /* synthetic */ void popTopPageAndRemoveAll$default(IAnimView r100, IAnimationCallback r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        popTopPageAndRemoveAll(r100, r101);
    }

    public static /* synthetic */ void pushPage$default(IAnimView r100, IAnimationCallback r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        pushPage(r100, r101);
    }

    public static /* synthetic */ void pushPageWithoutDelayWithAnim$default(IAnimView r100, IAnimationCallback r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        pushPageWithoutDelayWithAnim(r100, r101);
    }

    public static /* synthetic */ void pushPageWithoutDelayWithoutAnim$default(IAnimView r100, IAnimationCallback r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        pushPageWithoutDelayWithoutAnim(r100, r101);
    }

    public static final /* synthetic */ void access$beginPopAnimNew(AnimUtil r100, IAnimView r101, IAnimView r102, IAnimationCallback r103, boolean r104) {
        r100.beginPopAnimNew(r101, r102, r103, r104);
    }

    public static final /* synthetic */ void access$beginPushAnimNew(AnimUtil r100, IAnimView r101, IAnimView r102, IAnimationCallback r103, boolean r104) {
        r100.beginPushAnimNew(r101, r102, r103, r104);
    }

    @JvmStatic
    public static final void popTopPageAndRemoveGroup(final IAnimView r100, final IAnimationCallback r101, final Boolean r102, final Boolean r110, final Boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Handler r103 = b.f202770a;
        Runnable r104 = new RunnableC88251(r100, r101, r111, r110, r102);
        Intrinsics.checkNotNullParameter(r104, "<this>");
        b.i(r104);
    }

    public static /* synthetic */ void resetPage$default(AnimUtil r100, IAnimView r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r102 = true;
    L5:
        r100.resetPage(r101, r102);
    }

    public static /* synthetic */ int getScreenHeight$default(Activity r100, boolean r101, boolean r102, String r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = false;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = false;
    L9:
        if ((r104 & 8) == 0) goto L12;
        r103 = INSTANCE.getNavHeightGetMethod();
    L12:
        return getScreenHeight(r100, r101, r102, r103);
    }

    public static /* synthetic */ void beginPopAnimNew$default(AnimUtil r100, IAnimView r101, IAnimView r102, IAnimationCallback r103, boolean r104, int r105, Object r106) {
        if ((r105 & 4) == 0) goto L6;
        r103 = null;
    L6:
        if ((r105 & 8) == 0) goto L8;
        r104 = false;
    L8:
        r100.beginPopAnimNew(r101, r102, r103, r104);
    }

    public static /* synthetic */ void beginPushAnimNew$default(AnimUtil r100, IAnimView r101, IAnimView r102, IAnimationCallback r103, boolean r104, int r105, Object r106) {
        if ((r105 & 4) == 0) goto L6;
        r103 = null;
    L6:
        if ((r105 & 8) == 0) goto L8;
        r104 = false;
    L8:
        r100.beginPushAnimNew(r101, r102, r103, r104);
    }

    public static /* synthetic */ void popTopPageAndRemoveGroup$default(IAnimView r100, IAnimationCallback r101, Boolean r102, Boolean r103, Boolean r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r102 = Boolean.TRUE;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r103 = Boolean.FALSE;
    L12:
        if ((r105 & 16) == 0) goto L14;
        r104 = Boolean.FALSE;
    L14:
        popTopPageAndRemoveGroup(r100, r101, r102, r103, r104);
    }

    private final int resolveHorizontalAnimationWidth(Activity r100, IAnimView r101, IAnimView r102, View r103, View r104, int r105, boolean r106) {
        boolean r107 = CJPayLargeScreenUtils.isCashierLargeScreenAdaptEnabled();
        if (r106 == true) goto L5;
    L7:
        boolean r108 = false;
    L8:
        boolean r109 = shouldUseLargeScreenAnimationWidth(r102);
        if (r108 == false) goto L12;
        if (r109 == false) goto L12;
        int r110 = Math.max(CJPayLargeScreenUtils.resolveAnimationWidthPx(r100, r104), CJPayLargeScreenUtils.resolveAnimationWidthPx(r100, r103));
    L17:
        CJLogger.d(TAG, "resolveHorizontalAnimationWidth width=" + r110 + ", fallback=" + r105 + ", movePreviousPage=" + r106 + ", experimentEnabled=" + r107 + ", usePrePageLargeWidth=" + r108 + ", useCurPageLargeWidth=" + r109);
        return r110;
    L12:
        if (r109 == false) goto L14;
        r110 = CJPayLargeScreenUtils.resolveAnimationWidthPx(r100, r104);
        goto L17
    L14:
        if (r108 == false) goto L16;
        r110 = CJPayLargeScreenUtils.resolveAnimationWidthPx(r100, r103);
        goto L17
    L16:
        r110 = r105;
        goto L17
    L5:
        if (shouldUseLargeScreenAnimationWidth(r101) == false) goto L7;
        r108 = true;
        goto L8
    }
}
