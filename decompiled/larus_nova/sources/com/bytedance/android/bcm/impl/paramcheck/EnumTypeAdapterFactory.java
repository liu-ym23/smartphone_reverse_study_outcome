package com.bytedance.android.bcm.impl.paramcheck;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/bcm/impl/paramcheck/EnumTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "<init>", "()V", "BasicType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "bcm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class EnumTypeAdapterFactory implements TypeAdapterFactory {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/bcm/impl/paramcheck/EnumTypeAdapterFactory$BasicType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "INT", "STRING", "LONG", "DOUBLE", "BOOLEAN", "bcm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
    public static final enum BasicType extends Enum<BasicType> {
        public static final BasicType BOOLEAN = null;
        public static final a Companion = null;
        public static final BasicType DOUBLE = null;
        public static final BasicType INT = null;
        public static final BasicType LONG = null;
        public static final BasicType STRING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BasicType[] f41851a = null;
        private String value;

        public static final class a {
            public a() {
            }
        }

        static {
            BasicType r100 = new BasicType("INT", 0, "int");
            INT = r100;
            BasicType r101 = new BasicType("STRING", 1, "java.lang.String");
            STRING = r101;
            BasicType r102 = new BasicType("LONG", 2, "long");
            LONG = r102;
            BasicType r103 = new BasicType("DOUBLE", 3, ItemStyle.ITEM_STYLE_DOUBLE);
            DOUBLE = r103;
            BasicType r104 = new BasicType("BOOLEAN", 4, "boolean");
            BOOLEAN = r104;
            f41851a = new BasicType[]{r100, r101, r102, r103, r104};
            Companion = new a();
        }

        public static BasicType valueOf(String r100) {
            return (BasicType) r27.a.a(BasicType.class, r100);
        }

        public static BasicType[] values() {
            return (BasicType[]) f41851a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public final void setValue(String r100) {
            this.value = r100;
        }

        public BasicType(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f41852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BasicType f41853b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f41852a, r101.f41852a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f41853b, r101.f41853b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            Object r100 = this.f41852a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            BasicType r104 = this.f41853b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ValueType(value=" + this.f41852a + ", type=" + this.f41853b + ")";
        }

        public final BasicType getType() {
            return this.f41853b;
        }

        public a(Object r100, BasicType r101) {
            this.f41852a = r100;
            this.f41853b = r101;
        }
    }

    public EnumTypeAdapterFactory() {
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final <T> TypeAdapter<T> create(Gson r110, TypeToken<T> r111) {
        if (r111.getRawType().isEnum() == true) goto L5;
        return null;
    L5:
        final LinkedHashMap r112 = new LinkedHashMap();
        Object[] r113 = r111.getRawType().getEnumConstants();
        if (r113 == null) goto L74;
        ArrayList r100 = new ArrayList();
        int r101 = r113.length;
        int r102 = 0;
    L8:
        boolean r103 = true;
        if (r102 >= r101) goto L17;
        Object r104 = r113[r102];
        if (r104 != null) goto L14;
        r103 = false;
    L14:
        if (r103 == false) goto L16;
        r100.add(r104);
    L16:
        r102 = r102 + 1;
        goto L8
    L17:
        Iterator<T> r114 = r100.iterator();
    L19:
        if (r114.hasNext() == false) goto L74;
        T r105 = r114.next();
        if (r105 != null) goto L23;
        Intrinsics.throwNpe();
    L23:
        if (r105 == null) goto L72;
        SerializedName r106 = (SerializedName) r105.getClass().getField(r105.toString()).getAnnotation(SerializedName.class);
        if (r106 != null) goto L26;
        Field[] r107 = r105.getClass().getDeclaredFields();
        int r108 = r107.length;
        int r109 = 0;
    L28:
        if (r109 >= r108) goto L39;
        Field r115 = r107[r109];
        BasicType.a r116 = BasicType.Companion;
        String r117 = r115.getType().getName();
        r116.getClass();
        BasicType[] r118 = BasicType.values();
        int r119 = r118.length;
        int r120 = 0;
    L30:
        if (r120 >= r119) goto L35;
        if (Intrinsics.areEqual(r118[r120].getValue(), r117) == true) goto L33;
        r120 = r120 + 1;
        goto L30
    L33:
        boolean r121 = true;
    L36:
        if (r121 == true) goto L40;
        r109 = r109 + 1;
    L40:
        if (r115 != null) goto L41;
        r112.put(r105, new a(r105.toString(), BasicType.STRING));
        goto L19
    L41:
        r115.setAccessible(true);
        BasicType.a r122 = BasicType.Companion;
        String r123 = r115.getType().getName();
        r122.getClass();
        BasicType[] r124 = BasicType.values();
        int r125 = r124.length;
        int r126 = 0;
    L42:
        if (r126 >= r125) goto L69;
        BasicType r127 = r124[r126];
        if (Intrinsics.areEqual(r127.getValue(), r123) == true) goto L45;
        r126 = r126 + 1;
        goto L42
    L45:
        int r128 = b.f41867a[r127.ordinal()];
        if (r128 != 1) goto L48;
        Object r129 = Integer.valueOf(r115.getInt(r105));
    L66:
        r112.put(r105, new a(r129, r127));
        goto L19
    L48:
        if (r128 != 2) goto L50;
        Object r130 = r115.get(r105);
        if (r130 == null) goto L64;
        r129 = (String) r130;
        goto L66
    L64:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    L50:
        if (r128 != 3) goto L52;
        r129 = Long.valueOf(r115.getLong(r105));
        goto L66
    L52:
        if (r128 != 4) goto L54;
        r129 = Double.valueOf(r115.getDouble(r105));
        goto L66
    L54:
        if (r128 != 5) goto L57;
        r129 = Boolean.valueOf(r115.getBoolean(r105));
        goto L66
    L57:
        throw new NoWhenBranchMatchedException();
    L69:
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    L35:
        r121 = false;
        goto L36
    L39:
        r115 = null;
        goto L40
    L26:
        r112.put(r105, new a(r106.value(), BasicType.STRING));
        goto L19
    L72:
        throw new TypeCastException("null cannot be cast to non-null type T");
    L74:
        return new AnonymousClass3(r112);
    }
}
