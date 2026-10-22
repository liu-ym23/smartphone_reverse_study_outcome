package com.bytedance.android.ec.window.base.common.p002const;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/window/base/common/const/WindowLiveStyles;", "", "", "type", "I", "getType", "()I", "UNDEFINED", "HEADERLIVE", "FLOATWINDOW", "NOLIVE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowLiveStyles extends Enum<WindowLiveStyles> {
    public static final WindowLiveStyles FLOATWINDOW = null;
    public static final WindowLiveStyles HEADERLIVE = null;
    public static final WindowLiveStyles NOLIVE = null;
    public static final WindowLiveStyles UNDEFINED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowLiveStyles[] f49147a = null;
    private final int type;

    static {
        WindowLiveStyles r100 = new WindowLiveStyles("UNDEFINED", 0, -1);
        UNDEFINED = r100;
        WindowLiveStyles r101 = new WindowLiveStyles("HEADERLIVE", 1, 0);
        HEADERLIVE = r101;
        WindowLiveStyles r102 = new WindowLiveStyles("FLOATWINDOW", 2, 1);
        FLOATWINDOW = r102;
        WindowLiveStyles r103 = new WindowLiveStyles("NOLIVE", 3, 2);
        NOLIVE = r103;
        f49147a = new WindowLiveStyles[]{r100, r101, r102, r103};
    }

    public static WindowLiveStyles valueOf(String r100) {
        return (WindowLiveStyles) a.a(WindowLiveStyles.class, r100);
    }

    public static WindowLiveStyles[] values() {
        return (WindowLiveStyles[]) f49147a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public WindowLiveStyles(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
