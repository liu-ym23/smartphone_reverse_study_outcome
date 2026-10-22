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
import pb.X;
import pb.Y0;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002\u001f#BC\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001f\u0010\u0016R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b#\u0010\u0016¨\u0006%"}, d2 = {"LP6/f;", "", "", "seen0", "", "previewUrl", "dstType", "page", "expiresAt", "Lpb/T0;", "serializationConstructorMarker", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "e", "(LP6/f;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", Const.INTENT_KEY_PKGNAME, "Companion", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@lb.l
/* renamed from: P6.f, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class DocumentPreviewResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String dstType;
    private final String expiresAt;
    private final Integer page;
    private final String previewUrl;

    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/stepos/common/utils/filestorage/models/DocumentPreviewResponse.$serializer", "Lpb/M;", "LP6/f;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "c", "(Lkotlinx/serialization/encoding/Encoder;LP6/f;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", Const.INTENT_KEY_PKGNAME, "(Lkotlinx/serialization/encoding/Decoder;)LP6/f;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: P6.f$a */
    public /* synthetic */ class a implements M<DocumentPreviewResponse> {
        public static final a INSTANCE;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            I0 i02 = new I0("com.stepos.common.utils.filestorage.models.DocumentPreviewResponse", aVar, 4);
            i02.n("previewUrl", false);
            i02.n("dstType", false);
            i02.n("page", true);
            i02.n("expiresAt", false);
            descriptor = i02;
        }

        @Override // lb.InterfaceC4883a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final DocumentPreviewResponse deserialize(Decoder decoder) {
            int i10;
            String str;
            String str2;
            Integer num;
            String strDecodeStringElement;
            p.i(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
            String strDecodeStringElement2 = null;
            if (cVarBeginStructure.decodeSequentially()) {
                String strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
                String strDecodeStringElement4 = cVarBeginStructure.decodeStringElement(serialDescriptor, 1);
                Integer num2 = (Integer) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, X.f38325a, null);
                str = strDecodeStringElement3;
                strDecodeStringElement = cVarBeginStructure.decodeStringElement(serialDescriptor, 3);
                num = num2;
                str2 = strDecodeStringElement4;
                i10 = 15;
            } else {
                boolean z10 = true;
                int i11 = 0;
                String strDecodeStringElement5 = null;
                Integer num3 = null;
                String strDecodeStringElement6 = null;
                while (z10) {
                    int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z10 = false;
                    } else if (iDecodeElementIndex == 0) {
                        strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i11 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        strDecodeStringElement5 = cVarBeginStructure.decodeStringElement(serialDescriptor, 1);
                        i11 |= 2;
                    } else if (iDecodeElementIndex == 2) {
                        num3 = (Integer) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, X.f38325a, num3);
                        i11 |= 4;
                    } else {
                        if (iDecodeElementIndex != 3) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        strDecodeStringElement6 = cVarBeginStructure.decodeStringElement(serialDescriptor, 3);
                        i11 |= 8;
                    }
                }
                i10 = i11;
                str = strDecodeStringElement2;
                str2 = strDecodeStringElement5;
                num = num3;
                strDecodeStringElement = strDecodeStringElement6;
            }
            cVarBeginStructure.endStructure(serialDescriptor);
            return new DocumentPreviewResponse(i10, str, str2, num, strDecodeStringElement, null);
        }

        @Override // lb.m
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, DocumentPreviewResponse value) {
            p.i(encoder, "encoder");
            p.i(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            ob.d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
            DocumentPreviewResponse.e(value, dVarBeginStructure, serialDescriptor);
            dVarBeginStructure.endStructure(serialDescriptor);
        }

        @Override // pb.M
        public final KSerializer<?>[] childSerializers() {
            KSerializer<?> kSerializerT = C4931a.t(X.f38325a);
            Y0 y02 = Y0.f38329a;
            return new KSerializer[]{y02, y02, kSerializerT, y02};
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

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"LP6/f$b;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "LP6/f;", "serializer", "()Lkotlinx/serialization/KSerializer;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: P6.f$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<DocumentPreviewResponse> serializer() {
            return a.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ DocumentPreviewResponse(int i10, String str, String str2, Integer num, String str3, T0 t02) {
        if (11 != (i10 & 11)) {
            E0.a(i10, 11, a.INSTANCE.getDescriptor());
        }
        this.previewUrl = str;
        this.dstType = str2;
        if ((i10 & 4) == 0) {
            this.page = null;
        } else {
            this.page = num;
        }
        this.expiresAt = str3;
    }

    public static final /* synthetic */ void e(DocumentPreviewResponse self, ob.d output, SerialDescriptor serialDesc) {
        output.w(serialDesc, 0, self.previewUrl);
        output.w(serialDesc, 1, self.dstType);
        if (output.y(serialDesc, 2) || self.page != null) {
            output.k(serialDesc, 2, X.f38325a, self.page);
        }
        output.w(serialDesc, 3, self.expiresAt);
    }

    /* renamed from: a, reason: from getter */
    public final String getDstType() {
        return this.dstType;
    }

    /* renamed from: b, reason: from getter */
    public final String getExpiresAt() {
        return this.expiresAt;
    }

    /* renamed from: c, reason: from getter */
    public final Integer getPage() {
        return this.page;
    }

    /* renamed from: d, reason: from getter */
    public final String getPreviewUrl() {
        return this.previewUrl;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentPreviewResponse)) {
            return false;
        }
        DocumentPreviewResponse documentPreviewResponse = (DocumentPreviewResponse) other;
        return p.d(this.previewUrl, documentPreviewResponse.previewUrl) && p.d(this.dstType, documentPreviewResponse.dstType) && p.d(this.page, documentPreviewResponse.page) && p.d(this.expiresAt, documentPreviewResponse.expiresAt);
    }

    public int hashCode() {
        int iHashCode = ((this.previewUrl.hashCode() * 31) + this.dstType.hashCode()) * 31;
        Integer num = this.page;
        return ((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.expiresAt.hashCode();
    }

    public String toString() {
        return "DocumentPreviewResponse(previewUrl=" + this.previewUrl + ", dstType=" + this.dstType + ", page=" + this.page + ", expiresAt=" + this.expiresAt + ")";
    }
}
