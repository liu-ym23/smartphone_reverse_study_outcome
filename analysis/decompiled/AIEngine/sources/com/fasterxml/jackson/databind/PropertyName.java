package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.util.InternCache;
import com.fasterxml.jackson.databind.util.a;
import java.io.Serializable;
import java.lang.annotation.Annotation;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class PropertyName implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final PropertyName f3753d = new PropertyName("", null);

    /* renamed from: e, reason: collision with root package name */
    public static final PropertyName f3754e = new PropertyName(new String(""), null);

    /* renamed from: a, reason: collision with root package name */
    public final String f3755a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3756b;

    /* renamed from: c, reason: collision with root package name */
    public SerializedString f3757c;

    public PropertyName(String str, String str2) {
        Annotation[] annotationArr = a.f4529a;
        this.f3755a = str == null ? "" : str;
        this.f3756b = str2;
    }

    public static PropertyName a(String str) {
        return (str == null || str.isEmpty()) ? f3753d : new PropertyName(InternCache.f3643b.a(str), null);
    }

    public static PropertyName b(String str, String str2) {
        if (str == null) {
            str = "";
        }
        return (str2 == null && str.isEmpty()) ? f3753d : new PropertyName(InternCache.f3643b.a(str), str2);
    }

    public final boolean c() {
        return this.f3756b == null && this.f3755a.isEmpty();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        PropertyName propertyName = (PropertyName) obj;
        String str = propertyName.f3756b;
        String str2 = propertyName.f3755a;
        String str3 = this.f3755a;
        if (str3 == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str3.equals(str2)) {
            return false;
        }
        String str4 = this.f3756b;
        return str4 == null ? str == null : str4.equals(str);
    }

    public final int hashCode() {
        String str = this.f3755a;
        String str2 = this.f3756b;
        return str2 == null ? str.hashCode() : str2.hashCode() ^ str.hashCode();
    }

    public Object readResolve() {
        if (this.f3756b != null) {
            return this;
        }
        String str = this.f3755a;
        return (str == null || "".equals(str)) ? f3753d : this;
    }

    public final String toString() {
        String str = this.f3755a;
        String str2 = this.f3756b;
        if (str2 == null) {
            return str;
        }
        return "{" + str2 + "}" + str;
    }
}
