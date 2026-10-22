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
import pb.C5101i0;
import pb.E0;
import pb.I0;
import pb.M;
import pb.T0;
import pb.Y0;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002\" BK\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b!\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b\"\u0010\u0018R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\n\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b&\u0010\u0018¨\u0006("}, d2 = {"LP6/g;", "", "", "seen0", "", "downloadModel", "downloadUrl", "contentType", "", "fileSize", "expiresAt", "Lpb/T0;", "serializationConstructorMarker", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "e", "(LP6/g;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_APIKEY, "J", "getFileSize", "()J", Const.INTENT_KEY_UMID, "Companion", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@lb.l
/* renamed from: P6.g, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class DownloadUrlResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String contentType;
    private final String downloadModel;
    private final String downloadUrl;
    private final String expiresAt;
    private final long fileSize;

    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/stepos/common/utils/filestorage/models/DownloadUrlResponse.$serializer", "Lpb/M;", "LP6/g;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "c", "(Lkotlinx/serialization/encoding/Encoder;LP6/g;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", Const.INTENT_KEY_PKGNAME, "(Lkotlinx/serialization/encoding/Decoder;)LP6/g;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: P6.g$a */
    public /* synthetic */ class a implements M<DownloadUrlResponse> {
        public static final a INSTANCE;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            I0 i02 = new I0("com.stepos.common.utils.filestorage.models.DownloadUrlResponse", aVar, 5);
            i02.n("downloadModel", false);
            i02.n("downloadUrl", false);
            i02.n("contentType", false);
            i02.n("fileSize", false);
            i02.n("expiresAt", false);
            descriptor = i02;
        }

        @Override // lb.InterfaceC4883a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final DownloadUrlResponse deserialize(Decoder decoder) {
            String strDecodeStringElement;
            String strDecodeStringElement2;
            int i10;
            String str;
            String str2;
            long j10;
            p.i(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
            if (cVarBeginStructure.decodeSequentially()) {
                strDecodeStringElement = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
                String strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(serialDescriptor, 1);
                String strDecodeStringElement4 = cVarBeginStructure.decodeStringElement(serialDescriptor, 2);
                long jDecodeLongElement = cVarBeginStructure.decodeLongElement(serialDescriptor, 3);
                strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(serialDescriptor, 4);
                i10 = 31;
                str = strDecodeStringElement4;
                str2 = strDecodeStringElement3;
                j10 = jDecodeLongElement;
            } else {
                strDecodeStringElement = null;
                String strDecodeStringElement5 = null;
                String strDecodeStringElement6 = null;
                boolean z10 = true;
                long jDecodeLongElement2 = 0;
                String strDecodeStringElement7 = null;
                int i11 = 0;
                while (z10) {
                    int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z10 = false;
                    } else if (iDecodeElementIndex == 0) {
                        strDecodeStringElement = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i11 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        strDecodeStringElement6 = cVarBeginStructure.decodeStringElement(serialDescriptor, 1);
                        i11 |= 2;
                    } else if (iDecodeElementIndex == 2) {
                        strDecodeStringElement5 = cVarBeginStructure.decodeStringElement(serialDescriptor, 2);
                        i11 |= 4;
                    } else if (iDecodeElementIndex == 3) {
                        jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(serialDescriptor, 3);
                        i11 |= 8;
                    } else {
                        if (iDecodeElementIndex != 4) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        strDecodeStringElement7 = cVarBeginStructure.decodeStringElement(serialDescriptor, 4);
                        i11 |= 16;
                    }
                }
                strDecodeStringElement2 = strDecodeStringElement7;
                i10 = i11;
                str = strDecodeStringElement5;
                str2 = strDecodeStringElement6;
                j10 = jDecodeLongElement2;
            }
            String str3 = strDecodeStringElement;
            cVarBeginStructure.endStructure(serialDescriptor);
            return new DownloadUrlResponse(i10, str3, str2, str, j10, strDecodeStringElement2, null);
        }

        @Override // lb.m
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, DownloadUrlResponse value) {
            p.i(encoder, "encoder");
            p.i(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            ob.d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
            DownloadUrlResponse.e(value, dVarBeginStructure, serialDescriptor);
            dVarBeginStructure.endStructure(serialDescriptor);
        }

        @Override // pb.M
        public final KSerializer<?>[] childSerializers() {
            Y0 y02 = Y0.f38329a;
            return new KSerializer[]{y02, y02, y02, C5101i0.f38365a, y02};
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

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"LP6/g$b;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "LP6/g;", "serializer", "()Lkotlinx/serialization/KSerializer;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: P6.g$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<DownloadUrlResponse> serializer() {
            return a.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ DownloadUrlResponse(int i10, String str, String str2, String str3, long j10, String str4, T0 t02) {
        if (31 != (i10 & 31)) {
            E0.a(i10, 31, a.INSTANCE.getDescriptor());
        }
        this.downloadModel = str;
        this.downloadUrl = str2;
        this.contentType = str3;
        this.fileSize = j10;
        this.expiresAt = str4;
    }

    public static final /* synthetic */ void e(DownloadUrlResponse self, ob.d output, SerialDescriptor serialDesc) {
        output.w(serialDesc, 0, self.downloadModel);
        output.w(serialDesc, 1, self.downloadUrl);
        output.w(serialDesc, 2, self.contentType);
        output.C(serialDesc, 3, self.fileSize);
        output.w(serialDesc, 4, self.expiresAt);
    }

    /* renamed from: a, reason: from getter */
    public final String getContentType() {
        return this.contentType;
    }

    /* renamed from: b, reason: from getter */
    public final String getDownloadModel() {
        return this.downloadModel;
    }

    /* renamed from: c, reason: from getter */
    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    /* renamed from: d, reason: from getter */
    public final String getExpiresAt() {
        return this.expiresAt;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadUrlResponse)) {
            return false;
        }
        DownloadUrlResponse downloadUrlResponse = (DownloadUrlResponse) other;
        return p.d(this.downloadModel, downloadUrlResponse.downloadModel) && p.d(this.downloadUrl, downloadUrlResponse.downloadUrl) && p.d(this.contentType, downloadUrlResponse.contentType) && this.fileSize == downloadUrlResponse.fileSize && p.d(this.expiresAt, downloadUrlResponse.expiresAt);
    }

    public int hashCode() {
        return (((((((this.downloadModel.hashCode() * 31) + this.downloadUrl.hashCode()) * 31) + this.contentType.hashCode()) * 31) + Long.hashCode(this.fileSize)) * 31) + this.expiresAt.hashCode();
    }

    public String toString() {
        return "DownloadUrlResponse(downloadModel=" + this.downloadModel + ", downloadUrl=" + this.downloadUrl + ", contentType=" + this.contentType + ", fileSize=" + this.fileSize + ", expiresAt=" + this.expiresAt + ")";
    }
}
