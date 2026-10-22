package com.obric.appstore.buss.debug;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.appstore.R;
import com.obric.appstore.base.e;
import com.obric.appstore.util.ApiEvn;
import com.obric.oui.dialog.alert.OAlertDialogBuilder;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.Metadata;
import sa.q;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u0003R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/obric/appstore/buss/debug/DebugFragment;", "Lcom/obric/appstore/base/e;", "<init>", "()V", "Landroid/view/View;", ServerElements.CONTENT, "", "B", "(Landroid/view/View;)V", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "Lsa/q;", "h", "Lsa/q;", "contentBinding", "", "w", "()I", "layoutId", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DebugFragment extends e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q f10609h;

    public DebugFragment() {
    }

    public static /* synthetic */ void F(DebugFragment r10, View r11) {
        H(r10, r11);
    }

    public static final /* synthetic */ q G(DebugFragment r10) {
        return r10.f10609h;
    }

    public static final void H(final DebugFragment r10, View r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        final FragmentActivity r12 = r10.getActivity();
        if (r12 != null) goto L5;
        return;
    L5:
        OAlertDialogBuilder r13 = new OAlertDialogBuilder(r12);
        OAlertDialogBuilder.P(r13, "确认重启", false, 2, null);
        r13.t("重启应用后，配置才生效");
        r13.b(false);
        r13.y("取消", DebugFragment$onViewCreated$1$1$1$1.INSTANCE);
        r13.K("重启", new DebugFragment$onViewCreated$1$1$1$2(r10, r12));
        r13.i();
    }

    @Override // com.obric.appstore.base.e
    public void B(View r10) {
        kotlin.jvm.internal.q.g(r10, ServerElements.CONTENT);
        super.B(r10);
        q r11 = q.a(r10);
        r11.f24665d.setText("1.0.3 (100003070, release, 2026-08-27 00:04:46)");
        r11.f24663b.setText("fab1af5f,a80d3b82,2bd8f26b,85579b36,5ad573e1");
        r11.f24664c.setText(ApiEvn.f11052a.a());
        this.f10609h = r11;
    }

    @Override // com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f10609h = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        kotlin.jvm.internal.q.g(r10, "view");
        super.onViewCreated(r10, r11);
        OFloatingTitleBar r12 = y();
        if (r12 == null) goto L6;
        r12.setCenterTitle("调试");
        String r13 = getString(R.string.debug_label_save);
        kotlin.jvm.internal.q.f(r13, "getString(...)");
        r12.i(r13, -1, new a(this));
        return;
    }

    @Override // com.obric.appstore.base.e
    public int w() {
        return R.layout.obric_fragment_debug;
    }
}
