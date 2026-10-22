package com.obric.eventkit.task.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: ConditionTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ConditionGroup implements Parcelable, Condition {
    public static final Parcelable.Creator<ConditionGroup> CREATOR = null;
    private final ArrayList<Condition> conditions;
    private final String type;

    /* JADX INFO: compiled from: ConditionTask.kt */
    public static final class Creator implements Parcelable.Creator<ConditionGroup> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConditionGroup createFromParcel(Parcel r5) {
            o.e(r5, "parcel");
            String r4 = r5.readString();
            int r0 = r5.readInt();
            ArrayList r1 = new ArrayList(r0);
            int r2 = 0;
        L3:
            if (r2 == r0) goto L6;
            r1.add(r5.readParcelable(ConditionGroup.class.getClassLoader()));
            r2 = r2 + 1;
            goto L3
        L6:
            return new ConditionGroup(r4, r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ConditionGroup createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConditionGroup[] newArray(int r1) {
            return new ConditionGroup[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ConditionGroup[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConditionGroup copy$default(ConditionGroup r0, String r1, ArrayList r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.conditions;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.type;
    }

    public final ArrayList<Condition> component2() {
        return this.conditions;
    }

    public final ConditionGroup copy(String r1, ArrayList<Condition> r2) {
        o.e(r1, "type");
        o.e(r2, "conditions");
        return new ConditionGroup(r1, r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public String toString() {
        return "ConditionGroup(type=" + this.type + ", conditions=" + this.conditions + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        o.e(r4, "dest");
        r4.writeString(this.type);
        ArrayList<Condition> r3 = this.conditions;
        r4.writeInt(r3.size());
        Iterator<Condition> r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r6.next(), Parcelable.class, "com.obric.aiagent.plugin"), r5);
        goto L4
    }

    public ConditionGroup(String r2, ArrayList<Condition> r3) {
        o.e(r2, "type");
        o.e(r3, "conditions");
        this.type = r2;
        this.conditions = r3;
    }

    public final String getType() {
        return this.type;
    }

    public final ArrayList<Condition> getConditions() {
        return this.conditions;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L5;
        return true;
    L5:
        Class<?> r2 = getClass();
        if (r7 == null) goto L8;
        Class<?> r3 = r7.getClass();
    L10:
        if (o.a(r2, r3) == true) goto L12;
        return false;
    L12:
        o.a(r7, "null cannot be cast to non-null type com.obric.eventkit.task.model.ConditionGroup");
        ConditionGroup r4 = (ConditionGroup) ZeusTransformUtils.preCheckCast(r7, ConditionGroup.class, "com.obric.aiagent.plugin");
        if (o.a(this.type, ((ConditionGroup) ZeusTransformUtils.preCheckCast(r7, ConditionGroup.class, "com.obric.aiagent.plugin")).type) == false) goto L20;
        if (this.conditions.size() != ((ConditionGroup) ZeusTransformUtils.preCheckCast(r7, ConditionGroup.class, "com.obric.aiagent.plugin")).conditions.size()) goto L20;
        if (o.a(p.q((Iterable) ZeusTransformUtils.preCheckCast(this.conditions, Iterable.class, "com.obric.aiagent.plugin")), p.q((Iterable) ZeusTransformUtils.preCheckCast(((ConditionGroup) ZeusTransformUtils.preCheckCast(r7, ConditionGroup.class, "com.obric.aiagent.plugin")).conditions, Iterable.class, "com.obric.aiagent.plugin"))) == false) goto L20;
        return true;
    L20:
        return false;
    L8:
        r3 = null;
        goto L10
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + p.q((Iterable) ZeusTransformUtils.preCheckCast(this.conditions, Iterable.class, "com.obric.aiagent.plugin")).hashCode();
    }
}
