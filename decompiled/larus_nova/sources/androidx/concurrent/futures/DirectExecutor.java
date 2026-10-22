package androidx.concurrent.futures;

import java.util.concurrent.Executor;
import r27.a;

/* JADX INFO: loaded from: classes6.dex */
public final enum DirectExecutor extends Enum<DirectExecutor> implements Executor {
    private static final /* synthetic */ DirectExecutor[] $VALUES = null;
    public static final DirectExecutor INSTANCE = null;

    @Override // java.lang.Enum
    public String toString() {
        return "DirectExecutor";
    }

    static {
        DirectExecutor r100 = new DirectExecutor("INSTANCE", 0);
        INSTANCE = r100;
        $VALUES = new DirectExecutor[]{r100};
    }

    public static DirectExecutor[] values() {
        return (DirectExecutor[]) $VALUES.clone();
    }

    public static DirectExecutor valueOf(String r100) {
        return (DirectExecutor) a.a(DirectExecutor.class, r100);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r100) {
        r100.run();
    }

    private DirectExecutor(String r100, int r101) {
        super(r100, r101);
    }
}
