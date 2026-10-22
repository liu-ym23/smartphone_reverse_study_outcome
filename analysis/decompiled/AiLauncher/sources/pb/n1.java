package pb;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.ame.sdk.SkillStoreKt;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import mb.C4931a;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\u00020\b*\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u0005*\u00020\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lpb/n1;", "Lkotlinx/serialization/KSerializer;", "LY8/p;", "Lpb/O0;", "LY8/o;", "Lpb/m1;", "<init>", "()V", "", "w", "([J)I", "z", "([J)Lpb/m1;", "x", "()[J", "Lob/c;", "decoder", "index", "builder", "", "checkIndex", "LY8/t;", "y", "(Lob/c;ILpb/m1;Z)V", "Lob/d;", "encoder", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, ContentDisposition.Parameters.Size, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lob/d;[JI)V", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class n1 extends O0<Y8.o, Y8.p, m1> implements KSerializer<Y8.p> {

    /* renamed from: c, reason: collision with root package name */
    public static final n1 f38394c = new n1();

    public n1() {
        super(C4931a.w(Y8.o.INSTANCE));
    }

    public void A(ob.d encoder, long[] content, int size) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(content, "content");
        for (int i10 = 0; i10 < size; i10++) {
            encoder.b(getDescriptor(), i10).i(Y8.p.l(content, i10));
        }
    }

    @Override // pb.AbstractC5084a
    public /* bridge */ /* synthetic */ int f(Object obj) {
        return w(((Y8.p) obj).getStorage());
    }

    @Override // pb.AbstractC5084a
    public /* bridge */ /* synthetic */ Object l(Object obj) {
        return z(((Y8.p) obj).getStorage());
    }

    @Override // pb.O0
    public /* bridge */ /* synthetic */ Y8.p s() {
        return Y8.p.b(x());
    }

    @Override // pb.O0
    public /* bridge */ /* synthetic */ void v(ob.d dVar, Y8.p pVar, int i10) {
        A(dVar, pVar.getStorage(), i10);
    }

    public int w(long[] collectionSize) {
        kotlin.jvm.internal.p.i(collectionSize, "$this$collectionSize");
        return Y8.p.n(collectionSize);
    }

    public long[] x() {
        return Y8.p.c(0);
    }

    @Override // pb.AbstractC5125v, pb.AbstractC5084a
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void i(ob.c decoder, int index, m1 builder, boolean checkIndex) {
        kotlin.jvm.internal.p.i(decoder, "decoder");
        kotlin.jvm.internal.p.i(builder, "builder");
        builder.e(Y8.o.b(decoder.decodeInlineElement(getDescriptor(), index).decodeLong()));
    }

    public m1 z(long[] toBuilder) {
        kotlin.jvm.internal.p.i(toBuilder, "$this$toBuilder");
        return new m1(toBuilder, null);
    }
}
