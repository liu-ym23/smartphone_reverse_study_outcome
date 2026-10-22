package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.battle.RivalsRecommendResponse.GroupRivals")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R$\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/GroupRivals;", "", "", "groupType", "I", "getGroupType", "()I", "setGroupType", "(I)V", "", "Lcom/bytedance/android/livesdk/chatroom/interact/model/l;", "rivals", "Ljava/util/List;", "getRivals", "()Ljava/util/List;", "setRivals", "(Ljava/util/List;)V", "", "imprId", "Ljava/lang/String;", "getImprId", "()Ljava/lang/String;", "setImprId", "(Ljava/lang/String;)V", "groupName", "getGroupName", "setGroupName", "detailType", "getDetailType", "setDetailType", "<init>", "()V", "GroupType", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GroupRivals implements vh7.h {

    @SerializedName("detail_type")
    protected String detailType;

    @SerializedName("group_name")
    protected String groupName;

    @SerializedName("group_rivals_type")
    protected int groupType;

    @SerializedName("impr_id")
    protected String imprId;

    @SerializedName("rivals")
    protected List<l> rivals;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/GroupRivals$GroupType;", "", "GroupUndefined", "GroupFeedFollowed", "GroupFeedRecommend", "GroupRivalsSearchHourlyRank", "GroupRivalsActivity", "GroupRivalsSearchPopularityRank", "GroupRivalsFeedAutoMatchSelfIn", "GroupRivalsMultipleFeedRecommend", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum GroupType extends Enum<GroupType> {
        public static final GroupType GroupFeedFollowed = null;
        public static final GroupType GroupFeedRecommend = null;
        public static final GroupType GroupRivalsActivity = null;
        public static final GroupType GroupRivalsFeedAutoMatchSelfIn = null;
        public static final GroupType GroupRivalsMultipleFeedRecommend = null;
        public static final GroupType GroupRivalsSearchHourlyRank = null;
        public static final GroupType GroupRivalsSearchPopularityRank = null;
        public static final GroupType GroupUndefined = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GroupType[] f106755a = null;

        static {
            GroupType r100 = new GroupType("GroupUndefined", 0);
            GroupUndefined = r100;
            GroupType r101 = new GroupType("GroupFeedFollowed", 1);
            GroupFeedFollowed = r101;
            GroupType r102 = new GroupType("GroupFeedRecommend", 2);
            GroupFeedRecommend = r102;
            GroupType r103 = new GroupType("GroupRivalsSearchHourlyRank", 3);
            GroupRivalsSearchHourlyRank = r103;
            GroupType r104 = new GroupType("GroupRivalsActivity", 4);
            GroupRivalsActivity = r104;
            GroupType r105 = new GroupType("GroupRivalsSearchPopularityRank", 5);
            GroupRivalsSearchPopularityRank = r105;
            GroupType r106 = new GroupType("GroupRivalsFeedAutoMatchSelfIn", 6);
            GroupRivalsFeedAutoMatchSelfIn = r106;
            GroupType r107 = new GroupType("GroupRivalsMultipleFeedRecommend", 7);
            GroupRivalsMultipleFeedRecommend = r107;
            f106755a = new GroupType[]{r100, r101, r102, r103, r104, r105, r106, r107};
        }

        public static GroupType valueOf(String r100) {
            return (GroupType) r27.a.a(GroupType.class, r100);
        }

        public static GroupType[] values() {
            return (GroupType[]) f106755a.clone();
        }

        public GroupType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public GroupRivals() {
    }

    public GroupRivals(am3.g r100) {
        this.rivals = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.groupType = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.rivals.add(new l(r100));
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.imprId = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.groupName = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.detailType = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }
}
