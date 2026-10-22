package com.bytedance.android.live.impl.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.k0;
import com.obric.miniapp.alarm.AccountType;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class SharedPrefHelper extends k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f69311a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f69312b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SharedPrefHelper f69313c = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/impl/utils/SharedPrefHelper$Type;", "", "STRING", "INTEGER", "BOOLEAN", "FLOAT", "LONG", "STRING_SET", AccountType.ALL, "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Type extends Enum<Type> {
        public static final Type ALL = null;
        public static final Type BOOLEAN = null;
        public static final Type FLOAT = null;
        public static final Type INTEGER = null;
        public static final Type LONG = null;
        public static final Type STRING = null;
        public static final Type STRING_SET = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f69314a = null;

        static {
            Type r100 = new Type("STRING", 0);
            STRING = r100;
            Type r101 = new Type("INTEGER", 1);
            INTEGER = r101;
            Type r102 = new Type("BOOLEAN", 2);
            BOOLEAN = r102;
            Type r103 = new Type("FLOAT", 3);
            FLOAT = r103;
            Type r104 = new Type("LONG", 4);
            LONG = r104;
            Type r105 = new Type("STRING_SET", 5);
            STRING_SET = r105;
            Type r106 = new Type(AccountType.ALL, 6);
            ALL = r106;
            f69314a = new Type[]{r100, r101, r102, r103, r104, r105, r106};
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) f69314a.clone();
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static SharedPreferences h() {
        return (SharedPreferences) f69312b.getValue();
    }

    static {
        f69313c = new SharedPrefHelper();
        f69311a = "liveai_feature_manager_sp";
        f69312b = LazyKt.lazy(SharedPrefHelper$spForLiveFeatureManager$2.INSTANCE);
    }

    public SharedPrefHelper() {
    }

    @Override // com.bytedance.android.live.core.utils.k0
    public final int a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r101 = g(r100, Type.INTEGER, 0);
        Intrinsics.checkNotNull(r101);
        return ((Number) r101).intValue();
    }

    @Override // com.bytedance.android.live.core.utils.k0
    public final JSONObject b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        String r101 = d(r100, null);
        if (r101 != null) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        return null;
    L11:
        return new JSONObject(r101);
    L10:
        return null;
    }

    @Override // com.bytedance.android.live.core.utils.k0
    public final long c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r101 = g(r100, Type.LONG, 0L);
        Intrinsics.checkNotNull(r101);
        return ((Number) r101).longValue();
    }

    @Override // com.bytedance.android.live.core.utils.k0
    public final String d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return (String) g(r100, Type.STRING, r101);
    }

    @Override // com.bytedance.android.live.core.utils.k0
    public final void e(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        SharedPreferences r102 = h();
        if (r102 == null) goto L5;
        SharedPreferences.Editor r103 = r102.edit();
    L6:
        if (r103 != null) goto L8;
        return;
    L8:
        if ((r101 instanceof String) == false) goto L11;
        r103.putString(r100, (String) r101);
    L26:
        r103.apply();
        return;
    L11:
        if ((r101 instanceof Integer) == false) goto L14;
        r103.putInt(r100, ((Number) r101).intValue());
        goto L26
    L14:
        if ((r101 instanceof Boolean) == false) goto L17;
        r103.putBoolean(r100, ((Boolean) r101).booleanValue());
        goto L26
    L17:
        if ((r101 instanceof Float) == false) goto L20;
        r103.putFloat(r100, ((Number) r101).floatValue());
        goto L26
    L20:
        if ((r101 instanceof Long) == false) goto L23;
        r103.putLong(r100, ((Number) r101).longValue());
        goto L26
    L23:
        if ((r101 instanceof Set) == false) goto L25;
        r103.putStringSet(r100, (Set) r101);
        goto L26
    L25:
        r103.putString(r100, r101.toString());
        goto L26
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.core.utils.k0
    public final void f(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        e(r100, r101.toString());
    }

    public static Object g(String r100, Type r101, Object r102) {
        switch(c.f69321a[r101.ordinal()]) {
            case 1: goto L32;
            case 2: goto L26;
            case 3: goto L21;
            case 4: goto L16;
            case 5: goto L11;
            case 6: goto L8;
            case 7: goto L5;
            default: goto L41;
        };
    L5:
        SharedPreferences r103 = h();
        if (r103 != null) goto L37;
    L35:
        return null;
    L37:
        return r103.getAll();
    L8:
        SharedPreferences r104 = h();
        if (r104 == null) goto L35;
        return r104.getStringSet(r100, (Set) r102);
    L11:
        Long r105 = (Long) r102;
        if (r105 == null) goto L35;
        long r106 = r105.longValue();
        f69313c.getClass();
        SharedPreferences r107 = h();
        if (r107 == null) goto L35;
        Object r108 = Long.valueOf(r107.getLong(r100, r106));
    L39:
        return r108;
    L16:
        Float r109 = (Float) r102;
        if (r109 == null) goto L35;
        float r110 = r109.floatValue();
        f69313c.getClass();
        SharedPreferences r111 = h();
        if (r111 == null) goto L35;
        r108 = Float.valueOf(r111.getFloat(r100, r110));
        goto L39
    L21:
        Boolean r112 = (Boolean) r102;
        if (r112 == null) goto L35;
        boolean r113 = r112.booleanValue();
        f69313c.getClass();
        SharedPreferences r114 = h();
        if (r114 == null) goto L35;
        r108 = Boolean.valueOf(r114.getBoolean(r100, r113));
        goto L39
    L26:
        Integer r115 = (Integer) r102;
        if (r115 == null) goto L35;
        int r116 = r115.intValue();
        f69313c.getClass();
        SharedPreferences r117 = h();
        if (r117 == null) goto L35;
        r108 = Integer.valueOf(r117.getInt(r100, r116));
        goto L39
    L32:
        SharedPreferences r118 = h();
        if (r118 == null) goto L35;
        return r118.getString(r100, (String) r102);
    L41:
        return r102;
    }
}
