package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class h {
    public boolean A;
    public String B;
    public Bundle C;
    public int D;
    public int E;
    public Notification F;
    public RemoteViews G;
    public RemoteViews H;
    public RemoteViews I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f2469J;
    public int K;
    public String L;
    public long M;
    public int N;
    public int O;
    public boolean P;
    public Notification Q;
    public boolean R;
    public Icon S;
    public ArrayList T;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f2470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f2471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList f2472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f2473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f2474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f2475f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PendingIntent f2476g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PendingIntent f2477h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RemoteViews f2478i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Bitmap f2479j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f2480k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2481l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2482m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f2483n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2484o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f2485p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CharSequence f2486q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence[] f2487r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f2488s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f2489t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f2490u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f2491v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2492w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f2493x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f2494y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f2495z;

    public h(Context r10, String r11) {
        this.f2471b = new ArrayList();
        this.f2472c = new ArrayList();
        this.f2473d = new ArrayList();
        this.f2483n = true;
        this.f2494y = false;
        this.D = 0;
        this.E = 0;
        this.K = 0;
        this.N = 0;
        this.O = 0;
        Notification r12 = new Notification();
        this.Q = r12;
        this.f2470a = r10;
        this.f2469J = r11;
        r12.when = System.currentTimeMillis();
        this.Q.audioStreamType = -1;
        this.f2482m = 0;
        this.T = new ArrayList();
        this.P = true;
    }

    public static CharSequence c(CharSequence r10) {
        if (r10 != null) goto L5;
        return r10;
    L5:
        if (r10.length() > 5120) goto L7;
        return r10;
    L7:
        return r10.subSequence(0, 5120);
    }

    public Notification a() {
        return new i(this).b();
    }

    public Bundle b() {
        if (this.C != null) goto L6;
        this.C = new Bundle();
    L6:
        return this.C;
    }

    public h d(boolean r10) {
        i(16, r10);
        return this;
    }

    public h e(String r10) {
        this.f2469J = r10;
        return this;
    }

    public h f(PendingIntent r10) {
        this.f2476g = r10;
        return this;
    }

    public h g(CharSequence r10) {
        this.f2475f = c(r10);
        return this;
    }

    public h h(CharSequence r10) {
        this.f2474e = c(r10);
        return this;
    }

    public final void i(int r10, boolean r11) {
        if (r11 == false) goto L4;
        Notification r12 = this.Q;
        r12.flags = r10 | r12.flags;
        return;
    L4:
        Notification r13 = this.Q;
        int r14 = r13.flags;
        r13.flags = (~r10) & r14;
    }

    public h j(String r10) {
        this.f2491v = r10;
        return this;
    }

    public h k(boolean r10) {
        this.f2492w = r10;
        return this;
    }

    public h l(int r10) {
        this.Q.icon = r10;
        return this;
    }

    public h(Context r10) {
        this(r10, null);
    }
}
