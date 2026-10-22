package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.widget.Filter;

/* JADX INFO: loaded from: classes17.dex */
class CursorFilter extends Filter {
    CursorFilterClient mClient;

    public interface CursorFilterClient {
        void changeCursor(Cursor r100);

        CharSequence convertToString(Cursor r100);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence r100);
    }

    public CursorFilter(CursorFilterClient r100) {
        this.mClient = r100;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object r100) {
        return this.mClient.convertToString((Cursor) r100);
    }

    @Override // android.widget.Filter
    public Filter.FilterResults performFiltering(CharSequence r100) {
        Cursor r101 = this.mClient.runQueryOnBackgroundThread(r100);
        Filter.FilterResults r102 = new Filter.FilterResults();
        if (r101 == null) goto L5;
        r102.count = r101.getCount();
        r102.values = r101;
    L6:
        return r102;
    L5:
        r102.count = 0;
        r102.values = null;
        goto L6
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence r100, Filter.FilterResults r101) {
        Cursor r102 = this.mClient.getCursor();
        Object r103 = r101.values;
        if (r103 == null) goto L7;
        if (r103 == r102) goto L8;
        this.mClient.changeCursor((Cursor) r103);
        return;
    L8:
        return;
    }
}
