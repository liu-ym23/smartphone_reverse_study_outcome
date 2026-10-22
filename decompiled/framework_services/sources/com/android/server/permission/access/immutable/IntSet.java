package com.android.server.permission.access.immutable;

import android.util.SparseBooleanArray;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: IntSet.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class IntSet implements Immutable<MutableIntSet> {
    private final SparseBooleanArray array;

    public /* synthetic */ IntSet(SparseBooleanArray r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    private IntSet(SparseBooleanArray array) {
        this.array = array;
    }

    public final SparseBooleanArray getArray$frameworks__base__services__permission__android_common__services_permission_pre_jarjar() {
        return this.array;
    }

    @Override // com.android.server.permission.access.immutable.Immutable
    public /* bridge */ /* synthetic */ MutableIntSet toMutable() {
        return toMutable();
    }

    public final int getSize() {
        return this.array.size();
    }

    public final int elementAt(int index) {
        return this.array.keyAt(index);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.server.permission.access.immutable.Immutable
    public MutableIntSet toMutable() {
        return new MutableIntSet(this);
    }

    public String toString() {
        return this.array.toString();
    }
}
