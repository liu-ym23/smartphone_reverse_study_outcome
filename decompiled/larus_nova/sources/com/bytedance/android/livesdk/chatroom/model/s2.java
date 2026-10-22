package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/s2;", "Lvh7/c;", "", "getStreamData", "()Ljava/lang/String;", "setStreamData", "(Ljava/lang/String;)V", "getStreamData$annotations", "()V", "streamData", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface s2 extends vh7.c<s2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = MiniAppConstants.KEY_MINI_APP_STREAM_DATA)
    String getStreamData();

    @FieldName(name = "stream_data#setter")
    void setStreamData(String r100);
}
