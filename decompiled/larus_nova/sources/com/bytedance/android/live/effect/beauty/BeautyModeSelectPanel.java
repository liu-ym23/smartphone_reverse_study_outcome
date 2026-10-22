package com.bytedance.android.live.effect.beauty;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.effect.sticker.presenter.BeautyModeInfo;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R#\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/BeautyModeSelectPanel;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/bytedance/android/live/effect/beauty/BeautyModeSelectorAdapter;", "b", "getAdapter", "()Lcom/bytedance/android/live/effect/beauty/BeautyModeSelectorAdapter;", "adapter", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BeautyModeSelectPanel extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f67026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f67027b;

    public BeautyModeSelectPanel(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BeautyModeSelectPanel(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final BeautyModeSelectorAdapter getAdapter() {
        return (BeautyModeSelectorAdapter) this.f67027b.getValue();
    }

    private final RecyclerView getRecyclerView() {
        return (RecyclerView) this.f67026a.getValue();
    }

    public final void R5(Map<String, BeautyModeInfo> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "modeMap");
        Intrinsics.checkNotNullParameter(r101, "currentModeKey");
        BeautyModeSelectorAdapter r102 = getAdapter();
        Collection<BeautyModeInfo> r103 = r100.values();
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        BeautyModeInfo r106 = (BeautyModeInfo) r105.next();
        r104.add(new Pair(r106.b(), r106.c()));
        goto L4
    L6:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r104, "list");
        Intrinsics.checkNotNullParameter(r101, "currentModeKey");
        ((ArrayList) r102.f67028a).clear();
        ((ArrayList) r102.f67028a).addAll(r104);
        r102.f67029b = r101;
        r102.notifyDataSetChanged();
    }

    public BeautyModeSelectPanel(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f67026a = LazyKt.lazy(new BeautyModeSelectPanel$recyclerView$2(this));
        this.f67027b = LazyKt.lazy(BeautyModeSelectPanel$adapter$2.INSTANCE);
        ViewGroup.inflate(r100, R.layout.ttlive_effect_beauty_mode_select_panel, this);
        RecyclerView r103 = getRecyclerView();
        if (r103 == null) goto L5;
        LinearLayoutManager r104 = new LinearLayoutManager(r100);
        r104.setOrientation(1);
        Unit r105 = Unit.INSTANCE;
        r103.setLayoutManager(r104);
    L5:
        RecyclerView r106 = getRecyclerView();
        if (r106 == null) goto L8;
        r106.setAdapter(getAdapter());
    L8:
        RecyclerView r107 = getRecyclerView();
        if (r107 == null) goto L12;
        DividerItemDecoration r108 = new DividerItemDecoration(r100, 1);
        r108.setDrawable(new ColorDrawable(ColorProtector.parseColor("#1F161823")));
        Unit r109 = Unit.INSTANCE;
        r107.addItemDecoration(r108);
        return;
    }

    public /* synthetic */ BeautyModeSelectPanel(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
