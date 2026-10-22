package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\r\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u000e\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/z1;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/u;", "", "getBattleAttachedInfoStr", "()Ljava/lang/String;", "getBattleAttachedInfoStr$annotations", "()V", "battleAttachedInfoStr", "", "getType", "()J", "getType$annotations", "type", "getBizExtraStr", "getBizExtraStr$annotations", "bizExtraStr", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface z1 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.u>, com.bytedance.android.livesdk.link.model.bridge.u {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.u, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.u, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "battle_attached_info")
    String getBattleAttachedInfoStr();

    @FieldName(name = "biz_extra")
    String getBizExtraStr();

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = SeiMessageConst.MSG_TYPE)
    long getType();

    /* synthetic */ String get_revUID();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);
}
