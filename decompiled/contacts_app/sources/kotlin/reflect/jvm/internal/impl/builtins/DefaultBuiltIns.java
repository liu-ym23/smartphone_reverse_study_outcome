package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;

/* JADX INFO: compiled from: DefaultBuiltIns.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DefaultBuiltIns extends KotlinBuiltIns {
    public static final Companion Companion = null;
    private static final DefaultBuiltIns Instance = null;

    /* JADX INFO: compiled from: DefaultBuiltIns.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final DefaultBuiltIns getInstance() {
            return DefaultBuiltIns.access$getInstance$cp();
        }
    }

    public DefaultBuiltIns() {
        boolean r2 = false;
        this(r2, 1, null);
    }

    public DefaultBuiltIns(boolean r3) {
        super(new LockBasedStorageManager("DefaultBuiltIns"));
        if (r3 == false) goto L6;
        createBuiltInsModule(false);
        return;
    }

    public /* synthetic */ DefaultBuiltIns(boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        this(r1);
    }

    public static final /* synthetic */ DefaultBuiltIns access$getInstance$cp() {
        return Instance;
    }

    static {
        DefaultConstructorMarker r1 = null;
        Companion = new Companion(r1);
        Instance = new DefaultBuiltIns(false, 1, r1);
    }
}
