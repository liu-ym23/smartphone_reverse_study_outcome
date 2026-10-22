package com.bytedance.android.bcm.impl.model;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0007\u0010\u0004\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R*\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\u00020\u001e8\u0006X\u0087D¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001e8\u0006X\u0087D¢\u0006\f\n\u0004\b#\u0010 \u001a\u0004\b#\u0010\"R \u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u0019\u001a\u0004\b%\u0010\u001b¨\u0006'"}, d2 = {"Lcom/bytedance/android/bcm/impl/model/f;", "", "", "bcmKey", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "bizType", "b", "setBizType", "(Ljava/lang/String;)V", "bizType$annotations", "()V", "Lcom/bytedance/android/bcm/impl/model/ValueType;", "valueType", "Lcom/bytedance/android/bcm/impl/model/ValueType;", ce.f26391f, "()Lcom/bytedance/android/bcm/impl/model/ValueType;", "Lcom/bytedance/android/bcm/impl/model/ParamType;", "paramType", "Lcom/bytedance/android/bcm/impl/model/ParamType;", "d", "()Lcom/bytedance/android/bcm/impl/model/ParamType;", "", "enumValue", "Ljava/util/List;", "c", "()Ljava/util/List;", "setEnumValue", "(Ljava/util/List;)V", "", "androidFlag", "I", "getAndroidFlag", "()I", "isRequired", "version", "getVersion", "<init>", "bcm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class f {

    @SerializedName("android_flag")
    private final int androidFlag;

    @SerializedName("bcm_field_name")
    private final String bcmKey;

    @SerializedName("biz_type")
    private String bizType;

    @SerializedName("enum_value")
    private List<? extends Object> enumValue;

    @SerializedName("is_required")
    private final int isRequired;

    @SerializedName("param_type")
    private final ParamType paramType;

    @SerializedName("type")
    private final ValueType valueType;

    @SerializedName("rela_version_list")
    private final List<String> version;

    public final boolean e() {
        if (this.isRequired == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final List<Object> f() {
        if (this.paramType == ParamType.ENUM) goto L7;
        return null;
    L7:
        return this.enumValue;
    }

    public final String toString() {
        return "BcmUnit(valueType=" + this.valueType + ", paramType=" + this.paramType + ", bcmFieldName='" + this.bcmKey + "', enumValue=" + this.enumValue + ", androidFlag=" + this.androidFlag + ", isRequired=" + this.isRequired + ", version=" + CollectionsKt.joinToString$default(this.version, null, null, null, 0, null, null, 63, null) + ')';
    }

    public f() {
        this.bcmKey = "";
        this.bizType = "ecom_entrance";
        this.valueType = ValueType.UNDEFINED;
        this.paramType = ParamType.UNDEFINED;
        this.version = CollectionsKt.emptyList();
    }

    public final String a() {
        return this.bcmKey;
    }

    public final String b() {
        return this.bizType;
    }

    public final List<Object> c() {
        return this.enumValue;
    }

    public final ParamType d() {
        return this.paramType;
    }

    public final ValueType g() {
        return this.valueType;
    }
}
