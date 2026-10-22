package s0;

import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: s0.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0851i implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumC0851i f14202a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumC0851i[] f14203b;

    static {
        EnumC0851i enumC0851i = new EnumC0851i("INSTANCE", 0);
        f14202a = enumC0851i;
        f14203b = new EnumC0851i[]{enumC0851i};
    }

    public static EnumC0851i valueOf(String str) {
        return (EnumC0851i) Enum.valueOf(EnumC0851i.class, str);
    }

    public static EnumC0851i[] values() {
        return (EnumC0851i[]) f14203b.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable command) {
        Intrinsics.checkNotNullParameter(command, "command");
        command.run();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "DirectExecutor";
    }
}
