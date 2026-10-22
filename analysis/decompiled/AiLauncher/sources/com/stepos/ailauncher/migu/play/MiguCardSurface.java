package com.stepos.ailauncher.migu.play;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/migu/play/MiguCardSurface;", "", "<init>", "(Ljava/lang/String;I)V", "INSTALL", "DOWNLOADING", "DONE", "LOGIN", "PLAYLIST", "HIDDEN", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MiguCardSurface {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ MiguCardSurface[] $VALUES;
    public static final MiguCardSurface INSTALL = new MiguCardSurface("INSTALL", 0);
    public static final MiguCardSurface DOWNLOADING = new MiguCardSurface("DOWNLOADING", 1);
    public static final MiguCardSurface DONE = new MiguCardSurface("DONE", 2);
    public static final MiguCardSurface LOGIN = new MiguCardSurface("LOGIN", 3);
    public static final MiguCardSurface PLAYLIST = new MiguCardSurface("PLAYLIST", 4);
    public static final MiguCardSurface HIDDEN = new MiguCardSurface("HIDDEN", 5);

    private static final /* synthetic */ MiguCardSurface[] $values() {
        return new MiguCardSurface[]{INSTALL, DOWNLOADING, DONE, LOGIN, PLAYLIST, HIDDEN};
    }

    static {
        MiguCardSurface[] miguCardSurfaceArr$values = $values();
        $VALUES = miguCardSurfaceArr$values;
        $ENTRIES = kotlin.enums.a.a(miguCardSurfaceArr$values);
    }

    private MiguCardSurface(String str, int i10) {
    }

    public static InterfaceC4149a<MiguCardSurface> getEntries() {
        return $ENTRIES;
    }

    public static MiguCardSurface valueOf(String str) {
        return (MiguCardSurface) Enum.valueOf(MiguCardSurface.class, str);
    }

    public static MiguCardSurface[] values() {
        return (MiguCardSurface[]) $VALUES.clone();
    }
}
