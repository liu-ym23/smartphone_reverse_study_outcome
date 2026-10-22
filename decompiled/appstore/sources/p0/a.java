package p0;

import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f23256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f23257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ArrayList f23258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f23259d;

    /* JADX INFO: renamed from: p0.a$a, reason: collision with other inner class name */
    public static class C0338a implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f23260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Pattern f23261b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f23262c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f23263d;

        public C0338a(ArrayList r10, Pattern r11, long r12, long r13) {
            this.f23260a = r10;
            this.f23261b = r11;
            this.f23262c = r12;
            this.f23263d = r13;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r10, String r11) {
            this.f23260a.add(r11);
            Matcher r12 = this.f23261b.matcher(r11);
            if (r12.find() == true) goto L5;
        L21:
            return false;
        L5:
            if (r12.groupCount() != 1) goto L21;
            String r13 = r12.group(1);
            if (r13 != null) goto L10;
            return false;
        L10:
            long r14 = Long.parseLong(r13);
            if (r14 <= 0) goto L21;
            if (r14 > this.f23262c) goto L21;
            long r15 = new File(r10, r11).lastModified();
            if (r15 <= 0) goto L21;
            if (r15 < this.f23263d) goto L21;
            return true;
        }
    }

    static {
    }

    public static File[] a(String r10, String r11, String r12, long r13, long r14) {
        f23256a = r13;
        f23257b = r14;
        f23259d = null;
        f23258c = null;
        if (r13 <= r14) goto L6;
        f23259d = "time interval is invalid";
        return new File[0];
    L6:
        File r15 = new File(r10);
        if (r15.exists() == true) goto L9;
    L30:
        f23259d = "log dir not exists";
        return new File[0];
    L9:
        if (r15.isDirectory() == false) goto L30;
        if (TextUtils.isEmpty(r11) == true) goto L14;
        r11 = r11.replace(':', '-');
    L14:
        StringBuilder r16 = new StringBuilder();
        r16.append("^\\d{4}_\\d{2}_\\d{2}_(\\d+)__");
        String r17 = "\\S+";
        if (TextUtils.isEmpty(r11) == false) goto L17;
        String r18 = "\\S+";
    L18:
        r16.append(r18);
        r16.append("__");
        if (TextUtils.isEmpty(r12) == true) goto L22;
        r17 = Pattern.quote(r12);
    L22:
        r16.append(r17);
        r16.append("\\.alog\\.hot$");
        Pattern r19 = Pattern.compile(r16.toString());
        ArrayList r20 = new ArrayList();
        File[] r110 = r15.listFiles(new C0338a(r20, r19, r14, r13));
        if (r110 != null) goto L25;
    L26:
        f23259d = "log file not found";
        f23258c = r20;
    L27:
        if (r110 == null) goto L29;
        return r110;
    L29:
        return new File[0];
    L25:
        if (r110.length != 0) goto L27;
    L17:
        r18 = Pattern.quote(r11);
        goto L18
    }
}
