package com.bytedance.android.live.livepkaudience.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Switch;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/dialog/PkApplyPermissionSwitchDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkApplyPermissionSwitchDialog extends CommonBottomDialog {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f81647f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f81648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f81649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f81650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Room f81651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f81652e;

    public static final class a {
        public a() {
        }
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_pk_interact_permission_setting;
    }

    static {
        f81647f = new a();
    }

    public final void N0() {
        if (com.bytedance.android.livesdk.sharedpref.c.f158304s1.getValue().booleanValue() == true) goto L5;
        this.f81649b = true;
        ((FrameLayout) findViewById(R.id.fl_no_need_apply)).setAlpha(1.0f);
        ((FrameLayout) findViewById(R.id.fl_need_apply)).setAlpha(1.0f);
        O0();
        return;
    L5:
        this.f81649b = false;
        ((FrameLayout) findViewById(R.id.fl_no_need_apply)).setAlpha(0.4f);
        ((FrameLayout) findViewById(R.id.fl_need_apply)).setAlpha(0.4f);
        ((ImageView) findViewById(R.id.iv_need_apply)).setVisibility(8);
        ((ImageView) findViewById(R.id.iv_no_need_apply)).setVisibility(8);
    }

    public final void O0() {
        if (this.f81650c == false) goto L5;
        ((ImageView) findViewById(R.id.iv_need_apply)).setVisibility(0);
        ((ImageView) findViewById(R.id.iv_no_need_apply)).setVisibility(8);
        return;
    L5:
        ((ImageView) findViewById(R.id.iv_need_apply)).setVisibility(8);
        ((ImageView) findViewById(R.id.iv_no_need_apply)).setVisibility(0);
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f81648a.dispose();
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (this.f81652e != 1) goto L6;
        ((Switch) findViewById(R.id.switch_only_accept_follower)).setChecked(com.bytedance.android.livesdk.sharedpref.c.f158295p1.getValue().booleanValue());
        this.f81650c = com.bytedance.android.livesdk.sharedpref.c.f158307t1.getValue().booleanValue();
        O0();
    L6:
        ((Switch) findViewById(R.id.switch_only_accept_follower)).setOnCheckedChangeListener(new f(this));
        ((FrameLayout) findViewById(R.id.fl_no_need_apply)).setOnClickListener(new g(this));
        ((FrameLayout) findViewById(R.id.fl_need_apply)).setOnClickListener(new h(this));
        ((FrameLayout) findViewById(R.id.fl_switch_only_join_through_invitation)).setVisibility(0);
        ((Switch) findViewById(R.id.switch_only_join_through_invitation)).setChecked(com.bytedance.android.livesdk.sharedpref.c.f158304s1.getValue().booleanValue());
        ((Switch) findViewById(R.id.switch_only_join_through_invitation)).setOnCheckedChangeListener(new e(this));
        N0();
    }

    public PkApplyPermissionSwitchDialog(Room r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "room");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r101);
        this.f81651d = r100;
        this.f81652e = 1;
        this.f81648a = new CompositeDisposable();
        this.f81649b = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.HashMap] */
    public static final void M0(PkApplyPermissionSwitchDialog r100, boolean r101) {
        if (r100.f81649b == false) goto L11;
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        ?? r103 = new HashMap();
        r102.element = r103;
        r103.put("scene", Integer.valueOf(r100.f81652e));
        if (r100.f81652e != 1) goto L9;
        ((HashMap) r102.element).put("big_party_accept_need_verified", Boolean.valueOf(r101));
        ((HashMap) r102.element).put("big_party_only_accept_follower_apply", Boolean.valueOf(((Switch) r100.findViewById(R.id.switch_only_accept_follower)).isChecked()));
    L9:
        Disposable r104 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).updateSetting(r100.f81651d.f162599id, (HashMap) r102.element).compose(RxUtil.rxSchedulerHelper()).subscribe(new i(r100, r102, r101));
        r100.f81648a.add(r104);
        return;
    }
}
