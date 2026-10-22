package androidx.work;

import android.content.Context;
import androidx.work.impl.c0;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class WorkManager {

    public static final enum UpdateResult extends Enum<UpdateResult> {
        private static final /* synthetic */ UpdateResult[] $VALUES = null;
        public static final UpdateResult APPLIED_FOR_NEXT_RUN = null;
        public static final UpdateResult APPLIED_IMMEDIATELY = null;
        public static final UpdateResult NOT_APPLIED = null;

        private static /* synthetic */ UpdateResult[] $values() {
            return new UpdateResult[]{NOT_APPLIED, APPLIED_IMMEDIATELY, APPLIED_FOR_NEXT_RUN};
        }

        static {
            NOT_APPLIED = new UpdateResult("NOT_APPLIED", 0);
            APPLIED_IMMEDIATELY = new UpdateResult("APPLIED_IMMEDIATELY", 1);
            APPLIED_FOR_NEXT_RUN = new UpdateResult("APPLIED_FOR_NEXT_RUN", 2);
            $VALUES = $values();
        }

        private UpdateResult(String r10, int r11) {
            super(r10, r11);
        }

        public static UpdateResult valueOf(String r10) {
            return (UpdateResult) Enum.valueOf(UpdateResult.class, r10);
        }

        public static UpdateResult[] values() {
            return (UpdateResult[]) $VALUES.clone();
        }
    }

    public WorkManager() {
    }

    public static WorkManager e(Context r10) {
        return c0.l(r10);
    }

    public static void f(Context r10, Configuration r11) {
        c0.f(r10, r11);
    }

    public final Operation a(l r10) {
        return b(Collections.singletonList(r10));
    }

    public abstract Operation b(List r10);

    public Operation c(String r10, ExistingWorkPolicy r11, j r12) {
        return d(r10, r11, Collections.singletonList(r12));
    }

    public abstract Operation d(String r10, ExistingWorkPolicy r11, List r12);
}
