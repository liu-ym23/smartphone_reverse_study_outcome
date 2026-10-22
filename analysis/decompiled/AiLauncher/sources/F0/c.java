package F0;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class c extends a {

    /* renamed from: i, reason: collision with root package name */
    public int f2542i;

    /* renamed from: j, reason: collision with root package name */
    public int f2543j;

    /* renamed from: k, reason: collision with root package name */
    public LayoutInflater f2544k;

    @Deprecated
    public c(Context context, int i10, Cursor cursor, boolean z10) {
        super(context, cursor, z10);
        this.f2543j = i10;
        this.f2542i = i10;
        this.f2544k = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // F0.a
    public View e(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f2544k.inflate(this.f2543j, viewGroup, false);
    }

    @Override // F0.a
    public View f(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f2544k.inflate(this.f2542i, viewGroup, false);
    }
}
