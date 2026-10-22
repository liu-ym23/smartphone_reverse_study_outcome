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
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import com.ss.android.socialbase.downloader.constants.DBDefinition;

/* JADX INFO: loaded from: classes17.dex */
public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilter.CursorFilterClient {
    public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;
    protected boolean mAutoRequery;
    protected ChangeObserver mChangeObserver;
    protected Context mContext;
    protected Cursor mCursor;
    protected CursorFilter mCursorFilter;
    protected DataSetObserver mDataSetObserver;
    protected boolean mDataValid;
    protected FilterQueryProvider mFilterQueryProvider;
    protected int mRowIDColumn;

    public class ChangeObserver extends ContentObserver {
        final /* synthetic */ CursorAdapter this$0;

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        public ChangeObserver(CursorAdapter r100) {
            this.this$0 = r100;
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r100) {
            this.this$0.onContentChanged();
        }
    }

    public class MyDataSetObserver extends DataSetObserver {
        final /* synthetic */ CursorAdapter this$0;

        @Override // android.database.DataSetObserver
        public void onChanged() {
            CursorAdapter r100 = this.this$0;
            r100.mDataValid = true;
            r100.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            CursorAdapter r100 = this.this$0;
            r100.mDataValid = false;
            r100.notifyDataSetInvalidated();
        }

        public MyDataSetObserver(CursorAdapter r100) {
            this.this$0 = r100;
        }
    }

    public abstract void bindView(View r100, Context r101, Cursor r102);

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public abstract View newView(Context r100, Cursor r101, ViewGroup r102);

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mDataValid == false) goto L8;
        Cursor r100 = this.mCursor;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getCount();
    L8:
        return 0;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.mCursorFilter != null) goto L6;
        this.mCursorFilter = new CursorFilter(this);
    L6:
        return this.mCursorFilter;
    }

    public void onContentChanged() {
        if (this.mAutoRequery == false) goto L10;
        Cursor r100 = this.mCursor;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.isClosed() == true) goto L12;
        this.mDataValid = this.mCursor.requery();
        return;
    L12:
        return;
    }

    @Override // androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public Cursor getCursor() {
        return this.mCursor;
    }

    public FilterQueryProvider getFilterQueryProvider() {
        return this.mFilterQueryProvider;
    }

    public void changeCursor(Cursor r100) {
        Cursor r101 = swapCursor(r100);
        if (r101 == null) goto L6;
        r101.close();
        return;
    }

    public CharSequence convertToString(Cursor r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.toString();
    }

    @Override // android.widget.Adapter
    public Object getItem(int r100) {
        if (this.mDataValid == false) goto L8;
        Cursor r101 = this.mCursor;
        if (r101 == null) goto L10;
        r101.moveToPosition(r100);
        return this.mCursor;
    L10:
        return null;
    L8:
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int r100) {
        if (this.mDataValid == false) goto L10;
        Cursor r101 = this.mCursor;
        if (r101 == null) goto L10;
        if (r101.moveToPosition(r100) == false) goto L10;
        return this.mCursor.getLong(this.mRowIDColumn);
    L10:
        return 0;
    }

    public Cursor runQueryOnBackgroundThread(CharSequence r100) {
        FilterQueryProvider r101 = this.mFilterQueryProvider;
        if (r101 == null) goto L7;
        return r101.runQuery(r100);
    L7:
        return this.mCursor;
    }

    public void setFilterQueryProvider(FilterQueryProvider r100) {
        this.mFilterQueryProvider = r100;
    }

    public Cursor swapCursor(Cursor r100) {
        Cursor r101 = this.mCursor;
        if (r100 != r101) goto L6;
        return null;
    L6:
        if (r101 == null) goto L13;
        ChangeObserver r102 = this.mChangeObserver;
        if (r102 == null) goto L10;
        r101.unregisterContentObserver(r102);
    L10:
        DataSetObserver r103 = this.mDataSetObserver;
        if (r103 == null) goto L13;
        r101.unregisterDataSetObserver(r103);
    L13:
        this.mCursor = r100;
        if (r100 == null) goto L22;
        ChangeObserver r104 = this.mChangeObserver;
        if (r104 == null) goto L18;
        r100.registerContentObserver(r104);
    L18:
        DataSetObserver r105 = this.mDataSetObserver;
        if (r105 == null) goto L21;
        r100.registerDataSetObserver(r105);
    L21:
        this.mRowIDColumn = r100.getColumnIndexOrThrow(DBDefinition.ID);
        this.mDataValid = true;
        notifyDataSetChanged();
    L23:
        return r101;
    L22:
        this.mRowIDColumn = -1;
        this.mDataValid = false;
        notifyDataSetInvalidated();
        goto L23
    }

    public CursorAdapter(Context r100, Cursor r101) {
        init(r100, r101, 1);
    }

    public CursorAdapter(Context r100, Cursor r101, boolean r102) {
        if (r102 == false) goto L5;
        int r103 = 1;
    L6:
        init(r100, r101, r103);
        return;
    L5:
        r103 = 2;
        goto L6
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int r100, View r101, ViewGroup r102) {
        if (this.mDataValid == false) goto L9;
        this.mCursor.moveToPosition(r100);
        if (r101 != null) goto L7;
        r101 = newDropDownView(this.mContext, this.mCursor, r102);
    L7:
        bindView(r101, this.mContext, this.mCursor);
        return r101;
    L9:
        return null;
    }

    @Override // android.widget.Adapter
    public View getView(int r100, View r101, ViewGroup r102) {
        if (this.mDataValid == false) goto L13;
        if (this.mCursor.moveToPosition(r100) == false) goto L11;
        if (r101 != null) goto L8;
        r101 = newView(this.mContext, this.mCursor, r102);
    L8:
        bindView(r101, this.mContext, this.mCursor);
        return r101;
    L11:
        throw new IllegalStateException("couldn't move cursor to position " + r100);
    L13:
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }

    public void init(Context r100, Cursor r101, int r102) {
        boolean r103 = false;
        if ((r102 & 1) != 1) goto L5;
        r102 = r102 | 2;
        this.mAutoRequery = true;
    L6:
        if (r101 == null) goto L8;
        r103 = true;
    L8:
        this.mCursor = r101;
        this.mDataValid = r103;
        this.mContext = r100;
        if (r103 == false) goto L11;
        int r104 = r101.getColumnIndexOrThrow(DBDefinition.ID);
    L12:
        this.mRowIDColumn = r104;
        if ((r102 & 2) != 2) goto L15;
        this.mChangeObserver = new ChangeObserver(this);
        this.mDataSetObserver = new MyDataSetObserver(this);
    L16:
        if (r103 == false) goto L24;
        ChangeObserver r105 = this.mChangeObserver;
        if (r105 == null) goto L20;
        r101.registerContentObserver(r105);
    L20:
        DataSetObserver r106 = this.mDataSetObserver;
        if (r106 == null) goto L25;
        r101.registerDataSetObserver(r106);
        return;
    L25:
        return;
    L24:
        return;
    L15:
        this.mChangeObserver = null;
        this.mDataSetObserver = null;
        goto L16
    L11:
        r104 = -1;
        goto L12
    L5:
        this.mAutoRequery = false;
        goto L6
    }

    public View newDropDownView(Context r100, Cursor r101, ViewGroup r102) {
        return newView(r100, r101, r102);
    }

    public CursorAdapter(Context r100, Cursor r101, int r102) {
        init(r100, r101, r102);
    }

    public void init(Context r100, Cursor r101, boolean r102) {
        if (r102 == false) goto L4;
        int r103 = 1;
    L5:
        init(r100, r101, r103);
        return;
    L4:
        r103 = 2;
        goto L5
    }
}
