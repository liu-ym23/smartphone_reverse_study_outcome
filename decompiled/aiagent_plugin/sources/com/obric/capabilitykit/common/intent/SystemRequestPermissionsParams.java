package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;

/* JADX INFO: compiled from: SystemRequestPermissionsParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SystemRequestPermissionsParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<SystemRequestPermissionsParams> CREATOR = null;
    private String content;
    private Options[] options;
    private Permission[] permissions;
    private String title;

    /* JADX INFO: compiled from: SystemRequestPermissionsParams.kt */
    public static final class Creator implements Parcelable.Creator<SystemRequestPermissionsParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemRequestPermissionsParams createFromParcel(Parcel r12) {
            int r0 = r12.readInt();
            o.e(r12, "parcel");
            String r1 = r12.readString();
            String r2 = r12.readString();
            Permission[] r5 = null;
            if (r12.readInt() != 0) goto L5;
            Options[] r7 = null;
        L9:
            if (r12.readInt() == 0) goto L14;
            int r3 = r12.readInt();
            r5 = new Permission[r3];
            int r8 = 0;
        L12:
            if (r8 == r3) goto L14;
            r5[r8] = (Permission) ZeusTransformUtils.preCheckCast(Permission.CREATOR.createFromParcel(r12), Permission.class, "com.obric.aiagent.plugin");
            r8 = r8 + 1;
        L14:
            SystemRequestPermissionsParams r4 = new SystemRequestPermissionsParams(r1, r2, r7, r5);
            int r6 = Math.min(r0, 0);
            ClassLoader r11 = getClass().getClassLoader();
            int r9 = 1;
        L15:
            if (r9 > r6) goto L17;
            r9 = r9 + 1;
        L17:
            if (r9 > r0) goto L19;
            a.a(r12, r11);
            r9 = r9 + 1;
            goto L17
        L19:
            return r4;
        L5:
            int r10 = r12.readInt();
            r7 = new Options[r10];
            int r13 = 0;
        L6:
            if (r13 == r10) goto L9;
            r7[r13] = (Options) ZeusTransformUtils.preCheckCast(Options.CREATOR.createFromParcel(r12), Options.class, "com.obric.aiagent.plugin");
            r13 = r13 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemRequestPermissionsParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemRequestPermissionsParams[] newArray(int r1) {
            return new SystemRequestPermissionsParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemRequestPermissionsParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public SystemRequestPermissionsParams() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SystemRequestPermissionsParams copy$default(SystemRequestPermissionsParams r0, String r1, String r2, Options[] r3, Permission[] r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.title;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.content;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.options;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.permissions;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.content;
    }

    public final Options[] component3() {
        return this.options;
    }

    public final Permission[] component4() {
        return this.permissions;
    }

    public final SystemRequestPermissionsParams copy(String r1, String r2, Options[] r3, Permission[] r4) {
        return new SystemRequestPermissionsParams(r1, r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SystemRequestPermissionsParams.class) == true) goto L8;
        return false;
    L8:
        SystemRequestPermissionsParams r6 = (SystemRequestPermissionsParams) ZeusTransformUtils.preCheckCast(r5, SystemRequestPermissionsParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.title, r6.title) == true) goto L12;
        return false;
    L12:
        if (o.a(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (o.a(this.options, r6.options) == true) goto L18;
        return false;
    L18:
        if (o.a(this.permissions, r6.permissions) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.title;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.content;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Options[] r7 = this.options;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Permission[] r10 = this.permissions;
        if (r10 == null) goto L19;
        r1 = Arrays.hashCode(r10);
    L19:
        return r9 + r1;
    L13:
        r8 = Arrays.hashCode(r7);
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SystemRequestPermissionsParams(title=" + this.title + ", content=" + this.content + ", options=" + Arrays.toString(this.options) + ", permissions=" + Arrays.toString(this.permissions) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r7, int r8) {
        int r0 = 0;
        r7.writeInt(0);
        o.e(r7, "out");
        r7.writeString(this.title);
        r7.writeString(this.content);
        Options[] r1 = this.options;
        if (r1 != null) goto L5;
        r7.writeInt(0);
    L8:
        Permission[] r6 = this.permissions;
        if (r6 != null) goto L11;
        r7.writeInt(0);
        return;
    L11:
        r7.writeInt(1);
        int r2 = r6.length;
        r7.writeInt(r2);
    L12:
        if (r0 == r2) goto L17;
        r6[r0].writeToParcel(r7, r8);
        r0 = r0 + 1;
        goto L12
    L17:
        return;
    L5:
        r7.writeInt(1);
        int r3 = r1.length;
        r7.writeInt(r3);
        int r4 = 0;
    L6:
        if (r4 == r3) goto L8;
        r1[r4].writeToParcel(r7, r8);
        r4 = r4 + 1;
        goto L6
    }

    public SystemRequestPermissionsParams(String r1, String r2, Options[] r3, Permission[] r4) {
        this.title = r1;
        this.content = r2;
        this.options = r3;
        this.permissions = r4;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ SystemRequestPermissionsParams(String r2, String r3, Options[] r4, Permission[] r5, int r6, h r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String r1) {
        this.content = r1;
    }

    public final Options[] getOptions() {
        return this.options;
    }

    public final void setOptions(Options[] r1) {
        this.options = r1;
    }

    public final Permission[] getPermissions() {
        return this.permissions;
    }

    public final void setPermissions(Permission[] r1) {
        this.permissions = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, SystemRequestPermissionsParams.class) == false) goto L5;
        String r1 = this.title;
        if (r1 != null) goto L9;
        r1 = ((SystemRequestPermissionsParams) ZeusTransformUtils.preCheckCast(r6, SystemRequestPermissionsParams.class, "com.obric.aiagent.plugin")).title;
    L9:
        String r3 = this.content;
        if (r3 != null) goto L12;
        r3 = ((SystemRequestPermissionsParams) ZeusTransformUtils.preCheckCast(r6, SystemRequestPermissionsParams.class, "com.obric.aiagent.plugin")).content;
    L12:
        Options[] r4 = this.options;
        if (r4 != null) goto L15;
        r4 = ((SystemRequestPermissionsParams) ZeusTransformUtils.preCheckCast(r6, SystemRequestPermissionsParams.class, "com.obric.aiagent.plugin")).options;
    L15:
        Permission[] r5 = this.permissions;
        if (r5 != null) goto L19;
        r5 = ((SystemRequestPermissionsParams) ZeusTransformUtils.preCheckCast(r6, SystemRequestPermissionsParams.class, "com.obric.aiagent.plugin")).permissions;
    L19:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new SystemRequestPermissionsParams(r1, r3, r4, r5), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
