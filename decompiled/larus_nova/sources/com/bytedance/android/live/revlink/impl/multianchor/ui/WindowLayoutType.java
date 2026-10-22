package com.bytedance.android.live.revlink.impl.multianchor.ui;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/ui/WindowLayoutType;", "", "Normal", "EnlargeBig", "EnlargeSmall", "FullBig", "FullSmall", "FullRecordBig", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum WindowLayoutType extends Enum<WindowLayoutType> {
    public static final WindowLayoutType EnlargeBig = null;
    public static final WindowLayoutType EnlargeSmall = null;
    public static final WindowLayoutType FullBig = null;
    public static final WindowLayoutType FullRecordBig = null;
    public static final WindowLayoutType FullSmall = null;
    public static final WindowLayoutType Normal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowLayoutType[] f94795a = null;

    static {
        WindowLayoutType r100 = new WindowLayoutType("Normal", 0);
        Normal = r100;
        WindowLayoutType r101 = new WindowLayoutType("EnlargeBig", 1);
        EnlargeBig = r101;
        WindowLayoutType r102 = new WindowLayoutType("EnlargeSmall", 2);
        EnlargeSmall = r102;
        WindowLayoutType r103 = new WindowLayoutType("FullBig", 3);
        FullBig = r103;
        WindowLayoutType r104 = new WindowLayoutType("FullSmall", 4);
        FullSmall = r104;
        WindowLayoutType r105 = new WindowLayoutType("FullRecordBig", 5);
        FullRecordBig = r105;
        f94795a = new WindowLayoutType[]{r100, r101, r102, r103, r104, r105};
    }

    public static WindowLayoutType valueOf(String r100) {
        return (WindowLayoutType) r27.a.a(WindowLayoutType.class, r100);
    }

    public static WindowLayoutType[] values() {
        return (WindowLayoutType[]) f94795a.clone();
    }

    public WindowLayoutType(String r100, int r101) {
        super(r100, r101);
    }
}
