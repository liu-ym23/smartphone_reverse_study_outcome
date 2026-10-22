package x3;

import c5.z;
import com.stepos.stepclaw.SecurePrefs;
import io.ktor.utils.io.o;
import io.ktor.utils.io.p;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import k4.q;
import k4.x;
import k4.y;
import p5.l;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f5.h f6254a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f4.d f6255b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u4.d f6256c;

    public /* synthetic */ b(f5.h hVar, f4.d dVar, n4.e eVar, u4.d dVar2) {
        this.f6254a = hVar;
        this.f6255b = dVar;
        this.f6256c = dVar2;
    }

    @Override // p5.l
    public final Object invoke(Object obj) throws IOException {
        y yVar;
        BufferedInputStream bufferedInputStream;
        p cVar;
        InputStream inputStream;
        String lowerCase;
        HttpURLConnection current = (HttpURLConnection) obj;
        kotlin.jvm.internal.p.e(current, "current");
        int responseCode = current.getResponseCode();
        String responseMessage = current.getResponseMessage();
        if (responseMessage != null) {
            yVar = new y(responseCode, responseMessage);
        } else {
            y yVar2 = (y) y.f3650k.get(Integer.valueOf(responseCode));
            if (yVar2 == null) {
                yVar2 = new y(responseCode, "Unknown Status Code");
            }
            yVar = yVar2;
        }
        y yVar3 = yVar;
        f5.h callContext = this.f6254a;
        kotlin.jvm.internal.p.e(callContext, "callContext");
        if (c5.l.S(new Integer[]{Integer.valueOf(y.f3647g.f3651a), Integer.valueOf(y.f3644c.f3651a)}).contains(Integer.valueOf(responseCode))) {
            p.f3226a.getClass();
            cVar = o.f3223b;
        } else {
            BufferedInputStream bufferedInputStream2 = null;
            try {
                inputStream = current.getInputStream();
            } catch (IOException unused) {
                InputStream errorStream = current.getErrorStream();
                if (errorStream != null) {
                    if (errorStream instanceof BufferedInputStream) {
                        bufferedInputStream = (BufferedInputStream) errorStream;
                    } else {
                        bufferedInputStream2 = new BufferedInputStream(errorStream, 8192);
                    }
                }
            }
            if (inputStream != null) {
                if (inputStream instanceof BufferedInputStream) {
                    bufferedInputStream = (BufferedInputStream) inputStream;
                    bufferedInputStream2 = bufferedInputStream;
                } else {
                    bufferedInputStream2 = new BufferedInputStream(inputStream, 8192);
                }
            }
            if (bufferedInputStream2 != null) {
                a5.c pool = s4.a.f5238a;
                kotlin.jvm.internal.p.e(pool, "pool");
                cVar = new z4.c(new j6.b(bufferedInputStream2), callContext);
            } else {
                p.f3226a.getClass();
                cVar = o.f3223b;
            }
        }
        p pVar = cVar;
        Map<String, List<String>> headerFields = current.getHeaderFields();
        kotlin.jvm.internal.p.d(headerFields, "getHeaderFields(...)");
        LinkedHashMap linkedHashMap = new LinkedHashMap(z.T(headerFields.size()));
        Iterator<T> it = headerFields.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            if (str != null) {
                Locale locale = Locale.getDefault();
                kotlin.jvm.internal.p.d(locale, "getDefault(...)");
                lowerCase = str.toLowerCase(locale);
                kotlin.jvm.internal.p.d(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            }
            linkedHashMap.put(lowerCase, entry.getValue());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            if (!n.t1((CharSequence) entry2.getKey())) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        q qVar = new q(linkedHashMap2);
        if (this.f6255b.f2600f.d(f4.e.f2602a) == null) {
            return new f4.g(yVar3, this.f6256c, qVar, x.d, pVar, callContext);
        }
        throw new ClassCastException();
    }
}
