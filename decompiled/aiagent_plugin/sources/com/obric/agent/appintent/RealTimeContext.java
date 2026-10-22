package com.obric.agent.appintent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.meta.MetaValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Intent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RealTimeContext implements Parcelable {
    public static final Parcelable.Creator<RealTimeContext> CREATOR = null;
    public static final a Companion = null;
    private final List<AppEntity> appEntities;
    private final String curTopActivityName;
    private final String curTopAppName;
    private final String curTopAppPackageName;
    private final List<AppEntity> referenceAppEntities;
    private final List<MetaValue> referenceMetaValue;
    private final List<MetaValue> screenMetaValue;

    /* JADX INFO: compiled from: Intent.kt */
    public static final class Creator implements Parcelable.Creator<RealTimeContext> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RealTimeContext createFromParcel(Parcel r12) {
            o.e(r12, "parcel");
            int r11 = r12.readInt();
            ArrayList r0 = new ArrayList(r11);
            int r1 = 0;
            int r2 = 0;
        L3:
            if (r2 == r11) goto L5;
            r0.add(r12.readParcelable(RealTimeContext.class.getClassLoader()));
            r2 = r2 + 1;
            goto L3
        L5:
            List r4 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
            int r13 = r12.readInt();
            ArrayList r3 = new ArrayList(r13);
            int r5 = 0;
        L6:
            if (r5 == r13) goto L8;
            r3.add(r12.readParcelable(RealTimeContext.class.getClassLoader()));
            r5 = r5 + 1;
            goto L6
        L8:
            List r6 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
            int r14 = r12.readInt();
            ArrayList r7 = new ArrayList(r14);
            int r8 = 0;
        L9:
            if (r8 == r14) goto L11;
            r7.add(r12.readParcelable(RealTimeContext.class.getClassLoader()));
            r8 = r8 + 1;
            goto L9
        L11:
            List r9 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
            int r15 = r12.readInt();
            ArrayList r10 = new ArrayList(r15);
        L12:
            if (r1 == r15) goto L15;
            r10.add(r12.readParcelable(RealTimeContext.class.getClassLoader()));
            r1 = r1 + 1;
            goto L12
        L15:
            return new RealTimeContext(r4, r6, r9, (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin"), r12.readString(), r12.readString(), r12.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RealTimeContext createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RealTimeContext[] newArray(int r1) {
            return new RealTimeContext[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RealTimeContext[] newArray(int r1) {
            return newArray(r1);
        }
    }

    /* JADX INFO: compiled from: Intent.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ RealTimeContext copy$default(RealTimeContext r8, List r9, List r10, List r11, List r12, String r13, String r14, String r15, int r16, Object r17) {
        List<MetaValue> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        List<AppEntity> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        List<AppEntity> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        List<MetaValue> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        if ((r16 & 1) == 0) goto L6;
        r1 = r8.screenMetaValue;
    L6:
        if ((r16 & 2) == 0) goto L9;
        r3 = r8.appEntities;
    L9:
        if ((r16 & 4) == 0) goto L12;
        r4 = r8.referenceAppEntities;
    L12:
        if ((r16 & 8) == 0) goto L15;
        r2 = r8.referenceMetaValue;
    L15:
        if ((r16 & 16) == 0) goto L17;
        String r5 = r8.curTopAppPackageName;
    L19:
        if ((r16 & 32) == 0) goto L21;
        String r6 = r8.curTopAppName;
    L23:
        if ((r16 & 64) == 0) goto L25;
        String r7 = r8.curTopActivityName;
    L27:
        return r8.copy(r1, r3, r4, r2, r5, r6, r7);
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    }

    public final List<MetaValue> component1() {
        return this.screenMetaValue;
    }

    public final List<AppEntity> component2() {
        return this.appEntities;
    }

    public final List<AppEntity> component3() {
        return this.referenceAppEntities;
    }

    public final List<MetaValue> component4() {
        return this.referenceMetaValue;
    }

    public final String component5() {
        return this.curTopAppPackageName;
    }

    public final String component6() {
        return this.curTopAppName;
    }

    public final String component7() {
        return this.curTopActivityName;
    }

    public final RealTimeContext copy(List<? extends MetaValue> r11, List<? extends AppEntity> r12, List<? extends AppEntity> r13, List<? extends MetaValue> r14, String r15, String r16, String r17) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "screenMetaValue");
        o.e(r4, "appEntities");
        o.e(r5, "referenceAppEntities");
        o.e(r6, "referenceMetaValue");
        o.e(r15, "curTopAppPackageName");
        o.e(r16, "curTopAppName");
        o.e(r17, "curTopActivityName");
        return new RealTimeContext(r3, r4, r5, r6, r15, r16, r17);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RealTimeContext.class) == true) goto L8;
        return false;
    L8:
        RealTimeContext r6 = (RealTimeContext) ZeusTransformUtils.preCheckCast(r5, RealTimeContext.class, "com.obric.aiagent.plugin");
        if (o.a(this.screenMetaValue, r6.screenMetaValue) == true) goto L12;
        return false;
    L12:
        if (o.a(this.appEntities, r6.appEntities) == true) goto L15;
        return false;
    L15:
        if (o.a(this.referenceAppEntities, r6.referenceAppEntities) == true) goto L18;
        return false;
    L18:
        if (o.a(this.referenceMetaValue, r6.referenceMetaValue) == true) goto L21;
        return false;
    L21:
        if (o.a(this.curTopAppPackageName, r6.curTopAppPackageName) == true) goto L24;
        return false;
    L24:
        if (o.a(this.curTopAppName, r6.curTopAppName) == true) goto L27;
        return false;
    L27:
        if (o.a(this.curTopActivityName, r6.curTopActivityName) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        return (((((((((((this.screenMetaValue.hashCode() * 31) + this.appEntities.hashCode()) * 31) + this.referenceAppEntities.hashCode()) * 31) + this.referenceMetaValue.hashCode()) * 31) + this.curTopAppPackageName.hashCode()) * 31) + this.curTopAppName.hashCode()) * 31) + this.curTopActivityName.hashCode();
    }

    public String toString() {
        return "RealTimeContext(screenMetaValue=" + this.screenMetaValue + ", appEntities=" + this.appEntities + ", referenceAppEntities=" + this.referenceAppEntities + ", referenceMetaValue=" + this.referenceMetaValue + ", curTopAppPackageName=" + this.curTopAppPackageName + ", curTopAppName=" + this.curTopAppName + ", curTopActivityName=" + this.curTopActivityName + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        o.e(r5, "dest");
        List<MetaValue> r0 = this.screenMetaValue;
        r5.writeInt(r0.size());
        Iterator<MetaValue> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r5.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r1.next(), Parcelable.class, "com.obric.aiagent.plugin"), r6);
        goto L4
    L6:
        List<AppEntity> r2 = this.appEntities;
        r5.writeInt(r2.size());
        Iterator<AppEntity> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        r5.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r3.next(), Parcelable.class, "com.obric.aiagent.plugin"), r6);
        goto L8
    L10:
        List<AppEntity> r4 = this.referenceAppEntities;
        r5.writeInt(r4.size());
        Iterator<AppEntity> r7 = r4.iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        r5.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r7.next(), Parcelable.class, "com.obric.aiagent.plugin"), r6);
        goto L12
    L14:
        List<MetaValue> r8 = this.referenceMetaValue;
        r5.writeInt(r8.size());
        Iterator<MetaValue> r9 = r8.iterator();
    L16:
        if (r9.hasNext() == false) goto L18;
        r5.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r9.next(), Parcelable.class, "com.obric.aiagent.plugin"), r6);
        goto L16
    L18:
        r5.writeString(this.curTopAppPackageName);
        r5.writeString(this.curTopAppName);
        r5.writeString(this.curTopActivityName);
    }

    public RealTimeContext(List<? extends MetaValue> r3, List<? extends AppEntity> r4, List<? extends AppEntity> r5, List<? extends MetaValue> r6, String r7, String r8, String r9) {
        List<MetaValue> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List<AppEntity> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List<AppEntity> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        List<MetaValue> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        o.e(r10, "screenMetaValue");
        o.e(r11, "appEntities");
        o.e(r12, "referenceAppEntities");
        o.e(r13, "referenceMetaValue");
        o.e(r7, "curTopAppPackageName");
        o.e(r8, "curTopAppName");
        o.e(r9, "curTopActivityName");
        this.screenMetaValue = r10;
        this.appEntities = r11;
        this.referenceAppEntities = r12;
        this.referenceMetaValue = r13;
        this.curTopAppPackageName = r7;
        this.curTopAppName = r8;
        this.curTopActivityName = r9;
    }

    public final List<MetaValue> getScreenMetaValue() {
        return this.screenMetaValue;
    }

    public final List<AppEntity> getAppEntities() {
        return this.appEntities;
    }

    public final List<AppEntity> getReferenceAppEntities() {
        return this.referenceAppEntities;
    }

    public final List<MetaValue> getReferenceMetaValue() {
        return this.referenceMetaValue;
    }

    public final String getCurTopAppPackageName() {
        return this.curTopAppPackageName;
    }

    public final String getCurTopAppName() {
        return this.curTopAppName;
    }

    public final String getCurTopActivityName() {
        return this.curTopActivityName;
    }
}
