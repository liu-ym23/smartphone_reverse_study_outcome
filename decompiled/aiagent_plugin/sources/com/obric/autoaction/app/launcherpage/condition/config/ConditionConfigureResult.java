package com.obric.autoaction.app.launcherpage.condition.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ConditionConfigureDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ConditionConfigureResult implements Parcelable {
    public static final Parcelable.Creator<ConditionConfigureResult> CREATOR = null;
    private final List<AutoCondition> condition;
    private final String displayText;

    /* JADX INFO: compiled from: ConditionConfigureDialogFragment.kt */
    public static final class Creator implements Parcelable.Creator<ConditionConfigureResult> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConditionConfigureResult createFromParcel(Parcel r5) {
            o.e(r5, "parcel");
            String r4 = r5.readString();
            int r0 = r5.readInt();
            ArrayList r1 = new ArrayList(r0);
            int r2 = 0;
        L3:
            if (r2 == r0) goto L6;
            r1.add(r5.readParcelable(ConditionConfigureResult.class.getClassLoader()));
            r2 = r2 + 1;
            goto L3
        L6:
            return new ConditionConfigureResult(r4, (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"));
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ConditionConfigureResult createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConditionConfigureResult[] newArray(int r1) {
            return new ConditionConfigureResult[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ConditionConfigureResult[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        o.e(r4, "dest");
        r4.writeString(this.displayText);
        List<AutoCondition> r3 = this.condition;
        r4.writeInt(r3.size());
        Iterator<AutoCondition> r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r6.next(), Parcelable.class, "com.obric.aiagent.plugin"), r5);
        goto L4
    }

    public ConditionConfigureResult(String r3, List<? extends AutoCondition> r4) {
        List<AutoCondition> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "displayText");
        o.e(r5, "condition");
        this.displayText = r3;
        this.condition = r5;
    }

    public final String getDisplayText() {
        return this.displayText;
    }

    public final List<AutoCondition> getCondition() {
        return this.condition;
    }
}
