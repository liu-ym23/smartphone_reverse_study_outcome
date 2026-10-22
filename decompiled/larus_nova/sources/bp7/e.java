package bp7;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f19995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f19996b;

    public final void a() {
        this.f19995a = this.f19996b.getSharedPreferences("sp_yz_settings", 0);
    }

    public e(Context r100, boolean r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        this.f19996b = r100;
        if (r101 == false) goto L9;
        a();
        this.f19995a.getBoolean("allow_network", false);
        this.f19995a.getLong("first_use_time", System.currentTimeMillis());
        return;
    }
}
