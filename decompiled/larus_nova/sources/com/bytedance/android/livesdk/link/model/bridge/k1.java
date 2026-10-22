package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R$\u0010\n\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/k1;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdk/link/model/bridge/l1;", "getLinkMicAudienceContent", "()Lcom/bytedance/android/livesdk/link/model/bridge/l1;", "setLinkMicAudienceContent", "(Lcom/bytedance/android/livesdk/link/model/bridge/l1;)V", "getLinkMicAudienceContent$annotations", "()V", "linkMicAudienceContent", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface k1 extends vh7.c<k1> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "linkmic_audience_content")
    l1 getLinkMicAudienceContent();

    /* synthetic */ m1 getLinkMicContent();

    @FieldName(name = "linkmic_audience_content#setter")
    void setLinkMicAudienceContent(l1 r100);

    /* synthetic */ void setLinkMicContent(m1 r100);
}
