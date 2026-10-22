package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class s3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f126413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a5 f126414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, c5> f126415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IBaseUser f126416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f126417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f126418f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s3) == false) goto L18;
        s3 r101 = (s3) r100;
        if (Intrinsics.areEqual(this.f126413a, r101.f126413a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f126414b, r101.f126414b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f126415c, r101.f126415c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f126416d, r101.f126416d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f126417e, r101.f126417e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f126418f, r101.f126418f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f126413a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        a5 r104 = this.f126414b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, c5> r107 = this.f126415c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        IBaseUser r110 = this.f126416d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f126417e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, String> r116 = this.f126418f;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
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
        return "TextPrivilegeDressInfo(dressId=" + this.f126413a + ", fullText=" + this.f126414b + ", templateValues=" + this.f126415c + ", user=" + this.f126416d + ", finishSelfSchema=" + this.f126417e + ", trackingMap=" + this.f126418f + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s3(String r100, a5 r101, Map<String, ? extends c5> r102, IBaseUser r103, String r104, Map<String, String> r105) {
        Intrinsics.checkNotNullParameter(r100, "dressId");
        Intrinsics.checkNotNullParameter(r103, "user");
        Intrinsics.checkNotNullParameter(r104, "finishSelfSchema");
        Intrinsics.checkNotNullParameter(r105, "trackingMap");
        this.f126413a = r100;
        this.f126414b = r101;
        this.f126415c = r102;
        this.f126416d = r103;
        this.f126417e = r104;
        this.f126418f = r105;
    }
}
