package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2846i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2847j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LayoutInflater f2848k;

    public b(Context r10, int r11, Cursor r12, boolean r13) {
        super(r10, r12, r13);
        this.f2847j = r11;
        this.f2846i = r11;
        this.f2848k = (LayoutInflater) r10.getSystemService("layout_inflater");
    }

    @Override // androidx.cursoradapter.widget.a
    public View c(Context r10, Cursor r11, ViewGroup r12) {
        return this.f2848k.inflate(this.f2847j, r12, false);
    }

    @Override // androidx.cursoradapter.widget.a
    public View d(Context r10, Cursor r11, ViewGroup r12) {
        return this.f2848k.inflate(this.f2846i, r12, false);
    }
}
