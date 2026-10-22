package com.bytedance.android.live.impl.utils;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.k0;
import com.bytedance.keva.Keva;
import com.obric.miniapp.alarm.AccountType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class KevaHelper extends k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f69308a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final KevaHelper f69309b = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/impl/utils/KevaHelper$Type;", "", "STRING", "INTEGER", "BOOLEAN", "FLOAT", "LONG", "STRING_SET", AccountType.ALL, "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Type extends Enum<Type> {
        public static final Type ALL = null;
        public static final Type BOOLEAN = null;
        public static final Type FLOAT = null;
        public static final Type INTEGER = null;
        public static final Type LONG = null;
        public static final Type STRING = null;
        public static final Type STRING_SET = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f69310a = null;

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
            f69310a = new Type[]{r100, r101, r102, r103, r104, r105, r106};
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) f69310a.clone();
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        f69309b = new KevaHelper();
        f69308a = Keva.getRepo("live_feature_manager", 0);
    }

    public KevaHelper() {
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
        if ((r101 instanceof String) == false) goto L6;
        f69308a.storeString(r100, (String) r101);
        return;
    L6:
        if ((r101 instanceof Integer) == false) goto L9;
        f69308a.storeInt(r100, ((Number) r101).intValue());
        return;
    L9:
        if ((r101 instanceof Boolean) == false) goto L12;
        f69308a.storeBoolean(r100, ((Boolean) r101).booleanValue());
        return;
    L12:
        if ((r101 instanceof Float) == false) goto L15;
        f69308a.storeFloat(r100, ((Number) r101).floatValue());
        return;
    L15:
        if ((r101 instanceof Long) == false) goto L18;
        f69308a.storeLong(r100, ((Number) r101).longValue());
        return;
    L18:
        if ((r101 instanceof Set) == false) goto L20;
        f69308a.storeStringSet(r100, (Set) r101);
        return;
    L20:
        f69308a.storeString(r100, r101.toString());
    }

    @Override // com.bytedance.android.live.core.utils.k0
    public final void f(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        e(r100, r101.toString());
    }

    public static Object g(String r100, Type r101, Object r102) {
        switch(b.f69320a[r101.ordinal()]) {
            case 1: goto L21;
            case 2: goto L16;
            case 3: goto L13;
            case 4: goto L10;
            case 5: goto L7;
            case 6: goto L23;
            case 7: goto L22;
            default: goto L29;
        };
    L7:
        Long r103 = (Long) r102;
        if (r103 == null) goto L19;
        long r104 = r103.longValue();
        return Long.valueOf(f69308a.getLong(r100, r104));
    L19:
        return null;
    L10:
        Float r105 = (Float) r102;
        if (r105 == null) goto L19;
        float r106 = r105.floatValue();
        return Float.valueOf(f69308a.getFloat(r100, r106));
    L13:
        Boolean r107 = (Boolean) r102;
        if (r107 == null) goto L19;
        boolean r108 = r107.booleanValue();
        return Boolean.valueOf(f69308a.getBoolean(r100, r108));
    L16:
        Integer r109 = (Integer) r102;
        if (r109 == null) goto L19;
        int r110 = r109.intValue();
        return Integer.valueOf(f69308a.getInt(r100, r110));
    L29:
        return r102;
    L22:
        return f69308a.getAll();
    L23:
        return f69308a.getStringSet(r100, (Set) r102);
    L21:
        return f69308a.getString(r100, (String) r102);
    }
}
