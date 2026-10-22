package pb;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.ame.sdk.SkillStoreKt;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import mb.C4931a;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\u00020\b*\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u0005*\u00020\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lpb/q;", "Lkotlinx/serialization/KSerializer;", "", "Lpb/O0;", "", "Lpb/p;", "<init>", "()V", "", "w", "([C)I", "z", "([C)Lpb/p;", "x", "()[C", "Lob/c;", "decoder", "index", "builder", "", "checkIndex", "LY8/t;", "y", "(Lob/c;ILpb/p;Z)V", "Lob/d;", "encoder", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, ContentDisposition.Parameters.Size, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lob/d;[CI)V", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: pb.q, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5116q extends O0<Character, char[], C5114p> implements KSerializer<char[]> {

    /* renamed from: c, reason: collision with root package name */
    public static final C5116q f38402c = new C5116q();

    public C5116q() {
        super(C4931a.B(kotlin.jvm.internal.e.f34825a));
    }

    @Override // pb.O0
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void v(ob.d encoder, char[] content, int size) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(content, "content");
        for (int i10 = 0; i10 < size; i10++) {
            encoder.l(getDescriptor(), i10, content[i10]);
        }
    }

    @Override // pb.AbstractC5084a
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public int f(char[] cArr) {
        kotlin.jvm.internal.p.i(cArr, "<this>");
        return cArr.length;
    }

    @Override // pb.O0
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public char[] s() {
        return new char[0];
    }

    @Override // pb.AbstractC5125v, pb.AbstractC5084a
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void i(ob.c decoder, int index, C5114p builder, boolean checkIndex) {
        kotlin.jvm.internal.p.i(decoder, "decoder");
        kotlin.jvm.internal.p.i(builder, "builder");
        builder.e(decoder.decodeCharElement(getDescriptor(), index));
    }

    @Override // pb.AbstractC5084a
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public C5114p l(char[] cArr) {
        kotlin.jvm.internal.p.i(cArr, "<this>");
        return new C5114p(cArr);
    }
}
