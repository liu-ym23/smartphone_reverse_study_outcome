package com.bytedance.android.livesdk.padutils;

import android.content.Context;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.business.depend.IUserAgreePrivacyPolicyListener;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements IUserAgreePrivacyPolicyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f154213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f154214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f154215c = null;

    public b() {
    }

    static {
        f154215c = new b();
    }

    @Override // com.bytedance.android.livehostapi.business.depend.IUserAgreePrivacyPolicyListener
    public final void onUserAgreePrivacyPolicy() {
        if (f154213a != null) goto L10;
        Context r100 = s1.getContext();
        if (r100 == null) goto L11;
        a r101 = new a(r100, PadOrientationHelper$enableListener$1.INSTANCE);
        f154213a = r101;
        r101.enable();
        return;
    L11:
        return;
    }
}
