package com.amap.api.col.jmsl;

import android.content.Context;
import android.util.Log;
import android.webkit.WebResourceResponse;
import com.amap.api.col.jmsl.C1551f0;
import com.amap.api.col.jmsl.R2;
import com.amap.api.maps.AMapCallback;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.amap.api.col.jmsl.w0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1618w0 {

    /* renamed from: b, reason: collision with root package name */
    public H f17007b;

    /* renamed from: c, reason: collision with root package name */
    public H f17008c;

    /* renamed from: h, reason: collision with root package name */
    public RunnableC1587o0 f17013h;

    /* renamed from: i, reason: collision with root package name */
    public Context f17014i;

    /* renamed from: a, reason: collision with root package name */
    public R2 f17006a = null;

    /* renamed from: d, reason: collision with root package name */
    public String f17009d = null;

    /* renamed from: e, reason: collision with root package name */
    public String f17010e = null;

    /* renamed from: f, reason: collision with root package name */
    public boolean f17011f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f17012g = false;

    /* renamed from: com.amap.api.col.jmsl.w0$a */
    public class a implements AMapCallback<C1551f0.a> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f17015a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AMapCallback f17016b;

        public a(int i10, AMapCallback aMapCallback) {
            this.f17015a = i10;
            this.f17016b = aMapCallback;
        }

        public final void a(boolean z10) {
            AMapCallback aMapCallback = this.f17016b;
            if (aMapCallback != null) {
                aMapCallback.onCallback(Boolean.valueOf(z10));
            }
        }

        @Override // com.amap.api.maps.AMapCallback
        public void onCallback(C1551f0.a aVar) throws IOException {
            C1551f0.a aVar2 = aVar;
            if (C1623x1.f17030a) {
                C1570k.i("JAVA-JS数据下载完成");
            }
            C1618w0.this.getClass();
            if (aVar2 == null || aVar2.f16623a == null) {
                a(false);
                return;
            }
            if (C1623x1.f17030a) {
                r.f(111, "start unzip new js file ");
            }
            Map<String, byte[]> mapA = P.a(aVar2.f16623a, null);
            if (mapA == null || mapA.size() == 0) {
                if (C1623x1.f17030a) {
                    r.f(112, "js file is null, when udpate js file!!");
                }
                a(false);
                return;
            }
            int i10 = this.f17015a;
            if (i10 == 0) {
                C1618w0.f(C1618w0.this);
            } else if (i10 == 1) {
                C1618w0.f(C1618w0.this);
                C1618w0.k(C1618w0.this);
            }
            if (C1623x1.f17030a) {
                r.f(111, "clear cache finish!! reason " + this.f17015a);
            }
            Iterator<String> it = mapA.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                C1618w0.this.getClass();
                byte[] bArr = mapA.get(next);
                if (bArr != null) {
                    if (!next.startsWith("/")) {
                        next = "/" + next;
                    }
                    if (C1623x1.f17030a) {
                        r.f(111, "save new js file " + next + " len " + bArr.length);
                    }
                    C1618w0.this.f17007b.c(next, bArr);
                }
            }
            C1618w0.this.getClass();
            String str = aVar2.f16624b;
            if (str != null) {
                String strA = L1.a(str);
                C1618w0.this.f17007b.b("js-version", str);
                C1618w0.this.f17007b.b("js-version-md5", strA);
                if (C1623x1.f17030a) {
                    r.f(111, "save new js version " + str + " verMd5 " + strA);
                }
            }
            if (C1623x1.f17030a) {
                C1570k.i("JAVA-JS数据解压更新完成");
            }
            a(true);
        }
    }

    public C1618w0(Context context, File file, long j10, int i10) {
        this.f17014i = context;
        try {
            this.f17007b = H.a(new File(file, "jsFileCache"), j10, i10);
            this.f17008c = H.a(new File(file, "jsDataCache"), j10, i10);
        } catch (Exception e10) {
            Log.i("mapcore", "HTTP response cache installation failed:" + e10);
        }
    }

    public static void f(C1618w0 c1618w0) {
        H h10 = c1618w0.f17007b;
        if (h10 != null) {
            h10.e();
        }
    }

    public static void k(C1618w0 c1618w0) {
        H h10 = c1618w0.f17008c;
        if (h10 != null) {
            h10.e();
        }
    }

    public final WebResourceResponse a(H h10, String str) throws Throwable {
        String str2;
        if (str != null && h10 != null) {
            String strH = h10.h(str);
            String str3 = "";
            if (strH == null) {
                byte[] bArrF = h10.f(str);
                if (bArrF != null) {
                    return new WebResourceResponse("", "", new ByteArrayInputStream(bArrF));
                }
                return null;
            }
            String[] strArrSplit = strH.split("_--_--_--_");
            if (strArrSplit.length == 2) {
                String str4 = strArrSplit[0];
                str2 = strArrSplit[1];
                if (str4.equals("_")) {
                    str4 = "";
                }
                if (str2.equals("_")) {
                    str2 = "";
                }
                str3 = str4;
            } else {
                str2 = "";
            }
            byte[] bArrF2 = h10.f(d(str, str3, str2));
            if (bArrF2 != null) {
                return new WebResourceResponse(str3, str2, new ByteArrayInputStream(bArrF2));
            }
        }
        return null;
    }

    public WebResourceResponse b(String str) {
        return a(this.f17008c, str);
    }

    public WebResourceResponse c(String str, String str2, String str3, String str4) throws Throwable {
        boolean z10;
        R2.b bVarA;
        if (this.f17012g) {
            z10 = this.f17011f;
        } else {
            e();
            j();
            String str5 = this.f17010e;
            if (str5 == null) {
                z10 = true;
            } else {
                int iA = C1570k.a(this.f17009d, str5);
                this.f17011f = iA >= 0;
                this.f17012g = true;
                if (C1623x1.f17030a) {
                    r.f(111, "version assets " + this.f17009d + " fileCacheVersion " + this.f17010e);
                    r.f(111, "isNeedUseAssets checkflag " + iA + " isNeedUseAssets " + this.f17011f);
                }
                z10 = this.f17011f;
            }
        }
        if (!z10) {
            return a(this.f17007b, str2);
        }
        R2 r22 = this.f17006a;
        if (r22 == null || (bVarA = r22.a(str, str2, str3, str4)) == null) {
            return null;
        }
        if (str3 == null) {
            str3 = bVarA.f16305b;
        }
        if (str4 == null) {
            str4 = bVarA.f16306c;
        }
        return new WebResourceResponse(str3, str4, new ByteArrayInputStream(bVarA.f16304a));
    }

    public final String d(String str, String str2, String str3) {
        if (str2 == null) {
            str2 = "_";
        }
        if (str3 == null) {
            str3 = "";
        }
        return str + str2 + str3;
    }

    public final void e() {
        R2 r22;
        R2.b bVarA;
        byte[] bArr;
        if (this.f17009d != null || (r22 = this.f17006a) == null || (bVarA = r22.a("js-version", "js-version", null, null)) == null || (bArr = bVarA.f16304a) == null) {
            return;
        }
        String str = new String(bArr);
        this.f17009d = str;
        this.f17009d = str.trim();
    }

    public void g(R2 r22) {
        this.f17006a = r22;
    }

    public void h(String str, String str2, int i10, AMapCallback<Boolean> aMapCallback) throws Throwable {
        if (str == null) {
            if (aMapCallback != null) {
                aMapCallback.onCallback(Boolean.FALSE);
                return;
            }
            return;
        }
        e();
        j();
        boolean z10 = C1570k.a(str, this.f17009d) > 0 && C1570k.a(str, this.f17010e) > 0;
        if (C1623x1.f17030a) {
            r.f(111, "updateJsVersion  version " + str + " assetsJsVersion " + this.f17009d + " fileCacheVersion " + this.f17010e);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("updateJsVersion needUpdate ");
            sb2.append(z10);
            r.f(111, sb2.toString());
        }
        if (!z10) {
            if (aMapCallback != null) {
                aMapCallback.onCallback(Boolean.FALSE);
                return;
            }
            return;
        }
        RunnableC1587o0 runnableC1587o0 = this.f17013h;
        if (runnableC1587o0 != null) {
            runnableC1587o0.a();
        }
        if (C1623x1.f17030a) {
            r.f(111, "start download new js version " + str2);
            r.f(111, "clean js cache reason " + i10);
        }
        RunnableC1587o0 runnableC1587o02 = new RunnableC1587o0(this.f17014i, new a(i10, aMapCallback), str2, str);
        this.f17013h = runnableC1587o02;
        C1534b.a().b(runnableC1587o02);
    }

    public void i(String str, String str2, String str3, byte[] bArr) throws IOException {
        if (str == null || bArr == null || this.f17008c == null) {
            return;
        }
        this.f17008c.b(str, (str2 == null ? "_" : str2) + "_--_--_--_" + (str3 != null ? str3 : "_"));
        this.f17008c.c(d(str, str2, str3), bArr);
    }

    public final void j() throws Throwable {
        H h10;
        if (this.f17010e != null || (h10 = this.f17007b) == null) {
            return;
        }
        String strH = h10.h("js-version-md5");
        String strH2 = this.f17007b.h("js-version");
        if (strH2 != null) {
            strH2 = strH2.replace("\n", "").trim();
        }
        String strA = L1.a(strH2);
        if (strH == null || !strH.equals(strA)) {
            this.f17010e = "0.0.0";
        } else {
            this.f17010e = strH2;
        }
    }
}
