package com.bytedance.android.livesdk.live.extension.plugin.api.vesdk.editor_jni;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdkapi.depend.model.LocalSubStickerItem;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/vesdk/editor_jni/LiveWrappedNLETrackType;", "", "", "swigValue", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, UserProfileEvent.POSITION_NONE, "AUDIO", "VIDEO", "STICKER", "EFFECT", LocalSubStickerItem.BEAUTY_TYPE_FILTER, "IMAGE", "MV", "EFFECT_STICKER", "IMAGE_TEMPLATE_EFFECT", "VIRTUAL", "LAYER_STICKER", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedNLETrackType extends Enum<LiveWrappedNLETrackType> {
    public static final LiveWrappedNLETrackType AUDIO = null;
    public static final LiveWrappedNLETrackType EFFECT = null;
    public static final LiveWrappedNLETrackType EFFECT_STICKER = null;
    public static final LiveWrappedNLETrackType FILTER = null;
    public static final LiveWrappedNLETrackType IMAGE = null;
    public static final LiveWrappedNLETrackType IMAGE_TEMPLATE_EFFECT = null;
    public static final LiveWrappedNLETrackType LAYER_STICKER = null;
    public static final LiveWrappedNLETrackType MV = null;
    public static final LiveWrappedNLETrackType NONE = null;
    public static final LiveWrappedNLETrackType STICKER = null;
    public static final LiveWrappedNLETrackType VIDEO = null;
    public static final LiveWrappedNLETrackType VIRTUAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedNLETrackType[] f147475a = null;
    private final int swigValue;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static int f147476a;

        static {
        }
    }

    public static LiveWrappedNLETrackType valueOf(String r100) {
        return (LiveWrappedNLETrackType) r27.a.a(LiveWrappedNLETrackType.class, r100);
    }

    public static LiveWrappedNLETrackType[] values() {
        return (LiveWrappedNLETrackType[]) f147475a.clone();
    }

    static {
        LiveWrappedNLETrackType r100 = new LiveWrappedNLETrackType(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        LiveWrappedNLETrackType r101 = new LiveWrappedNLETrackType("AUDIO", 1, 1);
        AUDIO = r101;
        LiveWrappedNLETrackType r102 = new LiveWrappedNLETrackType("VIDEO", 2, 2);
        VIDEO = r102;
        LiveWrappedNLETrackType r103 = new LiveWrappedNLETrackType("STICKER", 3, 3);
        STICKER = r103;
        LiveWrappedNLETrackType r104 = new LiveWrappedNLETrackType("EFFECT", 4, 4);
        EFFECT = r104;
        LiveWrappedNLETrackType r105 = new LiveWrappedNLETrackType(LocalSubStickerItem.BEAUTY_TYPE_FILTER, 5, 5);
        FILTER = r105;
        LiveWrappedNLETrackType r106 = new LiveWrappedNLETrackType("IMAGE", 6, 6);
        IMAGE = r106;
        LiveWrappedNLETrackType r107 = new LiveWrappedNLETrackType("MV", 7, 7);
        MV = r107;
        LiveWrappedNLETrackType r108 = new LiveWrappedNLETrackType("EFFECT_STICKER", 8, 8);
        EFFECT_STICKER = r108;
        LiveWrappedNLETrackType r109 = new LiveWrappedNLETrackType("IMAGE_TEMPLATE_EFFECT", 9, 9);
        IMAGE_TEMPLATE_EFFECT = r109;
        LiveWrappedNLETrackType r110 = new LiveWrappedNLETrackType("VIRTUAL", 10, 10);
        VIRTUAL = r110;
        LiveWrappedNLETrackType r111 = new LiveWrappedNLETrackType();
        LAYER_STICKER = r111;
        f147475a = new LiveWrappedNLETrackType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111};
    }

    public LiveWrappedNLETrackType() {
        super("LAYER_STICKER", 11);
        int r100 = a.f147476a;
        a.f147476a = r100 + 1;
        this.swigValue = r100;
    }

    public LiveWrappedNLETrackType(String r100, int r101, int r102) {
        super(r100, r101);
        this.swigValue = r102;
        a.f147476a = r102 + 1;
    }
}
