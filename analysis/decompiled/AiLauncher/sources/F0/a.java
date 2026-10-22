package F0;

import F0.b;
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
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;

/* loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2531a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2532b;

    /* renamed from: c, reason: collision with root package name */
    public Cursor f2533c;

    /* renamed from: d, reason: collision with root package name */
    public Context f2534d;

    /* renamed from: e, reason: collision with root package name */
    public int f2535e;

    /* renamed from: f, reason: collision with root package name */
    public C0029a f2536f;

    /* renamed from: g, reason: collision with root package name */
    public DataSetObserver f2537g;

    /* renamed from: h, reason: collision with root package name */
    public F0.b f2538h;

    /* renamed from: F0.a$a, reason: collision with other inner class name */
    public class C0029a extends ContentObserver {
        public C0029a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            a.this.g();
        }
    }

    public class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f2531a = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f2531a = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z10) {
        d(context, cursor, z10 ? 1 : 2);
    }

    @Override // F0.b.a
    public void a(Cursor cursor) {
        Cursor cursorH = h(cursor);
        if (cursorH != null) {
            cursorH.close();
        }
    }

    public abstract void c(View view, Context context, Cursor cursor);

    public void d(Context context, Cursor cursor, int i10) {
        if ((i10 & 1) == 1) {
            i10 |= 2;
            this.f2532b = true;
        } else {
            this.f2532b = false;
        }
        boolean z10 = cursor != null;
        this.f2533c = cursor;
        this.f2531a = z10;
        this.f2534d = context;
        this.f2535e = z10 ? cursor.getColumnIndexOrThrow(StepOSRecipientEmailHistory._ID) : -1;
        if ((i10 & 2) == 2) {
            this.f2536f = new C0029a();
            this.f2537g = new b();
        } else {
            this.f2536f = null;
            this.f2537g = null;
        }
        if (z10) {
            C0029a c0029a = this.f2536f;
            if (c0029a != null) {
                cursor.registerContentObserver(c0029a);
            }
            DataSetObserver dataSetObserver = this.f2537g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View e(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract View f(Context context, Cursor cursor, ViewGroup viewGroup);

    public void g() {
        Cursor cursor;
        if (!this.f2532b || (cursor = this.f2533c) == null || cursor.isClosed()) {
            return;
        }
        this.f2531a = this.f2533c.requery();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f2531a || (cursor = this.f2533c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // F0.b.a
    public Cursor getCursor() {
        return this.f2533c;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        if (!this.f2531a) {
            return null;
        }
        this.f2533c.moveToPosition(i10);
        if (view == null) {
            view = e(this.f2534d, this.f2533c, viewGroup);
        }
        c(view, this.f2534d, this.f2533c);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f2538h == null) {
            this.f2538h = new F0.b(this);
        }
        return this.f2538h;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        Cursor cursor;
        if (!this.f2531a || (cursor = this.f2533c) == null) {
            return null;
        }
        cursor.moveToPosition(i10);
        return this.f2533c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        Cursor cursor;
        if (this.f2531a && (cursor = this.f2533c) != null && cursor.moveToPosition(i10)) {
            return this.f2533c.getLong(this.f2535e);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (!this.f2531a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f2533c.moveToPosition(i10)) {
            if (view == null) {
                view = f(this.f2534d, this.f2533c, viewGroup);
            }
            c(view, this.f2534d, this.f2533c);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i10);
    }

    public Cursor h(Cursor cursor) {
        Cursor cursor2 = this.f2533c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0029a c0029a = this.f2536f;
            if (c0029a != null) {
                cursor2.unregisterContentObserver(c0029a);
            }
            DataSetObserver dataSetObserver = this.f2537g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f2533c = cursor;
        if (cursor == null) {
            this.f2535e = -1;
            this.f2531a = false;
            notifyDataSetInvalidated();
            return cursor2;
        }
        C0029a c0029a2 = this.f2536f;
        if (c0029a2 != null) {
            cursor.registerContentObserver(c0029a2);
        }
        DataSetObserver dataSetObserver2 = this.f2537g;
        if (dataSetObserver2 != null) {
            cursor.registerDataSetObserver(dataSetObserver2);
        }
        this.f2535e = cursor.getColumnIndexOrThrow(StepOSRecipientEmailHistory._ID);
        this.f2531a = true;
        notifyDataSetChanged();
        return cursor2;
    }
}
