package com.bytedance.android.ec.store.search.history;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.c;
import cn.d;
import com.bytedance.android.shopping.store.utils.o;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\r\u001aB\u0019\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/store/search/history/HistoryBanner;", "Landroid/widget/FrameLayout;", "", "editing", "", "setEditing", "Landroid/widget/TextView;", "actionView", "setActionTextStyle", "", "iconId", "setDeleteIcon", "Lcom/bytedance/android/ec/store/search/history/HistoryBanner$b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/ec/store/search/history/HistoryBanner$b;", "getActionPerformListener", "()Lcom/bytedance/android/ec/store/search/history/HistoryBanner$b;", "setActionPerformListener", "(Lcom/bytedance/android/ec/store/search/history/HistoryBanner$b;)V", "actionPerformListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HistoryBanner extends FrameLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f48527d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f48528e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f48529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f48530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f48531c;

    public static final class a {
    }

    public interface b {
        void a();

        void b();

        void c();
    }

    public final void a() {
        setEditing(false);
    }

    public final void b() {
        setEditing(true);
    }

    static {
        f48527d = com.bytedance.android.shopping.extensions.b.b(24);
        f48528e = o.a(20);
    }

    public final b getActionPerformListener() {
        return this.f48529a;
    }

    private final void setActionTextStyle(TextView r100) {
        r100.setTextSize(2, 14.0f);
        r100.setTextColor(-9210757);
    }

    private final void setEditing(boolean r100) {
        LinearLayout r101 = this.f48530b;
        int r102 = 0;
        if (r101 == null) goto L8;
        if (r100 == false) goto L6;
        int r103 = 0;
    L7:
        r101.setVisibility(r103);
        goto L8
    L6:
        r103 = 8;
    L8:
        ImageView r104 = this.f48531c;
        if (r104 == null) goto L14;
        if (r100 == false) goto L12;
        r102 = 8;
    L12:
        r104.setVisibility(r102);
        return;
    }

    public final void setActionPerformListener(b r100) {
        this.f48529a = r100;
    }

    public final void setDeleteIcon(int r100) {
        ImageView r101 = this.f48531c;
        if (r101 == null) goto L6;
        r101.setImageResource(r100);
        return;
    }

    public HistoryBanner(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        TextView r102 = new TextView(getContext());
        r102.setTextColor(-15329245);
        r102.setTextSize(2, 15.0f);
        r102.setText("历史记录");
        addView(r102);
        TextView r103 = new TextView(getContext());
        r103.setText("完成");
        r103.setOnClickListener(new cn.b(this));
        TextView r104 = new TextView(getContext());
        r104.setText("全部删除");
        r104.setOnClickListener(new c(this));
        setActionTextStyle(r103);
        setActionTextStyle(r104);
        LinearLayout r105 = new LinearLayout(getContext());
        this.f48530b = r105;
        r105.addView(r104);
        cn.a r106 = new cn.a(getContext());
        ViewGroup.LayoutParams r107 = new ViewGroup.LayoutParams(f48527d, -1);
        LinearLayout r108 = this.f48530b;
        if (r108 == null) goto L5;
        r108.addView(r106, r107);
    L5:
        LinearLayout r109 = this.f48530b;
        if (r109 == null) goto L8;
        r109.addView(r103);
    L8:
        FrameLayout.LayoutParams r110 = new FrameLayout.LayoutParams(-2, -2);
        r110.gravity = 8388629;
        addView(this.f48530b, r110);
        LinearLayout r111 = this.f48530b;
        if (r111 == null) goto L11;
        r111.setVisibility(8);
    L11:
        this.f48531c = new ImageView(getContext());
        int r112 = f48528e;
        FrameLayout.LayoutParams r113 = new FrameLayout.LayoutParams(r112, r112);
        r113.gravity = 8388629;
        ImageView r114 = this.f48531c;
        if (r114 == null) goto L14;
        r114.setOnClickListener(new d(this));
    L14:
        addView(this.f48531c, r113);
    }
}
