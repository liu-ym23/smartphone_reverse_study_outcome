package com.obric.oui.window.bean;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import xd.b;
import xd.c;
import xd.d;
import xd.e;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/window/bean/WindowSizeClass;", "", "", "dpSize", "Lxd/c;", "baseGridConfig", "<init>", "(Ljava/lang/String;IILxd/c;)V", "I", "getDpSize", "()I", "Lxd/c;", "getBaseGridConfig", "()Lxd/c;", "MINUS_ERROR_SIZE", "FLOATING_WINDOW", "SMALL_SPLIT_SCREEN", "SMALLER_ANDROID_SCREEN", "SMALL", "STANDARD", "NORMAL", "LARGE", "OVERSIZE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum WindowSizeClass extends Enum<WindowSizeClass> {
    private static final /* synthetic */ WindowSizeClass[] $VALUES = null;
    public static final WindowSizeClass FLOATING_WINDOW = null;
    public static final WindowSizeClass LARGE = null;
    public static final WindowSizeClass MINUS_ERROR_SIZE = null;
    public static final WindowSizeClass NORMAL = null;
    public static final WindowSizeClass OVERSIZE = null;
    public static final WindowSizeClass SMALL = null;
    public static final WindowSizeClass SMALLER_ANDROID_SCREEN = null;
    public static final WindowSizeClass SMALL_SPLIT_SCREEN = null;
    public static final WindowSizeClass STANDARD = null;

    @NotNull
    private final c baseGridConfig;
    private final int dpSize;

    private static final /* synthetic */ WindowSizeClass[] $values() {
        return new WindowSizeClass[]{MINUS_ERROR_SIZE, FLOATING_WINDOW, SMALL_SPLIT_SCREEN, SMALLER_ANDROID_SCREEN, SMALL, STANDARD, NORMAL, LARGE, OVERSIZE};
    }

    static {
        MINUS_ERROR_SIZE = new WindowSizeClass("MINUS_ERROR_SIZE", 0, -1, new c("MINUS_ERROR_SIZE", new b(1), new d(0), new e(0)));
        FLOATING_WINDOW = new WindowSizeClass("FLOATING_WINDOW", 1, 0, new c("FLOATING_WINDOW", new b(12), new d(11), new e(12)));
        SMALL_SPLIT_SCREEN = new WindowSizeClass("SMALL_SPLIT_SCREEN", 2, 375, new c("SMALL_SPLIT_SCREEN", new b(12), new d(12), new e(12)));
        SMALLER_ANDROID_SCREEN = new WindowSizeClass("SMALLER_ANDROID_SCREEN", 3, 516, new c("SMALLER_ANDROID_SCREEN", new b(12), new d(12), new e(16)));
        SMALL = new WindowSizeClass("SMALL", 4, 640, new c("SMALL", new b(12), new d(12), new e(16)));
        STANDARD = new WindowSizeClass("STANDARD", 5, 768, new c("STANDARD", new b(12), new d(12), new e(24)));
        NORMAL = new WindowSizeClass("NORMAL", 6, 834, new c("NORMAL", new b(12), new d(12), new e(24)));
        LARGE = new WindowSizeClass("LARGE", 7, 1024, new c("LARGE", new b(20), new d(16), new e(32)));
        OVERSIZE = new WindowSizeClass("OVERSIZE", 8, 1366, new c("OVERSIZE", new b(24), new d(16), new e(32)));
        $VALUES = $values();
    }

    private WindowSizeClass(String r10, int r11, int r12, c r13) {
        super(r10, r11);
        this.dpSize = r12;
        this.baseGridConfig = r13;
    }

    public static WindowSizeClass valueOf(String r10) {
        return (WindowSizeClass) Enum.valueOf(WindowSizeClass.class, r10);
    }

    public static WindowSizeClass[] values() {
        return (WindowSizeClass[]) $VALUES.clone();
    }

    @NotNull
    public final c getBaseGridConfig() {
        return this.baseGridConfig;
    }

    public final int getDpSize() {
        return this.dpSize;
    }
}
