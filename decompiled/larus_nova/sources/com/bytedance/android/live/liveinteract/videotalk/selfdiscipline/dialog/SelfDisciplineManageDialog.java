package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zg1.g1;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/dialog/SelfDisciplineManageDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelfDisciplineManageDialog extends CommonBottomDialog {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f79682e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f79683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f79684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f79685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f79686d;

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_interact_video_talk_self_displine_manage;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f79683a.dispose();
    }

    public SelfDisciplineManageDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f79683a = new CompositeDisposable();
        this.f79684b = LazyKt.lazy(new SelfDisciplineManageDialog$mCloseDialog$2(this));
        this.f79685c = SelfDisciplineContext.Companion.e();
        this.f79686d = LazyKt.lazy(new SelfDisciplineManageDialog$mSelectTargetCallback$2(this));
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        TextView r101 = (TextView) findViewById(R.id.tv_title);
        SelfDisciplineContext.a r102 = SelfDisciplineContext.Companion;
        r102.getClass();
        r101.setText(SelfDisciplineContext.a.c());
        ImageView r103 = (ImageView) findViewById(R.id.iv_help);
        int r104 = 4;
        if (this.f79685c == false) goto L5;
        int r105 = 4;
    L6:
        r103.setVisibility(r105);
        ImageView r106 = (ImageView) findViewById(R.id.iv_help);
        if (r106 == null) goto L9;
        r106.setOnClickListener(x0.a(new SelfDisciplineManageDialog$initTitleRightRegion$1(this)));
    L9:
        ImageView r107 = (ImageView) findViewById(R.id.iv_close);
        if (this.f79685c == false) goto L12;
        r104 = 0;
    L12:
        r107.setVisibility(r104);
        ImageView r108 = (ImageView) findViewById(R.id.iv_close);
        if (r108 == null) goto L15;
        r108.setOnClickListener(x0.a(new SelfDisciplineManageDialog$initTitleRightRegion$2(this)));
    L15:
        TextView r109 = (TextView) findViewById(R.id.tv_self_discipline_target);
        if (r109 == null) goto L18;
        r109.setText(b6.P.getValue().getCurrentTarget());
    L18:
        LinearLayout r110 = (LinearLayout) findViewById(R.id.self_discipline_target_container);
        if (r110 == null) goto L21;
        r110.setOnClickListener(x0.a(new SelfDisciplineManageDialog$initSettingRegion$1(this)));
    L21:
        r102.getClass();
        if (Intrinsics.areEqual(SelfDisciplineContext.a.c(), s1.B(R.string.ttlive_self_discipline_manage_dialog_title)) == false) goto L24;
        ((TextView) findViewById(R.id.tv_self_discipline_target_hint)).setText(getContext().getResources().getString(R.string.ttlive_self_discipline_manage_dialog_target));
        ((TextView) findViewById(R.id.tv_sub_title)).setText(getContext().getResources().getString(R.string.ttlive_self_discipline_manage_dialog_sub_title));
    L25:
        LinearLayout r111 = (LinearLayout) findViewById(R.id.room_intro_container);
        if (r111 == null) goto L29;
        r111.setOnClickListener(x0.a(new SelfDisciplineManageDialog$initSettingRegion$2(this)));
    L29:
        if (this.f79685c == false) goto L34;
        Button r112 = (Button) findViewById(R.id.btn_operation);
        if (r112 == null) goto L33;
        r112.setSelected(false);
    L33:
        ((Button) findViewById(R.id.btn_operation)).setText(R.string.ttlive_self_discipline_manage_dialog_update);
    L42:
        Button r113 = (Button) findViewById(R.id.btn_operation);
        if (r113 == null) goto L45;
        r113.setOnClickListener(x0.a(new SelfDisciplineManageDialog$initOperationBtn$1(this)));
    L45:
        SelfDisciplineContext r114 = r102.getContext();
        if (r114 == null) goto L54;
        m<Integer> r115 = r114.getStatus();
        if (r115 == null) goto L54;
        Observable<Integer> r116 = r115.a();
        if (r116 == null) goto L54;
        Disposable r117 = RxUtilKt.n(r116, new SelfDisciplineManageDialog$init$1(this));
        if (r117 == null) goto L54;
        this.f79683a.add(r117);
    L54:
        Disposable r118 = xs2.b.a().b(g1.class).subscribe(new d(this));
        if (r118 == null) goto L58;
        this.f79683a.add(r118);
        return;
    L58:
        return;
    L34:
        Button r119 = (Button) findViewById(R.id.btn_operation);
        if (r119 == null) goto L41;
        TextView r120 = (TextView) findViewById(R.id.tv_self_discipline_target);
        if (r120 == null) goto L39;
        CharSequence r121 = r120.getText();
    L40:
        r119.setSelected(!StringsKt.isBlank(r121.toString()));
        goto L41
    L39:
        r121 = null;
    L41:
        ((Button) findViewById(R.id.btn_operation)).setText(R.string.ttlive_self_discipline_manage_dialog_start);
        goto L42
    L24:
        ((TextView) findViewById(R.id.tv_self_discipline_target_hint)).setText(getContext().getResources().getString(R.string.ttlive_self_discipline_manage_dialog_target_tag));
        ((TextView) findViewById(R.id.tv_sub_title)).setText(getContext().getResources().getString(R.string.ttlive_self_discipline_manage_dialog_sub_title_new));
        goto L25
    L5:
        r105 = 0;
        goto L6
    }
}
