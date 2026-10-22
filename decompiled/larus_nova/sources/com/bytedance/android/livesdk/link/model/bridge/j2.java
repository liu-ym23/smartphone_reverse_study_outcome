package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001e\u0010\b\u001a\u00060\u0002j\u0002`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R$\u0010\u000f\u001a\u0004\u0018\u00010\t8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0014\u001a\u00020\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/j2;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/LinkerId;", "getToLinkerId", "()J", "getToLinkerId$annotations", "()V", "toLinkerId", "Lcom/bytedance/android/livesdk/link/model/bridge/n1;", "getMultiAnchorExtra", "()Lcom/bytedance/android/livesdk/link/model/bridge/n1;", "setMultiAnchorExtra", "(Lcom/bytedance/android/livesdk/link/model/bridge/n1;)V", "getMultiAnchorExtra$annotations", "multiAnchorExtra", "", "getInviterFromScene", "()I", "getInviterFromScene$annotations", "inviterFromScene", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface j2 extends vh7.c<j2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "inviter_from_scene")
    int getInviterFromScene();

    @FieldName(name = "multi_anchor_extra")
    n1 getMultiAnchorExtra();

    @FieldName(name = "to_linker_id")
    long getToLinkerId();

    @FieldName(name = "multi_anchor_extra#setter")
    void setMultiAnchorExtra(n1 r100);
}
