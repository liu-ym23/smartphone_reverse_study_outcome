package com.bytedance.android.livesdk.interactivity.comment.frequentchat.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/frequentchat/model/FrequentChatSubPanelSource;", "", "ADD", "EDIT", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FrequentChatSubPanelSource extends Enum<FrequentChatSubPanelSource> {
    public static final FrequentChatSubPanelSource ADD = null;
    public static final FrequentChatSubPanelSource EDIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FrequentChatSubPanelSource[] f134877a = null;

    static {
        FrequentChatSubPanelSource r100 = new FrequentChatSubPanelSource("ADD", 0);
        ADD = r100;
        FrequentChatSubPanelSource r101 = new FrequentChatSubPanelSource("EDIT", 1);
        EDIT = r101;
        f134877a = new FrequentChatSubPanelSource[]{r100, r101};
    }

    public static FrequentChatSubPanelSource valueOf(String r100) {
        return (FrequentChatSubPanelSource) r27.a.a(FrequentChatSubPanelSource.class, r100);
    }

    public static FrequentChatSubPanelSource[] values() {
        return (FrequentChatSubPanelSource[]) f134877a.clone();
    }

    public FrequentChatSubPanelSource(String r100, int r101) {
        super(r100, r101);
    }
}
