package com.bytedance.android.shopping.mall.homepage.impl;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class MallOpenWitchSevenSplit implements cf3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f178173a;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.impl.MallOpenWitchSevenSplit$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000eR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/impl/MallOpenWitchSevenSplit$a$a;", "", "", "", "schemaRelaxCondition", "Ljava/util/List;", "b", "()Ljava/util/List;", "setSchemaRelaxCondition", "(Ljava/util/List;)V", "schemaStrictCondition", "c", "setSchemaStrictCondition", "schemaInnerCondition", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setSchemaInnerCondition", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class C2640a {

            @SerializedName("schema_inner_condition")
            private List<String> schemaInnerCondition;

            @SerializedName("schema_relax_condition")
            private List<String> schemaRelaxCondition;

            @SerializedName("schema_strict_condition")
            private List<String> schemaStrictCondition;

            /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.impl.MallOpenWitchSevenSplit$a$a$a, reason: collision with other inner class name */
            public static final class C2641a {
            }

            static {
            }

            public C2640a() {
                this(null);
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof C2640a) == false) goto L12;
                C2640a r101 = (C2640a) r100;
                if (Intrinsics.areEqual(this.schemaRelaxCondition, r101.schemaRelaxCondition) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.schemaStrictCondition, r101.schemaStrictCondition) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.schemaInnerCondition, r101.schemaInnerCondition) == true) goto L19;
                return false;
            L19:
                return true;
            L12:
                return false;
            }

            public final int hashCode() {
                List<String> r100 = this.schemaRelaxCondition;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                List<String> r104 = this.schemaStrictCondition;
                if (r104 == null) goto L9;
                int r105 = r104.hashCode();
            L10:
                int r106 = (r103 + r105) * 31;
                List<String> r107 = this.schemaInnerCondition;
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
                return "MallSevenSplitOpenCondition(schemaRelaxCondition=" + this.schemaRelaxCondition + ", schemaStrictCondition=" + this.schemaStrictCondition + ", schemaInnerCondition=" + this.schemaInnerCondition + ")";
            }

            public final List<String> a() {
                return this.schemaInnerCondition;
            }

            public final List<String> b() {
                return this.schemaRelaxCondition;
            }

            public final List<String> c() {
                return this.schemaStrictCondition;
            }

            public C2640a(Object r100) {
                this.schemaRelaxCondition = null;
                this.schemaStrictCondition = null;
                this.schemaInnerCondition = null;
            }
        }
    }

    static {
    }

    public MallOpenWitchSevenSplit() {
        this.f178173a = LazyKt.lazy(MallOpenWitchSevenSplit$settingConfig$2.INSTANCE);
    }

    @Override // cf3.a
    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        List<String> r101 = ((a.C2640a) this.f178173a.getValue()).b();
        String r102 = null;
        if (r101 == null) goto L10;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        if (StringsKt.contains$default(r100, (String) r103.next(), false, 2, null) == false) goto L6;
        return true;
    L10:
        List<String> r104 = ((a.C2640a) this.f178173a.getValue()).c();
        if (r104 != null) goto L13;
    L15:
        List<String> r105 = ((a.C2640a) this.f178173a.getValue()).a();
        if (r105 != null) goto L35;
    L34:
        return false;
    L35:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L28
        Uri r107 = UriProtector.parse(r100);     // Catch: Throwable -> L28
        if (r107 == null) goto L25;
        String r108 = UriProtector.getQueryParameter(r107, "url");     // Catch: Throwable -> L28
        if (r108 == null) goto L22;
    L21:
        r102 = r108;
    L30:
        if (r102 == null) goto L34;
        if (b(r102, r105) == false) goto L34;
        return true;
    L22:
        r108 = UriProtector.getQueryParameter(r107, "surl");     // Catch: Throwable -> L28
        if (r108 != null) goto L21;
    L26:
        Result.m9449constructorimpl(r107);     // Catch: Throwable -> L28
        goto L30
    L25:
        r107 = null;
    L28:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    L13:
        if (b(r100, r104) == false) goto L15;
        return true;
    }

    public static boolean b(String r100, List r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L20
        Uri r103 = UriProtector.parse(r100);     // Catch: Throwable -> L20
        if (r103 == null) goto L17;
        Iterator r104 = r101.iterator();     // Catch: Throwable -> L20
    L7:
        if (r104.hasNext() == false) goto L18;
        String r105 = UriProtector.getQueryParameter(r103, (String) r104.next());     // Catch: Throwable -> L20
        if (r105 != null) goto L11;
    L14:
        boolean r106 = true;
    L15:
        if (r106 == true) goto L7;
        return true;
    L11:
        if (r105.length() == 0) goto L14;
        r106 = false;
    L18:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L20
    L22:
        return false;
    L17:
        r103 = null;
    L20:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    }
}
