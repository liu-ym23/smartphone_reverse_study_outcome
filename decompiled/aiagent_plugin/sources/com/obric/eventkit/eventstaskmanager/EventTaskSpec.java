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
public class EventTaskSpec implements Parcelable {
    public static final Parcelable.Creator<EventTaskSpec> CREATOR = null;
    public static final a Companion = null;
    private static final int FIELD_VERSION = 0;
    private final Integer enableStatus;
    private final Map<String, String> ext;
    private final String name;
    private final TaskKnowledge taskKnowledge;
    private final Integer taskMode;
    private final Integer taskStatus;
    private final String templateId;
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
        CREATOR = new EventTaskSpec$Companion$CREATOR$1();
    }

    public EventTaskSpec(int r3, String r4, Integer r5, TaskKnowledge r6, String r7, Integer r8, Integer r9, Map<String, String> r10) {
        Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        this.type = r3;
        this.name = r4;
        this.taskMode = r5;
        this.taskKnowledge = r6;
        this.templateId = r7;
        this.taskStatus = r8;
        this.enableStatus = r9;
        this.ext = r11;
    }

    public /* synthetic */ EventTaskSpec(int r10, String r11, Integer r12, TaskKnowledge r13, String r14, Integer r15, Integer r16, Map r17, int r18, h r19) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.aiagent.plugin");
        if ((r18 & 2) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r18 & 4) == 0) goto L9;
        Integer r4 = null;
    L11:
        if ((r18 & 8) == 0) goto L13;
        TaskKnowledge r5 = null;
    L15:
        if ((r18 & 16) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r18 & 32) == 0) goto L21;
        Integer r7 = null;
    L23:
        if ((r18 & 64) == 0) goto L25;
        Integer r8 = null;
    L27:
        if ((r18 & 128) == 0) goto L29;
        r1 = null;
    L29:
        this(r10, r2, r4, r5, r6, r7, r8, r1);
        return;
    L25:
        r8 = r16;
        goto L27
    L21:
        r7 = r15;
        goto L23
    L17:
        r6 = r14;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Integer getEnableStatus() {
        return this.enableStatus;
    }

    public Map<String, String> getExt() {
        return this.ext;
    }

    public String getName() {
        return this.name;
    }

    public TaskKnowledge getTaskKnowledge() {
        return this.taskKnowledge;
    }

    public Integer getTaskMode() {
        return this.taskMode;
    }

    public Integer getTaskStatus() {
        return this.taskStatus;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public final int getType() {
        return this.type;
    }

    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public final void readExtensionFieldFromParcel$eventstaskkit_release(Parcel r4) {
        o.e(r4, "parcel");
        int r3 = r4.readInt();
        ClassLoader r0 = EventTaskSpec.class.getClassLoader();
        if (r3 <= 0) goto L5;
        int r1 = 0;
    L6:
        int r2 = 1;
    L7:
        if (r2 > r1) goto L9;
        r2 = r2 + 1;
    L9:
        if (r2 > r3) goto L11;
        ParcelUtils.INSTANCE.skipValueSafely(r4, r0);
        r2 = r2 + 1;
        goto L9
    L11:
        return;
    L5:
        r1 = r3;
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

    public final void writeExtensionFieldToParcel$eventstaskkit_release(Parcel r1) {
        o.e(r1, "parcel");
        r1.writeInt(0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        o.e(r5, "parcel");
        r5.writeInt(this.type);
        r5.writeString(getName());
        Integer r0 = getTaskMode();
        int r1 = -1;
        if (r0 == null) goto L5;
        int r2 = r0.intValue();
    L6:
        r5.writeInt(r2);
        r5.writeParcelable(getTaskKnowledge(), r6);
        r5.writeString(getTemplateId());
        Integer r7 = getTaskStatus();
        if (r7 == null) goto L9;
        int r8 = r7.intValue();
    L10:
        r5.writeInt(r8);
        Integer r9 = getEnableStatus();
        if (r9 == null) goto L13;
        r1 = r9.intValue();
    L13:
        r5.writeInt(r1);
        if (Build.VERSION.SDK_INT < 33) goto L16;
        r5.writeMap(getExt());
        return;
    L16:
        Bundle r10 = new Bundle();
        Map<String, String> r4 = getExt();
        if (r4 == null) goto L22;
        Iterator<Map.Entry<String, String>> r11 = r4.entrySet().iterator();
    L20:
        if (r11.hasNext() == false) goto L22;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r10.putString((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r3.getValue(), String.class, "com.obric.aiagent.plugin"));
    L22:
        r5.writeBundle(r10);
        return;
    L9:
        r8 = -1;
        goto L10
    L5:
        r2 = -1;
        goto L6
    }
}
