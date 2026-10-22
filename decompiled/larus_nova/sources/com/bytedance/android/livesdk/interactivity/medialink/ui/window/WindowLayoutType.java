package com.bytedance.android.livesdk.interactivity.medialink.ui.window;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/ui/window/WindowLayoutType;", "", "Normal", "EnlargeBig", "EnlargeSmall", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowLayoutType extends Enum<WindowLayoutType> {
    public static final WindowLayoutType EnlargeBig = null;
    public static final WindowLayoutType EnlargeSmall = null;
    public static final WindowLayoutType Normal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowLayoutType[] f138419a = null;

    static {
        WindowLayoutType r100 = new WindowLayoutType("Normal", 0);
        Normal = r100;
        WindowLayoutType r101 = new WindowLayoutType("EnlargeBig", 1);
        EnlargeBig = r101;
        WindowLayoutType r102 = new WindowLayoutType("EnlargeSmall", 2);
        EnlargeSmall = r102;
        f138419a = new WindowLayoutType[]{r100, r101, r102};
    }

    public static WindowLayoutType valueOf(String r100) {
        return (WindowLayoutType) r27.a.a(WindowLayoutType.class, r100);
    }

    public static WindowLayoutType[] values() {
        return (WindowLayoutType[]) f138419a.clone();
    }

    public WindowLayoutType(String r100, int r101) {
        super(r100, r101);
    }
}
