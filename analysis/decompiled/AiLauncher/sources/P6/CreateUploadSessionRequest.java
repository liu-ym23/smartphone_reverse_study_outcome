package P6;

import P6.UploadBinding;
import Z8.C1173v;
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
import mb.C4931a;
import pb.C5094f;
import pb.C5101i0;
import pb.E0;
import pb.I0;
import pb.M;
import pb.T0;
import pb.X;
import pb.Y0;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0081\b\u0018\u0000 22\u00020\u0001:\u00023\u001aBO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000e\u0010\u000fBg\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u000e\u0010\u0013J'\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010\u001dR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010$\u001a\u0004\b&\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b'\u0010\u001dR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b(\u0010\u001dR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010,\u001a\u0004\b-\u0010.R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010/\u001a\u0004\b0\u00101¨\u00064"}, d2 = {"LP6/d;", "", "", "bizCode", "sourceType", "fileName", "contentType", "", "fileSize", "", "expiresSeconds", "", "LP6/k;", "bindings", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/util/List;)V", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/util/List;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(LP6/d;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getBizCode", "getSourceType", "getFileName", "getContentType", "Ljava/lang/Long;", "getFileSize", "()Ljava/lang/Long;", "Ljava/lang/Integer;", "getExpiresSeconds", "()Ljava/lang/Integer;", "Ljava/util/List;", "getBindings", "()Ljava/util/List;", "Companion", Const.INTENT_KEY_APIKEY, "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@lb.l
/* renamed from: P6.d, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class CreateUploadSessionRequest {
    private final List<UploadBinding> bindings;
    private final String bizCode;
    private final String contentType;
    private final Integer expiresSeconds;
    private final String fileName;
    private final Long fileSize;
    private final String sourceType;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, new C5094f(UploadBinding.a.INSTANCE)};

    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/stepos/common/utils/filestorage/models/CreateUploadSessionRequest.$serializer", "Lpb/M;", "LP6/d;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "c", "(Lkotlinx/serialization/encoding/Encoder;LP6/d;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", Const.INTENT_KEY_PKGNAME, "(Lkotlinx/serialization/encoding/Decoder;)LP6/d;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: P6.d$a */
    public /* synthetic */ class a implements M<CreateUploadSessionRequest> {
        public static final a INSTANCE;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            I0 i02 = new I0("com.stepos.common.utils.filestorage.models.CreateUploadSessionRequest", aVar, 7);
            i02.n("bizCode", false);
            i02.n("sourceType", false);
            i02.n("fileName", false);
            i02.n("contentType", false);
            i02.n("fileSize", true);
            i02.n("expiresSeconds", true);
            i02.n("bindings", true);
            descriptor = i02;
        }

        @Override // lb.InterfaceC4883a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CreateUploadSessionRequest deserialize(Decoder decoder) {
            int i10;
            List list;
            Integer num;
            String str;
            String str2;
            String str3;
            String str4;
            Long l10;
            p.i(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
            KSerializer[] kSerializerArr = CreateUploadSessionRequest.$childSerializers;
            String strDecodeStringElement = null;
            if (cVarBeginStructure.decodeSequentially()) {
                String strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
                String strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(serialDescriptor, 1);
                String strDecodeStringElement4 = cVarBeginStructure.decodeStringElement(serialDescriptor, 2);
                String strDecodeStringElement5 = cVarBeginStructure.decodeStringElement(serialDescriptor, 3);
                Long l11 = (Long) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, C5101i0.f38365a, null);
                Integer num2 = (Integer) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, X.f38325a, null);
                list = (List) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 6, kSerializerArr[6], null);
                str = strDecodeStringElement2;
                num = num2;
                str4 = strDecodeStringElement5;
                l10 = l11;
                str3 = strDecodeStringElement4;
                i10 = 127;
                str2 = strDecodeStringElement3;
            } else {
                boolean z10 = true;
                int i11 = 0;
                List list2 = null;
                Integer num3 = null;
                String strDecodeStringElement6 = null;
                String strDecodeStringElement7 = null;
                String strDecodeStringElement8 = null;
                Long l12 = null;
                while (z10) {
                    int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                    switch (iDecodeElementIndex) {
                        case -1:
                            z10 = false;
                            break;
                        case 0:
                            i11 |= 1;
                            strDecodeStringElement = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
                            continue;
                        case 1:
                            i11 |= 2;
                            strDecodeStringElement6 = cVarBeginStructure.decodeStringElement(serialDescriptor, 1);
                            continue;
                        case 2:
                            strDecodeStringElement7 = cVarBeginStructure.decodeStringElement(serialDescriptor, 2);
                            i11 |= 4;
                            continue;
                        case 3:
                            strDecodeStringElement8 = cVarBeginStructure.decodeStringElement(serialDescriptor, 3);
                            i11 |= 8;
                            break;
                        case 4:
                            l12 = (Long) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, C5101i0.f38365a, l12);
                            i11 |= 16;
                            break;
                        case 5:
                            num3 = (Integer) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, X.f38325a, num3);
                            i11 |= 32;
                            break;
                        case 6:
                            list2 = (List) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 6, kSerializerArr[6], list2);
                            i11 |= 64;
                            break;
                        default:
                            throw new UnknownFieldException(iDecodeElementIndex);
                    }
                }
                i10 = i11;
                list = list2;
                num = num3;
                str = strDecodeStringElement;
                str2 = strDecodeStringElement6;
                str3 = strDecodeStringElement7;
                str4 = strDecodeStringElement8;
                l10 = l12;
            }
            cVarBeginStructure.endStructure(serialDescriptor);
            return new CreateUploadSessionRequest(i10, str, str2, str3, str4, l10, num, list, null);
        }

        @Override // lb.m
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, CreateUploadSessionRequest value) {
            p.i(encoder, "encoder");
            p.i(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            ob.d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
            CreateUploadSessionRequest.b(value, dVarBeginStructure, serialDescriptor);
            dVarBeginStructure.endStructure(serialDescriptor);
        }

        @Override // pb.M
        public final KSerializer<?>[] childSerializers() {
            KSerializer<?>[] kSerializerArr = CreateUploadSessionRequest.$childSerializers;
            KSerializer<?> kSerializerT = C4931a.t(C5101i0.f38365a);
            KSerializer<?> kSerializerT2 = C4931a.t(X.f38325a);
            KSerializer<?> kSerializer = kSerializerArr[6];
            Y0 y02 = Y0.f38329a;
            return new KSerializer[]{y02, y02, y02, y02, kSerializerT, kSerializerT2, kSerializer};
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

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"LP6/d$b;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "LP6/d;", "serializer", "()Lkotlinx/serialization/KSerializer;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: P6.d$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<CreateUploadSessionRequest> serializer() {
            return a.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ CreateUploadSessionRequest(int i10, String str, String str2, String str3, String str4, Long l10, Integer num, List list, T0 t02) {
        if (15 != (i10 & 15)) {
            E0.a(i10, 15, a.INSTANCE.getDescriptor());
        }
        this.bizCode = str;
        this.sourceType = str2;
        this.fileName = str3;
        this.contentType = str4;
        if ((i10 & 16) == 0) {
            this.fileSize = null;
        } else {
            this.fileSize = l10;
        }
        if ((i10 & 32) == 0) {
            this.expiresSeconds = null;
        } else {
            this.expiresSeconds = num;
        }
        if ((i10 & 64) == 0) {
            this.bindings = C1173v.m();
        } else {
            this.bindings = list;
        }
    }

    public static final /* synthetic */ void b(CreateUploadSessionRequest self, ob.d output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.w(serialDesc, 0, self.bizCode);
        output.w(serialDesc, 1, self.sourceType);
        output.w(serialDesc, 2, self.fileName);
        output.w(serialDesc, 3, self.contentType);
        if (output.y(serialDesc, 4) || self.fileSize != null) {
            output.k(serialDesc, 4, C5101i0.f38365a, self.fileSize);
        }
        if (output.y(serialDesc, 5) || self.expiresSeconds != null) {
            output.k(serialDesc, 5, X.f38325a, self.expiresSeconds);
        }
        if (!output.y(serialDesc, 6) && p.d(self.bindings, C1173v.m())) {
            return;
        }
        output.x(serialDesc, 6, kSerializerArr[6], self.bindings);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateUploadSessionRequest)) {
            return false;
        }
        CreateUploadSessionRequest createUploadSessionRequest = (CreateUploadSessionRequest) other;
        return p.d(this.bizCode, createUploadSessionRequest.bizCode) && p.d(this.sourceType, createUploadSessionRequest.sourceType) && p.d(this.fileName, createUploadSessionRequest.fileName) && p.d(this.contentType, createUploadSessionRequest.contentType) && p.d(this.fileSize, createUploadSessionRequest.fileSize) && p.d(this.expiresSeconds, createUploadSessionRequest.expiresSeconds) && p.d(this.bindings, createUploadSessionRequest.bindings);
    }

    public int hashCode() {
        int iHashCode = ((((((this.bizCode.hashCode() * 31) + this.sourceType.hashCode()) * 31) + this.fileName.hashCode()) * 31) + this.contentType.hashCode()) * 31;
        Long l10 = this.fileSize;
        int iHashCode2 = (iHashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
        Integer num = this.expiresSeconds;
        return ((iHashCode2 + (num != null ? num.hashCode() : 0)) * 31) + this.bindings.hashCode();
    }

    public String toString() {
        return "CreateUploadSessionRequest(bizCode=" + this.bizCode + ", sourceType=" + this.sourceType + ", fileName=" + this.fileName + ", contentType=" + this.contentType + ", fileSize=" + this.fileSize + ", expiresSeconds=" + this.expiresSeconds + ", bindings=" + this.bindings + ")";
    }

    public CreateUploadSessionRequest(String bizCode, String sourceType, String fileName, String contentType, Long l10, Integer num, List<UploadBinding> bindings) {
        p.i(bizCode, "bizCode");
        p.i(sourceType, "sourceType");
        p.i(fileName, "fileName");
        p.i(contentType, "contentType");
        p.i(bindings, "bindings");
        this.bizCode = bizCode;
        this.sourceType = sourceType;
        this.fileName = fileName;
        this.contentType = contentType;
        this.fileSize = l10;
        this.expiresSeconds = num;
        this.bindings = bindings;
    }
}
