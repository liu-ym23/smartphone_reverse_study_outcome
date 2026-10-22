package y2;

import java.util.Arrays;

/* renamed from: y2.m, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5932m {

    /* renamed from: a, reason: collision with root package name */
    public final String f43828a;

    /* renamed from: b, reason: collision with root package name */
    public final C5930k f43829b;

    /* renamed from: c, reason: collision with root package name */
    public C5930k f43830c;

    public /* synthetic */ C5932m(String str, C5931l c5931l) {
        C5930k c5930k = new C5930k();
        this.f43829b = c5930k;
        this.f43830c = c5930k;
        str.getClass();
        this.f43828a = str;
    }

    public final C5932m a(String str, Object obj) {
        C5930k c5930k = new C5930k();
        this.f43830c.f43827c = c5930k;
        this.f43830c = c5930k;
        c5930k.f43826b = obj;
        c5930k.f43825a = str;
        return this;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append(this.f43828a);
        sb2.append('{');
        C5930k c5930k = this.f43829b.f43827c;
        String str = "";
        while (c5930k != null) {
            Object obj = c5930k.f43826b;
            sb2.append(str);
            String str2 = c5930k.f43825a;
            if (str2 != null) {
                sb2.append(str2);
                sb2.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb2.append(obj);
            } else {
                sb2.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r1.length() - 1);
            }
            c5930k = c5930k.f43827c;
            str = ", ";
        }
        sb2.append('}');
        return sb2.toString();
    }
}
