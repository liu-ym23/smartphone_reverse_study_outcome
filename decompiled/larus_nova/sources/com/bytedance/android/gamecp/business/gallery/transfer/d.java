package com.bytedance.android.gamecp.business.gallery.transfer;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import com.bytedance.android.gamecp.common.utils.y0;
import com.larus.nova.R;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f53245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f53246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f53247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f53248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f53249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f53250f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<ImageView> f53251g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<String> f53252h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<String> f53253i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<String> f53254j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ys.a f53255k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public xs.a f53256l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public vs.d f53257m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f53258n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f53259o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b f53260p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f53261q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public c f53262r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public a f53263s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f53264t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f53265u;

    public interface a {
        void a(AlertDialog r100, e r101);

        void b(AlertDialog r100, e r101);
    }

    public interface b {
        void call(int r100);
    }

    public interface c {
        void call(int r100);
    }

    public final vs.e a() {
        if (this.f53257m != null) goto L6;
        this.f53257m = new vs.d();
    L6:
        return this.f53257m;
    }

    public final Drawable b() {
        if (this.f53246b != 0) goto L5;
        return null;
    L5:
        return y0.e(R.drawable.gamecp_game_promote_image_failed);
    }

    public d() {
        this.f53258n = false;
        this.f53259o = false;
        this.f53261q = false;
        this.f53262r = null;
        this.f53264t = null;
        this.f53265u = 0;
    }
}
