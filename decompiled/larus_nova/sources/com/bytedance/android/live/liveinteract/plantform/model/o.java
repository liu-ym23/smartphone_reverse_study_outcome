package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0010\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R\"\u0010\u0011\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\u000e\u0010\u0004\"\u0004\b\u000f\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/o;", "Lvh7/c;", "", "getJoinChannelTime", "()J", "setJoinChannelTime", "(J)V", "getJoinChannelTime$annotations", "()V", "joinChannelTime", "getExpectLeaveTime", "setExpectLeaveTime", "getExpectLeaveTime$annotations", "expectLeaveTime", "getCurrentTime", "setCurrentTime", "getCurrentTime$annotations", "currentTime", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface o extends vh7.c<o> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "current_time")
    long getCurrentTime();

    @FieldName(name = "expected_leave_time")
    long getExpectLeaveTime();

    @FieldName(name = "join_channel_time")
    long getJoinChannelTime();

    @FieldName(name = "current_time#setter")
    void setCurrentTime(long r100);

    @FieldName(name = "expected_leave_time#setter")
    void setExpectLeaveTime(long r100);

    @FieldName(name = "join_channel_time#setter")
    void setJoinChannelTime(long r100);
}
