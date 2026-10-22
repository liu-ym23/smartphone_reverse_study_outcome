package com.uxsense.ruleTrigger.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.appfunctions.metadata.a;
import com.uxsense.core.model.ViewTrigger;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class TriggerCondition implements Parcelable {
    public static final Parcelable.Creator<TriggerCondition> CREATOR = new Parcelable.Creator<TriggerCondition>() { // from class: com.uxsense.ruleTrigger.model.TriggerCondition.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TriggerCondition createFromParcel(Parcel parcel) {
            return new TriggerCondition(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TriggerCondition[] newArray(int i) {
            return new TriggerCondition[i];
        }
    };
    private int[] activityTriggers;
    private long cooldownMillis;
    private long delayMillis;
    private int maxTriggerCount;
    private int mode;
    private boolean triggerOnce;
    private int[] viewTriggers;

    public TriggerCondition() {
        this.activityTriggers = new int[0];
        this.viewTriggers = new int[0];
        this.mode = 0;
        this.delayMillis = 0L;
        this.cooldownMillis = 0L;
        this.maxTriggerCount = 0;
        this.triggerOnce = false;
    }

    public boolean containsActivityTrigger(int i) {
        for (int i6 : this.activityTriggers) {
            if (i6 == i || i6 == 999) {
                return true;
            }
        }
        return false;
    }

    public boolean containsViewTrigger(ViewTrigger viewTrigger) {
        for (int i : this.viewTriggers) {
            if (i == viewTrigger.ordinal() || i == ViewTrigger.ANY.ordinal()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int[] getActivityTriggers() {
        return this.activityTriggers;
    }

    public long getCooldownMillis() {
        return this.cooldownMillis;
    }

    public long getDelayMillis() {
        return this.delayMillis;
    }

    public int getMaxTriggerCount() {
        return this.maxTriggerCount;
    }

    public int getMode() {
        return this.mode;
    }

    public int[] getViewTriggers() {
        return this.viewTriggers;
    }

    public boolean hasActivityTriggers() {
        int[] iArr = this.activityTriggers;
        return iArr != null && iArr.length > 0;
    }

    public boolean hasViewTriggers() {
        int[] iArr = this.viewTriggers;
        return iArr != null && iArr.length > 0;
    }

    public boolean isTriggerOnce() {
        return this.triggerOnce;
    }

    public void setActivityTriggers(int[] iArr) {
        if (iArr == null) {
            iArr = new int[0];
        }
        this.activityTriggers = iArr;
    }

    public void setCooldownMillis(long j5) {
        this.cooldownMillis = j5;
    }

    public void setDelayMillis(long j5) {
        this.delayMillis = j5;
    }

    public void setMaxTriggerCount(int i) {
        this.maxTriggerCount = i;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public void setTriggerOnce(boolean z10) {
        this.triggerOnce = z10;
    }

    public void setViewTriggers(int[] iArr) {
        if (iArr == null) {
            iArr = new int[0];
        }
        this.viewTriggers = iArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TriggerCondition{activityTriggers=");
        sb.append(Arrays.toString(this.activityTriggers));
        sb.append(", viewTriggers=");
        sb.append(Arrays.toString(this.viewTriggers));
        sb.append(", mode=");
        sb.append(TriggerMode.getName(this.mode));
        sb.append(", delayMillis=");
        sb.append(this.delayMillis);
        sb.append(", cooldownMillis=");
        sb.append(this.cooldownMillis);
        sb.append(", maxTriggerCount=");
        sb.append(this.maxTriggerCount);
        sb.append(", triggerOnce=");
        return a.r(sb, this.triggerOnce, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeIntArray(this.activityTriggers);
        parcel.writeIntArray(this.viewTriggers);
        parcel.writeInt(this.mode);
        parcel.writeLong(this.delayMillis);
        parcel.writeLong(this.cooldownMillis);
        parcel.writeInt(this.maxTriggerCount);
        parcel.writeByte(this.triggerOnce ? (byte) 1 : (byte) 0);
    }

    public TriggerCondition(int[] iArr, int[] iArr2, int i, long j5, long j6, int i6, boolean z10) {
        this.activityTriggers = iArr == null ? new int[0] : iArr;
        this.viewTriggers = iArr2 == null ? new int[0] : iArr2;
        this.mode = i;
        this.delayMillis = j5;
        this.cooldownMillis = j6;
        this.maxTriggerCount = i6;
        this.triggerOnce = z10;
    }

    public TriggerCondition(Parcel parcel) {
        this.activityTriggers = parcel.createIntArray();
        this.viewTriggers = parcel.createIntArray();
        this.mode = parcel.readInt();
        this.delayMillis = parcel.readLong();
        this.cooldownMillis = parcel.readLong();
        this.maxTriggerCount = parcel.readInt();
        this.triggerOnce = parcel.readByte() != 0;
    }
}
