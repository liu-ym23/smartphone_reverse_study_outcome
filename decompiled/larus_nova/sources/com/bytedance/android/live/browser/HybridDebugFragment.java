package com.bytedance.android.live.browser;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.bytedance.android.annie.resource.AnnieGeckoClient;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.config.wj1;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.uicomponent.compoundbutton.TranslucentSwitch;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/browser/HybridDebugFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HybridDebugFragment extends LiveDialogFragment {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f62558k = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f62559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f62560e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f62561f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w f62562g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f62563h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f62564i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TranslucentSwitch f62565j;

    public static final class a {
    }

    static {
    }

    public HybridDebugFragment() {
        this.f62560e = Boolean.FALSE;
        this.f62562g = (w) jc1.k.f(w.class);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        Dialog r101 = getDialog();
        if (r101 != null) goto L25;
    L9:
        if (r101 == null) goto L11;
        r101.setCanceledOnTouchOutside(true);
    L11:
        super.onActivityCreated(r100);
        if (r101 == null) goto L14;
        Window r102 = r101.getWindow();
    L15:
        if (r102 == null) goto L27;
        int r103 = t6.c(getContext());
        int r104 = t6.b(getContext());
        r102.setBackgroundDrawable(new ColorDrawable(0));
        if (isVertical() == false) goto L19;
        r102.setGravity(16);
        r102.setLayout(r103, r104);
    L23:
        r102.setFlags(1024, 1024);
        WindowManager.LayoutParams r105 = r102.getAttributes();
        r105.dimAmount = 0.0f;
        r102.setAttributes(r105);
        return;
    L19:
        r102.setGravity(8388629);
        r102.setLayout(-1, -1);
        WindowManager.LayoutParams r106 = r102.getAttributes();
        if (getContext() == null) goto L22;
        r106.horizontalMargin = t6.a(getContext(), 8.0f) / t6.b(getContext());
    L22:
        r102.setAttributes(r106);
        goto L23
    L27:
        return;
    L14:
        r102 = null;
        goto L15
    L25:
        r101.requestWindowFeature(1);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        ALogger.e("LiveDialogUtil", e);
        goto L9
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_CommonBottomDialog);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Bundle r102 = getArguments();
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.getString("url");
    L6:
        this.f62559d = r104;
        boolean r105 = false;
        if (r102 == null) goto L9;
        Boolean r106 = Boolean.valueOf(r102.getBoolean("is_lynx", false));
    L10:
        this.f62560e = r106;
        if (r102 == null) goto L13;
        r103 = r102.getString("origin_schema", null);
    L13:
        this.f62561f = r103;
        this.f62563h = (TextView) requireView().findViewById(R.id.current_url);
        this.f62564i = (TextView) requireView().findViewById(R.id.params_tv);
        this.f62565j = (TranslucentSwitch) requireView().findViewById(R.id.lynx_devtool_switch);
        TextView r107 = this.f62563h;
        if (r107 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("current_url");
    L16:
        r107.setText(this.f62561f);
        URL r108 = new URL(this.f62559d);     // Catch: MalformedURLException -> L25
        TextView r109 = this.f62564i;     // Catch: MalformedURLException -> L25
        if (r109 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("params_tv");     // Catch: MalformedURLException -> L25
    L20:
        r109.setText(r108.getQuery());     // Catch: MalformedURLException -> L25
        TextView r110 = this.f62563h;     // Catch: MalformedURLException -> L25
        if (r110 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("current_url");     // Catch: MalformedURLException -> L25
    L23:
        r110.setText(r108.getProtocol() + "://" + r108.getHost() + r108.getPath());     // Catch: MalformedURLException -> L25
    L26:
        boolean r111 = true;
        if (Intrinsics.areEqual(this.f62560e, Boolean.TRUE) == false) goto L37;
        if (LiveConfigSettingKeys.ENABLE_LYNX_OFFLINE.getValue().booleanValue() == false) goto L44;
        int r112 = p20.c.f527360a;
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L34;
        r111 = AnnieConfigSettingKeys.OFFLINE_SWITCH.a().booleanValue();
    L34:
        if (r111 == false) goto L44;
        AnnieGeckoClient r113 = com.bytedance.android.annie.resource.i.f39797a;
        com.bytedance.android.annie.resource.i.a(this.f62559d);
    L44:
        TranslucentSwitch r114 = this.f62565j;
        if (r114 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("lynx_devtool_switch");
    L47:
        w r115 = this.f62562g;
        if (r115 == null) goto L50;
        r105 = r115.isEnableDevtoolDebug();
    L50:
        r114.setChecked(r105);
        TranslucentSwitch r116 = this.f62565j;
        if (r116 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("lynx_devtool_switch");
    L53:
        r116.setOnCheckedChangeListener(new s(this));
        return;
    L37:
        if (wj1.f121532a.getValue().booleanValue() == false) goto L44;
        int r117 = p20.c.f527360a;
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L42;
        r111 = AnnieConfigSettingKeys.OFFLINE_SWITCH.a().booleanValue();
    L42:
        if (r111 == false) goto L44;
        AnnieGeckoClient r118 = com.bytedance.android.annie.resource.i.f39797a;
        com.bytedance.android.annie.resource.i.a(this.f62559d);
        goto L44
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_fragment_hybrid_debug, r101, false);
    }
}
