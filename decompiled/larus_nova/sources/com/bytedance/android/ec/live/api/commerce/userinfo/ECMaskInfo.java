package com.bytedance.android.ec.live.api.commerce.userinfo;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0007R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECMaskInfo;", "", "Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECMaskInfo$Type;", "type", "Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECMaskInfo$Type;", "getType", "()Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECMaskInfo$Type;", "Type", "ecom-live-api_release"}, k = 1, mv = {1, 4, 3})
public final class ECMaskInfo {

    @SerializedName("type")
    private final Type type;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECMaskInfo$Type;", "", "UNKNOWN", "GOLD", "RED", "ecom-live-api_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Type extends Enum<Type> {

        @SerializedName("1")
        public static final Type GOLD = null;

        @SerializedName("2")
        public static final Type RED = null;

        @SerializedName("0")
        public static final Type UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f47842a = null;

        static {
            Type r100 = new Type("UNKNOWN", 0);
            UNKNOWN = r100;
            Type r101 = new Type("GOLD", 1);
            GOLD = r101;
            Type r102 = new Type("RED", 2);
            RED = r102;
            f47842a = new Type[]{r100, r101, r102};
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) f47842a.clone();
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECMaskInfo) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.type, ((ECMaskInfo) r100).type) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Type r100 = this.type;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "ECMaskInfo(type=" + this.type + ")";
    }

    public ECMaskInfo() {
        Type r100 = Type.UNKNOWN;
        Intrinsics.checkNotNullParameter(r100, "type");
        this.type = r100;
    }

    public final Type getType() {
        return this.type;
    }
}
