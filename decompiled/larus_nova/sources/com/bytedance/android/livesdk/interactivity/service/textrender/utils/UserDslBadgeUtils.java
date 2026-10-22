package com.bytedance.android.livesdk.interactivity.service.textrender.utils;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.h5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.PublicAreaBadgeInfo;
import com.bytedance.android.live.base.model.user.h0;
import com.bytedance.android.live.base.model.user.r;
import com.bytedance.android.live.base.model.user.s;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class UserDslBadgeUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f141055a = 0;

    public interface a {
        void a(ak6.g r100, boolean r101);
    }

    public UserDslBadgeUtils() {
    }

    public static long c() {
        IMiddleWareHostContext r100 = (IMiddleWareHostContext) k.f(IMiddleWareHostContext.class);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.appId();
    }

    public static long d() {
        IMiddleWareHostContext r100 = (IMiddleWareHostContext) k.f(IMiddleWareHostContext.class);
        if (r100 == null) goto L9;
        String r101 = r100.getVersionCode();
        if (r101 == null) goto L9;
        Long r102 = StringsKt.toLongOrNull(r101);
        if (r102 == null) goto L9;
        return r102.longValue();
    L9:
        return 0;
    }

    static {
    }

    public static final String a(List r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return "[" + TextUtils.join(",", r100) + ']';
    }

    @JvmStatic
    public static final List<tb2.c> b(List<h0> r100) {
        Intrinsics.checkNotNullParameter(r100, "badgeList");
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L38;
        h0 r103 = (h0) r102.next();
        py.k r104 = r103.f58944b;
        py.k.b.a r105 = py.k.b.Companion;
        py.k.b r106 = r104.getImageContent();
        r105.getClass();
        if (py.k.b.a.a(r106) == false) goto L36;
        tb2.c r107 = d.d(r104);
        ITextPieceImage r108 = r107.getImageValue();
        if (r108 == null) goto L12;
        py.k r109 = r108.getImageModel();
        if (r109 == null) goto L12;
        r109.setIsResizableImg(true);
    L12:
        ITextPieceImage r110 = r107.getImageValue();
        if (r110 == null) goto L35;
        ((h5) r110).setTextType(5);
        ITextPieceImage r111 = r107.getImageValue();
        if (r111 == null) goto L33;
        h5 r112 = (h5) r111;
        py.k.b r113 = r104.getImageContent();
        String r114 = null;
        if (r113 == null) goto L19;
        String r115 = r113.getName();
    L20:
        r112.setTextContent(r115);
        ITextPieceImage r116 = r107.getImageValue();
        if (r116 == null) goto L31;
        h5 r117 = (h5) r116;
        py.k.b r118 = r104.getImageContent();
        if (r118 == null) goto L25;
        r114 = r118.getFontColor();
    L25:
        r117.setTextColor(d.f(String.valueOf(r114)));
        ITextPieceImage r119 = r107.getImageValue();
        if (r119 == null) goto L29;
        ((h5) r119).setTextSizeRate(0.55f);
    L37:
        r107.setBadgePiece(true);
        r107.setBadge(r103);
        r101.add(r107);
        goto L4
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L19:
        r115 = null;
        goto L20
    L33:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L35:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L36:
        r107 = d.c(r104);
        goto L37
    L38:
        return r101;
    }

    @JvmStatic
    public static final List<h0> e(IBaseUser r100) {
        if (r100 == null) goto L8;
        com.bytedance.android.livesdk.interactivity.service.model.d r101 = (com.bytedance.android.livesdk.interactivity.service.model.d) r100.castToOrNull(com.bytedance.android.livesdk.interactivity.service.model.d.class);
        if (r101 == null) goto L8;
        return f(r101.getPublicAreaBadgeInfo());
    L8:
        return CollectionsKt.emptyList();
    }

    @JvmStatic
    public static final List f(final PublicAreaBadgeInfo r100) {
        if (r100 != null) goto L6;
        return CollectionsKt.emptyList();
    L6:
        if (r100.getPublicAreaBadgeList() != null) goto L60;
        i(UserDslBadgeUtils$processDsl$1.INSTANCE);
        List<r> r101 = r100.dslBadgeList();
        if (r101 != null) goto L11;
    L14:
        boolean r102 = true;
    L16:
        if (r102 == false) goto L18;
        i(new UserDslBadgeUtils$processDsl$badgeListKey$1(r100));
        final List<Long> r103 = r100.badgeList();
    L48:
        ArrayList r104 = new ArrayList();
        if (r103 == null) goto L59;
        Iterator<T> r105 = r103.iterator();
    L52:
        if (r105.hasNext() == false) goto L59;
        long r106 = ((Number) r105.next()).longValue();
        Map<Long, py.k> r107 = r100.badgeInfoMap();
        if (r107 == null) goto L56;
        py.k r108 = r107.get(Long.valueOf(r106));
    L57:
        if (r108 == null) goto L52;
        r104.add(new h0(r106, r108));
        goto L52
    L56:
        r108 = null;
    L59:
        r100.setPublicAreaBadgeList(r104);
        goto L60
    L18:
        List<r> r109 = r100.dslBadgeList();
        if (r109 == null) goto L39;
        Iterator<T> r110 = r109.iterator();
    L22:
        if (r110.hasNext() == false) goto L37;
        Object r111 = r110.next();
        r r112 = (r) r111;
        s r113 = r112.targetDslRule();
        s r114 = r112.filterDslRule();
        if (r113 == null) goto L26;
        final boolean r115 = h(PickerReporterConstants.KEY.TARGET, r113);
    L27:
        if (r114 == null) goto L29;
        final boolean r116 = h("filter", r114);
    L30:
        if (r115 == false) goto L33;
        if (r116 == true) goto L33;
        final boolean r117 = true;
    L34:
        i(new UserDslBadgeUtils$processDsl$badgeListKey$matchDslBadgeList$1$1(r117, r115, r116));
        if (r117 == false) goto L22;
    L38:
        r r118 = (r) r111;
    L40:
        if (r118 == null) goto L42;
        r103 = r118.badgeList();
    L43:
        if (r103 == null) goto L45;
        i(new UserDslBadgeUtils$processDsl$badgeListKey$2(r103));
    L46:
        if (r103 != null) goto L48;
        r103 = r100.badgeList();
        goto L48
    L45:
        i(new UserDslBadgeUtils$processDsl$badgeListKey$3(r100));
        goto L46
    L42:
        r103 = null;
    L33:
        r117 = false;
        goto L34
    L29:
        r116 = false;
        goto L30
    L26:
        r115 = true;
        goto L27
    L37:
        r111 = null;
        goto L38
    L39:
        r118 = null;
        goto L40
    L11:
        if (r101.isEmpty() == true) goto L14;
        r102 = false;
    L60:
        List<h0> r119 = r100.getPublicAreaBadgeList();
        if (r119 == null) goto L63;
        return r119;
    L63:
        return CollectionsKt.emptyList();
    }

    public static String g(String r100) {
        Object r101 = SettingUtil.getRawValue("key_ttlive_sdk_setting", r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.toString();
    }

    public static void i(Function0 r100) {
        LocalTestManager.a(new Class[]{wy.a.class});
        if (v.a() == false) goto L10;
        if (r100 == null) goto L11;
        String r101 = (String) r100.invoke();
        if (r101 == null) goto L12;
        ALogger.i("UserDslBadge", r101);
        return;
    L12:
        return;
    L11:
        return;
    }

    public static boolean h(final String r110, s r111) {
        final List<Long> r100 = r111.appId();
        List<Long> r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == true) goto L18;
        i(new UserDslBadgeUtils$matchDslRule$1(r110, r100));
        return false;
    L18:
        final List<Long> r104 = r111.versionCode();
        if (r104 != null) goto L21;
    L32:
        boolean r105 = true;
    L33:
        if (r105 == true) goto L36;
        i(new UserDslBadgeUtils$matchDslRule$2(r110, r104));
        return false;
    L36:
        final Map<String, String> r112 = r111.abParams();
        if (r112 != null) goto L39;
    L42:
        boolean r106 = true;
    L43:
        if (r106 == false) goto L45;
    L53:
        boolean r107 = true;
    L54:
        if (r107 == true) goto L57;
        i(new UserDslBadgeUtils$matchDslRule$4(r110, r112));
        return false;
    L57:
        i(new UserDslBadgeUtils$matchDslRule$5(r110, r100, r104, r112));
        return true;
    L45:
        if (r112.isEmpty() == true) goto L53;
        Iterator<Map.Entry<String, String>> r108 = r112.entrySet().iterator();
    L49:
        if (r108.hasNext() == false) goto L53;
        Map.Entry<String, String> r109 = r108.next();
        if (Intrinsics.areEqual(r109.getValue(), g(r109.getKey())) == true) goto L49;
        r107 = false;
        goto L54
    L39:
        if (r112.isEmpty() == true) goto L42;
        r106 = false;
        goto L43
    L21:
        if (r104.size() != 2) goto L32;
        long r113 = ((Number) ListProtector.get(r104, 0)).longValue();
        long r114 = ((Number) ListProtector.get(r104, 1)).longValue();
        if (r114 != 0) goto L25;
        r114 = Long.MAX_VALUE;
    L25:
        long r115 = d();
        if (r113 <= r115) goto L29;
    L31:
        r105 = false;
        goto L33
    L29:
        if (r114 < r115) goto L31;
    L11:
        if (r100.contains(Long.valueOf(c())) == true) goto L14;
        r103 = false;
        goto L15
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }
}
