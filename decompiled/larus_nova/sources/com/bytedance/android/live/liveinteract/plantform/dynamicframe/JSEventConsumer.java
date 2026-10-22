package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/JSEventConsumer;", "", "Dual", "RootWidget", "LogicWidget", "FeedRootWidget", "RenderWidget", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum JSEventConsumer extends Enum<JSEventConsumer> {
    public static final JSEventConsumer Dual = null;
    public static final JSEventConsumer FeedRootWidget = null;
    public static final JSEventConsumer LogicWidget = null;
    public static final JSEventConsumer RenderWidget = null;
    public static final JSEventConsumer RootWidget = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JSEventConsumer[] f76791a = null;

    static {
        JSEventConsumer r100 = new JSEventConsumer("Dual", 0);
        Dual = r100;
        JSEventConsumer r101 = new JSEventConsumer("RootWidget", 1);
        RootWidget = r101;
        JSEventConsumer r102 = new JSEventConsumer("LogicWidget", 2);
        LogicWidget = r102;
        JSEventConsumer r103 = new JSEventConsumer("FeedRootWidget", 3);
        FeedRootWidget = r103;
        JSEventConsumer r104 = new JSEventConsumer("RenderWidget", 4);
        RenderWidget = r104;
        f76791a = new JSEventConsumer[]{r100, r101, r102, r103, r104};
    }

    public static JSEventConsumer valueOf(String r100) {
        return (JSEventConsumer) r27.a.a(JSEventConsumer.class, r100);
    }

    public static JSEventConsumer[] values() {
        return (JSEventConsumer[]) f76791a.clone();
    }

    public JSEventConsumer(String r100, int r101) {
        super(r100, r101);
    }
}
