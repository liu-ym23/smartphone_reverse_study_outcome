package androidx.activity.result.a;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.i;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import d.m;
import d.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ActivityResultContracts.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: compiled from: ActivityResultContracts.kt */
    public static final class a extends androidx.activity.result.a.a<String[], Map<String, Boolean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0005a f164a = null;

        /* JADX INFO: renamed from: androidx.activity.result.a.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ActivityResultContracts.kt */
        public static final class C0005a {
            public /* synthetic */ C0005a(h r1) {
                this();
            }

            private C0005a() {
            }

            public final Intent a(String[] r2) {
                o.e(r2, "input");
                Intent r1 = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", r2);
                o.c(r1, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
                return r1;
            }
        }

        static {
            f164a = new C0005a(null);
        }

        @Override // androidx.activity.result.a.a
        public /* synthetic */ Intent a(Context r3, String[] r4) {
            return a2((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (String[]) ZeusTransformUtils.preCheckCast(r4, String[].class, "com.obric.aiagent.plugin"));
        }

        @Override // androidx.activity.result.a.a
        public /* synthetic */ Map<String, Boolean> a(int r1, Intent r2) {
            return b(r1, r2);
        }

        @Override // androidx.activity.result.a.a
        public /* synthetic */ androidx.activity.result.a.a.C0004a<Map<String, Boolean>> b(Context r3, String[] r4) {
            return b2((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (String[]) ZeusTransformUtils.preCheckCast(r4, String[].class, "com.obric.aiagent.plugin"));
        }

        public a() {
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public Intent a2(Context r2, String[] r3) {
            o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
            o.e(r3, "input");
            return f164a.a(r3);
        }

        /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
        public androidx.activity.result.a.a.C0004a<Map<String, Boolean>> b2(Context r6, String[] r7) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
            o.e(r5, "context");
            o.e(r7, "input");
            int r1 = 0;
            if (r7.length != 0) goto L5;
            boolean r8 = true;
        L6:
            if (r8 == true) goto L8;
            int r9 = r7.length;
            int r3 = 0;
        L10:
            if (r3 >= r9) goto L18;
            if (androidx.core.content.a.b(r5, r7[r3]) != 0) goto L14;
            boolean r4 = true;
        L15:
            if (r4 == false) goto L16;
            r3 = r3 + 1;
            goto L10
        L16:
            boolean r10 = false;
        L19:
            if (r10 == false) goto L24;
            Map r11 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(n.c(ao.a(r7.length), 16)), Map.class, "com.obric.aiagent.plugin");
            int r12 = r7.length;
        L21:
            if (r1 >= r12) goto L29;
            m r0 = s.a(r7[r1], true);
            r11.put(r0.a(), r0.b());
            r1 = r1 + 1;
            goto L21
        L29:
            return new androidx.activity.result.a.a.C0004a(r11);
        L24:
            return null;
        L14:
            r4 = false;
            goto L15
        L18:
            r10 = true;
            goto L19
        L8:
            return new androidx.activity.result.a.a.C0004a(ao.b());
        L5:
            r8 = false;
            goto L6
        }

        public Map<String, Boolean> b(int r6, Intent r7) {
            if (r6 != (-1)) goto L5;
            if (r7 == null) goto L8;
            String[] r5 = r7.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] r8 = r7.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (r8 == null) goto L23;
            if (r5 == null) goto L23;
            Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r8.length), Collection.class, "com.obric.aiagent.plugin");
            int r0 = r8.length;
            int r3 = 0;
        L14:
            if (r3 >= r0) goto L21;
            if (r8[r3] != 0) goto L18;
            boolean r4 = true;
        L19:
            r9.add(Boolean.valueOf(r4));
            r3 = r3 + 1;
            goto L14
        L18:
            r4 = false;
            goto L19
        L21:
            return ao.a((Iterable) ZeusTransformUtils.preCheckCast(p.c((Iterable) ZeusTransformUtils.preCheckCast(i.e(r5), Iterable.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin"));
        L23:
            return ao.b();
        L8:
            return ao.b();
        L5:
            return ao.b();
        }
    }

    /* JADX INFO: renamed from: androidx.activity.result.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActivityResultContracts.kt */
    public static final class C0006b extends androidx.activity.result.a.a<Intent, ActivityResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f165a = null;

        /* JADX INFO: renamed from: androidx.activity.result.a.b$b$a */
        /* JADX INFO: compiled from: ActivityResultContracts.kt */
        public static final class a {
            public /* synthetic */ a(h r1) {
                this();
            }

            private a() {
            }
        }

        static {
            f165a = new a(null);
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public Intent a2(Context r2, Intent r3) {
            o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
            o.e(r3, "input");
            return r3;
        }

        public C0006b() {
        }

        @Override // androidx.activity.result.a.a
        public /* synthetic */ Intent a(Context r3, Intent r4) {
            return a2((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (Intent) ZeusTransformUtils.preCheckCast(r4, Intent.class, "com.obric.aiagent.plugin"));
        }

        @Override // androidx.activity.result.a.a
        public /* synthetic */ ActivityResult a(int r1, Intent r2) {
            return b(r1, r2);
        }

        public ActivityResult b(int r1, Intent r2) {
            return new ActivityResult(r1, r2);
        }
    }
}
