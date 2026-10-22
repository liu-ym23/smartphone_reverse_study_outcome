package com.bytedance.android.live.soloktv.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.ktv.common.util.KtvCommonConfigParams;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.io.File;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f101607a = null;

    public static final class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f101608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f101609b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0 f101610c;

        public a(Ref.BooleanRef r100, String r101, Function0 r102) {
            this.f101608a = r100;
            this.f101609b = r101;
            this.f101610c = r102;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f101608a.element = true;
            r100.dismiss();
            cb1.a r102 = cb1.a.f22994a;
            String r103 = this.f101609b;
            Intrinsics.checkNotNullParameter(r103, "clickType");
            HashMap r104 = new HashMap();
            SoloKtvContext.Companion.getClass();
            com.bytedance.live.datacontext.n<MusicPanel> r105 = SoloKtvContext.a.a().getCurMusicPanel();
            if (r105 == null) goto L7;
            MusicPanel r106 = r105.getValue();
            if (r106 == null) goto L7;
            cb1.a.z(r104, r106);
            r104.put("from_request_type", r106.f153580d);
        L7:
            String r107 = SoloKtvContext.a.a().getPageIndicate();
            if (r107 != null) goto L10;
            r107 = "";
        L10:
            r104.put("click_page", r107);
            r104.put("click_type", r103);
            r104.put("sure_type", "sure");
            j0.l().sendLog("livesdk_solo_ktv_toast_sure", r104, new Object[]{IRoom.class});
            this.f101610c.invoke();
        }
    }

    public static final class b implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f101611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f101612b;

        public b(Ref.BooleanRef r100, Function0 r101) {
            this.f101611a = r100;
            this.f101612b = r101;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r100) {
            if (this.f101611a.element == true) goto L8;
            Function0 r101 = this.f101612b;
            if (r101 == null) goto L9;
            Unit r102 = (Unit) r101.invoke();
            return;
        L9:
            return;
        }
    }

    public static final class c implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f101613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f101614b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0 f101615c;

        public c(Ref.BooleanRef r100, String r101, Function0 r102) {
            this.f101613a = r100;
            this.f101614b = r101;
            this.f101615c = r102;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f101613a.element = true;
            cb1.a r102 = cb1.a.f22994a;
            String r103 = this.f101614b;
            Intrinsics.checkNotNullParameter(r103, "clickType");
            HashMap r104 = new HashMap();
            SoloKtvContext.Companion.getClass();
            com.bytedance.live.datacontext.n<MusicPanel> r105 = SoloKtvContext.a.a().getCurMusicPanel();
            if (r105 == null) goto L7;
            MusicPanel r106 = r105.getValue();
            if (r106 == null) goto L7;
            cb1.a.z(r104, r106);
            r104.put("from_request_type", r106.f153580d);
        L7:
            String r107 = SoloKtvContext.a.a().getPageIndicate();
            if (r107 != null) goto L10;
            r107 = "";
        L10:
            r104.put("click_page", r107);
            r104.put("click_type", r103);
            r104.put("sure_type", "cancel");
            j0.l().sendLog("livesdk_solo_ktv_toast_sure", r104, new Object[]{IRoom.class});
            r100.dismiss();
            Function0 r108 = this.f101615c;
            if (r108 == null) goto L14;
            Unit r109 = (Unit) r108.invoke();
            return;
        }
    }

    public j() {
    }

    static {
        f101607a = new j();
    }

    public static String d() {
        StringBuilder r100 = new StringBuilder(KtvCommonConfigParams.a());
        String r101 = File.separator;
        r100.append(r101);
        r100.append("musicPack");
        r100.append(r101);
        r100.append(KtvSubElement.MV);
        r100.append(r101);
        return r100.toString();
    }

    public static boolean h() {
        SoloKtvContext.Companion.getClass();
        com.bytedance.android.live.ktv.common.model.bean.f r100 = SoloKtvContext.a.b();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.f69998b;
    }

    public static boolean i() {
        if (((Number) vm2.h.C.getValue(null, vm2.h.f556082a[27])).intValue() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean a(MusicPanel r100) {
        if (r100 != null) goto L5;
    L7:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (KtvUtilsKt.F(r100) != true) goto L14;
        return true;
    L14:
        return false;
    L5:
        if (KtvUtilsKt.D(r100) != true) goto L7;
        return b(r100, false);
    }

    public static Bitmap c(com.bytedance.android.live.soloktv.model.k r100) {
        if (r100 == null) goto L9;
        eb1.f r101 = r100.b();
        if (r101 == null) goto L9;
        List<eb1.c> r102 = r101.d();
        if (r102 == null) goto L9;
        eb1.c r103 = (eb1.c) CollectionsKt.firstOrNull(r102);
    L11:
        if (r103 == null) goto L20;
        int r104 = r103.getType();
        int r105 = eb1.c.f471790a;
        if (r104 != 1) goto L17;
        String r106 = r103.a();
        if (r106 != null) goto L29;
        return null;
    L29:
        return ThumbnailUtils.createVideoThumbnail(r106, 2);
    L17:
        String r107 = r103.a();
        if (r107 != null) goto L31;
        return null;
    L31:
        return BitmapFactory.decodeFile(r107);
    L20:
        if (r100 == null) goto L24;
        fb1.e r108 = r100.d();
        if (r108 == null) goto L24;
        String r109 = r108.d();
    L25:
        if (r109 != null) goto L27;
        return null;
    L27:
        return ThumbnailUtils.createVideoThumbnail(r109, 2);
    L24:
        r109 = null;
    L9:
        r103 = null;
        goto L11
    }

    public static long e(com.bytedance.android.live.soloktv.model.k r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        long r101 = r100.d().c();
        String r102 = r100.d().d();
        if (r102 != null) goto L9;
        return 0;
    L9:
        if (r101 <= 0) goto L12;
        return r101;
    L12:
        return d.d(r102);
    }

    public static boolean f(String r100) {
        String r101 = URLConnection.guessContentTypeFromName(r100);
        if (r101 != null) goto L5;
        return false;
    L5:
        if (StringsKt.startsWith$default(r101, "image", false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean g(Activity r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (StringsKt.contains$default(r100.getLocalClassName(), "live.LivePlayActivity", false, 2, null) == false) goto L8;
    L9:
        return true;
    L8:
        if (StringsKt.contains$default(r100.getLocalClassName(), "live.LivePlayActivityV2", false, 2, null) == true) goto L9;
        return false;
    }

    public static boolean j(String r100) {
        String r101 = URLConnection.guessContentTypeFromName(r100);
        if (r101 != null) goto L5;
        return false;
    L5:
        if (StringsKt.startsWith$default(r101, "video", false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean b(MusicPanel r100, boolean r101) {
        if (r101 == false) goto L8;
        if (r100 != null) goto L6;
    L12:
        boolean r102 = false;
    L13:
        if (r100 == null) goto L21;
        if (KtvUtilsKt.E(r100) != true) goto L21;
        if (com.bytedance.android.livesdk.sharedpref.c.T.getValue().booleanValue() == false) goto L22;
        if (r102 == false) goto L23;
        return true;
    L23:
        return false;
    L22:
        return false;
    L21:
        return r102;
    L6:
        if (KtvUtilsKt.G(r100) != true) goto L12;
    L11:
        r102 = true;
        goto L13
    L8:
        if (r100 == null) goto L12;
        if (KtvUtilsKt.F(r100) != true) goto L12;
        goto L11
    }

    public static void k(Context r100, String r101, String r102, String r103, String r104, Function0 r105, Function0 r110) {
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, "cancelText");
        Intrinsics.checkNotNullParameter(r103, "confirmText");
        Intrinsics.checkNotNullParameter(r104, "clickType");
        Intrinsics.checkNotNullParameter(r110, "confirmFunc");
        if (r100 != null) goto L6;
        ALogger.i(bb0.b.b(), "openDialog error,context is null, invoke class :".concat(j.class.getSimpleName()));
        return;
    L6:
        Activity r106 = ContextUtil.contextToActivity(r100);
        if (r106 != null) goto L9;
    L19:
        ALogger.i(bb0.b.b(), "openDialog error,activity is null or isFinishing, invoke class :".concat(j.class.getSimpleName()));
        return;
    L9:
        if (r106.isFinishing() == true) goto L19;
        Ref.BooleanRef r107 = new Ref.BooleanRef();
        r107.element = false;
        x0.d r108 = new x0.d();
        r108.f162243b = r106;
        r108.f162242a = 8;
        r108.f162252k = true;
        r108.f162253l = true;
        r108.f162245d = r101;
        a r109 = new a(r107, r104, r110);
        x0.c[] r111 = r108.f162248g;
        x0.c r112 = r111[0];
        if (r112 != null) goto L14;
        r112 = new x0.c();
        r111[0] = r112;
    L14:
        r112.f162239a = r103;
        r112.f162240b = r109;
        r108.f162250i = new b(r107, r105);
        c r113 = new c(r107, r104, r105);
        x0.c[] r114 = r108.f162248g;
        x0.c r115 = r114[1];
        if (r115 != null) goto L17;
        r115 = new x0.c();
        r114[1] = r115;
    L17:
        r115.f162239a = r102;
        r115.f162240b = r113;
        x0.b.g(new x0(r108.f162243b, r108));
    }

    public static /* synthetic */ void l(j r100, Context r110, String r111, String r112, String r113, Function0 r114, Function0 r115, int r116) {
        if ((r116 & 4) == 0) goto L5;
        String r101 = "取消";
    L7:
        if ((r116 & 8) == 0) goto L9;
        String r102 = "确定";
    L11:
        if ((r116 & 16) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r116 & 32) == 0) goto L17;
        Function0 r104 = null;
    L18:
        r100.getClass();
        k(r110, r111, r101, r102, r103, r104, r115);
        return;
    L17:
        r104 = r114;
        goto L18
    L13:
        r103 = r113;
        goto L15
    L9:
        r102 = r112;
        goto L11
    L5:
        r101 = null;
        goto L7
    }
}
