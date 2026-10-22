package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.drawerlayout.widget.DrawerLayout;

/* JADX INFO: compiled from: ActionBarDrawerToggle.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements DrawerLayout.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    View.OnClickListener f238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InterfaceC0008a f239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DrawerLayout f240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private DrawerArrowDrawable f241e;
    private boolean f;
    private final int g;
    private final int h;

    /* JADX INFO: renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionBarDrawerToggle.java */
    public interface InterfaceC0008a {
        void a(int r1);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.c
    public void a(int r1) {
    }

    void a() {
        int r0 = this.f240d.getDrawerLockMode(8388611);
        if (this.f240d.isDrawerVisible(8388611) == false) goto L8;
        if (r0 == 2) goto L8;
        this.f240d.closeDrawer(8388611);
        return;
    L8:
        if (r0 == 1) goto L12;
        this.f240d.openDrawer(8388611);
        return;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.c
    public void a(View r2, float r3) {
        if (this.f == false) goto L5;
        a(Math.min(1.0f, Math.max(0.0f, r3)));
        return;
    L5:
        a(0.0f);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.c
    public void a(View r1) {
        a(1.0f);
        if (this.f237a == false) goto L6;
        b(this.h);
        return;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.c
    public void b(View r1) {
        a(0.0f);
        if (this.f237a == false) goto L6;
        b(this.g);
        return;
    }

    void b(int r1) {
        this.f239c.a(r1);
    }

    private void a(float r3) {
        if (r3 != 1.0f) goto L6;
        this.f241e.setVerticalMirror(true);
    L8:
        this.f241e.setProgress(r3);
        return;
    L6:
        if (r3 != 0.0f) goto L8;
        this.f241e.setVerticalMirror(false);
        goto L8
    }
}
