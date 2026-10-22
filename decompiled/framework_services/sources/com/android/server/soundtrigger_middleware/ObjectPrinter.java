package com.android.server.soundtrigger_middleware;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
class ObjectPrinter {
    public static final int kDefaultMaxCollectionLength = 16;

    ObjectPrinter() {
    }

    static String print(Object obj, int maxCollectionLength) {
        StringBuilder builder = new StringBuilder();
        print(builder, obj, maxCollectionLength);
        return builder.toString();
    }

    static void print(StringBuilder builder, Object obj) {
        print(builder, obj, 16);
    }

    static void print(StringBuilder builder, Object obj, int maxCollectionLength) {
        if (obj != null) goto L8;
        builder.append("null");     // Catch: Exception -> L5
        return;
    L8:
        if ((obj instanceof Boolean) == false) goto L12;
        builder.append(obj);     // Catch: Exception -> L5
        return;
    L12:
        if ((obj instanceof Number) == false) goto L16;
        builder.append(obj);     // Catch: Exception -> L5
        return;
    L16:
        if ((obj instanceof Character) == false) goto L20;
        builder.append('\'');     // Catch: Exception -> L5
        builder.append(obj);     // Catch: Exception -> L5
        builder.append('\'');     // Catch: Exception -> L5
        return;
    L20:
        if ((obj instanceof String) == false) goto L23;
        builder.append('\"');     // Catch: Exception -> L5
        builder.append(obj.toString());     // Catch: Exception -> L5
        builder.append('\"');     // Catch: Exception -> L5
        return;
    L23:
        Class<?> r0 = obj.getClass();     // Catch: Exception -> L5
        if (Collection.class.isAssignableFrom(r0) == false) goto L40;
        Collection collection = (Collection) obj;     // Catch: Exception -> L5
        builder.append("[ ");     // Catch: Exception -> L5
        int length = collection.size();     // Catch: Exception -> L5
        boolean isLong = false;
        int i = 0;
        Iterator r9 = collection.iterator();     // Catch: Exception -> L5
    L28:
        if (r9.hasNext() == false) goto L35;
        Object child = r9.next();     // Catch: Exception -> L5
        if (i <= 0) goto L32;
        builder.append(", ");     // Catch: Exception -> L5
    L32:
        if (i >= maxCollectionLength) goto L33;
        print(builder, child, maxCollectionLength);     // Catch: Exception -> L5
        i = i + 1;     // Catch: Exception -> L5
        goto L28
    L33:
        isLong = true;
    L35:
        if (isLong == false) goto L37;
        builder.append("... (+");     // Catch: Exception -> L5
        builder.append(length - maxCollectionLength);     // Catch: Exception -> L5
        builder.append(" entries)");     // Catch: Exception -> L5
    L37:
        builder.append(" ]");     // Catch: Exception -> L5
        return;
    L40:
        if (Map.class.isAssignableFrom(r0) == false) goto L55;
        Map<?, ?> map = (Map) obj;     // Catch: Exception -> L5
        builder.append("< ");     // Catch: Exception -> L5
        int length2 = map.size();     // Catch: Exception -> L5
        boolean isLong2 = false;
        int i2 = 0;
        Iterator<Map.Entry<?, ?>> r8 = map.entrySet().iterator();     // Catch: Exception -> L5
    L43:
        if (r8.hasNext() == false) goto L50;
        Map.Entry<?, ?> child2 = r8.next();     // Catch: Exception -> L5
        if (i2 <= 0) goto L47;
        builder.append(", ");     // Catch: Exception -> L5
    L47:
        if (i2 >= maxCollectionLength) goto L48;
        print(builder, child2.getKey(), maxCollectionLength);     // Catch: Exception -> L5
        builder.append(": ");     // Catch: Exception -> L5
        print(builder, child2.getValue(), maxCollectionLength);     // Catch: Exception -> L5
        i2 = i2 + 1;     // Catch: Exception -> L5
        goto L43
    L48:
        isLong2 = true;
    L50:
        if (isLong2 == false) goto L52;
        builder.append("... (+");     // Catch: Exception -> L5
        builder.append(length2 - maxCollectionLength);     // Catch: Exception -> L5
        builder.append(" entries)");     // Catch: Exception -> L5
    L52:
        builder.append(" >");     // Catch: Exception -> L5
        return;
    L55:
        if (r0.isArray() == false) goto L67;
        builder.append("[ ");     // Catch: Exception -> L5
        int length3 = Array.getLength(obj);     // Catch: Exception -> L5
        boolean isLong3 = false;
        int i3 = 0;
    L57:
        if (i3 >= length3) goto L63;
        if (i3 <= 0) goto L60;
        builder.append(", ");     // Catch: Exception -> L5
    L60:
        if (i3 >= maxCollectionLength) goto L61;
        print(builder, Array.get(obj, i3), maxCollectionLength);     // Catch: Exception -> L5
        i3 = i3 + 1;     // Catch: Exception -> L5
        goto L57
    L61:
        isLong3 = true;
    L63:
        if (isLong3 == false) goto L65;
        builder.append("... (+");     // Catch: Exception -> L5
        builder.append(length3 - maxCollectionLength);     // Catch: Exception -> L5
        builder.append(" entries)");     // Catch: Exception -> L5
    L65:
        builder.append(" ]");     // Catch: Exception -> L5
        return;
    L67:
        builder.append(obj);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
