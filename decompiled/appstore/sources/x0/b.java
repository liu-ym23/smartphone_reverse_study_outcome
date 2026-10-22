package x0;

import android.content.Context;
import com.bytedance.apm.alog.IAlogUploadStrategy;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class b implements IAlogUploadStrategy {

    public class a implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Pattern f25411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f25412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f25413c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f25414d;

        public a(b r10, Pattern r11, long r12, long r13) {
            this.f25414d = r10;
            this.f25411a = r11;
            this.f25412b = r12;
            this.f25413c = r13;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r10, String r11) {
            Matcher r12 = this.f25411a.matcher(r11);
            if (r12.find() == true) goto L5;
            return false;
        L5:
            if (r12.groupCount() != 1) goto L25;
            String r13 = r12.group(1);
            if (r13 != null) goto L10;
            return false;
        L10:
            long r14 = Long.parseLong(r13);
            if (r14 > 0) goto L13;
            return false;
        L13:
            if (r14 > this.f25412b) goto L26;
            long r15 = new File(r10, r11).lastModified();
            if (r15 > 0) goto L18;
            return false;
        L18:
            if (r15 >= this.f25413c) goto L20;
            return false;
        L20:
            return true;
        L26:
            return false;
        L25:
            return false;
        }
    }

    public b() {
    }

    @Override // com.bytedance.apm.alog.IAlogUploadStrategy
    public List getUploadAlogFiles(Context r10, String r11, long r12, long r14) {
        long r13 = r12 * 1000;
        long r15 = r14 * 1000;
        if (r13 <= r15) goto L5;
        return null;
    L5:
        if (r11 != null) goto L7;
        return null;
    L7:
        File r16 = new File(r11);
        if (r16.exists() == true) goto L10;
    L19:
        return null;
    L10:
        if (r16.isDirectory() == false) goto L19;
        File[] r17 = r16.listFiles(new a(this, Pattern.compile("^\\d{4}_\\d{2}_\\d{2}_(\\d+)__\\S+__\\S+\\.alog\\.hot$"), r15, r13));
        ArrayList r18 = new ArrayList();
        if (r17 != null) goto L15;
        return null;
    L15:
        int r19 = r17.length;
        int r110 = 0;
    L16:
        if (r110 >= r19) goto L18;
        r18.add(r17[r110].getAbsolutePath());
        r110 = r110 + 1;
        goto L16
    L18:
        return r18;
    }
}
