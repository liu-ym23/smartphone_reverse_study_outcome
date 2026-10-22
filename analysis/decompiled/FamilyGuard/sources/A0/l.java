package A0;

import A0.d;
import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import z0.EnumC1335a;

/* loaded from: classes.dex */
public abstract class l<T> implements d<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Uri f24a;

    /* renamed from: b, reason: collision with root package name */
    private final ContentResolver f25b;

    /* renamed from: c, reason: collision with root package name */
    private T f26c;

    public l(ContentResolver contentResolver, Uri uri) {
        this.f25b = contentResolver;
        this.f24a = uri;
    }

    @Override // A0.d
    public void b() {
        T t5 = this.f26c;
        if (t5 != null) {
            try {
                c(t5);
            } catch (IOException unused) {
            }
        }
    }

    protected abstract void c(T t5);

    @Override // A0.d
    public void cancel() {
    }

    @Override // A0.d
    public EnumC1335a d() {
        return EnumC1335a.LOCAL;
    }

    @Override // A0.d
    public final void e(v0.g gVar, d.a<? super T> aVar) {
        try {
            T tF = f(this.f24a, this.f25b);
            this.f26c = tF;
            aVar.f(tF);
        } catch (FileNotFoundException e6) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e6);
            }
            aVar.c(e6);
        }
    }

    protected abstract T f(Uri uri, ContentResolver contentResolver);
}
