package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/j;", "Lvh7/c;", "", "", "getInUseLinkMicId", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface j extends vh7.c<j> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ String getBackupLinkMicId();

    String getInUseLinkMicId();

    /* synthetic */ String getMainLinkMicId();

    /* synthetic */ boolean getUseBackupStream();
}
