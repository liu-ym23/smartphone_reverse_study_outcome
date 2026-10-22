package com.bytedanceos.common.ui.widget.oui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.tag.OTextTag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u0000 <2\u00020\u0001:\u0001<B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010!\u001a\u00020\"H\u0004J\b\u0010#\u001a\u00020\"H\u0004J\b\u0010$\u001a\u00020\"H\u0004J\b\u0010%\u001a\u00020\"H\u0004J\u0018\u0010&\u001a\u00020\"2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010(H\u0002J\u0010\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020\u0007H\u0002J\u0010\u0010+\u001a\u00020\"2\b\u0010,\u001a\u0004\u0018\u00010\nJ\b\u0010-\u001a\u00020\"H\u0002J\u0006\u0010.\u001a\u00020\u001eJ\u0006\u0010/\u001a\u000200J\u0010\u00101\u001a\u00020\"2\b\u00102\u001a\u0004\u0018\u000103J\u0016\u00104\u001a\u00020\"2\u0006\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u0010J\u000e\u00107\u001a\u00020\"2\u0006\u00108\u001a\u000209J\u0010\u0010:\u001a\u00020\"2\b\u0010,\u001a\u0004\u0018\u00010\nJ\u001c\u0010;\u001a\u00020\"2\b\u0010,\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010*\u001a\u00020\u0007H\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/bytedanceos/common/ui/widget/oui/OUIAppItemView;", "Lcom/obric/oui/layout/OUIConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "appInfo", "Lcom/bytedanceos/common/model/AppInfo;", "getAppInfo", "()Lcom/bytedanceos/common/model/AppInfo;", "setAppInfo", "(Lcom/bytedanceos/common/model/AppInfo;)V", "onBtnClickListener", "Landroid/view/View$OnClickListener;", "onItemClickListener", "vBrief", "Landroid/widget/TextView;", "vCategory", "vDivider", "Landroid/view/View;", "vIcon", "Lcom/bytedanceos/common/network/widget/NetworkImageView;", "vIndex", "vName", "vRate", "Landroid/widget/ImageView;", "vStatus", "Lcom/bytedanceos/common/ui/widget/oui/OUIAppStatusView;", "vTagContainer", "Landroid/widget/LinearLayout;", "addLeftMarginForLine", "", "addNameRlMargin", "addRightMarginForAppStatusView", "addRightMarginForLine", "addTags", "labels", "", "bindAppStatus", "position", "bindData", ServerElements.INFO, "bindIcon", "getAppStatusView", "getIconBitmap", "Landroid/graphics/Bitmap;", "setNumber", "number", "", "setOnClickListener", "btnClickListener", "itemClickListener", "showLine", "show", "", "updateAppStatus", "updateItemView", "Companion", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOUIAppItemView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OUIAppItemView.kt\ncom/bytedanceos/common/ui/widget/oui/OUIAppItemView\n+ 2 OUnitExtension.kt\ncom/obric/oui/common/util/OUnitExtensionKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,201:1\n181#2,3:202\n180#2,5:205\n181#2,3:214\n180#2,5:217\n181#2,3:223\n180#2,5:226\n766#3:210\n857#3,2:211\n1855#3:213\n1856#3:222\n1#4:231\n*S KotlinDebug\n*F\n+ 1 OUIAppItemView.kt\ncom/bytedanceos/common/ui/widget/oui/OUIAppItemView\n*L\n60#1:202,3\n60#1:205,5\n181#1:214,3\n181#1:217,5\n189#1:223,3\n189#1:226,5\n173#1:210\n173#1:211,2\n173#1:213\n173#1:222\n*E\n"})
public class OUIAppItemView extends OUIConstraintLayout {

    @NotNull
    public static final Companion Companion = null;
    private static final int MARGIN_HORIZONTAL = 0;

    @Nullable
    private AppInfo appInfo;

    @Nullable
    private View.OnClickListener onBtnClickListener;

    @Nullable
    private View.OnClickListener onItemClickListener;

    @NotNull
    private final TextView vBrief;

    @NotNull
    private final TextView vCategory;

    @NotNull
    private final View vDivider;

    @NotNull
    private final NetworkImageView vIcon;

