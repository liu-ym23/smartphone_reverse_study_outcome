package com.miui.guardprovider.aidl;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes2.dex */
public class ScanResultInfo implements Parcelable {
    public static final Parcelable.Creator<ScanResultInfo> CREATOR = null;
    public static final long FLAG_FORBIDDEN_INSTALLATION = 1;
    public String checkoutEngine;
    public Bundle extras;
    public long flags;
    public String threatDesc;
    public int threatLevel;
    public String threatName;

    static class a {
        static /* synthetic */ Object a(Parcel r2, Parcelable.Creator r3) {
            return b(r2, (Parcelable.Creator) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.Creator.class, "com.obric.aiagent.plugin"));
        }

        static /* synthetic */ void a(Parcel r2, Parcelable r3, int r4) {
            b(r2, (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin"), r4);
        }

        private static <T> T b(Parcel r2, Parcelable.Creator<T> r3) {
            Parcelable.Creator r4 = (Parcelable.Creator) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.Creator.class, "com.obric.aiagent.plugin");
            if (r2.readInt() != 0) goto L5;
            return null;
        L5:
            return (T) r4.createFromParcel(r2);
        }

        private static <T extends Parcelable> void b(Parcel r2, T r3, int r4) {
            Parcelable r5 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L5;
            r2.writeInt(1);
            r5.writeToParcel(r2, r4);
            return;
        L5:
            r2.writeInt(0);
        }
    }

    public ScanResultInfo() {
        this.flags = 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        int r0 = r4.dataPosition();
        r4.writeInt(0);
        r4.writeInt(this.threatLevel);
        r4.writeString(this.threatName);
        r4.writeString(this.threatDesc);
        r4.writeString(this.checkoutEngine);
        a.a(r4, this.extras, r5);
        r4.writeLong(this.flags);
        int r3 = r4.dataPosition();
        r4.setDataPosition(r0);
        r4.writeInt(r3 - r0);
        r4.setDataPosition(r3);
    }

    public final void readFromParcel(Parcel r8) {
        int r0 = r8.dataPosition();
        int r1 = r8.readInt();
        if (r1 < 4) goto L63;
        if ((r8.dataPosition() - r0) >= r1) goto L8;
        this.threatLevel = r8.readInt();     // Catch: Throwable -> L60
        if ((r8.dataPosition() - r0) >= r1) goto L17;
        this.threatName = r8.readString();     // Catch: Throwable -> L60
        if ((r8.dataPosition() - r0) >= r1) goto L25;
        this.threatDesc = r8.readString();     // Catch: Throwable -> L60
        if ((r8.dataPosition() - r0) >= r1) goto L33;
        this.checkoutEngine = r8.readString();     // Catch: Throwable -> L60
        if ((r8.dataPosition() - r0) >= r1) goto L41;
        this.extras = (Bundle) ZeusTransformUtils.preCheckCast(a.a(r8, Bundle.CREATOR), Bundle.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L60
        if ((r8.dataPosition() - r0) >= r1) goto L49;
        this.flags = r8.readLong();     // Catch: Throwable -> L60
        if (r0 > (Integer.MAX_VALUE - r1)) goto L59;
        r8.setDataPosition(r0 + r1);
        return;
    L59:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L49:
        if (r0 > (Integer.MAX_VALUE - r1)) goto L52;
    L9:
        r8.setDataPosition(r0 + r1);
        return;
    L52:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L41:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L33:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L25:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L17:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L8:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L63:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        if (r0 > (Integer.MAX_VALUE - r1)) goto L67;
        r8.setDataPosition(r0 + r1);
        throw th;
    L67:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    public String toString() {
        StringJoiner r0 = new StringJoiner(", ", "{", "}");
        r0.add("threatLevel: " + this.threatLevel);
        r0.add("threatName: " + Objects.toString(this.threatName));
        r0.add("threatDesc: " + Objects.toString(this.threatDesc));
        r0.add("checkoutEngine: " + Objects.toString(this.checkoutEngine));
        r0.add("extras: " + Objects.toString(this.extras));
        r0.add("flags: " + this.flags);
        return "ScanResultInfo" + r0.toString();
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if (r6 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r6, ScanResultInfo.class) == true) goto L11;
        return false;
    L11:
        ScanResultInfo r7 = (ScanResultInfo) ZeusTransformUtils.preCheckCast(r6, ScanResultInfo.class, "com.obric.aiagent.plugin");
        if (Objects.deepEquals(Integer.valueOf(this.threatLevel), Integer.valueOf(r7.threatLevel)) == true) goto L15;
        return false;
    L15:
        if (Objects.deepEquals(this.threatName, r7.threatName) == true) goto L18;
        return false;
    L18:
        if (Objects.deepEquals(this.threatDesc, r7.threatDesc) == true) goto L21;
        return false;
    L21:
        if (Objects.deepEquals(this.checkoutEngine, r7.checkoutEngine) == true) goto L24;
        return false;
    L24:
        if (Objects.deepEquals(this.extras, r7.extras) == true) goto L27;
        return false;
    L27:
        if (Objects.deepEquals(Long.valueOf(this.flags), Long.valueOf(r7.flags)) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        return Arrays.deepHashCode(Arrays.asList(new Object[]{Integer.valueOf(this.threatLevel), this.threatName, this.threatDesc, this.checkoutEngine, this.extras, Long.valueOf(this.flags)}).toArray());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return describeContents(this.extras) | 0;
    }

    private int describeContents(Object r2) {
        if (r2 != null) goto L6;
        return 0;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, Parcelable.class) == true) goto L8;
        return 0;
    L8:
        return ((Parcelable) ZeusTransformUtils.preCheckCast(r2, Parcelable.class, "com.obric.aiagent.plugin")).describeContents();
    }
}
