package io.ktor.util;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J(\u0010\u0005\u001a\u00028\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&¢\u0006\u0004\b\u0007\u0010\u0006J\u001c\u0010\t\u001a\u00020\b2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H¦\u0002¢\u0006\u0004\b\t\u0010\nJ/\u0010\r\u001a\u00020\f\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0004\b\r\u0010\u000eJ0\u0010\u000f\u001a\u00020\f\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u000b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ'\u0010\u0010\u001a\u00020\f\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0012\u001a\u00028\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0006J)\u0010\u0013\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0006J5\u0010\u0016\u001a\u00028\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00188&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001cÀ\u0006\u0003"}, d2 = {"Lio/ktor/util/Attributes;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/util/AttributeKey;", "key", "get", "(Lio/ktor/util/AttributeKey;)Ljava/lang/Object;", "getOrNull", "", "contains", "(Lio/ktor/util/AttributeKey;)Z", UxipConstants.f30680s, "LY8/t;", "put", "(Lio/ktor/util/AttributeKey;Ljava/lang/Object;)V", "set", "remove", "(Lio/ktor/util/AttributeKey;)V", "take", "takeOrNull", "Lkotlin/Function0;", "block", "computeIfAbsent", "(Lio/ktor/util/AttributeKey;Lp9/a;)Ljava/lang/Object;", "", "getAllKeys", "()Ljava/util/List;", "allKeys", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface Attributes {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <T> T get(Attributes attributes, AttributeKey<T> key) {
            kotlin.jvm.internal.p.i(key, "key");
            return (T) Attributes.super.get(key);
        }

        @Deprecated
        public static <T> void set(Attributes attributes, AttributeKey<T> key, T value) {
            kotlin.jvm.internal.p.i(key, "key");
            kotlin.jvm.internal.p.i(value, "value");
            Attributes.super.set(key, value);
        }

        @Deprecated
        public static <T> T take(Attributes attributes, AttributeKey<T> key) {
            kotlin.jvm.internal.p.i(key, "key");
            return (T) Attributes.super.take(key);
        }

        @Deprecated
        public static <T> T takeOrNull(Attributes attributes, AttributeKey<T> key) {
            kotlin.jvm.internal.p.i(key, "key");
            return (T) Attributes.super.takeOrNull(key);
        }
    }

    <T> T computeIfAbsent(AttributeKey<T> key, InterfaceC5063a<? extends T> block);

    boolean contains(AttributeKey<?> key);

    default <T> T get(AttributeKey<T> key) {
        kotlin.jvm.internal.p.i(key, "key");
        T t10 = (T) getOrNull(key);
        if (t10 != null) {
            return t10;
        }
        throw new IllegalStateException("No instance for key " + key);
    }

    List<AttributeKey<?>> getAllKeys();

    <T> T getOrNull(AttributeKey<T> key);

    <T> void put(AttributeKey<T> key, T value);

    <T> void remove(AttributeKey<T> key);

    default <T> void set(AttributeKey<T> key, T value) {
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(value, "value");
        put(key, value);
    }

    default <T> T take(AttributeKey<T> key) {
        kotlin.jvm.internal.p.i(key, "key");
        T t10 = (T) get(key);
        remove(key);
        return t10;
    }

    default <T> T takeOrNull(AttributeKey<T> key) {
        kotlin.jvm.internal.p.i(key, "key");
        T t10 = (T) getOrNull(key);
        remove(key);
        return t10;
    }
}
