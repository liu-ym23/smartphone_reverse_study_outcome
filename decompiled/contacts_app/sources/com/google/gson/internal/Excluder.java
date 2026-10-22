package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT = null;
    private static final double IGNORE_VERSIONS = -1.0d;
    private List<ExclusionStrategy> deserializationStrategies;
    private int modifiers;
    private boolean requireExpose;
    private List<ExclusionStrategy> serializationStrategies;
    private boolean serializeInnerClasses;
    private double version;

    public Excluder() {
        this.version = IGNORE_VERSIONS;
        this.modifiers = 136;
        this.serializeInnerClasses = true;
        this.serializationStrategies = Collections.emptyList();
        this.deserializationStrategies = Collections.emptyList();
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    protected /* bridge */ /* synthetic */ Object m288clone() throws CloneNotSupportedException {
        return clone();
    }

    static {
        DEFAULT = new Excluder();
    }

    protected Excluder clone() {
        return (Excluder) super.clone();
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public Excluder withVersion(double r1) {
        Excluder r0 = clone();
        r0.version = r1;
        return r0;
    }

    public Excluder withModifiers(int... r5) {
        Excluder r4 = clone();
        int r0 = 0;
        r4.modifiers = 0;
        int r1 = r5.length;
    L3:
        if (r0 >= r1) goto L5;
        r4.modifiers = r5[r0] | r4.modifiers;
        r0 = r0 + 1;
        goto L3
    L5:
        return r4;
    }

    public Excluder disableInnerClassSerialization() {
        Excluder r1 = clone();
        r1.serializeInnerClasses = false;
        return r1;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder r1 = clone();
        r1.requireExpose = true;
        return r1;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy r3, boolean r4, boolean r5) {
        Excluder r0 = clone();
        if (r4 == false) goto L5;
        ArrayList r6 = new ArrayList(this.serializationStrategies);
        r0.serializationStrategies = r6;
        r6.add(r3);
    L5:
        if (r5 == false) goto L7;
        ArrayList r7 = new ArrayList(this.deserializationStrategies);
        r0.deserializationStrategies = r7;
        r7.add(r3);
    L7:
        return r0;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson r9, final TypeToken<T> r10) {
        Class<? super T> r0 = r10.getRawType();
        final boolean r5 = excludeClass(r0, true);
        final boolean r4 = excludeClass(r0, false);
        if (r5 == true) goto L8;
        if (r4 == true) goto L8;
        return null;
    L8:
        return new AnonymousClass1(this, r4, r5, r9, r10);
    }

    public boolean excludeField(Field r7, boolean r8) {
        if ((this.modifiers & r7.getModifiers()) == 0) goto L6;
        return true;
    L6:
        if (this.version == IGNORE_VERSIONS) goto L11;
        if (isValidVersion((Since) r7.getAnnotation(Since.class), (Until) r7.getAnnotation(Until.class)) == true) goto L11;
        return true;
    L11:
        if (r7.isSynthetic() == false) goto L14;
        return true;
    L14:
        if (this.requireExpose == false) goto L25;
        Expose r0 = (Expose) r7.getAnnotation(Expose.class);
        if (r0 == null) goto L23;
        if (r8 == false) goto L22;
        if (r0.serialize() == true) goto L25;
    L22:
        if (r0.deserialize() == true) goto L25;
    L23:
        return true;
    L25:
        if (excludeClass(r7.getType(), r8) == false) goto L27;
        return true;
    L27:
        if (r8 == false) goto L29;
        List<ExclusionStrategy> r6 = this.serializationStrategies;
    L31:
        if (r6.isEmpty() == true) goto L38;
        FieldAttributes r9 = new FieldAttributes(r7);
        Iterator<ExclusionStrategy> r10 = r6.iterator();
    L34:
        if (r10.hasNext() == false) goto L43;
        if (r10.next().shouldSkipField(r9) == false) goto L34;
        return true;
    L43:
        return false;
    L38:
        return false;
    L29:
        r6 = this.deserializationStrategies;
        goto L31
    }

    public boolean excludeClass(Class<?> r5, boolean r6) {
        if (this.version == IGNORE_VERSIONS) goto L8;
        if (isValidVersion((Since) r5.getAnnotation(Since.class), (Until) r5.getAnnotation(Until.class)) == true) goto L8;
        return true;
    L8:
        if (this.serializeInnerClasses == false) goto L10;
    L12:
        if (r6 == false) goto L14;
    L18:
        if (r6 == false) goto L20;
        List<ExclusionStrategy> r4 = this.serializationStrategies;
    L21:
        Iterator<ExclusionStrategy> r7 = r4.iterator();
    L23:
        if (r7.hasNext() == false) goto L27;
        if (r7.next().shouldSkipClass(r5) == false) goto L23;
        return true;
    L27:
        return false;
    L20:
        r4 = this.deserializationStrategies;
        goto L21
    L14:
        if (Enum.class.isAssignableFrom(r5) == true) goto L18;
        if (ReflectionHelper.isAnonymousOrNonStaticLocal(r5) == false) goto L18;
        return true;
    L10:
        if (isInnerClass(r5) == false) goto L12;
        return true;
    }

    private static boolean isInnerClass(Class<?> r1) {
        if (r1.isMemberClass() == true) goto L5;
    L7:
        return false;
    L5:
        if (ReflectionHelper.isStatic(r1) == true) goto L7;
        return true;
    }

    private boolean isValidVersion(Since r1, Until r2) {
        if (isValidSince(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (isValidUntil(r2) == false) goto L7;
        return true;
    }

    private boolean isValidSince(Since r4) {
        if (r4 == null) goto L9;
        double r1 = r4.value();
        if (this.version >= r1) goto L10;
        return false;
    L10:
        return true;
    L9:
        return true;
    }

    private boolean isValidUntil(Until r4) {
        if (r4 == null) goto L9;
        double r1 = r4.value();
        if (this.version < r1) goto L10;
        return false;
    L10:
        return true;
    L9:
        return true;
    }
}
