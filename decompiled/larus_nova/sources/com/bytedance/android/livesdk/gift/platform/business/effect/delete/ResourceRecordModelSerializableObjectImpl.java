package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/delete/ResourceRecordModelSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/delete/v;", "", "lastUsedTime", "J", "i3", "()J", "U4", "(J)V", "size", "getSize", "setSize", "", "md5", "Ljava/lang/String;", "getMd5", "()Ljava/lang/String;", "R4", "(Ljava/lang/String;)V", "assetId", "getAssetId", "setAssetId", "keepALiveTime", "J0", "x7", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ResourceRecordModelSerializableObjectImpl implements v {

    @SerializedName("asset_id")
    private long assetId;

    @SerializedName("keep_alive_time")
    private long keepALiveTime;

    @SerializedName("last_used_time")
    private long lastUsedTime;

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    @SerializedName("md5")
    private String f129235md5;

    @SerializedName("size")
    private long size;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/delete/ResourceRecordModelSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(ResourceRecordModelSerializableObjectImpl.class);
        }
    }

    public ResourceRecordModelSerializableObjectImpl() {
        this.lastUsedTime = com.bytedance.live.kmp.util.e.b() / ((long) 1000);
        this.f129235md5 = "";
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.v
    public final long J0() {
        return this.keepALiveTime;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.v
    public final long getAssetId() {
        return this.assetId;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.v
    public final String getMd5() {
        return this.f129235md5;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.v
    public final long getSize() {
        return this.size;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.v
    public final long i3() {
        return this.lastUsedTime;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.v
    public final void R4(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f129235md5 = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.v
    public final void U4(long r100) {
        this.lastUsedTime = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.v
    public final void setAssetId(long r100) {
        this.assetId = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.v
    public final void setSize(long r100) {
        this.size = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.v
    public final void x7(long r100) {
        this.keepALiveTime = r100;
    }
}
