package com.ttnet.org.chromium.net;

import android.content.Context;
import android.util.Pair;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ExperimentalCronetEngine.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class h extends d {

    /* JADX INFO: compiled from: ExperimentalCronetEngine.java */
    public static class a extends d.a {
        public a n(boolean r1) {
            return this;
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a a() {
            return b();
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a a(int r1) {
            return c(r1);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a a(int r1, long r2) {
            return b(r1, r2);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a a(long r1) {
            return c(r1);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a a(TTAppInfoProvider.AppInfo r1) {
            return b(r1);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a a(TTAppInfoProvider r1) {
            return b(r1);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a a(TTSamplingSettingProvider.TTSlaSamplingSetting r1) {
            return b(r1);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a a(TTThreadConfigInfoProvider.b r3) {
            return b((TTThreadConfigInfoProvider.b) ZeusTransformUtils.wrapperContextForParams(r3, TTThreadConfigInfoProvider.b.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a a(aa r1) {
            return b(r1);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a a(d.a.AbstractC1027a r1) {
            return b(r1);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a a(z r1) {
            return b(r1);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a a(String r1) {
            return i(r1);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a a(String r1, int r2, int r3) {
            return b(r1, r2, r3);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a a(ArrayList r1) {
            return c(r1);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a a(Map r3) {
            return b((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a a(boolean r1) {
            return l(r1);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a a(boolean r1, String r2) {
            return b(r1, r2);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a a(boolean r1, boolean r2) {
            return b(r1, r2);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a b(long r1) {
            return d(r1);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a b(String r1) {
            return j(r1);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a b(ArrayList r1) {
            return d(r1);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a b(boolean r1) {
            return m(r1);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a c(boolean r1) {
            return o(r1);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a d(String r1) {
            return k(r1);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a d(boolean r1) {
            return p(r1);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a e(String r1) {
            return l(r1);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a e(boolean r1) {
            return q(r1);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a f(String r1) {
            return m(r1);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a f(boolean r1) {
            return r(r1);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a g(String r1) {
            return n(r1);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a g(boolean r1) {
            return s(r1);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a h(String r1) {
            return o(r1);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a h(boolean r1) {
            return t(r1);
        }

        @Override // com.ttnet.org.chromium.net.d.a
        public /* synthetic */ d.a i(boolean r1) {
            return u(r1);
        }

        public a(Context r3, boolean r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
        }

        public a(k r1) {
            super(r1);
        }

        public a k(boolean r2) {
            this.f37897a.k(r2);
            return this;
        }

        public a b(int r2) {
            this.f37897a.b(r2);
            return this;
        }

        public a i(String r1) {
            super.a(r1);
            return this;
        }

        public a j(String r1) {
            super.b(r1);
            return this;
        }

        public a b(d.a.AbstractC1027a r1) {
            super.a(r1);
            return this;
        }

        public a l(boolean r1) {
            super.a(r1);
            return this;
        }

        public a m(boolean r1) {
            super.b(r1);
            return this;
        }

        public a b(int r1, long r2) {
            super.a(r1, r2);
            return this;
        }

        public a o(boolean r1) {
            super.c(r1);
            return this;
        }

        public a p(boolean r1) {
            super.d(r1);
            return this;
        }

        public a b() {
            super.a();
            return this;
        }

        public a b(TTAppInfoProvider r1) {
            super.a(r1);
            return this;
        }

        public a b(aa r1) {
            super.a(r1);
            return this;
        }

        public a b(z r1) {
            super.a(r1);
            return this;
        }

        public a c(int r1) {
            super.a(r1);
            return this;
        }

        public a k(String r1) {
            super.d(r1);
            return this;
        }

        public a c(ArrayList<byte[]> r1) {
            super.a(r1);
            return this;
        }

        public a b(Map<String[], Pair<byte[], byte[]>> r3) {
            super.a((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"));
            return this;
        }

        public a l(String r1) {
            super.e(r1);
            return this;
        }

        public a m(String r1) {
            super.f(r1);
            return this;
        }

        public a n(String r1) {
            super.g(r1);
            return this;
        }

        public a q(boolean r1) {
            super.e(r1);
            return this;
        }

        public a r(boolean r1) {
            super.f(r1);
            return this;
        }

        public a c(long r1) {
            super.a(r1);
            return this;
        }

        public a s(boolean r1) {
            super.g(r1);
            return this;
        }

        public a t(boolean r1) {
            super.h(r1);
            return this;
        }

        public a o(String r1) {
            super.h(r1);
            return this;
        }

        public a b(TTAppInfoProvider.AppInfo r1) {
            super.a(r1);
            return this;
        }

        public a u(boolean r1) {
            super.i(r1);
            return this;
        }

        public a b(boolean r1, boolean r2) {
            super.a(r1, r2);
            return this;
        }

        public a d(long r1) {
            super.b(r1);
            return this;
        }

        public a d(ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r1) {
            super.b(r1);
            return this;
        }

        public a b(TTThreadConfigInfoProvider.b r3) {
            super.a((TTThreadConfigInfoProvider.b) ZeusTransformUtils.wrapperContextForParams(r3, TTThreadConfigInfoProvider.b.class, "com.obric.aiagent.plugin"));
            return this;
        }

        public a b(TTSamplingSettingProvider.TTSlaSamplingSetting r1) {
            super.a(r1);
            return this;
        }

        public a b(boolean r1, String r2) {
            super.a(r1, r2);
            return this;
        }

        public a b(String r1, int r2, int r3) {
            super.a(r1, r2, r3);
            return this;
        }

        public h c() {
            return this.f37897a.b();
        }
    }

    public double a(int r1) {
        return -1.0d;
    }

    public Map<String, String> a(String r1, int r2, boolean r3) {
        return null;
    }

    public void a(long r1) {
    }

    public void a(long r1, long r3, long r5, long r7, long r9, long r11, long r13, long r15) {
    }

    public void a(TTSamplingSettingProvider.TTSlaSamplingSetting r1) {
    }

    public void a(String r1) {
    }

    public void a(String r1, int r2, String r3, Map<String, String> r4) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
    }

    public void a(String r1, int r2, Map<String, String> r3) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public void a(String r1, String r2) {
    }

    public void a(String r1, String r2, String r3, String r4, String r5, String r6) {
    }

    public void a(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11) {
    }

    public void a(boolean r1) {
    }

    public void a(boolean r1, String r2, String r3, String r4, boolean r5, String r6) {
    }

    public void a(String[] r1, int r2) {
    }

    public void a(String[] r1, int r2, int r3) {
    }

    public void a(String[] r1, int r2, long r3) {
    }

    public void a(String[] r1, byte[] r2, byte[] r3, long r4, long r6) {
    }

    public double b(int r1) {
        return -1.0d;
    }

    public int b() {
        return 0;
    }

    public abstract i.a b(String r1, ai.b r2, Executor r3);

    public void b(String r1) {
    }

    public void b(boolean r1) {
    }

    public double c(int r1) {
        return -1.0d;
    }

    public void c() {
    }

    public void c(String r1) {
    }

    public double d(int r1) {
        return -1.0d;
    }

    public void d(String r1) {
    }

    public int e() {
        return 0;
    }

    public void e(int r1) {
    }

    public int f() {
        return -1;
    }

    public void f(int r1) {
    }

    public int g() {
        return -1;
    }

    public void g(int r1) {
    }

    public int h() {
        return -1;
    }

    public void h(int r1) {
    }

    public List<Long> i() {
        return null;
    }

    public void j() {
    }

    public int k() {
        return -1;
    }

    public int l() {
        return -1;
    }

    public int m() {
        return -1;
    }

    public h() {
    }

    @Override // com.ttnet.org.chromium.net.d
    public /* synthetic */ ai.a a(String r3, ai.b r4, Executor r5) {
        return b(r3, r4, (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.aiagent.plugin"));
    }

    public Map<String, int[]> d() {
        return new HashMap();
    }
}
