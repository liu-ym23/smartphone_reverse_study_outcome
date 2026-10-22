package com.bytedance.applet.aibridge.navi;

import com.google.gson.annotations.SerializedName;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.lark.banner.export.entity.BannerBizName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/applet/aibridge/navi/NavigationPageFrom;", "", "<init>", "(Ljava/lang/String;I)V", "TOOL", "TASK", "POPUP", AccountType.OTHERS, BannerBizName.NOTIFICATION, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NavigationPageFrom extends Enum<NavigationPageFrom> {

    @SerializedName("from_island")
    public static final NavigationPageFrom NOTIFICATION = null;

    @SerializedName("from_others")
    public static final NavigationPageFrom OTHERS = null;

    @SerializedName("from_popup")
    public static final NavigationPageFrom POPUP = null;

    @SerializedName("from_task")
    public static final NavigationPageFrom TASK = null;

    @SerializedName("from_tool")
    public static final NavigationPageFrom TOOL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NavigationPageFrom[] f191222a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f191223b = null;

    public static EnumEntries<NavigationPageFrom> getEntries() {
        return f191223b;
    }

    static {
        NavigationPageFrom r100 = new NavigationPageFrom("TOOL", 0);
        TOOL = r100;
        NavigationPageFrom r101 = new NavigationPageFrom("TASK", 1);
        TASK = r101;
        NavigationPageFrom r102 = new NavigationPageFrom("POPUP", 2);
        POPUP = r102;
        NavigationPageFrom r103 = new NavigationPageFrom(AccountType.OTHERS, 3);
        OTHERS = r103;
        NavigationPageFrom r104 = new NavigationPageFrom(BannerBizName.NOTIFICATION, 4);
        NOTIFICATION = r104;
        NavigationPageFrom[] r105 = {r100, r101, r102, r103, r104};
        f191222a = r105;
        f191223b = EnumEntriesKt.enumEntries(r105);
    }

    public static NavigationPageFrom[] values() {
        return (NavigationPageFrom[]) f191222a.clone();
    }

    public static NavigationPageFrom valueOf(String r100) {
        return (NavigationPageFrom) r27.a.a(NavigationPageFrom.class, r100);
    }

    public NavigationPageFrom(String r100, int r101) {
        super(r100, r101);
    }
}
