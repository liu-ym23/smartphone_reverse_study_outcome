package com.bytedance.android.live.base.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u000bR2\u0010\u0012\u001a\u001a\u0012\b\u0012\u00060\u000ej\u0002`\u000f0\u0002j\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\b\u001a\u0004\b\u0010\u0010\u0006R2\u0010\u0015\u001a\u001a\u0012\b\u0012\u00060\u000ej\u0002`\u000f0\u0002j\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\b\u001a\u0004\b\u0013\u0010\u0006R\u001e\u0010\u0019\u001a\u00060\u000ej\u0002`\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\b\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/base/model/d;", "Lvh7/c;", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getUrlList", "()Ljava/util/List;", "getUrlList$annotations", "()V", "urlList", "getUri", "()Ljava/lang/String;", "getUri$annotations", "uri", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getFlexSetting", "getFlexSetting$annotations", "flexSetting", "getTextSetting", "getTextSetting$annotations", "textSetting", "getTopBorderHeight", "()J", "getTopBorderHeight$annotations", "topBorderHeight", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d extends vh7.c<d> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "flex_setting")
    List<Long> getFlexSetting();

    @FieldName(name = "text_setting")
    List<Long> getTextSetting();

    @FieldName(name = "top_border_height")
    long getTopBorderHeight();

    @FieldName(name = "uri")
    String getUri();

    @FieldName(name = ScoreTags.STAR_URL_LIST)
    List<String> getUrlList();
}
