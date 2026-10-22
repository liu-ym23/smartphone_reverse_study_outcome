package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001b\u001a\u00020\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\"\u0010\u001f\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\u0004\"\u0004\b\u001d\u0010\u0006¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/IMVUrlStruct;", "Lvh7/c;", "", "getUri", "()Ljava/lang/String;", "setUri", "(Ljava/lang/String;)V", "getUri$annotations", "()V", "uri", "", "getUrlList", "()Ljava/util/List;", "setUrlList", "(Ljava/util/List;)V", "getUrlList$annotations", "urlList", "", "getWidth", "()J", "setWidth", "(J)V", "getWidth$annotations", "width", "getHeight", "setHeight", "getHeight$annotations", "height", "getUrlKey", "setUrlKey", "getUrlKey$annotations", "urlKey", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IMVUrlStruct extends vh7.c<IMVUrlStruct> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "height")
    long getHeight();

    @FieldName(name = "uri")
    String getUri();

    @FieldName(name = "url_key")
    String getUrlKey();

    @FieldName(name = ScoreTags.STAR_URL_LIST)
    List<String> getUrlList();

    @FieldName(name = "width")
    long getWidth();

    @FieldName(name = "height#setter")
    void setHeight(long r100);

    @FieldName(name = "uri#setter")
    void setUri(String r100);

    @FieldName(name = "url_key#setter")
    void setUrlKey(String r100);

    @FieldName(name = "url_list#setter")
    void setUrlList(List<String> r100);

    @FieldName(name = "width#setter")
    void setWidth(long r100);
}
