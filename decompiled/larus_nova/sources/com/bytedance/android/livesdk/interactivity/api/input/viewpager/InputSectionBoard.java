package com.bytedance.android.livesdk.interactivity.api.input.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.uikit.viewpager.SSViewPager;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u001a\u0010\t\u001a\u00020\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000f\u001a\u00020\n8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR*\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00128\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/input/viewpager/InputSectionBoard;", "Landroid/widget/FrameLayout;", "", "getLayoutId", "Lcom/bytedance/android/live/uikit/viewpager/SSViewPager;", "c", "Lcom/bytedance/android/live/uikit/viewpager/SSViewPager;", "getViewpager", "()Lcom/bytedance/android/live/uikit/viewpager/SSViewPager;", "viewpager", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "getSelectionRecycleView", "()Landroidx/recyclerview/widget/RecyclerView;", "selectionRecycleView", "Ljava/util/ArrayList;", "Lcom/bytedance/android/livesdk/interactivity/api/input/viewpager/c;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "getSelections", "()Ljava/util/ArrayList;", "selections", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class InputSectionBoard extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SelectionListAdapter f133255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InputSectionPagerAdapter f133256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SSViewPager f133257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f133258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<c> f133259e;

    public InputSectionBoard(Context r100) {
        this(r100, null, 0, 14, 0);
    }

    public InputSectionBoard(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 12, 0);
    }

    public InputSectionBoard(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 8, 0);
    }

    public int getLayoutId() {
        return R.layout.ttlive_normal_board;
    }

    public SelectionListAdapter b() {
        return new SelectionListAdapter(this.f133258d, this.f133259e);
    }

    public final RecyclerView getSelectionRecycleView() {
        return this.f133258d;
    }

    public final ArrayList<c> getSelections() {
        return this.f133259e;
    }

    public final SSViewPager getViewpager() {
        return this.f133257c;
    }

    public final void a(List<b> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        r100.size();
        UtilityKotlinExtentionsKt.w(this.f133258d);
        List<b> r101 = r100;
        Iterator<T> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        this.f133259e.add(((b) r102.next()).b());
        goto L7
    L9:
        final GridLayoutManager r103 = new GridLayoutManager(getContext(), r100.size());
        this.f133255a = b();
        this.f133258d.setLayoutManager(r103);
        this.f133258d.setAdapter(this.f133255a);
        InputSectionPagerAdapter r104 = this.f133256b;
        Function2<Integer, b, Unit> r105 = new InputSectionBoard$bindData$2(this, r103);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "listener");
        r104.f133260a.add(r105);
        SelectionListAdapter r106 = this.f133255a;
        if (r106 == null) goto L12;
        r106.f133267a = new InputSectionBoard$bindData$3(this);
    L12:
        InputSectionPagerAdapter r107 = this.f133256b;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r100, "value");
        ((ArrayList) r107.f133264e).clear();
        ((ArrayList) r107.f133264e).addAll(r100);
        r107.f133263d = 0;
        Iterator<T> r108 = r101.iterator();
        int r109 = 0;
    L14:
        if (r108.hasNext() == false) goto L19;
        Object r110 = r108.next();
        int r111 = r109 + 1;
        if (r109 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        b r112 = (b) r110;
        r107.f133263d++;
        r109 = r111;
        goto L14
    L19:
        r107.f133262c = 0;
        r107.notifyDataSetChanged();
        if ((!((ArrayList) r107.f133264e).isEmpty()) == false) goto L22;
        r107.f(r107.f133262c);
    L22:
        SelectionListAdapter r113 = this.f133255a;
        if (r113 == null) goto L27;
        LinkedHashSet<Integer> r114 = r113.f133269c;
        if (r114 == null) goto L27;
        r114.add(0);
    L27:
        this.f133256b.f133266g.setCurrentItem(0, false);
    }

    public InputSectionBoard(Context r100, AttributeSet r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f133259e = new ArrayList();
        LayoutInflater.from(r100).inflate(getLayoutId(), this, true);
        SSViewPager r104 = (SSViewPager) findViewById(R.id.normal_pager);
        this.f133257c = r104;
        this.f133258d = (RecyclerView) findViewById(R.id.normal_section_list);
        this.f133256b = new InputSectionPagerAdapter(r100, r104);
    }

    public /* synthetic */ InputSectionBoard(Context r100, AttributeSet r101, int r102, int r103, int r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102, 0);
    }
}
