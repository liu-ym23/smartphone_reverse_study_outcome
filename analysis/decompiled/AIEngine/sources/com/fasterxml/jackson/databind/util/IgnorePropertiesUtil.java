package com.fasterxml.jackson.databind.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class IgnorePropertiesUtil {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Checker implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Set<String> f4506a;

        /* renamed from: b, reason: collision with root package name */
        public final Set<String> f4507b;

        public Checker(Set<String> set, Set<String> set2) {
            this.f4506a = set == null ? Collections.EMPTY_SET : set;
            this.f4507b = set2;
        }

        public final boolean a(Object obj) {
            Set<String> set = this.f4507b;
            return !(set == null || set.contains(obj)) || this.f4506a.contains(obj);
        }
    }

    public static Checker a(Set<String> set, Set<String> set2) {
        if (set2 == null && (set == null || set.isEmpty())) {
            return null;
        }
        return new Checker(set, set2);
    }

    public static boolean b(Object obj, Collection<String> collection, Collection<String> collection2) {
        if (collection == null && collection2 == null) {
            return false;
        }
        return collection2 == null ? collection.contains(obj) : collection == null ? !collection2.contains(obj) : !collection2.contains(obj) || collection.contains(obj);
    }
}
