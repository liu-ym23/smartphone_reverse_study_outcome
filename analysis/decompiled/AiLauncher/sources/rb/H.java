package rb;

import com.autonavi.aps.amapapi.config.Const;
import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.ClassDiscriminatorMode;
import nb.AbstractC4951d;
import nb.AbstractC4952e;
import nb.AbstractC4959l;
import pb.Y;
import qb.AbstractC5171a;
import qb.InterfaceC5175e;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a/\u0010\u0006\u001a\u00020\u00052\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u001b\u0010\u000f\u001a\u00020\u0003*\u00020\f2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Llb/m;", "serializer", "actualSerializer", "", "classDiscriminator", "LY8/t;", Const.INTENT_KEY_UMID, "(Llb/m;Llb/m;Ljava/lang/String;)V", "Lnb/l;", "kind", Const.INTENT_KEY_PKGNAME, "(Lnb/l;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lqb/a;", "json", "c", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lqb/a;)Ljava/lang/String;", "kotlinx-serialization-json"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class H {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38936a;

        static {
            int[] iArr = new int[ClassDiscriminatorMode.values().length];
            try {
                iArr[ClassDiscriminatorMode.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ClassDiscriminatorMode.POLYMORPHIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ClassDiscriminatorMode.ALL_JSON_OBJECTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f38936a = iArr;
        }
    }

    public static final void b(AbstractC4959l kind) {
        kotlin.jvm.internal.p.i(kind, "kind");
        if (kind instanceof AbstractC4959l.b) {
            throw new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead");
        }
        if (kind instanceof AbstractC4952e) {
            throw new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead");
        }
        if (kind instanceof AbstractC4951d) {
            throw new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself");
        }
    }

    public static final String c(SerialDescriptor serialDescriptor, AbstractC5171a json) {
        kotlin.jvm.internal.p.i(serialDescriptor, "<this>");
        kotlin.jvm.internal.p.i(json, "json");
        for (Annotation annotation : serialDescriptor.getAnnotations()) {
            if (annotation instanceof InterfaceC5175e) {
                return ((InterfaceC5175e) annotation).discriminator();
            }
        }
        return json.getConfiguration().getClassDiscriminator();
    }

    public static final void d(lb.m<?> mVar, lb.m<?> mVar2, String str) {
        if ((mVar instanceof lb.j) && Y.a(mVar2.getDescriptor()).contains(str)) {
            String serialName = ((lb.j) mVar).getDescriptor().getSerialName();
            throw new IllegalStateException(("Sealed class '" + mVar2.getDescriptor().getSerialName() + "' cannot be serialized as base class '" + serialName + "' because it has property name that conflicts with JSON class discriminator '" + str + "'. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism").toString());
        }
    }
}
