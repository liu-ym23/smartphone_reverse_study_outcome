package stepos.support.v7.app;

import android.content.Context;
import android.widget.ArrayAdapter;

/* renamed from: stepos.support.v7.app.f, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1957f extends ArrayAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6312a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1957f(Context context, int i, int i6, Object[] objArr, int i10) {
        super(context, i, i6, objArr);
        this.f6312a = i10;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final long getItemId(int i) {
        switch (this.f6312a) {
        }
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        switch (this.f6312a) {
        }
        return true;
    }
}
