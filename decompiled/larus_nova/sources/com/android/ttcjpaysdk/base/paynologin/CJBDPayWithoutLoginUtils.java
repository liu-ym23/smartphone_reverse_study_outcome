package com.android.ttcjpaysdk.base.paynologin;

import android.net.Uri;
import com.android.ttcjpaysdk.base.CJOuterHostInfo;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import xc4.f;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR$\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R(\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/base/paynologin/CJBDPayWithoutLoginUtils;", "", "Lxc4/f;", "userInfo", "", "onPayWithoutLoginStart", "onPayWithoutLoginStop", "", "originSchema", "appendParams", "TAG", "Ljava/lang/String;", "", "<set-?>", "isPayWithoutLogin", "Z", "()Z", "hostUserInfo", "Lxc4/f;", "getHostUserInfo", "()Lxc4/f;", "<init>", "()V", "base-context_release"}, k = 1, mv = {1, 6, 0})
public final class CJBDPayWithoutLoginUtils {
    public static final CJBDPayWithoutLoginUtils INSTANCE = null;
    private static final String TAG = "CJBDPayWithoutLoginUtils";
    private static f hostUserInfo;
    private static boolean isPayWithoutLogin;

    static {
        INSTANCE = new CJBDPayWithoutLoginUtils();
    }

    private CJBDPayWithoutLoginUtils() {
    }

    public final void onPayWithoutLoginStop() {
        CJLogger.d(TAG, "onPayWithoutLoginStop");
        isPayWithoutLogin = false;
        hostUserInfo = null;
        Map<String, Object> r100 = CJOuterHostInfo.INSTANCE.getCJContext().f202260f;
        r100.remove("free_login");
        r100.remove("free_login_user");
    }

    public final f getHostUserInfo() {
        return hostUserInfo;
    }

    public final boolean isPayWithoutLogin() {
        return isPayWithoutLogin;
    }

    public final String appendParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "originSchema");
        Uri r101 = UriProtector.parse(r100);     // Catch: Exception -> L25
        f r102 = hostUserInfo;     // Catch: Exception -> L25
        if (r102 == null) goto L30;
        String r103 = r102.f563210c;     // Catch: Exception -> L25
        if (r103 != null) goto L8;
        return r100;
    L8:
        if ((!StringsKt.isBlank(r103)) == true) goto L10;
    L12:
        boolean r104 = false;
    L13:
        String r105 = null;
        if (r104 == true) goto L17;
        r103 = null;
    L17:
        if (r103 != null) goto L19;
        return r100;
    L19:
        if ((!UriProtector.getQueryParameterNames(r101).contains("no_login_pay_uid")) == false) goto L21;
        r105 = r103;
    L21:
        if (r105 == null) goto L33;
        String r106 = r101.buildUpon().appendQueryParameter("no_login_pay_uid", r105).build().toString();     // Catch: Exception -> L25
        if (r106 != null) goto L35;
        return r100;
    L35:
        return r106;
    L33:
        return r100;
    L10:
        if (isPayWithoutLogin == false) goto L12;
        r104 = true;
        goto L13
    L30:
        return r100;
    L25:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJBDPayWithoutLoginUtils#appendParams", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJBDPayWithoutLoginUtils#appendParams", e);
        return r100;
    }

    public final void onPayWithoutLoginStart(f r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfo");
        CJLogger.d(TAG, "onPayWithoutLoginStart: " + r100.f563210c);
        isPayWithoutLogin = true;
        hostUserInfo = r100;
        Map<String, Object> r101 = CJOuterHostInfo.INSTANCE.getCJContext().f202260f;
        r101.put("free_login", "1");
        r101.put("free_login_user", r100.f563208a);
    }
}
