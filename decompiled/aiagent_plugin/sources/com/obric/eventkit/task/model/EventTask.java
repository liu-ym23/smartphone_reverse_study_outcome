package com.obric.eventkit.task.model;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: EventTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public class EventTask implements Parcelable {
    public static final Parcelable.Creator<EventTask> CREATOR = null;
    public static final a Companion = null;
    private static final int FIELD_VERSION = 4;
    private Long createTime;
    private Integer enableStatus;
    private Map<String, String> ext;
    private String id;
    private final String name;
    private String omniModel;
    private TaskKnowledge taskKnowledge;
    private int taskMode;
    private Integer taskStatus;
    private String templateId;
    private final int type;

    /* JADX INFO: compiled from: EventTask.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public EventTask(int r3, String r4, String r5, Integer r6, Integer r7, Long r8, Map<String, String> r9) {
        Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        this.type = r3;
        this.id = r4;
        this.name = r5;
        this.taskStatus = r6;
        this.enableStatus = r7;
        this.createTime = r8;
        this.ext = r10;
    }

    public /* synthetic */ EventTask(int r9, String r10, String r11, Integer r12, Integer r13, Long r14, Map r15, int r16, h r17) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.aiagent.plugin");
        if ((r16 & 2) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r16 & 4) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r16 & 8) == 0) goto L13;
        Integer r4 = null;
    L15:
        if ((r16 & 16) == 0) goto L17;
        Integer r5 = null;
    L19:
        if ((r16 & 32) == 0) goto L21;
        Long r6 = null;
    L23:
        if ((r16 & 64) == 0) goto L25;
        r0 = null;
    L25:
        this(r9, r1, r3, r4, r5, r6, r0);
        return;
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final int getType() {
        return this.type;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public String getName() {
        return this.name;
    }

    public Integer getTaskStatus() {
        return this.taskStatus;
    }

    public void setTaskStatus(Integer r1) {
        this.taskStatus = r1;
    }

    public Integer getEnableStatus() {
        return this.enableStatus;
    }

    public void setEnableStatus(Integer r1) {
        this.enableStatus = r1;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Long r1) {
        this.createTime = r1;
    }

    public Map<String, String> getExt() {
        return this.ext;
    }

    public void setExt(Map<String, String> r3) {
        this.ext = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public final int getTaskMode() {
        return this.taskMode;
    }

    public final void setTaskMode(int r1) {
        this.taskMode = r1;
    }

    public final TaskKnowledge getTaskKnowledge() {
        return this.taskKnowledge;
    }

    public final void setTaskKnowledge(TaskKnowledge r1) {
        this.taskKnowledge = r1;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final void setTemplateId(String r1) {
        this.templateId = r1;
    }

    public final String getOmniModel() {
        return this.omniModel;
    }

    public final void setOmniModel(String r1) {
        this.omniModel = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        o.e(r5, "parcel");
        r5.writeInt(this.type);
        r5.writeString(getId());
        r5.writeString(getName());
        Integer r7 = getTaskStatus();
        int r0 = -1;
        if (r7 == null) goto L5;
        int r8 = r7.intValue();
    L6:
        r5.writeInt(r8);
        Integer r9 = getEnableStatus();
        if (r9 == null) goto L9;
        r0 = r9.intValue();
    L9:
        r5.writeInt(r0);
        Long r10 = getCreateTime();
        if (r10 == null) goto L12;
        long r1 = r10.longValue();
    L13:
        r5.writeLong(r1);
        if (Build.VERSION.SDK_INT < 33) goto L16;
        r5.writeMap(getExt());
        return;
    L16:
        Bundle r11 = new Bundle();
        Map<String, String> r4 = getExt();
        if (r4 == null) goto L22;
        Iterator<Map.Entry<String, String>> r12 = r4.entrySet().iterator();
    L20:
        if (r12.hasNext() == false) goto L22;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r11.putString((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin"));
    L22:
        r5.writeBundle(r11);
        return;
    L12:
        r1 = -1;
        goto L13
    L5:
        r8 = -1;
        goto L6
    }

    public final void writeExtensionFieldToParcel$manager_api_release(Parcel r2) {
        o.e(r2, "parcel");
        r2.writeInt(4);
        r2.writeValue(Integer.valueOf(this.taskMode));
        r2.writeValue(this.taskKnowledge);
        r2.writeValue(this.templateId);
        r2.writeValue(this.omniModel);
    }

    public final void readExtensionFieldFromParcel$manager_api_release(Parcel r11) {
        o.e(r11, "parcel");
        int r0 = r11.readInt();
        ClassLoader r1 = EventTask.class.getClassLoader();
        int r3 = Math.min(r0, 4);
        int r5 = 1;
    L3:
        if (r5 > r3) goto L26;
        if (r5 == 1) goto L24;
        TaskKnowledge r8 = null;
        String r9 = null;
        String r10 = null;
        if (r5 != 2) goto L9;
        Object r7 = ParcelUtils.INSTANCE.readValueSafely(r11, r1);
        if (ZeusTransformUtils.instanceOf(r7, TaskKnowledge.class) == false) goto L23;
        r8 = (TaskKnowledge) ZeusTransformUtils.preCheckCast(r7, TaskKnowledge.class, "com.obric.aiagent.plugin");
    L23:
        this.taskKnowledge = r8;
    L25:
        r5 = r5 + 1;
        goto L3
    L9:
        if (r5 == 3) goto L16;
        if (r5 != 4) goto L25;
        Object r12 = ParcelUtils.INSTANCE.readValueSafely(r11, r1);
        if (ZeusTransformUtils.instanceOf(r12, String.class) == false) goto L15;
        r9 = (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.aiagent.plugin");
    L15:
        this.omniModel = r9;
        goto L25
    L16:
        Object r13 = r11.readValue(r1);
        if (ZeusTransformUtils.instanceOf(r13, String.class) == false) goto L19;
        r10 = (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.aiagent.plugin");
    L19:
        this.templateId = r10;
        goto L25
    L24:
        Object r14 = r11.readValue(r1);
        o.a(r14, "null cannot be cast to non-null type kotlin.Int");
        this.taskMode = ((Integer) ZeusTransformUtils.preCheckCast(r14, Integer.class, "com.obric.aiagent.plugin")).intValue();
    L26:
        if (r5 > r0) goto L28;
        ParcelUtils.INSTANCE.skipValueSafely(r11, r1);
        r5 = r5 + 1;
        goto L26
    }

    public final void readSubClassExtensionFieldFromParcel$manager_api_release(Parcel r4, int r5) {
        o.e(r4, "parcel");
        int r0 = r4.readInt();
        int r6 = Math.min(r0, r5);
        ClassLoader r1 = EventTask.class.getClassLoader();
        int r2 = 1;
    L3:
        if (r2 > r6) goto L5;
        onReadSubClassExtensionField(r4, r1, r2);
        r2 = r2 + 1;
    L5:
        if (r2 > r0) goto L7;
        ParcelUtils.INSTANCE.skipValueSafely(r4, r1);
        r2 = r2 + 1;
        goto L5
    }

    static {
        Companion = new a(null);
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new EventTask$Companion$CREATOR$1(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }
}
