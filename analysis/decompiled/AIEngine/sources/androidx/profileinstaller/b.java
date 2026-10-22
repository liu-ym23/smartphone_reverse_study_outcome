package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.c;
import b.l;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f2447a;

    /* renamed from: b, reason: collision with root package name */
    public final c.InterfaceC0017c f2448b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f2449c;

    /* renamed from: d, reason: collision with root package name */
    public final File f2450d;

    /* renamed from: e, reason: collision with root package name */
    public final String f2451e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2452f = false;

    /* renamed from: g, reason: collision with root package name */
    public t1.a[] f2453g;
    public byte[] h;

    public b(AssetManager assetManager, Executor executor, c.InterfaceC0017c interfaceC0017c, String str, File file) {
        this.f2447a = executor;
        this.f2448b = interfaceC0017c;
        this.f2451e = str;
        this.f2450d = file;
        int i10 = Build.VERSION.SDK_INT;
        this.f2449c = i10 >= 31 ? t1.d.f12928a : i10 != 30 ? null : t1.d.f12929b;
    }

    public final FileInputStream a(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e10) {
            String message = e10.getMessage();
            if (message == null || !message.contains("compressed")) {
                return null;
            }
            this.f2448b.a();
            return null;
        }
    }

    public final void b(int i10, Serializable serializable) {
        this.f2447a.execute(new l(i10, 2, this, serializable));
    }
}
