package com.bytedance.android.live.liveinteract.interactivesong.logger;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interactivesong/logger/OpenSource;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "CONVENIENT_PAGE", "INTERACTION_BUTTON", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum OpenSource extends Enum<OpenSource> {
    public static final OpenSource CONVENIENT_PAGE = null;
    public static final OpenSource INTERACTION_BUTTON = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenSource[] f74045a = null;
    private final String value;

    static {
        OpenSource r100 = new OpenSource("CONVENIENT_PAGE", 0, "convenient_page");
        CONVENIENT_PAGE = r100;
        OpenSource r101 = new OpenSource("INTERACTION_BUTTON", 1, "interaction_button");
        INTERACTION_BUTTON = r101;
        f74045a = new OpenSource[]{r100, r101};
    }

    public static OpenSource valueOf(String r100) {
        return (OpenSource) a.a(OpenSource.class, r100);
    }

    public static OpenSource[] values() {
        return (OpenSource[]) f74045a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public OpenSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
