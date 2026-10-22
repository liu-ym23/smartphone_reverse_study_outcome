package com.bytedance.android.ec.store.sortbar;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/ec/store/sortbar/HorizonSortItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HorizonSortItemHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f48611c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final QUIManager f48612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f48613b;

    public static final class a {
    }

    static {
    }

    public HorizonSortItemHolder(QUIManager r100, View r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "uiManager");
        Intrinsics.checkNotNullParameter(r101, "itemView");
        super(r101);
        this.f48612a = r100;
        this.f48613b = r102;
    }
}
