package com.bytedance.android.livesdk.interactivity.api.publicscreen.listener;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/listener/ShowArea;", "", "Scroll", "Fold", "Float", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShowArea extends Enum<ShowArea> {
    public static final ShowArea Float = null;
    public static final ShowArea Fold = null;
    public static final ShowArea Scroll = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShowArea[] f133477a = null;

    static {
        ShowArea r100 = new ShowArea("Scroll", 0);
        Scroll = r100;
        ShowArea r101 = new ShowArea("Fold", 1);
        Fold = r101;
        ShowArea r102 = new ShowArea("Float", 2);
        Float = r102;
        f133477a = new ShowArea[]{r100, r101, r102};
    }

    public static ShowArea valueOf(String r100) {
        return (ShowArea) a.a(ShowArea.class, r100);
    }

    public static ShowArea[] values() {
        return (ShowArea[]) f133477a.clone();
    }

    public ShowArea(String r100, int r101) {
        super(r100, r101);
    }
}
