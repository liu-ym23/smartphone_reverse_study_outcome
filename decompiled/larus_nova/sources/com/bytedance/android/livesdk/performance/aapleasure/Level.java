package com.bytedance.android.livesdk.performance.aapleasure;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/performance/aapleasure/Level;", "", "", "level", "I", "getLevel", "()I", "High", "Normal", "Serious", "Critical", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Level extends Enum<Level> {
    public static final Level Critical = null;
    public static final Level High = null;
    public static final Level Normal = null;
    public static final Level Serious = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Level[] f154412a = null;
    private final int level;

    static {
        Level r100 = new Level("High", 0, 1);
        High = r100;
        Level r101 = new Level("Normal", 1, 0);
        Normal = r101;
        Level r102 = new Level("Serious", 2, -1);
        Serious = r102;
        Level r103 = new Level("Critical", 3, -2);
        Critical = r103;
        f154412a = new Level[]{r100, r101, r102, r103};
    }

    public static Level valueOf(String r100) {
        return (Level) r27.a.a(Level.class, r100);
    }

    public static Level[] values() {
        return (Level[]) f154412a.clone();
    }

    public final int getLevel() {
        return this.level;
    }

    public Level(String r100, int r101, int r102) {
        super(r100, r101);
        this.level = r102;
    }
}
