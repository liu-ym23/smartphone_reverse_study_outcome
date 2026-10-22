package rx.internal.util;

import rx.functions.Func1;

/* JADX INFO: loaded from: classes4.dex */
public abstract class UtilityFunctions {

    public static final enum AlwaysFalse extends Enum<AlwaysFalse> implements Func1<Object, Boolean> {
        private static final /* synthetic */ AlwaysFalse[] $VALUES = null;
        public static final AlwaysFalse INSTANCE = null;

        static {
            AlwaysFalse r10 = new AlwaysFalse("INSTANCE", 0);
            INSTANCE = r10;
            $VALUES = new AlwaysFalse[]{r10};
        }

        private AlwaysFalse(String r10, int r11) {
            super(r10, r11);
        }

        public static AlwaysFalse valueOf(String r10) {
            return (AlwaysFalse) Enum.valueOf(AlwaysFalse.class, r10);
        }

        public static AlwaysFalse[] values() {
            return (AlwaysFalse[]) $VALUES.clone();
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Boolean call(Object r10) {
            return call(r10);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // rx.functions.Func1
        public Boolean call(Object r10) {
            return Boolean.FALSE;
        }
    }

    public static final enum AlwaysTrue extends Enum<AlwaysTrue> implements Func1<Object, Boolean> {
        private static final /* synthetic */ AlwaysTrue[] $VALUES = null;
        public static final AlwaysTrue INSTANCE = null;

        static {
            AlwaysTrue r10 = new AlwaysTrue("INSTANCE", 0);
            INSTANCE = r10;
            $VALUES = new AlwaysTrue[]{r10};
        }

        private AlwaysTrue(String r10, int r11) {
            super(r10, r11);
        }

        public static AlwaysTrue valueOf(String r10) {
            return (AlwaysTrue) Enum.valueOf(AlwaysTrue.class, r10);
        }

        public static AlwaysTrue[] values() {
            return (AlwaysTrue[]) $VALUES.clone();
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Boolean call(Object r10) {
            return call(r10);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // rx.functions.Func1
        public Boolean call(Object r10) {
            return Boolean.TRUE;
        }
    }

    public static final enum Identity extends Enum<Identity> implements Func1<Object, Object> {
        private static final /* synthetic */ Identity[] $VALUES = null;
        public static final Identity INSTANCE = null;

        static {
            Identity r10 = new Identity("INSTANCE", 0);
            INSTANCE = r10;
            $VALUES = new Identity[]{r10};
        }

        private Identity(String r10, int r11) {
            super(r10, r11);
        }

        public static Identity valueOf(String r10) {
            return (Identity) Enum.valueOf(Identity.class, r10);
        }

        public static Identity[] values() {
            return (Identity[]) $VALUES.clone();
        }

        @Override // rx.functions.Func1
        public Object call(Object r10) {
            return r10;
        }
    }

    public static Func1 a() {
        return AlwaysTrue.INSTANCE;
    }

    public static Func1 b() {
        return Identity.INSTANCE;
    }
}
