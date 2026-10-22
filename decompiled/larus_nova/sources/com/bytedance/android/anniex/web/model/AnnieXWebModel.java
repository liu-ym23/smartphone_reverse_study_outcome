package com.bytedance.android.anniex.web.model;

import android.net.Uri;
import com.bytedance.ies.bullet.core.BulletContext;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import q26.c;
import q26.h;
import q26.j;

/* JADX INFO: loaded from: classes43.dex */
public final class AnnieXWebModel implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f41466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f41467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f41468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f41469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f41470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Object> f41471f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f41472g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final t36.j f41473h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f41474i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f41475j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f41476k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final BulletContext f41477l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f41478m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AnnieXWebModel) == true) goto L8;
        return false;
    L8:
        AnnieXWebModel r101 = (AnnieXWebModel) r100;
        if (Intrinsics.areEqual(this.f41466a, r101.f41466a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f41467b, r101.f41467b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f41468c, r101.f41468c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f41469d, r101.f41469d) == true) goto L21;
        return false;
    L21:
        if (this.f41470e == r101.f41470e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f41471f, r101.f41471f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f41472g, r101.f41472g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f41473h, r101.f41473h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f41474i, r101.f41474i) == true) goto L36;
        return false;
    L36:
        if (this.f41475j == r101.f41475j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f41466a.hashCode() * 31) + this.f41467b.hashCode()) * 31) + this.f41468c.hashCode()) * 31) + this.f41469d.hashCode()) * 31;
        int r101 = 1231;
        if (this.f41470e == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        Map<String, Object> r104 = this.f41471f;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r103 + r106) * 31;
        Map<String, Object> r108 = this.f41472g;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        t36.j r111 = this.f41473h;
        if (r111 == null) goto L18;
        r105 = r111.hashCode();
    L18:
        int r112 = (((r110 + r105) * 31) + this.f41474i.hashCode()) * 31;
        if (this.f41475j == true) goto L23;
        r101 = 1237;
    L23:
        return r112 + r101;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "AnnieXWebModel(businessId=" + this.f41466a + ", url=" + this.f41467b + ", originalUri=" + this.f41468c + ", sessionId=" + this.f41469d + ", enablePIA=" + this.f41470e + ", injectData=" + this.f41471f + ", globalProps=" + this.f41472g + ", schemaModelUnion=" + this.f41473h + ", enterFrom=" + this.f41474i + ", needSccDelegate=" + this.f41475j + ')';
    }

    @Override // q26.j
    public final h getServiceContext() {
        return (h) this.f41478m.getValue();
    }

    @Override // q26.j
    public final Map<Class<?>, Object> getAllDependency() {
        return getServiceContext().getAllDependency();
    }

    @Override // q26.j
    public final String getBid() {
        return this.f41466a;
    }

    @Override // q26.j
    public final <T> T a(Class<T> r100) {
        return (T) j.a.a(this, r100);
    }

    @Override // q26.j
    public final <T extends c> T getService(Class<T> r100) {
        return (T) j.a.b(this, r100);
    }

    public AnnieXWebModel(String r100, String r101, Uri r102, String r103, boolean r104, Map<String, Object> r105, Map<String, Object> r106, t36.j r107, String r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "businessId");
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "originalUri");
        Intrinsics.checkNotNullParameter(r103, "sessionId");
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        this.f41466a = r100;
        this.f41467b = r101;
        this.f41468c = r102;
        this.f41469d = r103;
        this.f41470e = r104;
        this.f41471f = r105;
        this.f41472g = r106;
        this.f41473h = r107;
        this.f41474i = r110;
        this.f41475j = r111;
        this.f41476k = LazyKt.lazy(AnnieXWebModel$appendQueryMap$2.INSTANCE);
        BulletContext r108 = new BulletContext(r103);
        r108.f246438f = r100;
        r108.C = true;
        this.f41477l = r108;
        this.f41478m = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AnnieXWebModel$serviceContext$2.INSTANCE);
    }
}
