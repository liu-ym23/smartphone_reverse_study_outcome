package com.bytedance.rpc.internal;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MapBuilder {

    /* JADX INFO: renamed from: com.bytedance.rpc.internal.MapBuilder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder<K, V> {
        private Map mMap;
        private boolean mUnderConstruction;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.mMap = MapBuilder.of(16);
            this.mUnderConstruction = true;
        }

        public Builder<K, V> put(K r2, V r3) {
            if (this.mUnderConstruction == false) goto L7;
            this.mMap.put(r2, r3);
            return this;
        L7:
            throw new IllegalStateException("Underlying map has already been built");
        }

        public Map<K, V> build() {
            if (this.mUnderConstruction == false) goto L7;
            this.mUnderConstruction = false;
            return this.mMap;
        L7:
            throw new IllegalStateException("Underlying map has already been built");
        }
    }

    public MapBuilder() {
    }

    public static <K, V> Map<K, V> of(int r1) {
        if (r1 > 0) goto L6;
        r1 = 8;
    L6:
        return new HashMap(r1);
    }

    public static <K, V> Map<K, V> of(K r1, V r2) {
        Map<K, V> r0 = of(2);
        r0.put(r1, r2);
        return r0;
    }

    public static <K, V> Map<K, V> of(K r1, V r2, K r3, V r4) {
        Map<K, V> r0 = of(4);
        r0.put(r1, r2);
        r0.put(r3, r4);
        return r0;
    }

    public static <K, V> Map<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6) {
        Map<K, V> r0 = of(8);
        r0.put(r1, r2);
        r0.put(r3, r4);
        r0.put(r5, r6);
        return r0;
    }

    public static <K, V> Map<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6, K r7, V r8) {
        Map<K, V> r0 = of(8);
        r0.put(r1, r2);
        r0.put(r3, r4);
        r0.put(r5, r6);
        r0.put(r7, r8);
        return r0;
    }

    public static <K, V> Map<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10) {
        Map<K, V> r0 = of(16);
        r0.put(r1, r2);
        r0.put(r3, r4);
        r0.put(r5, r6);
        r0.put(r7, r8);
        r0.put(r9, r10);
        return r0;
    }

    public static <K, V> Map<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10, K r11, V r12) {
        Map<K, V> r0 = of(16);
        r0.put(r1, r2);
        r0.put(r3, r4);
        r0.put(r5, r6);
        r0.put(r7, r8);
        r0.put(r9, r10);
        r0.put(r11, r12);
        return r0;
    }

    public static final <K, V> void put(Map<K, V> r1, K r2, V r3) {
        if (r1 == null) goto L13;
        if (r2 != null) goto L5;
        return;
    L5:
        if ((r2 instanceof CharSequence) == true) goto L7;
    L9:
        if (r3 != null) goto L11;
        r1.remove(r2);
        return;
    L11:
        r1.put(r2, r3);
        return;
    L7:
        if (RpcUtils.isInvisible((CharSequence) r2) == false) goto L9;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> void put(Map<K, V> r1, Map<K, V> r2) {
        if (r1 == null) goto L8;
        if (r2 != 0) goto L5;
        return;
    L5:
        if (r2.isEmpty() == true) goto L10;
        r1.putAll(r2);
        return;
    L10:
        return;
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder(null);
    }
}
