package com.bytedance.android.livesdk.interactivity.api.expression;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.style.ForegroundColorSpan;
import com.bytedance.android.live.base.model.user.IBaseUser;

/* JADX INFO: loaded from: classes9.dex */
public class MentionSpan extends ForegroundColorSpan implements e90.a {
    public static final Parcelable.Creator<MentionSpan> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBaseUser f133184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f133185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f133186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextExtraStruct f133187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f133188e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f133189f;

    public class a implements Parcelable.Creator<MentionSpan> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MentionSpan createFromParcel(Parcel r100) {
            return new MentionSpan(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final MentionSpan[] newArray(int r100) {
            return new MentionSpan[r100];
        }
    }

    @Override // e90.a
    public final int a() {
        return 4;
    }

    @Override // e90.a
    public final boolean b() {
        return true;
    }

    @Override // android.text.style.ForegroundColorSpan, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public int getType() {
        return 2;
    }

    static {
        CREATOR = new a();
    }

    public final int hashCode() {
        String r100 = this.f133185b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f133186c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        TextExtraStruct r107 = this.f133187d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f133188e;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    @Override // e90.a
    public final String getDesc() {
        return this.f133186c;
    }

    public MentionSpan(d r100) {
        super(r100.f133203a);
        this.f133188e = "";
        this.f133189f = false;
        this.f133185b = r100.f133205c;
        this.f133186c = r100.f133204b;
        this.f133188e = r100.f133206d;
        this.f133184a = r100.f133207e;
        TextExtraStruct r101 = new TextExtraStruct();
        this.f133187d = r101;
        r101.setUserId(r100.f133205c);
        r101.setWebcastUid(r100.f133205c);
        r101.setUser(r100.f133207e);
        this.f133189f = r100.f133208f;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L41:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L41;
        MentionSpan r101 = (MentionSpan) r100;
        String r102 = this.f133185b;
        if (r102 == null) goto L16;
        if (r102.equals(r101.f133185b) == false) goto L17;
    L18:
        String r103 = this.f133186c;
        if (r103 == null) goto L24;
        if (r103.equals(r101.f133186c) == false) goto L25;
    L26:
        TextExtraStruct r104 = this.f133187d;
        if (r104 == null) goto L32;
        if (r104.equals(r101.f133187d) == false) goto L33;
    L34:
        String r105 = this.f133188e;
        String r106 = r101.f133188e;
        if (r105 != null) goto L42;
        if (r106 == null) goto L43;
        return false;
    L43:
        return true;
    L42:
        return r105.equals(r106);
    L33:
        return false;
    L32:
        if (r101.f133187d == null) goto L34;
    L25:
        return false;
    L24:
        if (r101.f133186c == null) goto L26;
    L17:
        return false;
    L16:
        if (r101.f133185b == null) goto L18;
        goto L17
    }

    public MentionSpan(Parcel r100) {
        super(r100);
        this.f133188e = "";
        this.f133189f = false;
        this.f133185b = r100.readString();
        this.f133186c = r100.readString();
        this.f133187d = (TextExtraStruct) r100.readParcelable(TextExtraStruct.class.getClassLoader());
        this.f133188e = r100.readString();
    }

    @Override // android.text.style.ForegroundColorSpan, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f133185b);
        r100.writeString(this.f133186c);
        r100.writeParcelable(this.f133187d, r101);
        r100.writeString(this.f133188e);
    }
}
