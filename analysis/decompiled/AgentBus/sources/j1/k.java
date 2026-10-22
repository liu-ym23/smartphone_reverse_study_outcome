package j1;

import android.content.ClipboardManager;
import android.content.Context;

/* loaded from: classes.dex */
public final class k implements c1 {

    /* renamed from: a, reason: collision with root package name */
    public final ClipboardManager f5213a;

    public k(Context context) {
        Object systemService = context.getSystemService("clipboard");
        q7.k.c(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        this.f5213a = (ClipboardManager) systemService;
    }
}
