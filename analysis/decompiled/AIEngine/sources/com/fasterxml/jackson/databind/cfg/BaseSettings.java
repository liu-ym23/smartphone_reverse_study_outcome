package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.DefaultAccessorNamingStrategy;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.f;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class BaseSettings implements Serializable {

    /* renamed from: l, reason: collision with root package name */
    public static final TimeZone f3788l = TimeZone.getTimeZone("UTC");

    /* renamed from: a, reason: collision with root package name */
    public final TypeFactory f3789a;

    /* renamed from: b, reason: collision with root package name */
    public final f f3790b;

    /* renamed from: c, reason: collision with root package name */
    public final JacksonAnnotationIntrospector f3791c;

    /* renamed from: d, reason: collision with root package name */
    public final DefaultAccessorNamingStrategy.Provider f3792d;

    /* renamed from: e, reason: collision with root package name */
    public final PolymorphicTypeValidator f3793e;
    public final DateFormat h;

    /* renamed from: j, reason: collision with root package name */
    public final Locale f3794j;

    /* renamed from: k, reason: collision with root package name */
    public final Base64Variant f3795k;

    public BaseSettings(BasicClassIntrospector basicClassIntrospector, JacksonAnnotationIntrospector jacksonAnnotationIntrospector, TypeFactory typeFactory, DateFormat dateFormat, Locale locale, Base64Variant base64Variant, PolymorphicTypeValidator polymorphicTypeValidator, DefaultAccessorNamingStrategy.Provider provider) {
        this.f3790b = basicClassIntrospector;
        this.f3791c = jacksonAnnotationIntrospector;
        this.f3789a = typeFactory;
        this.h = dateFormat;
        this.f3794j = locale;
        this.f3795k = base64Variant;
        this.f3793e = polymorphicTypeValidator;
        this.f3792d = provider;
    }
}
