package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;

/* JADX INFO: compiled from: NewKotlinTypeChecker.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface NewKotlinTypeChecker extends KotlinTypeChecker {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: NewKotlinTypeChecker.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final NewKotlinTypeCheckerImpl Default = null;

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        static {
            $$INSTANCE = new Companion();
            Default = new NewKotlinTypeCheckerImpl(KotlinTypeRefiner.Default.INSTANCE, null, 2, 0 == true ? 1 : 0);
        }

        public final NewKotlinTypeCheckerImpl getDefault() {
            return Default;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    KotlinTypeRefiner getKotlinTypeRefiner();

    OverridingUtil getOverridingUtil();
}
