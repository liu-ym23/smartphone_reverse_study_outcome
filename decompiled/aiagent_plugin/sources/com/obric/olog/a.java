package com.obric.olog;

import android.content.Context;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OLogConfig.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f33915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f33916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f33917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f33918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f33919e;
    private int f;
    private int g;

    /* JADX INFO: renamed from: com.obric.olog.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: OLogConfig.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.obric.olog.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OLogConfig.java */
    public static class C0919a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f33920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f33921b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f33922c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f33923d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f33924e;
        private int f;
        private int g;

        public C0919a(Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            this.f33921b = false;
            this.f33922c = 3;
            this.f33923d = true;
            this.g = 14;
            if (r5 == null) goto L14;
            Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L7;
            r5 = r0;
        L7:
            this.f33920a = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
            if (b() == false) goto L10;
            int r6 = 31457280;
        L11:
            this.f = r6;
            return;
        L10:
            r6 = 20971520;
            goto L11
        L14:
            throw new RuntimeException("context must not be null");
        }

        public a a() {
            a r0 = new a(null);
            r0.a(this.f33920a);
            r0.a(this.f33921b);
            r0.a(this.f33922c);
            r0.b(this.f33923d);
            r0.a(this.f33924e);
            r0.b(this.f);
            r0.c(this.g);
            return r0;
        }

        private boolean b() {
            return Build.TYPE.equals("userdebug");
        }
    }

    /* synthetic */ a(AnonymousClass1 r1) {
        this();
    }

    private a() {
        this.f33916b = false;
        this.f33917c = 3;
        this.f33918d = true;
        this.g = 14;
    }

    public Context getContext() {
        return this.f33915a;
    }

    public void a(Context r3) {
        this.f33915a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    public boolean a() {
        return this.f33916b;
    }

    public void a(boolean r1) {
        this.f33916b = r1;
    }

    public int b() {
        return this.f33917c;
    }

    public void a(int r1) {
        this.f33917c = r1;
    }

    public boolean c() {
        return this.f33918d;
    }

    public void b(boolean r1) {
        this.f33918d = r1;
    }

    public String d() {
        return this.f33919e;
    }

    public void a(String r1) {
        this.f33919e = r1;
    }

    public int e() {
        return this.f;
    }

    public void b(int r1) {
        this.f = r1;
    }

    public int f() {
        return this.g;
    }

    public void c(int r1) {
        this.g = r1;
    }
}
