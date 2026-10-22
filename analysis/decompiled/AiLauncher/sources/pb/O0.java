package pb;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.util.Iterator;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import pb.M0;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b!\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u000e\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00010\u00032\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005B\u0017\b\u0000\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u000b\u001a\u00020\n*\u00028\u0002H\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00028\u0001*\u00028\u0002H\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\u0010*\u00028\u00022\u0006\u0010\u000f\u001a\u00020\nH\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013*\u00028\u0001H\u0004¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0018\u001a\u00020\u0010*\u00028\u00022\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00028\u0002H\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00028\u0001H$¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010!\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\nH$¢\u0006\u0004\b!\u0010\"J\u001d\u0010%\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020#2\u0006\u0010$\u001a\u00028\u0001¢\u0006\u0004\b%\u0010&J\u0015\u0010)\u001a\u00028\u00012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*R\u0017\u00100\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00061"}, d2 = {"Lpb/O0;", "Element", "Array", "Lpb/M0;", "Builder", "Lpb/v;", "Lkotlinx/serialization/KSerializer;", "primitiveSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "", "q", "(Lpb/M0;)I", "u", "(Lpb/M0;)Ljava/lang/Object;", ContentDisposition.Parameters.Size, "LY8/t;", "r", "(Lpb/M0;I)V", "", "e", "(Ljava/lang/Object;)Ljava/util/Iterator;", "index", "element", "t", "(Lpb/M0;ILjava/lang/Object;)V", "p", "()Lpb/M0;", "s", "()Ljava/lang/Object;", "Lob/d;", "encoder", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "v", "(Lob/d;Ljava/lang/Object;I)V", "Lkotlinx/serialization/encoding/Encoder;", UxipConstants.f30680s, "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", Const.INTENT_KEY_PKGNAME, "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class O0<Element, Array, Builder extends M0<Array>> extends AbstractC5125v<Element, Array, Builder> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final SerialDescriptor descriptor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O0(KSerializer<Element> primitiveSerializer) {
        super(primitiveSerializer, null);
        kotlin.jvm.internal.p.i(primitiveSerializer, "primitiveSerializer");
        this.descriptor = new N0(primitiveSerializer.getDescriptor());
    }

    @Override // pb.AbstractC5084a, lb.InterfaceC4883a
    public final Array deserialize(Decoder decoder) {
        kotlin.jvm.internal.p.i(decoder, "decoder");
        return g(decoder, null);
    }

    @Override // pb.AbstractC5084a
    public final Iterator<Element> e(Array array) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead");
    }

    @Override // pb.AbstractC5125v, kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // pb.AbstractC5084a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public final Builder b() {
        return l(s());
    }

    @Override // pb.AbstractC5084a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public final int c(Builder builder) {
        kotlin.jvm.internal.p.i(builder, "<this>");
        return builder.getPosition();
    }

    @Override // pb.AbstractC5084a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public final void d(Builder builder, int i10) {
        kotlin.jvm.internal.p.i(builder, "<this>");
        builder.b(i10);
    }

    public abstract Array s();

    @Override // pb.AbstractC5125v, lb.m
    public final void serialize(Encoder encoder, Array value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        int iF = f(value);
        SerialDescriptor serialDescriptor = this.descriptor;
        ob.d dVarF = encoder.f(serialDescriptor, iF);
        v(dVarF, value, iF);
        dVarF.endStructure(serialDescriptor);
    }

    @Override // pb.AbstractC5125v
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public final void o(Builder builder, int i10, Element element) {
        kotlin.jvm.internal.p.i(builder, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead");
    }

    @Override // pb.AbstractC5084a
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public final Array m(Builder builder) {
        kotlin.jvm.internal.p.i(builder, "<this>");
        return (Array) builder.a();
    }

    public abstract void v(ob.d encoder, Array content, int size);
}
