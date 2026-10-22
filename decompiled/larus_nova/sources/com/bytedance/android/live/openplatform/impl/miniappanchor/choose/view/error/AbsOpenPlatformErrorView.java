package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.view.error;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import op0.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/view/error/AbsOpenPlatformErrorView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "getLayoutId", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsOpenPlatformErrorView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f84320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f84321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f84322c;

    public abstract int getLayoutId();

    public final void R5() {
        setVisibility(8);
    }

    public AbsOpenPlatformErrorView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void S5(String r110) {
        Intrinsics.checkNotNullParameter(r110, "errorTips");
        Intrinsics.checkNotNullParameter(r110, "errorTips");
        T5(new a(true, R.drawable.ttlive_mini_app_choose_list_empty, true, r110, false, "", null));
    }

    public final void T5(a r100) {
        Intrinsics.checkNotNullParameter(r100, "errorViewConfig");
        setVisibility(0);
        if (r100.f524678a == false) goto L10;
        ImageView r101 = this.f84320a;
        if (r101 == null) goto L7;
        r101.setVisibility(0);
    L7:
        ImageView r102 = this.f84320a;
        if (r102 == null) goto L14;
        r102.setImageResource(r100.f524679b);
    L14:
        if (r100.f524680c == false) goto L21;
        TextView r103 = this.f84321b;
        if (r103 == null) goto L18;
        r103.setVisibility(0);
    L18:
        TextView r104 = this.f84321b;
        if (r104 == null) goto L25;
        r104.setText(r100.f524681d);
    L25:
        if (r100.f524682e == false) goto L35;
        TextView r105 = this.f84322c;
        if (r105 == null) goto L29;
        r105.setVisibility(0);
    L29:
        TextView r106 = this.f84322c;
        if (r106 == null) goto L32;
        r106.setText(r100.f524683f);
    L32:
        TextView r107 = this.f84322c;
        if (r107 == null) goto L39;
        r107.setOnClickListener(r100.f524684g);
        return;
    L39:
        return;
    L35:
        TextView r108 = this.f84322c;
        if (r108 == null) goto L41;
        r108.setVisibility(8);
        return;
    L41:
        return;
    L21:
        TextView r109 = this.f84321b;
        if (r109 == null) goto L25;
        r109.setVisibility(8);
        goto L25
    L10:
        ImageView r110 = this.f84320a;
        if (r110 == null) goto L14;
        r110.setVisibility(8);
        goto L14
    }

    public final void U5(View.OnClickListener r110) {
        String r100 = s1.B(R.string.ttlive_mini_app_choose_list_network_error_tip);
        Intrinsics.checkNotNullParameter(r100, "errorTips");
        String r101 = s1.B(R.string.ttlive_mini_app_choose_list_refresh);
        Intrinsics.checkNotNullParameter(r101, "errorButtonTips");
        T5(new a(true, R.drawable.ttlive_mini_app_choose_list_network_error, true, r100, true, r101, r110));
    }

    public AbsOpenPlatformErrorView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public AbsOpenPlatformErrorView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(getLayoutId(), this);
        this.f84320a = (ImageView) findViewById(R.id.error_image);
        this.f84321b = (TextView) findViewById(R.id.error_tips);
        this.f84322c = (TextView) findViewById(R.id.error_btn);
        setVisibility(8);
    }
}
