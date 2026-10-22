package com.bytedanceos.appstore.buss.widget.app.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.bytedanceos.appstore.buss.entity.AppSubEntity;
import com.bytedanceos.appstore.buss.entity.AppSubWrap;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u001d\u0010\u0011\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010 \u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017R\u001b\u0010%\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0015\u001a\u0004\b#\u0010$R\u001d\u0010(\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010\u0017¨\u0006)"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/app/base/BaseSubPagerView;", "Lcom/bytedanceos/appstore/buss/widget/app/base/BasePagerView;", "Lcom/bytedanceos/appstore/buss/entity/AppSubWrap;", "Lcom/bytedanceos/appstore/buss/entity/AppSubEntity;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "wrap", "", "setTitle", "(Lcom/bytedanceos/appstore/buss/entity/AppSubWrap;)V", "setNewData", "", ServerElements.LIST, "setItems", "(Ljava/util/List;)V", "Landroid/widget/TextView;", "a", "Lkotlin/Lazy;", "getTvNext", "()Landroid/widget/TextView;", "tvNext", "Landroid/widget/ImageView;", "b", "getIvNext", "()Landroid/widget/ImageView;", "ivNext", "c", "getTvCategoryTitle", "tvCategoryTitle", "Landroidx/constraintlayout/widget/Group;", "d", "getGroupCategoryTitle", "()Landroidx/constraintlayout/widget/Group;", "groupCategoryTitle", "e", "getTvGroupDownloadAll", "tvGroupDownloadAll", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class BaseSubPagerView extends BasePagerView<AppSubWrap, AppSubEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f9093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f9094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f9095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f9096d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f9097e;

    public BaseSubPagerView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        this.f9093a = kotlin.b.b(new BaseSubPagerView$tvNext$2(this));
        this.f9094b = kotlin.b.b(new BaseSubPagerView$ivNext$2(this));
        this.f9095c = kotlin.b.b(new BaseSubPagerView$tvCategoryTitle$2(this));
        this.f9096d = kotlin.b.b(new BaseSubPagerView$groupCategoryTitle$2(this));
        this.f9097e = kotlin.b.b(new BaseSubPagerView$tvGroupDownloadAll$2(this));
        setLayoutParams(new ConstraintLayout.LayoutParams(-1, -2));
    }

    private final Group getGroupCategoryTitle() {
        return (Group) this.f9096d.getValue();
    }

    private final ImageView getIvNext() {
        return (ImageView) this.f9094b.getValue();
    }

    private final TextView getTvCategoryTitle() {
        return (TextView) this.f9095c.getValue();
    }

    private final TextView getTvGroupDownloadAll() {
        return (TextView) this.f9097e.getValue();
    }

    private final TextView getTvNext() {
        return (TextView) this.f9093a.getValue();
    }

    private final void setTitle(AppSubWrap r10) {
        String r11 = r10.getName();
        if (r11 != null) goto L5;
    L12:
        getGroupCategoryTitle().setVisibility(8);
        getTvNext().setVisibility(8);
        getIvNext().setVisibility(8);
        TextView r12 = getTvGroupDownloadAll();
        if (r12 == null) goto L18;
        r12.setVisibility(8);
        return;
    L18:
        return;
    L5:
        if (o.r(r11) == true) goto L12;
        getGroupCategoryTitle().setVisibility(0);
        getTvCategoryTitle().setText(r11);
        getTvNext().setVisibility(8);
        getIvNext().setVisibility(8);
        TextView r13 = getTvGroupDownloadAll();
        if (r13 == null) goto L17;
        r13.setVisibility(8);
        return;
    }

    @Override // com.bytedanceos.appstore.buss.widget.app.base.BasePagerView
    public void setItems(@NotNull List<? extends AppSubEntity> r10) {
        q.g(r10, ServerElements.LIST);
        getAdapter().setList(r10);
    }

    @Override // com.bytedanceos.appstore.buss.widget.app.base.BasePagerView
    public /* bridge */ /* synthetic */ void setNewData(AppSubWrap r10) {
        setNewData2(r10);
    }

    /* JADX INFO: renamed from: setNewData, reason: avoid collision after fix types in other method */
    public void setNewData2(@Nullable AppSubWrap r10) {
        if (r10 == null) goto L4;
        List<AppSubEntity> r11 = r10.getApps();
    L5:
        if (r11 != null) goto L7;
    L11:
        setVisibility(8);
        return;
    L7:
        if (r11.isEmpty() == true) goto L11;
        setVisibility(0);
        setTitle(r10);
        setItems(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }
}
