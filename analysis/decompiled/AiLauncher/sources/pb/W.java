package pb;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.ame.sdk.SkillStoreKt;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import mb.C4931a;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\b\u001a\u00020\u0004*\u00020\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u0005*\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lpb/W;", "Lkotlinx/serialization/KSerializer;", "", "Lpb/O0;", "", "Lpb/V;", "<init>", "()V", "w", "([I)I", "z", "([I)Lpb/V;", "x", "()[I", "Lob/c;", "decoder", "index", "builder", "", "checkIndex", "LY8/t;", "y", "(Lob/c;ILpb/V;Z)V", "Lob/d;", "encoder", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, ContentDisposition.Parameters.Size, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lob/d;[II)V", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class W extends O0<Integer, int[], V> implements KSerializer<int[]> {

    /* renamed from: c, reason: collision with root package name */
    public static final W f38323c = new W();

    public W() {
        super(C4931a.E(kotlin.jvm.internal.o.f34832a));
    }

    @Override // pb.O0
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void v(ob.d encoder, int[] content, int size) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(content, "content");
        for (int i10 = 0; i10 < size; i10++) {
            encoder.t(getDescriptor(), i10, content[i10]);
        }
    }

    @Override // pb.AbstractC5084a
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public int f(int[] iArr) {
        kotlin.jvm.internal.p.i(iArr, "<this>");
        return iArr.length;
    }

    @Override // pb.O0
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public int[] s() {
        return new int[0];
    }

    @Override // pb.AbstractC5125v, pb.AbstractC5084a
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void i(ob.c decoder, int index, V builder, boolean checkIndex) {
        kotlin.jvm.internal.p.i(decoder, "decoder");
        kotlin.jvm.internal.p.i(builder, "builder");
        builder.e(decoder.decodeIntElement(getDescriptor(), index));
    }

    @Override // pb.AbstractC5084a
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public V l(int[] iArr) {
        kotlin.jvm.internal.p.i(iArr, "<this>");
        return new V(iArr);
    }
}
