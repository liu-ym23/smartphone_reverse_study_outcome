package com.obric.appstore.buss.rank;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.ui.widget.oui.ViewExtKt;
import com.obric.appstore.R;
import com.obric.appstore.base.e;
import com.obric.appstore.buss.search.transition.SearchTransition;
import com.obric.oui.tab.OTabLayout;
import com.obric.oui.tab.OTabLayoutBase;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.tmall.wireless.tangram.structure.card.FixCard;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\u00020\u00148\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/obric/appstore/buss/rank/RankContainerFragment;", "Lcom/obric/appstore/base/e;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", ServerElements.CONTENT, "B", "(Landroid/view/View;)V", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", FixCard.FixStyle.KEY_X, "()Landroid/os/Bundle;", "", "h", "I", "w", "()I", "layoutId", "", "i", "[Ljava/lang/Integer;", "titles", "Lcom/obric/appstore/buss/search/transition/SearchTransition$b;", "j", "Lcom/obric/appstore/buss/search/transition/SearchTransition$b;", "searchScene2", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRankContainerFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RankContainerFragment.kt\ncom/obric/appstore/buss/rank/RankContainerFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,106:1\n1#2:107\n*E\n"})
public final class RankContainerFragment extends e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f10789h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer[] f10790i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SearchTransition.b f10791j;

    public static final class a implements RecyclerView.OnItemTouchListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView r10, MotionEvent r11) {
            q.g(r10, "rv");
            q.g(r11, "e");
            if (r11.getActionMasked() == 0) goto L5;
            return false;
        L5:
            if (r10.getScrollState() != 2) goto L10;
            r10.stopScroll();
            return false;
        L10:
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean r10) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView r10, MotionEvent r11) {
            q.g(r10, "rv");
            q.g(r11, "e");
        }
    }

    public static final class b implements OTabLayoutBase.OnTabSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewPager2 f10792a;

        public b(ViewPager2 r10) {
            this.f10792a = r10;
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.OnTabSelectedListener
        public void onTabReselected(OTabLayoutBase.h r10) {
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.OnTabSelectedListener
        public void onTabSelected(OTabLayoutBase.h r10) {
            if (r10 == null) goto L5;
            int r11 = r10.d();
            this.f10792a.j(r11, true);
            return;
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.OnTabSelectedListener
        public void onTabUnselected(OTabLayoutBase.h r10) {
        }
    }

    public RankContainerFragment() {
        this.f10789h = R.layout.obric_fragment_rank_container;
        this.f10790i = new Integer[]{Integer.valueOf(R.string.title_rank_app), Integer.valueOf(R.string.title_rank_game)};
        this.f10791j = new SearchTransition.b();
    }

    public static /* synthetic */ void F(ViewPager2 r10) {
        G(r10);
    }

    public static final void G(ViewPager2 r10) {
        q.g(r10, "$viewPager");
        View r11 = r10.getChildAt(0);
        if ((r11 instanceof RecyclerView) == false) goto L5;
        RecyclerView r12 = (RecyclerView) r11;
    L6:
        if (r12 == null) goto L9;
        r12.addOnItemTouchListener(new a());
        return;
    L9:
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.obric.appstore.base.e
    public void B(View r10) {
        q.g(r10, ServerElements.CONTENT);
        super.B(r10);
        final OTabLayout r11 = (OTabLayout) ViewExtKt.findView(r10, R.id.tab_layout);
        final ViewPager2 r12 = (ViewPager2) ViewExtKt.findView(r10, R.id.view_pager);
        r12.post(new c(r12));
        r11.addOnTabSelectedListener(new b(r12));
        r12.g(new RankContainerFragment$onCreateContentView$3(r11));
        r12.setAdapter(new d(this, this.f10790i));
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r10) {
        q.g(r10, "context");
        super.onAttach(r10);
        FragmentActivity r11 = getActivity();
        if (r11 == null) goto L8;
        Window r12 = r11.getWindow();
        if (r12 == null) goto L9;
        this.f10791j.c(r12);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        q.g(r10, "view");
        super.onViewCreated(r10, r11);
        OFloatingTitleBar r12 = y();
        if (r12 == null) goto L6;
        r12.setCenterTitle(getString(R.string.ranking));
        m(r12);
        this.f10791j.a(r12);
        return;
    }

    @Override // com.obric.appstore.base.e
    public int w() {
        return this.f10789h;
    }

    @Override // com.obric.appstore.base.e
    public Bundle x() {
        SearchTransition.b r10 = this.f10791j;
        FragmentActivity r11 = getActivity();
        if (r11 != null) goto L7;
        return null;
    L7:
        return r10.b(r11);
    }
}
