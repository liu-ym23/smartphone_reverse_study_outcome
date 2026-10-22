package com.fasterxml.jackson.annotation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ObjectIdGenerator<T> implements Serializable {

    public static final class IdKey implements Serializable {
        private static final long serialVersionUID = 1;
        private final int hashCode;
        public final Object key;
        public final Class<?> scope;
        public final Class<?> type;

        public IdKey(Class<?> r1, Class<?> r2, Object r3) {
            if (r3 == null) goto L10;
            this.type = r1;
            this.scope = r2;
            this.key = r3;
            int r4 = r3.hashCode() + r1.getName().hashCode();
            if (r2 == null) goto L7;
            r4 = r4 ^ r2.getName().hashCode();
        L7:
            this.hashCode = r4;
            return;
        L10:
            throw new IllegalArgumentException("Can not construct IdKey for null key");
        }

        public int hashCode() {
            return this.hashCode;
        }

        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (r5 != null) goto L9;
            return false;
        L9:
            if (r5.getClass() == getClass()) goto L11;
            return false;
        L11:
            IdKey r6 = (IdKey) ZeusTransformUtils.preCheckCast(r5, IdKey.class, "com.obric.aiagent.plugin");
            if (r6.key.equals(this.key) == false) goto L19;
            if (r6.type != this.type) goto L19;
            if (r6.scope != this.scope) goto L19;
            return true;
        L19:
            return false;
        }

        public String toString() {
            Object[] r0 = new Object[3];
            r0[0] = this.key;
            Class<?> r1 = this.type;
            String r2 = "NONE";
            if (r1 != null) goto L5;
            String r3 = "NONE";
        L6:
            r0[1] = r3;
            Class<?> r4 = this.scope;
            if (r4 == null) goto L10;
            r2 = r4.getName();
        L10:
            r0[2] = r2;
            return String.format("[ObjectId: key=%s, type=%s, scope=%s]", r0);
        L5:
            r3 = r1.getName();
            goto L6
        }
    }

    public abstract boolean canUseFor(ObjectIdGenerator<?> r1);

    public abstract ObjectIdGenerator<T> forScope(Class<?> r1);

    public abstract T generateId(Object r1);

    public abstract Class<?> getScope();

    public boolean isValidReferencePropertyName(String r1, Object r2) {
        return false;
    }

    public abstract IdKey key(Object r1);

    public boolean maySerializeAsObject() {
        return false;
    }

    public abstract ObjectIdGenerator<T> newForSerialization(Object r1);

    public ObjectIdGenerator() {
    }
}
