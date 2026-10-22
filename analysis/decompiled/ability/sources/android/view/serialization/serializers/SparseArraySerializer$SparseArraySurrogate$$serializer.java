package android.view.serialization.serializers;

import A9.d;
import A9.e;
import B9.A;
import B9.C0177d;
import B9.V;
import C7.c;
import C7.f;
import android.view.serialization.serializers.SparseArraySerializer;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlinx.serialization.UnknownFieldException;
import x9.InterfaceC2123a;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000@\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000*\u0004\b\u0002\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00030\u0002B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0017\b\u0016\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ#\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0013¢\u0006\u0004\b\u0016\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"androidx/savedstate/serialization/serializers/SparseArraySerializer.SparseArraySurrogate.$serializer", ExifInterface.GPS_DIRECTION_TRUE, "LB9/A;", "Landroidx/savedstate/serialization/serializers/SparseArraySerializer$SparseArraySurrogate;", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "typeSerial0", "(Lx9/b;)V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Landroidx/savedstate/serialization/serializers/SparseArraySerializer$SparseArraySurrogate;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Landroidx/savedstate/serialization/serializers/SparseArraySerializer$SparseArraySurrogate;", "", "childSerializers", "()[Lx9/b;", "typeParametersSerializers", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@c
/* loaded from: classes2.dex */
public /* synthetic */ class SparseArraySerializer$SparseArraySurrogate$$serializer<T> implements A {
    private final g descriptor;
    private final /* synthetic */ b typeSerial0;

    private SparseArraySerializer$SparseArraySurrogate$$serializer() {
        V v10 = new V("androidx.savedstate.serialization.serializers.SparseArraySerializer.SparseArraySurrogate", this, 2);
        v10.j("keys", false);
        v10.j("values", false);
        this.descriptor = v10;
    }

    private final /* synthetic */ b getTypeSerial0() {
        return this.typeSerial0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // B9.A
    public final b[] childSerializers() {
        return new b[]{SparseArraySerializer.SparseArraySurrogate.$childSerializers[0].getF4884a(), new C0177d(this.typeSerial0)};
    }

    @Override // x9.InterfaceC2123a
    public final SparseArraySerializer.SparseArraySurrogate<T> deserialize(e decoder) {
        List list;
        List list2;
        int i;
        k.f(decoder, "decoder");
        g gVar = this.descriptor;
        A9.c cVarBeginStructure = decoder.beginStructure(gVar);
        f[] fVarArr = SparseArraySerializer.SparseArraySurrogate.$childSerializers;
        if (cVarBeginStructure.decodeSequentially()) {
            list2 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 0, (InterfaceC2123a) fVarArr[0].getF4884a(), null);
            list = (List) cVarBeginStructure.decodeSerializableElement(gVar, 1, new C0177d(this.typeSerial0), null);
            i = 3;
        } else {
            boolean z10 = true;
            int i6 = 0;
            List list3 = null;
            List list4 = null;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                if (iDecodeElementIndex == -1) {
                    z10 = false;
                } else if (iDecodeElementIndex == 0) {
                    list4 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 0, (InterfaceC2123a) fVarArr[0].getF4884a(), list4);
                    i6 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    list3 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 1, new C0177d(this.typeSerial0), list3);
                    i6 |= 2;
                }
            }
            list = list3;
            list2 = list4;
            i = i6;
        }
        cVarBeginStructure.endStructure(gVar);
        return new SparseArraySerializer.SparseArraySurrogate<>(i, list2, list, null);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return this.descriptor;
    }

    @Override // x9.f
    public final void serialize(A9.f encoder, SparseArraySerializer.SparseArraySurrogate<T> value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        g gVar = this.descriptor;
        d dVarBeginStructure = encoder.beginStructure(gVar);
        SparseArraySerializer.SparseArraySurrogate.write$Self$savedstate_release(value, dVarBeginStructure, gVar, this.typeSerial0);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // B9.A
    public final b[] typeParametersSerializers() {
        return new b[]{this.typeSerial0};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SparseArraySerializer$SparseArraySurrogate$$serializer(b typeSerial0) {
        this();
        k.f(typeSerial0, "typeSerial0");
        this.typeSerial0 = typeSerial0;
    }
}
