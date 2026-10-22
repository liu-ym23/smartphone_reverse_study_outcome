package com.bytedance.android.livesdk.interactivity.comment.frequentchat.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/frequentchat/model/FrequentChatShowMode;", "", "READ", "EDIT", "SORT", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FrequentChatShowMode extends Enum<FrequentChatShowMode> {
    public static final FrequentChatShowMode EDIT = null;
    public static final FrequentChatShowMode READ = null;
    public static final FrequentChatShowMode SORT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FrequentChatShowMode[] f134876a = null;

    static {
        FrequentChatShowMode r100 = new FrequentChatShowMode("READ", 0);
        READ = r100;
        FrequentChatShowMode r101 = new FrequentChatShowMode("EDIT", 1);
        EDIT = r101;
        FrequentChatShowMode r102 = new FrequentChatShowMode("SORT", 2);
        SORT = r102;
        f134876a = new FrequentChatShowMode[]{r100, r101, r102};
    }

    public static FrequentChatShowMode valueOf(String r100) {
        return (FrequentChatShowMode) r27.a.a(FrequentChatShowMode.class, r100);
    }

    public static FrequentChatShowMode[] values() {
        return (FrequentChatShowMode[]) f134876a.clone();
    }

    public FrequentChatShowMode(String r100, int r101) {
        super(r100, r101);
    }
}
