package com.bytedance.android.livedress.impl.jsb;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import jd1.e;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livedress/impl/jsb/GetDressInfoParamModelSerializableObjectImpl;", "Ljd1/e;", "", "dressId", "Ljava/lang/String;", "getDressId", "()Ljava/lang/String;", "", "dressType", "I", "getDressType", "()I", "definition", "getDefinition", "definitionVersion", "c6", "definitionName", "u", "autoFetch", "J6", "<init>", "()V", "Adapter", "live-dress-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GetDressInfoParamModelSerializableObjectImpl implements e {

    @SerializedName("autoFetch")
    private final int autoFetch;

    @SerializedName("definition")
    private final String definition;

    @SerializedName("definitionName")
    private final String definitionName;

    @SerializedName("definitionVersion")
    private final int definitionVersion;

    @SerializedName("dressId")
    private final String dressId;

    @SerializedName("dressType")
    private final int dressType;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livedress/impl/jsb/GetDressInfoParamModelSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-dress-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(GetDressInfoParamModelSerializableObjectImpl.class);
        }
    }

    public GetDressInfoParamModelSerializableObjectImpl() {
        this.dressId = "";
        this.definition = "";
        this.definitionName = "";
    }

    @Override // jd1.e
    public final int J6() {
        return this.autoFetch;
    }

    @Override // jd1.e
    public final int c6() {
        return this.definitionVersion;
    }

    @Override // jd1.e
    public final String getDefinition() {
        return this.definition;
    }

    @Override // jd1.e
    public final String getDressId() {
        return this.dressId;
    }

    @Override // jd1.e
    public final String u() {
        return this.definitionName;
    }
}
