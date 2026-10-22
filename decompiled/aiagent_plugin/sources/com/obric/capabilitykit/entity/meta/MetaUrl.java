package com.obric.capabilitykit.entity.meta;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class MetaUrl extends MetaValue {
    public static final CREATOR CREATOR = null;
    public static final int VERSION = 0;
    private final String title;
    private final String url;

    public static final class CREATOR implements Parcelable.Creator<MetaUrl> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaUrl createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new MetaUrl(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaUrl createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaUrl[] newArray(int r1) {
            return new MetaUrl[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaUrl[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MetaUrl(Parcel r3) {
        o.e(r3, "parcel");
        this(EntityExtKt.a(r3), r3.readString());
        readMetaValueExtensionField$capabilitykitcommon_release(r3, 0, r3.readInt());
    }

    public MetaUrl(String r2, String r3) {
        o.e(r2, "url");
        super(MetaType.URL);
        this.url = r2;
        this.title = r3;
    }

    public /* synthetic */ MetaUrl(String r1, String r2, int r3, h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public static /* synthetic */ MetaUrl copy$default(MetaUrl r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.url;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.title;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.title;
    }

    public final MetaUrl copy(String r1, String r2) {
        o.e(r1, "url");
        return new MetaUrl(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MetaUrl.class) == true) goto L8;
        return false;
    L8:
        MetaUrl r6 = (MetaUrl) ZeusTransformUtils.preCheckCast(r5, MetaUrl.class, "com.obric.aiagent.plugin");
        if (o.a(this.url, r6.url) == true) goto L12;
        return false;
    L12:
        if (o.a(this.title, r6.title) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int r0 = this.url.hashCode() * 31;
        String r1 = this.title;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public void onReadMetaValueExtensionField$capabilitykitcommon_release(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public String toString() {
        return "MetaUrl(url=" + this.url + ", title=" + this.title + ')';
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(this.url);
        r1.writeString(this.title);
        r1.writeInt(0);
    }
}
