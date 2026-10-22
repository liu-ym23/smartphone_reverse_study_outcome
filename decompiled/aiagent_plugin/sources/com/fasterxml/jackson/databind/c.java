package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: BeanDescription.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final k f12547a;

    public abstract JsonFormat.Value a(JsonFormat.Value r1);

    public abstract JsonInclude.Value a(JsonInclude.Value r1);

    public abstract com.fasterxml.jackson.databind.e.k a(String r1, Class<?>[] r2);

    public abstract Object a(boolean r1);

    public abstract com.fasterxml.jackson.databind.e.d c();

    public abstract com.fasterxml.jackson.databind.e.ac d();

    public abstract boolean e();

    public abstract com.fasterxml.jackson.databind.l.b f();

    public abstract List<com.fasterxml.jackson.databind.e.t> g();

    public abstract Set<String> h();

    public abstract List<com.fasterxml.jackson.databind.e.t> i();

    public abstract List<com.fasterxml.jackson.databind.e.f> j();

    public abstract List<com.fasterxml.jackson.databind.e.c<com.fasterxml.jackson.databind.e.f, JsonCreator.Mode>> k();

    public abstract List<com.fasterxml.jackson.databind.e.k> l();

    public abstract List<com.fasterxml.jackson.databind.e.c<com.fasterxml.jackson.databind.e.k, JsonCreator.Mode>> m();

    public abstract com.fasterxml.jackson.databind.e.f n();

    public com.fasterxml.jackson.databind.e.j o() {
        return null;
    }

    public abstract com.fasterxml.jackson.databind.e.j p();

    public abstract com.fasterxml.jackson.databind.e.j q();

    public abstract com.fasterxml.jackson.databind.e.j r();

    public abstract com.fasterxml.jackson.databind.l.j<Object, Object> s();

    public abstract com.fasterxml.jackson.databind.l.j<Object, Object> t();

    public abstract Map<Object, com.fasterxml.jackson.databind.e.j> u();

    public abstract Class<?> v();

    public abstract JsonPOJOBuilder.Value w();

    public abstract Class<?>[] x();

    public c(k r1) {
        this.f12547a = r1;
    }

    public k getType() {
        return this.f12547a;
    }

    public Class<?> a() {
        return this.f12547a.e();
    }

    public boolean b() {
        return c().l();
    }
}
