package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT = null;
    private static final double IGNORE_VERSIONS = -1.0d;
    private List<ExclusionStrategy> deserializationStrategies;
    private int modifiers;
    private boolean requireExpose;
    private List<ExclusionStrategy> serializationStrategies;
    private boolean serializeInnerClasses;
    private double version;

    static {
        DEFAULT = new Excluder();
    }

    public Excluder() {
        this.version = IGNORE_VERSIONS;
        this.modifiers = 136;
        this.serializeInnerClasses = true;
        this.serializationStrategies = Collections.emptyList();
        this.deserializationStrategies = Collections.emptyList();
    }

    private boolean excludeClassChecks(Class<?> r10) {
        if (this.version == IGNORE_VERSIONS) goto L8;
        if (isValidVersion((Since) r10.getAnnotation(Since.class), (Until) r10.getAnnotation(Until.class)) == true) goto L8;
        return true;
    L8:
        if (this.serializeInnerClasses == true) goto L13;
        if (isInnerClass(r10) == false) goto L13;
        return true;
    L13:
        if (isAnonymousOrLocal(r10) == false) goto L15;
        return true;
    L15:
        return false;
    }

    private boolean excludeClassInStrategy(Class<?> r10, boolean r11) {
        if (r11 == false) goto L4;
        List<ExclusionStrategy> r12 = this.serializationStrategies;
    L5:
        Iterator<ExclusionStrategy> r13 = r12.iterator();
    L7:
        if (r13.hasNext() == false) goto L12;
        if (r13.next().shouldSkipClass(r10) == false) goto L7;
        return true;
    L12:
        return false;
    L4:
        r12 = this.deserializationStrategies;
        goto L5
    }

    private boolean isAnonymousOrLocal(Class<?> r10) {
        if (Enum.class.isAssignableFrom(r10) == false) goto L5;
    L9:
        return false;
    L5:
        if (r10.isAnonymousClass() == false) goto L7;
    L8:
        return true;
    L7:
        if (r10.isLocalClass() == false) goto L9;
        goto L8
    }

    private boolean isInnerClass(Class<?> r10) {
        if (r10.isMemberClass() == true) goto L5;
    L7:
        return false;
    L5:
        if (isStatic(r10) == true) goto L7;
        return true;
    }

    private boolean isStatic(Class<?> r10) {
        if ((r10.getModifiers() & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isValidSince(Since r10) {
        if (r10 != null) goto L4;
        return true;
    L4:
        if (r10.value() <= this.version) goto L9;
        return false;
    L9:
        return true;
    }

    private boolean isValidUntil(Until r10) {
        if (r10 != null) goto L4;
        return true;
    L4:
        if (r10.value() > this.version) goto L9;
        return false;
    L9:
        return true;
    }

    private boolean isValidVersion(Since r10, Until r11) {
        if (isValidSince(r10) == true) goto L5;
    L7:
        return false;
    L5:
        if (isValidUntil(r11) == false) goto L7;
        return true;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m10clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson r12, final TypeToken<T> r13) {
        Class<? super T> r10 = r13.getRawType();
        boolean r11 = excludeClassChecks(r10);
        if (r11 == false) goto L5;
    L8:
        final boolean r14 = true;
    L9:
        if (r11 == false) goto L11;
    L14:
        final boolean r15 = true;
    L15:
        if (r14 == true) goto L20;
        if (r15 == true) goto L20;
        return null;
    L20:
        return new AnonymousClass1(this, r15, r14, r12, r13);
    L11:
        if (excludeClassInStrategy(r10, false) == true) goto L14;
        r15 = false;
        goto L15
    L5:
        if (excludeClassInStrategy(r10, true) == true) goto L8;
        r14 = false;
        goto L9
    }

    public Excluder disableInnerClassSerialization() {
        Excluder r10 = clone();
        r10.serializeInnerClasses = false;
        return r10;
    }

    public boolean excludeClass(Class<?> r10, boolean r11) {
        if (excludeClassChecks(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (excludeClassInStrategy(r10, r11) == true) goto L8;
        return false;
    }

    public boolean excludeField(Field r10, boolean r11) {
        if ((this.modifiers & r10.getModifiers()) == 0) goto L6;
        return true;
    L6:
        if (this.version == IGNORE_VERSIONS) goto L11;
        if (isValidVersion((Since) r10.getAnnotation(Since.class), (Until) r10.getAnnotation(Until.class)) == true) goto L11;
        return true;
    L11:
        if (r10.isSynthetic() == false) goto L14;
        return true;
    L14:
        if (this.requireExpose == false) goto L25;
        Expose r12 = (Expose) r10.getAnnotation(Expose.class);
        if (r12 == null) goto L23;
        if (r11 == false) goto L22;
        if (r12.serialize() == true) goto L25;
    L22:
        if (r12.deserialize() == true) goto L25;
    L23:
        return true;
    L25:
        if (this.serializeInnerClasses == true) goto L30;
        if (isInnerClass(r10.getType()) == false) goto L30;
        return true;
    L30:
        if (isAnonymousOrLocal(r10.getType()) == false) goto L32;
        return true;
    L32:
        if (r11 == false) goto L34;
        List<ExclusionStrategy> r13 = this.serializationStrategies;
    L36:
        if (r13.isEmpty() == true) goto L43;
        FieldAttributes r14 = new FieldAttributes(r10);
        Iterator<ExclusionStrategy> r15 = r13.iterator();
    L39:
        if (r15.hasNext() == false) goto L48;
        if (r15.next().shouldSkipField(r14) == false) goto L39;
        return true;
    L48:
        return false;
    L43:
        return false;
    L34:
        r13 = this.deserializationStrategies;
        goto L36
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder r10 = clone();
        r10.requireExpose = true;
        return r10;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy r10, boolean r11, boolean r12) {
        Excluder r13 = clone();
        if (r11 == false) goto L5;
        ArrayList r14 = new ArrayList(this.serializationStrategies);
        r13.serializationStrategies = r14;
        r14.add(r10);
    L5:
        if (r12 == false) goto L7;
        ArrayList r15 = new ArrayList(this.deserializationStrategies);
        r13.deserializationStrategies = r15;
        r15.add(r10);
    L7:
        return r13;
    }

    public Excluder withModifiers(int... r10) {
        Excluder r11 = clone();
        int r12 = 0;
        r11.modifiers = 0;
        int r13 = r10.length;
    L3:
        if (r12 >= r13) goto L5;
        r11.modifiers = r10[r12] | r11.modifiers;
        r12 = r12 + 1;
        goto L3
    L5:
        return r11;
    }

    public Excluder withVersion(double r10) {
        Excluder r11 = clone();
        r11.version = r10;
        return r11;
    }

    public Excluder clone() {
        return (Excluder) super.clone();
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }
}
