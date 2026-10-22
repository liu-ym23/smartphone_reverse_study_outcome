package com.bytedance.android.livesdk.message.linker;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/message/linker/d;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/message/linker/c;", "getChangePlayModeData", "()Lcom/bytedance/android/livesdk/message/linker/c;", "changePlayModeData", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d extends vh7.c<d> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "change_play_mode_data")
    c getChangePlayModeData();
}
