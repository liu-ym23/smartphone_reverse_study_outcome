package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import com.bytedance.android.livesdk.chatroom.model.interact.o1;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/dialog/SelfDisciplineManagerDialogV2;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/dialog/SelfDisciplineDurationSelectDialog$a;", "Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/dialog/SelfDisciplineTargetAdapterV2$a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelfDisciplineManagerDialogV2 extends CommonBottomDialog implements SelfDisciplineDurationSelectDialog.a, SelfDisciplineTargetAdapterV2.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f79688o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f79689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f79690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Button f79691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f79692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f79693e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f79694f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f79695g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f79696h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RecyclerView f79697i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f79698j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f79699k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f79700l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f79701m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<String> f79702n;

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_interact_video_talk_discipline_manage_v2;
    }

    public SelfDisciplineManagerDialogV2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f79689a = LazyKt.lazy(new SelfDisciplineManagerDialogV2$mCloseDialog$2(this));
        this.f79690b = SelfDisciplineContext.Companion.e();
        com.bytedance.android.livesdk.sharedpref.e<o1> r101 = b6.P;
        String r102 = r101.getValue().getCurrentTarget();
        if (r102 != null) goto L5;
        r102 = "备考自习";
    L5:
        this.f79700l = r102;
        this.f79701m = r101.getValue().getPunchDuration();
        List<String> r103 = r101.getValue().getTargetList();
        if (r103 == null) goto L8;
        List<String> r104 = CollectionsKt.toMutableList(r103);
    L9:
        this.f79702n = r104;
        return;
    L8:
        r104 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog.SelfDisciplineTargetAdapterV2.a
    public final void k0(String r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        this.f79700l = r100;
        boolean r101 = true;
        if (this.f79690b == false) goto L13;
        Button r102 = this.f79691c;
        if (r102 == null) goto L18;
        com.bytedance.android.livesdk.sharedpref.e<o1> r103 = b6.P;
        if (r103.getValue().getPunchDuration() == this.f79701m) goto L9;
    L12:
        r102.setSelected(r101);
        return;
    L9:
        if ((!Intrinsics.areEqual(r103.getValue().getCurrentTarget(), this.f79700l)) == true) goto L12;
        r101 = false;
        goto L12
    L18:
        return;
    L13:
        Button r104 = this.f79691c;
        if (r104 == null) goto L16;
        r104.setSelected(true);
    L16:
        b6.P.getValue().setCurrentTarget(this.f79700l);
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f79694f = (ViewGroup) findViewById(R.id.self_discipline_duration_container);
        this.f79695g = (TextView) findViewById(R.id.tv_self_discipline_duration_score);
        this.f79696h = (TextView) findViewById(R.id.tv_self_discipline_target_hint);
        this.f79692d = (ImageView) findViewById(R.id.iv_close);
        this.f79693e = (ImageView) findViewById(R.id.iv_help);
        this.f79698j = (TextView) findViewById(R.id.tv_title);
        this.f79699k = (TextView) findViewById(R.id.tv_sub_title);
        this.f79691c = (Button) findViewById(R.id.btn_operation);
        this.f79697i = (RecyclerView) findViewById(R.id.self_discipline_target_list);
        List<String> r101 = this.f79702n;
        if (r101 != null) goto L5;
    L7:
        SelfDisciplineTargetAdapterV2 r102 = new SelfDisciplineTargetAdapterV2(getContext(), this.f79702n, this.f79700l, this);
        RecyclerView r103 = this.f79697i;
        if (r103 == null) goto L10;
        r103.setAdapter(r102);
    L10:
        RecyclerView r104 = this.f79697i;
        if (r104 == null) goto L13;
        r104.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    L13:
        ViewGroup r105 = this.f79694f;
        if (r105 == null) goto L16;
        r105.setOnClickListener(new g(this));
    L16:
        TextView r106 = this.f79695g;
        if (r106 == null) goto L19;
        r106.setText(a.a((int) this.f79701m));
    L19:
        ImageView r107 = this.f79693e;
        int r108 = 4;
        if (r107 != null) goto L22;
    L26:
        ImageView r109 = this.f79693e;
        if (r109 == null) goto L29;
        r109.setOnClickListener(x0.a(new SelfDisciplineManagerDialogV2$initPanelHead$1(this)));
    L29:
        ImageView r110 = this.f79692d;
        if (r110 != null) goto L32;
    L35:
        ImageView r111 = this.f79692d;
        if (r111 == null) goto L38;
        r111.setOnClickListener(x0.a(new SelfDisciplineManagerDialogV2$initPanelHead$2(this)));
    L38:
        TextView r112 = this.f79698j;
        if (r112 == null) goto L41;
        SelfDisciplineContext.Companion.getClass();
        r112.setText(SelfDisciplineContext.a.c());
    L41:
        TextView r113 = this.f79699k;
        if (r113 == null) goto L48;
        SelfDisciplineContext.Companion.getClass();
        if (Intrinsics.areEqual(SelfDisciplineContext.a.c(), s1.B(R.string.ttlive_self_discipline_manage_dialog_title)) == false) goto L46;
        String r114 = s1.B(R.string.ttlive_self_discipline_manage_dialog_sub_title);
    L47:
        r113.setText(r114);
        goto L48
    L46:
        r114 = s1.B(R.string.ttlive_self_discipline_manage_dialog_sub_title_new);
    L48:
        TextView r115 = this.f79696h;
        if (r115 == null) goto L56;
        SelfDisciplineContext.Companion.getClass();
        if (Intrinsics.areEqual(SelfDisciplineContext.a.c(), s1.B(R.string.ttlive_self_discipline_manage_dialog_title)) == false) goto L53;
        String r116 = s1.B(R.string.ttlive_self_discipline_theme);
    L54:
        r115.setText(r116);
        goto L56
    L53:
        r116 = s1.B(R.string.ttlive_self_punch_theme);
    L56:
        if (this.f79690b == false) goto L63;
        Button r117 = this.f79691c;
        if (r117 == null) goto L60;
        r117.setSelected(false);
    L60:
        Button r118 = this.f79691c;
        if (r118 == null) goto L69;
        r118.setText(R.string.ttlive_self_discipline_manage_dialog_update);
    L69:
        Button r119 = this.f79691c;
        if (r119 == null) goto L73;
        r119.setOnClickListener(x0.a(new SelfDisciplineManagerDialogV2$initView$2(this)));
        return;
    L73:
        return;
    L63:
        Button r120 = this.f79691c;
        if (r120 == null) goto L66;
        r120.setSelected(!StringsKt.isBlank(this.f79700l));
    L66:
        Button r121 = this.f79691c;
        if (r121 == null) goto L69;
        r121.setText(R.string.ttlive_self_discipline_manage_dialog_start);
        goto L69
    L32:
        if (this.f79690b == false) goto L34;
        r108 = 0;
    L34:
        r110.setVisibility(r108);
        goto L35
    L22:
        if (this.f79690b == false) goto L24;
        int r122 = 4;
    L25:
        r107.setVisibility(r122);
        goto L26
    L24:
        r122 = 0;
        goto L25
    L5:
        if (r101.contains(this.f79700l) != true) goto L7;
        List<String> r123 = this.f79702n;
        Intrinsics.checkNotNull(r123);
        r123.remove(this.f79700l);
        List<String> r124 = this.f79702n;
        Intrinsics.checkNotNull(r124);
        ListProtector.add(r124, 0, this.f79700l);
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog.SelfDisciplineDurationSelectDialog.a
    public final void q0(int r100) {
        this.f79701m = r100;
        boolean r101 = true;
        if (this.f79690b == false) goto L13;
        Button r102 = this.f79691c;
        if (r102 == null) goto L17;
        com.bytedance.android.livesdk.sharedpref.e<o1> r103 = b6.P;
        if (r103.getValue().getPunchDuration() == this.f79701m) goto L9;
    L12:
        r102.setSelected(r101);
        goto L17
    L9:
        if ((!Intrinsics.areEqual(r103.getValue().getCurrentTarget(), this.f79700l)) == true) goto L12;
        r101 = false;
    L17:
        TextView r104 = this.f79695g;
        if (r104 == null) goto L21;
        r104.setText(a.a((int) this.f79701m));
        return;
    L21:
        return;
    L13:
        Button r105 = this.f79691c;
        if (r105 == null) goto L16;
        r105.setSelected(true);
    L16:
        b6.P.getValue().setPunchDuration(this.f79701m);
        goto L17
    }
}
