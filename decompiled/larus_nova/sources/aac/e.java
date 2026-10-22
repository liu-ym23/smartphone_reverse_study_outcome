package aac;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.usersetting.base.UserSetting;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f.b f2383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserSetting f2384b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f2383a.a(this.f2384b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public e(f.b r100, UserSetting r101) {
        this.f2383a = r100;
        this.f2384b = r101;
    }
}
