package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class JdkDeserializers {
    private static final HashSet<String> _classNames = new HashSet<>();

    static {
        Class[] clsArr = {UUID.class, AtomicBoolean.class, AtomicInteger.class, AtomicLong.class, StackTraceElement.class, ByteBuffer.class, Void.class, ThreadGroup.class};
        for (int i = 0; i < 8; i++) {
            _classNames.add(clsArr[i].getName());
        }
        for (Class<?> cls : FromStringDeserializer.types()) {
            _classNames.add(cls.getName());
        }
    }

    public static JsonDeserializer<?> find(DeserializationContext deserializationContext, Class<?> cls, String str) {
        if (!_classNames.contains(str)) {
            return null;
        }
        FromStringDeserializer<?> fromStringDeserializerFindDeserializer = FromStringDeserializer.findDeserializer(cls);
        if (fromStringDeserializerFindDeserializer != null) {
            return fromStringDeserializerFindDeserializer;
        }
        if (cls == UUID.class) {
            return new UUIDDeserializer();
        }
        if (cls == StackTraceElement.class) {
            return StackTraceElementDeserializer.construct(deserializationContext);
        }
        if (cls == AtomicBoolean.class) {
            return new AtomicBooleanDeserializer();
        }
        if (cls == AtomicInteger.class) {
            return new AtomicIntegerDeserializer();
        }
        if (cls == AtomicLong.class) {
            return new AtomicLongDeserializer();
        }
        if (cls == ByteBuffer.class) {
            return new ByteBufferDeserializer();
        }
        if (cls == Void.class) {
            return NullifyingDeserializer.instance;
        }
        if (cls == ThreadGroup.class) {
            return new ThreadGroupDeserializer();
        }
        return null;
    }

    public static boolean hasDeserializerFor(Class<?> cls) {
        return _classNames.contains(cls.getName());
    }
}
