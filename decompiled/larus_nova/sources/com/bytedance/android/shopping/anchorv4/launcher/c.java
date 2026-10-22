package com.bytedance.android.shopping.anchorv4.launcher;

import com.bytedance.android.shopping.anchorv3.repository.api.SchemaPackRequest;
import com.bytedance.android.shopping.anchorv4.helper.u;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.bytedance.android.shopping.anchorv4.schemav2.PdpSchemaProcessor;
import com.bytedance.android.shopping.anchorv4.schemav2.o;
import com.bytedance.android.shopping.pre_purchase.arch.launch.j;
import kotlin.jvm.internal.Intrinsics;
import p83.h;

/* JADX INFO: loaded from: classes12.dex */
public final class c implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PdpSchemaProcessor f167025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SchemaPackRequest f167026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final V4NativeParams f167027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f167028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u f167029e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o f167030f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SplitParam f167031g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L20;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f167025a, r101.f167025a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f167026b, r101.f167026b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f167027c, r101.f167027c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f167028d, r101.f167028d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f167029e, r101.f167029e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f167030f, r101.f167030f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f167031g, r101.f167031g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        PdpSchemaProcessor r100 = this.f167025a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        SchemaPackRequest r104 = this.f167026b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        V4NativeParams r107 = this.f167027c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        h r110 = this.f167028d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        u r113 = this.f167029e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        o r116 = this.f167030f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        SplitParam r119 = this.f167031g;
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
        return "SchemaParseModel(schemaProcessor=" + this.f167025a + ", reqParams=" + this.f167026b + ", nativeParams=" + this.f167027c + ", pdpParams=" + this.f167028d + ", pdpPassDataHolder=" + this.f167029e + ", openPdpListener=" + this.f167030f + ", splitParam=" + this.f167031g + ")";
    }

    public c(PdpSchemaProcessor r100, SchemaPackRequest r101, V4NativeParams r102, h r103, u r104, o r105, SplitParam r106) {
        Intrinsics.checkNotNullParameter(r100, "schemaProcessor");
        Intrinsics.checkNotNullParameter(r101, "reqParams");
        Intrinsics.checkNotNullParameter(r102, "nativeParams");
        Intrinsics.checkNotNullParameter(r103, "pdpParams");
        Intrinsics.checkNotNullParameter(r104, "pdpPassDataHolder");
        Intrinsics.checkNotNullParameter(r105, "openPdpListener");
        Intrinsics.checkNotNullParameter(r106, "splitParam");
        this.f167025a = r100;
        this.f167026b = r101;
        this.f167027c = r102;
        this.f167028d = r103;
        this.f167029e = r104;
        this.f167030f = r105;
        this.f167031g = r106;
    }
}
