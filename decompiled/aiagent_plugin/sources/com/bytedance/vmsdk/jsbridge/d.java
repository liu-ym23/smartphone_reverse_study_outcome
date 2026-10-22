package com.bytedance.vmsdk.jsbridge;

/* JADX INFO: compiled from: ParamWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Class<? extends JSModule> f11758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f11759c;

    public d() {
    }

    public void a(String r1) {
        this.f11757a = r1;
    }

    public Class<? extends JSModule> a() {
        return this.f11758b;
    }

    public void a(Class<? extends JSModule> r1) {
        this.f11758b = r1;
    }

    public Object b() {
        return this.f11759c;
    }

    public void a(Object r1) {
        this.f11759c = r1;
    }

    public String toString() {
        return "[" + this.f11758b.getSimpleName() + " - " + this.f11757a + "]";
    }
}
