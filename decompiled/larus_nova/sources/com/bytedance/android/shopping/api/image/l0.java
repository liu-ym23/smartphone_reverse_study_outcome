package com.bytedance.android.shopping.api.image;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR>\u0010\u0011\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000ej\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u0001`\u00108\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/api/image/l0;", "Lcom/bytedance/android/shopping/api/image/b0;", "", "targetTemplateName", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "targetServiceId", "b", "", "customParams", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "finalParams", "Ljava/util/HashMap;", "f", "()Ljava/util/HashMap;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class l0 implements b0 {

    @SerializedName("custom_params")
    private final List<String> customParams;

    @SerializedName("final_params")
    private final HashMap<String, Object> finalParams;

    @SerializedName("target_service_id")
    private final String targetServiceId;

    @SerializedName("target_template")
    private final String targetTemplateName;

    public static final class a implements b0, d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b0 f170196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d.b f170197b;

        @Override // com.bytedance.android.shopping.api.image.x
        public final List<String> a() {
            return this.f170196a.a();
        }

        @Override // com.bytedance.android.shopping.api.image.w
        public final String b() {
            return this.f170196a.b();
        }

        @Override // com.bytedance.android.shopping.api.image.d.b
        public final Boolean c() {
            return this.f170197b.c();
        }

        @Override // com.bytedance.android.shopping.api.image.w
        public final String d() {
            return this.f170196a.d();
        }

        @Override // com.bytedance.android.shopping.api.image.d.b
        public final List<d> e() {
            return this.f170197b.e();
        }

        @Override // com.bytedance.android.shopping.api.image.x
        public final HashMap<String, Object> f() {
            return this.f170196a.f();
        }

        @Override // com.bytedance.android.shopping.api.image.d.b
        public final String g() {
            return this.f170197b.g();
        }

        public a(l0 r100, g0 r101) {
            Intrinsics.checkNotNullParameter(r100, "tmplModel");
            Intrinsics.checkNotNullParameter(r101, "mather");
            this.f170196a = r100;
            this.f170197b = r101;
        }
    }

    public final int hashCode() {
        String r100 = this.targetTemplateName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.targetServiceId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.customParams;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        HashMap<String, Object> r110 = this.finalParams;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ReplaceTmplModel(targetTemplateName=" + this.targetTemplateName + ", targetServiceId=" + this.targetServiceId + ", customParams=" + this.customParams + ", finalParams=" + this.finalParams + ")";
    }

    public l0() {
        this.targetTemplateName = null;
        this.targetServiceId = null;
        this.customParams = null;
        this.finalParams = null;
    }

    @Override // com.bytedance.android.shopping.api.image.x
    public final List<String> a() {
        return this.customParams;
    }

    @Override // com.bytedance.android.shopping.api.image.w
    public final String b() {
        return this.targetServiceId;
    }

    @Override // com.bytedance.android.shopping.api.image.w
    public final String d() {
        return this.targetTemplateName;
    }

    @Override // com.bytedance.android.shopping.api.image.x
    public final HashMap<String, Object> f() {
        return this.finalParams;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l0) == false) goto L14;
        l0 r101 = (l0) r100;
        if (Intrinsics.areEqual(this.targetTemplateName, r101.targetTemplateName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.targetServiceId, r101.targetServiceId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.customParams, r101.customParams) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.finalParams, r101.finalParams) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }
}
