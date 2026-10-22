package com.stepos.core.data;

import a0.a;
import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.stepos.core.data.base.Content;
import gc.q;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class FileContent extends Content {
    private final String mimeType;
    private final String path;
    private final ParcelFileDescriptor pfd;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<FileContent> CREATOR = new Parcelable.Creator<FileContent>() { // from class: com.stepos.core.data.FileContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileContent createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            parcel.readInt();
            ContentParams contentParamsCreateFromParcel = parcel.readByte() == 1 ? ContentParams.CREATOR.createFromParcel(parcel) : null;
            FileContent fileContent = new FileContent(parcel);
            ((Content) fileContent).params = contentParamsCreateFromParcel;
            return fileContent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileContent[] newArray(int i10) {
            return new FileContent[i10];
        }
    };

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ FileContent fromPath$default(Companion companion, String str, String str2, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                str2 = companion.guessMimeType(str);
            }
            return companion.fromPath(str, str2);
        }

        public static /* synthetic */ FileContent fromUri$default(Companion companion, Context context, Uri uri, String str, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                str = null;
            }
            return companion.fromUri(context, uri, str);
        }

        private final String guessMimeType(String str) {
            String lowerCase = q.H0(str, '.', "").toLowerCase(Locale.ROOT);
            g.e(lowerCase, "toLowerCase(...)");
            switch (lowerCase.hashCode()) {
                case 96323:
                    return !lowerCase.equals("aac") ? "application/octet-stream" : "audio/aac";
                case 97669:
                    return !lowerCase.equals("bmp") ? "application/octet-stream" : "image/bmp";
                case 102340:
                    return !lowerCase.equals("gif") ? "application/octet-stream" : "image/gif";
                case 105441:
                    return !lowerCase.equals("jpg") ? "application/octet-stream" : "image/jpeg";
                case 106458:
                    return !lowerCase.equals("m4a") ? "application/octet-stream" : "audio/aac";
                case 108272:
                    return !lowerCase.equals("mp3") ? "application/octet-stream" : "audio/mpeg";
                case 108273:
                    return !lowerCase.equals("mp4") ? "application/octet-stream" : "video/mp4";
                case 109967:
                    return !lowerCase.equals("ogg") ? "application/octet-stream" : "audio/ogg";
                case 110834:
                    return !lowerCase.equals("pdf") ? "application/octet-stream" : "application/pdf";
                case 111145:
                    return !lowerCase.equals("png") ? "application/octet-stream" : "image/png";
                case 115312:
                    return !lowerCase.equals("txt") ? "application/octet-stream" : "text/plain";
                case 117484:
                    return !lowerCase.equals("wav") ? "application/octet-stream" : "audio/wav";
                case 3268712:
                    return !lowerCase.equals("jpeg") ? "application/octet-stream" : "image/jpeg";
                case 3271912:
                    return !lowerCase.equals("json") ? "application/octet-stream" : "application/json";
                case 3645337:
                    return !lowerCase.equals("webm") ? "application/octet-stream" : "video/webm";
                case 3645340:
                    return !lowerCase.equals("webp") ? "application/octet-stream" : "image/webp";
                default:
                    return "application/octet-stream";
            }
        }

        public final FileContent fromPath(String path) {
            g.f(path, "path");
            return fromPath$default(this, path, null, 2, null);
        }

        public final FileContent fromUri(Context context, Uri uri) {
            g.f(context, "context");
            g.f(uri, "uri");
            return fromUri$default(this, context, uri, null, 4, null);
        }

        public final FileContent readFieldsFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new FileContent(parcel);
        }

        private Companion() {
        }

        public final FileContent fromPath(String path, String mimeType) {
            g.f(path, "path");
            g.f(mimeType, "mimeType");
            return new FileContent(path, mimeType, ParcelFileDescriptor.open(new File(path), 268435456));
        }

        public final FileContent fromUri(Context context, Uri uri, String str) throws FileNotFoundException {
            g.f(context, "context");
            g.f(uri, "uri");
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                throw new IllegalArgumentException("Cannot open URI: " + uri);
            }
            if (str == null && (str = context.getContentResolver().getType(uri)) == null) {
                str = "application/octet-stream";
            }
            String string = uri.toString();
            g.e(string, "toString(...)");
            return new FileContent(string, str, parcelFileDescriptorOpenFileDescriptor);
        }
    }

    public /* synthetic */ FileContent(String str, String str2, ParcelFileDescriptor parcelFileDescriptor, int i10, e eVar) {
        this(str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? null : parcelFileDescriptor);
    }

    public static final FileContent fromPath(String str) {
        return Companion.fromPath(str);
    }

    public static final FileContent fromUri(Context context, Uri uri) {
        return Companion.fromUri(context, uri);
    }

    public static final FileContent readFieldsFromParcel(Parcel parcel) {
        return Companion.readFieldsFromParcel(parcel);
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public int describeContents() {
        return this.pfd != null ? 1 : 0;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getPath() {
        return this.path;
    }

    public final ParcelFileDescriptor getPfd() {
        return this.pfd;
    }

    public final boolean hasFileDescriptor() {
        return this.pfd != null;
    }

    public String toString() {
        return a.m(ai.onnxruntime.a.s("FileContent(path='", this.path, "', mimeType='", this.mimeType, "', hasPfd="), this.pfd != null, ")");
    }

    public final boolean validate() {
        return (q.t0(this.path) && this.pfd == null) ? false : true;
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        g.f(parcel, "parcel");
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.path);
        parcel.writeString(this.mimeType);
        parcel.writeTypedObject(this.pfd, i10);
    }

    public static final FileContent fromPath(String str, String str2) {
        return Companion.fromPath(str, str2);
    }

    public static final FileContent fromUri(Context context, Uri uri, String str) {
        return Companion.fromUri(context, uri, str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileContent(String path, String mimeType, ParcelFileDescriptor parcelFileDescriptor) {
        super(4);
        g.f(path, "path");
        g.f(mimeType, "mimeType");
        this.path = path;
        this.mimeType = mimeType;
        this.pfd = parcelFileDescriptor;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FileContent(Parcel parcel) {
        g.f(parcel, "parcel");
        String string = parcel.readString();
        string = string == null ? "" : string;
        String string2 = parcel.readString();
        this(string, string2 != null ? string2 : "", (ParcelFileDescriptor) parcel.readTypedObject(ParcelFileDescriptor.CREATOR));
    }
}
