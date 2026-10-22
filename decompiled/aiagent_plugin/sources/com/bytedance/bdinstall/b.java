package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AbsEnv.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ap f6171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bytedance.bdinstall.j.r<SharedPreferences> f6174e;
    private final com.bytedance.bdinstall.j.k<SharedPreferences> f;

    b(ap r2, boolean r3, boolean r4, boolean r5) {
        this.f6174e = new AnonymousClass1(this);
        this.f = new AnonymousClass2(this);
        this.f6171b = r2;
        this.f6172c = r3;
        this.f6173d = r4;
        this.f6170a = r5;
    }

    public ap a() {
        return this.f6171b;
    }

    public boolean b() {
        return this.f6172c;
    }

    public boolean c() {
        return this.f6173d;
    }

    public boolean d() {
        return this.f6170a;
    }

    public String toString() {
        return "AbsEnv{isChildMode=" + this.f6170a + ", config=" + this.f6171b + ", isI18n=" + this.f6172c + ", isBoe=" + this.f6173d + '}';
    }

    public SharedPreferences a(an r4) {
        if (r4.o() == false) goto L6;
        return a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L6:
        return a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), String.valueOf(r4.a()));
    }

    public SharedPreferences a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        return (SharedPreferences) ZeusTransformUtils.preCheckCast(this.f6174e.c(new Object[]{r5}), SharedPreferences.class, "com.obric.aiagent.plugin");
    }

    public SharedPreferences a(Context r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        return (SharedPreferences) ZeusTransformUtils.preCheckCast(this.f.c(r5, new Object[]{r6}), SharedPreferences.class, "com.obric.aiagent.plugin");
    }

    public boolean equals(Object r7) {
        if (r7 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, b.class) == true) goto L8;
        return false;
    L8:
        if (this.f6171b.equals(((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin")).f6171b) == false) goto L17;
        if (this.f6173d != ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin")).f6173d) goto L17;
        if (this.f6172c != ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin")).f6172c) goto L17;
        if (this.f6170a != ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin")).d()) goto L17;
        return true;
    L17:
        return false;
    }

    public Object clone() {
        return super.clone();
    }
}
