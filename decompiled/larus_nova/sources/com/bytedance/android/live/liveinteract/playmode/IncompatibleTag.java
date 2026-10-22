package com.bytedance.android.live.liveinteract.playmode;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/playmode/IncompatibleTag;", "", "SCENE", "UI_LAYOUT", "PLAY_MODE", "DEFAULT", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IncompatibleTag extends Enum<IncompatibleTag> {
    public static final IncompatibleTag DEFAULT = null;
    public static final IncompatibleTag PLAY_MODE = null;
    public static final IncompatibleTag SCENE = null;
    public static final IncompatibleTag UI_LAYOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IncompatibleTag[] f77857a = null;

    static {
        IncompatibleTag r100 = new IncompatibleTag("SCENE", 0);
        SCENE = r100;
        IncompatibleTag r101 = new IncompatibleTag("UI_LAYOUT", 1);
        UI_LAYOUT = r101;
        IncompatibleTag r102 = new IncompatibleTag("PLAY_MODE", 2);
        PLAY_MODE = r102;
        IncompatibleTag r103 = new IncompatibleTag("DEFAULT", 3);
        DEFAULT = r103;
        f77857a = new IncompatibleTag[]{r100, r101, r102, r103};
    }

    public static IncompatibleTag valueOf(String r100) {
        return (IncompatibleTag) a.a(IncompatibleTag.class, r100);
    }

    public static IncompatibleTag[] values() {
        return (IncompatibleTag[]) f77857a.clone();
    }

    public IncompatibleTag(String r100, int r101) {
        super(r100, r101);
    }
}
