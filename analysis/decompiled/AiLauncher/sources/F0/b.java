package F0;

import android.database.Cursor;
import android.widget.Filter;

/* loaded from: classes.dex */
public class b extends Filter {

    /* renamed from: a, reason: collision with root package name */
    public a f2541a;

    public interface a {
        void a(Cursor cursor);

        Cursor b(CharSequence charSequence);

        CharSequence convertToString(Cursor cursor);

        Cursor getCursor();
    }

    public b(a aVar) {
        this.f2541a = aVar;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.f2541a.convertToString((Cursor) obj);
    }

    @Override // android.widget.Filter
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor cursorB = this.f2541a.b(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (cursorB != null) {
            filterResults.count = cursorB.getCount();
            filterResults.values = cursorB;
            return filterResults;
        }
        filterResults.count = 0;
        filterResults.values = null;
        return filterResults;
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor cursor = this.f2541a.getCursor();
        Object obj = filterResults.values;
        if (obj == null || obj == cursor) {
            return;
        }
        this.f2541a.a((Cursor) obj);
    }
}
