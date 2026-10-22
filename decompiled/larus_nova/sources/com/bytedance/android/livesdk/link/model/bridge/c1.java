package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/c1;", "Lvh7/c;", "", "Lgm2/i;", "getLinkMicSignalFlex", "()Lgm2/i;", "linkMicSignalFlex", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface c1 extends vh7.c<c1> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    gm2.i getLinkMicSignalFlex();

    /* synthetic */ String getSignal();
}
