package com.bytedance.android.ec.store.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000fB'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/store/view/ECShopCouponStateButton;", "Landroid/widget/FrameLayout;", "", "code", "", "setStateCode", "getStateCode", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopCouponStateButton extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f48746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, a> f48747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f48748c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f48749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f48750b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Drawable f48751c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f48749a, r101.f48749a) == true) goto L8;
            return false;
        L8:
            if (this.f48750b == r101.f48750b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f48751c, r101.f48751c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f48749a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = ((r102 * 31) + this.f48750b) * 31;
            Drawable r104 = this.f48751c;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "StateUIConfig(text=" + this.f48749a + ", textColor=" + this.f48750b + ", backgroundDrawable=" + this.f48751c + ")";
        }

        public a(String r100, int r101, Drawable r102) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f48749a = r100;
            this.f48750b = r101;
            this.f48751c = r102;
        }
    }

    public ECShopCouponStateButton(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECShopCouponStateButton(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final String getStateCode() {
        return this.f48746a;
    }

    public final void setStateCode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "code");
        this.f48746a = r100;
        a r101 = (a) ((LinkedHashMap) this.f48747b).get(r100);
        if (r101 == null) goto L6;
        this.f48748c.setText(r101.f48749a);
        this.f48748c.setTextColor(r101.f48750b);
        this.f48748c.setBackground(r101.f48751c);
        return;
    }

    public ECShopCouponStateButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f48747b = new LinkedHashMap();
        TextView r103 = new TextView(r100);
        r103.setTextSize(2, 12.0f);
        r103.setTextAlignment(4);
        r103.setPadding(ExtensionsKt.a(8), ExtensionsKt.a(4), ExtensionsKt.a(8), ExtensionsKt.a(4));
        com.bytedance.android.shopping.extensions.f.e(r103, 500);
        Unit r104 = Unit.INSTANCE;
        this.f48748c = r103;
        setBackgroundColor(0);
        addView(r103, new FrameLayout.LayoutParams(-2, -2));
    }

    public /* synthetic */ ECShopCouponStateButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
