package com.stepos.core.data;

import La.H;
import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.stepos.core.data.base.Content;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import com.zyql.ai.selector.config.PictureMimeType;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import net.sqlcipher.database.SQLiteDatabase;
import u6.C5578a;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0010\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/stepos/core/data/FileContent;", "Lcom/stepos/core/data/base/Content;", "", "path", "mimeType", "Landroid/os/ParcelFileDescriptor;", "pfd", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/ParcelFileDescriptor;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "validate", "()Z", "hasFileDescriptor", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "getPath", "getMimeType", "Landroid/os/ParcelFileDescriptor;", "getPfd", "()Landroid/os/ParcelFileDescriptor;", "Companion", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FileContent extends Content {
    private final String mimeType;
    private final String path;
    private final ParcelFileDescriptor pfd;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<FileContent> CREATOR = new Parcelable.Creator<FileContent>() { // from class: com.stepos.core.data.FileContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileContent createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            parcel.readInt();
            ContentParams contentParamsCreateFromParcel = parcel.readByte() == 1 ? ContentParams.CREATOR.createFromParcel(parcel) : null;
            FileContent fileContent = new FileContent(parcel);
            ((Content) fileContent).params = contentParamsCreateFromParcel;
            return fileContent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileContent[] newArray(int size) {
            return new FileContent[size];
        }
    };

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007J$\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/stepos/core/data/FileContent$Companion;", "", "<init>", "()V", "fromPath", "Lcom/stepos/core/data/FileContent;", "path", "", "mimeType", "fromUri", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "guessMimeType", "readFieldsFromParcel", "parcel", "Landroid/os/Parcel;", "CREATOR", "Landroid/os/Parcelable$Creator;", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
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

        private final String guessMimeType(String path) {
            String lowerCase = H.q1(path, '.', "").toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
            switch (lowerCase.hashCode()) {
                case 96323:
                    return !lowerCase.equals("aac") ? "application/octet-stream" : "audio/aac";
                case 97669:
                    return !lowerCase.equals("bmp") ? "application/octet-stream" : "image/bmp";
                case 102340:
                    return !lowerCase.equals("gif") ? "application/octet-stream" : "image/gif";
                case 105441:
                    return !lowerCase.equals(C5578a.DST_JPG) ? "application/octet-stream" : "image/jpeg";
                case 106458:
                    return !lowerCase.equals("m4a") ? "application/octet-stream" : "audio/aac";
                case 108272:
                    return !lowerCase.equals("mp3") ? "application/octet-stream" : PictureMimeType.MIME_TYPE_AUDIO;
                case 108273:
                    return !lowerCase.equals("mp4") ? "application/octet-stream" : "video/mp4";
                case 109967:
                    return !lowerCase.equals("ogg") ? "application/octet-stream" : "audio/ogg";
                case 110834:
                    return !lowerCase.equals("pdf") ? "application/octet-stream" : "application/pdf";
                case 111145:
                    return !lowerCase.equals("png") ? "application/octet-stream" : PictureMimeType.PNG_Q;
                case 115312:
                    return !lowerCase.equals("txt") ? "application/octet-stream" : e.f30839B;
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
            p.i(path, "path");
            return fromPath$default(this, path, null, 2, null);
        }

        public final FileContent fromUri(Context context, Uri uri) {
            p.i(context, "context");
            p.i(uri, "uri");
            return fromUri$default(this, context, uri, null, 4, null);
        }

        public final FileContent readFieldsFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new FileContent(parcel);
        }

        private Companion() {
        }

        public final FileContent fromPath(String path, String mimeType) {
            p.i(path, "path");
            p.i(mimeType, "mimeType");
            return new FileContent(path, mimeType, ParcelFileDescriptor.open(new File(path), SQLiteDatabase.CREATE_IF_NECESSARY));
        }

        public final FileContent fromUri(Context context, Uri uri, String mimeType) throws FileNotFoundException {
            p.i(context, "context");
            p.i(uri, "uri");
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                throw new IllegalArgumentException("Cannot open URI: " + uri);
            }
            if (mimeType == null && (mimeType = context.getContentResolver().getType(uri)) == null) {
                mimeType = "application/octet-stream";
            }
            String string = uri.toString();
            p.h(string, "toString(...)");
            return new FileContent(string, mimeType, parcelFileDescriptorOpenFileDescriptor);
        }
    }

    public /* synthetic */ FileContent(String str, String str2, ParcelFileDescriptor parcelFileDescriptor, int i10, i iVar) {
        this(str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? null : parcelFileDescriptor);
    }

    public static final FileContent fromPath(String str) {
        return INSTANCE.fromPath(str);
    }

    public static final FileContent fromUri(Context context, Uri uri) {
        return INSTANCE.fromUri(context, uri);
    }

    public static final FileContent readFieldsFromParcel(Parcel parcel) {
        return INSTANCE.readFieldsFromParcel(parcel);
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
        return "FileContent(path='" + this.path + "', mimeType='" + this.mimeType + "', hasPfd=" + (this.pfd != null) + ")";
    }

    public final boolean validate() {
        return (H.x0(this.path) && this.pfd == null) ? false : true;
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        p.i(parcel, "parcel");
        super.writeToParcel(parcel, flags);
        parcel.writeString(this.path);
        parcel.writeString(this.mimeType);
        parcel.writeTypedObject(this.pfd, flags);
    }

    public static final FileContent fromPath(String str, String str2) {
        return INSTANCE.fromPath(str, str2);
    }

    public static final FileContent fromUri(Context context, Uri uri, String str) {
        return INSTANCE.fromUri(context, uri, str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileContent(String path, String mimeType, ParcelFileDescriptor parcelFileDescriptor) {
        super(4);
        p.i(path, "path");
        p.i(mimeType, "mimeType");
        this.path = path;
        this.mimeType = mimeType;
        this.pfd = parcelFileDescriptor;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FileContent(Parcel parcel) {
        p.i(parcel, "parcel");
        String string = parcel.readString();
        string = string == null ? "" : string;
        String string2 = parcel.readString();
        this(string, string2 != null ? string2 : "", (ParcelFileDescriptor) parcel.readTypedObject(ParcelFileDescriptor.CREATOR));
    }
}
