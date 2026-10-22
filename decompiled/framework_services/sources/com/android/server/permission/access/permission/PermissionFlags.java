package com.android.server.permission.access.permission;

import com.android.server.permission.access.util.IntExtensionsKt;
import com.android.server.permission.jarjar.kotlin.UInt;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import com.android.server.permission.jarjar.kotlin.text.UStringsKt;
import java.util.Locale;

/* JADX INFO: compiled from: PermissionFlags.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PermissionFlags {
    public static final PermissionFlags INSTANCE = null;

    static {
        INSTANCE = new PermissionFlags();
    }

    private PermissionFlags() {
    }

    public final boolean isPermissionGranted(int flags) {
        if (IntExtensionsKt.hasBits(flags, 1) == false) goto L6;
        return true;
    L6:
        if (IntExtensionsKt.hasBits(flags, 2) == false) goto L9;
        return false;
    L9:
        if (IntExtensionsKt.hasBits(flags, 4) == false) goto L12;
        return true;
    L12:
        if (IntExtensionsKt.hasBits(flags, 1024) == false) goto L14;
    L21:
        return true;
    L14:
        if (IntExtensionsKt.hasBits(flags, 2048) == true) goto L21;
        if (IntExtensionsKt.hasBits(flags, 262144) == false) goto L20;
        return false;
    L20:
        return IntExtensionsKt.hasBits(flags, 16);
    }

    public final boolean isAppOpGranted(int flags) {
        if (isPermissionGranted(flags) == true) goto L6;
        return false;
    L6:
        if (IntExtensionsKt.hasAnyBit(flags, 786432) == false) goto L9;
        return false;
    L9:
        if (IntExtensionsKt.hasBits(flags, 1048576) == false) goto L11;
        return false;
    L11:
        return true;
    }

    public final int toApiFlags(int flags) {
        int apiFlags = 0;
        if (IntExtensionsKt.hasBits(flags, 32) == false) goto L5;
        apiFlags = 0 | 1;
    L5:
        int r1 = 64;
        if (IntExtensionsKt.hasBits(flags, 64) == false) goto L9;
        apiFlags = apiFlags | 2;
    L9:
        if (IntExtensionsKt.hasBits(flags, 128) == false) goto L12;
        apiFlags = apiFlags | 4;
    L12:
        if (IntExtensionsKt.hasBits(flags, 256) == false) goto L15;
        apiFlags = apiFlags | 16;
    L15:
        if (IntExtensionsKt.hasBits(flags, 512) == false) goto L18;
        apiFlags = apiFlags | 32;
    L18:
        if (IntExtensionsKt.hasBits(flags, 4096) == false) goto L25;
        if (IntExtensionsKt.hasBits(flags, 1024) == true) goto L23;
        r1 = 128;
    L23:
        apiFlags = r1 | apiFlags;
    L25:
        if (IntExtensionsKt.hasBits(flags, 8192) == false) goto L28;
        apiFlags = apiFlags | 256;
    L28:
        if (IntExtensionsKt.hasBits(flags, 16384) == false) goto L31;
        apiFlags = apiFlags | 512;
    L31:
        if (IntExtensionsKt.hasBits(flags, 32768) == false) goto L34;
        apiFlags = apiFlags | 2048;
    L34:
        if (IntExtensionsKt.hasBits(flags, 65536) == false) goto L37;
        apiFlags = apiFlags | 4096;
    L37:
        if (IntExtensionsKt.hasBits(flags, 131072) == false) goto L40;
        apiFlags = apiFlags | 8192;
    L40:
        if (IntExtensionsKt.hasBits(flags, 262144) == false) goto L42;
    L43:
        apiFlags = apiFlags | 16384;
    L45:
        if (IntExtensionsKt.hasBits(flags, 8) == false) goto L48;
        apiFlags = apiFlags | 32768;
    L48:
        if (IntExtensionsKt.hasBits(flags, 1048576) == false) goto L51;
        apiFlags = apiFlags | 8;
    L51:
        if (IntExtensionsKt.hasBits(flags, 2097152) == false) goto L54;
        apiFlags = apiFlags | 65536;
    L54:
        if (IntExtensionsKt.hasBits(flags, 4194304) == false) goto L57;
        apiFlags = apiFlags | 131072;
    L57:
        if (IntExtensionsKt.hasBits(flags, 8388608) == true) goto L59;
        return apiFlags;
    L59:
        return apiFlags | 524288;
    L42:
        if (IntExtensionsKt.hasBits(flags, 524288) == false) goto L45;
        goto L43
    }

    public final int updateRuntimePermissionGranted(int flags, boolean isGranted) {
        if (isGranted == false) goto L5;
        return flags | 16;
    L5:
        return IntExtensionsKt.andInv(flags, 16);
    }

    public final int updateFlags(Permission permission, int flags, int apiFlagMask, int apiFlagValues) {
        int oldApiFlags = toApiFlags(flags);
        int newApiFlags = IntExtensionsKt.andInv(oldApiFlags, apiFlagMask) | (apiFlagValues & apiFlagMask);
        return fromApiFlags(newApiFlags, permission, flags);
    }

    private final int fromApiFlags(int apiFlags, Permission permission, int oldFlags) {
        int flags = 0 | (oldFlags & 1);
        int flags2 = (flags | (oldFlags & 2)) | (oldFlags & 4);
        if (IntExtensionsKt.hasBits(apiFlags, 32768) == false) goto L5;
        flags2 = flags2 | 8;
    L5:
        int flags3 = flags2 | (oldFlags & 16);
        if (IntExtensionsKt.hasBits(apiFlags, 1) == false) goto L9;
        flags3 = flags3 | 32;
    L9:
        if (IntExtensionsKt.hasBits(apiFlags, 2) == false) goto L12;
        flags3 = flags3 | 64;
    L12:
        if (IntExtensionsKt.hasBits(apiFlags, 4) == false) goto L15;
        flags3 = flags3 | 128;
    L15:
        if (IntExtensionsKt.hasBits(apiFlags, 16) == false) goto L18;
        flags3 = flags3 | 256;
    L18:
        if (IntExtensionsKt.hasBits(apiFlags, 32) == false) goto L20;
        flags3 = flags3 | 512;
    L20:
        int flags4 = (flags3 | (oldFlags & 1024)) | (oldFlags & 2048);
        if (IntExtensionsKt.hasBits(apiFlags, 64) == false) goto L23;
    L24:
        flags4 = flags4 | 4096;
    L26:
        if (IntExtensionsKt.hasBits(apiFlags, 256) == false) goto L29;
        flags4 = flags4 | 8192;
    L29:
        if (IntExtensionsKt.hasBits(apiFlags, 512) == false) goto L32;
        flags4 = flags4 | 16384;
    L32:
        if (IntExtensionsKt.hasBits(apiFlags, 2048) == false) goto L35;
        flags4 = flags4 | 32768;
    L35:
        if (IntExtensionsKt.hasBits(apiFlags, 4096) == false) goto L38;
        flags4 = flags4 | 65536;
    L38:
        if (IntExtensionsKt.hasBits(apiFlags, 8192) == false) goto L41;
        flags4 = flags4 | 131072;
    L41:
        if (IntExtensionsKt.hasBits(apiFlags, 16384) == false) goto L49;
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().flags, 4) == false) goto L46;
        flags4 = flags4 | 262144;
    L46:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().flags, 8) == false) goto L49;
        flags4 = flags4 | 524288;
    L49:
        if (IntExtensionsKt.hasBits(apiFlags, 8) == false) goto L52;
        flags4 = flags4 | 1048576;
    L52:
        if (IntExtensionsKt.hasBits(apiFlags, 65536) == false) goto L55;
        flags4 = flags4 | 2097152;
    L55:
        if (IntExtensionsKt.hasBits(apiFlags, 131072) == false) goto L58;
        flags4 = flags4 | 4194304;
    L58:
        if (IntExtensionsKt.hasBits(apiFlags, 524288) == true) goto L60;
        return flags4;
    L60:
        return flags4 | 8388608;
    L23:
        if (IntExtensionsKt.hasBits(apiFlags, 128) == false) goto L26;
        goto L24
    }

    public final String flagToString(int flag) {
        switch(flag) {
            case 1: goto L27;
            case 2: goto L26;
            case 4: goto L25;
            case 8: goto L24;
            case 16: goto L23;
            case 32: goto L22;
            case 64: goto L21;
            case 128: goto L20;
            case 256: goto L19;
            case 512: goto L18;
            case 1024: goto L17;
            case 2048: goto L16;
            case 4096: goto L15;
            case 8192: goto L14;
            case 16384: goto L13;
            case 32768: goto L12;
            case 65536: goto L11;
            case 131072: goto L10;
            case 262144: goto L9;
            case 524288: goto L8;
            case 1048576: goto L7;
            case 2097152: goto L6;
            case 4194304: goto L5;
            case 8388608: goto L4;
            default: goto L3;
        };
    L3:
        String r0 = UStringsKt.m6566toStringV7xB4Y4(UInt.m6565constructorimpl(flag), 16).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r0, "toUpperCase(...)");
        return "0x" + r0;
    L4:
        return "USER_SELECTED";
    L5:
        return "HIBERNATION";
    L6:
        return "ONE_TIME";
    L7:
        return "APP_OP_REVOKED";
    L8:
        return "SOFT_RESTRICTED";
    L9:
        return "RESTRICTION_REVOKED";
    L10:
        return "UPGRADE_EXEMPT";
    L11:
        return "SYSTEM_EXEMPT";
    L12:
        return "INSTALLER_EXEMPT";
    L13:
        return "USER_SENSITIVE_WHEN_REVOKED";
    L14:
        return "USER_SENSITIVE_WHEN_GRANTED";
    L15:
        return "IMPLICIT";
    L16:
        return "IMPLICIT_GRANTED";
    L17:
        return "LEGACY_GRANTED";
    L18:
        return "PREGRANT";
    L19:
        return "SYSTEM_FIXED";
    L20:
        return "POLICY_FIXED";
    L21:
        return "USER_FIXED";
    L22:
        return "USER_SET";
    L23:
        return "RUNTIME_GRANTED";
    L24:
        return "ROLE";
    L25:
        return "PROTECTION_GRANTED";
    L26:
        return "INSTALL_REVOKED";
    L27:
        return "INSTALL_GRANTED";
    }

    public final String toString(int flags) {
        int flags$iv = flags;
        StringBuilder $this$flagsToString_u24lambda_u240$iv = new StringBuilder();
        $this$flagsToString_u24lambda_u240$iv.append("[");
    L3:
        if (flags$iv == 0) goto L7;
        int flag$iv = 1 << Integer.numberOfTrailingZeros(flags$iv);
        flags$iv = IntExtensionsKt.andInv(flags$iv, flag$iv);
        $this$flagsToString_u24lambda_u240$iv.append(INSTANCE.flagToString(flag$iv));
        if (flags$iv == 0) goto L3;
        $this$flagsToString_u24lambda_u240$iv.append('|');
        goto L3
    L7:
        $this$flagsToString_u24lambda_u240$iv.append("]");
        return $this$flagsToString_u24lambda_u240$iv.toString();
    }
}