    @NotNull
    private final TextView vIndex;

    @NotNull
    private final TextView vName;

    @NotNull
    private final ImageView vRate;

    @NotNull
    private final OUIAppStatusView vStatus;

    @NotNull
    private final LinearLayout vTagContainer;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedanceos/common/ui/widget/oui/OUIAppItemView$Companion;", "", "()V", "MARGIN_HORIZONTAL", "", "getMARGIN_HORIZONTAL", "()I", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final int getMARGIN_HORIZONTAL() {
            return OUIAppItemView.access$getMARGIN_HORIZONTAL$cp();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        MARGIN_HORIZONTAL = BaseApplication.c().getResources().getDimensionPixelOffset(R$dimen.checkbox_margin);
    }

    @JvmOverloads
    public OUIAppItemView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static final /* synthetic */ int access$getMARGIN_HORIZONTAL$cp() {
        return MARGIN_HORIZONTAL;
    }

    private final void addTags(List<Integer> r10) {
        this.vTagContainer.removeAllViews();
        if (r10 == null) goto L16;
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L6:
        if (r12.hasNext() == false) goto L10;
        Object r13 = r12.next();
        if (com.bytedanceos.common.toolbox.e.H0(((Number) r13).intValue()) == false) goto L6;
        r11.add(r13);
        goto L6
    L10:
        List r14 = b0.u0(r11, 2);
        if (r14 == null) goto L23;
        Iterator r15 = r14.iterator();
    L14:
        if (r15.hasNext() == false) goto L24;
        int r16 = ((Number) r15.next()).intValue();
        LinearLayout r17 = this.vTagContainer;
        OTextTag r18 = com.bytedanceos.common.toolbox.e.s(r16);
        LinearLayout.LayoutParams r19 = new LinearLayout.LayoutParams(-2, -2);
        r19.gravity = 16;
        r19.setMargins(yf.b.b(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics())), 0, 0, 0);
        Unit r20 = Unit.f21064a;
        r17.addView(r18, r19);
        goto L14
    L24:
        return;
    L23:
        return;
    }

    private final void bindAppStatus(int r10) {
        AppInfo r11 = this.appInfo;
        if (r11 != null) goto L5;
        return;
    L5:
        this.vStatus.updateDownloadStatus(r11);
        this.vStatus.setTag(r11);
        this.vStatus.setTag(R$id.page_button_pos, Integer.valueOf(r10));
        this.vStatus.setTag(R$id.appinfo, r11);
        this.vStatus.setTag(R$id.app_row_index, Integer.valueOf(r10));
        View.OnClickListener r12 = this.onBtnClickListener;
        if (r12 == null) goto L9;
        this.vStatus.setOnClickListener(r12);
        return;
    }

    private final void bindIcon() {
        AppInfo r10 = this.appInfo;
        if (r10 != null) goto L5;
        return;
    L5:
        this.vIcon.e(r10.appIcon, yf.b.b(TypedValue.applyDimension(1, 30, Resources.getSystem().getDisplayMetrics())));
    }

    public static /* synthetic */ void updateItemView$default(OUIAppItemView r10, AppInfo r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        r10.updateItemView(r11, r12);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateItemView");
    }

    public final void addLeftMarginForLine() {
    }

    public final void addNameRlMargin() {
    }

    public final void addRightMarginForAppStatusView() {
    }

    public final void addRightMarginForLine() {
    }

    public final void bindData(@Nullable AppInfo r10) {
        updateItemView$default(this, r10, 0, 2, null);
    }

    @Nullable
    public final AppInfo getAppInfo() {
        return this.appInfo;
    }

    @NotNull
    public final OUIAppStatusView getAppStatusView() {
        return this.vStatus;
    }

    @NotNull
    public final Bitmap getIconBitmap() {
        Bitmap r10 = Bitmap.createBitmap(this.vIcon.getWidth(), this.vIcon.getHeight(), Bitmap.Config.ARGB_8888);
        q.f(r10, "createBitmap(...)");
        Canvas r11 = new Canvas(r10);
        this.vIcon.draw(r11);
        return r10;
    }

    public final void setAppInfo(@Nullable AppInfo r10) {
        this.appInfo = r10;
    }

    public final void setNumber(@Nullable Object r10) {
        if (r10 != null) goto L6;
        this.vIndex.setVisibility(8);
        return;
    L6:
        String r11 = r10.toString();
        if (o.r(r11) == false) goto L10;
        this.vIndex.setVisibility(8);
        return;
    L10:
        this.vIndex.setVisibility(0);
        this.vIndex.setText(r11);
    }

    public final void setOnClickListener(@NotNull View.OnClickListener r10, @NotNull View.OnClickListener r11) {
        q.g(r10, "btnClickListener");
        q.g(r11, "itemClickListener");
        this.onBtnClickListener = r10;
        this.onItemClickListener = r11;
        setOnClickListener(r11);
        this.vStatus.setOnClickListener(this.onBtnClickListener);
    }

    public final void showLine(boolean r10) {
        l.p(this.vDivider, r10);
    }

    public final void updateAppStatus(@Nullable AppInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.vStatus.updateDownloadStatus(r10);
    }

    @JvmOverloads
    public final void updateItemView(@Nullable AppInfo r10) {
        updateItemView$default(this, r10, 0, 2, null);
    }

    @JvmOverloads
    public OUIAppItemView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    @JvmOverloads
    public final void updateItemView(@Nullable AppInfo r10, int r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.appInfo = r10;
        setTag(R$id.appinfo, r10);
        View.OnClickListener r12 = this.onItemClickListener;
        if (r12 == null) goto L8;
        setOnClickListener(r12);
    L8:
        if (TextUtils.isEmpty(r10.recmd_brief) == true) goto L10;
    L12:
        this.vRate.setVisibility(8);
        this.vBrief.setVisibility(0);
    L13:
        this.vName.setText(r10.appName);
        TextView r13 = this.vBrief;
        String r14 = r10.recmd_brief;
        if (r14 != null) goto L16;
    L19:
        String r15 = getContext().getString(R$string.no_comment);
    L20:
        r13.setText(r15);
        if (TextUtils.isEmpty(r10.appCategoryName) == false) goto L23;
        this.vCategory.setVisibility(8);
    L24:
        this.vName.setText(r10.appName);
        addTags(r10.mLabels);
        bindAppStatus(r11);
        bindIcon();
        return;
    L23:
        this.vCategory.setVisibility(0);
        this.vCategory.setText(r10.appCategoryName);
        goto L24
    L16:
        if (o.r(r14) == true) goto L19;
        r15 = r10.recmd_brief;
        goto L20
    L10:
        if (r10.appScores <= 0.0f) goto L12;
        this.vRate.setVisibility(0);
        this.vBrief.setVisibility(8);
        int r16 = com.bytedanceos.common.toolbox.e.b0(getContext(), r10.appScores, false);
        this.vRate.setImageResource(r16);
        goto L13
    }

    public /* synthetic */ OUIAppItemView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OUIAppItemView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12, null, 8, null);
        LayoutInflater.from(r10).inflate(R$layout.oui_app_item_view, this);
        this.vIndex = (TextView) ViewExtKt.findView(this, R$id.app_index);
        this.vIcon = (NetworkImageView) ViewExtKt.findView(this, R$id.appIcon);
        this.vName = (TextView) ViewExtKt.findView(this, R$id.appName);
        this.vCategory = (TextView) ViewExtKt.findView(this, R$id.appCategory);
        this.vTagContainer = (LinearLayout) ViewExtKt.findView(this, R$id.app_tag_container);
        this.vBrief = (TextView) ViewExtKt.findView(this, R$id.appBrief);
        this.vRate = (ImageView) ViewExtKt.findView(this, R$id.appRate);
        OUIAppStatusView r13 = (OUIAppStatusView) ViewExtKt.findView(this, R$id.appStatusLay);
        this.vStatus = r13;
        r13.showAppSize();
        this.vDivider = ViewExtKt.findView(this, R$id.line);
        setRadius(getResources().getDimensionPixelSize(R$dimen.oui_r_l3_rect));
        setLayoutParams(new ViewGroup.LayoutParams(-1, yf.b.b(TypedValue.applyDimension(1, 64, Resources.getSystem().getDisplayMetrics()))));
    }
}
