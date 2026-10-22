package com.bytedance.android.ec.common.impl.sku.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.model.ECUrlModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/view/SpecItemView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "hostType", "", "setUnSelect", "(Ljava/lang/Integer;)V", "setSelect", "setGray", "Lcom/bytedance/android/ec/common/impl/sku/view/k;", "clickListener", "setItemClickListener", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SpecItemView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f43466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f43467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n.c f43468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f43469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SpecItemGroupLayout.e f43470e;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SpecItemView f43472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f43473b;

        public a(SpecItemView r100, k r101) {
            this.f43472a = r100;
            this.f43473b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            n.c r101 = this.f43472a.f43468c;
            if ((r100 instanceof TextView) == true) goto L5;
            r100 = null;
        L5:
            TextView r102 = (TextView) r100;
            if (r101 == null) goto L10;
            if (r102 == null) goto L11;
            this.f43473b.a(r101);
            return;
        L11:
            return;
        }
    }

    private final void setGray(Integer r100) {
        if (r100 != null) goto L5;
    L7:
        setBackgroundResource(R.drawable.shopping_bg_sku_tag_border);
    L8:
        setTextColor(th.a.a(getContext(), R.color.shopping_std_text_black_4));
        return;
    L5:
        if (r100.intValue() != 4) goto L7;
        setBackgroundResource(R.drawable.shopping_bg_sku_panel_item_un_check);
        goto L8
    }

    private final void setSelect(Integer r100) {
        if (r100 != null) goto L5;
    L7:
        setBackgroundResource(R.drawable.shopping_bg_red_round);
        setTextColor(th.a.a(getContext(), R.color.commerce_bg_primary));
        return;
    L5:
        if (r100.intValue() != 4) goto L7;
        setBackgroundResource(R.drawable.shopping_bg_sku_panel_check);
        setTextColor(th.a.a(getContext(), R.color.shopping_std_brand));
    }

    private final void setUnSelect(Integer r100) {
        if (r100 != null) goto L5;
    L7:
        setBackgroundResource(R.drawable.shopping_bg_sku_tag_border);
        setTextColor(th.a.a(getContext(), R.color.commerce_text_reverse_3));
        return;
    L5:
        if (r100.intValue() != 4) goto L7;
        setBackgroundResource(R.drawable.shopping_bg_sku_panel_item_un_check);
        setTextColor(th.a.a(getContext(), R.color.shopping_std_text_black_2));
    }

    public final void setItemClickListener(k r100) {
        Intrinsics.checkNotNullParameter(r100, "clickListener");
        setOnClickListener(new a(this, r100));
    }

    public SpecItemView(Context r100, n r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 0);
        this.f43470e = r101;
        AccessibilityDelegateCompat r102 = new AnonymousClass1(this);
        int r103 = jg.a.f498940a;
        ViewCompat.setAccessibilityDelegate(this, r102);
    }

    public final void y(n.c r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "viewInfo");
        String r102 = null;
        if (Intrinsics.areEqual(r101, r100.f43545b) == false) goto L14;
        SpecItemGroupLayout.e r103 = this.f43470e;
        if (r103 == null) goto L10;
        n.c r104 = r103.getCheckedItemViewInfo();
        if (r104 == null) goto L10;
        r102 = r104.f43545b;
    L10:
        if ((!Intrinsics.areEqual(r102, r101)) == false) goto L12;
        this.f43469d = true;
        setSelect(this.f43466a);
        return;
    L12:
        this.f43469d = true;
        return;
    L14:
        if (r100.equals(this.f43468c) == true) goto L22;
        n.c r105 = new n.c(r100.f43545b, r100.f43546c, r100.f43547d, r100.f43548e);
        r105.f43544a = r100.f43544a;
        this.f43468c = r105;
        if ((!Intrinsics.areEqual(this.f43467b, Boolean.TRUE)) == false) goto L18;
    L21:
        this.f43469d = false;
        setGray(this.f43466a);
        return;
    L18:
        if (r100.f43544a == false) goto L21;
        this.f43469d = false;
        setUnSelect(this.f43466a);
        return;
    L22:
        SpecItemGroupLayout.e r106 = this.f43470e;
        if (r106 == null) goto L27;
        n.c r107 = r106.getCheckedItemViewInfo();
        if (r107 == null) goto L27;
        String r108 = r107.f43545b;
    L28:
        n.c r109 = this.f43468c;
        if (r109 == null) goto L32;
        r102 = r109.f43545b;
    L32:
        if (Intrinsics.areEqual(r108, r102) == false) goto L40;
        this.f43469d = false;
        if ((!Intrinsics.areEqual(this.f43467b, Boolean.TRUE)) == false) goto L36;
    L39:
        setGray(this.f43466a);
        return;
    L36:
        if (r100.f43544a == false) goto L39;
        setUnSelect(this.f43466a);
        return;
    L40:
        this.f43469d = false;
        return;
    L27:
        r108 = null;
        goto L28
    }

    public final void x(n.c r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "itemInfo");
        boolean r103 = r100.f43544a;
        n.c r104 = this.f43468c;
        if (r104 != null) goto L5;
    L15:
        this.f43466a = Integer.valueOf(r101);
        this.f43467b = Boolean.valueOf(r102);
        this.f43469d = false;
        boolean r105 = r100.f43544a;
        if (r102 == false) goto L20;
        if (r105 == false) goto L20;
        setUnSelect(Integer.valueOf(r101));
    L22:
        if (r100.equals(this.f43468c) == true) goto L27;
        setText(r100.f43546c);
        ECUrlModel r106 = r100.f43548e;
        if (r106 == null) goto L26;
        com.bytedance.android.ec.core.utils.y.l(r106, 0, 0, new d0(this));
    L26:
        n.c r107 = new n.c(r100.f43545b, r100.f43546c, r100.f43547d, r100.f43548e);
        r107.f43544a = r100.f43544a;
        this.f43468c = r107;
    L27:
        this.f43469d = false;
        return;
    L20:
        setGray(Integer.valueOf(r101));
        goto L22
    L5:
        if (r103 != r104.f43544a) goto L15;
        if (this.f43469d == true) goto L15;
        if ((!Intrinsics.areEqual(Boolean.valueOf(r102), this.f43467b)) == true) goto L15;
        Integer r108 = this.f43466a;
        if (r108 == null) goto L15;
        if (r101 == r108.intValue()) goto L22;
        goto L15
    }
}
