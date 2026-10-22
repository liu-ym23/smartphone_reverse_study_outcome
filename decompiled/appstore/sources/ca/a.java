package ca;

import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.monitor.cloudmessage.utils.NetworkUtils;
import da.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import w0.c;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ArrayList f6068a;

    static {
        f6068a = new ArrayList();
    }

    public static boolean a(da.a r10) {
        if (r10.g() == false) goto L6;
        return false;
    L6:
        if (r10.q() == true) goto L11;
        if ((System.currentTimeMillis() - r10.d()) >= 0) goto L11;
        return false;
    L11:
        if (NetworkUtils.k(v9.a.k().i()) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static String b(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return "";
    L6:
        int r11 = r10.lastIndexOf(LibrarianImpl.Constants.DOT);
        if (r11 != (-1)) goto L11;
        return r10 + "-cloudMsg.zip";
    L11:
        return r10.substring(0, r11) + "-cloudMsg.zip";
    }

    public static void c(da.a r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.j() != null) goto L6;
        return;
    L6:
        if (r10.j().getUploadFileList().size() != 0) goto L9;
        return;
    L9:
        if (a(r10) == true) goto L12;
        return;
    L12:
        if (r10.m() == true) goto L14;
        r10.u(r10.j().getUploadFileList());
    L15:
        boolean r11 = ea.a.d(r10);
        if (r10.n() == false) goto L31;
        if (r11 == false) goto L32;
        Iterator<String> r12 = r10.j().getUploadFileList().iterator();
    L20:
        if (r12.hasNext() == false) goto L34;
        File r13 = new File(r12.next());
        if (r13.exists() == false) goto L20;
        r13.delete();
        goto L20
    L34:
        return;
    L32:
        return;
    L31:
        return;
    L14:
        e(r10);
        goto L15
    }

    public static void d(b r10) {
        if (c.B() == false) goto L5;
        s1.c.b("cloudmessage", new String[]{"uploadInfo=" + r10});
    L5:
        if (r10 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r10.b()) == true) goto L12;
        ea.a.c(r10);
        return;
    }

    public static void e(da.a r10) {
        if (r10.j().getUploadFileList().size() != 1) goto L5;
    L15:
        File r11 = new File(r10.j().getUploadFileList().get(0));
        File r12 = new File(r11.getParent(), b(r11.getName()));
        if (r12.exists() == false) goto L18;
        r12.delete();
    L18:
        String[] r13 = new String[r10.j().getUploadFileList().size()];
        String[] r14 = (String[]) r10.j().getUploadFileList().toArray(r13);
        com.monitor.cloudmessage.utils.b.b(r12.getAbsolutePath(), r14);
        ArrayList r15 = new ArrayList(1);
        r15.add(r12.getAbsolutePath());
        r10.u(r15);
        return;
    L5:
        if (r10.p() == true) goto L15;
        ArrayList r16 = new ArrayList();
        Iterator<String> r17 = r10.j().getUploadFileList().iterator();
    L9:
        if (r17.hasNext() == false) goto L14;
        String r18 = r17.next();
        File r19 = new File(r18);
        File r20 = new File(r19.getParent(), b(r19.getName()));
        if (r20.exists() == false) goto L13;
        r20.delete();
    L13:
        com.monitor.cloudmessage.utils.b.b(r20.getAbsolutePath(), new String[]{r18});
        r16.add(r20.getAbsolutePath());
        goto L9
    L14:
        r10.u(r16);
    }
}
