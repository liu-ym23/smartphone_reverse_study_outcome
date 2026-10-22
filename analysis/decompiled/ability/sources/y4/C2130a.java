package y4;

import android.content.Context;
import android.util.Log;
import com.stepos.ability.api.ability.security.ISecurityManager;
import kotlin.jvm.internal.k;

/* renamed from: y4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2130a implements ISecurityManager {
    @Override // com.stepos.ability.commoninternal.ability.IComponent
    public final void destroy() {
        Log.i("SecurityManagerImpl", "SecurityManagerImpl destroy.");
    }

    @Override // com.stepos.ability.api.ability.security.ISecurityManager
    public final boolean isCallerAllowed(String caller, String pkgSign, long j5) {
        k.f(caller, "caller");
        k.f(pkgSign, "pkgSign");
        if (pkgSign.length() <= 0 || pkgSign.equals("B4F3B9F05A77ADCAFBD555BF38F4EFBDA2CE58DE000BF15DAD3568A836655E8F")) {
            return true;
        }
        Log.e("SecurityManagerImpl", androidx.appfunctions.metadata.a.m("isCallerAllowed failed. caller sign is not valid. caller: ", caller, ", callerSign: ", pkgSign, ", pkgSign: B4F3B9F05A77ADCAFBD555BF38F4EFBDA2CE58DE000BF15DAD3568A836655E8F, abilityId: <redacted>"));
        return false;
    }

    @Override // com.stepos.ability.commoninternal.ability.IComponent
    public final void setup(Context context) {
        k.f(context, "context");
        Log.i("SecurityManagerImpl", "SecurityManagerImpl setup.");
    }
}
