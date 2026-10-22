package com.bytedance.android.shopping.store.tabkit.container;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.store.tabkit.TabKitFragment;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFirstFramePref;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFramePref;
import com.bytedance.android.shopping.store.tabkit.router.TabKitRouterParams;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/container/TabKitDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabKitDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final boolean f186703j = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TabKitFragment f186704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f186705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bundle f186706f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TabKitRouterParams f186707g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f186708h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f186709i;

    public static final class a {
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return R.style.TabKitDialogTheme;
    }

    static {
        int r100 = hk3.a.f485544a;
        int r101 = n.f45241a;
        Object r102 = Boolean.FALSE;
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L166
        Object r105 = null;
        Object r106 = com.bytedance.android.ec.base.settings.d.f42818c.get("tabkit_lite_page_enable_show_now");     // Catch: Throwable -> L57
        if (r106 != null) goto L9;
    L54:
        Object r107 = null;
    L55:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L57
    L59:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L166
        if (r109 == null) goto L63;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L166
    L63:
        if (Result.m9455isFailureimpl(r108) == false) goto L66;
        r108 = null;
    L66:
        if ((r108 instanceof Boolean) == true) goto L68;
        r108 = null;
    L68:
        Object r110 = (Boolean) r108;     // Catch: Throwable -> L166
        if (r110 != null) goto L75;
        Object r111 = com.bytedance.android.ec.base.settings.d.f42816a.get("tabkit_lite_page_enable_show_now");     // Catch: Throwable -> L166
        if ((r111 instanceof Boolean) == true) goto L74;
        r111 = null;
    L74:
        r110 = (Boolean) r111;     // Catch: Throwable -> L166
    L75:
        if (r110 != null) goto L175;
        int r112 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L166
        Object r113 = com.bytedance.android.ec.base.settings.d.f42818c.get("tabkit_lite_page_enable_show_now");     // Catch: Throwable -> L130
        if (r113 != null) goto L82;
    L127:
        Object r114 = null;
    L128:
        Object r115 = Result.m9449constructorimpl(r114);     // Catch: Throwable -> L130
    L132:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);     // Catch: Throwable -> L156
        if (r116 == null) goto L136;
        EnsureManager.ensureNotReachHere(r116);     // Catch: Throwable -> L156
    L136:
        if (Result.m9455isFailureimpl(r115) == false) goto L139;
        r115 = null;
    L139:
        if ((r115 instanceof Boolean) == true) goto L141;
        r115 = null;
    L141:
        r110 = (Boolean) r115;     // Catch: Throwable -> L156
        if (r110 != null) goto L164;
        IHybridHostService r117 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r117 == null) goto L147;
        Object r118 = r117.getHostABValue("tabkit_lite_page_enable_show_now", r102);     // Catch: Throwable -> L156
    L148:
        if (r118 != null) goto L150;
    L155:
        r110 = r102;
        goto L164
    L150:
        if ((r118 instanceof Boolean) == false) goto L153;
        r105 = r118;
    L153:
        Object r119 = (Boolean) r105;     // Catch: Throwable -> L156
        if (r119 == null) goto L155;
    L163:
        r110 = r119;
        goto L164
    L147:
        r118 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("tabkit_lite_page_enable_show_now", r110);     // Catch: Throwable -> L166
        goto L175
    L82:
        if ((r113 instanceof Boolean) == true) goto L84;
        Object r120 = null;
    L85:
        r114 = (Boolean) r120;     // Catch: Throwable -> L130
        if (r114 != null) goto L128;
        if ((r113 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r121 = Float.valueOf(((Number) r113).floatValue());     // Catch: Throwable -> L130
        if ((r121 instanceof Boolean) == true) goto L95;
        r121 = null;
    L95:
        r114 = (Boolean) r121;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r122 = Double.valueOf(((Number) r113).doubleValue());     // Catch: Throwable -> L130
        if ((r122 instanceof Boolean) == true) goto L101;
        r122 = null;
    L101:
        r114 = (Boolean) r122;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r123 = Integer.valueOf(((Number) r113).intValue());     // Catch: Throwable -> L130
        if ((r123 instanceof Boolean) == true) goto L107;
        r123 = null;
    L107:
        r114 = (Boolean) r123;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r124 = Long.valueOf(((Number) r113).longValue());     // Catch: Throwable -> L130
        if ((r124 instanceof Boolean) == true) goto L113;
        r124 = null;
    L113:
        r114 = (Boolean) r124;     // Catch: Throwable -> L130
    L115:
        if ((r113 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L123
        Object r125 = SDKSettingsCacheManager.a().fromJson(r113.toString(), Boolean.class);     // Catch: Throwable -> L123
        if ((r125 instanceof Boolean) == true) goto L121;
        r125 = null;
    L121:
        Object r126 = Result.m9449constructorimpl((Boolean) r125);     // Catch: Throwable -> L123
    L125:
        r114 = r126;
        if (Result.m9455isFailureimpl(r114) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L130
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r113 instanceof JSONArray) == false) goto L127;
    L84:
        r120 = r113;
    L156:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L166
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r129 = Result.m9452exceptionOrNullimpl(r119);     // Catch: Throwable -> L166
        if (r129 == null) goto L161;
        EnsureManager.ensureNotReachHere(r129);     // Catch: Throwable -> L166
    L161:
        if (Result.m9455isFailureimpl(r119) == false) goto L163;
        r119 = r102;
    L130:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L156
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L175:
        f186703j = ((Boolean) r110).booleanValue();
        return;
    L9:
        if ((r106 instanceof Boolean) == true) goto L11;
        Object r131 = null;
    L12:
        r107 = (Boolean) r131;     // Catch: Throwable -> L57
        if (r107 != null) goto L55;
        if ((r106 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r132 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Boolean) == true) goto L22;
        r132 = null;
    L22:
        r107 = (Boolean) r132;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r133 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L57
        if ((r133 instanceof Boolean) == true) goto L28;
        r133 = null;
    L28:
        r107 = (Boolean) r133;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r134 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L57
        if ((r134 instanceof Boolean) == true) goto L34;
        r134 = null;
    L34:
        r107 = (Boolean) r134;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r135 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L57
        if ((r135 instanceof Boolean) == true) goto L40;
        r135 = null;
    L40:
        r107 = (Boolean) r135;     // Catch: Throwable -> L57
    L42:
        if ((r106 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r136 = SDKSettingsCacheManager.a().fromJson(r106.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r136 instanceof Boolean) == true) goto L48;
        r136 = null;
    L48:
        Object r137 = Result.m9449constructorimpl((Boolean) r136);     // Catch: Throwable -> L50
    L52:
        r107 = r137;
        if (Result.m9455isFailureimpl(r107) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L57
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r106 instanceof JSONArray) == false) goto L54;
    L11:
        r131 = r106;
    L57:
        th = move-exception;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L166
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        Object r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r142 = Result.m9452exceptionOrNullimpl(r141);
        if (r142 == null) goto L171;
        EnsureManager.ensureNotReachHere(r142);
    L171:
        if (Result.m9455isFailureimpl(r141) == true) goto L174;
        r102 = r141;
    L174:
        r110 = r102;
        goto L175
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        i.b(this.f186708h, Type.FRAGMENT, Action.ON_DESTROY);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        int r100 = ik3.a.f490268a;
        ik3.a.a(this, this.f186707g);
        i.a("fragment onPause, unique id=" + this.f186708h);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        i.a("fragment onResume, unique id=" + this.f186708h);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        if (this.f186709i == true) goto L10;
        Function0<Unit> r100 = new TabKitDialogFragment$initDebugTag$1(this);
        Intrinsics.checkNotNullParameter(r100, "block");
        if (ECAppInfoService.f48114e.isLocalTest() == false) goto L9;
        r100.invoke();
        return;
    L9:
        return;
    }

    public TabKitDialogFragment() {
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        d.a(r100);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        Bundle r101 = getArguments();
        if (r101 == null) goto L6;
        String r102 = r101.getString("key_tabkit_root_fragment_id");
        if (r102 == null) goto L6;
    L7:
        this.f186708h = r102;
        i.a("fragment onCreate, unique id=" + this.f186708h + ", ctx=" + getContext());
        i.b(this.f186708h, Type.FRAGMENT, Action.ON_CREATE);
        Bundle r103 = getArguments();
        if (r103 == null) goto L10;
        Bundle r104 = r103.getBundle("biz_arguments");
    L11:
        this.f186706f = r104;
        if (r104 == null) goto L14;
        Object r105 = r104.get(TabKitRouterParams.KEY_ROUTER_PARAMS);
    L16:
        if ((r105 instanceof TabKitRouterParams) == true) goto L18;
        r105 = null;
    L18:
        this.f186707g = (TabKitRouterParams) r105;
        Bundle r106 = this.f186706f;
        if (r106 == null) goto L23;
        long r107 = r106.getLong(TabkitFirstFramePref.KEY_TABKIT_MONITOR);
        Map<Long, TabkitFirstFramePref> r108 = ok3.a.f523622e;
        TabkitFirstFramePref r109 = ok3.a.C7061a.a(r107);
        if (r109 == null) goto L23;
        TabkitFramePref.recordTime$default(r109, "t_on_create_fragment", null, 2, null);
    L23:
        super.onCreate(r100);
        return;
    L14:
        r105 = null;
        goto L16
    L10:
        r104 = null;
    L6:
        r102 = "";
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Bundle r102 = this.f186706f;
        TabKitFragment r103 = null;
        if (r102 == null) goto L7;
        long r104 = r102.getLong(TabkitFirstFramePref.KEY_TABKIT_MONITOR);
        Map<Long, TabkitFirstFramePref> r105 = ok3.a.f523622e;
        TabkitFirstFramePref r106 = ok3.a.C7061a.a(r104);
        if (r106 == null) goto L7;
        TabkitFramePref.recordTime$default(r106, "t_on_view_created_fragment", null, 2, null);
    L7:
        super.onViewCreated(r100, r101);
        if (r101 != null) goto L39;
        int r107 = ik3.a.f490268a;
        TabKitRouterParams r108 = this.f186707g;
        if (r108 == null) goto L12;
        String r109 = r108.getPageEnterAnim();
    L13:
        if (r109 != null) goto L16;
    L21:
        int r110 = R.style.TabKitDialogAnimation;
    L22:
        Dialog r111 = getDialog();
        if (r111 == null) goto L29;
        Window r112 = r111.getWindow();
        if (r112 == null) goto L29;
        WindowManager.LayoutParams r113 = r112.getAttributes();
        if (r113 == null) goto L29;
        Integer r114 = Integer.valueOf(r113.windowAnimations);
    L30:
        if (r114 != null) goto L33;
    L34:
        Dialog r115 = getDialog();
        if (r115 == null) goto L40;
        Window r116 = r115.getWindow();
        if (r116 == null) goto L40;
        r116.setWindowAnimations(r110);
    L40:
        View r117 = r100.findViewById(R.id.tabkit_fragment_root);
        if ((r117 instanceof FrameLayout) == true) goto L43;
        r117 = null;
    L43:
        this.f186705e = (FrameLayout) r117;
        Fragment r118 = getChildFragmentManager().findFragmentByTag("tabkit_fragment");
        if ((r118 instanceof TabKitFragment) == true) goto L46;
        r118 = null;
    L46:
        TabKitFragment r119 = (TabKitFragment) r118;
        this.f186704d = r119;
        if (r119 != null) goto L73;
        Bundle r120 = getArguments();
        if (r120 == null) goto L51;
        Serializable r121 = r120.getSerializable("tabkit_fragment_clazz");
    L53:
        if ((r121 instanceof Class) == true) goto L55;
        r121 = null;
    L55:
        Class r122 = (Class) r121;
        if (r122 == null) goto L60;
        Constructor r123 = r122.getDeclaredConstructor(new Class[0]);
        if (r123 == null) goto L60;
        r103 = (TabKitFragment) r123.newInstance(new Object[0]);
    L60:
        this.f186704d = r103;
        if (r103 == null) goto L66;
        Bundle r124 = new Bundle();
        Bundle r125 = this.f186706f;
        if (r125 == null) goto L65;
        r124.putAll(r125);
    L65:
        Unit r126 = Unit.INSTANCE;
        r103.setArguments(r124);
    L66:
        TabKitFragment r127 = this.f186704d;
        if (r127 == null) goto L73;
        FragmentTransaction r128 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r128, r127, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "tabkit_fragment", R.id.tabkit_fragment_root) == true) goto L72;
        r128.add(R.id.tabkit_fragment_root, r127, "tabkit_fragment");
    L72:
        r128.commitNowAllowingStateLoss();
        goto L73
    L51:
        r121 = null;
    L73:
        Dialog r129 = getDialog();
        if (r129 == null) goto L78;
        Window r130 = r129.getWindow();
        if (r130 == null) goto L78;
        l0.d(r130);
    L78:
        Dialog r131 = getDialog();
        if (r131 == null) goto L82;
        r131.setOnKeyListener(new h(this));
        return;
    L82:
        return;
    L33:
        if (r114.intValue() == r110) goto L40;
    L29:
        r114 = null;
        goto L30
    L16:
        if (r109.hashCode() != 3135100) goto L21;
        if (r109.equals("fade") == false) goto L21;
        r110 = R.style.TabKitDialogAnimationFade;
        goto L22
    L12:
        r109 = null;
        goto L13
    L39:
        int r132 = ik3.a.f490268a;
        ik3.a.a(this, this.f186707g);
        goto L40
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ec_tabkit_fragment, r101);
    }
}
