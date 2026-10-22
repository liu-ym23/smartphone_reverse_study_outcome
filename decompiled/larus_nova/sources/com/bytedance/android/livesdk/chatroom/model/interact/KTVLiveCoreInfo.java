package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class KTVLiveCoreInfo extends FlexModelBase<i0> implements i0 {
    public static final String AUDIO = "4";
    public static final String AUDIO_CHORUS = "3";
    public static final String AVATAR = "5";
    public static final String VIDEO = "2";
    public static final String VIDEO_CHORUS = "1";

    @SerializedName("live_core_info_map")
    public Map<Long, String> mLiveCoreExtInfoMap;

    public KTVLiveCoreInfo() {
        super(i0.class);
    }

    public String toString() {
        return "KTVLiveCoreInfo{Map=" + this.mLiveCoreExtInfoMap + '}';
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.i0
    public Map<Long, String> getLiveCoreExtInfoMap() {
        return this.mLiveCoreExtInfoMap;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.i0
    public String getLiveCoreInfo(String r100) {
        long r101 = CastLongProtector.parseLong(r100);     // Catch: Throwable -> L4
        return this.mLiveCoreExtInfoMap.get(Long.valueOf(r101));
    L4:
        return "";
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.i0
    public void setLiveCoreExtInfoMap(Map<Long, String> r100) {
        this.mLiveCoreExtInfoMap = r100;
    }
}
