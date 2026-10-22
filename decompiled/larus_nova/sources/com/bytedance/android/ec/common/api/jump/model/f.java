package com.bytedance.android.ec.common.api.jump.model;

import java.util.Iterator;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class f extends com.bytedance.android.ec.common.api.jump.model.a implements d, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f42859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f42860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final jf.b f42861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final jf.e f42862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f42863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final JSONObject f42864f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final JSONObject f42865g;

    public static final class a implements com.bytedance.android.ec.common.api.jump.model.a.InterfaceC0780a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f42866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f42867b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final jf.b f42868c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final jf.e f42869d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f42870e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final JSONObject f42871f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final JSONObject f42872g;

        @Override // com.bytedance.android.ec.common.api.jump.model.a.InterfaceC0780a
        public final <T extends com.bytedance.android.ec.common.api.jump.model.a> T a(KClass<T> r110) {
            Intrinsics.checkNotNullParameter(r110, "modelClass");
            if (Intrinsics.areEqual(r110, Reflection.getOrCreateKotlinClass(f.class)) == false) goto L7;
            return new f(this.f42866a, this.f42867b, this.f42868c, this.f42869d, this.f42870e, this.f42871f, this.f42872g);
        L7:
            return (T) JvmClassMappingKt.getJavaClass(r110).newInstance();
        }

        public a(String r100, String r101, jf.b r102, jf.e r103, String r104, JSONObject r105, JSONObject r106, int r110) {
            if ((r110 & 16) == 0) goto L6;
            r104 = null;
        L6:
            if ((r110 & 32) == 0) goto L9;
            r105 = null;
        L9:
            if ((r110 & 64) == 0) goto L11;
            r106 = null;
        L11:
            Intrinsics.checkNotNullParameter(r102, "ecomEntranceForm");
            Intrinsics.checkNotNullParameter(r103, "sourcePage");
            this.f42866a = r100;
            this.f42867b = r101;
            this.f42868c = r102;
            this.f42869d = r103;
            this.f42870e = r104;
            this.f42871f = r105;
            this.f42872g = r106;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L20;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f42859a, r101.f42859a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f42860b, r101.f42860b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f42861c, r101.f42861c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f42862d, r101.f42862d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f42863e, r101.f42863e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f42864f, r101.f42864f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f42865g, r101.f42865g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f42859a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f42860b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        jf.b r107 = this.f42861c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        jf.e r110 = this.f42862d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f42863e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        JSONObject r116 = this.f42864f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        JSONObject r119 = this.f42865g;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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
        return "PageParams(btm=" + this.f42859a + ", btmPageId=" + this.f42860b + ", ecomEntranceForm=" + this.f42861c + ", sourcePage=" + this.f42862d + ", newSourceType=" + this.f42863e + ", customEntranceInfo=" + this.f42864f + ", customAddToCartEntranceInfo=" + this.f42865g + ")";
    }

    @Override // com.bytedance.android.ec.common.api.jump.model.c
    public final JSONObject addToCartEntranceInfo() {
        JSONObject r100 = this.f42865g;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new JSONObject();
    }

    @Override // com.bytedance.android.ec.common.api.jump.model.d
    public final JSONObject entranceInfo() {
        JSONObject r100 = new JSONObject();
        r100.put("carrier_type", this.f42861c.f498849a);     // Catch: JSONException -> L10
        JSONObject r101 = this.f42864f;     // Catch: JSONException -> L10
        if (r101 == null) goto L12;
        Iterator<String> r102 = r101.keys();     // Catch: JSONException -> L10
    L7:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();     // Catch: JSONException -> L10
        r100.put(r103, r101.opt(r103));     // Catch: JSONException -> L10
    L12:
        return r100;
    L10:
        e = move-exception;
        ye.a.b(e);
        goto L12
    }

    public f(String r100, String r101, jf.b r102, jf.e r103, String r104, JSONObject r105, JSONObject r106) {
        Intrinsics.checkNotNullParameter(r102, "ecomEntranceForm");
        Intrinsics.checkNotNullParameter(r103, "sourcePage");
        this.f42859a = r100;
        this.f42860b = r101;
        this.f42861c = r102;
        this.f42862d = r103;
        this.f42863e = r104;
        this.f42864f = r105;
        this.f42865g = r106;
    }
}
