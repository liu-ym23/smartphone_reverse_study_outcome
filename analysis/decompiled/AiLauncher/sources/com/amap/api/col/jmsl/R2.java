package com.amap.api.col.jmsl;

import android.content.Context;
import android.graphics.Bitmap;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.zyql.ai.selector.config.PictureMimeType;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/* loaded from: classes.dex */
public class R2 {

    /* renamed from: b, reason: collision with root package name */
    public final String f16301b;

    /* renamed from: d, reason: collision with root package name */
    public final Context f16303d;

    /* renamed from: a, reason: collision with root package name */
    public HashMap<String, b> f16300a = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public final String f16302c = "map_assets";

    public class a extends b {
        public a(R2 r22, byte[] bArr, String str, String str2, int i10, int i11) {
            super(r22, bArr, str, str2);
        }
    }

    public class b {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f16304a;

        /* renamed from: b, reason: collision with root package name */
        public String f16305b;

        /* renamed from: c, reason: collision with root package name */
        public String f16306c;

        public b(R2 r22, byte[] bArr, String str, String str2) {
            this.f16304a = bArr;
            this.f16305b = str;
            this.f16306c = str2;
        }
    }

    public R2(Context context) {
        this.f16301b = context.getCacheDir() + File.separator + "amap_web_res";
        this.f16303d = context;
    }

    public b a(String str, String str2, String str3, String str4) throws Throwable {
        b bVar;
        if (str == null) {
            return null;
        }
        String strReplace = str.replace("file:///android_asset/", "");
        synchronized (this) {
            try {
                if (this.f16300a.containsKey(strReplace)) {
                    return this.f16300a.get(strReplace);
                }
                if (strReplace.contains("localhost_amap_bimap")) {
                    synchronized (this) {
                        bVar = this.f16300a.get(strReplace);
                    }
                    return bVar;
                }
                if (str3 == null && str4 == null) {
                    str3 = strReplace.contains("png") ? PictureMimeType.PNG_Q : strReplace.contains("/maps") ? "application/javascript;charset=utf-8" : "";
                    str4 = (strReplace.contains("png") || strReplace.contains("/maps")) ? "gzip" : "";
                }
                if (str2 == null) {
                    try {
                        str2 = new URL(strReplace).getPath();
                    } catch (MalformedURLException e10) {
                        e10.printStackTrace();
                        str2 = null;
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f16301b);
                String str5 = File.separator;
                sb2.append(str5);
                sb2.append(str2);
                byte[] bArrS = C1570k.s(sb2.toString().replace("//", "/"));
                if (bArrS == null) {
                    bArrS = C1570k.p(this.f16303d, (this.f16302c + str5 + str2).replace("//", "/"));
                }
                if (bArrS != null) {
                    return new b(this, bArrS, str3, str4);
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(BitmapDescriptor bitmapDescriptor) {
        R2 r22;
        if (bitmapDescriptor == null) {
            return;
        }
        try {
            String id = bitmapDescriptor.getId();
            if (this.f16300a.containsKey(id)) {
                return;
            }
            try {
                synchronized (this) {
                    try {
                        if (this.f16300a.containsKey(id)) {
                            r22 = this;
                        } else {
                            Bitmap bitmap = bitmapDescriptor.getBitmap();
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                            r22 = this;
                            this.f16300a.put(id, new a(r22, byteArrayOutputStream.toByteArray(), PictureMimeType.PNG_Q, "", bitmap.getWidth(), bitmap.getHeight()));
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
            throw th;
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public void c(String str) {
        R2 r22;
        try {
            if (this.f16300a.containsKey(str)) {
                return;
            }
            try {
                synchronized (this) {
                    try {
                        if (this.f16300a.containsKey(str) || !"localhost_amap_bimap:default_marker".equals(str)) {
                            r22 = this;
                        } else {
                            Bitmap bitmap = BitmapDescriptorFactory.defaultMarker().getBitmap();
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                            r22 = this;
                            this.f16300a.put(str, new a(r22, byteArrayOutputStream.toByteArray(), PictureMimeType.PNG_Q, "", bitmap.getWidth(), bitmap.getHeight()));
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
            throw th;
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }
}
