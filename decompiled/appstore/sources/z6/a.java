package z6;

import com.bytedance.watson.assist.file.FileStatInfo;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FileStatInfo f26288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f26289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public File f26290c;

    public a(String r10) {
        this.f26288a = null;
        this.f26290c = null;
        this.f26289b = r10;
    }

    public FileStatInfo a(File r10) {
        return null;
    }

    public FileStatInfo b() {
        if (this.f26289b != null) goto L7;
        a7.a.h("refresh and path null");
        return null;
    L7:
        if (this.f26290c != null) goto L9;
        this.f26290c = new File(this.f26289b);
    L9:
        FileStatInfo r10 = a(this.f26290c);
        this.f26288a = r10;
        return r10;
    }

    public String toString() {
        return "BaseStatFile{mPath='" + this.f26289b + "', mFile=" + this.f26290c + ", mLastInfo=" + this.f26288a + '}';
    }
}
