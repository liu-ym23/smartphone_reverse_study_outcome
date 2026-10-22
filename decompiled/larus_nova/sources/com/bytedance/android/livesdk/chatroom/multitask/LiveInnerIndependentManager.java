package com.bytedance.android.livesdk.chatroom.multitask;

import android.app.Dialog;
import android.content.Context;
import android.text.format.DateFormat;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.multitask.IIndependentTaskManager;
import com.bytedance.android.livesdk.config.e41;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class LiveInnerIndependentManager implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f107020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f107021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<e41> f107022c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LiveInnerIndependentManager f107023d = null;

    public LiveInnerIndependentManager() {
    }

    static {
        f107023d = new LiveInnerIndependentManager();
        f107022c = new com.bytedance.android.livesdk.sharedpref.e("live_multi_task_independent_guide_status", new e41(0));
    }

    public static boolean b() {
        IHostBusiness r100 = (IHostBusiness) k.f(IHostBusiness.class);
        if (r100 == null) goto L7;
        IIndependentTaskManager r101 = r100.getIndependentTaskManager();
        if (r101 == null) goto L7;
        return r101.isMultiTaskServerConfigOpen();
    L7:
        return false;
    }

    public final boolean a() {
        IHostBusiness r100 = (IHostBusiness) k.f(IHostBusiness.class);
        if (r100 == null) goto L7;
        IIndependentTaskManager r101 = r100.getIndependentTaskManager();
        if (r101 == null) goto L7;
        return r101.isMultiTaskOpen();
    L7:
        return false;
    }

    @JvmStatic
    public static final boolean c(Context r100) {
        IHostBusiness r101 = (IHostBusiness) k.f(IHostBusiness.class);
        if (r101 == null) goto L7;
        IIndependentTaskManager r102 = r101.getIndependentTaskManager();
        if (r102 == null) goto L7;
        return r102.isNewLiveActivity(r100);
    L7:
        return false;
    }

    @JvmStatic
    public static final void e(Context r110) {
        if (r110 != null) goto L5;
        return;
    L5:
        if (f107020a == false) goto L7;
        return;
    L7:
        LiveInnerIndependentManager r100 = f107023d;
        if (r100.a() == true) goto L11;
        return;
    L11:
        if (r100.a() == false) goto L33;
        e41 r101 = f107022c.getValue();
        r100.d("LiveInnerIndependentTaskManager", "checkNeedShowType status:" + r101);
        if (r101.f120085a == true) goto L18;
        if (r101.f120089e == false) goto L18;
        final String r102 = "TYPE_GUIDE_DIALOG";
    L35:
        if (Intrinsics.areEqual(r102, "TYPE_DEFAULT_DIALOG") == false) goto L37;
        return;
    L37:
        e.a r103 = new e.a(r110);
        Function1<Dialog, Unit> r111 = new LiveInnerIndependentManager$tryShowDialog$dialog$1(r102);
        e.c r104 = r103.f107029a;
        r104.f107036f = r111;
        r104.f107035e = LiveInnerIndependentManager$tryShowDialog$dialog$2.INSTANCE;
        Function1<Dialog, Unit> r112 = new LiveInnerIndependentManager$tryShowDialog$dialog$3(r102);
        e.c r105 = r103.f107029a;
        r105.f107037g = r112;
        r105.f107033c = R.string.ttlive_independent_multitask_guide_button_text;
        if (Intrinsics.areEqual(r102, "TYPE_GUIDE_DIALOG") == false) goto L40;
        Intrinsics.checkNotNullParameter("/multitask/ttlive_live_independent_task_guide.png", "imageResId");
        e.c r106 = r103.f107029a;
        r106.getClass();
        Intrinsics.checkNotNullParameter("/multitask/ttlive_live_independent_task_guide.png", "<set-?>");
        r106.f107031a = "/multitask/ttlive_live_independent_task_guide.png";
        e.c r113 = r103.f107029a;
        r113.f107032b = R.string.ttlive_independent_multitask_title_guide_res;
        r113.f107034d = R.color.ttlive_independent_task_guide_bg_color;
    L41:
        e r114 = new e(r103.f107030b, r103.f107029a);
        r114.setOnDismissListener(new d(r114, r103));
        Function1<? super Dialog, Unit> r107 = r103.f107029a.f107036f;
        if (r107 == null) goto L45;
        Unit r108 = r107.invoke(r114);
    L45:
        if (DialogLancet.shouldBlockDialogShow(r114) == false) goto L58;
        DialogLancet.handleBlockedDialogShow(r114);
    L49:
        com.bytedance.android.livesdk.sharedpref.e<e41> r115 = f107022c;
        if (Intrinsics.areEqual(r102, "TYPE_GUIDE_DIALOG") == false) goto L53;
        com.bytedance.android.livesdk.sharedpref.f.d(r115, e41.a(r115.getValue(), true, false, null, null, 30));
    L55:
        r100.d("LiveInnerIndependentTaskManager", "updateGuideStatus status:" + r115.getValue());
        return;
    L53:
        if (Intrinsics.areEqual(r102, "TYPE_CLOSE_DIALOG") == false) goto L55;
        com.bytedance.android.livesdk.sharedpref.f.d(r115, e41.a(r115.getValue(), false, true, null, null, 29));
        goto L55
    L58:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L57
    L48:
        DialogLancet.beforeDialogShow(r114);
        r114.show();
        DialogLancet.afterDialogShow(r114);
        goto L49
    L40:
        Intrinsics.checkNotNullParameter("/multitask/ttlive_live_independent_task_close_guide.png", "imageResId");
        e.c r109 = r103.f107029a;
        r109.getClass();
        Intrinsics.checkNotNullParameter("/multitask/ttlive_live_independent_task_close_guide.png", "<set-?>");
        r109.f107031a = "/multitask/ttlive_live_independent_task_close_guide.png";
        e.c r116 = r103.f107029a;
        r116.f107032b = R.string.ttlive_independent_multitask_title_close_res;
        r116.f107034d = R.color.ttlive_independent_task_guide_bg_color;
    L18:
        if (r101.f120086b == true) goto L33;
        CharSequence r117 = DateFormat.format("yyyy-MM-dd", System.currentTimeMillis());
        if (Intrinsics.areEqual(r117, r101.f120087c) == false) goto L33;
        Map<String, Integer> r118 = r101.f120088d;
        if (r118 == null) goto L32;
        if (r118.containsKey(r117) == true) goto L27;
        r118 = null;
    L27:
        if (r118 == null) goto L33;
        Integer r119 = r118.get(r117);
        Intrinsics.checkNotNull(r119);
        if (r119.intValue() < 3) goto L33;
        r102 = "TYPE_CLOSE_DIALOG";
        goto L35
    L32:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    L33:
        r102 = "TYPE_DEFAULT_DIALOG";
        goto L35
    }

    @JvmStatic
    public static final void f(Context r110) {
        if (c(r110) == false) goto L22;
        final com.bytedance.android.livesdk.sharedpref.e<e41> r111 = f107022c;
        final String r100 = DateFormat.format("yyyy-MM-dd", System.currentTimeMillis()).toString();
        if (r100.length() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
    L19:
        com.bytedance.android.livesdk.sharedpref.f.d(r111, e41.a(r111.getValue(), false, false, r100, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(r100, 1)}), 19));
    L20:
        f107023d.d("LiveInnerIndependentTaskManager", "updateStopRoomCount status:" + r111.getValue());
        return;
    L10:
        if (Intrinsics.areEqual(r100, r111.getValue().f120087c) == false) goto L19;
        Map<String, Integer> r102 = r111.getValue().f120088d;
        if (r102.containsKey(r100) == true) goto L15;
        r102 = null;
    L15:
        Map<String, Integer> r103 = r102;
        if (r103 == null) goto L18;
        Integer r104 = r103.get(r100);
        Intrinsics.checkNotNull(r104);
        r103.put(r100, Integer.valueOf(r104.intValue() + 1));
        com.bytedance.android.livesdk.sharedpref.f.d(r111, e41.a(r111.getValue(), false, false, null, r103, 23));
        Unit r105 = Unit.INSTANCE;
        goto L20
    L18:
        new LiveInnerIndependentManager$updateStopRoomCount$1$3(r111, r100);
        goto L20
    L7:
        r101 = false;
        goto L8
    }

    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        ALogger.i("LiveInnerIndependentTaskManager", r100 + ", " + r101);
    }
}
