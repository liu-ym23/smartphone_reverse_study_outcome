package com.bytedance.android.shopping.widget.rittag.viewimpl;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.response.RitTagUI;
import com.bytedance.android.shopping.widget.rittag.RitTagPart;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0007B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/widget/rittag/viewimpl/RitTagTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/bytedance/android/shopping/widget/rittag/b;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RitTagTextView extends AppCompatTextView implements com.bytedance.android.shopping.widget.rittag.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f187466b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f187467a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.widget.rittag.b
    public final View i() {
        return this;
    }

    public RitTagTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        int r101 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        this.f187467a = com.bytedance.android.ec.hybrid.list.util.c.d(2);
    }

    @Override // com.bytedance.android.shopping.widget.rittag.b
    public final void l(RitTagUI.RitTagUIItem r110, RitTagPart r111) {
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r111, "part");
        int r100 = s.f45717a;
        RitTagUI.RitTagUIItem.TextItem r101 = r110.getText();
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getTextColor();
    L6:
        setTextColor(s.a(r103, -50350));
        float[] r104 = r110.getRadius();
        RitTagUI.RitTagUIItem.TextItem r105 = r110.getText();
        if (r105 == null) goto L9;
        String r106 = r105.getTextBorderColor();
    L10:
        RitTagUI.RitTagUIItem.TextItem r107 = r110.getText();
        if (r107 == null) goto L13;
        String r108 = r107.getTextBgColor();
    L14:
        Drawable r109 = com.bytedance.android.shopping.widget.rittag.a.c(r104, Float.MAX_VALUE, r106, r108);
        int r112 = com.bytedance.android.shopping.widget.rittag.a.a();
        int r113 = c.f187471b[r111.ordinal()];
        if (r113 == 1) goto L23;
        if (r113 != 2) goto L18;
        setPadding(0, 0, 0, 0);
    L25:
        Intrinsics.checkNotNullParameter(this, "$this$setBackgroundCompat");
        setBackground(r109);
        RitTagUI.RitTagUIItem.TextItem r114 = r110.getText();
        if (r114 == null) goto L30;
        Float r115 = r114.leftPadding();
        if (r115 == null) goto L30;
        int r116 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        int r117 = com.bytedance.android.ec.hybrid.list.util.c.d(r115);
    L31:
        RitTagUI.RitTagUIItem.TextItem r118 = r110.getText();
        if (r118 == null) goto L36;
        Float r119 = r118.rightPadding();
        if (r119 == null) goto L36;
        int r120 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        int r121 = com.bytedance.android.ec.hybrid.list.util.c.d(r119);
    L37:
        setPadding(getPaddingLeft() + r117, getPaddingTop(), getPaddingRight() + r121, getPaddingBottom());
        RitTagUI.RitTagUIItem.TextItem r122 = r110.getText();
        if (r122 == null) goto L40;
        RitTagUI.RitTagUIItem.FontWeight r123 = r122.getWeight();
    L41:
        if (r123 == null) goto L46;
        int r124 = c.f187470a[r123.ordinal()];
        if (r124 == 1) goto L49;
        if (r124 == 2) goto L46;
        throw new NoWhenBranchMatchedException();
    L49:
        Typeface r125 = Typeface.DEFAULT_BOLD;
    L50:
        setTypeface(r125);
        RitTagUI.RitTagUIItem.TextItem r126 = r110.getText();
        if (r126 == null) goto L53;
        r102 = r126.getText();
    L53:
        if (r102 != null) goto L55;
        r102 = "";
    L55:
        setText(r102);
        return;
    L46:
        r125 = Typeface.DEFAULT;
        goto L50
    L40:
        r123 = null;
    L36:
        r121 = this.f187467a;
    L30:
        r117 = this.f187467a;
        goto L31
    L18:
        if (r113 != 3) goto L21;
        setPadding(r112, 0, 0, 0);
        InsetDrawable r127 = new InsetDrawable(r109, -r112, 0, 0, 0);
    L24:
        r109 = r127;
        goto L25
    L21:
        throw new NoWhenBranchMatchedException();
    L23:
        setPadding(0, 0, r112, 0);
        r127 = new InsetDrawable(r109, 0, 0, -r112, 0);
        goto L24
    L13:
        r108 = null;
        goto L14
    L9:
        r106 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }
}
