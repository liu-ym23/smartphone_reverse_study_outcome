package com.obric.appstore.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.viewbinding.ViewBinding;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.obric.appstore.R;
import com.obric.appstore.base.BaseListItemProvider;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B6\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012%\b\u0002\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001e\u0010 \u001a\u0004\b!\u0010\"R4\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lcom/obric/appstore/ui/adapter/FixedEntranceItemProvider;", "Lcom/obric/appstore/base/BaseListItemProvider;", "Lsa/f;", "Lza/f;", "Landroid/view/View$OnClickListener;", "", "pageSource", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "id", "", "itemClickListener", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Landroid/view/ViewGroup;", "parent", "e", "(Landroid/view/ViewGroup;)Lsa/f;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "d", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lza/f;)V", "Landroid/view/View;", "v", BusSupport.EVENT_ON_CLICK, "(Landroid/view/View;)V", "binding", "c", "(Lsa/f;)V", "Ljava/lang/String;", "getPageSource", "()Ljava/lang/String;", "Lkotlin/jvm/functions/Function1;", "getItemClickListener", "()Lkotlin/jvm/functions/Function1;", "getItemViewType", "()I", "itemViewType", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFixedEntranceItemProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FixedEntranceItemProvider.kt\ncom/obric/appstore/ui/adapter/FixedEntranceItemProvider\n+ 2 OUnitExtension.kt\ncom/obric/oui/common/util/OUnitExtensionKt\n*L\n1#1,104:1\n181#2,3:105\n180#2,5:108\n181#2,3:113\n180#2,5:116\n181#2,3:121\n180#2,5:124\n*S KotlinDebug\n*F\n+ 1 FixedEntranceItemProvider.kt\ncom/obric/appstore/ui/adapter/FixedEntranceItemProvider\n*L\n51#1:105,3\n51#1:108,5\n63#1:113,3\n63#1:116,5\n83#1:121,3\n83#1:124,5\n*E\n"})
public final class FixedEntranceItemProvider extends BaseListItemProvider<sa.f, za.f> implements View.OnClickListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1 f11012d;

    public FixedEntranceItemProvider(String r10, Function1 r11) {
        q.g(r10, "pageSource");
        this.f11011c = r10;
        this.f11012d = r11;
    }

    @Override // com.obric.appstore.base.BaseListItemProvider
    public /* bridge */ /* synthetic */ ViewBinding a(ViewGroup r10) {
        return e(r10);
    }

    public final void c(sa.f r15) {
        Context r14 = r15.b().getContext();
        int r10 = r14.getResources().getDisplayMetrics().widthPixels - yf.b.b(TypedValue.applyDimension(1, 32, Resources.getSystem().getDisplayMetrics()));
        int r11 = View.MeasureSpec.makeMeasureSpec(0, 0);
        r15.f24584g.measure(r11, r11);
        r15.f24579b.measure(r11, r11);
        r15.f24580c.measure(r11, r11);
        int r12 = ((r15.f24584g.getMeasuredWidth() + r15.f24579b.getMeasuredWidth()) + r15.f24580c.getMeasuredWidth()) + yf.b.b(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics()));
        ConstraintSet r13 = new ConstraintSet();
        if (r12 <= r10) goto L5;
        ConstraintLayout r16 = r15.b();
        q.e(r16, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        r13.q(r16);
        int r17 = R.id.entrance_app;
        r13.o(r17, 7);
        r13.t(r17, 7, 0, 7);
        int r18 = R.id.entrance_rank_list;
        r13.o(r18, 4);
        r13.o(r17, 4);
        int r19 = R.id.entrance_game;
        r13.o(r19, 6);
        r13.o(r19, 7);
        r13.o(r19, 3);
        r13.u(r19, 3, r18, 4, yf.b.b(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics())));
        r13.t(r19, 4, 0, 4);
        r13.t(r19, 6, r18, 6);
        r13.t(r19, 7, r18, 7);
        r13.b0(r19, 6, 0);
    L6:
        ConstraintLayout r110 = r15.b();
        q.e(r110, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        r13.i(r110);
        return;
    L5:
        r13.p(r14, R.layout.item_fixed_entrance_view);
        goto L6
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, Object r11) {
        d(r10, (za.f) r11);
    }

    public void d(BaseViewHolder r10, za.f r11) {
        q.g(r10, "helper");
        q.g(r11, "item");
        sa.f r12 = (sa.f) b(r10);
        r12.f24579b.setOnClickListener(this);
        r12.f24580c.setOnClickListener(this);
        r12.f24584g.setOnClickListener(this);
        c(r12);
    }

    public sa.f e(ViewGroup r10) {
        q.g(r10, "parent");
        sa.f r11 = sa.f.c(LayoutInflater.from(r10.getContext()), r10, false);
        q.f(r11, "inflate(...)");
        return r11;
    }

    @Override // com.obric.appstore.base.BaseListItemProvider, com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return ItemType.FIXED_ENTRANCE.ordinal();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Function1 r11 = this.f11012d;
        if (r11 == null) goto L8;
        r11.invoke(Integer.valueOf(r10.getId()));
        return;
    }
}
