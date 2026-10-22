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
import pb.C5100i;
import pb.C5101i0;
import pb.E0;
import pb.I0;
import pb.M;
import pb.T0;
import pb.Y0;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\b\u0087\b\u0018\u0000 C2\u00020\u0001:\u0002D>B¿\u0001\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010#\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b'\u0010(J\u001a\u0010*\u001a\u00020\u00142\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b*\u0010+R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010,\u001a\u0004\b-\u0010&R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010,\u001a\u0004\b.\u0010&R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010,\u001a\u0004\b/\u0010&R\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010,\u001a\u0004\b0\u0010&R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010,\u001a\u0004\b1\u0010&R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u00102\u001a\u0004\b3\u00104R\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010,\u001a\u0004\b5\u0010&R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010,\u001a\u0004\b6\u0010&R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010,\u001a\u0004\b7\u0010&R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010,\u001a\u0004\b8\u0010&R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010,\u001a\u0004\b9\u0010&R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010,\u001a\u0004\b:\u0010&R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010,\u001a\u0004\b;\u0010&R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010,\u001a\u0004\b<\u0010&R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010=\u001a\u0004\b>\u0010?R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006¢\u0006\f\n\u0004\b\u0018\u0010@\u001a\u0004\bA\u0010B¨\u0006E"}, d2 = {"LP6/i;", "", "", "seen0", "", "fileId", "bizCode", "sourceType", "fileName", "contentType", "", "fileSize", "status", "auditStatus", "auditDecision", "auditRiskLevel", "auditSuggestText", "sensitiveStatus", "sensitiveDecision", "sensitiveLevel", "", "detectPassed", "", "LP6/k;", "bindings", "Lpb/T0;", "serializationConstructorMarker", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "e", "(LP6/i;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", "getBizCode", "getSourceType", "getFileName", "getContentType", "J", "getFileSize", "()J", Const.INTENT_KEY_UMID, "getAuditStatus", "getAuditDecision", "getAuditRiskLevel", "getAuditSuggestText", "getSensitiveStatus", "getSensitiveDecision", "getSensitiveLevel", "Ljava/lang/Boolean;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/Boolean;", "Ljava/util/List;", "getBindings", "()Ljava/util/List;", "Companion", Const.INTENT_KEY_APIKEY, "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@lb.l
/* renamed from: P6.i, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class StorageObjectDetail {
    private final String auditDecision;
    private final String auditRiskLevel;
    private final String auditStatus;
    private final String auditSuggestText;
    private final List<UploadBinding> bindings;
    private final String bizCode;
    private final String contentType;
    private final Boolean detectPassed;
    private final String fileId;
    private final String fileName;
    private final long fileSize;
    private final String sensitiveDecision;
    private final String sensitiveLevel;
    private final String sensitiveStatus;
    private final String sourceType;
    private final String status;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new C5094f(UploadBinding.a.INSTANCE)};

    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/stepos/common/utils/filestorage/models/StorageObjectDetail.$serializer", "Lpb/M;", "LP6/i;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "c", "(Lkotlinx/serialization/encoding/Encoder;LP6/i;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", Const.INTENT_KEY_PKGNAME, "(Lkotlinx/serialization/encoding/Decoder;)LP6/i;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: P6.i$a */
    public /* synthetic */ class a implements M<StorageObjectDetail> {
        public static final a INSTANCE;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            I0 i02 = new I0("com.stepos.common.utils.filestorage.models.StorageObjectDetail", aVar, 16);
            i02.n("fileId", false);
            i02.n("bizCode", false);
            i02.n("sourceType", false);
            i02.n("fileName", false);
            i02.n("contentType", false);
            i02.n("fileSize", false);
            i02.n("status", false);
            i02.n("auditStatus", true);
            i02.n("auditDecision", true);
            i02.n("auditRiskLevel", true);
            i02.n("auditSuggestText", true);
            i02.n("sensitiveStatus", true);
            i02.n("sensitiveDecision", true);
            i02.n("sensitiveLevel", true);
            i02.n("detectPassed", true);
            i02.n("bindings", true);
            descriptor = i02;
        }

        @Override // lb.InterfaceC4883a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final StorageObjectDetail deserialize(Decoder decoder) {
            String str;
            int i10;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            Boolean bool;
            String str7;
            String str8;
            String str9;
            List list;
            String str10;
            String str11;
            String str12;
            String str13;
            long j10;
            p.i(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
            KSerializer[] kSerializerArr = StorageObjectDetail.$childSerializers;
            char c10 = '\n';
            if (cVarBeginStructure.decodeSequentially()) {
                String strDecodeStringElement = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
                String strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(serialDescriptor, 1);
                String strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(serialDescriptor, 2);
                String strDecodeStringElement4 = cVarBeginStructure.decodeStringElement(serialDescriptor, 3);
                String strDecodeStringElement5 = cVarBeginStructure.decodeStringElement(serialDescriptor, 4);
                long jDecodeLongElement = cVarBeginStructure.decodeLongElement(serialDescriptor, 5);
                String strDecodeStringElement6 = cVarBeginStructure.decodeStringElement(serialDescriptor, 6);
                Y0 y02 = Y0.f38329a;
                String str14 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, y02, null);
                String str15 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, y02, null);
                String str16 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, y02, null);
                String str17 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, y02, null);
                str = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, y02, null);
                String str18 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, y02, null);
                String str19 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 13, y02, null);
                i10 = 65535;
                bool = (Boolean) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 14, C5100i.f38363a, null);
                str7 = str19;
                list = (List) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 15, kSerializerArr[15], null);
                str2 = strDecodeStringElement;
                str10 = strDecodeStringElement3;
                str3 = strDecodeStringElement2;
                str11 = strDecodeStringElement4;
                str9 = str17;
                str4 = str16;
                str6 = str14;
                str13 = strDecodeStringElement6;
                str12 = strDecodeStringElement5;
                str5 = str15;
                str8 = str18;
                j10 = jDecodeLongElement;
            } else {
                long jDecodeLongElement2 = 0;
                boolean z10 = true;
                String strDecodeStringElement7 = null;
                String strDecodeStringElement8 = null;
                String str20 = null;
                String str21 = null;
                Boolean bool2 = null;
                String str22 = null;
                String str23 = null;
                String str24 = null;
                List list2 = null;
                str = null;
                String strDecodeStringElement9 = null;
                String strDecodeStringElement10 = null;
                String strDecodeStringElement11 = null;
                String strDecodeStringElement12 = null;
                i10 = 0;
                String str25 = null;
                while (z10) {
                    int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                    switch (iDecodeElementIndex) {
                        case -1:
                            z10 = false;
                        case 0:
                            i10 |= 1;
                            strDecodeStringElement7 = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
                            c10 = '\n';
                        case 1:
                            i10 |= 2;
                            strDecodeStringElement8 = cVarBeginStructure.decodeStringElement(serialDescriptor, 1);
                            c10 = '\n';
                        case 2:
                            strDecodeStringElement9 = cVarBeginStructure.decodeStringElement(serialDescriptor, 2);
                            i10 |= 4;
                            c10 = '\n';
                        case 3:
                            strDecodeStringElement10 = cVarBeginStructure.decodeStringElement(serialDescriptor, 3);
                            i10 |= 8;
                            c10 = '\n';
                        case 4:
                            strDecodeStringElement11 = cVarBeginStructure.decodeStringElement(serialDescriptor, 4);
                            i10 |= 16;
                            c10 = '\n';
                        case 5:
                            jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(serialDescriptor, 5);
                            i10 |= 32;
                            c10 = '\n';
                        case 6:
                            strDecodeStringElement12 = cVarBeginStructure.decodeStringElement(serialDescriptor, 6);
                            i10 |= 64;
                            c10 = '\n';
                        case 7:
                            str25 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, Y0.f38329a, str25);
                            i10 |= 128;
                            c10 = '\n';
                        case 8:
                            str21 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, Y0.f38329a, str21);
                            i10 |= 256;
                            c10 = '\n';
                        case 9:
                            str20 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, Y0.f38329a, str20);
                            i10 |= 512;
                            c10 = '\n';
                        case 10:
                            str24 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, Y0.f38329a, str24);
                            i10 |= 1024;
                            c10 = '\n';
                        case 11:
                            str = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, Y0.f38329a, str);
                            i10 |= 2048;
                            c10 = '\n';
                        case 12:
                            str23 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, Y0.f38329a, str23);
                            i10 |= 4096;
                            c10 = '\n';
                        case 13:
                            str22 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 13, Y0.f38329a, str22);
                            i10 |= com.stepos.agentframework.chatui.longtext.b.THRESHOLD;
                            c10 = '\n';
                        case 14:
                            bool2 = (Boolean) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 14, C5100i.f38363a, bool2);
                            i10 |= 16384;
                            c10 = '\n';
                        case 15:
                            list2 = (List) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 15, kSerializerArr[15], list2);
                            i10 |= 32768;
                            c10 = '\n';
                        default:
                            throw new UnknownFieldException(iDecodeElementIndex);
                    }
                }
                str2 = strDecodeStringElement7;
                str3 = strDecodeStringElement8;
                str4 = str20;
                str5 = str21;
                str6 = str25;
                bool = bool2;
                str7 = str22;
                str8 = str23;
                str9 = str24;
                list = list2;
                str10 = strDecodeStringElement9;
                str11 = strDecodeStringElement10;
                str12 = strDecodeStringElement11;
                str13 = strDecodeStringElement12;
                j10 = jDecodeLongElement2;
            }
            int i11 = i10;
            String str26 = str;
            cVarBeginStructure.endStructure(serialDescriptor);
            return new StorageObjectDetail(i11, str2, str3, str10, str11, str12, j10, str13, str6, str5, str4, str9, str26, str8, str7, bool, list, null);
        }

        @Override // lb.m
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, StorageObjectDetail value) {
            p.i(encoder, "encoder");
            p.i(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            ob.d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
            StorageObjectDetail.e(value, dVarBeginStructure, serialDescriptor);
            dVarBeginStructure.endStructure(serialDescriptor);
        }

        @Override // pb.M
        public final KSerializer<?>[] childSerializers() {
            KSerializer<?>[] kSerializerArr = StorageObjectDetail.$childSerializers;
            Y0 y02 = Y0.f38329a;
            return new KSerializer[]{y02, y02, y02, y02, y02, C5101i0.f38365a, y02, C4931a.t(y02), C4931a.t(y02), C4931a.t(y02), C4931a.t(y02), C4931a.t(y02), C4931a.t(y02), C4931a.t(y02), C4931a.t(C5100i.f38363a), kSerializerArr[15]};
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

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"LP6/i$b;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "LP6/i;", "serializer", "()Lkotlinx/serialization/KSerializer;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: P6.i$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<StorageObjectDetail> serializer() {
            return a.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ StorageObjectDetail(int i10, String str, String str2, String str3, String str4, String str5, long j10, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Boolean bool, List list, T0 t02) {
        if (127 != (i10 & 127)) {
            E0.a(i10, 127, a.INSTANCE.getDescriptor());
        }
        this.fileId = str;
        this.bizCode = str2;
        this.sourceType = str3;
        this.fileName = str4;
        this.contentType = str5;
        this.fileSize = j10;
        this.status = str6;
        if ((i10 & 128) == 0) {
            this.auditStatus = null;
        } else {
            this.auditStatus = str7;
        }
        if ((i10 & 256) == 0) {
            this.auditDecision = null;
        } else {
            this.auditDecision = str8;
        }
        if ((i10 & 512) == 0) {
            this.auditRiskLevel = null;
        } else {
            this.auditRiskLevel = str9;
        }
        if ((i10 & 1024) == 0) {
            this.auditSuggestText = null;
        } else {
            this.auditSuggestText = str10;
        }
        if ((i10 & 2048) == 0) {
            this.sensitiveStatus = null;
        } else {
            this.sensitiveStatus = str11;
        }
        if ((i10 & 4096) == 0) {
            this.sensitiveDecision = null;
        } else {
            this.sensitiveDecision = str12;
        }
        if ((i10 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) == 0) {
            this.sensitiveLevel = null;
        } else {
            this.sensitiveLevel = str13;
        }
        if ((i10 & 16384) == 0) {
            this.detectPassed = null;
        } else {
            this.detectPassed = bool;
        }
        this.bindings = (i10 & 32768) == 0 ? C1173v.m() : list;
    }

    public static final /* synthetic */ void e(StorageObjectDetail self, ob.d output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.w(serialDesc, 0, self.fileId);
        output.w(serialDesc, 1, self.bizCode);
        output.w(serialDesc, 2, self.sourceType);
        output.w(serialDesc, 3, self.fileName);
        output.w(serialDesc, 4, self.contentType);
        output.C(serialDesc, 5, self.fileSize);
        output.w(serialDesc, 6, self.status);
        if (output.y(serialDesc, 7) || self.auditStatus != null) {
            output.k(serialDesc, 7, Y0.f38329a, self.auditStatus);
        }
        if (output.y(serialDesc, 8) || self.auditDecision != null) {
            output.k(serialDesc, 8, Y0.f38329a, self.auditDecision);
        }
        if (output.y(serialDesc, 9) || self.auditRiskLevel != null) {
            output.k(serialDesc, 9, Y0.f38329a, self.auditRiskLevel);
        }
        if (output.y(serialDesc, 10) || self.auditSuggestText != null) {
            output.k(serialDesc, 10, Y0.f38329a, self.auditSuggestText);
        }
        if (output.y(serialDesc, 11) || self.sensitiveStatus != null) {
            output.k(serialDesc, 11, Y0.f38329a, self.sensitiveStatus);
        }
        if (output.y(serialDesc, 12) || self.sensitiveDecision != null) {
            output.k(serialDesc, 12, Y0.f38329a, self.sensitiveDecision);
        }
        if (output.y(serialDesc, 13) || self.sensitiveLevel != null) {
            output.k(serialDesc, 13, Y0.f38329a, self.sensitiveLevel);
        }
        if (output.y(serialDesc, 14) || self.detectPassed != null) {
            output.k(serialDesc, 14, C5100i.f38363a, self.detectPassed);
        }
        if (!output.y(serialDesc, 15) && p.d(self.bindings, C1173v.m())) {
            return;
        }
        output.x(serialDesc, 15, kSerializerArr[15], self.bindings);
    }

    /* renamed from: b, reason: from getter */
    public final Boolean getDetectPassed() {
        return this.detectPassed;
    }

    /* renamed from: c, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    /* renamed from: d, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StorageObjectDetail)) {
            return false;
        }
        StorageObjectDetail storageObjectDetail = (StorageObjectDetail) other;
        return p.d(this.fileId, storageObjectDetail.fileId) && p.d(this.bizCode, storageObjectDetail.bizCode) && p.d(this.sourceType, storageObjectDetail.sourceType) && p.d(this.fileName, storageObjectDetail.fileName) && p.d(this.contentType, storageObjectDetail.contentType) && this.fileSize == storageObjectDetail.fileSize && p.d(this.status, storageObjectDetail.status) && p.d(this.auditStatus, storageObjectDetail.auditStatus) && p.d(this.auditDecision, storageObjectDetail.auditDecision) && p.d(this.auditRiskLevel, storageObjectDetail.auditRiskLevel) && p.d(this.auditSuggestText, storageObjectDetail.auditSuggestText) && p.d(this.sensitiveStatus, storageObjectDetail.sensitiveStatus) && p.d(this.sensitiveDecision, storageObjectDetail.sensitiveDecision) && p.d(this.sensitiveLevel, storageObjectDetail.sensitiveLevel) && p.d(this.detectPassed, storageObjectDetail.detectPassed) && p.d(this.bindings, storageObjectDetail.bindings);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((this.fileId.hashCode() * 31) + this.bizCode.hashCode()) * 31) + this.sourceType.hashCode()) * 31) + this.fileName.hashCode()) * 31) + this.contentType.hashCode()) * 31) + Long.hashCode(this.fileSize)) * 31) + this.status.hashCode()) * 31;
        String str = this.auditStatus;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.auditDecision;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.auditRiskLevel;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.auditSuggestText;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.sensitiveStatus;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.sensitiveDecision;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.sensitiveLevel;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Boolean bool = this.detectPassed;
        return ((iHashCode8 + (bool != null ? bool.hashCode() : 0)) * 31) + this.bindings.hashCode();
    }

    public String toString() {
        return "StorageObjectDetail(fileId=" + this.fileId + ", bizCode=" + this.bizCode + ", sourceType=" + this.sourceType + ", fileName=" + this.fileName + ", contentType=" + this.contentType + ", fileSize=" + this.fileSize + ", status=" + this.status + ", auditStatus=" + this.auditStatus + ", auditDecision=" + this.auditDecision + ", auditRiskLevel=" + this.auditRiskLevel + ", auditSuggestText=" + this.auditSuggestText + ", sensitiveStatus=" + this.sensitiveStatus + ", sensitiveDecision=" + this.sensitiveDecision + ", sensitiveLevel=" + this.sensitiveLevel + ", detectPassed=" + this.detectPassed + ", bindings=" + this.bindings + ")";
    }
}
