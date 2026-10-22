package B0;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes.dex */
class e {

    /* renamed from: f, reason: collision with root package name */
    private static final a f198f = new a();

    /* renamed from: a, reason: collision with root package name */
    private final a f199a;

    /* renamed from: b, reason: collision with root package name */
    private final d f200b;

    /* renamed from: c, reason: collision with root package name */
    private final D0.b f201c;

    /* renamed from: d, reason: collision with root package name */
    private final ContentResolver f202d;

    /* renamed from: e, reason: collision with root package name */
    private final List<ImageHeaderParser> f203e;

    e(List<ImageHeaderParser> list, d dVar, D0.b bVar, ContentResolver contentResolver) {
        this(list, f198f, dVar, bVar, contentResolver);
    }

    private String b(Uri uri) {
        Cursor cursorA = this.f200b.a(uri);
        if (cursorA != null) {
            try {
                if (cursorA.moveToFirst()) {
                    return cursorA.getString(0);
                }
            } finally {
                cursorA.close();
            }
        }
        if (cursorA != null) {
        }
        return null;
    }

    private boolean c(File file) {
        return this.f199a.a(file) && 0 < this.f199a.c(file);
    }

    int a(Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                inputStreamOpenInputStream = this.f202d.openInputStream(uri);
                int iA = com.bumptech.glide.load.a.a(this.f203e, inputStreamOpenInputStream, this.f201c);
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return iA;
            } catch (Throwable th) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException | NullPointerException e6) {
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e6);
            }
            if (inputStreamOpenInputStream == null) {
                return -1;
            }
            try {
                inputStreamOpenInputStream.close();
                return -1;
            } catch (IOException unused3) {
                return -1;
            }
        }
    }

    public InputStream d(Uri uri) throws FileNotFoundException {
        String strB = b(uri);
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        File fileB = this.f199a.b(strB);
        if (!c(fileB)) {
            return null;
        }
        Uri uriFromFile = Uri.fromFile(fileB);
        try {
            return this.f202d.openInputStream(uriFromFile);
        } catch (NullPointerException e6) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + uriFromFile).initCause(e6));
        }
    }

    e(List<ImageHeaderParser> list, a aVar, d dVar, D0.b bVar, ContentResolver contentResolver) {
        this.f199a = aVar;
        this.f200b = dVar;
        this.f201c = bVar;
        this.f202d = contentResolver;
        this.f203e = list;
    }
}
