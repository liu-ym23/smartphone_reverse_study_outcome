package c2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.firebase.encoders.EncodingException;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import d2.AbstractC3943a;
import d2.AbstractC3949g;
import d2.AbstractC3950h;
import d2.AbstractC3951i;
import d2.AbstractC3952j;
import e2.AbstractC3981h;
import e2.C3980g;
import f2.AbstractC4050e;
import f2.k;
import h2.C4124a;
import i2.C4164b;
import j3.InterfaceC4763a;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import n2.InterfaceC4936a;

/* renamed from: c2.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1492d implements k {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC4763a f15428a;

    /* renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f15429b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f15430c;

    /* renamed from: d, reason: collision with root package name */
    public final URL f15431d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC4936a f15432e;

    /* renamed from: f, reason: collision with root package name */
    public final InterfaceC4936a f15433f;

    /* renamed from: g, reason: collision with root package name */
    public final int f15434g;

    /* renamed from: c2.d$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final URL f15435a;

        /* renamed from: b, reason: collision with root package name */
        public final AbstractC3949g f15436b;

        /* renamed from: c, reason: collision with root package name */
        public final String f15437c;

        public a(URL url, AbstractC3949g abstractC3949g, String str) {
            this.f15435a = url;
            this.f15436b = abstractC3949g;
            this.f15437c = str;
        }

        public a a(URL url) {
            return new a(url, this.f15436b, this.f15437c);
        }
    }

    /* renamed from: c2.d$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f15438a;

        /* renamed from: b, reason: collision with root package name */
        public final URL f15439b;

        /* renamed from: c, reason: collision with root package name */
        public final long f15440c;

        public b(int i10, URL url, long j10) {
            this.f15438a = i10;
            this.f15439b = url;
            this.f15440c = j10;
        }
    }

    public C1492d(Context context, InterfaceC4936a interfaceC4936a, InterfaceC4936a interfaceC4936a2, int i10) {
        this.f15428a = AbstractC3949g.b();
        this.f15430c = context;
        this.f15429b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f15431d = m(C1489a.f15418c);
        this.f15432e = interfaceC4936a2;
        this.f15433f = interfaceC4936a;
        this.f15434g = i10;
    }

    public static int e(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE.getValue();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return NetworkConnectionInfo.MobileSubtype.COMBINED.getValue();
        }
        if (NetworkConnectionInfo.MobileSubtype.forNumber(subtype) != null) {
            return subtype;
        }
        return 0;
    }

    public static int f(NetworkInfo networkInfo) {
        return networkInfo == null ? NetworkConnectionInfo.NetworkType.NONE.getValue() : networkInfo.getType();
    }

    public static int g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            C4124a.c("CctTransportBackend", "Unable to find version code for package", e10);
            return -1;
        }
    }

    public static TelephonyManager i(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    public static long j() {
        Calendar.getInstance();
        return TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
    }

    public static /* synthetic */ a k(a aVar, b bVar) {
        URL url = bVar.f15439b;
        if (url == null) {
            return null;
        }
        C4124a.a("CctTransportBackend", "Following redirect to: %s", url);
        return aVar.a(bVar.f15439b);
    }

    public static InputStream l(InputStream inputStream, String str) throws IOException {
        return "gzip".equals(str) ? new GZIPInputStream(inputStream) : inputStream;
    }

    public static URL m(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e10) {
            throw new IllegalArgumentException("Invalid url: " + str, e10);
        }
    }

    @Override // f2.k
    public BackendResponse a(AbstractC4050e abstractC4050e) {
        AbstractC3949g abstractC3949gH = h(abstractC4050e);
        URL urlM = this.f15431d;
        if (abstractC4050e.c() != null) {
            try {
                C1489a c1489aC = C1489a.c(abstractC4050e.c());
                strD = c1489aC.d() != null ? c1489aC.d() : null;
                if (c1489aC.e() != null) {
                    urlM = m(c1489aC.e());
                }
            } catch (IllegalArgumentException unused) {
                return BackendResponse.a();
            }
        }
        try {
            b bVar = (b) C4164b.a(5, new a(urlM, abstractC3949gH, strD), C1490b.a(this), C1491c.b());
            int i10 = bVar.f15438a;
            if (i10 == 200) {
                return BackendResponse.d(bVar.f15440c);
            }
            if (i10 < 500 && i10 != 404) {
                return BackendResponse.a();
            }
            return BackendResponse.e();
        } catch (IOException e10) {
            C4124a.c("CctTransportBackend", "Could not make request to the backend", e10);
            return BackendResponse.e();
        }
    }

    @Override // f2.k
    public AbstractC3981h b(AbstractC3981h abstractC3981h) {
        NetworkInfo activeNetworkInfo = this.f15429b.getActiveNetworkInfo();
        return abstractC3981h.l().a("sdk-version", Build.VERSION.SDK_INT).c(AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, Build.MODEL).c("hardware", Build.HARDWARE).c(Parameters.DEVICE, Build.DEVICE).c("product", Build.PRODUCT).c("os-uild", Build.ID).c("manufacturer", Build.MANUFACTURER).c("fingerprint", Build.FINGERPRINT).b("tz-offset", j()).a("net-type", f(activeNetworkInfo)).a("mobile-subtype", e(activeNetworkInfo)).c("country", Locale.getDefault().getCountry()).c("locale", Locale.getDefault().getLanguage()).c("mcc_mnc", i(this.f15430c).getSimOperator()).c("application_build", Integer.toString(g(this.f15430c))).d();
    }

    public final b d(a aVar) throws IOException {
        C4124a.a("CctTransportBackend", "Making request to: %s", aVar.f15435a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.f15435a.openConnection();
        httpURLConnection.setConnectTimeout(Const.I_LOC_JUMP_DELAY);
        httpURLConnection.setReadTimeout(this.f15434g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30853l, String.format("datatransport/%s android/", "2.3.3"));
        httpURLConnection.setRequestProperty(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30849h, "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = aVar.f15437c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    this.f15428a.a(aVar.f15436b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    C4124a.e("CctTransportBackend", "Status Code: " + responseCode);
                    C4124a.e("CctTransportBackend", "Content-Type: " + httpURLConnection.getHeaderField("Content-Type"));
                    C4124a.e("CctTransportBackend", "Content-Encoding: " + httpURLConnection.getHeaderField(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30849h));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new b(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream inputStreamL = l(inputStream, httpURLConnection.getHeaderField(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30849h));
                        try {
                            b bVar = new b(responseCode, null, AbstractC3952j.b(new BufferedReader(new InputStreamReader(inputStreamL))).c());
                            if (inputStreamL != null) {
                                inputStreamL.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return bVar;
                        } catch (Throwable th) {
                            if (inputStreamL != null) {
                                try {
                                    inputStreamL.close();
                                } catch (Throwable unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        throw th2;
                    }
                } catch (Throwable th3) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable unused3) {
                    }
                    throw th3;
                }
            } catch (Throwable th4) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable unused4) {
                    }
                }
                throw th4;
            }
        } catch (EncodingException | IOException e10) {
            C4124a.c("CctTransportBackend", "Couldn't encode request, returning with 400", e10);
            return new b(Const.I_TILE_TINY, null, 0L);
        } catch (ConnectException | UnknownHostException e11) {
            C4124a.c("CctTransportBackend", "Couldn't open connection, returning with 500", e11);
            return new b(500, null, 0L);
        }
    }

    public final AbstractC3949g h(AbstractC4050e abstractC4050e) {
        AbstractC3950h.a aVarJ;
        HashMap map = new HashMap();
        for (AbstractC3981h abstractC3981h : abstractC4050e.b()) {
            String strJ = abstractC3981h.j();
            if (map.containsKey(strJ)) {
                ((List) map.get(strJ)).add(abstractC3981h);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(abstractC3981h);
                map.put(strJ, arrayList);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            AbstractC3981h abstractC3981h2 = (AbstractC3981h) ((List) entry.getValue()).get(0);
            AbstractC3951i.a aVarB = AbstractC3951i.a().f(QosTier.DEFAULT).g(this.f15433f.a()).h(this.f15432e.a()).b(ClientInfo.a().c(ClientInfo.ClientType.ANDROID_FIREBASE).b(AbstractC3943a.a().m(Integer.valueOf(abstractC3981h2.g("sdk-version"))).j(abstractC3981h2.b(AlgorithmUpdateBundle.KEY_SUFFIX_MODEL)).f(abstractC3981h2.b("hardware")).d(abstractC3981h2.b(Parameters.DEVICE)).l(abstractC3981h2.b("product")).k(abstractC3981h2.b("os-uild")).h(abstractC3981h2.b("manufacturer")).e(abstractC3981h2.b("fingerprint")).c(abstractC3981h2.b("country")).g(abstractC3981h2.b("locale")).i(abstractC3981h2.b("mcc_mnc")).b(abstractC3981h2.b("application_build")).a()).a());
            try {
                aVarB.i(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                aVarB.j((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (AbstractC3981h abstractC3981h3 : (List) entry.getValue()) {
                C3980g c3980gE = abstractC3981h3.e();
                b2.b bVarB = c3980gE.b();
                if (bVarB.equals(b2.b.b("proto"))) {
                    aVarJ = AbstractC3950h.j(c3980gE.a());
                } else if (bVarB.equals(b2.b.b("json"))) {
                    aVarJ = AbstractC3950h.i(new String(c3980gE.a(), Charset.forName("UTF-8")));
                } else {
                    C4124a.f("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", bVarB);
                }
                aVarJ.c(abstractC3981h3.f()).d(abstractC3981h3.k()).h(abstractC3981h3.h("tz-offset")).e(NetworkConnectionInfo.a().c(NetworkConnectionInfo.NetworkType.forNumber(abstractC3981h3.g("net-type"))).b(NetworkConnectionInfo.MobileSubtype.forNumber(abstractC3981h3.g("mobile-subtype"))).a());
                if (abstractC3981h3.d() != null) {
                    aVarJ.b(abstractC3981h3.d());
                }
                arrayList3.add(aVarJ.a());
            }
            aVarB.c(arrayList3);
            arrayList2.add(aVarB.a());
        }
        return AbstractC3949g.a(arrayList2);
    }

    public C1492d(Context context, InterfaceC4936a interfaceC4936a, InterfaceC4936a interfaceC4936a2) {
        this(context, interfaceC4936a, interfaceC4936a2, 40000);
    }
}
