package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0002\f\rR0\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IGroupRivals;", "Lvh7/c;", "", "", "Lcom/bytedance/android/livesdk/link/model/m2;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getSortRivals", "()Ljava/util/List;", "setSortRivals", "(Ljava/util/List;)V", "sortRivals", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "GroupType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IGroupRivals extends vh7.c<IGroupRivals> {
    public static final a Companion = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IGroupRivals$GroupType;", "", "GroupUndefined", "GroupFeedFollowed", "GroupFeedRecommend", "GroupRivalsSearchHourlyRank", "GroupRivalsActivity", "GroupRivalsSearchPopularityRank", "GroupRivalsFeedAutoMatchSelfIn", "GroupRivalsMultipleFeedRecommend", "GroupRivalsNewRecommend", "GroupRivalsNewFollowed", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum GroupType extends Enum<GroupType> {
        public static final GroupType GroupFeedFollowed = null;
        public static final GroupType GroupFeedRecommend = null;
        public static final GroupType GroupRivalsActivity = null;
        public static final GroupType GroupRivalsFeedAutoMatchSelfIn = null;
        public static final GroupType GroupRivalsMultipleFeedRecommend = null;
        public static final GroupType GroupRivalsNewFollowed = null;
        public static final GroupType GroupRivalsNewRecommend = null;
        public static final GroupType GroupRivalsSearchHourlyRank = null;
        public static final GroupType GroupRivalsSearchPopularityRank = null;
        public static final GroupType GroupUndefined = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GroupType[] f147039a = null;

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
            GroupType r108 = new GroupType("GroupRivalsNewRecommend", 8);
            GroupRivalsNewRecommend = r108;
            GroupType r109 = new GroupType("GroupRivalsNewFollowed", 9);
            GroupRivalsNewFollowed = r109;
            f147039a = new GroupType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
        }

        public static GroupType valueOf(String r100) {
            return (GroupType) r27.a.a(GroupType.class, r100);
        }

        public static GroupType[] values() {
            return (GroupType[]) f147039a.clone();
        }

        public GroupType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f147040a = null;

        public a() {
        }

        static {
            f147040a = new a();
        }
    }

    static {
        Companion = a.f147040a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ String getDetailType();

    /* synthetic */ com.bytedance.android.live.base.model.message.a5 getGroupInfo();

    /* synthetic */ String getGroupName();

    /* synthetic */ int getGroupType();

    /* synthetic */ boolean getHasSelectButton();

    /* synthetic */ String getImprId();

    /* synthetic */ List<m2> getRivals();

    /* synthetic */ int getSelectType();

    List<m2> getSortRivals();

    /* synthetic */ int getStatus();

    /* synthetic */ void setRivals(List<? extends m2> r100);

    void setSortRivals(List<? extends m2> r100);
}
