package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.widget.ArrayAdapter;

/* renamed from: androidx.appcompat.app.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0184j extends ArrayAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2619a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0184j(Context context, int i4, CharSequence[] charSequenceArr, int i5) {
        super(context, i4, R.id.text1, charSequenceArr);
        this.f2619a = i5;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final long getItemId(int i4) {
        switch (this.f2619a) {
        }
        return i4;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}
