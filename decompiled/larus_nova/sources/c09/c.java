package c09;

import android.os.Bundle;
import com.bytedance.sdk.account.platform.AuthorizeAdapter;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import n38.l;

/* JADX INFO: loaded from: classes27.dex */
public final class c extends AuthorizeAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f21968a;

    public c(l r100) {
        this.f21968a = r100;
        super("weixin");
    }

    @Override // com.bytedance.sdk.account.platform.AuthorizeAdapter
    public final void onAuthError(AuthorizeErrorResponse r100) {
        l r101 = this.f21968a;
        if (r100 == null) goto L6;
        String r102 = r100.platformErrorMsg;
        if (r102 == null) goto L6;
    L7:
        r101.b(r102, null);
        return;
    L6:
        r102 = "";
        goto L7
    }

    @Override // com.bytedance.sdk.account.platform.AuthorizeAdapter
    public final void onAuthSuccess(Bundle r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getString("auth_code");
    L6:
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        this.f21968a.b("token is empty", null);
        return;
    L14:
        this.f21968a.a(r101, null);
        return;
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
        goto L12
    L5:
        r101 = null;
        goto L6
    }
}
