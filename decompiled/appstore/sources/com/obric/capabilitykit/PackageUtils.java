package com.obric.capabilitykit;

import android.annotation.TargetApi;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.common.primitives.UnsignedBytes;
import com.obric.capabilitykit.entity.EntityContextHolder;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0003J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/capabilitykit/PackageUtils;", "", "()V", "NOVA_PKG_NAME", "", "NOVA_SIGNATURE", "TAG", "checkSignature", "", "callingPkg", "checkSignatureApi28Plus", "checkSignatureLegacy", "isMemoryPackageName", "pkgName", "isPrivilegedApp", "packageName", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PackageUtils {

    @NotNull
    public static final PackageUtils INSTANCE = null;

    @NotNull
    public static final String NOVA_PKG_NAME = "com.larus.nova";

    @NotNull
    private static final String NOVA_SIGNATURE = "ff04b47ec9dd20b79f758af67a184926db00ac55cfd2a01e03fba9a1dca9de2a";

    @NotNull
    private static final String TAG = "PersonalContextPackageUtils";

    static {
        INSTANCE = new PackageUtils();
    }

    private PackageUtils() {
    }

    @TargetApi(28)
    private final boolean checkSignatureApi28Plus(String r11) {
        PackageInfo r12 = EntityContextHolder.INSTANCE.getContext().getPackageManager().getPackageInfo(r11, 134217728);     // Catch: Exception -> L19
        kotlin.jvm.internal.q.f(r12, "EntityContextHolder.cont…FICATES\n                )");     // Catch: Exception -> L19
        SigningInfo r13 = r12.signingInfo;     // Catch: Exception -> L19
        if (r13 != null) goto L6;
        return false;
    L6:
        Signature[] r14 = r13.getApkContentsSigners();     // Catch: Exception -> L19
        if (r14 != null) goto L9;
    L28:
        Log.d(TAG, "signatures is null or empty");     // Catch: Exception -> L19
        return false;
    L9:
        if (r14.length == 0) goto L28;
        int r10 = r14.length;     // Catch: Exception -> L19
        int r15 = 0;
    L12:
        if (r15 >= r10) goto L26;
        byte[] r16 = MessageDigest.getInstance("SHA-256").digest(r14[r15].toByteArray());     // Catch: Exception -> L19
        StringBuilder r17 = new StringBuilder();     // Catch: Exception -> L19
        kotlin.jvm.internal.q.f(r16, "hashBytes");     // Catch: Exception -> L19
        int r18 = r16.length;     // Catch: Exception -> L19
        int r19 = 0;
    L15:
        if (r19 >= r18) goto L23;
        String r20 = Integer.toHexString(r16[r19] & UnsignedBytes.MAX_VALUE);     // Catch: Exception -> L19
        if (r20.length() != 1) goto L21;
        r17.append('0');     // Catch: Exception -> L19
    L21:
        r17.append(r20);     // Catch: Exception -> L19
        r19 = r19 + 1;     // Catch: Exception -> L19
        goto L15
    L23:
        if (kotlin.jvm.internal.q.b(r17.toString(), NOVA_SIGNATURE) == true) goto L24;
        r15 = r15 + 1;     // Catch: Exception -> L19
        goto L12
    L24:
        return true;
    L26:
        Log.d(TAG, "signatures not match");     // Catch: Exception -> L19
        return false;
    L19:
        e = move-exception;
        Log.e(TAG, "Error checking signature in api 28+ mode", e);
        return false;
    }

    private final boolean checkSignatureLegacy(String r11) {
        PackageInfo r12 = EntityContextHolder.INSTANCE.getContext().getPackageManager().getPackageInfo(r11, 64);     // Catch: Exception -> L16
        kotlin.jvm.internal.q.f(r12, "EntityContextHolder.cont…NATURES\n                )");     // Catch: Exception -> L16
        Signature[] r13 = r12.signatures;     // Catch: Exception -> L16
        if (r13 != null) goto L6;
    L23:
        Log.d(TAG, "signatures is null or empty");     // Catch: Exception -> L16
        return false;
    L6:
        if (r13.length == 0) goto L23;
        int r10 = r13.length;     // Catch: Exception -> L16
        int r14 = 0;
    L9:
        if (r14 >= r10) goto L26;
        byte[] r15 = MessageDigest.getInstance("SHA-256").digest(r13[r14].toByteArray());     // Catch: Exception -> L16
        StringBuilder r16 = new StringBuilder();     // Catch: Exception -> L16
        kotlin.jvm.internal.q.f(r15, "hashBytes");     // Catch: Exception -> L16
        int r17 = r15.length;     // Catch: Exception -> L16
        int r18 = 0;
    L12:
        if (r18 >= r17) goto L20;
        String r19 = Integer.toHexString(r15[r18] & UnsignedBytes.MAX_VALUE);     // Catch: Exception -> L16
        if (r19.length() != 1) goto L18;
        r16.append('0');     // Catch: Exception -> L16
    L18:
        r16.append(r19);     // Catch: Exception -> L16
        r18 = r18 + 1;     // Catch: Exception -> L16
        goto L12
    L20:
        if (kotlin.jvm.internal.q.b(r16.toString(), NOVA_SIGNATURE) == true) goto L21;
        r14 = r14 + 1;     // Catch: Exception -> L16
        goto L9
    L21:
        return true;
    L26:
        Log.d(TAG, "signatures not match");
        return false;
    L16:
        e = move-exception;
        Log.e(TAG, "Error checking signature in legacy mode", e);
        goto L26
    }

    public final boolean checkSignature(@Nullable String r10) {
        if (r10 != null) goto L5;
    L21:
        Log.d(TAG, "callingPkg is null");
        return false;
    L5:
        if (r10.length() == 0) goto L21;
        if (kotlin.jvm.internal.q.b(r10, EntityContextHolder.INSTANCE.getPackageName()) == false) goto L12;
        return true;
    L12:
        if (isMemoryPackageName(r10) == true) goto L16;
        Log.d(TAG, "callingPkg is not com.larus.nova");
        return false;
    L16:
        if (isPrivilegedApp(r10) == true) goto L20;
        Log.w(TAG, "callingPkg " + r10 + " is not privilege app");
        return false;
    L20:
        return checkSignatureApi28Plus(r10);
    }

    public final boolean isMemoryPackageName(@NotNull String r10) {
        kotlin.jvm.internal.q.g(r10, "pkgName");
        return kotlin.jvm.internal.q.b(NOVA_PKG_NAME, r10);
    }

    public final boolean isPrivilegedApp(@NotNull String r10) {
        kotlin.jvm.internal.q.g(r10, "packageName");
        ApplicationInfo r11 = EntityContextHolder.INSTANCE.getContext().getPackageManager().getApplicationInfo(r10, 0);     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L9
        kotlin.jvm.internal.q.f(r11, "pm.getApplicationInfo(packageName, 0)");     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L9
        Field r12 = ApplicationInfo.class.getDeclaredField("privateFlags");     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L9
        r12.setAccessible(true);     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L9
    L5:
        if ((r12.getInt(r11) & 8) != 0) goto L17;
        return false;
    L17:
        return true;
    L9:
        e = e;
        StringBuilder r13 = new StringBuilder();
    L12:
        r13.append("Error checking privileged app: ");
        r13.append(r10);
        Log.e(TAG, r13.toString(), e);
        return false;
    L7:
        e = th;
        r13 = new StringBuilder();
        goto L12
    }
}
