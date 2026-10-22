package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.linkmic.RivalsResponse.ResponseData")
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b9\u0010:R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR0\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R0\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020$\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0011\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00106\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\u0018\u001a\u0004\b7\u0010\u001a\"\u0004\b8\u0010\u001c¨\u0006;"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/m0;", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "followedList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setFollowedList", "(Ljava/util/List;)V", "recommendList", "getRecommendList", "setRecommendList", "", "", "Lcom/bytedance/android/livesdk/chatroom/interact/model/RivalExtraInfo;", "rivalExtraInfos", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "setRivalExtraInfos", "(Ljava/util/Map;)V", "", "tips", "Ljava/lang/String;", "getTips", "()Ljava/lang/String;", "setTips", "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdk/chatroom/interact/model/n0;", "searchBar", "Lcom/bytedance/android/livesdk/chatroom/interact/model/n0;", "getSearchBar", "()Lcom/bytedance/android/livesdk/chatroom/interact/model/n0;", "setSearchBar", "(Lcom/bytedance/android/livesdk/chatroom/interact/model/n0;)V", "Lcom/bytedance/android/livesdk/chatroom/interact/model/o;", "tagsMap", "getTagsMap", "setTagsMap", "Lcom/bytedance/android/livesdk/chatroom/interact/model/l0;", "activityData", "Lcom/bytedance/android/livesdk/chatroom/interact/model/l0;", "getActivityData", "()Lcom/bytedance/android/livesdk/chatroom/interact/model/l0;", "setActivityData", "(Lcom/bytedance/android/livesdk/chatroom/interact/model/l0;)V", "", "tabLocate", "I", "getTabLocate", "()I", "setTabLocate", "(I)V", "followedListGroupName", "getFollowedListGroupName", "setFollowedListGroupName", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m0 implements vh7.h {

    @SerializedName("activity_data")
    protected l0 activityData;

    @SerializedName("followed_list")
    protected List<Room> followedList;

    @SerializedName("followedlist_group_name")
    protected String followedListGroupName;

    @SerializedName("recommend_list")
    protected List<Room> recommendList;

    @SerializedName("rival_extra_infos")
    protected Map<Long, RivalExtraInfo> rivalExtraInfos;

    @SerializedName(PickerReporterConstants.VALUE.CLICK.BAR)
    protected n0 searchBar;

    @SerializedName("tab_locate")
    protected int tabLocate;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    protected Map<Long, o> tagsMap;

    @SerializedName("tips")
    protected String tips;

    public m0() {
    }

    public final List<Room> a() {
        return this.followedList;
    }

    public final Map<Long, RivalExtraInfo> b() {
        return this.rivalExtraInfos;
    }

    public m0(am3.g r110) {
        this.followedList = new ArrayList();
        this.recommendList = new ArrayList();
        this.rivalExtraInfos = new HashMap();
        this.tagsMap = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L64;
        if (r101 == 1) goto L62;
        if (r101 != 11) goto L10;
        this.activityData = new l0(r110);
        goto L3
    L10:
        if (r101 != 15) goto L11;
        this.tabLocate = (int) r110.j();
        goto L3
    L11:
        Long r102 = null;
        if (r101 == 17) goto L44;
        if (r101 != 20) goto L16;
        this.followedListGroupName = am3.h.c(r110);
        goto L3
    L16:
        if (r101 != 3) goto L18;
        List<Room> r103 = this.recommendList;
        Room r104 = new Room(r110);
    L63:
        r103.add(r104);
        goto L3
    L18:
        if (r101 != 4) goto L20;
        long r111 = r110.c();
        Object r105 = null;
    L27:
        int r106 = r110.f();
        if (r106 == (-1)) goto L34;
        if (r106 != 1) goto L30;
        r102 = Long.valueOf(r110.j());
        goto L27
    L30:
        if (r106 != 2) goto L31;
        r105 = new RivalExtraInfo(r110);
        goto L27
    L31:
        am3.h.e(r110);
        goto L27
    L34:
        r110.d(r111);
        Map r107 = this.rivalExtraInfos;
        if (r102 == null) goto L41;
        if (r105 == null) goto L39;
    L37:
        r107.put(r102, r105);
        goto L3
    L39:
        throw new IllegalStateException("Value must not be null");
    L41:
        throw new IllegalStateException("Key must not be null");
    L20:
        if (r101 != 6) goto L22;
        this.tips = am3.h.c(r110);
        goto L3
    L22:
        if (r101 != 7) goto L23;
        this.searchBar = new n0(r110);
        goto L3
    L23:
        am3.h.e(r110);
        goto L3
    L44:
        long r112 = r110.c();
        r105 = null;
    L45:
        int r108 = r110.f();
        if (r108 == (-1)) goto L52;
        if (r108 != 1) goto L48;
        r102 = Long.valueOf(r110.j());
        goto L45
    L48:
        if (r108 != 2) goto L49;
        r105 = new o(r110);
        goto L45
    L49:
        am3.h.e(r110);
        goto L45
    L52:
        r110.d(r112);
        r107 = this.tagsMap;
        if (r102 == null) goto L59;
        if (r105 != null) goto L37;
        throw new IllegalStateException("Value must not be null");
    L59:
        throw new IllegalStateException("Key must not be null");
    L62:
        r103 = this.followedList;
        r104 = new Room(r110);
        goto L63
    L64:
        r110.d(r100);
    }
}
