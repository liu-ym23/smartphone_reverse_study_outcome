package com.obric.capabilitykit;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import com.GlobalProxyLancet;
import com.obric.capabilitykit.entity.EntityContextHolder;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0003J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/capabilitykit/PackageUtils;", "", "()V", "NOVA_PKG_NAME", "", "NOVA_SIGNATURE", "TAG", "checkSignature", "", "callingPkg", "checkSignatureApi28Plus", "checkSignatureLegacy", "isMemoryPackageName", "pkgName", "isPrivilegedApp", "packageName", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PackageUtils {
    public static final PackageUtils INSTANCE = null;
    public static final String NOVA_PKG_NAME = "com.larus.nova";
    private static final String NOVA_SIGNATURE = "ff04b47ec9dd20b79f758af67a184926db00ac55cfd2a01e03fba9a1dca9de2a";
    private static final String TAG = "PersonalContextPackageUtils";

    static {
        INSTANCE = new PackageUtils();
    }

    private PackageUtils() {
    }

    private final boolean checkSignatureApi28Plus(String r11) {
        PackageInfo r12 = EntityContextHolder.INSTANCE.getContext().getPackageManager().getPackageInfo(r11, 134217728);     // Catch: Exception -> L30
        Intrinsics.checkNotNullExpressionValue(r12, "EntityContextHolder.cont…FICATES\n                )");     // Catch: Exception -> L30
        SigningInfo r13 = r12.signingInfo;     // Catch: Exception -> L30
        if (r13 != null) goto L6;
        return false;
    L6:
        Signature[] r14 = r13.getApkContentsSigners();     // Catch: Exception -> L30
        if (r14 != null) goto L9;
    L28:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "signatures is null or empty");     // Catch: Exception -> L30
        return false;
    L9:
        if (r14.length != 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == true) goto L28;
        int r2 = r14.length;     // Catch: Exception -> L30
        int r3 = 0;
    L15:
        if (r3 >= r2) goto L26;
        byte[] r4 = MessageDigest.getInstance("SHA-256").digest(r14[r3].toByteArray());     // Catch: Exception -> L30
        StringBuilder r5 = new StringBuilder();     // Catch: Exception -> L30
        Intrinsics.checkNotNullExpressionValue(r4, "hashBytes");     // Catch: Exception -> L30
        int r6 = r4.length;     // Catch: Exception -> L30
        int r7 = 0;
    L17:
        if (r7 >= r6) goto L23;
        String r8 = Integer.toHexString(r4[r7] & 255);     // Catch: Exception -> L30
        if (r8.length() != 1) goto L21;
        r5.append('0');     // Catch: Exception -> L30
    L21:
        r5.append(r8);     // Catch: Exception -> L30
        r7 = r7 + 1;     // Catch: Exception -> L30
        goto L17
    L23:
        if (Intrinsics.areEqual(r5.toString(), NOVA_SIGNATURE) == true) goto L24;
        r3 = r3 + 1;     // Catch: Exception -> L30
        goto L15
    L24:
        return true;
    L26:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "signatures not match");     // Catch: Exception -> L30
        return false;
    L11:
        r1 = false;
    L30:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Error checking signature in api 28+ mode", e);
        return false;
    }

    private final boolean checkSignatureLegacy(String r11) {
        PackageInfo r12 = EntityContextHolder.INSTANCE.getContext().getPackageManager().getPackageInfo(r11, 64);     // Catch: Exception -> L25
        Intrinsics.checkNotNullExpressionValue(r12, "EntityContextHolder.cont…NATURES\n                )");     // Catch: Exception -> L25
        Signature[] r13 = r12.signatures;     // Catch: Exception -> L25
        if (r13 != null) goto L6;
    L23:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "signatures is null or empty");     // Catch: Exception -> L25
        return false;
    L6:
        if (r13.length != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L23;
        int r2 = r13.length;     // Catch: Exception -> L25
        int r3 = 0;
    L12:
        if (r3 >= r2) goto L27;
        byte[] r4 = MessageDigest.getInstance("SHA-256").digest(r13[r3].toByteArray());     // Catch: Exception -> L25
        StringBuilder r5 = new StringBuilder();     // Catch: Exception -> L25
        Intrinsics.checkNotNullExpressionValue(r4, "hashBytes");     // Catch: Exception -> L25
        int r6 = r4.length;     // Catch: Exception -> L25
        int r7 = 0;
    L14:
        if (r7 >= r6) goto L20;
        String r8 = Integer.toHexString(r4[r7] & 255);     // Catch: Exception -> L25
        if (r8.length() != 1) goto L18;
        r5.append('0');     // Catch: Exception -> L25
    L18:
        r5.append(r8);     // Catch: Exception -> L25
        r7 = r7 + 1;     // Catch: Exception -> L25
        goto L14
    L20:
        if (Intrinsics.areEqual(r5.toString(), NOVA_SIGNATURE) == true) goto L21;
        r3 = r3 + 1;     // Catch: Exception -> L25
        goto L12
    L21:
        return true;
    L27:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "signatures not match");
        return false;
    L8:
        r1 = false;
    L25:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Error checking signature in legacy mode", e);
        goto L27
    }

    public final boolean checkSignature(String r5) {
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L14;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "callingPkg is null");
        return false;
    L14:
        if (Intrinsics.areEqual(r5, EntityContextHolder.INSTANCE.getPackageName()) == false) goto L17;
        return true;
    L17:
        if (isMemoryPackageName(r5) == true) goto L21;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "callingPkg is not com.larus.nova");
        return false;
    L21:
        if (isPrivilegedApp(r5) == true) goto L25;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "callingPkg " + r5 + " is not privilege app");
        return false;
    L25:
        return checkSignatureApi28Plus(r5);
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    public final boolean isMemoryPackageName(String r1) {
        Intrinsics.checkNotNullParameter(r1, "pkgName");
        return Intrinsics.areEqual("com.larus.nova", r1);
    }

    public final boolean isPrivilegedApp(String r6) {
        Intrinsics.checkNotNullParameter(r6, "packageName");
        ApplicationInfo r2 = EntityContextHolder.INSTANCE.getContext().getPackageManager().getApplicationInfo(r6, 0);     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L9
        Intrinsics.checkNotNullExpressionValue(r2, "pm.getApplicationInfo(packageName, 0)");     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L9
        Field r3 = ApplicationInfo.class.getDeclaredField("privateFlags");     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L9
        r3.setAccessible(true);     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L9
    L5:
        if ((r3.getInt(r2) & 8) != 0) goto L16;
        return false;
    L16:
        return true;
    L9:
        e = e;
        StringBuilder r4 = new StringBuilder("Error checking privileged app: ");
    L11:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, r4.append(r6).toString(), e);
        return false;
    L7:
        e = th;
        r4 = new StringBuilder("Error checking privileged app: ");
        goto L11
    }
}
