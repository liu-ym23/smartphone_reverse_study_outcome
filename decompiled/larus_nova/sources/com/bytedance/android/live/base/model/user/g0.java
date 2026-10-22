package com.bytedance.android.live.base.model.user;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000e\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0003\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000e\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0006\u001a\u0004\b\f\u0010\tR\u001a\u0010\u0011\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000f\u0010\tR\u001a\u0010\u0014\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0012\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/base/model/user/g0;", "Lvh7/c;", "", "isMember", "()Z", "isMember$annotations", "()V", "", "getLevel", "()J", "getLevel$annotations", "level", "getIdentityType", "getIdentityType$annotations", "identityType", "getBuyType", "getBuyType$annotations", "buyType", "getOpen", "getOpen$annotations", "open", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface g0 extends vh7.c<g0> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "buy_type")
    long getBuyType();

    @FieldName(name = "identity_type")
    long getIdentityType();

    @FieldName(name = "level")
    long getLevel();

    @FieldName(name = "open")
    long getOpen();

    @FieldName(name = "is_member")
    boolean isMember();
}
