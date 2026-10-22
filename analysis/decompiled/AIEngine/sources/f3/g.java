package f3;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import f3.f;
import java.util.BitSet;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final JsonParser f8724a;

    /* renamed from: b, reason: collision with root package name */
    public final DeserializationContext f8725b;

    /* renamed from: c, reason: collision with root package name */
    public final ObjectIdReader f8726c;

    /* renamed from: d, reason: collision with root package name */
    public final Object[] f8727d;

    /* renamed from: e, reason: collision with root package name */
    public int f8728e;

    /* renamed from: f, reason: collision with root package name */
    public int f8729f;

    /* renamed from: g, reason: collision with root package name */
    public final BitSet f8730g;
    public f h;

    /* renamed from: i, reason: collision with root package name */
    public Object f8731i;

    public g(JsonParser jsonParser, DeserializationContext deserializationContext, int i10, ObjectIdReader objectIdReader) {
        this.f8724a = jsonParser;
        this.f8725b = deserializationContext;
        this.f8728e = i10;
        this.f8726c = objectIdReader;
        this.f8727d = new Object[i10];
        if (i10 < 32) {
            this.f8730g = null;
        } else {
            this.f8730g = new BitSet();
        }
    }

    public final Object a(SettableBeanProperty settableBeanProperty) throws JsonMappingException {
        Object objO = settableBeanProperty.o();
        PropertyName propertyName = settableBeanProperty.f3891c;
        DeserializationContext deserializationContext = this.f8725b;
        if (objO != null) {
            deserializationContext.p(settableBeanProperty.o());
            throw null;
        }
        Boolean bool = settableBeanProperty.f4149a.f3745a;
        if (bool != null && bool.booleanValue()) {
            deserializationContext.Q(settableBeanProperty, "Missing required creator property '%s' (index %d)", propertyName.f3755a, Integer.valueOf(settableBeanProperty.m()));
            throw null;
        }
        if (deserializationContext.J(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES)) {
            deserializationContext.Q(settableBeanProperty, "Missing creator property '%s' (index %d); `DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES` enabled", propertyName.f3755a, Integer.valueOf(settableBeanProperty.m()));
            throw null;
        }
        try {
            Object objA = settableBeanProperty.f3894j.a(deserializationContext);
            return objA != null ? objA : settableBeanProperty.r().a(deserializationContext);
        } catch (JsonMappingException e10) {
            AnnotatedMember annotatedMemberD = settableBeanProperty.d();
            if (annotatedMemberD != null) {
                e10.f(new JsonMappingException.Reference(annotatedMemberD.h(), propertyName.f3755a));
            }
            throw e10;
        }
    }

    public final boolean b(SettableBeanProperty settableBeanProperty, Object obj) {
        int iM = settableBeanProperty.m();
        this.f8727d[iM] = obj;
        BitSet bitSet = this.f8730g;
        if (bitSet == null) {
            int i10 = this.f8729f;
            int i11 = (1 << iM) | i10;
            if (i10 != i11) {
                this.f8729f = i11;
                int i12 = this.f8728e - 1;
                this.f8728e = i12;
                if (i12 <= 0) {
                    return this.f8726c == null || this.f8731i != null;
                }
            }
        } else if (!bitSet.get(iM)) {
            bitSet.set(iM);
            this.f8728e--;
        }
        return false;
    }

    public final void c(SettableBeanProperty settableBeanProperty, Object obj) {
        this.h = new f.c(this.h, obj, settableBeanProperty);
    }

    public final boolean d(String str) {
        ObjectIdReader objectIdReader = this.f8726c;
        if (objectIdReader == null || !str.equals(objectIdReader.f3929b.f3755a)) {
            return false;
        }
        this.f8731i = objectIdReader.f3932e.d(this.f8724a, this.f8725b);
        return true;
    }
}
