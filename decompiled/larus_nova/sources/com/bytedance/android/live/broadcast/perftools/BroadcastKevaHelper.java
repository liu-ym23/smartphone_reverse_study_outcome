package com.bytedance.android.live.broadcast.perftools;

import com.bytedance.keva.Keva;
import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
public final class BroadcastKevaHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f59174a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/broadcast/perftools/BroadcastKevaHelper$Type;", "", "STRING", "INTEGER", "BOOLEAN", "FLOAT", "LONG", "STRING_SET", AccountType.ALL, "livebroadcast-shared-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Type extends Enum<Type> {
        public static final Type ALL = null;
        public static final Type BOOLEAN = null;
        public static final Type FLOAT = null;
        public static final Type INTEGER = null;
        public static final Type LONG = null;
        public static final Type STRING = null;
        public static final Type STRING_SET = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f59175a = null;

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
            f59175a = new Type[]{r100, r101, r102, r103, r104, r105, r106};
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) f59175a.clone();
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        f59174a = Keva.getRepo("live_broadcast_keva_sp", 0);
    }
}
