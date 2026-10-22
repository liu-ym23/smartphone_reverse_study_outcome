package p3;

import android.content.Context;
import android.widget.ArrayAdapter;

/* loaded from: classes.dex */
public final class q extends ArrayAdapter<CharSequence> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(Context context, int i5, int i6, CharSequence[] charSequenceArr) {
        super(context, i5, i6, charSequenceArr);
        j4.k.g(context, "context");
        j4.k.g(charSequenceArr, "objects");
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i5) {
        return i5;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}
