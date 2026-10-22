package com.bytedance.android.livesdk.gift.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R6\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r`\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\u000f\u0010\u0010R6\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u000bj\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014`\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\t\u001a\u0004\b\u0015\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/o1;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/gift/model/n1;", "", "Lcom/bytedance/android/livesdk/gift/model/p1;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getGiftExtras", "()Ljava/util/List;", "getGiftExtras$annotations", "()V", "giftExtras", "", "", "Lcom/bytedance/android/livesdk/gift/model/z1;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getSceneConfigMap", "()Ljava/util/Map;", "getSceneConfigMap$annotations", "sceneConfigMap", "", "Lcom/bytedance/android/livesdk/gift/model/k2;", "getPageExtra", "getPageExtra$annotations", "pageExtra", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface o1 extends vh7.c<o1>, n1 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "gift_extra")
    List<p1> getGiftExtras();

    @FieldName(name = "page_extra")
    Map<Long, k2> getPageExtra();

    @FieldName(name = "scene_config")
    Map<String, z1> getSceneConfigMap();
}
