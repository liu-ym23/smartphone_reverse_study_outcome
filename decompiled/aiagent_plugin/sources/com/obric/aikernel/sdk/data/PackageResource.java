package com.obric.aikernel.sdk.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.a.b;
import d.h.b.h;
import d.h.b.o;
import d.o.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PackageResource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PackageResource implements Parcelable {
    public static final CREATOR CREATOR = null;
    private static final int FULL = -1;
    public static final int OWNER_AIKERNEL = 1;
    public static final int OWNER_LOCAL = 0;
    public static final int STATE_FLAG_AVAILABLE = 2;
    public static final int STATE_FLAG_DOWNLOADED = 4;
    public static final int STATE_FLAG_PROVISIONED = 1;
    public static final int STATE_MASK_UPDATED = 5;
    public static final int TYPE_CLOUD_MODEL = 2;
    public static final int TYPE_LORA = 3;
    public static final int TYPE_MODEL = 1;
    public static final int TYPE_PACKAGE = 0;
    private int flag;
    private final String name;
    private final int owner;
    private List<PackageResource> subRes;
    private final int type;
    private String version;

    /* JADX INFO: compiled from: PackageResource.kt */
    public static final class CREATOR implements Parcelable.Creator<PackageResource> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PackageResource createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PackageResource[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PackageResource createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new PackageResource(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PackageResource[] newArray(int r1) {
            return new PackageResource[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    private final boolean isState(int r1, int r2) {
        if ((r1 & r2) != r2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PackageResource(String r2, int r3, int r4, String r5, int r6) {
        o.e(r2, "name");
        o.e(r5, "version");
        this.name = r2;
        this.owner = r3;
        this.type = r4;
        this.version = r5;
        this.flag = r6;
    }

    public /* synthetic */ PackageResource(String r8, int r9, int r10, String r11, int r12, int r13, h r14) {
        if ((r13 & 2) == 0) goto L5;
        int r3 = 0;
    L7:
        if ((r13 & 4) == 0) goto L9;
        int r4 = 0;
    L11:
        if ((r13 & 8) == 0) goto L13;
        r11 = "";
    L13:
        String r5 = r11;
        if ((r13 & 16) == 0) goto L16;
        int r6 = 0;
    L17:
        this(r8, r3, r4, r5, r6);
        return;
    L16:
        r6 = r12;
        goto L17
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    public final String getName() {
        return this.name;
    }

    public final int getOwner() {
        return this.owner;
    }

    public final int getType() {
        return this.type;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String r2) {
        o.e(r2, "<set-?>");
        this.version = r2;
    }

    public final List<PackageResource> getSubRes() {
        return this.subRes;
    }

    public final void setSubRes(List<PackageResource> r3) {
        this.subRes = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public PackageResource(Parcel r9) {
        o.e(r9, "parcel");
        String r0 = r9.readString();
        if (r0 != null) goto L5;
        String r3 = "";
    L6:
        int r4 = r9.readInt();
        int r5 = r9.readInt();
        String r1 = r9.readString();
        if (r1 != null) goto L9;
        String r6 = "";
    L10:
        this(r3, r4, r5, r6, r9.readInt());
        int r2 = r9.readInt();
        if (r2 <= 0) goto L14;
        List<PackageResource> r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(r2), List.class, "com.obric.aiagent.plugin");
        this.subRes = r7;
        o.a(r7);
        r9.readParcelableList(r7, getClass().getClassLoader());
        return;
    L14:
        return;
    L9:
        r6 = r1;
        goto L10
    L5:
        r3 = r0;
        goto L6
    }

    public PackageResource(PackageResource r8) {
        o.e(r8, "src");
        this(r8.name, r8.owner, r8.type, r8.version, r8.flag);
        this.subRes = r8.subRes;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "parcel");
        r2.writeString(this.name);
        r2.writeInt(this.owner);
        r2.writeInt(this.type);
        r2.writeString(this.version);
        r2.writeInt(this.flag);
        List<PackageResource> r4 = this.subRes;
        if (r4 == null) goto L5;
        int r5 = r4.size();
    L6:
        r2.writeInt(r5);
        if (r5 <= 0) goto L10;
        r2.writeParcelableList(this.subRes, 0);
        return;
    L10:
        return;
    L5:
        r5 = 0;
        goto L6
    }

    public final int getFlag() {
        int r0 = this.flag;
        return getSubResFlag() & r0;
    }

    public final int getSelfFlag() {
        return this.flag;
    }

    public final int getSubResFlag() {
        List<PackageResource> r1 = this.subRes;
        if (r1 != null) goto L5;
    L13:
        return -1;
    L5:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L13;
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        List<PackageResource> r4 = this.subRes;
        o.a(r4);
        int r5 = ((PackageResource) ZeusTransformUtils.preCheckCast(p.k(r4), PackageResource.class, "com.obric.aiagent.plugin")).getFlag();
        Iterator r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L16;
        r5 = r5 & ((PackageResource) ZeusTransformUtils.preCheckCast(r3.next(), PackageResource.class, "com.obric.aiagent.plugin")).getFlag();
        goto L11
    L16:
        return r5;
    }

    public final boolean isLoraPackage() {
        if (this.type == 3) goto L18;
        List<PackageResource> r8 = this.subRes;
        Object r1 = null;
        if (r8 == null) goto L16;
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r9.hasNext() == false) goto L15;
        Object r5 = r9.next();
        if (((PackageResource) ZeusTransformUtils.preCheckCast(r5, PackageResource.class, "com.obric.aiagent.plugin")).type != 3) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L8;
        r1 = r5;
        goto L15
    L12:
        r7 = false;
    L15:
        r1 = (PackageResource) ZeusTransformUtils.preCheckCast(r1, PackageResource.class, "com.obric.aiagent.plugin");
    L16:
        if (r1 != null) goto L18;
        return false;
    L18:
        return true;
    }

    public final boolean isProvisioned() {
        return isState(getFlag(), 1);
    }

    public final boolean isAvailable() {
        return isState(getFlag(), 2);
    }

    public final boolean isDownloaded() {
        return isState(getFlag(), 4);
    }

    public final boolean isUpdated() {
        return isState(getFlag(), 5);
    }

    public final boolean isSelfUpdated() {
        return isState(getSelfFlag(), 5);
    }

    public final String formatToString() {
        StringBuilder r0 = new StringBuilder().append("[Package ").append(this.name).append('@').append(this.version).append(' ');
        if (this.owner != 1) goto L5;
        String r2 = "AIKERNEL";
    L6:
        StringBuilder r1 = r0.append(r2).append(' ');
        int r3 = this.type;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L11;
        String r4 = "CLOUD_API";
    L17:
        StringBuilder r5 = r1.append(r4).append(", state is ");
        String r6 = "avail";
        if (isAvailable() == false) goto L20;
        String r7 = "avail";
    L21:
        StringBuilder r8 = r5.append(r7).append(", self is ");
        if (isState(getSelfFlag(), 2) == false) goto L25;
    L31:
        StringBuilder r9 = r8.append(r6).append('.');
        List<PackageResource> r12 = this.subRes;
        if (r12 != null) goto L34;
    L47:
        String r13 = "";
    L49:
        return r9.append(r13).append(']').toString();
    L34:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L37;
        r12 = null;
    L37:
        if (r12 == null) goto L47;
        StringBuilder r10 = new StringBuilder().append("|subResource:(");
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r14, 10)), Collection.class, "com.obric.aiagent.plugin");
        int r15 = 0;
        Iterator r16 = r14.iterator();
    L40:
        if (r16.hasNext() == false) goto L45;
        Object r17 = r16.next();
        int r18 = r15 + 1;
        if (r15 >= 0) goto L44;
        p.c();
    L44:
        r11.add('{' + r15 + ", " + ((PackageResource) ZeusTransformUtils.preCheckCast(r17, PackageResource.class, "com.obric.aiagent.plugin")).formatToString() + '}');
        r15 = r18;
        goto L40
    L45:
        r13 = r10.append(p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, (b) ZeusTransformUtils.preCheckCast(PackageResource$formatToString$2$2.INSTANCE, b.class, "com.obric.aiagent.plugin"), 31, null)).append(')').toString();
        if (r13 != null) goto L49;
    L25:
        if (isState(getSelfFlag(), 4) == false) goto L28;
        r6 = "downloaded";
        goto L31
    L28:
        if (isState(getSelfFlag(), 1) == false) goto L30;
        r6 = "wait download";
        goto L31
    L30:
        r6 = "not found";
        goto L31
    L20:
        r7 = "not avail";
        goto L21
    L11:
        if (r3 == 3) goto L13;
        r4 = "unknown type";
        goto L17
    L13:
        r4 = "LORA";
        goto L17
    L15:
        r4 = "MODEL";
        goto L17
    L16:
        r4 = "PACKAGE";
        goto L17
    L5:
        r2 = "LOCAL";
        goto L6
    }

    public final String simpleToString() {
        StringBuilder r0 = new StringBuilder().append("[Package ").append(this.name).append("|(ver:").append(this.version).append("|own:").append(this.owner).append("|type:").append(this.type).append(")|flag:");
        String r1 = Integer.toString(getSelfFlag(), a.a(2));
        o.c(r1, "toString(this, checkRadix(radix))");
        StringBuilder r2 = r0.append(r1).append("|state:");
        String r3 = Integer.toString(getFlag(), a.a(2));
        o.c(r3, "toString(this, checkRadix(radix))");
        StringBuilder r4 = r2.append(r3);
        List<PackageResource> r12 = this.subRes;
        if (r12 != null) goto L5;
    L18:
        String r13 = "";
    L20:
        return r4.append(r13).append(']').toString();
    L5:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L8;
        r12 = null;
    L8:
        if (r12 == null) goto L18;
        StringBuilder r5 = new StringBuilder().append("|subResource:(");
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r14, 10)), Collection.class, "com.obric.aiagent.plugin");
        int r7 = 0;
        Iterator r15 = r14.iterator();
    L11:
        if (r15.hasNext() == false) goto L16;
        Object r8 = r15.next();
        int r9 = r7 + 1;
        if (r7 >= 0) goto L15;
        p.c();
    L15:
        r6.add('{' + r7 + ", " + ((PackageResource) ZeusTransformUtils.preCheckCast(r8, PackageResource.class, "com.obric.aiagent.plugin")).simpleToString() + '}');
        r7 = r9;
        goto L11
    L16:
        r13 = r5.append(p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, (b) ZeusTransformUtils.preCheckCast(PackageResource$simpleToString$2$2.INSTANCE, b.class, "com.obric.aiagent.plugin"), 31, null)).append(')').toString();
        if (r13 != null) goto L20;
        goto L18
    }

    public final String fullToString() {
        StringBuilder r0 = new StringBuilder().append("______________________________________\nPackage: ").append(this.name).append("\n[ver:").append(this.version).append("|own:").append(this.owner).append("|type:").append(this.type).append("]\n🆔Flag\tstate: [");
        String r1 = Integer.toString(getFlag(), a.a(2));
        o.c(r1, "toString(this, checkRadix(radix))");
        StringBuilder r2 = r0.append(r1).append("] self:[");
        String r3 = Integer.toString(getSelfFlag(), a.a(2));
        o.c(r3, "toString(this, checkRadix(radix))");
        StringBuilder r4 = r2.append(r3).append("]\nflagFormat:[downloaded|available|provisioned]\n");
        List<PackageResource> r5 = this.subRes;
        if (r5 != null) goto L5;
    L18:
        String r13 = "";
    L20:
        return r4.append(r13).append("______________________________________\n").toString();
    L5:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L8;
        r5 = null;
    L8:
        if (r5 == null) goto L18;
        StringBuilder r6 = new StringBuilder().append("🆔SubResource\t sum:").append(r5.size()).append(":\n");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r7, 10)), Collection.class, "com.obric.aiagent.plugin");
        int r9 = 0;
        Iterator r10 = r7.iterator();
    L11:
        if (r10.hasNext() == false) goto L16;
        Object r11 = r10.next();
        int r12 = r9 + 1;
        if (r9 >= 0) goto L15;
        p.c();
    L15:
        r8.add("++sub " + r9 + " of " + this.name + '\n' + ((PackageResource) ZeusTransformUtils.preCheckCast(r11, PackageResource.class, "com.obric.aiagent.plugin")));
        r9 = r12;
        goto L11
    L16:
        r13 = r6.append(p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, (b) ZeusTransformUtils.preCheckCast(PackageResource$fullToString$2$2.INSTANCE, b.class, "com.obric.aiagent.plugin"), 31, null)).toString();
        if (r13 != null) goto L20;
        goto L18
    }

    public String toString() {
        return formatToString();
    }

    public final void addFlagArray(int[] r5) {
        o.e(r5, "flags");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.flag = r5[r1] | this.flag;
        r1 = r1 + 1;
        goto L3
    }

    public final void addFlag(int... r5) {
        o.e(r5, "flags");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.flag = r5[r1] | this.flag;
        r1 = r1 + 1;
        goto L3
    }

    public final void removeFlag(int... r5) {
        o.e(r5, "flags");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int r2 = r5[r1];
        int r3 = this.flag;
        this.flag = (~r2) & r3;
        r1 = r1 + 1;
        goto L3
    }
}
