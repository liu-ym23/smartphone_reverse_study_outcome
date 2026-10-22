package com.smt.obric.appstore.ktx;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.AppPermissionActivity;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.n;
import kotlin.collections.u;
import kotlin.jvm.internal.q;
import kotlin.text.o;

/* JADX INFO: loaded from: classes4.dex */
public abstract class PackageInfoKTxKt {
    public static final Set a(PackageInfo r10) {
        q.g(r10, "<this>");
        Signature[] r11 = r10.signatures;
        SigningInfo r12 = r10.signingInfo;
        if (r12 == null) goto L7;
        r11 = r12.getSigningCertificateHistory();
        if (r12.hasMultipleSigners() == false) goto L7;
        r11 = r12.getApkContentsSigners();
    L7:
        if (r11 != null) goto L10;
        r11 = new Signature[0];
    L10:
        return n.O(r11);
    }

    public static final List b(PackageManager r11, String r12) {
        q.g(r11, "<this>");
        q.g(r12, "packageName");
        PackageInfo r13 = r11.getPackageInfo(r12, 134217728);
        q.d(r13);
        Set r14 = a(r13);
        ArrayList r15 = new ArrayList(u.r(r14, 10));
        Iterator r16 = r14.iterator();
    L4:
        if (r16.hasNext() == false) goto L6;
        r15.add(((Signature) r16.next()).toByteArray());
        goto L4
    L6:
        ArrayList r17 = new ArrayList(u.r(r15, 10));
        Iterator r18 = r15.iterator();
    L8:
        if (r18.hasNext() == false) goto L10;
        byte[] r10 = (byte[]) r18.next();
        byte[] r19 = MessageDigest.getInstance("SHA-256").digest(r10);
        q.d(r19);
        r17.add(n.B(r19, "", null, null, 0, null, PackageInfoKTxKt$getSignaturesFingerprint$1$1.INSTANCE, 30, null));
        goto L8
    L10:
        return r17;
    }

    public static final boolean c(PackageManager r10, String r11) {
        q.g(r10, "<this>");
        q.g(r11, "packageName");
        r10.getPackageInfo(r11, 0);     // Catch: PackageManager.NameNotFoundException -> L6
        return true;
    L6:
        return false;
    }

    public static final boolean d(Context r10, String r11, String r12) {
        q.g(r10, "<this>");
        q.g(r11, AppPermissionActivity.EXTRA_APP_PKG);
        if (r12 != null) goto L5;
    L12:
        j.o("[AppStatus][AppInstaller][InstallStage]: isSignNotMatch fingerprint is null, pkg=" + r11);
        return false;
    L5:
        if (o.r(r12) == true) goto L12;
        PackageManager r13 = r10.getPackageManager();
        q.f(r13, "getPackageManager(...)");
        if (c(r13, r11) == true) goto L10;
        return false;
    L10:
        PackageManager r14 = r10.getPackageManager();
        q.f(r14, "getPackageManager(...)");
        return !b(r14, r11).contains(r12);
    }
}
