package com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreenpanel/enums/PanelItemShowArea;", "", "TOP", "MIDDLE", "BOTTOM", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PanelItemShowArea extends Enum<PanelItemShowArea> {
    public static final PanelItemShowArea BOTTOM = null;
    public static final PanelItemShowArea MIDDLE = null;
    public static final PanelItemShowArea TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PanelItemShowArea[] f133744a = null;

    static {
        PanelItemShowArea r100 = new PanelItemShowArea("TOP", 0);
        TOP = r100;
        PanelItemShowArea r101 = new PanelItemShowArea("MIDDLE", 1);
        MIDDLE = r101;
        PanelItemShowArea r102 = new PanelItemShowArea("BOTTOM", 2);
        BOTTOM = r102;
        f133744a = new PanelItemShowArea[]{r100, r101, r102};
    }

    public static PanelItemShowArea valueOf(String r100) {
        return (PanelItemShowArea) a.a(PanelItemShowArea.class, r100);
    }

    public static PanelItemShowArea[] values() {
        return (PanelItemShowArea[]) f133744a.clone();
    }

    public PanelItemShowArea(String r100, int r101) {
        super(r100, r101);
    }
}
