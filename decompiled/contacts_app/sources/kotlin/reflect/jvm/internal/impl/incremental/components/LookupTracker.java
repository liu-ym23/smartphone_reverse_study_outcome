package kotlin.reflect.jvm.internal.impl.incremental.components;

import com.obric.aikernel.sdk.ext.Params;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LookupTracker.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface LookupTracker {

    /* JADX INFO: compiled from: LookupTracker.kt */
    public static final class DO_NOTHING implements LookupTracker {
        public static final DO_NOTHING INSTANCE = null;

        static {
            INSTANCE = new DO_NOTHING();
        }

        @Override // kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker
        public boolean getRequiresPosition() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker
        public void record(String r1, Position r2, String r3, ScopeKind r4, String r5) {
            Intrinsics.checkNotNullParameter(r1, Params.FILE_PATH);
            Intrinsics.checkNotNullParameter(r2, "position");
            Intrinsics.checkNotNullParameter(r3, "scopeFqName");
            Intrinsics.checkNotNullParameter(r4, "scopeKind");
            Intrinsics.checkNotNullParameter(r5, "name");
        }

        private DO_NOTHING() {
        }
    }

    boolean getRequiresPosition();

    void record(String r1, Position r2, String r3, ScopeKind r4, String r5);
}
