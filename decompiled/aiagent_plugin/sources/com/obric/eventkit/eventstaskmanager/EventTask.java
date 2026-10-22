package com.obric.eventkit.eventstaskmanager;

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

/* JADX INFO: loaded from: classes4.dex */
public class EventTask implements Parcelable {
    public static final Parcelable.Creator<EventTask> CREATOR = null;
    public static final a Companion = null;
    private static final int FIELD_VERSION = 3;
    private Long createTime;
    private Integer enableStatus;
    private Map<String, String> ext;
    private String id;
    private final String name;
    private TaskKnowledge taskKnowledge;
    private int taskMode;
    private Integer taskStatus;
    private String templateId;
    private final int type;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
        CREATOR = new EventTask$Companion$CREATOR$1();
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

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public Integer getEnableStatus() {
        return this.enableStatus;
    }

    public Map<String, String> getExt() {
        return this.ext;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public final TaskKnowledge getTaskKnowledge() {
        return this.taskKnowledge;
    }

    public final int getTaskMode() {
        return this.taskMode;
    }

    public Integer getTaskStatus() {
        return this.taskStatus;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final int getType() {
        return this.type;
    }

    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public final void readExtensionFieldFromParcel$eventstaskkit_release(Parcel r11) {
        o.e(r11, "parcel");
        int r0 = r11.readInt();
        ClassLoader r1 = EventTask.class.getClassLoader();
        if (r0 <= 3) goto L5;
        int r3 = 3;
    L6:
        int r5 = 1;
    L7:
        if (r5 > r3) goto L24;
        if (r5 == 1) goto L22;
        TaskKnowledge r8 = null;
        String r9 = null;
        if (r5 == 2) goto L18;
        if (r5 != 3) goto L23;
        Object r7 = r11.readValue(r1);
        if (ZeusTransformUtils.instanceOf(r7, String.class) == false) goto L17;
        r9 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.aiagent.plugin");
    L17:
        this.templateId = r9;
    L23:
        r5 = r5 + 1;
        goto L7
    L18:
        Object r10 = ParcelUtils.INSTANCE.readValueSafely(r11, r1);
        if (ZeusTransformUtils.instanceOf(r10, TaskKnowledge.class) == false) goto L21;
        r8 = (TaskKnowledge) ZeusTransformUtils.preCheckCast(r10, TaskKnowledge.class, "com.obric.aiagent.plugin");
    L21:
        this.taskKnowledge = r8;
        goto L23
    L22:
        Object r12 = r11.readValue(r1);
        o.a(r12, "null cannot be cast to non-null type kotlin.Int");
        this.taskMode = ((Integer) ZeusTransformUtils.preCheckCast(r12, Integer.class, "com.obric.aiagent.plugin")).intValue();
    L24:
        if (r5 > r0) goto L26;
        ParcelUtils.INSTANCE.skipValueSafely(r11, r1);
        r5 = r5 + 1;
        goto L24
    L26:
        return;
    L5:
        r3 = r0;
        goto L6
    }

    public final void readSubClassExtensionFieldFromParcel$eventstaskkit_release(Parcel r4, int r5) {
        o.e(r4, "parcel");
        int r0 = r4.readInt();
        if (r0 > r5) goto L6;
        r5 = r0;
    L6:
        ClassLoader r1 = EventTask.class.getClassLoader();
        int r2 = 1;
    L7:
        if (r2 > r5) goto L9;
        onReadSubClassExtensionField(r4, r1, r2);
        r2 = r2 + 1;
    L9:
        if (r2 > r0) goto L11;
        ParcelUtils.INSTANCE.skipValueSafely(r4, r1);
        r2 = r2 + 1;
        goto L9
    }

    public void setCreateTime(Long r1) {
        this.createTime = r1;
    }

    public void setEnableStatus(Integer r1) {
        this.enableStatus = r1;
    }

    public void setExt(Map<String, String> r3) {
        this.ext = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public final void setTaskKnowledge(TaskKnowledge r1) {
        this.taskKnowledge = r1;
    }

    public final void setTaskMode(int r1) {
        this.taskMode = r1;
    }

    public void setTaskStatus(Integer r1) {
        this.taskStatus = r1;
    }

    public final void setTemplateId(String r1) {
        this.templateId = r1;
    }

    public final void writeExtensionFieldToParcel$eventstaskkit_release(Parcel r2) {
        o.e(r2, "parcel");
        r2.writeInt(3);
        r2.writeValue(Integer.valueOf(this.taskMode));
        r2.writeValue(this.taskKnowledge);
        r2.writeValue(this.templateId);
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
}
