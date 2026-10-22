package com.bytedance.android.live.core.resources;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b1\u00102R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\u001c\u0010#\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u0017R\u001c\u0010%\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0015\u001a\u0004\b&\u0010\u0017R\u001a\u0010(\u001a\u00020'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001c\u0010-\u001a\u0004\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/bytedance/android/live/core/resources/LokiExtraKtSerializableObjectImpl;", "Lcom/bytedance/android/live/core/resources/h;", "", "needScreenShot", "Z", "getNeedScreenShot", "()Z", "Lcom/bytedance/android/live/core/resources/h$b;", "size", "Lcom/bytedance/android/live/core/resources/h$b;", "getSize", "()Lcom/bytedance/android/live/core/resources/h$b;", "", "fps", "I", "getFps", "()I", "fitMode", "getFitMode", "", "modelNames", "Ljava/lang/String;", "l3", "()Ljava/lang/String;", "h4", "(Ljava/lang/String;)V", "", "requirements", "Ljava/util/List;", "o8", "()Ljava/util/List;", "n2", "(Ljava/util/List;)V", "shouldMultiFrame", "Y7", "viewOverlay", "getViewOverlay", "giftType", "getGiftType", "", "duration", "J", "getDuration", "()J", "Lcom/bytedance/android/live/core/resources/h$a;", "audioGraph", "Lcom/bytedance/android/live/core/resources/h$a;", "getAudioGraph", "()Lcom/bytedance/android/live/core/resources/h$a;", "<init>", "()V", "Adapter", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LokiExtraKtSerializableObjectImpl implements h {

    @SerializedName("audio_graph")
    private final h.a audioGraph;

    @SerializedName("gift_duration")
    private final long duration;

    @SerializedName("befViewFitMode")
    private final int fitMode;

    @SerializedName("befViewRenderFPS")
    private final int fps;

    @SerializedName("gift_type")
    private final String giftType;

    @SerializedName("model_names")
    private String modelNames;

    @SerializedName("need_screen_shot")
    private final boolean needScreenShot;

    @SerializedName("requirements")
    private List<String> requirements;

    @SerializedName("should_multi_frame")
    private final boolean shouldMultiFrame;

    @SerializedName("befViewRenderSize")
    private final h.b size;

    @SerializedName("view_overlay")
    private final String viewOverlay;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/core/resources/LokiExtraKtSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(LokiExtraKtSerializableObjectImpl.class);
        }
    }

    public LokiExtraKtSerializableObjectImpl() {
        this.needScreenShot = false;
        this.size = null;
        this.fps = 0;
        this.fitMode = 0;
        this.modelNames = null;
        this.requirements = null;
        this.shouldMultiFrame = false;
        this.viewOverlay = null;
        this.giftType = null;
        this.duration = 0;
        this.audioGraph = null;
    }

    @Override // com.bytedance.android.live.core.resources.h
    public final boolean Y7() {
        return this.shouldMultiFrame;
    }

    @Override // com.bytedance.android.live.core.resources.h
    public final long getDuration() {
        return this.duration;
    }

    @Override // com.bytedance.android.live.core.resources.h
    public final String getGiftType() {
        return this.giftType;
    }

    @Override // com.bytedance.android.live.core.resources.h
    public final String l3() {
        return this.modelNames;
    }

    @Override // com.bytedance.android.live.core.resources.h
    public final List<String> o8() {
        return this.requirements;
    }

    @Override // com.bytedance.android.live.core.resources.h
    public final void h4(String r100) {
        this.modelNames = r100;
    }

    @Override // com.bytedance.android.live.core.resources.h
    public final void n2(List<String> r100) {
        this.requirements = r100;
    }
}
