package com.bytedance.android.shopping.verify;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.extensions.j;
import com.bytedance.common.utility.UIUtils;
import com.google.gson.Gson;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lh3.i;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/verify/LawHintDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LawHintDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f187164p = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f187165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f187166e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f187167f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f187168g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CheckBox f187169h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f187170i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f187171j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f187172k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f187173l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CompositeDisposable f187174m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f187175n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function2<? super Boolean, ? super Boolean, Unit> f187176o;

    public static final class a {
    }

    static {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        if (this.f187173l == true) goto L8;
        Function2<? super Boolean, ? super Boolean, Unit> r100 = this.f187176o;
        if (r100 == null) goto L9;
        Unit r101 = r100.invoke(Boolean.valueOf(this.f187172k), Boolean.FALSE);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f187173l = false;
        int r100 = lh3.b.f509238a;
        Lazy r101 = ECSettingKeys.f43616a;     // Catch: Exception -> L16
        int r102 = p.f45243a;     // Catch: Exception -> L16
        Object r103 = "{\"main_title\":\"服务授权\",\"desc\":\"同意授权小店获取你的账号信息（昵称、头像信息）\",\"agree_desc\":\"已经阅读并同意%laws_placeholder及%laws_placeholder\",\"laws\":[{\"link\":\"https://school.jinritemai.com/doudian/web/article/104868?noNav=true&from=douyin_shop_detail\",\"title\":\"《平台用户协议》\"},{\"link\":\"https://school.jinritemai.com/doudian/web/article/104870?noNav=true&from=douyin_shop_detail\",\"title\":\"《平台隐私政策》\"}],\"confirm\":\"授权\",\"later\":\"下次再说\"}";
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L8
        jj4.b r105 = jj4.b.f499326b;     // Catch: Throwable -> L8
        Object r106 = jj4.a.a("ec_disclaimer_description_new", String.class, "{\"main_title\":\"服务授权\",\"desc\":\"同意授权小店获取你的账号信息（昵称、头像信息）\",\"agree_desc\":\"已经阅读并同意%laws_placeholder及%laws_placeholder\",\"laws\":[{\"link\":\"https://school.jinritemai.com/doudian/web/article/104868?noNav=true&from=douyin_shop_detail\",\"title\":\"《平台用户协议》\"},{\"link\":\"https://school.jinritemai.com/doudian/web/article/104870?noNav=true&from=douyin_shop_detail\",\"title\":\"《平台隐私政策》\"}],\"confirm\":\"授权\",\"later\":\"下次再说\"}", false);     // Catch: Throwable -> L8
        if (r106 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L8
    L14:
        Gson r107 = new Gson();     // Catch: Exception -> L16
        i r108 = (i) r107.fromJson((String) r106, i.class);     // Catch: Exception -> L16
    L17:
        Context r109 = getContext();
        if (r109 == null) goto L92;
        TextView r110 = this.f187166e;
        if (r110 == null) goto L27;
        if (r108 == null) goto L25;
        String r111 = r108.f();
        if (r111 == null) goto L25;
    L26:
        r110.setText(r111);
    L25:
        int r112 = g1.f45599a;
        r111 = g1.a.c(r109, R.string.commerce_law_hint_title, new Object[0]);
    L27:
        TextView r113 = this.f187171j;
        if (r113 == null) goto L35;
        if (r108 == null) goto L33;
        String r114 = r108.b();
        if (r114 == null) goto L33;
    L34:
        r113.setText(r114);
    L33:
        int r115 = g1.f45599a;
        r114 = g1.a.c(r109, R.string.commerce_law_hint_confirm, new Object[0]);
    L35:
        TextView r116 = this.f187167f;
        if (r116 == null) goto L43;
        if (r108 == null) goto L41;
        String r117 = r108.c();
        if (r117 == null) goto L41;
    L42:
        r116.setText(r117);
    L41:
        int r118 = g1.f45599a;
        r117 = g1.a.c(r109, R.string.commerce_law_hint_desc, new Object[0]);
    L43:
        TextView r119 = this.f187170i;
        if (r119 == null) goto L52;
        if (r108 == null) goto L49;
        String r120 = r108.d();
        if (r120 == null) goto L49;
    L50:
        r119.setText(r120);
    L49:
        int r121 = g1.f45599a;
        r120 = g1.a.c(r109, R.string.commerce_law_hint_later, new Object[0]);
    L52:
        if (r108 == null) goto L55;
        String r122 = r108.a();
        if (r122 == null) goto L55;
    L56:
        if (r108 == null) goto L66;
        List<lh3.d> r123 = r108.e();
        if (r123 == null) goto L66;
        Iterator<T> r124 = r123.iterator();
    L61:
        if (r124.hasNext() == false) goto L66;
        String r125 = ((lh3.d) r124.next()).b();
        if (r125 != null) goto L65;
        r125 = "";
    L65:
        r122 = StringsKt.replaceFirst(r122, "%laws_placeholder", r125, false);
    L66:
        String r126 = a2.d(r122);
        if (r126 != null) goto L69;
        int r127 = g1.f45599a;
        r126 = g1.a.c(r109, R.string.commerce_law_hint_agree_desc, new Object[0]);
    L69:
        SpannableString r128 = new SpannableString(r126);
        if (r108 == null) goto L73;
        List<lh3.d> r129 = r108.e();
        Iterable r130 = r129;
        if (r129 == null) goto L73;
    L74:
        Iterator r131 = r130.iterator();
    L76:
        if (r131.hasNext() == false) goto L89;
        lh3.d r132 = (lh3.d) r131.next();
        if (r132 == null) goto L76;
        String r133 = r132.b();
        if (r133 == null) goto L76;
        String r134 = r132.a();
        if (r134 == null) goto L76;
        int r135 = g1.f45599a;     // Catch: Exception -> L87
        f r136 = new f(r134, g1.a.a(r109, R.color.commerce_link4), new LawHintDialogFragment$setClickableSpan$span$1(this));     // Catch: Exception -> L87
        int r137 = StringsKt.indexOf$default(r128, r133, 0, false, 6, null);     // Catch: Exception -> L87
        r128.setSpan(r136, r137, r133.length() + r137, 34);     // Catch: Exception -> L87
    L87:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L76
    L89:
        TextView r138 = this.f187168g;
        if (r138 == null) goto L92;
        r138.setText(r128);
        r138.setMovementMethod(LinkMovementMethod.getInstance());
    L73:
        int r139 = AuthUtils.f187163a;
        ArrayList r140 = new ArrayList();
        lh3.d r141 = new lh3.d();
        r141.e(j.c(R.string.commerce_user_agreement));
        r141.c("https://school.jinritemai.com/doudian/web/article/104868?noNav=true&from=douyin_shop_detail");
        Unit r142 = Unit.INSTANCE;
        r140.add(r141);
        lh3.d r143 = new lh3.d();
        r143.e(j.c(R.string.commerce_privacy_policy));
        r143.c("https://school.jinritemai.com/doudian/web/article/104870?noNav=true&from=douyin_shop_detail");
        r140.add(r143);
        r130 = r140;
    L55:
        r122 = "";
    L92:
        Lazy r144 = ECAppInfoService.f48110a;
        if (ECAppInfoService.l() == true) goto L101;
        Context r145 = getContext();
        if (r145 == null) goto L101;
        Resources r146 = th.a.f(r145);
        if (r146 == null) goto L101;
        int r147 = r146.getColor(R.color.SDQuaternary);
        TextView r148 = this.f187168g;
        if (r148 == null) goto L101;
        r148.setHighlightColor(r147);
    L101:
        TextView r149 = this.f187170i;
        if (r149 == null) goto L104;
        r149.setOnClickListener(new d(this));
    L104:
        TextView r150 = this.f187171j;
        if (r150 == null) goto L107;
        r150.setOnClickListener(new e(this));
    L107:
        S90("show");
        Dialog r151 = getDialog();
        if (r151 == null) goto L136;
        Window r152 = r151.getWindow();
        if (r152 == null) goto L137;
        WindowManager.LayoutParams r153 = r152.getAttributes();
        r153.gravity = 17;
        r153.width = (int) UIUtils.dip2Px(getContext(), 280.0f);
        r153.height = -2;
        View r154 = r152.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L116;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r155 = ThreadMethodProxy.currentThread();
        if (r155 == com.larus.home.impl.utils.c.f346341a) goto L116;
        com.larus.home.impl.utils.c.a(r155, "getDecorView");
    L116:
        r154.setPadding(0, 0, 0, 0);
        r152.setAttributes(r153);
        return;
    L137:
        return;
    L136:
        return;
    L8:
        th = move-exception;
        Result.Companion r156 = Result.Companion;     // Catch: Exception -> L16
        Object r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L16
        if (Result.m9455isFailureimpl(r157) == true) goto L13;
        r103 = r157;
    L13:
        r106 = r103;
    L16:
        r108 = null;
        goto L17
    }

    public LawHintDialogFragment() {
    }

    public final void S90(String r100) {
        in.b r101 = new in.b();
        r101.f490570a = r100;
        if (this.f187175n != 10) goto L5;
        int r102 = 1;
    L6:
        r101.f490571b = r102;
        r101.post(null, null);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        Window r102 = r101.getWindow();
        if (r102 == null) goto L5;
        r102.requestFeature(1);
    L5:
        r101.setCanceledOnTouchOutside(false);
        return r101;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f187166e = (TextView) r100.findViewById(R.id.law_hint_title);
        this.f187167f = (TextView) r100.findViewById(R.id.law_hint_desc);
        this.f187169h = (CheckBox) r100.findViewById(R.id.law_hint_check_box);
        this.f187168g = (TextView) r100.findViewById(R.id.law_hint_agree_desc);
        this.f187171j = (TextView) r100.findViewById(R.id.law_hint_confirm);
        this.f187170i = (TextView) r100.findViewById(R.id.law_hint_later);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void show(FragmentManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: IllegalStateException -> L9
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r101, r102);     // Catch: IllegalStateException -> L9
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, this, r102) == true) goto L16;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L7:
        super.show(r100, r101);     // Catch: IllegalStateException -> L9
        return;
    L16:
        return;
    L9:
        ECExceptionMonitor.c("LawHintDialogFragment show exception");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Dialog r103 = getDialog();
        if (r103 == null) goto L7;
        Window r104 = r103.getWindow();
        if (r104 == null) goto L7;
        r104.setBackgroundDrawable(new ColorDrawable(0));
    L7:
        Context r105 = getContext();
        if (r105 == null) goto L10;
        View r106 = th.a.c(r105, R.layout.ec_commerce_v3_law_hint_layout, r101, false);
    L11:
        this.f187165d = r106;
        return r106;
    L10:
        r106 = null;
        goto L11
    }
}
