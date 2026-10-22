package pb;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.ame.sdk.SkillStoreKt;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.C4852c;
import kotlinx.serialization.KSerializer;
import mb.C4931a;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\u00020\b*\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u0005*\u00020\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\bH\u0014¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lpb/h;", "Lkotlinx/serialization/KSerializer;", "", "Lpb/O0;", "", "Lpb/g;", "<init>", "()V", "", "w", "([Z)I", "z", "([Z)Lpb/g;", "x", "()[Z", "Lob/c;", "decoder", "index", "builder", "checkIndex", "LY8/t;", "y", "(Lob/c;ILpb/g;Z)V", "Lob/d;", "encoder", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, ContentDisposition.Parameters.Size, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lob/d;[ZI)V", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: pb.h, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5098h extends O0<Boolean, boolean[], C5096g> implements KSerializer<boolean[]> {

    /* renamed from: c, reason: collision with root package name */
    public static final C5098h f38360c = new C5098h();

    public C5098h() {
        super(C4931a.z(C4852c.f34823a));
    }

    @Override // pb.O0
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void v(ob.d encoder, boolean[] content, int size) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(content, "content");
        for (int i10 = 0; i10 < size; i10++) {
            encoder.v(getDescriptor(), i10, content[i10]);
        }
    }

    @Override // pb.AbstractC5084a
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public int f(boolean[] zArr) {
        kotlin.jvm.internal.p.i(zArr, "<this>");
        return zArr.length;
    }

    @Override // pb.O0
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public boolean[] s() {
        return new boolean[0];
    }

    @Override // pb.AbstractC5125v, pb.AbstractC5084a
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void i(ob.c decoder, int index, C5096g builder, boolean checkIndex) {
        kotlin.jvm.internal.p.i(decoder, "decoder");
        kotlin.jvm.internal.p.i(builder, "builder");
        builder.e(decoder.decodeBooleanElement(getDescriptor(), index));
    }

    @Override // pb.AbstractC5084a
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public C5096g l(boolean[] zArr) {
        kotlin.jvm.internal.p.i(zArr, "<this>");
        return new C5096g(zArr);
    }
}
