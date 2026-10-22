package com.fasterxml.jackson.core.util;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class InternCache extends ConcurrentHashMap<String, String> {

    /* renamed from: b, reason: collision with root package name */
    public static final InternCache f3643b = new InternCache();

    /* renamed from: a, reason: collision with root package name */
    public final Object f3644a;

    private InternCache() {
        super(180, 0.8f, 4);
        this.f3644a = new Object();
    }

    public final String a(String str) {
        String str2 = get(str);
        if (str2 != null) {
            return str2;
        }
        if (size() >= 180) {
            synchronized (this.f3644a) {
                try {
                    if (size() >= 180) {
                        clear();
                    }
                } finally {
                }
            }
        }
        String strIntern = str.intern();
        put(strIntern, strIntern);
        return strIntern;
    }
}
