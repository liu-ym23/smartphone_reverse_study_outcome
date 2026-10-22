package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class ConditionGroup implements Parcelable, Condition {
    public static final Parcelable.Creator<ConditionGroup> CREATOR = null;
    private final ArrayList<Condition> conditions;
    private final String type;

    public static final class Creator implements Parcelable.Creator<ConditionGroup> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConditionGroup createFromParcel(Parcel r7) {
            int r6 = r7.readInt();
            o.e(r7, "parcel");
            String r0 = r7.readString();
            int r1 = r7.readInt();
            ArrayList r2 = new ArrayList(r1);
            int r4 = 0;
        L3:
            if (r4 == r1) goto L5;
            r2.add(r7.readParcelable(ConditionGroup.class.getClassLoader()));
            r4 = r4 + 1;
            goto L3
        L5:
            ConditionGroup r3 = new ConditionGroup(r0, r2);
            int r5 = Math.min(r6, 0);
            ClassLoader r8 = Creator.class.getClassLoader();
            int r9 = 1;
        L6:
            if (r9 > r5) goto L8;
            r9 = r9 + 1;
        L8:
            if (r9 > r6) goto L10;
            com.obric.a.a.a(r7, r8);
            r9 = r9 + 1;
            goto L8
        L10:
            return r3;
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
        CREATOR = new Creator();
    }

    public ConditionGroup(String r2, ArrayList<Condition> r3) {
        o.e(r2, "type");
        o.e(r3, "conditions");
        this.type = r2;
        this.conditions = r3;
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
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        if (r5 == null) goto L7;
        Class<?> r2 = r5.getClass();
    L9:
        if (o.a(ConditionGroup.class, r2) == true) goto L11;
        return false;
    L11:
        o.a(r5, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.ConditionGroup");
        ConditionGroup r6 = (ConditionGroup) ZeusTransformUtils.preCheckCast(r5, ConditionGroup.class, "com.obric.aiagent.plugin");
        if (o.a(this.type, r6.type) == false) goto L19;
        if (this.conditions.size() != r6.conditions.size()) goto L19;
        if (o.a(p.q(this.conditions), p.q(r6.conditions)) == false) goto L19;
        return true;
    L19:
        return false;
    L7:
        r2 = null;
        goto L9
    }

    public final ArrayList<Condition> getConditions() {
        return this.conditions;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + p.q(this.conditions).hashCode();
    }

    public String toString() {
        return "ConditionGroup(type=" + this.type + ", conditions=" + this.conditions + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        r4.writeInt(0);
        o.e(r4, "out");
        r4.writeString(this.type);
        ArrayList<Condition> r3 = this.conditions;
        r4.writeInt(r3.size());
        Iterator<Condition> r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r6.next(), Parcelable.class, "com.obric.aiagent.plugin"), r5);
        goto L4
    }
}
