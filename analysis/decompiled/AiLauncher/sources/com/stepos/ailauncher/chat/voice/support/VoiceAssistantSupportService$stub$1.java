package com.stepos.ailauncher.chat.voice.support;

import C5.d;
import La.H;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.stepos.ailauncher.voice.support.IVoiceAssistantCallback;
import com.stepos.ailauncher.voice.support.IVoiceAssistantService;
import com.stepos.ailauncher.voice.support.IVoiceAssistantSpeakCallback;
import h8.C4148a;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000M\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0019\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010!\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0006H\u0016¢\u0006\u0004\b#\u0010$J!\u0010&\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b(\u0010\u000eJ!\u0010)\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b)\u0010\u001eJ\u000f\u0010*\u001a\u00020\u0015H\u0016¢\u0006\u0004\b*\u0010\u0017J\u000f\u0010+\u001a\u00020\u0006H\u0016¢\u0006\u0004\b+\u0010$J!\u0010-\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b-\u0010\u001eJ\u0017\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0004H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0015H\u0016¢\u0006\u0004\b2\u00103¨\u00064"}, d2 = {"com/stepos/ailauncher/chat/voice/support/VoiceAssistantSupportService$stub$1", "Lcom/stepos/ailauncher/voice/support/IVoiceAssistantService$Stub;", "", "packageName", "", "focuses", "LY8/t;", "setFocuses", "(Ljava/lang/String;I)V", "Lcom/stepos/ailauncher/voice/support/IVoiceAssistantCallback;", "callback", "registerCallback", "(Ljava/lang/String;Lcom/stepos/ailauncher/voice/support/IVoiceAssistantCallback;)V", "unregisterCallback", "(Ljava/lang/String;)V", "Landroid/os/IBinder;", M5.b.CREDENTIAL_TOKEN, "displayPopWindow", "(Ljava/lang/String;Landroid/os/IBinder;)V", "hidePopWindow", "(Landroid/os/IBinder;)V", "", "isPopWindowShowing", "()Z", "", "localScene", "runVoiceRecognize", "(Ljava/lang/String;[Ljava/lang/String;)V", "text", "runTextRecognize", "(Ljava/lang/String;Ljava/lang/String;)V", "", "timeNode", "runWakeRecognize", "(Ljava/lang/String;J)V", "runStopRecognize", "()V", "Lcom/stepos/ailauncher/voice/support/IVoiceAssistantSpeakCallback;", "registerOnSpeakCallback", "(Ljava/lang/String;Lcom/stepos/ailauncher/voice/support/IVoiceAssistantSpeakCallback;)V", "unregisterOnSpeakCallback", "runStartSpeak", "isSpeaking", "runStopSpeak", "hintText", "setHintText", "color", "setBackgroundColor", "(I)V", "nightModeOn", "overridePopWindowNightMode", "(Z)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VoiceAssistantSupportService$stub$1 extends IVoiceAssistantService.Stub {
    final /* synthetic */ VoiceAssistantSupportService this$0;

    public VoiceAssistantSupportService$stub$1(VoiceAssistantSupportService voiceAssistantSupportService) {
        this.this$0 = voiceAssistantSupportService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t displayPopWindow$lambda$3(VoiceAssistantSupportService voiceAssistantSupportService, String str, IBinder iBinder) throws IllegalAccessException, RemoteException, IllegalArgumentException, InvocationTargetException {
        voiceAssistantSupportService.N(str, iBinder);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t hidePopWindow$lambda$4(VoiceAssistantSupportService voiceAssistantSupportService, IBinder iBinder) {
        voiceAssistantSupportService.R(iBinder);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t overridePopWindowNightMode$lambda$14(VoiceAssistantSupportService voiceAssistantSupportService, boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        voiceAssistantSupportService.nightModeOverride = z10 ? 1 : 0;
        voiceAssistantSupportService.J();
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t registerCallback$lambda$1(VoiceAssistantSupportService voiceAssistantSupportService, String str, IVoiceAssistantCallback iVoiceAssistantCallback) {
        voiceAssistantSupportService.currentPkg = str;
        voiceAssistantSupportService.callbacks.put(str, iVoiceAssistantCallback);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t registerOnSpeakCallback$lambda$8(VoiceAssistantSupportService voiceAssistantSupportService, String str, IVoiceAssistantSpeakCallback iVoiceAssistantSpeakCallback) {
        voiceAssistantSupportService.currentPkg = str;
        voiceAssistantSupportService.speakCallbacks.put(str, iVoiceAssistantSpeakCallback);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t runStartSpeak$lambda$10(VoiceAssistantSupportService voiceAssistantSupportService, String str, String str2) {
        voiceAssistantSupportService.currentPkg = str;
        voiceAssistantSupportService.currentSpeakCallback = (IVoiceAssistantSpeakCallback) voiceAssistantSupportService.speakCallbacks.get(str);
        voiceAssistantSupportService.currentCallback = (IVoiceAssistantCallback) voiceAssistantSupportService.callbacks.get(str);
        voiceAssistantSupportService.Z(str2);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t runStopRecognize$lambda$7(VoiceAssistantSupportService voiceAssistantSupportService) {
        voiceAssistantSupportService.a0();
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t runStopSpeak$lambda$11(VoiceAssistantSupportService voiceAssistantSupportService) {
        voiceAssistantSupportService.b0();
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t runTextRecognize$lambda$6(VoiceAssistantSupportService voiceAssistantSupportService, String str, String str2) {
        voiceAssistantSupportService.currentPkg = str;
        voiceAssistantSupportService.currentCallback = (IVoiceAssistantCallback) voiceAssistantSupportService.callbacks.get(str);
        IVoiceAssistantCallback iVoiceAssistantCallback = voiceAssistantSupportService.currentCallback;
        if (iVoiceAssistantCallback == null) {
            return Y8.t.f7040a;
        }
        if (str2 == null || str2.length() == 0) {
            voiceAssistantSupportService.X(iVoiceAssistantCallback, -1001, C3081a.CONTENT_EMPTY_ERROR_MSG);
        } else {
            Intent intent = new Intent();
            intent.putExtra(C3081a.RESULT_IAT_RAWTEXT, H.D1(str2).toString());
            try {
                iVoiceAssistantCallback.onSuccess(intent);
                Y8.t tVar = Y8.t.f7040a;
            } catch (RemoteException e10) {
                C4148a.t("VASupportService", "runTextRecognize dispatch failed", e10, false, 8, null);
            }
        }
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t runVoiceRecognize$lambda$5(VoiceAssistantSupportService voiceAssistantSupportService, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        voiceAssistantSupportService.currentPkg = str;
        voiceAssistantSupportService.currentCallback = (IVoiceAssistantCallback) voiceAssistantSupportService.callbacks.get(str);
        voiceAssistantSupportService.Y();
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t setBackgroundColor$lambda$13(VoiceAssistantSupportService voiceAssistantSupportService, int i10) {
        voiceAssistantSupportService.popBgColor = i10;
        com.stepos.ailauncher.chat.voice.support.widget.c cVar = voiceAssistantSupportService.popView;
        if (cVar != null) {
            cVar.setBackgroundColor(i10);
        }
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t setFocuses$lambda$0(VoiceAssistantSupportService voiceAssistantSupportService, String str, int i10) {
        voiceAssistantSupportService.currentPkg = str;
        voiceAssistantSupportService.W(str);
        voiceAssistantSupportService.appFocuses.put(str, voiceAssistantSupportService.T(i10));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t setHintText$lambda$12(String str, VoiceAssistantSupportService voiceAssistantSupportService, String str2) {
        if (str != null) {
            voiceAssistantSupportService.hintTexts.put(str2, str);
        }
        if (kotlin.jvm.internal.p.d(str2, voiceAssistantSupportService.currentPkg)) {
            if (str == null) {
                str = "";
            }
            voiceAssistantSupportService.popHintText = str;
            voiceAssistantSupportService.I();
        }
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t unregisterCallback$lambda$2(VoiceAssistantSupportService voiceAssistantSupportService, String str) {
        voiceAssistantSupportService.callbacks.remove(str);
        if (kotlin.jvm.internal.p.d(voiceAssistantSupportService.currentPkg, str)) {
            voiceAssistantSupportService.currentCallback = null;
        }
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t unregisterOnSpeakCallback$lambda$9(VoiceAssistantSupportService voiceAssistantSupportService, String str) {
        voiceAssistantSupportService.speakCallbacks.remove(str);
        if (kotlin.jvm.internal.p.d(voiceAssistantSupportService.currentPkg, str)) {
            voiceAssistantSupportService.currentSpeakCallback = null;
        }
        return Y8.t.f7040a;
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
    public void displayPopWindow(String packageName, final IBinder token) {
        kotlin.jvm.internal.p.i(packageName, "packageName");
        C5.d dVar = C5.d.INSTANCE;
        dVar.g(this.this$0, "displayPopWindow");
        final String strB = dVar.b(this.this$0);
        C4148a.d("VASupportService", "displayPopWindow caller=" + strB, false, 4, null);
        if (token == null) {
            throw new SecurityException("displayPopWindow denied: empty token");
        }
        final VoiceAssistantSupportService voiceAssistantSupportService = this.this$0;
        voiceAssistantSupportService.U("displayPopWindow", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.support.i
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceAssistantSupportService$stub$1.displayPopWindow$lambda$3(voiceAssistantSupportService, strB, token);
            }
        });
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
    public void hidePopWindow(final IBinder token) {
        C5.d.INSTANCE.g(this.this$0, "hidePopWindow");
        C4148a.d("VASupportService", "hidePopWindow", false, 4, null);
        if (token == null) {
            throw new SecurityException("hidePopWindow denied: empty token");
        }
        final VoiceAssistantSupportService voiceAssistantSupportService = this.this$0;
        voiceAssistantSupportService.U("hidePopWindow", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.support.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceAssistantSupportService$stub$1.hidePopWindow$lambda$4(voiceAssistantSupportService, token);
            }
        });
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
    public boolean isPopWindowShowing() {
        C5.d.INSTANCE.g(this.this$0, "isPopWindowShowing");
        com.stepos.ailauncher.chat.voice.support.widget.c cVar = this.this$0.popView;
        boolean z10 = (cVar != null ? cVar.getWindowToken() : null) != null;
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("isPopWindowShowing=%s", Arrays.copyOf(new Object[]{Boolean.valueOf(z10)}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d("VASupportService", str, false, 4, null);
        return z10;
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
    public boolean isSpeaking() {
        C5.d.INSTANCE.g(this.this$0, "isSpeaking");
        return this.this$0.isSpeakingFlag;
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
    public void overridePopWindowNightMode(final boolean nightModeOn) {
        C5.d.INSTANCE.g(this.this$0, "overridePopWindowNightMode");
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("overridePopWindowNightMode on=%s", Arrays.copyOf(new Object[]{Boolean.valueOf(nightModeOn)}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d("VASupportService", str, false, 4, null);
        final VoiceAssistantSupportService voiceAssistantSupportService = this.this$0;
        voiceAssistantSupportService.U("overridePopWindowNightMode", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.support.m
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceAssistantSupportService$stub$1.overridePopWindowNightMode$lambda$14(voiceAssistantSupportService, nightModeOn);
            }
        });
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
    public void registerCallback(String packageName, final IVoiceAssistantCallback callback) {
        kotlin.jvm.internal.p.i(packageName, "packageName");
        d.a aVarD = C5.d.INSTANCE.d(this.this$0);
        aVarD.a(this.this$0, "registerCallback");
        final String key = aVarD.getKey();
        if (callback == null) {
            throw new SecurityException("registerCallback denied: null callback");
        }
        C4148a.d("VASupportService", "registerCallback caller=" + key, false, 4, null);
        final VoiceAssistantSupportService voiceAssistantSupportService = this.this$0;
        voiceAssistantSupportService.U("registerCallback", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.support.h
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceAssistantSupportService$stub$1.registerCallback$lambda$1(voiceAssistantSupportService, key, callback);
            }
        });
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
    public void registerOnSpeakCallback(String packageName, final IVoiceAssistantSpeakCallback callback) {
        kotlin.jvm.internal.p.i(packageName, "packageName");
        d.a aVarD = C5.d.INSTANCE.d(this.this$0);
        aVarD.a(this.this$0, "registerOnSpeakCallback");
        final String key = aVarD.getKey();
        if (callback == null) {
            throw new SecurityException("registerOnSpeakCallback denied: null callback");
        }
        C4148a.d("VASupportService", "registerOnSpeakCallback caller=" + key, false, 4, null);
        final VoiceAssistantSupportService voiceAssistantSupportService = this.this$0;
        voiceAssistantSupportService.U("registerOnSpeakCallback", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.support.g
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceAssistantSupportService$stub$1.registerOnSpeakCallback$lambda$8(voiceAssistantSupportService, key, callback);
            }
        });
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
    public void runStartSpeak(String packageName, final String text) {
        kotlin.jvm.internal.p.i(packageName, "packageName");
        d.a aVarD = C5.d.INSTANCE.d(this.this$0);
        aVarD.a(this.this$0, "runStartSpeak");
        final String key = aVarD.getKey();
        C4148a.d("VASupportService", "runStartSpeak caller=" + key + " len=" + (text != null ? text.length() : 0), false, 4, null);
        final VoiceAssistantSupportService voiceAssistantSupportService = this.this$0;
        voiceAssistantSupportService.U("runStartSpeak", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.support.n
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceAssistantSupportService$stub$1.runStartSpeak$lambda$10(voiceAssistantSupportService, key, text);
            }
        });
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
    public void runStopRecognize() {
        C5.d.INSTANCE.g(this.this$0, "runStopRecognize");
        C4148a.d("VASupportService", "runStopRecognize", false, 4, null);
        final VoiceAssistantSupportService voiceAssistantSupportService = this.this$0;
        voiceAssistantSupportService.U("runStopRecognize", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.support.k
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceAssistantSupportService$stub$1.runStopRecognize$lambda$7(voiceAssistantSupportService);
            }
        });
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
    public void runStopSpeak() {
        C5.d.INSTANCE.g(this.this$0, "runStopSpeak");
        C4148a.d("VASupportService", "runStopSpeak", false, 4, null);
        final VoiceAssistantSupportService voiceAssistantSupportService = this.this$0;
        voiceAssistantSupportService.U("runStopSpeak", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.support.q
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceAssistantSupportService$stub$1.runStopSpeak$lambda$11(voiceAssistantSupportService);
            }
        });
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
    public void runTextRecognize(String packageName, final String text) {
        kotlin.jvm.internal.p.i(packageName, "packageName");
        d.a aVarD = C5.d.INSTANCE.d(this.this$0);
        aVarD.a(this.this$0, "runTextRecognize");
        final String key = aVarD.getKey();
        C4148a.d("VASupportService", "runTextRecognize caller=" + key + " len=" + (text != null ? text.length() : 0), false, 4, null);
        final VoiceAssistantSupportService voiceAssistantSupportService = this.this$0;
        voiceAssistantSupportService.U("runTextRecognize", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.support.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceAssistantSupportService$stub$1.runTextRecognize$lambda$6(voiceAssistantSupportService, key, text);
            }
        });
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
    public void runVoiceRecognize(String packageName, String[] localScene) {
        kotlin.jvm.internal.p.i(packageName, "packageName");
        d.a aVarD = C5.d.INSTANCE.d(this.this$0);
        aVarD.a(this.this$0, "runVoiceRecognize");
        final String key = aVarD.getKey();
        C4148a.d("VASupportService", "runVoiceRecognize caller=" + key, false, 4, null);
        final VoiceAssistantSupportService voiceAssistantSupportService = this.this$0;
        voiceAssistantSupportService.U("runVoiceRecognize", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.support.r
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceAssistantSupportService$stub$1.runVoiceRecognize$lambda$5(voiceAssistantSupportService, key);
            }
        });
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
    public void runWakeRecognize(String packageName, long timeNode) {
        kotlin.jvm.internal.p.i(packageName, "packageName");
        C5.d.INSTANCE.g(this.this$0, "runWakeRecognize");
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("runWakeRecognize timeNode=%d", Arrays.copyOf(new Object[]{Long.valueOf(timeNode)}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d("VASupportService", str, false, 4, null);
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
    public void setBackgroundColor(final int color) {
        C5.d.INSTANCE.g(this.this$0, "setBackgroundColor");
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("setBackgroundColor color=%d", Arrays.copyOf(new Object[]{Integer.valueOf(color)}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d("VASupportService", str, false, 4, null);
        final VoiceAssistantSupportService voiceAssistantSupportService = this.this$0;
        voiceAssistantSupportService.U("setBackgroundColor", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.support.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceAssistantSupportService$stub$1.setBackgroundColor$lambda$13(voiceAssistantSupportService, color);
            }
        });
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
    public void setFocuses(String packageName, final int focuses) {
        kotlin.jvm.internal.p.i(packageName, "packageName");
        d.a aVarD = C5.d.INSTANCE.d(this.this$0);
        aVarD.a(this.this$0, "setFocuses");
        final String key = aVarD.getKey();
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("setFocuses caller=%s focuses=0x%x", Arrays.copyOf(new Object[]{key, Integer.valueOf(focuses)}, 2));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d("VASupportService", str, false, 4, null);
        final VoiceAssistantSupportService voiceAssistantSupportService = this.this$0;
        voiceAssistantSupportService.U("setFocuses", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.support.j
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceAssistantSupportService$stub$1.setFocuses$lambda$0(voiceAssistantSupportService, key, focuses);
            }
        });
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
    public void setHintText(final String hintText, String packageName) {
        kotlin.jvm.internal.p.i(packageName, "packageName");
        d.a aVarD = C5.d.INSTANCE.d(this.this$0);
        aVarD.a(this.this$0, "setHintText");
        final String key = aVarD.getKey();
        C4148a.d("VASupportService", "setHintText caller=" + key, false, 4, null);
        final VoiceAssistantSupportService voiceAssistantSupportService = this.this$0;
        voiceAssistantSupportService.U("setHintText", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.support.p
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceAssistantSupportService$stub$1.setHintText$lambda$12(hintText, voiceAssistantSupportService, key);
            }
        });
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
    public void unregisterCallback(String packageName) {
        kotlin.jvm.internal.p.i(packageName, "packageName");
        d.a aVarD = C5.d.INSTANCE.d(this.this$0);
        aVarD.a(this.this$0, "unregisterCallback");
        final String key = aVarD.getKey();
        C4148a.d("VASupportService", "unregisterCallback caller=" + key, false, 4, null);
        final VoiceAssistantSupportService voiceAssistantSupportService = this.this$0;
        voiceAssistantSupportService.U("unregisterCallback", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.support.o
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceAssistantSupportService$stub$1.unregisterCallback$lambda$2(voiceAssistantSupportService, key);
            }
        });
    }

    @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
    public void unregisterOnSpeakCallback(String packageName) {
        kotlin.jvm.internal.p.i(packageName, "packageName");
        d.a aVarD = C5.d.INSTANCE.d(this.this$0);
        aVarD.a(this.this$0, "unregisterOnSpeakCallback");
        final String key = aVarD.getKey();
        C4148a.d("VASupportService", "unregisterOnSpeakCallback caller=" + key, false, 4, null);
        final VoiceAssistantSupportService voiceAssistantSupportService = this.this$0;
        voiceAssistantSupportService.U("unregisterOnSpeakCallback", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.support.l
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceAssistantSupportService$stub$1.unregisterOnSpeakCallback$lambda$9(voiceAssistantSupportService, key);
            }
        });
    }
}
