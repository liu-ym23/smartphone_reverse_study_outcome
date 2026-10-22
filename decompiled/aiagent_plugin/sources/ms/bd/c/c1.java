package ms.bd.c;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c1 f39466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f39467b;

    final class a implements p.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c1 f39468a;

        a(c1 r1) {
            this.f39468a = r1;
        }

        @Override // ms.bd.c.p.a
        public final void a(String r1) {
            c1.a(this.f39468a, r1);
        }
    }

    private c1(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        this.f39467b = null;
        new p(new a(this)).a(r10);     // Catch: Throwable -> L5
        return;
    L5:
        String r8 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b1dda6", new byte[]{124, 38, 20}), String.class, "com.obric.aiagent.plugin");
    }

    public static c1 a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (f39466a != null) goto L15;
        monitor-enter(c1.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f39466a != null) goto L9;
        f39466a = new c1(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(c1.class);     // Catch: Throwable -> L11
    L15:
        return f39466a;
    }

    static /* synthetic */ void a(c1 r0, String r1) {
        r0.f39467b = r1;
    }

    public static boolean a(Context r2, String r3) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getPackageManager().getPackageInfo(r3, 128) == null) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    public final String a() {
        return this.f39467b;
    }
}
