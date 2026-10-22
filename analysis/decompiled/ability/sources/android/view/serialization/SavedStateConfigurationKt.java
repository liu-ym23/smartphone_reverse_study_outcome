package android.view.serialization;

import E9.d;
import E9.e;
import E9.g;
import android.os.Bundle;
import android.view.serialization.SavedStateConfiguration;
import android.view.serialization.serializers.SavedStateSerializer;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlinx.serialization.modules.a;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\"\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/savedstate/serialization/SavedStateConfiguration;", TypedValues.TransitionType.S_FROM, "Lkotlin/Function1;", "Landroidx/savedstate/serialization/SavedStateConfiguration$Builder;", "LC7/r;", "builderAction", "SavedStateConfiguration", "(Landroidx/savedstate/serialization/SavedStateConfiguration;LS7/k;)Landroidx/savedstate/serialization/SavedStateConfiguration;", "LE9/e;", "DEFAULT_SERIALIZERS_MODULE", "LE9/e;", "savedstate_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SavedStateConfigurationKt {
    private static final e DEFAULT_SERIALIZERS_MODULE;

    static {
        a aVar = new a();
        aVar.o(m.f4928a.b(Bundle.class), SavedStateSerializer.INSTANCE);
        d dVarC = aVar.c();
        e other = SavedStateConfig_androidKt.getDefaultSerializersModuleOnPlatform();
        d dVar = g.f499a;
        k.f(other, "other");
        a aVar2 = new a();
        dVarC.a(aVar2);
        other.a(aVar2);
        DEFAULT_SERIALIZERS_MODULE = aVar2.c();
    }

    public static final SavedStateConfiguration SavedStateConfiguration(S7.k builderAction) {
        k.f(builderAction, "builderAction");
        return SavedStateConfiguration$default(null, builderAction, 1, null);
    }

    public static /* synthetic */ SavedStateConfiguration SavedStateConfiguration$default(SavedStateConfiguration savedStateConfiguration, S7.k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return SavedStateConfiguration(savedStateConfiguration, kVar);
    }

    public static final SavedStateConfiguration SavedStateConfiguration(SavedStateConfiguration from, S7.k builderAction) {
        k.f(from, "from");
        k.f(builderAction, "builderAction");
        SavedStateConfiguration.Builder builder = new SavedStateConfiguration.Builder(from);
        builderAction.invoke(builder);
        return builder.build$savedstate_release();
    }
}
