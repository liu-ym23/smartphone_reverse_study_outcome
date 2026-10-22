package com.stepos.ailauncher.taskstore.widget;

import Ua.C1060i;
import Ua.L0;
import Z8.C1173v;
import Z8.C1174w;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.contract.model.ArtifactAvailability;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.taskstore.R$dimen;
import com.stepos.ailauncher.taskstore.R$id;
import com.stepos.ailauncher.taskstore.R$layout;
import com.stepos.ailauncher.taskstore.chat.TaskResultCodeItem;
import com.stepos.ailauncher.taskstore.chat.TaskResultCodePayload;
import com.stepos.ailauncher.taskstore.livenotification.ArtifactExposureNotificationCanceller;
import com.stepos.ailauncher.taskstore.livenotification.C3715c;
import com.stepos.ame.sdk.SkillStoreKt;
import h8.C4148a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import u6.C5579b;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 K2\u00020\u0001:\u0001LB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\u000f\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0017\u0010\u0012J\u000f\u0010\u0018\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0018\u0010\u0012J\u000f\u0010\u0019\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0019\u0010\u0012J3\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010$\u001a\u00020\u000e2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002¢\u0006\u0004\b$\u0010%J\u001f\u0010)\u001a\u00020(2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\"H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\"H\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u000bH\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u001dH\u0002¢\u0006\u0004\b1\u00102J\u001f\u00104\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\"2\u0006\u00103\u001a\u00020\u000bH\u0002¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u000eH\u0002¢\u0006\u0004\b6\u0010\u0012R\u0018\u00107\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u00109R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u00109R\u0016\u0010:\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R$\u0010C\u001a\u0012\u0012\u0004\u0012\u00020\u000b0Aj\b\u0012\u0004\u0012\u00020\u000b`B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010F\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000e0H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006M"}, d2 = {"Lcom/stepos/ailauncher/taskstore/widget/TaskResultCodeView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/stepos/ailauncher/taskstore/chat/F;", "data", "", "", "expiredFileIds", "blockedFileIds", "LY8/t;", "s", "(Lcom/stepos/ailauncher/taskstore/chat/F;Ljava/util/Set;Ljava/util/Set;)V", "onAttachedToWindow", "()V", "", "isVisible", "onVisibilityAggregated", "(Z)V", "onDetachedFromWindow", ExifInterface.LONGITUDE_EAST, "o", "", "Lcom/stepos/ailauncher/contract/model/ArtifactAvailability;", C3081a.FOCUS_MAP_NAME, "", "gen", "n", "(Lcom/stepos/ailauncher/taskstore/chat/F;Ljava/util/Map;I)V", "", "Lcom/stepos/ailauncher/taskstore/chat/E;", "artifacts", "H", "(Ljava/util/List;)V", "raw", "item", "", "w", "(Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/chat/E;)Ljava/lang/CharSequence;", "x", "(Lcom/stepos/ailauncher/taskstore/chat/E;)Ljava/lang/String;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "y", "(Ljava/lang/String;)Z", "viewFullRowPx", "D", "(I)I", "from", "C", "(Lcom/stepos/ailauncher/taskstore/chat/E;Ljava/lang/String;)V", "L", "payload", "Lcom/stepos/ailauncher/taskstore/chat/F;", "Ljava/util/Set;", "availabilityGeneration", "I", "skipAvailabilityQuery", "Z", "Lcom/stepos/ailauncher/taskstore/livenotification/c;", "exposureTimer", "Lcom/stepos/ailauncher/taskstore/livenotification/c;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "exposedFileIds", "Ljava/util/HashSet;", "LUa/M;", "trackScope", "LUa/M;", "Lkotlin/Function0;", "availabilityChangedListener", "Lp9/a;", "Companion", Const.INTENT_KEY_APIKEY, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskResultCodeView extends LinearLayout {
    private static final String TAG = "TaskResultCodeView";
    private final InterfaceC5063a<Y8.t> availabilityChangedListener;
    private int availabilityGeneration;
    private Set<String> blockedFileIds;
    private Set<String> expiredFileIds;
    private final HashSet<String> exposedFileIds;
    private final C3715c exposureTimer;
    private TaskResultCodePayload payload;
    private boolean skipAvailabilityQuery;
    private Ua.M trackScope;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskResultCodeView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        this.expiredFileIds = Z8.Y.e();
        this.blockedFileIds = Z8.Y.e();
        this.exposureTimer = new C3715c(this, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.widget.B
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskResultCodeView.z(context, this, (String) obj);
            }
        });
        this.exposedFileIds = new HashSet<>();
        this.availabilityChangedListener = new InterfaceC5063a() { // from class: com.stepos.ailauncher.taskstore.widget.C
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return TaskResultCodeView.r(this.f29298a);
            }
        };
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    }

    public static final void A(TaskResultCodeView taskResultCodeView) {
        taskResultCodeView.E();
    }

    public static final void B(TaskResultCodeView taskResultCodeView) {
        taskResultCodeView.E();
    }

    public static final Y8.t F(final TaskResultCodeView taskResultCodeView, final TaskResultCodePayload taskResultCodePayload, final int i10, final Map map) {
        kotlin.jvm.internal.p.i(map, "map");
        taskResultCodeView.post(new Runnable() { // from class: com.stepos.ailauncher.taskstore.widget.t
            @Override // java.lang.Runnable
            public final void run() {
                TaskResultCodeView.G(this.f29401a, taskResultCodePayload, map, i10);
            }
        });
        return Y8.t.f7040a;
    }

    public static final void G(TaskResultCodeView taskResultCodeView, TaskResultCodePayload taskResultCodePayload, Map map, int i10) {
        taskResultCodeView.n(taskResultCodePayload, map, i10);
    }

    public static final void I(TaskResultCodeView taskResultCodeView, TaskResultCodeItem taskResultCodeItem, View view) {
        taskResultCodeView.C(taskResultCodeItem, "viewFull");
    }

    public static final void J(TaskResultCodeView taskResultCodeView, TaskResultCodeItem taskResultCodeItem, View view) {
        taskResultCodeView.C(taskResultCodeItem, SkillStoreKt.SKILL_DOC_TYPE_CONTENT);
    }

    public static final void K(TaskResultCodeView taskResultCodeView, TaskResultCodeItem taskResultCodeItem, View view) {
        taskResultCodeView.C(taskResultCodeItem, "header");
    }

    public static final Y8.t p(final TaskResultCodeView taskResultCodeView, final TaskResultCodePayload taskResultCodePayload, final int i10, final Map map) {
        kotlin.jvm.internal.p.i(map, "map");
        taskResultCodeView.post(new Runnable() { // from class: com.stepos.ailauncher.taskstore.widget.x
            @Override // java.lang.Runnable
            public final void run() {
                TaskResultCodeView.q(this.f29422a, taskResultCodePayload, map, i10);
            }
        });
        return Y8.t.f7040a;
    }

    public static final void q(TaskResultCodeView taskResultCodeView, TaskResultCodePayload taskResultCodePayload, Map map, int i10) {
        taskResultCodeView.n(taskResultCodePayload, map, i10);
    }

    public static final Y8.t r(TaskResultCodeView taskResultCodeView) {
        taskResultCodeView.o();
        return Y8.t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void t(TaskResultCodeView taskResultCodeView, TaskResultCodePayload taskResultCodePayload, Set set, Set set2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            set = Z8.Y.e();
        }
        if ((i10 & 4) != 0) {
            set2 = Z8.Y.e();
        }
        taskResultCodeView.s(taskResultCodePayload, set, set2);
    }

    public static final Y8.t u(final TaskResultCodeView taskResultCodeView, final int i10, final Map map) {
        kotlin.jvm.internal.p.i(map, "map");
        taskResultCodeView.post(new Runnable() { // from class: com.stepos.ailauncher.taskstore.widget.D
            @Override // java.lang.Runnable
            public final void run() {
                TaskResultCodeView.v(this.f29299a, map, i10);
            }
        });
        return Y8.t.f7040a;
    }

    public static final void v(TaskResultCodeView taskResultCodeView, Map map, int i10) {
        TaskResultCodePayload taskResultCodePayload = taskResultCodeView.payload;
        if (taskResultCodePayload == null) {
            return;
        }
        taskResultCodeView.n(taskResultCodePayload, map, i10);
    }

    public static final Y8.t z(Context context, TaskResultCodeView taskResultCodeView, String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        ArtifactExposureNotificationCanceller.INSTANCE.b(context, taskId, TAG);
        taskResultCodeView.L();
        return Y8.t.f7040a;
    }

    public final void C(TaskResultCodeItem item, String from) {
        if (La.H.x0(item.getFileId())) {
            return;
        }
        if (this.expiredFileIds.contains(item.getFileId())) {
            C5579b c5579b = C5579b.INSTANCE;
            Context context = getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            c5579b.c(context);
            return;
        }
        Context context2 = getContext();
        kotlin.jvm.internal.p.h(context2, "getContext(...)");
        String strB = C3738d.b(context2);
        String str = strB.length() > 0 ? strB : null;
        String fileId = item.getFileId();
        TaskResultCodePayload taskResultCodePayload = this.payload;
        String taskId = taskResultCodePayload != null ? taskResultCodePayload.getTaskId() : null;
        C4148a.k(TAG, "code card click from=" + from + " fileId=" + fileId + " sessionId=" + str + " taskId=" + taskId + " name=" + item.getFileName(), false, 4, null);
        TaskResultCodePayload taskResultCodePayload2 = this.payload;
        SessionArtifact sessionArtifactA = com.stepos.ailauncher.taskstore.chat.G.a(item, str, taskResultCodePayload2 != null ? taskResultCodePayload2.getTaskId() : null);
        if (kotlin.jvm.internal.p.d(from, "viewFull")) {
            M5.c cVar = M5.c.INSTANCE;
            String content = item.getContent();
            cVar.f(sessionArtifactA, str, content != null ? Integer.valueOf(content.length()) : null);
        } else {
            M5.c.b(M5.c.INSTANCE, sessionArtifactA, str, "chatview", null, M5.c.CARD_TYPE_PREVIEW, 8, null);
        }
        Context context3 = getContext();
        kotlin.jvm.internal.p.h(context3, "getContext(...)");
        C3738d.d(context3, sessionArtifactA, null, 2, null);
    }

    public final int D(int viewFullRowPx) throws Resources.NotFoundException {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.task_result_code_card_max_height);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.task_result_code_card_padding);
        return (((dimensionPixelSize - (dimensionPixelSize2 * 2)) - getResources().getDimensionPixelSize(R$dimen.task_result_code_header_icon)) - (getResources().getDimensionPixelSize(R$dimen.task_result_code_section_gap) * 2)) - viewFullRowPx;
    }

    public final void E() {
        final TaskResultCodePayload taskResultCodePayload;
        if (!isShown() || (getParent() instanceof TaskResultFileRowView) || (taskResultCodePayload = this.payload) == null) {
            return;
        }
        List<TaskResultCodeItem> listA = taskResultCodePayload.a();
        if (listA == null) {
            listA = C1173v.m();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : listA) {
            if (!La.H.x0(((TaskResultCodeItem) obj).getFileId())) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        final int i10 = this.availabilityGeneration + 1;
        this.availabilityGeneration = i10;
        com.stepos.ailauncher.taskstore.artifact.a aVar = com.stepos.ailauncher.taskstore.artifact.a.INSTANCE;
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((TaskResultCodeItem) it.next()).getFileId());
        }
        aVar.f(arrayList2, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.widget.w
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return TaskResultCodeView.F(this.f29419a, taskResultCodePayload, i10, (Map) obj2);
            }
        });
    }

    public final void H(List<TaskResultCodeItem> artifacts) {
        removeAllViews();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int i10 = 0;
        for (Object obj : artifacts) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            final TaskResultCodeItem taskResultCodeItem = (TaskResultCodeItem) obj;
            View viewInflate = layoutInflaterFrom.inflate(R$layout.item_task_result_code_card, (ViewGroup) this, false);
            if (this.expiredFileIds.contains(taskResultCodeItem.getFileId())) {
                viewInflate.setAlpha(0.5f);
            }
            ImageView imageView = (ImageView) viewInflate.findViewById(R$id.iv_code_icon);
            TextView textView = (TextView) viewInflate.findViewById(R$id.tv_code_filename);
            View viewFindViewById = viewInflate.findViewById(R$id.fl_code_preview);
            TextView textView2 = (TextView) viewInflate.findViewById(R$id.tv_code_content);
            View viewFindViewById2 = viewInflate.findViewById(R$id.ll_code_view_full);
            imageView.setImageResource(TaskMediumCardDecorationResolver.INSTANCE.n(taskResultCodeItem.getFileName(), taskResultCodeItem.getMimeType()));
            textView.setText(x(taskResultCodeItem));
            String content = taskResultCodeItem.getContent();
            if (content == null) {
                content = "";
            }
            textView2.setText(w(content, taskResultCodeItem), TextView.BufferType.SPANNABLE);
            textView2.setTypeface(Typeface.MONOSPACE);
            boolean zX0 = La.H.x0(content);
            boolean z10 = !zX0 && y(content);
            if (z10) {
                ViewGroup.LayoutParams layoutParams = viewInflate.getLayoutParams();
                layoutParams.height = getResources().getDimensionPixelSize(R$dimen.task_result_code_card_max_height);
                viewInflate.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = viewFindViewById.getLayoutParams();
                kotlin.jvm.internal.p.g(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
                layoutParams3.height = 0;
                layoutParams3.weight = 1.0f;
                textView2.setMaxLines(Integer.MAX_VALUE);
            } else {
                ViewGroup.LayoutParams layoutParams4 = viewInflate.getLayoutParams();
                layoutParams4.height = -2;
                viewInflate.setLayoutParams(layoutParams4);
                ViewGroup.LayoutParams layoutParams5 = viewFindViewById.getLayoutParams();
                kotlin.jvm.internal.p.g(layoutParams5, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) layoutParams5;
                layoutParams6.height = -2;
                layoutParams6.weight = 0.0f;
                textView2.setMaxLines(!zX0 ? Integer.MAX_VALUE : 1);
            }
            viewFindViewById.setVerticalFadingEdgeEnabled(z10);
            viewFindViewById.scrollTo(0, 0);
            viewFindViewById2.setVisibility(z10 ? 0 : 8);
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.taskstore.widget.F
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TaskResultCodeView.I(this.f29305a, taskResultCodeItem, view);
                }
            });
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.stepos.ailauncher.taskstore.widget.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TaskResultCodeView.J(this.f29406a, taskResultCodeItem, view);
                }
            };
            viewFindViewById.setOnClickListener(onClickListener);
            textView2.setOnClickListener(onClickListener);
            viewInflate.findViewById(R$id.ll_code_header).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.taskstore.widget.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TaskResultCodeView.K(this.f29412a, taskResultCodeItem, view);
                }
            });
            addView(viewInflate);
            if (i10 < C1173v.o(artifacts)) {
                ViewGroup.LayoutParams layoutParams7 = viewInflate.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams7 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams7 : null;
                if (marginLayoutParams != null) {
                    marginLayoutParams.bottomMargin = getResources().getDimensionPixelSize(R$dimen.task_result_code_section_gap);
                }
            }
            i10 = i11;
        }
    }

    public final void L() {
        if (getParent() instanceof TaskResultFileRowView) {
            return;
        }
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        String strB = C3738d.b(context);
        if (strB.length() <= 0) {
            strB = null;
        }
        TaskResultCodePayload taskResultCodePayload = this.payload;
        List<TaskResultCodeItem> listA = taskResultCodePayload != null ? taskResultCodePayload.a() : null;
        if (listA == null) {
            listA = C1173v.m();
        }
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (Object obj : listA) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            TaskResultCodeItem taskResultCodeItem = (TaskResultCodeItem) obj;
            Pair pairA = (La.H.x0(taskResultCodeItem.getFileId()) || !this.exposedFileIds.add(taskResultCodeItem.getFileId())) ? null : Y8.j.a(Integer.valueOf(i10), taskResultCodeItem);
            if (pairA != null) {
                arrayList.add(pairA);
            }
            i10 = i11;
        }
        if (arrayList.isEmpty()) {
            return;
        }
        TaskResultCodePayload taskResultCodePayload2 = this.payload;
        String taskId = taskResultCodePayload2 != null ? taskResultCodePayload2.getTaskId() : null;
        Ua.M mA = this.trackScope;
        if (mA == null) {
            mA = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Ua.Y.c().getImmediate()));
            this.trackScope = mA;
        }
        C1060i.d(mA, null, null, new TaskResultCodeView$reportChatCardExpose$1(arrayList, taskId, strB, null), 3, null);
    }

    public final void n(TaskResultCodePayload data, Map<String, ? extends ArtifactAvailability> map, int gen) {
        if (gen != this.availabilityGeneration) {
            return;
        }
        C5579b c5579b = C5579b.INSTANCE;
        Set<String> setE = c5579b.e(map);
        Set<String> setA = c5579b.a(map);
        if (kotlin.jvm.internal.p.d(setE, this.expiredFileIds) && kotlin.jvm.internal.p.d(setA, this.blockedFileIds)) {
            return;
        }
        this.expiredFileIds = setE;
        this.blockedFileIds = setA;
        this.skipAvailabilityQuery = true;
        s(data, setE, setA);
        this.skipAvailabilityQuery = false;
    }

    public final void o() {
        final TaskResultCodePayload taskResultCodePayload;
        if (!isShown() || (getParent() instanceof TaskResultFileRowView) || (taskResultCodePayload = this.payload) == null) {
            return;
        }
        List<TaskResultCodeItem> listA = taskResultCodePayload.a();
        if (listA == null) {
            listA = C1173v.m();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : listA) {
            if (!La.H.x0(((TaskResultCodeItem) obj).getFileId())) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        final int i10 = this.availabilityGeneration;
        com.stepos.ailauncher.taskstore.artifact.a aVar = com.stepos.ailauncher.taskstore.artifact.a.INSTANCE;
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((TaskResultCodeItem) it.next()).getFileId());
        }
        aVar.d(arrayList2, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.widget.E
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return TaskResultCodeView.p(this.f29302a, taskResultCodePayload, i10, (Map) obj2);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.stepos.ailauncher.taskstore.artifact.a.INSTANCE.a(this.availabilityChangedListener);
        this.exposureTimer.e(isShown());
        post(new Runnable() { // from class: com.stepos.ailauncher.taskstore.widget.y
            @Override // java.lang.Runnable
            public final void run() {
                TaskResultCodeView.A(this.f29426a);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        com.stepos.ailauncher.taskstore.artifact.a.INSTANCE.l(this.availabilityChangedListener);
        this.exposureTimer.g();
        Ua.M m10 = this.trackScope;
        if (m10 != null) {
            kotlinx.coroutines.d.e(m10, null, 1, null);
        }
        this.trackScope = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean isVisible) {
        super.onVisibilityAggregated(isVisible);
        this.exposureTimer.e(isVisible);
        if (isVisible) {
            post(new Runnable() { // from class: com.stepos.ailauncher.taskstore.widget.z
                @Override // java.lang.Runnable
                public final void run() {
                    TaskResultCodeView.B(this.f29427a);
                }
            });
        }
    }

    public final void s(TaskResultCodePayload data, Set<String> expiredFileIds, Set<String> blockedFileIds) {
        kotlin.jvm.internal.p.i(expiredFileIds, "expiredFileIds");
        kotlin.jvm.internal.p.i(blockedFileIds, "blockedFileIds");
        this.payload = data;
        if (!this.skipAvailabilityQuery) {
            this.expiredFileIds = expiredFileIds;
            this.blockedFileIds = blockedFileIds;
        }
        this.exposedFileIds.clear();
        List<TaskResultCodeItem> listA = data != null ? data.a() : null;
        if (listA == null) {
            listA = C1173v.m();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : listA) {
            if (!La.H.x0(((TaskResultCodeItem) obj).getFileId())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (!this.blockedFileIds.contains(((TaskResultCodeItem) obj2).getFileId())) {
                arrayList2.add(obj2);
            }
        }
        if (arrayList2.isEmpty()) {
            this.exposureTimer.b(null);
            setVisibility(8);
            return;
        }
        this.exposureTimer.b(data != null ? data.getTaskId() : null);
        setVisibility(0);
        if (!this.skipAvailabilityQuery) {
            this.availabilityGeneration++;
        }
        final int i10 = this.availabilityGeneration;
        H(arrayList2);
        if (this.skipAvailabilityQuery || (getParent() instanceof TaskResultFileRowView)) {
            return;
        }
        com.stepos.ailauncher.taskstore.artifact.a aVar = com.stepos.ailauncher.taskstore.artifact.a.INSTANCE;
        ArrayList arrayList3 = new ArrayList(C1174w.x(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((TaskResultCodeItem) it.next()).getFileId());
        }
        aVar.f(arrayList3, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.widget.A
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj3) {
                return TaskResultCodeView.u(this.f29294a, i10, (Map) obj3);
            }
        });
    }

    public final CharSequence w(String raw, TaskResultCodeItem item) {
        String lowerCase;
        String strQ1;
        if (raw.length() == 0) {
            return new SpannableStringBuilder();
        }
        String fileName = item.getFileName();
        if (fileName == null || (strQ1 = La.H.q1(fileName, '.', "")) == null) {
            lowerCase = null;
        } else {
            lowerCase = strQ1.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        }
        String str = lowerCase != null ? lowerCase : "";
        String language = item.getLanguage();
        if (language != null) {
            String lowerCase2 = language.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(lowerCase2, "toLowerCase(...)");
            if (lowerCase2 != null) {
                String str2 = La.H.x0(lowerCase2) ? null : lowerCase2;
                if (str2 != null) {
                    str = str2;
                }
            }
        }
        K4.d dVar = K4.d.INSTANCE;
        return dVar.b(str, raw, dVar.a(true), 20000);
    }

    public final String x(TaskResultCodeItem item) {
        u6.j jVar = u6.j.INSTANCE;
        TaskResultCodePayload taskResultCodePayload = this.payload;
        String taskId = taskResultCodePayload != null ? taskResultCodePayload.getTaskId() : null;
        if (taskId == null) {
            taskId = "";
        }
        String strB = jVar.b(taskId, item.getTitle(), item.getFileName(), item.getMimeType(), item.getCloudPath(), 0L, (64 & 64) != 0 ? null : null);
        if (!this.expiredFileIds.contains(item.getFileId())) {
            return strB;
        }
        C5579b c5579b = C5579b.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        return c5579b.d(context, strB);
    }

    public final boolean y(String content) {
        String strG1 = La.H.G1(content, '\n', '\r');
        if (strG1.length() == 0) {
            return false;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < strG1.length(); i11++) {
            if (strG1.charAt(i11) == '\n') {
                i10++;
            }
        }
        return i10 + 1 > C5685n.f(D((int) (((float) 20) * getResources().getDisplayMetrics().density)) / getResources().getDimensionPixelSize(R$dimen.task_result_code_line_height), 1);
    }

    public /* synthetic */ TaskResultCodeView(Context context, AttributeSet attributeSet, int i10, kotlin.jvm.internal.i iVar) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }
}
