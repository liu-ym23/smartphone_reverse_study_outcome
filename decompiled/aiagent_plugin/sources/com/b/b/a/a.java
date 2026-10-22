package com.b.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;

/* JADX INFO: compiled from: Engine.java */
/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final C0081a f3195a = null;

    /* JADX INFO: renamed from: com.b.b.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Engine.java */
    static final class C0081a implements Comparator<org.a.b.a> {
        C0081a() {
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(org.a.b.a r3, org.a.b.a r4) {
            return a((org.a.b.a) ZeusTransformUtils.preCheckCast(r3, org.a.b.a.class, "com.obric.aiagent.plugin"), (org.a.b.a) ZeusTransformUtils.preCheckCast(r4, org.a.b.a.class, "com.obric.aiagent.plugin"));
        }

        public int a(org.a.b.a r5, org.a.b.a r6) {
            if (r5.a() != r6.a()) goto L13;
            if (r5.c() >= r6.c()) goto L8;
            return 1;
        L8:
            if (r5.c() != r6.c()) goto L11;
            return 0;
        L11:
            return -1;
        L13:
            if (r5.a() >= r6.a()) goto L16;
            return -1;
        L16:
            if (r5.a() != r6.a()) goto L19;
            return 0;
        L19:
            return 1;
        }
    }

    static {
        f3195a = new C0081a();
    }
}
