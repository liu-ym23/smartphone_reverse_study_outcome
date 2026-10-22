package com.stepos.ailauncher.taskstore.widget;

import Ua.C1056g;
import Ua.C1060i;
import Z8.C1173v;
import Z8.C1174w;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.widget.SweepTextView;
import com.stepos.ailauncher.taskstore.R$color;
import com.stepos.ailauncher.taskstore.R$drawable;
import com.stepos.ailauncher.taskstore.R$string;
import com.stepos.ailauncher.taskstore.TaskStoreModule;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoOption;
import com.stepos.ailauncher.taskstore.entity.TaskInfoQuestion;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import com.stepos.ailauncher.taskstore.livenotification.ArtifactExposureNotificationCanceller;
import com.stepos.ailauncher.taskstore.livenotification.C3715c;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;
import v6.C5660a;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 m2\u00020\u0001:\u0001nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\b\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0018\u0010\u0011J\u0017\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0019\u0010\u0011J\u0017\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001a\u0010\u0011J\u0017\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001b\u0010\u0011J\u0017\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001c\u0010\u0011J\u0017\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b \u0010\u0011J\u000f\u0010!\u001a\u00020\u000fH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u000fH\u0002¢\u0006\u0004\b#\u0010\"J\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b(\u0010)J'\u0010-\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020'2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b-\u0010.J\u001f\u0010/\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020*2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b/\u00100J\u001f\u00102\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u00101\u001a\u00020\nH\u0002¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b4\u0010\u0011J+\u00108\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020605H\u0002¢\u0006\u0004\b8\u00109J\u0013\u0010<\u001a\u00020;*\u00020:H\u0002¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u000fH\u0014¢\u0006\u0004\b>\u0010\"J\u000f\u0010?\u001a\u00020\u000fH\u0014¢\u0006\u0004\b?\u0010\"J\u0017\u0010A\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020;H\u0016¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u0004\u0018\u00010\n¢\u0006\u0004\bC\u0010DJ!\u0010G\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010F\u001a\u0004\u0018\u00010EH\u0016¢\u0006\u0004\bG\u0010HJ\u0017\u0010J\u001a\u00020\u000f2\b\b\u0001\u0010I\u001a\u00020\u0006¢\u0006\u0004\bJ\u0010\u001fJ\u0017\u0010J\u001a\u00020\u000f2\b\u0010L\u001a\u0004\u0018\u00010K¢\u0006\u0004\bJ\u0010MJ\u0017\u0010O\u001a\u00020\u000f2\b\u0010N\u001a\u0004\u0018\u00010\n¢\u0006\u0004\bO\u0010PJ'\u0010S\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\n2\b\u0010N\u001a\u0004\u0018\u00010\n2\u0006\u0010R\u001a\u00020;¢\u0006\u0004\bS\u0010TR\u0014\u0010V\u001a\u00020U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010XR \u0010Z\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010\\\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010`\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010d\u001a\u00020*8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bb\u0010cR\u0014\u0010h\u001a\u00020e8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bf\u0010gR\u0014\u0010l\u001a\u00020i8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bj\u0010k¨\u0006o"}, d2 = {"Lcom/stepos/ailauncher/taskstore/widget/TaskInfoCardMediumView;", "Lcom/stepos/ailauncher/taskstore/widget/c;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "taskId", "(Landroid/content/Context;Ljava/lang/String;)V", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "card", "LY8/t;", "u", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)V", "LUa/M;", "scope", "L", "(LUa/M;)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "I", "H", "G", "J", "K", "dp", "setToolcallMarginStart", "(I)V", "q", "y", "()V", "t", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoQuestion;", "question", "", "Lcom/stepos/ailauncher/taskstore/widget/j;", "B", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoQuestion;)Ljava/util/List;", "Landroid/widget/TextView;", "button", "action", "o", "(Landroid/widget/TextView;Lcom/stepos/ailauncher/taskstore/widget/j;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)V", "r", "(Landroid/widget/TextView;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)V", "label", "F", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;Ljava/lang/String;)V", ExifInterface.LONGITUDE_EAST, "", "", "answers", "v", "(Ljava/lang/String;Ljava/util/Map;)V", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "", "z", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;)Z", "onAttachedToWindow", "onDetachedFromWindow", "isVisible", "onVisibilityAggregated", "(Z)V", "getTaskId", "()Ljava/lang/String;", "Lcom/stepos/ailauncher/taskstore/widget/k;", "listener", "c", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;Lcom/stepos/ailauncher/taskstore/widget/k;)V", "res", "setDecorationImage", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/graphics/drawable/Drawable;)V", "toolName", "setToolCallName", "(Ljava/lang/String;)V", "sessionId", "isFinished", "w", "(Ljava/lang/String;Ljava/lang/String;Z)V", "Lv6/a;", "binding", "Lv6/a;", "Ljava/lang/String;", "", "answeredQuestions", "Ljava/util/Map;", "answeredQuestionsOwnerTaskId", "ioScope", "LUa/M;", "Lcom/stepos/ailauncher/taskstore/livenotification/c;", "exposureTimer", "Lcom/stepos/ailauncher/taskstore/livenotification/c;", "getTitleView", "()Landroid/widget/TextView;", "titleView", "Lcom/stepos/ailauncher/common/widget/SweepTextView;", "getSubtitleView", "()Lcom/stepos/ailauncher/common/widget/SweepTextView;", "subtitleView", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "iconView", "Companion", Const.INTENT_KEY_APIKEY, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskInfoCardMediumView extends AbstractC3737c {
    private static final int MAX_ACTION_LABEL_LEN = 15;
    private static final int MAX_VISIBLE_ACTIONS = 3;
    private static final String TAG = "TaskInfoCardMediumView";
    private static final int TOOLCALL_MARGIN_START_DP = 10;
    private static final long TWO_MINUTES_MS = 120000;
    private final Map<String, String> answeredQuestions;
    private String answeredQuestionsOwnerTaskId;
    private final C5660a binding;
    private final C3715c exposureTimer;
    private Ua.M ioScope;
    private String taskId;
    private static final Set<TaskInfoStatus> RUNNING_STATUSES = Z8.Y.j(TaskInfoStatus.RUNNING, TaskInfoStatus.IN_PROGRESS, TaskInfoStatus.PLANNING);
    private static final Set<TaskInfoStatus> WAITING_STATUSES = Z8.Y.j(TaskInfoStatus.WAITING, TaskInfoStatus.PENDING, TaskInfoStatus.PAUSED);

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TaskInfoStatus.values().length];
            try {
                iArr[TaskInfoStatus.FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TaskInfoStatus.COMPLETED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TaskInfoStatus.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TaskInfoStatus.IN_PROGRESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[MediumActionStyle.values().length];
            try {
                iArr2[MediumActionStyle.PRIMARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[MediumActionStyle.SECONDARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[MediumActionStyle.OPTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskInfoCardMediumView(final Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        C5660a c5660aB = C5660a.b(LayoutInflater.from(context), this, true);
        kotlin.jvm.internal.p.h(c5660aB, "inflate(...)");
        this.binding = c5660aB;
        this.answeredQuestions = new LinkedHashMap();
        this.exposureTimer = new C3715c(this, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.widget.l
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskInfoCardMediumView.x(this.f29381a, context, (String) obj);
            }
        });
        c5660aB.btnMediumCardAction.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.taskstore.widget.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskInfoCardMediumView.m(this.f29384a, view);
            }
        });
        setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.taskstore.widget.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskInfoCardMediumView.n(this.f29386a, view);
            }
        });
    }

    public static final String C(TaskInfoOption it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getLabel();
    }

    public static final boolean D(String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return !La.H.x0(it);
    }

    public static final void m(TaskInfoCardMediumView taskInfoCardMediumView, View view) {
        taskInfoCardMediumView.u(taskInfoCardMediumView.getBoundCard());
    }

    public static final void n(TaskInfoCardMediumView taskInfoCardMediumView, View view) {
        taskInfoCardMediumView.u(taskInfoCardMediumView.getBoundCard());
    }

    public static final void p(TaskInfoCardMediumView taskInfoCardMediumView, TaskInfoCard taskInfoCard, MediumActionItem mediumActionItem, View view) {
        taskInfoCardMediumView.F(taskInfoCard, mediumActionItem.getLabel());
    }

    public static final void s(TaskInfoCardMediumView taskInfoCardMediumView, TaskInfoCard taskInfoCard, View view) {
        taskInfoCardMediumView.u(taskInfoCard);
    }

    private final void setToolcallMarginStart(int dp) {
        int i10;
        ViewGroup.LayoutParams layoutParams = this.binding.tvMediumCardToolcallName.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null || layoutParams2.getMarginStart() == (i10 = (int) (dp * getResources().getDisplayMetrics().density))) {
            return;
        }
        layoutParams2.setMarginStart(i10);
        this.binding.tvMediumCardToolcallName.setLayoutParams(layoutParams2);
    }

    public static final Y8.t x(TaskInfoCardMediumView taskInfoCardMediumView, Context context, String exposedTaskId) {
        kotlin.jvm.internal.p.i(exposedTaskId, "exposedTaskId");
        TaskInfoCard boundCard = taskInfoCardMediumView.getBoundCard();
        if ((boundCard != null ? boundCard.getStatus() : null) == TaskInfoStatus.FAILED) {
            com.stepos.ailauncher.taskstore.livenotification.A a10 = com.stepos.ailauncher.taskstore.livenotification.A.INSTANCE;
            String requestSessionKey = boundCard.getRequestSessionKey();
            if (requestSessionKey == null) {
                requestSessionKey = boundCard.getSessionKey();
            }
            a10.h(context, requestSessionKey, exposedTaskId);
        } else {
            ArtifactExposureNotificationCanceller.INSTANCE.b(context, exposedTaskId, "TaskInfoCardMediumView");
        }
        return Y8.t.f7040a;
    }

    public final TaskInfoCard A(String taskId) {
        return (TaskInfoCard) C1056g.h(Ua.Y.b(), new TaskInfoCardMediumView$loadCard$1(taskId, null));
    }

    public final List<MediumActionItem> B(TaskInfoQuestion question) {
        List listD0 = SequencesKt___SequencesKt.d0(SequencesKt___SequencesKt.F(SequencesKt___SequencesKt.R(Z8.F.d0(question.getOptions()), new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.widget.q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskInfoCardMediumView.C((TaskInfoOption) obj);
            }
        }), new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.widget.r
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TaskInfoCardMediumView.D((String) obj));
            }
        }));
        if (listD0.isEmpty()) {
            return C1173v.m();
        }
        int iO = C1173v.o(listD0);
        List list = listD0;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            arrayList.add(new MediumActionItem((String) obj, listD0.size() >= 3 ? MediumActionStyle.OPTION : listD0.size() == 2 ? i10 == iO ? MediumActionStyle.PRIMARY : MediumActionStyle.SECONDARY : MediumActionStyle.PRIMARY));
            i10 = i11;
        }
        return arrayList;
    }

    public final void E(TaskInfoCard card) {
        Set setE;
        if (this.answeredQuestions.isEmpty()) {
            return;
        }
        List<TaskInfoQuestion> pendingQuestions = card.getPendingQuestions();
        if (pendingQuestions != null) {
            setE = new HashSet();
            Iterator<T> it = pendingQuestions.iterator();
            while (it.hasNext()) {
                setE.add(((TaskInfoQuestion) it.next()).getQuestion());
            }
        } else {
            setE = null;
        }
        if (setE == null) {
            setE = Z8.Y.e();
        }
        this.answeredQuestions.keySet().retainAll(setE);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00e2 A[LOOP:1: B:38:0x00dc->B:40:0x00e2, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F(com.stepos.ailauncher.taskstore.entity.TaskInfoCard r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.widget.TaskInfoCardMediumView.F(com.stepos.ailauncher.taskstore.entity.TaskInfoCard, java.lang.String):void");
    }

    public final void G(TaskInfoCard card) {
        e(getContext().getString(R$string.taskstore_medium_subtitle_completed_default), androidx.core.content.a.c(getContext(), R$color.taskstore_card_status_success));
        SweepTextView tvMediumCardSubtitle = this.binding.tvMediumCardSubtitle;
        kotlin.jvm.internal.p.h(tvMediumCardSubtitle, "tvMediumCardSubtitle");
        SweepTextView.setSweepActive$default(tvMediumCardSubtitle, false, 0, 2, null);
        Integer numM = TaskMediumCardDecorationResolver.INSTANCE.m(card);
        this.binding.ivMediumCardDecoration.setImageResource(numM != null ? numM.intValue() : R$drawable.ic_taskstore_artifact_glyph_none);
        this.binding.layoutMediumCardVisual.setVisibility(0);
        this.binding.ivMediumCardDecoration.setVisibility(0);
        this.binding.layoutMediumCardActionRow.setVisibility(8);
        J(card);
    }

    public final void H(TaskInfoCard card) {
        e(getContext().getString(R$string.taskstore_medium_subtitle_failed_default), androidx.core.content.a.c(getContext(), R$color.taskstore_card_status_failed));
        SweepTextView tvMediumCardSubtitle = this.binding.tvMediumCardSubtitle;
        kotlin.jvm.internal.p.h(tvMediumCardSubtitle, "tvMediumCardSubtitle");
        SweepTextView.setSweepActive$default(tvMediumCardSubtitle, false, 0, 2, null);
        this.binding.btnMediumCardAction.setText(R$string.taskstore_medium_action_view_detail);
        this.binding.layoutMediumCardVisual.setVisibility(8);
        this.binding.ivMediumCardDecoration.setVisibility(8);
        this.binding.layoutMediumCardActionRow.setVisibility(0);
        K(card);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void I(com.stepos.ailauncher.taskstore.entity.TaskInfoCard r5) {
        /*
            r4 = this;
            v6.a r0 = r4.binding
            android.widget.ImageView r0 = r0.ivMediumCardDecoration
            int r1 = com.stepos.ailauncher.taskstore.R$drawable.ic_taskstore_task_card_decoration_loading
            r0.setImageResource(r1)
            v6.a r0 = r4.binding
            android.widget.FrameLayout r0 = r0.layoutMediumCardVisual
            r1 = 0
            r0.setVisibility(r1)
            v6.a r0 = r4.binding
            android.widget.ImageView r0 = r0.ivMediumCardDecoration
            r0.setVisibility(r1)
            v6.a r0 = r4.binding
            android.widget.LinearLayout r0 = r0.layoutMediumCardActionRow
            r1 = 8
            r0.setVisibility(r1)
            com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r0 = r5.getStatus()
            java.util.Set<com.stepos.ailauncher.taskstore.entity.TaskInfoStatus> r1 = com.stepos.ailauncher.taskstore.widget.TaskInfoCardMediumView.RUNNING_STATUSES
            boolean r1 = r1.contains(r0)
            if (r1 == 0) goto L30
            int r0 = com.stepos.ailauncher.taskstore.R$color.taskstore_card_status_running
            goto L3d
        L30:
            java.util.Set<com.stepos.ailauncher.taskstore.entity.TaskInfoStatus> r1 = com.stepos.ailauncher.taskstore.widget.TaskInfoCardMediumView.WAITING_STATUSES
            boolean r0 = r1.contains(r0)
            if (r0 == 0) goto L3b
            int r0 = com.stepos.ailauncher.taskstore.R$color.taskstore_card_status_waiting
            goto L3d
        L3b:
            int r0 = com.stepos.ailauncher.taskstore.R$color.taskstore_card_medium_subtitle
        L3d:
            v6.a r1 = r4.binding
            com.stepos.ailauncher.common.widget.SweepTextView r1 = r1.tvMediumCardSubtitle
            com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r2 = r5.getStatus()
            boolean r2 = r4.z(r2)
            android.content.Context r3 = r4.getContext()
            int r0 = androidx.core.content.a.c(r3, r0)
            r1.setSweepActive(r2, r0)
            com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r0 = r5.getStatus()
            com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r1 = com.stepos.ailauncher.taskstore.entity.TaskInfoStatus.WAITING
            if (r0 != r1) goto L94
            java.lang.String r0 = r5.getSummary()
            r1 = 0
            if (r0 == 0) goto L6d
            boolean r2 = La.H.x0(r0)
            if (r2 != 0) goto L6a
            goto L6b
        L6a:
            r0 = r1
        L6b:
            if (r0 != 0) goto L8d
        L6d:
            java.lang.String r5 = r5.getSubTitle()
            if (r5 == 0) goto L7a
            boolean r0 = La.H.x0(r5)
            if (r0 != 0) goto L7a
            r1 = r5
        L7a:
            if (r1 != 0) goto L8c
            android.content.Context r5 = r4.getContext()
            int r0 = com.stepos.ailauncher.taskstore.R$string.taskstore_medium_subtitle_waiting_default
            java.lang.String r0 = r5.getString(r0)
            java.lang.String r5 = "getString(...)"
            kotlin.jvm.internal.p.h(r0, r5)
            goto L8d
        L8c:
            r0 = r1
        L8d:
            v6.a r4 = r4.binding
            com.stepos.ailauncher.common.widget.SweepTextView r4 = r4.tvMediumCardSubtitle
            r4.setText(r0)
        L94:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.widget.TaskInfoCardMediumView.I(com.stepos.ailauncher.taskstore.entity.TaskInfoCard):void");
    }

    public final void J(TaskInfoCard card) {
        String summary = card.getSummary();
        if (summary == null || La.H.x0(summary)) {
            summary = null;
        }
        if (summary == null) {
            this.binding.tvMediumCardToolcallName.setText("");
            this.binding.tvMediumCardToolcallName.setVisibility(8);
        } else {
            setToolcallMarginStart(0);
            this.binding.tvMediumCardToolcallName.setText(getContext().getString(R$string.taskstore_medium_completed_summary, summary));
            this.binding.tvMediumCardToolcallName.setVisibility(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void K(com.stepos.ailauncher.taskstore.entity.TaskInfoCard r5) {
        /*
            r4 = this;
            java.lang.String r0 = r5.getSummary()
            r1 = 0
            if (r0 == 0) goto L14
            boolean r2 = La.H.x0(r0)
            if (r2 != 0) goto Le
            goto Lf
        Le:
            r0 = r1
        Lf:
            if (r0 != 0) goto L12
            goto L14
        L12:
            r1 = r0
            goto L27
        L14:
            com.stepos.ailauncher.taskstore.entity.TaskInfoAnswer r5 = r5.getAnswer()
            if (r5 == 0) goto L27
            java.lang.String r5 = r5.getError()
            if (r5 == 0) goto L27
            boolean r0 = La.H.x0(r5)
            if (r0 != 0) goto L27
            r1 = r5
        L27:
            if (r1 != 0) goto L3c
            v6.a r5 = r4.binding
            android.widget.TextView r5 = r5.tvMediumCardToolcallName
            java.lang.String r0 = ""
            r5.setText(r0)
            v6.a r4 = r4.binding
            android.widget.TextView r4 = r4.tvMediumCardToolcallName
            r5 = 8
            r4.setVisibility(r5)
            return
        L3c:
            r5 = 0
            r4.setToolcallMarginStart(r5)
            v6.a r0 = r4.binding
            android.widget.TextView r0 = r0.tvMediumCardToolcallName
            android.content.Context r2 = r4.getContext()
            int r3 = com.stepos.ailauncher.taskstore.R$string.taskstore_medium_failed_summary
            java.lang.Object[] r1 = new java.lang.Object[]{r1}
            java.lang.String r1 = r2.getString(r3, r1)
            r0.setText(r1)
            v6.a r4 = r4.binding
            android.widget.TextView r4 = r4.tvMediumCardToolcallName
            r4.setVisibility(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.widget.TaskInfoCardMediumView.K(com.stepos.ailauncher.taskstore.entity.TaskInfoCard):void");
    }

    public final void L(Ua.M scope) {
        String str = this.taskId;
        if (str == null) {
            return;
        }
        try {
            C1060i.d(scope, null, null, new TaskInfoCardMediumView$startObservingCard$1(TaskStoreModule.INSTANCE.n(), str, this, null), 3, null);
        } catch (IllegalStateException e10) {
            Log.w("TaskInfoCardMediumView", "TaskStoreModule not initialized, skip observing taskId=" + str, e10);
        }
    }

    @Override // com.stepos.ailauncher.taskstore.widget.AbstractC3737c
    public void c(TaskInfoCard card, InterfaceC3745k listener) {
        kotlin.jvm.internal.p.i(card, "card");
        super.c(card, listener);
        setIcon(TaskMediumCardDecorationResolver.INSTANCE.s(card));
        this.binding.tvMediumCardToolcallName.setVisibility(8);
        this.binding.tvMediumCardToolcallName.setText("");
        if (kotlin.jvm.internal.p.d(this.answeredQuestionsOwnerTaskId, card.getTaskId())) {
            E(card);
        } else {
            this.answeredQuestions.clear();
            this.answeredQuestionsOwnerTaskId = card.getTaskId();
        }
        TaskInfoStatus status = card.getStatus();
        int[] iArr = b.$EnumSwitchMapping$0;
        int i10 = iArr[status.ordinal()];
        if (i10 == 1) {
            H(card);
        } else if (i10 != 2) {
            I(card);
        } else {
            G(card);
        }
        q(card);
        if (iArr[card.getStatus().ordinal()] == 1) {
            this.exposureTimer.b(card.getTaskId());
        } else {
            this.exposureTimer.b(null);
        }
    }

    @Override // com.stepos.ailauncher.taskstore.widget.AbstractC3737c
    public ImageView getIconView() {
        ImageView ivMediumCardIcon = this.binding.ivMediumCardIcon;
        kotlin.jvm.internal.p.h(ivMediumCardIcon, "ivMediumCardIcon");
        return ivMediumCardIcon;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    @Override // com.stepos.ailauncher.taskstore.widget.AbstractC3737c
    public TextView getTitleView() {
        TextView tvMediumCardTitle = this.binding.tvMediumCardTitle;
        kotlin.jvm.internal.p.h(tvMediumCardTitle, "tvMediumCardTitle");
        return tvMediumCardTitle;
    }

    public final void o(TextView button, final MediumActionItem action, final TaskInfoCard card) {
        Pair pairA;
        button.setText(action.getLabel());
        int i10 = b.$EnumSwitchMapping$1[action.getStyle().ordinal()];
        if (i10 == 1) {
            pairA = Y8.j.a(Integer.valueOf(R$drawable.bg_taskstore_action_pill_primary), -16777216);
        } else if (i10 == 2) {
            pairA = Y8.j.a(Integer.valueOf(R$drawable.bg_taskstore_action_pill_secondary), -1711276033);
        } else {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            pairA = Y8.j.a(Integer.valueOf(R$drawable.bg_taskstore_action_pill_secondary), -419430401);
        }
        int iIntValue = ((Number) pairA.a()).intValue();
        int iIntValue2 = ((Number) pairA.b()).intValue();
        button.setBackgroundResource(iIntValue);
        button.setTextColor(iIntValue2);
        button.setTypeface(Typeface.DEFAULT, action.getStyle() == MediumActionStyle.PRIMARY ? 1 : 0);
        button.setClickable(true);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.taskstore.widget.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskInfoCardMediumView.p(this.f29388a, card, action, view);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null && layoutParams.width != -1) {
            layoutParams.width = -1;
            setLayoutParams(layoutParams);
        }
        if (this.ioScope == null) {
            Ua.M mB = kotlinx.coroutines.d.b();
            this.ioScope = mB;
            L(mB);
        }
        this.exposureTimer.e(isShown());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.exposureTimer.g();
        Ua.M m10 = this.ioScope;
        if (m10 != null) {
            kotlinx.coroutines.d.e(m10, null, 1, null);
        }
        this.ioScope = null;
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean isVisible) {
        super.onVisibilityAggregated(isVisible);
        this.exposureTimer.e(isVisible);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void q(TaskInfoCard card) {
        List<TaskInfoQuestion> pendingQuestions;
        TaskInfoQuestion taskInfoQuestion = null;
        if (card.getStatus() == TaskInfoStatus.WAITING && (pendingQuestions = card.getPendingQuestions()) != null) {
            Iterator<T> it = pendingQuestions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                TaskInfoQuestion taskInfoQuestion2 = (TaskInfoQuestion) next;
                if (!La.H.x0(taskInfoQuestion2.getQuestion()) && !taskInfoQuestion2.getOptions().isEmpty() && !this.answeredQuestions.keySet().contains(taskInfoQuestion2.getQuestion()) && !card.getAnsweredQuestionTexts().contains(taskInfoQuestion2.getQuestion())) {
                    taskInfoQuestion = next;
                    break;
                }
            }
            taskInfoQuestion = taskInfoQuestion;
        }
        if (taskInfoQuestion == null) {
            y();
            return;
        }
        List<MediumActionItem> listB = B(taskInfoQuestion);
        if (listB.isEmpty()) {
            y();
            return;
        }
        this.binding.layoutMediumCardActionRow.setVisibility(8);
        this.binding.layoutMediumCardVisual.setVisibility(0);
        this.binding.ivMediumCardDecoration.setVisibility(0);
        this.binding.layoutMediumCardActions.setVisibility(0);
        this.binding.layoutMediumCardActionSingle.setVisibility(8);
        this.binding.layoutMediumCardActionDouble.setVisibility(8);
        this.binding.layoutMediumCardActionTriple.setVisibility(8);
        if (listB.size() <= 3) {
            List<MediumActionItem> list = listB;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    if (((MediumActionItem) it2.next()).getLabel().length() > 15) {
                    }
                }
            }
            int size = listB.size();
            if (size == 1) {
                this.binding.layoutMediumCardActionSingle.setVisibility(0);
                TextView btnMediumCardActionSingle = this.binding.btnMediumCardActionSingle;
                kotlin.jvm.internal.p.h(btnMediumCardActionSingle, "btnMediumCardActionSingle");
                o(btnMediumCardActionSingle, listB.get(0), card);
                return;
            }
            if (size == 2) {
                this.binding.layoutMediumCardActionDouble.setVisibility(0);
                TextView btnMediumCardActionDoublePrimary = this.binding.btnMediumCardActionDoublePrimary;
                kotlin.jvm.internal.p.h(btnMediumCardActionDoublePrimary, "btnMediumCardActionDoublePrimary");
                o(btnMediumCardActionDoublePrimary, listB.get(0), card);
                TextView btnMediumCardActionDoubleSecondary = this.binding.btnMediumCardActionDoubleSecondary;
                kotlin.jvm.internal.p.h(btnMediumCardActionDoubleSecondary, "btnMediumCardActionDoubleSecondary");
                o(btnMediumCardActionDoubleSecondary, listB.get(1), card);
                return;
            }
            this.binding.layoutMediumCardActionTriple.setVisibility(0);
            TextView btnMediumCardActionTriplePrimary = this.binding.btnMediumCardActionTriplePrimary;
            kotlin.jvm.internal.p.h(btnMediumCardActionTriplePrimary, "btnMediumCardActionTriplePrimary");
            o(btnMediumCardActionTriplePrimary, listB.get(0), card);
            TextView btnMediumCardActionTripleSecondary = this.binding.btnMediumCardActionTripleSecondary;
            kotlin.jvm.internal.p.h(btnMediumCardActionTripleSecondary, "btnMediumCardActionTripleSecondary");
            o(btnMediumCardActionTripleSecondary, listB.get(1), card);
            TextView btnMediumCardActionTripleTertiary = this.binding.btnMediumCardActionTripleTertiary;
            kotlin.jvm.internal.p.h(btnMediumCardActionTripleTertiary, "btnMediumCardActionTripleTertiary");
            o(btnMediumCardActionTripleTertiary, listB.get(2), card);
            return;
        }
        this.binding.layoutMediumCardActionSingle.setVisibility(0);
        TextView btnMediumCardActionSingle2 = this.binding.btnMediumCardActionSingle;
        kotlin.jvm.internal.p.h(btnMediumCardActionSingle2, "btnMediumCardActionSingle");
        r(btnMediumCardActionSingle2, card);
    }

    public final void r(TextView button, final TaskInfoCard card) {
        button.setText(button.getContext().getString(R$string.taskstore_medium_action_view_detail));
        button.setBackgroundResource(R$drawable.bg_taskstore_action_pill_primary);
        button.setTextColor(-16777216);
        button.setTypeface(Typeface.DEFAULT, 1);
        button.setClickable(true);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.taskstore.widget.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskInfoCardMediumView.s(this.f29392a, card, view);
            }
        });
    }

    public final void setDecorationImage(int res) {
        this.binding.ivMediumCardDecoration.setImageResource(res);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setToolCallName(java.lang.String r4) {
        /*
            r3 = this;
            com.stepos.ailauncher.taskstore.entity.TaskInfoCard r0 = r3.getBoundCard()
            r1 = 0
            if (r0 == 0) goto L15
            com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r0 = r0.getStatus()
            if (r0 == 0) goto L15
            boolean r0 = r0.isTerminal()
            r2 = 1
            if (r0 != r2) goto L15
            goto L16
        L15:
            r2 = r1
        L16:
            if (r4 == 0) goto L35
            boolean r0 = La.H.x0(r4)
            if (r0 == 0) goto L1f
            goto L35
        L1f:
            if (r2 != 0) goto L35
            r0 = 10
            r3.setToolcallMarginStart(r0)
            v6.a r0 = r3.binding
            android.widget.TextView r0 = r0.tvMediumCardToolcallName
            r0.setText(r4)
            v6.a r3 = r3.binding
            android.widget.TextView r3 = r3.tvMediumCardToolcallName
            r3.setVisibility(r1)
            return
        L35:
            v6.a r4 = r3.binding
            android.widget.TextView r4 = r4.tvMediumCardToolcallName
            java.lang.String r0 = ""
            r4.setText(r0)
            v6.a r3 = r3.binding
            android.widget.TextView r3 = r3.tvMediumCardToolcallName
            r4 = 8
            r3.setVisibility(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.widget.TaskInfoCardMediumView.setToolCallName(java.lang.String):void");
    }

    public final void t() {
        this.binding.btnMediumCardActionSingle.setOnClickListener(null);
        this.binding.btnMediumCardActionDoublePrimary.setOnClickListener(null);
        this.binding.btnMediumCardActionDoubleSecondary.setOnClickListener(null);
        this.binding.btnMediumCardActionTriplePrimary.setOnClickListener(null);
        this.binding.btnMediumCardActionTripleSecondary.setOnClickListener(null);
        this.binding.btnMediumCardActionTripleTertiary.setOnClickListener(null);
    }

    public final void u(TaskInfoCard card) {
        if (card == null) {
            InterfaceC3745k actionListener = getActionListener();
            if (actionListener != null) {
                actionListener.a(null);
                return;
            }
            return;
        }
        if (card.getStatus() == TaskInfoStatus.FAILED) {
            com.stepos.ailauncher.taskstore.livenotification.A a10 = com.stepos.ailauncher.taskstore.livenotification.A.INSTANCE;
            Context context = getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            String requestSessionKey = card.getRequestSessionKey();
            if (requestSessionKey == null) {
                requestSessionKey = card.getSessionKey();
            }
            a10.h(context, requestSessionKey, card.getTaskId());
        } else if (card.getStatus() == TaskInfoStatus.COMPLETED) {
            com.stepos.ailauncher.taskstore.livenotification.A a11 = com.stepos.ailauncher.taskstore.livenotification.A.INSTANCE;
            Context context2 = getContext();
            kotlin.jvm.internal.p.h(context2, "getContext(...)");
            a11.a(context2, card.getTaskId());
        }
        InterfaceC3745k actionListener2 = getActionListener();
        if (actionListener2 != null) {
            actionListener2.a(card);
        }
    }

    public final void v(String taskId, Map<String, ? extends Object> answers) {
        Ua.M m10 = this.ioScope;
        if (m10 != null) {
            C1060i.d(m10, Ua.Y.b(), null, new TaskInfoCardMediumView$dispatchInteractTask$1(taskId, answers, null), 2, null);
            return;
        }
        C4148a.s("TaskInfoCardMediumView", "dispatchInteractTask: ioScope==null taskId=" + taskId + " answers=" + answers, true);
    }

    public final void w(String sessionId, String toolName, boolean isFinished) {
        TaskInfoCard boundCard;
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (La.H.x0(sessionId) || (boundCard = getBoundCard()) == null) {
            return;
        }
        if (kotlin.jvm.internal.p.d(boundCard.getSessionKey(), sessionId) || kotlin.jvm.internal.p.d(boundCard.getRequestSessionKey(), sessionId)) {
            if (boundCard.getStatus() == TaskInfoStatus.COMPLETED) {
                J(boundCard);
            } else if (boundCard.getStatus() == TaskInfoStatus.FAILED) {
                K(boundCard);
            } else {
                setToolCallName(boundCard.getStatus().isTerminal() ? null : X.INSTANCE.a(toolName));
            }
        }
    }

    public final void y() {
        this.binding.layoutMediumCardActions.setVisibility(8);
        this.binding.layoutMediumCardActionSingle.setVisibility(8);
        this.binding.layoutMediumCardActionDouble.setVisibility(8);
        this.binding.layoutMediumCardActionTriple.setVisibility(8);
        t();
    }

    public final boolean z(TaskInfoStatus taskInfoStatus) {
        int i10 = b.$EnumSwitchMapping$0[taskInfoStatus.ordinal()];
        return i10 == 3 || i10 == 4;
    }

    @Override // com.stepos.ailauncher.taskstore.widget.AbstractC3737c
    public SweepTextView getSubtitleView() {
        SweepTextView tvMediumCardSubtitle = this.binding.tvMediumCardSubtitle;
        kotlin.jvm.internal.p.h(tvMediumCardSubtitle, "tvMediumCardSubtitle");
        return tvMediumCardSubtitle;
    }

    public final void setDecorationImage(Drawable drawable) {
        this.binding.ivMediumCardDecoration.setImageDrawable(drawable);
    }

    public /* synthetic */ TaskInfoCardMediumView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TaskInfoCardMediumView(Context context, String taskId) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(taskId, "taskId");
        this.taskId = taskId;
        TaskInfoCard taskInfoCardA = A(taskId);
        if (taskInfoCardA != null) {
            AbstractC3737c.d(this, taskInfoCardA, null, 2, null);
            return;
        }
        Log.w("TaskInfoCardMediumView", "card not found for taskId=" + taskId);
    }
}
