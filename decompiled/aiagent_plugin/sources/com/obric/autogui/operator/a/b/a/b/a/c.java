package com.obric.autogui.operator.a.b.a.b.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: IntentResolveHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f29464a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Intent f29465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f29466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f29467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ComponentName f29468e;

    /* JADX INFO: compiled from: IntentResolveHelper.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: IntentResolveHelper.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f29469a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f29470b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f29471c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f29472d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ b[] f29473e = null;
        private static final /* synthetic */ d.d.a f = null;

        private static final /* synthetic */ b[] a() {
            return new b[]{f29469a, f29470b, f29471c, f29472d};
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f29469a = new b("Unresolved", 0);
            f29470b = new b("Resolved", 1);
            f29471c = new b("ResolvedWithoutSolution", 2);
            f29472d = new b("ResolvedPartly", 3);
            b[] r0 = a();
            f29473e = r0;
            f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f29473e.clone(), b[].class, "com.obric.aiagent.plugin");
        }
    }

    static {
        f29464a = new a(null);
    }

    public c(Intent r2) {
        o.e(r2, MemorySourceLinkType.INTENT);
        this.f29465b = r2;
        this.f29466c = b.f29469a;
    }

    public final boolean a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        if (this.f29466c == b.f29469a) goto L12;
        return false;
    L12:
        b(r5);     // Catch: Throwable -> L8
        return true;
    L8:
        th = move-exception;
        Loog.INSTANCE.e("Op-OpenApp/IntentRes", "[IntentResolve] failed to resolve the intent (" + this.f29465b + "). (Exception)", th);
        this.f29466c = b.f29471c;
        return true;
    }

    private final void b(Context r7) {
        boolean r2 = false;
        ActivityInfo r8 = this.f29465b.resolveActivityInfo(((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin")).getPackageManager(), 0);
        if (r8 != null) goto L6;
        Loog.INSTANCE.w("Op-OpenApp/IntentRes", "[IntentResolve] cannot resolve the package/component for an implicit intent.");
        this.f29466c = b.f29471c;
        return;
    L6:
        this.f29468e = new ComponentName(r8.packageName, r8.name);
        String r9 = r8.applicationInfo.packageName;
        this.f29467d = r9;
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L9;
    L12:
        boolean r11 = true;
    L13:
        if (r11 == false) goto L15;
        Loog.INSTANCE.w("Op-OpenApp/IntentRes", "[IntentResolve] cannot resolve the packageName for an implicit intent.");
        this.f29466c = b.f29472d;
    L15:
        ComponentName r12 = this.f29468e;
        String r4 = null;
        if (r12 == null) goto L18;
        String r13 = r12.getPackageName();
    L19:
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L22;
    L25:
        boolean r15 = true;
    L26:
        if (r15 == true) goto L36;
        ComponentName r16 = this.f29468e;
        if (r16 == null) goto L30;
        r4 = r16.getClassName();
    L30:
        CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r17 != null) goto L33;
    L34:
        r2 = true;
    L35:
        if (r2 == true) goto L36;
    L38:
        if (this.f29466c != b.f29472d) goto L40;
        return;
    L40:
        this.f29466c = b.f29470b;
        return;
    L33:
        if (d.o.o.d(r17) == false) goto L35;
    L36:
        Loog.INSTANCE.w("Op-OpenApp/IntentRes", "[IntentResolve] cannot resolve the componentName for an implicit intent (" + this.f29468e + ").");
        this.f29466c = b.f29472d;
        goto L38
    L22:
        if (d.o.o.d(r14) == true) goto L25;
        r15 = false;
        goto L26
    L18:
        r13 = null;
        goto L19
    L9:
        if (d.o.o.d(r10) == true) goto L12;
        r11 = false;
        goto L13
    }

    public final String a() {
        if (this.f29466c != b.f29469a) goto L7;
        Loog.INSTANCE.w("Op-OpenApp/IntentRes", "[IntentResolve] cannot get the packageName for an unresolved intent.");
        return null;
    L7:
        return this.f29467d;
    }

    public final ComponentName b() {
        if (this.f29466c != b.f29469a) goto L7;
        Loog.INSTANCE.w("Op-OpenApp/IntentRes", "[IntentResolve] cannot get the componentName for an unresolved intent.");
        return null;
    L7:
        return this.f29468e;
    }
}
