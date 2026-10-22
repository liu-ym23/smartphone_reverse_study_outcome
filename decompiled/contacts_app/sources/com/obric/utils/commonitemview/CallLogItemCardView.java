package com.obric.utils.commonitemview;

import android.content.Context;
import android.content.res.Resources;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.PhoneCallDetails;
import com.android.contacts.R;
import com.android.contacts.activities.ContactCalllogsActivity;
import com.android.contacts.calllog.CallTypeHelper;
import com.android.contacts.calllog.CallTypeIconsView;
import com.android.contacts.calllog.PhoneNumberHelper;
import com.android.contacts.calllog.record.SuggestionMaxWidthTextView;
import com.android.contacts.detail.ContactDetailDisplayUtils;
import com.android.contacts.util.CallLogTimeRangeUtil;
import com.android.contacts.util.ContactTypeLabelUtils;
import com.android.contacts.util.DateUtils;
import com.obric.callsummary.bean.CallSummary;
import com.obric.model.CallFeatureModel;
import com.obric.model.bean.CallFeatureBean;
import com.obric.oui.text.OTextView;
import com.obric.utils.ObriceRecordSummaryUtils;
import com.obric.utils.views.commonitemview.ContactsCommonListItem;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.Regex;

/* JADX INFO: compiled from: CallLogItemCardView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\n\u0018\u0000 \\2\u00020\u0001:\u0001\\B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010.\u001a\u0002092\u0006\u0010:\u001a\u00020+J \u0010;\u001a\u0002092\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020=J\u000e\u0010A\u001a\u0002092\u0006\u0010B\u001a\u00020+J\u0016\u0010C\u001a\u0002092\u0006\u0010D\u001a\u00020-2\u0006\u0010E\u001a\u00020FJB\u0010C\u001a\u0002092\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020-2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020=2\u0006\u0010H\u001a\u00020F2\b\b\u0002\u0010I\u001a\u00020+JB\u0010J\u001a\u0002092\u0006\u0010G\u001a\u00020-2\u0006\u0010E\u001a\u00020F2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020=2\u0006\u0010H\u001a\u00020F2\b\b\u0002\u0010I\u001a\u00020+J\u0016\u0010K\u001a\u0002092\u0006\u0010L\u001a\u00020F2\u0006\u0010M\u001a\u00020+J@\u0010N\u001a\u0002092\u0006\u0010*\u001a\u00020+2\u0006\u0010G\u001a\u00020-2\u0006\u0010E\u001a\u00020F2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020=2\u0006\u0010H\u001a\u00020FJ\u0016\u0010O\u001a\u0002092\u0006\u00103\u001a\u00020+2\u0006\u0010*\u001a\u00020+J\u0016\u0010P\u001a\u0002092\u0006\u00103\u001a\u00020+2\u0006\u0010*\u001a\u00020+JC\u0010Q\u001a\u0002092\u0006\u0010E\u001a\u00020F2\u0006\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010S2\b\u0010U\u001a\u0004\u0018\u00010F2\u0006\u0010V\u001a\u00020S2\b\b\u0002\u0010I\u001a\u00020+H\u0002¢\u0006\u0002\u0010WJ \u0010X\u001a\u0002092\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020=J7\u0010Y\u001a\u0002092\u0006\u0010E\u001a\u00020F2\u0006\u0010R\u001a\u00020S2\b\u0010U\u001a\u0004\u0018\u00010F2\u0006\u0010V\u001a\u00020S2\u0006\u0010H\u001a\u00020FH\u0002¢\u0006\u0002\u0010ZJ\u0006\u0010[\u001a\u000209R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001a\u001a\u00020\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001b\u0010\u0017R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00106\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0011\"\u0004\b8\u0010\u0013¨\u0006]"}, d2 = {"Lcom/obric/utils/commonitemview/CallLogItemCardView;", "Lcom/obric/utils/views/commonitemview/ContactsCommonListItem;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "callDuration", "Landroid/widget/TextView;", "callLabelText", "getCallLabelText", "()Landroid/widget/TextView;", "setCallLabelText", "(Landroid/widget/TextView;)V", "callLogEndViewIcon", "Landroid/widget/ImageView;", "getCallLogEndViewIcon", "()Landroid/widget/ImageView;", "setCallLogEndViewIcon", "(Landroid/widget/ImageView;)V", "callLogSingleSubView", "Landroid/view/View;", "getCallLogSingleSubView", "()Landroid/view/View;", "callLogSingleSubView$delegate", "Lkotlin/Lazy;", "callLogSubView", "getCallLogSubView", "callLogSubView$delegate", "callNumber", "callSummary", "Lcom/android/contacts/calllog/record/SuggestionMaxWidthTextView;", "callTypeAndDate", "Lcom/obric/oui/text/OTextView;", "callTypeHelper", "Lcom/android/contacts/calllog/CallTypeHelper;", "callTypeIcons", "Lcom/android/contacts/calllog/CallTypeIconsView;", "getCallTypeIcons", "()Lcom/android/contacts/calllog/CallTypeIconsView;", "setCallTypeIcons", "(Lcom/android/contacts/calllog/CallTypeIconsView;)V", ContactCalllogsActivity.EXTRA_CONTACT_HAS_MORE_NUMBERS, "", "details", "Lcom/android/contacts/PhoneCallDetails;", "hideIntelligentStatusView", "intelligentIcon", "intelligentLayout", "Landroid/widget/LinearLayout;", "intelligentText", "isShowSingleContactCalls", "phoneNumberHelper", "Lcom/android/contacts/calllog/PhoneNumberHelper;", "simIcon", "getSimIcon", "setSimIcon", "", "hide", "setCallSummaryText", "date", "", "number", "", "duration", "setEditMode", "isEditMode", "setPhoneCallDetails", "pDetails", "callType", "", "detail", "interceptType", "isMarked", "setPhoneDetail", "setPhoneSimStatus", "simId", "showSimIcon", "showSingleContactCallNumber", "showSingleContactCalls", "showSingleContactCallsWithNoUpdate", "updateCallLogView", "displayNumber", "", "numberFormattedLabel", "callCount", "dateText", "(ILjava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/Integer;Ljava/lang/CharSequence;Z)V", "updateIntelligentLayout", "updateSingleContactCallsView", "(ILjava/lang/CharSequence;Ljava/lang/Integer;Ljava/lang/CharSequence;I)V", "updateView", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallLogItemCardView extends ContactsCommonListItem {
    public static final Companion Companion = null;
    public static final int MAX_CALL_TYPE_ICONS = 1;
    public static final long RING_ONCE_MAX_LIMIT = 5;
    private TextView callDuration;
    private TextView callLabelText;
    private ImageView callLogEndViewIcon;
    private final Lazy callLogSingleSubView$delegate;
    private final Lazy callLogSubView$delegate;
    private TextView callNumber;
    private SuggestionMaxWidthTextView callSummary;
    private OTextView callTypeAndDate;
    private CallTypeHelper callTypeHelper;
    private CallTypeIconsView callTypeIcons;
    private boolean contactHasMoreNumbers;
    private PhoneCallDetails details;
    private boolean hideIntelligentStatusView;
    private ImageView intelligentIcon;
    private LinearLayout intelligentLayout;
    private TextView intelligentText;
    private boolean isShowSingleContactCalls;
    private PhoneNumberHelper phoneNumberHelper;
    private ImageView simIcon;

    /* JADX INFO: compiled from: CallLogItemCardView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/utils/commonitemview/CallLogItemCardView$Companion;", "", "()V", "MAX_CALL_TYPE_ICONS", "", "RING_ONCE_MAX_LIMIT", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    public /* synthetic */ CallLogItemCardView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public CallLogItemCardView(final Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, 0, 4, null);
        this.callLogSingleSubView$delegate = LazyKt.lazy(new CallLogItemCardView$callLogSingleSubView$2(r8));
        this.callLogSubView$delegate = LazyKt.lazy(new CallLogItemCardView$callLogSubView$2(r8));
        setCardType(1);
    }

    public final View getCallLogSingleSubView() {
        Object r1 = this.callLogSingleSubView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-callLogSingleSubView>(...)");
        return (View) r1;
    }

    public final View getCallLogSubView() {
        Object r1 = this.callLogSubView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-callLogSubView>(...)");
        return (View) r1;
    }

    public final ImageView getSimIcon() {
        return this.simIcon;
    }

    public final void setSimIcon(ImageView r1) {
        this.simIcon = r1;
    }

    public final CallTypeIconsView getCallTypeIcons() {
        return this.callTypeIcons;
    }

    public final void setCallTypeIcons(CallTypeIconsView r1) {
        this.callTypeIcons = r1;
    }

    public final TextView getCallLabelText() {
        return this.callLabelText;
    }

    public final void setCallLabelText(TextView r1) {
        this.callLabelText = r1;
    }

    public final ImageView getCallLogEndViewIcon() {
        return this.callLogEndViewIcon;
    }

    public final void setCallLogEndViewIcon(ImageView r1) {
        this.callLogEndViewIcon = r1;
    }

    public final void setEditMode(boolean r2) {
        setSelectedMode(r2);
        if (this.isShowSingleContactCalls == true) goto L6;
        showTailIcon(!r2);
        return;
    }

    public final void showSingleContactCallNumber(boolean r14, PhoneCallDetails r15, int r16, long r17, String r19, long r20, int r22) {
        Intrinsics.checkNotNullParameter(r15, "detail");
        showSingleContactCalls(true, r14);
        setPhoneDetail$default(this, r15, r16, r17, r19, r20, r22, false, 64, null);
    }

    public final void showSingleContactCallsWithNoUpdate(boolean r1, boolean r2) {
        this.isShowSingleContactCalls = r1;
        this.contactHasMoreNumbers = r2;
    }

    public final void showSingleContactCalls(boolean r1, boolean r2) {
        this.isShowSingleContactCalls = r1;
        this.contactHasMoreNumbers = r2;
        updateView();
    }

    public final void updateView() {
        setTitleContainerWidthSpread();
        if (this.isShowSingleContactCalls == true) goto L16;
        setDefaultCustomEndView(3);
        setTailIcon(R.drawable.icon_item_arrow);
        showTailIcon(true);
        showCustomEnd(true);
        setEndContainerWidthWrap();
        this.callTypeAndDate = getEndDetail();
        ViewGroup r0 = getItemEndContainer();
        if (r0 == null) goto L9;
        ViewGroup.LayoutParams r4 = r0.getLayoutParams();
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        ((ViewGroup.MarginLayoutParams) r4).setMarginEnd(MathKt.roundToInt(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics())));
        r0.setLayoutParams(r4);
        r0.requestLayout();
    L9:
        this.simIcon = (ImageView) getCallLogSubView().findViewById(R.id.calllog_item_sub_view_call_type_sim);
        this.callTypeIcons = (CallTypeIconsView) getCallLogSubView().findViewById(R.id.calllog_item_sub_view_call_type_icon);
        this.callLabelText = (TextView) getCallLogSubView().findViewById(R.id.calllog_item_sub_view_call_label);
        this.callSummary = (SuggestionMaxWidthTextView) getCallLogSubView().findViewById(R.id.calllog_item_sub_view_call_summary);
        setSubtitleContainer(getCallLogSubView());
        ImageView r1 = getTailIconView();
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        ((ViewGroup.MarginLayoutParams) r2).setMarginEnd(MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics())));
        r1.setLayoutParams(r2);
    L12:
        this.callLogEndViewIcon = r1;
        SuggestionMaxWidthTextView r3 = this.callSummary;
        if (r3 == null) goto L17;
        r3.setIcon(getContext().getDrawable(R.drawable.ic_call_summary));
    L17:
        showSubtitleContainer(true);
        showDivider(true);
        return;
    L16:
        setDefaultTailIcon(0);
        showTailIcon(true);
        showCustomEnd(true);
        setEndContainerWidthWrap();
        this.simIcon = (ImageView) getCallLogSingleSubView().findViewById(R.id.calllog_item_sub_view_call_type_sim);
        this.callTypeIcons = (CallTypeIconsView) getCallLogSingleSubView().findViewById(R.id.calllog_item_sub_view_call_type_icon);
        this.callNumber = (TextView) getCallLogSingleSubView().findViewById(R.id.calllog_sub_sing_number);
        this.callDuration = (TextView) getCallLogSingleSubView().findViewById(R.id.calllog_duration);
        this.intelligentLayout = (LinearLayout) getCallLogSingleSubView().findViewById(R.id.intelligent_layout);
        this.intelligentIcon = (ImageView) getCallLogSingleSubView().findViewById(R.id.intelligent_icon);
        this.intelligentText = (TextView) getCallLogSingleSubView().findViewById(R.id.intelligent_text);
        setSubtitleContainer(getCallLogSingleSubView());
        goto L17
    }

    public static /* synthetic */ void setPhoneDetail$default(CallLogItemCardView r11, PhoneCallDetails r12, int r13, long r14, String r16, long r17, int r19, boolean r20, int r21, Object r22) {
        if ((r21 & 64) == 0) goto L5;
        boolean r10 = false;
    L6:
        r11.setPhoneDetail(r12, r13, r14, r16, r17, r19, r10);
        return;
    L5:
        r10 = r20;
        goto L6
    }

    public final void setPhoneDetail(PhoneCallDetails r11, int r12, long r13, String r15, long r16, int r18, boolean r19) {
        Intrinsics.checkNotNullParameter(r11, "detail");
        updateView();
        this.details = r11;
        if (this.phoneNumberHelper != null) goto L6;
        this.phoneNumberHelper = new PhoneNumberHelper(getContext().getResources());
    L6:
        if (this.callTypeHelper != null) goto L8;
        this.callTypeHelper = new CallTypeHelper(getContext().getResources());
    L8:
        setPhoneCallDetails(r12, r11, r13, r15, r16, r18, r19);
    }

    public final void setPhoneSimStatus(int r3, boolean r4) {
        if (DSUtils.useDSFeature() == true) goto L10;
        if (r4 == true) goto L10;
        ImageView r2 = this.simIcon;
        if (r2 == null) goto L27;
        r2.setVisibility(8);
        return;
    L27:
        return;
    L10:
        int r5 = DSUtils.getSimIconResource(r3);
        if (r5 <= 0) goto L19;
        ImageView r6 = this.simIcon;
        if (r6 == null) goto L16;
        r6.setVisibility(0);
    L16:
        ImageView r7 = this.simIcon;
        if (r7 == null) goto L25;
        r7.setImageResource(r5);
        return;
    L25:
        return;
    L19:
        ImageView r8 = this.simIcon;
        if (r8 == null) goto L28;
        r8.setVisibility(8);
        return;
    }

    public static /* synthetic */ void setPhoneCallDetails$default(CallLogItemCardView r11, int r12, PhoneCallDetails r13, long r14, String r16, long r17, int r19, boolean r20, int r21, Object r22) {
        if ((r21 & 64) == 0) goto L5;
        boolean r10 = false;
    L6:
        r11.setPhoneCallDetails(r12, r13, r14, r16, r17, r19, r10);
        return;
    L5:
        r10 = r20;
        goto L6
    }

    public final void setPhoneCallDetails(int r15, PhoneCallDetails r16, long r17, String r19, long r20, int r22, boolean r23) {
        Intrinsics.checkNotNullParameter(r16, "detail");
        CallTypeIconsView r1 = this.callTypeIcons;
        if (r1 == null) goto L5;
        r1.clear();
    L5:
        int[] r0 = r16.callTypes;
        boolean r2 = false;
        if (r0 == null) goto L8;
        int r3 = r0.length;
    L9:
        CallTypeIconsView r4 = this.callTypeIcons;
        if (r4 == null) goto L12;
        r4.add(r15);
    L12:
        CallTypeIconsView r5 = this.callTypeIcons;
        if (r5 == null) goto L16;
        r5.setVisibility(0);
    L16:
        CharSequence r6 = null;
        if (r3 <= 1) goto L19;
        Integer r7 = Integer.valueOf(r3);
    L20:
        long r8 = 0;
        if (this.isShowSingleContactCalls == true) goto L26;
        PhoneCallDetails r9 = this.details;
        if (r9 == null) goto L25;
        r8 = r9.date;
    L25:
        Context r10 = getContext();
        Intrinsics.checkNotNullExpressionValue(r10, "context");
        String r11 = CallLogTimeRangeUtil.getCallLogListFormatTime(r8, r10);
    L30:
        String r12 = r11;
        PhoneCallDetails r13 = this.details;
        if (r13 == null) goto L33;
        CharSequence r14 = r13.number;
    L35:
        if (TextUtils.isEmpty(r14) == true) goto L51;
        PhoneCallDetails r18 = this.details;
        if (r18 == null) goto L39;
        CharSequence r21 = r18.number;
    L41:
        if (PhoneNumberUtils.isUriNumber(String.valueOf(r21)) == true) goto L51;
        PhoneCallDetails r24 = this.details;
        if (r24 == null) goto L49;
        int r25 = r24.numberType;
        Context r26 = getContext();
        Integer r27 = Integer.valueOf(r25);
        PhoneCallDetails r28 = this.details;
        if (r28 == null) goto L47;
        CharSequence r29 = r28.numberLabel;
    L48:
        CharSequence r30 = ContactTypeLabelUtils.getPhoneTypeLabel(r26, r27, r29);
    L50:
        CharSequence r31 = r30;
    L52:
        PhoneCallDetails r32 = this.details;
        if (r32 == null) goto L55;
        CharSequence r33 = r32.formattedNumber;
    L57:
        if (TextUtils.isEmpty(r33) == true) goto L62;
        PhoneCallDetails r34 = this.details;
        if (r34 == null) goto L61;
        CharSequence r35 = r34.formattedNumber;
    L68:
        PhoneCallDetails r110 = this.details;
        if (r110 == null) goto L87;
        int r111 = r110.presentation;
        PhoneNumberHelper r112 = this.phoneNumberHelper;
        if (r112 == null) goto L80;
        PhoneCallDetails r113 = this.details;
        if (r113 == null) goto L75;
        CharSequence r114 = r113.number;
    L76:
        PhoneCallDetails r115 = this.details;
        if (r115 == null) goto L79;
        r6 = r115.formattedNumber;
    L79:
        r6 = r112.getDisplayNumber(r114, r6, r111, true);
        goto L80
    L75:
        r114 = null;
    L80:
        if (r6 != null) goto L82;
    L83:
        r2 = true;
    L84:
        if (r2 == false) goto L86;
        r6 = r35;
    L86:
        if (r6 == null) goto L87;
    L91:
        if (this.isShowSingleContactCalls == false) goto L93;
        updateSingleContactCallsView(r15, r6, r7, r12, r22);
        updateIntelligentLayout(r17, r19, r20);
    L94:
        if (r15 != 1) goto L96;
        CallTypeIconsView r36 = this.callTypeIcons;
        if (r36 == null) goto L126;
        r36.setContentDescription(getContext().getResources().getString(R.string.type_incoming));
        return;
    L126:
        return;
    L96:
        if (r15 != 2) goto L98;
        CallTypeIconsView r37 = this.callTypeIcons;
        if (r37 == null) goto L125;
        r37.setContentDescription(getContext().getResources().getString(R.string.type_outgoing));
        return;
    L125:
        return;
    L98:
        if (r15 != 3) goto L100;
        CallTypeIconsView r38 = this.callTypeIcons;
        if (r38 == null) goto L124;
        r38.setContentDescription(getContext().getResources().getString(R.string.type_missed));
        return;
    L124:
        return;
    L100:
        if (r15 != 7) goto L122;
        CallTypeIconsView r39 = this.callTypeIcons;
        if (r39 == null) goto L123;
        r39.setContentDescription(getContext().getResources().getString(R.string.type_answered_elsewhere));
        return;
    L123:
        return;
    L122:
        return;
    L93:
        updateCallLogView(r15, r6, r31, r7, r12, r23);
        setCallSummaryText(r17, r19, r20);
        goto L94
    L82:
        if (r6.length() != 0) goto L84;
    L87:
        if (r35 != null) goto L89;
        goto L91
    L89:
        r6 = r35;
        goto L91
    L61:
        r35 = null;
        goto L68
    L62:
        PhoneCallDetails r40 = this.details;
        if (r40 == null) goto L65;
        r35 = r40.number;
    L66:
        if (r35 != null) goto L68;
        goto L68
    L65:
        r35 = null;
        goto L66
    L55:
        r33 = null;
        goto L57
    L47:
        r29 = null;
        goto L48
    L49:
        r30 = null;
        goto L50
    L39:
        r21 = null;
    L51:
        r31 = null;
        goto L52
    L33:
        r14 = null;
        goto L35
    L26:
        PhoneCallDetails r41 = this.details;
        if (r41 == null) goto L29;
        r8 = r41.date;
    L29:
        r11 = CallLogTimeRangeUtil.getCallDetailFormatTime(r8);
        goto L30
    L19:
        r7 = null;
        goto L20
    L8:
        r3 = 0;
        goto L9
    }

    public final void hideIntelligentStatusView(boolean r1) {
        this.hideIntelligentStatusView = r1;
    }

    public final void setCallSummaryText(long r6, String r8, long r9) {
        if (this.hideIntelligentStatusView == false) goto L9;
        SuggestionMaxWidthTextView r5 = this.callSummary;
        if (r5 == null) goto L59;
        r5.setVisibility(8);
        return;
    L59:
        return;
    L9:
        if (r8 != null) goto L15;
        SuggestionMaxWidthTextView r7 = this.callSummary;
        if (r7 == null) goto L60;
        r7.setVisibility(8);
        return;
    L60:
        return;
    L15:
        CallFeatureBean r0 = CallFeatureModel.INSTANCE.getCallFeature(r6, r8);
        if (r0 != null) goto L23;
        SuggestionMaxWidthTextView r10 = this.callSummary;
        if (r10 == null) goto L61;
        r10.setVisibility(8);
        return;
    L61:
        return;
    L23:
        if (r0.isIntelligentCallEnabled() == true) goto L25;
    L30:
        String r11 = ObriceRecordSummaryUtils.getCallLogSummaryText(Long.valueOf(r6), r8);
        boolean r12 = r0.isFeatureCallSummaryEnabled();
        boolean r2 = CallFeatureModel.INSTANCE.getSummarizingDataSet().contains(new Pair(Long.valueOf(r6), r8));
        if (r12 == true) goto L39;
        if (r2 == true) goto L39;
        SuggestionMaxWidthTextView r13 = this.callSummary;
        if (r13 == null) goto L65;
        r13.setVisibility(8);
        return;
    L65:
        return;
    L39:
        if (r0.isSummaryEmpty() == true) goto L49;
        String r14 = r11;
        if (TextUtils.isEmpty(r14) == true) goto L49;
        CallSummary r15 = r0.getSummary();
        Context r1 = getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        if (r15.isUnableToSummarize(r1) == true) goto L49;
        SuggestionMaxWidthTextView r16 = this.callSummary;
        Intrinsics.checkNotNull(r16);
        r16.setText(r14);
        SuggestionMaxWidthTextView r17 = this.callSummary;
        if (r17 == null) goto L66;
        r17.setVisibility(0);
        return;
    L66:
        return;
    L49:
        if (CallFeatureModel.INSTANCE.getSummarizingDataSet().contains(new Pair(Long.valueOf(r6), r8)) == false) goto L54;
        SuggestionMaxWidthTextView r18 = this.callSummary;
        Intrinsics.checkNotNull(r18);
        r18.setText(R.string.summary_generation);
        SuggestionMaxWidthTextView r19 = this.callSummary;
        if (r19 == null) goto L67;
        r19.setVisibility(0);
        return;
    L67:
        return;
    L54:
        SuggestionMaxWidthTextView r20 = this.callSummary;
        if (r20 == null) goto L68;
        r20.setVisibility(8);
        return;
    L68:
        return;
    L25:
        if (r9 <= 0) goto L30;
        if (r0.isOnlyUseIntelligentCall() == false) goto L29;
        setTitleColor(Integer.valueOf(getContext().getResources().getColor(R.color.oui_red_6)));
        goto L30
    L29:
        setTitleColor(Integer.valueOf(getContext().getResources().getColor(R.color.oui_text_1)));
        goto L30
    }

    private final void updateSingleContactCallsView(int r9, CharSequence r10, Integer r11, CharSequence r12, int r13) {
        PhoneCallDetails r0 = this.details;
        boolean r1 = true;
        if (r0 == null) goto L9;
        int[] r2 = r0.callTypes;
        if (r2 == null) goto L9;
        if (r2[0] != 3) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
        String r14 = getContext().getResources().getString(R.string.type_missed);
    L30:
        if (this.contactHasMoreNumbers == false) goto L39;
        TextView r4 = this.callNumber;
        if (r4 == null) goto L35;
        r4.setVisibility(0);
    L35:
        TextView r5 = this.callNumber;
        if (r5 == null) goto L39;
        r5.setText(r10.toString());
    L39:
        if (r11 == null) goto L41;
        r14 = r14 + " (" + r11 + ')';
    L41:
        if (r9 != 3) goto L43;
        setTitleColor(Integer.valueOf(getContext().getResources().getColor(R.color.oui_red_6)));
    L44:
        TextView r15 = this.callDuration;
        if (r15 == null) goto L48;
        r15.setText(r14);
    L48:
        setTitleText(r12.toString());
        return;
    L43:
        setTitleColor(Integer.valueOf(getContext().getResources().getColor(R.color.oui_text_1)));
        goto L44
    L12:
        PhoneCallDetails r6 = this.details;
        long r7 = 0;
        if (r6 != null) goto L15;
    L17:
        r1 = false;
    L18:
        if (r1 == false) goto L20;
        if (r13 <= 0) goto L28;
        r14 = getContext().getResources().getString(R.string.type_blocked);
        goto L30
    L28:
        r14 = getContext().getResources().getString(R.string.cancelled);
        goto L30
    L20:
        if (ContactsUtils.FEATURE_CMCC == false) goto L22;
        r14 = "";
        goto L30
    L22:
        PhoneCallDetails r16 = this.details;
        if (r16 == null) goto L25;
        r7 = r16.duration;
    L25:
        r14 = DateUtils.formatDuration(r7, getContext());
        goto L30
    L15:
        if (r6.duration != 0) goto L17;
    L9:
        r3 = false;
        goto L10
    }

    public final void updateIntelligentLayout(long r5, String r7, long r8) {
        if (this.hideIntelligentStatusView == false) goto L9;
        LinearLayout r4 = this.intelligentLayout;
        if (r4 == null) goto L57;
        r4.setVisibility(8);
        return;
    L57:
        return;
    L9:
        if (r7 != null) goto L15;
        LinearLayout r6 = this.intelligentLayout;
        if (r6 == null) goto L58;
        r6.setVisibility(8);
        return;
    L58:
        return;
    L15:
        CallFeatureBean r9 = CallFeatureModel.INSTANCE.getCallFeature(r5, r7);
        if (r9 != null) goto L23;
        LinearLayout r10 = this.intelligentLayout;
        if (r10 == null) goto L59;
        r10.setVisibility(8);
        return;
    L59:
        return;
    L23:
        if (r9.isIntelligentCallEnabled() == false) goto L38;
        if (r8 <= 0) goto L38;
        LinearLayout r11 = this.intelligentLayout;
        if (r11 == null) goto L30;
        r11.setVisibility(0);
    L30:
        ImageView r12 = this.intelligentIcon;
        if (r12 == null) goto L33;
        r12.setImageResource(R.drawable.call_detail_intelligent_call);
    L33:
        TextView r13 = this.intelligentText;
        if (r13 == null) goto L62;
        r13.setText(getResources().getString(R.string.common_smart_answer));
        return;
    L62:
        return;
    L38:
        if (r9.isFeatureCallRecordEnabled() == true) goto L40;
    L52:
        LinearLayout r14 = this.intelligentLayout;
        if (r14 == null) goto L64;
        r14.setVisibility(8);
        return;
    L64:
        return;
    L40:
        if (r8 <= 0) goto L52;
        LinearLayout r15 = this.intelligentLayout;
        if (r15 == null) goto L45;
        r15.setVisibility(0);
    L45:
        ImageView r16 = this.intelligentIcon;
        if (r16 == null) goto L48;
        r16.setImageResource(R.drawable.ic_obric_record);
    L48:
        TextView r17 = this.intelligentText;
        if (r17 == null) goto L63;
        r17.setText(getResources().getString(R.string.common_call_recording));
        return;
    }

    static /* synthetic */ void updateCallLogView$default(CallLogItemCardView r7, int r8, CharSequence r9, CharSequence r10, Integer r11, CharSequence r12, boolean r13, int r14, Object r15) {
        if ((r14 & 32) == 0) goto L5;
        r13 = false;
    L5:
        r7.updateCallLogView(r8, r9, r10, r11, r12, r13);
    }

    private final void updateCallLogView(int r7, String r8, CharSequence r9, Integer r10, CharSequence r11, boolean r12) {
        PhoneCallDetails r0 = this.details;
        if (r0 == null) goto L5;
        CharSequence r1 = r0.name;
    L7:
        if (r1 != null) goto L9;
    L12:
        boolean r2 = true;
    L14:
        if (r2 == false) goto L22;
        PhoneCallDetails r13 = this.details;
        if (r13 == null) goto L18;
        CharSequence r14 = r13.numberLabel;
    L19:
        String r15 = (String) r14;
        if (r15 != null) goto L32;
        r15 = "";
    L32:
        if (r7 != 3) goto L34;
        setTitleColor(Integer.valueOf(getContext().getResources().getColor(R.color.oui_red_6)));
    L35:
        if (r10 == null) goto L37;
        r8 = r8 + " (" + r10 + ')';
    L37:
        String r16 = r15;
        if (TextUtils.isEmpty(r16) == true) goto L60;
        Intrinsics.checkNotNull(r15);
        String r17 = new Regex("(?<!中国)(移动|联通|电信)$").replace(r16, "");
        int r18 = r17.length() - 1;
        int r19 = 0;
        boolean r3 = false;
    L40:
        if (r19 > r18) goto L55;
        if (r3 == true) goto L43;
        int r4 = r19;
    L45:
        if (Intrinsics.compare(r17.charAt(r4), 32) > 0) goto L47;
        boolean r5 = true;
    L48:
        if (r3 == false) goto L49;
        if (r5 == false) goto L55;
        r18 = r18 - 1;
        goto L40
    L49:
        if (r5 == false) goto L50;
        r19 = r19 + 1;
        goto L40
    L50:
        r3 = true;
        goto L40
    L47:
        r5 = false;
        goto L48
    L43:
        r4 = r18;
    L55:
        r15 = r17.subSequence(r19, r18 + 1).toString();
        if (r12 == false) goto L60;
        Intrinsics.checkNotNull(r15);
        if (r15.length() <= 8) goto L60;
        StringBuilder r20 = new StringBuilder();
        String r21 = r15.substring(0, 8);
        Intrinsics.checkNotNullExpressionValue(r21, "substring(...)");
        r15 = r20.append(r21).append("...").toString();
    L60:
        ContactDetailDisplayUtils.setCombinedTextWithDivider(getContext(), this.callLabelText, r15, null);
        OTextView r22 = this.callTypeAndDate;
        if (r22 == null) goto L64;
        r22.setText(r11);
    L64:
        OTextView r23 = this.callTypeAndDate;
        if (r23 == null) goto L68;
        r23.setContentDescription(r11);
    L68:
        setTitleText(String.valueOf(r8));
        return;
    L34:
        setTitleColor(Integer.valueOf(getContext().getResources().getColor(R.color.oui_text_1)));
        goto L35
    L18:
        r14 = null;
        goto L19
    L22:
        PhoneCallDetails r6 = this.details;
        if (r6 == null) goto L25;
        CharSequence r24 = r6.name;
    L26:
        if (r9 == null) goto L29;
        r15 = r9.toString();
        if (r15 == null) goto L29;
    L30:
        r8 = r24;
    L29:
        r15 = r8.toString();
        goto L30
    L25:
        r24 = null;
        goto L26
    L9:
        if (r1.length() == 0) goto L12;
        r2 = false;
        goto L14
    L5:
        r1 = null;
        goto L7
    }

    public final void setPhoneCallDetails(PhoneCallDetails r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "pDetails");
        CallTypeIconsView r0 = this.callTypeIcons;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        int r1 = r2.callTypes.length;
        CallTypeIconsView r4 = this.callTypeIcons;
        if (r4 == null) goto L8;
        r4.add(r3);
    L8:
        CallTypeIconsView r5 = this.callTypeIcons;
        if (r5 == null) goto L12;
        r5.setVisibility(0);
    L12:
        String r6 = CallLogTimeRangeUtil.getCallLogListFormatTime(r2.date);
        OTextView r7 = getEndDetail();
        if (r7 == null) goto L17;
        r7.setText(r6);
        return;
    }
}
