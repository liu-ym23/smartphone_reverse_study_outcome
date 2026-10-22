package com.bytedance.android.shopping.api.image;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\nR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R>\u0010\u000e\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bj\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`\r8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/api/image/j0;", "Lcom/bytedance/android/shopping/api/image/x;", "", "Lcom/bytedance/android/shopping/api/image/f0;", "targetTemplate", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "customParams", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "finalParams", "Ljava/util/HashMap;", "f", "()Ljava/util/HashMap;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class j0 implements x {

    @SerializedName("custom_params")
    private final List<String> customParams;

    @SerializedName("final_params")
    private final HashMap<String, Object> finalParams;

    @SerializedName("target_template")
    private final List<f0> targetTemplate;

    public static final class a implements x, w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j0 f170194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f0 f170195b;

        @Override // com.bytedance.android.shopping.api.image.x
        public final List<String> a() {
            return this.f170194a.a();
        }

        @Override // com.bytedance.android.shopping.api.image.w
        public final String b() {
            return this.f170195b.b();
        }

        @Override // com.bytedance.android.shopping.api.image.w
        public final String d() {
            return this.f170195b.d();
        }

        @Override // com.bytedance.android.shopping.api.image.x
        public final HashMap<String, Object> f() {
            return this.f170194a.f();
        }

        public a(j0 r100, f0 r101) {
            Intrinsics.checkNotNullParameter(r100, "tmplModel");
            Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
            this.f170194a = r100;
            this.f170195b = r101;
        }
    }

    public final int hashCode() {
        List<f0> r100 = this.targetTemplate;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.customParams;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        HashMap<String, Object> r107 = this.finalParams;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ReplaceOldTmplModel(targetTemplate=" + this.targetTemplate + ", customParams=" + this.customParams + ", finalParams=" + this.finalParams + ")";
    }

    public j0() {
        this.targetTemplate = null;
        this.customParams = null;
        this.finalParams = null;
    }

    @Override // com.bytedance.android.shopping.api.image.x
    public final List<String> a() {
        return this.customParams;
    }

    public final List<f0> b() {
        return this.targetTemplate;
    }

    @Override // com.bytedance.android.shopping.api.image.x
    public final HashMap<String, Object> f() {
        return this.finalParams;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j0) == false) goto L12;
        j0 r101 = (j0) r100;
        if (Intrinsics.areEqual(this.targetTemplate, r101.targetTemplate) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.customParams, r101.customParams) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.finalParams, r101.finalParams) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }
}
