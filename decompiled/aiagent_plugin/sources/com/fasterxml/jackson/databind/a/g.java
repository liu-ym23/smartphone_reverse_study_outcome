package com.fasterxml.jackson.databind.a;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;

/* JADX INFO: compiled from: ConfigOverride.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected JsonFormat.Value f12204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected JsonInclude.Value f12205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected JsonInclude.Value f12206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected JsonIgnoreProperties.Value f12207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected JsonSetter.Value f12208e;
    protected JsonAutoDetect.Value f;
    protected Boolean g;
    protected Boolean h;

    /* JADX INFO: compiled from: ConfigOverride.java */
    static final class a extends g {
        static final a i = null;

        static {
            i = new a();
        }

        private a() {
        }
    }

    public g() {
    }

    public static g a() {
        return a.i;
    }

    public JsonFormat.Value b() {
        return this.f12204a;
    }

    public JsonInclude.Value c() {
        return this.f12205b;
    }

    public JsonInclude.Value d() {
        return this.f12206c;
    }

    public JsonIgnoreProperties.Value e() {
        return this.f12207d;
    }

    public Boolean f() {
        return this.g;
    }

    public JsonSetter.Value g() {
        return this.f12208e;
    }

    public JsonAutoDetect.Value h() {
        return this.f;
    }

    public Boolean i() {
        return this.h;
    }
}
