package mobile;

import go.Seq;

/* loaded from: classes.dex */
public abstract class Mobile {
    public static final long LevelAll = 0;
    public static final long LevelL1 = 1;
    public static final long LevelL2 = 2;
    public static final long LevelL3 = 3;
    public static final long LevelL4 = 4;
    public static final long ScenarioDefault = 0;
    public static final long ScenarioInference = 2;
    public static final long ScenarioLog = 1;

    static {
        Seq.touch();
        _init();
    }

    private Mobile() {
    }

    private static native void _init();

    public static native Guard newGuard(long j2, long j4);

    public static native Guard newGuardWithDictDir(long j2, long j4, String str);

    public static native Guard newGuardWithEncrypt(long j2, long j4, boolean z4, String str);

    public static native Guard newGuardWithEncryptDefault(long j2, long j4, boolean z4);

    public static native Opener newOpener(String str, String str2);

    public static native Opener newOpenerDefault();

    public static void touch() {
    }

    public static native String version();
}
