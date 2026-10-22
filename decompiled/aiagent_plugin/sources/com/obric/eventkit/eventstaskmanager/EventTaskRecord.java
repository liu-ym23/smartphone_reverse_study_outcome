package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public class EventTaskRecord implements Parcelable {
    public static final Parcelable.Creator<EventTaskRecord> CREATOR = null;
    public static final a Companion = null;
    private static final int FIELD_VERSION = 0;
    private final long id;
    private final int result;
    private final String sourceFrom;
    private final String taskId;
    private final long triggerTime;
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
        CREATOR = new EventTaskRecord$Companion$CREATOR$1();
    }

    public EventTaskRecord(int r1, long r2, String r4, long r5, String r7, int r8) {
        this.type = r1;
        this.id = r2;
        this.taskId = r4;
        this.triggerTime = r5;
        this.sourceFrom = r7;
        this.result = r8;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getId() {
        return this.id;
    }

    public int getResult() {
        return this.result;
    }

    public String getSourceFrom() {
        return this.sourceFrom;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public long getTriggerTime() {
        return this.triggerTime;
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
        ClassLoader r0 = EventTaskRecord.class.getClassLoader();
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
        ClassLoader r1 = EventTaskRecord.class.getClassLoader();
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
    public void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "parcel");
        r3.writeInt(this.type);
        r3.writeLong(getId());
        r3.writeString(getTaskId());
        r3.writeLong(getTriggerTime());
        r3.writeString(getSourceFrom());
        r3.writeInt(getResult());
    }
}
