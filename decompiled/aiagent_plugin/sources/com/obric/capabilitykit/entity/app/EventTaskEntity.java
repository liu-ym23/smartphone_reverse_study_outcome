package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class EventTaskEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private List<String> conditionList;
    private String conditionString;
    private boolean isDeleted;
    private String periodString;
    private String taskQuery;

    public static final class CREATOR implements Parcelable.Creator<EventTaskEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EventTaskEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.EventTaskEntity");
            return (EventTaskEntity) ZeusTransformUtils.preCheckCast(r1, EventTaskEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EventTaskEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EventTaskEntity[] newArray(int r1) {
            return new EventTaskEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EventTaskEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public EventTaskEntity(Parcel r13) {
        o.e(r13, "parcel");
        String r2 = EntityExtKt.a(r13);
        long r3 = r13.readLong();
        long r5 = r13.readLong();
        String r7 = EntityExtKt.a(r13);
        String r8 = EntityExtKt.a(r13);
        String r9 = EntityExtKt.a(r13);
        boolean r10 = EntityExtKt.b(r13);
        ArrayList<String> r0 = r13.createStringArrayList();
        if (r0 == null) goto L6;
        List r1 = p.o(r0);
        if (r1 == null) goto L6;
    L7:
        this(r2, r3, r5, r7, r8, r9, r10, r1);
        readExtensionFieldFromParcel$capabilitykitcommon_release(r13);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r13, 0, r13.readInt());
        return;
    L6:
        r1 = new ArrayList();
        goto L7
    }

    public EventTaskEntity(String r13, long r14, long r16, String r18, String r19, String r20, boolean r21, List<String> r22) {
        List<String> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        o.e(r13, DbHelper.COL_ID);
        o.e(r18, "conditionString");
        o.e(r19, "taskQuery");
        o.e(r20, "periodString");
        o.e(r11, "conditionList");
        super(r13, r14, r16, EntityType.EVENT_TASK);
        this.conditionString = r18;
        this.taskQuery = r19;
        this.periodString = r20;
        this.isDeleted = r21;
        this.conditionList = r11;
    }

    public final List<String> getConditionList() {
        return this.conditionList;
    }

    public final String getConditionString() {
        return this.conditionString;
    }

    public final String getPeriodString() {
        return this.periodString;
    }

    public final String getTaskQuery() {
        return this.taskQuery;
    }

    public final boolean isDeleted() {
        return this.isDeleted;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public final void setConditionList(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "<set-?>");
        this.conditionList = r4;
    }

    public final void setConditionString(String r2) {
        o.e(r2, "<set-?>");
        this.conditionString = r2;
    }

    public final void setDeleted(boolean r1) {
        this.isDeleted = r1;
    }

    public final void setPeriodString(String r2) {
        o.e(r2, "<set-?>");
        this.periodString = r2;
    }

    public final void setTaskQuery(String r2) {
        o.e(r2, "<set-?>");
        this.taskQuery = r2;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeString(this.conditionString);
        r1.writeString(this.taskQuery);
        r1.writeString(this.periodString);
        EntityExtKt.a(r1, this.isDeleted);
        r1.writeStringList(this.conditionList);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeInt(0);
    }
}
