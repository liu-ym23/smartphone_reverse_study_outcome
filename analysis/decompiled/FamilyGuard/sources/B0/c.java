package B0;

import A0.d;
import A0.g;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import v0.ComponentCallbacks2C1180c;
import z0.EnumC1335a;

/* loaded from: classes.dex */
public class c implements A0.d<InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final Uri f191a;

    /* renamed from: b, reason: collision with root package name */
    private final e f192b;

    /* renamed from: c, reason: collision with root package name */
    private InputStream f193c;

    static class a implements d {

        /* renamed from: b, reason: collision with root package name */
        private static final String[] f194b = {"_data"};

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f195a;

        a(ContentResolver contentResolver) {
            this.f195a = contentResolver;
        }

        @Override // B0.d
        public Cursor a(Uri uri) {
            return this.f195a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f194b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    static class b implements d {

        /* renamed from: b, reason: collision with root package name */
        private static final String[] f196b = {"_data"};

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f197a;

        b(ContentResolver contentResolver) {
            this.f197a = contentResolver;
        }

        @Override // B0.d
        public Cursor a(Uri uri) {
            return this.f197a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f196b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    c(Uri uri, e eVar) {
        this.f191a = uri;
        this.f192b = eVar;
    }

    private static c c(Context context, Uri uri, d dVar) {
        return new c(uri, new e(ComponentCallbacks2C1180c.c(context).j().g(), dVar, ComponentCallbacks2C1180c.c(context).e(), context.getContentResolver()));
    }

    public static c f(Context context, Uri uri) {
        return c(context, uri, new a(context.getContentResolver()));
    }

    public static c g(Context context, Uri uri) {
        return c(context, uri, new b(context.getContentResolver()));
    }

    private InputStream h() throws FileNotFoundException {
        InputStream inputStreamD = this.f192b.d(this.f191a);
        int iA = inputStreamD != null ? this.f192b.a(this.f191a) : -1;
        return iA != -1 ? new g(inputStreamD, iA) : inputStreamD;
    }

    @Override // A0.d
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // A0.d
    public void b() throws IOException {
        InputStream inputStream = this.f193c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // A0.d
    public void cancel() {
    }

    @Override // A0.d
    public EnumC1335a d() {
        return EnumC1335a.LOCAL;
    }

    @Override // A0.d
    public void e(v0.g gVar, d.a<? super InputStream> aVar) {
        try {
            InputStream inputStreamH = h();
            this.f193c = inputStreamH;
            aVar.f(inputStreamH);
        } catch (FileNotFoundException e6) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e6);
            }
            aVar.c(e6);
        }
    }
}
