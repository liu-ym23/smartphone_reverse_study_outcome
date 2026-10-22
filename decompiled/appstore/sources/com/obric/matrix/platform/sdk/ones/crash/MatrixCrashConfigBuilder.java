package com.obric.matrix.platform.sdk.ones.crash;

import android.app.Application;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class MatrixCrashConfigBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f11888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f11892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f11893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f11894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f11895h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f11896i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f11897j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f11898k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f11899l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f11900m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Function0 f11901n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function1 f11902o;

    public MatrixCrashConfigBuilder(Application r10) {
        q.g(r10, "application");
        this.f11888a = r10;
        this.f11889b = true;
        this.f11890c = true;
        this.f11891d = true;
        this.f11892e = true;
        this.f11893f = true;
        this.f11894g = true;
        this.f11895h = true;
        this.f11896i = true;
        this.f11897j = true;
        this.f11898k = "";
        this.f11899l = "1.0.0";
        this.f11901n = MatrixCrashConfigBuilder$crashPortraitProvider$1.INSTANCE;
        this.f11902o = MatrixCrashConfigBuilder$onCrashCatchSucceed$1.INSTANCE;
    }

    public final MatrixCrashConfigBuilder A(String r10) {
        q.g(r10, "packageName");
        this.f11898k = r10;
        return this;
    }

    public final MatrixCrashConfigBuilder B(int r10) {
        this.f11900m = r10;
        return this;
    }

    public final MatrixCrashConfigBuilder a(String r10) {
        q.g(r10, "version");
        this.f11899l = r10;
        return this;
    }

    public final void b() {
        a.f11903a.a(this);
    }

    public final MatrixCrashConfigBuilder c(Function0 r10) {
        q.g(r10, "provider");
        this.f11901n = r10;
        return this;
    }

    public final MatrixCrashConfigBuilder d(boolean r10) {
        this.f11892e = r10;
        return this;
    }

    public final MatrixCrashConfigBuilder e(boolean r10) {
        this.f11893f = r10;
        return this;
    }

    public final MatrixCrashConfigBuilder f(boolean r10) {
        this.f11894g = r10;
        return this;
    }

    public final MatrixCrashConfigBuilder g(boolean r10) {
        this.f11891d = r10;
        return this;
    }

    public final MatrixCrashConfigBuilder h(boolean r10) {
        this.f11889b = r10;
        return this;
    }

    public final MatrixCrashConfigBuilder i(boolean r10) {
        this.f11890c = r10;
        return this;
    }

    public final MatrixCrashConfigBuilder j(boolean r10) {
        this.f11895h = r10;
        return this;
    }

    public final MatrixCrashConfigBuilder k(boolean r10) {
        this.f11897j = r10;
        return this;
    }

    public final MatrixCrashConfigBuilder l(boolean r10) {
        this.f11896i = r10;
        return this;
    }

    public final String m() {
        return this.f11899l;
    }

    public final Application n() {
        return this.f11888a;
    }

    public final Function0 o() {
        return this.f11901n;
    }

    public final boolean p() {
        return this.f11892e;
    }

    public final boolean q() {
        return this.f11893f;
    }

    public final boolean r() {
        return this.f11894g;
    }

    public final boolean s() {
        return this.f11891d;
    }

    public final boolean t() {
        return this.f11889b;
    }

    public final boolean u() {
        return this.f11890c;
    }

    public final boolean v() {
        return this.f11897j;
    }

    public final boolean w() {
        return this.f11896i;
    }

    public final Function1 x() {
        return this.f11902o;
    }

    public final int y() {
        return this.f11900m;
    }

    public final MatrixCrashConfigBuilder z(Function1 r10) {
        q.g(r10, "callback");
        this.f11902o = r10;
        return this;
    }
}
