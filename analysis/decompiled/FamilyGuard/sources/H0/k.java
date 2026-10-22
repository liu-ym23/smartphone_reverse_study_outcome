package H0;

import A0.d;
import H0.n;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;
import z0.C1342h;
import z0.EnumC1335a;

/* loaded from: classes.dex */
public final class k implements n<Uri, File> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1992a;

    public static final class a implements o<Uri, File> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f1993a;

        public a(Context context) {
            this.f1993a = context;
        }

        @Override // H0.o
        public n<Uri, File> a(r rVar) {
            return new k(this.f1993a);
        }

        @Override // H0.o
        public void b() {
        }
    }

    private static class b implements A0.d<File> {

        /* renamed from: c, reason: collision with root package name */
        private static final String[] f1994c = {"_data"};

        /* renamed from: a, reason: collision with root package name */
        private final Context f1995a;

        /* renamed from: b, reason: collision with root package name */
        private final Uri f1996b;

        b(Context context, Uri uri) {
            this.f1995a = context;
            this.f1996b = uri;
        }

        @Override // A0.d
        public Class<File> a() {
            return File.class;
        }

        @Override // A0.d
        public void b() {
        }

        @Override // A0.d
        public void cancel() {
        }

        @Override // A0.d
        public EnumC1335a d() {
            return EnumC1335a.LOCAL;
        }

        @Override // A0.d
        public void e(v0.g gVar, d.a<? super File> aVar) {
            Cursor cursorQuery = this.f1995a.getContentResolver().query(this.f1996b, f1994c, null, null, null);
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                    cursorQuery.close();
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
            if (!TextUtils.isEmpty(string)) {
                aVar.f(new File(string));
                return;
            }
            aVar.c(new FileNotFoundException("Failed to find file path for: " + this.f1996b));
        }
    }

    public k(Context context) {
        this.f1992a = context;
    }

    @Override // H0.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<File> b(Uri uri, int i5, int i6, C1342h c1342h) {
        return new n.a<>(new W0.b(uri), new b(this.f1992a, uri));
    }

    @Override // H0.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return B0.b.b(uri);
    }
}
