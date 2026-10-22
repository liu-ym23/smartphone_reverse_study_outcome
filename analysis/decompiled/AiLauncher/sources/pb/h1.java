package pb;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.ame.sdk.SkillStoreKt;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import mb.C4931a;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\u00020\b*\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u0005*\u00020\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lpb/h1;", "Lkotlinx/serialization/KSerializer;", "LY8/l;", "Lpb/O0;", "LY8/k;", "Lpb/g1;", "<init>", "()V", "", "w", "([B)I", "z", "([B)Lpb/g1;", "x", "()[B", "Lob/c;", "decoder", "index", "builder", "", "checkIndex", "LY8/t;", "y", "(Lob/c;ILpb/g1;Z)V", "Lob/d;", "encoder", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, ContentDisposition.Parameters.Size, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lob/d;[BI)V", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class h1 extends O0<Y8.k, Y8.l, g1> implements KSerializer<Y8.l> {

    /* renamed from: c, reason: collision with root package name */
    public static final h1 f38362c = new h1();

    public h1() {
        super(C4931a.u(Y8.k.INSTANCE));
    }

    public void A(ob.d encoder, byte[] content, int size) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(content, "content");
        for (int i10 = 0; i10 < size; i10++) {
            encoder.b(getDescriptor(), i10).d(Y8.l.l(content, i10));
        }
    }

    @Override // pb.AbstractC5084a
    public /* bridge */ /* synthetic */ int f(Object obj) {
        return w(((Y8.l) obj).getStorage());
    }

    @Override // pb.AbstractC5084a
    public /* bridge */ /* synthetic */ Object l(Object obj) {
        return z(((Y8.l) obj).getStorage());
    }

    @Override // pb.O0
    public /* bridge */ /* synthetic */ Y8.l s() {
        return Y8.l.b(x());
    }

    @Override // pb.O0
    public /* bridge */ /* synthetic */ void v(ob.d dVar, Y8.l lVar, int i10) {
        A(dVar, lVar.getStorage(), i10);
    }

    public int w(byte[] collectionSize) {
        kotlin.jvm.internal.p.i(collectionSize, "$this$collectionSize");
        return Y8.l.n(collectionSize);
    }

    public byte[] x() {
        return Y8.l.c(0);
    }

    @Override // pb.AbstractC5125v, pb.AbstractC5084a
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void i(ob.c decoder, int index, g1 builder, boolean checkIndex) {
        kotlin.jvm.internal.p.i(decoder, "decoder");
        kotlin.jvm.internal.p.i(builder, "builder");
        builder.e(Y8.k.b(decoder.decodeInlineElement(getDescriptor(), index).decodeByte()));
    }

    public g1 z(byte[] toBuilder) {
        kotlin.jvm.internal.p.i(toBuilder, "$this$toBuilder");
        return new g1(toBuilder, null);
    }
}
