package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019B\u001b\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0018\u0010\u001cB#\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u0018\u0010\u001fJ\u0016\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/PkItemExposeRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "", "setAdapter", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/String;", "getInviteIconPanelType", "()Ljava/lang/String;", "setInviteIconPanelType", "(Ljava/lang/String;)V", "inviteIconPanelType", "", "b", "Z", "getDisableScrollTouch", "()Z", "setDisableScrollTouch", "(Z)V", "disableScrollTouch", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defaultStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class PkItemExposeRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f96969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f96970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet<String> f96971c;

    public static final class a implements ViewTreeObserver.OnScrollChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkItemExposeRecyclerView f96973a;

        public a(PkItemExposeRecyclerView r100) {
            this.f96973a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            this.f96973a.t();
        }
    }

    public final void r() {
        this.f96971c.clear();
    }

    public final void t() {
        Rect r100 = new Rect();
        if (isShown() == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L10;
        return;
    L10:
        int r102 = getChildCount();
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L47;
        View r104 = getChildAt(r103);
        if (r104 == null) goto L46;
        Object r105 = getChildViewHolder(r104);
        RecyclerView.LayoutManager r106 = getLayoutManager();
        if ((r106 instanceof LinearLayoutManager) == true) goto L18;
        r106 = null;
    L18:
        LinearLayoutManager r107 = (LinearLayoutManager) r106;
        if (r107 == null) goto L21;
        int r108 = r107.getOrientation();
    L22:
        Rect r109 = new Rect();
        if (r104.isShown() == true) goto L25;
    L39:
        boolean r110 = false;
    L40:
        if (r110 == false) goto L46;
        if ((r105 instanceof j) == false) goto L46;
        j r111 = (j) r105;
        String r112 = r111.G();
        if (this.f96971c.contains(r112) == true) goto L46;
        r111.N(this.f96969a);
        this.f96971c.add(r111.G());
        goto L46
    L25:
        if (r104.getGlobalVisibleRect(r109) == false) goto L39;
        if (r108 == 1) goto L28;
    L30:
        boolean r113 = false;
    L31:
        if (r108 == 0) goto L33;
    L35:
        boolean r114 = false;
    L36:
        if (r113 == true) goto L38;
        if (r114 == false) goto L39;
    L38:
        r110 = true;
        goto L40
    L33:
        if (r109.width() <= (r104.getMeasuredWidth() / 2)) goto L35;
        r114 = true;
        goto L36
    L28:
        if (r109.height() <= (r104.getMeasuredHeight() / 2)) goto L30;
        r113 = true;
        goto L31
    L21:
        r108 = -1;
    L46:
        r103 = r103 + 1;
        goto L11
    L47:
        return;
    L5:
        if (getGlobalVisibleRect(r100) == false) goto L7;
        r101 = true;
        goto L8
    }

    public final boolean getDisableScrollTouch() {
        return this.f96970b;
    }

    public final String getInviteIconPanelType() {
        return this.f96969a;
    }

    public PkItemExposeRecyclerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f96969a = "";
        this.f96971c = new HashSet();
        getViewTreeObserver().addOnScrollChangedListener(new a(this));
        addOnScrollListener(new AnonymousClass2(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f96970b == false) goto L7;
        return false;
    L7:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f96970b == false) goto L7;
        return true;
    L7:
        return super.onTouchEvent(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter<?> r100) {
        super.setAdapter(r100);
        if (r100 == null) goto L6;
        r100.registerAdapterDataObserver(new AnonymousClass1(this));
        return;
    }

    public final void setDisableScrollTouch(boolean r100) {
        this.f96970b = r100;
    }

    public final void setInviteIconPanelType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f96969a = r100;
    }

    public PkItemExposeRecyclerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f96969a = "";
        this.f96971c = new HashSet();
        getViewTreeObserver().addOnScrollChangedListener(new a(this));
        addOnScrollListener(new AnonymousClass2(this));
    }

    public PkItemExposeRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f96969a = "";
        this.f96971c = new HashSet();
        getViewTreeObserver().addOnScrollChangedListener(new a(this));
        addOnScrollListener(new AnonymousClass2(this));
    }
}
