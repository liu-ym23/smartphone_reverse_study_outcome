package com.bytedance.android.anya;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.SubStatePropertyImpl;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public abstract class MVIState<STATE extends MVIState<STATE>> {
    public final l<STATE> dynamicStates;
    public volatile int maxVersion;
    public final Set<com.bytedance.android.anya.internal.c<?, ?>> modifiedProperties;
    public volatile Function0<Unit> notifyParentNodeChange;
    public final LinkedHashMap<String, com.bytedance.android.anya.internal.c<?, ?>> properties;
    public final Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> propertyAddedCallback;
    public final Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> propertyChangeCallback;

    public final class a implements l<STATE> {
        public a() {
            new LinkedHashMap();
        }
    }

    public static /* synthetic */ void maxVersion$annotations() {
    }

    public static /* synthetic */ void modifiedProperties$annotations() {
    }

    public static /* synthetic */ void notifyParentNodeChange$annotations() {
    }

    public static /* synthetic */ void properties$annotations() {
    }

    public static /* synthetic */ void propertyAddedCallback$annotations() {
    }

    public static /* synthetic */ void propertyChangeCallback$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void clearModifyState$runtime_release() {
        Iterator<T> r100 = this.modifiedProperties.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        com.bytedance.android.anya.internal.c r101 = (com.bytedance.android.anya.internal.c) r100.next();
        r101.f41674c = 0;
        if ((r101 instanceof SubStatePropertyImpl) == false) goto L4;
        ((MVIState) ((SubStatePropertyImpl) r101).c()).clearModifyState$runtime_release();
        goto L4
    L8:
        this.modifiedProperties.clear();
        this.maxVersion = 0;
    }

    public String toString() {
        return StringsKt.trimMargin$default("{\n            |\"type\": \"" + Reflection.getOrCreateKotlinClass(getClass()).getQualifiedName() + "\", \n            |\"properties\": [" + CollectionsKt.joinToString$default(this.properties.values(), ",", null, null, 0, null, AnonymousClass1.INSTANCE, 30, null) + "], \n            |\"modified\": [" + CollectionsKt.joinToString$default(this.modifiedProperties, ",", null, null, 0, null, AnonymousClass2.INSTANCE, 30, null) + "]\n            | } ", null, 1, null);
    }

    public MVIState() {
        this.dynamicStates = new a();
        this.properties = new LinkedHashMap();
        this.modifiedProperties = new LinkedHashSet();
        this.maxVersion = -1;
        this.propertyAddedCallback = (Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit>) new MVIState$propertyAddedCallback$1(this);
        this.propertyChangeCallback = (Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit>) new MVIState$propertyChangeCallback$1(this);
    }

    public final <T> v.a<STATE, T, r0<STATE, T>> property(T r100) {
        return new com.bytedance.android.anya.internal.o(new com.bytedance.android.anya.internal.r(r100, this.propertyChangeCallback, this.propertyAddedCallback));
    }

    public final /* synthetic */ <T extends x<T>> v.a<STATE, T, o0<STATE, T>> reflexState(T r100) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new com.bytedance.android.anya.internal.o(new com.bytedance.android.anya.internal.q(x.class, r100, this.propertyChangeCallback, this.propertyAddedCallback));
    }

    public final <T> com.bytedance.android.anya.internal.r<STATE, T> simplePropertyImpl(T r100) {
        return new com.bytedance.android.anya.internal.r(r100, this.propertyChangeCallback, this.propertyAddedCallback);
    }

    public final /* synthetic */ <T extends MVIState<T>> v.a<STATE, s0<T>, t0<STATE, T>> stateList(List<? extends T> r100) {
        return new com.bytedance.android.anya.internal.o(new com.bytedance.android.anya.internal.u(r100, this.propertyChangeCallback, this.propertyAddedCallback));
    }

    public final <T extends MVIState<T>> com.bytedance.android.anya.internal.u<STATE, T> stateListImpl(List<? extends T> r100) {
        return new com.bytedance.android.anya.internal.u(r100, this.propertyChangeCallback, this.propertyAddedCallback);
    }

    public final /* synthetic */ <T extends MVIState<T>> v.a<STATE, T, u0<STATE, T>> subState(T r100) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new com.bytedance.android.anya.internal.o(new SubStatePropertyImpl(MVIState.class, r100, this.propertyChangeCallback, this.propertyAddedCallback));
    }

    @Deprecated(message = "try data layer instead.")
    public r toBusinessState(k0<STATE, ?> r100) {
        throw new IllegalStateException("Not implemented!".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final r toBusinessStateImpl(k0<?, ?> r100) {
        return toBusinessState(r100);
    }

    public final <T extends x<T>> com.bytedance.android.anya.internal.q<STATE, T> reflexStateImpl(Class<T> r100, T r101) {
        return new com.bytedance.android.anya.internal.q(r100, r101, this.propertyChangeCallback, this.propertyAddedCallback);
    }

    public final <T extends MVIState<?>> SubStatePropertyImpl<STATE, T> subStateImpl(Class<T> r100, T r101) {
        return new SubStatePropertyImpl(r100, r101, this.propertyChangeCallback, this.propertyAddedCallback);
    }

    public static /* synthetic */ v.a subState$default(MVIState r100, MVIState r101, int r102, Object r103) {
        if (r103 != null) goto L13;
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        if (r100 == null) goto L11;
        return new com.bytedance.android.anya.internal.o(new SubStatePropertyImpl(MVIState.class, r101, r100.propertyChangeCallback, r100.propertyAddedCallback));
    L11:
        throw new TypeCastException("null cannot be cast to non-null type STATE");
    L13:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subState");
    }

    public static /* synthetic */ SubStatePropertyImpl subStateImpl$default(MVIState r100, Class r101, MVIState r102, int r103, Object r104) {
        if (r104 != null) goto L13;
        if ((r103 & 2) == 0) goto L7;
        r102 = null;
    L7:
        if (r100 == null) goto L11;
        return new SubStatePropertyImpl(r101, r102, r100.propertyChangeCallback, r100.propertyAddedCallback);
    L11:
        throw new TypeCastException("null cannot be cast to non-null type STATE");
    L13:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subStateImpl");
    }
}
