package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rRj\u0010\u0006\u001aJ\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0018\u00010\u0002j,\u0012\u0004\u0012\u00020\u0003\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005\u0018\u0001`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/config/tf1;", "", "Ljava/util/HashMap;", "", "Lcom/bytedance/android/livesdk/config/zf1;", "Lkotlin/collections/HashMap;", "spatialAudioSpeakPositionConfigByLayout", "Ljava/util/HashMap;", "getSpatialAudioSpeakPositionConfigByLayout", "()Ljava/util/HashMap;", "setSpatialAudioSpeakPositionConfigByLayout", "(Ljava/util/HashMap;)V", "<init>", "()V", "liverevlink-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class tf1 {

    @SerializedName("speak_position_config_by_layout")
    private HashMap<Integer, HashMap<Integer, zf1>> spatialAudioSpeakPositionConfigByLayout;

    public tf1() {
        this.spatialAudioSpeakPositionConfigByLayout = new HashMap();
    }
}
