package com.stepos.ailauncher.chat.voice.support;

import C5.d;
import La.H;
import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.amap.api.services.core.AMapException;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.common.utils.MicConflictPolicy;
import com.stepos.ailauncher.contract.api.speech.AsrCallback;
import com.stepos.ailauncher.contract.api.speech.ISpeechService;
import com.stepos.ailauncher.contract.api.speech.TtsListener;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.sla.SlaRouter;
import com.stepos.ailauncher.speech.view.VoiceTextView;
import com.stepos.ailauncher.voice.support.IVoiceAssistantCallback;
import com.stepos.ailauncher.voice.support.IVoiceServices;
import h8.C4148a;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002tw\u0018\u0000 ~2\u00020\u0001:\u0001\u007fB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\rJ!\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\rJ\u000f\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0014\u0010\rJ\u000f\u0010\u0015\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\rJ\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010 \u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u000f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u001eH\u0002¢\u0006\u0004\b \u0010!J$\u0010%\u001a\u00020\t2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\"H\u0082\b¢\u0006\u0004\b%\u0010&J#\u0010*\u001a\u00020\t*\u00020#2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u000fH\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\tH\u0016¢\u0006\u0004\b,\u0010\rJ\u000f\u0010-\u001a\u00020\tH\u0016¢\u0006\u0004\b-\u0010\rJ\u000f\u0010.\u001a\u00020\u0016H\u0016¢\u0006\u0004\b.\u0010\u0018J\u0019\u00100\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\tH\u0016¢\u0006\u0004\b2\u0010\rJ#\u00103\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b3\u0010\u0012J\u000f\u00104\u001a\u00020\tH\u0016¢\u0006\u0004\b4\u0010\rJ\u000f\u00105\u001a\u00020\u0016H\u0016¢\u0006\u0004\b5\u0010\u0018J\u0015\u00107\u001a\b\u0012\u0004\u0012\u00020\u000f06H\u0016¢\u0006\u0004\b7\u00108J\u0019\u00109\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b9\u0010\u000bJ\u000f\u0010:\u001a\u00020\tH\u0016¢\u0006\u0004\b:\u0010\rJ\u0019\u0010<\u001a\u00020\u00162\b\u0010;\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0016H\u0016¢\u0006\u0004\b>\u0010\u0018J\u0019\u0010@\u001a\u00020\t2\b\u0010?\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b@\u0010\u000bJ\u000f\u0010A\u001a\u00020\tH\u0016¢\u0006\u0004\bA\u0010\rJ\u000f\u0010B\u001a\u00020\tH\u0016¢\u0006\u0004\bB\u0010\rJ\u0019\u0010D\u001a\u00020\u00162\b\u0010C\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\bD\u0010=J\u000f\u0010E\u001a\u00020\u0016H\u0016¢\u0006\u0004\bE\u0010\u0018J\u0017\u0010H\u001a\u00020\t2\u0006\u0010G\u001a\u00020FH\u0016¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\tH\u0016¢\u0006\u0004\bJ\u0010\rJ\u000f\u0010K\u001a\u00020\tH\u0016¢\u0006\u0004\bK\u0010\rJ\u0019\u0010N\u001a\u00020\t2\b\u0010M\u001a\u0004\u0018\u00010LH\u0016¢\u0006\u0004\bN\u0010OJ\r\u0010P\u001a\u00020\t¢\u0006\u0004\bP\u0010\rJ\r\u0010Q\u001a\u00020\t¢\u0006\u0004\bQ\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010RR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010SR\u0014\u0010U\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR0\u0010\\\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020#0Zj\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020#`[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010^\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010`\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010b\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010aR\u0014\u0010c\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010aR\u0018\u0010d\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010g\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010i\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010k\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010_R\u0016\u0010l\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010aR\u0016\u0010m\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010aR\u0016\u0010n\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010aR\u0018\u0010p\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010r\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0014\u0010u\u001a\u00020t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u0014\u0010x\u001a\u00020w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010}\u001a\u0004\u0018\u00010z8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b{\u0010|¨\u0006\u0080\u0001"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/support/VoiceServiceBinder;", "Lcom/stepos/ailauncher/voice/support/IVoiceServices$Stub;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "bindIntent", "<init>", "(Landroid/content/Context;Landroid/content/Intent;)V", "param", "LY8/t;", "startRecognizeInternal", "(Landroid/content/Intent;)V", "stopRecognizeInternal", "()V", "cancelRecordInternal", "", "text", "speakInternal", "(Ljava/lang/String;Landroid/content/Intent;)V", "stopSpeakInternal", "ensurePopView", "destroyPopView", "", "isPopWindowShowingInternal", "()Z", "Landroid/view/View;", "view", "applyNightModeToView", "(Landroid/view/View;)V", "what", "Lkotlin/Function0;", "action", "runOnMain", "(Ljava/lang/String;Lp9/a;)V", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/voice/support/IVoiceAssistantCallback;", "block", "dispatchAllCallbacks", "(Lp9/l;)V", "", "code", "msg", "safeOnFailure", "(Lcom/stepos/ailauncher/voice/support/IVoiceAssistantCallback;ILjava/lang/String;)V", "display", DidiCardProvider.ACTION_DISMISS, "isDisplay", "callback", "registerCallback", "(Lcom/stepos/ailauncher/voice/support/IVoiceAssistantCallback;)V", "unregisterCallBack", "speak", "stopSpeak", "isSpeaking", "", "getSupportSounds", "()Ljava/util/List;", "startRecognize", "endRecognize", "name", "isSupport", "(Ljava/lang/String;)Z", "isFloatViewDisplayed", "params", "displayFloatView", "dismissFloatView", "cancelRecognize", "prefixMsg", "showCtaPermissionDiaglogIfNeed", "isPermissionAllowed", "", "voiceSpeed", "setVoiceSpeed", "(F)V", "pauseSpeak", "resumeSpeak", "Landroid/os/IBinder;", "clientBinder", "setClientDeathListener", "(Landroid/os/IBinder;)V", "destroy", "onBackPressed", "Landroid/content/Context;", "Landroid/content/Intent;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Landroid/view/WindowManager;", "wm", "Landroid/view/WindowManager;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "callbacks", "Ljava/util/HashMap;", "bindPkgName", "Ljava/lang/String;", "needWarningTone", "Z", "needAudio", "autoStop", "popView", "Landroid/view/View;", "Lcom/stepos/ailauncher/speech/view/VoiceTextView;", "asrTextView", "Lcom/stepos/ailauncher/speech/view/VoiceTextView;", "popBgColor", "I", "popHintText", "floatViewDisplayed", "isSpeakingFlag", "isRecognizing", "Landroid/os/IBinder$DeathRecipient;", "clientDeathRecipient", "Landroid/os/IBinder$DeathRecipient;", "deathClientBinder", "Landroid/os/IBinder;", "com/stepos/ailauncher/chat/voice/support/VoiceServiceBinder$b", "asrCallback", "Lcom/stepos/ailauncher/chat/voice/support/VoiceServiceBinder$b;", "com/stepos/ailauncher/chat/voice/support/VoiceServiceBinder$d", "speechAsrCallback", "Lcom/stepos/ailauncher/chat/voice/support/VoiceServiceBinder$d;", "Lcom/stepos/ailauncher/contract/api/speech/ISpeechService;", "getSpeechService", "()Lcom/stepos/ailauncher/contract/api/speech/ISpeechService;", "speechService", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VoiceServiceBinder extends IVoiceServices.Stub {
    private static final String TAG = "VoiceServiceBinder";
    private final b asrCallback;
    private VoiceTextView asrTextView;
    private final boolean autoStop;
    private final Intent bindIntent;
    private final String bindPkgName;
    private final HashMap<String, IVoiceAssistantCallback> callbacks;
    private IBinder.DeathRecipient clientDeathRecipient;
    private final Context context;
    private IBinder deathClientBinder;
    private boolean floatViewDisplayed;
    private boolean isRecognizing;
    private boolean isSpeakingFlag;
    private final Handler mainHandler;
    private final boolean needAudio;
    private final boolean needWarningTone;
    private int popBgColor;
    private String popHintText;
    private View popView;
    private final d speechAsrCallback;
    private final WindowManager wm;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J!\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"com/stepos/ailauncher/chat/voice/support/VoiceServiceBinder$b", "", "", "finalAsr", "LY8/t;", "c", "(Ljava/lang/String;)V", "currentAsr", Const.INTENT_KEY_PKGNAME, "", "errCode", "errMsg", Const.INTENT_KEY_APIKEY, "(ILjava/lang/String;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b {
        public b() {
        }

        public void a(int errCode, String errMsg) {
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str = String.format("asr onFail code=%d msg=%s", Arrays.copyOf(new Object[]{Integer.valueOf(errCode), errMsg}, 2));
            kotlin.jvm.internal.p.h(str, "format(...)");
            C4148a.u(VoiceServiceBinder.TAG, str, false, 4, null);
            VoiceServiceBinder.this.isRecognizing = false;
            if (errCode == -100) {
                for (Object obj : VoiceServiceBinder.this.callbacks.values()) {
                    kotlin.jvm.internal.p.h(obj, "next(...)");
                    try {
                        ((IVoiceAssistantCallback) obj).onCancel();
                    } catch (RemoteException e10) {
                        C4148a.t(VoiceServiceBinder.TAG, "dispatch callback failed", e10, false, 8, null);
                    } catch (Throwable th) {
                        C4148a.t(VoiceServiceBinder.TAG, "dispatch callback failed (non-remote)", th, false, 8, null);
                    }
                }
                return;
            }
            VoiceServiceBinder voiceServiceBinder = VoiceServiceBinder.this;
            for (Object obj2 : voiceServiceBinder.callbacks.values()) {
                kotlin.jvm.internal.p.h(obj2, "next(...)");
                try {
                    voiceServiceBinder.safeOnFailure((IVoiceAssistantCallback) obj2, errCode, errMsg == null ? C3081a.ENGINE_ERROR_MSG : errMsg);
                } catch (RemoteException e11) {
                    C4148a.t(VoiceServiceBinder.TAG, "dispatch callback failed", e11, false, 8, null);
                } catch (Throwable th2) {
                    C4148a.t(VoiceServiceBinder.TAG, "dispatch callback failed (non-remote)", th2, false, 8, null);
                }
            }
        }

        public void b(String currentAsr) {
            Intent intent = new Intent();
            intent.putExtra("result_type", "msg_part_result");
            if (currentAsr == null) {
                currentAsr = "";
            }
            intent.putExtra("msg_part_result", currentAsr);
            intent.putExtra("msg_part_last", false);
            for (Object obj : VoiceServiceBinder.this.callbacks.values()) {
                kotlin.jvm.internal.p.h(obj, "next(...)");
                try {
                    ((IVoiceAssistantCallback) obj).onVoiceMsgProc(intent);
                } catch (RemoteException e10) {
                    C4148a.t(VoiceServiceBinder.TAG, "dispatch callback failed", e10, false, 8, null);
                } catch (Throwable th) {
                    C4148a.t(VoiceServiceBinder.TAG, "dispatch callback failed (non-remote)", th, false, 8, null);
                }
            }
        }

        public void c(String finalAsr) {
            C4148a.d(VoiceServiceBinder.TAG, "asr onSuc len=" + (finalAsr != null ? finalAsr.length() : 0), false, 4, null);
            VoiceServiceBinder.this.isRecognizing = false;
            if (finalAsr == null || finalAsr.length() == 0) {
                VoiceServiceBinder voiceServiceBinder = VoiceServiceBinder.this;
                for (Object obj : voiceServiceBinder.callbacks.values()) {
                    kotlin.jvm.internal.p.h(obj, "next(...)");
                    try {
                        voiceServiceBinder.safeOnFailure((IVoiceAssistantCallback) obj, -1001, C3081a.CONTENT_EMPTY_ERROR_MSG);
                    } catch (RemoteException e10) {
                        C4148a.t(VoiceServiceBinder.TAG, "dispatch callback failed", e10, false, 8, null);
                    } catch (Throwable th) {
                        C4148a.t(VoiceServiceBinder.TAG, "dispatch callback failed (non-remote)", th, false, 8, null);
                    }
                }
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(C3081a.RESULT_RAWTEXT, H.D1(finalAsr).toString());
            intent.putExtra(C3081a.RESULT_IAT_RAWTEXT, H.D1(finalAsr).toString());
            for (Object obj2 : VoiceServiceBinder.this.callbacks.values()) {
                kotlin.jvm.internal.p.h(obj2, "next(...)");
                try {
                    ((IVoiceAssistantCallback) obj2).onSuccess(intent);
                } catch (RemoteException e11) {
                    C4148a.t(VoiceServiceBinder.TAG, "dispatch callback failed", e11, false, 8, null);
                } catch (Throwable th2) {
                    C4148a.t(VoiceServiceBinder.TAG, "dispatch callback failed (non-remote)", th2, false, 8, null);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/stepos/ailauncher/chat/voice/support/VoiceServiceBinder$c", "Lcom/stepos/ailauncher/contract/api/speech/TtsListener;", "LY8/t;", "onPlayStarted", "()V", "onPlayStopped", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements TtsListener {
        public c() {
        }

        @Override // com.stepos.ailauncher.contract.api.speech.TtsListener
        public void onPlayStarted() {
            VoiceServiceBinder.this.isSpeakingFlag = true;
            for (Object obj : VoiceServiceBinder.this.callbacks.values()) {
                kotlin.jvm.internal.p.h(obj, "next(...)");
                try {
                    ((IVoiceAssistantCallback) obj).onSpeakBegan("native");
                } catch (RemoteException e10) {
                    C4148a.t(VoiceServiceBinder.TAG, "dispatch callback failed", e10, false, 8, null);
                } catch (Throwable th) {
                    C4148a.t(VoiceServiceBinder.TAG, "dispatch callback failed (non-remote)", th, false, 8, null);
                }
            }
        }

        @Override // com.stepos.ailauncher.contract.api.speech.TtsListener
        public void onPlayStopped() {
            VoiceServiceBinder.this.isSpeakingFlag = false;
            for (Object obj : VoiceServiceBinder.this.callbacks.values()) {
                kotlin.jvm.internal.p.h(obj, "next(...)");
                try {
                    ((IVoiceAssistantCallback) obj).onSpeakCompleted(0);
                } catch (RemoteException e10) {
                    C4148a.t(VoiceServiceBinder.TAG, "dispatch callback failed", e10, false, 8, null);
                } catch (Throwable th) {
                    C4148a.t(VoiceServiceBinder.TAG, "dispatch callback failed (non-remote)", th, false, 8, null);
                }
            }
        }

        @Override // com.stepos.ailauncher.contract.api.speech.TtsListener
        public /* bridge */ void onStreamInterrupted(String str) {
            super.onStreamInterrupted(str);
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0017\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"com/stepos/ailauncher/chat/voice/support/VoiceServiceBinder$d", "Lcom/stepos/ailauncher/contract/api/speech/AsrCallback;", "", "text", "LY8/t;", "onPartialResult", "(Ljava/lang/String;)V", "onFinalResult", "", "code", "message", "onError", "(ILjava/lang/String;)V", "onRecordingStarted", "()V", "onRecordingStopped", "", "data", "onAudioFrame", "([S)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements AsrCallback {
        public d() {
        }

        @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
        public void onAudioFrame(short[] data) {
            kotlin.jvm.internal.p.i(data, "data");
        }

        @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
        public void onError(int code, String message) {
            kotlin.jvm.internal.p.i(message, "message");
            VoiceServiceBinder.this.asrCallback.a(code, message);
        }

        @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
        public void onFinalResult(String text) {
            kotlin.jvm.internal.p.i(text, "text");
            VoiceServiceBinder.this.asrCallback.c(text);
        }

        @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
        public void onPartialResult(String text) {
            kotlin.jvm.internal.p.i(text, "text");
            VoiceServiceBinder.this.asrCallback.b(text);
        }

        @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
        public void onRecordingStarted() {
            Y8.t tVar;
            VoiceServiceBinder voiceServiceBinder = VoiceServiceBinder.this;
            try {
                Result.Companion companion = Result.INSTANCE;
                VoiceTextView voiceTextView = voiceServiceBinder.asrTextView;
                if (voiceTextView != null) {
                    voiceTextView.m();
                    tVar = Y8.t.f7040a;
                } else {
                    tVar = null;
                }
                Result.b(tVar);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }

        @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
        public void onRecordingStopped() {
            Y8.t tVar;
            VoiceServiceBinder voiceServiceBinder = VoiceServiceBinder.this;
            try {
                Result.Companion companion = Result.INSTANCE;
                VoiceTextView voiceTextView = voiceServiceBinder.asrTextView;
                if (voiceTextView != null) {
                    voiceTextView.o();
                    tVar = Y8.t.f7040a;
                } else {
                    tVar = null;
                }
                Result.b(tVar);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }

        @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
        public /* bridge */ void onSpeechDetected() {
            super.onSpeechDetected();
        }
    }

    public VoiceServiceBinder(Context context, Intent intent) {
        Bundle extras;
        Bundle extras2;
        Bundle extras3;
        Bundle extras4;
        kotlin.jvm.internal.p.i(context, "context");
        this.context = context;
        this.bindIntent = intent;
        this.mainHandler = new Handler(Looper.getMainLooper());
        Object systemService = context.getSystemService("window");
        kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.wm = (WindowManager) systemService;
        this.callbacks = new HashMap<>();
        this.bindPkgName = (intent == null || (extras4 = intent.getExtras()) == null) ? null : extras4.getString("package");
        boolean z10 = true;
        this.needWarningTone = (intent == null || (extras3 = intent.getExtras()) == null) ? true : extras3.getBoolean(C3081a.KEY_NEED_WARNING_TONE, true);
        boolean z11 = false;
        if (intent != null && (extras2 = intent.getExtras()) != null) {
            z11 = extras2.getBoolean(C3081a.KEY_NEED_AUDIO, false);
        }
        this.needAudio = z11;
        if (intent != null && (extras = intent.getExtras()) != null) {
            z10 = extras.getBoolean(C3081a.PARAM_AUTO_STOP, true);
        }
        this.autoStop = z10;
        this.popBgColor = -1;
        this.popHintText = "";
        this.asrCallback = new b();
        this.speechAsrCallback = new d();
    }

    private final void applyNightModeToView(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object systemService = this.context.getSystemService("uimode");
        UiModeManager uiModeManager = systemService instanceof UiModeManager ? (UiModeManager) systemService : null;
        if (uiModeManager != null && uiModeManager.getNightMode() == 2) {
            try {
                View.class.getDeclaredMethod("actInMzNightMode", Integer.TYPE).invoke(view, 2);
            } catch (Exception unused) {
            }
            if (this.popBgColor == -1) {
                this.popBgColor = -16777216;
            }
        }
        int i10 = this.popBgColor;
        if (i10 != -1) {
            view.setBackgroundColor(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t cancelRecognize$lambda$0(VoiceServiceBinder voiceServiceBinder) {
        voiceServiceBinder.cancelRecordInternal();
        return Y8.t.f7040a;
    }

    private final void cancelRecordInternal() {
        if (this.isRecognizing) {
            ISpeechService speechService = getSpeechService();
            if (speechService != null) {
                speechService.cancelAsr();
            }
            this.isRecognizing = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t destroy$lambda$0(VoiceServiceBinder voiceServiceBinder) {
        voiceServiceBinder.cancelRecordInternal();
        voiceServiceBinder.stopSpeakInternal();
        voiceServiceBinder.destroyPopView();
        return Y8.t.f7040a;
    }

    private final void destroyPopView() {
        View view = this.popView;
        if (view == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            this.wm.removeView(view);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        this.popView = null;
        this.asrTextView = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t dismiss$lambda$0(VoiceServiceBinder voiceServiceBinder) {
        voiceServiceBinder.cancelRecordInternal();
        voiceServiceBinder.destroyPopView();
        return Y8.t.f7040a;
    }

    private final void dispatchAllCallbacks(InterfaceC5074l<? super IVoiceAssistantCallback, Y8.t> block) {
        for (Object obj : this.callbacks.values()) {
            kotlin.jvm.internal.p.h(obj, "next(...)");
            try {
                block.invoke((IVoiceAssistantCallback) obj);
            } catch (RemoteException e10) {
                C4148a.t(TAG, "dispatch callback failed", e10, false, 8, null);
            } catch (Throwable th) {
                C4148a.t(TAG, "dispatch callback failed (non-remote)", th, false, 8, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t display$lambda$0(VoiceServiceBinder voiceServiceBinder) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (voiceServiceBinder.isPopWindowShowingInternal()) {
            return Y8.t.f7040a;
        }
        voiceServiceBinder.ensurePopView();
        voiceServiceBinder.startRecognizeInternal(null);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t endRecognize$lambda$0(VoiceServiceBinder voiceServiceBinder) {
        voiceServiceBinder.stopRecognizeInternal();
        return Y8.t.f7040a;
    }

    private final void ensurePopView() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.popView != null) {
            return;
        }
        View viewInflate = LayoutInflater.from(this.context).inflate(R$layout.layout_voice_assistant_pop, (ViewGroup) null, false);
        viewInflate.measure(0, 0);
        VoiceTextView voiceTextView = (VoiceTextView) viewInflate.findViewById(R$id.voice_pop_asr_view);
        voiceTextView.i(this.context);
        voiceTextView.h(false);
        voiceTextView.setRollingAsrTextColor(-1);
        voiceTextView.b(1, 0);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.width = -1;
        layoutParams.height = viewInflate.getMeasuredHeight();
        layoutParams.type = AMapException.CODE_AMAP_ENGINE_TABLEID_NOT_EXIST;
        layoutParams.format = -2;
        layoutParams.flags = 8;
        layoutParams.gravity = 83;
        layoutParams.setTitle("SF_VoiceServiceBinder");
        layoutParams.windowAnimations = this.context.getResources().getIdentifier("pop_view_anim", "style", this.context.getPackageName());
        kotlin.jvm.internal.p.f(viewInflate);
        applyNightModeToView(viewInflate);
        int i10 = this.popBgColor;
        if (i10 != -1) {
            viewInflate.setBackgroundColor(i10);
        }
        if (this.popHintText.length() > 0) {
            voiceTextView.q(this.popHintText);
        }
        this.popView = viewInflate;
        this.asrTextView = voiceTextView;
        try {
            this.wm.addView(viewInflate, layoutParams);
        } catch (Throwable th) {
            C4148a.g(TAG, "wm.addView failed", th, false, 8, null);
            this.popView = null;
            this.asrTextView = null;
        }
    }

    private final ISpeechService getSpeechService() {
        ISpeechService iSpeechService = (ISpeechService) D5.a.INSTANCE.a(ISpeechService.class);
        if (iSpeechService == null || !iSpeechService.isAsrAvailable()) {
            return null;
        }
        return iSpeechService;
    }

    private final boolean isPopWindowShowingInternal() {
        View view = this.popView;
        return (view == null || view.getVisibility() != 0 || view.getWindowToken() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t onBackPressed$lambda$0(VoiceServiceBinder voiceServiceBinder) {
        if (!voiceServiceBinder.isPopWindowShowingInternal()) {
            return Y8.t.f7040a;
        }
        for (Object obj : voiceServiceBinder.callbacks.values()) {
            kotlin.jvm.internal.p.h(obj, "next(...)");
            try {
                ((IVoiceAssistantCallback) obj).onCancel();
            } catch (RemoteException e10) {
                C4148a.t(TAG, "dispatch callback failed", e10, false, 8, null);
            } catch (Throwable th) {
                C4148a.t(TAG, "dispatch callback failed (non-remote)", th, false, 8, null);
            }
        }
        voiceServiceBinder.cancelRecordInternal();
        voiceServiceBinder.destroyPopView();
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t pauseSpeak$lambda$0(VoiceServiceBinder voiceServiceBinder) {
        voiceServiceBinder.stopSpeakInternal();
        return Y8.t.f7040a;
    }

    private final void runOnMain(final String what, final InterfaceC5063a<Y8.t> action) {
        final d.a aVarD = C5.d.INSTANCE.d(this.context);
        aVarD.a(this.context, what);
        final InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.support.E
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceServiceBinder.runOnMain$lambda$0(aVarD, this, what, action);
            }
        };
        if (kotlin.jvm.internal.p.d(Looper.getMainLooper(), Looper.myLooper())) {
            interfaceC5063a.invoke();
        } else {
            this.mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.voice.support.F
                @Override // java.lang.Runnable
                public final void run() {
                    interfaceC5063a.invoke();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t runOnMain$lambda$0(d.a aVar, VoiceServiceBinder voiceServiceBinder, String str, InterfaceC5063a interfaceC5063a) {
        try {
            aVar.a(voiceServiceBinder.context, str);
            interfaceC5063a.invoke();
        } catch (SecurityException e10) {
            C4148a.u(TAG, "drop " + str + ": " + e10.getMessage(), false, 4, null);
        }
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void safeOnFailure(IVoiceAssistantCallback iVoiceAssistantCallback, int i10, String str) {
        try {
            Intent intent = new Intent();
            intent.putExtra("errorCode", i10);
            intent.putExtra(C3081a.ERROR_MSG, str);
            iVoiceAssistantCallback.onFailure(intent);
        } catch (RemoteException e10) {
            C4148a.t(TAG, "onFailure dispatch failed", e10, false, 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setClientDeathListener$lambda$1(VoiceServiceBinder voiceServiceBinder, IBinder iBinder, Ref$ObjectRef ref$ObjectRef) {
        IBinder.DeathRecipient deathRecipient = null;
        C4148a.d(TAG, "client binder died, stopSpeak", false, 4, null);
        try {
            voiceServiceBinder.stopSpeak();
        } catch (RemoteException e10) {
            C4148a.t(TAG, "stopSpeak on binderDied failed", e10, false, 8, null);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            T t10 = ref$ObjectRef.f34820a;
            if (t10 == 0) {
                kotlin.jvm.internal.p.A("recipient");
            } else {
                deathRecipient = (IBinder.DeathRecipient) t10;
            }
            Result.b(Boolean.valueOf(iBinder.unlinkToDeath(deathRecipient, 0)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t speak$lambda$0(VoiceServiceBinder voiceServiceBinder, String str, Intent intent) {
        voiceServiceBinder.speakInternal(str, intent);
        return Y8.t.f7040a;
    }

    private final void speakInternal(String text, Intent param) {
        if (MicConflictPolicy.INSTANCE.e()) {
            C4148a.d(TAG, "speak suppressed: concurrent mic occupancy", false, 4, null);
            return;
        }
        if (!AuthManager.INSTANCE.p0(this.context)) {
            C4148a.u(TAG, "speakInternal: AI engine not ready", false, 4, null);
            this.isSpeakingFlag = false;
            for (Object obj : this.callbacks.values()) {
                kotlin.jvm.internal.p.h(obj, "next(...)");
                try {
                    ((IVoiceAssistantCallback) obj).onSpeakCompleted(-1);
                } catch (RemoteException e10) {
                    C4148a.t(TAG, "dispatch callback failed", e10, false, 8, null);
                } catch (Throwable th) {
                    C4148a.t(TAG, "dispatch callback failed (non-remote)", th, false, 8, null);
                }
            }
            return;
        }
        ISpeechService iSpeechService = (ISpeechService) D5.a.INSTANCE.a(ISpeechService.class);
        if (iSpeechService == null || !iSpeechService.isTtsAvailable()) {
            iSpeechService = null;
        }
        if (iSpeechService != null) {
            iSpeechService.stopSpeak();
            iSpeechService.speak(text, new c());
            return;
        }
        C4148a.u(TAG, "speakInternal: AIEngine TTS unavailable", false, 4, null);
        this.isSpeakingFlag = false;
        for (Object obj2 : this.callbacks.values()) {
            kotlin.jvm.internal.p.h(obj2, "next(...)");
            try {
                ((IVoiceAssistantCallback) obj2).onSpeakCompleted(-1);
            } catch (RemoteException e11) {
                C4148a.t(TAG, "dispatch callback failed", e11, false, 8, null);
            } catch (Throwable th2) {
                C4148a.t(TAG, "dispatch callback failed (non-remote)", th2, false, 8, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t startRecognize$lambda$0(VoiceServiceBinder voiceServiceBinder, Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        voiceServiceBinder.ensurePopView();
        voiceServiceBinder.startRecognizeInternal(intent);
        return Y8.t.f7040a;
    }

    private final void startRecognizeInternal(Intent param) {
        if (this.isRecognizing) {
            C4148a.d(TAG, "startRecognizeInternal: already recognizing, skip", false, 4, null);
            return;
        }
        if (!AuthManager.INSTANCE.p0(this.context)) {
            C4148a.u(TAG, "startRecognizeInternal: AI engine not ready", false, 4, null);
            for (Object obj : this.callbacks.values()) {
                kotlin.jvm.internal.p.h(obj, "next(...)");
                try {
                    safeOnFailure((IVoiceAssistantCallback) obj, -1002, C3081a.NOT_READY_FOR_RECOGNIZE_MSG);
                } catch (RemoteException e10) {
                    C4148a.t(TAG, "dispatch callback failed", e10, false, 8, null);
                } catch (Throwable th) {
                    C4148a.t(TAG, "dispatch callback failed (non-remote)", th, false, 8, null);
                }
            }
            return;
        }
        ISpeechService speechService = getSpeechService();
        if (speechService == null) {
            C4148a.u(TAG, "startRecognizeInternal: AIEngine ASR unavailable", false, 4, null);
            for (Object obj2 : this.callbacks.values()) {
                kotlin.jvm.internal.p.h(obj2, "next(...)");
                try {
                    safeOnFailure((IVoiceAssistantCallback) obj2, -1002, C3081a.NOT_READY_FOR_RECOGNIZE_MSG);
                } catch (RemoteException e11) {
                    C4148a.t(TAG, "dispatch callback failed", e11, false, 8, null);
                } catch (Throwable th2) {
                    C4148a.t(TAG, "dispatch callback failed (non-remote)", th2, false, 8, null);
                }
            }
            return;
        }
        if (this.asrTextView == null) {
            C4148a.u(TAG, "startRecognizeInternal: asrTextView null, skip", false, 4, null);
            return;
        }
        this.isRecognizing = true;
        for (Object obj3 : this.callbacks.values()) {
            kotlin.jvm.internal.p.h(obj3, "next(...)");
            try {
                ((IVoiceAssistantCallback) obj3).onRecordStart();
            } catch (RemoteException e12) {
                C4148a.t(TAG, "dispatch callback failed", e12, false, 8, null);
            } catch (Throwable th3) {
                C4148a.t(TAG, "dispatch callback failed (non-remote)", th3, false, 8, null);
            }
        }
        speechService.startListening(this.speechAsrCallback);
    }

    private final void stopRecognizeInternal() {
        if (this.isRecognizing) {
            ISpeechService speechService = getSpeechService();
            if (speechService != null) {
                speechService.stopAndFinalize();
            }
            this.isRecognizing = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t stopSpeak$lambda$0(VoiceServiceBinder voiceServiceBinder) {
        voiceServiceBinder.stopSpeakInternal();
        return Y8.t.f7040a;
    }

    private final void stopSpeakInternal() {
        ISpeechService iSpeechService = (ISpeechService) D5.a.INSTANCE.a(ISpeechService.class);
        if (iSpeechService != null) {
            if (!iSpeechService.isTtsAvailable()) {
                iSpeechService = null;
            }
            if (iSpeechService != null) {
                iSpeechService.stopSpeak();
            }
        }
        if (this.isSpeakingFlag) {
            this.isSpeakingFlag = false;
            for (Object obj : this.callbacks.values()) {
                kotlin.jvm.internal.p.h(obj, "next(...)");
                try {
                    ((IVoiceAssistantCallback) obj).onSpeakInterrupted();
                } catch (RemoteException e10) {
                    C4148a.t(TAG, "dispatch callback failed", e10, false, 8, null);
                } catch (Throwable th) {
                    C4148a.t(TAG, "dispatch callback failed (non-remote)", th, false, 8, null);
                }
            }
        }
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceServices
    public void cancelRecognize() {
        C5.d.INSTANCE.g(this.context, "cancelRecognize");
        C4148a.d(TAG, "cancelRecognize", false, 4, null);
        runOnMain("cancelRecognize", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.support.A
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceServiceBinder.cancelRecognize$lambda$0(this.f26512a);
            }
        });
    }

    public final void destroy() {
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("destroy pkg=%s", Arrays.copyOf(new Object[]{this.bindPkgName}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        runOnMain("destroy", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.support.y
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceServiceBinder.destroy$lambda$0(this.f26584a);
            }
        });
        this.callbacks.clear();
        IBinder iBinder = this.deathClientBinder;
        IBinder.DeathRecipient deathRecipient = this.clientDeathRecipient;
        if (iBinder != null && deathRecipient != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Result.b(Boolean.valueOf(iBinder.unlinkToDeath(deathRecipient, 0)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
        this.deathClientBinder = null;
        this.clientDeathRecipient = null;
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceServices
    public void dismiss() {
        C5.d.INSTANCE.g(this.context, DidiCardProvider.ACTION_DISMISS);
        C4148a.d(TAG, DidiCardProvider.ACTION_DISMISS, false, 4, null);
        runOnMain(DidiCardProvider.ACTION_DISMISS, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.support.z
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceServiceBinder.dismiss$lambda$0(this.f26585a);
            }
        });
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceServices
    public void dismissFloatView() {
        C5.d.INSTANCE.g(this.context, "dismissFloatView");
        C4148a.d(TAG, "dismissFloatView", false, 4, null);
        this.floatViewDisplayed = false;
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceServices
    public void display() {
        C5.d.INSTANCE.g(this.context, "display");
        C4148a.d(TAG, "display", false, 4, null);
        runOnMain("display", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.support.C
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceServiceBinder.display$lambda$0(this.f26516a);
            }
        });
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceServices
    public void displayFloatView(Intent params) {
        C5.d.INSTANCE.g(this.context, "displayFloatView");
        C4148a.d(TAG, "displayFloatView", false, 4, null);
        this.floatViewDisplayed = true;
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceServices
    public void endRecognize() {
        C5.d.INSTANCE.g(this.context, "endRecognize");
        C4148a.d(TAG, "endRecognize", false, 4, null);
        runOnMain("endRecognize", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.support.D
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceServiceBinder.endRecognize$lambda$0(this.f26517a);
            }
        });
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceServices
    public List<String> getSupportSounds() {
        C5.d.INSTANCE.g(this.context, "getSupportSounds");
        return new ArrayList();
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceServices
    public boolean isDisplay() {
        C5.d.INSTANCE.g(this.context, "isDisplay");
        return isPopWindowShowingInternal();
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceServices
    public boolean isFloatViewDisplayed() {
        C5.d.INSTANCE.g(this.context, "isFloatViewDisplayed");
        return this.floatViewDisplayed;
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceServices
    public boolean isPermissionAllowed() {
        return C5.d.INSTANCE.k(this.context);
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceServices
    public boolean isSpeaking() {
        C5.d.INSTANCE.g(this.context, "isSpeaking");
        return this.isSpeakingFlag;
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceServices
    public boolean isSupport(String name) {
        C5.d.INSTANCE.g(this.context, "isSupport");
        if (name != null) {
            for (String str : C3081a.INSTANCE.a()) {
                if (kotlin.jvm.internal.p.d(str, name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void onBackPressed() {
        C4148a.d(TAG, "onBackPressed", false, 4, null);
        runOnMain("onBackPressed", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.support.w
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceServiceBinder.onBackPressed$lambda$0(this.f26572a);
            }
        });
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceServices
    public void pauseSpeak() {
        C5.d.INSTANCE.g(this.context, "pauseSpeak");
        C4148a.d(TAG, "pauseSpeak", false, 4, null);
        runOnMain("pauseSpeak", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.support.u
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceServiceBinder.pauseSpeak$lambda$0(this.f26570a);
            }
        });
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceServices
    public void registerCallback(IVoiceAssistantCallback callback) {
        C5.d dVar = C5.d.INSTANCE;
        dVar.g(this.context, "registerCallback");
        String strB = dVar.b(this.context);
        if (callback == null) {
            throw new SecurityException("registerCallback denied: null callback");
        }
        C4148a.d(TAG, "registerCallback caller=" + strB, false, 4, null);
        this.callbacks.put(strB, callback);
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceServices
    public void resumeSpeak() {
        C5.d.INSTANCE.g(this.context, "resumeSpeak");
        C4148a.d(TAG, "resumeSpeak", false, 4, null);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [T, com.stepos.ailauncher.chat.voice.support.B] */
    @Override // com.stepos.ailauncher.voice.support.IVoiceServices
    public void setClientDeathListener(final IBinder clientBinder) throws RemoteException {
        C5.d.INSTANCE.g(this.context, "setClientDeathListener");
        IBinder.DeathRecipient deathRecipient = null;
        C4148a.d(TAG, "setClientDeathListener", false, 4, null);
        IBinder iBinder = this.deathClientBinder;
        IBinder.DeathRecipient deathRecipient2 = this.clientDeathRecipient;
        if (iBinder != null && deathRecipient2 != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Result.b(Boolean.valueOf(iBinder.unlinkToDeath(deathRecipient2, 0)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
        this.clientDeathRecipient = null;
        this.deathClientBinder = null;
        if (clientBinder == null) {
            return;
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ?? r22 = new IBinder.DeathRecipient() { // from class: com.stepos.ailauncher.chat.voice.support.B
            @Override // android.os.IBinder.DeathRecipient
            public final void binderDied() {
                VoiceServiceBinder.setClientDeathListener$lambda$1(this.f26513a, clientBinder, ref$ObjectRef);
            }
        };
        ref$ObjectRef.f34820a = r22;
        try {
            clientBinder.linkToDeath((IBinder.DeathRecipient) r22, 0);
            this.deathClientBinder = clientBinder;
            T t10 = ref$ObjectRef.f34820a;
            if (t10 == 0) {
                kotlin.jvm.internal.p.A("recipient");
            } else {
                deathRecipient = (IBinder.DeathRecipient) t10;
            }
            this.clientDeathRecipient = deathRecipient;
        } catch (RemoteException e10) {
            C4148a.t(TAG, "linkToDeath failed", e10, false, 8, null);
        }
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceServices
    public void setVoiceSpeed(float voiceSpeed) {
        C5.d.INSTANCE.g(this.context, "setVoiceSpeed");
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("setVoiceSpeed %f", Arrays.copyOf(new Object[]{Float.valueOf(voiceSpeed)}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceServices
    public boolean showCtaPermissionDiaglogIfNeed(String prefixMsg) {
        C5.d.INSTANCE.g(this.context, "showCtaPermissionDiaglogIfNeed");
        SlaRouter slaRouter = SlaRouter.INSTANCE;
        if (slaRouter.t(this.context)) {
            return false;
        }
        C4148a.d(TAG, "showCtaPermissionDiaglogIfNeed prefix=" + prefixMsg, false, 4, null);
        return slaRouter.K(this.context);
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceServices
    public void speak(final String text, final Intent param) {
        C5.d.INSTANCE.g(this.context, "speak");
        C4148a.d(TAG, "speak len=" + (text != null ? text.length() : 0), false, 4, null);
        if (text == null || text.length() == 0) {
            return;
        }
        runOnMain("speak", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.support.x
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceServiceBinder.speak$lambda$0(this.f26581a, text, param);
            }
        });
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceServices
    public void startRecognize(final Intent param) {
        C5.d.INSTANCE.g(this.context, "startRecognize");
        C4148a.d(TAG, "startRecognize", false, 4, null);
        runOnMain("startRecognize", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.support.G
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceServiceBinder.startRecognize$lambda$0(this.f26523a, param);
            }
        });
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceServices
    public void stopSpeak() {
        C5.d.INSTANCE.g(this.context, "stopSpeak");
        C4148a.d(TAG, "stopSpeak", false, 4, null);
        runOnMain("stopSpeak", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.support.v
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceServiceBinder.stopSpeak$lambda$0(this.f26571a);
            }
        });
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceServices
    public void unregisterCallBack() {
        C5.d dVar = C5.d.INSTANCE;
        dVar.g(this.context, "unregisterCallBack");
        String strB = dVar.b(this.context);
        C4148a.d(TAG, "unregisterCallBack caller=" + strB, false, 4, null);
        this.callbacks.remove(strB);
    }
}
