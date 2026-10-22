package com.bytedance.android.live.core.resources;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R2\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\bj\b\u0012\u0004\u0012\u00020\u0002`\t8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/core/resources/l;", "Lvh7/c;", "", "getUri", "()Ljava/lang/String;", "getUri$annotations", "()V", "uri", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getUrlList", "()Ljava/util/List;", "setUrlList", "(Ljava/util/List;)V", "getUrlList$annotations", "urlList", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface l extends vh7.c<l> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "uri")
    String getUri();

    @FieldName(name = ScoreTags.STAR_URL_LIST)
    List<String> getUrlList();

    @FieldName(name = "url_list#setter")
    void setUrlList(List<String> r100);
}
