package com.stepos.ailauncher.task.space;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.dynamicanimation.animation.e;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.ailauncher.agent.aispace.connect.C2215l;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.chat.manager.ClawVMManager;
import com.stepos.ailauncher.chat.model.ReInstallVMResult;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.sheet.SheetSpring;
import com.stepos.ailauncher.task.R$drawable;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import com.stepos.ailauncher.task.R$string;
import com.stepos.common.ReInstallMode;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import net.sqlcipher.database.SQLiteDatabase;
import p7.AppUI;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000±\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u001c*\u0001y\u0018\u0000 \u0092\u00012\u00020\u0001:\u0002\u0093\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\fJ\u000f\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\fJ#\u0010\u0013\u001a\u00020\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\fJ\u000f\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\fJ\u000f\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J5\u0010!\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u001f\u0010%\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u001cH\u0002¢\u0006\u0004\b%\u0010&J\u0011\u0010(\u001a\u0004\u0018\u00010'H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\nH\u0002¢\u0006\u0004\b*\u0010\fJ\u000f\u0010+\u001a\u00020\nH\u0002¢\u0006\u0004\b+\u0010\fJ\u000f\u0010,\u001a\u00020\nH\u0002¢\u0006\u0004\b,\u0010\fJ\u000f\u0010-\u001a\u00020\nH\u0002¢\u0006\u0004\b-\u0010\fJ-\u00100\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u001c2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\n0\u001fH\u0002¢\u0006\u0004\b0\u00101J\u000f\u00103\u001a\u000202H\u0002¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u000202H\u0002¢\u0006\u0004\b5\u00104J!\u00109\u001a\u00020\n2\u0006\u00106\u001a\u0002022\b\b\u0002\u00108\u001a\u000207H\u0002¢\u0006\u0004\b9\u0010:J'\u0010>\u001a\u00020\n2\u0006\u00106\u001a\u0002022\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020;H\u0002¢\u0006\u0004\b>\u0010?J\u0017\u0010@\u001a\u00020\n2\u0006\u00106\u001a\u000202H\u0002¢\u0006\u0004\b@\u0010AJ\u001f\u0010D\u001a\u00020\n2\u0006\u00106\u001a\u0002022\u0006\u0010C\u001a\u00020BH\u0002¢\u0006\u0004\bD\u0010EJ_\u0010O\u001a\u00020N2\u0006\u0010F\u001a\u00020;2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020;0G2\u0006\u0010I\u001a\u00020B2\u0006\u0010K\u001a\u00020J2\u0016\b\u0002\u0010L\u001a\u0010\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\n\u0018\u00010\u00112\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001fH\u0002¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020BH\u0002¢\u0006\u0004\bQ\u0010RJ\u0017\u0010U\u001a\u00020\n2\u0006\u0010T\u001a\u00020SH\u0002¢\u0006\u0004\bU\u0010VJ\u001f\u0010X\u001a\u00020\n2\u0006\u0010T\u001a\u00020S2\u0006\u0010W\u001a\u00020\u0006H\u0002¢\u0006\u0004\bX\u0010YJ\u0017\u0010[\u001a\u00020\n2\u0006\u0010Z\u001a\u000207H\u0002¢\u0006\u0004\b[\u0010\\J\u000f\u0010]\u001a\u00020\nH\u0002¢\u0006\u0004\b]\u0010\fJ\u000f\u0010^\u001a\u00020\nH\u0002¢\u0006\u0004\b^\u0010\fJ\u000f\u0010_\u001a\u00020\nH\u0002¢\u0006\u0004\b_\u0010\fJ\u0017\u0010a\u001a\u00020\n2\u0006\u0010`\u001a\u00020\u0006H\u0002¢\u0006\u0004\ba\u0010bJ\u0017\u0010c\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u001cH\u0002¢\u0006\u0004\bc\u0010dJ\u000f\u0010e\u001a\u00020\nH\u0002¢\u0006\u0004\be\u0010\fR\u0014\u0010g\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010j\u001a\u00020i8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010l\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010%R\u0018\u0010m\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010o\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010%R\u0018\u0010p\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0014\u0010s\u001a\u00020r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u0014\u0010u\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u0014\u0010w\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010vR\u0014\u0010x\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010vR\u0014\u0010z\u001a\u00020y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010{R,\u0010|\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R/\u0010\u0082\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u0082\u0001\u0010}\u001a\u0005\b\u0083\u0001\u0010\u007f\"\u0006\b\u0084\u0001\u0010\u0081\u0001R/\u0010\u0085\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u0085\u0001\u0010}\u001a\u0005\b\u0086\u0001\u0010\u007f\"\u0006\b\u0087\u0001\u0010\u0081\u0001R\u0017\u0010\u0088\u0001\u001a\u00020\u001c8\u0002X\u0082D¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0017\u0010\u008a\u0001\u001a\u00020\u001c8\u0002X\u0082D¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u0089\u0001R\u0017\u0010\u008b\u0001\u001a\u00020\u001c8\u0002X\u0082D¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u0089\u0001R\u0017\u0010\u008c\u0001\u001a\u00020\u001c8\u0002X\u0082D¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u0089\u0001R\u0017\u0010\u008d\u0001\u001a\u00020\u001c8\u0002X\u0082D¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u0089\u0001R\u0017\u0010\u008e\u0001\u001a\u00020\u001c8\u0002X\u0082D¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u0089\u0001R\u0017\u0010\u008f\u0001\u001a\u00020\u001c8\u0002X\u0082D¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0089\u0001R\u0017\u0010\u0090\u0001\u001a\u00020\u001c8\u0002X\u0082D¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0089\u0001R\u0018\u0010\u0091\u0001\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010%¨\u0006\u0094\u0001"}, d2 = {"Lcom/stepos/ailauncher/task/space/RepairTabView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LY8/t;", "onAttachedToWindow", "()V", "onDetachedFromWindow", "l0", "k0", "n0", "Lkotlin/Function1;", "open", "a0", "(Lp9/l;)V", "Y", "Q0", "", "Q", "()Ljava/lang/CharSequence;", "Landroid/text/SpannableString;", "sp", "", ChatTracker.STAGE_FULL, "label", "Lkotlin/Function0;", "onClick", "P", "(Landroid/text/SpannableString;Ljava/lang/String;Ljava/lang/String;Lp9/a;)V", "title", QueryAlgorithmBundle.KEY_CATEGORY, "Z", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/app/Activity;", "J", "()Landroid/app/Activity;", "j0", "L0", "y0", "N0", "message", "onConfirm", "I0", "(Ljava/lang/String;Ljava/lang/String;Lp9/a;)V", "Landroid/app/Dialog;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()Landroid/app/Dialog;", "U", C3081a.FOCUS_DIALOG_NAME, "", "animated", "C0", "(Landroid/app/Dialog;Z)V", "Landroid/view/View;", "card", "scrim", "N", "(Landroid/app/Dialog;Landroid/view/View;Landroid/view/View;)V", "K", "(Landroid/app/Dialog;)V", "", "fraction", "m0", "(Landroid/app/Dialog;F)V", "view", "Landroidx/dynamicanimation/animation/f;", "property", "finalValue", "Lcom/stepos/ailauncher/sheet/g0;", "spring", "onUpdate", "onEnd", "Landroidx/dynamicanimation/animation/i;", "T0", "(Landroid/view/View;Landroidx/dynamicanimation/animation/f;FLcom/stepos/ailauncher/sheet/g0;Lp9/l;Lp9/a;)Landroidx/dynamicanimation/animation/i;", ExifInterface.GPS_DIRECTION_TRUE, "()F", "Landroid/widget/ImageView;", "imageView", "X0", "(Landroid/widget/ImageView;)V", "originalIconRes", "Y0", "(Landroid/widget/ImageView;I)V", x5.d.EXTRA_ENABLED, "setCardsEnabled", "(Z)V", "e0", "c0", "g0", "resId", "A0", "(I)V", "B0", "(Ljava/lang/String;)V", ExifInterface.LONGITUDE_WEST, "Lr6/r;", "binding", "Lr6/r;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "isOperationInProgress", "currentDialog", "Landroid/app/Dialog;", "isDismissing", "currentToastView", "Landroid/view/View;", "Ljava/lang/Runnable;", "dismissToastRunnable", "Ljava/lang/Runnable;", "cardPositionSpring", "Lcom/stepos/ailauncher/sheet/g0;", "cardFadeSpring", "cardExitFadeSpring", "com/stepos/ailauncher/task/space/RepairTabView$c", "scrimDimProperty", "Lcom/stepos/ailauncher/task/space/RepairTabView$c;", "onNavigateToMemory", "Lp9/a;", "getOnNavigateToMemory", "()Lp9/a;", "setOnNavigateToMemory", "(Lp9/a;)V", "onNavigateToThirdPartyAuth", "getOnNavigateToThirdPartyAuth", "setOnNavigateToThirdPartyAuth", "onNavigateToTestSpace", "getOnNavigateToTestSpace", "setOnNavigateToTestSpace", "TRACKER_PAGE_NAME", "Ljava/lang/String;", "TRACKER_PAGE_RESTART_EVENT", "TRACKER_PAGE_RESTART_CONFIRM_EVENT", "TRACKER_PAGE_AUTOFIX_EVENT", "TRACKER_PAGE_AUTOFIX_CONFIRM_EVENT", "TRACKER_PAGE_RESTORE_EVENT", "TRACKER_PAGE_RESTORE_CONFIRM_EVENT", "TRACKER_PAGE_MY_TASK_EVENT", "testSpaceExposeReported", "Companion", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RepairTabView extends LinearLayout {
    private static final long DELETE_MEMORY_ANIMATION_MS = 3000;
    private static final long FIX_ANIMATION_MS = 5000;
    private static final long RESTART_ANIMATION_MS = 5000;
    private static final long RESTORE_ANIMATION_MS = 15000;
    private static final String TAG = "AILauncher-RepairTab";
    private static final long TOAST_DURATION_MS = 2000;
    private final String TRACKER_PAGE_AUTOFIX_CONFIRM_EVENT;
    private final String TRACKER_PAGE_AUTOFIX_EVENT;
    private final String TRACKER_PAGE_MY_TASK_EVENT;
    private final String TRACKER_PAGE_NAME;
    private final String TRACKER_PAGE_RESTART_CONFIRM_EVENT;
    private final String TRACKER_PAGE_RESTART_EVENT;
    private final String TRACKER_PAGE_RESTORE_CONFIRM_EVENT;
    private final String TRACKER_PAGE_RESTORE_EVENT;
    private final r6.r binding;
    private final SheetSpring cardExitFadeSpring;
    private final SheetSpring cardFadeSpring;
    private final SheetSpring cardPositionSpring;
    private Dialog currentDialog;
    private View currentToastView;
    private final Runnable dismissToastRunnable;
    private final Handler handler;
    private boolean isDismissing;
    private boolean isOperationInProgress;
    private InterfaceC5063a<Y8.t> onNavigateToMemory;
    private InterfaceC5063a<Y8.t> onNavigateToTestSpace;
    private InterfaceC5063a<Y8.t> onNavigateToThirdPartyAuth;
    private final c scrimDimProperty;
    private boolean testSpaceExposeReported;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/task/space/RepairTabView$b", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AppUI.TYPE_WIDGET, "LY8/t;", "onClick", "(Landroid/view/View;)V", "Landroid/text/TextPaint;", Const.SP_KEY_DEVICE_SENSORS, "updateDrawState", "(Landroid/text/TextPaint;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends ClickableSpan {
        final /* synthetic */ InterfaceC5063a<Y8.t> $onClick;

        public b(InterfaceC5063a<Y8.t> interfaceC5063a) {
            this.$onClick = interfaceC5063a;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            kotlin.jvm.internal.p.i(widget, "widget");
            this.$onClick.invoke();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            kotlin.jvm.internal.p.i(ds, "ds");
            ds.setColor(-14652161);
            ds.setUnderlineText(false);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/task/space/RepairTabView$c", "Landroidx/dynamicanimation/animation/f;", "Landroid/view/View;", "view", "", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;)F", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/view/View;F)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends androidx.dynamicanimation.animation.f<View> {
        public c() {
            super("scrimDim");
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            kotlin.jvm.internal.p.i(view, "view");
            return (view.getBackground() != null ? r0.getAlpha() : 255) / 255.0f;
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float value) {
            kotlin.jvm.internal.p.i(view, "view");
            Drawable background = view.getBackground();
            if (background != null) {
                background.setAlpha(C5685n.n((int) (value * 255.0f), 0, 255));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RepairTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public static /* synthetic */ void D0(RepairTabView repairTabView, Dialog dialog, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        repairTabView.C0(dialog, z10);
    }

    public static final void E0(boolean z10, RepairTabView repairTabView, Dialog dialog, View view) {
        if (z10) {
            repairTabView.K(dialog);
        } else {
            dialog.dismiss();
        }
    }

    public static final void F0(View view) {
    }

    public static final void G0(RepairTabView repairTabView, DialogInterface dialogInterface) {
        repairTabView.currentDialog = null;
        repairTabView.isDismissing = false;
    }

    public static final boolean H0(RepairTabView repairTabView, Dialog dialog, DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return false;
        }
        if (keyEvent.getAction() == 1 && !repairTabView.isDismissing) {
            repairTabView.K(dialog);
        }
        return true;
    }

    public static final void J0(RepairTabView repairTabView, Dialog dialog, View view) {
        repairTabView.K(dialog);
    }

    public static final void K0(RepairTabView repairTabView, Dialog dialog, InterfaceC5063a interfaceC5063a, View view) {
        repairTabView.K(dialog);
        interfaceC5063a.invoke();
    }

    public static final Y8.t L(RepairTabView repairTabView, Dialog dialog, float f10) {
        repairTabView.m0(dialog, f10);
        return Y8.t.f7040a;
    }

    public static final Y8.t M(RepairTabView repairTabView, Dialog dialog) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            dialog.dismiss();
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "dismiss dialog failed", thE, false, 8, null);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t M0(RepairTabView repairTabView) {
        repairTabView.e0();
        return Y8.t.f7040a;
    }

    public static final Y8.t O(RepairTabView repairTabView, Dialog dialog, float f10) {
        repairTabView.m0(dialog, f10);
        return Y8.t.f7040a;
    }

    public static final void O0(RepairTabView repairTabView, Dialog dialog, View view) {
        repairTabView.K(dialog);
    }

    public static final void P0(RepairTabView repairTabView, Dialog dialog, View view) {
        repairTabView.K(dialog);
        repairTabView.g0();
    }

    public static final Y8.t R(RepairTabView repairTabView, String str) {
        repairTabView.Z(La.H.E1(str, 12298, 12299), "zlgnsq");
        return Y8.t.f7040a;
    }

    public static final void R0(Dialog dialog, View view) {
        dialog.dismiss();
    }

    public static final Y8.t S(RepairTabView repairTabView, String str) {
        repairTabView.Z(La.H.E1(str, 12298, 12299), "gnsqsf");
        return Y8.t.f7040a;
    }

    public static final void S0(Dialog dialog, RepairTabView repairTabView, View view) {
        dialog.dismiss();
        repairTabView.j0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ androidx.dynamicanimation.animation.i U0(RepairTabView repairTabView, View view, androidx.dynamicanimation.animation.f fVar, float f10, SheetSpring sheetSpring, InterfaceC5074l interfaceC5074l, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            interfaceC5074l = null;
        }
        if ((i10 & 32) != 0) {
            interfaceC5063a = null;
        }
        return repairTabView.T0(view, fVar, f10, sheetSpring, interfaceC5074l, interfaceC5063a);
    }

    public static final void V0(InterfaceC5074l interfaceC5074l, androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
        interfaceC5074l.invoke(Float.valueOf(f10));
    }

    public static final void W0(InterfaceC5063a interfaceC5063a, androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
        interfaceC5063a.invoke();
    }

    public static final void X(RepairTabView repairTabView) {
        repairTabView.W();
    }

    public static final Y8.t b0(InterfaceC5074l interfaceC5074l, Context context) {
        kotlin.jvm.internal.p.f(context);
        interfaceC5074l.invoke(context);
        return Y8.t.f7040a;
    }

    public static final void d0(RepairTabView repairTabView) {
        ImageView ivAutoFix = repairTabView.binding.ivAutoFix;
        kotlin.jvm.internal.p.h(ivAutoFix, "ivAutoFix");
        repairTabView.Y0(ivAutoFix, R$drawable.ic_repair_auto_fix);
        repairTabView.A0(R$string.repair_auto_fix_toast_done);
        repairTabView.setCardsEnabled(true);
    }

    public static final void f0(RepairTabView repairTabView) {
        ImageView ivRestart = repairTabView.binding.ivRestart;
        kotlin.jvm.internal.p.h(ivRestart, "ivRestart");
        repairTabView.Y0(ivRestart, R$drawable.ic_repair_restart);
        repairTabView.A0(R$string.repair_restart_toast_done);
        repairTabView.setCardsEnabled(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final Y8.t h0(final com.stepos.ailauncher.task.space.RepairTabView r5, java.lang.String r6, com.stepos.ailauncher.chat.model.ReInstallVMResult r7) {
        /*
            java.lang.String r0 = "result"
            kotlin.jvm.internal.p.i(r7, r0)
            boolean r0 = r7.isSuccess()
            if (r0 != 0) goto L77
            r6.r r6 = r5.binding
            android.widget.ImageView r6 = r6.ivRestore
            java.lang.String r0 = "ivRestore"
            kotlin.jvm.internal.p.h(r6, r0)
            int r0 = com.stepos.ailauncher.task.R$drawable.ic_repair_restore
            r5.Y0(r6, r0)
            r6 = 1
            r5.setCardsEnabled(r6)
            java.lang.String r0 = r7.getMsg()
            r1 = 0
            if (r0 == 0) goto L2f
            boolean r2 = La.H.x0(r0)
            if (r2 != 0) goto L2c
            goto L2d
        L2c:
            r0 = r1
        L2d:
            if (r0 != 0) goto L3e
        L2f:
            android.content.Context r0 = r5.getContext()
            int r2 = com.stepos.ailauncher.task.R$string.task_space_operation_failed
            java.lang.String r0 = r0.getString(r2)
            java.lang.String r2 = "getString(...)"
            kotlin.jvm.internal.p.h(r0, r2)
        L3e:
            int r7 = r7.getCode()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Restore rejected, code="
            r2.append(r3)
            r2.append(r7)
            java.lang.String r7 = ", message="
            r2.append(r7)
            r2.append(r0)
            java.lang.String r7 = r2.toString()
            r2 = 0
            r3 = 4
            java.lang.String r4 = "AILauncher-RepairTab"
            h8.C4148a.u(r4, r7, r2, r3, r1)
            r5.W()
            android.content.Context r5 = r5.getContext()
            android.content.Context r5 = r5.getApplicationContext()
            android.widget.Toast r5 = android.widget.Toast.makeText(r5, r0, r6)
            r5.show()
            Y8.t r5 = Y8.t.f7040a
            return r5
        L77:
            com.stepos.ailauncher.task.space.MemorySettingApi r7 = com.stepos.ailauncher.task.space.MemorySettingApi.INSTANCE
            r7.B(r6)
            android.os.Handler r6 = r5.handler
            com.stepos.ailauncher.task.space.g1 r7 = new com.stepos.ailauncher.task.space.g1
            r7.<init>()
            r0 = 15000(0x3a98, double:7.411E-320)
            r6.postDelayed(r7, r0)
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.space.RepairTabView.h0(com.stepos.ailauncher.task.space.RepairTabView, java.lang.String, com.stepos.ailauncher.chat.model.ReInstallVMResult):Y8.t");
    }

    public static final void i0(RepairTabView repairTabView) {
        ImageView ivRestore = repairTabView.binding.ivRestore;
        kotlin.jvm.internal.p.h(ivRestore, "ivRestore");
        repairTabView.Y0(ivRestore, R$drawable.ic_repair_restore);
        repairTabView.A0(R$string.repair_restore_toast_done);
        repairTabView.setCardsEnabled(true);
    }

    public static final void o0(RepairTabView repairTabView, View view) {
        InterfaceC5063a<Y8.t> interfaceC5063a = repairTabView.onNavigateToMemory;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final void p0(RepairTabView repairTabView, View view) {
        repairTabView.Y();
    }

    public static final void q0(RepairTabView repairTabView, View view) {
        repairTabView.a0(new RepairTabView$setupClickListeners$3$1(RepairWebActivity.INSTANCE));
    }

    public static final void r0(RepairTabView repairTabView, View view) {
        kotlin.N.a(repairTabView.TRACKER_PAGE_MY_TASK_EVENT, repairTabView.TRACKER_PAGE_NAME, kotlin.collections.a.i());
        repairTabView.a0(new RepairTabView$setupClickListeners$4$1(RepairWebActivity.INSTANCE));
    }

    public static final void s0(RepairTabView repairTabView, View view) {
        C3577a2.INSTANCE.d();
        InterfaceC5063a<Y8.t> interfaceC5063a = repairTabView.onNavigateToTestSpace;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    private final void setCardsEnabled(boolean enabled) {
        this.isOperationInProgress = !enabled;
        float f10 = enabled ? 1.0f : 0.5f;
        this.binding.cardRestart.setAlpha(f10);
        this.binding.cardAutoFix.setAlpha(f10);
        this.binding.cardRestore.setAlpha(f10);
    }

    public static final void t0(RepairTabView repairTabView, View view) {
        InterfaceC5063a<Y8.t> interfaceC5063a = repairTabView.onNavigateToThirdPartyAuth;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final void u0(RepairTabView repairTabView, View view) {
        if (repairTabView.isOperationInProgress) {
            return;
        }
        repairTabView.Q0();
    }

    public static final void v0(RepairTabView repairTabView, View view) {
        if (repairTabView.isOperationInProgress) {
            return;
        }
        repairTabView.L0();
    }

    public static final void w0(RepairTabView repairTabView, View view) {
        if (repairTabView.isOperationInProgress) {
            return;
        }
        repairTabView.y0();
    }

    public static final void x0(RepairTabView repairTabView, View view) {
        if (repairTabView.isOperationInProgress) {
            return;
        }
        repairTabView.N0();
    }

    public static final Y8.t z0(RepairTabView repairTabView) {
        repairTabView.c0();
        return Y8.t.f7040a;
    }

    public final void A0(int resId) {
        String string = getContext().getString(resId);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        B0(string);
    }

    public final void B0(String message) {
        Object objB;
        W();
        Object systemService = getContext().getSystemService("window");
        kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager windowManager = (WindowManager) systemService;
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.layout_repair_toast, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R$id.tv_toast_message)).setText(message);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2038, 24, -3);
        layoutParams.gravity = 81;
        layoutParams.y = (int) (80 * getContext().getResources().getDisplayMetrics().density);
        try {
            Result.Companion companion = Result.INSTANCE;
            windowManager.addView(viewInflate, layoutParams);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "showCustomToast addView failed", thE, false, 8, null);
        }
        if (Result.h(objB)) {
            this.currentToastView = viewInflate;
            this.handler.postDelayed(this.dismissToastRunnable, 2000L);
        }
    }

    public final void C0(final Dialog dialog, final boolean animated) {
        Object objB;
        View viewFindViewById = dialog.findViewById(R$id.fl_overlay);
        View viewFindViewById2 = dialog.findViewById(R$id.ll_card);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.V0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RepairTabView.E0(animated, this, dialog, view);
                }
            });
        }
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.W0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RepairTabView.F0(view);
                }
            });
        }
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.stepos.ailauncher.task.space.X0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                RepairTabView.G0(this.f28896a, dialogInterface);
            }
        });
        if (animated && viewFindViewById2 != null && viewFindViewById != null) {
            Window window = dialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(0);
            }
            viewFindViewById2.setTranslationY(T());
            viewFindViewById2.setAlpha(0.0f);
            Drawable background = viewFindViewById.getBackground();
            if (background != null) {
                background.setAlpha(0);
            }
            dialog.setCancelable(false);
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.stepos.ailauncher.task.space.Y0
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                    return RepairTabView.H0(this.f28898a, dialog, dialogInterface, i10, keyEvent);
                }
            });
        }
        this.currentDialog = dialog;
        try {
            Result.Companion companion = Result.INSTANCE;
            dialog.show();
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "show dialog failed", thE, false, 8, null);
        }
        if (!Result.h(objB) || !animated || viewFindViewById2 == null || viewFindViewById == null) {
            return;
        }
        N(dialog, viewFindViewById2, viewFindViewById);
    }

    public final void I0(String title, String message, final InterfaceC5063a<Y8.t> onConfirm) {
        final Dialog dialogV = V();
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.dialog_maintenance_confirm, (ViewGroup) null);
        dialogV.setContentView(viewInflate);
        ((TextView) viewInflate.findViewById(R$id.tv_title)).setText(title);
        ((TextView) viewInflate.findViewById(R$id.tv_message)).setText(message);
        TextView textView = (TextView) viewInflate.findViewById(R$id.btn_cancel);
        textView.setText(textView.getContext().getString(R$string.repair_dialog_cancel));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.T0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RepairTabView.J0(this.f28875a, dialogV, view);
            }
        });
        TextView textView2 = (TextView) viewInflate.findViewById(R$id.btn_confirm);
        textView2.setText(textView2.getContext().getString(R$string.repair_dialog_confirm));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.U0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RepairTabView.K0(this.f28882a, dialogV, onConfirm, view);
            }
        });
        C0(dialogV, true);
    }

    public final Activity J() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public final void K(final Dialog dialog) {
        Object objB;
        if (this.isDismissing) {
            return;
        }
        View viewFindViewById = dialog.findViewById(R$id.ll_card);
        View viewFindViewById2 = dialog.findViewById(R$id.fl_overlay);
        if (viewFindViewById != null && viewFindViewById2 != null) {
            this.isDismissing = true;
            e.s TRANSLATION_Y = androidx.dynamicanimation.animation.e.f13691o;
            kotlin.jvm.internal.p.h(TRANSLATION_Y, "TRANSLATION_Y");
            U0(this, viewFindViewById, TRANSLATION_Y, T(), this.cardPositionSpring, null, null, 48, null);
            U0(this, viewFindViewById2, this.scrimDimProperty, 0.0f, this.cardExitFadeSpring, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.R0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return RepairTabView.L(this.f28864a, dialog, ((Float) obj).floatValue());
                }
            }, null, 32, null);
            e.s ALPHA = androidx.dynamicanimation.animation.e.f13701y;
            kotlin.jvm.internal.p.h(ALPHA, "ALPHA");
            U0(this, viewFindViewById, ALPHA, 0.0f, this.cardExitFadeSpring, null, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.S0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return RepairTabView.M(this.f28871a, dialog);
                }
            }, 16, null);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            dialog.dismiss();
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "dismiss dialog failed", thE, false, 8, null);
        }
    }

    public final void L0() {
        String string = getContext().getString(R$string.repair_action_restart);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        String string2 = getContext().getString(R$string.repair_restart_message);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        I0(string, string2, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.M0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return RepairTabView.M0(this.f28837a);
            }
        });
        kotlin.N.a(this.TRACKER_PAGE_RESTART_EVENT, this.TRACKER_PAGE_NAME, kotlin.collections.a.i());
    }

    public final void N(final Dialog dialog, View card, View scrim) {
        e.s TRANSLATION_Y = androidx.dynamicanimation.animation.e.f13691o;
        kotlin.jvm.internal.p.h(TRANSLATION_Y, "TRANSLATION_Y");
        U0(this, card, TRANSLATION_Y, 0.0f, this.cardPositionSpring, null, null, 48, null);
        e.s ALPHA = androidx.dynamicanimation.animation.e.f13701y;
        kotlin.jvm.internal.p.h(ALPHA, "ALPHA");
        U0(this, card, ALPHA, 1.0f, this.cardFadeSpring, null, null, 48, null);
        U0(this, scrim, this.scrimDimProperty, 1.0f, this.cardFadeSpring, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.f1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RepairTabView.O(this.f29026a, dialog, ((Float) obj).floatValue());
            }
        }, null, 32, null);
    }

    public final void N0() {
        final Dialog dialogV = V();
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.dialog_restore_confirm, (ViewGroup) null);
        dialogV.setContentView(viewInflate);
        ((TextView) viewInflate.findViewById(R$id.btn_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.H0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RepairTabView.O0(this.f28802a, dialogV, view);
            }
        });
        ((TextView) viewInflate.findViewById(R$id.btn_confirm)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.I0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RepairTabView.P0(this.f28807a, dialogV, view);
            }
        });
        C0(dialogV, true);
        kotlin.N.a(this.TRACKER_PAGE_RESTORE_EVENT, this.TRACKER_PAGE_NAME, kotlin.collections.a.i());
    }

    public final void P(SpannableString sp, String full, String label, InterfaceC5063a<Y8.t> onClick) {
        int iU0 = La.H.u0(full, label, 0, false, 6, null);
        if (iU0 < 0) {
            return;
        }
        int length = label.length() + iU0;
        sp.setSpan(new b(onClick), iU0, length, 33);
        sp.setSpan(new AbsoluteSizeSpan(12, true), iU0, length, 33);
    }

    public final CharSequence Q() {
        String string = getContext().getString(R$string.revoke_dialog_protocol_intro);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        final String string2 = getContext().getString(R$string.revoke_protocol_step);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        final String string3 = getContext().getString(R$string.revoke_protocol_external);
        kotlin.jvm.internal.p.h(string3, "getString(...)");
        String str = string + "\n\n" + string2 + "\n\n" + string3;
        SpannableString spannableString = new SpannableString(str);
        P(spannableString, str, string2, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.O0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return RepairTabView.R(this.f28851a, string2);
            }
        });
        P(spannableString, str, string3, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.P0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return RepairTabView.S(this.f28856a, string3);
            }
        });
        return spannableString;
    }

    public final void Q0() {
        final Dialog dialogU = U();
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.dialog_agent_auth_revoke, (ViewGroup) null);
        dialogU.setContentView(viewInflate);
        TextView textView = (TextView) viewInflate.findViewById(R$id.tv_protocols);
        textView.setText(Q());
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        ((TextView) viewInflate.findViewById(R$id.btn_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.J0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RepairTabView.R0(dialogU, view);
            }
        });
        ((TextView) viewInflate.findViewById(R$id.btn_confirm)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.K0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RepairTabView.S0(dialogU, this, view);
            }
        });
        D0(this, dialogU, false, 2, null);
    }

    public final float T() {
        return getResources().getDisplayMetrics().widthPixels * 0.34013605f;
    }

    public final androidx.dynamicanimation.animation.i T0(View view, androidx.dynamicanimation.animation.f<View> property, float finalValue, SheetSpring spring, final InterfaceC5074l<? super Float, Y8.t> onUpdate, final InterfaceC5063a<Y8.t> onEnd) {
        androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(view, property);
        iVar.B(com.stepos.ailauncher.sheet.h0.d(spring, finalValue));
        if (property != androidx.dynamicanimation.animation.e.f13691o) {
            iVar.o(0.00390625f);
        }
        if (onUpdate != null) {
            iVar.c(new e.r() { // from class: com.stepos.ailauncher.task.space.d1
                @Override // androidx.dynamicanimation.animation.e.r
                public final void b(androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
                    RepairTabView.V0(onUpdate, eVar, f10, f11);
                }
            });
        }
        if (onEnd != null) {
            iVar.b(new e.q() { // from class: com.stepos.ailauncher.task.space.e1
                @Override // androidx.dynamicanimation.animation.e.q
                public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
                    RepairTabView.W0(onEnd, eVar, z10, f10, f11);
                }
            });
        }
        iVar.t();
        return iVar;
    }

    public final Dialog U() {
        Context contextJ = J();
        if (contextJ == null) {
            contextJ = getContext();
        }
        Dialog dialog = new Dialog(contextJ, R.style.Theme.Translucent.NoTitleBar);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
            window.setLayout(-1, -1);
        }
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        return dialog;
    }

    public final Dialog V() {
        Dialog dialog = new Dialog(getContext(), R.style.Theme.Translucent.NoTitleBar);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setType(2038);
            window.setBackgroundDrawableResource(R.color.transparent);
            window.setLayout(-1, -1);
            window.clearFlags(201326592);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarContrastEnforced(false);
            window.setNavigationBarContrastEnforced(false);
            window.setStatusBarColor(0);
            window.setNavigationBarColor(0);
        }
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        return dialog;
    }

    public final void W() {
        Object objB;
        this.handler.removeCallbacks(this.dismissToastRunnable);
        View view = this.currentToastView;
        if (view == null) {
            return;
        }
        this.currentToastView = null;
        Object systemService = getContext().getSystemService("window");
        kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager windowManager = (WindowManager) systemService;
        try {
            Result.Companion companion = Result.INSTANCE;
            windowManager.removeView(view);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "dismissCustomToast removeView failed", thE, false, 8, null);
        }
    }

    public final void X0(ImageView imageView) {
        imageView.setImageResource(R$drawable.ic_repair_loading_spinner);
        Object drawable = imageView.getDrawable();
        Animatable animatable = drawable instanceof Animatable ? (Animatable) drawable : null;
        if (animatable != null) {
            animatable.start();
        }
    }

    public final void Y() {
        try {
            Intent intentAddFlags = new Intent("stepos.intent.action.AGENT_SAFETY_CENTER_LAUNCHER").addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            kotlin.jvm.internal.p.h(intentAddFlags, "addFlags(...)");
            getContext().startActivity(intentAddFlags);
        } catch (Exception e10) {
            C4148a.t(TAG, "Failed to launch Agent Safety Center", e10, false, 8, null);
            B0("无法打开安全设置");
        }
    }

    public final void Y0(ImageView imageView, int originalIconRes) {
        Object drawable = imageView.getDrawable();
        Animatable animatable = drawable instanceof Animatable ? (Animatable) drawable : null;
        if (animatable != null) {
            animatable.stop();
        }
        imageView.setImageResource(originalIconRes);
    }

    public final void Z(String title, String category) {
        Object objB;
        Activity activityJ = J();
        if (activityJ == null) {
            C4148a.u(TAG, "openPolicy: no activity context", false, 4, null);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            com.stepos.ailauncher.chat.util.j.INSTANCE.f(activityJ, category, title);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "openPolicy failed", thE, false, 8, null);
        }
    }

    public final void a0(final InterfaceC5074l<? super Context, Y8.t> open) {
        Context contextJ = J();
        if (contextJ == null) {
            contextJ = getContext().getApplicationContext();
        }
        final Context context = contextJ;
        if (com.stepos.ailauncher.foundation.account.f.INSTANCE.v()) {
            kotlin.jvm.internal.p.f(context);
            open.invoke(context);
        } else {
            AuthManager authManager = AuthManager.INSTANCE;
            kotlin.jvm.internal.p.f(context);
            AuthManager.r1(authManager, context, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.N0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return RepairTabView.b0(open, context);
                }
            }, null, null, 12, null);
        }
    }

    public final void c0() {
        setCardsEnabled(false);
        A0(R$string.repair_auto_fix_toast_progress);
        C4148a.d(TAG, "Auto fix confirmed", false, 4, null);
        ImageView ivAutoFix = this.binding.ivAutoFix;
        kotlin.jvm.internal.p.h(ivAutoFix, "ivAutoFix");
        X0(ivAutoFix);
        ClawVMManager clawVMManagerA = ClawVMManager.INSTANCE.a();
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        clawVMManagerA.t(context);
        this.handler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.task.space.c1
            @Override // java.lang.Runnable
            public final void run() {
                RepairTabView.d0(this.f28938a);
            }
        }, 5000L);
        kotlin.N.a(this.TRACKER_PAGE_AUTOFIX_CONFIRM_EVENT, this.TRACKER_PAGE_NAME, kotlin.collections.a.i());
    }

    public final void e0() {
        setCardsEnabled(false);
        A0(R$string.repair_restart_toast_progress);
        C4148a.d(TAG, "Restart confirmed", false, 4, null);
        ImageView ivRestart = this.binding.ivRestart;
        kotlin.jvm.internal.p.h(ivRestart, "ivRestart");
        X0(ivRestart);
        ClawVMManager clawVMManagerA = ClawVMManager.INSTANCE.a();
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        clawVMManagerA.D(context);
        this.handler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.task.space.Z0
            @Override // java.lang.Runnable
            public final void run() {
                RepairTabView.f0(this.f28907a);
            }
        }, 5000L);
        kotlin.N.a(this.TRACKER_PAGE_RESTART_CONFIRM_EVENT, this.TRACKER_PAGE_NAME, kotlin.collections.a.i());
    }

    public final void g0() {
        if (this.isOperationInProgress) {
            return;
        }
        final String strK = com.stepos.ailauncher.foundation.account.f.INSTANCE.k();
        setCardsEnabled(false);
        A0(R$string.repair_restore_toast_progress);
        C4148a.d(TAG, "Restore confirmed, memory will be cleared", false, 4, null);
        ImageView ivRestore = this.binding.ivRestore;
        kotlin.jvm.internal.p.h(ivRestore, "ivRestore");
        X0(ivRestore);
        ClawVMManager clawVMManagerA = ClawVMManager.INSTANCE.a();
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        clawVMManagerA.A(context, ReInstallMode.FULL, "true", new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.a1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RepairTabView.h0(this.f28915a, strK, (ReInstallVMResult) obj);
            }
        });
        kotlin.N.a(this.TRACKER_PAGE_RESTORE_CONFIRM_EVENT, this.TRACKER_PAGE_NAME, kotlin.collections.a.i());
    }

    public final InterfaceC5063a<Y8.t> getOnNavigateToMemory() {
        return this.onNavigateToMemory;
    }

    public final InterfaceC5063a<Y8.t> getOnNavigateToTestSpace() {
        return this.onNavigateToTestSpace;
    }

    public final InterfaceC5063a<Y8.t> getOnNavigateToThirdPartyAuth() {
        return this.onNavigateToThirdPartyAuth;
    }

    public final void j0() {
        C4148a.d(TAG, "Revoke cross-device authorization confirmed", false, 4, null);
        C2215l.INSTANCE.c();
        l0();
        A0(R$string.revoke_toast_done);
    }

    public final void k0() {
        if (isAttachedToWindow() && !this.testSpaceExposeReported) {
            this.testSpaceExposeReported = true;
            C3577a2.INSTANCE.e();
        }
        this.binding.rowTestSpace.setVisibility(0);
        this.binding.dividerTestSpace.setVisibility(0);
    }

    public final void l0() {
        C2215l c2215l = C2215l.INSTANCE;
        this.binding.cardRevoke.setVisibility(c2215l.b() || c2215l.a() ? 0 : 8);
    }

    public final void m0(Dialog dialog, float fraction) {
        int iM = ((int) (51 * C5685n.m(fraction, 0.0f, 1.0f))) << 24;
        Window window = dialog.getWindow();
        if (window != null) {
            window.setStatusBarColor(iM);
            window.setNavigationBarColor(iM);
        }
    }

    public final void n0() {
        this.binding.rowMemory.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.Q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RepairTabView.o0(this.f28861a, view);
            }
        });
        this.binding.rowSafety.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.b1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RepairTabView.p0(this.f28927a, view);
            }
        });
        this.binding.rowSubscription.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.h1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RepairTabView.q0(this.f29034a, view);
            }
        });
        this.binding.rowMyTasks.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.i1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RepairTabView.r0(this.f29039a, view);
            }
        });
        this.binding.rowTestSpace.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.j1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RepairTabView.s0(this.f29045a, view);
            }
        });
        this.binding.cardThirdPartyAuth.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.k1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RepairTabView.t0(this.f29049a, view);
            }
        });
        this.binding.cardRevoke.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.l1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RepairTabView.u0(this.f29054a, view);
            }
        });
        this.binding.cardRestart.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.m1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RepairTabView.v0(this.f29060a, view);
            }
        });
        this.binding.cardAutoFix.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.n1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RepairTabView.w0(this.f29070a, view);
            }
        });
        this.binding.cardRestore.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.G0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RepairTabView.x0(this.f28799a, view);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        l0();
        k0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Dialog dialog = this.currentDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.currentDialog = null;
        this.testSpaceExposeReported = false;
    }

    public final void setOnNavigateToMemory(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onNavigateToMemory = interfaceC5063a;
    }

    public final void setOnNavigateToTestSpace(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onNavigateToTestSpace = interfaceC5063a;
    }

    public final void setOnNavigateToThirdPartyAuth(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onNavigateToThirdPartyAuth = interfaceC5063a;
    }

    public final void y0() {
        String string = getContext().getString(R$string.repair_action_auto_fix);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        String string2 = getContext().getString(R$string.repair_auto_fix_message);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        I0(string, string2, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.L0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return RepairTabView.z0(this.f28832a);
            }
        });
        kotlin.N.a(this.TRACKER_PAGE_AUTOFIX_EVENT, this.TRACKER_PAGE_NAME, kotlin.collections.a.i());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RepairTabView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        r6.r rVarB = r6.r.b(LayoutInflater.from(context), this, true);
        kotlin.jvm.internal.p.h(rVarB, "inflate(...)");
        this.binding = rVarB;
        this.handler = new Handler(Looper.getMainLooper());
        this.dismissToastRunnable = new Runnable() { // from class: com.stepos.ailauncher.task.space.F0
            @Override // java.lang.Runnable
            public final void run() {
                RepairTabView.X(this.f28796a);
            }
        };
        this.cardPositionSpring = new SheetSpring(322.27f, 0.8f);
        this.cardFadeSpring = SheetSpring.Companion.b(SheetSpring.INSTANCE, 400.0f, 40.0f, 0.0f, 4, null);
        this.cardExitFadeSpring = new SheetSpring(439.0f, 0.9f);
        this.scrimDimProperty = new c();
        this.TRACKER_PAGE_NAME = com.stepos.ailauncher.task.space.credential.P.ENTRY_REPAIR;
        this.TRACKER_PAGE_RESTART_EVENT = "repair_restart_click";
        this.TRACKER_PAGE_RESTART_CONFIRM_EVENT = "repair_restart_confirm_click";
        this.TRACKER_PAGE_AUTOFIX_EVENT = "repair_autofix_click";
        this.TRACKER_PAGE_AUTOFIX_CONFIRM_EVENT = "repair_auto_fix_confirm_click";
        this.TRACKER_PAGE_RESTORE_EVENT = "repair_restoredefault_click";
        this.TRACKER_PAGE_RESTORE_CONFIRM_EVENT = "repair_restoredefault_confirm_click";
        this.TRACKER_PAGE_MY_TASK_EVENT = "repair_mytask_click";
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        n0();
        l0();
        k0();
    }

    public /* synthetic */ RepairTabView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
