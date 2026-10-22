package p7;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import lb.l;
import mb.C4931a;
import ob.c;
import ob.d;
import pb.C5100i;
import pb.E0;
import pb.I0;
import pb.M;
import pb.T0;
import pb.Y0;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002\u0017\"BE\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bBU\b\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u0010J(\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014HÇ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001e\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010 \u001a\u0004\b!\u0010\u001aR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\"\u0010 \u001a\u0004\b#\u0010\u001aR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\u001aR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\u001aR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b(\u0010 \u001a\u0004\b)\u0010\u001aR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b\t\u0010,¨\u0006."}, d2 = {"Lp7/b;", "", "", "type", "packageName", "appUIName", "widgetName", "widgetAction", "", "isFix", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "", "seen1", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lp7/b;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getType", Const.INTENT_KEY_PKGNAME, "getPackageName", "c", "getAppUIName", Const.INTENT_KEY_UMID, "getWidgetName", "e", "getWidgetAction", "f", "Z", "()Z", "Companion", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@l
/* renamed from: p7.b, reason: from toString */
/* loaded from: classes.dex */
public final /* data */ class AppUI {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TYPE_CUSTOM = "customView";
    public static final String TYPE_WEB = "web";
    public static final String TYPE_WIDGET = "widget";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String packageName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String appUIName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String widgetName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final String widgetAction;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean isFix;

    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/stepos/mcp/sdk/base/AppUI.$serializer", "Lpb/M;", "Lp7/b;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", Const.INTENT_KEY_PKGNAME, "(Lkotlinx/serialization/encoding/Decoder;)Lp7/b;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "c", "(Lkotlinx/serialization/encoding/Encoder;Lp7/b;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* renamed from: p7.b$a */
    public static final class a implements M<AppUI> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f38249a;
        private static final /* synthetic */ I0 descriptor;

        static {
            a aVar = new a();
            f38249a = aVar;
            I0 i02 = new I0("com.stepos.mcp.sdk.base.AppUI", aVar, 6);
            i02.n("type", false);
            i02.n("packageName", false);
            i02.n("appUIName", true);
            i02.n("widgetName", true);
            i02.n("widgetAction", true);
            i02.n("isFix", true);
            descriptor = i02;
        }

        @Override // lb.InterfaceC4883a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AppUI deserialize(Decoder decoder) {
            boolean zDecodeBooleanElement;
            int i10;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            p.i(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            c cVarBeginStructure = decoder.beginStructure(descriptor2);
            if (cVarBeginStructure.decodeSequentially()) {
                String strDecodeStringElement = cVarBeginStructure.decodeStringElement(descriptor2, 0);
                String strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(descriptor2, 1);
                Y0 y02 = Y0.f38329a;
                String str6 = (String) cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, y02, null);
                String str7 = (String) cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 3, y02, null);
                String str8 = (String) cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 4, y02, null);
                str = strDecodeStringElement;
                zDecodeBooleanElement = cVarBeginStructure.decodeBooleanElement(descriptor2, 5);
                str4 = str7;
                str5 = str8;
                str3 = str6;
                str2 = strDecodeStringElement2;
                i10 = 63;
            } else {
                boolean z10 = true;
                boolean zDecodeBooleanElement2 = false;
                String strDecodeStringElement3 = null;
                String strDecodeStringElement4 = null;
                String str9 = null;
                String str10 = null;
                String str11 = null;
                int i11 = 0;
                while (z10) {
                    int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(descriptor2);
                    switch (iDecodeElementIndex) {
                        case -1:
                            z10 = false;
                            continue;
                        case 0:
                            strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(descriptor2, 0);
                            i11 |= 1;
                            continue;
                        case 1:
                            strDecodeStringElement4 = cVarBeginStructure.decodeStringElement(descriptor2, 1);
                            i11 |= 2;
                            break;
                        case 2:
                            str9 = (String) cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, Y0.f38329a, str9);
                            i11 |= 4;
                            break;
                        case 3:
                            str10 = (String) cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 3, Y0.f38329a, str10);
                            i11 |= 8;
                            break;
                        case 4:
                            str11 = (String) cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 4, Y0.f38329a, str11);
                            i11 |= 16;
                            break;
                        case 5:
                            zDecodeBooleanElement2 = cVarBeginStructure.decodeBooleanElement(descriptor2, 5);
                            i11 |= 32;
                            break;
                        default:
                            throw new UnknownFieldException(iDecodeElementIndex);
                    }
                }
                zDecodeBooleanElement = zDecodeBooleanElement2;
                i10 = i11;
                str = strDecodeStringElement3;
                str2 = strDecodeStringElement4;
                str3 = str9;
                str4 = str10;
                str5 = str11;
            }
            cVarBeginStructure.endStructure(descriptor2);
            return new AppUI(i10, str, str2, str3, str4, str5, zDecodeBooleanElement, null);
        }

        @Override // lb.m
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void serialize(Encoder encoder, AppUI value) {
            p.i(encoder, "encoder");
            p.i(value, "value");
            SerialDescriptor descriptor2 = getDescriptor();
            d dVarBeginStructure = encoder.beginStructure(descriptor2);
            AppUI.a(value, dVarBeginStructure, descriptor2);
            dVarBeginStructure.endStructure(descriptor2);
        }

        @Override // pb.M
        public KSerializer<?>[] childSerializers() {
            Y0 y02 = Y0.f38329a;
            return new KSerializer[]{y02, y02, C4931a.t(y02), C4931a.t(y02), C4931a.t(y02), C5100i.f38363a};
        }

        @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
        public SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // pb.M
        public KSerializer<?>[] typeParametersSerializers() {
            return M.a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lp7/b$b;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lp7/b;", "serializer", "()Lkotlinx/serialization/KSerializer;", "", "TYPE_CUSTOM", "Ljava/lang/String;", "TYPE_WEB", "TYPE_WIDGET", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* renamed from: p7.b$b, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<AppUI> serializer() {
            return a.f38249a;
        }

        public Companion() {
        }
    }

    public /* synthetic */ AppUI(int i10, String str, String str2, String str3, String str4, String str5, boolean z10, T0 t02) {
        if (3 != (i10 & 3)) {
            E0.a(i10, 3, a.f38249a.getDescriptor());
        }
        this.type = str;
        this.packageName = str2;
        if ((i10 & 4) == 0) {
            this.appUIName = null;
        } else {
            this.appUIName = str3;
        }
        if ((i10 & 8) == 0) {
            this.widgetName = null;
        } else {
            this.widgetName = str4;
        }
        if ((i10 & 16) == 0) {
            this.widgetAction = null;
        } else {
            this.widgetAction = str5;
        }
        if ((i10 & 32) == 0) {
            this.isFix = false;
        } else {
            this.isFix = z10;
        }
    }

    public static final /* synthetic */ void a(AppUI self, d output, SerialDescriptor serialDesc) {
        output.w(serialDesc, 0, self.type);
        output.w(serialDesc, 1, self.packageName);
        if (output.y(serialDesc, 2) || self.appUIName != null) {
            output.k(serialDesc, 2, Y0.f38329a, self.appUIName);
        }
        if (output.y(serialDesc, 3) || self.widgetName != null) {
            output.k(serialDesc, 3, Y0.f38329a, self.widgetName);
        }
        if (output.y(serialDesc, 4) || self.widgetAction != null) {
            output.k(serialDesc, 4, Y0.f38329a, self.widgetAction);
        }
        if (output.y(serialDesc, 5) || self.isFix) {
            output.v(serialDesc, 5, self.isFix);
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppUI)) {
            return false;
        }
        AppUI appUI = (AppUI) other;
        return p.d(this.type, appUI.type) && p.d(this.packageName, appUI.packageName) && p.d(this.appUIName, appUI.appUIName) && p.d(this.widgetName, appUI.widgetName) && p.d(this.widgetAction, appUI.widgetAction) && this.isFix == appUI.isFix;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = (this.packageName.hashCode() + (this.type.hashCode() * 31)) * 31;
        String str = this.appUIName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.widgetName;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.widgetAction;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z10 = this.isFix;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return iHashCode4 + i10;
    }

    public String toString() {
        return "AppUI(type=" + this.type + ", packageName=" + this.packageName + ", appUIName=" + this.appUIName + ", widgetName=" + this.widgetName + ", widgetAction=" + this.widgetAction + ", isFix=" + this.isFix + ")";
    }

    public AppUI(String type, String packageName, String str, String str2, String str3, boolean z10) {
        p.i(type, "type");
        p.i(packageName, "packageName");
        this.type = type;
        this.packageName = packageName;
        this.appUIName = str;
        this.widgetName = str2;
        this.widgetAction = str3;
        this.isFix = z10;
    }
}
