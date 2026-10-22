package com.bytedance.android.monitorV2.webview;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/monitorV2/webview/WebViewLifeState;", "", "CREATED", "ATTACHED", "DETACHED", "DESTROYED", "REPORTED", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum WebViewLifeState extends Enum<WebViewLifeState> {
    public static final WebViewLifeState ATTACHED = null;
    public static final WebViewLifeState CREATED = null;
    public static final WebViewLifeState DESTROYED = null;
    public static final WebViewLifeState DETACHED = null;
    public static final WebViewLifeState REPORTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WebViewLifeState[] f163310a = null;

    public static WebViewLifeState valueOf(String r100) {
        return (WebViewLifeState) r27.a.a(WebViewLifeState.class, r100);
    }

    public static WebViewLifeState[] values() {
        return (WebViewLifeState[]) f163310a.clone();
    }

    static {
        WebViewLifeState r100 = new WebViewLifeState("CREATED", 0);
        CREATED = r100;
        WebViewLifeState r101 = new WebViewLifeState("ATTACHED", 1);
        ATTACHED = r101;
        WebViewLifeState r102 = new WebViewLifeState("DETACHED", 2);
        DETACHED = r102;
        WebViewLifeState r103 = new WebViewLifeState("DESTROYED", 3);
        DESTROYED = r103;
        WebViewLifeState r104 = new WebViewLifeState("REPORTED", 4);
        REPORTED = r104;
        f163310a = new WebViewLifeState[]{r100, r101, r102, r103, r104};
    }

    public WebViewLifeState(String r100, int r101) {
        super(r100, r101);
    }
}
