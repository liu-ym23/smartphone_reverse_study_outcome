package P6;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import pb.C5094f;
import pb.E0;
import pb.I0;
import pb.M;
import pb.T0;
import pb.Y0;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b\u0081\b\u0018\u0000 \u001f2\u00020\u0001:\u0002 \u0012B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\u000bJ'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"LP6/b;", "", "", "", "fileIds", "<init>", "(Ljava/util/List;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/util/List;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(LP6/b;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getFileIds", "()Ljava/util/List;", "Companion", Const.INTENT_KEY_APIKEY, "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@lb.l
/* renamed from: P6.b, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class BatchQueryStorageObjectRequest {
    private final List<String> fileIds;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new C5094f(Y0.f38329a)};

    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/stepos/common/utils/filestorage/models/BatchQueryStorageObjectRequest.$serializer", "Lpb/M;", "LP6/b;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "c", "(Lkotlinx/serialization/encoding/Encoder;LP6/b;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", Const.INTENT_KEY_PKGNAME, "(Lkotlinx/serialization/encoding/Decoder;)LP6/b;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: P6.b$a */
    public /* synthetic */ class a implements M<BatchQueryStorageObjectRequest> {
        public static final a INSTANCE;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            I0 i02 = new I0("com.stepos.common.utils.filestorage.models.BatchQueryStorageObjectRequest", aVar, 1);
            i02.n("fileIds", false);
            descriptor = i02;
        }

        @Override // lb.InterfaceC4883a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final BatchQueryStorageObjectRequest deserialize(Decoder decoder) {
            List list;
            p.i(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
            KSerializer[] kSerializerArr = BatchQueryStorageObjectRequest.$childSerializers;
            int i10 = 1;
            T0 t02 = null;
            if (cVarBeginStructure.decodeSequentially()) {
                list = (List) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], null);
            } else {
                boolean z10 = true;
                int i11 = 0;
                List list2 = null;
                while (z10) {
                    int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z10 = false;
                    } else {
                        if (iDecodeElementIndex != 0) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        list2 = (List) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], list2);
                        i11 = 1;
                    }
                }
                list = list2;
                i10 = i11;
            }
            cVarBeginStructure.endStructure(serialDescriptor);
            return new BatchQueryStorageObjectRequest(i10, list, t02);
        }

        @Override // lb.m
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, BatchQueryStorageObjectRequest value) {
            p.i(encoder, "encoder");
            p.i(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            ob.d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
            BatchQueryStorageObjectRequest.b(value, dVarBeginStructure, serialDescriptor);
            dVarBeginStructure.endStructure(serialDescriptor);
        }

        @Override // pb.M
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[]{BatchQueryStorageObjectRequest.$childSerializers[0]};
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

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"LP6/b$b;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "LP6/b;", "serializer", "()Lkotlinx/serialization/KSerializer;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: P6.b$b, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<BatchQueryStorageObjectRequest> serializer() {
            return a.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ BatchQueryStorageObjectRequest(int i10, List list, T0 t02) {
        if (1 != (i10 & 1)) {
            E0.a(i10, 1, a.INSTANCE.getDescriptor());
        }
        this.fileIds = list;
    }

    public static final /* synthetic */ void b(BatchQueryStorageObjectRequest self, ob.d output, SerialDescriptor serialDesc) {
        output.x(serialDesc, 0, $childSerializers[0], self.fileIds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof BatchQueryStorageObjectRequest) && p.d(this.fileIds, ((BatchQueryStorageObjectRequest) other).fileIds);
    }

    public int hashCode() {
        return this.fileIds.hashCode();
    }

    public String toString() {
        return "BatchQueryStorageObjectRequest(fileIds=" + this.fileIds + ")";
    }

    public BatchQueryStorageObjectRequest(List<String> fileIds) {
        p.i(fileIds, "fileIds");
        this.fileIds = fileIds;
    }
}
