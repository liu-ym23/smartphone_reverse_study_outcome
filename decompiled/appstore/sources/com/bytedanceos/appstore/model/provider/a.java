package com.bytedanceos.appstore.model.provider;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import com.bytedanceos.common.privacy.PrivacyUtils;
import com.bytedanceos.common.toolbox.j;
import kotlin.Result;
import kotlin.c;
import kotlin.collections.n;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0125a f9430b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9431a;

    /* JADX INFO: renamed from: com.bytedanceos.appstore.model.provider.a$a, reason: collision with other inner class name */
    public static final class C0125a {
        public /* synthetic */ C0125a(DefaultConstructorMarker r10) {
            this();
        }

        public C0125a() {
        }
    }

    static {
        f9430b = new C0125a(null);
    }

    public a(Context r10) {
        q.g(r10, "context");
        this.f9431a = r10;
    }

    public final Bundle a(String r10, String r11, Bundle r12) {
        q.g(r10, "method");
        String r13 = b();
        if (r12 == null) goto L5;
        int r14 = r12.getInt("client_version", -1);
    L7:
        if (r14 != (-1)) goto L11;
        j.n("AppStoreProvider call client version is -1, caller=" + r13 + ", method=" + r10);
        return null;
    L11:
        if (q.b(r10, "is_privacy_policy_agreed") == false) goto L14;
        boolean r15 = ((Boolean) PrivacyUtils.f9901a.j().getValue()).booleanValue();
        j.n("AppStoreProvider call result, caller=" + r13 + ", method=" + r10 + ", return=" + r15);
        Bundle r16 = new Bundle();
        r16.putBoolean("agreed", r15);
        return r16;
    L14:
        j.n("AppStoreProvider call unknown method, caller=" + r13 + ", method=" + r10);
        return null;
    L5:
        r14 = -1;
        goto L7
    }

    public final String b() {
        Result.a r10 = Result.Companion;     // Catch: Throwable -> L5
        String[] r11 = this.f9431a.getPackageManager().getPackagesForUid(Binder.getCallingUid());     // Catch: Throwable -> L5
        if (r11 != null) goto L7;
        r11 = new String[0];     // Catch: Throwable -> L5
    L7:
        Object r12 = Result.m35constructorimpl((String) n.s(r11));     // Catch: Throwable -> L5
    L10:
        Throwable r13 = Result.m38exceptionOrNullimpl(r12);
        if (r13 == null) goto L14;
        j.n("AppStoreProvider call getCallingPkg error = " + r13);
    L14:
        if (Result.m41isFailureimpl(r12) == false) goto L17;
        r12 = null;
    L17:
        return (String) r12;
    L5:
        th = move-exception;
        Result.a r14 = Result.Companion;
        r12 = Result.m35constructorimpl(c.a(th));
        goto L10
    }
}
