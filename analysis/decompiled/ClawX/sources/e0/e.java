package e0;

import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f2302a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2303b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2304c;

    public e(String str, int i8, int i9) {
        this.f2302a = str;
        this.f2303b = i8;
        this.f2304c = i9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Objects.equals(this.f2302a, eVar.f2302a) && this.f2303b == eVar.f2303b && this.f2304c == eVar.f2304c;
    }

    public final int hashCode() {
        Integer numValueOf = Integer.valueOf(this.f2303b);
        Integer numValueOf2 = Integer.valueOf(this.f2304c);
        Float fValueOf = Float.valueOf(1.0f);
        return Objects.hash(this.f2302a, numValueOf, numValueOf2, fValueOf, 0, 0, 0, fValueOf);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DisplayShapeCompat{ spec=");
        String str = this.f2302a;
        sb.append(str != null ? Integer.valueOf(str.hashCode()) : AbstractJsonLexerKt.NULL);
        sb.append(" displayWidth=");
        sb.append(this.f2303b);
        sb.append(" displayHeight=");
        return m0.f.e(sb, this.f2304c, " physicalPixelDisplaySizeRatio=1.0 rotation=0 offsetX=0 offsetY=0 scale=1.0}");
    }
}
