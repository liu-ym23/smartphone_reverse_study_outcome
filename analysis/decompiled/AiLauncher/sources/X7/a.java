package X7;

import Z7.C1139k;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: X7.a$a, reason: collision with other inner class name */
    public static class C0119a implements c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f6859a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f6860b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f6861c;

        public C0119a(b bVar, String str, boolean z10) {
            this.f6859a = bVar;
            this.f6860b = str;
            this.f6861c = z10;
        }

        @Override // X7.a.c
        public final boolean a(long j10, long j11, String str) {
            C1139k.h("new process %s", str);
            if (!str.equals(this.f6860b)) {
                return true;
            }
            b bVar = this.f6859a;
            bVar.f6862a = j10;
            bVar.f6863b = str;
            bVar.f6864c = j11;
            return this.f6861c;
        }

        @Override // X7.a.c
        public final boolean b(String str, int i10, String str2, String str3) {
            C1139k.h("new thread %s", str);
            b bVar = this.f6859a;
            if (bVar.f6862a > 0 && bVar.f6864c > 0 && bVar.f6863b != null) {
                if (bVar.f6865d == null) {
                    bVar.f6865d = new HashMap();
                }
                this.f6859a.f6865d.put(str, new String[]{str2, str3, String.valueOf(i10)});
            }
            return true;
        }

        @Override // X7.a.c
        public final boolean c(long j10) {
            C1139k.h("process end %d", Long.valueOf(j10));
            b bVar = this.f6859a;
            return bVar.f6862a <= 0 || bVar.f6864c <= 0 || bVar.f6863b == null;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public long f6862a;

        /* renamed from: b, reason: collision with root package name */
        public String f6863b;

        /* renamed from: c, reason: collision with root package name */
        public long f6864c;

        /* renamed from: d, reason: collision with root package name */
        public Map<String, String[]> f6865d;
    }

    public interface c {
        boolean a(long j10, long j11, String str);

        boolean b(String str, int i10, String str2, String str3);

        boolean c(long j10);
    }

    public static String a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < 3; i10++) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return null;
            }
            stringBuffer.append(line + "\n");
        }
        return stringBuffer.toString();
    }

    public static Object[] b(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return null;
            }
            for (Pattern pattern : patternArr) {
                if (pattern.matcher(line).matches()) {
                    return new Object[]{pattern, line};
                }
            }
        }
    }

    public static String c(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null || line.trim().length() <= 0) {
                break;
            }
            stringBuffer.append(line + "\n");
        }
        return stringBuffer.toString();
    }

    public static b d(String str, String str2, boolean z10) throws Throwable {
        if (str != null && str2 != null) {
            b bVar = new b();
            e(str2, new C0119a(bVar, str, z10));
            if (bVar.f6862a > 0 && bVar.f6864c > 0 && bVar.f6863b != null) {
                return bVar;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0150, code lost:
    
        if (r17.c(java.lang.Long.parseLong(r1[1].toString().split("\\s")[2])) != false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0152, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0155, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0156, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x015b, code lost:
    
        if (Z7.C1139k.e(r0) != false) goto L106;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(java.lang.String r16, X7.a.c r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 443
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: X7.a.e(java.lang.String, X7.a$c):void");
    }
}
