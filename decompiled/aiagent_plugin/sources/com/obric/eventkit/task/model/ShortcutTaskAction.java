package com.obric.eventkit.task.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ShortcutTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ShortcutTaskAction implements Parcelable {
    public static final Parcelable.Creator<ShortcutTaskAction> CREATOR = null;
    public static final a Companion = null;
    private final String intent;
    private final IntentParams params;

    /* JADX INFO: compiled from: ShortcutTask.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    public static /* synthetic */ ShortcutTaskAction copy$default(ShortcutTaskAction r1, String r2, IntentParams r3, int r4, Object r5) {
        IntentParams r6 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r3, IntentParams.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.intent;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r6 = r1.params;
    L9:
        return r1.copy(r2, r6);
    }

    public final String component1() {
        return this.intent;
    }

    public final IntentParams component2() {
        return this.params;
    }

    public final ShortcutTaskAction copy(String r2, IntentParams r3) {
        IntentParams r1 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r3, IntentParams.class, "com.obric.aiagent.plugin");
        o.e(r2, MemorySourceLinkType.INTENT);
        return new ShortcutTaskAction(r2, r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ShortcutTaskAction.class) == true) goto L8;
        return false;
    L8:
        ShortcutTaskAction r6 = (ShortcutTaskAction) ZeusTransformUtils.preCheckCast(r5, ShortcutTaskAction.class, "com.obric.aiagent.plugin");
        if (o.a(this.intent, r6.intent) == true) goto L12;
        return false;
    L12:
        if (o.a(this.params, r6.params) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.intent.hashCode() * 31;
        IntentParams r1 = this.params;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ShortcutTaskAction(intent=" + this.intent + ", params=" + this.params + ')';
    }

    public ShortcutTaskAction(String r3, IntentParams r4) {
        IntentParams r5 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r4, IntentParams.class, "com.obric.aiagent.plugin");
        o.e(r3, MemorySourceLinkType.INTENT);
        this.intent = r3;
        this.params = r5;
    }

    public final String getIntent() {
        return this.intent;
    }

    public final IntentParams getParams() {
        return this.params;
    }

    public ShortcutTaskAction(Parcel r4) {
        o.e(r4, "parcel");
        this(b.a(r4), (IntentParams) ZeusTransformUtils.preCheckCast(r4.readParcelable(IntentParams.class.getClassLoader()), IntentParams.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "parcel");
        r3.writeString(this.intent);
        r3.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.params, Parcelable.class, "com.obric.aiagent.plugin"), r4);
    }

    static {
        Companion = new a(null);
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new ShortcutTaskAction$Companion$CREATOR$1(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }
}
