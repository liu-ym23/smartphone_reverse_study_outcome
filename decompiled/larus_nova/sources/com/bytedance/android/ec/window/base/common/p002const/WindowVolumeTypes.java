package com.bytedance.android.ec.window.base.common.p002const;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/window/base/common/const/WindowVolumeTypes;", "", "", "type", "I", "getType", "()I", "MUTE", "UNMUTE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowVolumeTypes extends Enum<WindowVolumeTypes> {
    public static final WindowVolumeTypes MUTE = null;
    public static final WindowVolumeTypes UNMUTE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowVolumeTypes[] f49148a = null;
    private final int type;

    static {
        WindowVolumeTypes r100 = new WindowVolumeTypes("MUTE", 0, 2);
        MUTE = r100;
        WindowVolumeTypes r101 = new WindowVolumeTypes("UNMUTE", 1, 1);
        UNMUTE = r101;
        f49148a = new WindowVolumeTypes[]{r100, r101};
    }

    public static WindowVolumeTypes valueOf(String r100) {
        return (WindowVolumeTypes) a.a(WindowVolumeTypes.class, r100);
    }

    public static WindowVolumeTypes[] values() {
        return (WindowVolumeTypes[]) f49148a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public WindowVolumeTypes(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
