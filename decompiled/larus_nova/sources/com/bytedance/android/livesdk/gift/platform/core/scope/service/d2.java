package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(GiftRequestSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/scope/service/d2;", "Lvh7/j;", "", "getType", "()Ljava/lang/String;", "getType$annotations", "()V", "type", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d2 extends vh7.j<d2> {

    @JsonAdapter(GiftRequestSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "type")
    String getType();
}
