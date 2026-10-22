package v;

import android.accounts.AccountManager;
import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: v.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2053a extends A8.b {
    public final ConcurrentHashMap b = new ConcurrentHashMap();

    public C2053a(Context context) {
        AccountManager.get(context);
    }

    @Override // A8.b
    public final void J0(String str, String str2) {
        this.b.put(str, str2);
    }

    @Override // A8.b
    public final String M0(String str) {
        return (String) this.b.get(str);
    }
}
