package com.stepos.ailauncher.chat.view;

import Z8.C1173v;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LifecycleOwner;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.controller.SessionSearchController;
import com.stepos.ailauncher.contract.model.search.SessionSearchHit;
import com.stepos.ailauncher.sheet.R$dimen;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u0001M\u0018\u0000 P2\u00020\u0001:\u0002QRB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u0018J\r\u0010\u001a\u001a\u00020\u000e¢\u0006\u0004\b\u001a\u0010\u0018J\u0015\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0011¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u000e¢\u0006\u0004\b!\u0010\u0018J\u0017\u0010\"\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u000eH\u0002¢\u0006\u0004\b$\u0010\u0018J\u000f\u0010%\u001a\u00020\u0011H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u000eH\u0002¢\u0006\u0004\b'\u0010\u0018J\u0017\u0010(\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b(\u0010#J\u0015\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0006H\u0002¢\u0006\u0004\b-\u0010.J#\u00101\u001a\u00020\u000e*\u00020*2\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0006H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u0006H\u0002¢\u0006\u0004\b4\u00105J\u0017\u00108\u001a\u00020\u000e2\u0006\u00107\u001a\u000206H\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u000eH\u0002¢\u0006\u0004\b:\u0010\u0018J\u000f\u0010;\u001a\u00020\u000eH\u0002¢\u0006\u0004\b;\u0010\u0018R\u0014\u0010=\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010C\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010ER\u0016\u0010F\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010K\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010O¨\u0006S"}, d2 = {"Lcom/stepos/ailauncher/chat/view/SessionSearchView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/stepos/ailauncher/chat/view/d8;", "host", "LY8/t;", "n", "(Landroidx/lifecycle/LifecycleOwner;Lcom/stepos/ailauncher/chat/view/d8;)V", "", "enter", "Lkotlin/Function0;", "onEnd", "C", "(ZLp9/a;)V", "z", "()V", "H", "M", "px", "m", "(I)V", "compact", "l", "(Z)V", "O", "r", "(Landroidx/lifecycle/LifecycleOwner;)V", "p", "K", "()Z", "w", "o", "", "Landroid/view/View;", "J", "()Ljava/util/List;", "L", "()I", ContentDisposition.Parameters.Size, "padding", "P", "(Landroid/view/View;II)V", UxipConstants.f30680s, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(I)I", "Lcom/stepos/ailauncher/contract/model/search/SessionSearchHit;", com.stepos.ailauncher.sla.G.JUDGE_HIT, "N", "(Lcom/stepos/ailauncher/contract/model/search/SessionSearchHit;)V", "B", "t", "Ll5/k;", "binding", "Ll5/k;", "Lcom/stepos/ailauncher/chat/controller/SessionSearchController;", "searchController", "Lcom/stepos/ailauncher/chat/controller/SessionSearchController;", "Landroid/widget/EditText;", "input", "Landroid/widget/EditText;", "Lcom/stepos/ailauncher/chat/view/d8;", "imeCompact", "Z", "guideRestHeight", "I", "Lcom/stepos/ailauncher/chat/view/SessionSearchView$b;", "expandedMetrics", "Lcom/stepos/ailauncher/chat/view/SessionSearchView$b;", "com/stepos/ailauncher/chat/view/SessionSearchView$c", "listTapToHideImeListener", "Lcom/stepos/ailauncher/chat/view/SessionSearchView$c;", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SessionSearchView extends FrameLayout {

    @Deprecated
    public static final int COMPACT_BAR_SIZE_DP = 46;

    @Deprecated
    public static final int COMPACT_CLEAR_PADDING_DP = 3;

    @Deprecated
    public static final int COMPACT_CLEAR_SIZE_DP = 24;

    @Deprecated
    public static final int COMPACT_CLOSE_PADDING_DP = 11;
    private static final a Companion = new a(null);

    @Deprecated
    public static final long PAGE_FADE_MS = 220;
    private final l5.k binding;
    private b expandedMetrics;
    private int guideRestHeight;
    private InterfaceC2797d8 host;
    private boolean imeCompact;
    private EditText input;
    private final c listTapToHideImeListener;
    private SessionSearchController searchController;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/chat/view/SessionSearchView$a;", "", "<init>", "()V", "", "PAGE_FADE_MS", "J", "", "COMPACT_BAR_SIZE_DP", "I", "COMPACT_CLOSE_PADDING_DP", "COMPACT_CLEAR_SIZE_DP", "COMPACT_CLEAR_PADDING_DP", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000b\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u000b\u001a\u0004\b\u0012\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/chat/view/SessionSearchView$b;", "", "", "contentHeight", "closeSize", "closePadding", "clearSize", "clearPadding", "barPaddingBottom", "<init>", "(IIIIII)V", "I", Const.INTENT_KEY_UMID, "()I", "c", Const.INTENT_KEY_PKGNAME, "getClearSize", "getClearPadding", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b {
        private final int barPaddingBottom;
        private final int clearPadding;
        private final int clearSize;
        private final int closePadding;
        private final int closeSize;
        private final int contentHeight;

        public b(int i10, int i11, int i12, int i13, int i14, int i15) {
            this.contentHeight = i10;
            this.closeSize = i11;
            this.closePadding = i12;
            this.clearSize = i13;
            this.clearPadding = i14;
            this.barPaddingBottom = i15;
        }

        /* renamed from: a, reason: from getter */
        public final int getBarPaddingBottom() {
            return this.barPaddingBottom;
        }

        /* renamed from: b, reason: from getter */
        public final int getClosePadding() {
            return this.closePadding;
        }

        /* renamed from: c, reason: from getter */
        public final int getCloseSize() {
            return this.closeSize;
        }

        /* renamed from: d, reason: from getter */
        public final int getContentHeight() {
            return this.contentHeight;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/view/SessionSearchView$c", "Landroidx/recyclerview/widget/RecyclerView$SimpleOnItemTouchListener;", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "Landroid/view/MotionEvent;", "e", "", "onInterceptTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends RecyclerView.SimpleOnItemTouchListener {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e10) {
            EditText editText;
            kotlin.jvm.internal.p.i(rv, "rv");
            kotlin.jvm.internal.p.i(e10, "e");
            if (e10.getActionMasked() != 0 || rv.findChildViewUnder(e10.getX(), e10.getY()) != null || (editText = SessionSearchView.this.input) == null) {
                return false;
            }
            com.stepos.ailauncher.chat.util.t.a(editText);
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionSearchView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        l5.k kVarC = l5.k.c(LayoutInflater.from(context), this, true);
        kotlin.jvm.internal.p.h(kVarC, "inflate(...)");
        this.binding = kVarC;
        this.listTapToHideImeListener = new c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void D(SessionSearchView sessionSearchView, boolean z10, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5063a = null;
        }
        sessionSearchView.C(z10, interfaceC5063a);
    }

    public static final Y8.t E(Ref$IntRef ref$IntRef, InterfaceC5063a interfaceC5063a) {
        int i10 = ref$IntRef.f34818a - 1;
        ref$IntRef.f34818a = i10;
        if (i10 == 0 && interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        return Y8.t.f7040a;
    }

    public static final void F(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
    }

    public static final void G(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
    }

    public static final void I(SessionSearchView sessionSearchView, EditText editText) {
        if (sessionSearchView.isAttachedToWindow()) {
            editText.requestFocus();
            com.stepos.ailauncher.chat.util.t.b(editText);
        }
    }

    public static final void q(SessionSearchView sessionSearchView, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        int i18 = i13 - i11;
        if (i18 <= 0) {
            return;
        }
        if (!sessionSearchView.K()) {
            sessionSearchView.guideRestHeight = i18;
            if (view.getTranslationY() == 0.0f) {
                return;
            }
            view.setTranslationY(0.0f);
            return;
        }
        if (sessionSearchView.guideRestHeight <= 0) {
            return;
        }
        float f10 = (r0 - i18) / 2.0f;
        if (view.getTranslationY() == f10) {
            return;
        }
        view.setTranslationY(f10);
    }

    public static final Y8.t s(SessionSearchView sessionSearchView, SessionSearchHit hit) {
        kotlin.jvm.internal.p.i(hit, "hit");
        sessionSearchView.N(hit);
        return Y8.t.f7040a;
    }

    public static final void u(SessionSearchView sessionSearchView, View view) {
        EditText editText = sessionSearchView.input;
        if (editText != null) {
            com.stepos.ailauncher.chat.util.t.a(editText);
        }
    }

    public static final void v(SessionSearchView sessionSearchView, View view) {
        EditText editText = sessionSearchView.input;
        if (editText != null) {
            editText.requestFocus();
            com.stepos.ailauncher.chat.util.t.b(editText);
        }
    }

    public static final void x(SessionSearchView sessionSearchView, View view) {
        sessionSearchView.B();
    }

    public static final void y(SessionSearchView sessionSearchView, View view) {
        sessionSearchView.B();
    }

    public final int A(int value) {
        return (int) ((value * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void B() {
        EditText editText = this.input;
        if (editText != null) {
            com.stepos.ailauncher.chat.util.t.a(editText);
        }
        InterfaceC2797d8 interfaceC2797d8 = this.host;
        if (interfaceC2797d8 != null) {
            interfaceC2797d8.a();
        }
    }

    public final void C(boolean enter, final InterfaceC5063a<Y8.t> onEnd) {
        setAlpha(1.0f);
        animate().cancel();
        LinearLayout sessionSearchContent = this.binding.sessionSearchContent;
        kotlin.jvm.internal.p.h(sessionSearchContent, "sessionSearchContent");
        ImageView btnSessionSearchClose = this.binding.btnSessionSearchClose;
        kotlin.jvm.internal.p.h(btnSessionSearchClose, "btnSessionSearchClose");
        for (View view : C1173v.p(sessionSearchContent, btnSessionSearchClose)) {
            view.animate().cancel();
            view.setAlpha(1.0f);
        }
        ImageView btnSessionSearchBack = this.binding.btnSessionSearchBack;
        kotlin.jvm.internal.p.h(btnSessionSearchBack, "btnSessionSearchBack");
        LinearLayout emptySessionSearch = this.binding.emptySessionSearch;
        kotlin.jvm.internal.p.h(emptySessionSearch, "emptySessionSearch");
        RecyclerView rvSessionSearch = this.binding.rvSessionSearch;
        kotlin.jvm.internal.p.h(rvSessionSearch, "rvSessionSearch");
        TextView tvSessionSearchTitle = this.binding.tvSessionSearchTitle;
        kotlin.jvm.internal.p.h(tvSessionSearchTitle, "tvSessionSearchTitle");
        List<View> listP = C1173v.p(btnSessionSearchBack, emptySessionSearch, rvSessionSearch, tvSessionSearchTitle);
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.f34818a = listP.size();
        final InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.j8
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SessionSearchView.E(ref$IntRef, onEnd);
            }
        };
        for (View view2 : listP) {
            view2.animate().cancel();
            if (enter) {
                view2.setAlpha(0.0f);
                view2.animate().alpha(1.0f).setDuration(220L).withEndAction(new Runnable() { // from class: com.stepos.ailauncher.chat.view.k8
                    @Override // java.lang.Runnable
                    public final void run() {
                        SessionSearchView.F(interfaceC5063a);
                    }
                }).start();
            } else {
                view2.animate().alpha(0.0f).setDuration(220L).withEndAction(new Runnable() { // from class: com.stepos.ailauncher.chat.view.l8
                    @Override // java.lang.Runnable
                    public final void run() {
                        SessionSearchView.G(interfaceC5063a);
                    }
                }).start();
            }
        }
    }

    public final void H() {
        InterfaceC2797d8 interfaceC2797d8 = this.host;
        if (interfaceC2797d8 != null) {
            interfaceC2797d8.c();
        }
        final EditText editText = this.input;
        if (editText == null) {
            return;
        }
        editText.post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.e8
            @Override // java.lang.Runnable
            public final void run() {
                SessionSearchView.I(this.f26119a, editText);
            }
        });
    }

    public final List<View> J() {
        ImageView btnSessionSearchBack = this.binding.btnSessionSearchBack;
        kotlin.jvm.internal.p.h(btnSessionSearchBack, "btnSessionSearchBack");
        LinearLayout sessionSearchContent = this.binding.sessionSearchContent;
        kotlin.jvm.internal.p.h(sessionSearchContent, "sessionSearchContent");
        ImageView btnSessionSearchClose = this.binding.btnSessionSearchClose;
        kotlin.jvm.internal.p.h(btnSessionSearchClose, "btnSessionSearchClose");
        return C1173v.p(btnSessionSearchBack, sessionSearchContent, btnSessionSearchClose);
    }

    public final boolean K() {
        return getPaddingBottom() > 0 || this.imeCompact;
    }

    public final int L() {
        return getResources().getDimensionPixelSize(R$dimen.ail_sheet_keyboard_gap);
    }

    public final void M() {
        EditText editText = this.input;
        if (editText != null) {
            com.stepos.ailauncher.chat.util.t.a(editText);
        }
    }

    public final void N(SessionSearchHit hit) {
        EditText editText = this.input;
        if (editText != null) {
            com.stepos.ailauncher.chat.util.t.a(editText);
        }
        com.stepos.ailauncher.chat.trace.f.g(com.stepos.ailauncher.chat.trace.f.INSTANCE, hit.getSessionId(), null, null, "search", hit.getAgentLabel(), hit.getAgentId(), 6, null);
        InterfaceC2797d8 interfaceC2797d8 = this.host;
        if (interfaceC2797d8 != null) {
            interfaceC2797d8.b(hit.getSessionId());
        }
    }

    public final void O() {
        SessionSearchController sessionSearchController = this.searchController;
        if (sessionSearchController != null) {
            sessionSearchController.q();
        }
        this.searchController = null;
        this.binding.rvSessionSearch.removeOnItemTouchListener(this.listTapToHideImeListener);
        this.binding.b().setOnClickListener(null);
        this.binding.sessionSearchContent.setOnClickListener(null);
        this.input = null;
        this.host = null;
    }

    public final void P(View view, int i10, int i11) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.width = i10;
        layoutParams.height = i10;
        view.setLayoutParams(layoutParams);
        view.setPadding(i11, i11, i11, i11);
    }

    public final void l(boolean compact) {
        if (this.imeCompact == compact) {
            return;
        }
        LinearLayout sessionSearchContent = this.binding.sessionSearchContent;
        kotlin.jvm.internal.p.h(sessionSearchContent, "sessionSearchContent");
        ImageView btnSessionSearchClose = this.binding.btnSessionSearchClose;
        kotlin.jvm.internal.p.h(btnSessionSearchClose, "btnSessionSearchClose");
        ImageView btnSessionSearchClear = this.binding.btnSessionSearchClear;
        kotlin.jvm.internal.p.h(btnSessionSearchClear, "btnSessionSearchClear");
        LinearLayout llSessionSearchBottomBar = this.binding.llSessionSearchBottomBar;
        kotlin.jvm.internal.p.h(llSessionSearchBottomBar, "llSessionSearchBottomBar");
        b bVar = this.expandedMetrics;
        if (bVar == null) {
            b bVar2 = new b(sessionSearchContent.getLayoutParams().height, btnSessionSearchClose.getLayoutParams().height, btnSessionSearchClose.getPaddingTop(), btnSessionSearchClear.getLayoutParams().height, btnSessionSearchClear.getPaddingTop(), llSessionSearchBottomBar.getPaddingBottom());
            this.expandedMetrics = bVar2;
            bVar = bVar2;
        }
        this.imeCompact = compact;
        ViewGroup.LayoutParams layoutParams = sessionSearchContent.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.height = compact ? A(46) : bVar.getContentHeight();
        sessionSearchContent.setLayoutParams(layoutParams);
        if (compact) {
            P(btnSessionSearchClose, A(46), A(11));
        } else {
            P(btnSessionSearchClose, bVar.getCloseSize(), bVar.getClosePadding());
        }
        sessionSearchContent.setPadding(compact ? A(9) : A(12), sessionSearchContent.getPaddingTop(), compact ? A(9) : A(12), sessionSearchContent.getPaddingBottom());
        llSessionSearchBottomBar.setPadding(llSessionSearchBottomBar.getPaddingLeft(), llSessionSearchBottomBar.getPaddingTop(), llSessionSearchBottomBar.getPaddingRight(), compact ? L() : bVar.getBarPaddingBottom());
    }

    public final void m(int px) {
        l(px > 0);
        if (getPaddingBottom() == px) {
            return;
        }
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), px);
    }

    public final void n(LifecycleOwner owner, InterfaceC2797d8 host) {
        kotlin.jvm.internal.p.i(owner, "owner");
        kotlin.jvm.internal.p.i(host, "host");
        this.host = host;
        r(owner);
        w();
        t();
        o(owner);
        p();
    }

    public final void o(LifecycleOwner owner) {
        C2773b6 c2773b6 = new C2773b6(owner, false, 2, null);
        ImageView btnSessionSearchBack = this.binding.btnSessionSearchBack;
        kotlin.jvm.internal.p.h(btnSessionSearchBack, "btnSessionSearchBack");
        ImageView btnSessionSearchClose = this.binding.btnSessionSearchClose;
        kotlin.jvm.internal.p.h(btnSessionSearchClose, "btnSessionSearchClose");
        C2773b6 c2773b6P = C2773b6.p(c2773b6, new View[]{btnSessionSearchBack, btnSessionSearchClose}, y7.o.INSTANCE.i(), false, 4, null);
        LinearLayout sessionSearchContent = this.binding.sessionSearchContent;
        kotlin.jvm.internal.p.h(sessionSearchContent, "sessionSearchContent");
        c2773b6P.n(new View[]{sessionSearchContent}, new SessionSearchView$bindGlass$1(K7.INSTANCE));
        for (View view : J()) {
            view.forceHasOverlappingRendering(false);
            Object parent = view.getParent();
            View view2 = parent instanceof View ? (View) parent : null;
            if (view2 != null) {
                view2.forceHasOverlappingRendering(false);
            }
        }
    }

    public final void p() {
        LinearLayout emptySessionSearch = this.binding.emptySessionSearch;
        kotlin.jvm.internal.p.h(emptySessionSearch, "emptySessionSearch");
        emptySessionSearch.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.chat.view.h8
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                SessionSearchView.q(this.f26163a, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        });
    }

    public final void r(LifecycleOwner owner) {
        EditText etSessionSearch = this.binding.etSessionSearch;
        kotlin.jvm.internal.p.h(etSessionSearch, "etSessionSearch");
        this.input = etSessionSearch;
        RecyclerView rvSessionSearch = this.binding.rvSessionSearch;
        kotlin.jvm.internal.p.h(rvSessionSearch, "rvSessionSearch");
        ImageView btnSessionSearchClear = this.binding.btnSessionSearchClear;
        kotlin.jvm.internal.p.h(btnSessionSearchClear, "btnSessionSearchClear");
        TextView tvSessionSearchTitle = this.binding.tvSessionSearchTitle;
        kotlin.jvm.internal.p.h(tvSessionSearchTitle, "tvSessionSearchTitle");
        LinearLayout emptySessionSearch = this.binding.emptySessionSearch;
        kotlin.jvm.internal.p.h(emptySessionSearch, "emptySessionSearch");
        ImageView ivSessionSearch = this.binding.ivSessionSearch;
        kotlin.jvm.internal.p.h(ivSessionSearch, "ivSessionSearch");
        TextView tvSessionSearchEmpty = this.binding.tvSessionSearchEmpty;
        kotlin.jvm.internal.p.h(tvSessionSearchEmpty, "tvSessionSearchEmpty");
        SessionSearchController sessionSearchController = new SessionSearchController(new SessionSearchController.b(rvSessionSearch, etSessionSearch, btnSessionSearchClear, tvSessionSearchTitle, emptySessionSearch, ivSessionSearch, tvSessionSearchEmpty));
        sessionSearchController.v(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.i8
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SessionSearchView.s(this.f26177a, (SessionSearchHit) obj);
            }
        });
        sessionSearchController.m(owner);
        this.searchController = sessionSearchController;
    }

    public final void t() {
        this.binding.b().setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.m8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SessionSearchView.u(this.f26252a, view);
            }
        });
        this.binding.sessionSearchContent.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.n8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SessionSearchView.v(this.f26269a, view);
            }
        });
        this.binding.rvSessionSearch.addOnItemTouchListener(this.listTapToHideImeListener);
    }

    public final void w() {
        this.binding.btnSessionSearchBack.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.f8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SessionSearchView.x(this.f26133a, view);
            }
        });
        this.binding.btnSessionSearchClose.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.g8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SessionSearchView.y(this.f26150a, view);
            }
        });
    }

    public final void z() {
        LinearLayout sessionSearchContent = this.binding.sessionSearchContent;
        kotlin.jvm.internal.p.h(sessionSearchContent, "sessionSearchContent");
        ImageView btnSessionSearchClose = this.binding.btnSessionSearchClose;
        kotlin.jvm.internal.p.h(btnSessionSearchClose, "btnSessionSearchClose");
        for (View view : C1173v.p(sessionSearchContent, btnSessionSearchClose)) {
            view.animate().cancel();
            view.setAlpha(0.0f);
        }
    }

    public /* synthetic */ SessionSearchView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
