package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: FeedbackBean.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FeedbackBean implements Parcelable {
    public static final Parcelable.Creator<FeedbackBean> CREATOR = null;
    private final String description;
    private final ArrayList<String> filePath;
    private final boolean launchReportAppWhenNoPermission;
    private final boolean needReportVoc;
    private final boolean needShowToast;

    /* JADX INFO: compiled from: FeedbackBean.kt */
    public static final class Creator implements Parcelable.Creator<FeedbackBean> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FeedbackBean createFromParcel(Parcel r8) {
            o.e(r8, "parcel");
            ArrayList<String> r1 = r8.createStringArrayList();
            String r2 = r8.readString();
            if (r8.readInt() == 0) goto L5;
            boolean r5 = true;
        L7:
            if (r8.readInt() == 0) goto L9;
            boolean r6 = true;
        L11:
            if (r8.readInt() == 0) goto L13;
            boolean r9 = true;
        L15:
            return new FeedbackBean(r1, r2, r5, r6, r9);
        L13:
            r9 = false;
            goto L15
        L9:
            r6 = false;
            goto L11
        L5:
            r5 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FeedbackBean createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FeedbackBean[] newArray(int r1) {
            return new FeedbackBean[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FeedbackBean[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeedbackBean copy$default(FeedbackBean r3, ArrayList r4, String r5, boolean r6, boolean r7, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.filePath;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.description;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.needReportVoc;
    L11:
        boolean r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.launchReportAppWhenNoPermission;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.needShowToast;
    L17:
        ArrayList r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final ArrayList<String> component1() {
        return this.filePath;
    }

    public final String component2() {
        return this.description;
    }

    public final boolean component3() {
        return this.needReportVoc;
    }

    public final boolean component4() {
        return this.launchReportAppWhenNoPermission;
    }

    public final boolean component5() {
        return this.needShowToast;
    }

    public final FeedbackBean copy(ArrayList<String> r7, String r8, boolean r9, boolean r10, boolean r11) {
        o.e(r8, "description");
        return new FeedbackBean(r7, r8, r9, r10, r11);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, FeedbackBean.class) == true) goto L8;
        return false;
    L8:
        FeedbackBean r6 = (FeedbackBean) ZeusTransformUtils.preCheckCast(r5, FeedbackBean.class, "com.obric.aiagent.plugin");
        if (o.a(this.filePath, r6.filePath) == true) goto L12;
        return false;
    L12:
        if (o.a(this.description, r6.description) == true) goto L15;
        return false;
    L15:
        if (this.needReportVoc == r6.needReportVoc) goto L18;
        return false;
    L18:
        if (this.launchReportAppWhenNoPermission == r6.launchReportAppWhenNoPermission) goto L21;
        return false;
    L21:
        if (this.needShowToast == r6.needShowToast) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        ArrayList<String> r0 = this.filePath;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((((((r1 * 31) + this.description.hashCode()) * 31) + Boolean.hashCode(this.needReportVoc)) * 31) + Boolean.hashCode(this.launchReportAppWhenNoPermission)) * 31) + Boolean.hashCode(this.needShowToast);
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "FeedbackBean(filePath=" + this.filePath + ", description=" + this.description + ", needReportVoc=" + this.needReportVoc + ", launchReportAppWhenNoPermission=" + this.launchReportAppWhenNoPermission + ", needShowToast=" + this.needShowToast + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "dest");
        r3.writeStringList((List) ZeusTransformUtils.preCheckCast(this.filePath, List.class, "com.obric.aiagent.plugin"));
        r3.writeString(this.description);
        r3.writeInt(this.needReportVoc ? 1 : 0);
        r3.writeInt(this.launchReportAppWhenNoPermission ? 1 : 0);
        r3.writeInt(this.needShowToast ? 1 : 0);
    }

    public FeedbackBean(ArrayList<String> r2, String r3, boolean r4, boolean r5, boolean r6) {
        o.e(r3, "description");
        this.filePath = r2;
        this.description = r3;
        this.needReportVoc = r4;
        this.launchReportAppWhenNoPermission = r5;
        this.needShowToast = r6;
    }

    public /* synthetic */ FeedbackBean(ArrayList r8, String r9, boolean r10, boolean r11, boolean r12, int r13, h r14) {
        if ((r13 & 8) == 0) goto L5;
        boolean r5 = false;
    L7:
        if ((r13 & 16) == 0) goto L9;
        boolean r6 = false;
    L10:
        this(r8, r9, r10, r5, r6);
        return;
    L9:
        r6 = r12;
        goto L10
    L5:
        r5 = r11;
        goto L7
    }

    public final ArrayList<String> getFilePath() {
        return this.filePath;
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean getNeedReportVoc() {
        return this.needReportVoc;
    }

    public final boolean getLaunchReportAppWhenNoPermission() {
        return this.launchReportAppWhenNoPermission;
    }

    public final boolean getNeedShowToast() {
        return this.needShowToast;
    }
}
