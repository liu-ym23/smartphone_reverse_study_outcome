package t0;

import android.content.res.AssetManager;
import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.concurrent.Executor;
import org.bouncycastle.asn1.BERTags;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f5410a;

    /* renamed from: b, reason: collision with root package name */
    public final e f5411b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f5412c;
    public final File d;

    /* renamed from: e, reason: collision with root package name */
    public final String f5413e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5414f = false;

    /* renamed from: g, reason: collision with root package name */
    public c[] f5415g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f5416h;

    public b(AssetManager assetManager, Executor executor, e eVar, String str, File file) {
        this.f5410a = executor;
        this.f5411b = eVar;
        this.f5413e = str;
        this.d = file;
        int i8 = Build.VERSION.SDK_INT;
        byte[] bArr = null;
        if (i8 <= 34) {
            switch (i8) {
                case BERTags.DATE /* 31 */:
                case 32:
                case BERTags.DATE_TIME /* 33 */:
                case BERTags.DURATION /* 34 */:
                    bArr = f.d;
                    break;
            }
        }
        this.f5412c = bArr;
    }

    public final FileInputStream a(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e9) {
            String message = e9.getMessage();
            if (message == null || !message.contains("compressed")) {
                return null;
            }
            this.f5411b.d();
            return null;
        }
    }

    public final void b(final int i8, final Serializable serializable) {
        this.f5410a.execute(new Runnable() { // from class: t0.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f5407a.f5411b.e(i8, serializable);
            }
        });
    }
}
