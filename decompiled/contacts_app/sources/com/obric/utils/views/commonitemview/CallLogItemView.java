package com.obric.utils.views.commonitemview;

import android.content.Context;
import android.content.res.Resources;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.PhoneCallDetails;
import com.android.contacts.R;
import com.android.contacts.activities.ContactCalllogsActivity;
import com.android.contacts.calllog.CallTypeIconsView;
import com.android.contacts.calllog.PhoneNumberHelper;
import com.android.contacts.detail.ContactDetailDisplayUtils;
import com.android.contacts.util.CallLogTimeRangeUtil;
import com.android.contacts.util.ContactTypeLabelUtils;
import com.android.contacts.util.DateUtils;
import com.obric.callsummary.CallSummaryGenerateManagerKt;
import com.obric.callsummary.bean.CallSummary;
import com.obric.model.CallFeatureModel;
import com.obric.model.bean.CallFeatureBean;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.text.OTextView;
import com.obric.utils.ObriceRecordSummaryUtils;
import com.obric.utils.views.commonitemview.bean.SwipeItemButtonType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CallLogItemView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 {2\u00020\u0001:\u0001{B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u00109\u001a\u00020:2\u0006\u0010;\u001a\u000206J\u0018\u0010<\u001a\u00020:2\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020\u001dJ\b\u0010@\u001a\u00020:H\u0002J\"\u0010A\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010>2\u0006\u0010E\u001a\u00020\u001dH\u0002J\u0006\u0010F\u001a\u00020:J\b\u0010G\u001a\u00020:H\u0002J\b\u0010H\u001a\u00020:H\u0002J\u0018\u0010I\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020\u00142\u0006\u0010K\u001a\u00020\u0016H\u0002J\u001a\u0010L\u001a\u00020:2\u0006\u0010J\u001a\u00020\u00142\b\u0010K\u001a\u0004\u0018\u00010\u0016H\u0002J*\u0010M\u001a\u00020:2\u0006\u0010J\u001a\u00020\u00142\b\u0010K\u001a\u0004\u0018\u00010\u00162\u0006\u0010N\u001a\u00020\u00142\u0006\u0010O\u001a\u00020\u0007H\u0002J\u0010\u0010P\u001a\u00020:2\u0006\u0010O\u001a\u00020\u0007H\u0002J\u000e\u0010Q\u001a\u00020:2\u0006\u0010R\u001a\u00020\u001dJ\u000e\u0010S\u001a\u00020:2\u0006\u0010T\u001a\u00020\u001dJ\u000e\u0010U\u001a\u00020:2\u0006\u0010R\u001a\u00020\u001dJ\u0010\u0010V\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010WJ\u0010\u0010X\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010YJ\u0010\u0010Z\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010YJH\u0010[\u001a\u00020:2\u0006\u0010\\\u001a\u00020]2\u0006\u0010O\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u00142\b\u0010K\u001a\u0004\u0018\u00010\u00162\u0006\u0010N\u001a\u00020\u00142\u0006\u0010^\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010_\u001a\u00020\u001dJ\u0016\u0010`\u001a\u00020:2\u0006\u0010a\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u001dJ,\u0010c\u001a\u00020d2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020g0f2\u0016\b\u0002\u0010h\u001a\u0010\u0012\u0004\u0012\u00020g\u0012\u0004\u0012\u00020:\u0018\u00010iJ\u0018\u0010j\u001a\u00020:2\u0006\u0010k\u001a\u00020\u00072\u0006\u0010l\u001a\u00020\u0007H\u0002J\u0010\u0010m\u001a\u00020:2\b\u0010=\u001a\u0004\u0018\u00010>J(\u0010n\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020\u00142\u0006\u0010K\u001a\u00020\u00162\u0006\u0010o\u001a\u00020\u001d2\u0006\u0010p\u001a\u00020\u001dH\u0002J \u0010q\u001a\u00020\u001d2\u0006\u0010o\u001a\u00020\u001d2\u0006\u0010p\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\u001dH\u0002J\b\u0010r\u001a\u00020:H\u0002J\u000e\u0010s\u001a\u00020:2\u0006\u0010t\u001a\u00020\u001dJ\b\u0010u\u001a\u00020:H\u0002J\u0010\u0010v\u001a\u00020\u00162\u0006\u0010w\u001a\u00020\u001dH\u0002J\"\u0010x\u001a\u00020:2\u0006\u0010J\u001a\u00020\u00142\b\u0010K\u001a\u0004\u0018\u00010\u00162\u0006\u0010N\u001a\u00020\u0014H\u0002J\b\u0010y\u001a\u00020:H\u0002J \u0010z\u001a\u00020:2\u0006\u0010B\u001a\u00020C2\u0006\u0010N\u001a\u00020\u00142\u0006\u0010O\u001a\u00020\u0007H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006|"}, d2 = {"Lcom/obric/utils/views/commonitemview/CallLogItemView;", "Lcom/obric/oui/lisitem/OCardListItem;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "callLabelText", "Lcom/obric/oui/text/OTextView;", "callTypeIcons", "Lcom/android/contacts/calllog/CallTypeIconsView;", "checkBox", "Lcom/obric/utils/views/commonitemview/ContactsOCheckBoxLayout;", "checkboxContainer", "Landroid/widget/LinearLayout;", "commonSubtitleRoot", "Landroid/view/View;", "currentSummaryDate", "", "currentSummaryNumber", "", "endContainer", "endIcon", "Landroid/widget/ImageView;", "endText", "Landroid/widget/TextView;", "hideIntelligentStatusView", "", "intelligentIcon", "intelligentLayout", "intelligentText", "<set-?>", "isInSwipeAction", "()Z", "isShowSingleContactCalls", "itemDivider", "mainContainer", "Lcom/obric/oui/layout/OUIConstraintLayout;", "originSwipeEnabled", "phoneNumberHelper", "Lcom/android/contacts/calllog/PhoneNumberHelper;", "rootContainer", "simIcon", "singleDuration", "singleNumber", "singleSubtitleRoot", "subtitleContainer", "Landroid/widget/FrameLayout;", "summaryCardView", "Lcom/obric/utils/views/commonitemview/CallLogSummaryCardView;", "swipeListenerBound", "swipeStatusListener", "Lcom/obric/utils/views/commonitemview/ContactsCommonListItem$SwipeStatusListener;", "titleContainer", "titleView", "addSwipeListener", "", "listener", "bindEndData", "text", "", "showIcon", "clearCurrentTransientSummaryFailure", "hasSummaryText", "callFeatureBean", "Lcom/obric/model/bean/CallFeatureBean;", "summaryText", "isUnable", "hideSummary", "initCommonSubtitleViews", "initSingleSubtitleViews", "isSummaryWorking", "date", "number", "saveSummaryArgs", "setCallSummaryText", "duration", "callType", "setCallTypeContentDescription", "setChecked", MaterialConfigFormatNames.CHECKED, "setEditMode", "isEditMode", "setItemChecked", "setOnClickListener", "Lcom/obric/utils/views/commonitemview/ContactsCommonListItem$ContactsCommonListItemClickListener;", "setOnEndIconClickListener", "Landroid/view/View$OnClickListener;", "setOnSummaryClickListener", "setPhoneDetail", "detail", "Lcom/android/contacts/PhoneCallDetails;", "interceptType", ContactCalllogsActivity.EXTRA_CONTACT_HAS_MORE_NUMBERS, "setPhoneSimStatus", "simId", "showSimIcon", "setSwipeItemButtonView", "Lcom/obric/utils/views/commonitemview/SwipeItemView;", "swipeBtnList", "", "Lcom/obric/utils/views/commonitemview/bean/SwipeItemButtonType;", "swipeListener", "Lkotlin/Function1;", "setTitleColors", "titleColor", "subTitleColor", "setTitleText", "shouldShowTempFailure", "summaryEnabled", "isWorking", "shouldShowUnableFailure", "showCommonSubtitle", "showItemDivider", "show", "showSingleSubtitle", "summaryFailureText", "hasTempFailure", "updateIntelligentLayout", "updateItemDividerOffset", "updateSummaryTitleColor", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallLogItemView extends OCardListItem {
    private static final Regex CARRIER_SUFFIX_REGEX = null;
    private static final Companion Companion = null;
    private OTextView callLabelText;
    private CallTypeIconsView callTypeIcons;
    private final ContactsOCheckBoxLayout checkBox;
    private final LinearLayout checkboxContainer;
    private View commonSubtitleRoot;
    private long currentSummaryDate;
    private String currentSummaryNumber;
    private final LinearLayout endContainer;
    private final ImageView endIcon;
    private final TextView endText;
    private boolean hideIntelligentStatusView;
    private ImageView intelligentIcon;
    private View intelligentLayout;
    private TextView intelligentText;
    private boolean isInSwipeAction;
    private boolean isShowSingleContactCalls;
    private final View itemDivider;
    private final OUIConstraintLayout mainContainer;
    private boolean originSwipeEnabled;
    private PhoneNumberHelper phoneNumberHelper;
    private final OUIConstraintLayout rootContainer;
    private ImageView simIcon;
    private TextView singleDuration;
    private TextView singleNumber;
    private View singleSubtitleRoot;
    private final FrameLayout subtitleContainer;
    private final CallLogSummaryCardView summaryCardView;
    private boolean swipeListenerBound;
    private ContactsCommonListItem.SwipeStatusListener swipeStatusListener;
    private final LinearLayout titleContainer;
    private final OTextView titleView;

    /* JADX INFO: compiled from: CallLogItemView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/utils/views/commonitemview/CallLogItemView$Companion;", "", "()V", "CARRIER_SUFFIX_REGEX", "Lkotlin/text/Regex;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ boolean $r8$lambda$B2bWjYw0SfZzGdK5h6eUPVH10Kc(CallLogItemView r0, ContactsCommonListItem.ContactsCommonListItemClickListener r1, OSwipeLayout r2, View r3) {
        return setOnClickListener$lambda$8(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$gqjrazxpwxfsW6zcfS4irAT_u6A(CallLogItemView r0, View.OnClickListener r1, View r2) {
        setOnSummaryClickListener$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$iMCIK7C5_iRJSV5sj6UhzGSO25w(CallLogItemView r0, View.OnClickListener r1, View r2) {
        setOnEndIconClickListener$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$msTdVDLbOmm3hPHCB32dUxfavkY(CallLogItemView r0, ContactsCommonListItem.ContactsCommonListItemClickListener r1, View r2) {
        setOnClickListener$lambda$6(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$rrMHjUDOrQfRk46u5bSnsVEFgc8(CallLogItemView r0, OSwipeLayout r1, ContactsCommonListItem.ContactsCommonListItemClickListener r2, View r3, MotionEvent r4) {
        return setOnClickListener$lambda$7(r0, r1, r2, r3, r4);
    }

    public CallLogItemView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public CallLogItemView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    private final boolean shouldShowUnableFailure(boolean r1, boolean r2, boolean r3) {
        if (r1 == false) goto L6;
        if (r2 == true) goto L6;
        if (r3 == false) goto L6;
        return true;
    L6:
        return false;
    }

    public /* synthetic */ CallLogItemView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ void access$clearCurrentTransientSummaryFailure(CallLogItemView r0) {
        r0.clearCurrentTransientSummaryFailure();
    }

    public static final /* synthetic */ ContactsCommonListItem.SwipeStatusListener access$getSwipeStatusListener$p(CallLogItemView r0) {
        return r0.swipeStatusListener;
    }

    public static final /* synthetic */ void access$setInSwipeAction$p(CallLogItemView r0, boolean r1) {
        r0.isInSwipeAction = r1;
    }

    public CallLogItemView(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r8);
        this.currentSummaryDate = -1;
        this.originSwipeEnabled = true;
        setCustomStartView(R.layout.calllog_item_root_container);
        setCardType(2);
        showIcon(false);
        showTitle(false);
        showSubTitle(false);
        showCustomEnd(false);
        showTailIcon(false);
        setShowCardBg(false);
        showDivider(false);
        View r9 = findViewById(R.id.call_log_item_root_container);
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.call_log_item_root_container)");
        OUIConstraintLayout r10 = (OUIConstraintLayout) r9;
        this.rootContainer = r10;
        View r0 = findViewById(R.id.main_container);
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.main_container)");
        OUIConstraintLayout r1 = (OUIConstraintLayout) r0;
        this.mainContainer = r1;
        View r2 = findViewById(R.id.icon_container);
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.icon_container)");
        this.checkboxContainer = (LinearLayout) r2;
        View r3 = findViewById(R.id.edit_check_box);
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.edit_check_box)");
        ContactsOCheckBoxLayout r4 = (ContactsOCheckBoxLayout) r3;
        this.checkBox = r4;
        View r5 = findViewById(R.id.title_container);
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.title_container)");
        this.titleContainer = (LinearLayout) r5;
        View r11 = findViewById(R.id.call_log_title);
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.call_log_title)");
        this.titleView = (OTextView) r11;
        View r12 = findViewById(R.id.subtitle_container);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.subtitle_container)");
        this.subtitleContainer = (FrameLayout) r12;
        View r13 = findViewById(R.id.end_container);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.end_container)");
        this.endContainer = (LinearLayout) r13;
        View r14 = findViewById(R.id.end_text);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.end_text)");
        this.endText = (TextView) r14;
        View r15 = findViewById(R.id.end_icon);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.end_icon)");
        this.endIcon = (ImageView) r15;
        View r16 = findViewById(R.id.call_log_summary_card_view);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.call_log_summary_card_view)");
        CallLogSummaryCardView r17 = (CallLogSummaryCardView) r16;
        this.summaryCardView = r17;
        View r18 = findViewById(R.id.item_divider);
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.item_divider)");
        this.itemDivider = r18;
        r4.setClickable(false);
        r4.setFocusable(false);
        r4.getCheckBox().setClickable(false);
        r4.getCheckBox().setFocusable(false);
        r4.getCheckBox().setVisibility(0);
        r4.setVisibility(8);
        r10.setChangeAlphaWhenPress(false);
        r1.setChangeAlphaWhenPress(false);
        r17.setOnConsumeTempFailure(new AnonymousClass1(this));
        showItemDivider(true);
        updateItemDividerOffset();
    }

    static {
        Companion = new Companion(null);
        CARRIER_SUFFIX_REGEX = new Regex("(?<!中国)(移动|联通|电信)$");
    }

    public final boolean isInSwipeAction() {
        return this.isInSwipeAction;
    }

    public final void setEditMode(boolean r5) {
        LinearLayout r0 = this.checkboxContainer;
        int r1 = 8;
        if (r5 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        ContactsOCheckBoxLayout r2 = this.checkBox;
        if (r5 == false) goto L9;
        int r4 = 0;
    L10:
        r2.setVisibility(r4);
        ImageView r6 = this.endIcon;
        if ((!r5) == false) goto L13;
        r1 = 0;
    L13:
        r6.setVisibility(r1);
        updateItemDividerOffset();
        if (r5 == true) goto L17;
        setChecked(false);
        return;
    L17:
        return;
    L9:
        r4 = 8;
        goto L10
    L5:
        r3 = 8;
        goto L6
    }

    public final void setChecked(boolean r1) {
        this.checkBox.setChecked(r1);
    }

    public final void setItemChecked(boolean r1) {
        setChecked(r1);
    }

    public final void showItemDivider(boolean r3) {
        View r0 = this.itemDivider;
        if (r3 == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        if (r3 == false) goto L10;
        updateItemDividerOffset();
        return;
    L10:
        return;
    L5:
        r1 = 8;
        goto L6
    }

    private final void updateItemDividerOffset() {
        View r0 = this.itemDivider;
        if (this.checkBox.getVisibility() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        float r4 = MathKt.roundToInt(TypedValue.applyDimension(1, 32, Resources.getSystem().getDisplayMetrics()));
    L9:
        r0.setTranslationX(r4);
        return;
    L8:
        r4 = 0.0f;
        goto L9
    L5:
        r3 = false;
        goto L6
    }

    public final void setTitleText(CharSequence r1) {
        OTextView r0 = this.titleView;
        if (r1 != null) goto L5;
    L5:
        r0.setText(r1);
    }

    public final void bindEndData(CharSequence r5, boolean r6) {
        if (r5 == null) goto L4;
        String r7 = r5.toString();
    L5:
        if (r7 != null) goto L7;
        r7 = "";
    L7:
        TextView r0 = this.endText;
        String r8 = r7;
        int r2 = 0;
        if (r8.length() <= 0) goto L10;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        int r3 = 0;
    L15:
        r0.setVisibility(r3);
        this.endText.setText(r8);
        this.endText.setContentDescription(r8);
        ImageView r4 = this.endIcon;
        if (r6 == true) goto L19;
        r2 = 8;
    L19:
        r4.setVisibility(r2);
        return;
    L14:
        r3 = 8;
        goto L15
    L10:
        r1 = false;
        goto L12
    L4:
        r7 = null;
        goto L5
    }

    public final void hideSummary() {
        this.summaryCardView.hideCard();
    }

    private final void clearCurrentTransientSummaryFailure() {
        if (this.currentSummaryDate < 0) goto L15;
        String r0 = this.currentSummaryNumber;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L16;
        CallFeatureModel.INSTANCE.clearTransientSummaryFailure(this.currentSummaryDate, this.currentSummaryNumber);
        return;
    L16:
        return;
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
        goto L11
    }

    private final void saveSummaryArgs(long r1, String r3) {
        this.currentSummaryDate = r1;
        this.currentSummaryNumber = r3;
    }

    private final void updateSummaryTitleColor(CallFeatureBean r3, long r4, int r6) {
        if (r3.isIntelligentCallEnabled() == true) goto L5;
        return;
    L5:
        if (r4 > 0) goto L8;
        return;
    L8:
        if (r3.isOnlyUseIntelligentCall() == false) goto L10;
    L13:
        int r5 = ContextCompat.getColor(getContext(), R.color.oui_red_6);
    L14:
        setTitleColors(r5, ContextCompat.getColor(getContext(), R.color.oui_basic_text_3));
        return;
    L10:
        if (r6 == 3) goto L13;
        r5 = ContextCompat.getColor(getContext(), R.color.oui_text_1);
        goto L14
    }

    private final boolean isSummaryWorking(long r2, String r4) {
        return CallFeatureModel.INSTANCE.getSummarizingDataSet().contains(new Pair(Long.valueOf(r2), r4));
    }

    private final boolean hasSummaryText(CallFeatureBean r1, CharSequence r2, boolean r3) {
        if (r1.isSummaryEmpty() == false) goto L5;
    L8:
        return false;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L8;
        if (r3 == true) goto L8;
        return true;
    }

    private final boolean shouldShowTempFailure(long r1, String r3, boolean r4, boolean r5) {
        if (r4 == false) goto L9;
        if (r5 == true) goto L9;
        if (CallFeatureModel.INSTANCE.hasTransientSummaryFailure(r1, r3) == false) goto L9;
        if (this.summaryCardView.canKeepTempFailure(r1, r3) == false) goto L9;
        return true;
    L9:
        return false;
    }

    private final String summaryFailureText(boolean r1) {
        if (r1 == false) goto L4;
        String r0 = getContext().getString(R.string.summary_generation_failed);
        Intrinsics.checkNotNullExpressionValue(r0, "{\n            context.ge…eration_failed)\n        }");
        return r0;
    L4:
        String r2 = getContext().getString(R.string.unable_to_summarize);
        Intrinsics.checkNotNullExpressionValue(r2, "{\n            context.ge…e_to_summarize)\n        }");
        return r2;
    }

    public final void setOnEndIconClickListener(final View.OnClickListener r3) {
        if (r3 != null) goto L5;
        this.endIcon.setOnClickListener(null);
        return;
    L5:
        this.endIcon.setOnClickListener(new CallLogItemView$$ExternalSyntheticLambda0(this, r3));
    }

    private static final void setOnEndIconClickListener$lambda$0(CallLogItemView r1, View.OnClickListener r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r1.isInSwipeAction == false) goto L5;
        return;
    L5:
        if (r1.endIcon.getVisibility() != 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L12;
        r2.onClick(r3);
        return;
    L12:
        return;
    L7:
        r4 = false;
        goto L8
    }

    public final void setOnSummaryClickListener(final View.OnClickListener r2) {
        if (r2 != null) goto L5;
        this.summaryCardView.setOnCardClickListener(null);
        return;
    L5:
        View.OnClickListener r0 = new CallLogItemView$$ExternalSyntheticLambda4(this, r2);
        this.summaryCardView.setOnCardClickListener(r0);
    }

    private static final void setOnSummaryClickListener$lambda$1(CallLogItemView r1, View.OnClickListener r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r1.isInSwipeAction == false) goto L5;
        return;
    L5:
        if (r1.summaryCardView.isCardVisible() == false) goto L9;
        r2.onClick(r3);
        return;
    }

    public final void setPhoneSimStatus(int r3, boolean r4) {
        if (this.isShowSingleContactCalls == false) goto L5;
        initSingleSubtitleViews();
    L7:
        if (DSUtils.useDSFeature() == true) goto L14;
        if (r4 == true) goto L14;
        ImageView r2 = this.simIcon;
        if (r2 == null) goto L31;
        r2.setVisibility(8);
        return;
    L31:
        return;
    L14:
        int r5 = DSUtils.getSimIconResource(r3);
        if (r5 <= 0) goto L23;
        ImageView r6 = this.simIcon;
        if (r6 == null) goto L20;
        r6.setVisibility(0);
    L20:
        ImageView r7 = this.simIcon;
        if (r7 == null) goto L29;
        r7.setImageResource(r5);
        return;
    L29:
        return;
    L23:
        ImageView r8 = this.simIcon;
        if (r8 == null) goto L32;
        r8.setVisibility(8);
        return;
    L32:
        return;
    L5:
        initCommonSubtitleViews();
        goto L7
    }

    private final void initCommonSubtitleViews() {
        if (this.commonSubtitleRoot != null) goto L17;
        View r0 = LayoutInflater.from(getContext()).inflate(R.layout.calllog_item_sub_view, this.subtitleContainer, false);
        this.commonSubtitleRoot = r0;
        CallTypeIconsView r1 = null;
        if (r0 == null) goto L7;
        ImageView r2 = (ImageView) r0.findViewById(R.id.calllog_item_sub_view_call_type_sim);
    L8:
        this.simIcon = r2;
        View r3 = this.commonSubtitleRoot;
        if (r3 == null) goto L11;
        OTextView r4 = (OTextView) r3.findViewById(R.id.calllog_item_sub_view_call_label);
    L12:
        this.callLabelText = r4;
        View r5 = this.commonSubtitleRoot;
        if (r5 == null) goto L15;
        r1 = (CallTypeIconsView) r5.findViewById(R.id.calllog_item_sub_view_call_type_icon);
    L15:
        this.callTypeIcons = r1;
        return;
    L11:
        r4 = null;
        goto L12
    L7:
        r2 = null;
        goto L8
    }

    private final void initSingleSubtitleViews() {
        if (this.singleSubtitleRoot != null) goto L33;
        View r0 = LayoutInflater.from(getContext()).inflate(R.layout.calllog_item_sub_single_view, this.subtitleContainer, false);
        this.singleSubtitleRoot = r0;
        TextView r1 = null;
        if (r0 == null) goto L7;
        ImageView r2 = (ImageView) r0.findViewById(R.id.calllog_item_sub_view_call_type_sim);
    L8:
        this.simIcon = r2;
        View r3 = this.singleSubtitleRoot;
        if (r3 == null) goto L11;
        CallTypeIconsView r4 = (CallTypeIconsView) r3.findViewById(R.id.calllog_item_sub_view_call_type_icon);
    L12:
        this.callTypeIcons = r4;
        View r5 = this.singleSubtitleRoot;
        if (r5 == null) goto L15;
        TextView r6 = (TextView) r5.findViewById(R.id.calllog_sub_sing_number);
    L16:
        this.singleNumber = r6;
        View r7 = this.singleSubtitleRoot;
        if (r7 == null) goto L19;
        TextView r8 = (TextView) r7.findViewById(R.id.calllog_duration);
    L20:
        this.singleDuration = r8;
        View r9 = this.singleSubtitleRoot;
        if (r9 == null) goto L23;
        View r10 = r9.findViewById(R.id.intelligent_layout);
    L24:
        this.intelligentLayout = r10;
        View r11 = this.singleSubtitleRoot;
        if (r11 == null) goto L27;
        ImageView r12 = (ImageView) r11.findViewById(R.id.intelligent_icon);
    L28:
        this.intelligentIcon = r12;
        View r13 = this.singleSubtitleRoot;
        if (r13 == null) goto L31;
        r1 = (TextView) r13.findViewById(R.id.intelligent_text);
    L31:
        this.intelligentText = r1;
        return;
    L27:
        r12 = null;
        goto L28
    L23:
        r10 = null;
        goto L24
    L19:
        r8 = null;
        goto L20
    L15:
        r6 = null;
        goto L16
    L11:
        r4 = null;
        goto L12
    L7:
        r2 = null;
        goto L8
    }

    private final void showCommonSubtitle() {
        initCommonSubtitleViews();
        View r0 = this.commonSubtitleRoot;
        if (r0 == null) goto L5;
        ViewParent r1 = r0.getParent();
    L7:
        if (Intrinsics.areEqual(r1, this.subtitleContainer) == true) goto L11;
        this.subtitleContainer.removeAllViews();
        View r2 = this.commonSubtitleRoot;
        if (r2 == null) goto L11;
        this.subtitleContainer.addView(r2);
    L11:
        this.subtitleContainer.setVisibility(0);
        return;
    L5:
        r1 = null;
        goto L7
    }

    private final void showSingleSubtitle() {
        initSingleSubtitleViews();
        View r0 = this.singleSubtitleRoot;
        if (r0 == null) goto L5;
        ViewParent r1 = r0.getParent();
    L7:
        if (Intrinsics.areEqual(r1, this.subtitleContainer) == true) goto L11;
        this.subtitleContainer.removeAllViews();
        View r2 = this.singleSubtitleRoot;
        if (r2 == null) goto L11;
        this.subtitleContainer.addView(r2);
    L11:
        this.subtitleContainer.setVisibility(0);
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void setPhoneDetail(PhoneCallDetails r17, int r18, long r19, String r21, long r22, int r24, boolean r25, boolean r26) {
        Intrinsics.checkNotNullParameter(r17, "detail");
        int r2 = ContextCompat.getColor(getContext(), R.color.oui_text_1);
        int r3 = ContextCompat.getColor(getContext(), R.color.oui_red_6);
        int r8 = ContextCompat.getColor(getContext(), R.color.oui_basic_text_3);
        if (r18 != 3) goto L5;
        r2 = r3;
    L5:
        setTitleColors(r2, r8);
        this.isShowSingleContactCalls = r25;
        if (this.phoneNumberHelper != null) goto L8;
        this.phoneNumberHelper = new PhoneNumberHelper(getContext().getResources());
    L8:
        CharSequence r4 = r17.formattedNumber;
        int r5 = 0;
        if (r4 != null) goto L11;
    L14:
        boolean r6 = true;
    L15:
        String r10 = "";
        if (r6 == true) goto L18;
        String r7 = r17.formattedNumber.toString();
    L28:
        PhoneNumberHelper r11 = this.phoneNumberHelper;
        if (r11 == null) goto L33;
        CharSequence r12 = r11.getDisplayNumber(r17.number, r17.formattedNumber, r17.presentation, true);
        if (r12 == null) goto L33;
        String r13 = r12.toString();
    L34:
        String r14 = r13;
        if (r14 != null) goto L37;
    L40:
        boolean r15 = true;
    L41:
        if (r15 == false) goto L44;
        r13 = null;
    L44:
        if (r13 == null) goto L48;
        r7 = r13;
    L48:
        if (TextUtils.isEmpty(r17.number) == false) goto L50;
    L52:
        CharSequence r16 = null;
    L54:
        if (r25 == false) goto L107;
        showSingleSubtitle();
        this.endIcon.setImageResource(R.drawable.ic_call_summary_arrow);
        CallTypeIconsView r1 = this.callTypeIcons;
        if (r1 == null) goto L58;
        r1.clear();
    L58:
        CallTypeIconsView r9 = this.callTypeIcons;
        if (r9 == null) goto L61;
        r9.add(r18);
    L61:
        CallTypeIconsView r20 = this.callTypeIcons;
        if (r20 == null) goto L65;
        r20.setVisibility(0);
    L65:
        setCallTypeContentDescription(r18);
        setTitleText(CallLogTimeRangeUtil.getCallDetailFormatTime(r17.date));
        TextView r110 = this.singleNumber;
        if (r110 == null) goto L81;
        TextView r111 = r110;
        if (r26 == true) goto L71;
    L76:
        boolean r112 = false;
    L77:
        if (r112 == false) goto L79;
        int r113 = 0;
    L80:
        r111.setVisibility(r113);
        goto L81
    L79:
        r113 = 8;
        goto L80
    L71:
        if (r7.length() <= 0) goto L73;
        boolean r114 = true;
    L74:
        if (r114 == false) goto L76;
        r112 = true;
        goto L77
    L73:
        r114 = false;
    L81:
        TextView r115 = this.singleNumber;
        if (r115 == null) goto L85;
        r115.setText(r7);
    L85:
        if (r18 != 3) goto L88;
        r10 = getContext().getString(R.string.type_missed);
    L96:
        int[] r0 = r17.callTypes;
        if (r0 == null) goto L99;
        r5 = r0.length;
    L99:
        if (r5 <= 1) goto L101;
        r10 = r10 + " (" + r5 + ')';
    L101:
        TextView r23 = this.singleDuration;
        if (r23 == null) goto L105;
        r23.setText(r10);
    L105:
        updateIntelligentLayout(r19, r21, r22);
        bindEndData(null, true);
        hideSummary();
        return;
    L88:
        if (r22 > 0) goto L90;
        if (r24 <= 0) goto L95;
        r10 = getContext().getString(R.string.type_blocked);
        goto L96
    L95:
        r10 = getContext().getString(R.string.cancelled);
        goto L96
    L90:
        if (ContactsUtils.FEATURE_CMCC == true) goto L96;
        r10 = DateUtils.formatDuration(r22, getContext());
        goto L96
    L107:
        showCommonSubtitle();
        this.endIcon.setImageResource(R.drawable.icon_item_arrow);
        if (TextUtils.isEmpty(r17.name) == false) goto L110;
        String r27 = r7;
    L111:
        int[] r116 = r17.callTypes;
        if (r116 == null) goto L114;
        int r117 = r116.length;
    L115:
        if (r117 <= 1) goto L117;
        r27 = r27 + " (" + r117 + ')';
    L117:
        setTitleText(r27);
        CharSequence r28 = r17.name;
        if (r28 != null) goto L120;
    L123:
        boolean r29 = true;
    L124:
        if (r29 == false) goto L131;
        CharSequence r30 = r17.numberLabel;
        if (r30 == null) goto L128;
        String r31 = r30.toString();
    L129:
        if (r31 != null) goto L143;
        r31 = "";
    L143:
        String r32 = r31;
        if (r32.length() <= 0) goto L146;
        boolean r33 = true;
    L147:
        if (r33 == false) goto L149;
        r31 = StringsKt.trim(CARRIER_SUFFIX_REGEX.replace(r32, "")).toString();
    L149:
        ContactDetailDisplayUtils.setCombinedTextWithDivider(getContext(), this.callLabelText, r31, null);
        CallTypeIconsView r34 = this.callTypeIcons;
        if (r34 == null) goto L152;
        r34.clear();
    L152:
        CallTypeIconsView r35 = this.callTypeIcons;
        if (r35 == null) goto L155;
        r35.add(r18);
    L155:
        CallTypeIconsView r36 = this.callTypeIcons;
        if (r36 == null) goto L159;
        r36.setVisibility(0);
    L159:
        setCallTypeContentDescription(r18);
        Context r37 = getContext();
        Intrinsics.checkNotNullExpressionValue(r37, "context");
        bindEndData(CallLogTimeRangeUtil.getCallLogListFormatTime(r19, r37), true);
        setCallSummaryText(r19, r21, r22, r18);
        return;
    L146:
        r33 = false;
        goto L147
    L128:
        r31 = null;
        goto L129
    L131:
        if (r16 == null) goto L134;
        r31 = r16.toString();
        if (r31 != null) goto L143;
    L134:
        String r38 = r7;
        if (r38.length() != 0) goto L137;
        boolean r39 = true;
    L138:
        if (r39 == false) goto L142;
        if (r21 != null) goto L141;
        r38 = "";
        goto L142
    L141:
        r38 = r21;
    L142:
        r31 = r38;
        goto L143
    L137:
        r39 = false;
        goto L138
    L120:
        if (r28.length() == 0) goto L123;
        r29 = false;
        goto L124
    L114:
        r117 = 0;
        goto L115
    L110:
        r27 = r17.name.toString();
        goto L111
    L50:
        if (PhoneNumberUtils.isUriNumber(r17.number.toString()) == true) goto L52;
        r16 = ContactTypeLabelUtils.getPhoneTypeLabel(getContext(), Integer.valueOf(r17.numberType), r17.numberLabel);
        goto L54
    L37:
        if (r14.length() == 0) goto L40;
        r15 = false;
    L33:
        r13 = null;
        goto L34
    L18:
        CharSequence r40 = r17.number;
        if (r40 != null) goto L21;
    L24:
        boolean r41 = true;
    L25:
        if (r41 == true) goto L27;
        r7 = r17.number.toString();
        goto L28
    L27:
        r7 = "";
        goto L28
    L21:
        if (r40.length() == 0) goto L24;
        r41 = false;
        goto L25
    L11:
        if (r4.length() == 0) goto L14;
        r6 = false;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SwipeItemView setSwipeItemButtonView$default(CallLogItemView r0, List r1, Function1 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.setSwipeItemButtonView(r1, r2);
    }

    public final SwipeItemView setSwipeItemButtonView(List<? extends SwipeItemButtonType> r5, Function1<? super SwipeItemButtonType, Unit> r6) {
        Intrinsics.checkNotNullParameter(r5, "swipeBtnList");
        View r0 = getSwipeView();
        if ((r0 instanceof SwipeItemView) == false) goto L5;
        SwipeItemView r1 = (SwipeItemView) r0;
    L6:
        if (r1 != null) goto L8;
        Context r2 = getContext();
        Intrinsics.checkNotNullExpressionValue(r2, "context");
        r1 = new SwipeItemView(r2);
        setSwipeView(r1);
    L8:
        OSwipeLayout r3 = getSwipeLayout();
        r3.setClickToClose(true);
        if (this.swipeListenerBound == true) goto L11;
        r3.addSwipeListener(new C04451(this));
        this.swipeListenerBound = true;
    L11:
        r1.setSwipeItemButtonView(r5, r6);
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final void addSwipeListener(ContactsCommonListItem.SwipeStatusListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.swipeStatusListener = r2;
    }

    public final void setOnClickListener(final ContactsCommonListItem.ContactsCommonListItemClickListener r4) {
        final OSwipeLayout r0 = getSwipeLayout();
        this.mainContainer.setOnClickListener(new CallLogItemView$$ExternalSyntheticLambda1(this, r4));
        this.mainContainer.setOnTouchListener(new CallLogItemView$$ExternalSyntheticLambda2(this, r0, r4));
        this.mainContainer.setOnLongClickListener(new CallLogItemView$$ExternalSyntheticLambda3(this, r4, r0));
    }

    private static final void setOnClickListener$lambda$6(CallLogItemView r1, ContactsCommonListItem.ContactsCommonListItemClickListener r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r1.isInSwipeAction == true) goto L7;
        if (r2 == null) goto L8;
        Intrinsics.checkNotNullExpressionValue(r3, "view");
        r2.onClick(r3);
        return;
    L8:
        return;
    }

    private static final boolean setOnClickListener$lambda$7(CallLogItemView r5, OSwipeLayout r6, ContactsCommonListItem.ContactsCommonListItemClickListener r7, View r8, MotionEvent r9) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r6, "$swipeLayout");
        if (r5.isInSwipeAction == false) goto L6;
        return true;
    L6:
        if (r9.getAction() != 0) goto L9;
        int r0 = r9.getActionIndex();
        r8.setTag(R.id.item_touch_position, new int[]{(int) r9.getX(r0), (int) r9.getY(r0)});
        r5.originSwipeEnabled = r6.isSwipeEnabled();
    L9:
        if (r9.getAction() != 1) goto L11;
    L12:
        r6.setSwipeEnabled(r5.originSwipeEnabled);
    L13:
        if (r7 == null) goto L16;
        Intrinsics.checkNotNullExpressionValue(r8, "view");
        Intrinsics.checkNotNullExpressionValue(r9, "event");
        return r7.onTouch(r8, r9);
    L16:
        return false;
    L11:
        if (r9.getAction() != 3) goto L13;
        goto L12
    }

    private static final boolean setOnClickListener$lambda$8(CallLogItemView r4, ContactsCommonListItem.ContactsCommonListItemClickListener r5, OSwipeLayout r6, View r7) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        Intrinsics.checkNotNullParameter(r6, "$swipeLayout");
        boolean r0 = true;
        if (r4.isInSwipeAction == false) goto L5;
        return true;
    L5:
        Object r8 = r7.getTag(R.id.item_touch_position);
        if ((r8 instanceof int[]) == false) goto L8;
        int[] r9 = (int[]) r8;
    L10:
        if (r9 == null) goto L14;
        Integer r2 = ArraysKt.getOrNull(r9, 0);
        if (r2 == null) goto L14;
        int r3 = r2.intValue();
    L15:
        if (r9 == null) goto L19;
        Integer r10 = ArraysKt.getOrNull(r9, 1);
        if (r10 == null) goto L19;
        int r11 = r10.intValue();
    L20:
        int r12 = r11 - ((int) r7.getY());
        if (r5 == null) goto L25;
        Intrinsics.checkNotNullExpressionValue(r7, "view");
        if (r5.onLongClick(r7, r3, r12) != true) goto L25;
    L26:
        r6.setSwipeEnabled(!r0);
        return r0;
    L25:
        r0 = false;
    L19:
        r11 = 0;
    L14:
        r3 = 0;
        goto L15
    L8:
        r9 = null;
        goto L10
    }

    private final void setCallSummaryText(long r19, String r21, long r22, int r24) {
        saveSummaryArgs(r19, r21);
        if (r21 != null) goto L5;
    L10:
        String r12 = null;
    L11:
        if (r12 == null) goto L13;
        CallFeatureBean r13 = CallFeatureModel.INSTANCE.getCallFeature(r19, r12);
    L15:
        if (this.hideIntelligentStatusView == true) goto L46;
        String r0 = r12;
        if (r0 != null) goto L19;
    L22:
        boolean r1 = true;
    L23:
        if (r1 == true) goto L46;
        if (r13 == null) goto L46;
        if (r13.isRecordASRAvailable() == false) goto L46;
        updateSummaryTitleColor(r13, r22, r24);
        String r14 = ObriceRecordSummaryUtils.getCallLogSummaryText(Long.valueOf(r19), r12);
        boolean r15 = isSummaryWorking(r19, r12);
        boolean r5 = r13.isFeatureCallSummaryEnabled();
        CallSummary r2 = r13.getSummary();
        Context r3 = getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        boolean r4 = r2.isUnableToSummarize(r3);
        String r6 = r14;
        boolean r7 = hasSummaryText(r13, r6, r4);
        boolean r8 = shouldShowTempFailure(r19, r12, r5, r15);
        boolean r9 = shouldShowUnableFailure(r5, r15, r4);
        if (r8 == true) goto L33;
        if (r9 == true) goto L33;
        boolean r10 = false;
    L34:
        if (r10 == false) goto L36;
        String r11 = summaryFailureText(r8);
    L37:
        String r16 = getContext().getString(R.string.summary_call_log_generation);
        Intrinsics.checkNotNullExpressionValue(r16, "context.getString(R.stri…mary_call_log_generation)");
        if (ContactsUtils.DEBUG == false) goto L44;
        StringBuilder r17 = new StringBuilder("item bind date=").append(r19).append(" enabled=").append(r5).append(" working=").append(r15).append(" hasSummary=").append(r7).append(" tempFail=").append(r8).append(" unableFail=").append(r9).append(" summaryError=").append(r13.getSummary().getErrorCode()).append(" textEmpty=");
        if (r6.length() != 0) goto L42;
        boolean r18 = true;
    L43:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, r17.append(r18).append(" textLen=").append(r14.length()).toString());
        goto L44
    L42:
        r18 = false;
    L44:
        String r20 = r12;
        this.summaryCardView.bind(new CallLogSummaryCardView.BindData(r19, r20, r6, r16, r11, r5, r15, r7, r10, r8));
        return;
    L36:
        r11 = null;
    L33:
        r10 = true;
        goto L34
    L19:
        if (r0.length() == 0) goto L22;
        r1 = false;
    L46:
        hideSummary();
        return;
    L13:
        r13 = null;
        goto L15
    L5:
        if (r21.length() != 0) goto L7;
        boolean r23 = true;
    L8:
        if (r23 == true) goto L10;
        r12 = r21;
        goto L11
    L7:
        r23 = false;
        goto L8
    }

    private final void setTitleColors(int r2, int r3) {
        this.titleView.setTextColor(r2);
        OTextView r4 = this.callLabelText;
        if (r4 == null) goto L5;
        r4.setTextColor(r3);
    L5:
        TextView r5 = this.singleNumber;
        if (r5 == null) goto L8;
        r5.setTextColor(r3);
    L8:
        TextView r1 = this.singleDuration;
        if (r1 == null) goto L12;
        r1.setTextColor(r3);
        return;
    }

    private final void updateIntelligentLayout(long r5, String r7, long r8) {
        if (this.hideIntelligentStatusView == false) goto L9;
        View r4 = this.intelligentLayout;
        if (r4 == null) goto L57;
        r4.setVisibility(8);
        return;
    L57:
        return;
    L9:
        if (r7 != null) goto L15;
        View r6 = this.intelligentLayout;
        if (r6 == null) goto L58;
        r6.setVisibility(8);
        return;
    L58:
        return;
    L15:
        CallFeatureBean r9 = CallFeatureModel.INSTANCE.getCallFeature(r5, r7);
        if (r9 != null) goto L23;
        View r10 = this.intelligentLayout;
        if (r10 == null) goto L59;
        r10.setVisibility(8);
        return;
    L59:
        return;
    L23:
        if (r9.isIntelligentCallEnabled() == false) goto L38;
        if (r8 <= 0) goto L38;
        View r11 = this.intelligentLayout;
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
        View r14 = this.intelligentLayout;
        if (r14 == null) goto L64;
        r14.setVisibility(8);
        return;
    L64:
        return;
    L40:
        if (r8 <= 0) goto L52;
        View r15 = this.intelligentLayout;
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

    private final void setCallTypeContentDescription(int r3) {
        CallTypeIconsView r0 = this.callTypeIcons;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r3 != 1) goto L8;
        String r2 = getContext().getString(R.string.type_incoming);
    L18:
        r0.setContentDescription(r2);
        return;
    L8:
        if (r3 != 2) goto L10;
        r2 = getContext().getString(R.string.type_outgoing);
        goto L18
    L10:
        if (r3 != 3) goto L12;
        r2 = getContext().getString(R.string.type_missed);
        goto L18
    L12:
        if (r3 == 7) goto L14;
        r2 = null;
        goto L18
    L14:
        r2 = getContext().getString(R.string.type_answered_elsewhere);
        goto L18
    }
}
