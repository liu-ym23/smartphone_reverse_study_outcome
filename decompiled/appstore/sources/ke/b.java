package ke;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
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
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements ModelLoader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21055b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21056a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ String a(a r10, Uri r11) {
            return r10.c(r11);
        }

        public final String b(String r10) {
            q.g(r10, "apkPath");
            Uri r11 = Uri.parse("icon://com.obric.appstore.preload.icon/" + r10);
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
            if (r11 == null) goto L19;
            Path r12 = Paths.get(r11, new String[0]);
            q.f(r12, "get(...)");
            String r13 = r12.toString();
            if (r13.length() > 0) goto L16;
            return null;
        L16:
            return r13;
        L19:
            return null;
        }

        public final boolean d(Uri r10) {
            q.g(r10, "uri");
            if (q.b(r10.getScheme(), ServerElements.ICON) == true) goto L5;
        L7:
            return false;
        L5:
            if (q.b(r10.getAuthority(), "com.obric.appstore.preload.icon") == false) goto L7;
            return true;
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: ke.b$b, reason: collision with other inner class name */
    public static final class C0289b implements ModelLoaderFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f21057a;

        public C0289b(Context r10) {
            q.g(r10, "context");
            this.f21057a = r10;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory r10) {
            q.g(r10, "multiFactory");
            return new b(this.f21057a);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public static final class c implements DataFetcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f21058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f21059b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Bitmap f21060c;

        public c(Context r10, String r11) {
            q.g(r10, "context");
            q.g(r11, "fullPath");
            this.f21058a = r10;
            this.f21059b = r11;
        }

        private final Bitmap a(String r10) {
            PackageManager r11 = this.f21058a.getPackageManager();
            if (r11 != null) goto L5;
            return null;
        L5:
            PackageInfo r12 = r11.getPackageArchiveInfo(r10, 0);
            if (r12 == null) goto L13;
            ApplicationInfo r13 = r12.applicationInfo;
            if (r13 == null) goto L14;
            Drawable r14 = r13.loadIcon(r11);
            if (r14 != null) goto L12;
            return null;
        L12:
            return pe.a.a(r14);
        L14:
            return null;
        L13:
            return null;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            this.f21060c = null;
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
            Bitmap r12 = a(this.f21059b);
            this.f21060c = r12;
            r11.onDataReady(r12);
        }
    }

    static {
        f21055b = new a(null);
    }

    public b(Context r10) {
        q.g(r10, "context");
        this.f21056a = r10;
    }

    public ModelLoader.LoadData a(String r10, int r11, int r12, Options r13) {
        q.g(r10, NetKey.MODEL);
        q.g(r13, "options");
        Uri r14 = Uri.parse(r10);
        q.f(r14, "parse(this)");
        String r15 = a.a(f21055b, r14);
        if (r15 != null) goto L7;
        return null;
    L7:
        return new ModelLoader.LoadData(new ObjectKey(r10), new c(this.f21056a, r15));
    }

    public boolean b(String r10) {
        q.g(r10, NetKey.MODEL);
        a r11 = f21055b;
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
