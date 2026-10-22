package P6;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import mb.C4931a;
import pb.E0;
import pb.I0;
import pb.M;
import pb.T0;
import pb.Y0;
import qb.D;
import qb.E;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002\u0014&BC\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b \u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b!\u0010\u0017R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\"\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"LP6/k;", "", "", "seen0", "", "bizRefType", "bizRefId", "bindingRole", "Lqb/D;", "metadata", "Lpb/T0;", "serializationConstructorMarker", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lqb/D;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", Const.INTENT_KEY_APIKEY, "(LP6/k;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getBizRefType", "getBizRefId", "getBindingRole", "Lqb/D;", "getMetadata", "()Lqb/D;", "Companion", Const.INTENT_KEY_PKGNAME, "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@lb.l
/* renamed from: P6.k, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class UploadBinding {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String bindingRole;
    private final String bizRefId;
    private final String bizRefType;
    private final D metadata;

    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/stepos/common/utils/filestorage/models/UploadBinding.$serializer", "Lpb/M;", "LP6/k;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "c", "(Lkotlinx/serialization/encoding/Encoder;LP6/k;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", Const.INTENT_KEY_PKGNAME, "(Lkotlinx/serialization/encoding/Decoder;)LP6/k;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: P6.k$a */
    public /* synthetic */ class a implements M<UploadBinding> {
        public static final a INSTANCE;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            I0 i02 = new I0("com.stepos.common.utils.filestorage.models.UploadBinding", aVar, 4);
            i02.n("bizRefType", false);
            i02.n("bizRefId", false);
            i02.n("bindingRole", false);
            i02.n("metadata", true);
            descriptor = i02;
        }

        @Override // lb.InterfaceC4883a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final UploadBinding deserialize(Decoder decoder) {
            int i10;
            String str;
            String str2;
            String str3;
            D d10;
            p.i(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
            String strDecodeStringElement = null;
            if (cVarBeginStructure.decodeSequentially()) {
                String strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
                String strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(serialDescriptor, 1);
                String strDecodeStringElement4 = cVarBeginStructure.decodeStringElement(serialDescriptor, 2);
                str = strDecodeStringElement2;
                d10 = (D) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, E.f38623a, null);
                str3 = strDecodeStringElement4;
                str2 = strDecodeStringElement3;
                i10 = 15;
            } else {
                boolean z10 = true;
                int i11 = 0;
                String strDecodeStringElement5 = null;
                String strDecodeStringElement6 = null;
                D d11 = null;
                while (z10) {
                    int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z10 = false;
                    } else if (iDecodeElementIndex == 0) {
                        strDecodeStringElement = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i11 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        strDecodeStringElement5 = cVarBeginStructure.decodeStringElement(serialDescriptor, 1);
                        i11 |= 2;
                    } else if (iDecodeElementIndex == 2) {
                        strDecodeStringElement6 = cVarBeginStructure.decodeStringElement(serialDescriptor, 2);
                        i11 |= 4;
                    } else {
                        if (iDecodeElementIndex != 3) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        d11 = (D) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, E.f38623a, d11);
                        i11 |= 8;
                    }
                }
                i10 = i11;
                str = strDecodeStringElement;
                str2 = strDecodeStringElement5;
                str3 = strDecodeStringElement6;
                d10 = d11;
            }
            cVarBeginStructure.endStructure(serialDescriptor);
            return new UploadBinding(i10, str, str2, str3, d10, null);
        }

        @Override // lb.m
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, UploadBinding value) {
            p.i(encoder, "encoder");
            p.i(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            ob.d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
            UploadBinding.a(value, dVarBeginStructure, serialDescriptor);
            dVarBeginStructure.endStructure(serialDescriptor);
        }

        @Override // pb.M
        public final KSerializer<?>[] childSerializers() {
            KSerializer<?> kSerializerT = C4931a.t(E.f38623a);
            Y0 y02 = Y0.f38329a;
            return new KSerializer[]{y02, y02, y02, kSerializerT};
        }

        @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // pb.M
        public KSerializer<?>[] typeParametersSerializers() {
            return M.a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"LP6/k$b;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "LP6/k;", "serializer", "()Lkotlinx/serialization/KSerializer;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: P6.k$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<UploadBinding> serializer() {
            return a.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ UploadBinding(int i10, String str, String str2, String str3, D d10, T0 t02) {
        if (7 != (i10 & 7)) {
            E0.a(i10, 7, a.INSTANCE.getDescriptor());
        }
        this.bizRefType = str;
        this.bizRefId = str2;
        this.bindingRole = str3;
        if ((i10 & 8) == 0) {
            this.metadata = null;
        } else {
            this.metadata = d10;
        }
    }

    public static final /* synthetic */ void a(UploadBinding self, ob.d output, SerialDescriptor serialDesc) {
        output.w(serialDesc, 0, self.bizRefType);
        output.w(serialDesc, 1, self.bizRefId);
        output.w(serialDesc, 2, self.bindingRole);
        if (!output.y(serialDesc, 3) && self.metadata == null) {
            return;
        }
        output.k(serialDesc, 3, E.f38623a, self.metadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadBinding)) {
            return false;
        }
        UploadBinding uploadBinding = (UploadBinding) other;
        return p.d(this.bizRefType, uploadBinding.bizRefType) && p.d(this.bizRefId, uploadBinding.bizRefId) && p.d(this.bindingRole, uploadBinding.bindingRole) && p.d(this.metadata, uploadBinding.metadata);
    }

    public int hashCode() {
        int iHashCode = ((((this.bizRefType.hashCode() * 31) + this.bizRefId.hashCode()) * 31) + this.bindingRole.hashCode()) * 31;
        D d10 = this.metadata;
        return iHashCode + (d10 == null ? 0 : d10.hashCode());
    }

    public String toString() {
        return "UploadBinding(bizRefType=" + this.bizRefType + ", bizRefId=" + this.bizRefId + ", bindingRole=" + this.bindingRole + ", metadata=" + this.metadata + ")";
    }
}
