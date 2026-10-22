package x;

import android.graphics.Insets;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final b f6231e = new b(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f6232a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6233b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6234c;
    public final int d;

    public b(int i8, int i9, int i10, int i11) {
        this.f6232a = i8;
        this.f6233b = i9;
        this.f6234c = i10;
        this.d = i11;
    }

    public static b a(b bVar, b bVar2) {
        return b(Math.max(bVar.f6232a, bVar2.f6232a), Math.max(bVar.f6233b, bVar2.f6233b), Math.max(bVar.f6234c, bVar2.f6234c), Math.max(bVar.d, bVar2.d));
    }

    public static b b(int i8, int i9, int i10, int i11) {
        return (i8 == 0 && i9 == 0 && i10 == 0 && i11 == 0) ? f6231e : new b(i8, i9, i10, i11);
    }

    public static b c(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public final Insets d() {
        return Insets.of(this.f6232a, this.f6233b, this.f6234c, this.d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.d == bVar.d && this.f6232a == bVar.f6232a && this.f6234c == bVar.f6234c && this.f6233b == bVar.f6233b;
    }

    public final int hashCode() {
        return (((((this.f6232a * 31) + this.f6233b) * 31) + this.f6234c) * 31) + this.d;
    }

    public final String toString() {
        return "Insets{left=" + this.f6232a + ", top=" + this.f6233b + ", right=" + this.f6234c + ", bottom=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }
}
