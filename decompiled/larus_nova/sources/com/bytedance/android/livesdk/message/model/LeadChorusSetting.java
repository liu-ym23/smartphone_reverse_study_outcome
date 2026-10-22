package com.bytedance.android.livesdk.message.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/LeadChorusSetting;", "", "", "value", "I", "getValue", "()I", "Close", "OrderUser", "AssignUser", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LeadChorusSetting extends Enum<LeadChorusSetting> {
    public static final LeadChorusSetting AssignUser = null;
    public static final LeadChorusSetting Close = null;
    public static final LeadChorusSetting OrderUser = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LeadChorusSetting[] f153565a = null;
    private final int value;

    static {
        LeadChorusSetting r100 = new LeadChorusSetting("Close", 0, 0);
        Close = r100;
        LeadChorusSetting r101 = new LeadChorusSetting("OrderUser", 1, 1);
        OrderUser = r101;
        LeadChorusSetting r102 = new LeadChorusSetting("AssignUser", 2, 2);
        AssignUser = r102;
        f153565a = new LeadChorusSetting[]{r100, r101, r102};
    }

    public static LeadChorusSetting valueOf(String r100) {
        return (LeadChorusSetting) r27.a.a(LeadChorusSetting.class, r100);
    }

    public static LeadChorusSetting[] values() {
        return (LeadChorusSetting[]) f153565a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LeadChorusSetting(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
