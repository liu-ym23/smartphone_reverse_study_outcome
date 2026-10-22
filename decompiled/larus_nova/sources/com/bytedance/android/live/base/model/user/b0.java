package com.bytedance.android.live.base.model.user;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&R\u001c\u0010\u0007\u001a\u00020\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/base/model/user/b0;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/user/k;", "baseProfileInfo", "", "translateAwemeUserBaseProfileInfo", "", "isMuted", "()Z", "setMuted", "(Z)V", "getBaseProfileInfo", "()Lcom/bytedance/android/live/base/model/user/k;", "Lcom/bytedance/android/live/base/model/user/c0;", "getFollowInfo", "()Lcom/bytedance/android/live/base/model/user/c0;", "followInfo", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b0 extends vh7.c<b0> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    k getBaseProfileInfo();

    c0 getFollowInfo();

    boolean isMuted();

    void setMuted(boolean r100);

    void translateAwemeUserBaseProfileInfo(k r100);
}
