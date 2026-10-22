package com.android.ttcjpaysdk.base.settings.abtest;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B%\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0002\u0010\bB-\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0002\u0010\nB5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\u000b\u001a\u00028\u0000\u0012\u0006\u0010\f\u001a\u00028\u0000\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006HÆ\u0003J\u000e\u0010\u0019\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u001a\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003JL\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\b\b\u0002\u0010\u000b\u001a\u00028\u00002\b\b\u0002\u0010\f\u001a\u00028\u00002\b\b\u0002\u0010\t\u001a\u00020\u0004HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0004HÖ\u0001J\u0015\u0010$\u001a\u00028\u00002\b\b\u0002\u0010%\u001a\u00020\u001f¢\u0006\u0002\u0010&R\u0013\u0010\u000b\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\f\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006'"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/abtest/CJPayExperimentValue;", ExifInterface.GPS_DIRECTION_TRUE, "", "key", "", "type", "Ljava/lang/Class;", "defaultValue", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;)V", "serverKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;)V", "defaultValue1", "defaultValue2", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;)V", "getDefaultValue1", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getDefaultValue2", "getKey", "()Ljava/lang/String;", "getServerKey", "getType", "()Ljava/lang/Class;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;)Lcom/android/ttcjpaysdk/base/settings/abtest/CJPayExperimentValue;", "equals", "", "other", "hashCode", "", "toString", "value", "isExposure", "(Z)Ljava/lang/Object;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayExperimentValue<T> {
    private final T defaultValue1;
    private final T defaultValue2;
    private final String key;
    private final String serverKey;
    private final Class<T> type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CJPayExperimentValue copy$default(CJPayExperimentValue r100, String r101, Class r102, Object r103, Object r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.key;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.type;
    L8:
        Class r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.defaultValue1;
    L11:
        Object r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.defaultValue2;
    L14:
        Object r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.serverKey;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.key;
    }

    public final Class<T> component2() {
        return this.type;
    }

    public final T component3() {
        return this.defaultValue1;
    }

    public final T component4() {
        return this.defaultValue2;
    }

    public final String component5() {
        return this.serverKey;
    }

    public final CJPayExperimentValue<T> copy(String r100, Class<T> r101, T r110, T r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r112, "serverKey");
        return new CJPayExperimentValue(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJPayExperimentValue) == true) goto L8;
        return false;
    L8:
        CJPayExperimentValue r101 = (CJPayExperimentValue) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.defaultValue1, r101.defaultValue1) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.defaultValue2, r101.defaultValue2) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.serverKey, r101.serverKey) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.key.hashCode() * 31) + this.type.hashCode()) * 31;
        T r101 = this.defaultValue1;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        T r105 = this.defaultValue2;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return ((r104 + r102) * 31) + this.serverKey.hashCode();
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "CJPayExperimentValue(key=" + this.key + ", type=" + this.type + ", defaultValue1=" + this.defaultValue1 + ", defaultValue2=" + this.defaultValue2 + ", serverKey=" + this.serverKey + ')';
    }

    public final T getDefaultValue1() {
        return this.defaultValue1;
    }

    public final T getDefaultValue2() {
        return this.defaultValue2;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getServerKey() {
        return this.serverKey;
    }

    public final Class<T> getType() {
        return this.type;
    }

    public final T value(final boolean r100) {
        T r101 = (T) CJPayABExperimentKt.tryGetWithNoClassDefCatch(new AnonymousClass1(this, r100));
        if (r101 == null) goto L5;
        return r101;
    L5:
        return this.defaultValue2;
    }

    public CJPayExperimentValue(String r110, Class<T> r111, T r112) {
        Intrinsics.checkNotNullParameter(r110, "key");
        Intrinsics.checkNotNullParameter(r111, "type");
        CJPayABExperimentUtils r100 = CJPayABExperimentUtils.INSTANCE;
        this(r110, r111, r100.getABValueFromSettings(r110, r111, r112), r100.getABValueFromSettings(r110, r111, r112), null, 16, null);
    }

    public CJPayExperimentValue(String r100, String r101, Class<T> r110, T r111) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "serverKey");
        Intrinsics.checkNotNullParameter(r110, "type");
        CJPayABExperimentUtils r102 = CJPayABExperimentUtils.INSTANCE;
        this(r100, r110, r102.getABValueFromSettings(r100, r110, r111), r102.getABValueFromSettings(r100, r110, r111), r101);
    }

    public static /* synthetic */ Object value$default(CJPayExperimentValue r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = true;
    L6:
        return r100.value(r101);
    }

    public CJPayExperimentValue(String r100, Class<T> r101, T r102, T r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r104, "serverKey");
        this.key = r100;
        this.type = r101;
        this.defaultValue1 = r102;
        this.defaultValue2 = r103;
        this.serverKey = r104;
    }

    public /* synthetic */ CJPayExperimentValue(String r100, Class r101, Object r102, Object r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 16) == 0) goto L5;
        r111 = "";
    L5:
        this(r100, r101, r102, r110, r111);
    }
}
