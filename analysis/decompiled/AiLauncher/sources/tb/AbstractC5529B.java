package tb;

import Mb.I;
import Mb.InterfaceC0967e;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Pair;
import okio.ByteString;
import ub.C5642b;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u0000 \u00132\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0011¨\u0006\u0014"}, d2 = {"Ltb/B;", "", "<init>", "()V", "Ltb/x;", Const.INTENT_KEY_PKGNAME, "()Ltb/x;", "", Const.INTENT_KEY_APIKEY, "()J", "LMb/e;", "sink", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LMb/e;)V", "", "e", "()Z", "f", "Companion", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: tb.B, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5529B {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final AbstractC5529B EMPTY;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u0007*\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u0007*\u00020\n2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u0011\u001a\u00020\u0007*\u00020\r2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\u0007*\u00020\u00132\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ5\u0010\u001b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Ltb/B$a;", "", "<init>", "()V", "", "Ltb/x;", "contentType", "Ltb/B;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ltb/x;)Ltb/B;", "Lokio/ByteString;", "c", "(Lokio/ByteString;Ltb/x;)Ltb/B;", "", "", "offset", "byteCount", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "([BLtb/x;II)Ltb/B;", "Ljava/io/File;", Const.INTENT_KEY_APIKEY, "(Ljava/io/File;Ltb/x;)Ltb/B;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, Const.INTENT_KEY_UMID, "(Ltb/x;Ljava/lang/String;)Ltb/B;", "e", "(Ltb/x;Lokio/ByteString;)Ltb/B;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ltb/x;[BII)Ltb/B;", "EMPTY", "Ltb/B;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: tb.B$a, reason: from kotlin metadata */
    public static final class Companion {

        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"tb/B$a$a", "Ltb/B;", "Ltb/x;", Const.INTENT_KEY_PKGNAME, "()Ltb/x;", "", Const.INTENT_KEY_APIKEY, "()J", "LMb/e;", "sink", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LMb/e;)V", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: tb.B$a$a, reason: collision with other inner class name */
        public static final class C0529a extends AbstractC5529B {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ x f42090a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ File f42091b;

            public C0529a(x xVar, File file) {
                this.f42090a = xVar;
                this.f42091b = file;
            }

            @Override // tb.AbstractC5529B
            public long a() {
                return this.f42091b.length();
            }

            @Override // tb.AbstractC5529B
            /* renamed from: b, reason: from getter */
            public x getF42094a() {
                return this.f42090a;
            }

            @Override // tb.AbstractC5529B
            public void g(InterfaceC0967e sink) throws IOException {
                kotlin.jvm.internal.p.i(sink, "sink");
                I iK = Mb.u.k(this.f42091b);
                try {
                    sink.V0(iK);
                    l9.b.a(iK, null);
                } finally {
                }
            }
        }

        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"tb/B$a$b", "Ltb/B;", "Ltb/x;", Const.INTENT_KEY_PKGNAME, "()Ltb/x;", "", Const.INTENT_KEY_APIKEY, "()J", "LMb/e;", "sink", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LMb/e;)V", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: tb.B$a$b */
        public static final class b extends AbstractC5529B {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ x f42092a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ByteString f42093b;

            public b(x xVar, ByteString byteString) {
                this.f42092a = xVar;
                this.f42093b = byteString;
            }

            @Override // tb.AbstractC5529B
            public long a() {
                return this.f42093b.K();
            }

            @Override // tb.AbstractC5529B
            /* renamed from: b, reason: from getter */
            public x getF42094a() {
                return this.f42092a;
            }

            @Override // tb.AbstractC5529B
            public void g(InterfaceC0967e sink) throws IOException {
                kotlin.jvm.internal.p.i(sink, "sink");
                sink.j1(this.f42093b);
            }
        }

        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"tb/B$a$c", "Ltb/B;", "Ltb/x;", Const.INTENT_KEY_PKGNAME, "()Ltb/x;", "", Const.INTENT_KEY_APIKEY, "()J", "LMb/e;", "sink", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LMb/e;)V", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: tb.B$a$c */
        public static final class c extends AbstractC5529B {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ x f42094a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f42095b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ byte[] f42096c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f42097d;

            public c(x xVar, int i10, byte[] bArr, int i11) {
                this.f42094a = xVar;
                this.f42095b = i10;
                this.f42096c = bArr;
                this.f42097d = i11;
            }

            @Override // tb.AbstractC5529B
            public long a() {
                return this.f42095b;
            }

            @Override // tb.AbstractC5529B
            /* renamed from: b, reason: from getter */
            public x getF42094a() {
                return this.f42094a;
            }

            @Override // tb.AbstractC5529B
            public void g(InterfaceC0967e sink) throws IOException {
                kotlin.jvm.internal.p.i(sink, "sink");
                sink.write(this.f42096c, this.f42097d, this.f42095b);
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ AbstractC5529B i(Companion companion, ByteString byteString, x xVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                xVar = null;
            }
            return companion.c(byteString, xVar);
        }

        public static /* synthetic */ AbstractC5529B j(Companion companion, x xVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
            if ((i12 & 4) != 0) {
                i10 = 0;
            }
            if ((i12 & 8) != 0) {
                i11 = bArr.length;
            }
            return companion.g(xVar, bArr, i10, i11);
        }

        public final AbstractC5529B a(File file, x xVar) {
            kotlin.jvm.internal.p.i(file, "<this>");
            return new C0529a(xVar, file);
        }

        public final AbstractC5529B b(String str, x xVar) {
            kotlin.jvm.internal.p.i(str, "<this>");
            Pair<Charset, x> pairB = C5642b.b(xVar);
            Charset charsetA = pairB.a();
            x xVarB = pairB.b();
            byte[] bytes = str.getBytes(charsetA);
            kotlin.jvm.internal.p.h(bytes, "getBytes(...)");
            return h(bytes, xVarB, 0, bytes.length);
        }

        public final AbstractC5529B c(ByteString byteString, x xVar) {
            kotlin.jvm.internal.p.i(byteString, "<this>");
            return new b(xVar, byteString);
        }

        public final AbstractC5529B d(x contentType, String content) {
            kotlin.jvm.internal.p.i(content, "content");
            return b(content, contentType);
        }

        public final AbstractC5529B e(x contentType, ByteString content) {
            kotlin.jvm.internal.p.i(content, "content");
            return c(content, contentType);
        }

        public final AbstractC5529B f(x xVar, byte[] content) {
            kotlin.jvm.internal.p.i(content, "content");
            return j(this, xVar, content, 0, 0, 12, null);
        }

        public final AbstractC5529B g(x contentType, byte[] content, int offset, int byteCount) {
            kotlin.jvm.internal.p.i(content, "content");
            return h(content, contentType, offset, byteCount);
        }

        public final AbstractC5529B h(byte[] bArr, x xVar, int i10, int i11) {
            kotlin.jvm.internal.p.i(bArr, "<this>");
            ub.n.e(bArr.length, i10, i11);
            return new c(xVar, i11, bArr, i10);
        }

        public Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        EMPTY = Companion.i(companion, ByteString.f37756e, null, 1, null);
    }

    public static final AbstractC5529B c(x xVar, ByteString byteString) {
        return INSTANCE.e(xVar, byteString);
    }

    public static final AbstractC5529B d(x xVar, byte[] bArr) {
        return INSTANCE.f(xVar, bArr);
    }

    public long a() throws IOException {
        return -1L;
    }

    /* renamed from: b */
    public abstract x getF42094a();

    public boolean e() {
        return false;
    }

    public boolean f() {
        return false;
    }

    public abstract void g(InterfaceC0967e sink) throws IOException;
}
