package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/IPetMetaSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/message/model/db;", "", "petType", "J", "H6", "()J", "", "overridePetScheme", "Ljava/lang/String;", "G7", "()Ljava/lang/String;", "<init>", "()V", "Adapter", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPetMetaSerializableObjectImpl implements db {

    @SerializedName("override_pet_scheme")
    private final String overridePetScheme;

    @SerializedName("pet_type")
    private final long petType;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/IPetMetaSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(IPetMetaSerializableObjectImpl.class);
        }
    }

    public IPetMetaSerializableObjectImpl() {
    }

    @Override // com.bytedance.android.livesdk.message.model.db
    public final String G7() {
        return this.overridePetScheme;
    }

    @Override // com.bytedance.android.livesdk.message.model.db
    public final long H6() {
        return this.petType;
    }
}
