package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.broadcastgame.api.model.n0;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/tab/TabSelectorView;", "Landroid/widget/LinearLayout;", "", "key", "", "setSelect", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabSelectorView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f61607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f61608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f61609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n0 f61610d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public xl4.a f61611e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f61612f;

    public interface a {
        void a(String r100);
    }

    public TabSelectorView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TabSelectorView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void c() {
        this.f61609c = false;
        this.f61608b.setRotation(0.0f);
        xl4.a r100 = this.f61611e;
        if (r100 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        r100.dismiss();
    L5:
        this.f61611e = null;
    }

    private final void setSelect(String r100) {
        this.f61607a.setText(r100);
        n0 r101 = this.f61610d;
        if (r101 == null) goto L5;
        r101.f59365a = r100;
    L5:
        a r102 = this.f61612f;
        if (r102 == null) goto L9;
        r102.a(r100);
        return;
    }

    public static final /* synthetic */ void a(TabSelectorView r100, String r101) {
        r100.setSelect(r101);
    }

    public final void b(n0 r100, com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3.b r101) {
        c();
        this.f61610d = r100;
        this.f61612f = r101;
        TextView r102 = this.f61607a;
        if (r100 == null) goto L7;
        String r103 = r100.f59365a;
        if (r103 == null) goto L7;
    L11:
        r102.setText(r103);
        setOnClickListener(new c(this));
        return;
    L7:
        if (r100 == null) goto L9;
        String r104 = r100.defaultKey;
    L10:
        r103 = r104;
        goto L11
    L9:
        r104 = null;
        goto L10
    }

    public TabSelectorView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_tab_selector_view, this);
        this.f61607a = (TextView) findViewById(R.id.tv_selector_content);
        this.f61608b = (ImageView) findViewById(R.id.iv_selector_triangle);
    }

    public /* synthetic */ TabSelectorView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
