package com.obric.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.AsyncTask;
import android.view.ViewGroup;
import com.android.contacts.util.DateUtils;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.RecyclerView.ViewHolder;
import com.obric.utils.ICallData;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: ObricGroupCallRecyclerViewAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 b*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00030\u0005:\u0006bcdefgB\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0013J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0013J1\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\u00102\u0006\u0010&\u001a\u00028\u00002\u0006\u0010'\u001a\u00020\u001eH\u0002¢\u0006\u0002\u0010(J\u0012\u0010)\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010\u000eH\u0002J\u001e\u0010+\u001a\u00020$2\u0014\u0010,\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0011\u0018\u00010\u0010H\u0002J\u0015\u0010-\u001a\u00028\u00012\u0006\u0010.\u001a\u00020/H&¢\u0006\u0002\u00100J\u0015\u00101\u001a\u00028\u00012\u0006\u0010.\u001a\u00020/H&¢\u0006\u0002\u00100J\u001d\u00102\u001a\u00028\u00012\u0006\u0010.\u001a\u00020/2\u0006\u00103\u001a\u00020\u001eH&¢\u0006\u0002\u00104J\u0017\u00105\u001a\u0004\u0018\u00018\u00002\u0006\u00106\u001a\u00020\u000eH$¢\u0006\u0002\u00107J\u001e\u00108\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0011\u0018\u00010\u00102\b\u00109\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010:\u001a\u00020$J\b\u0010;\u001a\u0004\u0018\u00010\u000eJ\u0012\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\u0010J\b\u0010=\u001a\u00020\u001eH\u0016J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u001eH\u0016J\u0010\u0010A\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020\u001eH\u0016J\u0006\u0010B\u001a\u00020\u001eJ\u000e\u0010C\u001a\u00020?2\u0006\u0010@\u001a\u00020\u001eJ\u0010\u0010D\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020\u001eH&J\u001d\u0010E\u001a\u00020\u001a2\u0006\u0010F\u001a\u00028\u00002\u0006\u0010G\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010HJ\u001d\u0010I\u001a\u00020\u001a2\u0006\u0010F\u001a\u00028\u00002\u0006\u0010G\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010HJ\u001d\u0010J\u001a\u00020\u001a2\u0006\u0010F\u001a\u00028\u00002\u0006\u0010G\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010HJ\u001d\u0010K\u001a\u00020\u001a2\u0006\u0010F\u001a\u00028\u00002\u0006\u0010G\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010HJ'\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u00028\u00012\u0006\u0010@\u001a\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0002\u0010NJ'\u0010O\u001a\u00020$2\u0006\u0010M\u001a\u00028\u00012\u0006\u0010@\u001a\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0002\u0010NJ\u001d\u0010P\u001a\u00020$2\u0006\u0010M\u001a\u00028\u00012\u0006\u0010@\u001a\u00020\u001eH\u0016¢\u0006\u0002\u0010QJ-\u0010P\u001a\u00020$2\u0006\u0010M\u001a\u00028\u00012\u0006\u0010@\u001a\u00020\u001e2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0011H&¢\u0006\u0002\u0010RJ\u001e\u0010S\u001a\u00020$2\u0014\u0010,\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0011\u0018\u00010\u0010H&J\u001d\u0010T\u001a\u00028\u00012\u0006\u0010.\u001a\u00020/2\u0006\u00103\u001a\u00020\u001eH\u0016¢\u0006\u0002\u00104J(\u0010U\u001a\u00020$2\b\u00106\u001a\u0004\u0018\u00010\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0011\u0018\u00010\u0010H\u0014J\n\u0010V\u001a\u0004\u0018\u00010\u000eH$J\u000e\u0010W\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0013J\u000e\u0010X\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0013JY\u0010Y\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\u00102\u0006\u0010&\u001a\u00028\u00002\u0016\u0010Z\u001a\u0012\u0012\u0004\u0012\u00028\u00000[j\b\u0012\u0004\u0012\u00028\u0000`\\2\u0006\u0010]\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010^\u001a\u00020\u001eH\u0002¢\u0006\u0002\u0010_J\u0012\u0010`\u001a\u00020$2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u000eJ\u0014\u0010a\u001a\u0004\u0018\u00010\u000e2\b\u0010*\u001a\u0004\u0018\u00010\u000eH\u0002R\u0014\u0010\u0006\u001a\u00020\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00120\fR\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u0016X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u001b\u001a\u0014\u0018\u00010\u001cR\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006h"}, d2 = {"Lcom/obric/utils/ObricGroupCallRecyclerViewAdapter;", "DATA", "Lcom/obric/utils/ICallData;", "VH", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "cursorObserver", "Lcom/obric/utils/ObricGroupCallRecyclerViewAdapter$DataObserver;", "dataCursor", "Landroid/database/Cursor;", "dataList", "", "Lcom/obric/utils/ObricGroupCallRecyclerViewAdapter$GroupCallData;", "footers", "Lcom/obric/utils/ObricGroupCallRecyclerViewAdapter$HeaderFooterData;", "headers", "idColumnName", "", "getIdColumnName", "()Ljava/lang/String;", "isDataValid", "", "queryTask", "Lcom/obric/utils/ObricGroupCallRecyclerViewAdapter$QueryTask;", "rowIdentifierIndex", "", "addFooter", "footer", "addHeader", "header", "addItem", "", "resultList", "data", "cursorPosition", "(Ljava/util/List;Lcom/obric/utils/ICallData;I)V", "changeCursor", "newCursor", "changeDataList", "newDataList", "createFooterViewHolder", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "createHeaderViewHolder", "createRealItemViewHolder", "viewType", "(Landroid/view/ViewGroup;I)Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "cursorToData", "cursor", "(Landroid/database/Cursor;)Lcom/obric/utils/ICallData;", "cursorToGroups", "c", "destroy", "getCursor", "getDataList", "getItemCount", "getItemId", "", "position", "getItemViewType", "getRealDataItemCount", "getRealItemId", "getRealItemViewType", "groupConditionDate", "data1", DBHelper.COL_DATA2, "(Lcom/obric/utils/ICallData;Lcom/obric/utils/ICallData;)Z", "groupConditionExtra", "groupConditionNumber", "groupConditionType", "onBindFooterViewHolder", "holder", "(Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;ILcom/obric/utils/ObricGroupCallRecyclerViewAdapter$HeaderFooterData;)V", "onBindHeaderViewHolder", "onBindViewHolder", "(Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;I)V", "(Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;ILcom/obric/utils/ObricGroupCallRecyclerViewAdapter$GroupCallData;)V", "onChangedDataList", "onCreateViewHolder", "onCursorDataChanged", "query", "removeFooter", "removeHeader", "setGroup", "dataGroup", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "listIndex", "groupCount", "(Ljava/util/List;Lcom/obric/utils/ICallData;Ljava/util/LinkedHashSet;III)V", "startQuery", "swapCursor", "Companion", "CursorWrapper", "DataObserver", "GroupCallData", "HeaderFooterData", "QueryTask", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ObricGroupCallRecyclerViewAdapter<DATA extends ICallData, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    public static final Companion Companion = null;
    private static final int VIEW_TYPE_FOOTER = -20;
    private static final int VIEW_TYPE_HEADER = -10;
    private final Context context;
    private final ObricGroupCallRecyclerViewAdapter<DATA, VH>.DataObserver cursorObserver;
    private Cursor dataCursor;
    private final List<GroupCallData<DATA>> dataList;
    private final List<HeaderFooterData> footers;
    private final List<HeaderFooterData> headers;
    private final String idColumnName;
    private boolean isDataValid;
    private ObricGroupCallRecyclerViewAdapter<DATA, VH>.QueryTask queryTask;
    private int rowIdentifierIndex;

    /* JADX INFO: compiled from: ObricGroupCallRecyclerViewAdapter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/utils/ObricGroupCallRecyclerViewAdapter$Companion;", "", "()V", "VIEW_TYPE_FOOTER", "", "VIEW_TYPE_HEADER", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: ObricGroupCallRecyclerViewAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001f\u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/utils/ObricGroupCallRecyclerViewAdapter$CursorWrapper;", "", "cursor", "Landroid/database/Cursor;", "dataList", "", "Lcom/obric/utils/ObricGroupCallRecyclerViewAdapter$GroupCallData;", "(Lcom/obric/utils/ObricGroupCallRecyclerViewAdapter;Landroid/database/Cursor;Ljava/util/List;)V", "getCursor", "()Landroid/database/Cursor;", "getDataList", "()Ljava/util/List;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class CursorWrapper {
        private final Cursor cursor;
        private final List<GroupCallData<DATA>> dataList;
        final /* synthetic */ ObricGroupCallRecyclerViewAdapter<DATA, VH> this$0;

        public CursorWrapper(ObricGroupCallRecyclerViewAdapter r1, Cursor r2, List<GroupCallData<DATA>> r3) {
            this.this$0 = r1;
            this.cursor = r2;
            this.dataList = r3;
        }

        public final Cursor getCursor() {
            return this.cursor;
        }

        public final List<GroupCallData<DATA>> getDataList() {
            return this.dataList;
        }
    }

    /* JADX INFO: compiled from: ObricGroupCallRecyclerViewAdapter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/obric/utils/ObricGroupCallRecyclerViewAdapter$DataObserver;", "Landroid/database/DataSetObserver;", "(Lcom/obric/utils/ObricGroupCallRecyclerViewAdapter;)V", "onChanged", "", "onInvalidated", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class DataObserver extends DataSetObserver {
        final /* synthetic */ ObricGroupCallRecyclerViewAdapter<DATA, VH> this$0;

        public DataObserver(ObricGroupCallRecyclerViewAdapter r1) {
            this.this$0 = r1;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ObricGroupCallRecyclerViewAdapter.access$setDataValid$p(this.this$0, true);
            ObricGroupCallRecyclerViewAdapter<DATA, VH> r2 = this.this$0;
            r2.startQuery(ObricGroupCallRecyclerViewAdapter.access$getDataCursor$p(r2));
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
            ObricGroupCallRecyclerViewAdapter.access$setDataValid$p(this.this$0, false);
        }
    }

    /* JADX INFO: compiled from: ObricGroupCallRecyclerViewAdapter.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002Bq\u0012\u0006\u0010\u0003\u001a\u00028\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00028\u0002\u0018\u00010\bj\n\u0012\u0004\u0012\u00028\u0002\u0018\u0001`\t\u0012\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\t\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\r¢\u0006\u0002\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0003\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R.\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00028\u0002\u0018\u00010\bj\n\u0012\u0004\u0012\u00028\u0002\u0018\u0001`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001f\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001a¨\u0006!"}, d2 = {"Lcom/obric/utils/ObricGroupCallRecyclerViewAdapter$GroupCallData;", "DATA", "", "data", "cursorPosition", "", "groupCount", "dataGroup", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "idGroup", "", "extra", "", "", "(Ljava/lang/Object;IILjava/util/LinkedHashSet;Ljava/util/LinkedHashSet;Ljava/util/Map;)V", "getCursorPosition", "()I", "setCursorPosition", "(I)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getDataGroup", "()Ljava/util/LinkedHashSet;", "setDataGroup", "(Ljava/util/LinkedHashSet;)V", "getExtra", "()Ljava/util/Map;", "getGroupCount", "setGroupCount", "getIdGroup", "setIdGroup", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class GroupCallData<DATA> {
        private int cursorPosition;
        private final DATA data;
        private LinkedHashSet<DATA> dataGroup;
        private final Map<String, Object> extra;
        private int groupCount;
        private LinkedHashSet<Long> idGroup;

        public GroupCallData(DATA r2, int r3, int r4, LinkedHashSet<DATA> r5, LinkedHashSet<Long> r6, Map<String, Object> r7) {
            Intrinsics.checkNotNullParameter(r7, "extra");
            this.data = r2;
            this.cursorPosition = r3;
            this.groupCount = r4;
            this.dataGroup = r5;
            this.idGroup = r6;
            this.extra = r7;
        }

        public final DATA getData() {
            return this.data;
        }

        public final int getCursorPosition() {
            return this.cursorPosition;
        }

        public final void setCursorPosition(int r1) {
            this.cursorPosition = r1;
        }

        public final int getGroupCount() {
            return this.groupCount;
        }

        public final void setGroupCount(int r1) {
            this.groupCount = r1;
        }

        public final LinkedHashSet<DATA> getDataGroup() {
            return this.dataGroup;
        }

        public final void setDataGroup(LinkedHashSet<DATA> r1) {
            this.dataGroup = r1;
        }

        public final LinkedHashSet<Long> getIdGroup() {
            return this.idGroup;
        }

        public final void setIdGroup(LinkedHashSet<Long> r1) {
            this.idGroup = r1;
        }

        public /* synthetic */ GroupCallData(Object r10, int r11, int r12, LinkedHashSet r13, LinkedHashSet r14, Map r15, int r16, DefaultConstructorMarker r17) {
            if ((r16 & 8) == 0) goto L5;
            LinkedHashSet r6 = null;
        L7:
            if ((r16 & 16) == 0) goto L9;
            LinkedHashSet r7 = null;
        L11:
            if ((r16 & 32) == 0) goto L13;
            Map r8 = new LinkedHashMap();
        L14:
            this(r10, r11, r12, r6, r7, r8);
            return;
        L13:
            r8 = r15;
            goto L14
        L9:
            r7 = r14;
            goto L11
        L5:
            r6 = r13;
            goto L7
        }

        public final Map<String, Object> getExtra() {
            return this.extra;
        }
    }

    /* JADX INFO: compiled from: ObricGroupCallRecyclerViewAdapter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/obric/utils/ObricGroupCallRecyclerViewAdapter$HeaderFooterData;", "", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "", "(I)V", "getHeight", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class HeaderFooterData {
        private final int height;

        public static /* synthetic */ HeaderFooterData copy$default(HeaderFooterData r0, int r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.height;
        L6:
            return r0.copy(r1);
        }

        public final int component1() {
            return this.height;
        }

        public final HeaderFooterData copy(int r1) {
            return new HeaderFooterData(r1);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof HeaderFooterData) == true) goto L9;
            return false;
        L9:
            if (this.height == ((HeaderFooterData) r4).height) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Integer.hashCode(this.height);
        }

        public String toString() {
            return "HeaderFooterData(height=" + this.height + ')';
        }

        public HeaderFooterData(int r1) {
            this.height = r1;
        }

        public final int getHeight() {
            return this.height;
        }
    }

    /* JADX INFO: compiled from: ObricGroupCallRecyclerViewAdapter.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u00120\u0003R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0001B\u000f\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J1\u0010\n\u001a\u00120\u0003R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\f\"\u00020\u0002H\u0014¢\u0006\u0002\u0010\rJ \u0010\u000e\u001a\u00020\u000f2\u0016\u0010\u0010\u001a\u00120\u0003R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/obric/utils/ObricGroupCallRecyclerViewAdapter$QueryTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "Lcom/obric/utils/ObricGroupCallRecyclerViewAdapter$CursorWrapper;", "Lcom/obric/utils/ObricGroupCallRecyclerViewAdapter;", "queryCursor", "Landroid/database/Cursor;", "(Lcom/obric/utils/ObricGroupCallRecyclerViewAdapter;Landroid/database/Cursor;)V", "getQueryCursor", "()Landroid/database/Cursor;", "doInBackground", "params", "", "([Ljava/lang/Void;)Lcom/obric/utils/ObricGroupCallRecyclerViewAdapter$CursorWrapper;", "onPostExecute", "", "result", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class QueryTask extends AsyncTask<Void, Void, ObricGroupCallRecyclerViewAdapter<DATA, VH>.CursorWrapper> {
        private final Cursor queryCursor;
        final /* synthetic */ ObricGroupCallRecyclerViewAdapter<DATA, VH> this$0;

        public QueryTask(ObricGroupCallRecyclerViewAdapter r1, Cursor r2) {
            this.this$0 = r1;
            this.queryCursor = r2;
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Object doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        public final Cursor getQueryCursor() {
            return this.queryCursor;
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(Object r1) {
            onPostExecute((CursorWrapper) r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected ObricGroupCallRecyclerViewAdapter<DATA, VH>.CursorWrapper doInBackground2(Void... r3) {
            Intrinsics.checkNotNullParameter(r3, "params");
            Cursor r4 = this.queryCursor;
            if (r4 != null) goto L5;
            r4 = this.this$0.query();
        L5:
            ObricGroupCallRecyclerViewAdapter<DATA, VH> r2 = this.this$0;
            return new CursorWrapper(r2, r4, r2.cursorToGroups(r4));
        }

        protected void onPostExecute(ObricGroupCallRecyclerViewAdapter<DATA, VH>.CursorWrapper r3) {
            Intrinsics.checkNotNullParameter(r3, "result");
            super.onPostExecute(r3);
            ObricGroupCallRecyclerViewAdapter.access$changeCursor(this.this$0, r3.getCursor());
            ObricGroupCallRecyclerViewAdapter.access$changeDataList(this.this$0, r3.getDataList());
            this.this$0.onCursorDataChanged(r3.getCursor(), r3.getDataList());
            this.this$0.notifyDataSetChanged();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public abstract VH createFooterViewHolder(ViewGroup r1);

    public abstract VH createHeaderViewHolder(ViewGroup r1);

    public abstract VH createRealItemViewHolder(ViewGroup r1, int r2);

    protected abstract DATA cursorToData(Cursor r1);

    public abstract int getRealItemViewType(int r1);

    protected boolean groupConditionExtra(DATA r1, DATA r2) {
        Intrinsics.checkNotNullParameter(r1, "data1");
        Intrinsics.checkNotNullParameter(r2, DBHelper.COL_DATA2);
        return true;
    }

    public abstract void onBindFooterViewHolder(VH r1, int r2, HeaderFooterData r3);

    public abstract void onBindHeaderViewHolder(VH r1, int r2, HeaderFooterData r3);

    public abstract void onBindViewHolder(VH r1, int r2, GroupCallData<DATA> r3);

    public abstract void onChangedDataList(List<GroupCallData<DATA>> r1);

    protected void onCursorDataChanged(Cursor r1, List<GroupCallData<DATA>> r2) {
    }

    protected abstract Cursor query();

    public static final /* synthetic */ void access$changeCursor(ObricGroupCallRecyclerViewAdapter r0, Cursor r1) {
        r0.changeCursor(r1);
    }

    public static final /* synthetic */ void access$changeDataList(ObricGroupCallRecyclerViewAdapter r0, List r1) {
        r0.changeDataList(r1);
    }

    public static final /* synthetic */ Cursor access$getDataCursor$p(ObricGroupCallRecyclerViewAdapter r0) {
        return r0.dataCursor;
    }

    public static final /* synthetic */ void access$setDataValid$p(ObricGroupCallRecyclerViewAdapter r0, boolean r1) {
        r0.isDataValid = r1;
    }

    protected final Context getContext() {
        return this.context;
    }

    public ObricGroupCallRecyclerViewAdapter(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.context = r5;
        int r6 = -1;
        this.rowIdentifierIndex = -1;
        ObricGroupCallRecyclerViewAdapter<DATA, VH>.DataObserver r0 = new DataObserver(this);
        this.cursorObserver = r0;
        this.dataList = new ArrayList();
        this.headers = new ArrayList();
        this.footers = new ArrayList();
        boolean r1 = true;
        setHasStableIds(true);
        Cursor r2 = this.dataCursor;
        if (r2 != null) goto L6;
        r1 = false;
    L6:
        this.isDataValid = r1;
        if (r1 == false) goto L9;
        Intrinsics.checkNotNull(r2);
        r6 = r2.getColumnIndex("_id");
    L9:
        this.rowIdentifierIndex = r6;
        if (r2 == null) goto L12;
        r2.registerDataSetObserver(r0);
    L12:
        this.idColumnName = "_id";
    }

    public final Cursor getCursor() {
        return this.dataCursor;
    }

    public final List<GroupCallData<DATA>> getDataList() {
        return this.dataList;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.isDataValid == true) goto L5;
    L9:
        return 0;
    L5:
        if (this.dataCursor == null) goto L9;
        if ((!this.dataList.isEmpty()) == false) goto L9;
        return (this.headers.size() + this.dataList.size()) + this.footers.size();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r3) {
        int r0 = this.headers.size();
        if (r3 >= r0) goto L6;
        return ((long) r3) - Long.MIN_VALUE;
    L6:
        if (r3 >= (this.dataList.size() + r0)) goto L9;
        return getRealItemId(r3 - r0);
    L9:
        return Long.MAX_VALUE - ((long) ((r3 - r0) - getRealDataItemCount()));
    }

    public final int getRealDataItemCount() {
        return this.dataList.size();
    }

    public final long getRealItemId(int r5) {
        GroupCallData r6 = (GroupCallData) CollectionsKt.getOrNull(this.dataList, r5);
        if (r6 == null) goto L14;
        int r7 = r6.getCursorPosition();
        if (this.isDataValid == false) goto L15;
        Cursor r2 = this.dataCursor;
        boolean r3 = false;
        if (r2 != null) goto L9;
    L11:
        if (r3 == false) goto L16;
        Cursor r8 = this.dataCursor;
        Intrinsics.checkNotNull(r8);
        return r8.getLong(this.rowIdentifierIndex);
    L16:
        return 0;
    L9:
        if (r2.moveToPosition(r7) != true) goto L11;
        r3 = true;
        goto L11
    L15:
        return 0;
    L14:
        return 0;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(VH r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        int r0 = this.headers.size();
        if (r5 >= r0) goto L6;
        onBindHeaderViewHolder(r4, r5, (HeaderFooterData) CollectionsKt.getOrNull(this.headers, r5));
        return;
    L6:
        if (r5 >= (getRealDataItemCount() + r0)) goto L21;
        int r6 = r5 - r0;
        if (this.isDataValid == false) goto L19;
        Cursor r1 = this.dataCursor;
        boolean r2 = false;
        if (r1 != null) goto L12;
    L14:
        if (r2 == false) goto L17;
        onBindViewHolder(r4, r6, (GroupCallData) CollectionsKt.getOrNull(this.dataList, r6));
        return;
    L17:
        throw new IllegalStateException(("Couldn't move to position " + r6).toString());
    L12:
        if (r1.moveToPosition(r6) != true) goto L14;
        r2 = true;
        goto L14
    L19:
        throw new IllegalStateException("Should only be called with valid cursor".toString());
    L21:
        if (r5 < (getRealDataItemCount() + r0)) goto L26;
        int r7 = (r5 - r0) - getRealDataItemCount();
        onBindFooterViewHolder(r4, r7, (HeaderFooterData) CollectionsKt.getOrNull(this.footers, r7));
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public VH onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        if (r3 == (-20)) goto L11;
        if (r3 == (-10)) goto L9;
        return (VH) createRealItemViewHolder(r2, r3);
    L9:
        return (VH) createHeaderViewHolder(r2);
    L11:
        return (VH) createFooterViewHolder(r2);
    }

    private final void changeDataList(List<GroupCallData<DATA>> r3) {
        this.dataList.clear();
        if (r3 != null) goto L5;
        return;
    L5:
        this.dataList.addAll(r3);
        onChangedDataList(r3);
    }

    private final void changeCursor(Cursor r1) {
        Cursor r0 = swapCursor(r1);
        if (r0 == null) goto L6;
        r0.close();
        return;
    }

    private final Cursor swapCursor(Cursor r3) {
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

    public static /* synthetic */ void startQuery$default(ObricGroupCallRecyclerViewAdapter r0, Cursor r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        r0.startQuery(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startQuery");
    }

    public final void startQuery(Cursor r3) {
        ObricGroupCallRecyclerViewAdapter<DATA, VH>.QueryTask r0 = this.queryTask;
        if (r0 == null) goto L5;
        r0.cancel(true);
    L5:
        ObricGroupCallRecyclerViewAdapter<DATA, VH>.QueryTask r1 = new QueryTask(this, r3);
        r1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        this.queryTask = r1;
    }

    public final void destroy() {
        ObricGroupCallRecyclerViewAdapter<DATA, VH>.QueryTask r0 = this.queryTask;
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

    protected boolean groupConditionNumber(DATA r3, DATA r4) {
        Intrinsics.checkNotNullParameter(r3, "data1");
        Intrinsics.checkNotNullParameter(r4, DBHelper.COL_DATA2);
        NumberUtils r0 = NumberUtils.INSTANCE;
        String r5 = r3.getPhoneNumber();
        String r1 = "";
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        String r6 = r4.getPhoneNumber();
        if (r6 == null) goto L10;
        r1 = r6;
    L10:
        return r0.equalNumbers(r5, r1, this.context);
    }

    protected boolean groupConditionDate(DATA r3, DATA r4) {
        Intrinsics.checkNotNullParameter(r3, "data1");
        Intrinsics.checkNotNullParameter(r4, DBHelper.COL_DATA2);
        Calendar r2 = Calendar.getInstance();
        r2.setTimeInMillis(r3.getCallDate());
        Calendar r5 = Calendar.getInstance();
        r5.setTimeInMillis(r4.getCallDate());
        return DateUtils.isSameDay(r2, r5);
    }

    protected boolean groupConditionType(DATA r5, DATA r6) {
        Intrinsics.checkNotNullParameter(r5, "data1");
        Intrinsics.checkNotNullParameter(r6, DBHelper.COL_DATA2);
        if (r5.getCallType() == 4) goto L15;
        if (r5.getCallType() == 3) goto L15;
        if (r6.getCallType() == 7) goto L17;
        if (r6.getCallType() == 1) goto L17;
        if (r6.getCallType() == 2) goto L17;
        return false;
    L17:
        return true;
    L15:
        if (r6.getCallType() == 3) goto L17;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<GroupCallData<DATA>> cursorToGroups(Cursor r14) {
        if (r14 != null) goto L6;
        return null;
    L6:
        if (r14.isClosed() == false) goto L8;
    L44:
        return null;
    L8:
        if (r14.moveToFirst() == false) goto L44;
        int r1 = r14.getCount();
        if (r1 != 0) goto L13;
        return null;
    L13:
        ArrayList r2 = new ArrayList();
        ICallData r3 = cursorToData(r14);     // Catch: Exception -> L41
        if (r3 != null) goto L17;
        return null;
    L17:
        LinkedHashSet r0 = new LinkedHashSet();     // Catch: Exception -> L41
        addItem(r2, r3, r14.getPosition());     // Catch: Exception -> L41
        r0.add(r3);     // Catch: Exception -> L41
        LinkedHashSet r6 = r0;
        ICallData r5 = r3;
        int r4 = 0;
        int r9 = 1;
    L19:
        if (r14.moveToNext() == false) goto L38;
        ICallData r12 = cursorToData(r14);     // Catch: Exception -> L41
        if (r12 == null) goto L19;
        if (groupConditionNumber(r5, r12) == true) goto L26;
    L32:
        boolean r7 = false;
    L33:
        if (r7 == true) goto L34;
        if (r9 <= 1) goto L37;
        setGroup(r2, r5, r6, r4, r14.getPosition() - r9, r9);     // Catch: Exception -> L41
    L37:
        addItem(r2, r12, r14.getPosition());     // Catch: Exception -> L41
        r4 = r4 + 1;     // Catch: Exception -> L41
        r6 = new LinkedHashSet();     // Catch: Exception -> L41
        r6.add(r12);     // Catch: Exception -> L41
        r9 = 1;
        r5 = r12;
        goto L19
    L34:
        r9 = r9 + 1;     // Catch: Exception -> L41
        r6.add(r12);     // Catch: Exception -> L41
        goto L19
    L26:
        if (groupConditionDate(r5, r12) == false) goto L32;
        if (groupConditionType(r5, r12) == false) goto L32;
        if (groupConditionExtra(r5, r12) == false) goto L32;
        r7 = true;
        goto L33
    L38:
        if (r9 <= 1) goto L43;
        setGroup(r2, r5, r6, r4, r1 - r9, r9);     // Catch: Exception -> L41
    L43:
        return r2;
    L41:
        e = move-exception;
        e.printStackTrace();
        goto L43
    }

    private final void setGroup(List<GroupCallData<DATA>> r3, DATA r4, LinkedHashSet<DATA> r5, int r6, int r7, int r8) {
        LinkedHashSet<Long> r9 = new LinkedHashSet();
        Iterator<T> r2 = r5.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r9.add(Long.valueOf(((ICallData) r2.next()).getCallId()));
        goto L4
    L6:
        LinkedHashSet<Long> r10 = r9;
        GroupCallData r11 = (GroupCallData) CollectionsKt.getOrNull(r3, r6);
        if (r11 == null) goto L11;
        r11.setCursorPosition(r7);
        r11.setGroupCount(r8);
        r11.setDataGroup(r5);
        r11.setIdGroup(r10);
        return;
    }

    private final void addItem(List<GroupCallData<DATA>> r10, DATA r11, int r12) {
        r10.add(new GroupCallData(r11, r12, 0, null, null, null, 56, null));
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r3) {
        if (r3 >= this.headers.size()) goto L6;
        return -10;
    L6:
        if (r3 < (this.headers.size() + getRealDataItemCount())) goto L11;
        return -20;
    L11:
        return getRealItemViewType(r3 - this.headers.size());
    }

    public final int addHeader(HeaderFooterData r2) {
        Intrinsics.checkNotNullParameter(r2, "header");
        this.headers.add(r2);
        return this.headers.size() - 1;
    }

    public final int removeHeader(HeaderFooterData r2) {
        Intrinsics.checkNotNullParameter(r2, "header");
        int r3 = this.headers.indexOf(r2);
        if (r3 == (-1)) goto L6;
        this.headers.remove(r3);
        return r3;
    L6:
        return -1;
    }

    public final int addFooter(HeaderFooterData r2) {
        Intrinsics.checkNotNullParameter(r2, "footer");
        this.footers.add(r2);
        return getItemCount() - 1;
    }

    public final int removeFooter(HeaderFooterData r2) {
        Intrinsics.checkNotNullParameter(r2, "footer");
        int r3 = this.footers.indexOf(r2);
        if (r3 == (-1)) goto L6;
        this.footers.remove(r3);
        return (this.headers.size() + getRealDataItemCount()) + r3;
    L6:
        return -1;
    }
}
