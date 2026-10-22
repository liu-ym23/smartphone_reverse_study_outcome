package at5;

import com.bytedance.ee.larkwebview.bridge.Status;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Status f16258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f16260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f16261d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f16258a == r101.f16258a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f16259b, r101.f16259b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f16260c, r101.f16260c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f16261d, r101.f16261d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Status r100 = this.f16258a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f16259b.hashCode()) * 31;
        Object r104 = this.f16260c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Object r107 = this.f16261d;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ResponseJsData(status=" + this.f16258a + ", callbackId=" + this.f16259b + ", data=" + this.f16260c + ", extraStr=" + this.f16261d + ')';
    }

    public l() {
        Intrinsics.checkNotNullParameter("", "callbackId");
        this.f16258a = null;
        this.f16259b = "";
        this.f16260c = null;
        this.f16261d = null;
    }
}
