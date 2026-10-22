package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ShortcutRecommendItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShortcutRecommendItem implements Parcelable {
    public static final Parcelable.Creator<ShortcutRecommendItem> CREATOR = null;
    private final long createTime;
    private final boolean isShortInstructEnable;
    private final String originQuery;
    private final String shortQuery;
    private final String taskId;

    /* JADX INFO: compiled from: ShortcutRecommendItem.kt */
    public static final class Creator implements Parcelable.Creator<ShortcutRecommendItem> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ShortcutRecommendItem createFromParcel(Parcel r8) {
            o.e(r8, "parcel");
            String r1 = r8.readString();
            String r2 = r8.readString();
            String r3 = r8.readString();
            if (r8.readInt() == 0) goto L5;
            boolean r0 = true;
        L7:
            return new ShortcutRecommendItem(r1, r2, r3, r0, r8.readLong());
        L5:
            r0 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ShortcutRecommendItem createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ShortcutRecommendItem[] newArray(int r1) {
            return new ShortcutRecommendItem[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ShortcutRecommendItem[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ ShortcutRecommendItem copy$default(ShortcutRecommendItem r4, String r5, String r6, String r7, boolean r8, long r9, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.taskId;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.originQuery;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.shortQuery;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.isShortInstructEnable;
    L14:
        boolean r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.createTime;
    L17:
        String r10 = r5;
        return r4.copy(r10, r13, r0, r1, r9);
    }

    public final String component1() {
        return this.taskId;
    }

    public final String component2() {
        return this.originQuery;
    }

    public final String component3() {
        return this.shortQuery;
    }

    public final boolean component4() {
        return this.isShortInstructEnable;
    }

    public final long component5() {
        return this.createTime;
    }

    public final ShortcutRecommendItem copy(String r8, String r9, String r10, boolean r11, long r12) {
        o.e(r8, DBDefinition.TASK_ID);
        o.e(r9, "originQuery");
        return new ShortcutRecommendItem(r8, r9, r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, ShortcutRecommendItem.class) == true) goto L8;
        return false;
    L8:
        ShortcutRecommendItem r8 = (ShortcutRecommendItem) ZeusTransformUtils.preCheckCast(r7, ShortcutRecommendItem.class, "com.obric.aiagent.plugin");
        if (o.a(this.taskId, r8.taskId) == true) goto L12;
        return false;
    L12:
        if (o.a(this.originQuery, r8.originQuery) == true) goto L15;
        return false;
    L15:
        if (o.a(this.shortQuery, r8.shortQuery) == true) goto L18;
        return false;
    L18:
        if (this.isShortInstructEnable == r8.isShortInstructEnable) goto L21;
        return false;
    L21:
        if (this.createTime == r8.createTime) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.taskId.hashCode() * 31) + this.originQuery.hashCode()) * 31;
        String r1 = this.shortQuery;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + Boolean.hashCode(this.isShortInstructEnable)) * 31) + Long.hashCode(this.createTime);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ShortcutRecommendItem(taskId=" + this.taskId + ", originQuery=" + this.originQuery + ", shortQuery=" + this.shortQuery + ", isShortInstructEnable=" + this.isShortInstructEnable + ", createTime=" + this.createTime + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "dest");
        r3.writeString(this.taskId);
        r3.writeString(this.originQuery);
        r3.writeString(this.shortQuery);
        r3.writeInt(this.isShortInstructEnable ? 1 : 0);
        r3.writeLong(this.createTime);
    }

    public ShortcutRecommendItem(String r2, String r3, String r4, boolean r5, long r6) {
        o.e(r2, DBDefinition.TASK_ID);
        o.e(r3, "originQuery");
        this.taskId = r2;
        this.originQuery = r3;
        this.shortQuery = r4;
        this.isShortInstructEnable = r5;
        this.createTime = r6;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getOriginQuery() {
        return this.originQuery;
    }

    public final String getShortQuery() {
        return this.shortQuery;
    }

    public final boolean isShortInstructEnable() {
        return this.isShortInstructEnable;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getDisplayText() {
        String r0 = this.shortQuery;
        String r2 = null;
        if (r0 != null) goto L5;
    L7:
        r0 = null;
    L8:
        String r3 = this.originQuery;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L12;
        r2 = r3;
    L12:
        if (this.isShortInstructEnable == false) goto L16;
        if (r0 != null) goto L21;
        if (r2 == null) goto L23;
    L20:
        return r2;
    L23:
        return "";
    L21:
        return r0;
    L16:
        if (r2 != null) goto L20;
        if (r0 == null) goto L23;
        return r0;
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L7;
        goto L7
    }
}
