package com.obric.appstore.base;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b&\u0018\u0000 \u0017*\b\b\u0000\u0010\u0002*\u00020\u0001*\u0004\b\u0001\u0010\u00032\b\u0012\u0004\u0012\u00028\u00010\u0004:\u0003\u000e\u0017\u001aB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000e\u0010\u000fR \u0010\u0014\u001a\u00020\t8\u0006X\u0087D¢\u0006\u0012\n\u0004\b\u000e\u0010\u0010\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0012R\u0015\u0010\u0019\u001a\u00028\u0000*\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/obric/appstore/base/BaseListItemProvider;", "Landroidx/viewbinding/ViewBinding;", "Binding", "T", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "<init>", "()V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "a", "(Landroid/view/ViewGroup;)Landroidx/viewbinding/ViewBinding;", "I", "getLayoutId", "()I", "getLayoutId$annotations", "layoutId", "getItemViewType", "itemViewType", "b", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)Landroidx/viewbinding/ViewBinding;", "binding", "ViewBindingHolder", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class BaseListItemProvider<Binding extends ViewBinding, T> extends BaseItemProvider<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f10546b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10547a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00028\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0004\u001a\u00028\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/appstore/base/BaseListItemProvider$ViewBindingHolder;", "Landroidx/viewbinding/ViewBinding;", "Binding", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "binding", "<init>", "(Landroidx/viewbinding/ViewBinding;)V", "a", "Landroidx/viewbinding/ViewBinding;", "()Landroidx/viewbinding/ViewBinding;", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewBindingHolder<Binding extends ViewBinding> extends BaseViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewBinding f10548a;

        public ViewBindingHolder(@NotNull Binding r10) {
            q.g(r10, "binding");
            View r11 = r10.getRoot();
            q.f(r11, "getRoot(...)");
            super(r11);
            this.f10548a = r10;
        }

        public final ViewBinding a() {
            return this.f10548a;
        }
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b implements ViewBinding {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f10549a;

        public b(View r10) {
            q.g(r10, "view");
            this.f10549a = r10;
        }

        @Override // androidx.viewbinding.ViewBinding
        public View getRoot() {
            return this.f10549a;
        }
    }

    static {
        f10546b = new a(null);
    }

    public BaseListItemProvider() {
    }

    public abstract ViewBinding a(ViewGroup r10);

    public final ViewBinding b(BaseViewHolder r10) {
        q.g(r10, "<this>");
        return ((ViewBindingHolder) r10).a();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return 0;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final int getLayoutId() {
        return this.f10547a;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final BaseViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        q.g(r10, "parent");
        return new ViewBindingHolder(a(r10));
    }
}
