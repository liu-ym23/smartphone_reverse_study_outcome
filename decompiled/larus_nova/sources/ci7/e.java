package ci7;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes22.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f23861a = 0;

    static {
    }

    public static void a(Context r100) {
        mi7.g.a(r100).getClass();
        if (mi7.g.f514094a != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty("KEY_LAST_CB_D_EEROR_TTCB_CONTENT") == true) goto L9;
        SharedPreferences.Editor r101 = mi7.g.f514094a.edit();
        r101.remove("KEY_LAST_CB_D_EEROR_TTCB_CONTENT");
        r101.apply();
        return;
    }
}
