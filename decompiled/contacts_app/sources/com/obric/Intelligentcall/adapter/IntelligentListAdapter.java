package com.obric.Intelligentcall.adapter;

import android.database.Cursor;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.util.CallLogTimeRangeUtil;
import com.obric.Intelligentcall.activity.IntelligentListActivity;
import com.obric.contactprovider.ObricCallLogProviderHelper;
import com.obric.contactprovider.tableinfo.CallFeature;
import com.obric.database.entity.CallFeatureEntity;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.utils.CallContactInfoUtils;
import com.obric.utils.ObricCursorRecyclerViewAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: IntelligentListAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/obric/Intelligentcall/adapter/IntelligentListAdapter;", "Lcom/obric/utils/ObricCursorRecyclerViewAdapter;", "Lcom/obric/Intelligentcall/adapter/ViewHolder;", "activity", "Lcom/obric/Intelligentcall/activity/IntelligentListActivity;", "(Lcom/obric/Intelligentcall/activity/IntelligentListActivity;)V", "getActivity", "()Lcom/obric/Intelligentcall/activity/IntelligentListActivity;", "callContactInfo", "Lcom/obric/utils/CallContactInfoUtils;", "idColumnName", "", "getIdColumnName", "()Ljava/lang/String;", "onBindViewHolder", "", "holder", "cursor", "Landroid/database/Cursor;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "query", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IntelligentListAdapter extends ObricCursorRecyclerViewAdapter<ViewHolder> {
    private final IntelligentListActivity activity;
    private final CallContactInfoUtils callContactInfo;

    /* JADX INFO: renamed from: $r8$lambda$TZC-gHMJoMd-GsWYv9_eOQv16io, reason: not valid java name */
    public static /* synthetic */ void m309$r8$lambda$TZCgHMJoMdGsWYv9_eOQv16io(IntelligentListAdapter r0, Ref.ObjectRef r1, CallFeatureEntity r2, String r3, View r4) {
        onBindViewHolder$lambda$1$lambda$0(r0, r1, r2, r3, r4);
    }

    @Override // com.obric.utils.ObricCursorRecyclerViewAdapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, Cursor r2) {
        onBindViewHolder((ViewHolder) r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    public final IntelligentListActivity getActivity() {
        return this.activity;
    }

    public IntelligentListAdapter(IntelligentListActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        super(r2);
        this.activity = r2;
        this.callContactInfo = new CallContactInfoUtils(r2);
    }

    @Override // com.obric.utils.ObricCursorRecyclerViewAdapter
    protected String getIdColumnName() {
        String r1 = CallFeature.ID;
        Intrinsics.checkNotNullExpressionValue(r1, "ID");
        return r1;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(R.layout.adapter_intelligent_list, r3, false);
        Intrinsics.checkNotNullExpressionValue(r5, "from(parent.context).inf…gent_list, parent, false)");
        return new ViewHolder(r5);
    }

    @Override // com.obric.utils.ObricCursorRecyclerViewAdapter
    protected Cursor query() {
        return this.activity.getContentResolver().query(ObricCallLogProviderHelper.INSTANCE.getCallFeatureUri(), null, CallFeature.FEATURE + " & 4 != 0", null, CallFeature.ID + " DESC", null);
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [T, java.lang.String] */
    public void onBindViewHolder(final ViewHolder r8, Cursor r9) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        Intrinsics.checkNotNullParameter(r9, "cursor");
        final CallFeatureEntity r10 = ObricCallLogProviderHelper.INSTANCE.callFeatureCursor2Entity(r9);
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.getPhoneNumber() != null) goto L8;
        return;
    L8:
        final String r0 = r10.getPhoneNumber();
        String r1 = ContactsUtils.formatNumber(r0);
        if (r1 != null) goto L11;
        r1 = r0;
    L12:
        Regex r2 = new Regex("^(\\+86|0086)");
        final ?? r3 = StringsKt.trim(r2.replace(r1, "")).toString();
        final Ref.ObjectRef r4 = new Ref.ObjectRef();
        r4.element = r3;
        final Ref.ObjectRef r5 = new Ref.ObjectRef();
        r5.element = "";
        Object r6 = this.callContactInfo.getContact(r0, new IntelligentListAdapter$onBindViewHolder$1$tag$1(r8, r4, r3, r5));
        if (r8.getTag() == null) goto L20;
        Object r7 = r8.getTag();
        if ((r7 instanceof AsyncTask) == false) goto L17;
        AsyncTask r11 = (AsyncTask) r7;
    L18:
        if (r11 == null) goto L20;
        r11.cancel(true);
        goto L20
    L17:
        r11 = null;
    L20:
        r8.setTag(r6);
        String r12 = CallLogTimeRangeUtil.getCallLogListFormatTime(r10.getCallCreateTime());
        r8.getTrailingView().setTrailingText(r12);
        r8.getListItem().setOnClickListener(new IntelligentListAdapter$$ExternalSyntheticLambda0(this, r4, r10, r0));
        if ((r10.getStatus() & 8) == 0) goto L23;
        int r13 = R.color.oui_red_6;
    L24:
        r8.getListItem().setTitleString((CharSequence) r4.element);
        r8.getListItem().setSubTitleString((CharSequence) r5.element);
        r8.getListItem().getMTvTitle().setTextColor(this.activity.getResources().getColor(r13));
        return;
    L23:
        r13 = R.color.oui_text_1;
        goto L24
    L11:
        Intrinsics.checkNotNullExpressionValue(r1, "systemFormatPhoneNumber ?: phoneNumber");
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void onBindViewHolder$lambda$1$lambda$0(IntelligentListAdapter r2, Ref.ObjectRef r3, CallFeatureEntity r4, String r5, View r6) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$contactNames");
        Intrinsics.checkNotNullParameter(r4, "$entity");
        r2.activity.startCallRecordAndSummaryActivity((String) r3.element, r4.getCallCreateTime(), r5);
    }
}
