package H;

import H.b;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

/* loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f1939a;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f1940b;

    /* renamed from: c, reason: collision with root package name */
    protected Cursor f1941c;

    /* renamed from: d, reason: collision with root package name */
    protected Context f1942d;

    /* renamed from: e, reason: collision with root package name */
    protected int f1943e;

    /* renamed from: f, reason: collision with root package name */
    protected C0030a f1944f;

    /* renamed from: g, reason: collision with root package name */
    protected DataSetObserver f1945g;

    /* renamed from: h, reason: collision with root package name */
    protected H.b f1946h;

    /* renamed from: H.a$a, reason: collision with other inner class name */
    private class C0030a extends ContentObserver {
        C0030a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z5) {
            a.this.h();
        }
    }

    private class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f1939a = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f1939a = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z5) {
        e(context, cursor, z5 ? 1 : 2);
    }

    @Override // H.b.a
    public void a(Cursor cursor) {
        Cursor cursorI = i(cursor);
        if (cursorI != null) {
            cursorI.close();
        }
    }

    @Override // H.b.a
    public Cursor b() {
        return this.f1941c;
    }

    public abstract void d(View view, Context context, Cursor cursor);

    void e(Context context, Cursor cursor, int i5) {
        if ((i5 & 1) == 1) {
            i5 |= 2;
            this.f1940b = true;
        } else {
            this.f1940b = false;
        }
        boolean z5 = cursor != null;
        this.f1941c = cursor;
        this.f1939a = z5;
        this.f1942d = context;
        this.f1943e = z5 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i5 & 2) == 2) {
            this.f1944f = new C0030a();
            this.f1945g = new b();
        } else {
            this.f1944f = null;
            this.f1945g = null;
        }
        if (z5) {
            C0030a c0030a = this.f1944f;
            if (c0030a != null) {
                cursor.registerContentObserver(c0030a);
            }
            DataSetObserver dataSetObserver = this.f1945g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View f(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f1939a || (cursor = this.f1941c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i5, View view, ViewGroup viewGroup) {
        if (!this.f1939a) {
            return null;
        }
        this.f1941c.moveToPosition(i5);
        if (view == null) {
            view = f(this.f1942d, this.f1941c, viewGroup);
        }
        d(view, this.f1942d, this.f1941c);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f1946h == null) {
            this.f1946h = new H.b(this);
        }
        return this.f1946h;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i5) {
        Cursor cursor;
        if (!this.f1939a || (cursor = this.f1941c) == null) {
            return null;
        }
        cursor.moveToPosition(i5);
        return this.f1941c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i5) {
        Cursor cursor;
        if (this.f1939a && (cursor = this.f1941c) != null && cursor.moveToPosition(i5)) {
            return this.f1941c.getLong(this.f1943e);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i5, View view, ViewGroup viewGroup) {
        if (!this.f1939a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f1941c.moveToPosition(i5)) {
            if (view == null) {
                view = g(this.f1942d, this.f1941c, viewGroup);
            }
            d(view, this.f1942d, this.f1941c);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i5);
    }

    protected void h() {
        Cursor cursor;
        if (!this.f1940b || (cursor = this.f1941c) == null || cursor.isClosed()) {
            return;
        }
        this.f1939a = this.f1941c.requery();
    }

    public Cursor i(Cursor cursor) {
        Cursor cursor2 = this.f1941c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0030a c0030a = this.f1944f;
            if (c0030a != null) {
                cursor2.unregisterContentObserver(c0030a);
            }
            DataSetObserver dataSetObserver = this.f1945g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1941c = cursor;
        if (cursor == null) {
            this.f1943e = -1;
            this.f1939a = false;
            notifyDataSetInvalidated();
            return cursor2;
        }
        C0030a c0030a2 = this.f1944f;
        if (c0030a2 != null) {
            cursor.registerContentObserver(c0030a2);
        }
        DataSetObserver dataSetObserver2 = this.f1945g;
        if (dataSetObserver2 != null) {
            cursor.registerDataSetObserver(dataSetObserver2);
        }
        this.f1943e = cursor.getColumnIndexOrThrow("_id");
        this.f1939a = true;
        notifyDataSetChanged();
        return cursor2;
    }
}
