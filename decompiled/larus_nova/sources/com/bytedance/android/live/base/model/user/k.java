package com.bytedance.android.live.base.model.user;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\u0004\"\u0004\b\t\u0010\u0006R\u001c\u0010\r\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0004\"\u0004\b\f\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/base/model/user/k;", "Lvh7/c;", "", "getNickname", "()Ljava/lang/String;", "setNickname", "(Ljava/lang/String;)V", InstantPlayContext.NICKNAME, "getIdStr", "setIdStr", "idStr", "getSecUid", "setSecUid", "secUid", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface k extends vh7.c<k> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    String getIdStr();

    String getNickname();

    String getSecUid();

    void setIdStr(String r100);

    void setNickname(String r100);

    void setSecUid(String r100);
}
