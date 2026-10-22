package com.google.protobuf;

import com.google.protobuf.MessageLite;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class f2 extends b {

    /* renamed from: f, reason: collision with root package name */
    public final i2 f2350f;

    /* renamed from: g, reason: collision with root package name */
    public i2 f2351g;

    public f2(i2 i2Var) {
        this.f2350f = i2Var;
        if (i2Var.h()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f2351g = i2Var.k();
    }

    public static void h(Object obj, Object obj2) {
        q3 q3Var = q3.f2501c;
        q3Var.getClass();
        q3Var.a(obj.getClass()).a(obj, obj2);
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final i2 build() {
        i2 i2VarBuildPartial = buildPartial();
        i2VarBuildPartial.getClass();
        if (i2.g(i2VarBuildPartial, true)) {
            return i2VarBuildPartial;
        }
        throw new b4();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i2 buildPartial() {
        if (!this.f2351g.h()) {
            return this.f2351g;
        }
        this.f2351g.i();
        return this.f2351g;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    public final MessageLite.Builder clear() {
        i2 i2Var = this.f2350f;
        if (i2Var.h()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f2351g = i2Var.k();
        return this;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    public final MessageLite.Builder clone() {
        f2 f2Var = (f2) this.f2350f.d(5, null);
        f2Var.f2351g = buildPartial();
        return f2Var;
    }

    public final void d() {
        if (this.f2351g.h()) {
            return;
        }
        e();
    }

    public void e() {
        i2 i2VarK = this.f2350f.k();
        h(i2VarK, this.f2351g);
        this.f2351g = i2VarK;
    }

    public final void f(o oVar, u1 u1Var) {
        d();
        try {
            q3 q3Var = q3.f2501c;
            i2 i2Var = this.f2351g;
            q3Var.getClass();
            t3 t3VarA = q3Var.a(i2Var.getClass());
            i2 i2Var2 = this.f2351g;
            androidx.datastore.preferences.protobuf.k kVar = oVar.f2465b;
            if (kVar == null) {
                kVar = new androidx.datastore.preferences.protobuf.k(oVar);
            }
            t3VarA.j(i2Var2, kVar, u1Var);
        } catch (RuntimeException e10) {
            if (!(e10.getCause() instanceof IOException)) {
                throw e10;
            }
            throw ((IOException) e10.getCause());
        }
    }

    public final void g(byte[] bArr, int i2, int i10, u1 u1Var) {
        d();
        try {
            q3 q3Var = q3.f2501c;
            i2 i2Var = this.f2351g;
            q3Var.getClass();
            q3Var.a(i2Var.getClass()).h(this.f2351g, bArr, i2, i2 + i10, new g(u1Var));
        } catch (r2 e10) {
            throw e10;
        } catch (IOException e11) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e11);
        } catch (IndexOutOfBoundsException unused) {
            throw r2.g();
        }
    }

    @Override // com.google.protobuf.MessageLite.Builder
    public final MessageLite getDefaultInstanceForType() {
        return this.f2350f;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    public final boolean isInitialized() {
        return i2.g(this.f2351g, false);
    }

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(o oVar, u1 u1Var) {
        f(oVar, u1Var);
        return this;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] bArr, int i2, int i10, u1 u1Var) {
        g(bArr, i2, i10, u1Var);
        return this;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    public final MessageLite.Builder mergeFrom(byte[] bArr, int i2, int i10) {
        g(bArr, i2, i10, u1.b());
        return this;
    }

    /* renamed from: clone, reason: collision with other method in class */
    public final Object m14clone() {
        f2 f2Var = (f2) this.f2350f.d(5, null);
        f2Var.f2351g = buildPartial();
        return f2Var;
    }
}
