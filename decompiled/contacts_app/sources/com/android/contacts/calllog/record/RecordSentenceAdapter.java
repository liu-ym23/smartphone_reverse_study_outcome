package com.android.contacts.calllog.record;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.android.contacts.widget.CopyAllView;
import com.obric.callsummary.bean.CallAssignment;
import com.obric.callsummary.bean.CallAssignmentData;
import com.obric.callsummary.bean.CallSummary;
import com.obric.callsummary.model.aikernel.AISummary;
import com.obric.database.entity.RecordASRMessageEntity;
import com.obric.incallui.InCallUIAppHelper;
import com.obric.model.CallFeatureModel;
import com.obric.model.bean.CallFeatureBean;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButton;
import com.obric.oui.dialog.alert.OAlertDialog;
import com.obric.oui.dialog.alert.OAlertDialogBuilder;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.text.OTextView;
import com.obric.utils.ContactNames;
import com.obric.utils.ObriceRecordSummaryUtils;
import com.obric.voice.ASRController;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: RecordSentenceAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 q2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0006qrstuvBK\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0002\u0010\u0013J\"\u0010F\u001a\u0002082\f\u0010G\u001a\b\u0012\u0004\u0012\u000208072\f\u0010H\u001a\b\u0012\u0004\u0012\u00020807J\u0010\u0010I\u001a\u0002082\u0006\u0010J\u001a\u00020\u001aH\u0002J\u0006\u0010K\u001a\u00020\u000fJ\b\u0010L\u001a\u00020\u000fH\u0016J\u0010\u0010M\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020\u000fH\u0016J\u0006\u0010O\u001a\u00020\u000fJ\u0006\u0010P\u001a\u00020\u000fJ\u0006\u00105\u001a\u00020\rJ\u0017\u0010Q\u001a\u0002082\b\u0010R\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u00100J\u0016\u0010S\u001a\u0002082\u0006\u0010T\u001a\u00020\r2\u0006\u0010U\u001a\u00020\rJ\u0006\u0010V\u001a\u000208J\u0018\u0010W\u001a\u0002082\u0006\u0010J\u001a\u00020\u00022\u0006\u0010N\u001a\u00020\u000fH\u0017J\u0018\u0010X\u001a\u00020\u00022\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u000fH\u0016J\u000e\u0010\\\u001a\u0002082\u0006\u0010J\u001a\u00020&J\u000e\u0010]\u001a\u0002082\u0006\u0010J\u001a\u00020&J\u000e\u0010^\u001a\u0002082\u0006\u0010J\u001a\u00020&J\u000e\u0010_\u001a\u0002082\u0006\u0010J\u001a\u00020&J\u0010\u0010`\u001a\u0002082\u0006\u0010J\u001a\u00020&H\u0002J\u0018\u0010a\u001a\u0002082\u0006\u0010J\u001a\u00020&2\u0006\u0010b\u001a\u00020\rH\u0002J>\u0010c\u001a\u0002082\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010d\u001a\u00020\b2\u0006\u0010e\u001a\u00020\b2\u0006\u0010f\u001a\u00020\b2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020\b2\u0006\u0010j\u001a\u00020hJ\u000e\u0010k\u001a\u0002082\u0006\u0010J\u001a\u00020&J\u0018\u0010l\u001a\u0002082\u0006\u0010J\u001a\u00020&2\b\b\u0002\u0010m\u001a\u00020\rJ\u000e\u0010n\u001a\u0002082\u0006\u0010b\u001a\u00020\rJ\b\u0010o\u001a\u000208H\u0002J\u0006\u0010p\u001a\u000208R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R*\u0010,\u001a\u0004\u0018\u00010\u000f2\b\u0010+\u001a\u0004\u0018\u00010\u000f@FX\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00102\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u00106\u001a\n\u0012\u0004\u0012\u000208\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00109\u001a\n\u0012\u0004\u0012\u000208\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020=X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010D\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\bE\u0010\"¨\u0006w"}, d2 = {"Lcom/android/contacts/calllog/record/RecordSentenceAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "callCreateTime", "", "phoneNumber", "", "asrItems", "", "Lcom/obric/database/entity/RecordASRMessageEntity;", "showSummary", "", "statusHeight", "", "listener", "Lcom/android/contacts/calllog/record/RecordSentenceAdapter$RecordSentenceClickListener;", "asrFailCanNotUseMobileNetwork", "(Landroid/content/Context;JLjava/lang/String;Ljava/util/List;ZILcom/android/contacts/calllog/record/RecordSentenceAdapter$RecordSentenceClickListener;Z)V", "getAsrItems", "()Ljava/util/List;", "contactNames", "Lcom/obric/utils/ContactNames;", "currentStatusHeight", "feedbackHolder", "Lcom/android/contacts/calllog/record/RecordSentenceAdapter$FeedbackHolder;", "getFeedbackHolder", "()Lcom/android/contacts/calllog/record/RecordSentenceAdapter$FeedbackHolder;", "setFeedbackHolder", "(Lcom/android/contacts/calllog/record/RecordSentenceAdapter$FeedbackHolder;)V", "feedbackVisibleLayoutParams", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$LayoutParams;", "getFeedbackVisibleLayoutParams", "()Lcom/obric/oui/orecyclerview/widget/RecyclerView$LayoutParams;", "goneLayoutParams", "getGoneLayoutParams", "headerHolder", "Lcom/android/contacts/calllog/record/RecordSentenceAdapter$HeaderHolder;", "getHeaderHolder", "()Lcom/android/contacts/calllog/record/RecordSentenceAdapter$HeaderHolder;", "setHeaderHolder", "(Lcom/android/contacts/calllog/record/RecordSentenceAdapter$HeaderHolder;)V", "value", "highlightPosition", "getHighlightPosition", "()Ljava/lang/Integer;", "setHighlightPosition", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "isDown", "isFeedbackDislikeSelected", "isFeedbackLikeSelected", "isFeedbackVisible", "onFeedbackDislikeClick", "Lkotlin/Function0;", "", "onFeedbackLikeClick", "getShowSummary", "()Z", "statuesHolder", "Lcom/android/contacts/calllog/record/RecordSentenceAdapter$StatusHolder;", "getStatuesHolder", "()Lcom/android/contacts/calllog/record/RecordSentenceAdapter$StatusHolder;", "setStatuesHolder", "(Lcom/android/contacts/calllog/record/RecordSentenceAdapter$StatusHolder;)V", "getStatusHeight", "()I", "visibleLayoutParams", "getVisibleLayoutParams", "bindFeedbackActions", "onLikeClick", "onDislikeClick", "bindFeedbackHolder", "holder", "getContentStartOffset", "getItemCount", "getItemViewType", "position", "getStatusPosition", "getVisibleTopSectionHeight", "notifyContentItemChanged", "contentPosition", "notifyFeedbackVoteState", "isLikeSelected", "isDislikeSelected", "notifySummaryStatusChanged", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onSummaryFail", "onSummaryGeneration", "onSummaryGenerationFailed", "onSummaryModelDownloading", "resetHeaderHolder", "setHeaderVisible", "visible", "showAlertDialog", "title", "message", "positiveButtonText", "positiveButtonClickListener", "Landroid/content/DialogInterface$OnClickListener;", "negativeButtonText", "negativeButtonClickListener", "switchExpanded", "updateExpandedStatus", "useAnimator", "updateFeedbackVisibility", "updateStatusHeight", "updateStatusView", "Companion", "FeedbackHolder", "HeaderHolder", "ItemHolder", "RecordSentenceClickListener", "StatusHolder", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RecordSentenceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int CONTENT_START_OFFSET = 3;
    public static final Companion Companion = null;
    private static final int FEEDBACK_POSITION = 0;
    private static final int HEADER_POSITION = 1;
    private static final int STATUS_POSITION = 2;
    private static final String TAG = "CallRecordAndSummaryActivity_RecordSentenceAdapter";
    private static final int VIEW_TYPE_FEEDBACK = 0;
    private static final int VIEW_TYPE_HEADER = 1;
    private static final int VIEW_TYPE_ITEM = 3;
    private static final int VIEW_TYPE_STATUS = 2;
    private static boolean expanded;
    private final boolean asrFailCanNotUseMobileNetwork;
    private final List<RecordASRMessageEntity> asrItems;
    private final long callCreateTime;
    private final ContactNames contactNames;
    private final Context context;
    private int currentStatusHeight;
    private FeedbackHolder feedbackHolder;
    private HeaderHolder headerHolder;
    private Integer highlightPosition;
    private boolean isDown;
    private boolean isFeedbackDislikeSelected;
    private boolean isFeedbackLikeSelected;
    private boolean isFeedbackVisible;
    private final RecordSentenceClickListener listener;
    private Function0<Unit> onFeedbackDislikeClick;
    private Function0<Unit> onFeedbackLikeClick;
    private final String phoneNumber;
    private final boolean showSummary;
    public StatusHolder statuesHolder;
    private final int statusHeight;

    /* JADX INFO: compiled from: RecordSentenceAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/contacts/calllog/record/RecordSentenceAdapter$Companion;", "", "()V", "CONTENT_START_OFFSET", "", "FEEDBACK_POSITION", "HEADER_POSITION", "STATUS_POSITION", "TAG", "", "VIEW_TYPE_FEEDBACK", "VIEW_TYPE_HEADER", "VIEW_TYPE_ITEM", "VIEW_TYPE_STATUS", "expanded", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: RecordSentenceAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/android/contacts/calllog/record/RecordSentenceAdapter$FeedbackHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "container", "getContainer", "()Landroid/view/View;", "dislikeButton", "Lcom/obric/oui/button/OIconButton;", "getDislikeButton", "()Lcom/obric/oui/button/OIconButton;", "likeButton", "getLikeButton", "getView", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class FeedbackHolder extends RecyclerView.ViewHolder {
        private final View container;
        private final OIconButton dislikeButton;
        private final OIconButton likeButton;
        private final View view;

        public FeedbackHolder(View r3) {
            Intrinsics.checkNotNullParameter(r3, "view");
            super(r3);
            this.view = r3;
            View r0 = r3.findViewById(R.id.ll_feedback_container);
            Intrinsics.checkNotNullExpressionValue(r0, "view.findViewById(R.id.ll_feedback_container)");
            this.container = r0;
            this.likeButton = (OIconButton) r3.findViewById(R.id.btn_feedback_like);
            this.dislikeButton = (OIconButton) r3.findViewById(R.id.btn_feedback_dislike);
        }

        public final View getView() {
            return this.view;
        }

        public final View getContainer() {
            return this.container;
        }

        public final OIconButton getLikeButton() {
            return this.likeButton;
        }

        public final OIconButton getDislikeButton() {
            return this.dislikeButton;
        }
    }

    /* JADX INFO: compiled from: RecordSentenceAdapter.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/android/contacts/calllog/record/RecordSentenceAdapter$HeaderHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "callContentGenerateTodo", "Landroid/view/ViewGroup;", "getCallContentGenerateTodo", "()Landroid/view/ViewGroup;", "callContentParagraph", "getCallContentParagraph", "callSummary", "Landroid/widget/TextView;", "getCallSummary", "()Landroid/widget/TextView;", "callSummaryContainer", "getCallSummaryContainer", "callSummaryCopy", "Lcom/android/contacts/widget/CopyAllView;", "getCallSummaryCopy", "()Lcom/android/contacts/widget/CopyAllView;", "callSummaryDes", "getCallSummaryDes", "callSummaryLoading", "Lcom/obric/oui/progress/ODownloadProgressView;", "getCallSummaryLoading", "()Lcom/obric/oui/progress/ODownloadProgressView;", "callSummaryStatus", "Landroid/widget/ImageView;", "getCallSummaryStatus", "()Landroid/widget/ImageView;", "madeByAi", "Lcom/obric/oui/text/OTextView;", "getMadeByAi", "()Lcom/obric/oui/text/OTextView;", "getView", "()Landroid/view/View;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class HeaderHolder extends RecyclerView.ViewHolder {
        private final ViewGroup callContentGenerateTodo;
        private final ViewGroup callContentParagraph;
        private final TextView callSummary;
        private final ViewGroup callSummaryContainer;
        private final CopyAllView callSummaryCopy;
        private final TextView callSummaryDes;
        private final ODownloadProgressView callSummaryLoading;
        private final ImageView callSummaryStatus;
        private final OTextView madeByAi;
        private final View view;

        public HeaderHolder(View r3) {
            Intrinsics.checkNotNullParameter(r3, "view");
            super(r3);
            this.view = r3;
            this.callSummary = (TextView) r3.findViewById(R.id.tv_call_summary);
            this.callContentParagraph = (ViewGroup) r3.findViewById(R.id.ll_call_content_paragraph);
            this.callContentGenerateTodo = (ViewGroup) r3.findViewById(R.id.ll_call_content_generate_todo);
            ViewGroup r0 = (ViewGroup) r3.findViewById(R.id.ll_summary_container);
            this.callSummaryContainer = r0;
            this.callSummaryDes = (TextView) r3.findViewById(R.id.tv_summary_des);
            this.callSummaryStatus = (ImageView) r3.findViewById(R.id.iv_summary_status);
            this.callSummaryCopy = (CopyAllView) r3.findViewById(R.id.call_summary_copy);
            this.callSummaryLoading = (ODownloadProgressView) r3.findViewById(R.id.iv_summary_loading);
            this.madeByAi = (OTextView) r3.findViewById(R.id.tv_made_by_ai);
            if ((r0 instanceof OUIConstraintLayout) == false) goto L5;
            OUIConstraintLayout r1 = (OUIConstraintLayout) r0;
        L6:
            if (r1 == null) goto L9;
            r1.setChangeAlphaWhenPress(false);
            return;
        L9:
            return;
        L5:
            r1 = null;
            goto L6
        }

        public final View getView() {
            return this.view;
        }

        public final TextView getCallSummary() {
            return this.callSummary;
        }

        public final ViewGroup getCallContentParagraph() {
            return this.callContentParagraph;
        }

        public final ViewGroup getCallContentGenerateTodo() {
            return this.callContentGenerateTodo;
        }

        public final ViewGroup getCallSummaryContainer() {
            return this.callSummaryContainer;
        }

        public final TextView getCallSummaryDes() {
            return this.callSummaryDes;
        }

        public final ImageView getCallSummaryStatus() {
            return this.callSummaryStatus;
        }

        public final CopyAllView getCallSummaryCopy() {
            return this.callSummaryCopy;
        }

        public final ODownloadProgressView getCallSummaryLoading() {
            return this.callSummaryLoading;
        }

        public final OTextView getMadeByAi() {
            return this.madeByAi;
        }
    }

    /* JADX INFO: compiled from: RecordSentenceAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/android/contacts/calllog/record/RecordSentenceAdapter$ItemHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "recordBottomView", "Landroid/view/ViewGroup;", "getRecordBottomView", "()Landroid/view/ViewGroup;", "setRecordBottomView", "(Landroid/view/ViewGroup;)V", "recordContent", "Landroid/widget/TextView;", "getRecordContent", "()Landroid/widget/TextView;", "setRecordContent", "(Landroid/widget/TextView;)V", "recordContentContainer", "getRecordContentContainer", "setRecordContentContainer", "recordDuration", "getRecordDuration", "setRecordDuration", "recordSpeaker", "getRecordSpeaker", "setRecordSpeaker", "getView", "()Landroid/view/View;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ItemHolder extends RecyclerView.ViewHolder {
        private ViewGroup recordBottomView;
        private TextView recordContent;
        private ViewGroup recordContentContainer;
        private TextView recordDuration;
        private TextView recordSpeaker;
        private final View view;

        public ItemHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.view = r2;
            this.recordSpeaker = (TextView) r2.findViewById(R.id.tv_record_speaker);
            this.recordDuration = (TextView) r2.findViewById(R.id.tv_record_duration);
            this.recordContent = (TextView) r2.findViewById(R.id.tv_record_content);
            this.recordContentContainer = (ViewGroup) r2.findViewById(R.id.cl_asr_sentence_content);
            this.recordBottomView = (ViewGroup) r2.findViewById(R.id.bottom_merge_view);
        }

        public final View getView() {
            return this.view;
        }

        public final TextView getRecordSpeaker() {
            return this.recordSpeaker;
        }

        public final void setRecordSpeaker(TextView r1) {
            this.recordSpeaker = r1;
        }

        public final TextView getRecordDuration() {
            return this.recordDuration;
        }

        public final void setRecordDuration(TextView r1) {
            this.recordDuration = r1;
        }

        public final TextView getRecordContent() {
            return this.recordContent;
        }

        public final void setRecordContent(TextView r1) {
            this.recordContent = r1;
        }

        public final ViewGroup getRecordContentContainer() {
            return this.recordContentContainer;
        }

        public final void setRecordContentContainer(ViewGroup r1) {
            this.recordContentContainer = r1;
        }

        public final ViewGroup getRecordBottomView() {
            return this.recordBottomView;
        }

        public final void setRecordBottomView(ViewGroup r1) {
            this.recordBottomView = r1;
        }
    }

    /* JADX INFO: compiled from: RecordSentenceAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/android/contacts/calllog/record/RecordSentenceAdapter$RecordSentenceClickListener;", "", "onItemClicked", "", "currentPosition", "", "startLocalSummaryDownload", "updateAsrErrorViewHeight", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "updateListViewHeight", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface RecordSentenceClickListener {
        void onItemClicked(int r1);

        void startLocalSummaryDownload();

        void updateAsrErrorViewHeight(int r1);

        void updateListViewHeight(int r1);
    }

    /* JADX INFO: compiled from: RecordSentenceAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/android/contacts/calllog/record/RecordSentenceAdapter$StatusHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "desc", "Landroid/widget/TextView;", "getDesc", "()Landroid/widget/TextView;", "setDesc", "(Landroid/widget/TextView;)V", "progress", "getProgress", "()Landroid/view/View;", "setProgress", "retry", "Lcom/obric/oui/button/OButton;", "getRetry", "()Lcom/obric/oui/button/OButton;", "setRetry", "(Lcom/obric/oui/button/OButton;)V", "title", "Lcom/obric/oui/text/OTextView;", "getTitle", "()Lcom/obric/oui/text/OTextView;", "getView", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class StatusHolder extends RecyclerView.ViewHolder {
        private TextView desc;
        private View progress;
        private OButton retry;
        private final OTextView title;
        private final View view;

        public StatusHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.view = r2;
            this.title = (OTextView) r2.findViewById(R.id.tv_asr_status_title);
            this.desc = (TextView) r2.findViewById(R.id.tv_asr_status_desc);
            this.retry = (OButton) r2.findViewById(R.id.bt_asr_retry);
            this.progress = r2.findViewById(R.id.progress_view_processing);
        }

        public final View getView() {
            return this.view;
        }

        public final OTextView getTitle() {
            return this.title;
        }

        public final TextView getDesc() {
            return this.desc;
        }

        public final void setDesc(TextView r1) {
            this.desc = r1;
        }

        public final OButton getRetry() {
            return this.retry;
        }

        public final void setRetry(OButton r1) {
            this.retry = r1;
        }

        public final View getProgress() {
            return this.progress;
        }

        public final void setProgress(View r1) {
            this.progress = r1;
        }
    }

    public static /* synthetic */ void $r8$lambda$0gp1YpuoylHR8f_696B5s8XivBc(RecordSentenceAdapter r0, View r1) {
        bindFeedbackHolder$lambda$8(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$29D9xpZHJZGvsZ1hrFitbSQfzo4(RecordSentenceAdapter r0, HeaderHolder r1) {
        updateExpandedStatus$lambda$12(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$4gewxRwp5tmeA2eRQCcU4p7G3rw(RecordSentenceAdapter r0, View r1) {
        bindFeedbackHolder$lambda$9(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$5zAIVHTyT1ujq92VcC8ZEbHBhDQ(DialogInterface r0, int r1) {
        updateStatusView$lambda$18$lambda$17$lambda$16(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$GdfmIeeY0rC9eTrCogOdg1dmjO4(DialogInterface r0) {
        showAlertDialog$lambda$23(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$J9TG2y-Yg2f5DOsrrNYJz_Ccwjg, reason: not valid java name */
    public static /* synthetic */ void m152$r8$lambda$J9TG2yYg2f5DOsrrNYJz_Ccwjg(DialogInterface.OnClickListener r0, DialogInterface r1, int r2) {
        showAlertDialog$lambda$21(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$NBf8TweYGAmouVlsy_exY-Bp_MU, reason: not valid java name */
    public static /* synthetic */ void m153$r8$lambda$NBf8TweYGAmouVlsy_exYBp_MU(RecordSentenceAdapter r0, HeaderHolder r1, ViewGroup r2, View r3) {
        onSummaryGenerationFailed$lambda$11$lambda$10(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$Q4mXDx4QEaD3BjvhR7aLZBcKRZY(RecordSentenceAdapter r0, RecordASRMessageEntity r1, View r2) {
        onBindViewHolder$lambda$7(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$UB1k_aWMKfQnwDFxJTyNgONyi7M(RecordSentenceAdapter r0, RecyclerView.ViewHolder r1, View r2) {
        onBindViewHolder$lambda$2(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$UEkwEHW0n76UDZTTwCX-eBH5EPM, reason: not valid java name */
    public static /* synthetic */ void m154$r8$lambda$UEkwEHW0n76UDZTTwCXeBH5EPM(OButton r0, RecordSentenceAdapter r1, DialogInterface r2, int r3) {
        updateStatusView$lambda$18$lambda$17$lambda$15(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$ZWF9qUoq61VqeVoJiCXRyFwuFt4(DialogInterface.OnClickListener r0, DialogInterface r1, int r2) {
        showAlertDialog$lambda$22(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$goGFaxurggLATmCj7irYVj5TIQk(RecordSentenceAdapter r0) {
        updateStatusHeight$lambda$20(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$vVkwjQzmJZGMRaaK4dAr6OIT-Mc, reason: not valid java name */
    public static /* synthetic */ void m155$r8$lambda$vVkwjQzmJZGMRaaK4dAr6OITMc(RecordSentenceAdapter r0, OButton r1, View r2) {
        updateStatusView$lambda$18$lambda$17(r0, r1, r2);
    }

    private static final void updateStatusView$lambda$18$lambda$17$lambda$16(DialogInterface r0, int r1) {
    }

    public final int getContentStartOffset() {
        return 3;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r1) {
        if (r1 != 0) goto L4;
        return 0;
    L4:
        if (r1 != 1) goto L6;
        return 1;
    L6:
        if (r1 == 2) goto L11;
        return 3;
    L11:
        return 2;
    }

    public final int getStatusPosition() {
        return 2;
    }

    public static final /* synthetic */ long access$getCallCreateTime$p(RecordSentenceAdapter r2) {
        return r2.callCreateTime;
    }

    public static final /* synthetic */ String access$getPhoneNumber$p(RecordSentenceAdapter r0) {
        return r0.phoneNumber;
    }

    public final List<RecordASRMessageEntity> getAsrItems() {
        return this.asrItems;
    }

    public final boolean getShowSummary() {
        return this.showSummary;
    }

    public final int getStatusHeight() {
        return this.statusHeight;
    }

    public RecordSentenceAdapter(Context r2, long r3, String r5, List<RecordASRMessageEntity> r6, boolean r7, int r8, RecordSentenceClickListener r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "phoneNumber");
        Intrinsics.checkNotNullParameter(r6, "asrItems");
        Intrinsics.checkNotNullParameter(r9, "listener");
        this.context = r2;
        this.callCreateTime = r3;
        this.phoneNumber = r5;
        this.asrItems = r6;
        this.showSummary = r7;
        this.statusHeight = r8;
        this.listener = r9;
        this.asrFailCanNotUseMobileNetwork = r10;
        this.contactNames = new ContactNames(r2);
        this.currentStatusHeight = r8;
        this.highlightPosition = -1;
        this.isDown = !expanded;
    }

    public final FeedbackHolder getFeedbackHolder() {
        return this.feedbackHolder;
    }

    public final void setFeedbackHolder(FeedbackHolder r1) {
        this.feedbackHolder = r1;
    }

    public final HeaderHolder getHeaderHolder() {
        return this.headerHolder;
    }

    public final void setHeaderHolder(HeaderHolder r1) {
        this.headerHolder = r1;
    }

    public final RecyclerView.LayoutParams getGoneLayoutParams() {
        return new RecyclerView.LayoutParams(0, 0);
    }

    public final RecyclerView.LayoutParams getFeedbackVisibleLayoutParams() {
        RecyclerView.LayoutParams r3 = new RecyclerView.LayoutParams(-1, -2);
        r3.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()));
        r3.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));
        return r3;
    }

    public final RecyclerView.LayoutParams getVisibleLayoutParams() {
        RecyclerView.LayoutParams r3 = new RecyclerView.LayoutParams(-1, -2);
        r3.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics()));
        r3.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics()));
        return r3;
    }

    public final StatusHolder getStatuesHolder() {
        StatusHolder r0 = this.statuesHolder;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("statuesHolder");
        return null;
    }

    public final void setStatuesHolder(StatusHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.statuesHolder = r2;
    }

    public final Integer getHighlightPosition() {
        return this.highlightPosition;
    }

    public final void setHighlightPosition(Integer r3) {
        Integer r0 = this.highlightPosition;
        if (Intrinsics.areEqual(r0, r3) == false) goto L5;
        return;
    L5:
        this.highlightPosition = r3;
        notifyContentItemChanged(r0);
        notifyContentItemChanged(r3);
    }

    static {
        Companion = new Companion(null);
        expanded = true;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 != 0) goto L5;
        View r6 = LayoutInflater.from(r4.getContext()).inflate(R.layout.calllog_feedback_bar_item, r4, false);
        Intrinsics.checkNotNullExpressionValue(r6, "view");
        FeedbackHolder r7 = new FeedbackHolder(r6);
        this.feedbackHolder = r7;
        Intrinsics.checkNotNull(r7);
        return r7;
    L5:
        if (r5 != 1) goto L7;
        View r8 = LayoutInflater.from(r4.getContext()).inflate(R.layout.call_record_sumarry_container, r4, false);
        Intrinsics.checkNotNullExpressionValue(r8, "view");
        HeaderHolder r9 = new HeaderHolder(r8);
        this.headerHolder = r9;
        Intrinsics.checkNotNull(r9);
        return r9;
    L7:
        if (r5 == 2) goto L10;
        View r3 = LayoutInflater.from(r4.getContext()).inflate(R.layout.record_content_sententce, r4, false);
        Intrinsics.checkNotNullExpressionValue(r3, "view");
        return new ItemHolder(r3);
    L10:
        View r10 = LayoutInflater.from(r4.getContext()).inflate(R.layout.record_asr_gen_status, r4, false);
        Intrinsics.checkNotNullExpressionValue(r10, "view");
        setStatuesHolder(new StatusHolder(r10));
        return getStatuesHolder();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.asrItems.size() + 3;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder r24, int r25) {
        Intrinsics.checkNotNullParameter(r24, "holder");
        if ((r24 instanceof FeedbackHolder) == false) goto L7;
        bindFeedbackHolder((FeedbackHolder) r24);
        return;
    L7:
        if ((r24 instanceof HeaderHolder) == false) goto L115;
        HeaderHolder r3 = (HeaderHolder) r24;
        resetHeaderHolder(r3);
        CallFeatureBean r8 = CallFeatureModel.INSTANCE.getCallFeature(this.callCreateTime, this.phoneNumber);
        if (this.showSummary == false) goto L114;
        if (r8 == null) goto L114;
        if (r8.isFeatureCallSummaryEnabled() == false) goto L14;
    L15:
        setHeaderVisible(r3, true);
        if (AISummary.INSTANCE.isLocalModel(this.context) == false) goto L22;
        if (AISummary.INSTANCE.isModelDownloadCompleted(this.context) == true) goto L22;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "summary local model is download");
        onSummaryModelDownloading(r3);
        this.listener.startLocalSummaryDownload();
        return;
    L22:
        if (CallFeatureModel.INSTANCE.getSummarizingDataSet().contains(new Pair(Long.valueOf(this.callCreateTime), this.phoneNumber)) == false) goto L26;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "summary is generating");
        onSummaryGeneration(r3);
        return;
    L26:
        if (this.asrItems.isEmpty() == false) goto L30;
        setHeaderVisible(r3, false);
        return;
    L30:
        if (r8.getSummary().isEmpty() == false) goto L33;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "summary generation failed");
        onSummaryGenerationFailed(r3);
        return;
    L33:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "summary generation success " + r8);
        if (r8.getSummary().isUnableToSummarize(this.context) == true) goto L36;
        TextView r9 = r3.getCallSummaryDes();
        if (r9 == null) goto L48;
        r9.setVisibility(8);
    L48:
        ImageView r10 = r3.getCallSummaryStatus();
        if (r10 == null) goto L52;
        r10.setVisibility(0);
    L52:
        ViewGroup r11 = r3.getCallSummaryContainer();
        if (r11 == null) goto L56;
        r11.setOnClickListener(new RecordSentenceAdapter$$ExternalSyntheticLambda5(this, r24));
    L56:
        if (r8.getSummary().getSummary().length() <= 0) goto L58;
        boolean r12 = true;
    L59:
        TextView r13 = r3.getCallSummary();
        if (r13 == null) goto L67;
        TextView r14 = r13;
        if (r12 == false) goto L65;
        int r15 = 0;
    L66:
        r14.setVisibility(r15);
        goto L67
    L65:
        r15 = 8;
    L67:
        OTextView r16 = r3.getMadeByAi();
        if (r16 == null) goto L75;
        OTextView r17 = r16;
        if (r12 == false) goto L73;
        int r18 = 0;
    L74:
        r17.setVisibility(r18);
        goto L75
    L73:
        r18 = 8;
    L75:
        TextView r19 = r3.getCallSummary();
        if (r19 == null) goto L79;
        r19.setText(r8.getSummary().getSummary());
    L79:
        StringBuilder r20 = new StringBuilder(r8.getSummary().getSummary());
        Iterator<T> r110 = r8.getSummary().getItems().iterator();
    L81:
        if (r110.hasNext() == false) goto L89;
        String r111 = (String) r110.next();
        View r5 = LayoutInflater.from(this.context).inflate(R.layout.detail_calllog_content_paragraph, r3.getCallContentParagraph(), false);
        TextView r6 = (TextView) r5.findViewById(R.id.tv_summary_paragraph);
        if (r6 == null) goto L85;
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById<TextView>(R.id.tv_summary_paragraph)");
        r6.setText(r111);
        r6.setTextColor(r6.getContext().getColor(R.color.oui_text_1));
    L85:
        r5.setPadding(0, MathKt.roundToInt(TypedValue.applyDimension(1, 7, Resources.getSystem().getDisplayMetrics())), 0, 0);
        ViewGroup r7 = r3.getCallContentParagraph();
        if (r7 == null) goto L88;
        r7.addView(r5);
    L88:
        r20.append("\n").append(r111);
        goto L81
    L89:
        CopyAllView r21 = r3.getCallSummaryCopy();
        if (r21 == null) goto L93;
        r21.setText(r20);
    L93:
        List<CallAssignmentData> r22 = r8.getSummary().getCallAssignment().getList();
        OTextView r23 = new OTextView(this.context, null, 0, null, 14, null);
        r23.setText(this.context.getString(R.string.call_summary_generate_todo));
        r23.setTextSize(14.0f);
        r23.setTypeface(Typeface.DEFAULT_BOLD);
        r23.setTextAppearance(R.style.Body_1_Medium);
        r23.setTextColor(this.context.getColor(R.color.oui_text_1));
        float r26 = 7;
        r23.setPadding(0, MathKt.roundToInt(TypedValue.applyDimension(1, r26, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r26, Resources.getSystem().getDisplayMetrics())), 0);
        ViewGroup r27 = r3.getCallContentGenerateTodo();
        if (r27 == null) goto L96;
        r27.addView(r23);
    L96:
        Iterator<T> r28 = r22.iterator();
    L98:
        if (r28.hasNext() == false) goto L109;
        CallAssignmentData r29 = (CallAssignmentData) r28.next();
        View r30 = LayoutInflater.from(this.context).inflate(R.layout.detail_calllog_content_paragraph, r3.getCallContentGenerateTodo(), false);
        OUILinearLayout r112 = (OUILinearLayout) r30.findViewById(R.id.tv_summary_tag);
        if (r112 == null) goto L103;
        Intrinsics.checkNotNullExpressionValue(r112, "findViewById<OUILinearLayout>(R.id.tv_summary_tag)");
        r112.setVisibility(8);
    L103:
        TextView r113 = (TextView) r30.findViewById(R.id.tv_summary_paragraph);
        if (r113 == null) goto L106;
        Intrinsics.checkNotNullExpressionValue(r113, "findViewById<TextView>(R.id.tv_summary_paragraph)");
        r113.setText(r29.getSummary());
        r113.setTextColor(r113.getContext().getColor(R.color.oui_text_1));
    L106:
        r30.setPadding(0, MathKt.roundToInt(TypedValue.applyDimension(1, r26, Resources.getSystem().getDisplayMetrics())), 0, 0);
        ViewGroup r31 = r3.getCallContentGenerateTodo();
        if (r31 == null) goto L98;
        r31.addView(r30);
        goto L98
    L109:
        ODownloadProgressView r32 = r3.getCallSummaryLoading();
        int r33 = 8;
        if (r32 == null) goto L113;
        r32.setVisibility(8);
    L113:
        updateExpandedStatus(r3, false);
    L117:
        if ((r24 instanceof StatusHolder) == false) goto L124;
        OTextView r4 = getStatuesHolder().getTitle();
        if (r4 == null) goto L122;
        r4.setVisibility(0);
    L122:
        updateStatusView();
    L124:
        if ((r24 instanceof ItemHolder) == false) goto L212;
        int r34 = r25 - 3;
        if (r34 >= 0) goto L128;
        return;
    L128:
        if (r34 >= this.asrItems.size()) goto L214;
        final RecordASRMessageEntity r35 = this.asrItems.get(r34);
        if (r35.getOwner() != 1) goto L136;
        TextView r36 = ((ItemHolder) r24).getRecordSpeaker();
        if (r36 == null) goto L159;
        r36.setText(this.context.getString(R.string.common_i));
    L159:
        ItemHolder r1 = (ItemHolder) r24;
        TextView r37 = r1.getRecordDuration();
        if (r37 == null) goto L163;
        r37.setText(TimeUtilKt.formatMillisecondsUsingDuration((int) r35.getDuration()));
    L163:
        Integer r38 = this.highlightPosition;
        if (r38 != null) goto L167;
    L178:
        TextView r39 = r1.getRecordContent();
        if (r39 == null) goto L182;
        r39.setText(r35.getAsrText());
    L182:
        ViewGroup r40 = r1.getRecordContentContainer();
        if (r40 == null) goto L186;
        r40.setBackground(null);
    L186:
        TextView r41 = r1.getRecordContent();
        if (r41 == null) goto L189;
        r41.setTextColor(this.context.getColor(R.color.oui_text_3));
    L189:
        ViewGroup r42 = r1.getRecordContentContainer();
        if (r42 == null) goto L192;
        r42.setOnClickListener(new RecordSentenceAdapter$$ExternalSyntheticLambda6(this, r35));
    L192:
        ViewGroup r2 = r1.getRecordBottomView();
        if (r2 == null) goto L215;
        ViewGroup r43 = r2;
        boolean r44 = true;
        if (r25 == (getItemCount() - 1)) goto L199;
        r44 = false;
    L199:
        if (r44 == false) goto L201;
        int r45 = 0;
    L202:
        r43.setVisibility(r45);
        return;
    L201:
        r45 = r33;
        goto L202
    L215:
        return;
    L167:
        if (r38.intValue() != r34) goto L178;
        TextView r46 = r1.getRecordContent();
        if (r46 == null) goto L172;
        r46.setText(r35.getAsrText());
    L172:
        ViewGroup r47 = r1.getRecordContentContainer();
        if (r47 == null) goto L175;
        r47.setBackgroundResource(R.color.oui_state_overlay_pressed);
    L175:
        TextView r48 = r1.getRecordContent();
        if (r48 == null) goto L189;
        r48.setTextColor(this.context.getColor(R.color.oui_text_1));
        goto L189
    L136:
        if (r35.getOwner() == 2) goto L138;
        TextView r49 = ((ItemHolder) r24).getRecordSpeaker();
        if (r49 == null) goto L159;
        r49.setText(this.context.getString(R.string.call_speaker_self_ai));
        goto L159
    L138:
        if (r35.isConference() == null) goto L148;
        Integer r50 = r35.isConference();
        if (r50 != null) goto L143;
    L144:
        TextView r51 = ((ItemHolder) r24).getRecordSpeaker();
        if (r51 == null) goto L159;
        r51.setText(this.context.getString(R.string.common_conference_call));
        goto L159
    L143:
        if (r50.intValue() != 0) goto L144;
    L148:
        ItemHolder r52 = (ItemHolder) r24;
        TextView r53 = r52.getRecordSpeaker();
        if (r53 == null) goto L152;
        r53.setText(r35.getPhoneNumber());
    L152:
        Object r54 = this.contactNames.getName(r35.getPhoneNumber(), new RecordSentenceAdapter$onBindViewHolder$tag$1(r24));
        TextView r55 = r52.getRecordSpeaker();
        if (r55 == null) goto L159;
        r55.setTag(R.id.tv_record_speaker, r54);
        goto L159
    L214:
        return;
    L212:
        return;
    L58:
        r12 = false;
        goto L59
    L36:
        if ((!this.asrItems.isEmpty()) == false) goto L38;
    L41:
        setHeaderVisible(r3, true);
    L42:
        onSummaryFail(r3);
        return;
    L38:
        if (r8.isRecordASRAvailable() == true) goto L41;
        setHeaderVisible(r3, false);
        goto L42
    L14:
        if (CallFeatureModel.INSTANCE.getSummarizingDataSet().contains(new Pair(Long.valueOf(this.callCreateTime), this.phoneNumber)) == true) goto L15;
    L114:
        r33 = 8;
        setHeaderVisible(r3, false);
        goto L117
    L115:
        r33 = 8;
        goto L117
    }

    private static final void onBindViewHolder$lambda$2(RecordSentenceAdapter r0, RecyclerView.ViewHolder r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullParameter(r1, "$holder");
        r0.switchExpanded((HeaderHolder) r1);
    }

    private static final void onBindViewHolder$lambda$7(RecordSentenceAdapter r0, RecordASRMessageEntity r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullParameter(r1, "$entity");
        r0.listener.onItemClicked((int) r1.getStartTime());
    }

    private final void bindFeedbackHolder(FeedbackHolder r6) {
        View r0 = r6.itemView;
        if (this.isFeedbackVisible == false) goto L5;
        RecyclerView.LayoutParams r1 = getFeedbackVisibleLayoutParams();
    L6:
        r0.setLayoutParams(r1);
        View r2 = r6.itemView;
        if (this.isFeedbackVisible == false) goto L9;
        int r3 = 0;
    L10:
        r2.setVisibility(r3);
        OIconButton r4 = r6.getLikeButton();
        if (r4 == null) goto L13;
        r4.setOnClickListener(new RecordSentenceAdapter$$ExternalSyntheticLambda0(this));
    L13:
        OIconButton r5 = r6.getDislikeButton();
        if (r5 == null) goto L16;
        r5.setOnClickListener(new RecordSentenceAdapter$$ExternalSyntheticLambda4(this));
    L16:
        OIconButton r7 = r6.getLikeButton();
        int r8 = R.color.oui_functional_blue_6;
        if (r7 == null) goto L24;
        Context r9 = this.context;
        if (this.isFeedbackLikeSelected == false) goto L22;
        int r10 = R.color.oui_functional_blue_6;
    L23:
        r7.setImageTintList(ContextCompat.getColorStateList(r9, r10));
        goto L24
    L22:
        r10 = R.color.oui_basic_text_3;
    L24:
        OIconButton r11 = r6.getDislikeButton();
        if (r11 == null) goto L32;
        Context r12 = this.context;
        if (this.isFeedbackDislikeSelected == true) goto L31;
        r8 = R.color.oui_basic_text_3;
    L31:
        r11.setImageTintList(ContextCompat.getColorStateList(r12, r8));
    L32:
        OIconButton r13 = r6.getLikeButton();
        if (r13 == null) goto L36;
        r13.setSelected(this.isFeedbackLikeSelected);
    L36:
        OIconButton r14 = r6.getDislikeButton();
        if (r14 == null) goto L41;
        r14.setSelected(this.isFeedbackDislikeSelected);
        return;
    L41:
        return;
    L9:
        r3 = 8;
        goto L10
    L5:
        r1 = getGoneLayoutParams();
        goto L6
    }

    private static final void bindFeedbackHolder$lambda$8(RecordSentenceAdapter r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Function0<Unit> r2 = r0.onFeedbackLikeClick;
        if (r2 == null) goto L6;
        r2.invoke();
        return;
    }

    private static final void bindFeedbackHolder$lambda$9(RecordSentenceAdapter r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Function0<Unit> r2 = r0.onFeedbackDislikeClick;
        if (r2 == null) goto L6;
        r2.invoke();
        return;
    }

    public final void bindFeedbackActions(Function0<Unit> r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "onLikeClick");
        Intrinsics.checkNotNullParameter(r3, "onDislikeClick");
        this.onFeedbackLikeClick = r2;
        this.onFeedbackDislikeClick = r3;
        FeedbackHolder r4 = this.feedbackHolder;
        if (r4 == null) goto L6;
        bindFeedbackHolder(r4);
        return;
    }

    public final void updateFeedbackVisibility(boolean r2) {
        if (this.isFeedbackVisible != r2) goto L5;
        return;
    L5:
        this.isFeedbackVisible = r2;
        notifyItemChanged(0);
    }

    public final void notifyFeedbackVoteState(boolean r2, boolean r3) {
        if (this.isFeedbackLikeSelected == r2) goto L5;
    L7:
        this.isFeedbackLikeSelected = r2;
        this.isFeedbackDislikeSelected = r3;
        notifyItemChanged(0);
        return;
    L5:
        if (this.isFeedbackDislikeSelected != r3) goto L7;
    }

    public final void notifySummaryStatusChanged() {
        notifyItemChanged(1);
        notifyItemChanged(2);
    }

    private final void notifyContentItemChanged(Integer r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.intValue() >= 0) goto L6;
        return;
    L6:
        if (r3.intValue() >= this.asrItems.size()) goto L12;
        notifyItemChanged(r3.intValue() + 3);
        return;
    }

    public final boolean isFeedbackVisible() {
        return this.isFeedbackVisible;
    }

    public final int getVisibleTopSectionHeight() {
        FeedbackHolder r0 = this.feedbackHolder;
        boolean r1 = true;
        int r2 = 0;
        if (r0 == null) goto L12;
        View r3 = r0.itemView;
        if (r3 == null) goto L12;
        if (r3.getVisibility() != 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 != true) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L21;
        FeedbackHolder r6 = this.feedbackHolder;
        if (r6 == null) goto L19;
        View r7 = r6.itemView;
        if (r7 == null) goto L19;
        int r8 = r7.getMeasuredHeight();
    L20:
        int r9 = r8 + 0;
    L22:
        HeaderHolder r10 = this.headerHolder;
        if (r10 == null) goto L32;
        View r11 = r10.itemView;
        if (r11 == null) goto L32;
        if (r11.getVisibility() != 0) goto L29;
        boolean r12 = true;
    L30:
        if (r12 != true) goto L32;
    L33:
        if (r1 == false) goto L41;
        HeaderHolder r13 = this.headerHolder;
        if (r13 == null) goto L40;
        View r14 = r13.itemView;
        if (r14 == null) goto L40;
        r2 = r14.getMeasuredHeight();
    L40:
        return r9 + r2;
    L41:
        return r9;
    L29:
        r12 = false;
    L32:
        r1 = false;
    L19:
        r8 = 0;
        goto L20
    L21:
        r9 = 0;
        goto L22
    L9:
        r4 = false;
    L12:
        r5 = false;
        goto L13
    }

    private final void setHeaderVisible(HeaderHolder r2, boolean r3) {
        if (r3 == false) goto L4;
        r2.itemView.setLayoutParams(getVisibleLayoutParams());
    L5:
        View r1 = r2.itemView;
        if (r3 == false) goto L8;
        int r4 = 0;
    L9:
        r1.setVisibility(r4);
        return;
    L8:
        r4 = 8;
        goto L9
    L4:
        r2.itemView.setLayoutParams(getGoneLayoutParams());
        goto L5
    }

    private final void resetHeaderHolder(HeaderHolder r2) {
        ViewGroup r1 = r2.getCallContentParagraph();
        if (r1 == null) goto L5;
        r1.removeAllViews();
    L5:
        ViewGroup r3 = r2.getCallContentGenerateTodo();
        if (r3 == null) goto L8;
        r3.removeAllViews();
    L8:
        ViewGroup r4 = r2.getCallSummaryContainer();
        if (r4 == null) goto L11;
        r4.setOnClickListener(null);
    L11:
        r2.itemView.setClickable(true);
        TextView r5 = r2.getCallSummaryDes();
        if (r5 == null) goto L15;
        r5.setVisibility(8);
    L15:
        ImageView r6 = r2.getCallSummaryStatus();
        if (r6 == null) goto L19;
        r6.setVisibility(8);
    L19:
        ODownloadProgressView r7 = r2.getCallSummaryLoading();
        if (r7 == null) goto L23;
        r7.setVisibility(8);
    L23:
        ViewGroup r8 = r2.getCallContentParagraph();
        if (r8 == null) goto L27;
        r8.setVisibility(8);
    L27:
        ViewGroup r9 = r2.getCallContentGenerateTodo();
        if (r9 == null) goto L31;
        r9.setVisibility(8);
    L31:
        TextView r10 = r2.getCallSummary();
        if (r10 == null) goto L35;
        r10.setVisibility(8);
    L35:
        OTextView r11 = r2.getMadeByAi();
        if (r11 == null) goto L40;
        r11.setVisibility(8);
        return;
    }

    public final void onSummaryFail(HeaderHolder r5) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        r5.itemView.setClickable(false);
        TextView r0 = r5.getCallSummaryDes();
        if (r0 == null) goto L6;
        r0.setText(this.context.getString(R.string.call_summary_fail_detail));
    L6:
        TextView r1 = r5.getCallSummaryDes();
        if (r1 == null) goto L9;
        r1.setTextColor(this.context.getColor(R.color.oui_text_3b));
    L9:
        ImageView r4 = r5.getCallSummaryStatus();
        if (r4 == null) goto L13;
        r4.setVisibility(8);
    L13:
        ViewGroup r6 = r5.getCallContentParagraph();
        if (r6 == null) goto L17;
        r6.setVisibility(8);
    L17:
        ViewGroup r7 = r5.getCallContentGenerateTodo();
        if (r7 == null) goto L21;
        r7.setVisibility(8);
    L21:
        TextView r8 = r5.getCallSummary();
        if (r8 == null) goto L25;
        r8.setVisibility(8);
    L25:
        OTextView r9 = r5.getMadeByAi();
        if (r9 == null) goto L29;
        r9.setVisibility(8);
    L29:
        TextView r10 = r5.getCallSummaryDes();
        if (r10 == null) goto L33;
        r10.setVisibility(0);
    L33:
        ODownloadProgressView r11 = r5.getCallSummaryLoading();
        if (r11 == null) goto L38;
        r11.setVisibility(8);
        return;
    }

    public final void onSummaryModelDownloading(HeaderHolder r4) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        TextView r0 = r4.getCallSummaryDes();
        if (r0 == null) goto L6;
        r0.setText(this.context.getString(R.string.settings_ai_model_local_downloading));
    L6:
        TextView r1 = r4.getCallSummaryDes();
        if (r1 == null) goto L9;
        r1.setTextColor(this.context.getColor(R.color.oui_text_3b));
    L9:
        ImageView r3 = r4.getCallSummaryStatus();
        if (r3 == null) goto L13;
        r3.setVisibility(8);
    L13:
        ViewGroup r5 = r4.getCallContentParagraph();
        if (r5 == null) goto L17;
        r5.setVisibility(8);
    L17:
        ViewGroup r6 = r4.getCallContentGenerateTodo();
        if (r6 == null) goto L21;
        r6.setVisibility(8);
    L21:
        TextView r7 = r4.getCallSummary();
        if (r7 == null) goto L25;
        r7.setVisibility(8);
    L25:
        OTextView r8 = r4.getMadeByAi();
        if (r8 == null) goto L29;
        r8.setVisibility(8);
    L29:
        ODownloadProgressView r9 = r4.getCallSummaryLoading();
        if (r9 == null) goto L34;
        r9.setVisibility(0);
        return;
    }

    public final void onSummaryGeneration(HeaderHolder r4) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        TextView r0 = r4.getCallSummaryDes();
        if (r0 == null) goto L6;
        r0.setText(this.context.getString(R.string.summary_generation));
    L6:
        TextView r1 = r4.getCallSummaryDes();
        if (r1 == null) goto L9;
        r1.setTextColor(this.context.getColor(R.color.oui_text_3b));
    L9:
        ImageView r3 = r4.getCallSummaryStatus();
        if (r3 == null) goto L13;
        r3.setVisibility(8);
    L13:
        ViewGroup r5 = r4.getCallContentParagraph();
        if (r5 == null) goto L17;
        r5.setVisibility(8);
    L17:
        ViewGroup r6 = r4.getCallContentGenerateTodo();
        if (r6 == null) goto L21;
        r6.setVisibility(8);
    L21:
        TextView r7 = r4.getCallSummary();
        if (r7 == null) goto L25;
        r7.setVisibility(8);
    L25:
        OTextView r8 = r4.getMadeByAi();
        if (r8 == null) goto L29;
        r8.setVisibility(8);
    L29:
        ODownloadProgressView r9 = r4.getCallSummaryLoading();
        if (r9 == null) goto L33;
        r9.setVisibility(8);
    L33:
        ODownloadProgressView r10 = r4.getCallSummaryLoading();
        if (r10 == null) goto L38;
        r10.setVisibility(0);
        return;
    }

    public final void onSummaryGenerationFailed(final HeaderHolder r4) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        TextView r0 = r4.getCallSummaryDes();
        if (r0 == null) goto L6;
        r0.setText(this.context.getString(R.string.summary_generation_failed));
    L6:
        TextView r1 = r4.getCallSummaryDes();
        if (r1 == null) goto L9;
        r1.setTextColor(this.context.getColor(R.color.oui_functional_red_6));
    L9:
        TextView r2 = r4.getCallSummaryDes();
        if (r2 == null) goto L13;
        r2.setVisibility(0);
    L13:
        ImageView r3 = r4.getCallSummaryStatus();
        if (r3 == null) goto L17;
        r3.setVisibility(0);
    L17:
        ImageView r5 = r4.getCallSummaryStatus();
        if (r5 == null) goto L20;
        r5.setImageResource(R.drawable.icon_red6_progress);
    L20:
        final ViewGroup r6 = (ViewGroup) r4.getView().findViewById(R.id.ll_call_status_container);
        if (r6 == null) goto L23;
        r6.setOnClickListener(new RecordSentenceAdapter$$ExternalSyntheticLambda7(this, r4, r6));
    L23:
        ViewGroup r7 = r4.getCallContentParagraph();
        if (r7 == null) goto L27;
        r7.setVisibility(8);
    L27:
        ViewGroup r8 = r4.getCallContentGenerateTodo();
        if (r8 == null) goto L31;
        r8.setVisibility(8);
    L31:
        TextView r9 = r4.getCallSummary();
        if (r9 == null) goto L35;
        r9.setVisibility(8);
    L35:
        OTextView r10 = r4.getMadeByAi();
        if (r10 == null) goto L39;
        r10.setVisibility(8);
    L39:
        ODownloadProgressView r11 = r4.getCallSummaryLoading();
        if (r11 == null) goto L44;
        r11.setVisibility(8);
        return;
    }

    private static final void onSummaryGenerationFailed$lambda$11$lambda$10(RecordSentenceAdapter r6, HeaderHolder r7, ViewGroup r8, View r9) {
        Intrinsics.checkNotNullParameter(r6, "this$0");
        Intrinsics.checkNotNullParameter(r7, "$holder");
        r6.onSummaryGeneration(r7);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new RecordSentenceAdapter$onSummaryGenerationFailed$1$1$1(r6, r8, r7, null), 3, null);
    }

    public final void switchExpanded(HeaderHolder r4) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        expanded = !expanded;
        updateExpandedStatus$default(this, r4, false, 2, null);
        updateStatusHeight();
    }

    public static /* synthetic */ void updateExpandedStatus$default(RecordSentenceAdapter r0, HeaderHolder r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.updateExpandedStatus(r1, r2);
    }

    public final void updateExpandedStatus(final HeaderHolder r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "holder");
        CallFeatureBean r0 = CallFeatureModel.INSTANCE.getCallFeature(this.callCreateTime, this.phoneNumber);
        float r3 = 0.0f;
        int r6 = 8;
        if (expanded == true) goto L29;
        ViewGroup r1 = r10.getCallContentParagraph();
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        ViewGroup r2 = r10.getCallContentGenerateTodo();
        if (r2 == null) goto L12;
        r2.setVisibility(8);
    L12:
        TextView r4 = r10.getCallSummary();
        if (r4 == null) goto L16;
        r4.setVisibility(8);
    L16:
        OTextView r5 = r10.getMadeByAi();
        if (r5 == null) goto L20;
        r5.setVisibility(8);
    L20:
        if (r11 == true) goto L22;
        ImageView r9 = r10.getCallSummaryStatus();
        if (r9 == null) goto L90;
        r9.setImageResource(R.drawable.icon_text3b_down);
        return;
    L90:
        return;
    L22:
        if (this.isDown == true) goto L25;
        r3 = 180.0f;
    L25:
        ObjectAnimator.ofFloat(r10.getCallSummaryStatus(), "rotation", new float[]{r3}).start();
        return;
    L29:
        ViewGroup r7 = r10.getCallContentParagraph();
        if (r7 == null) goto L33;
        r7.setVisibility(0);
    L33:
        ViewGroup r8 = r10.getCallContentGenerateTodo();
        if (r8 == null) goto L52;
        ViewGroup r12 = r8;
        if (r0 == null) goto L47;
        CallSummary r13 = r0.getSummary();
        if (r13 == null) goto L47;
        CallAssignment r14 = r13.getCallAssignment();
        if (r14 == null) goto L47;
        List<CallAssignmentData> r15 = r14.getList();
        if (r15 == null) goto L47;
        if (r15.isEmpty() == true) goto L47;
        boolean r16 = true;
    L48:
        if (r16 == false) goto L50;
        int r17 = 0;
    L51:
        r12.setVisibility(r17);
        goto L52
    L50:
        r17 = 8;
    L47:
        r16 = false;
    L52:
        if (r0 == null) goto L63;
        CallSummary r18 = r0.getSummary();
        if (r18 == null) goto L63;
        String r19 = r18.getSummary();
        if (r19 == null) goto L63;
        if (r19.length() <= 0) goto L60;
        boolean r20 = true;
    L61:
        if (r20 != true) goto L63;
        boolean r21 = true;
    L64:
        TextView r22 = r10.getCallSummary();
        if (r22 == null) goto L72;
        TextView r23 = r22;
        if (r21 == false) goto L70;
        int r24 = 0;
    L71:
        r23.setVisibility(r24);
        goto L72
    L70:
        r24 = 8;
    L72:
        OTextView r25 = r10.getMadeByAi();
        if (r25 == null) goto L79;
        OTextView r26 = r25;
        if (r21 == false) goto L78;
        r6 = 0;
    L78:
        r26.setVisibility(r6);
    L79:
        if (r11 == true) goto L81;
        ImageView r110 = r10.getCallSummaryStatus();
        if (r110 == null) goto L87;
        r110.setImageResource(R.drawable.icon_text3b_up);
    L87:
        r10.itemView.post(new RecordSentenceAdapter$$ExternalSyntheticLambda11(this, r10));
        return;
    L81:
        if (this.isDown == false) goto L83;
        r3 = 180.0f;
    L83:
        ObjectAnimator.ofFloat(r10.getCallSummaryStatus(), "rotation", new float[]{r3}).start();
        goto L87
    L60:
        r20 = false;
    L63:
        r21 = false;
        goto L64
    }

    private static final void updateExpandedStatus$lambda$12(RecordSentenceAdapter r1, HeaderHolder r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$holder");
        r1.listener.updateListViewHeight(r2.itemView.getHeight());
    }

    public final void updateStatusView() {
        CallFeatureBean r0 = CallFeatureModel.INSTANCE.getCallFeature(this.callCreateTime, this.phoneNumber);
        Boolean r1 = null;
        if (r0 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r0.isRecordASRAvailable());
    L6:
        if (r0 == null) goto L8;
        Boolean r3 = Boolean.valueOf(r0.isRecordASRWorking());
    L9:
        if (r0 == null) goto L12;
        r1 = Boolean.valueOf(r0.isFeatureCallRecordEnabled());
    L12:
        if (this.statuesHolder != null) goto L14;
        return;
    L14:
        if (getStatuesHolder().itemView != null) goto L17;
        return;
    L17:
        if ((!this.asrItems.isEmpty()) == false) goto L19;
    L71:
        getStatuesHolder().itemView.setVisibility(8);
        getStatuesHolder().itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
        return;
    L19:
        if (ObriceRecordSummaryUtils.recordFileNotExists(this.context, Long.valueOf(this.callCreateTime), this.phoneNumber) == false) goto L28;
        if (Intrinsics.areEqual(r1, true) == false) goto L28;
        if (Intrinsics.areEqual(r2, false) == false) goto L28;
        if (Intrinsics.areEqual(r3, false) == true) goto L71;
    L28:
        if (this.currentStatusHeight == 0) goto L33;
        if (getStatuesHolder().itemView.getHeight() != 0) goto L33;
        getStatuesHolder().itemView.getLayoutParams().height = this.currentStatusHeight;
    L33:
        if (Intrinsics.areEqual(r1, true) == false) goto L51;
        if (Intrinsics.areEqual(r2, false) == false) goto L51;
        if (Intrinsics.areEqual(r3, true) == false) goto L51;
        TextView r4 = getStatuesHolder().getDesc();
        if (r4 == null) goto L41;
        r4.setText(R.string.asr_centent_generation);
    L41:
        View r5 = getStatuesHolder().getProgress();
        if (r5 == null) goto L45;
        r5.setVisibility(0);
    L45:
        OButton r6 = getStatuesHolder().getRetry();
        if (r6 == null) goto L49;
        r6.setVisibility(8);
    L49:
        updateStatusHeight();
        return;
    L51:
        if (Intrinsics.areEqual(r1, true) == true) goto L53;
    L69:
        getStatuesHolder().itemView.setVisibility(8);
        getStatuesHolder().itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
        return;
    L53:
        if (Intrinsics.areEqual(r2, false) == false) goto L69;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "isFeatureCallRecordEnabled:true but isRecordASRAvailable:false " + this.callCreateTime);
        TextView r7 = getStatuesHolder().getDesc();
        if (r7 == null) goto L57;
        float r8 = 43;
        r7.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r8, Resources.getSystem().getDisplayMetrics())), r7.getPaddingTop(), MathKt.roundToInt(TypedValue.applyDimension(1, r8, Resources.getSystem().getDisplayMetrics())), r7.getPaddingBottom());
        r7.setGravity(1);
        r7.setText(r7.getContext().getString(R.string.call_summary_err_use_mobile_data_tips));
    L57:
        View r9 = getStatuesHolder().getProgress();
        if (r9 == null) goto L61;
        r9.setVisibility(8);
    L61:
        OButton r10 = getStatuesHolder().getRetry();
        if (r10 == null) goto L65;
        r10.setVisibility(0);
    L65:
        final OButton r11 = getStatuesHolder().getRetry();
        if (r11 == null) goto L68;
        r11.setText(r11.getContext().getString(R.string.call_summary_err_use_mobile_data_btn));
        r11.setOnClickListener(new RecordSentenceAdapter$$ExternalSyntheticLambda3(this, r11));
    L68:
        updateStatusHeight();
        getStatuesHolder().itemView.setVisibility(0);
        return;
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    private static final void updateStatusView$lambda$18$lambda$17(final RecordSentenceAdapter r10, final OButton r11, View r12) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        Intrinsics.checkNotNullParameter(r11, "$this_apply");
        OTextView r13 = r10.getStatuesHolder().getTitle();
        if (r13 == null) goto L7;
        r13.setVisibility(8);
    L7:
        if (ASRController.INSTANCE.canStartASR() == true) goto L9;
        DialogInterface.OnClickListener r7 = new RecordSentenceAdapter$$ExternalSyntheticLambda12(r11, r10);
        DialogInterface.OnClickListener r9 = new RecordSentenceAdapter$$ExternalSyntheticLambda1();
        Context r3 = r11.getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        String r4 = r11.getContext().getString(R.string.use_mobile_data_dialog_title);
        Intrinsics.checkNotNullExpressionValue(r4, "context.getString(R.stri…mobile_data_dialog_title)");
        String r5 = r11.getContext().getString(R.string.use_mobile_data_dialog_subtitle);
        Intrinsics.checkNotNullExpressionValue(r5, "context.getString(R.stri…ile_data_dialog_subtitle)");
        String r6 = r11.getContext().getString(R.string.btn_continue);
        Intrinsics.checkNotNullExpressionValue(r6, "context.getString(R.string.btn_continue)");
        String r8 = r11.getContext().getString(R.string.common_cancel);
        Intrinsics.checkNotNullExpressionValue(r8, "context.getString(R.string.common_cancel)");
        r10.showAlertDialog(r3, r4, r5, r6, r7, r8, r9);
        return;
    L9:
        InCallUIAppHelper r14 = InCallUIAppHelper.INSTANCE;
        Context r2 = r11.getContext();
        Intrinsics.checkNotNullExpressionValue(r2, "context");
        r14.notifyRetryRecordASR(r2, r10.callCreateTime, r10.phoneNumber);
        r11.setVisibility(8);
        TextView r15 = r10.getStatuesHolder().getDesc();
        if (r15 == null) goto L12;
        r15.setText(R.string.asr_centent_generation);
    L12:
        View r16 = r10.getStatuesHolder().getProgress();
        if (r16 == null) goto L18;
        r16.setVisibility(0);
        return;
    }

    private static final void updateStatusView$lambda$18$lambda$17$lambda$15(OButton r3, RecordSentenceAdapter r4, DialogInterface r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "$this_apply");
        Intrinsics.checkNotNullParameter(r4, "this$0");
        InCallUIAppHelper r7 = InCallUIAppHelper.INSTANCE;
        Context r8 = r3.getContext();
        Intrinsics.checkNotNullExpressionValue(r8, "context");
        r7.notifyRetryRecordASR(r8, r4.callCreateTime, r4.phoneNumber);
        r3.setVisibility(8);
        TextView r9 = r4.getStatuesHolder().getDesc();
        if (r9 == null) goto L5;
        r9.setText(R.string.asr_centent_generation);
    L5:
        View r10 = r4.getStatuesHolder().getProgress();
        if (r10 == null) goto L10;
        r10.setVisibility(0);
        return;
    }

    private final void updateStatusHeight() {
        if (this.statuesHolder != null) goto L5;
        return;
    L5:
        if (getStatuesHolder().itemView == null) goto L14;
        View r0 = getStatuesHolder().itemView;
        Intrinsics.checkNotNullExpressionValue(r0, "statuesHolder.itemView");
        if (r0.getVisibility() != 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L15;
        getStatuesHolder().itemView.post(new RecordSentenceAdapter$$ExternalSyntheticLambda2(this));
        return;
    L15:
        return;
    L9:
        r1 = false;
        goto L10
    }

    private static final void updateStatusHeight$lambda$20(RecordSentenceAdapter r4) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        int r1 = MathKt.roundToInt(TypedValue.applyDimension(1, 536, Resources.getSystem().getDisplayMetrics())) - r4.getVisibleTopSectionHeight();
        float r0 = 196;
        if (r1 > MathKt.roundToInt(TypedValue.applyDimension(1, r0, Resources.getSystem().getDisplayMetrics()))) goto L7;
        r1 = MathKt.roundToInt(TypedValue.applyDimension(1, r0, Resources.getSystem().getDisplayMetrics()));
    L7:
        if (r4.currentStatusHeight != r1) goto L9;
        return;
    L9:
        r4.currentStatusHeight = r1;
        r4.getStatuesHolder().itemView.getLayoutParams().height = r1;
        r4.listener.updateAsrErrorViewHeight(r1);
        r4.getStatuesHolder().itemView.requestLayout();
    }

    public final void showAlertDialog(Context r7, String r8, String r9, String r10, final DialogInterface.OnClickListener r11, String r12, final DialogInterface.OnClickListener r13) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "title");
        Intrinsics.checkNotNullParameter(r9, "message");
        Intrinsics.checkNotNullParameter(r10, "positiveButtonText");
        Intrinsics.checkNotNullParameter(r11, "positiveButtonClickListener");
        Intrinsics.checkNotNullParameter(r12, "negativeButtonText");
        Intrinsics.checkNotNullParameter(r13, "negativeButtonClickListener");
        OAlertDialog r6 = OAlertDialogBuilder.positiveButton$default(OAlertDialogBuilder.negativeButton$default(new OAlertDialogBuilder(r7).autoDismiss(false).title(r8, false).message(r9), r12, new RecordSentenceAdapter$$ExternalSyntheticLambda8(r13), null, 4, null), r10, new RecordSentenceAdapter$$ExternalSyntheticLambda9(r11), null, 4, null).build();
        r6.setCancelable(true);
        r6.setOnCancelListener(new RecordSentenceAdapter$$ExternalSyntheticLambda10());
        r6.show();
    }

    private static final void showAlertDialog$lambda$21(DialogInterface.OnClickListener r1, DialogInterface r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "$negativeButtonClickListener");
        r1.onClick(r2, r3);
        r2.dismiss();
    }

    private static final void showAlertDialog$lambda$22(DialogInterface.OnClickListener r1, DialogInterface r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "$positiveButtonClickListener");
        r1.onClick(r2, r3);
        r2.dismiss();
    }

    private static final void showAlertDialog$lambda$23(DialogInterface r0) {
        r0.dismiss();
    }
}
