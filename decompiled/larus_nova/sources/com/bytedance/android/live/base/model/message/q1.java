package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/base/model/message/q1;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/o1;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface q1 extends vh7.c<q1>, o1 {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ List<String> getColorList();

    @Override // com.bytedance.android.live.base.model.message.o1
    /* synthetic */ boolean getShowFontColor();

    @Override // com.bytedance.android.live.base.model.message.o1
    /* synthetic */ boolean isShowHead();

    @Override // com.bytedance.android.live.base.model.message.o1
    /* synthetic */ boolean isShowNickName();

    @Override // com.bytedance.android.live.base.model.message.o1
    /* synthetic */ boolean isStarMessage();
}
