package com.obric.autogui.agents.vlm.models.impl.a;

import android.content.Context;
import com.obric.autogui.agents.vlm.models.impl.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.Collection;

/* JADX INFO: compiled from: IStandardModelStepsHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface a {

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IStandardModelStepsHolder.kt */
    public static final class C0684a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f27296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f27297b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f27298c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0684a.class) == true) goto L8;
            return false;
        L8:
            C0684a r6 = (C0684a) ZeusTransformUtils.preCheckCast(r5, C0684a.class, "com.obric.aiagent.plugin");
            if (this.f27296a == r6.f27296a) goto L12;
            return false;
        L12:
            if (this.f27297b == r6.f27297b) goto L15;
            return false;
        L15:
            if (o.a(this.f27298c, r6.f27298c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.f27296a) * 31) + Integer.hashCode(this.f27297b)) * 31) + this.f27298c.hashCode();
        }

        public String toString() {
            return "ExecStatus(executed=" + this.f27296a + ", statusCode=" + this.f27297b + ", feedbackForModel=" + this.f27298c + ')';
        }

        public C0684a(boolean r2, int r3, String r4) {
            o.e(r4, "feedbackForModel");
            this.f27296a = r2;
            this.f27297b = r3;
            this.f27298c = r4;
        }

        public final boolean a() {
            return this.f27296a;
        }

        public final int b() {
            return this.f27297b;
        }

        public final String c() {
            return this.f27298c;
        }
    }

    String a();

    Collection<C0684a> a(Context r1);

    void a(d.h.a.b<? super g, x> r1);

    boolean b();

    g c();

    void d();
}
