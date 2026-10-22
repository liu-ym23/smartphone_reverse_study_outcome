package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import java.io.Serializable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class PropertyMetadata implements Serializable {

    /* renamed from: k, reason: collision with root package name */
    public static final PropertyMetadata f3742k = new PropertyMetadata(Boolean.TRUE, null, null, null, null, null, null);

    /* renamed from: l, reason: collision with root package name */
    public static final PropertyMetadata f3743l = new PropertyMetadata(Boolean.FALSE, null, null, null, null, null, null);

    /* renamed from: m, reason: collision with root package name */
    public static final PropertyMetadata f3744m = new PropertyMetadata(null, null, null, null, null, null, null);

    /* renamed from: a, reason: collision with root package name */
    public final Boolean f3745a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3746b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f3747c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3748d;

    /* renamed from: e, reason: collision with root package name */
    public final transient a f3749e;
    public final Nulls h;

    /* renamed from: j, reason: collision with root package name */
    public final Nulls f3750j;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final AnnotatedMember f3751a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f3752b;

        public a(AnnotatedMember annotatedMember, boolean z) {
            this.f3751a = annotatedMember;
            this.f3752b = z;
        }
    }

    public PropertyMetadata(Boolean bool, String str, Integer num, String str2, a aVar, Nulls nulls, Nulls nulls2) {
        this.f3745a = bool;
        this.f3746b = str;
        this.f3747c = num;
        this.f3748d = (str2 == null || str2.isEmpty()) ? null : str2;
        this.f3749e = aVar;
        this.h = nulls;
        this.f3750j = nulls2;
    }

    public static PropertyMetadata a(Boolean bool, String str, Integer num, String str2) {
        return (str == null && num == null && str2 == null) ? bool == null ? f3744m : bool.booleanValue() ? f3742k : f3743l : new PropertyMetadata(bool, str, num, str2, null, null, null);
    }

    public final PropertyMetadata b(a aVar) {
        return new PropertyMetadata(this.f3745a, this.f3746b, this.f3747c, this.f3748d, aVar, this.h, this.f3750j);
    }

    public Object readResolve() {
        if (this.f3746b != null || this.f3747c != null || this.f3748d != null || this.f3749e != null || this.h != null || this.f3750j != null) {
            return this;
        }
        Boolean bool = this.f3745a;
        return bool == null ? f3744m : bool.booleanValue() ? f3742k : f3743l;
    }
}
