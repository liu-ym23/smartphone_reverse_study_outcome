package com.stepos.ailauncher.chat.wake;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.manager.InputViewManager;
import com.stepos.ailauncher.chat.view.BaseInputView;
import h8.C4148a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00068\u0016X\u0096D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/S;", "Lcom/stepos/ailauncher/chat/wake/N1;", "<init>", "()V", "Landroid/content/Context;", "context", "", "source", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Ljava/lang/String;)Z", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class S implements N1 {
    public static final S INSTANCE = new S();
    private static final String name = "SelfRecordingVoiceWakeup";

    @Override // com.stepos.ailauncher.chat.wake.N1
    public boolean a(Context context, String source) {
        kotlin.jvm.internal.p.i(context, "context");
        BaseInputView baseInputViewR0 = InputViewManager.INSTANCE.r0();
        boolean zF = Q1.f(source, baseInputViewR0 != null && baseInputViewR0.a8(), baseInputViewR0 != null && baseInputViewR0.getListenModeActive(), baseInputViewR0 != null && baseInputViewR0.R7());
        if (!zF) {
            C4148a.d("WakeGuard", "SelfRecordingVoiceWakeup: VOICE_WAKEUP suppressed, inputView recording", false, 4, null);
        }
        return zF;
    }

    @Override // com.stepos.ailauncher.chat.wake.N1
    public String getName() {
        return name;
    }
}
