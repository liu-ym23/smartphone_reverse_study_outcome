package A0;

import A0.d;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.IOException;
import z0.EnumC1335a;

/* loaded from: classes.dex */
public abstract class b<T> implements d<T> {

    /* renamed from: a, reason: collision with root package name */
    private final String f0a;

    /* renamed from: b, reason: collision with root package name */
    private final AssetManager f1b;

    /* renamed from: c, reason: collision with root package name */
    private T f2c;

    public b(AssetManager assetManager, String str) {
        this.f1b = assetManager;
        this.f0a = str;
    }

    @Override // A0.d
    public void b() {
        T t5 = this.f2c;
        if (t5 == null) {
            return;
        }
        try {
            c(t5);
        } catch (IOException unused) {
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
    public void e(v0.g gVar, d.a<? super T> aVar) {
        try {
            T tF = f(this.f1b, this.f0a);
            this.f2c = tF;
            aVar.f(tF);
        } catch (IOException e6) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e6);
            }
            aVar.c(e6);
        }
    }

    protected abstract T f(AssetManager assetManager, String str);
}
