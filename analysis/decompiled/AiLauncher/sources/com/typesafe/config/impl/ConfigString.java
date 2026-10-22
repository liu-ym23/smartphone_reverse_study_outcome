package com.typesafe.config.impl;

import com.typesafe.config.ConfigValueType;
import java.io.ObjectStreamException;
import java.io.Serializable;

/* loaded from: classes4.dex */
abstract class ConfigString extends AbstractConfigValue implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public final String f31744b;

    public static final class Quoted extends ConfigString {
        public Quoted(b8.k kVar, String str) {
            super(kVar, str);
        }

        private Object writeReplace() throws ObjectStreamException {
            return new SerializedConfigValue(this);
        }

        @Override // com.typesafe.config.impl.ConfigString, b8.p
        public /* bridge */ /* synthetic */ Object a() {
            return super.a();
        }

        @Override // com.typesafe.config.impl.AbstractConfigValue
        /* renamed from: s0, reason: merged with bridge method [inline-methods] */
        public Quoted c0(b8.k kVar) {
            return new Quoted(kVar, this.f31744b);
        }
    }

    public static final class Unquoted extends ConfigString {
        public Unquoted(b8.k kVar, String str) {
            super(kVar, str);
        }

        private Object writeReplace() throws ObjectStreamException {
            return new SerializedConfigValue(this);
        }

        @Override // com.typesafe.config.impl.ConfigString, b8.p
        public /* bridge */ /* synthetic */ Object a() {
            return super.a();
        }

        @Override // com.typesafe.config.impl.AbstractConfigValue
        /* renamed from: s0, reason: merged with bridge method [inline-methods] */
        public Unquoted c0(b8.k kVar) {
            return new Unquoted(kVar, this.f31744b);
        }
    }

    public ConfigString(b8.k kVar, String str) {
        super(kVar);
        this.f31744b = str;
    }

    @Override // b8.p
    public ConfigValueType c() {
        return ConfigValueType.STRING;
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public void f0(StringBuilder sb2, int i10, boolean z10, b8.n nVar) {
        if (T(nVar)) {
            O(sb2);
        } else {
            sb2.append(nVar.d() ? C3904j.g(this.f31744b) : C3904j.h(this.f31744b));
        }
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public String m0() {
        return this.f31744b;
    }

    @Override // b8.p
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public String a() {
        return this.f31744b;
    }

    public boolean r0() {
        return this instanceof Quoted;
    }
}
