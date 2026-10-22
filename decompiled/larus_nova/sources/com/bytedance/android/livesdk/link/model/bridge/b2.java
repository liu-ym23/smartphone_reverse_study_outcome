package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001RB\u0010\u000b\u001a*\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002j\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000f\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\n\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0014\u001a\u00020\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\n\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "Lvh7/c;", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/RoomId;", "Lcom/bytedance/android/livesdk/link/model/bridge/z1;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getPreRtcUserInfo", "()Ljava/util/Map;", "getPreRtcUserInfo$annotations", "()V", "preRtcUserInfo", "getVersion", "()J", "getVersion$annotations", "version", "", "getRtcJoinChannel", "()Z", "getRtcJoinChannel$annotations", "rtcJoinChannel", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b2 extends vh7.c<b2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "pre_rtc_user_info")
    Map<Long, z1> getPreRtcUserInfo();

    @FieldName(name = "rtc_join_channel")
    boolean getRtcJoinChannel();

    @FieldName(name = "version")
    long getVersion();
}
