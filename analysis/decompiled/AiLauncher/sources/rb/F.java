package rb;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.util.List;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;
import qb.AbstractC5171a;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010!¨\u0006%"}, d2 = {"Lrb/F;", "Lrb/B;", "Lqb/a;", "json", "Lqb/D;", UxipConstants.f30680s, "<init>", "(Lqb/a;Lqb/D;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "index", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/String;", "decodeElementIndex", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "tag", "Lqb/i;", "G", "(Ljava/lang/String;)Lqb/i;", "LY8/t;", "endStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "l", "Lqb/D;", "Y", "()Lqb/D;", "", "m", "Ljava/util/List;", "keys", "n", "I", ContentDisposition.Parameters.Size, "o", "position", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class F extends C5247B {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final qb.D value;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final List<String> keys;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final int size;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public int position;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F(AbstractC5171a json, qb.D value) {
        super(json, value, null, null, 12, null);
        kotlin.jvm.internal.p.i(json, "json");
        kotlin.jvm.internal.p.i(value, "value");
        this.value = value;
        List<String> listM1 = Z8.F.m1(U().keySet());
        this.keys = listM1;
        this.size = listM1.size() * 2;
        this.position = -1;
    }

    @Override // rb.C5247B, pb.AbstractC5115p0
    public String A(SerialDescriptor descriptor, int index) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        return this.keys.get(index / 2);
    }

    @Override // rb.C5247B, rb.AbstractC5253c
    public qb.i G(String tag) {
        kotlin.jvm.internal.p.i(tag, "tag");
        return this.position % 2 == 0 ? qb.j.c(tag) : (qb.i) kotlin.collections.a.j(U(), tag);
    }

    @Override // rb.C5247B, rb.AbstractC5253c
    /* renamed from: Y, reason: from getter and merged with bridge method [inline-methods] */
    public qb.D getValue() {
        return this.value;
    }

    @Override // rb.C5247B, ob.c
    public int decodeElementIndex(SerialDescriptor descriptor) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        int i10 = this.position;
        if (i10 >= this.size - 1) {
            return -1;
        }
        int i11 = i10 + 1;
        this.position = i11;
        return i11;
    }

    @Override // rb.C5247B, rb.AbstractC5253c, ob.c
    public void endStructure(SerialDescriptor descriptor) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
    }
}
