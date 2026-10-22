package com.obric.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.AsyncTask;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ObricCursorRecyclerViewAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0002*+B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u001a\u001a\u00020\u0018J\b\u0010\u001b\u001a\u0004\u0018\u00010\fJ\b\u0010\u001c\u001a\u00020\u0016H\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0016H\u0016J\u001d\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00028\u00002\u0006\u0010\"\u001a\u00020\fH&¢\u0006\u0002\u0010#J\u001d\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010$J\n\u0010%\u001a\u0004\u0018\u00010\fH$J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0012H\u0016J\u0006\u0010(\u001a\u00020\u0018J\u0012\u0010)\u001a\u0004\u0018\u00010\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0018\u00010\u0014R\b\u0012\u0004\u0012\u00028\u00000\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/obric/utils/ObricCursorRecyclerViewAdapter;", "VH", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "cursorObserver", "Lcom/obric/utils/ObricCursorRecyclerViewAdapter$DataObserver;", "dataCursor", "Landroid/database/Cursor;", "idColumnName", "", "getIdColumnName", "()Ljava/lang/String;", "isDataValid", "", "queryTask", "Lcom/obric/utils/ObricCursorRecyclerViewAdapter$QueryTask;", "rowIdentifierIndex", "", "changeCursor", "", "newCursor", "destroy", "getCursor", "getItemCount", "getItemId", "", "position", "onBindViewHolder", "holder", "cursor", "(Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;Landroid/database/Cursor;)V", "(Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;I)V", "query", "setHasStableIds", "hasStableIds", "startQuery", "swapCursor", "DataObserver", "QueryTask", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ObricCursorRecyclerViewAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private final Context context;
    private final ObricCursorRecyclerViewAdapter<VH>.DataObserver cursorObserver;
    private Cursor dataCursor;
    private final String idColumnName;
    private boolean isDataValid;
    private ObricCursorRecyclerViewAdapter<VH>.QueryTask queryTask;
    private int rowIdentifierIndex;

    /* JADX INFO: compiled from: ObricCursorRecyclerViewAdapter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/obric/utils/ObricCursorRecyclerViewAdapter$DataObserver;", "Landroid/database/DataSetObserver;", "(Lcom/obric/utils/ObricCursorRecyclerViewAdapter;)V", "onChanged", "", "onInvalidated", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class DataObserver extends DataSetObserver {
        final /* synthetic */ ObricCursorRecyclerViewAdapter<VH> this$0;

        public DataObserver(ObricCursorRecyclerViewAdapter r1) {
            this.this$0 = r1;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ObricCursorRecyclerViewAdapter.access$setDataValid$p(this.this$0, true);
            this.this$0.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
            ObricCursorRecyclerViewAdapter.access$setDataValid$p(this.this$0, false);
            this.this$0.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: ObricCursorRecyclerViewAdapter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0007\"\u00020\u0002H\u0014¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0014¨\u0006\f"}, d2 = {"Lcom/obric/utils/ObricCursorRecyclerViewAdapter$QueryTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "Landroid/database/Cursor;", "(Lcom/obric/utils/ObricCursorRecyclerViewAdapter;)V", "doInBackground", "params", "", "([Ljava/lang/Void;)Landroid/database/Cursor;", "onPostExecute", "", "result", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class QueryTask extends AsyncTask<Void, Void, Cursor> {
        final /* synthetic */ ObricCursorRecyclerViewAdapter<VH> this$0;

        public QueryTask(ObricCursorRecyclerViewAdapter r1) {
            this.this$0 = r1;
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Cursor doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(Cursor r1) {
            onPostExecute2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Cursor doInBackground2(Void... r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            return this.this$0.query();
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Cursor r1) {
            super.onPostExecute(r1);
            this.this$0.changeCursor(r1);
        }
    }

    public abstract void onBindViewHolder(VH r1, Cursor r2);

    protected abstract Cursor query();

    public static final /* synthetic */ void access$setDataValid$p(ObricCursorRecyclerViewAdapter r0, boolean r1) {
        r0.isDataValid = r1;
    }

    protected final Context getContext() {
        return this.context;
    }

    public ObricCursorRecyclerViewAdapter(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.context = r5;
        int r6 = -1;
        this.rowIdentifierIndex = -1;
        ObricCursorRecyclerViewAdapter<VH>.DataObserver r0 = new DataObserver(this);
        this.cursorObserver = r0;
        Cursor r1 = this.dataCursor;
        if (r1 == null) goto L5;
        boolean r2 = true;
    L6:
        this.isDataValid = r2;
        if (r2 == false) goto L9;
        Intrinsics.checkNotNull(r1);
        r6 = r1.getColumnIndex("_id");
    L9:
        this.rowIdentifierIndex = r6;
        if (r1 == null) goto L12;
        r1.registerDataSetObserver(r0);
    L12:
        this.idColumnName = "_id";
        return;
    L5:
        r2 = false;
        goto L6
    }

    public final Cursor getCursor() {
        return this.dataCursor;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.isDataValid == false) goto L7;
        Cursor r1 = this.dataCursor;
        if (r1 == null) goto L7;
        Intrinsics.checkNotNull(r1);
        return r1.getCount();
    L7:
        return 0;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r3) {
        if (this.isDataValid == false) goto L11;
        Cursor r0 = this.dataCursor;
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == false) goto L11;
        Cursor r4 = this.dataCursor;
        Intrinsics.checkNotNull(r4);
        return r4.getLong(this.rowIdentifierIndex);
    L7:
        if (r0.moveToPosition(r3) != true) goto L9;
        r1 = true;
    L11:
        return 0;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean r1) {
        super.setHasStableIds(true);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(VH r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        if (this.isDataValid == false) goto L15;
        Cursor r0 = this.dataCursor;
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == false) goto L13;
        Cursor r6 = this.dataCursor;
        Intrinsics.checkNotNull(r6);
        onBindViewHolder(r4, r6);
        return;
    L13:
        throw new IllegalStateException(("Couldn't move to position " + r5).toString());
    L7:
        if (r0.moveToPosition(r5) != true) goto L9;
        r1 = true;
        goto L9
    L15:
        throw new IllegalStateException("Should only be called with valid cursor".toString());
    }

    public final void changeCursor(Cursor r1) {
        Cursor r0 = swapCursor(r1);
        if (r0 == null) goto L6;
        r0.close();
        return;
    }

    public final Cursor swapCursor(Cursor r3) {
        if (Intrinsics.areEqual(r3, this.dataCursor) == false) goto L6;
        return null;
    L6:
        Cursor r0 = this.dataCursor;
        if (r0 == null) goto L9;
        r0.unregisterDataSetObserver(this.cursorObserver);
    L9:
        if (r3 == null) goto L11;
        r3.registerDataSetObserver(this.cursorObserver);
    L11:
        if (r3 == null) goto L13;
        int r1 = r3.getColumnIndexOrThrow(getIdColumnName());
    L14:
        this.rowIdentifierIndex = r1;
        if (r3 == null) goto L17;
        boolean r2 = true;
    L18:
        this.isDataValid = r2;
        this.dataCursor = r3;
        notifyDataSetChanged();
        return r0;
    L17:
        r2 = false;
        goto L18
    L13:
        r1 = -1;
        goto L14
    }

    protected String getIdColumnName() {
        return this.idColumnName;
    }

    public final void startQuery() {
        ObricCursorRecyclerViewAdapter<VH>.QueryTask r0 = this.queryTask;
        if (r0 == null) goto L5;
        r0.cancel(true);
    L5:
        ObricCursorRecyclerViewAdapter<VH>.QueryTask r1 = new QueryTask(this);
        r1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        this.queryTask = r1;
    }

    public final void destroy() {
        ObricCursorRecyclerViewAdapter<VH>.QueryTask r0 = this.queryTask;
        if (r0 == null) goto L5;
        r0.cancel(true);
    L5:
        this.queryTask = null;
        Cursor r1 = this.dataCursor;
        if (r1 == null) goto L8;
        r1.close();
    L8:
        swapCursor(null);
    }
}
