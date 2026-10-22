package coil.fetch;

import A1.k;
import F1.j;
import La.D;
import La.H;
import Mb.AbstractC0971i;
import Mb.InterfaceC0968f;
import Mb.u;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import coil.decode.DataSource;
import coil.disk.a;
import coil.fetch.f;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import tb.AbstractC5531D;
import tb.C5528A;
import tb.C5530C;
import tb.C5537d;
import tb.InterfaceC5538e;
import tb.x;
import z1.C6053c;
import z1.C6054d;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u00024\u0010B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J5\u0010 \u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0082@¢\u0006\u0004\b$\u0010%J\u001f\u0010&\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b&\u0010'J\u0015\u0010(\u001a\u0004\u0018\u00010\u001e*\u00020\u0016H\u0002¢\u0006\u0004\b(\u0010)J\u0013\u0010+\u001a\u00020**\u00020\u0016H\u0002¢\u0006\u0004\b+\u0010,J\u0013\u0010.\u001a\u00020**\u00020-H\u0002¢\u0006\u0004\b.\u0010/J\u0013\u00101\u001a\u000200*\u00020\u001cH\u0002¢\u0006\u0004\b1\u00102R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u00103R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u00106R\u001c\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00106R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010;\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u0010:R\u0014\u0010>\u001a\u00020<8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b8\u0010=¨\u0006?"}, d2 = {"Lcoil/fetch/HttpUriFetcher;", "Lcoil/fetch/f;", "", "url", "LA1/k;", "options", "LY8/h;", "Ltb/e$a;", "callFactory", "Lcoil/disk/a;", "diskCache", "", "respectCacheHeaders", "<init>", "(Ljava/lang/String;LA1/k;LY8/h;LY8/h;Z)V", "Lw1/b;", Const.INTENT_KEY_APIKEY, "(Le9/c;)Ljava/lang/Object;", "Ltb/x;", "contentType", "f", "(Ljava/lang/String;Ltb/x;)Ljava/lang/String;", "Lcoil/disk/a$c;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Lcoil/disk/a$c;", "snapshot", "Ltb/A;", "request", "Ltb/C;", UxipConstants.f30685x, "Lz1/c;", "cacheResponse", "n", "(Lcoil/disk/a$c;Ltb/A;Ltb/C;Lz1/c;)Lcoil/disk/a$c;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ltb/A;", "c", "(Ltb/A;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ltb/A;Ltb/C;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcoil/disk/a$c;)Lz1/c;", "Lcoil/decode/e;", "l", "(Lcoil/disk/a$c;)Lcoil/decode/e;", "Ltb/D;", "m", "(Ltb/D;)Lcoil/decode/e;", "Lcoil/decode/DataSource;", "k", "(Ltb/C;)Lcoil/decode/DataSource;", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "LA1/k;", "LY8/h;", Const.INTENT_KEY_UMID, "e", "Z", "()Ljava/lang/String;", "diskCacheKey", "LMb/i;", "()LMb/i;", "fileSystem", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HttpUriFetcher implements f {

    /* renamed from: g, reason: collision with root package name */
    public static final C5537d f15658g = new C5537d.a().k().l().a();

    /* renamed from: h, reason: collision with root package name */
    public static final C5537d f15659h = new C5537d.a().k().m().a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String url;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final k options;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<InterfaceC5538e.a> callFactory;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<coil.disk.a> diskCache;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final boolean respectCacheHeaders;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0017R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcoil/fetch/HttpUriFetcher$b;", "Lcoil/fetch/f$a;", "Landroid/net/Uri;", "LY8/h;", "Ltb/e$a;", "callFactory", "Lcoil/disk/a;", "diskCache", "", "respectCacheHeaders", "<init>", "(LY8/h;LY8/h;Z)V", "data", "c", "(Landroid/net/Uri;)Z", "LA1/k;", "options", "Lcoil/c;", "imageLoader", "Lcoil/fetch/f;", Const.INTENT_KEY_PKGNAME, "(Landroid/net/Uri;LA1/k;Lcoil/c;)Lcoil/fetch/f;", Const.INTENT_KEY_APIKEY, "LY8/h;", "Z", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements f.a<Uri> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Y8.h<InterfaceC5538e.a> callFactory;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final Y8.h<coil.disk.a> diskCache;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final boolean respectCacheHeaders;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Y8.h<? extends InterfaceC5538e.a> hVar, Y8.h<? extends coil.disk.a> hVar2, boolean z10) {
            this.callFactory = hVar;
            this.diskCache = hVar2;
            this.respectCacheHeaders = z10;
        }

        private final boolean c(Uri data) {
            return p.d(data.getScheme(), "http") || p.d(data.getScheme(), "https");
        }

        @Override // coil.fetch.f.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public f a(Uri data, k options, coil.c imageLoader) {
            if (c(data)) {
                return new HttpUriFetcher(data.toString(), options, this.callFactory, this.diskCache, this.respectCacheHeaders);
            }
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpUriFetcher(String str, k kVar, Y8.h<? extends InterfaceC5538e.a> hVar, Y8.h<? extends coil.disk.a> hVar2, boolean z10) {
        this.url = str;
        this.options = kVar;
        this.callFactory = hVar;
        this.diskCache = hVar2;
        this.respectCacheHeaders = z10;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|2|(2:4|(1:6)(1:7))(0)|8|85|(3:(1:(1:(7:12|86|13|69|91|70|71)(2:17|18))(3:19|20|21))(5:24|(4:26|(2:31|32)|33|(2:35|(2:39|40))(4:41|(1:43)|44|45))(1:46)|47|(1:49)|67)|90|(4:53|(1:55)|59|60)(2:61|(2:63|64)(3:65|(5:68|69|91|70|71)|67)))|50|88|51|(2:(0)|(1:84))) */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01a8, code lost:
    
        r12 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01a9, code lost:
    
        r1 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v11 */
    @Override // coil.fetch.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(e9.InterfaceC4014c<? super w1.b> r12) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 439
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.fetch.HttpUriFetcher.a(e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(tb.C5528A r5, e9.InterfaceC4014c<? super tb.C5530C> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof coil.fetch.HttpUriFetcher$executeNetworkRequest$1
            if (r0 == 0) goto L13
            r0 = r6
            coil.fetch.HttpUriFetcher$executeNetworkRequest$1 r0 = (coil.fetch.HttpUriFetcher$executeNetworkRequest$1) r0
            int r1 = r0.f15670c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15670c = r1
            goto L18
        L13:
            coil.fetch.HttpUriFetcher$executeNetworkRequest$1 r0 = new coil.fetch.HttpUriFetcher$executeNetworkRequest$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f15668a
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f15670c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r6)
            goto L72
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r6)
            boolean r6 = F1.j.r()
            if (r6 == 0) goto L5d
            A1.k r6 = r4.options
            coil.request.CachePolicy r6 = r6.getNetworkCachePolicy()
            boolean r6 = r6.getReadEnabled()
            if (r6 != 0) goto L57
            Y8.h<tb.e$a> r4 = r4.callFactory
            java.lang.Object r4 = r4.getValue()
            tb.e$a r4 = (tb.InterfaceC5538e.a) r4
            tb.e r4 = r4.a(r5)
            tb.C r4 = r4.execute()
            goto L75
        L57:
            android.os.NetworkOnMainThreadException r4 = new android.os.NetworkOnMainThreadException
            r4.<init>()
            throw r4
        L5d:
            Y8.h<tb.e$a> r4 = r4.callFactory
            java.lang.Object r4 = r4.getValue()
            tb.e$a r4 = (tb.InterfaceC5538e.a) r4
            tb.e r4 = r4.a(r5)
            r0.f15670c = r3
            java.lang.Object r6 = F1.b.a(r4, r0)
            if (r6 != r1) goto L72
            return r1
        L72:
            r4 = r6
            tb.C r4 = (tb.C5530C) r4
        L75:
            boolean r5 = r4.getIsSuccessful()
            if (r5 != 0) goto L92
            int r5 = r4.getCode()
            r6 = 304(0x130, float:4.26E-43)
            if (r5 == r6) goto L92
            tb.D r5 = r4.getBody()
            if (r5 == 0) goto L8c
            F1.j.d(r5)
        L8c:
            coil.network.HttpException r5 = new coil.network.HttpException
            r5.<init>(r4)
            throw r5
        L92:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.fetch.HttpUriFetcher.c(tb.A, e9.c):java.lang.Object");
    }

    public final String d() {
        String diskCacheKey = this.options.getDiskCacheKey();
        return diskCacheKey == null ? this.url : diskCacheKey;
    }

    public final AbstractC0971i e() {
        coil.disk.a value = this.diskCache.getValue();
        p.f(value);
        return value.getFileSystem();
    }

    public final String f(String url, x contentType) {
        String strJ;
        String mediaType = contentType != null ? contentType.getMediaType() : null;
        if ((mediaType == null || D.X(mediaType, com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30839B, false, 2, null)) && (strJ = j.j(MimeTypeMap.getSingleton(), url)) != null) {
            return strJ;
        }
        if (mediaType != null) {
            return H.w1(mediaType, ';', null, 2, null);
        }
        return null;
    }

    public final boolean g(C5528A request, C5530C response) {
        if (this.options.getDiskCachePolicy().getWriteEnabled()) {
            return !this.respectCacheHeaders || C6054d.INSTANCE.b(request, response);
        }
        return false;
    }

    public final C5528A h() {
        C5528A.a aVarM = new C5528A.a().t(this.url).m(this.options.getHeaders());
        for (Map.Entry<Class<?>, Object> entry : this.options.getTags().a().entrySet()) {
            Class<?> key = entry.getKey();
            p.g(key, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
            aVarM.r(key, entry.getValue());
        }
        boolean readEnabled = this.options.getDiskCachePolicy().getReadEnabled();
        boolean readEnabled2 = this.options.getNetworkCachePolicy().getReadEnabled();
        if (!readEnabled2 && readEnabled) {
            aVarM.c(C5537d.f42164p);
        } else if (!readEnabled2 || readEnabled) {
            if (!readEnabled2 && !readEnabled) {
                aVarM.c(f15659h);
            }
        } else if (this.options.getDiskCachePolicy().getWriteEnabled()) {
            aVarM.c(C5537d.f42163o);
        } else {
            aVarM.c(f15658g);
        }
        return aVarM.b();
    }

    public final a.c i() {
        coil.disk.a value;
        if (!this.options.getDiskCachePolicy().getReadEnabled() || (value = this.diskCache.getValue()) == null) {
            return null;
        }
        return value.b(d());
    }

    public final C6053c j(a.c cVar) throws Throwable {
        Throwable th;
        C6053c c6053c;
        try {
            InterfaceC0968f interfaceC0968fC = u.c(e().v0(cVar.getMetadata()));
            try {
                c6053c = new C6053c(interfaceC0968fC);
                if (interfaceC0968fC != null) {
                    try {
                        interfaceC0968fC.close();
                        th = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    th = null;
                }
            } catch (Throwable th3) {
                if (interfaceC0968fC != null) {
                    try {
                        interfaceC0968fC.close();
                    } catch (Throwable th4) {
                        Y8.d.a(th3, th4);
                    }
                }
                th = th3;
                c6053c = null;
            }
            if (th == null) {
                return c6053c;
            }
            throw th;
        } catch (IOException unused) {
            return null;
        }
    }

    public final DataSource k(C5530C c5530c) {
        return c5530c.getNetworkResponse() != null ? DataSource.NETWORK : DataSource.DISK;
    }

    public final coil.decode.e l(a.c cVar) {
        return coil.decode.f.g(cVar.getData(), e(), d(), cVar);
    }

    public final coil.decode.e m(AbstractC5531D abstractC5531D) {
        return coil.decode.f.e(abstractC5531D.getSource(), this.options.getContext());
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00bc A[Catch: all -> 0x007f, Exception -> 0x0082, TRY_LEAVE, TryCatch #9 {Exception -> 0x0082, blocks: (B:15:0x002b, B:18:0x0036, B:70:0x00f0, B:38:0x0089, B:31:0x007b, B:39:0x008a, B:55:0x00bc, B:73:0x00f8, B:68:0x00eb, B:74:0x00f9, B:52:0x00b6), top: B:97:0x002b, outer: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f9 A[Catch: all -> 0x007f, Exception -> 0x0082, TRY_LEAVE, TryCatch #9 {Exception -> 0x0082, blocks: (B:15:0x002b, B:18:0x0036, B:70:0x00f0, B:38:0x0089, B:31:0x007b, B:39:0x008a, B:55:0x00bc, B:73:0x00f8, B:68:0x00eb, B:74:0x00f9, B:52:0x00b6), top: B:97:0x002b, outer: #10 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final coil.disk.a.c n(coil.disk.a.c r5, tb.C5528A r6, tb.C5530C r7, z1.C6053c r8) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.fetch.HttpUriFetcher.n(coil.disk.a$c, tb.A, tb.C, z1.c):coil.disk.a$c");
    }
}
