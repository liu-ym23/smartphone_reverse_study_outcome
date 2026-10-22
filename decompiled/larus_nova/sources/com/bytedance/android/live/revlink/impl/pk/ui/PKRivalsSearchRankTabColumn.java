package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.livesdk.link.model.IGroupRivals;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0018B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011B\u001b\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0010\u0010\u0014B#\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0010\u0010\u0017J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J\u0014\u0010\n\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/PKRivalsSearchRankTabColumn;", "Landroid/widget/LinearLayout;", "Lkotlin/Pair;", "Lcom/bytedance/android/livesdk/link/model/IGroupRivals$GroupType;", "Landroid/widget/TextView;", "pair", "", "setupOnClickListener", "", "tabTypes", "setupTabs", "Lcom/bytedance/android/live/revlink/impl/pk/ui/PKRivalsSearchRankTabColumn$a;", "listener", "setOnPageSelectListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PKRivalsSearchRankTabColumn extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Pair<IGroupRivals.GroupType, TextView>> f96939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IGroupRivals.GroupType f96940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f96941c;

    public interface a {
        void a(IGroupRivals.GroupType r100);
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PKRivalsSearchRankTabColumn f96942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Pair f96943b;

        public b(PKRivalsSearchRankTabColumn r100, Pair r101) {
            this.f96942a = r100;
            this.f96943b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f96942a.a((IGroupRivals.GroupType) this.f96943b.getFirst());
        }
    }

    public PKRivalsSearchRankTabColumn(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f96939a = new ArrayList();
        setBackgroundResource(R.color.ttlive_white);
    }

    private final void setupOnClickListener(Pair<? extends IGroupRivals.GroupType, ? extends TextView> r100) {
        r100.getSecond().setOnClickListener(new b(this, r100));
    }

    public final void a(IGroupRivals.GroupType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        List<Pair<IGroupRivals.GroupType, TextView>> r101 = this.f96939a;
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L6;
        if (((IGroupRivals.GroupType) ((Pair) r102.next()).getFirst()) != r100) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == false) goto L9;
        boolean r104 = true;
    L16:
        if (r104 == true) goto L19;
        return;
    L19:
        if (this.f96940b != r100) goto L21;
        return;
    L21:
        this.f96940b = r100;
        Iterator<T> r105 = this.f96939a.iterator();
    L23:
        if (r105.hasNext() == false) goto L33;
        Pair r106 = (Pair) r105.next();
        if (((IGroupRivals.GroupType) r106.getFirst()) != r100) goto L27;
        boolean r107 = true;
    L28:
        Resources r108 = getResources();
        if (r107 == false) goto L31;
        int r109 = R.color.ttlive_pk_recommend_list_tab_label_selected;
    L32:
        int r110 = r108.getColor(r109);
        ((TextView) r106.getSecond()).setSelected(r107);
        ((TextView) r106.getSecond()).setTextColor(r110);
        goto L23
    L31:
        r109 = R.color.ttlive_pk_recommend_list_tab_label_unselected;
        goto L32
    L27:
        r107 = false;
        goto L28
    L33:
        a r111 = this.f96941c;
        if (r111 == null) goto L45;
        r111.a(r100);
        return;
    L45:
        return;
    L13:
        r103 = false;
    L6:
        r104 = false;
        goto L16
    L5:
        if (r101.isEmpty() == false) goto L7;
        goto L6
    }

    public final void setOnPageSelectListener(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f96941c = r100;
    }

    public final void setupTabs(List<? extends IGroupRivals.GroupType> r100) {
        Intrinsics.checkNotNullParameter(r100, "tabTypes");
        ((ArrayList) this.f96939a).clear();
        removeAllViews();
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L29;
        IGroupRivals.GroupType r102 = (IGroupRivals.GroupType) r101.next();
        boolean r103 = true;
        int r104 = 0;
        if (getChildCount() != 0) goto L8;
        boolean r105 = true;
    L9:
        TextView r106 = new TextView(getContext());
        List<Pair<IGroupRivals.GroupType, TextView>> r107 = this.f96939a;
        if ((r107 instanceof Collection) == true) goto L12;
    L14:
        Iterator<T> r108 = r107.iterator();
    L16:
        if (r108.hasNext() == false) goto L13;
        if (((IGroupRivals.GroupType) ((Pair) r108.next()).getFirst()) != r102) goto L20;
        boolean r109 = true;
    L21:
        if (r109 == false) goto L16;
    L22:
        if (r103 == true) goto L23;
        addView(r106);
        Pair<? extends IGroupRivals.GroupType, ? extends TextView> r110 = TuplesKt.to(r102, r106);
        ((ArrayList) this.f96939a).add(r110);
        if (r105 == true) goto L28;
        r104 = UtilityKotlinExtentionsKt.i(16);
    L28:
        a1.m(r106, r104);
        setupOnClickListener(r110);
        goto L4
    L23:
        return;
    L20:
        r109 = false;
    L13:
        r103 = false;
        goto L22
    L12:
        if (r107.isEmpty() == false) goto L14;
    L8:
        r105 = false;
        goto L9
    }

    public PKRivalsSearchRankTabColumn(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f96939a = new ArrayList();
        setBackgroundResource(R.color.ttlive_white);
    }

    public final void b(IGroupRivals.GroupType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "title");
        List<Pair<IGroupRivals.GroupType, TextView>> r102 = this.f96939a;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L3:
        boolean r105 = true;
        if (r104.hasNext() == false) goto L11;
        Object r106 = r104.next();
        if (r100 == ((IGroupRivals.GroupType) ((Pair) r106).getFirst())) goto L9;
        r105 = false;
    L9:
        if (r105 == false) goto L3;
        r103.add(r106);
        goto L3
    L11:
        Iterator r107 = CollectionsKt.take(r103, 1).iterator();
    L13:
        if (r107.hasNext() == false) goto L15;
        ((TextView) ((Pair) r107.next()).getSecond()).setText(r101);
        goto L13
    }

    public PKRivalsSearchRankTabColumn(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f96939a = new ArrayList();
        setBackgroundResource(R.color.ttlive_white);
    }
}
