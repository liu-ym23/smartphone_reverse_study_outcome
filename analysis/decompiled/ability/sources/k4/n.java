package k4;

import com.stepos.ability.mcpserver.model.McpServerConfig;
import com.stepos.ability.mcpserver.security.CallerIdentityRegistry$bindings$1;
import j9.AbstractC1607a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;

/* loaded from: classes3.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final int f4808a;
    public final Object b;
    public final HashMap c;
    public final CallerIdentityRegistry$bindings$1 d;

    public n(McpServerConfig config) {
        kotlin.jvm.internal.k.f(config, "config");
        this.f4808a = config.getHandshakeBindingsPerUid();
        this.b = new Object();
        this.c = new HashMap();
        this.d = new CallerIdentityRegistry$bindings$1(this);
    }

    public static String b(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes(AbstractC1607a.f4778a);
        kotlin.jvm.internal.k.e(bytes, "getBytes(...)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        kotlin.jvm.internal.k.e(bArrDigest, "digest(...)");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int i = 0;
        for (byte b : bArrDigest) {
            i++;
            if (i > 1) {
                sb.append((CharSequence) "");
            }
            sb.append((CharSequence) String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1)));
        }
        sb.append((CharSequence) "");
        return sb.toString();
    }

    public final void a(int i, String str) {
        Integer numValueOf = Integer.valueOf(i);
        HashMap map = this.c;
        LinkedHashSet linkedHashSet = (LinkedHashSet) map.get(numValueOf);
        if (linkedHashSet == null) {
            return;
        }
        linkedHashSet.remove(str);
        if (linkedHashSet.isEmpty()) {
            map.remove(Integer.valueOf(i));
        }
    }
}
