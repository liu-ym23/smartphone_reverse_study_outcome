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
import pb.C5100i;
import pb.C5101i0;
import pb.E0;
import pb.I0;
import pb.M;
import pb.T0;
import pb.Y0;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \b\u0081\b\u0018\u0000 >2\u00020\u0001:\u000256B«\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014B§\u0001\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0013\u0010\u0019J'\u0010 \u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010'\u001a\u00020\u00112\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(R \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010)\u0012\u0004\b+\u0010,\u001a\u0004\b*\u0010#R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010)\u001a\u0004\b-\u0010#R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010.\u001a\u0004\b/\u00100R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010)\u001a\u0004\b1\u0010#R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010)\u001a\u0004\b2\u0010#R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010)\u001a\u0004\b3\u0010#R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010)\u001a\u0004\b4\u0010#R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010)\u001a\u0004\b5\u0010#R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010)\u001a\u0004\b6\u0010#R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010)\u001a\u0004\b7\u0010#R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010)\u001a\u0004\b8\u0010#R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010)\u001a\u0004\b9\u0010#R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010)\u001a\u0004\b:\u0010#R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010;\u001a\u0004\b<\u0010=¨\u0006?"}, d2 = {"LP6/j;", "", "", "status", "fileId", "", "fileSize", "downloadUrl", "code", "message", "auditStatus", "auditDecision", "auditRiskLevel", "auditSuggestText", "sensitiveStatus", "sensitiveDecision", "sensitiveLevel", "", "detectPassed", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "o", "(LP6/j;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "n", "getStatus$annotations", "()V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/lang/Long;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/lang/Long;", Const.INTENT_KEY_BACKGROUND_COMMAND, "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "c", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "m", "k", "l", "Ljava/lang/Boolean;", "f", "()Ljava/lang/Boolean;", "Companion", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@lb.l
/* renamed from: P6.j, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class TosCallbackBody {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String auditDecision;
    private final String auditRiskLevel;
    private final String auditStatus;
    private final String auditSuggestText;
    private final String code;
    private final Boolean detectPassed;
    private final String downloadUrl;
    private final String fileId;
    private final Long fileSize;
    private final String message;
    private final String sensitiveDecision;
    private final String sensitiveLevel;
    private final String sensitiveStatus;
    private final String status;

    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/stepos/common/utils/filestorage/models/TosCallbackBody.$serializer", "Lpb/M;", "LP6/j;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "c", "(Lkotlinx/serialization/encoding/Encoder;LP6/j;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", Const.INTENT_KEY_PKGNAME, "(Lkotlinx/serialization/encoding/Decoder;)LP6/j;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: P6.j$a */
    public /* synthetic */ class a implements M<TosCallbackBody> {
        public static final a INSTANCE;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            I0 i02 = new I0("com.stepos.common.utils.filestorage.models.TosCallbackBody", aVar, 14);
            i02.n("Status", false);
            i02.n("fileId", true);
            i02.n("fileSize", true);
            i02.n("downloadUrl", true);
            i02.n("code", true);
            i02.n("message", true);
            i02.n("auditStatus", true);
            i02.n("auditDecision", true);
            i02.n("auditRiskLevel", true);
            i02.n("auditSuggestText", true);
            i02.n("sensitiveStatus", true);
            i02.n("sensitiveDecision", true);
            i02.n("sensitiveLevel", true);
            i02.n("detectPassed", true);
            descriptor = i02;
        }

        @Override // lb.InterfaceC4883a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final TosCallbackBody deserialize(Decoder decoder) {
            String str;
            Boolean bool;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            Long l10;
            int i10;
            String str12;
            Long l11;
            Long l12;
            p.i(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
            Boolean bool2 = null;
            if (cVarBeginStructure.decodeSequentially()) {
                String strDecodeStringElement = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
                Y0 y02 = Y0.f38329a;
                String str13 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, y02, null);
                Long l13 = (Long) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, C5101i0.f38365a, null);
                String str14 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, y02, null);
                String str15 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, y02, null);
                String str16 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, y02, null);
                String str17 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, y02, null);
                String str18 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, y02, null);
                String str19 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, y02, null);
                String str20 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, y02, null);
                String str21 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, y02, null);
                String str22 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, y02, null);
                str2 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, y02, null);
                bool = (Boolean) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 13, C5100i.f38363a, null);
                i10 = 16383;
                l10 = l13;
                str8 = str21;
                str4 = str20;
                str6 = str18;
                str9 = str17;
                str7 = str16;
                str11 = str14;
                str5 = str19;
                str10 = str15;
                str3 = str22;
                str = str13;
                str12 = strDecodeStringElement;
            } else {
                int i11 = 0;
                Long l14 = null;
                String str23 = null;
                String str24 = null;
                String str25 = null;
                String str26 = null;
                String str27 = null;
                String str28 = null;
                String str29 = null;
                String str30 = null;
                String str31 = null;
                String str32 = null;
                String strDecodeStringElement2 = null;
                boolean z10 = true;
                String str33 = null;
                while (z10) {
                    String str34 = str23;
                    int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                    switch (iDecodeElementIndex) {
                        case -1:
                            z10 = false;
                            l14 = l14;
                            str23 = str34;
                            i11 = i11;
                        case 0:
                            l12 = l14;
                            strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
                            str23 = str34;
                            i11 |= 1;
                            l14 = l12;
                        case 1:
                            l12 = l14;
                            str23 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, Y0.f38329a, str34);
                            i11 |= 2;
                            l14 = l12;
                        case 2:
                            l14 = (Long) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, C5101i0.f38365a, l14);
                            i11 |= 4;
                            str23 = str34;
                        case 3:
                            l11 = l14;
                            str33 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, Y0.f38329a, str33);
                            i11 |= 8;
                            str23 = str34;
                            l14 = l11;
                        case 4:
                            l11 = l14;
                            str32 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, Y0.f38329a, str32);
                            i11 |= 16;
                            str23 = str34;
                            l14 = l11;
                        case 5:
                            l11 = l14;
                            str29 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, Y0.f38329a, str29);
                            i11 |= 32;
                            str23 = str34;
                            l14 = l11;
                        case 6:
                            l11 = l14;
                            str31 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, Y0.f38329a, str31);
                            i11 |= 64;
                            str23 = str34;
                            l14 = l11;
                        case 7:
                            l11 = l14;
                            str28 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, Y0.f38329a, str28);
                            i11 |= 128;
                            str23 = str34;
                            l14 = l11;
                        case 8:
                            l11 = l14;
                            str27 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, Y0.f38329a, str27);
                            i11 |= 256;
                            str23 = str34;
                            l14 = l11;
                        case 9:
                            l11 = l14;
                            str26 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, Y0.f38329a, str26);
                            i11 |= 512;
                            str23 = str34;
                            l14 = l11;
                        case 10:
                            l11 = l14;
                            str30 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, Y0.f38329a, str30);
                            i11 |= 1024;
                            str23 = str34;
                            l14 = l11;
                        case 11:
                            l11 = l14;
                            str25 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, Y0.f38329a, str25);
                            i11 |= 2048;
                            str23 = str34;
                            l14 = l11;
                        case 12:
                            l11 = l14;
                            str24 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, Y0.f38329a, str24);
                            i11 |= 4096;
                            str23 = str34;
                            l14 = l11;
                        case 13:
                            l11 = l14;
                            bool2 = (Boolean) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 13, C5100i.f38363a, bool2);
                            i11 |= com.stepos.agentframework.chatui.longtext.b.THRESHOLD;
                            str23 = str34;
                            l14 = l11;
                        default:
                            throw new UnknownFieldException(iDecodeElementIndex);
                    }
                }
                str = str23;
                bool = bool2;
                str2 = str24;
                str3 = str25;
                str4 = str26;
                str5 = str27;
                str6 = str28;
                str7 = str29;
                str8 = str30;
                str9 = str31;
                str10 = str32;
                str11 = str33;
                l10 = l14;
                i10 = i11;
                str12 = strDecodeStringElement2;
            }
            cVarBeginStructure.endStructure(serialDescriptor);
            return new TosCallbackBody(i10, str12, str, l10, str11, str10, str7, str9, str6, str5, str4, str8, str3, str2, bool, (T0) null);
        }

        @Override // lb.m
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, TosCallbackBody value) {
            p.i(encoder, "encoder");
            p.i(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            ob.d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
            TosCallbackBody.o(value, dVarBeginStructure, serialDescriptor);
            dVarBeginStructure.endStructure(serialDescriptor);
        }

        @Override // pb.M
        public final KSerializer<?>[] childSerializers() {
            Y0 y02 = Y0.f38329a;
            return new KSerializer[]{y02, C4931a.t(y02), C4931a.t(C5101i0.f38365a), C4931a.t(y02), C4931a.t(y02), C4931a.t(y02), C4931a.t(y02), C4931a.t(y02), C4931a.t(y02), C4931a.t(y02), C4931a.t(y02), C4931a.t(y02), C4931a.t(y02), C4931a.t(C5100i.f38363a)};
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

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"LP6/j$b;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "LP6/j;", "serializer", "()Lkotlinx/serialization/KSerializer;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: P6.j$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<TosCallbackBody> serializer() {
            return a.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ TosCallbackBody(int i10, String str, String str2, Long l10, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Boolean bool, T0 t02) {
        if (1 != (i10 & 1)) {
            E0.a(i10, 1, a.INSTANCE.getDescriptor());
        }
        this.status = str;
        if ((i10 & 2) == 0) {
            this.fileId = null;
        } else {
            this.fileId = str2;
        }
        if ((i10 & 4) == 0) {
            this.fileSize = null;
        } else {
            this.fileSize = l10;
        }
        if ((i10 & 8) == 0) {
            this.downloadUrl = null;
        } else {
            this.downloadUrl = str3;
        }
        if ((i10 & 16) == 0) {
            this.code = null;
        } else {
            this.code = str4;
        }
        if ((i10 & 32) == 0) {
            this.message = null;
        } else {
            this.message = str5;
        }
        if ((i10 & 64) == 0) {
            this.auditStatus = null;
        } else {
            this.auditStatus = str6;
        }
        if ((i10 & 128) == 0) {
            this.auditDecision = null;
        } else {
            this.auditDecision = str7;
        }
        if ((i10 & 256) == 0) {
            this.auditRiskLevel = null;
        } else {
            this.auditRiskLevel = str8;
        }
        if ((i10 & 512) == 0) {
            this.auditSuggestText = null;
        } else {
            this.auditSuggestText = str9;
        }
        if ((i10 & 1024) == 0) {
            this.sensitiveStatus = null;
        } else {
            this.sensitiveStatus = str10;
        }
        if ((i10 & 2048) == 0) {
            this.sensitiveDecision = null;
        } else {
            this.sensitiveDecision = str11;
        }
        if ((i10 & 4096) == 0) {
            this.sensitiveLevel = null;
        } else {
            this.sensitiveLevel = str12;
        }
        if ((i10 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) == 0) {
            this.detectPassed = null;
        } else {
            this.detectPassed = bool;
        }
    }

    public static final /* synthetic */ void o(TosCallbackBody self, ob.d output, SerialDescriptor serialDesc) {
        output.w(serialDesc, 0, self.status);
        if (output.y(serialDesc, 1) || self.fileId != null) {
            output.k(serialDesc, 1, Y0.f38329a, self.fileId);
        }
        if (output.y(serialDesc, 2) || self.fileSize != null) {
            output.k(serialDesc, 2, C5101i0.f38365a, self.fileSize);
        }
        if (output.y(serialDesc, 3) || self.downloadUrl != null) {
            output.k(serialDesc, 3, Y0.f38329a, self.downloadUrl);
        }
        if (output.y(serialDesc, 4) || self.code != null) {
            output.k(serialDesc, 4, Y0.f38329a, self.code);
        }
        if (output.y(serialDesc, 5) || self.message != null) {
            output.k(serialDesc, 5, Y0.f38329a, self.message);
        }
        if (output.y(serialDesc, 6) || self.auditStatus != null) {
            output.k(serialDesc, 6, Y0.f38329a, self.auditStatus);
        }
        if (output.y(serialDesc, 7) || self.auditDecision != null) {
            output.k(serialDesc, 7, Y0.f38329a, self.auditDecision);
        }
        if (output.y(serialDesc, 8) || self.auditRiskLevel != null) {
            output.k(serialDesc, 8, Y0.f38329a, self.auditRiskLevel);
        }
        if (output.y(serialDesc, 9) || self.auditSuggestText != null) {
            output.k(serialDesc, 9, Y0.f38329a, self.auditSuggestText);
        }
        if (output.y(serialDesc, 10) || self.sensitiveStatus != null) {
            output.k(serialDesc, 10, Y0.f38329a, self.sensitiveStatus);
        }
        if (output.y(serialDesc, 11) || self.sensitiveDecision != null) {
            output.k(serialDesc, 11, Y0.f38329a, self.sensitiveDecision);
        }
        if (output.y(serialDesc, 12) || self.sensitiveLevel != null) {
            output.k(serialDesc, 12, Y0.f38329a, self.sensitiveLevel);
        }
        if (!output.y(serialDesc, 13) && self.detectPassed == null) {
            return;
        }
        output.k(serialDesc, 13, C5100i.f38363a, self.detectPassed);
    }

    /* renamed from: a, reason: from getter */
    public final String getAuditDecision() {
        return this.auditDecision;
    }

    /* renamed from: b, reason: from getter */
    public final String getAuditRiskLevel() {
        return this.auditRiskLevel;
    }

    /* renamed from: c, reason: from getter */
    public final String getAuditStatus() {
        return this.auditStatus;
    }

    /* renamed from: d, reason: from getter */
    public final String getAuditSuggestText() {
        return this.auditSuggestText;
    }

    /* renamed from: e, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TosCallbackBody)) {
            return false;
        }
        TosCallbackBody tosCallbackBody = (TosCallbackBody) other;
        return p.d(this.status, tosCallbackBody.status) && p.d(this.fileId, tosCallbackBody.fileId) && p.d(this.fileSize, tosCallbackBody.fileSize) && p.d(this.downloadUrl, tosCallbackBody.downloadUrl) && p.d(this.code, tosCallbackBody.code) && p.d(this.message, tosCallbackBody.message) && p.d(this.auditStatus, tosCallbackBody.auditStatus) && p.d(this.auditDecision, tosCallbackBody.auditDecision) && p.d(this.auditRiskLevel, tosCallbackBody.auditRiskLevel) && p.d(this.auditSuggestText, tosCallbackBody.auditSuggestText) && p.d(this.sensitiveStatus, tosCallbackBody.sensitiveStatus) && p.d(this.sensitiveDecision, tosCallbackBody.sensitiveDecision) && p.d(this.sensitiveLevel, tosCallbackBody.sensitiveLevel) && p.d(this.detectPassed, tosCallbackBody.detectPassed);
    }

    /* renamed from: f, reason: from getter */
    public final Boolean getDetectPassed() {
        return this.detectPassed;
    }

    /* renamed from: g, reason: from getter */
    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    /* renamed from: h, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    public int hashCode() {
        int iHashCode = this.status.hashCode() * 31;
        String str = this.fileId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l10 = this.fileSize;
        int iHashCode3 = (iHashCode2 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str2 = this.downloadUrl;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.code;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.message;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.auditStatus;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.auditDecision;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.auditRiskLevel;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.auditSuggestText;
        int iHashCode10 = (iHashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.sensitiveStatus;
        int iHashCode11 = (iHashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.sensitiveDecision;
        int iHashCode12 = (iHashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.sensitiveLevel;
        int iHashCode13 = (iHashCode12 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Boolean bool = this.detectPassed;
        return iHashCode13 + (bool != null ? bool.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final Long getFileSize() {
        return this.fileSize;
    }

    /* renamed from: j, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: k, reason: from getter */
    public final String getSensitiveDecision() {
        return this.sensitiveDecision;
    }

    /* renamed from: l, reason: from getter */
    public final String getSensitiveLevel() {
        return this.sensitiveLevel;
    }

    /* renamed from: m, reason: from getter */
    public final String getSensitiveStatus() {
        return this.sensitiveStatus;
    }

    /* renamed from: n, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public String toString() {
        return "TosCallbackBody(status=" + this.status + ", fileId=" + this.fileId + ", fileSize=" + this.fileSize + ", downloadUrl=" + this.downloadUrl + ", code=" + this.code + ", message=" + this.message + ", auditStatus=" + this.auditStatus + ", auditDecision=" + this.auditDecision + ", auditRiskLevel=" + this.auditRiskLevel + ", auditSuggestText=" + this.auditSuggestText + ", sensitiveStatus=" + this.sensitiveStatus + ", sensitiveDecision=" + this.sensitiveDecision + ", sensitiveLevel=" + this.sensitiveLevel + ", detectPassed=" + this.detectPassed + ")";
    }

    public TosCallbackBody(String status, String str, Long l10, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Boolean bool) {
        p.i(status, "status");
        this.status = status;
        this.fileId = str;
        this.fileSize = l10;
        this.downloadUrl = str2;
        this.code = str3;
        this.message = str4;
        this.auditStatus = str5;
        this.auditDecision = str6;
        this.auditRiskLevel = str7;
        this.auditSuggestText = str8;
        this.sensitiveStatus = str9;
        this.sensitiveDecision = str10;
        this.sensitiveLevel = str11;
        this.detectPassed = bool;
    }

    public /* synthetic */ TosCallbackBody(String str, String str2, Long l10, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Boolean bool, int i10, kotlin.jvm.internal.i iVar) {
        this(str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : l10, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? null : str5, (i10 & 64) != 0 ? null : str6, (i10 & 128) != 0 ? null : str7, (i10 & 256) != 0 ? null : str8, (i10 & 512) != 0 ? null : str9, (i10 & 1024) != 0 ? null : str10, (i10 & 2048) != 0 ? null : str11, (i10 & 4096) != 0 ? null : str12, (i10 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? null : bool);
    }
}
