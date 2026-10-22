package H0;

import H0.n;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.InputStream;
import z0.C1342h;

/* loaded from: classes.dex */
public class s<Data> implements n<Integer, Data> {

    /* renamed from: a, reason: collision with root package name */
    private final n<Uri, Data> f2028a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources f2029b;

    public static final class a implements o<Integer, AssetFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f2030a;

        public a(Resources resources) {
            this.f2030a = resources;
        }

        @Override // H0.o
        public n<Integer, AssetFileDescriptor> a(r rVar) {
            return new s(this.f2030a, rVar.d(Uri.class, AssetFileDescriptor.class));
        }

        @Override // H0.o
        public void b() {
        }
    }

    public static class b implements o<Integer, ParcelFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f2031a;

        public b(Resources resources) {
            this.f2031a = resources;
        }

        @Override // H0.o
        public n<Integer, ParcelFileDescriptor> a(r rVar) {
            return new s(this.f2031a, rVar.d(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // H0.o
        public void b() {
        }
    }

    public static class c implements o<Integer, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f2032a;

        public c(Resources resources) {
            this.f2032a = resources;
        }

        @Override // H0.o
        public n<Integer, InputStream> a(r rVar) {
            return new s(this.f2032a, rVar.d(Uri.class, InputStream.class));
        }

        @Override // H0.o
        public void b() {
        }
    }

    public static class d implements o<Integer, Uri> {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f2033a;

        public d(Resources resources) {
            this.f2033a = resources;
        }

        @Override // H0.o
        public n<Integer, Uri> a(r rVar) {
            return new s(this.f2033a, v.c());
        }

        @Override // H0.o
        public void b() {
        }
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.f2029b = resources;
        this.f2028a = nVar;
    }

    private Uri d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f2029b.getResourcePackageName(num.intValue()) + '/' + this.f2029b.getResourceTypeName(num.intValue()) + '/' + this.f2029b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e6) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            Log.w("ResourceLoader", "Received invalid resource id: " + num, e6);
            return null;
        }
    }

    @Override // H0.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> b(Integer num, int i5, int i6, C1342h c1342h) {
        Uri uriD = d(num);
        if (uriD == null) {
            return null;
        }
        return this.f2028a.b(uriD, i5, i6, c1342h);
    }

    @Override // H0.n
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean a(Integer num) {
        return true;
    }
}
