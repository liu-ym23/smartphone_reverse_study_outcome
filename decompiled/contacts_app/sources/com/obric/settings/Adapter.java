package com.obric.settings;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.contacts.R;
import com.android.contacts.util.CallLogTimeRangeUtil;
import com.obric.contactprovider.ObricCallLogProviderHelper;
import com.obric.contactprovider.tableinfo.RecordInfo;
import com.obric.database.entity.RecordInfoEntity;
import com.obric.oui.lisitem.OListItemGeneral;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.utils.ContactNames;
import com.obric.utils.ObricCursorRecyclerViewAdapter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: CallRecordList.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0014H\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/obric/settings/Adapter;", "Lcom/obric/utils/ObricCursorRecyclerViewAdapter;", "Lcom/obric/settings/ViewHolder;", "activity", "Lcom/obric/settings/CallRecordList;", "(Lcom/obric/settings/CallRecordList;)V", "getActivity", "()Lcom/obric/settings/CallRecordList;", "contactNames", "Lcom/obric/utils/ContactNames;", "formatter2", "Ljava/text/SimpleDateFormat;", "idColumnName", "", "getIdColumnName", "()Ljava/lang/String;", "onBindViewHolder", "", "holder", "cursor", "Landroid/database/Cursor;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "query", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Adapter extends ObricCursorRecyclerViewAdapter<ViewHolder> {
    private final CallRecordList activity;
    private final ContactNames contactNames;
    private final SimpleDateFormat formatter2;

    public static /* synthetic */ void $r8$lambda$vj6qOO2pAuFMxbep_FQqdjrqEws(Adapter r0, RecordInfoEntity r1, View r2) {
        onBindViewHolder$lambda$1$lambda$0(r0, r1, r2);
    }

    @Override // com.obric.utils.ObricCursorRecyclerViewAdapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, Cursor r2) {
        onBindViewHolder((ViewHolder) r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    public final CallRecordList getActivity() {
        return this.activity;
    }

    public Adapter(CallRecordList r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        super(r2);
        this.activity = r2;
        this.contactNames = new ContactNames(r2);
        this.formatter2 = new SimpleDateFormat("YYYY-MM-dd HH:mm");
    }

    @Override // com.obric.utils.ObricCursorRecyclerViewAdapter
    protected String getIdColumnName() {
        String r1 = RecordInfo.ID;
        Intrinsics.checkNotNullExpressionValue(r1, "ID");
        return r1;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r2 = LayoutInflater.from(this.activity).inflate(R.layout.record_list_item, r3, false);
        Intrinsics.checkNotNullExpressionValue(r2, "from(activity).inflate(R…list_item, parent, false)");
        return new ViewHolder(r2);
    }

    @Override // com.obric.utils.ObricCursorRecyclerViewAdapter
    protected Cursor query() {
        return ObricCallLogProviderHelper.INSTANCE.getAllRecordInfoCursorDesc(this.activity);
    }

    public void onBindViewHolder(final ViewHolder r17, Cursor r18) {
        Intrinsics.checkNotNullParameter(r17, "holder");
        Intrinsics.checkNotNullParameter(r18, "cursor");
        final RecordInfoEntity r2 = ObricCallLogProviderHelper.INSTANCE.cursor2Entity(r18);
        if (r2 != null) goto L5;
        return;
    L5:
        r17.setTag(this.contactNames.getName(r2.getPhoneNumber(), new Adapter$onBindViewHolder$1$tag$1(r17)));
        long r3 = r2.getDuration() / ((long) 1000);
        long r5 = 60;
        long r7 = r3 / r5;
        long r9 = r7 / r5;
        TextView r11 = r17.getDuration();
        if (r11 != null) goto L9;
    L13:
        TextView r4 = r17.getCreateTime();
        if (r4 == null) goto L17;
        r4.setText(CallLogTimeRangeUtil.getCustomFormatTime(r2.getCallCreateTime()));
    L17:
        OListItemGeneral r1 = r17.getListItem();
        if (r1 == null) goto L21;
        r1.setOnClickListener(new Adapter$$ExternalSyntheticLambda0(this, r2));
        return;
    L21:
        return;
    L9:
        if (r9 <= 0) goto L11;
        StringCompanionObject r12 = StringCompanionObject.INSTANCE;
        String r6 = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r9), Long.valueOf(r7 % r5), Long.valueOf(r3 % r5)}, 3));
        Intrinsics.checkNotNullExpressionValue(r6, "format(...)");
        String r8 = r6;
    L12:
        r11.setText(r8);
        goto L13
    L11:
        StringCompanionObject r10 = StringCompanionObject.INSTANCE;
        String r13 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r7 % r5), Long.valueOf(r3 % r5)}, 2));
        Intrinsics.checkNotNullExpressionValue(r13, "format(...)");
        r8 = r13;
        goto L12
    }

    private static final void onBindViewHolder$lambda$1$lambda$0(final Adapter r2, final RecordInfoEntity r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$entity");
        r2.contactNames.getName(r3.getPhoneNumber(), new Adapter$onBindViewHolder$1$1$1(r2, r3));
    }
}
