package com.stepos.ailauncher.chat.activity;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.activity.StepAssistantActivity;
import com.stepos.ailauncher.chat.broadcast.RecentsWindowMonitor;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.chat.manager.C2708m;
import com.stepos.ailauncher.chat.manager.ClawVMManager;
import com.stepos.ailauncher.chat.manager.InputViewManager;
import com.stepos.ailauncher.chat.view.C2940q8;
import com.stepos.ailauncher.chat.wake.WakeService;
import com.stepos.ailauncher.chat.widget.FigmaSlider;
import com.stepos.ailauncher.chat.widget.FigmaSwitch;
import com.stepos.ailauncher.foundation.account.AccountInfo;
import h8.C4148a;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import p7.AppUI;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import t5.C5511d;
import t5.C5512e;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0002P|\u0018\u0000 \u007f2\u00020\u0001:\u0002\u0080\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000f\u0010\u0003J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0019\u0010\u0017J\u000f\u0010\u001a\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001c\u0010\u0003J\r\u0010\u001d\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u0003J!\u0010 \u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\u0003J\u0019\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010#\u001a\u00020\u001eH\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u001eH\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010\u0003J\u000f\u0010+\u001a\u00020\u0012H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0012H\u0002¢\u0006\u0004\b-\u0010,J\u000f\u0010.\u001a\u00020\u0012H\u0002¢\u0006\u0004\b.\u0010,J\u000f\u0010/\u001a\u00020\u0006H\u0002¢\u0006\u0004\b/\u0010\u0003J\u000f\u00100\u001a\u00020\u0006H\u0002¢\u0006\u0004\b0\u0010\u0003J\u000f\u00101\u001a\u00020\u0006H\u0002¢\u0006\u0004\b1\u0010\u0003J\u000f\u00102\u001a\u00020\u0006H\u0002¢\u0006\u0004\b2\u0010\u0003J\u000f\u00103\u001a\u00020\u0006H\u0002¢\u0006\u0004\b3\u0010\u0003J\u000f\u00104\u001a\u00020\u0006H\u0002¢\u0006\u0004\b4\u0010\u0003J\u0017\u00106\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u0012H\u0002¢\u0006\u0004\b6\u0010\u0017J\u001f\u00108\u001a\u00020\u00062\u0006\u00107\u001a\u00020$2\u0006\u00105\u001a\u00020\u0012H\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0006H\u0002¢\u0006\u0004\b:\u0010\u0003J\u000f\u0010;\u001a\u00020\u0006H\u0002¢\u0006\u0004\b;\u0010\u0003J\u001d\u0010?\u001a\u00020>2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00060<H\u0002¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u0006H\u0002¢\u0006\u0004\bA\u0010\u0003J\u000f\u0010B\u001a\u00020\u0006H\u0002¢\u0006\u0004\bB\u0010\u0003J\u000f\u0010C\u001a\u00020\u0006H\u0002¢\u0006\u0004\bC\u0010\u0003J\u000f\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0004\bD\u0010\u0003J\u000f\u0010E\u001a\u00020\u0006H\u0002¢\u0006\u0004\bE\u0010\u0003J\u000f\u0010F\u001a\u00020\u0006H\u0002¢\u0006\u0004\bF\u0010\u0003J\u0017\u0010I\u001a\u00020\u00062\u0006\u0010H\u001a\u00020GH\u0002¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\u0006H\u0002¢\u0006\u0004\bK\u0010\u0003J\u000f\u0010L\u001a\u00020\u0006H\u0002¢\u0006\u0004\bL\u0010\u0003J\u000f\u0010M\u001a\u00020\u0006H\u0002¢\u0006\u0004\bM\u0010\u0003J\u000f\u0010N\u001a\u00020\u0006H\u0002¢\u0006\u0004\bN\u0010\u0003J\u000f\u0010O\u001a\u00020\u0006H\u0002¢\u0006\u0004\bO\u0010\u0003R\u0014\u0010Q\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010T\u001a\u00020S8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bV\u0010UR\u0016\u0010W\u001a\u00020S8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bW\u0010UR\u0016\u0010X\u001a\u00020S8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bX\u0010UR\u0016\u0010Y\u001a\u00020S8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bY\u0010UR\u0016\u0010Z\u001a\u00020$8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010\\\u001a\u00020S8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\\\u0010UR\u0016\u0010^\u001a\u00020]8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010`\u001a\u00020G8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010b\u001a\u00020G8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bb\u0010aR\u0016\u0010d\u001a\u00020c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010g\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010i\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010LR\u0016\u0010k\u001a\u00020j8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010m\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010LR\u0018\u0010n\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010p\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010s\u001a\u00020r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010u\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010qR\u0016\u0010v\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010LR\u0016\u0010w\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010LR\u0016\u0010x\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010LR\u0014\u0010z\u001a\u00020y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u0014\u0010}\u001a\u00020|8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010~¨\u0006\u0081\u0001"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/StepAssistantActivity;", "Lz5/a;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "outState", "onSaveInstanceState", "onResume", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "hasFocus", "onWindowFocusChanged", "(Z)V", "isTopResumedActivity", "onTopResumedActivityChanged", "onPause", "onUserLeaveHint", "onDestroy", "z0", "", "from", "M", "(Landroid/content/Intent;Ljava/lang/String;)V", "y0", "key", "Landroid/view/View;", "G0", "(Ljava/lang/String;)Landroid/view/View;", "reason", "H0", "(Ljava/lang/String;)V", "s0", "N0", "()Z", "x0", "w0", "b0", ExifInterface.LATITUDE_SOUTH, "O0", "A0", "D0", "u0", x5.d.EXTRA_ENABLED, "P0", "view", "I0", "(Landroid/view/View;Z)V", "L0", "Q0", "Lkotlin/Function0;", "onClick", "Landroid/text/style/ClickableSpan;", "t0", "(Lp9/a;)Landroid/text/style/ClickableSpan;", "o0", "U", "B0", "m0", "k0", "f0", "Landroid/widget/TextView;", "tv", "J0", "(Landroid/widget/TextView;)V", "d0", "Z", "F0", "E0", "C0", "com/stepos/ailauncher/chat/activity/StepAssistantActivity$c", "agentOpenedReceiver", "Lcom/stepos/ailauncher/chat/activity/StepAssistantActivity$c;", "Lcom/stepos/ailauncher/chat/widget/FigmaSwitch;", "swMainSwitch", "Lcom/stepos/ailauncher/chat/widget/FigmaSwitch;", "swAmooSpaceSwitch", "swNavigation", "swHeadset", "swExpress", "itemAmooExpressSupportedApps", "Landroid/view/View;", "swImprove", "Lcom/stepos/ailauncher/chat/widget/FigmaSlider;", "sbVolume", "Lcom/stepos/ailauncher/chat/widget/FigmaSlider;", "tvVoiceWakeupSummary", "Landroid/widget/TextView;", "tvSoundSummary", "Landroid/view/ViewGroup;", "contentContainer", "Landroid/view/ViewGroup;", "Landroid/app/Dialog;", "privacyDialog", "Landroid/app/Dialog;", "pendingEnableAfterLogin", "", "createdAtElapsed", "J", "userInteracted", "lastVoiceWakeupEnabled", "Ljava/lang/Boolean;", "lastVoiceName", "Ljava/lang/String;", "Lcom/stepos/ailauncher/chat/util/r;", "highlighter", "Lcom/stepos/ailauncher/chat/util/r;", "pendingSearchKey", "searchHighlightDone", "lostTopResumedToOtherActivity", "everHadWindowFocus", "Ljava/lang/Runnable;", "focusLostFinish", "Ljava/lang/Runnable;", "com/stepos/ailauncher/chat/activity/StepAssistantActivity$b", "accountCallback", "Lcom/stepos/ailauncher/chat/activity/StepAssistantActivity$b;", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StepAssistantActivity extends ActivityC6361a {
    public static final String ACTION_AGENT_OPENED_FROM_DIALOG = "com.stepos.ailauncher.chat.action.AGENT_OPENED_FROM_DIALOG";
    private static final String APP_REGISTRATION_NUMBER = "沪ICP备2026015011号-69A";
    private static final long EPHEMERAL_PAUSE_MS = 400;
    private static final String EVENT_CLICK_IN = "amoo_settings_click_in";
    private static final String EVENT_EARPHONE_WAKEUP = "amoo_settings_earphone_wakeup";
    private static final String EVENT_IMPROVE = "improve_amoo_assistant";
    private static final String EVENT_NAVIGATION_WAKEUP = "amoo_settings_navagation_wakeup";
    private static final String EVENT_SWITCH = "amoo_settings_switch";
    private static final String EVENT_TO_SECURITY = "amoo_settings_to_security";
    private static final String EVENT_VOICE_TIMBRE = "amoo_settings_voice_timbre";
    private static final String EVENT_WAKE_UP_SWITCH = "amoo_settings_wake_up_switch";
    private static final long FOCUS_GUARD_WINDOW_MS = 5000;
    private static final long FOCUS_LOST_GRACE_MS = 800;
    private static final String KEY_FEEDBACK_VOLUME = "voice_setting_feedback_volume";
    private static final String KEY_WAKEUP_HEADSET = "voice_setting_wakeup_headset";
    private static final String KEY_WAKEUP_NAVIGATION = "voice_setting_wakeup_navigation";
    private static final Map<String, Integer> SEARCH_KEY_FALLBACK;
    private static final Map<String, Integer> SEARCH_KEY_TO_ROW;
    private static final String STATE_SEARCH_HIGHLIGHT_DONE = "search_highlight_done";
    private static final String TAG = "StepAssistant";
    private static final String TRACKER_PAGE_NAME = "amoo_settings";
    private ViewGroup contentContainer;
    private long createdAtElapsed;
    private boolean everHadWindowFocus;
    private com.stepos.ailauncher.chat.util.r highlighter;
    private View itemAmooExpressSupportedApps;
    private String lastVoiceName;
    private Boolean lastVoiceWakeupEnabled;
    private boolean lostTopResumedToOtherActivity;
    private boolean pendingEnableAfterLogin;
    private String pendingSearchKey;
    private Dialog privacyDialog;
    private FigmaSlider sbVolume;
    private boolean searchHighlightDone;
    private FigmaSwitch swAmooSpaceSwitch;
    private FigmaSwitch swExpress;
    private FigmaSwitch swHeadset;
    private FigmaSwitch swImprove;
    private FigmaSwitch swMainSwitch;
    private FigmaSwitch swNavigation;
    private TextView tvSoundSummary;
    private TextView tvVoiceWakeupSummary;
    private boolean userInteracted;
    private final c agentOpenedReceiver = new c();
    private final Runnable focusLostFinish = new Runnable() { // from class: com.stepos.ailauncher.chat.activity.b2
        @Override // java.lang.Runnable
        public final void run() {
            StepAssistantActivity.v0(this.f24799a);
        }
    };
    private final b accountCallback = new b();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/activity/StepAssistantActivity$b", "Lcom/stepos/ailauncher/foundation/account/i;", "Lcom/stepos/ailauncher/foundation/account/a;", "accountInfo", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/foundation/account/a;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements com.stepos.ailauncher.foundation.account.i {
        public b() {
        }

        public static final void c(StepAssistantActivity stepAssistantActivity) throws Resources.NotFoundException {
            stepAssistantActivity.A0();
        }

        @Override // com.stepos.ailauncher.foundation.account.i
        public void a(AccountInfo accountInfo) {
            if (!StepAssistantActivity.this.pendingEnableAfterLogin || accountInfo == null) {
                return;
            }
            StepAssistantActivity.this.pendingEnableAfterLogin = false;
            final StepAssistantActivity stepAssistantActivity = StepAssistantActivity.this;
            stepAssistantActivity.runOnUiThread(new Runnable() { // from class: com.stepos.ailauncher.chat.activity.j2
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    StepAssistantActivity.b.c(stepAssistantActivity);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/activity/StepAssistantActivity$c", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws Resources.NotFoundException {
            if (kotlin.jvm.internal.p.d(intent != null ? intent.getAction() : null, StepAssistantActivity.ACTION_AGENT_OPENED_FROM_DIALOG)) {
                StepAssistantActivity.this.z0();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/chat/activity/StepAssistantActivity$d", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AppUI.TYPE_WIDGET, "LY8/t;", "onClick", "(Landroid/view/View;)V", "Landroid/text/TextPaint;", Const.SP_KEY_DEVICE_SENSORS, "updateDrawState", "(Landroid/text/TextPaint;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends ClickableSpan {
        final /* synthetic */ InterfaceC5063a<Y8.t> $onClick;

        public d(InterfaceC5063a<Y8.t> interfaceC5063a) {
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
            super.updateDrawState(ds);
            ds.setColor(-15304705);
            ds.setUnderlineText(false);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/stepos/ailauncher/chat/activity/StepAssistantActivity$e", "Lcom/stepos/ailauncher/chat/manager/AuthManager$a;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e implements AuthManager.a {
        public e() {
        }

        @Override // com.stepos.ailauncher.chat.manager.AuthManager.a
        public void a() {
        }

        @Override // com.stepos.ailauncher.chat.manager.AuthManager.a
        public void b() {
            StepAssistantActivity.this.u0();
            StepAssistantActivity.this.C0();
        }
    }

    static {
        Pair pairA = Y8.j.a(C5512e.MAIN, Integer.valueOf(R$id.itemMainSwitch));
        Pair pairA2 = Y8.j.a(C5512e.AMOO_SPACE, Integer.valueOf(R$id.itemAmooSpace));
        Pair pairA3 = Y8.j.a(C5512e.VOICE_WAKEUP, Integer.valueOf(R$id.itemVoiceWakeup));
        Pair pairA4 = Y8.j.a(C5512e.NAVIGATION_KEY, Integer.valueOf(R$id.itemNavigationKey));
        Pair pairA5 = Y8.j.a(C5512e.HEADSET_KEY, Integer.valueOf(R$id.itemHeadsetKey));
        int i10 = R$id.itemAmooExpress;
        SEARCH_KEY_TO_ROW = kotlin.collections.a.m(pairA, pairA2, pairA3, pairA4, pairA5, Y8.j.a(C5512e.AMOO_EXPRESS, Integer.valueOf(i10)), Y8.j.a(C5512e.SUPPORTED_APPS, Integer.valueOf(R$id.itemAmooExpressSupportedApps)), Y8.j.a(C5512e.SOUND, Integer.valueOf(R$id.itemSound)), Y8.j.a(C5512e.AI_SAFETY, Integer.valueOf(R$id.itemAiSafety)), Y8.j.a(C5512e.PRIVACY, Integer.valueOf(R$id.itemPrivacySetting)), Y8.j.a(C5512e.PERSONAL_INFO, Integer.valueOf(R$id.itemPersonalInfoList)), Y8.j.a(C5512e.THIRD_PARTY, Integer.valueOf(R$id.itemThirdPartyShare)), Y8.j.a("step_assistant_improve", Integer.valueOf(R$id.itemImproveAssistant)), Y8.j.a(C5512e.CHECK_UPDATE, Integer.valueOf(R$id.itemCheckUpdate)));
        SEARCH_KEY_FALLBACK = Z8.Q.f(Y8.j.a(C5512e.SUPPORTED_APPS, Integer.valueOf(i10)));
    }

    public static final Y8.t K0(StepAssistantActivity stepAssistantActivity, String str) {
        com.stepos.ailauncher.chat.util.j.INSTANCE.c(stepAssistantActivity, "ueip", str);
        return Y8.t.f7040a;
    }

    public static final Y8.t M0(StepAssistantActivity stepAssistantActivity, boolean z10) {
        stepAssistantActivity.Q0();
        return Y8.t.f7040a;
    }

    public static final void T(StepAssistantActivity stepAssistantActivity, View view) {
        FigmaSwitch figmaSwitch = stepAssistantActivity.swAmooSpaceSwitch;
        FigmaSwitch figmaSwitch2 = null;
        if (figmaSwitch == null) {
            kotlin.jvm.internal.p.A("swAmooSpaceSwitch");
            figmaSwitch = null;
        }
        boolean z10 = !figmaSwitch.getIsChecked();
        FigmaSwitch figmaSwitch3 = stepAssistantActivity.swAmooSpaceSwitch;
        if (figmaSwitch3 == null) {
            kotlin.jvm.internal.p.A("swAmooSpaceSwitch");
        } else {
            figmaSwitch2 = figmaSwitch3;
        }
        figmaSwitch2.setChecked(z10);
        C2708m.INSTANCE.b(z10);
    }

    public static final void V(StepAssistantActivity stepAssistantActivity, View view) {
        stepAssistantActivity.startActivity(SupportedAppsActivity.INSTANCE.a(stepAssistantActivity));
    }

    public static final void W(final StepAssistantActivity stepAssistantActivity, View view) throws Resources.NotFoundException {
        FigmaSwitch figmaSwitch = stepAssistantActivity.swExpress;
        if (figmaSwitch == null) {
            kotlin.jvm.internal.p.A("swExpress");
            figmaSwitch = null;
        }
        if (figmaSwitch.getIsChecked()) {
            com.stepos.ailauncher.chat.manager.U0.INSTANCE.v(false);
            stepAssistantActivity.B0();
            return;
        }
        if (!com.stepos.ailauncher.chat.manager.U0.INSTANCE.l()) {
            AuthManager authManager = AuthManager.INSTANCE;
            if (authManager.S()) {
                AuthManager.k1(authManager, stepAssistantActivity, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.Y1
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return StepAssistantActivity.X(this.f24788a);
                    }
                }, null, null, 12, null);
                return;
            }
        }
        AuthManager.INSTANCE.Q(stepAssistantActivity, false, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.Z1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return StepAssistantActivity.Y(this.f24791a);
            }
        });
    }

    public static final Y8.t X(StepAssistantActivity stepAssistantActivity) {
        stepAssistantActivity.B0();
        return Y8.t.f7040a;
    }

    public static final Y8.t Y(StepAssistantActivity stepAssistantActivity) {
        com.stepos.ailauncher.chat.manager.U0.INSTANCE.v(true);
        stepAssistantActivity.B0();
        return Y8.t.f7040a;
    }

    public static final void a0(StepAssistantActivity stepAssistantActivity, View view) {
        stepAssistantActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://beian.miit.gov.cn/")));
    }

    public static final void c0(StepAssistantActivity stepAssistantActivity, View view) throws Resources.NotFoundException {
        FigmaSwitch figmaSwitch = stepAssistantActivity.swMainSwitch;
        FigmaSwitch figmaSwitch2 = null;
        if (figmaSwitch == null) {
            kotlin.jvm.internal.p.A("swMainSwitch");
            figmaSwitch = null;
        }
        if (!figmaSwitch.getIsChecked()) {
            stepAssistantActivity.O0();
            return;
        }
        FigmaSwitch figmaSwitch3 = stepAssistantActivity.swMainSwitch;
        if (figmaSwitch3 == null) {
            kotlin.jvm.internal.p.A("swMainSwitch");
        } else {
            figmaSwitch2 = figmaSwitch3;
        }
        figmaSwitch2.setChecked(false);
        AuthManager.INSTANCE.N0(false);
        stepAssistantActivity.P0(false);
        ClawVMManager.INSTANCE.a().y(stepAssistantActivity, com.stepos.ailauncher.chat.trace.g.ACTION_STOP);
        kotlin.N.a(EVENT_SWITCH, TRACKER_PAGE_NAME, Z8.Q.f(Y8.j.a("switch_status", W4.a.ENABLE_OFF)));
    }

    public static final void e0(StepAssistantActivity stepAssistantActivity, View view) {
        Toast.makeText(stepAssistantActivity, R$string.step_assistant_lastest_version, 0).show();
    }

    public static final void g0(StepAssistantActivity stepAssistantActivity, View view) {
        stepAssistantActivity.startActivity(PrivacyDetailActivity.INSTANCE.a(stepAssistantActivity));
    }

    public static final void h0(StepAssistantActivity stepAssistantActivity, View view) {
        com.stepos.ailauncher.chat.util.j jVar = com.stepos.ailauncher.chat.util.j.INSTANCE;
        String string = stepAssistantActivity.getString(R$string.step_assistant_personal_info);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        jVar.c(stepAssistantActivity, "picl", string);
    }

    public static final void i0(StepAssistantActivity stepAssistantActivity, View view) {
        com.stepos.ailauncher.chat.util.j jVar = com.stepos.ailauncher.chat.util.j.INSTANCE;
        String string = stepAssistantActivity.getString(R$string.step_assistant_third_party);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        jVar.c(stepAssistantActivity, "tisl", string);
    }

    public static final void j0(StepAssistantActivity stepAssistantActivity, View view) {
        FigmaSwitch figmaSwitch = stepAssistantActivity.swImprove;
        if (figmaSwitch == null) {
            kotlin.jvm.internal.p.A("swImprove");
            figmaSwitch = null;
        }
        boolean isChecked = figmaSwitch.getIsChecked();
        boolean z10 = !isChecked;
        FigmaSwitch figmaSwitch2 = stepAssistantActivity.swImprove;
        if (figmaSwitch2 == null) {
            kotlin.jvm.internal.p.A("swImprove");
            figmaSwitch2 = null;
        }
        figmaSwitch2.setChecked(z10);
        AuthManager.INSTANCE.P0(z10);
        stepAssistantActivity.getContentResolver().notifyChange(C5511d.INSTANCE.a(), null);
        kotlin.N.a(EVENT_IMPROVE, TRACKER_PAGE_NAME, Z8.Q.f(Y8.j.a("switch_status", !isChecked ? W4.a.ENABLE_ON : W4.a.ENABLE_OFF)));
    }

    public static final void l0(StepAssistantActivity stepAssistantActivity, View view) {
        try {
            stepAssistantActivity.startActivity(new Intent("stepos.intent.action.AGENT_SAFETY_CENTER_LAUNCHER"));
            kotlin.N.a(EVENT_TO_SECURITY, TRACKER_PAGE_NAME, Z8.Q.f(Y8.j.a("in_status", "AI智能体安全")));
        } catch (Exception unused) {
            Toast.makeText(stepAssistantActivity, R$string.step_assistant_safety_unavailable, 0).show();
        }
    }

    public static final void n0(StepAssistantActivity stepAssistantActivity, View view) {
        stepAssistantActivity.startActivity(new Intent(stepAssistantActivity, (Class<?>) SoundSettingActivity.class));
    }

    public static final void p0(StepAssistantActivity stepAssistantActivity, View view) {
        stepAssistantActivity.startActivity(new Intent("com.stepos.ability.action.VOICE_WAKEUP_SETTING").setPackage("com.stepos.ability"));
    }

    public static final void q0(StepAssistantActivity stepAssistantActivity, View view) {
        FigmaSwitch figmaSwitch = stepAssistantActivity.swNavigation;
        FigmaSwitch figmaSwitch2 = null;
        if (figmaSwitch == null) {
            kotlin.jvm.internal.p.A("swNavigation");
            figmaSwitch = null;
        }
        boolean isChecked = figmaSwitch.getIsChecked();
        boolean z10 = !isChecked;
        FigmaSwitch figmaSwitch3 = stepAssistantActivity.swNavigation;
        if (figmaSwitch3 == null) {
            kotlin.jvm.internal.p.A("swNavigation");
        } else {
            figmaSwitch2 = figmaSwitch3;
        }
        figmaSwitch2.setChecked(z10);
        com.stepos.ailauncher.chat.manager.U0.INSTANCE.B(z10);
        kotlin.N.a(EVENT_NAVIGATION_WAKEUP, TRACKER_PAGE_NAME, Z8.Q.f(Y8.j.a("switch_status", !isChecked ? W4.a.ENABLE_ON : W4.a.ENABLE_OFF)));
    }

    public static final void r0(StepAssistantActivity stepAssistantActivity, View view) {
        FigmaSwitch figmaSwitch = stepAssistantActivity.swHeadset;
        FigmaSwitch figmaSwitch2 = null;
        if (figmaSwitch == null) {
            kotlin.jvm.internal.p.A("swHeadset");
            figmaSwitch = null;
        }
        boolean isChecked = figmaSwitch.getIsChecked();
        boolean z10 = !isChecked;
        FigmaSwitch figmaSwitch3 = stepAssistantActivity.swHeadset;
        if (figmaSwitch3 == null) {
            kotlin.jvm.internal.p.A("swHeadset");
        } else {
            figmaSwitch2 = figmaSwitch3;
        }
        figmaSwitch2.setChecked(z10);
        com.stepos.ailauncher.chat.manager.U0.INSTANCE.A(z10);
        kotlin.N.a(EVENT_EARPHONE_WAKEUP, TRACKER_PAGE_NAME, Z8.Q.f(Y8.j.a("switch_status", !isChecked ? W4.a.ENABLE_ON : W4.a.ENABLE_OFF)));
    }

    private final ClickableSpan t0(InterfaceC5063a<Y8.t> onClick) {
        return new d(onClick);
    }

    public static final void v0(StepAssistantActivity stepAssistantActivity) {
        if (stepAssistantActivity.isFinishing() || stepAssistantActivity.isChangingConfigurations() || stepAssistantActivity.userInteracted || stepAssistantActivity.hasWindowFocus() || stepAssistantActivity.everHadWindowFocus || stepAssistantActivity.N0()) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - stepAssistantActivity.createdAtElapsed;
        if (jElapsedRealtime > 5000) {
            return;
        }
        C4148a.k(TAG, "focus-lost finish aliveMs=" + jElapsedRealtime + " (no-focus ANR guard)", false, 4, null);
        stepAssistantActivity.finish();
    }

    public final void A0() throws Resources.NotFoundException {
        AuthManager authManager = AuthManager.INSTANCE;
        if (authManager.Y()) {
            u0();
        } else {
            authManager.m0();
            authManager.v1(this, true, false, new e());
        }
    }

    public final void B0() {
        boolean zM = com.stepos.ailauncher.chat.manager.U0.INSTANCE.m();
        FigmaSwitch figmaSwitch = this.swExpress;
        View view = null;
        if (figmaSwitch == null) {
            kotlin.jvm.internal.p.A("swExpress");
            figmaSwitch = null;
        }
        figmaSwitch.setChecked(zM);
        View view2 = this.itemAmooExpressSupportedApps;
        if (view2 == null) {
            kotlin.jvm.internal.p.A("itemAmooExpressSupportedApps");
        } else {
            view = view2;
        }
        view.setVisibility(zM ? 0 : 8);
    }

    public final void C0() {
        FigmaSwitch figmaSwitch = this.swImprove;
        if (figmaSwitch == null) {
            kotlin.jvm.internal.p.A("swImprove");
            figmaSwitch = null;
        }
        figmaSwitch.setChecked(AuthManager.INSTANCE.T());
    }

    public final void D0() {
        boolean zK = AuthManager.INSTANCE.K();
        FigmaSwitch figmaSwitch = this.swMainSwitch;
        if (figmaSwitch == null) {
            kotlin.jvm.internal.p.A("swMainSwitch");
            figmaSwitch = null;
        }
        figmaSwitch.setChecked(zK);
        P0(zK);
    }

    public final void E0() {
        String strK = com.stepos.ailauncher.chat.manager.U0.INSTANCE.k();
        TextView textView = this.tvSoundSummary;
        if (textView == null) {
            kotlin.jvm.internal.p.A("tvSoundSummary");
            textView = null;
        }
        textView.setText(La.H.x0(strK) ? getString(R$string.voice_setting_sound_default_persona) : strK);
        String str = this.lastVoiceName;
        if (str != null && !kotlin.jvm.internal.p.d(str, strK)) {
            String string = La.H.x0(strK) ? getString(R$string.voice_setting_sound_default_persona) : strK;
            kotlin.jvm.internal.p.f(string);
            kotlin.N.a(EVENT_VOICE_TIMBRE, TRACKER_PAGE_NAME, Z8.Q.f(Y8.j.a("voice_type", string)));
        }
        this.lastVoiceName = strK;
    }

    public final void F0() {
        boolean zS = com.stepos.ailauncher.chat.manager.U0.INSTANCE.s();
        TextView textView = this.tvVoiceWakeupSummary;
        if (textView == null) {
            kotlin.jvm.internal.p.A("tvVoiceWakeupSummary");
            textView = null;
        }
        textView.setText(zS ? R$string.voice_setting_state_on : R$string.voice_setting_state_off);
        Boolean bool = this.lastVoiceWakeupEnabled;
        if (bool != null && !kotlin.jvm.internal.p.d(bool, Boolean.valueOf(zS))) {
            kotlin.N.a(EVENT_WAKE_UP_SWITCH, TRACKER_PAGE_NAME, Z8.Q.f(Y8.j.a("switch_status", zS ? W4.a.ENABLE_ON : W4.a.ENABLE_OFF)));
        }
        this.lastVoiceWakeupEnabled = Boolean.valueOf(zS);
    }

    public final View G0(String key) {
        View viewFindViewById;
        View viewFindViewById2;
        Integer num = SEARCH_KEY_TO_ROW.get(key);
        if (num != null && (viewFindViewById2 = findViewById(num.intValue())) != null) {
            if (viewFindViewById2.getVisibility() != 0) {
                viewFindViewById2 = null;
            }
            if (viewFindViewById2 != null) {
                return viewFindViewById2;
            }
        }
        Integer num2 = SEARCH_KEY_FALLBACK.get(key);
        if (num2 == null || (viewFindViewById = findViewById(num2.intValue())) == null || viewFindViewById.getVisibility() != 0) {
            return null;
        }
        return viewFindViewById;
    }

    public final void H0(String reason) {
        Window window;
        View decorView;
        if (isFinishing() || isChangingConfigurations() || this.userInteracted || N0()) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.createdAtElapsed;
        if (jElapsedRealtime > 5000 || (window = getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.removeCallbacks(this.focusLostFinish);
        decorView.postDelayed(this.focusLostFinish, 800L);
        C4148a.d(TAG, "schedule focus-lost finish reason=" + reason + " aliveMs=" + jElapsedRealtime, false, 4, null);
    }

    public final void I0(View view, boolean enabled) {
        view.setEnabled(enabled);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                kotlin.jvm.internal.p.h(childAt, "getChildAt(...)");
                I0(childAt, enabled);
            }
        }
    }

    public final void J0(TextView tv) {
        String string = getString(R$string.step_assistant_improve_desc);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        final String string2 = getString(R$string.step_assistant_improve_plan_link);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        SpannableString spannableString = new SpannableString(string);
        int iU0 = La.H.u0(string, string2, 0, false, 6, null);
        if (iU0 >= 0) {
            spannableString.setSpan(t0(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.X1
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return StepAssistantActivity.K0(this.f24784a, string2);
                }
            }), iU0, string2.length() + iU0, 33);
        }
        tv.setText(spannableString);
        tv.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void L0() {
        InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.activity.c2
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepAssistantActivity.M0(this.f24803a, ((Boolean) obj).booleanValue());
            }
        };
        FigmaSwitch figmaSwitch = this.swMainSwitch;
        FigmaSwitch figmaSwitch2 = null;
        if (figmaSwitch == null) {
            kotlin.jvm.internal.p.A("swMainSwitch");
            figmaSwitch = null;
        }
        figmaSwitch.setOnCheckedChangeListener(interfaceC5074l);
        FigmaSwitch figmaSwitch3 = this.swAmooSpaceSwitch;
        if (figmaSwitch3 == null) {
            kotlin.jvm.internal.p.A("swAmooSpaceSwitch");
            figmaSwitch3 = null;
        }
        figmaSwitch3.setOnCheckedChangeListener(interfaceC5074l);
        FigmaSwitch figmaSwitch4 = this.swNavigation;
        if (figmaSwitch4 == null) {
            kotlin.jvm.internal.p.A("swNavigation");
            figmaSwitch4 = null;
        }
        figmaSwitch4.setOnCheckedChangeListener(interfaceC5074l);
        FigmaSwitch figmaSwitch5 = this.swHeadset;
        if (figmaSwitch5 == null) {
            kotlin.jvm.internal.p.A("swHeadset");
            figmaSwitch5 = null;
        }
        figmaSwitch5.setOnCheckedChangeListener(interfaceC5074l);
        FigmaSwitch figmaSwitch6 = this.swExpress;
        if (figmaSwitch6 == null) {
            kotlin.jvm.internal.p.A("swExpress");
            figmaSwitch6 = null;
        }
        figmaSwitch6.setOnCheckedChangeListener(interfaceC5074l);
        FigmaSwitch figmaSwitch7 = this.swImprove;
        if (figmaSwitch7 == null) {
            kotlin.jvm.internal.p.A("swImprove");
        } else {
            figmaSwitch2 = figmaSwitch7;
        }
        figmaSwitch2.setOnCheckedChangeListener(interfaceC5074l);
    }

    public final void M(Intent intent, String from) {
        String strA = C5512e.INSTANCE.a(intent);
        this.pendingSearchKey = strA;
        C4148a.k(TAG, "[search] " + from + " resolved key=" + strA, false, 4, null);
    }

    public final boolean N0() {
        return x0() || w0();
    }

    public final void O0() throws Resources.NotFoundException {
        if (com.stepos.ailauncher.foundation.account.f.INSTANCE.v()) {
            A0();
        } else {
            this.pendingEnableAfterLogin = true;
            ClawVMManager.INSTANCE.a().x(this);
        }
    }

    public final void P0(boolean enabled) {
        ViewGroup viewGroup = this.contentContainer;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            kotlin.jvm.internal.p.A("contentContainer");
            viewGroup = null;
        }
        viewGroup.setAlpha(enabled ? 1.0f : 0.5f);
        ViewGroup viewGroup3 = this.contentContainer;
        if (viewGroup3 == null) {
            kotlin.jvm.internal.p.A("contentContainer");
        } else {
            viewGroup2 = viewGroup3;
        }
        I0(viewGroup2, enabled);
    }

    public final void Q0() {
        Object systemService = getSystemService("vibrator");
        Vibrator vibrator = systemService instanceof Vibrator ? (Vibrator) systemService : null;
        if (vibrator == null) {
            return;
        }
        vibrator.vibrate(VibrationEffect.createOneShot(40L, -1));
    }

    public final void S() {
        View viewFindViewById = findViewById(R$id.itemAmooSpace);
        ((TextView) viewFindViewById.findViewById(R$id.tvSettingTitle)).setText(R$string.step_assistant_amoo_space_title);
        ((TextView) viewFindViewById.findViewById(R$id.tvSettingSummary)).setText(R$string.step_assistant_amoo_space_desc);
        View viewFindViewById2 = viewFindViewById.findViewById(R$id.swSetting);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        FigmaSwitch figmaSwitch = (FigmaSwitch) viewFindViewById2;
        this.swAmooSpaceSwitch = figmaSwitch;
        if (figmaSwitch == null) {
            kotlin.jvm.internal.p.A("swAmooSpaceSwitch");
            figmaSwitch = null;
        }
        figmaSwitch.setChecked(C2708m.INSTANCE.a());
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.a2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepAssistantActivity.T(this.f24795a, view);
            }
        });
    }

    public final void U() {
        View viewFindViewById = findViewById(R$id.itemAmooExpress);
        int i10 = R$id.tvSettingTitle;
        ((TextView) viewFindViewById.findViewById(i10)).setText(R$string.voice_setting_amoo_express);
        int i11 = R$id.tvSettingSummary;
        ((TextView) viewFindViewById.findViewById(i11)).setText(R$string.voice_setting_amoo_express_desc);
        View viewFindViewById2 = viewFindViewById.findViewById(R$id.swSetting);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        this.swExpress = (FigmaSwitch) viewFindViewById2;
        View viewFindViewById3 = findViewById(R$id.itemAmooExpressSupportedApps);
        kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
        this.itemAmooExpressSupportedApps = viewFindViewById3;
        View view = null;
        if (viewFindViewById3 == null) {
            kotlin.jvm.internal.p.A("itemAmooExpressSupportedApps");
            viewFindViewById3 = null;
        }
        ((TextView) viewFindViewById3.findViewById(i10)).setText(R$string.voice_setting_supported_apps);
        View view2 = this.itemAmooExpressSupportedApps;
        if (view2 == null) {
            kotlin.jvm.internal.p.A("itemAmooExpressSupportedApps");
            view2 = null;
        }
        ((TextView) view2.findViewById(i11)).setText(R$string.voice_setting_supported_apps_desc);
        View view3 = this.itemAmooExpressSupportedApps;
        if (view3 == null) {
            kotlin.jvm.internal.p.A("itemAmooExpressSupportedApps");
        } else {
            view = view3;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.e2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                StepAssistantActivity.V(this.f24814a, view4);
            }
        });
        B0();
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.f2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) throws Resources.NotFoundException {
                StepAssistantActivity.W(this.f24820a, view4);
            }
        });
    }

    public final void Z() {
        TextView textView = (TextView) findViewById(R$id.tvFooterIcp);
        textView.append(APP_REGISTRATION_NUMBER);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.P1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepAssistantActivity.a0(this.f24761a, view);
            }
        });
    }

    public final void b0() {
        View viewFindViewById = findViewById(R$id.itemMainSwitch);
        ((TextView) viewFindViewById.findViewById(R$id.tvSettingTitle)).setText(R$string.step_assistant_title);
        ((TextView) viewFindViewById.findViewById(R$id.tvSettingSummary)).setText(R$string.step_assistant_main_desc);
        View viewFindViewById2 = viewFindViewById.findViewById(R$id.swSetting);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        FigmaSwitch figmaSwitch = (FigmaSwitch) viewFindViewById2;
        this.swMainSwitch = figmaSwitch;
        if (figmaSwitch == null) {
            kotlin.jvm.internal.p.A("swMainSwitch");
            figmaSwitch = null;
        }
        figmaSwitch.setChecked(AuthManager.INSTANCE.K());
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.d2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                StepAssistantActivity.c0(this.f24810a, view);
            }
        });
    }

    public final void d0() {
        View viewFindViewById = findViewById(R$id.itemCheckUpdate);
        ((TextView) viewFindViewById.findViewById(R$id.tvSettingTitle)).setText(R$string.step_assistant_check_update);
        ((TextView) viewFindViewById.findViewById(R$id.tvSettingSummary)).setText(getString(R$string.step_assistant_current_version, C6.a.INSTANCE.b(this)));
        ImageView imageView = (ImageView) viewFindViewById.findViewById(R$id.ivArrowRight);
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.h2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepAssistantActivity.e0(this.f24827a, view);
            }
        });
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent ev) {
        kotlin.jvm.internal.p.i(ev, "ev");
        if (ev.getActionMasked() == 0) {
            this.userInteracted = true;
            s0();
        }
        return super.dispatchTouchEvent(ev);
    }

    public final void f0() {
        View viewFindViewById = findViewById(R$id.itemPrivacySetting);
        int i10 = R$id.tvSettingTitle;
        ((TextView) viewFindViewById.findViewById(i10)).setText(R$string.step_assistant_privacy_setting);
        int i11 = R$id.tvSettingSummary;
        ((TextView) viewFindViewById.findViewById(i11)).setVisibility(8);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.S1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepAssistantActivity.g0(this.f24769a, view);
            }
        });
        View viewFindViewById2 = findViewById(R$id.itemPersonalInfoList);
        ((TextView) viewFindViewById2.findViewById(i10)).setText(R$string.step_assistant_personal_info);
        ((TextView) viewFindViewById2.findViewById(i11)).setVisibility(8);
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.T1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepAssistantActivity.h0(this.f24772a, view);
            }
        });
        View viewFindViewById3 = findViewById(R$id.itemThirdPartyShare);
        ((TextView) viewFindViewById3.findViewById(i10)).setText(R$string.step_assistant_third_party);
        ((TextView) viewFindViewById3.findViewById(i11)).setVisibility(8);
        viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.U1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepAssistantActivity.i0(this.f24775a, view);
            }
        });
        View viewFindViewById4 = findViewById(R$id.itemImproveAssistant);
        ((TextView) viewFindViewById4.findViewById(i10)).setText(R$string.step_assistant_improve_title);
        TextView textView = (TextView) viewFindViewById4.findViewById(i11);
        kotlin.jvm.internal.p.f(textView);
        J0(textView);
        View viewFindViewById5 = viewFindViewById4.findViewById(R$id.swSetting);
        kotlin.jvm.internal.p.h(viewFindViewById5, "findViewById(...)");
        FigmaSwitch figmaSwitch = (FigmaSwitch) viewFindViewById5;
        this.swImprove = figmaSwitch;
        if (figmaSwitch == null) {
            kotlin.jvm.internal.p.A("swImprove");
            figmaSwitch = null;
        }
        figmaSwitch.setChecked(AuthManager.INSTANCE.T());
        viewFindViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.V1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepAssistantActivity.j0(this.f24778a, view);
            }
        });
    }

    public final void k0() {
        View viewFindViewById = findViewById(R$id.itemAiSafety);
        ((TextView) viewFindViewById.findViewById(R$id.tvSettingTitle)).setText(R$string.step_assistant_ai_safety);
        ((TextView) viewFindViewById.findViewById(R$id.tvSettingSummary)).setVisibility(8);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.g2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepAssistantActivity.l0(this.f24823a, view);
            }
        });
    }

    public final void m0() {
        View viewFindViewById = findViewById(R$id.itemSound);
        ((TextView) viewFindViewById.findViewById(R$id.tvSettingTitle)).setText(R$string.voice_setting_sound);
        View viewFindViewById2 = viewFindViewById.findViewById(R$id.tvSettingSummary);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        this.tvSoundSummary = (TextView) viewFindViewById2;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.W1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepAssistantActivity.n0(this.f24781a, view);
            }
        });
    }

    public final void o0() {
        View viewFindViewById = findViewById(R$id.itemVoiceWakeup);
        int i10 = R$id.tvSettingTitle;
        ((TextView) viewFindViewById.findViewById(i10)).setText(R$string.voice_setting_voice_wakeup);
        int i11 = R$id.tvSettingSummary;
        View viewFindViewById2 = viewFindViewById.findViewById(i11);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        this.tvVoiceWakeupSummary = (TextView) viewFindViewById2;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.i2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepAssistantActivity.p0(this.f24834a, view);
            }
        });
        View viewFindViewById3 = findViewById(R$id.itemNavigationKey);
        ((TextView) viewFindViewById3.findViewById(i10)).setText(R$string.voice_setting_navigation_key);
        ((TextView) viewFindViewById3.findViewById(i11)).setText(R$string.voice_setting_navigation_key_desc);
        int i12 = R$id.swSetting;
        View viewFindViewById4 = viewFindViewById3.findViewById(i12);
        kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
        FigmaSwitch figmaSwitch = (FigmaSwitch) viewFindViewById4;
        this.swNavigation = figmaSwitch;
        FigmaSwitch figmaSwitch2 = null;
        if (figmaSwitch == null) {
            kotlin.jvm.internal.p.A("swNavigation");
            figmaSwitch = null;
        }
        com.stepos.ailauncher.chat.manager.U0 u02 = com.stepos.ailauncher.chat.manager.U0.INSTANCE;
        figmaSwitch.setChecked(u02.r());
        viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.Q1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepAssistantActivity.q0(this.f24765a, view);
            }
        });
        View viewFindViewById5 = findViewById(R$id.itemHeadsetKey);
        ((TextView) viewFindViewById5.findViewById(i10)).setText(R$string.voice_setting_headset_key);
        ((TextView) viewFindViewById5.findViewById(i11)).setText(R$string.voice_setting_headset_key_desc);
        View viewFindViewById6 = viewFindViewById5.findViewById(i12);
        kotlin.jvm.internal.p.h(viewFindViewById6, "findViewById(...)");
        FigmaSwitch figmaSwitch3 = (FigmaSwitch) viewFindViewById6;
        this.swHeadset = figmaSwitch3;
        if (figmaSwitch3 == null) {
            kotlin.jvm.internal.p.A("swHeadset");
        } else {
            figmaSwitch2 = figmaSwitch3;
        }
        figmaSwitch2.setChecked(u02.q());
        viewFindViewById5.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.R1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepAssistantActivity.r0(this.f24767a, view);
            }
        });
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.createdAtElapsed = SystemClock.elapsedRealtime();
        setContentView(R$layout.activity_step_assistant);
        C2940q8.d(C2940q8.INSTANCE, this, R$string.step_assistant_title, null, 4, null);
        View viewFindViewById = findViewById(R$id.contentContainer);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        this.contentContainer = (ViewGroup) viewFindViewById;
        View viewFindViewById2 = findViewById(R$id.settingsScroll);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        this.highlighter = new com.stepos.ailauncher.chat.util.r((ScrollView) viewFindViewById2);
        b0();
        S();
        o0();
        U();
        m0();
        k0();
        f0();
        d0();
        Z();
        L0();
        FigmaSwitch figmaSwitch = this.swMainSwitch;
        if (figmaSwitch == null) {
            kotlin.jvm.internal.p.A("swMainSwitch");
            figmaSwitch = null;
        }
        P0(figmaSwitch.getIsChecked());
        com.stepos.ailauncher.foundation.account.f.INSTANCE.z(this.accountCallback);
        registerReceiver(this.agentOpenedReceiver, new IntentFilter(ACTION_AGENT_OPENED_FROM_DIALOG), 4);
        kotlin.N.a(EVENT_CLICK_IN, TRACKER_PAGE_NAME, Z8.Q.f(Y8.j.a("in_status", "小跃助手设置页")));
        boolean z10 = false;
        if (savedInstanceState != null && savedInstanceState.getBoolean(STATE_SEARCH_HIGHLIGHT_DONE)) {
            z10 = true;
        }
        this.searchHighlightDone = z10;
        M(getIntent(), "onCreate");
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        s0();
        com.stepos.ailauncher.chat.util.r rVar = this.highlighter;
        if (rVar == null) {
            kotlin.jvm.internal.p.A("highlighter");
            rVar = null;
        }
        rVar.d();
        com.stepos.ailauncher.foundation.account.f.INSTANCE.C(this.accountCallback);
        try {
            Result.Companion companion = Result.INSTANCE;
            unregisterReceiver(this.agentOpenedReceiver);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        Dialog dialog = this.privacyDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.privacyDialog = null;
        AuthManager.INSTANCE.m0();
        super.onDestroy();
    }

    @Override // b.q, android.app.Activity
    public void onNewIntent(Intent intent) {
        kotlin.jvm.internal.p.i(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        this.searchHighlightDone = false;
        M(intent, "onNewIntent");
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onPause() {
        s0();
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.createdAtElapsed;
        if (!isFinishing() && !isChangingConfigurations() && !this.userInteracted && !N0() && jElapsedRealtime < 400) {
            C4148a.k(TAG, "ephemeral finish aliveMs=" + jElapsedRealtime + " (no-focus guard)", false, 4, null);
            finish();
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onResume() {
        super.onResume();
        AuthManager.INSTANCE.Q0(false);
        D0();
        F0();
        E0();
        C0();
        B0();
        y0();
    }

    @Override // b.q, androidx.core.app.f, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.p.i(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean(STATE_SEARCH_HIGHLIGHT_DONE, this.searchHighlightDone);
    }

    @Override // android.app.Activity
    public void onTopResumedActivityChanged(boolean isTopResumedActivity) {
        super.onTopResumedActivityChanged(isTopResumedActivity);
        if (isTopResumedActivity) {
            this.lostTopResumedToOtherActivity = false;
            s0();
        } else {
            this.lostTopResumedToOtherActivity = true;
            s0();
        }
    }

    @Override // b.q, android.app.Activity
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        AuthManager authManager = AuthManager.INSTANCE;
        if (authManager.z0()) {
            return;
        }
        authManager.m0();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (!hasFocus) {
            H0("windowFocusLost");
            return;
        }
        this.everHadWindowFocus = true;
        C4148a.k(TAG, "onWindowFocusChanged, everHadWindowFocus is true", false, 4, null);
        s0();
    }

    public final void s0() {
        View decorView;
        Window window = getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.removeCallbacks(this.focusLostFinish);
    }

    public final void u0() {
        FigmaSwitch figmaSwitch = this.swMainSwitch;
        if (figmaSwitch == null) {
            kotlin.jvm.internal.p.A("swMainSwitch");
            figmaSwitch = null;
        }
        figmaSwitch.setChecked(true);
        AuthManager.INSTANCE.N0(true);
        P0(true);
        ClawVMManager.INSTANCE.a().y(this, "start");
        kotlin.N.a(EVENT_SWITCH, TRACKER_PAGE_NAME, Z8.Q.f(Y8.j.a("switch_status", W4.a.ENABLE_ON)));
    }

    public final boolean w0() {
        return this.lostTopResumedToOtherActivity || WakeService.INSTANCE.K0() || InputViewManager.INSTANCE.y0() != null;
    }

    public final boolean x0() {
        RecentsWindowMonitor.RecentsState recentsStateH = RecentsWindowMonitor.INSTANCE.h();
        return recentsStateH == RecentsWindowMonitor.RecentsState.PEEK || recentsStateH == RecentsWindowMonitor.RecentsState.OVERVIEW;
    }

    public final void y0() {
        String str;
        if (this.searchHighlightDone || (str = this.pendingSearchKey) == null) {
            return;
        }
        com.stepos.ailauncher.chat.util.r rVar = null;
        this.pendingSearchKey = null;
        this.searchHighlightDone = true;
        View viewG0 = G0(str);
        if (viewG0 == null) {
            C4148a.k(TAG, "[search] no visible row for key=" + str + ", skip highlight", false, 4, null);
            return;
        }
        com.stepos.ailauncher.chat.util.r rVar2 = this.highlighter;
        if (rVar2 == null) {
            kotlin.jvm.internal.p.A("highlighter");
        } else {
            rVar = rVar2;
        }
        rVar.e(viewG0);
    }

    public final void z0() throws Resources.NotFoundException {
        FigmaSwitch figmaSwitch = this.swMainSwitch;
        if (figmaSwitch == null) {
            kotlin.jvm.internal.p.A("swMainSwitch");
            figmaSwitch = null;
        }
        figmaSwitch.setChecked(true);
        O0();
    }
}
