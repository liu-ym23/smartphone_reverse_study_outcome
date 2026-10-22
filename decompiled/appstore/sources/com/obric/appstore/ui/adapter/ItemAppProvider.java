package com.obric.appstore.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.IAppInfo;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.obric.appstore.base.BaseListItemProvider;
import com.obric.appstore.common.core.ui.view.AppItemViewStyle;
import com.obric.appstore.common.core.ui.view.ObricAppItemView;
import com.obric.appstore.common.core.ui.view.ObricAppItemViewForSettings;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b$\u0018\u0000 <*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003:\u0001=Bo\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\"\b\u0002\u0010\u000e\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r\u0018\u00010\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010!\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bH\u0002¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001d\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b!\u0010&\u001a\u0004\b)\u0010(R1\u0010\u000e\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u0010\u0010\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b2\u0010&\u001a\u0004\b3\u0010(R\u0017\u0010\u0011\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b4\u0010&\u001a\u0004\b\u0011\u0010(R\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0014\u0010;\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/obric/appstore/ui/adapter/ItemAppProvider;", "Lcom/bytedanceos/common/model/IAppInfo;", "T", "Lcom/obric/appstore/base/BaseListItemProvider;", "Lcom/obric/appstore/base/BaseListItemProvider$b;", "", "pageSource", "", "pager", "showIndex", "Lkotlin/Function3;", "", "Landroid/view/View;", "", "converter", "containerHeight", "showAppInfo", "isForbiddenItemInnerLine", "", "iconRadius", "<init>", "(Ljava/lang/String;ZZLkotlin/jvm/functions/Function3;Ljava/lang/Integer;ZZF)V", "Landroid/view/ViewGroup;", "parent", "d", "(Landroid/view/ViewGroup;)Lcom/obric/appstore/base/BaseListItemProvider$b;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "c", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/bytedanceos/common/model/IAppInfo;)V", "position", "row", "e", "(II)Z", "Ljava/lang/String;", "getPageSource", "()Ljava/lang/String;", "Z", "getPager", "()Z", "getShowIndex", "f", "Lkotlin/jvm/functions/Function3;", "getConverter", "()Lkotlin/jvm/functions/Function3;", "g", "Ljava/lang/Integer;", "getContainerHeight", "()Ljava/lang/Integer;", "h", "getShowAppInfo", "i", "j", "F", "getIconRadius", "()F", "getItemViewType", "()I", "itemViewType", "k", "a", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nItemAppProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ItemAppProvider.kt\ncom/obric/appstore/ui/adapter/ItemAppProvider\n+ 2 OUnitExtension.kt\ncom/obric/oui/common/util/OUnitExtensionKt\n*L\n1#1,103:1\n189#2,3:104\n188#2,5:107\n*S KotlinDebug\n*F\n+ 1 ItemAppProvider.kt\ncom/obric/appstore/ui/adapter/ItemAppProvider\n*L\n33#1:104,3\n33#1:107,5\n*E\n"})
public final class ItemAppProvider<T extends IAppInfo> extends BaseListItemProvider<BaseListItemProvider.b, T> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f11017k = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f11019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f11020e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function3 f11021f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f11022g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f11023h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f11024i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f11025j;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static /* synthetic */ void a(Activity r10, AppInfo r11, String r12, View r13) {
            e(r10, r11, r12, r13);
        }

        public static /* synthetic */ void b(Activity r10, AppInfo r11, String r12, View r13) {
            h(r10, r11, r12, r13);
        }

        public static /* synthetic */ void c(Activity r10, AppInfo r11, View r12) {
            f(r10, r11, r12);
        }

        public static final void e(Activity r10, AppInfo r11, String r12, View r13) {
            q.g(r10, "$activity");
            q.g(r11, "$item");
            q.g(r12, "$pageSource");
            l8.a.a(r10, r13, r11, r12);
        }

        public static final void f(Activity r10, AppInfo r11, View r12) {
            q.g(r10, "$activity");
            q.g(r11, "$item");
            com.bytedanceos.common.toolbox.e.e1(r10, r11, 0, "");
        }

        public static final void h(Activity r10, AppInfo r11, String r12, View r13) {
            q.g(r10, "$activity");
            q.g(r11, "$item");
            q.g(r12, "$pageSource");
            l8.a.a(r10, r13, r11, r12);
        }

        public final void d(final Activity r10, ObricAppItemView r11, final AppInfo r12, final String r13) {
            q.g(r10, "activity");
            q.g(r11, "view");
            q.g(r12, "item");
            q.g(r13, "pageSource");
            r11.setOnClickListener(new d(r10, r12, r13), new e(r10, r12));
            r11.i(r12, r13);
        }

        public final void g(final Activity r10, ObricAppItemViewForSettings r11, final AppInfo r12) {
            q.g(r10, "activity");
            q.g(r11, "view");
            q.g(r12, "item");
            final String r13 = "sysapp_update_setting";
            r11.setOnClickListener(new f(r10, r12, r13), null);
            r11.i(r12, "sysapp_update_setting");
        }

        public a() {
        }
    }

    static {
        f11017k = new a(null);
    }

    public ItemAppProvider(String r10, boolean r11, boolean r12, Function3 r13, Integer r14, boolean r15, boolean r16, float r17) {
        q.g(r10, "pageSource");
        this.f11018c = r10;
        this.f11019d = r11;
        this.f11020e = r12;
        this.f11021f = r13;
        this.f11022g = r14;
        this.f11023h = r15;
        this.f11024i = r16;
        this.f11025j = r17;
    }

    @Override // com.obric.appstore.base.BaseListItemProvider
    public /* bridge */ /* synthetic */ ViewBinding a(ViewGroup r10) {
        return d(r10);
    }

    public void c(BaseViewHolder r10, IAppInfo r11) {
        q.g(r10, "helper");
        q.g(r11, "item");
        View r12 = ((BaseListItemProvider.b) b(r10)).getRoot();
        q.e(r12, "null cannot be cast to non-null type com.obric.appstore.common.core.ui.view.ObricAppItemView");
        ObricAppItemView r13 = (ObricAppItemView) r12;
        if (this.f11019d == true) goto L5;
    L8:
        boolean r14 = true;
    L10:
        if (this.f11024i == false) goto L12;
        r13.showLine(false);
    L13:
        Activity r15 = null;
        if (this.f11020e == false) goto L16;
        r13.setNumber(Integer.valueOf(r10.getAdapterPosition() + 1));
    L17:
        Context r16 = getContext();
        if ((r16 instanceof Activity) == false) goto L20;
        r15 = (Activity) r16;
    L20:
        if (r15 == null) goto L22;
        f11017k.d(r15, r13, r11.getAppInfo(), this.f11018c);
    L22:
        Function3 r17 = this.f11021f;
        if (r17 == null) goto L26;
        r17.invoke(Integer.valueOf(r10.getAdapterPosition()), r13, r11);
        return;
    L26:
        return;
    L16:
        r13.setNumber(null);
        goto L17
    L12:
        r13.showLine(r14);
        goto L13
    L5:
        if (e(r10.getAdapterPosition(), 3) == false) goto L8;
        r14 = false;
        goto L10
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, Object r11) {
        c(r10, (IAppInfo) r11);
    }

    public BaseListItemProvider.b d(ViewGroup r10) {
        q.g(r10, "parent");
        ObricAppItemView r11 = new ObricAppItemView(getContext(), null, 0, 6, null);
        if (this.f11019d == false) goto L6;
        AppItemViewStyle r12 = AppItemViewStyle.PAGER_HOR;
    L12:
        r11.p(r12);
        Integer r13 = this.f11022g;
        if (r13 == null) goto L15;
        r11.j(r13.intValue());
    L15:
        r11.setAppIconRadius(this.f11025j);
        return new BaseListItemProvider.b(r11);
    L6:
        if (this.f11020e == false) goto L9;
        r12 = AppItemViewStyle.SHOW_INDEX;
        goto L12
    L9:
        if (this.f11023h == false) goto L11;
        r12 = AppItemViewStyle.APP_INFO;
        goto L12
    L11:
        r12 = AppItemViewStyle.DEFAULT;
        goto L12
    }

    public final boolean e(int r10, int r11) {
        if (((r10 + 1) % r11) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.appstore.base.BaseListItemProvider, com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return ItemType.APP.ordinal();
    }

    public /* synthetic */ ItemAppProvider(String r13, boolean r14, boolean r15, Function3 r16, Integer r17, boolean r18, boolean r19, float r20, int r21, DefaultConstructorMarker r22) {
        if ((r21 & 4) == 0) goto L5;
        boolean r10 = false;
    L7:
        if ((r21 & 8) == 0) goto L9;
        Function3 r11 = null;
    L11:
        if ((r21 & 16) == 0) goto L13;
        Integer r12 = null;
    L15:
        if ((r21 & 32) == 0) goto L17;
        boolean r23 = false;
    L19:
        if ((r21 & 64) == 0) goto L21;
        boolean r110 = false;
    L23:
        if ((r21 & 128) == 0) goto L25;
        float r111 = TypedValue.applyDimension(1, 14, Resources.getSystem().getDisplayMetrics());
    L26:
        this(r13, r14, r10, r11, r12, r23, r110, r111);
        return;
    L25:
        r111 = r20;
        goto L26
    L21:
        r110 = r19;
        goto L23
    L17:
        r23 = r18;
        goto L19
    L13:
        r12 = r17;
        goto L15
    L9:
        r11 = r16;
        goto L11
    L5:
        r10 = r15;
        goto L7
    }
}
