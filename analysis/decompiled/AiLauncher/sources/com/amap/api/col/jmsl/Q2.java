package com.amap.api.col.jmsl;

import android.content.Context;
import com.amap.api.col.jmsl.C0;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Q2 {
    public static int a(K2 k22) {
        C0 c02 = null;
        try {
            try {
                if (k22.f16166f.d()) {
                    k22.f16166f.c(true);
                    C0 c0B = C0.b(new File(k22.f16161a), 1, 1, k22.f16162b);
                    try {
                        ArrayList arrayList = new ArrayList();
                        byte[] bArrF = f(c0B, k22, arrayList);
                        if (bArrF != null && bArrF.length != 0) {
                            JSONObject jSONObject = new JSONObject(new String(C1540c1.b().d(new M1(bArrF, k22.f16163c)).f16719a));
                            if (jSONObject.has("code") && jSONObject.getInt("code") == 1) {
                                AbstractC1619w1 abstractC1619w1 = k22.f16166f;
                                if (abstractC1619w1 != null) {
                                    abstractC1619w1.b(bArrF.length);
                                }
                                if (k22.f16166f.a() < Integer.MAX_VALUE) {
                                    try {
                                        Iterator it = arrayList.iterator();
                                        while (it.hasNext()) {
                                            c0B.D0((String) it.next());
                                        }
                                        c0B.close();
                                    } catch (Throwable th) {
                                        C1541c2.b(th, "ofm", "dlo");
                                    }
                                } else {
                                    try {
                                        c0B.T0();
                                    } catch (Throwable th2) {
                                        C1541c2.b(th2, "ofm", "dlo");
                                    }
                                }
                                return bArrF.length;
                            }
                            c02 = c0B;
                        }
                        try {
                            c0B.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                        return -1;
                    } catch (Throwable th4) {
                        th = th4;
                        c02 = c0B;
                        try {
                            C1541c2.b(th, "leg", "uts");
                            if (c02 != null) {
                                c02.close();
                            }
                            return -1;
                        } catch (Throwable th5) {
                            if (c02 != null) {
                                try {
                                    c02.close();
                                } catch (Throwable th6) {
                                    th6.printStackTrace();
                                }
                            }
                            throw th5;
                        }
                    }
                }
            } catch (Throwable th7) {
                th = th7;
            }
            if (c02 != null) {
                c02.close();
            }
        } catch (Throwable th8) {
            th8.printStackTrace();
        }
        return -1;
    }

    public static K2 b(WeakReference<K2> weakReference) {
        return (K2) new WeakReference(new K2()).get();
    }

    public static String c(Context context, C1569j2 c1569j2) {
        StringBuilder sb2 = new StringBuilder();
        try {
            String str = S0.f16312a;
            sb2.append("\"sim\":\"");
            sb2.append("");
            sb2.append("\",\"sdkversion\":\"");
            sb2.append(c1569j2.d());
            sb2.append("\",\"product\":\"");
            sb2.append(c1569j2.g());
            sb2.append("\",\"ed\":\"");
            sb2.append(c1569j2.a());
            sb2.append("\",\"nt\":\"");
            sb2.append(S0.v(context));
            sb2.append("\",\"np\":\"");
            sb2.append(S0.w(context));
            sb2.append("\",\"mnc\":\"");
            sb2.append("");
            sb2.append("\",\"ant\":\"");
            sb2.append(S0.u(context));
            sb2.append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb2.toString();
    }

    public static void d(Context context, K2 k22, String str, int i10, int i11, String str2) {
        k22.f16161a = D1.a(context, str);
        k22.f16164d = i10;
        k22.f16162b = i11;
        k22.f16163c = str2;
    }

    public static void e(String str, byte[] bArr, K2 k22) throws Throwable {
        C0 c0B;
        boolean zExists;
        OutputStream outputStreamB = null;
        try {
            try {
                zExists = new File(k22.f16161a, str + ".0").exists();
            } catch (Throwable th) {
                C1541c2.b(th, "leg", "fet");
                zExists = false;
            }
            if (zExists) {
                return;
            }
            File file = new File(k22.f16161a);
            if (!file.exists()) {
                file.mkdirs();
            }
            c0B = C0.b(file, 1, 1, k22.f16162b);
            try {
                c0B.i(k22.f16164d);
                byte[] bArrB = k22.f16165e.b(bArr);
                C0.d dVarJ = c0B.J(str);
                outputStreamB = dVarJ.b(0);
                outputStreamB.write(bArrB);
                dVarJ.d();
                c0B.f1();
                try {
                    outputStreamB.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                try {
                    c0B.close();
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            } catch (Throwable th4) {
                th = th4;
                if (outputStreamB != null) {
                    try {
                        outputStreamB.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                if (c0B == null) {
                    throw th;
                }
                try {
                    c0B.close();
                    throw th;
                } catch (Throwable th6) {
                    th6.printStackTrace();
                    throw th;
                }
            }
        } catch (Throwable th7) {
            th = th7;
            c0B = null;
        }
    }

    public static byte[] f(C0 c02, K2 k22, List<String> list) {
        try {
            File fileK1 = c02.k1();
            if (fileK1 != null && fileK1.exists()) {
                int length = 0;
                for (String str : fileK1.list()) {
                    if (str.contains(".0")) {
                        String str2 = str.split("\\.")[0];
                        byte[] bArrG = g(c02, str2);
                        length += bArrG.length;
                        list.add(str2);
                        if (length > k22.f16166f.a()) {
                            break;
                        }
                        k22.f16167g.a(bArrG);
                    }
                }
                if (length <= 0) {
                    return null;
                }
                return k22.f16167g.b();
            }
        } catch (Throwable th) {
            C1541c2.b(th, "leg", "gCo");
        }
        return new byte[0];
    }

    public static byte[] g(C0 c02, String str) {
        C0.e eVarE0;
        byte[] bArr = new byte[0];
        InputStream inputStream = null;
        try {
            eVarE0 = c02.e0(str);
            if (eVarE0 != null) {
                try {
                    InputStream inputStreamB = eVarE0.b(0);
                    if (inputStreamB != null) {
                        bArr = new byte[inputStreamB.available()];
                        inputStreamB.read(bArr);
                        try {
                            inputStreamB.close();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        try {
                            eVarE0.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                        return bArr;
                    }
                    if (inputStreamB != null) {
                        try {
                            inputStreamB.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                    try {
                        eVarE0.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        C1541c2.b(th, "sui", "rdS");
                        if (0 != 0) {
                            try {
                                inputStream.close();
                            } catch (Throwable th6) {
                                th6.printStackTrace();
                            }
                        }
                        if (eVarE0 != null) {
                            try {
                                eVarE0.close();
                            } catch (Throwable th7) {
                                th7.printStackTrace();
                            }
                        }
                        return bArr;
                    } finally {
                    }
                }
            } else if (eVarE0 != null) {
                try {
                    eVarE0.close();
                    return bArr;
                } catch (Throwable th8) {
                    th8.printStackTrace();
                }
            }
            return bArr;
        } catch (Throwable th9) {
            th = th9;
            eVarE0 = null;
        }
    }
}
