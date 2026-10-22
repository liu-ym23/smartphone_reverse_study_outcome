package com.bytedance.android.live.ktv.common.model.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0015R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/bean/h;", "", "", "name", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "title", "e", "Lpy/k;", "icon", "Lpy/k;", "c", "()Lpy/k;", "conf", "b", "", "version", "I", "f", "()I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class h implements vh7.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f69999a;

    @SerializedName("conf")
    protected k conf;

    @SerializedName("icon")
    protected k icon;

    @SerializedName("name")
    protected String name;

    @SerializedName("title")
    protected String title;

    @SerializedName("version")
    protected int version;

    public static final class a {
    }

    static {
    }

    public h(String r100, String r101, k r102, k r103, int r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "icon");
        Intrinsics.checkNotNullParameter(r103, "conf");
        this.name = r100;
        this.title = r101;
        this.icon = r102;
        this.conf = r103;
        this.version = r104;
        this.f69999a = r105;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        k r107 = this.icon;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        k r110 = this.conf;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        int r111 = (((r109 + r101) * 31) + this.version) * 31;
        boolean r112 = this.f69999a;
        ?? r113 = r112;
        if (r112 == false) goto L21;
        r113 = 1;
    L21:
        return r111 + r113;
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

    public final boolean g() {
        return Intrinsics.areEqual(this.name, "none");
    }

    public final String toString() {
        return "TuningEffectItem(name='" + this.name + "', title='" + this.title + "', icon=" + this.icon + ", conf=" + this.conf + ", version=" + this.version + ", isSelected=" + this.f69999a + ')';
    }

    public h() {
        this.name = "none";
        this.title = "原声";
        this.icon = qy.a.c();
        this.conf = qy.a.c();
        this.version = 1;
    }

    public final k b() {
        return this.conf;
    }

    public final k c() {
        return this.icon;
    }

    public final String d() {
        return this.name;
    }

    public final String e() {
        return this.title;
    }

    public final int f() {
        return this.version;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object, py.k] */
    public h(am3.g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L20;
        if (r103 != 1) goto L7;
        this.name = am3.h.c(r100);
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.title = am3.h.c(r100);
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this.icon = vh7.f.a(r100, k.class);
        goto L3
    L11:
        if (r103 != 4) goto L13;
        this.conf = vh7.f.a(r100, k.class);
        goto L3
    L13:
        if (r103 != 5) goto L14;
        this.version = (int) r100.j();
        r102 = r102 | true;
        goto L3
    L14:
        am3.h.e(r100);
        goto L3
    L20:
        r100.d(r101);
        if (this.name != null) goto L24;
        this.name = "none";
    L24:
        if (this.title != null) goto L27;
        this.title = "原声";
    L27:
        if (this.icon != null) goto L30;
        this.icon = qy.a.c();
    L30:
        if (this.conf != null) goto L33;
        this.conf = qy.a.c();
    L33:
        if ((r102 & true) == true) goto L54;
        this.version = 1;
        return;
    }

    public static h a(h r100) {
        String r101 = r100.name;
        String r102 = r100.title;
        k r103 = r100.icon;
        k r104 = r100.conf;
        int r105 = r100.version;
        boolean r106 = r100.f69999a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "title");
        Intrinsics.checkNotNullParameter(r103, "icon");
        Intrinsics.checkNotNullParameter(r104, "conf");
        return new h(r101, r102, r103, r104, r105, r106);
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof h) == true) goto L5;
        r100 = null;
    L5:
        h r101 = (h) r100;
        if (r101 != null) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(r101.name, this.name) == true) goto L10;
        return false;
    L10:
        if (r101.version == this.version) goto L12;
        return false;
    L12:
        return true;
    }

    public final boolean h(h r100) {
        Intrinsics.checkNotNullParameter(r100, "newItem");
        if (this.f69999a == r100.f69999a) goto L5;
    L13:
        return false;
    L5:
        if (Intrinsics.areEqual(this.title, r100.title) == false) goto L13;
        if (Intrinsics.areEqual(this.icon, r100.icon) == false) goto L13;
        if (Intrinsics.areEqual(this.conf, r100.conf) == false) goto L13;
        if (this.version != r100.version) goto L13;
        return true;
    }
}
