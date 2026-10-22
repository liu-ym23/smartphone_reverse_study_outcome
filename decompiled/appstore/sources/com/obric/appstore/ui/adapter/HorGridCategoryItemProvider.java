package com.obric.appstore.ui.adapter;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.GridLayout;
import androidx.viewbinding.ViewBinding;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.obric.appstore.base.BaseListItemProvider;
import com.obric.appstore.util.ViewUtilsKt;
import com.obric.oui.paneltitlebar.OPanelTitleBar;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/obric/appstore/ui/adapter/HorGridCategoryItemProvider;", "Lcom/obric/appstore/base/BaseListItemProvider;", "Lsa/e;", "Lza/f;", "", "pageSource", "<init>", "(Ljava/lang/String;)V", "Landroid/view/ViewGroup;", "parent", "d", "(Landroid/view/ViewGroup;)Lsa/e;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "", "c", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lza/f;)V", "Ljava/lang/String;", "getPageSource", "()Ljava/lang/String;", "", "getItemViewType", "()I", "itemViewType", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHorGridCategoryItemProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HorGridCategoryItemProvider.kt\ncom/obric/appstore/ui/adapter/HorGridCategoryItemProvider\n+ 2 OUnitExtension.kt\ncom/obric/oui/common/util/OUnitExtensionKt\n*L\n1#1,84:1\n181#2,3:85\n180#2,5:88\n*S KotlinDebug\n*F\n+ 1 HorGridCategoryItemProvider.kt\ncom/obric/appstore/ui/adapter/HorGridCategoryItemProvider\n*L\n37#1:85,3\n37#1:88,5\n*E\n"})
public final class HorGridCategoryItemProvider extends BaseListItemProvider<sa.e, za.f> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11016c;

    public HorGridCategoryItemProvider(String r10) {
        q.g(r10, "pageSource");
        this.f11016c = r10;
    }

    @Override // com.obric.appstore.base.BaseListItemProvider
    public /* bridge */ /* synthetic */ ViewBinding a(ViewGroup r10) {
        return d(r10);
    }

    public void c(BaseViewHolder r10, za.f r11) {
        q.g(r10, "helper");
        q.g(r11, "item");
        if ((r11 instanceof za.e) == false) goto L5;
        za.e r12 = (za.e) r11;
    L6:
        if (r12 != null) goto L8;
        return;
    L8:
        final sa.e r13 = (sa.e) b(r10);
        r13.f24577d.setTitle(r12.e());
        int r14 = yf.b.b(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()));
        GridLayout r15 = r13.f24575b;
        q.f(r15, "categoryGridContainer");
        ViewUtilsKt.c(r15, r12.d(), true, new HorGridCategoryItemProvider$convert$1$1(this, r13), new HorGridCategoryItemProvider$convert$1$2(r14, this, r13));
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, Object r11) {
        c(r10, (za.f) r11);
    }

    public sa.e d(ViewGroup r10) {
        q.g(r10, "parent");
        sa.e r11 = sa.e.c(LayoutInflater.from(r10.getContext()), r10, false);
        q.f(r11, "inflate(...)");
        OPanelTitleBar r12 = r11.f24577d;
        q.f(r12, "categoryListTitle");
        b.a(r12);
        return r11;
    }

    @Override // com.obric.appstore.base.BaseListItemProvider, com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return ItemType.GRID_CATEGORY.ordinal();
    }
}
