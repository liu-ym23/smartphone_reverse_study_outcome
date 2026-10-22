package coil.intercept;

import A1.g;
import A1.k;
import A1.n;
import F1.j;
import F1.m;
import F1.q;
import F1.s;
import Ua.C1056g;
import Z8.r;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.c;
import coil.decode.DataSource;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 :2\u00020\u0001:\u00022\u000fB)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J0\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0081@¢\u0006\u0004\b\u0019\u0010\u001aJ0\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0082@¢\u0006\u0004\b\u001e\u0010\u001fJ8\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0082@¢\u0006\u0004\b#\u0010$J@\u0010'\u001a\u00020\u00112\u0006\u0010&\u001a\u00020%2\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0082@¢\u0006\u0004\b'\u0010(J-\u0010/\u001a\u00020.2\u0006\u0010*\u001a\u00020)2\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002¢\u0006\u0004\b/\u00100R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u00101R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006;"}, d2 = {"Lcoil/intercept/EngineInterceptor;", "Lcoil/intercept/a;", "Lcoil/c;", "imageLoader", "LF1/s;", "systemCallbacks", "LA1/n;", "requestService", "LF1/q;", "logger", "<init>", "(Lcoil/c;LF1/s;LA1/n;LF1/q;)V", "Lcoil/intercept/a$a;", "chain", "LA1/h;", Const.INTENT_KEY_APIKEY, "(Lcoil/intercept/a$a;Le9/c;)Ljava/lang/Object;", "Lcoil/intercept/EngineInterceptor$b;", "result", "LA1/g;", "request", "LA1/k;", "options", "Lcoil/b;", "eventListener", "l", "(Lcoil/intercept/EngineInterceptor$b;LA1/g;LA1/k;Lcoil/b;Le9/c;)Ljava/lang/Object;", "", "mappedData", "_options", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(LA1/g;Ljava/lang/Object;LA1/k;Lcoil/b;Le9/c;)Ljava/lang/Object;", "Lcoil/a;", "components", "Lw1/b;", "k", "(Lcoil/a;LA1/g;Ljava/lang/Object;LA1/k;Lcoil/b;Le9/c;)Ljava/lang/Object;", "Lw1/c;", "fetchResult", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lw1/c;Lcoil/a;LA1/g;Ljava/lang/Object;LA1/k;Lcoil/b;Le9/c;)Ljava/lang/Object;", "Landroid/graphics/drawable/Drawable;", "drawable", "", "LD1/b;", "transformations", "Landroid/graphics/Bitmap;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/graphics/drawable/Drawable;LA1/k;Ljava/util/List;)Landroid/graphics/Bitmap;", "Lcoil/c;", Const.INTENT_KEY_PKGNAME, "LF1/s;", "c", "LA1/n;", "Lcoil/memory/c;", Const.INTENT_KEY_UMID, "Lcoil/memory/c;", "memoryCacheService", "e", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EngineInterceptor implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final c imageLoader;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final s systemCallbacks;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final n requestService;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final coil.memory.c memoryCacheService;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcoil/intercept/EngineInterceptor$b;", "", "Landroid/graphics/drawable/Drawable;", "drawable", "", "isSampled", "Lcoil/decode/DataSource;", "dataSource", "", "diskCacheKey", "<init>", "(Landroid/graphics/drawable/Drawable;ZLcoil/decode/DataSource;Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "(Landroid/graphics/drawable/Drawable;ZLcoil/decode/DataSource;Ljava/lang/String;)Lcoil/intercept/EngineInterceptor$b;", "Landroid/graphics/drawable/Drawable;", "e", "()Landroid/graphics/drawable/Drawable;", Const.INTENT_KEY_PKGNAME, "Z", "f", "()Z", "c", "Lcoil/decode/DataSource;", "()Lcoil/decode/DataSource;", Const.INTENT_KEY_UMID, "Ljava/lang/String;", "()Ljava/lang/String;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Drawable drawable;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final boolean isSampled;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final DataSource dataSource;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final String diskCacheKey;

        public b(Drawable drawable, boolean z10, DataSource dataSource, String str) {
            this.drawable = drawable;
            this.isSampled = z10;
            this.dataSource = dataSource;
            this.diskCacheKey = str;
        }

        public static /* synthetic */ b b(b bVar, Drawable drawable, boolean z10, DataSource dataSource, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                drawable = bVar.drawable;
            }
            if ((i10 & 2) != 0) {
                z10 = bVar.isSampled;
            }
            if ((i10 & 4) != 0) {
                dataSource = bVar.dataSource;
            }
            if ((i10 & 8) != 0) {
                str = bVar.diskCacheKey;
            }
            return bVar.a(drawable, z10, dataSource, str);
        }

        public final b a(Drawable drawable, boolean isSampled, DataSource dataSource, String diskCacheKey) {
            return new b(drawable, isSampled, dataSource, diskCacheKey);
        }

        /* renamed from: c, reason: from getter */
        public final DataSource getDataSource() {
            return this.dataSource;
        }

        /* renamed from: d, reason: from getter */
        public final String getDiskCacheKey() {
            return this.diskCacheKey;
        }

        /* renamed from: e, reason: from getter */
        public final Drawable getDrawable() {
            return this.drawable;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getIsSampled() {
            return this.isSampled;
        }
    }

    public EngineInterceptor(c cVar, s sVar, n nVar, q qVar) {
        this.imageLoader = cVar;
        this.systemCallbacks = sVar;
        this.requestService = nVar;
        this.memoryCacheService = new coil.memory.c(cVar, nVar, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // coil.intercept.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(coil.intercept.a.InterfaceC0199a r14, e9.InterfaceC4014c<? super A1.h> r15) throws java.lang.Throwable {
        /*
            r13 = this;
            boolean r0 = r15 instanceof coil.intercept.EngineInterceptor$intercept$1
            if (r0 == 0) goto L13
            r0 = r15
            coil.intercept.EngineInterceptor$intercept$1 r0 = (coil.intercept.EngineInterceptor$intercept$1) r0
            int r1 = r0.f15746e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15746e = r1
            goto L18
        L13:
            coil.intercept.EngineInterceptor$intercept$1 r0 = new coil.intercept.EngineInterceptor$intercept$1
            r0.<init>(r13, r15)
        L18:
            java.lang.Object r15 = r0.f15744c
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f15746e
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r13 = r0.f15743b
            r14 = r13
            coil.intercept.a$a r14 = (coil.intercept.a.InterfaceC0199a) r14
            java.lang.Object r13 = r0.f15742a
            coil.intercept.EngineInterceptor r13 = (coil.intercept.EngineInterceptor) r13
            kotlin.C4849c.b(r15)     // Catch: java.lang.Throwable -> L32
            return r15
        L32:
            r0 = move-exception
        L33:
            r15 = r0
            goto La7
        L36:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L3e:
            kotlin.C4849c.b(r15)
            A1.g r6 = r14.getRequest()     // Catch: java.lang.Throwable -> La3
            java.lang.Object r15 = r6.getData()     // Catch: java.lang.Throwable -> La3
            B1.g r2 = r14.getSize()     // Catch: java.lang.Throwable -> La3
            coil.b r9 = F1.j.g(r14)     // Catch: java.lang.Throwable -> La3
            A1.n r4 = r13.requestService     // Catch: java.lang.Throwable -> La3
            A1.k r8 = r4.f(r6, r2)     // Catch: java.lang.Throwable -> La3
            coil.size.Scale r4 = r8.getCom.stepos.launcher.assistant.slidepanel.ConstConfig.KEY_VIEW_SCALE_PROPERTY java.lang.String()     // Catch: java.lang.Throwable -> La3
            r9.r(r6, r15)     // Catch: java.lang.Throwable -> La3
            coil.c r5 = r13.imageLoader     // Catch: java.lang.Throwable -> La3
            coil.a r5 = r5.getComponents()     // Catch: java.lang.Throwable -> La3
            java.lang.Object r7 = r5.g(r15, r8)     // Catch: java.lang.Throwable -> La3
            r9.f(r6, r7)     // Catch: java.lang.Throwable -> La3
            coil.memory.c r15 = r13.memoryCacheService     // Catch: java.lang.Throwable -> La3
            coil.memory.MemoryCache$Key r10 = r15.f(r6, r7, r8, r9)     // Catch: java.lang.Throwable -> La3
            if (r10 == 0) goto L7a
            coil.memory.c r15 = r13.memoryCacheService     // Catch: java.lang.Throwable -> L32
            coil.memory.MemoryCache$b r15 = r15.a(r6, r10, r2, r4)     // Catch: java.lang.Throwable -> L32
            goto L7b
        L7a:
            r15 = 0
        L7b:
            if (r15 == 0) goto L84
            coil.memory.c r0 = r13.memoryCacheService     // Catch: java.lang.Throwable -> L32
            A1.o r13 = r0.g(r14, r6, r10, r15)     // Catch: java.lang.Throwable -> L32
            return r13
        L84:
            Ua.I r15 = r6.getFetcherDispatcher()     // Catch: java.lang.Throwable -> La3
            coil.intercept.EngineInterceptor$intercept$2 r4 = new coil.intercept.EngineInterceptor$intercept$2     // Catch: java.lang.Throwable -> La3
            r12 = 0
            r5 = r13
            r11 = r14
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L9e
            r0.f15742a = r5     // Catch: java.lang.Throwable -> L9e
            r0.f15743b = r11     // Catch: java.lang.Throwable -> L9e
            r0.f15746e = r3     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r13 = Ua.C1056g.j(r15, r4, r0)     // Catch: java.lang.Throwable -> L9e
            if (r13 != r1) goto L9d
            return r1
        L9d:
            return r13
        L9e:
            r0 = move-exception
            r15 = r0
            r13 = r5
            r14 = r11
            goto La7
        La3:
            r0 = move-exception
            r5 = r13
            r11 = r14
            goto L33
        La7:
            boolean r0 = r15 instanceof java.util.concurrent.CancellationException
            if (r0 != 0) goto Lb6
            A1.n r13 = r13.requestService
            A1.g r14 = r14.getRequest()
            A1.e r13 = r13.a(r14, r15)
            return r13
        Lb6:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.a(coil.intercept.a$a, e9.c):java.lang.Object");
    }

    public final Bitmap h(Drawable drawable, k options, List<? extends D1.b> transformations) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (r.R(j.o(), F1.a.c(bitmap))) {
                return bitmap;
            }
        }
        return m.f2558a.a(drawable, options.getConfig(), options.getSize(), options.getCom.stepos.launcher.assistant.slidepanel.ConstConfig.KEY_VIEW_SCALE_PROPERTY java.lang.String(), options.getAllowInexactSize());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0096 -> B:21:0x009d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(w1.c r7, coil.a r8, A1.g r9, java.lang.Object r10, A1.k r11, coil.b r12, e9.InterfaceC4014c<? super coil.intercept.EngineInterceptor.b> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.i(w1.c, coil.a, A1.g, java.lang.Object, A1.k, coil.b, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x01d0, code lost:
    
        if (r1 == r7) goto L72;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Type inference failed for: r1v13, types: [T, coil.a] */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, coil.a] */
    /* JADX WARN: Type inference failed for: r1v8, types: [A1.k, T] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(A1.g r24, java.lang.Object r25, A1.k r26, coil.b r27, e9.InterfaceC4014c<? super coil.intercept.EngineInterceptor.b> r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 519
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.j(A1.g, java.lang.Object, A1.k, coil.b, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0090 -> B:21:0x0097). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(coil.a r7, A1.g r8, java.lang.Object r9, A1.k r10, coil.b r11, e9.InterfaceC4014c<? super w1.b> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 211
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.k(coil.a, A1.g, java.lang.Object, A1.k, coil.b, e9.c):java.lang.Object");
    }

    public final Object l(b bVar, g gVar, k kVar, coil.b bVar2, InterfaceC4014c<? super b> interfaceC4014c) {
        List<D1.b> listO = gVar.O();
        return listO.isEmpty() ? bVar : ((bVar.getDrawable() instanceof BitmapDrawable) || gVar.getAllowConversionToBitmap()) ? C1056g.j(gVar.getTransformationDispatcher(), new EngineInterceptor$transform$3(this, bVar, kVar, listO, bVar2, gVar, null), interfaceC4014c) : bVar;
    }
}
