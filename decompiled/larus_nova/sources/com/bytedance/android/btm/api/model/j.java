package com.bytedance.android.btm.api.model;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f42057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f42058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f42059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f42060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f42061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f42062f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f42063g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final JSONObject f42064h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f42065i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L24;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f42057a, r101.f42057a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f42058b, r101.f42058b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f42059c, r101.f42059c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f42060d, r101.f42060d) == true) goto L14;
        return false;
    L14:
        if (this.f42061e == r101.f42061e) goto L16;
        return false;
    L16:
        if (this.f42062f == r101.f42062f) goto L18;
        return false;
    L18:
        if (this.f42063g == r101.f42063g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f42064h, r101.f42064h) == true) goto L22;
        return false;
    L22:
        if (this.f42065i == r101.f42065i) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    public final int hashCode() {
        Context r100 = this.f42057a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f42058b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f42059c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f42060d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        long r113 = this.f42061e;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        long r115 = this.f42062f;
        int r116 = (r114 + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        boolean r117 = this.f42063g;
        ?? r118 = 1;
        ?? r119 = r117;
        if (r117 == false) goto L21;
        r119 = 1;
    L21:
        int r120 = (r116 + r119) * 31;
        JSONObject r121 = this.f42064h;
        if (r121 == null) goto L24;
        r101 = r121.hashCode();
    L24:
        int r122 = (r120 + r101) * 31;
        boolean r123 = this.f42065i;
        if (r123 == true) goto L29;
        r118 = r123;
    L29:
        return r122 + r118;
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
        return "EventModelV1(context=" + this.f42057a + ", category=" + this.f42058b + ", tag=" + this.f42059c + ", label=" + this.f42060d + ", value=" + this.f42061e + ", ext_value=" + this.f42062f + ", instant_only=" + this.f42063g + ", ext_json=" + this.f42064h + ", from_lancet=" + this.f42065i + ")";
    }

    public final String a() {
        if (Intrinsics.areEqual(this.f42058b, "event_v3") == false) goto L6;
        return this.f42059c;
    L6:
        return this.f42060d;
    }

    public final Context getContext() {
        return this.f42057a;
    }

    public j(Context r100, String r101, String r102, String r103, long r104, long r105, boolean r106, JSONObject r110, boolean r111) {
        this.f42057a = r100;
        this.f42058b = r101;
        this.f42059c = r102;
        this.f42060d = r103;
        this.f42061e = r104;
        this.f42062f = r105;
        this.f42063g = r106;
        this.f42064h = r110;
        this.f42065i = r111;
    }
}
