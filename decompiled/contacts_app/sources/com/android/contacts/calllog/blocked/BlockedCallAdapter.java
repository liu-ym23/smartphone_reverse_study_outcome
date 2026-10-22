package com.android.contacts.calllog.blocked;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.contacts.CallDetailActivity;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.android.contacts.activities.ContactDetailActivity;
import com.android.contacts.calllog.blocked.data.BlockedCallEntity;
import com.android.contacts.list.ContactDetailCacheManager;
import com.android.contacts.numberassistant.MarkInfoUtil;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.CallLogTimeRangeUtil;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.obric.contactprovider.ObricCallLogProviderHelper;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.utils.CallContactInfoUtils;
import com.obric.utils.ICallData;
import com.obric.utils.ObricGroupCallRecyclerViewAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BlockedCallAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 I2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001IB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010J\b\u0010\"\u001a\u00020\u0012H\u0002J\u0006\u0010#\u001a\u00020\u001dJ\u0010\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010(\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&2\u0006\u0010)\u001a\u00020\u000fH\u0016J\u0012\u0010*\u001a\u0004\u0018\u00010\u00022\u0006\u0010+\u001a\u00020,H\u0014J\u0006\u0010-\u001a\u00020\u001dJ\u0018\u0010.\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00100/J\u0010\u00100\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000fH\u0016J\u0018\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u0002H\u0014J\"\u00104\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u000f2\b\u0010!\u001a\u0004\u0018\u000105H\u0016J\"\u00106\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u000f2\b\u0010!\u001a\u0004\u0018\u000105H\u0016J(\u00107\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u000f2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010H\u0016J\u001e\u00108\u001a\u00020\u001d2\u0014\u00109\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0010\u0018\u00010:H\u0016J(\u0010;\u001a\u00020\u001d2\b\u0010+\u001a\u0004\u0018\u00010,2\u0014\u0010<\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0010\u0018\u00010:H\u0014J\n\u0010=\u001a\u0004\u0018\u00010,H\u0014J\u0014\u0010>\u001a\u00020\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010J\u0016\u0010?\u001a\u00020\u00122\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u0012J\u000e\u0010B\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\u0012J\u0010\u0010D\u001a\u00020\u001d2\b\u0010E\u001a\u0004\u0018\u00010\u001bJ\u0016\u0010F\u001a\u00020\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0002J\u0018\u0010G\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020H2\u0006\u0010!\u001a\u000205H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/android/contacts/calllog/blocked/BlockedCallAdapter;", "Lcom/obric/utils/ObricGroupCallRecyclerViewAdapter;", "Lcom/android/contacts/calllog/blocked/data/BlockedCallEntity;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "activity", "Lcom/android/contacts/calllog/blocked/BlockedCallActivity;", "longItemClickListener", "Lcom/android/contacts/calllog/blocked/IOnLongItemClickListener;", "(Lcom/android/contacts/calllog/blocked/BlockedCallActivity;Lcom/android/contacts/calllog/blocked/IOnLongItemClickListener;)V", "getActivity", "()Lcom/android/contacts/calllog/blocked/BlockedCallActivity;", "callContactInfo", "Lcom/obric/utils/CallContactInfoUtils;", "checkedMap", "", "", "Lcom/obric/utils/ObricGroupCallRecyclerViewAdapter$GroupCallData;", "isCheckedMapEmpty", "", "isEditMode", "()Z", "setEditMode", "(Z)V", "isMultiSimCard", "getLongItemClickListener", "()Lcom/android/contacts/calllog/blocked/IOnLongItemClickListener;", "onDataChangeListener", "Lcom/android/contacts/calllog/blocked/IOnDataChangeListener;", "checkItem", "", "holder", "Lcom/android/contacts/calllog/blocked/ViewHolder;", "position", "data", "checkedItemSizeIsEmpty", "clearCheckedState", "createFooterViewHolder", "parent", "Landroid/view/ViewGroup;", "createHeaderViewHolder", "createRealItemViewHolder", "viewType", "cursorToData", "cursor", "Landroid/database/Cursor;", "deleteCheckedItems", "getCheckedMap", "", "getRealItemViewType", "groupConditionType", "data1", DBHelper.COL_DATA2, "onBindFooterViewHolder", "Lcom/obric/utils/ObricGroupCallRecyclerViewAdapter$HeaderFooterData;", "onBindHeaderViewHolder", "onBindViewHolder", "onChangedDataList", "newDataList", "", "onCursorDataChanged", "dataList", "query", "removeData", "setChecked", "positon", "isCheck", "setCheckedAll", "isChecked", "setOnDataChangeListener", "listener", "toDetailPage", "updateHeaderFooterViewHolder", "Lcom/android/contacts/calllog/blocked/HeaderFooterViewHolder;", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BlockedCallAdapter extends ObricGroupCallRecyclerViewAdapter<BlockedCallEntity, RecyclerView.ViewHolder> {
    public static final Companion Companion = null;
    public static final String KEY_LOOKUP_URI = "lookup_uri";
    public static final int VIEW_TYPE_REAL_ITEM = 1;
    private final BlockedCallActivity activity;
    private final CallContactInfoUtils callContactInfo;
    private final Map<Integer, ObricGroupCallRecyclerViewAdapter.GroupCallData<BlockedCallEntity>> checkedMap;
    private boolean isCheckedMapEmpty;
    private boolean isEditMode;
    private final boolean isMultiSimCard;
    private final IOnLongItemClickListener longItemClickListener;
    private IOnDataChangeListener onDataChangeListener;

    /* JADX INFO: compiled from: BlockedCallAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/contacts/calllog/blocked/BlockedCallAdapter$Companion;", "", "()V", "KEY_LOOKUP_URI", "", "VIEW_TYPE_REAL_ITEM", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.obric.utils.ObricGroupCallRecyclerViewAdapter
    public int getRealItemViewType(int r1) {
        return 1;
    }

    public static final /* synthetic */ void access$toDetailPage(BlockedCallAdapter r0, ObricGroupCallRecyclerViewAdapter.GroupCallData r1) {
        r0.toDetailPage(r1);
    }

    @Override // com.obric.utils.ObricGroupCallRecyclerViewAdapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder createRealItemViewHolder(ViewGroup r1, int r2) {
        return createRealItemViewHolder(r1, r2);
    }

    @Override // com.obric.utils.ObricGroupCallRecyclerViewAdapter
    public /* bridge */ /* synthetic */ ICallData cursorToData(Cursor r1) {
        return cursorToData(r1);
    }

    public final BlockedCallActivity getActivity() {
        return this.activity;
    }

    public final IOnLongItemClickListener getLongItemClickListener() {
        return this.longItemClickListener;
    }

    @Override // com.obric.utils.ObricGroupCallRecyclerViewAdapter
    public /* bridge */ /* synthetic */ boolean groupConditionType(ICallData r1, ICallData r2) {
        return groupConditionType((BlockedCallEntity) r1, (BlockedCallEntity) r2);
    }

    public BlockedCallAdapter(BlockedCallActivity r2, IOnLongItemClickListener r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "longItemClickListener");
        super(r2);
        this.activity = r2;
        this.longItemClickListener = r3;
        this.callContactInfo = new CallContactInfoUtils(r2);
        if (DSUtils.isMultiSimEnabled() == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        this.isMultiSimCard = r4;
        this.checkedMap = new LinkedHashMap();
        this.isCheckedMapEmpty = true;
        return;
    L5:
        if (DSUtils.isAllSimsEnable() == false) goto L7;
        r4 = true;
        goto L8
    }

    public final boolean isEditMode() {
        return this.isEditMode;
    }

    public final void setEditMode(boolean r1) {
        this.isEditMode = r1;
    }

    public final Map<Integer, ObricGroupCallRecyclerViewAdapter.GroupCallData<BlockedCallEntity>> getCheckedMap() {
        return this.checkedMap;
    }

    @Override // com.obric.utils.ObricGroupCallRecyclerViewAdapter
    public void onBindViewHolder(final RecyclerView.ViewHolder r10, final int r11, final ObricGroupCallRecyclerViewAdapter.GroupCallData<BlockedCallEntity> r12) {
        Intrinsics.checkNotNullParameter(r10, "holder");
        if ((r10 instanceof ViewHolder) == true) goto L5;
        return;
    L5:
        if (r12 != null) goto L7;
        return;
    L7:
        BlockedCallEntity r0 = r12.getData();
        String r1 = r0.getPhoneNumber();
        if (r1 != null) goto L10;
        return;
    L10:
        final ViewHolder r2 = (ViewHolder) r10;
        String r3 = ContactsUtils.formatNumber(r1);
        if (r3 != null) goto L13;
        r3 = r1;
    L14:
        final String r4 = StringsKt.trim(new Regex("^(\\+86|0086)").replace(r3, "")).toString();
        Object r5 = this.callContactInfo.getContact(r1, new BlockedCallAdapter$onBindViewHolder$1$tag$1(r2, r4, r12));
        boolean r6 = true;
        if (r2.getTag() == null) goto L22;
        Object r7 = r2.getTag();
        if ((r7 instanceof AsyncTask) == false) goto L19;
        AsyncTask r8 = (AsyncTask) r7;
    L20:
        if (r8 == null) goto L22;
        r8.cancel(true);
        goto L22
    L19:
        r8 = null;
    L22:
        r2.setTag(r5);
        OCardListItem.setEndDetailText$default(r2.getListItem(), CallLogTimeRangeUtil.getCallLogListFormatTime(r0.getDate()), 0, 2, null);
        r2.getListItem().setOnClickListener(new BlockedCallAdapter$onBindViewHolder$1$1(this, r10, r11, r12));
        if (r12.getGroupCount() <= 1) goto L25;
        r4 = r4 + " (" + r12.getGroupCount() + ')';
    L25:
        r2.getListItem().setCustomTitleText(r4);
        r2.getListItem().setCustomSubTitleText(MarkInfoUtil.INSTANCE.getMarkChineseString(r0.getInterceptType()));
        r2.getListItem().setTitleColor(Integer.valueOf(this.activity.getResources().getColor(R.color.oui_text_1, null)));
        r2.getListItem().setCustomSubTitleColor(this.activity.getResources().getColor(R.color.oui_red_7, null));
        BlockListItemCardView r13 = r2.getListItem();
        int r14 = r0.getSimId();
        if (r0.getShowSimIcon() != 1) goto L28;
        boolean r9 = true;
    L29:
        r13.setSimId(r14, r9);
        int r15 = getRealDataItemCount();
        if (r15 != 1) goto L32;
        OCardListItem.setCardPosition$default(r2.getListItem(), 0, false, 2, null);
    L39:
        if (this.isEditMode == false) goto L45;
        r2.getListItem().setSelectedMode(true);
        BlockListItemCardView r16 = r2.getListItem();
        if (this.checkedMap.get(Integer.valueOf(r11)) != null) goto L44;
        r6 = false;
    L44:
        r16.setChecked(r6);
    L46:
        r2.getListItem().setEndContainerWidthWrap();
        r2.getListItem().setTitleContainerWidthSpread();
        return;
    L45:
        r2.getListItem().setSelectedMode(false);
        goto L46
    L32:
        if (r11 != 0) goto L35;
        OCardListItem.setCardPosition$default(r2.getListItem(), 1, false, 2, null);
        goto L39
    L35:
        if (r11 != (r15 - 1)) goto L37;
        OCardListItem.setCardPosition$default(r2.getListItem(), 3, false, 2, null);
        goto L39
    L37:
        OCardListItem.setCardPosition$default(r2.getListItem(), 2, false, 2, null);
        goto L39
    L28:
        r9 = false;
        goto L29
    L13:
        Intrinsics.checkNotNullExpressionValue(r3, "systemFormatPhoneNumber ?: phoneNumber");
        goto L14
    }

    @Override // com.obric.utils.ObricGroupCallRecyclerViewAdapter
    public void onBindFooterViewHolder(RecyclerView.ViewHolder r1, int r2, ObricGroupCallRecyclerViewAdapter.HeaderFooterData r3) {
        Intrinsics.checkNotNullParameter(r1, "holder");
        if ((r1 instanceof HeaderFooterViewHolder) == true) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        return;
    L7:
        updateHeaderFooterViewHolder((HeaderFooterViewHolder) r1, r3);
    }

    @Override // com.obric.utils.ObricGroupCallRecyclerViewAdapter
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder r1, int r2, ObricGroupCallRecyclerViewAdapter.HeaderFooterData r3) {
        Intrinsics.checkNotNullParameter(r1, "holder");
        if ((r1 instanceof HeaderFooterViewHolder) == true) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        return;
    L7:
        updateHeaderFooterViewHolder((HeaderFooterViewHolder) r1, r3);
    }

    private final void updateHeaderFooterViewHolder(HeaderFooterViewHolder r2, ObricGroupCallRecyclerViewAdapter.HeaderFooterData r3) {
        ViewGroup.LayoutParams r1 = r2.itemView.getLayoutParams();
        if (r1 != null) goto L5;
        r1 = new ViewGroup.LayoutParams(-1, r3.getHeight());
    L5:
        r2.itemView.setLayoutParams(r1);
    }

    @Override // com.obric.utils.ObricGroupCallRecyclerViewAdapter
    public void onChangedDataList(List<ObricGroupCallRecyclerViewAdapter.GroupCallData<BlockedCallEntity>> r1) {
        if (this.isEditMode == false) goto L6;
        this.checkedMap.clear();
        checkedItemSizeIsEmpty();
        return;
    }

    @Override // com.obric.utils.ObricGroupCallRecyclerViewAdapter
    protected Cursor query() {
        Uri r2 = BlockedCall.INSTANCE.getBLOCKED_CALL_LOG_URI();
        return this.activity.getContentResolver().query(r2, BlockedCall.INSTANCE.getBLOCKED_CALLS_PROJECTION(), null, null, "bcl_datetime DESC ");
    }

    @Override // com.obric.utils.ObricGroupCallRecyclerViewAdapter
    protected void onCursorDataChanged(Cursor r5, List<ObricGroupCallRecyclerViewAdapter.GroupCallData<BlockedCallEntity>> r6) {
        ArrayList<Long> r4 = new ArrayList();
        if (r6 == null) goto L19;
        Iterator<T> r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L19;
        ObricGroupCallRecyclerViewAdapter.GroupCallData r8 = (ObricGroupCallRecyclerViewAdapter.GroupCallData) r7.next();
        boolean r1 = true;
        if (r8.getGroupCount() <= 1) goto L10;
        LinkedHashSet<Long> r9 = r8.getIdGroup();
    L11:
        Collection<? extends Long> r10 = r9;
        if (r10 != null) goto L14;
    L17:
        if (r1 == true) goto L6;
        r4.addAll(r10);
        goto L6
    L14:
        if (r10.isEmpty() == true) goto L17;
        r1 = false;
        goto L17
    L10:
        r9 = SetsKt.setOf(Long.valueOf(((BlockedCallEntity) r8.getData()).getId()));
    L19:
        ContactDetailCacheManager.getInstance().refreshBlockedCallLogCache(r4);
    }

    @Override // com.obric.utils.ObricGroupCallRecyclerViewAdapter
    protected BlockedCallEntity cursorToData(Cursor r2) {
        Intrinsics.checkNotNullParameter(r2, "cursor");
        return ObricCallLogProviderHelper.INSTANCE.cursorToBlockedCallEntity(r2, this.isMultiSimCard);
    }

    @Override // com.obric.utils.ObricGroupCallRecyclerViewAdapter
    public RecyclerView.ViewHolder createFooterViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        return new HeaderFooterViewHolder(new View(this.activity));
    }

    @Override // com.obric.utils.ObricGroupCallRecyclerViewAdapter
    public RecyclerView.ViewHolder createHeaderViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        return new HeaderFooterViewHolder(new View(this.activity));
    }

    @Override // com.obric.utils.ObricGroupCallRecyclerViewAdapter
    public ViewHolder createRealItemViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r2 = LayoutInflater.from(this.activity).inflate(R.layout.blocked_call_card_item, r3, false);
        Intrinsics.checkNotNullExpressionValue(r2, "from(activity).inflate(R…card_item, parent, false)");
        return new ViewHolder(r2);
    }

    private final void toDetailPage(ObricGroupCallRecyclerViewAdapter.GroupCallData<BlockedCallEntity> r7) {
        Uri r1 = null;
        if (r7.getGroupCount() <= 1) goto L8;
        LinkedHashSet<Long> r0 = r7.getIdGroup();
        if (r0 == null) goto L7;
        long[] r2 = CollectionsKt.toLongArray(r0);
    L9:
        Object r3 = r7.getExtra().get(KEY_LOOKUP_URI);
        if ((r3 instanceof Uri) == false) goto L12;
        r1 = (Uri) r3;
    L12:
        Intent r4 = new Intent(this.activity, ContactDetailActivity.class);
        r4.setAction("android.intent.action.VIEW");
        if (r1 == null) goto L15;
        r4.setData(r1);
    L15:
        r4.putExtra(CallDetailActivity.EXTRA_CALL_LOG_IDS, r2);
        r4.putExtra(ContactsUtils.EXTRA_PHONE_NUMBERS, r7.getData().getNumber());
        r4.putExtra(ContactDetailActivity.EXTRA_LAUNCH_FROM_SELF, true);
        r4.putExtra(ContactsUtils.EXTRA_INTERCEPT_TYPE, r7.getData().getInterceptType());
        r4.putExtra("enter_from", "blocked_call_log");
        this.activity.startActivity(r4);
        AnimationUtil.switchActivityAnimation(this.activity, 5);
        return;
    L7:
        r2 = null;
        goto L9
    L8:
        r2 = new long[]{r7.getData().getId()};
        goto L9
    }

    public final boolean setChecked(int r2, boolean r3) {
        if (r3 == false) goto L7;
        ObricGroupCallRecyclerViewAdapter.GroupCallData<BlockedCallEntity> r4 = (ObricGroupCallRecyclerViewAdapter.GroupCallData) CollectionsKt.getOrNull(getDataList(), r2);
        if (r4 == null) goto L6;
        Integer r5 = Integer.valueOf(r2);
        this.checkedMap.put(r5, r4);
    L6:
        boolean r6 = true;
    L8:
        checkedItemSizeIsEmpty();
        return r6;
    L7:
        this.checkedMap.remove(Integer.valueOf(r2));
        r6 = false;
        goto L8
    }

    public final void checkItem(ViewHolder r3, int r4, ObricGroupCallRecyclerViewAdapter.GroupCallData<BlockedCallEntity> r5) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r5, "data");
        if (this.checkedMap.get(Integer.valueOf(r4)) != null) goto L5;
        boolean r0 = true;
    L6:
        r3.getListItem().setChecked(r0);
        if (r0 == false) goto L9;
        Integer r6 = Integer.valueOf(r4);
        this.checkedMap.put(r6, r5);
    L10:
        IOnDataChangeListener r7 = this.onDataChangeListener;
        if (r7 == null) goto L13;
        r7.onItemClickChecked(r4, r5, r0);
    L13:
        checkedItemSizeIsEmpty();
        return;
    L9:
        this.checkedMap.remove(Integer.valueOf(r4));
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public final void setCheckedAll(boolean r5) {
        if (r5 == false) goto L10;
        Iterator<T> r6 = getDataList().iterator();
        int r0 = 0;
    L5:
        if (r6.hasNext() == false) goto L11;
        Object r1 = r6.next();
        int r2 = r0 + 1;
        if (r0 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        Integer r3 = Integer.valueOf(r0);
        Map<Integer, ObricGroupCallRecyclerViewAdapter.GroupCallData<BlockedCallEntity>> r4 = this.checkedMap;
        r4.put(r3, (ObricGroupCallRecyclerViewAdapter.GroupCallData) r1);
        r0 = r2;
    L11:
        checkedItemSizeIsEmpty();
        return;
    L10:
        this.checkedMap.clear();
        goto L11
    }

    public final void clearCheckedState() {
        this.checkedMap.clear();
        checkedItemSizeIsEmpty();
    }

    public final void removeData(final ObricGroupCallRecyclerViewAdapter.GroupCallData<BlockedCallEntity> r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        boolean r0 = getDataList().remove(r4);
        CollectionsKt.removeAll(this.checkedMap.entrySet(), new AnonymousClass1(r4));
        checkedItemSizeIsEmpty();
        if (r0 == false) goto L6;
        notifyDataSetChanged();
        return;
    }

    private final boolean checkedItemSizeIsEmpty() {
        if (this.checkedMap.isEmpty() == false) goto L9;
        if (this.isCheckedMapEmpty == true) goto L7;
        this.isCheckedMapEmpty = true;
    L7:
        return true;
    L9:
        if (this.isCheckedMapEmpty == false) goto L11;
        this.isCheckedMapEmpty = false;
    L11:
        return false;
    }

    public final void setOnDataChangeListener(IOnDataChangeListener r1) {
        this.onDataChangeListener = r1;
    }

    public final void deleteCheckedItems() {
        List<ObricGroupCallRecyclerViewAdapter.GroupCallData<BlockedCallEntity>> r0 = getDataList();
        Iterator<T> r1 = this.checkedMap.entrySet().iterator();
        boolean r2 = false;
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.remove(((Map.Entry) r1.next()).getValue());
        r2 = true;
        goto L4
    L6:
        this.checkedMap.clear();
        if (r2 == false) goto L11;
        notifyDataSetChanged();
        return;
    }

    protected boolean groupConditionType(BlockedCallEntity r3, BlockedCallEntity r4) {
        Intrinsics.checkNotNullParameter(r3, "data1");
        Intrinsics.checkNotNullParameter(r4, DBHelper.COL_DATA2);
        if (r3.getCallType() != 6) goto L9;
        if (r4.getCallType() != 6) goto L9;
        return true;
    L9:
        return super.groupConditionType(r3, r4);
    }
}
