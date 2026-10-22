package com.bytedance.android.shopping.prepurchase.arch.atom_event;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0005R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/arch/atom_event/i;", "", "", "key", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "value", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f180691a = 0;

    @SerializedName("key")
    private final String key;

    @SerializedName("value")
    private final Object value;

    public static final class a {
        public static i a(Map r100) {
            Object r101 = null;
            if (r100 == null) goto L5;
            Object r102 = r100.get("key");
        L7:
            if ((r102 instanceof String) == false) goto L10;
            r101 = r102;
        L10:
            String r103 = (String) r101;
            if (r103 != null) goto L13;
            r103 = "";
        L13:
            if (r100 == null) goto L16;
            Object r104 = r100.get("value");
            if (r104 == null) goto L16;
        L18:
            return new i(r103, r104);
        L16:
            r104 = "null";
            goto L18
        L5:
            r102 = null;
            goto L7
        }
    }

    static {
    }

    public i() {
        this("", null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L10;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.value, r101.value) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.key;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Object r104 = this.value;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PDPStorageActionAtomEventParam(key=" + this.key + ", value=" + this.value + ")";
    }

    public final String a() {
        return this.key;
    }

    public final Object b() {
        return this.value;
    }

    public i(String r100, Object r101) {
        this.key = r100;
        this.value = r101;
    }
}
