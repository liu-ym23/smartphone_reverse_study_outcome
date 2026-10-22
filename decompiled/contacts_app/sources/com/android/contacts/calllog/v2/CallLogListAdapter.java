package com.android.contacts.calllog.v2;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.GlobalProxyLancet;
import com.android.contacts.DSUtils;
import com.android.contacts.PhoneCallDetails;
import com.android.contacts.calllog.ContactInfo;
import com.android.contacts.calllog.record.CallRecordAndSummaryActivity;
import com.obric.oui.orecyclerview.widget.ListAdapter;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.utils.views.commonitemview.CallLogItemView;
import com.obric.utils.views.commonitemview.bean.SwipeItemButtonType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallLogListAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 A2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002ABBs\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012$\u0010\u0007\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\b\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u001e\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0002\u0010\u000fJ\u0006\u0010(\u001a\u00020\u0006J\u000e\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020+J\u0010\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020'H\u0002J\u001f\u0010.\u001a\u0004\u0018\u00010\n2\u0006\u0010/\u001a\u0002002\b\u0010-\u001a\u0004\u0018\u00010'¢\u0006\u0002\u00101J\u0017\u00102\u001a\u0004\u0018\u00010\n2\u0006\u00103\u001a\u000200H\u0002¢\u0006\u0002\u00104J\u0006\u00105\u001a\u00020\u0006J\u000e\u00106\u001a\u00020\u00062\u0006\u0010-\u001a\u00020'J\u001c\u00107\u001a\u00020\u00062\n\u00108\u001a\u00060\u0003R\u00020\u00002\u0006\u00109\u001a\u00020\nH\u0016J*\u00107\u001a\u00020\u00062\n\u00108\u001a\u00060\u0003R\u00020\u00002\u0006\u00109\u001a\u00020\n2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;H\u0016J\u001c\u0010=\u001a\u00060\u0003R\u00020\u00002\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\nH\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0007\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/android/contacts/calllog/v2/CallLogListAdapter;", "Lcom/obric/oui/orecyclerview/widget/ListAdapter;", "Lcom/android/contacts/calllog/v2/CallLogItem;", "Lcom/android/contacts/calllog/v2/CallLogListAdapter$ViewHolder;", "onItemClick", "Lkotlin/Function1;", "", "onItemLongClick", "Lkotlin/Function4;", "Landroid/view/View;", "", "onDetailClick", "onSwipeAction", "Lkotlin/Function3;", "Lcom/obric/utils/views/commonitemview/bean/SwipeItemButtonType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "closingSwipeItem", "Lcom/obric/utils/views/commonitemview/CallLogItemView;", "contactInfoCache", "Lcom/android/contacts/calllog/v2/ContactInfoCache;", "getContactInfoCache", "()Lcom/android/contacts/calllog/v2/ContactInfoCache;", "setContactInfoCache", "(Lcom/android/contacts/calllog/v2/ContactInfoCache;)V", "currentSwipedItem", "value", "Lcom/android/contacts/calllog/v2/EditModeState;", "editModeState", "getEditModeState", "()Lcom/android/contacts/calllog/v2/EditModeState;", "setEditModeState", "(Lcom/android/contacts/calllog/v2/EditModeState;)V", "listScrollState", "getListScrollState", "()I", "setListScrollState", "(I)V", "pendingContactInfoNumbers", "", "", "clearSwipeState", "closeAllSwipes", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "doNotifyContactInfo", "number", "findPositionByDateNumber", "date", "", "(JLjava/lang/String;)Ljava/lang/Integer;", "findPositionById", "id", "(J)Ljava/lang/Integer;", "flushPendingContactInfoNotifications", "notifyContactInfoChanged", "onBindViewHolder", "holder", "position", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "ViewHolder", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallLogListAdapter extends ListAdapter<CallLogItem, ViewHolder> {
    public static final Companion Companion = null;
    public static final String PAYLOAD_CONTACT_INFO = "contact_info";
    public static final String PAYLOAD_EDIT_MODE = "edit_mode";
    public static final String PAYLOAD_ITEM_META = "item_meta";
    public static final String PAYLOAD_SELECTION = "selection";
    private static final String TAG = "CallLogV2";
    private CallLogItemView closingSwipeItem;
    private ContactInfoCache contactInfoCache;
    private CallLogItemView currentSwipedItem;
    private EditModeState editModeState;
    private int listScrollState;
    private final Function1<CallLogItem, Unit> onDetailClick;
    private final Function1<CallLogItem, Unit> onItemClick;
    private final Function4<CallLogItem, View, Integer, Integer, Unit> onItemLongClick;
    private final Function3<CallLogItem, SwipeItemButtonType, View, Unit> onSwipeAction;
    private final Set<String> pendingContactInfoNumbers;

    /* JADX INFO: compiled from: CallLogListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/contacts/calllog/v2/CallLogListAdapter$Companion;", "", "()V", "PAYLOAD_CONTACT_INFO", "", "PAYLOAD_EDIT_MODE", "PAYLOAD_ITEM_META", "PAYLOAD_SELECTION", "TAG", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: CallLogListAdapter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/contacts/calllog/v2/CallLogListAdapter$ViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "callLogView", "Lcom/obric/utils/views/commonitemview/CallLogItemView;", "(Lcom/android/contacts/calllog/v2/CallLogListAdapter;Lcom/obric/utils/views/commonitemview/CallLogItemView;)V", "bind", "", "item", "Lcom/android/contacts/calllog/v2/CallLogItem;", "editModeState", "Lcom/android/contacts/calllog/v2/EditModeState;", "bindActions", "bindEditMode", "bindMeta", "buildPhoneCallDetails", "Lcom/android/contacts/PhoneCallDetails;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final CallLogItemView callLogView;
        final /* synthetic */ CallLogListAdapter this$0;

        public static /* synthetic */ void $r8$lambda$RziOFm7rcOzqjMKvb7lpbgt4FOE(EditModeState r0, ViewHolder r1, CallLogItem r2, View r3) {
            bindActions$lambda$1(r0, r1, r2, r3);
        }

        public static /* synthetic */ void $r8$lambda$ZmQzmEknTqZIu0raUyRWTyXOqTY(CallLogListAdapter r0, CallLogItem r1, View r2) {
            bindActions$lambda$0(r0, r1, r2);
        }

        public ViewHolder(CallLogListAdapter r2, CallLogItemView r3) {
            Intrinsics.checkNotNullParameter(r3, "callLogView");
            this.this$0 = r2;
            super(r3);
            this.callLogView = r3;
        }

        public static final /* synthetic */ CallLogItemView access$getCallLogView$p(ViewHolder r0) {
            return r0.callLogView;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void bind(final CallLogItem r13, final EditModeState r14) {
            Intrinsics.checkNotNullParameter(r13, "item");
            Intrinsics.checkNotNullParameter(r14, "editModeState");
            if (this.callLogView.isInSwipeAction() == false) goto L5;
            this.callLogView.swipeClose();
        L5:
            this.callLogView.setPhoneDetail(buildPhoneCallDetails(r13), r13.getCallType(), r13.getDate(), r13.getNumber(), r13.getDuration(), r13.isBlocked() ? 1 : 0, false, false);
            if (DSUtils.isMultiSimEnabled() == false) goto L8;
            this.callLogView.setPhoneSimStatus(r13.getSimSlot(), r13.getShowSimIcon());
        L9:
            bindEditMode(r13, r14);
            bindActions(r13, r14);
            ArrayList r0 = CollectionsKt.arrayListOf(new SwipeItemButtonType[]{SwipeItemButtonType.SWIPE_MESSAGE, SwipeItemButtonType.SWIPE_DELETE});
            final CallLogListAdapter r4 = this.this$0;
            this.callLogView.setSwipeItemButtonView(r0, new CallLogListAdapter$ViewHolder$bind$1(r4, r13, this));
            this.callLogView.setEnableSwipe(!r14.isActive());
            CallLogItemView r15 = this.callLogView;
            final CallLogListAdapter r1 = this.this$0;
            r15.addSwipeListener(new CallLogListAdapter$ViewHolder$bind$2(r1, this, r14));
            return;
        L8:
            this.callLogView.setPhoneSimStatus(DSUtils.getDefaultCallSim(), false);
            goto L9
        }

        public final void bindMeta(CallLogItem r2, EditModeState r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "editModeState");
            bindEditMode(r2, r3);
            bindActions(r2, r3);
        }

        public final void bindEditMode(CallLogItem r3, EditModeState r4) {
            Intrinsics.checkNotNullParameter(r3, "item");
            Intrinsics.checkNotNullParameter(r4, "editModeState");
            boolean r0 = r4.isActive();
            this.callLogView.setEditMode(r0);
            if (r0 == false) goto L5;
            this.callLogView.setChecked(CallLogListAdapterKt.isGroupFullySelected(r3, r4.getSelectedIds()));
        L5:
            this.callLogView.setEnableSwipe(!r0);
        }

        private final void bindActions(final CallLogItem r4, final EditModeState r5) {
            CallLogItemView r0 = this.callLogView;
            final CallLogListAdapter r2 = this.this$0;
            r0.setOnClickListener(new CallLogListAdapter$ViewHolder$bindActions$1(r2, r4, r5, this));
            CallLogItemView r1 = this.callLogView;
            final CallLogListAdapter r3 = this.this$0;
            r1.setOnEndIconClickListener(new CallLogListAdapter$ViewHolder$$ExternalSyntheticLambda0(r3, r4));
            this.callLogView.setOnSummaryClickListener(new CallLogListAdapter$ViewHolder$$ExternalSyntheticLambda1(r5, this, r4));
        }

        private static final void bindActions$lambda$0(CallLogListAdapter r0, CallLogItem r1, View r2) {
            Intrinsics.checkNotNullParameter(r0, "this$0");
            Intrinsics.checkNotNullParameter(r1, "$item");
            CallLogListAdapter.access$getOnDetailClick$p(r0).invoke(r1);
        }

        private static final void bindActions$lambda$1(EditModeState r7, ViewHolder r8, CallLogItem r9, View r10) {
            Intrinsics.checkNotNullParameter(r7, "$editModeState");
            Intrinsics.checkNotNullParameter(r8, "this$0");
            Intrinsics.checkNotNullParameter(r9, "$item");
            if (r7.isActive() == true) goto L6;
            CallRecordAndSummaryActivity.Companion r0 = CallRecordAndSummaryActivity.Companion;
            Context r1 = r8.callLogView.getContext();
            Intrinsics.checkNotNullExpressionValue(r1, "callLogView.context");
            r0.startSelf(r1, Long.valueOf(r9.getDate()), r9.getNumber(), r9.getContactName(), "inner", true);
            return;
        }

        private final PhoneCallDetails buildPhoneCallDetails(CallLogItem r25) {
            ContactInfoCache r0 = this.this$0.getContactInfoCache();
            if (r0 == null) goto L5;
            ContactInfo r1 = r0.get(r25.getNumber(), r25.getCountryIso());
        L7:
            if (r1 == null) goto L11;
            String r2 = r1.name;
            if (r2 == null) goto L13;
        L14:
            if (r1 == null) goto L16;
            Uri r3 = r1.photoUri;
        L17:
            Uri r18 = r3;
            if (r1 == null) goto L20;
            int r4 = r1.type;
        L21:
            int r15 = r4;
            if (r1 == null) goto L26;
            String r5 = r1.label;
            if (r5 == null) goto L28;
        L29:
            String r6 = r25.getNumber();
            String r7 = r25.getFormattedNumber();
            if (r7 != null) goto L32;
            r7 = "";
        L32:
            String r8 = r7;
            String r9 = r25.getCountryIso();
            if (r9 != null) goto L35;
            String r10 = "";
        L36:
            String r11 = r25.getLocation();
            if (r11 != null) goto L39;
            String r12 = "";
        L40:
            int r13 = r25.getGroupSize();
            int[] r14 = new int[r13];
            int r16 = 0;
        L41:
            if (r16 >= r13) goto L43;
            r14[r16] = r25.getCallType();
            r16 = r16 + 1;
            goto L41
        L43:
            long r17 = r25.getDate();
            long r19 = r25.getDuration();
            String r110 = r2;
            String r111 = r5;
            if (r1 == null) goto L46;
            Uri r20 = r1.lookupUri;
        L47:
            Uri r112 = r20;
            if (r1 == null) goto L50;
            long r21 = r1.photoId;
        L51:
            PhoneCallDetails r22 = new PhoneCallDetails(r6, r8, r10, r12, r14, r17, r19, r110, r15, r111, r112, r18, r21, r25.getPresentation(), r25.getRecordUri());
            boolean r23 = true;
            if (r25.getFeatures() == 1) goto L55;
            r23 = false;
        L55:
            r22.isVideoCall = r23;
            return r22;
        L50:
            r21 = -1;
            goto L51
        L46:
            r20 = r25.getCachedLookupUri();
            goto L47
        L39:
            r12 = r11;
            goto L40
        L35:
            r10 = r9;
        L28:
            r5 = "";
            goto L29
        L26:
            r5 = r25.getNumberLabel();
            if (r5 != null) goto L29;
        L20:
            r4 = r25.getNumberType();
            goto L21
        L16:
            r3 = r25.getContactPhotoUri();
        L13:
            r2 = "";
            goto L14
        L11:
            r2 = r25.getContactName();
            if (r2 != null) goto L14;
        L5:
            r1 = null;
            goto L7
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ CallLogItemView access$getClosingSwipeItem$p(CallLogListAdapter r0) {
        return r0.closingSwipeItem;
    }

    public static final /* synthetic */ CallLogItemView access$getCurrentSwipedItem$p(CallLogListAdapter r0) {
        return r0.currentSwipedItem;
    }

    public static final /* synthetic */ Function1 access$getOnDetailClick$p(CallLogListAdapter r0) {
        return r0.onDetailClick;
    }

    public static final /* synthetic */ Function1 access$getOnItemClick$p(CallLogListAdapter r0) {
        return r0.onItemClick;
    }

    public static final /* synthetic */ Function4 access$getOnItemLongClick$p(CallLogListAdapter r0) {
        return r0.onItemLongClick;
    }

    public static final /* synthetic */ Function3 access$getOnSwipeAction$p(CallLogListAdapter r0) {
        return r0.onSwipeAction;
    }

    public static final /* synthetic */ void access$setClosingSwipeItem$p(CallLogListAdapter r0, CallLogItemView r1) {
        r0.closingSwipeItem = r1;
    }

    public static final /* synthetic */ void access$setCurrentSwipedItem$p(CallLogListAdapter r0, CallLogItemView r1) {
        r0.currentSwipedItem = r1;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((ViewHolder) r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2, List r3) {
        onBindViewHolder((ViewHolder) r1, r2, r3);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CallLogListAdapter(Function1<? super CallLogItem, Unit> r2, Function4<? super CallLogItem, ? super View, ? super Integer, ? super Integer, Unit> r3, Function1<? super CallLogItem, Unit> r4, Function3<? super CallLogItem, ? super SwipeItemButtonType, ? super View, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "onItemClick");
        Intrinsics.checkNotNullParameter(r3, "onItemLongClick");
        Intrinsics.checkNotNullParameter(r4, "onDetailClick");
        Intrinsics.checkNotNullParameter(r5, "onSwipeAction");
        super(new CallLogDiffCallback());
        this.onItemClick = r2;
        this.onItemLongClick = r3;
        this.onDetailClick = r4;
        this.onSwipeAction = r5;
        this.pendingContactInfoNumbers = new LinkedHashSet();
        this.editModeState = EditModeState.Companion.getINACTIVE();
    }

    public final ContactInfoCache getContactInfoCache() {
        return this.contactInfoCache;
    }

    public final void setContactInfoCache(ContactInfoCache r1) {
        this.contactInfoCache = r1;
    }

    public final int getListScrollState() {
        return this.listScrollState;
    }

    public final void setListScrollState(int r1) {
        this.listScrollState = r1;
    }

    public final void notifyContactInfoChanged(String r2) {
        Intrinsics.checkNotNullParameter(r2, "number");
        if (this.listScrollState != 0) goto L5;
        doNotifyContactInfo(r2);
        return;
    L5:
        this.pendingContactInfoNumbers.add(r2);
    }

    public final void flushPendingContactInfoNotifications() {
        if (this.pendingContactInfoNumbers.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<String> r0 = this.pendingContactInfoNumbers.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        doNotifyContactInfo(r0.next());
        goto L7
    L9:
        this.pendingContactInfoNumbers.clear();
    }

    private final void doNotifyContactInfo(String r4) {
        int r0 = getItemCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (Intrinsics.areEqual(getItem(r1).getNumber(), r4) == false) goto L7;
        notifyItemChanged(r1, PAYLOAD_CONTACT_INFO);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    public final EditModeState getEditModeState() {
        return this.editModeState;
    }

    public final void setEditModeState(EditModeState r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        EditModeState r0 = this.editModeState;
        this.editModeState = r5;
        if (r0.isActive() == r5.isActive()) goto L6;
        notifyItemRangeChanged(0, getItemCount(), PAYLOAD_EDIT_MODE);
        return;
    L6:
        if (Intrinsics.areEqual(r0.getSelectedIds(), r5.getSelectedIds()) == true) goto L21;
        Set r1 = SetsKt.minus(r5.getSelectedIds(), r0.getSelectedIds());
        Set r6 = SetsKt.minus(r0.getSelectedIds(), r5.getSelectedIds());
        Iterator r2 = SetsKt.plus(r1, r6).iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        Integer r3 = findPositionById(((Number) r2.next()).longValue());
        if (r3 == null) goto L9;
        notifyItemChanged(r3.intValue(), PAYLOAD_SELECTION);
        goto L9
    L13:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "selection changed: +" + r1.size() + ", -" + r6.size());
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "parent");
        Context r1 = r7.getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "parent.context");
        CallLogItemView r9 = new CallLogItemView(r1, null, 0, 4, null);
        r9.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new ViewHolder(this, r9);
    }

    public void onBindViewHolder(ViewHolder r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        CallLogItem r5 = getItem(r4);
        r3.itemView.setAlpha(1.0f);
        r3.itemView.setTranslationX(0.0f);
        Intrinsics.checkNotNullExpressionValue(r5, "item");
        r3.bind(r5, this.editModeState);
    }

    public void onBindViewHolder(ViewHolder r3, int r4, List<Object> r5) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r5, "payloads");
        CallLogItem r0 = getItem(r4);
        if (r5.isEmpty() == false) goto L5;
    L13:
        onBindViewHolder(r3, r4);
        return;
    L5:
        if (r5.contains(PAYLOAD_CONTACT_INFO) == true) goto L13;
        if (r5.contains(PAYLOAD_ITEM_META) == false) goto L11;
        Intrinsics.checkNotNullExpressionValue(r0, "item");
        r3.bindMeta(r0, this.editModeState);
        return;
    L11:
        Intrinsics.checkNotNullExpressionValue(r0, "item");
        r3.bindEditMode(r0, this.editModeState);
    }

    private final Integer findPositionById(long r5) {
        int r0 = getItemCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        if (getItem(r1).getId() == r5) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return Integer.valueOf(r1);
    L9:
        return null;
    }

    public final Integer findPositionByDateNumber(long r7, String r9) {
        if (r9 != null) goto L5;
        return null;
    L5:
        int r1 = getItemCount();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L14;
        CallLogItem r3 = getItem(r2);
        if (r3.getDate() != r7) goto L13;
        if (Intrinsics.areEqual(r3.getNumber(), r9) == false) goto L13;
        return Integer.valueOf(r2);
    L13:
        r2 = r2 + 1;
        goto L6
    L14:
        return null;
    }

    public final void closeAllSwipes(RecyclerView r6) {
        Intrinsics.checkNotNullParameter(r6, "recyclerView");
        int r0 = r6.getChildCount();
        int r1 = 0;
    L3:
        CallLogItemView r2 = null;
        if (r1 >= r0) goto L14;
        View r3 = r6.getChildAt(r1);
        if ((r3 instanceof CallLogItemView) == false) goto L8;
        r2 = (CallLogItemView) r3;
    L8:
        if (r2 == null) goto L13;
        if (r2.isInSwipeAction() == false) goto L13;
        r2.swipeClose();
    L13:
        r1 = r1 + 1;
        goto L3
    L14:
        this.currentSwipedItem = null;
        this.closingSwipeItem = null;
    }

    public final void clearSwipeState() {
        this.currentSwipedItem = null;
        this.closingSwipeItem = null;
    }
}
