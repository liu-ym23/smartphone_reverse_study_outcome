package com.fasterxml.jackson.databind.cfg;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class ContextAttributes {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Impl extends ContextAttributes implements Serializable {

        /* renamed from: c, reason: collision with root package name */
        public static final Impl f3814c;

        /* renamed from: d, reason: collision with root package name */
        public static final Object f3815d;

        /* renamed from: a, reason: collision with root package name */
        public final Map<?, ?> f3816a;

        /* renamed from: b, reason: collision with root package name */
        public final transient HashMap f3817b;

        static {
            Map map = Collections.EMPTY_MAP;
            f3814c = new Impl();
            f3815d = new Object();
        }

        public Impl() {
            this.f3816a = Collections.EMPTY_MAP;
            this.f3817b = null;
        }

        public Impl(Map map, HashMap map2) {
            this.f3816a = map;
            this.f3817b = map2;
        }
    }
}
