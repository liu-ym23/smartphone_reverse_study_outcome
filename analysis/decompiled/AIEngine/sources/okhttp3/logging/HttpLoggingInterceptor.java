package okhttp3.logging;

import ad.k;
import ad.l;
import ad.s;
import ad.t;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.core.ota.d;
import ed.g;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import jd.b;
import kotlin.collections.EmptySet;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.f;
import okhttp3.h;
import sd.e;
import sd.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class HttpLoggingInterceptor implements k {

    /* renamed from: a, reason: collision with root package name */
    public final a f11302a;

    /* renamed from: b, reason: collision with root package name */
    public volatile EmptySet f11303b;

    /* renamed from: c, reason: collision with root package name */
    public volatile EmptySet f11304c;

    /* renamed from: d, reason: collision with root package name */
    public volatile Level f11305d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Level {

        /* renamed from: a, reason: collision with root package name */
        public static final Level f11306a;

        /* renamed from: b, reason: collision with root package name */
        public static final Level f11307b;

        /* renamed from: c, reason: collision with root package name */
        public static final Level f11308c;

        /* renamed from: d, reason: collision with root package name */
        public static final Level f11309d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ Level[] f11310e;

        static {
            Level level = new Level(ModelFlowMeta.PLAN_NONE, 0);
            f11306a = level;
            Level level2 = new Level("BASIC", 1);
            f11307b = level2;
            Level level3 = new Level("HEADERS", 2);
            f11308c = level3;
            Level level4 = new Level("BODY", 3);
            f11309d = level4;
            Level[] levelArr = {level, level2, level3, level4};
            f11310e = levelArr;
            kotlin.enums.a.a(levelArr);
        }

        public Level() {
            throw null;
        }

        public static Level valueOf(String str) {
            return (Level) Enum.valueOf(Level.class, str);
        }

        public static Level[] values() {
            return (Level[]) f11310e.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {

        /* renamed from: f, reason: collision with root package name */
        public static final okhttp3.logging.a f11311f = new okhttp3.logging.a();

        void c(String str);
    }

    public HttpLoggingInterceptor(a aVar) {
        this.f11302a = aVar;
        EmptySet emptySet = EmptySet.f10003a;
        this.f11303b = emptySet;
        this.f11304c = emptySet;
        this.f11305d = Level.f11306a;
    }

    public final void a(f fVar, int i10) {
        EmptySet emptySet = this.f11303b;
        fVar.b(i10);
        emptySet.getClass();
        String strG = fVar.g(i10);
        this.f11302a.c(fVar.b(i10) + ": " + strG);
    }

    @Override // ad.k
    public final Response intercept(k.a aVar) throws Exception {
        String string;
        boolean z;
        boolean z3;
        String str;
        String str2;
        String str3;
        String str4;
        Charset charsetA;
        q qVar;
        Long lValueOf;
        Charset charsetA2;
        Level level = this.f11305d;
        fd.f fVar = (fd.f) aVar;
        h hVar = fVar.f8839e;
        if (level == Level.f11306a) {
            return fVar.b(hVar);
        }
        boolean z10 = true;
        boolean z11 = level == Level.f11309d;
        if (!z11 && level != Level.f11308c) {
            z10 = false;
        }
        s sVar = hVar.f10995d;
        g gVarC = fVar.c();
        StringBuilder sb2 = new StringBuilder("--> ");
        sb2.append(hVar.f10993b);
        sb2.append(' ');
        okhttp3.g url = hVar.f10992a;
        kotlin.jvm.internal.g.f(url, "url");
        this.f11304c.getClass();
        sb2.append(url.f10984i);
        if (gVarC != null) {
            StringBuilder sb3 = new StringBuilder(" ");
            Protocol protocol = gVarC.h;
            kotlin.jvm.internal.g.c(protocol);
            sb3.append(protocol);
            string = sb3.toString();
        } else {
            string = "";
        }
        sb2.append(string);
        String string2 = sb2.toString();
        if (!z10 && sVar != null) {
            StringBuilder sbP = a0.a.p(string2, " (");
            sbP.append(sVar.contentLength());
            sbP.append("-byte body)");
            string2 = sbP.toString();
        }
        this.f11302a.c(string2);
        Long lValueOf2 = null;
        if (z10) {
            f fVar2 = hVar.f10994c;
            z = z11;
            if (sVar != null) {
                l lVarContentType = sVar.contentType();
                z3 = z10;
                if (lVarContentType == null || fVar2.a("Content-Type") != null) {
                    str = " ";
                    str2 = "url";
                } else {
                    str2 = "url";
                    str = " ";
                    this.f11302a.c("Content-Type: " + lVarContentType);
                }
                if (sVar.contentLength() != -1 && fVar2.a("Content-Length") == null) {
                    this.f11302a.c("Content-Length: " + sVar.contentLength());
                }
            } else {
                z3 = z10;
                str = " ";
                str2 = "url";
            }
            int size = fVar2.size();
            for (int i10 = 0; i10 < size; i10++) {
                a(fVar2, i10);
            }
            if (!z || sVar == null) {
                this.f11302a.c("--> END " + hVar.f10993b);
            } else {
                String strA = hVar.f10994c.a("Content-Encoding");
                if (strA != null && !strA.equalsIgnoreCase("identity") && !strA.equalsIgnoreCase("gzip")) {
                    this.f11302a.c("--> END " + hVar.f10993b + " (encoded body omitted)");
                } else if (sVar.isDuplex()) {
                    this.f11302a.c("--> END " + hVar.f10993b + " (duplex request body omitted)");
                } else if (sVar.isOneShot()) {
                    this.f11302a.c("--> END " + hVar.f10993b + " (one-shot body omitted)");
                } else {
                    e eVar = new e();
                    sVar.writeTo(eVar);
                    if ("gzip".equalsIgnoreCase(fVar2.a("Content-Encoding"))) {
                        lValueOf = Long.valueOf(eVar.f11926b);
                        qVar = new q(eVar);
                        try {
                            eVar = new e();
                            eVar.u(qVar);
                            qVar.close();
                        } finally {
                        }
                    } else {
                        lValueOf = null;
                    }
                    l lVarContentType2 = sVar.contentType();
                    if (lVarContentType2 == null || (charsetA2 = l.a(lVarContentType2)) == null) {
                        charsetA2 = gc.a.f9106b;
                    }
                    this.f11302a.c("");
                    if (!b.B(eVar)) {
                        this.f11302a.c("--> END " + hVar.f10993b + " (binary " + sVar.contentLength() + "-byte body omitted)");
                    } else if (lValueOf != null) {
                        this.f11302a.c("--> END " + hVar.f10993b + " (" + eVar.f11926b + "-byte, " + lValueOf + "-gzipped-byte body)");
                    } else {
                        this.f11302a.c(eVar.p0(charsetA2));
                        this.f11302a.c("--> END " + hVar.f10993b + " (" + sVar.contentLength() + "-byte body)");
                    }
                }
            }
        } else {
            z = z11;
            z3 = z10;
            str = " ";
            str2 = "url";
        }
        long jNanoTime = System.nanoTime();
        try {
            Response responseB = fVar.b(hVar);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
            t tVar = responseB.f10893j;
            kotlin.jvm.internal.g.c(tVar);
            long jA = tVar.a();
            String str5 = jA != -1 ? jA + "-byte" : "unknown-length";
            a aVar2 = this.f11302a;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("<-- " + responseB.f10891d);
            if (responseB.f10890c.length() > 0) {
                str3 = str;
                StringBuilder sb5 = new StringBuilder(str3);
                str4 = "-byte";
                sb5.append(responseB.f10890c);
                sb4.append(sb5.toString());
            } else {
                str3 = str;
                str4 = "-byte";
            }
            StringBuilder sb6 = new StringBuilder(str3);
            okhttp3.g gVar = responseB.f10888a.f10992a;
            kotlin.jvm.internal.g.f(gVar, str2);
            this.f11304c.getClass();
            d.p(millis, gVar.f10984i, " (", sb6);
            sb6.append("ms");
            sb4.append(sb6.toString());
            if (!z3) {
                sb4.append(", " + str5 + " body");
            }
            sb4.append(")");
            String string3 = sb4.toString();
            kotlin.jvm.internal.g.e(string3, "toString(...)");
            aVar2.c(string3);
            if (z3) {
                f fVar3 = responseB.h;
                int size2 = fVar3.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    a(fVar3, i11);
                }
                if (z && fd.e.a(responseB)) {
                    String strA2 = responseB.h.a("Content-Encoding");
                    if (strA2 != null && !strA2.equalsIgnoreCase("identity") && !strA2.equalsIgnoreCase("gzip")) {
                        this.f11302a.c("<-- END HTTP (encoded body omitted)");
                        return responseB;
                    }
                    l lVarO = responseB.f10893j.o();
                    if (lVarO != null && lVarO.f101b.equals("text") && lVarO.f102c.equals("event-stream")) {
                        this.f11302a.c("<-- END HTTP (streaming)");
                        return responseB;
                    }
                    sd.h hVarW = tVar.w();
                    hVarW.M(Long.MAX_VALUE);
                    long millis2 = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
                    e eVarC = hVarW.c();
                    if ("gzip".equalsIgnoreCase(fVar3.a("Content-Encoding"))) {
                        lValueOf2 = Long.valueOf(eVarC.f11926b);
                        qVar = new q(eVarC.clone());
                        try {
                            eVarC = new e();
                            eVarC.u(qVar);
                            qVar.close();
                        } finally {
                            try {
                                throw th;
                            } finally {
                            }
                        }
                    }
                    Long l10 = lValueOf2;
                    l lVarO2 = tVar.o();
                    if (lVarO2 == null || (charsetA = l.a(lVarO2)) == null) {
                        charsetA = gc.a.f9106b;
                    }
                    if (!b.B(eVarC)) {
                        this.f11302a.c("");
                        a aVar3 = this.f11302a;
                        StringBuilder sbQ = ai.onnxruntime.a.q(millis2, "<-- END HTTP (", "ms, binary ");
                        sbQ.append(eVarC.f11926b);
                        sbQ.append("-byte body omitted)");
                        aVar3.c(sbQ.toString());
                        return responseB;
                    }
                    if (jA != 0) {
                        this.f11302a.c("");
                        this.f11302a.c(eVarC.clone().p0(charsetA));
                    }
                    a aVar4 = this.f11302a;
                    StringBuilder sb7 = new StringBuilder();
                    StringBuilder sbQ2 = ai.onnxruntime.a.q(millis2, "<-- END HTTP (", "ms, ");
                    sbQ2.append(eVarC.f11926b);
                    sbQ2.append(str4);
                    sb7.append(sbQ2.toString());
                    if (l10 != null) {
                        sb7.append(", " + l10 + "-gzipped-byte");
                    }
                    sb7.append(" body)");
                    String string4 = sb7.toString();
                    kotlin.jvm.internal.g.e(string4, "toString(...)");
                    aVar4.c(string4);
                    return responseB;
                }
                this.f11302a.c("<-- END HTTP");
            }
            return responseB;
        } catch (Exception e10) {
            this.f11302a.c("<-- HTTP FAILED: " + e10);
            throw e10;
        }
    }

    public /* synthetic */ HttpLoggingInterceptor(int i10) {
        this(a.f11311f);
    }
}
