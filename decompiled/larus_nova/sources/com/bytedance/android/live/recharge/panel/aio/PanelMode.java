package com.bytedance.android.live.recharge.panel.aio;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/recharge/panel/aio/PanelMode;", "", "", "mode", "I", "getMode", "()I", "UNKNOWN_MODE", "NORMAL_MODE", "NO_PASSWD_MODE", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PanelMode extends Enum<PanelMode> {
    public static final PanelMode NORMAL_MODE = null;
    public static final PanelMode NO_PASSWD_MODE = null;
    public static final PanelMode UNKNOWN_MODE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PanelMode[] f90152a = null;
    private final int mode;

    static {
        PanelMode r100 = new PanelMode("UNKNOWN_MODE", 0, 0);
        UNKNOWN_MODE = r100;
        PanelMode r101 = new PanelMode("NORMAL_MODE", 1, 1);
        NORMAL_MODE = r101;
        PanelMode r102 = new PanelMode("NO_PASSWD_MODE", 2, 2);
        NO_PASSWD_MODE = r102;
        f90152a = new PanelMode[]{r100, r101, r102};
    }

    public static PanelMode valueOf(String r100) {
        return (PanelMode) a.a(PanelMode.class, r100);
    }

    public static PanelMode[] values() {
        return (PanelMode[]) f90152a.clone();
    }

    public final int getMode() {
        return this.mode;
    }

    public PanelMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.mode = r102;
    }
}
