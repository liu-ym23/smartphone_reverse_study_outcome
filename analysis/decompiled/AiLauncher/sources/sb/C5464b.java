package sb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.z;
import kotlinx.serialization.KSerializer;
import lb.InterfaceC4883a;
import lb.m;
import p9.InterfaceC5074l;
import sb.AbstractC5463a;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001Bß\u0001\u0012\u0016\u0010\u0005\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012*\u0010\u0007\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00020\u0002\u0012.\u0010\u000b\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u001c\u0012\u001a\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\t0\bj\u0006\u0012\u0002\b\u0003`\n0\u0002\u0012&\u0010\r\u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00020\u0002\u00122\u0010\u0010\u001a.\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012 \u0012\u001e\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u000e0\bj\u0006\u0012\u0002\b\u0003`\u000f0\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J9\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t\"\b\b\u0000\u0010\u0016*\u00020\u00152\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00032\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ;\u0010\u001c\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e\"\b\b\u0000\u0010\u0016*\u00020\u00152\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJA\u0010!\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\"\b\b\u0000\u0010\u0016*\u00020\u00152\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0010\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b&\u0010'R$\u0010\u0005\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010(R8\u0010\u0007\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b!\u0010(R<\u0010\u000b\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u001c\u0012\u001a\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\t0\bj\u0006\u0012\u0002\b\u0003`\n0\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010(R4\u0010\r\u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010(R@\u0010\u0010\u001a.\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012 \u0012\u001e\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u000e0\bj\u0006\u0012\u0002\b\u0003`\u000f0\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010(R\u001a\u0010\u0012\u001a\u00020\u00118\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b*\u0010,¨\u0006-"}, d2 = {"Lsb/b;", "Lsb/c;", "", "Lw9/d;", "Lsb/a;", "class2ContextualFactory", "Lkotlinx/serialization/KSerializer;", "polyBase2Serializers", "Lkotlin/Function1;", "Llb/m;", "Lkotlinx/serialization/modules/PolymorphicSerializerProvider;", "polyBase2DefaultSerializerProvider", "", "polyBase2NamedSerializers", "Llb/a;", "Lkotlinx/serialization/modules/PolymorphicDeserializerProvider;", "polyBase2DefaultDeserializerProvider", "", "hasInterfaceContextualSerializers", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Z)V", "", ExifInterface.GPS_DIRECTION_TRUE, "baseClass", UxipConstants.f30680s, "f", "(Lw9/d;Ljava/lang/Object;)Llb/m;", "serializedClassName", "e", "(Lw9/d;Ljava/lang/String;)Llb/a;", "kClass", "", "typeArgumentsSerializers", Const.INTENT_KEY_PKGNAME, "(Lw9/d;Ljava/util/List;)Lkotlinx/serialization/KSerializer;", "Lsb/f;", "collector", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lsb/f;)V", "Ljava/util/Map;", "c", Const.INTENT_KEY_UMID, "Z", "()Z", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: sb.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5464b extends AbstractC5465c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Map<InterfaceC5745d<?>, AbstractC5463a> class2ContextualFactory;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Map<InterfaceC5745d<?>, Map<InterfaceC5745d<?>, KSerializer<?>>> polyBase2Serializers;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Map<InterfaceC5745d<?>, InterfaceC5074l<?, m<?>>> polyBase2DefaultSerializerProvider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Map<InterfaceC5745d<?>, Map<String, KSerializer<?>>> polyBase2NamedSerializers;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Map<InterfaceC5745d<?>, InterfaceC5074l<String, InterfaceC4883a<?>>> polyBase2DefaultDeserializerProvider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final boolean hasInterfaceContextualSerializers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C5464b(Map<InterfaceC5745d<?>, ? extends AbstractC5463a> class2ContextualFactory, Map<InterfaceC5745d<?>, ? extends Map<InterfaceC5745d<?>, ? extends KSerializer<?>>> polyBase2Serializers, Map<InterfaceC5745d<?>, ? extends InterfaceC5074l<?, ? extends m<?>>> polyBase2DefaultSerializerProvider, Map<InterfaceC5745d<?>, ? extends Map<String, ? extends KSerializer<?>>> polyBase2NamedSerializers, Map<InterfaceC5745d<?>, ? extends InterfaceC5074l<? super String, ? extends InterfaceC4883a<?>>> polyBase2DefaultDeserializerProvider, boolean z10) {
        super(null);
        p.i(class2ContextualFactory, "class2ContextualFactory");
        p.i(polyBase2Serializers, "polyBase2Serializers");
        p.i(polyBase2DefaultSerializerProvider, "polyBase2DefaultSerializerProvider");
        p.i(polyBase2NamedSerializers, "polyBase2NamedSerializers");
        p.i(polyBase2DefaultDeserializerProvider, "polyBase2DefaultDeserializerProvider");
        this.class2ContextualFactory = class2ContextualFactory;
        this.polyBase2Serializers = polyBase2Serializers;
        this.polyBase2DefaultSerializerProvider = polyBase2DefaultSerializerProvider;
        this.polyBase2NamedSerializers = polyBase2NamedSerializers;
        this.polyBase2DefaultDeserializerProvider = polyBase2DefaultDeserializerProvider;
        this.hasInterfaceContextualSerializers = z10;
    }

    @Override // sb.AbstractC5465c
    public void a(f collector) {
        p.i(collector, "collector");
        for (Map.Entry<InterfaceC5745d<?>, AbstractC5463a> entry : this.class2ContextualFactory.entrySet()) {
            InterfaceC5745d<?> key = entry.getKey();
            AbstractC5463a value = entry.getValue();
            if (value instanceof AbstractC5463a.C0520a) {
                p.g(key, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                KSerializer<?> kSerializerB = ((AbstractC5463a.C0520a) value).b();
                p.g(kSerializerB, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                collector.f(key, kSerializerB);
            } else {
                if (!(value instanceof AbstractC5463a.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                collector.b(key, ((AbstractC5463a.b) value).b());
            }
        }
        for (Map.Entry<InterfaceC5745d<?>, Map<InterfaceC5745d<?>, KSerializer<?>>> entry2 : this.polyBase2Serializers.entrySet()) {
            InterfaceC5745d<?> key2 = entry2.getKey();
            for (Map.Entry<InterfaceC5745d<?>, KSerializer<?>> entry3 : entry2.getValue().entrySet()) {
                InterfaceC5745d<?> key3 = entry3.getKey();
                KSerializer<?> value2 = entry3.getValue();
                p.g(key2, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                p.g(key3, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                p.g(value2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                collector.d(key2, key3, value2);
            }
        }
        for (Map.Entry<InterfaceC5745d<?>, InterfaceC5074l<?, m<?>>> entry4 : this.polyBase2DefaultSerializerProvider.entrySet()) {
            InterfaceC5745d<?> key4 = entry4.getKey();
            InterfaceC5074l<?, m<?>> value3 = entry4.getValue();
            p.g(key4, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            p.g(value3, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"value\")] kotlin.Any, kotlinx.serialization.SerializationStrategy<kotlin.Any>?>");
            collector.a(key4, (InterfaceC5074l) z.g(value3, 1));
        }
        for (Map.Entry<InterfaceC5745d<?>, InterfaceC5074l<String, InterfaceC4883a<?>>> entry5 : this.polyBase2DefaultDeserializerProvider.entrySet()) {
            InterfaceC5745d<?> key5 = entry5.getKey();
            InterfaceC5074l<String, InterfaceC4883a<?>> value4 = entry5.getValue();
            p.g(key5, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            p.g(value4, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"className\")] kotlin.String?, kotlinx.serialization.DeserializationStrategy<kotlin.Any>?>");
            collector.c(key5, (InterfaceC5074l) z.g(value4, 1));
        }
    }

    @Override // sb.AbstractC5465c
    public <T> KSerializer<T> b(InterfaceC5745d<T> kClass, List<? extends KSerializer<?>> typeArgumentsSerializers) {
        p.i(kClass, "kClass");
        p.i(typeArgumentsSerializers, "typeArgumentsSerializers");
        AbstractC5463a abstractC5463a = this.class2ContextualFactory.get(kClass);
        KSerializer<T> kSerializer = abstractC5463a != null ? (KSerializer<T>) abstractC5463a.a(typeArgumentsSerializers) : null;
        if (kSerializer instanceof KSerializer) {
            return kSerializer;
        }
        return null;
    }

    @Override // sb.AbstractC5465c
    /* renamed from: d, reason: from getter */
    public boolean getHasInterfaceContextualSerializers() {
        return this.hasInterfaceContextualSerializers;
    }

    @Override // sb.AbstractC5465c
    public <T> InterfaceC4883a<T> e(InterfaceC5745d<? super T> baseClass, String serializedClassName) {
        p.i(baseClass, "baseClass");
        Map<String, KSerializer<?>> map = this.polyBase2NamedSerializers.get(baseClass);
        KSerializer<?> kSerializer = map != null ? map.get(serializedClassName) : null;
        if (!(kSerializer instanceof KSerializer)) {
            kSerializer = null;
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        InterfaceC5074l<String, InterfaceC4883a<?>> interfaceC5074l = this.polyBase2DefaultDeserializerProvider.get(baseClass);
        InterfaceC5074l<String, InterfaceC4883a<?>> interfaceC5074l2 = z.o(interfaceC5074l, 1) ? interfaceC5074l : null;
        if (interfaceC5074l2 != null) {
            return (InterfaceC4883a) interfaceC5074l2.invoke(serializedClassName);
        }
        return null;
    }

    @Override // sb.AbstractC5465c
    public <T> m<T> f(InterfaceC5745d<? super T> baseClass, T value) {
        p.i(baseClass, "baseClass");
        p.i(value, "value");
        if (!baseClass.k(value)) {
            return null;
        }
        Map<InterfaceC5745d<?>, KSerializer<?>> map = this.polyBase2Serializers.get(baseClass);
        KSerializer<?> kSerializer = map != null ? map.get(t.b(value.getClass())) : null;
        KSerializer<?> kSerializer2 = kSerializer instanceof m ? kSerializer : null;
        if (kSerializer2 != null) {
            return kSerializer2;
        }
        InterfaceC5074l<?, m<?>> interfaceC5074l = this.polyBase2DefaultSerializerProvider.get(baseClass);
        InterfaceC5074l<?, m<?>> interfaceC5074l2 = z.o(interfaceC5074l, 1) ? interfaceC5074l : null;
        if (interfaceC5074l2 != null) {
            return (m) interfaceC5074l2.invoke(value);
        }
        return null;
    }
}
