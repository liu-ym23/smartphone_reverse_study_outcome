package R4;

import com.stepos.core.deepbinder.IAIEngineDeepBinderService;
import e5.InterfaceC1423a;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class a implements IAIEngineDeepBinderService {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1151a = new a();

    @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
    public final Boolean checkModelReady(String id) {
        k.f(id, "id");
        return null;
    }

    @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
    public final boolean containsAbility(String id) {
        k.f(id, "id");
        return false;
    }

    @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
    public final List getAbilities() {
        return EmptyList.f4893a;
    }

    @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
    public final String getAbilityProperty(String id, String name) {
        k.f(id, "id");
        k.f(name, "name");
        return null;
    }

    @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
    public final int getAbilityState(String id) {
        k.f(id, "id");
        return -2;
    }

    @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
    public final boolean setAbilityProperty(String id, String name, String value) {
        k.f(id, "id");
        k.f(name, "name");
        k.f(value, "value");
        return false;
    }

    @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
    public final void showCTADialog(InterfaceC1423a interfaceC1423a) {
        k.f(null, "callback");
    }
}
