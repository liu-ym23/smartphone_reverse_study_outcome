package brc;

import android.animation.ArgbEvaluator;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes41.dex */
public abstract class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f20196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f20197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f20198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f20199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArgbEvaluator f20200e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final crc.a f20201f;

    /* JADX INFO: renamed from: brc.a$a, reason: collision with other inner class name */
    public static final class C0351a {
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f20202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f20203b;

        public b() {
        }
    }

    static {
    }

    public int b() {
        return ((int) this.f20201f.a()) + 3;
    }

    public a(crc.a r100) {
        this.f20201f = r100;
        Paint r101 = new Paint();
        this.f20199d = r101;
        r101.setAntiAlias(true);
        this.f20196a = new b();
        int r102 = r100.f465141c;
        if (r102 != 4) goto L5;
    L6:
        this.f20200e = new ArgbEvaluator();
        return;
    L5:
        if (r102 == 5) goto L6;
    }
}
