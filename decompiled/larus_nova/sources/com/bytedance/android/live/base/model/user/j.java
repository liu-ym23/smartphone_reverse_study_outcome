package com.bytedance.android.live.base.model.user;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0011\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0017\u0010\u0014R\u001a\u0010\u001a\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001a\u0010\nR:\u0010!\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u001cj\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u0001`\u001d8&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/base/model/user/j;", "Lvh7/c;", "", "getType", "()J", "getType$annotations", "()V", "type", "", "getShowEntrance", "()Z", "getShowEntrance$annotations", "showEntrance", "", "getSchema", "()Ljava/lang/String;", "getSchema$annotations", "schema", "Lpy/k;", "getSingleEntranceIcon", "()Lpy/k;", "getSingleEntranceIcon$annotations", "singleEntranceIcon", "getDoubleEntranceIcon", "getDoubleEntranceIcon$annotations", "doubleEntranceIcon", "isMember", "isMember$annotations", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getTrackingParams", "()Ljava/util/Map;", "getTrackingParams$annotations", "trackingParams", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface j extends vh7.c<j> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "double_entrance_icon")
    py.k getDoubleEntranceIcon();

    @FieldName(name = "schema")
    String getSchema();

    @FieldName(name = "show_entrance")
    boolean getShowEntrance();

    @FieldName(name = "single_entrance_icon")
    py.k getSingleEntranceIcon();

    @FieldName(name = "tracking_params")
    Map<String, String> getTrackingParams();

    @FieldName(name = "type")
    long getType();

    @FieldName(name = "is_member")
    boolean isMember();
}
