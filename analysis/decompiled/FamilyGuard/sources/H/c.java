package H;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class c extends a {

    /* renamed from: i, reason: collision with root package name */
    private int f1950i;

    /* renamed from: j, reason: collision with root package name */
    private int f1951j;

    /* renamed from: k, reason: collision with root package name */
    private LayoutInflater f1952k;

    @Deprecated
    public c(Context context, int i5, Cursor cursor, boolean z5) {
        super(context, cursor, z5);
        this.f1951j = i5;
        this.f1950i = i5;
        this.f1952k = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // H.a
    public View f(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1952k.inflate(this.f1951j, viewGroup, false);
    }

    @Override // H.a
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1952k.inflate(this.f1950i, viewGroup, false);
    }
}
