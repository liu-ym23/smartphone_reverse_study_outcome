package bnb;

import android.content.Context;
import com.ss.android.lark.officesdk.api.IUserManager;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.officesdk.internal.OfficeSDKProvider;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements tza.a {
    public a() {
    }

    @Override // tza.a
    public final void R0(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "chatID");
        IUserManager r102 = OfficeSDKProvider.INSTANCE.getInstance().getUserManager();
        if (r102 == null) goto L10;
        OfficeSDKUserApi r103 = r102.getUserApi();
        if (r103 == null) goto L11;
        p3c.b r104 = (p3c.b) r103.getService(p3c.b.class);
        if (r104 == null) goto L12;
        r104.l3(r100, r101);
        return;
    L12:
        return;
    L11:
        return;
    }
}
