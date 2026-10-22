package com.typesafe.config.impl;

import com.typesafe.config.ConfigException;
import java.io.ObjectStreamException;
import java.io.Serializable;

/* loaded from: classes4.dex */
abstract class ConfigNumber extends AbstractConfigValue implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public final String f31743b;

    public ConfigNumber(b8.k kVar, String str) {
        super(kVar);
        this.f31743b = str;
    }

    public static ConfigNumber u0(b8.k kVar, double d10, String str) {
        long j10 = (long) d10;
        return ((double) j10) == d10 ? v0(kVar, j10, str) : new ConfigDouble(kVar, d10, str);
    }

    public static ConfigNumber v0(b8.k kVar, long j10, String str) {
        return (j10 > 2147483647L || j10 < -2147483648L) ? new ConfigLong(kVar, j10, str) : new ConfigInt(kVar, (int) j10, str);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new SerializedConfigValue(this);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public boolean P(Object obj) {
        return obj instanceof ConfigNumber;
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public boolean equals(Object obj) {
        if ((obj instanceof ConfigNumber) && P(obj)) {
            ConfigNumber configNumber = (ConfigNumber) obj;
            if (s0()) {
                return configNumber.s0() && t0() == configNumber.t0();
            }
            if (!configNumber.s0() && q0() == configNumber.q0()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public int hashCode() {
        long jT0 = s0() ? t0() : Double.doubleToLongBits(q0());
        return (int) (jT0 ^ (jT0 >>> 32));
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public String m0() {
        return this.f31743b;
    }

    public abstract double q0();

    public int r0(String str) {
        long jT0 = t0();
        if (jT0 >= -2147483648L && jT0 <= 2147483647L) {
            return (int) jT0;
        }
        throw new ConfigException.WrongType(e(), str, "32-bit integer", "out-of-range value " + jT0);
    }

    public final boolean s0() {
        return ((double) t0()) == q0();
    }

    public abstract long t0();

    @Override // b8.p
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public abstract Number a();
}
