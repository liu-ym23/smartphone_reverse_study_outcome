package com.bytedance.android.live.revlink.impl.multianchor.model;

import com.ss.android.ugc.effectmanager.common.EffectTypeConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/model/WindowType;", "", "Anchor", "Guest", EffectTypeConstants.TYPE_GAME, "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum WindowType extends Enum<WindowType> {
    public static final WindowType Anchor = null;
    public static final WindowType Game = null;
    public static final WindowType Guest = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowType[] f94430a = null;

    static {
        WindowType r100 = new WindowType("Anchor", 0);
        Anchor = r100;
        WindowType r101 = new WindowType("Guest", 1);
        Guest = r101;
        WindowType r102 = new WindowType(EffectTypeConstants.TYPE_GAME, 2);
        Game = r102;
        f94430a = new WindowType[]{r100, r101, r102};
    }

    public static WindowType valueOf(String r100) {
        return (WindowType) a.a(WindowType.class, r100);
    }

    public static WindowType[] values() {
        return (WindowType[]) f94430a.clone();
    }

    public WindowType(String r100, int r101) {
        super(r100, r101);
    }
}
