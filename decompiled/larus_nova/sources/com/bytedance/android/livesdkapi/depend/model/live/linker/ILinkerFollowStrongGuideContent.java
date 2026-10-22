package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerFollowStrongGuideContent;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerFollowStrongGuideContentDef;", "", "getToUserId", "()Ljava/lang/String;", "toUserId", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkerFollowStrongGuideContent extends c<ILinkerFollowStrongGuideContent>, ILinkerFollowStrongGuideContentDef {
    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    String getToUserId();
}
