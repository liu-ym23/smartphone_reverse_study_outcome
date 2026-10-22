package com.obric.appstore.ui.adapter;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.common.toolbox.i;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.obric.appstore.base.BaseListItemProvider;
import com.obric.oui.paneltitlebar.OPanelTitleBar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \n2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/obric/appstore/ui/adapter/HorGridAppsItemProvider;", "Lcom/obric/appstore/base/BaseListItemProvider;", "Lsa/b;", "Lza/f;", "", "pageSource", "<init>", "(Ljava/lang/String;)V", "Landroid/view/ViewGroup;", "parent", "d", "(Landroid/view/ViewGroup;)Lsa/b;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "", "c", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lza/f;)V", "Ljava/lang/String;", "getPageSource", "()Ljava/lang/String;", "", "getItemViewType", "()I", "itemViewType", "a", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHorGridAppsItemProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HorGridAppsItemProvider.kt\ncom/obric/appstore/ui/adapter/HorGridAppsItemProvider\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,109:1\n1#2:110\n*E\n"})
public final class HorGridAppsItemProvider extends BaseListItemProvider<sa.b, za.f> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f11014d = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11015c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final sa.b a(sa.b r10, String r11, String r12, List r13) {
            q.g(r10, "binding");
            q.g(r11, "pageSource");
            q.g(r12, "title");
            q.g(r13, "appInfos");
            r10.f24566d.setTitle(r12);
            if (r13.isEmpty() == false) goto L5;
            r10.f24565c.setVisibility(8);
            i.k("HorGridAppsItemProvider", "apps is empty");
        L12:
            return r10;
        L5:
            RecyclerView.Adapter r14 = r10.f24565c.getAdapter();
            if ((r14 instanceof ItemHorizontalAppAdapter) == false) goto L8;
            ItemHorizontalAppAdapter r15 = (ItemHorizontalAppAdapter) r14;
        L9:
            if (r15 != null) goto L11;
            ItemHorizontalAppAdapter r16 = new ItemHorizontalAppAdapter(r11, true);
            r16.setList(r13);
            r10.f24565c.setAdapter(r16);
            goto L12
        L11:
            r15.setList(r13);
            goto L12
        L8:
            r15 = null;
            goto L9
        }

        public final sa.b b(sa.b r10) {
            q.g(r10, "binding");
            GridLayoutManager r11 = new GridLayoutManager(r10.b().getContext(), 3);
            r11.setOrientation(0);
            r10.f24565c.setLayoutManager(r11);
            r10.f24565c.setNestedScrollingEnabled(false);
            r10.f24565c.setHasFixedSize(true);
            r10.f24565c.addItemDecoration(new xa.a(3, yf.b.b(TypedValue.applyDimension(1, 24, Resources.getSystem().getDisplayMetrics())), 0, 4, null));
            new ab.a(1).b(r10.f24565c);
            OPanelTitleBar r12 = r10.f24566d;
            q.f(r12, "pagerTitle");
            b.a(r12);
            return r10;
        }

        public a() {
        }
    }

    static {
        f11014d = new a(null);
    }

    public HorGridAppsItemProvider(String r10) {
        q.g(r10, "pageSource");
        this.f11015c = r10;
    }

    @Override // com.obric.appstore.base.BaseListItemProvider
    public /* bridge */ /* synthetic */ ViewBinding a(ViewGroup r10) {
        return d(r10);
    }

    public void c(BaseViewHolder r10, za.f r11) {
        q.g(r10, "helper");
        q.g(r11, "item");
        if ((r11 instanceof za.d) == false) goto L5;
        za.d r12 = (za.d) r11;
    L6:
        if (r12 != null) goto L8;
        return;
    L8:
        sa.b r13 = (sa.b) b(r10);
        f11014d.a(r13, this.f11015c, r12.e(), r12.d());
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, Object r11) {
        c(r10, (za.f) r11);
    }

    public sa.b d(ViewGroup r10) {
        q.g(r10, "parent");
        sa.b r11 = sa.b.c(LayoutInflater.from(r10.getContext()), r10, false);
        q.f(r11, "inflate(...)");
        f11014d.b(r11);
        return r11;
    }

    @Override // com.obric.appstore.base.BaseListItemProvider, com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return ItemType.HOR_PAGER_HORIZONTAL_APP.ordinal();
    }
}
