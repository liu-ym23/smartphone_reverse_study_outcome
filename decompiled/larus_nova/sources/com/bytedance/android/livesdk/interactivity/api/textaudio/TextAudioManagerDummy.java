package com.bytedance.android.livesdk.interactivity.api.textaudio;

import android.content.Context;
import com.bytedance.android.livesdkapi.depend.model.broadcast.IBroadcastStream;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.xiaomi.mipush.sdk.MiPushClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t52.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/textaudio/TextAudioManagerDummy;", "Lcom/bytedance/android/livesdk/interactivity/api/textaudio/BaseTextAudioManager;", "Lt52/a$b;", "listener", "", MiPushClient.COMMAND_REGISTER, MiPushClient.COMMAND_UNREGISTER, "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/IBroadcastStream;", "liveStream", "setLiveStream", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lt52/a$a;", "audioInfo", "playAudioByPath", "playAudioByUrl", "stopAudio", "", "isPlaying", "getPlaying", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TextAudioManagerDummy extends BaseTextAudioManager {
    public static final TextAudioManagerDummy INSTANCE = null;

    @Override // com.bytedance.android.livesdk.interactivity.api.textaudio.BaseTextAudioManager, t52.a
    public a.C7687a getPlaying() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.textaudio.BaseTextAudioManager, t52.a
    public boolean isPlaying() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.textaudio.BaseTextAudioManager, t52.a
    public void playAudioByPath(Context r100, a.C7687a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "audioInfo");
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.textaudio.BaseTextAudioManager, t52.a
    public void playAudioByUrl(Context r100, a.C7687a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "audioInfo");
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.textaudio.BaseTextAudioManager, t52.a
    public void register(a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.textaudio.BaseTextAudioManager, t52.a
    public void setLiveStream(IBroadcastStream r100) {
        Intrinsics.checkNotNullParameter(r100, "liveStream");
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.textaudio.BaseTextAudioManager, t52.a
    public void stopAudio() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.textaudio.BaseTextAudioManager, t52.a
    public void unregister(a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    static {
        INSTANCE = new TextAudioManagerDummy();
    }

    private TextAudioManagerDummy() {
    }
}
