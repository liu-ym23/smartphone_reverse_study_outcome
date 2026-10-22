package com.bytedance.android.livesdk.dynamicstrategy.api;

import com.obric.miniapp.alarm.AccountType;
import iu1.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
public abstract class DynamicFactor<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a<T> f123023a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/api/DynamicFactor$Type;", "", AccountType.LOCAL, "PLATFORM", "SMART_MIX", "dynamicstrategy-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Type extends Enum<Type> {
        public static final Type LOCAL = null;
        public static final Type PLATFORM = null;
        public static final Type SMART_MIX = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f123024a = null;

        static {
            Type r100 = new Type(AccountType.LOCAL, 0);
            LOCAL = r100;
            Type r101 = new Type("PLATFORM", 1);
            PLATFORM = r101;
            Type r102 = new Type("SMART_MIX", 2);
            SMART_MIX = r102;
            f123024a = new Type[]{r100, r101, r102};
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) f123024a.clone();
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public DynamicFactor() {
    }

    public abstract T b();

    public abstract String c();

    public abstract void d();

    public abstract void e();

    public Type getType() {
        return Type.LOCAL;
    }

    public final void update(T r100) {
        a<T> r101 = this.f123023a;
        if (r101 == null) goto L6;
        r101.update(r100);
        return;
    }
}
