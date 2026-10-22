package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AppIntentMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppIntentMessage implements Parcelable {
    public static final Parcelable.Creator<AppIntentMessage> CREATOR = null;
    private final String confirmNlg;
    private final ArrayList<AppEntity> data;
    private final DataSource dataSource;
    private final List<AppIntentCardData> dataV2;
    private final Map<String, String> ext;
    private final boolean isEnable;
    private final boolean isPaused;
    private final boolean needConfirm;
    private final String refuseNlg;
    private final boolean showRecentContact;

    /* JADX INFO: compiled from: AppIntentMessage.kt */
    public static final class Creator implements Parcelable.Creator<AppIntentMessage> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AppIntentMessage createFromParcel(Parcel r15) {
            o.e(r15, "parcel");
            DataSource r3 = (DataSource) ZeusTransformUtils.preCheckCast(DataSource.CREATOR.createFromParcel(r15), DataSource.class, "com.obric.aiagent.plugin");
            int r2 = 0;
            if (r15.readInt() == 0) goto L5;
            boolean r4 = true;
        L7:
            if (r15.readInt() == 0) goto L9;
            boolean r5 = true;
        L10:
            String r6 = r15.readString();
            String r7 = r15.readString();
            if (r15.readInt() == 0) goto L13;
            boolean r8 = true;
        L15:
            if (r15.readInt() == 0) goto L17;
            boolean r9 = true;
        L18:
            LinkedHashMap r0 = null;
            if (r15.readInt() != 0) goto L21;
            ArrayList r10 = null;
        L25:
            if (r15.readInt() != 0) goto L27;
            ArrayList r11 = null;
        L30:
            List r12 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin");
            if (r15.readInt() == 0) goto L37;
            int r14 = r15.readInt();
            r0 = new LinkedHashMap(r14);
        L34:
            if (r2 == r14) goto L37;
            r0.put(r15.readString(), r15.readString());
            r2 = r2 + 1;
        L37:
            return new AppIntentMessage(r3, r4, r5, r6, r7, r8, r9, r10, r12, (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin"));
        L27:
            int r16 = r15.readInt();
            r11 = new ArrayList(r16);
            int r13 = 0;
        L28:
            if (r13 == r16) goto L30;
            r11.add(AppIntentCardData.CREATOR.createFromParcel(r15));
            r13 = r13 + 1;
            goto L28
        L21:
            int r17 = r15.readInt();
            r10 = new ArrayList(r17);
            int r18 = 0;
        L22:
            if (r18 == r17) goto L25;
            r10.add(r15.readParcelable(AppIntentMessage.class.getClassLoader()));
            r18 = r18 + 1;
            goto L22
        L17:
            r9 = false;
            goto L18
        L13:
            r8 = false;
            goto L15
        L9:
            r5 = false;
            goto L10
        L5:
            r4 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppIntentMessage createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AppIntentMessage[] newArray(int r1) {
            return new AppIntentMessage[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppIntentMessage[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppIntentMessage copy$default(AppIntentMessage r13, DataSource r14, boolean r15, boolean r16, String r17, String r18, boolean r19, boolean r20, ArrayList r21, List r22, Map r23, int r24, Object r25) {
        List<AppIntentCardData> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        if ((r24 & 1) == 0) goto L5;
        DataSource r4 = r13.dataSource;
    L7:
        if ((r24 & 2) == 0) goto L9;
        boolean r5 = r13.isEnable;
    L11:
        if ((r24 & 4) == 0) goto L13;
        boolean r6 = r13.needConfirm;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r7 = r13.confirmNlg;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r8 = r13.refuseNlg;
    L23:
        if ((r24 & 32) == 0) goto L25;
        boolean r9 = r13.isPaused;
    L27:
        if ((r24 & 64) == 0) goto L29;
        boolean r10 = r13.showRecentContact;
    L31:
        if ((r24 & 128) == 0) goto L33;
        ArrayList r11 = r13.data;
    L35:
        if ((r24 & 256) == 0) goto L38;
        r2 = r13.dataV2;
    L38:
        if ((r24 & 512) == 0) goto L41;
        r3 = r13.ext;
    L41:
        return r13.copy(r4, r5, r6, r7, r8, r9, r10, r11, r2, r3);
    L33:
        r11 = r21;
        goto L35
    L29:
        r10 = r20;
        goto L31
    L25:
        r9 = r19;
        goto L27
    L21:
        r8 = r18;
        goto L23
    L17:
        r7 = r17;
        goto L19
    L13:
        r6 = r16;
        goto L15
    L9:
        r5 = r15;
        goto L11
    L5:
        r4 = r14;
        goto L7
    }

    public static /* synthetic */ void getData$annotations() {
    }

    public final DataSource component1() {
        return this.dataSource;
    }

    public final Map<String, String> component10() {
        return this.ext;
    }

    public final boolean component2() {
        return this.isEnable;
    }

    public final boolean component3() {
        return this.needConfirm;
    }

    public final String component4() {
        return this.confirmNlg;
    }

    public final String component5() {
        return this.refuseNlg;
    }

    public final boolean component6() {
        return this.isPaused;
    }

    public final boolean component7() {
        return this.showRecentContact;
    }

    public final ArrayList<AppEntity> component8() {
        return this.data;
    }

    public final List<AppIntentCardData> component9() {
        return this.dataV2;
    }

    public final AppIntentMessage copy(DataSource r14, boolean r15, boolean r16, String r17, String r18, boolean r19, boolean r20, ArrayList<AppEntity> r21, List<AppIntentCardData> r22, Map<String, String> r23) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        o.e(r14, "dataSource");
        o.e(r17, "confirmNlg");
        o.e(r18, "refuseNlg");
        return new AppIntentMessage(r14, r15, r16, r17, r18, r19, r20, r21, r11, r12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AppIntentMessage.class) == true) goto L8;
        return false;
    L8:
        AppIntentMessage r6 = (AppIntentMessage) ZeusTransformUtils.preCheckCast(r5, AppIntentMessage.class, "com.obric.aiagent.plugin");
        if (o.a(this.dataSource, r6.dataSource) == true) goto L12;
        return false;
    L12:
        if (this.isEnable == r6.isEnable) goto L15;
        return false;
    L15:
        if (this.needConfirm == r6.needConfirm) goto L18;
        return false;
    L18:
        if (o.a(this.confirmNlg, r6.confirmNlg) == true) goto L21;
        return false;
    L21:
        if (o.a(this.refuseNlg, r6.refuseNlg) == true) goto L24;
        return false;
    L24:
        if (this.isPaused == r6.isPaused) goto L27;
        return false;
    L27:
        if (this.showRecentContact == r6.showRecentContact) goto L30;
        return false;
    L30:
        if (o.a(this.data, r6.data) == true) goto L33;
        return false;
    L33:
        if (o.a(this.dataV2, r6.dataV2) == true) goto L36;
        return false;
    L36:
        if (o.a(this.ext, r6.ext) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((((this.dataSource.hashCode() * 31) + Boolean.hashCode(this.isEnable)) * 31) + Boolean.hashCode(this.needConfirm)) * 31) + this.confirmNlg.hashCode()) * 31) + this.refuseNlg.hashCode()) * 31) + Boolean.hashCode(this.isPaused)) * 31) + Boolean.hashCode(this.showRecentContact)) * 31;
        ArrayList<AppEntity> r1 = this.data;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        List<AppIntentCardData> r5 = this.dataV2;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Map<String, String> r8 = this.ext;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "AppIntentMessage(dataSource=" + this.dataSource + ", isEnable=" + this.isEnable + ", needConfirm=" + this.needConfirm + ", confirmNlg=" + this.confirmNlg + ", refuseNlg=" + this.refuseNlg + ", isPaused=" + this.isPaused + ", showRecentContact=" + this.showRecentContact + ", data=" + this.data + ", dataV2=" + this.dataV2 + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r7, int r8) {
        o.e(r7, "dest");
        this.dataSource.writeToParcel(r7, r8);
        r7.writeInt(this.isEnable ? 1 : 0);
        r7.writeInt(this.needConfirm ? 1 : 0);
        r7.writeString(this.confirmNlg);
        r7.writeString(this.refuseNlg);
        r7.writeInt(this.isPaused ? 1 : 0);
        r7.writeInt(this.showRecentContact ? 1 : 0);
        ArrayList<AppEntity> r0 = this.data;
        if (r0 != null) goto L5;
        r7.writeInt(0);
    L9:
        List<AppIntentCardData> r1 = this.dataV2;
        if (r1 != null) goto L12;
        r7.writeInt(0);
    L16:
        Map<String, String> r6 = this.ext;
        if (r6 != null) goto L19;
        r7.writeInt(0);
        return;
    L19:
        r7.writeInt(1);
        r7.writeInt(r6.size());
        Iterator<Map.Entry<String, String>> r9 = r6.entrySet().iterator();
    L21:
        if (r9.hasNext() == false) goto L27;
        Map.Entry<String, String> r10 = r9.next();
        r7.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r10, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
        r7.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r10, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L21
    L27:
        return;
    L12:
        r7.writeInt(1);
        r7.writeInt(r1.size());
        Iterator<AppIntentCardData> r2 = r1.iterator();
    L14:
        if (r2.hasNext() == false) goto L16;
        ((AppIntentCardData) ZeusTransformUtils.preCheckCast(r2.next(), AppIntentCardData.class, "com.obric.aiagent.plugin")).writeToParcel(r7, r8);
        goto L14
    L5:
        r7.writeInt(1);
        r7.writeInt(r0.size());
        Iterator<AppEntity> r3 = r0.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r7.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r3.next(), Parcelable.class, "com.obric.aiagent.plugin"), r8);
        goto L7
    }

    public AppIntentMessage(DataSource r3, boolean r4, boolean r5, String r6, String r7, boolean r8, boolean r9, ArrayList<AppEntity> r10, List<AppIntentCardData> r11, Map<String, String> r12) {
        List<AppIntentCardData> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, "dataSource");
        o.e(r6, "confirmNlg");
        o.e(r7, "refuseNlg");
        this.dataSource = r3;
        this.isEnable = r4;
        this.needConfirm = r5;
        this.confirmNlg = r6;
        this.refuseNlg = r7;
        this.isPaused = r8;
        this.showRecentContact = r9;
        this.data = r10;
        this.dataV2 = r13;
        this.ext = r14;
    }

    public /* synthetic */ AppIntentMessage(DataSource r13, boolean r14, boolean r15, String r16, String r17, boolean r18, boolean r19, ArrayList r20, List r21, Map r22, int r23, h r24) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.aiagent.plugin");
        if ((r23 & 2) == 0) goto L5;
        boolean r3 = true;
    L6:
        boolean r5 = false;
        if ((r23 & 4) == 0) goto L9;
        boolean r4 = false;
    L10:
        String r7 = "";
        if ((r23 & 8) == 0) goto L13;
        String r6 = "";
    L15:
        if ((r23 & 16) != 0) goto L19;
        r7 = r17;
    L19:
        if ((r23 & 32) == 0) goto L21;
        boolean r8 = false;
    L23:
        if ((r23 & 64) != 0) goto L26;
        r5 = r19;
    L26:
        Map r10 = null;
        if ((r23 & 128) == 0) goto L29;
        ArrayList r9 = null;
    L31:
        if ((r23 & 256) == 0) goto L34;
        r1 = null;
    L34:
        if ((r23 & 512) != 0) goto L37;
        r10 = r2;
    L37:
        this(r13, r3, r4, r6, r7, r8, r5, r9, r1, r10);
        return;
    L29:
        r9 = r20;
        goto L31
    L21:
        r8 = r18;
        goto L23
    L13:
        r6 = r16;
        goto L15
    L9:
        r4 = r15;
        goto L10
    L5:
        r3 = r14;
        goto L6
    }

    public final DataSource getDataSource() {
        return this.dataSource;
    }

    public final boolean isEnable() {
        return this.isEnable;
    }

    public final boolean getNeedConfirm() {
        return this.needConfirm;
    }

    public final String getConfirmNlg() {
        return this.confirmNlg;
    }

    public final String getRefuseNlg() {
        return this.refuseNlg;
    }

    public final boolean isPaused() {
        return this.isPaused;
    }

    public final boolean getShowRecentContact() {
        return this.showRecentContact;
    }

    public final ArrayList<AppEntity> getData() {
        return this.data;
    }

    public final List<AppIntentCardData> getDataV2() {
        return this.dataV2;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }
}
