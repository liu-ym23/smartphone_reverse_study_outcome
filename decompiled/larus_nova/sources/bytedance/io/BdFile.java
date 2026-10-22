package bytedance.io;

import bytedance.io.exception.IllegalPathException;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.net.URI;
import java.util.ArrayList;
import w.a;

/* JADX INFO: loaded from: classes28.dex */
public class BdFile extends File {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f21474a = null;

    static {
        f21474a = a.C8054a.f557764a;
    }

    @Override // java.io.File
    public BdFile getAbsoluteFile() {
        return new BdFile(getAbsolutePath());
    L5:
        e = move-exception;
        e.toString();
        return null;
    }

    @Override // java.io.File
    public String getParent() {
        String r100 = super.getParent();
        if (r100 != null) goto L10;
        return null;
    L10:
        return new BdFile(r100).getPath();
    L7:
        e = move-exception;
        e.toString();
        return null;
    }

    @Override // java.io.File
    public BdFile getParentFile() {
        String r100 = super.getParent();
        if (r100 != null) goto L10;
        return null;
    L10:
        return new BdFile(r100);
    L7:
        e = move-exception;
        e.toString();
        return null;
    }

    @Override // java.io.File
    public BdFile[] listFiles() {
        String[] r100 = list();
        if (r100 != null) goto L6;
        return null;
    L6:
        int r101 = r100.length;
        BdFile[] r102 = new BdFile[r101];
        int r103 = 0;
    L7:
        if (r103 >= r101) goto L13;
        r102[r103] = new BdFile(getPath(), r100[r103]);     // Catch: IllegalPathException -> L10
    L12:
        r103 = r103 + 1;
    L10:
        e = move-exception;
        e.toString();
        goto L12
    L13:
        return r102;
    }

    @Override // java.io.File
    public /* bridge */ /* synthetic */ File getAbsoluteFile() {
        return getAbsoluteFile();
    }

    @Override // java.io.File
    public /* bridge */ /* synthetic */ File getParentFile() {
        return getParentFile();
    }

    @Override // java.io.File
    public /* bridge */ /* synthetic */ File[] listFiles() {
        return listFiles();
    }

    public BdFile(URI r110) throws IllegalPathException {
        a r100 = f21474a;
        r100.getClass();
        if (r110.isAbsolute() == false) goto L53;
        if (r110.isOpaque() == true) goto L51;
        String r101 = r110.getScheme();
        if (r101 == null) goto L49;
        if (r101.equalsIgnoreCase("file") == false) goto L49;
        if (r110.getAuthority() != null) goto L47;
        if (r110.getFragment() != null) goto L45;
        if (r110.getQuery() != null) goto L43;
        String r111 = r110.getPath();
        if (r111.equals("") == true) goto L41;
        if (r111.endsWith(HTTP.URL_DEFAULT) == true) goto L21;
    L23:
        char r102 = File.separatorChar;
        if (r102 == '/') goto L26;
        r111 = r111.replace('/', r102);
    L26:
        int r103 = r111.length();
        char[] r104 = r111.toCharArray();
        int r105 = 0;
        char r106 = 0;
        int r107 = 0;
    L27:
        if (r105 >= r103) goto L33;
        char r108 = r104[r105];
        if (r108 != '/') goto L31;
        if (r106 != '/') goto L31;
    L32:
        r105 = r105 + 1;
        r106 = r108;
    L31:
        r104[r107] = r108;
        r107 = r107 + 1;
        goto L32
    L33:
        if (r106 != '/') goto L36;
        if (r103 <= 1) goto L36;
        r107 = r107 - 1;
    L36:
        if (r107 == r103) goto L38;
        r111 = new String(r104, 0, r107);
    L38:
        super(r100.b(r111));
        setLastModified(System.currentTimeMillis());
        return;
    L21:
        if (r111.length() <= 1) goto L23;
        r111 = r111.substring(0, r111.length() - 1);
        goto L23
    L41:
        throw new IllegalArgumentException("URI path component is empty");
    L43:
        throw new IllegalArgumentException("URI has a query component");
    L45:
        throw new IllegalArgumentException("URI has a fragment component");
    L47:
        throw new IllegalArgumentException("URI has an authority component");
    L49:
        throw new IllegalArgumentException("URI scheme is not \"file\"");
    L51:
        throw new IllegalArgumentException("URI is not hierarchical");
    L53:
        throw new IllegalArgumentException("URI is not absolute");
    }

    @Override // java.io.File
    public BdFile[] listFiles(FileFilter r100) {
        String[] r101 = list();
        if (r101 != null) goto L5;
        return null;
    L5:
        ArrayList r102 = new ArrayList();
        int r103 = r101.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L18;
        BdFile r105 = new BdFile(getPath(), r101[r104]);     // Catch: IllegalPathException -> L10
    L12:
        if (r100 != null) goto L14;
    L15:
        r102.add(r105);
    L16:
        r104 = r104 + 1;
        goto L6
    L14:
        if (r100.accept(r105) == false) goto L16;
    L10:
        e = move-exception;
        e.toString();
        r105 = null;
        goto L12
    L18:
        return (BdFile[]) r102.toArray(new BdFile[r102.size()]);
    }

    public BdFile(String r100) throws IllegalPathException {
        super(f21474a.b(r100));
        setLastModified(System.currentTimeMillis());
    }

    @Override // java.io.File
    public BdFile[] listFiles(FilenameFilter r100) {
        String[] r101 = list();
        if (r101 != null) goto L6;
        return null;
    L6:
        ArrayList r102 = new ArrayList();
        int r103 = r101.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L18;
        String r105 = r101[r104];
        if (r100 != null) goto L11;
    L19:
        r102.add(new BdFile(getPath(), r105));     // Catch: IllegalPathException -> L14
    L16:
        r104 = r104 + 1;
    L14:
        e = move-exception;
        e.toString();
        goto L16
    L11:
        if (r100.accept(this, r105) == false) goto L16;
    L18:
        return (BdFile[]) r102.toArray(new BdFile[r102.size()]);
    }

    @Override // java.io.File
    public /* bridge */ /* synthetic */ File[] listFiles(FileFilter r100) {
        return listFiles(r100);
    }

    @Override // java.io.File
    public /* bridge */ /* synthetic */ File[] listFiles(FilenameFilter r100) {
        return listFiles(r100);
    }

    public BdFile(File r100, String r101) throws IllegalPathException {
        a r102 = f21474a;
        r102.getClass();
        if (r101 == null) goto L12;
        if (r100 != null) goto L7;
        String r103 = r102.b(r101);
    L11:
        r101 = r103;
        goto L12
    L7:
        if (r100.getPath().equals("") == false) goto L9;
        r103 = r102.c(HTTP.URL_DEFAULT, r101);
        goto L11
    L9:
        r103 = r102.c(r100.getPath(), r101);
    L12:
        super(r101);
        setLastModified(System.currentTimeMillis());
    }

    public BdFile(String r100, String r101) throws IllegalPathException {
        super(f21474a.c(r100, r101));
        setLastModified(System.currentTimeMillis());
    }
}
