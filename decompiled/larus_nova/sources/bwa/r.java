package bwa;

import android.text.TextUtils;
import com.larksuite.framework.utils.j0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes34.dex */
@UserScope
public final class r implements awa.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Inject
    public String f21268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Inject
    public awa.b f21269b;

    @Override // awa.d
    public final String a() {
        Log.i("UserSettingManager", "getSettingConfig called");
        return this.f21269b.q0(this.f21268a, "biz_domain_config", true);
    }

    @Inject
    public r(awa.b r100) {
        Log.i("UserSettingManager", "UserSettingManager start");
        this.f21269b = r100;
        Log.i("UserSettingManager", "UserSettingManager finish");
        if (TextUtils.isEmpty(this.f21268a) == false) goto L5;
        Log.w("UserSettingManager", "wtf, invalid uid within user-state-framework.");
        return;
    L5:
        Log.i("UserSettingManager", "uid info:" + j0.a(this.f21268a));
    }

    @Override // awa.d
    public final <T> T get(Class<T> r100) {
        Log.i("UserSettingManager", "get called");
        return (T) this.f21269b.y0(this.f21268a, r100);
    }
}
