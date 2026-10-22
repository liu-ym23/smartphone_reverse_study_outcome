package k4;

import com.stepos.ability.mcpserver.security.KeyValidation;
import com.stepos.ability.mcpserver.security.KeyVerifier;

/* renamed from: k4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1624a implements KeyVerifier {
    @Override // com.stepos.ability.mcpserver.security.KeyVerifier
    public final KeyValidation verify(String key, c identity) {
        kotlin.jvm.internal.k.f(key, "key");
        kotlin.jvm.internal.k.f(identity, "identity");
        return new q(null);
    }
}
