package com.bytedance.android.ec.common.api.jump.model;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.StandardEventTrack;
import java.util.Map;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes43.dex */
public final class e extends com.bytedance.android.ec.common.api.jump.model.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f42854c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECUIPromotion f42855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f42856b;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.ec.common.api.jump.model.a.InterfaceC0780a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ECUIPromotion f42857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g f42858b;

        @Override // com.bytedance.android.ec.common.api.jump.model.a.InterfaceC0780a
        public final <T extends com.bytedance.android.ec.common.api.jump.model.a> T a(KClass<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "modelClass");
            if (Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(e.class)) == false) goto L7;
            return new e(this.f42857a, this.f42858b);
        L7:
            return (T) JvmClassMappingKt.getJavaClass(r100).newInstance();
        }

        public b(ECUIPromotion r100, g r101) {
            Intrinsics.checkNotNullParameter(r100, "promotion");
            Intrinsics.checkNotNullParameter(r101, "baseParams");
            this.f42857a = r100;
            this.f42858b = r101;
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f42855a, r101.f42855a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f42856b, r101.f42856b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        ECUIPromotion r100 = this.f42855a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        g r104 = this.f42856b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OldPromotionParams(promotion=" + this.f42855a + ", baseParams=" + this.f42856b + ")";
    }

    @Override // com.bytedance.android.ec.common.api.jump.model.a
    public final Map<String, String> chainParams() {
        StandardEventTrack r100 = this.f42855a.getStandardEventTrack();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getChainParamsMap();
    }

    public e(ECUIPromotion r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "promotion");
        Intrinsics.checkNotNullParameter(r101, "baseParams");
        this.f42855a = r100;
        this.f42856b = r101;
    }
}
