package rb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.ClassDiscriminatorMode;
import lb.InterfaceC4883a;
import nb.AbstractC4951d;
import nb.AbstractC4952e;
import nb.AbstractC4959l;
import nb.AbstractC4960m;
import p9.InterfaceC5074l;
import qb.JsonConfiguration;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005JI\u0010\u000f\u001a\u00020\u000e\"\b\b\u0000\u0010\u0007*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2 \u0010\r\u001a\u001c\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010JM\u0010\u0016\u001a\u00020\u000e\"\b\b\u0000\u0010\u0011*\u00020\u0006\"\b\b\u0001\u0010\u0012*\u00028\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017JC\u0010\u001a\u001a\u00020\u000e\"\b\b\u0000\u0010\u0011*\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00180\nH\u0016¢\u0006\u0004\b\u001a\u0010\u0010JE\u0010\u001e\u001a\u00020\u000e\"\b\b\u0000\u0010\u0011*\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u001c\u0010\u001d\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001c0\nH\u0016¢\u0006\u0004\b\u001e\u0010\u0010J#\u0010!\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001f2\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\bH\u0002¢\u0006\u0004\b!\u0010\"J#\u0010#\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001f2\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\bH\u0002¢\u0006\u0004\b#\u0010\"R\u0014\u0010%\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010'R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010'¨\u0006*"}, d2 = {"Lrb/y;", "Lsb/f;", "Lqb/f;", "configuration", "<init>", "(Lqb/f;)V", "", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "kClass", "Lkotlin/Function1;", "", "Lkotlinx/serialization/KSerializer;", Const.JSON_KEY_PROVIDER, "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lw9/d;Lp9/l;)V", "Base", "Sub", "baseClass", "actualClass", "actualSerializer", Const.INTENT_KEY_UMID, "(Lw9/d;Lw9/d;Lkotlinx/serialization/KSerializer;)V", "Llb/m;", "defaultSerializerProvider", Const.INTENT_KEY_APIKEY, "", "Llb/a;", "defaultDeserializerProvider", "c", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lw9/d;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/lang/String;", "discriminator", "", "Z", "useArrayPolymorphism", "isDiscriminatorRequired", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class y implements sb.f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String discriminator;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean useArrayPolymorphism;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final boolean isDiscriminatorRequired;

    public y(JsonConfiguration configuration) {
        kotlin.jvm.internal.p.i(configuration, "configuration");
        this.discriminator = configuration.getClassDiscriminator();
        this.useArrayPolymorphism = configuration.getUseArrayPolymorphism();
        this.isDiscriminatorRequired = configuration.getClassDiscriminatorMode() != ClassDiscriminatorMode.NONE;
    }

    @Override // sb.f
    public <Base> void a(InterfaceC5745d<Base> baseClass, InterfaceC5074l<? super Base, ? extends lb.m<? super Base>> defaultSerializerProvider) {
        kotlin.jvm.internal.p.i(baseClass, "baseClass");
        kotlin.jvm.internal.p.i(defaultSerializerProvider, "defaultSerializerProvider");
    }

    @Override // sb.f
    public <T> void b(InterfaceC5745d<T> kClass, InterfaceC5074l<? super List<? extends KSerializer<?>>, ? extends KSerializer<?>> provider) {
        kotlin.jvm.internal.p.i(kClass, "kClass");
        kotlin.jvm.internal.p.i(provider, "provider");
    }

    @Override // sb.f
    public <Base> void c(InterfaceC5745d<Base> baseClass, InterfaceC5074l<? super String, ? extends InterfaceC4883a<? extends Base>> defaultDeserializerProvider) {
        kotlin.jvm.internal.p.i(baseClass, "baseClass");
        kotlin.jvm.internal.p.i(defaultDeserializerProvider, "defaultDeserializerProvider");
    }

    @Override // sb.f
    public <Base, Sub extends Base> void d(InterfaceC5745d<Base> baseClass, InterfaceC5745d<Sub> actualClass, KSerializer<Sub> actualSerializer) {
        kotlin.jvm.internal.p.i(baseClass, "baseClass");
        kotlin.jvm.internal.p.i(actualClass, "actualClass");
        kotlin.jvm.internal.p.i(actualSerializer, "actualSerializer");
        SerialDescriptor descriptor = actualSerializer.getDescriptor();
        i(descriptor, actualClass);
        if (this.useArrayPolymorphism || !this.isDiscriminatorRequired) {
            return;
        }
        h(descriptor, actualClass);
    }

    @Override // sb.f
    public <T> void f(InterfaceC5745d<T> interfaceC5745d, KSerializer<T> kSerializer) {
        super.f(interfaceC5745d, kSerializer);
    }

    public final void h(SerialDescriptor descriptor, InterfaceC5745d<?> actualClass) {
        int elementsCount = descriptor.getElementsCount();
        for (int i10 = 0; i10 < elementsCount; i10++) {
            String strE = descriptor.e(i10);
            if (kotlin.jvm.internal.p.d(strE, this.discriminator)) {
                throw new IllegalArgumentException("Polymorphic serializer for " + actualClass + " has property '" + strE + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
            }
        }
    }

    public final void i(SerialDescriptor descriptor, InterfaceC5745d<?> actualClass) {
        AbstractC4959l kind = descriptor.getKind();
        if ((kind instanceof AbstractC4951d) || kotlin.jvm.internal.p.d(kind, AbstractC4959l.a.f37291a)) {
            throw new IllegalArgumentException("Serializer for " + actualClass.t() + " can't be registered as a subclass for polymorphic serialization because its kind " + kind + " is not concrete. To work with multiple hierarchies, register it as a base class.");
        }
        if (!this.useArrayPolymorphism && this.isDiscriminatorRequired) {
            if (kotlin.jvm.internal.p.d(kind, AbstractC4960m.b.f37294a) || kotlin.jvm.internal.p.d(kind, AbstractC4960m.c.f37295a) || (kind instanceof AbstractC4952e) || (kind instanceof AbstractC4959l.b)) {
                throw new IllegalArgumentException("Serializer for " + actualClass.t() + " of kind " + kind + " cannot be serialized polymorphically with class discriminator.");
            }
        }
    }
}
