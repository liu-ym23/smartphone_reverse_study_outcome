package com.stepos.ability.commoninternal;

import B7.a;
import D7.q;
import D7.v;
import N9.j;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.Signature;
import androidx.appfunctions.internal.AppSearchAppFunctionReader;
import androidx.compose.ui.text.d;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.AbstractC1607a;
import j9.t;
import java.lang.reflect.Field;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tJ\u0019\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\tH\u0002¨\u0006\u0017"}, d2 = {"Lcom/stepos/ability/commoninternal/AppInfoUtils;", "", AppAgent.CONSTRUCT, "()V", "getAppInfo", "Lcom/stepos/ability/commoninternal/AppInfoUtils$AppInfo;", "context", "Landroid/content/Context;", "targetPackageName", "", "calcSignatureSha256", "signatures", "", "Landroid/content/pm/Signature;", "([Landroid/content/pm/Signature;)Ljava/lang/String;", "isSystemApp", "", "applicationInfo", "Landroid/content/pm/ApplicationInfo;", "isSelfDevelopApp", "packageName", "ApplicationInfoHidden", "AppInfo", "commonInternal_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AppInfoUtils {
    public static final AppInfoUtils INSTANCE = new AppInfoUtils();

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003JQ\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0015¨\u0006#"}, d2 = {"Lcom/stepos/ability/commoninternal/AppInfoUtils$AppInfo;", "", "packageName", "", "signatureHash", "versionName", "versionCode", "", "appName", "isSystemApp", "", "isSelfDevelopApp", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ZZ)V", "getPackageName", "()Ljava/lang/String;", "getSignatureHash", "getVersionName", "getVersionCode", "()J", "getAppName", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "commonInternal_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AppInfo {
        private final String appName;
        private final boolean isSelfDevelopApp;
        private final boolean isSystemApp;
        private final String packageName;
        private final String signatureHash;
        private final long versionCode;
        private final String versionName;

        public AppInfo(String packageName, String signatureHash, String str, long j5, String appName, boolean z10, boolean z11) {
            k.f(packageName, "packageName");
            k.f(signatureHash, "signatureHash");
            k.f(appName, "appName");
            this.packageName = packageName;
            this.signatureHash = signatureHash;
            this.versionName = str;
            this.versionCode = j5;
            this.appName = appName;
            this.isSystemApp = z10;
            this.isSelfDevelopApp = z11;
        }

        public static /* synthetic */ AppInfo copy$default(AppInfo appInfo, String str, String str2, String str3, long j5, String str4, boolean z10, boolean z11, int i, Object obj) {
            if ((i & 1) != 0) {
                str = appInfo.packageName;
            }
            if ((i & 2) != 0) {
                str2 = appInfo.signatureHash;
            }
            if ((i & 4) != 0) {
                str3 = appInfo.versionName;
            }
            if ((i & 8) != 0) {
                j5 = appInfo.versionCode;
            }
            if ((i & 16) != 0) {
                str4 = appInfo.appName;
            }
            if ((i & 32) != 0) {
                z10 = appInfo.isSystemApp;
            }
            if ((i & 64) != 0) {
                z11 = appInfo.isSelfDevelopApp;
            }
            boolean z12 = z11;
            String str5 = str4;
            long j6 = j5;
            String str6 = str3;
            return appInfo.copy(str, str2, str6, j6, str5, z10, z12);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPackageName() {
            return this.packageName;
        }

        /* renamed from: component2, reason: from getter */
        public final String getSignatureHash() {
            return this.signatureHash;
        }

        /* renamed from: component3, reason: from getter */
        public final String getVersionName() {
            return this.versionName;
        }

        /* renamed from: component4, reason: from getter */
        public final long getVersionCode() {
            return this.versionCode;
        }

        /* renamed from: component5, reason: from getter */
        public final String getAppName() {
            return this.appName;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsSystemApp() {
            return this.isSystemApp;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsSelfDevelopApp() {
            return this.isSelfDevelopApp;
        }

        public final AppInfo copy(String packageName, String signatureHash, String versionName, long versionCode, String appName, boolean isSystemApp, boolean isSelfDevelopApp) {
            k.f(packageName, "packageName");
            k.f(signatureHash, "signatureHash");
            k.f(appName, "appName");
            return new AppInfo(packageName, signatureHash, versionName, versionCode, appName, isSystemApp, isSelfDevelopApp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AppInfo)) {
                return false;
            }
            AppInfo appInfo = (AppInfo) other;
            return k.b(this.packageName, appInfo.packageName) && k.b(this.signatureHash, appInfo.signatureHash) && k.b(this.versionName, appInfo.versionName) && this.versionCode == appInfo.versionCode && k.b(this.appName, appInfo.appName) && this.isSystemApp == appInfo.isSystemApp && this.isSelfDevelopApp == appInfo.isSelfDevelopApp;
        }

        public final String getAppName() {
            return this.appName;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public final String getSignatureHash() {
            return this.signatureHash;
        }

        public final long getVersionCode() {
            return this.versionCode;
        }

        public final String getVersionName() {
            return this.versionName;
        }

        public int hashCode() {
            int iC = a.c(this.packageName.hashCode() * 31, 31, this.signatureHash);
            String str = this.versionName;
            return Boolean.hashCode(this.isSelfDevelopApp) + androidx.appfunctions.metadata.a.d(a.c(androidx.appfunctions.metadata.a.c((iC + (str == null ? 0 : str.hashCode())) * 31, 31, this.versionCode), 31, this.appName), 31, this.isSystemApp);
        }

        public final boolean isSelfDevelopApp() {
            return this.isSelfDevelopApp;
        }

        public final boolean isSystemApp() {
            return this.isSystemApp;
        }

        public String toString() {
            String str = this.packageName;
            String str2 = this.signatureHash;
            String str3 = this.versionName;
            long j5 = this.versionCode;
            String str4 = this.appName;
            boolean z10 = this.isSystemApp;
            boolean z11 = this.isSelfDevelopApp;
            StringBuilder sbW = a.w("AppInfo(packageName=", str, ", signatureHash=", str2, ", versionName=");
            a.y(j5, str3, ", versionCode=", sbW);
            sbW.append(", appName=");
            sbW.append(str4);
            sbW.append(", isSystemApp=");
            sbW.append(z10);
            sbW.append(", isSelfDevelopApp=");
            sbW.append(z11);
            sbW.append(")");
            return sbW.toString();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stepos/ability/commoninternal/AppInfoUtils$ApplicationInfoHidden;", "", AppAgent.CONSTRUCT, "()V", "privateFlagsField", "Ljava/lang/reflect/Field;", "privateFlagPrivileged", "", "isPrivilegedApp", "", "applicationInfo", "Landroid/content/pm/ApplicationInfo;", "commonInternal_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ApplicationInfoHidden {
        public static final ApplicationInfoHidden INSTANCE = new ApplicationInfoHidden();
        private static final int privateFlagPrivileged;

        @SuppressLint({"DiscouragedPrivateApi"})
        private static final Field privateFlagsField;

        static {
            Field declaredField;
            int i;
            try {
                declaredField = ApplicationInfo.class.getDeclaredField("privateFlags");
                declaredField.setAccessible(true);
            } catch (ReflectiveOperationException unused) {
                declaredField = null;
            }
            privateFlagsField = declaredField;
            try {
                i = ApplicationInfo.class.getField("PRIVATE_FLAG_PRIVILEGED").getInt(null);
            } catch (ReflectiveOperationException unused2) {
                i = 8;
            }
            privateFlagPrivileged = i;
        }

        private ApplicationInfoHidden() {
        }

        public final boolean isPrivilegedApp(ApplicationInfo applicationInfo) {
            k.f(applicationInfo, "applicationInfo");
            Field field = privateFlagsField;
            if (field == null) {
                return false;
            }
            return (field.getInt(applicationInfo) & privateFlagPrivileged) != 0;
        }
    }

    private AppInfoUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence calcSignatureSha256$lambda$1(Signature it) {
        k.f(it, "it");
        HashUtils hashUtils = HashUtils.INSTANCE;
        byte[] byteArray = it.toByteArray();
        k.e(byteArray, "toByteArray(...)");
        return hashUtils.bytesToHex(byteArray);
    }

    public static /* synthetic */ AppInfo getAppInfo$default(AppInfoUtils appInfoUtils, Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return appInfoUtils.getAppInfo(context, str);
    }

    private final boolean isSelfDevelopApp(Context context, String packageName) {
        if (context.getPackageManager().checkSignatures(packageName, AppSearchAppFunctionReader.SYSTEM_PACKAGE_NAME) != 0) {
            return t.e0(packageName, "com.stepos.", false);
        }
        return true;
    }

    private final boolean isSystemApp(ApplicationInfo applicationInfo) {
        int i = applicationInfo.flags;
        return ((i & 1) == 0 && (i & 128) == 0 && !ApplicationInfoHidden.INSTANCE.isPrivilegedApp(applicationInfo)) ? false : true;
    }

    public final String calcSignatureSha256(Signature[] signatures) {
        k.f(signatures, "signatures");
        String strI0 = v.I0(q.D0(signatures, new Comparator() { // from class: com.stepos.ability.commoninternal.AppInfoUtils$calcSignatureSha256$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t9, T t10) {
                return j.m(Integer.valueOf(((Signature) t9).hashCode()), Integer.valueOf(((Signature) t10).hashCode()));
            }
        }), "", null, null, new d(12), 30);
        HashUtils hashUtils = HashUtils.INSTANCE;
        byte[] bytes = strI0.getBytes(AbstractC1607a.f4778a);
        k.e(bytes, "getBytes(...)");
        return hashUtils.sha256(bytes);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0060 A[Catch: Exception -> 0x0083, TryCatch #0 {Exception -> 0x0083, blocks: (B:10:0x001c, B:12:0x0026, B:14:0x002c, B:16:0x0032, B:19:0x0036, B:22:0x003f, B:24:0x0045, B:26:0x004b, B:28:0x0051, B:35:0x006a, B:37:0x0073, B:40:0x007b, B:34:0x0060), top: B:43:0x001c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ability.commoninternal.AppInfoUtils.AppInfo getAppInfo(android.content.Context r12, java.lang.String r13) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            r11 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.k.f(r12, r0)
            android.content.pm.PackageManager r0 = r12.getPackageManager()
            if (r13 == 0) goto L14
            boolean r1 = j9.m.s0(r13)
            if (r1 == 0) goto L12
            goto L14
        L12:
            r2 = r13
            goto L19
        L14:
            java.lang.String r13 = r12.getPackageName()
            goto L12
        L19:
            r13 = 134217728(0x8000000, float:3.85186E-34)
            r10 = 0
            android.content.pm.PackageInfo r13 = r0.getPackageInfo(r2, r13)     // Catch: java.lang.Exception -> L83
            android.content.pm.ApplicationInfo r1 = r13.applicationInfo     // Catch: java.lang.Exception -> L83
            android.content.pm.SigningInfo r3 = r13.signingInfo     // Catch: java.lang.Exception -> L83
            if (r3 == 0) goto L2b
            android.content.pm.Signature[] r3 = r3.getApkContentsSigners()     // Catch: java.lang.Exception -> L83
            goto L2c
        L2b:
            r3 = r10
        L2c:
            long r5 = r13.getLongVersionCode()     // Catch: java.lang.Exception -> L83
            if (r3 == 0) goto L3b
            int r4 = r3.length     // Catch: java.lang.Exception -> L83
            if (r4 != 0) goto L36
            goto L3b
        L36:
            java.lang.String r3 = r11.calcSignatureSha256(r3)     // Catch: java.lang.Exception -> L83
            goto L3d
        L3b:
            java.lang.String r3 = ""
        L3d:
            if (r1 == 0) goto L60
            java.lang.CharSequence r0 = r1.loadLabel(r0)     // Catch: java.lang.Exception -> L83
            if (r0 == 0) goto L60
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L83
            if (r0 == 0) goto L60
            boolean r4 = j9.m.s0(r0)     // Catch: java.lang.Exception -> L83
            if (r4 != 0) goto L5a
            java.lang.String r4 = "null"
            boolean r4 = r0.equals(r4)     // Catch: java.lang.Exception -> L83
            if (r4 != 0) goto L5a
            goto L5b
        L5a:
            r0 = r10
        L5b:
            if (r0 == 0) goto L60
        L5d:
            r7 = r0
            r0 = r1
            goto L6a
        L60:
            kotlin.jvm.internal.k.c(r2)     // Catch: java.lang.Exception -> L83
            r0 = 46
            java.lang.String r0 = j9.m.I0(r0, r2, r2)     // Catch: java.lang.Exception -> L83
            goto L5d
        L6a:
            com.stepos.ability.commoninternal.AppInfoUtils$AppInfo r1 = new com.stepos.ability.commoninternal.AppInfoUtils$AppInfo     // Catch: java.lang.Exception -> L83
            kotlin.jvm.internal.k.c(r2)     // Catch: java.lang.Exception -> L83
            java.lang.String r4 = r13.versionName     // Catch: java.lang.Exception -> L83
            if (r0 == 0) goto L79
            boolean r13 = r11.isSystemApp(r0)     // Catch: java.lang.Exception -> L83
        L77:
            r8 = r13
            goto L7b
        L79:
            r13 = 0
            goto L77
        L7b:
            boolean r9 = r11.isSelfDevelopApp(r12, r2)     // Catch: java.lang.Exception -> L83
            r1.<init>(r2, r3, r4, r5, r7, r8, r9)     // Catch: java.lang.Exception -> L83
            return r1
        L83:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.commoninternal.AppInfoUtils.getAppInfo(android.content.Context, java.lang.String):com.stepos.ability.commoninternal.AppInfoUtils$AppInfo");
    }
}
