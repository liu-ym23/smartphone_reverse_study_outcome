package androidx.concurrent.futures;

import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final enum DirectExecutor extends Enum<DirectExecutor> implements Executor {
    private static final /* synthetic */ DirectExecutor[] $VALUES = null;
    public static final DirectExecutor INSTANCE = null;

    static {
        DirectExecutor r10 = new DirectExecutor("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new DirectExecutor[]{r10};
    }

    private DirectExecutor(String r10, int r11) {
        super(r10, r11);
    }

    public static DirectExecutor valueOf(String r10) {
        return (DirectExecutor) Enum.valueOf(DirectExecutor.class, r10);
    }

    public static DirectExecutor[] values() {
        return (DirectExecutor[]) $VALUES.clone();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r10) {
        r10.run();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "DirectExecutor";
    }
}
