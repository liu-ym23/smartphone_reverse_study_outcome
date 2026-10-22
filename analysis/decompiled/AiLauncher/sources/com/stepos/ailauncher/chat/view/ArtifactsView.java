package com.stepos.ailauncher.chat.view;

import Ua.C1060i;
import Z8.C1173v;
import android.content.Context;
import android.util.AttributeSet;
import android.view.C1398p;
import android.view.LayoutInflater;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.contract.model.SessionArtifactKt;
import com.stepos.ailauncher.sheet.R$dimen;
import h8.C4148a;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import y7.G;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u0000 A2\u00020\u0001:\u0001BB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ1\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010%R*\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R0\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u00105R\u0018\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010=\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010?\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006C"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ArtifactsView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "sessionId", "", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "seeded", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;Ljava/util/List;)V", "o", "()V", "n", "(Landroidx/lifecycle/LifecycleOwner;)V", "artifacts", "m", "(Landroidx/lifecycle/LifecycleOwner;Ljava/util/List;)V", "q", "(Ljava/util/List;)Ljava/lang/String;", "titleBarHeight", "p", "(I)V", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/view/View;", "titleBar", "Landroid/view/View;", "topFade", "Lkotlin/Function0;", "onExit", "Lp9/a;", "getOnExit", "()Lp9/a;", "setOnExit", "(Lp9/a;)V", "Lkotlin/Function1;", "onArtifactClick", "Lp9/l;", "getOnArtifactClick", "()Lp9/l;", "setOnArtifactClick", "(Lp9/l;)V", "Ljava/lang/String;", "Lcom/stepos/ailauncher/chat/view/b6;", "glassGroup", "Lcom/stepos/ailauncher/chat/view/b6;", "Lkotlinx/coroutines/g;", "loadJob", "Lkotlinx/coroutines/g;", "", "density", "F", "listTopGapPx", "I", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArtifactsView extends FrameLayout {
    private static final float LIST_TOP_GAP_DP = 8.0f;
    private static final String TAG = "ArtifactsView";
    private final float density;
    private C2773b6 glassGroup;
    private final int listTopGapPx;
    private kotlinx.coroutines.g loadJob;
    private InterfaceC5074l<? super SessionArtifact, Y8.t> onArtifactClick;
    private InterfaceC5063a<Y8.t> onExit;
    private final RecyclerView rv;
    private String sessionId;
    private final View titleBar;
    private final View topFade;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactsView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        float f10 = getResources().getDisplayMetrics().density;
        this.density = f10;
        this.listTopGapPx = (int) (f10 * 8.0f);
        LayoutInflater.from(context).inflate(R$layout.fragment_artifacts, (ViewGroup) this, true);
        View viewFindViewById = findViewById(R$id.rv_artifacts);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById;
        this.rv = recyclerView;
        View viewFindViewById2 = findViewById(R$id.ll_artifacts_top);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        this.titleBar = viewFindViewById2;
        View viewFindViewById3 = findViewById(R$id.v_artifacts_top_fade);
        kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
        this.topFade = viewFindViewById3;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        viewFindViewById2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.chat.view.L
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                ArtifactsView.e(this.f25861a, view, i11, i12, i13, i14, i15, i16, i17, i18);
            }
        });
    }

    public static final void e(ArtifactsView artifactsView, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        artifactsView.p(view.getHeight());
    }

    public static final void k(ArtifactsView artifactsView, View view) {
        InterfaceC5063a<Y8.t> interfaceC5063a = artifactsView.onExit;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final void l(ArtifactsView artifactsView, View view) {
        InterfaceC5063a<Y8.t> interfaceC5063a = artifactsView.onExit;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final CharSequence r(SessionArtifact artifact) {
        kotlin.jvm.internal.p.i(artifact, "artifact");
        String taskId = artifact.getTaskId();
        String fileId = artifact.getFileId();
        String mimeType = artifact.getMimeType();
        String fileName = artifact.getFileName();
        if (fileName == null) {
            fileName = artifact.getName();
        }
        return "taskId=" + taskId + ",fileId=" + fileId + ",mime=" + mimeType + ",name=" + fileName + ",cloudPath=" + artifact.getCloudPath();
    }

    public final InterfaceC5074l<SessionArtifact, Y8.t> getOnArtifactClick() {
        return this.onArtifactClick;
    }

    public final InterfaceC5063a<Y8.t> getOnExit() {
        return this.onExit;
    }

    public final void j(LifecycleOwner owner, String sessionId, List<SessionArtifact> seeded) {
        kotlin.jvm.internal.p.i(owner, "owner");
        this.sessionId = sessionId;
        View viewFindViewById = findViewById(R$id.iv_artifacts_back);
        View viewFindViewById2 = findViewById(R$id.iv_artifacts_close);
        C2773b6 c2773b6 = this.glassGroup;
        if (c2773b6 != null) {
            c2773b6.t();
        }
        C2773b6 c2773b62 = new C2773b6(owner, false, 2, null);
        kotlin.jvm.internal.p.f(viewFindViewById);
        kotlin.jvm.internal.p.f(viewFindViewById2);
        C2773b6.p(c2773b62, new View[]{viewFindViewById, viewFindViewById2}, null, false, 6, null);
        C2773b6.j(c2773b62, new View[]{this.topFade}, G.a.f43886a.g(), Float.valueOf(getResources().getDimension(R$dimen.ail_sheet_corner) / getResources().getDisplayMetrics().density), null, 8, null);
        this.glassGroup = c2773b62;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtifactsView.k(this.f25869a, view);
            }
        });
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.N
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtifactsView.l(this.f25887a, view);
            }
        });
        List<SessionArtifact> list = seeded;
        if (list == null || list.isEmpty()) {
            n(owner);
            return;
        }
        List<SessionArtifact> listLatestFileProducts = SessionArtifactKt.latestFileProducts(seeded);
        C4148a.k(TAG, "bind seeded sessionId=" + sessionId + " rawSize=" + seeded.size() + " latestSize=" + listLatestFileProducts.size() + " raw=" + q(seeded) + " latest=" + q(listLatestFileProducts), false, 4, null);
        m(owner, listLatestFileProducts);
    }

    public final void m(LifecycleOwner owner, List<SessionArtifact> artifacts) {
        C4148a.k(TAG, "bindList sessionId=" + this.sessionId + " size=" + artifacts.size() + " items=" + q(artifacts), false, 4, null);
        C1060i.d(C1398p.a(owner), null, null, new ArtifactsView$bindList$1(artifacts, this, null), 3, null);
    }

    public final void n(LifecycleOwner owner) {
        String str = this.sessionId;
        if (str != null && str.length() != 0) {
            this.loadJob = C1060i.d(C1398p.a(owner), null, null, new ArtifactsView$load$1(this, owner, str, null), 3, null);
        } else {
            C4148a.u(TAG, "load: no sessionId and no seeded artifacts", false, 4, null);
            m(owner, C1173v.m());
        }
    }

    public final void o() {
        kotlinx.coroutines.g gVar = this.loadJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.loadJob = null;
        C2773b6 c2773b6 = this.glassGroup;
        if (c2773b6 != null) {
            c2773b6.t();
        }
        this.glassGroup = null;
    }

    public final void p(int titleBarHeight) {
        if (titleBarHeight <= 0) {
            return;
        }
        int i10 = this.listTopGapPx + titleBarHeight;
        if (this.rv.getPaddingTop() != i10) {
            RecyclerView recyclerView = this.rv;
            recyclerView.setPadding(recyclerView.getPaddingLeft(), i10, recyclerView.getPaddingRight(), recyclerView.getPaddingBottom());
        }
        if (this.topFade.getLayoutParams().height != titleBarHeight) {
            View view = this.topFade;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            layoutParams.height = titleBarHeight;
            view.setLayoutParams(layoutParams);
        }
    }

    public final String q(List<SessionArtifact> list) {
        return Z8.F.A0(list, Const.STR_MART_COMMA, "[", "]", 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.O
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ArtifactsView.r((SessionArtifact) obj);
            }
        }, 24, null);
    }

    public final void setOnArtifactClick(InterfaceC5074l<? super SessionArtifact, Y8.t> interfaceC5074l) {
        this.onArtifactClick = interfaceC5074l;
    }

    public final void setOnExit(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onExit = interfaceC5063a;
    }

    public /* synthetic */ ArtifactsView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
