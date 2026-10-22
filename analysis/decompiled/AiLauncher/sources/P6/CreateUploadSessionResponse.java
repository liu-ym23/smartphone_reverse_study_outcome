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
import pb.E0;
import pb.I0;
import pb.M;
import pb.T0;
import pb.Y0;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002\u001f\u001dB9\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001e\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001f\u0010\u0015¨\u0006!"}, d2 = {"LP6/e;", "", "", "seen0", "", "fileId", "uploadUrl", "expiresAt", "Lpb/T0;", "serializationConstructorMarker", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", Const.INTENT_KEY_UMID, "(LP6/e;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_APIKEY, "Companion", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@lb.l
/* renamed from: P6.e, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class CreateUploadSessionResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String expiresAt;
    private final String fileId;
    private final String uploadUrl;

    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/stepos/common/utils/filestorage/models/CreateUploadSessionResponse.$serializer", "Lpb/M;", "LP6/e;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "c", "(Lkotlinx/serialization/encoding/Encoder;LP6/e;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", Const.INTENT_KEY_PKGNAME, "(Lkotlinx/serialization/encoding/Decoder;)LP6/e;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: P6.e$a */
    public /* synthetic */ class a implements M<CreateUploadSessionResponse> {
        public static final a INSTANCE;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            I0 i02 = new I0("com.stepos.common.utils.filestorage.models.CreateUploadSessionResponse", aVar, 3);
            i02.n("fileId", false);
            i02.n("uploadUrl", false);
            i02.n("expiresAt", false);
            descriptor = i02;
        }

        @Override // lb.InterfaceC4883a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CreateUploadSessionResponse deserialize(Decoder decoder) {
            String strDecodeStringElement;
            String strDecodeStringElement2;
            String str;
            int i10;
            p.i(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
            if (cVarBeginStructure.decodeSequentially()) {
                strDecodeStringElement = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
                String strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(serialDescriptor, 1);
                strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(serialDescriptor, 2);
                str = strDecodeStringElement3;
                i10 = 7;
            } else {
                strDecodeStringElement = null;
                String strDecodeStringElement4 = null;
                String strDecodeStringElement5 = null;
                boolean z10 = true;
                int i11 = 0;
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
                    } else {
                        if (iDecodeElementIndex != 2) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        strDecodeStringElement4 = cVarBeginStructure.decodeStringElement(serialDescriptor, 2);
                        i11 |= 4;
                    }
                }
                strDecodeStringElement2 = strDecodeStringElement4;
                str = strDecodeStringElement5;
                i10 = i11;
            }
            String str2 = strDecodeStringElement;
            cVarBeginStructure.endStructure(serialDescriptor);
            return new CreateUploadSessionResponse(i10, str2, str, strDecodeStringElement2, null);
        }

        @Override // lb.m
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, CreateUploadSessionResponse value) {
            p.i(encoder, "encoder");
            p.i(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            ob.d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
            CreateUploadSessionResponse.d(value, dVarBeginStructure, serialDescriptor);
            dVarBeginStructure.endStructure(serialDescriptor);
        }

        @Override // pb.M
        public final KSerializer<?>[] childSerializers() {
            Y0 y02 = Y0.f38329a;
            return new KSerializer[]{y02, y02, y02};
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

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"LP6/e$b;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "LP6/e;", "serializer", "()Lkotlinx/serialization/KSerializer;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: P6.e$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<CreateUploadSessionResponse> serializer() {
            return a.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ CreateUploadSessionResponse(int i10, String str, String str2, String str3, T0 t02) {
        if (7 != (i10 & 7)) {
            E0.a(i10, 7, a.INSTANCE.getDescriptor());
        }
        this.fileId = str;
        this.uploadUrl = str2;
        this.expiresAt = str3;
    }

    public static final /* synthetic */ void d(CreateUploadSessionResponse self, ob.d output, SerialDescriptor serialDesc) {
        output.w(serialDesc, 0, self.fileId);
        output.w(serialDesc, 1, self.uploadUrl);
        output.w(serialDesc, 2, self.expiresAt);
    }

    /* renamed from: a, reason: from getter */
    public final String getExpiresAt() {
        return this.expiresAt;
    }

    /* renamed from: b, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    /* renamed from: c, reason: from getter */
    public final String getUploadUrl() {
        return this.uploadUrl;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateUploadSessionResponse)) {
            return false;
        }
        CreateUploadSessionResponse createUploadSessionResponse = (CreateUploadSessionResponse) other;
        return p.d(this.fileId, createUploadSessionResponse.fileId) && p.d(this.uploadUrl, createUploadSessionResponse.uploadUrl) && p.d(this.expiresAt, createUploadSessionResponse.expiresAt);
    }

    public int hashCode() {
        return (((this.fileId.hashCode() * 31) + this.uploadUrl.hashCode()) * 31) + this.expiresAt.hashCode();
    }

    public String toString() {
        return "CreateUploadSessionResponse(fileId=" + this.fileId + ", uploadUrl=" + this.uploadUrl + ", expiresAt=" + this.expiresAt + ")";
    }
}
