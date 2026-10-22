package com.stepos.widget.recipient;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\f\b&\u0018\u0000 c2\u00020\u0001:\u0002dcB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u000f\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0019\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u001d\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u000eH\u0004¢\u0006\u0004\b \u0010\u0018J\r\u0010!\u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u000eH\u0004¢\u0006\u0004\b#\u0010\u0018J\u0015\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010$J\u000f\u0010%\u001a\u00020\u0006H\u0016¢\u0006\u0004\b%\u0010\"J\u0017\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b'\u0010(J!\u0010*\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010&H\u0007¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b,\u0010$J\u0015\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006¢\u0006\u0004\b.\u0010/J\u0015\u00100\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006¢\u0006\u0004\b0\u0010/J\u0015\u00101\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006¢\u0006\u0004\b1\u0010/J\u0015\u00102\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b2\u0010/J\u000f\u00103\u001a\u00020\u0006H\u0016¢\u0006\u0004\b3\u0010\"J\u000f\u00104\u001a\u00020\u0006H\u0016¢\u0006\u0004\b4\u0010\"J\u001f\u00105\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0014¢\u0006\u0004\b5\u00106J\u0017\u00105\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0016¢\u0006\u0004\b5\u0010/J)\u0010;\u001a\u0002072\u0006\u0010-\u001a\u00020\u00062\b\u00108\u001a\u0004\u0018\u0001072\u0006\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b;\u0010<J5\u0010=\u001a\u0004\u0018\u0001072\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010&2\b\u00108\u001a\u0004\u0018\u0001072\u0006\u0010:\u001a\u000209H\u0014¢\u0006\u0004\b=\u0010>J3\u0010?\u001a\u0004\u0018\u0001072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010&2\u0006\u0010:\u001a\u000209H\u0014¢\u0006\u0004\b?\u0010@J)\u0010B\u001a\u00020\u000e2\u0006\u0010A\u001a\u0002072\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010&H\u0014¢\u0006\u0004\bB\u0010CJ9\u0010;\u001a\u0002072\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010)\u001a\u00020&2\u0006\u0010-\u001a\u00020\u00062\b\u00108\u001a\u0004\u0018\u0001072\u0006\u0010:\u001a\u000209H\u0014¢\u0006\u0004\b;\u0010DJ7\u0010E\u001a\u0002072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010)\u001a\u00020&2\u0006\u0010-\u001a\u00020\u00062\u0006\u0010:\u001a\u000209H$¢\u0006\u0004\bE\u0010FJ/\u0010H\u001a\u00020\u000e2\u0006\u0010G\u001a\u0002072\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010)\u001a\u00020&2\u0006\u0010-\u001a\u00020\u0006H$¢\u0006\u0004\bH\u0010IJ\u0019\u0010K\u001a\u0004\u0018\u00010J2\u0006\u0010-\u001a\u00020\u0006H\u0016¢\u0006\u0004\bK\u0010LJ\u0017\u0010N\u001a\u00020M2\u0006\u0010-\u001a\u00020\u0006H\u0016¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\u000bH\u0016¢\u0006\u0004\bP\u0010QJ\u0017\u0010R\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u0006H\u0016¢\u0006\u0004\bR\u0010$J\u001f\u0010R\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0014¢\u0006\u0004\bR\u0010SJ\u0017\u0010T\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000bH\u0007¢\u0006\u0004\bT\u0010UJ\u000f\u0010V\u001a\u00020\u000eH\u0016¢\u0006\u0004\bV\u0010\u0018R\u0014\u0010W\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u001e\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010\\\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010^\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010]R\u0016\u0010_\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010a\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010`R\u0016\u0010b\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010`¨\u0006e"}, d2 = {"Lcom/stepos/widget/recipient/StepOSCompositeCursorAdapter;", "Landroid/widget/BaseAdapter;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "initialCapacity", "(Landroid/content/Context;I)V", "getContext", "()Landroid/content/Context;", "", "showIfEmpty", "hasHeader", "LY8/t;", "addPartition", "(ZZ)V", "Lcom/stepos/widget/recipient/StepOSCompositeCursorAdapter$Partition;", "partition", "(Lcom/stepos/widget/recipient/StepOSCompositeCursorAdapter$Partition;)V", "partitionIndex", "removePartition", "(I)V", "clearPartitions", "()V", "close", "flag", "setHasHeader", "(IZ)V", "setShowIfEmpty", "getPartition", "(I)Lcom/stepos/widget/recipient/StepOSCompositeCursorAdapter$Partition;", "invalidate", "getPartitionCount", "()I", "ensureCacheValid", "(I)Z", "getCount", "Landroid/database/Cursor;", "getCursor", "(I)Landroid/database/Cursor;", "cursor", "changeCursor", "(ILandroid/database/Cursor;)V", "isPartitionEmpty", "position", "getPartitionForPosition", "(I)I", "getCursorIndexForPosition", "getOffsetInPartition", "getPositionForPartition", "getViewTypeCount", "getItemViewTypeCount", "getItemViewType", "(II)I", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", "parent", "getView", "(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;", "getHeaderView", "(ILandroid/database/Cursor;Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;", "newHeaderView", "(Landroid/content/Context;ILandroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;", "view", "bindHeaderView", "(Landroid/view/View;ILandroid/database/Cursor;)V", "(ILandroid/database/Cursor;ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;", "newView", "(Landroid/content/Context;ILandroid/database/Cursor;ILandroid/view/ViewGroup;)Landroid/view/View;", "v", "bindView", "(Landroid/view/View;ILandroid/database/Cursor;I)V", "", "getItem", "(I)Ljava/lang/Object;", "", "getItemId", "(I)J", "areAllItemsEnabled", "()Z", "isEnabled", "(II)Z", "setNotificationsEnabled", "(Z)V", "notifyDataSetChanged", "appContext", "Landroid/content/Context;", "", "partitions", "[Lcom/stepos/widget/recipient/StepOSCompositeCursorAdapter$Partition;", ContentDisposition.Parameters.Size, "I", "cachedCount", "cacheValid", "Z", "notificationsEnabled", "notificationNeeded", "Companion", "Partition", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class StepOSCompositeCursorAdapter extends BaseAdapter {
    private static final int INITIAL_CAPACITY = 2;
    private final Context appContext;
    private boolean cacheValid;
    private int cachedCount;
    private boolean notificationNeeded;
    private boolean notificationsEnabled;
    private Partition[] partitions;
    private int size;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/stepos/widget/recipient/StepOSCompositeCursorAdapter$Partition;", "", "showIfEmpty", "", "hasHeader", "<init>", "(ZZ)V", "getShowIfEmpty", "()Z", "setShowIfEmpty", "(Z)V", "getHasHeader", "setHasHeader", "cursor", "Landroid/database/Cursor;", "getCursor", "()Landroid/database/Cursor;", "setCursor", "(Landroid/database/Cursor;)V", "idColumnIndex", "", "getIdColumnIndex", "()I", "setIdColumnIndex", "(I)V", "count", "getCount", "setCount", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class Partition {
        private int count;
        private Cursor cursor;
        private boolean hasHeader;
        private int idColumnIndex = -1;
        private boolean showIfEmpty;

        public Partition(boolean z10, boolean z11) {
            this.showIfEmpty = z10;
            this.hasHeader = z11;
        }

        public final int getCount() {
            return this.count;
        }

        public final Cursor getCursor() {
            return this.cursor;
        }

        public final boolean getHasHeader() {
            return this.hasHeader;
        }

        public final int getIdColumnIndex() {
            return this.idColumnIndex;
        }

        public final boolean getShowIfEmpty() {
            return this.showIfEmpty;
        }

        public final void setCount(int i10) {
            this.count = i10;
        }

        public final void setCursor(Cursor cursor) {
            this.cursor = cursor;
        }

        public final void setHasHeader(boolean z10) {
            this.hasHeader = z10;
        }

        public final void setIdColumnIndex(int i10) {
            this.idColumnIndex = i10;
        }

        public final void setShowIfEmpty(boolean z10) {
            this.showIfEmpty = z10;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSCompositeCursorAdapter(Context context) {
        this(context, 2);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public final void addPartition(boolean showIfEmpty, boolean hasHeader) {
        addPartition(new Partition(showIfEmpty, hasHeader));
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        int i10 = this.size;
        for (int i11 = 0; i11 < i10; i11++) {
            Partition partition = this.partitions[i11];
            if (partition != null && partition.getHasHeader()) {
                return false;
            }
        }
        return true;
    }

    public void bindHeaderView(View view, int partition, Cursor cursor) {
        kotlin.jvm.internal.p.i(view, "view");
    }

    public abstract void bindView(View v10, int partition, Cursor cursor, int position);

    public final void changeCursor(int partition, Cursor cursor) {
        Partition partition2 = this.partitions[partition];
        Cursor cursor2 = partition2 != null ? partition2.getCursor() : null;
        if (cursor2 != cursor) {
            if (cursor2 != null && !cursor2.isClosed()) {
                cursor2.close();
            }
            Partition partition3 = getPartition(partition);
            partition3.setCursor(cursor);
            if (cursor != null) {
                partition3.setIdColumnIndex(cursor.getColumnIndex(StepOSRecipientEmailHistory._ID));
            }
            invalidate();
            notifyDataSetChanged();
        }
    }

    public final void clearPartitions() {
        int i10 = this.size;
        for (int i11 = 0; i11 < i10; i11++) {
            Partition partition = this.partitions[i11];
            if (partition != null) {
                partition.setCursor(null);
            }
        }
        invalidate();
        notifyDataSetChanged();
    }

    public final void close() {
        int i10 = this.size;
        for (int i11 = 0; i11 < i10; i11++) {
            Partition partition = this.partitions[i11];
            Cursor cursor = partition != null ? partition.getCursor() : null;
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
                Partition partition2 = this.partitions[i11];
                if (partition2 != null) {
                    partition2.setCursor(null);
                }
            }
        }
        this.size = 0;
        invalidate();
        notifyDataSetChanged();
    }

    public final void ensureCacheValid() {
        if (this.cacheValid) {
            return;
        }
        this.cachedCount = 0;
        int i10 = this.size;
        for (int i11 = 0; i11 < i10; i11++) {
            Partition partition = this.partitions[i11];
            if (partition != null) {
                Cursor cursor = partition.getCursor();
                int count = cursor != null ? cursor.getCount() : 0;
                if (partition.getHasHeader() && (count != 0 || partition.getShowIfEmpty())) {
                    count++;
                }
                partition.setCount(count);
                this.cachedCount += count;
            }
        }
        this.cacheValid = true;
    }

    /* renamed from: getContext, reason: from getter */
    public final Context getAppContext() {
        return this.appContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ensureCacheValid();
        return this.cachedCount;
    }

    public final Cursor getCursor(int partition) {
        Partition partition2 = this.partitions[partition];
        if (partition2 != null) {
            return partition2.getCursor();
        }
        return null;
    }

    public final int getCursorIndexForPosition(int position) {
        int i10 = this.size;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10) {
            Partition partition = this.partitions[i11];
            int count = (partition != null ? partition.getCount() : 0) + i12;
            if (position >= i12 && position < count) {
                return position - i12;
            }
            i11++;
            i12 = count;
        }
        return -1;
    }

    public View getHeaderView(int partition, Cursor cursor, View convertView, ViewGroup parent) {
        kotlin.jvm.internal.p.i(parent, "parent");
        if (convertView == null && (convertView = newHeaderView(this.appContext, partition, cursor, parent)) == null) {
            return null;
        }
        bindHeaderView(convertView, partition, cursor);
        return convertView;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        ensureCacheValid();
        int i10 = this.size;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Partition partition = this.partitions[i12];
            if (partition != null) {
                int count = partition.getCount() + i11;
                if (position >= i11 && position < count) {
                    int i13 = position - i11;
                    if (partition.getHasHeader()) {
                        i13--;
                    }
                    if (i13 == -1) {
                        return null;
                    }
                    Cursor cursor = partition.getCursor();
                    if (cursor != null) {
                        cursor.moveToPosition(i13);
                    }
                    return cursor;
                }
                i11 = count;
            }
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        Cursor cursor;
        ensureCacheValid();
        int i10 = this.size;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Partition partition = this.partitions[i12];
            if (partition != null) {
                int count = partition.getCount() + i11;
                if (position >= i11 && position < count) {
                    int i13 = position - i11;
                    if (partition.getHasHeader()) {
                        i13--;
                    }
                    if (i13 == -1 || partition.getIdColumnIndex() == -1 || (cursor = partition.getCursor()) == null || cursor.isClosed() || !cursor.moveToPosition(i13)) {
                        return 0L;
                    }
                    return cursor.getLong(partition.getIdColumnIndex());
                }
                i11 = count;
            }
        }
        return 0L;
    }

    public int getItemViewType(int partition, int position) {
        return 1;
    }

    public int getItemViewTypeCount() {
        return 1;
    }

    public final int getOffsetInPartition(int position) {
        ensureCacheValid();
        int i10 = this.size;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Partition partition = this.partitions[i12];
            if (partition != null) {
                int count = partition.getCount() + i11;
                if (position >= i11 && position < count) {
                    int i13 = position - i11;
                    return partition.getHasHeader() ? i13 - 1 : i13;
                }
                i11 = count;
            }
        }
        return -1;
    }

    public final Partition getPartition(int partitionIndex) {
        if (partitionIndex >= this.size) {
            throw new ArrayIndexOutOfBoundsException(partitionIndex);
        }
        Partition partition = this.partitions[partitionIndex];
        if (partition != null) {
            return partition;
        }
        throw new ArrayIndexOutOfBoundsException(partitionIndex);
    }

    /* renamed from: getPartitionCount, reason: from getter */
    public final int getSize() {
        return this.size;
    }

    public final int getPartitionForPosition(int position) {
        ensureCacheValid();
        int i10 = this.size;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10) {
            Partition partition = this.partitions[i11];
            int count = (partition != null ? partition.getCount() : 0) + i12;
            if (position >= i12 && position < count) {
                return i11;
            }
            i11++;
            i12 = count;
        }
        return -1;
    }

    public final int getPositionForPartition(int partition) {
        ensureCacheValid();
        int count = 0;
        for (int i10 = 0; i10 < partition; i10++) {
            Partition partition2 = this.partitions[i10];
            count += partition2 != null ? partition2.getCount() : 0;
        }
        return count;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        StepOSCompositeCursorAdapter stepOSCompositeCursorAdapter;
        View view;
        ViewGroup viewGroup;
        View view2;
        kotlin.jvm.internal.p.i(parent, "parent");
        ensureCacheValid();
        int i10 = this.size;
        int i11 = 0;
        int i12 = 0;
        while (i12 < i10) {
            Partition partition = this.partitions[i12];
            if (partition == null) {
                stepOSCompositeCursorAdapter = this;
                view = convertView;
                viewGroup = parent;
            } else {
                int count = partition.getCount() + i11;
                if (position >= i11 && position < count) {
                    int i13 = position - i11;
                    if (partition.getHasHeader()) {
                        i13--;
                    }
                    int i14 = i13;
                    if (i14 == -1) {
                        view2 = this.getHeaderView(i12, partition.getCursor(), convertView, parent);
                    } else {
                        Cursor cursor = partition.getCursor();
                        if (cursor == null) {
                            throw new IllegalStateException("Couldn't move cursor to position " + i14);
                        }
                        if (!cursor.moveToPosition(i14)) {
                            throw new IllegalStateException("Couldn't move cursor to position " + i14);
                        }
                        view2 = this.getView(i12, cursor, i14, convertView, parent);
                    }
                    if (view2 != null) {
                        return view2;
                    }
                    throw new NullPointerException("View should not be null, partition: " + i12 + " position: " + i14);
                }
                stepOSCompositeCursorAdapter = this;
                view = convertView;
                viewGroup = parent;
                i11 = count;
            }
            i12++;
            this = stepOSCompositeCursorAdapter;
            convertView = view;
            parent = viewGroup;
        }
        throw new ArrayIndexOutOfBoundsException(position);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return getItemViewTypeCount() + 1;
    }

    public final boolean hasHeader(int partition) {
        Partition partition2 = this.partitions[partition];
        return partition2 != null && partition2.getHasHeader();
    }

    public final void invalidate() {
        this.cacheValid = false;
    }

    public boolean isEnabled(int partition, int position) {
        return true;
    }

    public final boolean isPartitionEmpty(int partition) {
        Partition partition2 = this.partitions[partition];
        Cursor cursor = partition2 != null ? partition2.getCursor() : null;
        return cursor == null || cursor.getCount() == 0;
    }

    public View newHeaderView(Context context, int partition, Cursor cursor, ViewGroup parent) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(parent, "parent");
        return null;
    }

    public abstract View newView(Context context, int partition, Cursor cursor, int position, ViewGroup parent);

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        if (!this.notificationsEnabled) {
            this.notificationNeeded = true;
        } else {
            this.notificationNeeded = false;
            super.notifyDataSetChanged();
        }
    }

    public final void removePartition(int partitionIndex) {
        Partition partition = this.partitions[partitionIndex];
        Cursor cursor = partition != null ? partition.getCursor() : null;
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        Partition[] partitionArr = this.partitions;
        System.arraycopy(partitionArr, partitionIndex + 1, partitionArr, partitionIndex, (this.size - partitionIndex) - 1);
        Partition[] partitionArr2 = this.partitions;
        int i10 = this.size;
        partitionArr2[i10 - 1] = null;
        this.size = i10 - 1;
        invalidate();
        notifyDataSetChanged();
    }

    public final void setHasHeader(int partitionIndex, boolean flag) {
        Partition partition = this.partitions[partitionIndex];
        if (partition != null) {
            partition.setHasHeader(flag);
        }
        invalidate();
    }

    public final void setNotificationsEnabled(boolean flag) {
        this.notificationsEnabled = flag;
        if (flag && this.notificationNeeded) {
            notifyDataSetChanged();
        }
    }

    public final void setShowIfEmpty(int partitionIndex, boolean flag) {
        Partition partition = this.partitions[partitionIndex];
        if (partition != null) {
            partition.setShowIfEmpty(flag);
        }
        invalidate();
    }

    public StepOSCompositeCursorAdapter(Context context, int i10) {
        kotlin.jvm.internal.p.i(context, "context");
        this.cacheValid = true;
        this.notificationsEnabled = true;
        this.appContext = context;
        this.partitions = new Partition[2];
    }

    public final void addPartition(Partition partition) {
        kotlin.jvm.internal.p.i(partition, "partition");
        int i10 = this.size;
        Partition[] partitionArr = this.partitions;
        if (i10 >= partitionArr.length) {
            Partition[] partitionArr2 = new Partition[i10 + 2];
            System.arraycopy(partitionArr, 0, partitionArr2, 0, i10);
            this.partitions = partitionArr2;
        }
        Partition[] partitionArr3 = this.partitions;
        int i11 = this.size;
        partitionArr3[i11] = partition;
        this.size = i11 + 1;
        invalidate();
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int position) {
        ensureCacheValid();
        int i10 = this.size;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Partition partition = this.partitions[i12];
            if (partition != null) {
                int count = partition.getCount() + i11;
                if (position >= i11 && position < count) {
                    int i13 = position - i11;
                    if (partition.getHasHeader() && i13 == 0) {
                        return -1;
                    }
                    return getItemViewType(i12, position);
                }
                i11 = count;
            }
        }
        throw new ArrayIndexOutOfBoundsException(position);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int position) {
        ensureCacheValid();
        int i10 = this.size;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Partition partition = this.partitions[i12];
            if (partition != null) {
                int count = partition.getCount() + i11;
                if (position >= i11 && position < count) {
                    int i13 = position - i11;
                    if (partition.getHasHeader() && i13 == 0) {
                        return false;
                    }
                    return isEnabled(i12, i13);
                }
                i11 = count;
            }
        }
        return false;
    }

    public View getView(int partition, Cursor cursor, int position, View convertView, ViewGroup parent) {
        int i10;
        View viewNewView;
        int i11;
        Cursor cursor2;
        kotlin.jvm.internal.p.i(cursor, "cursor");
        kotlin.jvm.internal.p.i(parent, "parent");
        if (convertView == null) {
            i11 = position;
            cursor2 = cursor;
            i10 = partition;
            viewNewView = newView(this.appContext, i10, cursor2, i11, parent);
        } else {
            i10 = partition;
            viewNewView = convertView;
            i11 = position;
            cursor2 = cursor;
        }
        bindView(viewNewView, i10, cursor2, i11);
        return viewNewView;
    }
}
