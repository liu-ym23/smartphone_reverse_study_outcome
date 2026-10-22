package com.chad.library.adapter.base.viewholder;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.Keep;
import androidx.annotation.StringRes;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.constant.CommonKey;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\tH\u0017¢\u0006\u0002\u0010\nJ\u001f\u0010\u000b\u001a\u0002H\f\"\b\b\u0000\u0010\f*\u00020\u00032\b\b\u0001\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\u0004\u0018\u0001H\f\"\b\b\u0000\u0010\f*\u00020\u00032\b\b\u0001\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0011\u001a\u00020\u00002\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u0012\u001a\u00020\u000eH\u0016J\u001c\u0010\u0013\u001a\u00020\u00002\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u0014\u001a\u00020\u000eH\u0016J\u001a\u0010\u0015\u001a\u00020\u00002\b\b\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00002\b\b\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u001c\u0010\u001a\u001a\u00020\u00002\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001c\u0010\u001d\u001a\u00020\u00002\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001c\u0010 \u001a\u00020\u00002\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010!\u001a\u00020\u000eH\u0016J\u001c\u0010\"\u001a\u00020\u00002\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001e\u0010\"\u001a\u0004\u0018\u00010\u00002\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010%\u001a\u00020\u000eH\u0016J\u001c\u0010&\u001a\u00020\u00002\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u0012\u001a\u00020\u000eH\u0016J\u001c\u0010'\u001a\u00020\u00002\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010(\u001a\u00020\u000eH\u0016J\u001a\u0010)\u001a\u00020\u00002\b\b\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u0017H\u0016J\u001b\u0010+\u001a\u0004\u0018\u0001H\f\"\b\b\u0000\u0010\f*\u00020\u0003*\u00020\u000e¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "views", "Landroid/util/SparseArray;", "getBinding", "B", "Landroidx/databinding/ViewDataBinding;", "()Landroidx/databinding/ViewDataBinding;", "getView", "T", "viewId", "", "(I)Landroid/view/View;", "getViewOrNull", "setBackgroundColor", "color", "setBackgroundResource", "backgroundRes", "setEnabled", "isEnabled", "", "setGone", "isGone", "setImageBitmap", "bitmap", "Landroid/graphics/Bitmap;", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setImageResource", "imageResId", "setText", CommonKey.KEY_VALUE, "", "strId", "setTextColor", "setTextColorRes", "colorRes", "setVisible", "isVisible", "findView", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
public class BaseViewHolder extends RecyclerView.ViewHolder {
    private final SparseArray<View> views;

    public BaseViewHolder(@NotNull View r10) {
        q.h(r10, "view");
        super(r10);
        this.views = new SparseArray();
    }

    @Nullable
    public final <T extends View> T findView(int r10) {
        return (T) this.itemView.findViewById(r10);
    }

    @Deprecated(message = "Please use BaseDataBindingHolder class", replaceWith = @ReplaceWith(expression = "DataBindingUtil.getBinding(itemView)", imports = {"androidx.databinding.DataBindingUtil"}))
    @Nullable
    public <B extends ViewDataBinding> B getBinding() {
        return (B) e.c(this.itemView);
    }

    @NotNull
    public final <T extends View> T getView(@IdRes int r10) {
        T r11 = (T) getViewOrNull(r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new IllegalStateException(("No view found with id " + r10).toString());
    }

    @Nullable
    public final <T extends View> T getViewOrNull(@IdRes int r10) {
        T r11 = (T) this.views.get(r10);
        if (r11 != null) goto L8;
        T r12 = (T) this.itemView.findViewById(r10);
        if (r12 == null) goto L8;
        this.views.put(r10, r12);
        return r12;
    L8:
        if (r11 != null) goto L11;
        return null;
    L11:
        return r11;
    }

    @NotNull
    public BaseViewHolder setBackgroundColor(@IdRes int r10, @ColorInt int r11) {
        getView(r10).setBackgroundColor(r11);
        return this;
    }

    @NotNull
    public BaseViewHolder setBackgroundResource(@IdRes int r10, @DrawableRes int r11) {
        getView(r10).setBackgroundResource(r11);
        return this;
    }

    @NotNull
    public BaseViewHolder setEnabled(@IdRes int r10, boolean r11) {
        getView(r10).setEnabled(r11);
        return this;
    }

    @NotNull
    public BaseViewHolder setGone(@IdRes int r10, boolean r11) {
        View r12 = getView(r10);
        if (r11 == false) goto L5;
        int r13 = 8;
    L6:
        r12.setVisibility(r13);
        return this;
    L5:
        r13 = 0;
        goto L6
    }

    @NotNull
    public BaseViewHolder setImageBitmap(@IdRes int r10, @Nullable Bitmap r11) {
        ((ImageView) getView(r10)).setImageBitmap(r11);
        return this;
    }

    @NotNull
    public BaseViewHolder setImageDrawable(@IdRes int r10, @Nullable Drawable r11) {
        ((ImageView) getView(r10)).setImageDrawable(r11);
        return this;
    }

    @NotNull
    public BaseViewHolder setImageResource(@IdRes int r10, @DrawableRes int r11) {
        ((ImageView) getView(r10)).setImageResource(r11);
        return this;
    }

    @NotNull
    public BaseViewHolder setText(@IdRes int r10, @Nullable CharSequence r11) {
        ((TextView) getView(r10)).setText(r11);
        return this;
    }

    @NotNull
    public BaseViewHolder setTextColor(@IdRes int r10, @ColorInt int r11) {
        ((TextView) getView(r10)).setTextColor(r11);
        return this;
    }

    @NotNull
    public BaseViewHolder setTextColorRes(@IdRes int r10, @ColorRes int r11) {
        TextView r12 = (TextView) getView(r10);
        View r13 = this.itemView;
        q.c(r13, "itemView");
        r12.setTextColor(r13.getResources().getColor(r11));
        return this;
    }

    @NotNull
    public BaseViewHolder setVisible(@IdRes int r10, boolean r11) {
        View r12 = getView(r10);
        if (r11 == false) goto L5;
        int r13 = 0;
    L6:
        r12.setVisibility(r13);
        return this;
    L5:
        r13 = 4;
        goto L6
    }

    @Nullable
    public BaseViewHolder setText(@IdRes int r10, @StringRes int r11) {
        ((TextView) getView(r10)).setText(r11);
        return this;
    }
}
