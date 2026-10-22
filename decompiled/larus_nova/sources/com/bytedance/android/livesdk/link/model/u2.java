package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001e\u0010\b\u001a\u00060\u0002j\u0002`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u000b\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\u0005R\u001a\u0010\u000e\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0007\u001a\u0004\b\f\u0010\u0005R\u001a\u0010\u0011\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u000f\u0010\u0005R\u001a\u0010\u0014\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0012\u0010\u0005R\u001a\u0010\u0017\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0015\u0010\u0005R\u001a\u0010\u001c\u001a\u00020\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/u2;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/TimeInt64;", "getPkCustomDuration", "()J", "getPkCustomDuration$annotations", "()V", "pkCustomDuration", "getPkLikeLevel", "getPkLikeLevel$annotations", "pkLikeLevel", "getPkGiftValueLevel", "getPkGiftValueLevel$annotations", "pkGiftValueLevel", "getPkUVLevel", "getPkUVLevel$annotations", "pkUVLevel", "getPkTicketLevel", "getPkTicketLevel$annotations", "pkTicketLevel", "getPkVIPLevel", "getPkVIPLevel$annotations", "pkVIPLevel", "", "getPkValueType", "()I", "getPkValueType$annotations", "pkValueType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface u2 extends vh7.c<u2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "pk_duration_time")
    long getPkCustomDuration();

    @FieldName(name = "gift_value_type")
    long getPkGiftValueLevel();

    @FieldName(name = "like_type")
    long getPkLikeLevel();

    @FieldName(name = "ticket_type")
    long getPkTicketLevel();

    @FieldName(name = "gift_uv_type")
    long getPkUVLevel();

    @FieldName(name = "subscribe_type")
    long getPkVIPLevel();

    @FieldName(name = "pk_value_type")
    int getPkValueType();
}
