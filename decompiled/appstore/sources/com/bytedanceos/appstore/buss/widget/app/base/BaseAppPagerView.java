package com.bytedanceos.appstore.buss.widget.app.base;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.bytedanceos.appstore.buss.entity.AppEntityWrap;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.fragment.AppCategorySingleFragment;
import com.bytedanceos.appstore.buss.utilities.CommonUtil;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.e0;
import com.obric.appstore.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.u;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u001d\u0010\u0011\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u001a\u001a\u00020\u000b2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010!\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010 R\"\u0010%\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010 R$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00105\u001a\u00020.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001b\u0010;\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u00108\u001a\u0004\b>\u0010?R\u001b\u0010C\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u00108\u001a\u0004\bB\u0010:R\u001b\u0010H\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u00108\u001a\u0004\bF\u0010GR\u001d\u0010J\u001a\u0004\u0018\u0001068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u00108\u001a\u0004\bI\u0010:¨\u0006K"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/app/base/BaseAppPagerView;", "Lcom/bytedanceos/appstore/buss/widget/base/BasePagerView;", "Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "wrap", "", "setTitle", "(Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;)V", "setNewData", "", ServerElements.LIST, "setItems", "(Ljava/util/List;)V", "", "i", "()Z", "Lcom/bytedanceos/common/model/AppInfo;", "apps", "Landroid/view/View;", "view", "l", "(Ljava/util/List;Landroid/view/View;)V", "a", "Z", "getShowDownloadAll", "setShowDownloadAll", "(Z)V", "showDownloadAll", "b", "getShowMarginTop", "setShowMarginTop", "showMarginTop", "", "c", "Ljava/lang/String;", "getWidgetType", "()Ljava/lang/String;", "setWidgetType", "(Ljava/lang/String;)V", "widgetType", "", "d", "I", "getRow", "()I", "setRow", "(I)V", "row", "Landroid/widget/TextView;", "e", "Lkotlin/Lazy;", "getTvNext", "()Landroid/widget/TextView;", "tvNext", "Landroid/widget/ImageView;", "f", "getIvNext", "()Landroid/widget/ImageView;", "ivNext", "g", "getTvCategoryTitle", "tvCategoryTitle", "Landroidx/constraintlayout/widget/Group;", "h", "getGroupCategoryTitle", "()Landroidx/constraintlayout/widget/Group;", "groupCategoryTitle", "getTvGroupDownloadAll", "tvGroupDownloadAll", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBaseAppPagerView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseAppPagerView.kt\ncom/bytedanceos/appstore/buss/widget/app/base/BaseAppPagerView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ViewExt.kt\ncom/bytedanceos/appstore/buss/utilities/ViewExtKt\n*L\n1#1,186:1\n1549#2:187\n1620#2,3:188\n1855#2,2:203\n46#3,12:191\n*S KotlinDebug\n*F\n+ 1 BaseAppPagerView.kt\ncom/bytedanceos/appstore/buss/widget/app/base/BaseAppPagerView\n*L\n130#1:187\n130#1:188,3\n173#1:203,2\n131#1:191,12\n*E\n"})
public abstract class BaseAppPagerView extends com.bytedanceos.appstore.buss.widget.base.BasePagerView<AppEntityWrap, CommonAppEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f9084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f9086e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f9087f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f9088g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f9089h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f9090i;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$LongRef f9091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f9092b;

        public a(Ref$LongRef r10, List r11) {
            this.f9091a = r10;
            this.f9092b = r11;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            if (e.A0(BaseApplication.c()) == true) goto L6;
            e0.e(R.string.retry_connection);
            return;
        L6:
            long r11 = System.currentTimeMillis();
            Ref$LongRef r12 = this.f9091a;
            long r13 = r11 - r12.element;
            r12.element = System.currentTimeMillis();
            if (r13 >= 500) goto L9;
            return;
        L9:
            List r14 = this.f9092b;
            if (r14 == null) goto L17;
            Bundle r15 = new Bundle();
            if (((AppInfo) r14.get(0)).getSoftType() != 1) goto L14;
            r15.putString("app_moudle", "essential_game");
        L15:
            f9.b.b("click_essential_Install_all", r15);
            return;
        L14:
            r15.putString("app_moudle", "essential_app");
            goto L15
        }
    }

    public BaseAppPagerView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        this.f9083b = true;
        this.f9084c = "";
        this.f9086e = kotlin.b.b(new BaseAppPagerView$tvNext$2(this));
        this.f9087f = kotlin.b.b(new BaseAppPagerView$ivNext$2(this));
        this.f9088g = kotlin.b.b(new BaseAppPagerView$tvCategoryTitle$2(this));
        this.f9089h = kotlin.b.b(new BaseAppPagerView$groupCategoryTitle$2(this));
        this.f9090i = kotlin.b.b(new BaseAppPagerView$tvGroupDownloadAll$2(this));
        setLayoutParams(new ConstraintLayout.LayoutParams(-1, -2));
    }

    public static /* synthetic */ void g(String r10, BaseAppPagerView r11, Integer r12, View r13) {
        j(r10, r11, r12, r13);
    }

    private final Group getGroupCategoryTitle() {
        return (Group) this.f9089h.getValue();
    }

    private final ImageView getIvNext() {
        return (ImageView) this.f9087f.getValue();
    }

    private final TextView getTvCategoryTitle() {
        return (TextView) this.f9088g.getValue();
    }

    private final TextView getTvGroupDownloadAll() {
        return (TextView) this.f9090i.getValue();
    }

    private final TextView getTvNext() {
        return (TextView) this.f9086e.getValue();
    }

    public static /* synthetic */ void h(BaseAppPagerView r10, String r11, Integer r12, View r13) {
        k(r10, r11, r12, r13);
    }

    public static final void j(String r10, BaseAppPagerView r11, Integer r12, View r13) {
        q.g(r11, "this$0");
        Bundle r14 = new Bundle();
        r14.putString("sec_category_name", r10);
        f9.b.b("exposure_pages_seccategory", r14);
        i7.a.e(r11, AppCategorySingleFragment.f8457n.a(r10, r12, true));
    }

    public static final void k(BaseAppPagerView r10, String r11, Integer r12, View r13) {
        q.g(r10, "this$0");
        i7.a.a(r10, r11, r10.f9084c, r10.f9085d);
        i7.a.e(r10, AppCategorySingleFragment.f8457n.a(r11, r12, true));
    }

    private final void setTitle(AppEntityWrap r10) {
        final String r11 = r10.getCategoryName();
        if (r11 != null) goto L5;
    L49:
        getGroupCategoryTitle().setVisibility(8);
        getTvNext().setVisibility(8);
        getIvNext().setVisibility(8);
        TextView r12 = getTvGroupDownloadAll();
        if (r12 == null) goto L58;
        r12.setVisibility(8);
        return;
    L58:
        return;
    L5:
        if (o.r(r11) == true) goto L49;
        getGroupCategoryTitle().setVisibility(0);
        getTvCategoryTitle().setText(r11);
        final Integer r13 = r10.getCategoryId();
        if (r13 != null) goto L10;
        getTvNext().setVisibility(8);
        getIvNext().setVisibility(8);
    L12:
        if (this.f9082a == true) goto L14;
    L40:
        TextView r14 = getTvGroupDownloadAll();
        if (r14 == null) goto L45;
        r14.setVisibility(8);
    L45:
        if (this.f9083b == false) goto L47;
        ViewGroup.LayoutParams r15 = getTvCategoryTitle().getLayoutParams();
        q.e(r15, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        r16.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.dp_24);
        getTvCategoryTitle().setLayoutParams(r16);
        return;
    L47:
        ViewGroup.LayoutParams r17 = getTvCategoryTitle().getLayoutParams();
        q.e(r17, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r17;
        r18.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.dp_0);
        getTvCategoryTitle().setLayoutParams(r18);
        return;
    L14:
        if (getTvGroupDownloadAll() == null) goto L40;
        if (getTvNext().getVisibility() != 0) goto L22;
        TextView r19 = getTvGroupDownloadAll();
        if (r19 == null) goto L56;
        r19.setVisibility(8);
        return;
    L56:
        return;
    L22:
        TextView r20 = getTvGroupDownloadAll();
        if (r20 == null) goto L26;
        r20.setVisibility(0);
    L26:
        List<CommonAppEntity> r21 = r10.getApps();
        if (r21 == null) goto L35;
        ArrayList r22 = new ArrayList(u.r(r21, 10));
        Iterator<T> r23 = r21.iterator();
    L30:
        if (r23.hasNext() == false) goto L36;
        AppInfo r24 = ((CommonAppEntity) r23.next()).convertAppInfo();
        if (r24 == null) goto L33;
        q.d(r24);
        r22.add(r24);
        goto L30
    L33:
        return;
    L36:
        TextView r25 = getTvGroupDownloadAll();
        if (r25 == null) goto L39;
        r25.setOnClickListener(new a(new Ref$LongRef(), r22));
    L39:
        l(r22, getTvGroupDownloadAll());
        goto L45
    L35:
        r22 = null;
        goto L36
    L10:
        getTvNext().setVisibility(0);
        getIvNext().setVisibility(0);
        getTvCategoryTitle().setOnClickListener(new com.bytedanceos.appstore.buss.widget.app.base.a(r11, this, r13));
        getTvNext().setOnClickListener(new b(this, r11, r13));
        goto L12
    }

    public final int getRow() {
        return this.f9085d;
    }

    public final boolean getShowDownloadAll() {
        return this.f9082a;
    }

    public final boolean getShowMarginTop() {
        return this.f9083b;
    }

    @Nullable
    public final String getWidgetType() {
        return this.f9084c;
    }

    public final boolean i() {
        if (getGroupCategoryTitle().getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void l(List r10, View r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L21;
        if (r11 == null) goto L23;
        Iterator r12 = r10.iterator();
        boolean r13 = false;
    L9:
        if (r12.hasNext() == false) goto L13;
        r13 = CommonUtil.f8830a.g((AppInfo) r12.next());
        if (r13 == false) goto L9;
    L13:
        if (r13 == false) goto L15;
        r11.setEnabled(true);
        r11.setAlpha(1.0f);
        return;
    L15:
        r11.setEnabled(false);
        r11.setAlpha(0.3f);
        return;
    L23:
        return;
    }

    @Override // com.bytedanceos.appstore.buss.widget.base.BasePagerView
    public void setItems(@NotNull List<? extends CommonAppEntity> r10) {
        q.g(r10, ServerElements.LIST);
        getAdapter().setList(r10);
    }

    @Override // com.bytedanceos.appstore.buss.widget.base.BasePagerView
    public /* bridge */ /* synthetic */ void setNewData(AppEntityWrap r10) {
        setNewData2(r10);
    }

    public final void setRow(int r10) {
        this.f9085d = r10;
    }

    public final void setShowDownloadAll(boolean r10) {
        this.f9082a = r10;
    }

    public final void setShowMarginTop(boolean r10) {
        this.f9083b = r10;
    }

    public final void setWidgetType(@Nullable String r10) {
        this.f9084c = r10;
    }

    /* JADX INFO: renamed from: setNewData, reason: avoid collision after fix types in other method */
    public void setNewData2(@Nullable AppEntityWrap r10) {
        if (r10 == null) goto L4;
        List<CommonAppEntity> r11 = r10.getApps();
    L5:
        if (r11 != null) goto L7;
    L11:
        setVisibility(8);
        return;
    L7:
        if (r11.isEmpty() == true) goto L11;
        setLayoutParams(new ConstraintLayout.LayoutParams(-1, -2));
        setVisibility(0);
        setTitle(r10);
        setItems(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }
}
