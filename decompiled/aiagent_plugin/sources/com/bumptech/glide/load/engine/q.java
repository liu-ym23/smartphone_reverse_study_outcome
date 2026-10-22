package com.bumptech.glide.load.engine;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: GlideException.java */
/* JADX INFO: loaded from: classes.dex */
public final class q extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final StackTraceElement[] f3721a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Throwable> f3722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.load.g f3723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bumptech.glide.load.a f3724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Class<?> f3725e;
    private String f;
    private Exception g;

    /* JADX INFO: compiled from: GlideException.java */
    private static final class a implements Appendable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Appendable f3726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f3727b;

        private CharSequence a(CharSequence r2) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
            if (r1 != null) goto L6;
            return "";
        L6:
            return r1;
        }

        a(Appendable r3) {
            Appendable r4 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.aiagent.plugin");
            this.f3727b = true;
            this.f3726a = r4;
        }

        @Override // java.lang.Appendable
        public Appendable append(char r4) {
            boolean r1 = false;
            if (this.f3727b == false) goto L6;
            this.f3727b = false;
            this.f3726a.append("  ");
        L6:
            if (r4 != '\n') goto L8;
            r1 = true;
        L8:
            this.f3727b = r1;
            this.f3726a.append(r4);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence r3) {
            CharSequence r4 = a((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
            return append(r4, 0, r4.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence r4, int r5, int r6) {
            CharSequence r7 = a((CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin"));
            boolean r1 = false;
            if (this.f3727b == false) goto L6;
            this.f3727b = false;
            this.f3726a.append("  ");
        L6:
            if (r7.length() > 0) goto L8;
        L10:
            this.f3727b = r1;
            this.f3726a.append(r7, r5, r6);
            return this;
        L8:
            if (r7.charAt(r6 - 1) != '\n') goto L10;
            r1 = true;
            goto L10
        }
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    static {
        f3721a = new StackTraceElement[0];
    }

    public q(String r2) {
        this(r2, Collections.emptyList());
    }

    public q(String r1, Throwable r2) {
        this(r1, Collections.singletonList(r2));
    }

    public q(String r3, List<Throwable> r4) {
        List<Throwable> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        this.f = r3;
        setStackTrace(f3721a);
        this.f3722b = r5;
    }

    void a(com.bumptech.glide.load.g r3, com.bumptech.glide.load.a r4) {
        a((com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin"), r4, null);
    }

    void a(com.bumptech.glide.load.g r3, com.bumptech.glide.load.a r4, Class<?> r5) {
        this.f3723c = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        this.f3724d = r4;
        this.f3725e = r5;
    }

    public void a(Exception r1) {
        this.g = r1;
    }

    public List<Throwable> a() {
        return this.f3722b;
    }

    public List<Throwable> b() {
        ArrayList r0 = new ArrayList();
        a(this, r0);
        return r0;
    }

    public void a(String r7) {
        List<Throwable> r6 = b();
        int r0 = r6.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int r3 = r1 + 1;
        a(r7, "Root cause (" + r3 + " of " + r0 + ")", (Throwable) ZeusTransformUtils.preCheckCast(r6.get(r1), Throwable.class, "com.obric.aiagent.plugin"));
        r1 = r3;
        goto L3
    }

    private void a(Throwable r4, List<Throwable> r5) {
        List<Throwable> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, q.class) == false) goto L8;
        Iterator<Throwable> r7 = ((q) ZeusTransformUtils.preCheckCast(r4, q.class, "com.obric.aiagent.plugin")).a().iterator();
    L6:
        if (r7.hasNext() == false) goto L11;
        a((Throwable) ZeusTransformUtils.preCheckCast(r7.next(), Throwable.class, "com.obric.aiagent.plugin"), r6);
        goto L6
    L11:
        return;
    L8:
        r6.add(r4);
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream r1) {
        a(r1);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter r1) {
        a(r1);
    }

    private void a(Appendable r3) {
        Appendable r4 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.aiagent.plugin");
        a(this, r4);
        a(a(), new a(r4));
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder r0 = new StringBuilder(71).append(this.f);
        String r3 = "";
        if (this.f3725e == null) goto L5;
        String r1 = ", " + this.f3725e;
    L6:
        StringBuilder r2 = r0.append(r1);
        if (this.f3724d == null) goto L9;
        String r4 = ", " + this.f3724d;
    L10:
        StringBuilder r5 = r2.append(r4);
        if (this.f3723c == null) goto L13;
        r3 = ", " + this.f3723c;
    L13:
        StringBuilder r6 = r5.append(r3);
        List<Throwable> r7 = b();
        if (r7.isEmpty() == false) goto L18;
        return r6.toString();
    L18:
        if (r7.size() != 1) goto L20;
        r6.append("\nThere was 1 cause:");
    L21:
        Iterator<Throwable> r8 = r7.iterator();
    L23:
        if (r8.hasNext() == false) goto L25;
        Throwable r9 = (Throwable) ZeusTransformUtils.preCheckCast(r8.next(), Throwable.class, "com.obric.aiagent.plugin");
        r6.append('\n').append(r9.getClass().getName()).append('(').append(r9.getMessage()).append(')');
        goto L23
    L25:
        r6.append("\n call GlideException#logRootCauses(String) for more detail");
        return r6.toString();
    L20:
        r6.append("\nThere were ").append(r7.size()).append(" causes:");
        goto L21
    L9:
        r4 = "";
        goto L10
    L5:
        r1 = "";
        goto L6
    }

    private static void a(Throwable r2, Appendable r3) {
        Appendable r4 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.aiagent.plugin");
        r4.append(r2.getClass().toString()).append(": ").append(r2.getMessage()).append('\n');     // Catch: IOException -> L5
        return;
    L6:
        throw new RuntimeException(r2);
    }

    private static void a(List<Throwable> r2, Appendable r3) {
        b((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), (Appendable) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.aiagent.plugin"));     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static void b(List<Throwable> r7, Appendable r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        Appendable r10 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r8, Appendable.class, "com.obric.aiagent.plugin");
        int r1 = r9.size();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        int r5 = r3 + 1;
        r10.append("Cause (").append(String.valueOf(r5)).append(" of ").append(String.valueOf(r1)).append("): ");
        Throwable r4 = (Throwable) ZeusTransformUtils.preCheckCast(r9.get(r3), Throwable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, q.class) == false) goto L7;
        ((q) ZeusTransformUtils.preCheckCast(r4, q.class, "com.obric.aiagent.plugin")).a(r10);
    L8:
        r3 = r5;
        goto L3
    L7:
        a(r4, r10);
        goto L8
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2, r3);
    }
}
