package com.bytedance.android.live.profit.dress.config;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R*\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R6\u0010\u0010\u001a\u001e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\u000bj\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u0001`\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\t\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/g;", "Lvh7/c;", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getBasicImage", "()Lpy/k;", "setBasicImage", "(Lpy/k;)V", "getBasicImage$annotations", "()V", "basicImage", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getAdvanImageList", "()Ljava/util/List;", "getAdvanImageList$annotations", "advanImageList", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface g extends vh7.c<g> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "advan_image_list")
    List<py.k> getAdvanImageList();

    @FieldName(name = "basic_image")
    py.k getBasicImage();

    @FieldName(name = "basic_image#setter")
    void setBasicImage(py.k r100);
}
