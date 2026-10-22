package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R:\u0010\u0013\u001a\u001a\u0012\b\u0012\u00060\u000bj\u0002`\f0\nj\f\u0012\b\u0012\u00060\u000bj\u0002`\f`\r8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011RF\u0010\u001c\u001a&\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\u00150\u0014j\u0012\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\u0015`\u00168&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/h9;", "Lvh7/c;", "", "getSetUid", "()Ljava/lang/String;", "setSetUid", "(Ljava/lang/String;)V", "getSetUid$annotations", "()V", "setUid", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/GiftId;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getGiftIds", "()Ljava/util/List;", "setGiftIds", "(Ljava/util/List;)V", "getGiftIds$annotations", "giftIds", "", "Lcom/bytedance/android/livesdk/link/model/i9;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getGiftMap", "()Ljava/util/Map;", "setGiftMap", "(Ljava/util/Map;)V", "getGiftMap$annotations", "giftMap", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface h9 extends vh7.c<h9> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "gift_ids")
    List<Long> getGiftIds();

    @FieldName(name = "gift_map")
    Map<Long, i9> getGiftMap();

    @FieldName(name = "set_open_uid")
    String getSetUid();

    @FieldName(name = "gift_ids#setter")
    void setGiftIds(List<Long> r100);

    @FieldName(name = "gift_map#setter")
    void setGiftMap(Map<Long, ? extends i9> r100);

    @FieldName(name = "set_open_uid#setter")
    void setSetUid(String r100);
}
