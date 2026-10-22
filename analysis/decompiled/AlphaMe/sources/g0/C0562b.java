package g0;

import android.content.res.AssetManager;
import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.concurrent.Executor;
import l.ExecutorC0743a;

/* renamed from: g0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0562b {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f12618a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0564d f12619b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f12620c;

    /* renamed from: d, reason: collision with root package name */
    public final File f12621d;

    /* renamed from: e, reason: collision with root package name */
    public final String f12622e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f12623f = false;

    /* renamed from: g, reason: collision with root package name */
    public C0563c[] f12624g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f12625h;

    public C0562b(AssetManager assetManager, ExecutorC0743a executorC0743a, InterfaceC0564d interfaceC0564d, String str, File file) {
        this.f12618a = executorC0743a;
        this.f12619b = interfaceC0564d;
        this.f12622e = str;
        this.f12621d = file;
        int i4 = Build.VERSION.SDK_INT;
        byte[] bArr = null;
        if (i4 <= 34 && (i4 == 33 || i4 == 34)) {
            bArr = AbstractC0565e.f12638d;
        }
        this.f12620c = bArr;
    }

    public final FileInputStream a(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e4) {
            String message = e4.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f12619b.g();
            }
            return null;
        }
    }

    public final void b(int i4, Serializable serializable) {
        this.f12618a.execute(new RunnableC0561a(this, i4, serializable, 0));
    }
}
