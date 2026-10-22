package com.stepos.core.data.base;

import ai.onnxruntime.providers.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.core.data.AudioContent;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.FileContent;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.MixedContent;
import com.stepos.core.data.PrimitiveContent;
import com.stepos.core.data.SessionRefContent;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.VideoContent;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class Content implements Parcelable {
    public static final Parcelable.Creator<Content> CREATOR = new Parcelable.Creator<Content>() { // from class: com.stepos.core.data.base.Content.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Content createFromParcel(Parcel parcel) {
            return Content.createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Content[] newArray(int i10) {
            return new Content[i10];
        }
    };
    protected ContentParams params;
    protected int type;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Types {
        public static final int TYPE_AUDIO = 3;
        public static final int TYPE_BOOLEAN = 104;
        public static final int TYPE_DOUBLE = 103;
        public static final int TYPE_DOUBLE_ARRAY = 108;
        public static final int TYPE_FILE = 4;
        public static final int TYPE_FLOAT = 102;
        public static final int TYPE_FLOAT_ARRAY = 106;
        public static final int TYPE_IMAGE = 1;
        public static final int TYPE_INT = 100;
        public static final int TYPE_INT_ARRAY = 107;
        public static final int TYPE_LONG = 101;
        public static final int TYPE_MIXED = 5;
        public static final int TYPE_STRING = 105;
        public static final int TYPE_TEXT = 0;
        public static final int TYPE_VIDEO = 2;

        private Types() {
        }

        public static boolean isMediaType(int i10) {
            return i10 >= 0 && i10 < 100;
        }

        public static boolean isPrimitiveType(int i10) {
            return i10 >= 100;
        }
    }

    public Content() {
        this.type = -1;
        this.params = null;
    }

    public static Content createFromParcel(Parcel parcel) {
        Content fieldsFromParcel;
        int i10 = parcel.readInt();
        ContentParams contentParamsCreateFromParcel = parcel.readByte() == 1 ? ContentParams.CREATOR.createFromParcel(parcel) : null;
        switch (i10) {
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
                if (!Types.isPrimitiveType(i10)) {
                    throw new IllegalArgumentException(a.a(i10, "Unknown content type: "));
                }
                fieldsFromParcel = PrimitiveContent.Companion.readFieldsFromParcel(parcel, i10);
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

    public void setType(int i10) {
        this.type = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.type);
        if (this.params == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            this.params.writeToParcel(parcel, i10);
        }
    }

    public Content(int i10) {
        this.type = i10;
        this.params = null;
    }

    public Content(int i10, ContentParams contentParams) {
        this.type = i10;
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
