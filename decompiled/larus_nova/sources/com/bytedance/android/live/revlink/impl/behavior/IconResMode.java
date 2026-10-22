package com.bytedance.android.live.revlink.impl.behavior;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/behavior/IconResMode;", "", "IMAGE_MODEL", "DRAWABLE", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IconResMode extends Enum<IconResMode> {
    public static final IconResMode DRAWABLE = null;
    public static final IconResMode IMAGE_MODEL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IconResMode[] f92084a = null;

    static {
        IconResMode r100 = new IconResMode("IMAGE_MODEL", 0);
        IMAGE_MODEL = r100;
        IconResMode r101 = new IconResMode("DRAWABLE", 1);
        DRAWABLE = r101;
        f92084a = new IconResMode[]{r100, r101};
    }

    public static IconResMode valueOf(String r100) {
        return (IconResMode) r27.a.a(IconResMode.class, r100);
    }

    public static IconResMode[] values() {
        return (IconResMode[]) f92084a.clone();
    }

    public IconResMode(String r100, int r101) {
        super(r100, r101);
    }
}
