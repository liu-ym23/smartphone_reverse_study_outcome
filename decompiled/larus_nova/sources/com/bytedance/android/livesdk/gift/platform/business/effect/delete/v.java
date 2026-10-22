package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(ResourceRecordModelSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/delete/v;", "Lvh7/j;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface v extends vh7.j<v> {

    @JsonAdapter(ResourceRecordModelSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "keep_alive_time")
    long J0();

    @FieldName(name = "md5#setter")
    void R4(String r100);

    @FieldName(name = "last_used_time#setter")
    void U4(long r100);

    @FieldName(name = "asset_id")
    long getAssetId();

    @FieldName(name = "md5")
    String getMd5();

    @FieldName(name = "size")
    long getSize();

    @FieldName(name = "last_used_time")
    long i3();

    @FieldName(name = "asset_id#setter")
    void setAssetId(long r100);

    @FieldName(name = "size#setter")
    void setSize(long r100);

    @FieldName(name = "keep_alive_time#setter")
    void x7(long r100);
}
