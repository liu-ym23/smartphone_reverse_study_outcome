package com.fasterxml.jackson.databind.j.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: StdJdkSerializers.java */
/* JADX INFO: loaded from: classes2.dex */
public class af {

    /* JADX INFO: compiled from: StdJdkSerializers.java */
    public static class a extends ai<AtomicBoolean> {
        @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
        public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
            a((AtomicBoolean) ZeusTransformUtils.preCheckCast(r3, AtomicBoolean.class, "com.obric.aiagent.plugin"), r4, r5);
        }

        public a() {
            super(AtomicBoolean.class, false);
        }

        public void a(AtomicBoolean r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3) {
            r2.a(r1.get());
        }
    }

    /* JADX INFO: compiled from: StdJdkSerializers.java */
    public static class b extends ai<AtomicInteger> {
        @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
        public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
            a((AtomicInteger) ZeusTransformUtils.preCheckCast(r3, AtomicInteger.class, "com.obric.aiagent.plugin"), r4, r5);
        }

        public b() {
            super(AtomicInteger.class, false);
        }

        public void a(AtomicInteger r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3) {
            r2.d(r1.get());
        }
    }

    /* JADX INFO: compiled from: StdJdkSerializers.java */
    public static class c extends ai<AtomicLong> {
        @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
        public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
            a((AtomicLong) ZeusTransformUtils.preCheckCast(r3, AtomicLong.class, "com.obric.aiagent.plugin"), r4, r5);
        }

        public c() {
            super(AtomicLong.class, false);
        }

        public void a(AtomicLong r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3) {
            r2.b(r1.get());
        }
    }

    public static Collection<Map.Entry<Class<?>, Object>> a() {
        HashMap r0 = new HashMap();
        r0.put(URL.class, new an(URL.class));
        r0.put(URI.class, new an(URI.class));
        r0.put(Currency.class, new an(Currency.class));
        r0.put(UUID.class, new aq());
        r0.put(Pattern.class, new an(Pattern.class));
        r0.put(Locale.class, new an(Locale.class));
        r0.put(AtomicBoolean.class, a.class);
        r0.put(AtomicInteger.class, b.class);
        r0.put(AtomicLong.class, c.class);
        r0.put(File.class, o.class);
        r0.put(Class.class, i.class);
        r0.put(Void.class, v.f12924a);
        r0.put(Void.TYPE, v.f12924a);
        return r0.entrySet();
    }
}
