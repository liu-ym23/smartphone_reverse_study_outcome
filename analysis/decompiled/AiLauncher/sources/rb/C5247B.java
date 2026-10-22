package rb;

import Z8.Z;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;
import nb.AbstractC4951d;
import nb.AbstractC4959l;
import pb.Y;
import qb.AbstractC5171a;
import qb.C5168A;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0012\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010!\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\rH\u0002¢\u0006\u0004\b!\u0010\"R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010!¨\u0006."}, d2 = {"Lrb/B;", "Lrb/c;", "Lqb/a;", "json", "Lqb/D;", UxipConstants.f30680s, "", "polymorphicDiscriminator", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "polyDescriptor", "<init>", "(Lqb/a;Lqb/D;Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "descriptor", "", "decodeElementIndex", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "", "decodeNotNullMark", "()Z", "index", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/String;", "tag", "Lqb/i;", "G", "(Ljava/lang/String;)Lqb/i;", "X", "Lob/c;", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lob/c;", "LY8/t;", "endStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "Z", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lqb/D;", "Y", "()Lqb/D;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lkotlinx/serialization/descriptors/SerialDescriptor;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "I", "position", "k", "forceNull", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: rb.B, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5247B extends AbstractC5253c {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final qb.D value;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final SerialDescriptor polyDescriptor;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public int position;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public boolean forceNull;

    public /* synthetic */ C5247B(AbstractC5171a abstractC5171a, qb.D d10, String str, SerialDescriptor serialDescriptor, int i10, kotlin.jvm.internal.i iVar) {
        this(abstractC5171a, d10, (i10 & 4) != 0 ? null : str, (i10 & 8) != 0 ? null : serialDescriptor);
    }

    @Override // pb.AbstractC5115p0
    public String A(SerialDescriptor descriptor, int index) {
        Object next;
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        u.n(descriptor, getJson());
        String strE = descriptor.e(index);
        if (!this.configuration.getUseAlternativeNames() || U().keySet().contains(strE)) {
            return strE;
        }
        Map<String, Integer> mapE = u.e(getJson(), descriptor);
        Iterator<T> it = U().keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Integer num = mapE.get((String) next);
            if (num != null && num.intValue() == index) {
                break;
            }
        }
        String str = (String) next;
        return str != null ? str : strE;
    }

    @Override // rb.AbstractC5253c
    public qb.i G(String tag) {
        kotlin.jvm.internal.p.i(tag, "tag");
        return (qb.i) kotlin.collections.a.j(U(), tag);
    }

    public final qb.i X(String tag) {
        kotlin.jvm.internal.p.i(tag, "tag");
        return (qb.i) U().get(tag);
    }

    @Override // rb.AbstractC5253c
    /* renamed from: Y, reason: from getter and merged with bridge method [inline-methods] */
    public qb.D getValue() {
        return this.value;
    }

    public final boolean Z(SerialDescriptor descriptor, int index) {
        boolean z10 = (getJson().getConfiguration().getExplicitNulls() || descriptor.i(index) || !descriptor.g(index).b()) ? false : true;
        this.forceNull = z10;
        return z10;
    }

    @Override // rb.AbstractC5253c, kotlinx.serialization.encoding.Decoder
    public ob.c beginStructure(SerialDescriptor descriptor) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        if (descriptor != this.polyDescriptor) {
            return super.beginStructure(descriptor);
        }
        AbstractC5171a json = getJson();
        qb.i iVarH = H();
        String serialName = this.polyDescriptor.getSerialName();
        if (iVarH instanceof qb.D) {
            return new C5247B(json, (qb.D) iVarH, getPolymorphicDiscriminator(), this.polyDescriptor);
        }
        throw C5268s.f(-1, "Expected " + kotlin.jvm.internal.t.b(qb.D.class).t() + ", but had " + kotlin.jvm.internal.t.b(iVarH.getClass()).t() + " as the serialized body of " + serialName + " at element: " + D(), iVarH.toString());
    }

    @Override // ob.c
    public int decodeElementIndex(SerialDescriptor descriptor) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        while (this.position < descriptor.getElementsCount()) {
            int i10 = this.position;
            this.position = i10 + 1;
            String strU = u(descriptor, i10);
            int i11 = this.position - 1;
            this.forceNull = false;
            if (U().containsKey(strU) || Z(descriptor, i11)) {
                if (this.configuration.getCoerceInputValues()) {
                    AbstractC5171a json = getJson();
                    boolean zI = descriptor.i(i11);
                    SerialDescriptor serialDescriptorG = descriptor.g(i11);
                    if (!zI || serialDescriptorG.b() || !(X(strU) instanceof C5168A)) {
                        if (!kotlin.jvm.internal.p.d(serialDescriptorG.getKind(), AbstractC4959l.b.f37292a) || (serialDescriptorG.b() && (X(strU) instanceof C5168A))) {
                            return i11;
                        }
                        qb.i iVarX = X(strU);
                        qb.F f10 = iVarX instanceof qb.F ? (qb.F) iVarX : null;
                        String strF = f10 != null ? qb.j.f(f10) : null;
                        if (strF == null) {
                            return i11;
                        }
                        int i12 = u.i(serialDescriptorG, json, strF);
                        boolean z10 = !json.getConfiguration().getExplicitNulls() && serialDescriptorG.b();
                        if (i12 != -3 || ((!zI && !z10) || Z(descriptor, i11))) {
                        }
                    }
                }
                return i11;
            }
        }
        return -1;
    }

    @Override // rb.AbstractC5253c, kotlinx.serialization.encoding.Decoder
    public boolean decodeNotNullMark() {
        return !this.forceNull && super.decodeNotNullMark();
    }

    @Override // rb.AbstractC5253c, ob.c
    public void endStructure(SerialDescriptor descriptor) {
        Set<String> setO;
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        if (u.m(descriptor, getJson()) || (descriptor.getKind() instanceof AbstractC4951d)) {
            return;
        }
        u.n(descriptor, getJson());
        if (this.configuration.getUseAlternativeNames()) {
            Set<String> setA = Y.a(descriptor);
            Map map = (Map) qb.H.a(getJson()).a(descriptor, u.g());
            Set setKeySet = map != null ? map.keySet() : null;
            if (setKeySet == null) {
                setKeySet = Z8.Y.e();
            }
            setO = Z.o(setA, setKeySet);
        } else {
            setO = Y.a(descriptor);
        }
        for (String str : U().keySet()) {
            if (!setO.contains(str) && !kotlin.jvm.internal.p.d(str, getPolymorphicDiscriminator())) {
                throw C5268s.e(-1, "Encountered an unknown key '" + str + "' at element: " + D() + "\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder or '@JsonIgnoreUnknownKeys' annotation to ignore unknown keys.\nJSON input: " + ((Object) C5268s.j(U().toString(), 0, 1, null)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5247B(AbstractC5171a json, qb.D value, String str, SerialDescriptor serialDescriptor) {
        super(json, value, str, null);
        kotlin.jvm.internal.p.i(json, "json");
        kotlin.jvm.internal.p.i(value, "value");
        this.value = value;
        this.polyDescriptor = serialDescriptor;
    }
}
