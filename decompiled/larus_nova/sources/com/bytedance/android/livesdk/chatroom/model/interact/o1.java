package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0019\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001c\u001a\u00020\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/o1;", "Lvh7/c;", "", "", "getTargetList", "()Ljava/util/List;", "setTargetList", "(Ljava/util/List;)V", "targetList", "getCurrentTarget", "()Ljava/lang/String;", "setCurrentTarget", "(Ljava/lang/String;)V", "currentTarget", "getTargetIconUri", "setTargetIconUri", "targetIconUri", "getIndicatorText", "setIndicatorText", "indicatorText", "", "getPunchDuration", "()J", "setPunchDuration", "(J)V", "punchDuration", "getRoomPunchCount", "setRoomPunchCount", "roomPunchCount", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface o1 extends vh7.c<o1> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    String getCurrentTarget();

    String getIndicatorText();

    long getPunchDuration();

    String getRoomPunchCount();

    String getTargetIconUri();

    List<String> getTargetList();

    void setCurrentTarget(String r100);

    void setIndicatorText(String r100);

    void setPunchDuration(long r100);

    void setRoomPunchCount(String r100);

    void setTargetIconUri(String r100);

    void setTargetList(List<String> r100);
}
