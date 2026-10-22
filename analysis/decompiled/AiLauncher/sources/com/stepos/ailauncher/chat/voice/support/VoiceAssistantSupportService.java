package com.stepos.ailauncher.chat.voice.support;

import C5.d;
import La.H;
import android.app.Service;
import android.app.UiModeManager;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import android.view.WindowManager;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.services.core.AMapException;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.chat.voice.support.VoiceAssistantSupportService;
import com.stepos.ailauncher.common.utils.MicConflictPolicy;
import com.stepos.ailauncher.contract.api.speech.AsrCallback;
import com.stepos.ailauncher.contract.api.speech.ISpeechService;
import com.stepos.ailauncher.contract.api.speech.TtsListener;
import com.stepos.ailauncher.voice.support.IVoiceAssistantCallback;
import com.stepos.ailauncher.voice.support.IVoiceAssistantSpeakCallback;
import h8.C4148a;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u0000¹\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0003`cf\u0018\u0000 m2\u00020\u0001:\u0002noB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u001f\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\u0003J\u0017\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0007H\u0002¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010$\u001a\u00020\u0007H\u0002¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010%\u001a\u00020\u0007H\u0002¢\u0006\u0004\b%\u0010\u0003J\u0017\u0010&\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b&\u0010\u0015J\u0017\u0010'\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b'\u0010(J'\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u00040*j\b\u0012\u0004\u0012\u00020\u0004`+2\u0006\u0010)\u001a\u00020\u0010H\u0002¢\u0006\u0004\b,\u0010-J#\u00101\u001a\u00020\u0007*\u00020.2\u0006\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u0004H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0007H\u0016¢\u0006\u0004\b3\u0010\u0003J\u001b\u00106\u001a\u0004\u0018\u00010\u00182\b\u00105\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\b6\u00107J\u0019\u00109\u001a\u0002082\b\u00105\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0007H\u0016¢\u0006\u0004\b;\u0010\u0003R\u0014\u0010=\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010?\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010A\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER0\u0010H\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020.0Fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020.`G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR0\u0010J\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020C0Fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020C`G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010IRP\u0010K\u001a>\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040*j\b\u0012\u0004\u0012\u00020\u0004`+0Fj\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040*j\b\u0012\u0004\u0012\u00020\u0004`+`G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010IR0\u0010L\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040Fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010IR0\u0010M\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002080Fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u000208`G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010IR\u0018\u0010O\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010R\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010U\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u001e\u0010Y\u001a\f\u0012\b\u0012\u00060XR\u00020\u00000W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010[\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010@R\u0016\u0010\\\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010$R\u0016\u0010]\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010$R\u0016\u0010^\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010\u0014R\u0016\u0010_\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010\u0014R\u0014\u0010a\u001a\u00020`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010d\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010g\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010l\u001a\u0004\u0018\u00010i8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bj\u0010k¨\u0006p"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/support/VoiceAssistantSupportService;", "Landroid/app/Service;", "<init>", "()V", "", "what", "Lkotlin/Function0;", "LY8/t;", "action", "U", "(Ljava/lang/String;Lp9/a;)V", "Y", "a0", ExifInterface.LATITUDE_SOUTH, "", "data", "", "L", "([S)I", "text", "Z", "(Ljava/lang/String;)V", "b0", "packageName", "Landroid/os/IBinder;", M5.b.CREDENTIAL_TOKEN, "N", "(Ljava/lang/String;Landroid/os/IBinder;)V", "R", "(Landroid/os/IBinder;)V", "O", "Landroid/view/View;", "view", "K", "(Landroid/view/View;)V", "M", "I", "J", ExifInterface.LONGITUDE_WEST, "P", "(Landroid/os/IBinder;)I", "focuses", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", ExifInterface.GPS_DIRECTION_TRUE, "(I)Ljava/util/ArrayList;", "Lcom/stepos/ailauncher/voice/support/IVoiceAssistantCallback;", "code", "msg", "X", "(Lcom/stepos/ailauncher/voice/support/IVoiceAssistantCallback;ILjava/lang/String;)V", "onCreate", "Landroid/content/Intent;", "intent", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "", "onUnbind", "(Landroid/content/Intent;)Z", "onDestroy", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "currentPkg", "Ljava/lang/String;", "currentCallback", "Lcom/stepos/ailauncher/voice/support/IVoiceAssistantCallback;", "Lcom/stepos/ailauncher/voice/support/IVoiceAssistantSpeakCallback;", "currentSpeakCallback", "Lcom/stepos/ailauncher/voice/support/IVoiceAssistantSpeakCallback;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "callbacks", "Ljava/util/HashMap;", "speakCallbacks", "appFocuses", "hintTexts", "needPopWindowMap", "Landroid/view/WindowManager;", "wm", "Landroid/view/WindowManager;", "Lcom/stepos/ailauncher/chat/voice/support/widget/c;", "popView", "Lcom/stepos/ailauncher/chat/voice/support/widget/c;", "Landroid/view/WindowManager$LayoutParams;", "wmParams", "Landroid/view/WindowManager$LayoutParams;", "", "Lcom/stepos/ailauncher/chat/voice/support/VoiceAssistantSupportService$a;", "clients", "Ljava/util/List;", "popHintText", "popBgColor", "nightModeOverride", "isRecognizing", "isSpeakingFlag", "com/stepos/ailauncher/chat/voice/support/VoiceAssistantSupportService$stub$1", "stub", "Lcom/stepos/ailauncher/chat/voice/support/VoiceAssistantSupportService$stub$1;", "com/stepos/ailauncher/chat/voice/support/VoiceAssistantSupportService$c", "asrCallback", "Lcom/stepos/ailauncher/chat/voice/support/VoiceAssistantSupportService$c;", "com/stepos/ailauncher/chat/voice/support/VoiceAssistantSupportService$d", "speechAsrCallback", "Lcom/stepos/ailauncher/chat/voice/support/VoiceAssistantSupportService$d;", "Lcom/stepos/ailauncher/contract/api/speech/ISpeechService;", "Q", "()Lcom/stepos/ailauncher/contract/api/speech/ISpeechService;", "speechService", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VoiceAssistantSupportService extends Service {
    public static final String ACTION_BIND = "com.stepos.ailauncher.voice.support.IVoiceAssistantService";
    private static final String TAG = "VASupportService";
    private IVoiceAssistantCallback currentCallback;
    private String currentPkg;
    private IVoiceAssistantSpeakCallback currentSpeakCallback;
    private boolean isRecognizing;
    private boolean isSpeakingFlag;
    private com.stepos.ailauncher.chat.voice.support.widget.c popView;
    private WindowManager wm;
    private WindowManager.LayoutParams wmParams;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final HashMap<String, IVoiceAssistantCallback> callbacks = new HashMap<>();
    private final HashMap<String, IVoiceAssistantSpeakCallback> speakCallbacks = new HashMap<>();
    private final HashMap<String, ArrayList<String>> appFocuses = new HashMap<>();
    private final HashMap<String, String> hintTexts = new HashMap<>();
    private final HashMap<String, Boolean> needPopWindowMap = new HashMap<>();
    private final List<a> clients = new ArrayList();
    private String popHintText = "";
    private int popBgColor = -1;
    private int nightModeOverride = -1;
    private final VoiceAssistantSupportService$stub$1 stub = new VoiceAssistantSupportService$stub$1(this);
    private final c asrCallback = new c();
    private final d speechAsrCallback = new d();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/support/VoiceAssistantSupportService$a;", "Landroid/os/IBinder$DeathRecipient;", "Landroid/os/IBinder;", M5.b.CREDENTIAL_TOKEN, "", "name", "<init>", "(Lcom/stepos/ailauncher/chat/voice/support/VoiceAssistantSupportService;Landroid/os/IBinder;Ljava/lang/String;)V", "LY8/t;", "binderDied", "()V", "toString", "()Ljava/lang/String;", "Landroid/os/IBinder;", "c", "()Landroid/os/IBinder;", "Ljava/lang/String;", "getName", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class a implements IBinder.DeathRecipient {
        private final String name;
        final /* synthetic */ VoiceAssistantSupportService this$0;
        private final IBinder token;

        public a(VoiceAssistantSupportService voiceAssistantSupportService, IBinder token, String name) {
            kotlin.jvm.internal.p.i(token, "token");
            kotlin.jvm.internal.p.i(name, "name");
            this.this$0 = voiceAssistantSupportService;
            this.token = token;
            this.name = name;
        }

        public static final void b(VoiceAssistantSupportService voiceAssistantSupportService, a aVar) {
            voiceAssistantSupportService.R(aVar.token);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str = String.format("Client.binderDied %s", Arrays.copyOf(new Object[]{this.name}, 1));
            kotlin.jvm.internal.p.h(str, "format(...)");
            C4148a.d(VoiceAssistantSupportService.TAG, str, false, 4, null);
            Handler handler = this.this$0.mainHandler;
            final VoiceAssistantSupportService voiceAssistantSupportService = this.this$0;
            handler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.voice.support.c
                @Override // java.lang.Runnable
                public final void run() {
                    VoiceAssistantSupportService.a.b(voiceAssistantSupportService, this);
                }
            });
        }

        /* renamed from: c, reason: from getter */
        public final IBinder getToken() {
            return this.token;
        }

        public String toString() {
            return "Client[name=" + this.name + ",token=" + this.token + "]";
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J!\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"com/stepos/ailauncher/chat/voice/support/VoiceAssistantSupportService$c", "", "", "finalAsr", "LY8/t;", "c", "(Ljava/lang/String;)V", "currentAsr", Const.INTENT_KEY_PKGNAME, "", "errCode", "errMsg", Const.INTENT_KEY_APIKEY, "(ILjava/lang/String;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c {
        public c() {
        }

        public void a(int errCode, String errMsg) {
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str = String.format("asr onFail: code=%d msg=%s", Arrays.copyOf(new Object[]{Integer.valueOf(errCode), errMsg}, 2));
            kotlin.jvm.internal.p.h(str, "format(...)");
            C4148a.u(VoiceAssistantSupportService.TAG, str, false, 4, null);
            VoiceAssistantSupportService.this.isRecognizing = false;
            IVoiceAssistantCallback iVoiceAssistantCallback = VoiceAssistantSupportService.this.currentCallback;
            if (iVoiceAssistantCallback == null) {
                return;
            }
            if (errCode == -100) {
                try {
                    iVoiceAssistantCallback.onCancel();
                    Y8.t tVar = Y8.t.f7040a;
                    return;
                } catch (RemoteException e10) {
                    C4148a.t(VoiceAssistantSupportService.TAG, "onCancel dispatch failed", e10, false, 8, null);
                    return;
                }
            }
            VoiceAssistantSupportService.this.S();
            VoiceAssistantSupportService voiceAssistantSupportService = VoiceAssistantSupportService.this;
            if (errMsg == null) {
                errMsg = C3081a.ENGINE_ERROR_MSG;
            }
            voiceAssistantSupportService.X(iVoiceAssistantCallback, errCode, errMsg);
        }

        public void b(String currentAsr) {
            com.stepos.ailauncher.chat.voice.support.widget.c cVar;
            C4148a.d(VoiceAssistantSupportService.TAG, "asr onProgress len=" + (currentAsr != null ? currentAsr.length() : 0), false, 4, null);
            IVoiceAssistantCallback iVoiceAssistantCallback = VoiceAssistantSupportService.this.currentCallback;
            if (iVoiceAssistantCallback == null) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("result_type", "msg_part_result");
            intent.putExtra("msg_part_last", false);
            intent.putExtra(C3081a.RESULT_IAT_RAWTEXT, currentAsr == null ? "" : currentAsr);
            try {
                iVoiceAssistantCallback.onVoiceMsgProc(intent);
                if (currentAsr == null || (cVar = VoiceAssistantSupportService.this.popView) == null) {
                    return;
                }
                cVar.setTextPlease(currentAsr);
            } catch (RemoteException e10) {
                C4148a.t(VoiceAssistantSupportService.TAG, "asr onProgress dispatch failed", e10, false, 8, null);
            }
        }

        public void c(String finalAsr) {
            C4148a.d(VoiceAssistantSupportService.TAG, "asr onSuc len=" + (finalAsr != null ? finalAsr.length() : 0), false, 4, null);
            VoiceAssistantSupportService.this.isRecognizing = false;
            VoiceAssistantSupportService.this.S();
            IVoiceAssistantCallback iVoiceAssistantCallback = VoiceAssistantSupportService.this.currentCallback;
            if (iVoiceAssistantCallback == null) {
                C4148a.d(VoiceAssistantSupportService.TAG, "asr onSuc: callback is null", false, 4, null);
                return;
            }
            if (finalAsr == null || finalAsr.length() == 0) {
                VoiceAssistantSupportService.this.X(iVoiceAssistantCallback, -1001, C3081a.CONTENT_EMPTY_ERROR_MSG);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(C3081a.RESULT_IAT_RAWTEXT, H.D1(finalAsr).toString());
            try {
                iVoiceAssistantCallback.onSuccess(intent);
            } catch (RemoteException e10) {
                C4148a.t(VoiceAssistantSupportService.TAG, "asr onSuc dispatch failed", e10, false, 8, null);
            }
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0017\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"com/stepos/ailauncher/chat/voice/support/VoiceAssistantSupportService$d", "Lcom/stepos/ailauncher/contract/api/speech/AsrCallback;", "", "text", "LY8/t;", "onPartialResult", "(Ljava/lang/String;)V", "onFinalResult", "", "code", "message", "onError", "(ILjava/lang/String;)V", "onRecordingStarted", "()V", "onRecordingStopped", "", "data", "onAudioFrame", "([S)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements AsrCallback {
        public d() {
        }

        @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
        public void onAudioFrame(short[] data) {
            kotlin.jvm.internal.p.i(data, "data");
            int iL = VoiceAssistantSupportService.this.L(data);
            com.stepos.ailauncher.chat.voice.support.widget.c cVar = VoiceAssistantSupportService.this.popView;
            if (cVar != null) {
                cVar.q(iL);
            }
        }

        @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
        public void onError(int code, String message) {
            kotlin.jvm.internal.p.i(message, "message");
            VoiceAssistantSupportService.this.asrCallback.a(code, message);
        }

        @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
        public void onFinalResult(String text) {
            kotlin.jvm.internal.p.i(text, "text");
            VoiceAssistantSupportService.this.asrCallback.c(text);
        }

        @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
        public void onPartialResult(String text) {
            kotlin.jvm.internal.p.i(text, "text");
            VoiceAssistantSupportService.this.asrCallback.b(text);
        }

        @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
        public void onRecordingStarted() {
        }

        @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
        public void onRecordingStopped() {
        }

        @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
        public /* bridge */ void onSpeechDetected() {
            super.onSpeechDetected();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/stepos/ailauncher/chat/voice/support/VoiceAssistantSupportService$e", "Lcom/stepos/ailauncher/contract/api/speech/TtsListener;", "LY8/t;", "onPlayStarted", "()V", "onPlayStopped", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e implements TtsListener {
        public e() {
        }

        @Override // com.stepos.ailauncher.contract.api.speech.TtsListener
        public void onPlayStarted() {
            VoiceAssistantSupportService.this.isSpeakingFlag = true;
            try {
                IVoiceAssistantSpeakCallback iVoiceAssistantSpeakCallback = VoiceAssistantSupportService.this.currentSpeakCallback;
                if (iVoiceAssistantSpeakCallback != null) {
                    iVoiceAssistantSpeakCallback.onSpeaking();
                }
                IVoiceAssistantCallback iVoiceAssistantCallback = VoiceAssistantSupportService.this.currentCallback;
                if (iVoiceAssistantCallback != null) {
                    iVoiceAssistantCallback.onSpeakBegan("native");
                }
            } catch (RemoteException e10) {
                C4148a.t(VoiceAssistantSupportService.TAG, "speak onPlayStarted dispatch failed", e10, false, 8, null);
            }
        }

        @Override // com.stepos.ailauncher.contract.api.speech.TtsListener
        public void onPlayStopped() {
            VoiceAssistantSupportService.this.isSpeakingFlag = false;
            try {
                IVoiceAssistantSpeakCallback iVoiceAssistantSpeakCallback = VoiceAssistantSupportService.this.currentSpeakCallback;
                if (iVoiceAssistantSpeakCallback != null) {
                    iVoiceAssistantSpeakCallback.onSpeakOver();
                }
                IVoiceAssistantCallback iVoiceAssistantCallback = VoiceAssistantSupportService.this.currentCallback;
                if (iVoiceAssistantCallback != null) {
                    iVoiceAssistantCallback.onSpeakCompleted(0);
                }
            } catch (RemoteException e10) {
                C4148a.t(VoiceAssistantSupportService.TAG, "speak onPlayStopped dispatch failed", e10, false, 8, null);
            }
        }

        @Override // com.stepos.ailauncher.contract.api.speech.TtsListener
        public /* bridge */ void onStreamInterrupted(String str) {
            super.onStreamInterrupted(str);
        }
    }

    public static final void V(d.a aVar, VoiceAssistantSupportService voiceAssistantSupportService, String str, InterfaceC5063a interfaceC5063a) {
        try {
            aVar.a(voiceAssistantSupportService, str);
            interfaceC5063a.invoke();
        } catch (SecurityException e10) {
            C4148a.u(TAG, "drop " + str + ": " + e10.getMessage(), false, 4, null);
        }
    }

    public final void I() {
        com.stepos.ailauncher.chat.voice.support.widget.c cVar = this.popView;
        if (cVar != null && this.popHintText.length() > 0) {
            cVar.setTextPlease(this.popHintText);
        }
    }

    public final void J() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        com.stepos.ailauncher.chat.voice.support.widget.c cVar = this.popView;
        if (cVar == null) {
            return;
        }
        K(cVar);
    }

    public final void K(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object systemService = getSystemService("uimode");
        UiModeManager uiModeManager = systemService instanceof UiModeManager ? (UiModeManager) systemService : null;
        int i10 = this.nightModeOverride;
        boolean z10 = false;
        if (i10 != 0 && (i10 == 1 || (uiModeManager != null && uiModeManager.getNightMode() == 2))) {
            z10 = true;
        }
        com.stepos.ailauncher.chat.voice.support.widget.c cVar = view instanceof com.stepos.ailauncher.chat.voice.support.widget.c ? (com.stepos.ailauncher.chat.voice.support.widget.c) view : null;
        if (cVar != null) {
            cVar.t(this.nightModeOverride);
        }
        if (z10) {
            try {
                View.class.getDeclaredMethod("actInMzNightMode", Integer.TYPE).invoke(view, 2);
            } catch (Exception unused) {
            }
            if (this.popBgColor == -1) {
                this.popBgColor = -16777216;
            }
        }
        int i11 = this.popBgColor;
        if (i11 != -1) {
            view.setBackgroundColor(i11);
        }
    }

    public final int L(short[] data) {
        if (data.length == 0) {
            return 0;
        }
        double d10 = 0.0d;
        for (short s10 : data) {
            d10 += s10 * s10;
        }
        return C5685n.n((int) ((Math.sqrt(d10 / data.length) / 32768.0d) * 100.0d), 0, 100);
    }

    public final void M() {
        Y8.t tVar;
        com.stepos.ailauncher.chat.voice.support.widget.c cVar = this.popView;
        if (cVar == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            WindowManager windowManager = this.wm;
            if (windowManager != null) {
                windowManager.removeView(cVar);
                tVar = Y8.t.f7040a;
            } else {
                tVar = null;
            }
            Result.b(tVar);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        this.popView = null;
        this.wmParams = null;
    }

    public final void N(String packageName, IBinder token) throws IllegalAccessException, RemoteException, IllegalArgumentException, InvocationTargetException {
        com.stepos.ailauncher.chat.voice.support.widget.c cVar;
        W(packageName);
        this.currentPkg = packageName;
        this.currentCallback = this.callbacks.get(packageName);
        this.appFocuses.get(packageName);
        String str = this.hintTexts.get(packageName);
        if (str == null) {
            str = "";
        }
        this.popHintText = str;
        if (P(token) >= 0) {
            C4148a.d(TAG, "displayWindowInternal: token already added", false, 4, null);
            return;
        }
        a aVar = new a(this, token, packageName + "@" + System.currentTimeMillis());
        try {
            token.linkToDeath(aVar, 0);
            this.clients.add(aVar);
            O();
            I();
            J();
            int i10 = this.popBgColor;
            if (i10 != -1 && (cVar = this.popView) != null) {
                cVar.setBackgroundColor(i10);
            }
            Y();
        } catch (RemoteException e10) {
            C4148a.t(TAG, "linkToDeath failed", e10, false, 8, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void O() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.popView != null) {
            return;
        }
        int identifier = getResources().getIdentifier("AppTheme", "style", getPackageName());
        com.stepos.ailauncher.chat.voice.support.widget.c cVar = new com.stepos.ailauncher.chat.voice.support.widget.c(identifier != 0 ? new i.d(this, identifier) : this);
        cVar.measure(0, 0);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.width = -1;
        layoutParams.height = cVar.getMeasuredHeight();
        layoutParams.type = AMapException.CODE_AMAP_ENGINE_TABLEID_NOT_EXIST;
        layoutParams.format = -2;
        layoutParams.flags = 8;
        layoutParams.gravity = 83;
        layoutParams.setTitle("SF_VoiceAssistantSupportService");
        layoutParams.windowAnimations = getResources().getIdentifier("pop_view_anim", "style", layoutParams.packageName);
        K(cVar);
        if (this.popHintText.length() > 0) {
            cVar.setTextPlease(this.popHintText);
        }
        this.popView = cVar;
        this.wmParams = layoutParams;
        try {
            WindowManager windowManager = this.wm;
            if (windowManager != null) {
                windowManager.addView(cVar, layoutParams);
            }
        } catch (Throwable th) {
            C4148a.g(TAG, "wm.addView failed", th, false, 8, null);
            this.popView = null;
            this.wmParams = null;
        }
    }

    public final int P(IBinder token) {
        Iterator<a> it = this.clients.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (kotlin.jvm.internal.p.d(it.next().getToken(), token)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public final ISpeechService Q() {
        ISpeechService iSpeechService = (ISpeechService) D5.a.INSTANCE.a(ISpeechService.class);
        if (iSpeechService == null || !iSpeechService.isAsrAvailable()) {
            return null;
        }
        return iSpeechService;
    }

    public final void R(IBinder token) {
        int iP = P(token);
        if (iP < 0) {
            C4148a.d(TAG, "hideWindowInternal: token not found", false, 4, null);
            return;
        }
        a aVar = this.clients.get(iP);
        try {
            Result.Companion companion = Result.INSTANCE;
            Result.b(Boolean.valueOf(token.unlinkToDeath(aVar, 0)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        this.clients.remove(iP);
        if (this.clients.isEmpty()) {
            a0();
            M();
        }
    }

    public final void S() {
        com.stepos.ailauncher.chat.voice.support.widget.c cVar = this.popView;
        if (cVar == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            cVar.r();
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public final ArrayList<String> T(int focuses) {
        ArrayList<String> arrayList = new ArrayList<>();
        if ((focuses & 1) != 0) {
            arrayList.add(C3081a.IAT_FOCUS);
        }
        if ((focuses & 2) != 0) {
            arrayList.add("app");
        }
        if ((focuses & 4) != 0) {
            arrayList.add(C3081a.FOCUS_DIALOG_NAME);
        }
        if ((focuses & 8) != 0) {
            arrayList.add(C3081a.CAMERA_FOCUS);
        }
        if ((focuses & 16) != 0) {
            arrayList.add(C3081a.FOCUS_WALLET_NAME);
        }
        if ((focuses & 32) != 0) {
            arrayList.add(C3081a.FOCUS_RESTAURANT_NAME);
        }
        if ((focuses & 64) != 0) {
            arrayList.add("lbs");
        }
        if ((focuses & 128) != 0) {
            arrayList.add(C3081a.FOCUS_MAP_NAME);
        }
        return arrayList;
    }

    public final void U(final String what, final InterfaceC5063a<Y8.t> action) {
        final d.a aVarD = C5.d.INSTANCE.d(this);
        aVarD.a(this, what);
        this.mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.voice.support.b
            @Override // java.lang.Runnable
            public final void run() {
                VoiceAssistantSupportService.V(aVarD, this, what, action);
            }
        });
    }

    public final void W(String packageName) {
        if (this.needPopWindowMap.containsKey(packageName)) {
            return;
        }
        this.needPopWindowMap.put(packageName, Boolean.TRUE);
    }

    public final void X(IVoiceAssistantCallback iVoiceAssistantCallback, int i10, String str) {
        try {
            Intent intent = new Intent();
            intent.putExtra("errorCode", i10);
            intent.putExtra(C3081a.ERROR_MSG, str);
            iVoiceAssistantCallback.onFailure(intent);
        } catch (RemoteException e10) {
            C4148a.t(TAG, "onFailure dispatch failed", e10, false, 8, null);
        }
    }

    public final void Y() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.isRecognizing) {
            C4148a.d(TAG, "startRecognizeInternal: already recognizing, skip", false, 4, null);
            return;
        }
        if (!AuthManager.INSTANCE.p0(this)) {
            C4148a.u(TAG, "startRecognizeInternal: AI engine not ready", false, 4, null);
            this.isRecognizing = false;
            IVoiceAssistantCallback iVoiceAssistantCallback = this.currentCallback;
            if (iVoiceAssistantCallback != null) {
                X(iVoiceAssistantCallback, -1002, C3081a.NOT_READY_FOR_RECOGNIZE_MSG);
                return;
            }
            return;
        }
        ISpeechService iSpeechServiceQ = Q();
        if (iSpeechServiceQ == null) {
            C4148a.u(TAG, "startRecognizeInternal: AIEngine ASR unavailable", false, 4, null);
            this.isRecognizing = false;
            IVoiceAssistantCallback iVoiceAssistantCallback2 = this.currentCallback;
            if (iVoiceAssistantCallback2 != null) {
                X(iVoiceAssistantCallback2, -1002, C3081a.NOT_READY_FOR_RECOGNIZE_MSG);
                return;
            }
            return;
        }
        O();
        if (this.popView == null) {
            C4148a.u(TAG, "startRecognizeInternal: popView is null", false, 4, null);
            return;
        }
        this.isRecognizing = true;
        try {
            IVoiceAssistantCallback iVoiceAssistantCallback3 = this.currentCallback;
            if (iVoiceAssistantCallback3 != null) {
                iVoiceAssistantCallback3.onRecordStart();
            }
        } catch (RemoteException e10) {
            C4148a.t(TAG, "onRecordStart dispatch failed", e10, false, 8, null);
        }
        iSpeechServiceQ.startListening(this.speechAsrCallback);
    }

    public final void Z(String text) {
        if (text == null || text.length() == 0) {
            C4148a.d(TAG, "startSpeakInternal: empty text, skip", false, 4, null);
            return;
        }
        if (MicConflictPolicy.INSTANCE.e()) {
            C4148a.d(TAG, "startSpeakInternal: suppressed concurrent mic occupancy", false, 4, null);
            return;
        }
        if (!AuthManager.INSTANCE.p0(this)) {
            C4148a.u(TAG, "startSpeakInternal: AI engine not ready", false, 4, null);
            return;
        }
        try {
            IVoiceAssistantSpeakCallback iVoiceAssistantSpeakCallback = this.currentSpeakCallback;
            if (iVoiceAssistantSpeakCallback != null) {
                iVoiceAssistantSpeakCallback.onInit();
            }
        } catch (RemoteException e10) {
            C4148a.t(TAG, "speak onInit dispatch failed", e10, false, 8, null);
        }
        ISpeechService iSpeechService = (ISpeechService) D5.a.INSTANCE.a(ISpeechService.class);
        if (iSpeechService == null || !iSpeechService.isTtsAvailable()) {
            iSpeechService = null;
        }
        if (iSpeechService != null) {
            iSpeechService.stopSpeak();
            iSpeechService.speak(text, new e());
            return;
        }
        C4148a.u(TAG, "startSpeakInternal: AIEngine TTS unavailable", false, 4, null);
        this.isSpeakingFlag = false;
        try {
            IVoiceAssistantSpeakCallback iVoiceAssistantSpeakCallback2 = this.currentSpeakCallback;
            if (iVoiceAssistantSpeakCallback2 != null) {
                iVoiceAssistantSpeakCallback2.onSpeakOver();
            }
            IVoiceAssistantCallback iVoiceAssistantCallback = this.currentCallback;
            if (iVoiceAssistantCallback != null) {
                iVoiceAssistantCallback.onSpeakCompleted(-1);
            }
        } catch (RemoteException e11) {
            C4148a.t(TAG, "speak unavailable dispatch failed", e11, false, 8, null);
        }
    }

    public final void a0() {
        if (this.isRecognizing) {
            ISpeechService iSpeechServiceQ = Q();
            if (iSpeechServiceQ != null) {
                iSpeechServiceQ.stopAndFinalize();
            }
            this.isRecognizing = false;
        }
    }

    public final void b0() {
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
            try {
                IVoiceAssistantCallback iVoiceAssistantCallback = this.currentCallback;
                if (iVoiceAssistantCallback != null) {
                    iVoiceAssistantCallback.onSpeakInterrupted();
                }
                IVoiceAssistantSpeakCallback iVoiceAssistantSpeakCallback = this.currentSpeakCallback;
                if (iVoiceAssistantSpeakCallback != null) {
                    iVoiceAssistantSpeakCallback.onSpeakOver();
                }
            } catch (RemoteException e10) {
                C4148a.t(TAG, "stopSpeak dispatch failed", e10, false, 8, null);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if (action == null || kotlin.jvm.internal.p.d(action, "com.stepos.ailauncher.voice.support.IVoiceAssistantService")) {
            return this.stub;
        }
        C4148a.u(TAG, "onBind rejected: unexpected action", false, 4, null);
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C4148a.d(TAG, "onCreate", false, 4, null);
        Object systemService = getSystemService("window");
        kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.wm = (WindowManager) systemService;
    }

    @Override // android.app.Service
    public void onDestroy() {
        C4148a.d(TAG, "onDestroy", false, 4, null);
        ISpeechService iSpeechServiceQ = Q();
        if (iSpeechServiceQ != null) {
            iSpeechServiceQ.cancelAsr();
        }
        ISpeechService iSpeechService = (ISpeechService) D5.a.INSTANCE.a(ISpeechService.class);
        if (iSpeechService != null) {
            ISpeechService iSpeechService2 = iSpeechService.isTtsAvailable() ? iSpeechService : null;
            if (iSpeechService2 != null) {
                iSpeechService2.stopSpeak();
            }
        }
        M();
        for (a aVar : this.clients) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Result.b(Boolean.valueOf(aVar.getToken().unlinkToDeath(aVar, 0)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
        this.clients.clear();
        super.onDestroy();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("onUnbind intent=%s", Arrays.copyOf(new Object[]{intent}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        return super.onUnbind(intent);
    }
}
