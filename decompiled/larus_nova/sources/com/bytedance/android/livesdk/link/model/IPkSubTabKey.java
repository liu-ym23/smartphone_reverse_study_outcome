package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0011\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0017\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0015\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPkSubTabKey;", "Lvh7/c;", "", "getFlexActivityId", "()J", "getFlexActivityId$annotations", "()V", "flexActivityId", "", "getActivityId", "()Ljava/lang/String;", "getActivityId$annotations", "activityId", "", "getGroupRivalsType", "()I", "getGroupRivalsType$annotations", "groupRivalsType", "getType", "getType$annotations", "type", "getInviteType", "getInviteType$annotations", "inviteType", "TabType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IPkSubTabKey extends vh7.c<IPkSubTabKey> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPkSubTabKey$TabType;", "", "GroupRivals", "FlexActivity", "Near", "CommonPanel", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum TabType extends Enum<TabType> {
        public static final TabType CommonPanel = null;
        public static final TabType FlexActivity = null;
        public static final TabType GroupRivals = null;
        public static final TabType Near = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TabType[] f147059a = null;

        static {
            TabType r100 = new TabType("GroupRivals", 0);
            GroupRivals = r100;
            TabType r101 = new TabType("FlexActivity", 1);
            FlexActivity = r101;
            TabType r102 = new TabType("Near", 2);
            Near = r102;
            TabType r103 = new TabType("CommonPanel", 3);
            CommonPanel = r103;
            f147059a = new TabType[]{r100, r101, r102, r103};
        }

        public static TabType valueOf(String r100) {
            return (TabType) r27.a.a(TabType.class, r100);
        }

        public static TabType[] values() {
            return (TabType[]) f147059a.clone();
        }

        public TabType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "activity_id")
    String getActivityId();

    @FieldName(name = "flex_activity_id")
    long getFlexActivityId();

    @FieldName(name = "group_rivals_type")
    int getGroupRivalsType();

    @FieldName(name = "invite_type")
    int getInviteType();

    @FieldName(name = "type")
    int getType();
}
