package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: NetEaseCloudMusicSearchParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NetEaseCloudMusicSearchParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<NetEaseCloudMusicSearchParams> CREATOR = null;
    private Boolean auto_play;
    private Integer count;
    private Integer entity_type;
    private String query;

    /* JADX INFO: compiled from: NetEaseCloudMusicSearchParams.kt */
    public static final class Creator implements Parcelable.Creator<NetEaseCloudMusicSearchParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NetEaseCloudMusicSearchParams createFromParcel(Parcel r10) {
            int r0 = r10.readInt();
            o.e(r10, "parcel");
            String r2 = r10.readString();
            Integer r4 = null;
            if (r10.readInt() != 0) goto L5;
            Integer r3 = null;
        L6:
            int r7 = 1;
            if (r10.readInt() != 0) goto L10;
            Boolean r5 = null;
        L15:
            if (r10.readInt() == 0) goto L18;
            r4 = Integer.valueOf(r10.readInt());
        L18:
            NetEaseCloudMusicSearchParams r1 = new NetEaseCloudMusicSearchParams(r2, r3, r5, r4);
            int r6 = Math.min(r0, 0);
            ClassLoader r9 = getClass().getClassLoader();
        L19:
            if (r7 > r6) goto L21;
            r7 = r7 + 1;
        L21:
            if (r7 > r0) goto L23;
            a.a(r10, r9);
            r7 = r7 + 1;
            goto L21
        L23:
            return r1;
        L10:
            if (r10.readInt() == 0) goto L12;
            boolean r8 = true;
        L13:
            r5 = Boolean.valueOf(r8);
            goto L15
        L12:
            r8 = false;
            goto L13
        L5:
            r3 = Integer.valueOf(r10.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NetEaseCloudMusicSearchParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NetEaseCloudMusicSearchParams[] newArray(int r1) {
            return new NetEaseCloudMusicSearchParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NetEaseCloudMusicSearchParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public NetEaseCloudMusicSearchParams() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ NetEaseCloudMusicSearchParams copy$default(NetEaseCloudMusicSearchParams r0, String r1, Integer r2, Boolean r3, Integer r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.query;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.entity_type;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.auto_play;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.count;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.query;
    }

    public final Integer component2() {
        return this.entity_type;
    }

    public final Boolean component3() {
        return this.auto_play;
    }

    public final Integer component4() {
        return this.count;
    }

    public final NetEaseCloudMusicSearchParams copy(String r1, Integer r2, Boolean r3, Integer r4) {
        return new NetEaseCloudMusicSearchParams(r1, r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, NetEaseCloudMusicSearchParams.class) == true) goto L8;
        return false;
    L8:
        NetEaseCloudMusicSearchParams r6 = (NetEaseCloudMusicSearchParams) ZeusTransformUtils.preCheckCast(r5, NetEaseCloudMusicSearchParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.query, r6.query) == true) goto L12;
        return false;
    L12:
        if (o.a(this.entity_type, r6.entity_type) == true) goto L15;
        return false;
    L15:
        if (o.a(this.auto_play, r6.auto_play) == true) goto L18;
        return false;
    L18:
        if (o.a(this.count, r6.count) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.query;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.entity_type;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.auto_play;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.count;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "NetEaseCloudMusicSearchParams(query=" + this.query + ", entity_type=" + this.entity_type + ", auto_play=" + this.auto_play + ", count=" + this.count + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(0);
        o.e(r3, "out");
        r3.writeString(this.query);
        Integer r0 = this.entity_type;
        if (r0 != null) goto L5;
        r3.writeInt(0);
    L6:
        Boolean r1 = this.auto_play;
        if (r1 != null) goto L9;
        r3.writeInt(0);
    L10:
        Integer r2 = this.count;
        if (r2 != null) goto L13;
        r3.writeInt(0);
        return;
    L13:
        r3.writeInt(1);
        r3.writeInt(r2.intValue());
        return;
    L9:
        r3.writeInt(1);
        r3.writeInt(r1.booleanValue() ? 1 : 0);
        goto L10
    L5:
        r3.writeInt(1);
        r3.writeInt(r0.intValue());
        goto L6
    }

    public NetEaseCloudMusicSearchParams(String r1, Integer r2, Boolean r3, Integer r4) {
        this.query = r1;
        this.entity_type = r2;
        this.auto_play = r3;
        this.count = r4;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ NetEaseCloudMusicSearchParams(String r2, Integer r3, Boolean r4, Integer r5, int r6, h r7) {
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

    public final String getQuery() {
        return this.query;
    }

    public final void setQuery(String r1) {
        this.query = r1;
    }

    public final Integer getEntity_type() {
        return this.entity_type;
    }

    public final void setEntity_type(Integer r1) {
        this.entity_type = r1;
    }

    public final Boolean getAuto_play() {
        return this.auto_play;
    }

    public final void setAuto_play(Boolean r1) {
        this.auto_play = r1;
    }

    public final Integer getCount() {
        return this.count;
    }

    public final void setCount(Integer r1) {
        this.count = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.query == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, NetEaseCloudMusicSearchParams.class) == false) goto L5;
        String r1 = this.query;
        if (r1 != null) goto L9;
        r1 = ((NetEaseCloudMusicSearchParams) ZeusTransformUtils.preCheckCast(r6, NetEaseCloudMusicSearchParams.class, "com.obric.aiagent.plugin")).query;
    L9:
        Integer r3 = this.entity_type;
        if (r3 != null) goto L12;
        r3 = ((NetEaseCloudMusicSearchParams) ZeusTransformUtils.preCheckCast(r6, NetEaseCloudMusicSearchParams.class, "com.obric.aiagent.plugin")).entity_type;
    L12:
        Boolean r4 = this.auto_play;
        if (r4 != null) goto L15;
        r4 = ((NetEaseCloudMusicSearchParams) ZeusTransformUtils.preCheckCast(r6, NetEaseCloudMusicSearchParams.class, "com.obric.aiagent.plugin")).auto_play;
    L15:
        Integer r5 = this.count;
        if (r5 != null) goto L19;
        r5 = ((NetEaseCloudMusicSearchParams) ZeusTransformUtils.preCheckCast(r6, NetEaseCloudMusicSearchParams.class, "com.obric.aiagent.plugin")).count;
    L19:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new NetEaseCloudMusicSearchParams(r1, r3, r4, r5), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
