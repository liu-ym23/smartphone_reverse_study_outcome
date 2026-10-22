package com.stepos.ailauncher.sla;

import La.C0951a;
import Z8.C1173v;
import Z8.X;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.sla.SlaAtomicDispatcher;
import com.stepos.ame.sdk.SkillStoreKt;
import h8.C4148a;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ%\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ;\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010%¨\u0006'"}, d2 = {"Lcom/stepos/ailauncher/sla/t;", "", "<init>", "()V", "", "function", "", "params", "toolCallId", "", "startedAtMs", "Lcom/stepos/ailauncher/sla/SlaAtomicDispatcher$DispatchResult;", "c", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;J)Lcom/stepos/ailauncher/sla/SlaAtomicDispatcher$DispatchResult;", "Lcom/stepos/ailauncher/sla/t$a;", "f", "(Ljava/util/Map;)Lcom/stepos/ailauncher/sla/t$a;", "Landroid/content/pm/PackageManager;", "pm", "packageName", Const.INTENT_KEY_UMID, "(Landroid/content/pm/PackageManager;Ljava/lang/String;)Lcom/stepos/ailauncher/sla/t$a;", "appName", Const.INTENT_KEY_PKGNAME, "s", "e", "(Ljava/lang/String;)Ljava/lang/String;", "installed", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lcom/stepos/ailauncher/sla/t$a;)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "", "installFunctions", "Ljava/util/Set;", "", "appNameKeys", "Ljava/util/List;", "packageKeys", "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class t {
    private static final String TAG = "SLA";
    public static final t INSTANCE = new t();
    private static final Set<String> installFunctions = X.d("appstore_install_app");
    private static final List<String> appNameKeys = C1173v.p("appName", "app_name", "name");
    private static final List<String> packageKeys = C1173v.p("packageName", "package_name", "pkg");

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/sla/t$a;", "", "", "packageName", "label", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.sla.t$a, reason: from toString */
    public static final /* data */ class Installed {
        private final String label;
        private final String packageName;

        public Installed(String packageName, String label) {
            kotlin.jvm.internal.p.i(packageName, "packageName");
            kotlin.jvm.internal.p.i(label, "label");
            this.packageName = packageName;
            this.label = label;
        }

        /* renamed from: a, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* renamed from: b, reason: from getter */
        public final String getPackageName() {
            return this.packageName;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Installed)) {
                return false;
            }
            Installed installed = (Installed) other;
            return kotlin.jvm.internal.p.d(this.packageName, installed.packageName) && kotlin.jvm.internal.p.d(this.label, installed.label);
        }

        public int hashCode() {
            return (this.packageName.hashCode() * 31) + this.label.hashCode();
        }

        public String toString() {
            return "Installed(packageName=" + this.packageName + ", label=" + this.label + ")";
        }
    }

    public final String a(String function, Map<String, String> params, String toolCallId, Installed installed) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            String str = "「" + installed.getLabel() + "」已安装，无需重复安装";
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SkillStoreKt.SKILL_DOC_TYPE_CONTENT, str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("display_text", str);
            jSONObject2.put("already_installed", true);
            jSONObject2.put("packageName", installed.getPackageName());
            jSONObject2.put("source", "SlaInstalledAppGuard");
            Y8.t tVar = Y8.t.f7040a;
            jSONObject.put("meta", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("taskId", toolCallId);
            jSONObject4.put("name", "SLA: " + function);
            jSONObject4.put("params", new JSONObject(params));
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("tool_call_response", jSONObject.toString());
            jSONObject4.put("bundle", jSONObject5);
            jSONObject3.put("task", jSONObject4);
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("toolCallId", toolCallId);
            jSONArray.put(jSONObject6);
            jSONObject3.put("toolCallEvents", jSONArray);
            objB = Result.b(jSONObject3.toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g("SLA", "[LOCAL][INSTALL_GUARD] buildAlreadyInstalledResultJson failed: " + thE.getMessage(), thE, false, 8, null);
            objB = "{}";
        }
        return (String) objB;
    }

    public final Installed b(PackageManager pm, String appName) throws IOException {
        Object next;
        String strE = e(appName);
        if (strE.length() == 0) {
            return null;
        }
        Intent intentAddCategory = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER");
        kotlin.jvm.internal.p.h(intentAddCategory, "addCategory(...)");
        List<ResolveInfo> listQueryIntentActivities = pm.queryIntentActivities(intentAddCategory, PackageManager.ResolveInfoFlags.of(0L));
        kotlin.jvm.internal.p.h(listQueryIntentActivities, "queryIntentActivities(...)");
        Iterator<T> it = listQueryIntentActivities.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            ResolveInfo resolveInfo = (ResolveInfo) next;
            t tVar = INSTANCE;
            if (kotlin.jvm.internal.p.d(tVar.e(resolveInfo.loadLabel(pm).toString()), strE) || kotlin.jvm.internal.p.d(tVar.e(resolveInfo.activityInfo.applicationInfo.loadLabel(pm).toString()), strE)) {
                break;
            }
        }
        ResolveInfo resolveInfo2 = (ResolveInfo) next;
        if (resolveInfo2 != null) {
            String packageName = resolveInfo2.activityInfo.packageName;
            kotlin.jvm.internal.p.h(packageName, "packageName");
            return new Installed(packageName, resolveInfo2.activityInfo.applicationInfo.loadLabel(pm).toString());
        }
        C4148a.k("SLA", "[LOCAL][INSTALL_GUARD] 应用名未命中已安装应用 appName=" + appName + " launchableCount=" + listQueryIntentActivities.size() + " -> 照常派发", false, 4, null);
        return null;
    }

    public final SlaAtomicDispatcher.DispatchResult c(String function, Map<String, String> params, String toolCallId, long startedAtMs) {
        Installed installedF;
        kotlin.jvm.internal.p.i(function, "function");
        kotlin.jvm.internal.p.i(params, "params");
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        if (!installFunctions.contains(function) || (installedF = f(params)) == null) {
            return null;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - startedAtMs;
        C4148a.k("SLA", "[LOCAL][INSTALL_GUARD] 已安装 -> 拦截派发 function=" + function + " params=" + params + " pkg=" + installedF.getPackageName() + " label=" + installedF.getLabel() + " toolCallId=" + toolCallId + " elapsedMs=" + jElapsedRealtime, false, 4, null);
        return new SlaAtomicDispatcher.DispatchResult(SlaAtomicDispatcher.EXECUTOR_ID, SlaAtomicDispatcher.DispatchResult.Status.SUCCESS, 0, null, a(function, params, toolCallId, installedF), jElapsedRealtime, 12, null);
    }

    public final Installed d(PackageManager pm, String packageName) throws PackageManager.NameNotFoundException {
        try {
            ApplicationInfo applicationInfo = pm.getApplicationInfo(packageName, PackageManager.ApplicationInfoFlags.of(0L));
            kotlin.jvm.internal.p.h(applicationInfo, "getApplicationInfo(...)");
            return new Installed(packageName, applicationInfo.loadLabel(pm).toString());
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public final String e(String s10) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < s10.length(); i10++) {
            char cCharAt = s10.charAt(i10);
            if (!C0951a.c(cCharAt)) {
                sb2.append(cCharAt);
            }
        }
        String lowerCase = sb2.toString().toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007b A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:3:0x0001, B:4:0x0015, B:6:0x001b, B:8:0x0029, B:10:0x0033, B:20:0x0046, B:44:0x00b1, B:23:0x0050, B:24:0x006d, B:25:0x0075, B:27:0x007b, B:29:0x0089, B:31:0x0093, B:40:0x00a3, B:43:0x00ad), top: B:53:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a3 A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:3:0x0001, B:4:0x0015, B:6:0x001b, B:8:0x0029, B:10:0x0033, B:20:0x0046, B:44:0x00b1, B:23:0x0050, B:24:0x006d, B:25:0x0075, B:27:0x007b, B:29:0x0089, B:31:0x0093, B:40:0x00a3, B:43:0x00ad), top: B:53:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.sla.t.Installed f(java.util.Map<java.lang.String, java.lang.String> r9) {
        /*
            r8 = this;
            r1 = 0
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L3c
            com.stepos.ailauncher.common.utils.a r0 = com.stepos.ailauncher.common.utils.C3197a.INSTANCE     // Catch: java.lang.Throwable -> L3c
            android.app.Application r0 = r0.a()     // Catch: java.lang.Throwable -> L3c
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Throwable -> L3c
            java.util.List<java.lang.String> r2 = com.stepos.ailauncher.sla.t.packageKeys     // Catch: java.lang.Throwable -> L3c
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch: java.lang.Throwable -> L3c
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L3c
        L15:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L3c
            if (r3 == 0) goto L43
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r3 = r9.get(r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L3c
            if (r3 == 0) goto L3a
            java.lang.CharSequence r3 = La.H.D1(r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L3c
            if (r3 == 0) goto L3a
            int r4 = r3.length()     // Catch: java.lang.Throwable -> L3c
            if (r4 <= 0) goto L3a
            goto L40
        L3a:
            r3 = r1
            goto L40
        L3c:
            r0 = move-exception
            r8 = r0
            goto Lb6
        L40:
            if (r3 == 0) goto L15
            goto L44
        L43:
            r3 = r1
        L44:
            if (r3 == 0) goto L6d
            kotlin.jvm.internal.p.f(r0)     // Catch: java.lang.Throwable -> L3c
            com.stepos.ailauncher.sla.t$a r2 = r8.d(r0, r3)     // Catch: java.lang.Throwable -> L3c
            if (r2 == 0) goto L50
            goto Lb1
        L50:
            java.lang.String r2 = "SLA"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3c
            r4.<init>()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r5 = "[LOCAL][INSTALL_GUARD] 包名未安装 pkg="
            r4.append(r5)     // Catch: java.lang.Throwable -> L3c
            r4.append(r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = " -> 照常派发"
            r4.append(r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L3c
            r4 = 0
            r5 = 4
            h8.C4148a.k(r2, r3, r4, r5, r1)     // Catch: java.lang.Throwable -> L3c
        L6d:
            java.util.List<java.lang.String> r2 = com.stepos.ailauncher.sla.t.appNameKeys     // Catch: java.lang.Throwable -> L3c
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch: java.lang.Throwable -> L3c
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L3c
        L75:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L3c
            if (r3 == 0) goto L9e
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r3 = r9.get(r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L3c
            if (r3 == 0) goto L9a
            java.lang.CharSequence r3 = La.H.D1(r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L3c
            if (r3 == 0) goto L9a
            int r4 = r3.length()     // Catch: java.lang.Throwable -> L3c
            if (r4 <= 0) goto L9a
            goto L9b
        L9a:
            r3 = r1
        L9b:
            if (r3 == 0) goto L75
            goto L9f
        L9e:
            r3 = r1
        L9f:
            if (r3 != 0) goto La3
            r2 = r1
            goto Lb1
        La3:
            kotlin.jvm.internal.p.f(r0)     // Catch: java.lang.Throwable -> L3c
            com.stepos.ailauncher.sla.t$a r2 = r8.d(r0, r3)     // Catch: java.lang.Throwable -> L3c
            if (r2 == 0) goto Lad
            goto Lb1
        Lad:
            com.stepos.ailauncher.sla.t$a r2 = r8.b(r0, r3)     // Catch: java.lang.Throwable -> L3c
        Lb1:
            java.lang.Object r8 = kotlin.Result.b(r2)     // Catch: java.lang.Throwable -> L3c
            goto Lc0
        Lb6:
            kotlin.Result$a r9 = kotlin.Result.INSTANCE
            java.lang.Object r8 = kotlin.C4849c.a(r8)
            java.lang.Object r8 = kotlin.Result.b(r8)
        Lc0:
            java.lang.Throwable r4 = kotlin.Result.e(r8)
            if (r4 != 0) goto Lc8
            r1 = r8
            goto Le6
        Lc8:
            java.lang.String r8 = r4.getMessage()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "[LOCAL][INSTALL_GUARD] 已安装检查异常，按未安装处理: "
            r9.append(r0)
            r9.append(r8)
            java.lang.String r3 = r9.toString()
            r6 = 8
            r7 = 0
            java.lang.String r2 = "SLA"
            r5 = 0
            h8.C4148a.t(r2, r3, r4, r5, r6, r7)
        Le6:
            com.stepos.ailauncher.sla.t$a r1 = (com.stepos.ailauncher.sla.t.Installed) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.sla.t.f(java.util.Map):com.stepos.ailauncher.sla.t$a");
    }
}
