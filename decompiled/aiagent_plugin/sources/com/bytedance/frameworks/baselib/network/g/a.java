package com.bytedance.frameworks.baselib.network.g;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: SamplingSettingProvider.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.g.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SamplingSettingProvider.java */
    public static class C0180a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String[] f8100a;

        public C0180a(String[] r1) {
            this.f8100a = r1;
        }

        public String[] a() {
            return this.f8100a;
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L5;
            return true;
        L5:
            if (r3 != null) goto L7;
            return false;
        L7:
            if (getClass() != r3.getClass()) goto L13;
            C0180a r4 = (C0180a) ZeusTransformUtils.preCheckCast(r3, C0180a.class, "com.obric.aiagent.plugin");
            return Arrays.equals(this.f8100a, r4.f8100a);
        L13:
            return false;
        }
    }

    /* JADX INFO: compiled from: SamplingSettingProvider.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f8101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f8102b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String[] f8103c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String[] f8104d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String[] f8105e;
        private String[] f;
        private String[] g;
        private String[] h;
        private String[] i;

        public b(boolean r1, boolean r2, String[] r3, String[] r4, String[] r5, String[] r6, String[] r7, String[] r8, String[] r9) {
            this.f8101a = r1;
            this.f8102b = r2;
            this.f8103c = r3;
            this.f8104d = r4;
            this.f8105e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
        }

        public boolean a() {
            return this.f8101a;
        }

        public boolean b() {
            return this.f8102b;
        }

        public String[] c() {
            return this.f8103c;
        }

        public String[] d() {
            return this.f8104d;
        }

        public String[] e() {
            return this.f8105e;
        }

        public String[] f() {
            return this.f;
        }

        public String[] g() {
            return this.g;
        }

        public String[] h() {
            return this.h;
        }

        public String[] i() {
            return this.i;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L31:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L31;
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f8101a != r6.f8101a) goto L30;
            if (this.f8102b != r6.f8102b) goto L30;
            if (Arrays.equals(this.f8103c, r6.f8103c) == false) goto L30;
            if (Arrays.equals(this.f8104d, r6.f8104d) == false) goto L30;
            if (Arrays.equals(this.f8105e, r6.f8105e) == false) goto L30;
            if (Arrays.equals(this.f, r6.f) == false) goto L30;
            if (Arrays.equals(this.g, r6.g) == false) goto L30;
            if (Arrays.equals(this.h, r6.h) == false) goto L30;
            if (Arrays.equals(this.i, r6.i) == false) goto L30;
            return true;
        L30:
            return false;
        }
    }

    /* JADX INFO: compiled from: SamplingSettingProvider.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f8106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f8107b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private b f8108c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private C0180a f8109d;

        public c(int r2, b r3, C0180a r4) {
            this(r2, 0, r3, r4);
        }

        public c(int r1, int r2, b r3, C0180a r4) {
            this.f8106a = r1;
            this.f8107b = r2;
            this.f8108c = r3;
            this.f8109d = r4;
        }

        public int a() {
            return this.f8106a;
        }

        public int b() {
            return this.f8107b;
        }

        public b c() {
            return this.f8108c;
        }

        public C0180a d() {
            return this.f8109d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L21:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L21;
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (this.f8106a != r6.f8106a) goto L20;
            if (this.f8107b != r6.f8107b) goto L20;
            if (Objects.equals(this.f8108c, r6.f8108c) == false) goto L20;
            if (Objects.equals(this.f8109d, r6.f8109d) == false) goto L20;
            return true;
        L20:
            return false;
        }
    }
}
