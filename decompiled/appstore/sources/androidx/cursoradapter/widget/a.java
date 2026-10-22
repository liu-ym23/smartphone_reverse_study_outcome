package androidx.cursoradapter.widget;

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

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, CursorFilter.CursorFilterClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Cursor f2838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f2839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C0023a f2841f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DataSetObserver f2842g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CursorFilter f2843h;

    /* JADX INFO: renamed from: androidx.cursoradapter.widget.a$a, reason: collision with other inner class name */
    public class C0023a extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f2844a;

        public C0023a(a r10) {
            this.f2844a = r10;
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r10) {
            this.f2844a.e();
        }
    }

    public class b extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f2845a;

        public b(a r10) {
            this.f2845a = r10;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a r10 = this.f2845a;
            r10.f2836a = true;
            r10.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a r10 = this.f2845a;
            r10.f2836a = false;
            r10.notifyDataSetInvalidated();
        }
    }

    public a(Context r10, Cursor r11, boolean r12) {
        if (r12 == false) goto L5;
        int r13 = 1;
    L6:
        b(r10, r11, r13);
        return;
    L5:
        r13 = 2;
        goto L6
    }

    public abstract void a(View r10, Context r11, Cursor r12);

    public void b(Context r10, Cursor r11, int r12) {
        boolean r13 = false;
        if ((r12 & 1) != 1) goto L5;
        r12 = r12 | 2;
        this.f2837b = true;
    L6:
        if (r11 == null) goto L8;
        r13 = true;
    L8:
        this.f2838c = r11;
        this.f2836a = r13;
        this.f2839d = r10;
        if (r13 == false) goto L11;
        int r14 = r11.getColumnIndexOrThrow("_id");
    L12:
        this.f2840e = r14;
        if ((r12 & 2) != 2) goto L15;
        this.f2841f = new C0023a(this);
        this.f2842g = new b(this);
    L16:
        if (r13 == false) goto L24;
        C0023a r15 = this.f2841f;
        if (r15 == null) goto L20;
        r11.registerContentObserver(r15);
    L20:
        DataSetObserver r16 = this.f2842g;
        if (r16 == null) goto L25;
        r11.registerDataSetObserver(r16);
        return;
    L25:
        return;
    L24:
        return;
    L15:
        this.f2841f = null;
        this.f2842g = null;
        goto L16
    L11:
        r14 = -1;
        goto L12
    L5:
        this.f2837b = false;
        goto L6
    }

    public abstract View c(Context r10, Cursor r11, ViewGroup r12);

    public void changeCursor(Cursor r10) {
        Cursor r11 = f(r10);
        if (r11 == null) goto L6;
        r11.close();
        return;
    }

    public abstract CharSequence convertToString(Cursor r10);

    public abstract View d(Context r10, Cursor r11, ViewGroup r12);

    public void e() {
        if (this.f2837b == false) goto L10;
        Cursor r10 = this.f2838c;
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.isClosed() == true) goto L12;
        this.f2836a = this.f2838c.requery();
        return;
    L12:
        return;
    }

    public Cursor f(Cursor r10) {
        Cursor r11 = this.f2838c;
        if (r10 != r11) goto L6;
        return null;
    L6:
        if (r11 == null) goto L13;
        C0023a r12 = this.f2841f;
        if (r12 == null) goto L10;
        r11.unregisterContentObserver(r12);
    L10:
        DataSetObserver r13 = this.f2842g;
        if (r13 == null) goto L13;
        r11.unregisterDataSetObserver(r13);
    L13:
        this.f2838c = r10;
        if (r10 == null) goto L22;
        C0023a r14 = this.f2841f;
        if (r14 == null) goto L18;
        r10.registerContentObserver(r14);
    L18:
        DataSetObserver r15 = this.f2842g;
        if (r15 == null) goto L21;
        r10.registerDataSetObserver(r15);
    L21:
        this.f2840e = r10.getColumnIndexOrThrow("_id");
        this.f2836a = true;
        notifyDataSetChanged();
    L23:
        return r11;
    L22:
        this.f2840e = -1;
        this.f2836a = false;
        notifyDataSetInvalidated();
        goto L23
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f2836a == false) goto L8;
        Cursor r10 = this.f2838c;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getCount();
    L8:
        return 0;
    }

    @Override // androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public Cursor getCursor() {
        return this.f2838c;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int r10, View r11, ViewGroup r12) {
        if (this.f2836a == false) goto L9;
        this.f2838c.moveToPosition(r10);
        if (r11 != null) goto L7;
        r11 = c(this.f2839d, this.f2838c, r12);
    L7:
        a(r11, this.f2839d, this.f2838c);
        return r11;
    L9:
        return null;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f2843h != null) goto L6;
        this.f2843h = new CursorFilter(this);
    L6:
        return this.f2843h;
    }

    @Override // android.widget.Adapter
    public Object getItem(int r10) {
        if (this.f2836a == false) goto L8;
        Cursor r11 = this.f2838c;
        if (r11 == null) goto L10;
        r11.moveToPosition(r10);
        return this.f2838c;
    L10:
        return null;
    L8:
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int r10) {
        if (this.f2836a == false) goto L10;
        Cursor r11 = this.f2838c;
        if (r11 == null) goto L10;
        if (r11.moveToPosition(r10) == false) goto L10;
        return this.f2838c.getLong(this.f2840e);
    L10:
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int r10, View r11, ViewGroup r12) {
        if (this.f2836a == false) goto L13;
        if (this.f2838c.moveToPosition(r10) == false) goto L11;
        if (r11 != null) goto L8;
        r11 = d(this.f2839d, this.f2838c, r12);
    L8:
        a(r11, this.f2839d, this.f2838c);
        return r11;
    L11:
        throw new IllegalStateException("couldn't move cursor to position " + r10);
    L13:
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }
}
