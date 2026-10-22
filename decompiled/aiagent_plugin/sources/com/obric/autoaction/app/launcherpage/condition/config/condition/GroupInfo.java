package com.obric.autoaction.app.launcherpage.condition.config.condition;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AutoCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class GroupInfo implements Parcelable {
    public static final Parcelable.Creator<GroupInfo> CREATOR = null;
    public static final a Companion = null;
    private static final GroupInfo DAY_TIME_GROUP = null;
    private static final GroupInfo EXTRA_EVENT_GROUP = null;
    private static final GroupInfo LOCATION_GROUP = null;
    private final int activeColor;
    private final int activeSpanTextWeight;
    private final int defaultColor;
    private final int defaultSpanTextWeight;
    private final String groupName;
    private final int groupTitleRes;
    private final int icon;

    /* JADX INFO: compiled from: AutoCondition.kt */
    public static final class Creator implements Parcelable.Creator<GroupInfo> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GroupInfo createFromParcel(Parcel r9) {
            o.e(r9, "parcel");
            return new GroupInfo(r9.readString(), r9.readInt(), r9.readInt(), r9.readInt(), r9.readInt(), r9.readInt(), r9.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GroupInfo createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GroupInfo[] newArray(int r1) {
            return new GroupInfo[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GroupInfo[] newArray(int r1) {
            return newArray(r1);
        }
    }

    /* JADX INFO: compiled from: AutoCondition.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final GroupInfo a() {
            return GroupInfo.access$getDAY_TIME_GROUP$cp();
        }

        public final GroupInfo b() {
            return GroupInfo.access$getLOCATION_GROUP$cp();
        }

        public final GroupInfo c() {
            return GroupInfo.access$getEXTRA_EVENT_GROUP$cp();
        }
    }

    public static /* synthetic */ GroupInfo copy$default(GroupInfo r5, String r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.groupName;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.groupTitleRes;
    L8:
        int r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.activeColor;
    L11:
        int r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.defaultColor;
    L14:
        int r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.activeSpanTextWeight;
    L17:
        int r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.defaultSpanTextWeight;
    L20:
        int r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.icon;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.groupName;
    }

    public final int component2() {
        return this.groupTitleRes;
    }

    public final int component3() {
        return this.activeColor;
    }

    public final int component4() {
        return this.defaultColor;
    }

    public final int component5() {
        return this.activeSpanTextWeight;
    }

    public final int component6() {
        return this.defaultSpanTextWeight;
    }

    public final int component7() {
        return this.icon;
    }

    public final GroupInfo copy(String r9, int r10, int r11, int r12, int r13, int r14, int r15) {
        o.e(r9, "groupName");
        return new GroupInfo(r9, r10, r11, r12, r13, r14, r15);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GroupInfo.class) == true) goto L8;
        return false;
    L8:
        GroupInfo r6 = (GroupInfo) ZeusTransformUtils.preCheckCast(r5, GroupInfo.class, "com.obric.aiagent.plugin");
        if (o.a(this.groupName, r6.groupName) == true) goto L12;
        return false;
    L12:
        if (this.groupTitleRes == r6.groupTitleRes) goto L15;
        return false;
    L15:
        if (this.activeColor == r6.activeColor) goto L18;
        return false;
    L18:
        if (this.defaultColor == r6.defaultColor) goto L21;
        return false;
    L21:
        if (this.activeSpanTextWeight == r6.activeSpanTextWeight) goto L24;
        return false;
    L24:
        if (this.defaultSpanTextWeight == r6.defaultSpanTextWeight) goto L27;
        return false;
    L27:
        if (this.icon == r6.icon) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        return (((((((((((this.groupName.hashCode() * 31) + Integer.hashCode(this.groupTitleRes)) * 31) + Integer.hashCode(this.activeColor)) * 31) + Integer.hashCode(this.defaultColor)) * 31) + Integer.hashCode(this.activeSpanTextWeight)) * 31) + Integer.hashCode(this.defaultSpanTextWeight)) * 31) + Integer.hashCode(this.icon);
    }

    public String toString() {
        return "GroupInfo(groupName=" + this.groupName + ", groupTitleRes=" + this.groupTitleRes + ", activeColor=" + this.activeColor + ", defaultColor=" + this.defaultColor + ", activeSpanTextWeight=" + this.activeSpanTextWeight + ", defaultSpanTextWeight=" + this.defaultSpanTextWeight + ", icon=" + this.icon + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeString(this.groupName);
        r1.writeInt(this.groupTitleRes);
        r1.writeInt(this.activeColor);
        r1.writeInt(this.defaultColor);
        r1.writeInt(this.activeSpanTextWeight);
        r1.writeInt(this.defaultSpanTextWeight);
        r1.writeInt(this.icon);
    }

    public static final /* synthetic */ GroupInfo access$getDAY_TIME_GROUP$cp() {
        return DAY_TIME_GROUP;
    }

    public static final /* synthetic */ GroupInfo access$getEXTRA_EVENT_GROUP$cp() {
        return EXTRA_EVENT_GROUP;
    }

    public static final /* synthetic */ GroupInfo access$getLOCATION_GROUP$cp() {
        return LOCATION_GROUP;
    }

    public GroupInfo(String r2, int r3, int r4, int r5, int r6, int r7, int r8) {
        o.e(r2, "groupName");
        this.groupName = r2;
        this.groupTitleRes = r3;
        this.activeColor = r4;
        this.defaultColor = r5;
        this.activeSpanTextWeight = r6;
        this.defaultSpanTextWeight = r7;
        this.icon = r8;
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final int getGroupTitleRes() {
        return this.groupTitleRes;
    }

    public final int getActiveColor() {
        return this.activeColor;
    }

    public final int getDefaultColor() {
        return this.defaultColor;
    }

    public final int getActiveSpanTextWeight() {
        return this.activeSpanTextWeight;
    }

    public final int getDefaultSpanTextWeight() {
        return this.defaultSpanTextWeight;
    }

    public final int getIcon() {
        return this.icon;
    }

    static {
        Companion = new a(null);
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        DAY_TIME_GROUP = new GroupInfo("day_time", ZeusTransformUtils.mapRes(R.string.condition_group_day_time, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_group_day_time"), ZeusTransformUtils.mapRes(R.color.oui_functional_blue_6, "color", "oui_functional_blue_6"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3"), 500, 400, ZeusTransformUtils.mapRes(R.drawable.time_small, "drawable", "time_small"));
        LOCATION_GROUP = new GroupInfo("location", ZeusTransformUtils.mapRes(R.string.condition_group_location, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_group_location"), ZeusTransformUtils.mapRes(R.color.oui_functional_blue_6, "color", "oui_functional_blue_6"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3"), 500, 400, ZeusTransformUtils.mapRes(R.drawable.ic_location_small, "drawable", "ic_location_small"));
        EXTRA_EVENT_GROUP = new GroupInfo("extra_event", ZeusTransformUtils.mapRes(R.string.condition_group_extra_event, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_group_extra_event"), ZeusTransformUtils.mapRes(R.color.oui_functional_blue_6, "color", "oui_functional_blue_6"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3"), 500, 400, ZeusTransformUtils.mapRes(R.drawable.ic_event_small, "drawable", "ic_event_small"));
    }
}
