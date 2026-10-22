package com.bytedance.android.livesdkapi.depend.model.live.audio;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.lynx.canvas.KryptonCamera;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\bf\u0018\u0000 \u000e2\u00020\u0001:\u0003\u000e\u000f\u0010R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/audio/ISpeakingImageDef;", "", "Lpy/k;", "getLow", "()Lpy/k;", "getLow$annotations", "()V", "low", "getMedium", "getMedium$annotations", KryptonCamera.Config.RESOLUTION_MEDIUM, "getHigh", "getHigh$annotations", "high", "Companion", "ValidVoiceVolume", "VoiceVolume", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ISpeakingImageDef {
    public static final Companion Companion = null;
    public static final int HIGH = 3;
    public static final int LOW = 1;
    public static final int MEDIUM = 2;
    public static final int NONE = 0;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/audio/ISpeakingImageDef$Companion;", "", "()V", "HIGH", "", "LOW", "MEDIUM", UserProfileEvent.POSITION_NONE, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int HIGH = 3;
        public static final int LOW = 1;
        public static final int MEDIUM = 2;
        public static final int NONE = 0;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "speaking_high_image")
        public static /* synthetic */ void getHigh$annotations() {
        }

        @FieldName(name = "speaking_low_image")
        public static /* synthetic */ void getLow$annotations() {
        }

        @FieldName(name = "speaking_default_image")
        public static /* synthetic */ void getMedium$annotations() {
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/audio/ISpeakingImageDef$ValidVoiceVolume;", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public @interface ValidVoiceVolume {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/audio/ISpeakingImageDef$VoiceVolume;", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public @interface VoiceVolume {
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    k getHigh();

    k getLow();

    k getMedium();
}
