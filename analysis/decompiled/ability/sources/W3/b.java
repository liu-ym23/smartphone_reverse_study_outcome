package W3;

import com.stepos.ability.manager.AbilityManager;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1486a;
    public final /* synthetic */ AbilityManager b;

    public /* synthetic */ b(AbilityManager abilityManager, int i) {
        this.f1486a = i;
        this.b = abilityManager;
    }

    @Override // S7.a
    public final Object invoke() {
        int i = this.f1486a;
        AbilityManager abilityManager = this.b;
        switch (i) {
            case 0:
                return AbilityManager.setup$lambda$2(abilityManager);
            case 1:
                return AbilityManager.setup$lambda$3(abilityManager);
            default:
                return AbilityManager.api_delegate$lambda$0(abilityManager);
        }
    }
}
