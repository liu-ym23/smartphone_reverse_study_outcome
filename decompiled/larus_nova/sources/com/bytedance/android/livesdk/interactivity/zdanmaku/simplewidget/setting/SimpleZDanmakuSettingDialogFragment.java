package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.i;
import com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.settingmanager.SimpleSettingManager;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.barrage.ChangeSettingSource;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.OpenParams;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p22.o;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/zdanmaku/simplewidget/setting/SimpleZDanmakuSettingDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/livesdk/interactivity/zdanmaku/simplewidget/setting/b$a;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimpleZDanmakuSettingDialogFragment extends LiveDialogFragment implements b.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f141755i = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o f141756d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f141757e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f141758f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f141759g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OpenParams f141760h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.b.a
    public final void dR() {
        com.bytedance.android.livesdk.sharedpref.e<Integer> r100 = SimpleSettingManager.f141793a;
        SimpleSettingManager.e(null);
    }

    public SimpleZDanmakuSettingDialogFragment() {
        com.bytedance.android.livesdk.sharedpref.e<Integer> r100 = SimpleSettingManager.f141793a;
        this.f141756d = SimpleSettingManager.b();
        this.f141757e = LazyKt.lazy(new SimpleZDanmakuSettingDialogFragment$settingComponents$2(this));
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (isVertical() == false) goto L5;
        int r101 = R.style.ttlive_CommonBottomDialogFast;
    L6:
        setStyle(1, r101);
        return;
    L5:
        r101 = R.style.ttlivebase_ttlive_NewProfileRightDialog;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L9
        super.onDismiss(r100);     // Catch: Throwable -> L9
        Iterator r101 = ((List) this.f141757e.getValue()).iterator();     // Catch: Throwable -> L9
    L4:
        if (r101.hasNext() == false) goto L7;
        ((b) r101.next()).e();     // Catch: Throwable -> L9
        goto L4
    L7:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L9:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.b.a
    public final void yR(ChangeSettingSource r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        com.bytedance.android.livesdk.sharedpref.e<Integer> r101 = SimpleSettingManager.f141793a;
        SimpleSettingManager.f(this.f141756d, r100);
        int r102 = i.f141754a;
        i.c("saveSimpleDanmakuConfigSP: " + this.f141756d);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Iterator r102 = ((List) this.f141757e.getValue()).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((b) r102.next()).d();
        goto L4
    L6:
        TextView r103 = this.f141758f;
        if (r103 == null) goto L9;
        r103.setOnClickListener(x0.a(new SimpleZDanmakuSettingDialogFragment$configResetButton$1(this)));
    L9:
        TextView r104 = this.f141759g;
        if (r104 == null) goto L12;
        r104.setOnClickListener(x0.a(new SimpleZDanmakuSettingDialogFragment$configCloseButton$1(this)));
    L12:
        sendLog("livesdk_preview_bullet_comment_setting_panel_show", null);
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.b.a
    public final void sendLog(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live");
        OpenParams r103 = this.f141760h;
        String r104 = "";
        if (r103 == null) goto L8;
        Map<String, String> r105 = r103.getLiveGlobalParams();
        if (r105 == null) goto L8;
        String r106 = r105.get("action_type");
        if (r106 == null) goto L8;
    L9:
        r102.put("action_type", r106);
        OpenParams r107 = this.f141760h;
        if (r107 == null) goto L15;
        Map<String, String> r108 = r107.getLiveGlobalParams();
        if (r108 == null) goto L15;
        String r109 = r108.get("enter_from_merge");
        if (r109 == null) goto L15;
    L16:
        r102.put("enter_from_merge", r109);
        OpenParams r110 = this.f141760h;
        if (r110 == null) goto L22;
        Map<String, String> r111 = r110.getLiveGlobalParams();
        if (r111 == null) goto L22;
        String r112 = r111.get("enter_method");
        if (r112 == null) goto L22;
    L23:
        r102.put("enter_method", r112);
        OpenParams r113 = this.f141760h;
        if (r113 == null) goto L29;
        Map<String, String> r114 = r113.getLiveGlobalParams();
        if (r114 == null) goto L29;
        String r115 = r114.get("request_id");
        if (r115 == null) goto L29;
    L30:
        r102.put("request_id", r115);
        OpenParams r116 = this.f141760h;
        if (r116 == null) goto L36;
        Room r117 = r116.getRoom();
        if (r117 == null) goto L36;
        String r118 = r117.getIdStr();
        if (r118 == null) goto L36;
    L37:
        r102.put("room_id", r118);
        OpenParams r119 = this.f141760h;
        if (r119 == null) goto L45;
        Room r120 = r119.getRoom();
        if (r120 == null) goto L45;
        String r121 = r120.getOwnerUserIdString();
        if (r121 == null) goto L45;
        r104 = r121;
    L45:
        r102.put("anchor_id", r104);
        if (r101 == null) goto L48;
        r102.putAll(r101);
    L48:
        j0.l().sendLog(r100, r102, new Object[0]);
        return;
    L36:
        r118 = "";
    L29:
        r115 = "";
    L22:
        r112 = "";
    L15:
        r109 = "";
    L8:
        r106 = "";
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.ttlive_layout_portrait_simple_danmaku_setting_panel, r101, false);
        if (r103 == null) goto L9;
        Iterator r104 = ((List) this.f141757e.getValue()).iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        b r105 = (b) r104.next();
        r105.c(r100, (ViewGroup) r103.findViewById(r105.a()));
        goto L6
    L8:
        this.f141758f = (TextView) r103.findViewById(R.id.reset_button);
        this.f141759g = (TextView) r103.findViewById(R.id.close_barrage_button);
        return r103;
    L9:
        return null;
    }
}
