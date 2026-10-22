package com.bytedance.bdturing.verify.a;

import android.app.Activity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AbstractRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f6639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f6643e;
    private boolean f;
    private String g;

    public abstract void a(StringBuilder r1);

    public abstract String f();

    public abstract int g();

    public abstract int getType();

    public a() {
        this.f6643e = true;
        this.f = true;
        this.g = "";
    }

    public final void a(Activity r3) {
        this.f6639a = ZeusTransformUtils.wrapperContext2Activity((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    public final Activity getActivity() {
        return this.f6639a;
    }

    public void a(boolean r1) {
        this.f6640b = r1;
    }

    public boolean a() {
        return this.f6640b;
    }

    public final boolean b() {
        return this.f6642d;
    }

    public final void b(boolean r1) {
        this.f6643e = r1;
    }

    public final boolean c() {
        return this.f6643e;
    }

    public final void c(boolean r1) {
        this.f = r1;
    }

    public final boolean d() {
        return this.f;
    }

    public final void a(String r2) {
        d.h.b.o.d(r2, "<set-?>");
        this.g = r2;
    }

    public final String e() {
        return this.g;
    }

    public final String h() {
        StringBuilder r0 = com.bytedance.bdturing.a.b.f6500a.a(getType(), f(), this.f6639a);
        if (this.f6641c == false) goto L5;
        com.bytedance.bdturing.utils.d.a(r0, "preload", 1);
    L5:
        a(r0);
        String r4 = r0.toString();
        d.h.b.o.b(r4, "queryBuilder.toString()");
        return r4;
    }
}
