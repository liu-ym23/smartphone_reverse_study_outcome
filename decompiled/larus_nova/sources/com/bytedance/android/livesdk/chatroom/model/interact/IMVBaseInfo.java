package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\"\u0010\f\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\b\u0010\u0004\"\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u00158&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/IMVBaseInfo;", "Lvh7/c;", "", "getVid", "()Ljava/lang/String;", "getVid$annotations", "()V", "vid", "getCoverUrl", "setCoverUrl", "(Ljava/lang/String;)V", "getCoverUrl$annotations", "coverUrl", "getTitle", "getTitle$annotations", "title", "", "getDuration", "()I", "getDuration$annotations", "duration", "Lcom/bytedance/android/livesdk/chatroom/model/interact/IMVUrlStruct;", "getDownloadAddr", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/IMVUrlStruct;", "getDownloadAddr$annotations", "downloadAddr", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IMVBaseInfo extends vh7.c<IMVBaseInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "cover_url")
    String getCoverUrl();

    @FieldName(name = "download_addr")
    IMVUrlStruct getDownloadAddr();

    @FieldName(name = "duration")
    int getDuration();

    @FieldName(name = "title")
    String getTitle();

    @FieldName(name = "vid")
    String getVid();

    @FieldName(name = "cover_url#setter")
    void setCoverUrl(String r100);
}
