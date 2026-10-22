package bdc;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import cdc.d;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f18709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f18710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TimeInterpolator f18711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Animator.AnimatorListener f18712d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Context f18713e;

    public a(Intent r100) {
        this.f18709a = r100;
    }

    public final c a(Bundle r110) {
        if (this.f18711c != null) goto L5;
        this.f18711c = new DecelerateInterpolator();
    L5:
        Bundle r100 = this.f18709a.getExtras();
        Context r101 = this.f18713e;
        View r102 = this.f18710b;
        TimeInterpolator r103 = this.f18711c;
        Animator.AnimatorListener r104 = this.f18712d;
        Object r105 = cdc.c.f23435a;
        if ((r101 instanceof ContextThemeWrapper) == false) goto L8;
        r101 = ((ContextThemeWrapper) r101).getBaseContext();
    L8:
        d r106 = new d(r101, r100);
        String r107 = r106.f23441e;
        if (r107 == null) goto L24;
        Object r108 = cdc.c.f23435a;
        monitor-enter(r108);
    L32:
    L21:
        th = move-exception;
        throw th;
    L13:
        if (cdc.c.f23436b == true) goto L16;
        cdc.c.f23435a.wait(3000);     // Catch: InterruptedException -> L29 Throwable -> L21
        goto L32
    L16:
        monitor-exit(r108);     // Catch: Throwable -> L21
        Bitmap r109 = BitmapFactory.decodeFile(r107);
        if ((r102 instanceof ImageView) == false) goto L20;
        ((ImageView) r102).setImageBitmap(r109);
        goto L24
    L20:
        ViewCompat.setBackground(r102, new BitmapDrawable(r102.getResources(), r109));
    L24:
        cdc.a r111 = new cdc.a();
        r111.f23429f = r102;
        r111.f23428e = 200;
        if (r110 != null) goto L28;
        r102.getViewTreeObserver().addOnPreDrawListener(new cdc.b(r102, r111, r106, r103, r104));
    L28:
        return new c(r111);
    }
}
