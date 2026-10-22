package kotlinx.serialization.modules;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import v5.c;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a8\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\n\b\u0001\u0010\u0004\u0018\u0001*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0007H\u0086\u0088\u0004\u001a8\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\n\b\u0001\u0010\u0004\u0018\u0001*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\tH\u0086\u0088\u0004\u001a*\u0010\n\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\n\b\u0001\u0010\u0004\u0018\u0001*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0087\u0088\u0004¨\u0006\u000b"}, d2 = {"subclass", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Base", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "T", "Lkotlinx/serialization/modules/PolymorphicModuleBuilder;", "serializer", "Lkotlinx/serialization/KSerializer;", "clazz", "Lkotlin/reflect/KClass;", "subclassesOfSealed", "kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PolymorphicModuleBuilderKt {
    public static final /* synthetic */ <Base, T extends Base> void subclass(PolymorphicModuleBuilder<? super Base> polymorphicModuleBuilder, KSerializer<T> serializer) {
        p.e(polymorphicModuleBuilder, "<this>");
        p.e(serializer, "serializer");
        p.i();
        throw null;
    }

    @ExperimentalSerializationApi
    public static final /* synthetic */ <Base, T extends Base> void subclassesOfSealed(PolymorphicModuleBuilder<? super Base> polymorphicModuleBuilder) {
        p.e(polymorphicModuleBuilder, "<this>");
        p.i();
        throw null;
    }

    public static final /* synthetic */ <Base, T extends Base> void subclass(PolymorphicModuleBuilder<? super Base> polymorphicModuleBuilder, c clazz) {
        p.e(polymorphicModuleBuilder, "<this>");
        p.e(clazz, "clazz");
        p.i();
        throw null;
    }
}
