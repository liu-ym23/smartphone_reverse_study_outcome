package com.bytedance.android.livesdk.account.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/account/api/AuthScope;", "", "AUDIENCE", "BROADCAST", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AuthScope extends Enum<AuthScope> {
    public static final AuthScope AUDIENCE = null;
    public static final AuthScope BROADCAST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AuthScope[] f103000a = null;

    static {
        AuthScope r100 = new AuthScope("AUDIENCE", 0);
        AUDIENCE = r100;
        AuthScope r101 = new AuthScope("BROADCAST", 1);
        BROADCAST = r101;
        f103000a = new AuthScope[]{r100, r101};
    }

    public static AuthScope valueOf(String r100) {
        return (AuthScope) a.a(AuthScope.class, r100);
    }

    public static AuthScope[] values() {
        return (AuthScope[]) f103000a.clone();
    }

    public AuthScope(String r100, int r101) {
        super(r100, r101);
    }
}
