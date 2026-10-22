package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.a.b;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.l.j;
import d.m;
import d.s;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class AlarmEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 4;
    private static final int RELATED_VERSION = 0;
    private boolean closeInHoliday;
    private String date;
    private boolean isEnabled;
    private Boolean isRinging;
    private String name;
    private List<Integer> repeatDayOfWeek;
    private String repeatDayOfWeekDesc;
    private Integer repeatType;
    private String repeatTypeDesc;
    private String startTime;

    public static final class CREATOR implements Parcelable.Creator<AlarmEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlarmEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.AlarmEntity");
            return (AlarmEntity) ZeusTransformUtils.preCheckCast(r1, AlarmEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AlarmEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 4;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlarmEntity[] newArray(int r1) {
            return new AlarmEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AlarmEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    public static final class a extends p implements b<Integer, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map<Integer, String> f32089a;

        public a(Map<Integer, String> r3) {
            this.f32089a = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            super(1);
        }

        public final CharSequence a(int r2) {
            String r1 = (String) ZeusTransformUtils.preCheckCast(this.f32089a.get(Integer.valueOf(r2)), String.class, "com.obric.aiagent.plugin");
            if (r1 != null) goto L7;
            return "";
        L7:
            return r1;
        }

        @Override // d.h.a.b
        public /* synthetic */ CharSequence invoke(Integer r3) {
            return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue());
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public AlarmEntity(Parcel r10) {
        o.e(r10, "parcel");
        this(EntityExtKt.a(r10), r10.readLong(), r10.readLong(), EntityExtKt.a(r10), EntityExtKt.a(r10));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r10);
        int r0 = r10.readInt();
        this.isEnabled = EntityExtKt.b(r10);
        ArrayList r1 = new ArrayList();
        r10.readList(r1, Integer.TYPE.getClassLoader());
        setRepeatDayOfWeek(r1);
        this.closeInHoliday = EntityExtKt.b(r10);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r10, 4, r0);
    }

    public AlarmEntity(String r9, long r10, long r12, String r14, String r15) {
        o.e(r9, DbHelper.COL_ID);
        o.e(r14, "name");
        o.e(r15, "startTime");
        super(r9, r10, r12, EntityType.ALARM);
        this.name = r14;
        this.startTime = r15;
    }

    public /* synthetic */ AlarmEntity(String r10, long r11, long r13, String r15, String r16, int r17, h r18) {
        if ((r17 & 16) == 0) goto L5;
        String r8 = "";
    L6:
        this(r10, r11, r13, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }

    private final String generateRepeatDesc(List<Integer> r11) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return null;
    L12:
        Map r12 = ao.a(new m[]{s.a(1, "周一"), s.a(2, "周二"), s.a(3, "周三"), s.a(4, "周四"), s.a(5, "周五"), s.a(6, "周六"), s.a(7, "周日")});
        if (r10.containsAll(d.a.p.o(new j(1, 7))) == false) goto L16;
        return "每天";
    L16:
        return 27599 + d.a.p.a(d.a.p.m(r10), "", null, null, 0, null, new a(r12), 30, null);
    L5:
        if (r10.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    private final String generateRepeatTypeDesc(Integer r1) {
        if (r1 == null) goto L16;
        int r0 = r1.intValue();
        if (r0 != 0) goto L6;
        return "不重复";
    L6:
        if (r0 != 1) goto L8;
        return "每天";
    L8:
        if (r0 != 2) goto L10;
        return "法定工作日";
    L10:
        if (r0 != 3) goto L16;
        return "法定节假日及周末";
    L16:
        return null;
    }

    public final boolean getCloseInHoliday() {
        return this.closeInHoliday;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getName() {
        return this.name;
    }

    public final List<Integer> getRepeatDayOfWeek() {
        return this.repeatDayOfWeek;
    }

    public final Integer getRepeatType() {
        return this.repeatType;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final Boolean isRinging() {
        return this.isRinging;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r3, ClassLoader r4, int r5) {
        o.e(r3, "parcel");
        if (r5 != 1) goto L5;
        this.date = (String) ZeusTransformUtils.preCheckCast(r3.readValue(r4), String.class, "com.obric.aiagent.plugin");
        return;
    L5:
        if (r5 != 2) goto L7;
        this.isRinging = (Boolean) ZeusTransformUtils.preCheckCast(r3.readValue(r4), Boolean.class, "com.obric.aiagent.plugin");
        return;
    L7:
        if (r5 != 3) goto L9;
        setRepeatType((Integer) ZeusTransformUtils.preCheckCast(r3.readValue(r4), Integer.class, "com.obric.aiagent.plugin"));
        return;
    L9:
        if (r5 != 4) goto L19;
        this.repeatTypeDesc = (String) ZeusTransformUtils.preCheckCast(r3.readValue(r4), String.class, "com.obric.aiagent.plugin");
        return;
    }

    public final void setCloseInHoliday(boolean r1) {
        this.closeInHoliday = r1;
    }

    public final void setDate(String r1) {
        this.date = r1;
    }

    public final void setEnabled(boolean r1) {
        this.isEnabled = r1;
    }

    public final void setName(String r2) {
        o.e(r2, "<set-?>");
        this.name = r2;
    }

    public final void setRepeatDayOfWeek(List<Integer> r3) {
        List<Integer> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.repeatDayOfWeekDesc = generateRepeatDesc(r4);
        this.repeatDayOfWeek = r4;
    }

    public final void setRepeatType(Integer r2) {
        this.repeatTypeDesc = generateRepeatTypeDesc(r2);
        this.repeatType = r2;
    }

    public final void setRinging(Boolean r1) {
        this.isRinging = r1;
    }

    public final void setStartTime(String r2) {
        o.e(r2, "<set-?>");
        this.startTime = r2;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeString(this.name);
        r1.writeString(this.startTime);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeInt(4);
        EntityExtKt.a(r1, this.isEnabled);
        r1.writeList(this.repeatDayOfWeek);
        EntityExtKt.a(r1, this.closeInHoliday);
        r1.writeValue(this.date);
        r1.writeValue(this.isRinging);
        r1.writeValue(this.repeatType);
        r1.writeValue(this.repeatTypeDesc);
    }
}
