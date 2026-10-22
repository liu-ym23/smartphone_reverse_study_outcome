package com.bytedance.android.ec.store.common.p001const;

import java.io.Serializable;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/store/common/const/LiveStyles;", "", "Ljava/io/Serializable;", "", "type", "I", "getType", "()I", "UNDEFINED", "HEADERLIVE", "FLOATWINDOW", "NOLIVE", "HIDE_TOP_LIVE_AND_VIDEO_WITH_FLOAT", "ONLY_LIVE_ICON", "LIVE_ICON_AND_FLOATWINDOW", "LIVE_MODULE_AND_FLOATWINDOW", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveStyles extends Enum<LiveStyles> implements Serializable {
    public static final LiveStyles FLOATWINDOW = null;
    public static final LiveStyles HEADERLIVE = null;
    public static final LiveStyles HIDE_TOP_LIVE_AND_VIDEO_WITH_FLOAT = null;
    public static final LiveStyles LIVE_ICON_AND_FLOATWINDOW = null;
    public static final LiveStyles LIVE_MODULE_AND_FLOATWINDOW = null;
    public static final LiveStyles NOLIVE = null;
    public static final LiveStyles ONLY_LIVE_ICON = null;
    public static final LiveStyles UNDEFINED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveStyles[] f48220a = null;
    private final int type;

    public static LiveStyles valueOf(String r100) {
        return (LiveStyles) a.a(LiveStyles.class, r100);
    }

    public static LiveStyles[] values() {
        return (LiveStyles[]) f48220a.clone();
    }

    static {
        LiveStyles r100 = new LiveStyles("UNDEFINED", 0, -1);
        UNDEFINED = r100;
        LiveStyles r101 = new LiveStyles("HEADERLIVE", 1, 0);
        HEADERLIVE = r101;
        LiveStyles r102 = new LiveStyles("FLOATWINDOW", 2, 1);
        FLOATWINDOW = r102;
        LiveStyles r103 = new LiveStyles("NOLIVE", 3, 2);
        NOLIVE = r103;
        LiveStyles r104 = new LiveStyles("HIDE_TOP_LIVE_AND_VIDEO_WITH_FLOAT", 4, 3);
        HIDE_TOP_LIVE_AND_VIDEO_WITH_FLOAT = r104;
        LiveStyles r105 = new LiveStyles("ONLY_LIVE_ICON", 5, 4);
        ONLY_LIVE_ICON = r105;
        LiveStyles r106 = new LiveStyles("LIVE_ICON_AND_FLOATWINDOW", 6, 5);
        LIVE_ICON_AND_FLOATWINDOW = r106;
        LiveStyles r107 = new LiveStyles("LIVE_MODULE_AND_FLOATWINDOW", 7, 6);
        LIVE_MODULE_AND_FLOATWINDOW = r107;
        f48220a = new LiveStyles[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public final int getType() {
        return this.type;
    }

    public LiveStyles(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
