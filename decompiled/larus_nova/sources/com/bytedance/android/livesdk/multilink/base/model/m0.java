package com.bytedance.android.livesdk.multilink.base.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/multilink/base/model/m0;", "Lvh7/c;", "", "getSubtitle", "()Ljava/lang/String;", "getSubtitle$annotations", "()V", "subtitle", "getOpeningTimeTitle", "getOpeningTimeTitle$annotations", "openingTimeTitle", "getReserveUserNum", "getReserveUserNum$annotations", "reserveUserNum", "getRealReserveUserNum", "getRealReserveUserNum$annotations", "realReserveUserNum", "", "isReserve", "()Z", "isReserve$annotations", "getLeftEffectiveText", "getLeftEffectiveText$annotations", "leftEffectiveText", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface m0 extends vh7.c<m0> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "left_effective_text")
    String getLeftEffectiveText();

    @FieldName(name = "opening_time_title")
    String getOpeningTimeTitle();

    @FieldName(name = "real_reserve_num")
    String getRealReserveUserNum();

    @FieldName(name = "show_reserve_num")
    String getReserveUserNum();

    @FieldName(name = "subtitle")
    String getSubtitle();

    @FieldName(name = "is_reserve")
    boolean isReserve();
}
