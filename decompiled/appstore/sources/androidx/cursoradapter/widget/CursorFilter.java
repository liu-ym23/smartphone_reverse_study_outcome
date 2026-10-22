package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.widget.Filter;

/* JADX INFO: loaded from: classes.dex */
public class CursorFilter extends Filter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CursorFilterClient f2835a;

    public interface CursorFilterClient {
        void changeCursor(Cursor r10);

        CharSequence convertToString(Cursor r10);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence r10);
    }

    public CursorFilter(CursorFilterClient r10) {
        this.f2835a = r10;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object r10) {
        return this.f2835a.convertToString((Cursor) r10);
    }

    @Override // android.widget.Filter
    public Filter.FilterResults performFiltering(CharSequence r10) {
        Cursor r11 = this.f2835a.runQueryOnBackgroundThread(r10);
        Filter.FilterResults r12 = new Filter.FilterResults();
        if (r11 == null) goto L5;
        r12.count = r11.getCount();
        r12.values = r11;
    L6:
        return r12;
    L5:
        r12.count = 0;
        r12.values = null;
        goto L6
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence r10, Filter.FilterResults r11) {
        Cursor r12 = this.f2835a.getCursor();
        Object r13 = r11.values;
        if (r13 == null) goto L7;
        if (r13 == r12) goto L8;
        this.f2835a.changeCursor((Cursor) r13);
        return;
    L8:
        return;
    }
}
