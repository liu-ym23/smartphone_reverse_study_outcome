package k4;

import android.util.Log;
import com.stepos.ability.mcpserver.security.KeyValidation;
import com.stepos.ability.mcpserver.security.KeyValidator;
import com.stepos.ability.mcpserver.security.KeyVerifier;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes3.dex */
public final class i implements KeyValidator {

    /* renamed from: a, reason: collision with root package name */
    public final n f4803a;
    public final S7.a b;
    public final KeyVerifier c;

    public i(n registry, S7.a aVar, KeyVerifier verifier) {
        kotlin.jvm.internal.k.f(registry, "registry");
        kotlin.jvm.internal.k.f(verifier, "verifier");
        this.f4803a = registry;
        this.b = aVar;
        this.c = verifier;
    }

    @Override // com.stepos.ability.mcpserver.security.KeyValidator
    public final KeyValidation validate(String key) throws NoSuchAlgorithmException {
        c cVar;
        kotlin.jvm.internal.k.f(key, "key");
        n nVar = this.f4803a;
        nVar.getClass();
        String strB = n.b(key);
        synchronized (nVar.b) {
            m mVar = (m) nVar.d.get(strB);
            cVar = mVar != null ? mVar.f4807a : null;
        }
        c cVar2 = cVar == null ? (c) this.b.invoke() : cVar;
        if (cVar2 == null) {
            Log.e("BoundIdentityKeyValidator", "no bound identity and self identity unresolved");
            return p.f4810a;
        }
        if (cVar == null) {
            Log.i("BoundIdentityKeyValidator", "no handshake binding for this key, verify carries SELF identity (" + cVar2.f4797a + "); SDK app should re-handshake (restart it)");
        }
        return this.c.verify(key, cVar2);
    }
}
