package com.stepos.ailauncher.chat.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.provider.Settings;
import android.view.InterfaceC1387e;
import android.view.LifecycleOwner;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.widget.FigmaSlider;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.contract.api.express.IExpressService;
import h8.C4148a;
import java.util.Arrays;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import o6.C5009a;
import r9.C5227b;
import v9.C5685n;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0011¢\u0006\u0004\b\u0018\u0010\u0013J\u0015\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u0019\u0010\u0017J\r\u0010\u001a\u001a\u00020\u0011¢\u0006\u0004\b\u001a\u0010\u0013J\u0015\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u001b\u0010\u0017J\r\u0010\u001c\u001a\u00020\n¢\u0006\u0004\b\u001c\u0010\u0003J\r\u0010\u001d\u001a\u00020\u0011¢\u0006\u0004\b\u001d\u0010\u0013J\u0015\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0011¢\u0006\u0004\b\u001f\u0010\u0017J\u0015\u0010!\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\r¢\u0006\u0004\b!\u0010\"J\u001d\u0010#\u001a\u00020\n2\u0006\u0010 \u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u0011¢\u0006\u0004\b%\u0010\u0013J\u0015\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0011¢\u0006\u0004\b'\u0010\u0017J\r\u0010(\u001a\u00020\r¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\r¢\u0006\u0004\b*\u0010)J\u001d\u0010,\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\u0011¢\u0006\u0004\b.\u0010\u0013J\u0015\u0010/\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b/\u0010\bJ\u001d\u00100\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b0\u0010\fJ\u0015\u00102\u001a\u0002012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b2\u00103J\u001d\u00108\u001a\u00020\n2\u0006\u00105\u001a\u0002042\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J\u0015\u0010:\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b>\u0010=R\u0014\u0010?\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b?\u0010=R\u0014\u0010@\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b@\u0010=R\u0014\u0010A\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\bA\u0010=R\u0014\u0010B\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\bB\u0010=R\u0014\u0010C\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\bC\u0010=R\u0014\u0010D\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\bD\u0010=R\u0014\u0010E\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\bE\u0010=R\u0014\u0010F\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\bH\u0010=R\u0014\u0010I\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\bI\u0010=R\u0014\u0010J\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\bJ\u0010=R\u0016\u0010K\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010=R\u0014\u0010L\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\bL\u0010=R\u0014\u0010M\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\bM\u0010=R\u0014\u0010N\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\bN\u0010=¨\u0006O"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/U0;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/content/Context;)I", "percent", "LY8/t;", "c", "(Landroid/content/Context;I)V", "", "voiceId", "w", "(Ljava/lang/String;)V", "", "s", "()Z", "r", x5.d.EXTRA_ENABLED, "B", "(Z)V", "q", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "m", "v", "t", "l", "accepted", "u", "pkg", "n", "(Ljava/lang/String;)Z", "x", "(Ljava/lang/String;Z)V", "o", "used", "y", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Ljava/lang/String;", "k", "voiceName", "C", "(Ljava/lang/String;Ljava/lang/String;)V", "p", Const.INTENT_KEY_BACKGROUND_COMMAND, "z", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/content/Context;)F", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/stepos/ailauncher/chat/widget/FigmaSlider;", "slider", "e", "(Landroidx/lifecycle/LifecycleOwner;Lcom/stepos/ailauncher/chat/widget/FigmaSlider;)V", Const.INTENT_KEY_UMID, "(Landroid/content/Context;)V", "TAG", "Ljava/lang/String;", "ACTION_VOLUME_CHANGED", "EXTRA_VOLUME_STREAM_TYPE", "KEY_WAKEUP_NAVIGATION", "KEY_WAKEUP_HEADSET", "KEY_AMOO_EXPRESS", "KEY_AMOO_EXPRESS_ACCEPTED", "KEY_FEEDBACK_VOLUME", "KEY_FEEDBACK_VOLUME_SYNC_SYSTEM", "DEFAULT_FEEDBACK_VOLUME_PERCENT", "I", "KEY_SELECTED_VOICE_ID", "KEY_SELECTED_VOICE_NAME", "LEGACY_KEY_TTS_VOICE_ID", "defaultVoiceId", "KEY_EXPRESS_APP_PREFIX", "KEY_EXPRESS_TIP_COUNT", "KEY_EXPRESS_USED", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class U0 {
    private static final String ACTION_VOLUME_CHANGED = "android.media.VOLUME_CHANGED_ACTION";
    private static final int DEFAULT_FEEDBACK_VOLUME_PERCENT = 100;
    private static final String EXTRA_VOLUME_STREAM_TYPE = "android.media.EXTRA_VOLUME_STREAM_TYPE";
    public static final String KEY_AMOO_EXPRESS = "voice_setting_amoo_express";
    public static final String KEY_AMOO_EXPRESS_ACCEPTED = "voice_setting_amoo_express_accepted";
    private static final String KEY_EXPRESS_APP_PREFIX = "voice_setting_express_app_";
    private static final String KEY_EXPRESS_TIP_COUNT = "voice_setting_express_tip_count";
    private static final String KEY_EXPRESS_USED = "voice_setting_express_used";
    public static final String KEY_FEEDBACK_VOLUME = "voice_setting_feedback_volume";
    public static final String KEY_FEEDBACK_VOLUME_SYNC_SYSTEM = "voice_setting_feedback_volume_sync_system";
    public static final String KEY_SELECTED_VOICE_ID = "voice_setting_selected_voice_id";
    public static final String KEY_SELECTED_VOICE_NAME = "voice_setting_selected_voice_name";
    public static final String KEY_WAKEUP_HEADSET = "voice_setting_wakeup_headset";
    public static final String KEY_WAKEUP_NAVIGATION = "voice_setting_wakeup_navigation";
    private static final String LEGACY_KEY_TTS_VOICE_ID = "tts_voice_id";
    private static final String TAG = "VoiceAssistantSettings";
    public static final U0 INSTANCE = new U0();
    private static volatile String defaultVoiceId = "zhaoqixiaoduo";

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/chat/manager/U0$a", "Landroidx/lifecycle/e;", "Landroidx/lifecycle/LifecycleOwner;", "o", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroidx/lifecycle/LifecycleOwner;)V", "onDestroy", "", "registered", "Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements InterfaceC1387e {
        final /* synthetic */ Context $context;
        final /* synthetic */ b $receiver;
        private boolean registered;

        public a(Context context, b bVar) {
            this.$context = context;
            this.$receiver = bVar;
        }

        @Override // android.view.InterfaceC1387e
        public void b(LifecycleOwner o10) {
            kotlin.jvm.internal.p.i(o10, "o");
            this.$context.registerReceiver(this.$receiver, new IntentFilter(U0.ACTION_VOLUME_CHANGED), 2);
            this.registered = true;
        }

        @Override // android.view.InterfaceC1387e
        public void onDestroy(LifecycleOwner o10) {
            kotlin.jvm.internal.p.i(o10, "o");
            if (this.registered) {
                Context context = this.$context;
                b bVar = this.$receiver;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    context.unregisterReceiver(bVar);
                    Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.b(C4849c.a(th));
                }
                this.registered = false;
            }
        }

        @Override // android.view.InterfaceC1387e
        public /* bridge */ void onPause(LifecycleOwner lifecycleOwner) {
            super.onPause(lifecycleOwner);
        }

        @Override // android.view.InterfaceC1387e
        public /* bridge */ void onResume(LifecycleOwner lifecycleOwner) {
            super.onResume(lifecycleOwner);
        }

        @Override // android.view.InterfaceC1387e
        public /* bridge */ void onStart(LifecycleOwner lifecycleOwner) {
            super.onStart(lifecycleOwner);
        }

        @Override // android.view.InterfaceC1387e
        public /* bridge */ void onStop(LifecycleOwner lifecycleOwner) {
            super.onStop(lifecycleOwner);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/manager/U0$b", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "ctx", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends BroadcastReceiver {
        final /* synthetic */ FigmaSlider $slider;

        public b(FigmaSlider figmaSlider) {
            this.$slider = figmaSlider;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context ctx, Intent intent) {
            kotlin.jvm.internal.p.i(ctx, "ctx");
            kotlin.jvm.internal.p.i(intent, "intent");
            if (kotlin.jvm.internal.p.d(intent.getAction(), U0.ACTION_VOLUME_CHANGED)) {
                U0 u02 = U0.INSTANCE;
                if (u02.p() && intent.getIntExtra(U0.EXTRA_VOLUME_STREAM_TYPE, -1) == 3) {
                    int iH = u02.h(ctx);
                    if (this.$slider.getProgress() != iH) {
                        this.$slider.setProgress(iH);
                    }
                    C5009a.B(C5009a.INSTANCE, U0.KEY_FEEDBACK_VOLUME, iH, false, 4, null);
                }
            }
        }
    }

    public static final Y8.t f(Context context, int i10, boolean z10) {
        if (z10) {
            U0 u02 = INSTANCE;
            kotlin.jvm.internal.p.f(context);
            u02.z(context, i10);
            u02.d(context);
        }
        return Y8.t.f7040a;
    }

    public final void A(boolean enabled) {
        C5009a.y(C5009a.INSTANCE, KEY_WAKEUP_HEADSET, enabled, false, 4, null);
    }

    public final void B(boolean enabled) {
        C5009a.y(C5009a.INSTANCE, KEY_WAKEUP_NAVIGATION, enabled, false, 4, null);
    }

    public final void C(String voiceId, String voiceName) {
        kotlin.jvm.internal.p.i(voiceId, "voiceId");
        kotlin.jvm.internal.p.i(voiceName, "voiceName");
        C5009a c5009a = C5009a.INSTANCE;
        C5009a.G(c5009a, "voice_setting_selected_voice_id", voiceId, false, 4, null);
        C5009a.G(c5009a, "voice_setting_selected_voice_name", voiceName, false, 4, null);
        c5009a.F(LEGACY_KEY_TTS_VOICE_ID, voiceId, false);
    }

    public final void c(Context context, int percent) {
        Object systemService = context.getSystemService("audio");
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        if (audioManager == null) {
            return;
        }
        int iN = C5685n.n(C5227b.b((percent * r0) / 100.0f), 0, C5685n.f(audioManager.getStreamMaxVolume(3), 1));
        try {
            audioManager.setStreamVolume(3, iN, 0);
        } catch (SecurityException e10) {
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str = String.format("setStreamVolume failed, percent=%d raw=%d", Arrays.copyOf(new Object[]{Integer.valueOf(percent), Integer.valueOf(iN)}, 2));
            kotlin.jvm.internal.p.h(str, "format(...)");
            C4148a.t(TAG, str, e10, false, 8, null);
        }
    }

    public final void d(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("apply AIEngine TTS config voice=%s volume=%f", Arrays.copyOf(new Object[]{j(), Float.valueOf(i(context))}, 2));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
    }

    public final void e(LifecycleOwner owner, FigmaSlider slider) {
        kotlin.jvm.internal.p.i(owner, "owner");
        kotlin.jvm.internal.p.i(slider, "slider");
        final Context context = slider.getContext();
        slider.setMax(100);
        kotlin.jvm.internal.p.f(context);
        slider.setProgress(g(context));
        slider.setOnProgressChanged(new p9.p() { // from class: com.stepos.ailauncher.chat.manager.T0
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return U0.f(context, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue());
            }
        });
        owner.getLifecycle().a(new a(context, new b(slider)));
    }

    public final int g(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        if (!p()) {
            return C5685n.n(C5009a.k(C5009a.INSTANCE, KEY_FEEDBACK_VOLUME, 100, false, 4, null), 0, 100);
        }
        int iH = h(context);
        C5009a.B(C5009a.INSTANCE, KEY_FEEDBACK_VOLUME, iH, false, 4, null);
        return iH;
    }

    public final int h(Context context) {
        Object systemService = context.getSystemService("audio");
        if ((systemService instanceof AudioManager ? (AudioManager) systemService : null) == null) {
            return 50;
        }
        return C5685n.n((int) ((r2.getStreamVolume(3) * 100.0f) / C5685n.f(r2.getStreamMaxVolume(3), 1)), 10, 100);
    }

    public final float i(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return g(context) / 100.0f;
    }

    public final String j() {
        C5009a c5009a = C5009a.INSTANCE;
        String strT = C5009a.t(c5009a, "voice_setting_selected_voice_id", "", false, 4, null);
        if (strT != null && strT.length() != 0) {
            return strT;
        }
        String strT2 = C5009a.t(c5009a, LEGACY_KEY_TTS_VOICE_ID, "", false, 4, null);
        return (strT2 == null || strT2.length() == 0) ? defaultVoiceId : strT2;
    }

    public final String k() {
        String strT = C5009a.t(C5009a.INSTANCE, "voice_setting_selected_voice_name", "", false, 4, null);
        return strT == null ? "" : strT;
    }

    public final boolean l() {
        return C5009a.g(C5009a.INSTANCE, KEY_AMOO_EXPRESS_ACCEPTED, false, false, 4, null);
    }

    public final boolean m() {
        return C5009a.g(C5009a.INSTANCE, KEY_AMOO_EXPRESS, false, false, 4, null);
    }

    public final boolean n(String pkg) {
        kotlin.jvm.internal.p.i(pkg, "pkg");
        return C5009a.g(C5009a.INSTANCE, KEY_EXPRESS_APP_PREFIX + pkg, true, false, 4, null);
    }

    public final boolean o() {
        return C5009a.g(C5009a.INSTANCE, KEY_EXPRESS_USED, false, false, 4, null);
    }

    public final boolean p() {
        return C5009a.g(C5009a.INSTANCE, KEY_FEEDBACK_VOLUME_SYNC_SYSTEM, false, false, 4, null);
    }

    public final boolean q() {
        return C5009a.g(C5009a.INSTANCE, KEY_WAKEUP_HEADSET, true, false, 4, null);
    }

    public final boolean r() {
        return C5009a.g(C5009a.INSTANCE, KEY_WAKEUP_NAVIGATION, true, false, 4, null);
    }

    public final boolean s() {
        return Settings.Global.getInt(C3197a.INSTANCE.a().getContentResolver(), "voice_wakeup_enabled", 0) == 1;
    }

    public final void t() {
        IExpressService iExpressService = (IExpressService) D5.a.INSTANCE.a(IExpressService.class);
        if (iExpressService != null) {
            iExpressService.onSettingsChanged();
        }
    }

    public final void u(boolean accepted) {
        C5009a.y(C5009a.INSTANCE, KEY_AMOO_EXPRESS_ACCEPTED, accepted, false, 4, null);
    }

    public final void v(boolean enabled) {
        C5009a.y(C5009a.INSTANCE, KEY_AMOO_EXPRESS, enabled, false, 4, null);
        t();
    }

    public final void w(String voiceId) {
        kotlin.jvm.internal.p.i(voiceId, "voiceId");
        String string = La.H.D1(voiceId).toString();
        if (string.length() == 0 || kotlin.jvm.internal.p.d(defaultVoiceId, string)) {
            return;
        }
        defaultVoiceId = string;
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("defaultVoiceId updated -> %s", Arrays.copyOf(new Object[]{string}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
    }

    public final void x(String pkg, boolean enabled) {
        kotlin.jvm.internal.p.i(pkg, "pkg");
        C5009a.y(C5009a.INSTANCE, KEY_EXPRESS_APP_PREFIX + pkg, enabled, false, 4, null);
        t();
    }

    public final void y(boolean used) {
        C5009a.y(C5009a.INSTANCE, KEY_EXPRESS_USED, used, false, 4, null);
    }

    public final void z(Context context, int percent) {
        kotlin.jvm.internal.p.i(context, "context");
        int iN = C5685n.n(percent, 0, 100);
        if (p()) {
            c(context, iN);
        }
        C5009a.B(C5009a.INSTANCE, KEY_FEEDBACK_VOLUME, iN, false, 4, null);
    }
}
