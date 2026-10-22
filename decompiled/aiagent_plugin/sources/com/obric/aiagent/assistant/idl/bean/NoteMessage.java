package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: NoteMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoteMessage implements Parcelable {
    public static final Parcelable.Creator<NoteMessage> CREATOR = null;
    private final ArrayList<NoteEntity> data;
    private DataSource dataSource;
    private final boolean isEnable;
    private final boolean needConfirm;

    /* JADX INFO: compiled from: NoteMessage.kt */
    public static final class Creator implements Parcelable.Creator<NoteMessage> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NoteMessage createFromParcel(Parcel r7) {
            o.e(r7, "parcel");
            DataSource r6 = (DataSource) ZeusTransformUtils.preCheckCast(DataSource.CREATOR.createFromParcel(r7), DataSource.class, "com.obric.aiagent.plugin");
            boolean r1 = true;
            int r2 = 0;
            if (r7.readInt() == 0) goto L5;
            boolean r0 = true;
        L7:
            if (r7.readInt() != 0) goto L10;
            r1 = false;
        L10:
            int r3 = r7.readInt();
            ArrayList r4 = new ArrayList(r3);
        L11:
            if (r2 == r3) goto L14;
            r4.add(r7.readParcelable(NoteMessage.class.getClassLoader()));
            r2 = r2 + 1;
            goto L11
        L14:
            return new NoteMessage(r6, r0, r1, r4);
        L5:
            r0 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NoteMessage createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NoteMessage[] newArray(int r1) {
            return new NoteMessage[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NoteMessage[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NoteMessage copy$default(NoteMessage r0, DataSource r1, boolean r2, boolean r3, ArrayList r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.dataSource;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.isEnable;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.needConfirm;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.data;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final DataSource component1() {
        return this.dataSource;
    }

    public final boolean component2() {
        return this.isEnable;
    }

    public final boolean component3() {
        return this.needConfirm;
    }

    public final ArrayList<NoteEntity> component4() {
        return this.data;
    }

    public final NoteMessage copy(DataSource r1, boolean r2, boolean r3, ArrayList<NoteEntity> r4) {
        o.e(r1, "dataSource");
        o.e(r4, "data");
        return new NoteMessage(r1, r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, NoteMessage.class) == true) goto L8;
        return false;
    L8:
        NoteMessage r6 = (NoteMessage) ZeusTransformUtils.preCheckCast(r5, NoteMessage.class, "com.obric.aiagent.plugin");
        if (o.a(this.dataSource, r6.dataSource) == true) goto L12;
        return false;
    L12:
        if (this.isEnable == r6.isEnable) goto L15;
        return false;
    L15:
        if (this.needConfirm == r6.needConfirm) goto L18;
        return false;
    L18:
        if (o.a(this.data, r6.data) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.dataSource.hashCode() * 31) + Boolean.hashCode(this.isEnable)) * 31) + Boolean.hashCode(this.needConfirm)) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "NoteMessage(dataSource=" + this.dataSource + ", isEnable=" + this.isEnable + ", needConfirm=" + this.needConfirm + ", data=" + this.data + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        o.e(r4, "dest");
        this.dataSource.writeToParcel(r4, r5);
        r4.writeInt(this.isEnable ? 1 : 0);
        r4.writeInt(this.needConfirm ? 1 : 0);
        ArrayList<NoteEntity> r3 = this.data;
        r4.writeInt(r3.size());
        Iterator<NoteEntity> r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r6.next(), Parcelable.class, "com.obric.aiagent.plugin"), r5);
        goto L4
    }

    public NoteMessage(DataSource r2, boolean r3, boolean r4, ArrayList<NoteEntity> r5) {
        o.e(r2, "dataSource");
        o.e(r5, "data");
        this.dataSource = r2;
        this.isEnable = r3;
        this.needConfirm = r4;
        this.data = r5;
    }

    public final DataSource getDataSource() {
        return this.dataSource;
    }

    public final void setDataSource(DataSource r2) {
        o.e(r2, "<set-?>");
        this.dataSource = r2;
    }

    public final boolean isEnable() {
        return this.isEnable;
    }

    public final boolean getNeedConfirm() {
        return this.needConfirm;
    }

    public final ArrayList<NoteEntity> getData() {
        return this.data;
    }
}
