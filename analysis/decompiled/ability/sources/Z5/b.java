package Z5;

import android.content.Context;
import f6.AbstractC1436a;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f1595a = new b();
    public static volatile com.stepos.taskrobot.ability.a b;

    public final com.stepos.taskrobot.ability.a a(Context context) {
        com.stepos.taskrobot.ability.a aVar;
        com.stepos.taskrobot.ability.a aVar2 = b;
        if (aVar2 != null) {
            return aVar2;
        }
        synchronized (this) {
            aVar = b;
            if (aVar == null) {
                AbstractC1436a.d("ability", "MdiAbilityProvider: creating the process-wide MdiAbility instance", true);
                Context applicationContext = context.getApplicationContext();
                k.e(applicationContext, "getApplicationContext(...)");
                aVar = new com.stepos.taskrobot.ability.a(applicationContext);
                b = aVar;
            }
        }
        return aVar;
    }
}
