package a5;

/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final float f1644a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final boolean g;

    public h(float f, float f7, float f9, float f10, float f11, float f12, boolean z10) {
        this.f1644a = f;
        this.b = f7;
        this.c = f9;
        this.d = f10;
        this.e = f11;
        this.f = f12;
        this.g = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Float.compare(this.f1644a, hVar.f1644a) == 0 && Float.compare(this.b, hVar.b) == 0 && Float.compare(this.c, hVar.c) == 0 && Float.compare(this.d, hVar.d) == 0 && Float.compare(this.e, hVar.e) == 0 && Float.compare(this.f, hVar.f) == 0 && this.g == hVar.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int iB = androidx.appfunctions.metadata.a.b(this.f, androidx.appfunctions.metadata.a.b(this.e, androidx.appfunctions.metadata.a.b(this.d, androidx.appfunctions.metadata.a.b(this.c, androidx.appfunctions.metadata.a.b(this.b, Float.hashCode(this.f1644a) * 31, 31), 31), 31), 31), 31);
        boolean z10 = this.g;
        int i = z10;
        if (z10 != 0) {
            i = 1;
        }
        return iB + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SmoothPathParams(left=");
        sb.append(this.f1644a);
        sb.append(", top=");
        sb.append(this.b);
        sb.append(", right=");
        sb.append(this.c);
        sb.append(", bottom=");
        sb.append(this.d);
        sb.append(", smoothness=");
        sb.append(this.e);
        sb.append(", radius=");
        sb.append(this.f);
        sb.append(", useNativeRoundCornerWhileParamsInvalid=");
        return androidx.appfunctions.metadata.a.r(sb, this.g, ')');
    }
}
