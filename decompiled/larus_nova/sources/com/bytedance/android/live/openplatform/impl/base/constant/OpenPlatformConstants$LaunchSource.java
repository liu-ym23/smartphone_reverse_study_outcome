package com.bytedance.android.live.openplatform.impl.base.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"com/bytedance/android/live/openplatform/impl/base/constant/OpenPlatformConstants$LaunchSource", "", "Lcom/bytedance/android/live/openplatform/impl/base/constant/OpenPlatformConstants$LaunchSource;", "", "value", "J", "getValue", "()J", "Panel", "Scan", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OpenPlatformConstants$LaunchSource extends Enum<OpenPlatformConstants$LaunchSource> {
    public static final OpenPlatformConstants$LaunchSource Panel = null;
    public static final OpenPlatformConstants$LaunchSource Scan = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenPlatformConstants$LaunchSource[] f84014a = null;
    private final long value;

    static {
        OpenPlatformConstants$LaunchSource r100 = new OpenPlatformConstants$LaunchSource("Panel", 0, 1);
        Panel = r100;
        OpenPlatformConstants$LaunchSource r101 = new OpenPlatformConstants$LaunchSource("Scan", 1, 2);
        Scan = r101;
        f84014a = new OpenPlatformConstants$LaunchSource[]{r100, r101};
    }

    public static OpenPlatformConstants$LaunchSource valueOf(String r100) {
        return (OpenPlatformConstants$LaunchSource) a.a(OpenPlatformConstants$LaunchSource.class, r100);
    }

    public static OpenPlatformConstants$LaunchSource[] values() {
        return (OpenPlatformConstants$LaunchSource[]) f84014a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public OpenPlatformConstants$LaunchSource(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
