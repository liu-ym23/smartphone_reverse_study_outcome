package acc;

import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.widget.cleanresource.ResourceType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResourceType f2927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ResourceCleanScene f2928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2929c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f2927a == r101.f2927a) goto L12;
        return false;
    L12:
        if (this.f2928b == r101.f2928b) goto L15;
        return false;
    L15:
        if (this.f2929c == r101.f2929c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f2927a.hashCode() * 31;
        ResourceCleanScene r101 = this.f2928b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f2929c == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ResourceCleanedParams(type=" + this.f2927a + ", cleanScene=" + this.f2928b + ", sentFromCurrentTenant=" + this.f2929c + ')';
    }

    public final ResourceType getType() {
        return this.f2927a;
    }

    public d(ResourceType r100, ResourceCleanScene r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f2927a = r100;
        this.f2928b = r101;
        this.f2929c = r102;
    }
}
