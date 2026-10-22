package com.stepos.core.data;

import B7.a;
import L.g;
import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.core.data.base.Content;
import d5.m;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 \u001f2\u00020\u0001:\u0001 B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0010\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/stepos/core/data/FileContent;", "Lcom/stepos/core/data/base/Content;", "", SingleFileBundle.KEY_PATH, "mimeType", "Landroid/os/ParcelFileDescriptor;", "pfd", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Landroid/os/ParcelFileDescriptor;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "validate", "()Z", "hasFileDescriptor", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "getPath", "getMimeType", "Landroid/os/ParcelFileDescriptor;", "getPfd", "()Landroid/os/ParcelFileDescriptor;", "Companion", "d5/m", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FileContent extends Content {
    private final String mimeType;
    private final String path;
    private final ParcelFileDescriptor pfd;
    public static final m Companion = new m();
    public static final Parcelable.Creator<FileContent> CREATOR = new g(13);

    public /* synthetic */ FileContent(String str, String str2, ParcelFileDescriptor parcelFileDescriptor, int i, e eVar) {
        this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : parcelFileDescriptor);
    }

    public static final FileContent fromPath(String path) {
        m mVar = Companion;
        mVar.getClass();
        k.f(path, "path");
        return m.a(mVar, path);
    }

    public static final FileContent fromUri(Context context, Uri uri) {
        Companion.getClass();
        k.f(context, "context");
        k.f(uri, "uri");
        return m.b(context, uri, null);
    }

    public static final FileContent readFieldsFromParcel(Parcel parcel) {
        Companion.getClass();
        k.f(parcel, "parcel");
        return new FileContent(parcel);
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
        return a.s(a.w("FileContent(path='", this.path, "', mimeType='", this.mimeType, "', hasPfd="), this.pfd != null, ")");
    }

    public final boolean validate() {
        return (j9.m.s0(this.path) && this.pfd == null) ? false : true;
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        super.writeToParcel(parcel, flags);
        parcel.writeString(this.path);
        parcel.writeString(this.mimeType);
        parcel.writeTypedObject(this.pfd, flags);
    }

    public static final FileContent fromPath(String path, String mimeType) {
        Companion.getClass();
        k.f(path, "path");
        k.f(mimeType, "mimeType");
        return new FileContent(path, mimeType, ParcelFileDescriptor.open(new File(path), 268435456));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileContent(String path, String mimeType, ParcelFileDescriptor parcelFileDescriptor) {
        super(4);
        k.f(path, "path");
        k.f(mimeType, "mimeType");
        this.path = path;
        this.mimeType = mimeType;
        this.pfd = parcelFileDescriptor;
    }

    public static final FileContent fromUri(Context context, Uri uri, String str) {
        Companion.getClass();
        return m.b(context, uri, str);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FileContent(Parcel parcel) {
        k.f(parcel, "parcel");
        String string = parcel.readString();
        string = string == null ? "" : string;
        String string2 = parcel.readString();
        this(string, string2 != null ? string2 : "", (ParcelFileDescriptor) parcel.readTypedObject(ParcelFileDescriptor.CREATOR));
    }
}
