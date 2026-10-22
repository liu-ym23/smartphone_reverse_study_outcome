package com.bytedance.android.livesdkapi.depend.model.live.pay;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.paid.PaidReplayConstants;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\bR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PrivilegeInfo;", "", "()V", "entityConfig", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PaidLiveConfig;", "entityid", "", "extra", "", "itemList", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PaidLiveItemInfo;", "paidLiveInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PrivilegeBaseInfo;", "paidLiveType", "", "privilegeUrl", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PrivilegeUrl;", "uiConfig", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PaidLiveUIBaseConfig;", "getItemIdsForTeaLog", "getWatchStatus", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PrivilegeInfo implements h {
    public static final Companion Companion = null;
    public static final int ItemType_AnchorID = 3;
    public static final int ItemType_TicketSkuID = 2;
    public static final int ItemType_TicketSpuID = 1;
    public static final int ItemType_UnKnow = 0;
    public static final int PaidLiveType_Camera = 3;
    public static final int PaidLiveType_Camera_Privilege = 6;
    public static final int PaidLiveType_Clarity = 4;
    public static final int PaidLiveType_LiuYan = 5;
    public static final int PaidLiveType_Room = 1;
    public static final int PaidLiveType_Subscribe = 101;
    public static final int PaidLiveType_UnKnow = 0;

    @SerializedName("entity_config")
    public PaidLiveConfig entityConfig;

    @SerializedName(PickerReporterConstants.KEY.ENTITY_ID)
    public long entityid;

    @SerializedName("extra")
    public String extra;

    @SerializedName("item_list")
    public List<PaidLiveItemInfo> itemList;

    @SerializedName("paid_live_info")
    public PrivilegeBaseInfo paidLiveInfo;

    @SerializedName(PaidReplayConstants.KEY_PRIVILEGE_TYPE)
    public int paidLiveType;

    @SerializedName("privilege_url")
    public PrivilegeUrl privilegeUrl;

    @SerializedName("ui_config")
    public PaidLiveUIBaseConfig uiConfig;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PrivilegeInfo$Companion;", "", "()V", "ItemType_AnchorID", "", "ItemType_TicketSkuID", "ItemType_TicketSpuID", "ItemType_UnKnow", "PaidLiveType_Camera", "PaidLiveType_Camera_Privilege", "PaidLiveType_Clarity", "PaidLiveType_LiuYan", "PaidLiveType_Room", "PaidLiveType_Subscribe", "PaidLiveType_UnKnow", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PrivilegeInfo() {
    }

    public final String getItemIdsForTeaLog() {
        List<PaidLiveItemInfo> r100 = this.itemList;
        if (r100 != null) goto L5;
        return "";
    L5:
        if (r100 == null) goto L27;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        Object r103 = r102.next();
        if (ArraysKt.contains(new Integer[]{1, 2}, Integer.valueOf(((PaidLiveItemInfo) r103).itemtype)) == false) goto L8;
        r101.add(r103);
        goto L8
    L12:
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r105 = r101.iterator();
    L14:
        if (r105.hasNext() == false) goto L16;
        r104.add(Long.valueOf(((PaidLiveItemInfo) r105.next()).itemid));
        goto L14
    L16:
        String r106 = CollectionsKt.joinToString$default(r104, ",", "[", "]", 0, null, null, 56, null);
        if (r106 != null) goto L20;
        return "";
    L20:
        return r106;
    L27:
        return "";
    }

    public final String getWatchStatus() {
        PaidLiveConfig r100 = this.entityConfig;
        if (r100 == null) goto L7;
        PaidLiveConfig.UserRight r101 = r100.userRight;
        if (r101 == null) goto L7;
        Integer r102 = Integer.valueOf(r101.viewRight);
    L8:
        if (r102 == null) goto L16;
        PaidLiveConfig r103 = this.entityConfig;
        if (r103 == null) goto L15;
        PaidLiveConfig.UserRight r104 = r103.userRight;
        if (r104 == null) goto L15;
        if (r104.viewRight == 0) goto L16;
    L15:
        String r105 = "regular";
    L17:
        PaidLiveConfig r106 = this.entityConfig;
        if (r106 == null) goto L22;
        PaidLiveConfig.UserRight r107 = r106.userRight;
        if (r107 == null) goto L22;
        long r108 = r107.duration;
    L23:
        PaidLiveUIBaseConfig r109 = this.uiConfig;
        if (r109 == null) goto L26;
        long r110 = r109.duration;
    L28:
        if (r108 < r110) goto L31;
        return "try_end";
    L31:
        return r105;
    L26:
        r110 = 0;
    L22:
        r108 = -1;
    L16:
        r105 = "try";
    L7:
        r102 = null;
        goto L8
    }

    public PrivilegeInfo(g r100) {
        this.itemList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        switch(r102) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.entityConfig = new PaidLiveConfig(r100);
        goto L3
    L8:
        this.uiConfig = new PaidLiveUIBaseConfig(r100);
        goto L3
    L9:
        this.privilegeUrl = new PrivilegeUrl(r100);
        goto L3
    L10:
        this.extra = am3.h.c(r100);
        goto L3
    L11:
        this.paidLiveInfo = new PrivilegeBaseInfo(r100);
        goto L3
    L12:
        this.paidLiveType = r100.i();
        goto L3
    L13:
        this.itemList.add(new PaidLiveItemInfo(r100));
        goto L3
    L14:
        this.entityid = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
