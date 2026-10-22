package com.bytedance.android.live.ktv.common.karaokestation.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/model/FirstLevelTab;", "", "", "value", "I", "getValue", "()I", "Unknown", "FirstOpenTab", "OrderedSongTab", "OrderSongTab", "MySongTab", "PersonalKaraokeSungTab", "RealTimeChorusTab", "WantListenTab", "AudienceSingTab", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum FirstLevelTab extends Enum<FirstLevelTab> {
    public static final FirstLevelTab AudienceSingTab = null;
    public static final FirstLevelTab FirstOpenTab = null;
    public static final FirstLevelTab MySongTab = null;
    public static final FirstLevelTab OrderSongTab = null;
    public static final FirstLevelTab OrderedSongTab = null;
    public static final FirstLevelTab PersonalKaraokeSungTab = null;
    public static final FirstLevelTab RealTimeChorusTab = null;
    public static final FirstLevelTab Unknown = null;
    public static final FirstLevelTab WantListenTab = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FirstLevelTab[] f69487a = null;
    private final int value;

    public static FirstLevelTab valueOf(String r100) {
        return (FirstLevelTab) r27.a.a(FirstLevelTab.class, r100);
    }

    public static FirstLevelTab[] values() {
        return (FirstLevelTab[]) f69487a.clone();
    }

    static {
        FirstLevelTab r100 = new FirstLevelTab("Unknown", 0, 0);
        Unknown = r100;
        FirstLevelTab r101 = new FirstLevelTab("FirstOpenTab", 1, 1);
        FirstOpenTab = r101;
        FirstLevelTab r102 = new FirstLevelTab("OrderedSongTab", 2, 2);
        OrderedSongTab = r102;
        FirstLevelTab r103 = new FirstLevelTab("OrderSongTab", 3, 3);
        OrderSongTab = r103;
        FirstLevelTab r104 = new FirstLevelTab("MySongTab", 4, 4);
        MySongTab = r104;
        FirstLevelTab r105 = new FirstLevelTab("PersonalKaraokeSungTab", 5, 5);
        PersonalKaraokeSungTab = r105;
        FirstLevelTab r106 = new FirstLevelTab("RealTimeChorusTab", 6, 6);
        RealTimeChorusTab = r106;
        FirstLevelTab r107 = new FirstLevelTab("WantListenTab", 7, 100);
        WantListenTab = r107;
        FirstLevelTab r108 = new FirstLevelTab("AudienceSingTab", 8, 101);
        AudienceSingTab = r108;
        f69487a = new FirstLevelTab[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public final int getValue() {
        return this.value;
    }

    public FirstLevelTab(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
