package com.bytedance.android.live.liveinteract.plantform.dynamicframe.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/MultiLinkPanelLifecycle;", "", "UNKONWN", "SHOW", "HIDE", "UPDATE", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiLinkPanelLifecycle extends Enum<MultiLinkPanelLifecycle> {
    public static final MultiLinkPanelLifecycle HIDE = null;
    public static final MultiLinkPanelLifecycle SHOW = null;
    public static final MultiLinkPanelLifecycle UNKONWN = null;
    public static final MultiLinkPanelLifecycle UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultiLinkPanelLifecycle[] f77076a = null;

    static {
        MultiLinkPanelLifecycle r100 = new MultiLinkPanelLifecycle("UNKONWN", 0);
        UNKONWN = r100;
        MultiLinkPanelLifecycle r101 = new MultiLinkPanelLifecycle("SHOW", 1);
        SHOW = r101;
        MultiLinkPanelLifecycle r102 = new MultiLinkPanelLifecycle("HIDE", 2);
        HIDE = r102;
        MultiLinkPanelLifecycle r103 = new MultiLinkPanelLifecycle("UPDATE", 3);
        UPDATE = r103;
        f77076a = new MultiLinkPanelLifecycle[]{r100, r101, r102, r103};
    }

    public static MultiLinkPanelLifecycle valueOf(String r100) {
        return (MultiLinkPanelLifecycle) a.a(MultiLinkPanelLifecycle.class, r100);
    }

    public static MultiLinkPanelLifecycle[] values() {
        return (MultiLinkPanelLifecycle[]) f77076a.clone();
    }

    public MultiLinkPanelLifecycle(String r100, int r101) {
        super(r100, r101);
    }
}
