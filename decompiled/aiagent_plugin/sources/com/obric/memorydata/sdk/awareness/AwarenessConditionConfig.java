package com.obric.memorydata.sdk.awareness;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: AwarenessConditionConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AwarenessConditionConfig implements Parcelable {
    public static final Parcelable.Creator<AwarenessConditionConfig> CREATOR = null;
    public static final a Companion = null;
    private final String extraKey;
    private final String matchMode;
    private final ArrayList<AwarenessConditionRule> rules;
    private final String valueType;

    /* JADX INFO: compiled from: AwarenessConditionConfig.kt */
    public static final class Creator implements Parcelable.Creator<AwarenessConditionConfig> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AwarenessConditionConfig createFromParcel(Parcel r6) {
            o.e(r6, "parcel");
            String r5 = r6.readString();
            String r0 = r6.readString();
            int r1 = r6.readInt();
            ArrayList r2 = new ArrayList(r1);
            int r3 = 0;
        L3:
            if (r3 == r1) goto L6;
            r2.add(AwarenessConditionRule.CREATOR.createFromParcel(r6));
            r3 = r3 + 1;
            goto L3
        L6:
            return new AwarenessConditionConfig(r5, r0, r2, r6.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AwarenessConditionConfig createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AwarenessConditionConfig[] newArray(int r1) {
            return new AwarenessConditionConfig[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AwarenessConditionConfig[] newArray(int r1) {
            return newArray(r1);
        }
    }

    /* JADX INFO: compiled from: AwarenessConditionConfig.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final AwarenessConditionConfig a() {
            return new AwarenessConditionConfig(null, null, null, null, 15, null);
        }

        public final AwarenessConditionConfig a(String r3) {
            o.e(r3, "value");
            return a(WsChannelMultiProcessSharedProvider.STRING_TYPE, "eq", r3);
        }

        public final AwarenessConditionConfig b(String r3) {
            o.e(r3, "value");
            return a("string_list", "contains", r3);
        }

        public final AwarenessConditionConfig a(String r2, String r3) {
            o.e(r2, "extraKey");
            o.e(r3, "value");
            return a(a(r3), r2);
        }

        public final AwarenessConditionConfig b(String r2, String r3) {
            o.e(r2, "extraKey");
            o.e(r3, "value");
            return a(b(r3), r2);
        }

        public final AwarenessConditionConfig a(int r3) {
            return a("int", "eq", String.valueOf(r3));
        }

        public final AwarenessConditionConfig a(double r2) {
            return a("double", "gte", String.valueOf(r2));
        }

        public final AwarenessConditionConfig b(double r2) {
            return a("double", "lte", String.valueOf(r2));
        }

        public final AwarenessConditionRule c(String r3, String r4) {
            o.e(r3, "operator");
            o.e(r4, "value");
            return new AwarenessConditionRule(r3, p.d(new String[]{r4}));
        }

        private final AwarenessConditionConfig a(AwarenessConditionConfig r8, String r9) {
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L7;
            return AwarenessConditionConfig.copy$default(r8, null, null, null, r9, 7, null);
        L7:
            throw new IllegalArgumentException("extraKey must not be blank".toString());
        }

        private final AwarenessConditionConfig a(String r9, String r10, String r11) {
            return new AwarenessConditionConfig(r9, "all", p.d(new AwarenessConditionRule[]{c(r10, r11)}), null, 8, null);
        }
    }

    static {
        Companion = new a(null);
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public AwarenessConditionConfig() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AwarenessConditionConfig copy$default(AwarenessConditionConfig r0, String r1, String r2, ArrayList r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.valueType;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.matchMode;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.rules;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.extraKey;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.valueType;
    }

    public final String component2() {
        return this.matchMode;
    }

    public final ArrayList<AwarenessConditionRule> component3() {
        return this.rules;
    }

    public final String component4() {
        return this.extraKey;
    }

    public final AwarenessConditionConfig copy(String r1, String r2, ArrayList<AwarenessConditionRule> r3, String r4) {
        o.e(r2, "matchMode");
        o.e(r3, "rules");
        return new AwarenessConditionConfig(r1, r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AwarenessConditionConfig.class) == true) goto L8;
        return false;
    L8:
        AwarenessConditionConfig r6 = (AwarenessConditionConfig) ZeusTransformUtils.preCheckCast(r5, AwarenessConditionConfig.class, "com.obric.aiagent.plugin");
        if (o.a(this.valueType, r6.valueType) == true) goto L12;
        return false;
    L12:
        if (o.a(this.matchMode, r6.matchMode) == true) goto L15;
        return false;
    L15:
        if (o.a(this.rules, r6.rules) == true) goto L18;
        return false;
    L18:
        if (o.a(this.extraKey, r6.extraKey) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.valueType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((r2 * 31) + this.matchMode.hashCode()) * 31) + this.rules.hashCode()) * 31;
        String r4 = this.extraKey;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AwarenessConditionConfig(valueType=" + this.valueType + ", matchMode=" + this.matchMode + ", rules=" + this.rules + ", extraKey=" + this.extraKey + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        o.e(r5, "dest");
        r5.writeString(this.valueType);
        r5.writeString(this.matchMode);
        ArrayList<AwarenessConditionRule> r0 = this.rules;
        r5.writeInt(r0.size());
        Iterator<AwarenessConditionRule> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((AwarenessConditionRule) ZeusTransformUtils.preCheckCast(r1.next(), AwarenessConditionRule.class, "com.obric.aiagent.plugin")).writeToParcel(r5, r6);
        goto L4
    L6:
        r5.writeString(this.extraKey);
    }

    public AwarenessConditionConfig(String r2, String r3, ArrayList<AwarenessConditionRule> r4, String r5) {
        o.e(r3, "matchMode");
        o.e(r4, "rules");
        this.valueType = r2;
        this.matchMode = r3;
        this.rules = r4;
        this.extraKey = r5;
    }

    public final String getValueType() {
        return this.valueType;
    }

    public final String getMatchMode() {
        return this.matchMode;
    }

    public /* synthetic */ AwarenessConditionConfig(String r2, String r3, ArrayList r4, String r5, int r6, h r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = "all";
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = new ArrayList();
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }

    public final ArrayList<AwarenessConditionRule> getRules() {
        return this.rules;
    }

    public final String getExtraKey() {
        return this.extraKey;
    }

    public final boolean isAlways() {
        return this.rules.isEmpty();
    }
}
