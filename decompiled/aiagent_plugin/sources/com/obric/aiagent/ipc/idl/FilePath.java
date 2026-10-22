package com.obric.aiagent.ipc.idl;

import android.app.Application;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.aiagent.platform.depend.IAppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.io.File;

/* JADX INFO: compiled from: FileIDLStubImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FilePath implements Parcelable {
    public static final Parcelable.Creator<FilePath> CREATOR = null;
    public static final a Companion = null;
    public static final int DIR_BASE = 0;
    public static final int DIR_CACHE = 1;
    public static final int DIR_EXTERNAL_CACHE = 11;
    public static final int DIR_EXTERNAL_FILES = 12;
    public static final int DIR_FILES = 2;
    public static final int DIR_OBB = 10;
    private final int baseDir;
    private final boolean isDirectory;
    private final String relativePath;

    /* JADX INFO: compiled from: FileIDLStubImpl.kt */
    public static final class Creator implements Parcelable.Creator<FilePath> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FilePath createFromParcel(Parcel r3) {
            o.e(r3, "parcel");
            int r0 = r3.readInt();
            String r1 = r3.readString();
            if (r3.readInt() == 0) goto L5;
            boolean r4 = true;
        L7:
            return new FilePath(r0, r1, r4);
        L5:
            r4 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FilePath createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FilePath[] newArray(int r1) {
            return new FilePath[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FilePath[] newArray(int r1) {
            return newArray(r1);
        }
    }

    /* JADX INFO: compiled from: FileIDLStubImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ FilePath copy$default(FilePath r0, int r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.baseDir;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.relativePath;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.isDirectory;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.baseDir;
    }

    public final String component2() {
        return this.relativePath;
    }

    public final boolean component3() {
        return this.isDirectory;
    }

    public final FilePath copy(int r1, String r2, boolean r3) {
        o.e(r2, "relativePath");
        return new FilePath(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, FilePath.class) == true) goto L8;
        return false;
    L8:
        FilePath r6 = (FilePath) ZeusTransformUtils.preCheckCast(r5, FilePath.class, "com.obric.aiagent.plugin");
        if (this.baseDir == r6.baseDir) goto L12;
        return false;
    L12:
        if (o.a(this.relativePath, r6.relativePath) == true) goto L15;
        return false;
    L15:
        if (this.isDirectory == r6.isDirectory) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.baseDir) * 31) + this.relativePath.hashCode()) * 31) + Boolean.hashCode(this.isDirectory);
    }

    public String toString() {
        return "FilePath(baseDir=" + this.baseDir + ", relativePath=" + this.relativePath + ", isDirectory=" + this.isDirectory + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeInt(this.baseDir);
        r1.writeString(this.relativePath);
        r1.writeInt(this.isDirectory ? 1 : 0);
    }

    public FilePath(int r2, String r3, boolean r4) {
        o.e(r3, "relativePath");
        this.baseDir = r2;
        this.relativePath = r3;
        this.isDirectory = r4;
    }

    public /* synthetic */ FilePath(int r1, String r2, boolean r3, int r4, h r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        this(r1, r2, r3);
    }

    public final int getBaseDir() {
        return this.baseDir;
    }

    public final String getRelativePath() {
        return this.relativePath;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    private final Application getContext() {
        return (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
    }

    public final File toLocalFile() {
        int r0 = this.baseDir;
        if (r0 == 0) goto L20;
        if (r0 == 1) goto L28;
        if (r0 == 2) goto L27;
        switch(r0) {
            case 10: goto L14;
            case 11: goto L11;
            case 12: goto L22;
            default: goto L21;
        };
    L11:
        File r1 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getExternalCacheDir();
        if (r1 != null) goto L24;
        return null;
    L24:
        return new File(r1, this.relativePath);
    L14:
        File r2 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getObbDir();
        if (r2 != null) goto L26;
        return null;
    L26:
        return new File(r2, this.relativePath);
    L21:
        return ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getDir(this.relativePath, 0);
    L22:
        return ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getExternalFilesDir(this.relativePath);
    L27:
        return new File(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getFilesDir(), this.relativePath);
    L28:
        return new File(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getCacheDir(), this.relativePath);
    L20:
        return ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getDir(this.relativePath, 0);
    }
}
