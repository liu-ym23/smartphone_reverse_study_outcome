package com.bytedance.android.livesdkapi.paramtransfer.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.livesdkapi.depend.model.live.MetricTrackerData;
import com.bytedance.android.livesdkapi.enterparam.CommonEnterParamsData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010P\u001a\u00020QHÖ\u0001J\u0019\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020QHÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR6\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0019j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u001a\u0010\"\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\u001a\u0010%\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\u001a\u0010(\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\u001a\u0010+\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR6\u0010.\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0019j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u001eR6\u00101\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0019j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001c\"\u0004\b3\u0010\u001eR6\u00104\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0019j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001c\"\u0004\b6\u0010\u001eR\u001a\u00107\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR\u001a\u0010:\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u0010\bR\u001a\u0010=\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR\u001a\u0010@\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\bR\u001a\u0010C\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010\bR\u001a\u0010F\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0006\"\u0004\bH\u0010\bR \u0010I\u001a\b\u0012\u0004\u0012\u00020K0JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010O¨\u0006W"}, d2 = {"Lcom/bytedance/android/livesdkapi/paramtransfer/model/RoomBundleParams;", "Landroid/os/Parcelable;", "()V", "adClick", "", "getAdClick", "()Ljava/lang/String;", "setAdClick", "(Ljava/lang/String;)V", "adCommon", "getAdCommon", "setAdCommon", "adFirstShow", "getAdFirstShow", "setAdFirstShow", "commonEnterParams", "Lcom/bytedance/android/livesdkapi/enterparam/CommonEnterParamsData;", "getCommonEnterParams", "()Lcom/bytedance/android/livesdkapi/enterparam/CommonEnterParamsData;", "setCommonEnterParams", "(Lcom/bytedance/android/livesdkapi/enterparam/CommonEnterParamsData;)V", "communityClick", "getCommunityClick", "setCommunityClick", "communityClickMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getCommunityClickMap", "()Ljava/util/HashMap;", "setCommunityClickMap", "(Ljava/util/HashMap;)V", "communityCommon", "getCommunityCommon", "setCommunityCommon", "communityFirstShow", "getCommunityFirstShow", "setCommunityFirstShow", "ecomClick", "getEcomClick", "setEcomClick", "ecomCommon", "getEcomCommon", "setEcomCommon", "ecomFirstShow", "getEcomFirstShow", "setEcomFirstShow", "enterClick", "getEnterClick", "setEnterClick", "enterCommon", "getEnterCommon", "setEnterCommon", "eventFirstShow", "getEventFirstShow", "setEventFirstShow", "gameCpClick", "getGameCpClick", "setGameCpClick", "gameCpCommon", "getGameCpCommon", "setGameCpCommon", "gameCpFirstShow", "getGameCpFirstShow", "setGameCpFirstShow", "lifeClick", "getLifeClick", "setLifeClick", "lifeCommon", "getLifeCommon", "setLifeCommon", "lifeFirstShow", "getLifeFirstShow", "setLifeFirstShow", "trackerDataList", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/MetricTrackerData;", "getTrackerDataList", "()Ljava/util/List;", "setTrackerDataList", "(Ljava/util/List;)V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomBundleParams implements Parcelable {
    public static final Parcelable.Creator<RoomBundleParams> CREATOR = null;
    private String adClick;
    private String adCommon;
    private String adFirstShow;
    private CommonEnterParamsData commonEnterParams;
    private String communityClick;
    private HashMap<String, String> communityClickMap;
    private String communityCommon;
    private String communityFirstShow;
    private String ecomClick;
    private String ecomCommon;
    private String ecomFirstShow;
    private HashMap<String, String> enterClick;
    private HashMap<String, String> enterCommon;
    private HashMap<String, String> eventFirstShow;
    private String gameCpClick;
    private String gameCpCommon;
    private String gameCpFirstShow;
    private String lifeClick;
    private String lifeCommon;
    private String lifeFirstShow;
    private List<MetricTrackerData> trackerDataList;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static class Creator implements Parcelable.Creator<RoomBundleParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RoomBundleParams createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            if (r100.readInt() != 0) goto L7;
            return null;
        L7:
            return new RoomBundleParams();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RoomBundleParams[] newArray(int r100) {
            return new RoomBundleParams[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RoomBundleParams createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RoomBundleParams[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new Creator();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(1);
    }

    public RoomBundleParams() {
        this.eventFirstShow = new HashMap();
        this.enterCommon = new HashMap();
        this.enterClick = new HashMap();
        this.trackerDataList = new ArrayList();
        this.ecomCommon = "";
        this.ecomClick = "";
        this.ecomFirstShow = "";
        this.communityCommon = "";
        this.communityClick = "";
        this.communityClickMap = new HashMap();
        this.communityFirstShow = "";
        this.adCommon = "";
        this.adClick = "";
        this.adFirstShow = "";
        this.lifeCommon = "";
        this.lifeClick = "";
        this.lifeFirstShow = "";
        this.gameCpCommon = "";
        this.gameCpClick = "";
        this.gameCpFirstShow = "";
    }

    public final String getAdClick() {
        return this.adClick;
    }

    public final String getAdCommon() {
        return this.adCommon;
    }

    public final String getAdFirstShow() {
        return this.adFirstShow;
    }

    public final CommonEnterParamsData getCommonEnterParams() {
        return this.commonEnterParams;
    }

    public final String getCommunityClick() {
        return this.communityClick;
    }

    public final HashMap<String, String> getCommunityClickMap() {
        return this.communityClickMap;
    }

    public final String getCommunityCommon() {
        return this.communityCommon;
    }

    public final String getCommunityFirstShow() {
        return this.communityFirstShow;
    }

    public final String getEcomClick() {
        return this.ecomClick;
    }

    public final String getEcomCommon() {
        return this.ecomCommon;
    }

    public final String getEcomFirstShow() {
        return this.ecomFirstShow;
    }

    public final HashMap<String, String> getEnterClick() {
        return this.enterClick;
    }

    public final HashMap<String, String> getEnterCommon() {
        return this.enterCommon;
    }

    public final HashMap<String, String> getEventFirstShow() {
        return this.eventFirstShow;
    }

    public final String getGameCpClick() {
        return this.gameCpClick;
    }

    public final String getGameCpCommon() {
        return this.gameCpCommon;
    }

    public final String getGameCpFirstShow() {
        return this.gameCpFirstShow;
    }

    public final String getLifeClick() {
        return this.lifeClick;
    }

    public final String getLifeCommon() {
        return this.lifeCommon;
    }

    public final String getLifeFirstShow() {
        return this.lifeFirstShow;
    }

    public final List<MetricTrackerData> getTrackerDataList() {
        return this.trackerDataList;
    }

    public final void setAdClick(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.adClick = r100;
    }

    public final void setAdCommon(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.adCommon = r100;
    }

    public final void setAdFirstShow(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.adFirstShow = r100;
    }

    public final void setCommonEnterParams(CommonEnterParamsData r100) {
        this.commonEnterParams = r100;
    }

    public final void setCommunityClick(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.communityClick = r100;
    }

    public final void setCommunityClickMap(HashMap<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.communityClickMap = r100;
    }

    public final void setCommunityCommon(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.communityCommon = r100;
    }

    public final void setCommunityFirstShow(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.communityFirstShow = r100;
    }

    public final void setEcomClick(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ecomClick = r100;
    }

    public final void setEcomCommon(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ecomCommon = r100;
    }

    public final void setEcomFirstShow(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ecomFirstShow = r100;
    }

    public final void setEnterClick(HashMap<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterClick = r100;
    }

    public final void setEnterCommon(HashMap<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterCommon = r100;
    }

    public final void setEventFirstShow(HashMap<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.eventFirstShow = r100;
    }

    public final void setGameCpClick(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.gameCpClick = r100;
    }

    public final void setGameCpCommon(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.gameCpCommon = r100;
    }

    public final void setGameCpFirstShow(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.gameCpFirstShow = r100;
    }

    public final void setLifeClick(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lifeClick = r100;
    }

    public final void setLifeCommon(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lifeCommon = r100;
    }

    public final void setLifeFirstShow(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lifeFirstShow = r100;
    }

    public final void setTrackerDataList(List<MetricTrackerData> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.trackerDataList = r100;
    }
}
