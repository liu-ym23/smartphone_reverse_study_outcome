package ke;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.bytedanceos.common.toolbox.ServerElements;
import kotlin.Result;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements ModelLoader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0288a f21049b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21050a;

    /* JADX INFO: renamed from: ke.a$a, reason: collision with other inner class name */
    public static final class C0288a {
        public /* synthetic */ C0288a(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ String a(C0288a r10, Uri r11) {
            return r10.c(r11);
        }

        public final String b(String r10) {
            q.g(r10, "pkgName");
            Uri r11 = Uri.parse("icon://com.obric.appstore.pm.icon/" + r10);
            q.f(r11, "parse(this)");
            String r12 = r11.toString();
            q.f(r12, "toString(...)");
            return r12;
        }

        public final String c(Uri r10) {
            if (d(r10) == true) goto L5;
            return null;
        L5:
            String r11 = r10.getPath();
            if (r11 != null) goto L8;
            return null;
        L8:
            if (r11.length() > 0) goto L11;
            r11 = null;
        L11:
            if (r11 != null) goto L13;
            return null;
        L13:
            return StringsKt__StringsKt.B0(r11, new char[]{'/'});
        }

        public final boolean d(Uri r10) {
            q.g(r10, "uri");
            if (q.b(r10.getScheme(), ServerElements.ICON) == true) goto L5;
        L7:
            return false;
        L5:
            if (q.b(r10.getAuthority(), "com.obric.appstore.pm.icon") == false) goto L7;
            return true;
        }

        public C0288a() {
        }
    }

    public static final class b implements ModelLoaderFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f21051a;

        public b(Context r10) {
            q.g(r10, "context");
            this.f21051a = r10;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory r10) {
            q.g(r10, "multiFactory");
            return new a(this.f21051a);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public static final class c implements DataFetcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f21052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f21053b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Bitmap f21054c;

        public c(Context r10, String r11) {
            q.g(r10, "context");
            q.g(r11, "pkgName");
            this.f21052a = r10;
            this.f21053b = r11;
        }

        public final Bitmap a(String r10) {
            Result.a r11 = Result.Companion;     // Catch: Throwable -> L4
            Object r12 = Result.m35constructorimpl(this.f21052a.getPackageManager().getApplicationIcon(r10));     // Catch: Throwable -> L4
        L7:
            if (Result.m41isFailureimpl(r12) == false) goto L9;
            r12 = null;
        L9:
            Drawable r13 = (Drawable) r12;
            if (r13 != null) goto L12;
            return null;
        L12:
            return pe.a.a(r13);
        L4:
            th = move-exception;
            Result.a r14 = Result.Companion;
            r12 = Result.m35constructorimpl(kotlin.c.a(th));
            goto L7
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            this.f21054c = null;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class getDataClass() {
            return Bitmap.class;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority r10, DataFetcher.DataCallback r11) {
            q.g(r10, "priority");
            q.g(r11, "callback");
            Bitmap r12 = a(this.f21053b);
            this.f21054c = r12;
            r11.onDataReady(r12);
        }
    }

    static {
        f21049b = new C0288a(null);
    }

    public a(Context r10) {
        q.g(r10, "context");
        this.f21050a = r10;
    }

    public ModelLoader.LoadData a(String r10, int r11, int r12, Options r13) {
        q.g(r10, NetKey.MODEL);
        q.g(r13, "options");
        C0288a r14 = f21049b;
        Uri r15 = Uri.parse(r10);
        q.f(r15, "parse(this)");
        String r16 = C0288a.a(r14, r15);
        if (r16 != null) goto L7;
        return null;
    L7:
        return new ModelLoader.LoadData(new ObjectKey(r10), new c(this.f21050a, r16));
    }

    public boolean b(String r10) {
        q.g(r10, NetKey.MODEL);
        C0288a r11 = f21049b;
        Uri r12 = Uri.parse(r10);
        q.f(r12, "parse(this)");
        return r11.d(r12);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ ModelLoader.LoadData buildLoadData(Object r10, int r11, int r12, Options r13) {
        return a((String) r10, r11, r12, r13);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ boolean handles(Object r10) {
        return b((String) r10);
    }
}
