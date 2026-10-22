package x2;

import M0.i;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6870a = 0;
    public File b;
    public String c;
    public String d;
    public int e;

    public /* synthetic */ b() {
    }

    public final int a() {
        BufferedReader bufferedReader = null;
        int i = -1;
        switch (this.f6870a) {
            case 0:
                if (!this.b.exists() || !this.b.isFile()) {
                    return -1;
                }
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(this.b));
                    int i6 = -1;
                    do {
                        try {
                            String line = bufferedReader2.readLine();
                            if (line != null) {
                                int i10 = this.e;
                                if (line.startsWith(this.c)) {
                                    try {
                                        i10 = Integer.parseInt(line.split(this.d)[1].trim());
                                    } catch (NumberFormatException e) {
                                        int i11 = com.apm.insight.b.f2156a;
                                        i.k("NPTH_CATCH", e);
                                    }
                                    if (i10 < 0) {
                                        i10 = -2;
                                    }
                                }
                                i6 = i10;
                            }
                            i.i(bufferedReader2);
                            return i6;
                        } catch (Throwable th) {
                            th = th;
                            i = i6;
                            bufferedReader = bufferedReader2;
                            try {
                                int i12 = com.apm.insight.b.f2156a;
                                i.k("NPTH_CATCH", th);
                                if (bufferedReader == null) {
                                    return i;
                                }
                                i.i(bufferedReader);
                                return i;
                            } finally {
                            }
                        }
                    } while (i6 == -1);
                    i.i(bufferedReader2);
                    return i6;
                } catch (Throwable th2) {
                    th = th2;
                }
                break;
            default:
                File file = this.b;
                if (!file.exists() || !file.isFile()) {
                    return -1;
                }
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(new FileReader(file));
                    int i13 = -1;
                    do {
                        try {
                            String line2 = bufferedReader3.readLine();
                            if (line2 != null) {
                                int i14 = this.e;
                                if (line2.startsWith(this.c)) {
                                    try {
                                        i14 = Integer.parseInt(line2.split(this.d)[1].trim());
                                    } catch (NumberFormatException e6) {
                                        int i15 = com.apm.insight.b.f2156a;
                                        i.k("NPTH_CATCH", e6);
                                    }
                                    if (i14 < 0) {
                                        i14 = -2;
                                    }
                                }
                                i13 = i14;
                            }
                            i.i(bufferedReader3);
                            return i13;
                        } catch (Throwable th3) {
                            th = th3;
                            i = i13;
                            bufferedReader = bufferedReader3;
                            try {
                                int i16 = com.apm.insight.b.f2156a;
                                i.k("NPTH_CATCH", th);
                                if (bufferedReader == null) {
                                    return i;
                                }
                                i.i(bufferedReader);
                                return i;
                            } finally {
                            }
                        }
                    } while (i13 == -1);
                    i.i(bufferedReader3);
                    return i13;
                } catch (Throwable th4) {
                    th = th4;
                }
                break;
        }
    }

    public b(File file) {
        this.b = file;
    }
}
