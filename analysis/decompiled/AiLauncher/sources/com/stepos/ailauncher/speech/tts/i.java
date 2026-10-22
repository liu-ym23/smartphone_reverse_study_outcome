package com.stepos.ailauncher.speech.tts;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.speech.TtsListener;
import com.stepos.ailauncher.contract.api.speech.TtsStreamSession;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000bH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u0012J\u000f\u0010\u0016\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\u0012J\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000bH&¢\u0006\u0004\b\u001b\u0010\u0012¨\u0006\u001cÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/i;", "", "Landroid/content/Context;", "context", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Z", "", "text", "Lcom/stepos/ailauncher/contract/api/speech/TtsListener;", "listener", "LY8/t;", "speak", "(Ljava/lang/String;Lcom/stepos/ailauncher/contract/api/speech/TtsListener;)V", "Lcom/stepos/ailauncher/contract/api/speech/TtsStreamSession;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/contract/api/speech/TtsListener;)Lcom/stepos/ailauncher/contract/api/speech/TtsStreamSession;", com.stepos.ailauncher.chat.trace.g.ACTION_STOP, "()V", "isSpeaking", "()Z", "pause", "resume", "", "gain", "c", "(F)V", "destroy", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface i {
    boolean a(Context context);

    TtsStreamSession b(TtsListener listener);

    default void c(float gain) {
    }

    void destroy();

    boolean isSpeaking();

    default void pause() {
    }

    default void resume() {
    }

    void speak(String text, TtsListener listener);

    void stop();
}
