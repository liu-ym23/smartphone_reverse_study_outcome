package com.stepos.core.data.base;

import B7.a;
import L.g;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;
import com.stepos.core.data.AudioContent;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.FileContent;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.MixedContent;
import com.stepos.core.data.PrimitiveContent;
import com.stepos.core.data.SessionRefContent;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.VideoContent;
import d5.s;

/* loaded from: classes3.dex */
public class Content implements Parcelable {
    public static final Parcelable.Creator<Content> CREATOR = new g(7);
    protected ContentParams params;
    protected int type;

    public Content() {
        this.type = -1;
        this.params = null;
    }

    @RequiresApi(26)
    public static Content createFromParcel(Parcel parcel) {
        Content fieldsFromParcel;
        int i = parcel.readInt();
        ContentParams contentParamsCreateFromParcel = parcel.readByte() == 1 ? ContentParams.CREATOR.createFromParcel(parcel) : null;
        switch (i) {
            case 0:
                fieldsFromParcel = TextContent.readFieldsFromParcel(parcel);
                break;
            case 1:
                fieldsFromParcel = ImageContent.readFieldsFromParcel(parcel);
                break;
            case 2:
                fieldsFromParcel = VideoContent.readFieldsFromParcel(parcel);
                break;
            case 3:
                fieldsFromParcel = AudioContent.readFieldsFromParcel(parcel);
                break;
            case 4:
                fieldsFromParcel = FileContent.readFieldsFromParcel(parcel);
                break;
            case 5:
                fieldsFromParcel = MixedContent.readFieldsFromParcel(parcel);
                break;
            case 6:
                fieldsFromParcel = SessionRefContent.readFieldsFromParcel(parcel);
                break;
            default:
                if (i < 100) {
                    throw new IllegalArgumentException(a.h(i, "Unknown content type: "));
                }
                PrimitiveContent.Companion.getClass();
                fieldsFromParcel = new PrimitiveContent(s.a(parcel, i), i);
                break;
        }
        fieldsFromParcel.params = contentParamsCreateFromParcel;
        return fieldsFromParcel;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ContentParams getParams() {
        return this.params;
    }

    public byte[] getParamsBytes() {
        ContentParams contentParams = this.params;
        if (contentParams != null) {
            return contentParams.toByteArray();
        }
        return null;
    }

    public int getType() {
        return this.type;
    }

    public void setParams(ContentParams contentParams) {
        this.params = contentParams;
    }

    public void setParamsFromBytes(byte[] bArr) {
        this.params = bArr != null ? ContentParams.fromByteArray(bArr) : null;
    }

    public void setType(int i) {
        this.type = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        if (this.params == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            this.params.writeToParcel(parcel, i);
        }
    }

    public Content(int i) {
        this.type = i;
        this.params = null;
    }

    public Content(int i, ContentParams contentParams) {
        this.type = i;
        this.params = contentParams;
    }

    public Content(Parcel parcel) {
        this.type = parcel.readInt();
        if (parcel.readByte() == 1) {
            this.params = ContentParams.CREATOR.createFromParcel(parcel);
        } else {
            this.params = null;
        }
    }
}
