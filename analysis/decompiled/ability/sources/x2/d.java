package x2;

import java.io.File;
import java.util.HashMap;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class d {
    public static final Pattern g = Pattern.compile("^pid:\\s(.*),\\stid:\\s(.*),\\sname:\\s(.*)\\s+>>>\\s(.*)\\s<<<$");
    public static final Pattern h = Pattern.compile("^signal\\s(.*),\\scode\\s(.*),\\sfault\\saddr\\s(.*)$");
    public static final Pattern i = Pattern.compile("^Abort message: (.*)$");

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f6871j = Pattern.compile("^Crash message: (.*)$");
    public static final Pattern k = Pattern.compile("^    \\/(\\w*)\\/.*\\/(.*\\.so)\\s\\(BuildId: ([a-f0-9]*)\\)$");

    /* renamed from: a, reason: collision with root package name */
    public String f6872a;
    public String b;
    public String c;
    public String d;
    public String e;
    public final HashMap f = new HashMap();

    public d(File file) {
        a(new File(file, "tombstone.txt"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x018a, code lost:
    
        r12 = r4.readLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x018e, code lost:
    
        if (r12 == null) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0196, code lost:
    
        if (r12.contains("BuildId:") != false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0199, code lost:
    
        r12 = x2.d.k.matcher(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01a3, code lost:
    
        if (r12.find() != false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a6, code lost:
    
        r13 = r12.group(1);
        r1 = r12.group(2);
        r12 = r12.group(3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01b8, code lost:
    
        if (r13.equals(com.stepos.taskrobot.settingsprovider.SettingsConfig.KEY_DATA) == false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01ba, code lost:
    
        r0.put(r1, r12);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.io.File r13) {
        /*
            Method dump skipped, instructions count: 471
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.d.a(java.io.File):void");
    }

    public final String b() {
        StringBuilder sb = new StringBuilder();
        String str = this.c;
        if (str != null) {
            sb.append(str);
        }
        String str2 = this.d;
        if (str2 != null) {
            sb.append(str2);
        }
        String str3 = this.e;
        if (str3 != null) {
            sb.append(str3);
        }
        return sb.toString();
    }
}
