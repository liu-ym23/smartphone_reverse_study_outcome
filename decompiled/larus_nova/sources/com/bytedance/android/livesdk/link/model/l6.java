package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u001c\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/l6;", "Lvh7/c;", "", "getRtcExtInfo", "()Ljava/lang/String;", "rtcExtInfo", "getLiveCoreExtInfo", "liveCoreExtInfo", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "getMLinkUsers", "()Ljava/util/List;", "mLinkUsers", "", "getVersion", "()J", "version", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface l6 extends vh7.c<l6> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    String getLiveCoreExtInfo();

    List<com.bytedance.android.livesdk.link.model.bridge.k> getMLinkUsers();

    String getRtcExtInfo();

    long getVersion();
}
