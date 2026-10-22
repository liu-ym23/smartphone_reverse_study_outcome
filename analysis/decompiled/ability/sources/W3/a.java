package W3;

import android.content.Context;
import com.stepos.ability.manager.AbilityManager;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1485a;
    public final /* synthetic */ AbilityManager b;
    public final /* synthetic */ Context c;

    public /* synthetic */ a(AbilityManager abilityManager, Context context, int i) {
        this.f1485a = i;
        this.b = abilityManager;
        this.c = context;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f1485a) {
            case 0:
                return AbilityManager.setup$lambda$0(this.b, this.c);
            default:
                return AbilityManager.setup$lambda$1(this.b, this.c);
        }
    }
}
