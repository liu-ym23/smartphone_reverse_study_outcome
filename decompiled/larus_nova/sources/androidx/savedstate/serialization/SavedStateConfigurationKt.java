package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.savedstate.serialization.serializers.MutableStateFlowSerializer;
import androidx.savedstate.serialization.serializers.SavedStateSerializer;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.z0;
import kotlinx.serialization.modules.d;
import kotlinx.serialization.modules.e;
import kotlinx.serialization.modules.i;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0007\"\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"SavedStateConfiguration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "from", "builderAction", "Lkotlin/Function1;", "Landroidx/savedstate/serialization/SavedStateConfiguration$Builder;", "", "Lkotlin/ExtensionFunctionType;", "DEFAULT_SERIALIZERS_MODULE", "Lkotlinx/serialization/modules/SerializersModule;", "savedstate"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SavedStateConfigurationKt {
    private static final d DEFAULT_SERIALIZERS_MODULE = null;

    public static final SavedStateConfiguration SavedStateConfiguration(Function1<? super SavedStateConfiguration.Builder, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "builderAction");
        return SavedStateConfiguration$default(null, r100, 1, null);
    }

    public static /* synthetic */ juc.d a(List r100) {
        return DEFAULT_SERIALIZERS_MODULE$lambda$1$lambda$0(r100);
    }

    static {
        e r100 = new e();
        SavedStateSerializer r101 = SavedStateSerializer.INSTANCE;
        r100.b(Reflection.getOrCreateKotlinClass(Bundle.class), r101);
        r100.a(Reflection.getOrCreateKotlinClass(z0.class), new b());
        kotlinx.serialization.modules.c r102 = r100.f();
        d r103 = SavedStateConfig_androidKt.getDefaultSerializersModuleOnPlatform();
        kotlinx.serialization.modules.c r104 = i.f505488a;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        Intrinsics.checkNotNullParameter(r103, "other");
        e r105 = new e();
        Intrinsics.checkNotNullParameter(r102, EventConstant.Key.MODULE);
        r102.a(r105);
        Intrinsics.checkNotNullParameter(r103, EventConstant.Key.MODULE);
        r103.a(r105);
        DEFAULT_SERIALIZERS_MODULE = r105.f();
    }

    public static final /* synthetic */ d access$getDEFAULT_SERIALIZERS_MODULE$p() {
        return DEFAULT_SERIALIZERS_MODULE;
    }

    private static final juc.d DEFAULT_SERIALIZERS_MODULE$lambda$1$lambda$0(List r100) {
        Intrinsics.checkNotNullParameter(r100, "elementSerializers");
        return new MutableStateFlowSerializer((juc.d) CollectionsKt.first(r100));
    }

    public static final SavedStateConfiguration SavedStateConfiguration(SavedStateConfiguration r100, Function1<? super SavedStateConfiguration.Builder, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, "builderAction");
        SavedStateConfiguration.Builder r102 = new SavedStateConfiguration.Builder(r100);
        r101.invoke(r102);
        return r102.build$savedstate();
    }

    public static /* synthetic */ SavedStateConfiguration SavedStateConfiguration$default(SavedStateConfiguration r100, Function1 r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = SavedStateConfiguration.DEFAULT;
    L6:
        return SavedStateConfiguration(r100, r101);
    }
}
