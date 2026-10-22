package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/v;", "Lvh7/c;", "", "getStream", "()Ljava/lang/String;", "setStream", "(Ljava/lang/String;)V", "getStream$annotations", "()V", "stream", "Lcom/bytedance/android/livesdk/chatroom/model/s2;", "getPlayInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/s2;", "setPlayInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/s2;)V", "getPlayInfo$annotations", "playInfo", "Lcom/bytedance/android/livesdk/chatroom/model/y2;", "getPushInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/y2;", "setPushInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/y2;)V", "getPushInfo$annotations", "pushInfo", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface v extends vh7.c<v> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "play_info")
    s2 getPlayInfo();

    @FieldName(name = "push_info")
    y2 getPushInfo();

    @FieldName(name = "stream")
    String getStream();

    @FieldName(name = "play_info#setter")
    void setPlayInfo(s2 r100);

    @FieldName(name = "push_info#setter")
    void setPushInfo(y2 r100);

    @FieldName(name = "stream#setter")
    void setStream(String r100);
}
