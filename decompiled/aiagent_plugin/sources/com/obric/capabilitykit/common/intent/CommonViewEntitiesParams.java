package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;

/* JADX INFO: compiled from: CommonViewEntitiesParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CommonViewEntitiesParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<CommonViewEntitiesParams> CREATOR = null;
    private AppEntity[] entities;
    private Integer index;

    /* JADX INFO: compiled from: CommonViewEntitiesParams.kt */
    public static final class Creator implements Parcelable.Creator<CommonViewEntitiesParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CommonViewEntitiesParams createFromParcel(Parcel r10) {
            int r0 = r10.readInt();
            o.e(r10, "parcel");
            AppEntity[] r2 = null;
            if (r10.readInt() != 0) goto L5;
            Integer r1 = null;
        L7:
            if (r10.readInt() == 0) goto L13;
            int r3 = r10.readInt();
            AppEntity[] r4 = new AppEntity[r3];
            int r5 = 0;
        L10:
            if (r5 == r3) goto L12;
            r4[r5] = (AppEntity) ZeusTransformUtils.preCheckCast(r10.readParcelable(CommonViewEntitiesParams.class.getClassLoader()), AppEntity.class, "com.obric.aiagent.plugin");
            r5 = r5 + 1;
            goto L10
        L12:
            r2 = r4;
        L13:
            CommonViewEntitiesParams r6 = new CommonViewEntitiesParams(r1, r2);
            int r7 = Math.min(r0, 0);
            ClassLoader r9 = getClass().getClassLoader();
            int r8 = 1;
        L14:
            if (r8 > r7) goto L16;
            r8 = r8 + 1;
        L16:
            if (r8 > r0) goto L18;
            a.a(r10, r9);
            r8 = r8 + 1;
            goto L16
        L18:
            return r6;
        L5:
            r1 = Integer.valueOf(r10.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CommonViewEntitiesParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CommonViewEntitiesParams[] newArray(int r1) {
            return new CommonViewEntitiesParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CommonViewEntitiesParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommonViewEntitiesParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CommonViewEntitiesParams copy$default(CommonViewEntitiesParams r0, Integer r1, AppEntity[] r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.index;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.entities;
    L9:
        return r0.copy(r1, r2);
    }

    public final Integer component1() {
        return this.index;
    }

    public final AppEntity[] component2() {
        return this.entities;
    }

    public final CommonViewEntitiesParams copy(Integer r1, AppEntity[] r2) {
        return new CommonViewEntitiesParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CommonViewEntitiesParams.class) == true) goto L8;
        return false;
    L8:
        CommonViewEntitiesParams r6 = (CommonViewEntitiesParams) ZeusTransformUtils.preCheckCast(r5, CommonViewEntitiesParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.index, r6.index) == true) goto L12;
        return false;
    L12:
        if (o.a(this.entities, r6.entities) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.index;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        AppEntity[] r4 = this.entities;
        if (r4 == null) goto L11;
        r1 = Arrays.hashCode(r4);
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CommonViewEntitiesParams(index=" + this.index + ", entities=" + Arrays.toString(this.entities) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r6, int r7) {
        int r0 = 0;
        r6.writeInt(0);
        o.e(r6, "out");
        Integer r1 = this.index;
        if (r1 != null) goto L5;
        r6.writeInt(0);
    L6:
        AppEntity[] r5 = this.entities;
        if (r5 != null) goto L9;
        r6.writeInt(0);
        return;
    L9:
        r6.writeInt(1);
        int r2 = r5.length;
        r6.writeInt(r2);
    L10:
        if (r0 == r2) goto L14;
        r6.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r5[r0], Parcelable.class, "com.obric.aiagent.plugin"), r7);
        r0 = r0 + 1;
        goto L10
    L14:
        return;
    L5:
        r6.writeInt(1);
        r6.writeInt(r1.intValue());
        goto L6
    }

    public CommonViewEntitiesParams(Integer r1, AppEntity[] r2) {
        this.index = r1;
        this.entities = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ CommonViewEntitiesParams(Integer r2, AppEntity[] r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final Integer getIndex() {
        return this.index;
    }

    public final void setIndex(Integer r1) {
        this.index = r1;
    }

    public final AppEntity[] getEntities() {
        return this.entities;
    }

    public final void setEntities(AppEntity[] r1) {
        this.entities = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, CommonViewEntitiesParams.class) == false) goto L5;
        Integer r1 = this.index;
        if (r1 != null) goto L9;
        r1 = ((CommonViewEntitiesParams) ZeusTransformUtils.preCheckCast(r4, CommonViewEntitiesParams.class, "com.obric.aiagent.plugin")).index;
    L9:
        AppEntity[] r3 = this.entities;
        if (r3 != null) goto L13;
        r3 = ((CommonViewEntitiesParams) ZeusTransformUtils.preCheckCast(r4, CommonViewEntitiesParams.class, "com.obric.aiagent.plugin")).entities;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new CommonViewEntitiesParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
