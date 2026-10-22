package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class a0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SparseArray<w> f115962e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f115963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f115964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f115965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NewToolbarButtonConstants f115966d;

    public static final class a {
        public static ToolbarButton a(int r100, boolean r101, boolean r102) {
            w r103 = a0.f115962e.get(r100);
            if (r103 == null) goto L11;
            if (r101 == false) goto L8;
            if (r102 == false) goto L14;
            return r103.f116212d;
        L14:
            return r103.f116211c;
        L8:
            if (r102 == false) goto L16;
            return r103.f116210b;
        L16:
            return r103.f116209a;
        L11:
            return null;
        }
    }

    public a0() {
        this(null, null, 7);
    }

    public void a(ToolbarButton r100) {
    }

    public void b(ToolbarButton r100) {
    }

    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b d(s r100) {
        Intrinsics.checkNotNullParameter(r100, "button");
        return null;
    }

    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b e(s r100) {
        Intrinsics.checkNotNullParameter(r100, "button");
        return null;
    }

    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b f(s r100) {
        Intrinsics.checkNotNullParameter(r100, "button");
        return null;
    }

    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b g(s r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "button");
        return null;
    }

    public abstract w j();

    public abstract NewToolbarButtonConstants k();

    public void n(boolean r100) {
        Intrinsics.checkNotNullParameter("", "reason");
    }

    public boolean o() {
        return this instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.i;
    }

    public void p() {
    }

    static {
        f115962e = new SparseArray();
    }

    public boolean m() {
        int r100 = com.bytedance.android.livesdk.config.setting.s.f121216a;
        return LiveInfraSettingKeys.LIVE_NEW_TOOLBAR_FUNCTION_CHANGE.getValue().b();
    }

    public String i(boolean r100, boolean r101) {
        String r102 = k().getName();
        if (TextUtils.isEmpty(r102) == false) goto L5;
        return "";
    L5:
        StringBuilder r103 = new StringBuilder();
        r103.append(r102);
        if (r100 == false) goto L8;
        String r104 = NewToolbarButtonConstants.IN_MORE;
    L9:
        r103.append(r104);
        String r105 = r103.toString();
        StringBuilder r106 = new StringBuilder();
        r106.append(r105);
        if (r101 == false) goto L12;
        String r107 = NewToolbarButtonConstants.IN_ANCHOR;
    L13:
        r106.append(r107);
        return r106.toString();
    L12:
        r107 = NewToolbarButtonConstants.IN_AUDIENCE;
        goto L13
    L8:
        r104 = NewToolbarButtonConstants.IN_TOOLBAR;
        goto L9
    }

    public final ToolbarButton l(boolean r100, boolean r101) {
        w r102 = (w) this.f115963a.getValue();
        if (r100 == false) goto L7;
        if (r101 == false) goto L12;
        return r102.f116212d;
    L12:
        return r102.f116211c;
    L7:
        if (r101 == false) goto L10;
        return r102.f116210b;
    L10:
        return r102.f116209a;
    }

    public a0(zr2.v r100, NewToolbarButtonConstants r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        r101 = null;
    L8:
        this.f115965c = r100;
        this.f115966d = r101;
        Lazy r103 = LazyKt.lazy(new ToolbarComponentConfig$mappingRule$2(this));
        this.f115963a = r103;
        Lazy r104 = LazyKt.lazy(new ToolbarComponentConfig$constants$2(this));
        this.f115964b = r104;
        int r105 = ((NewToolbarButtonConstants) r104.getValue()).getId();
        w r106 = (w) r103.getValue();
        Intrinsics.checkNotNullParameter(r106, com.heytap.mcssdk.constant.b.f276366p);
        f115962e.put(r105, r106);
    }

    public boolean c(s r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "button");
        if (h(r100, r101, Boolean.valueOf(r102)) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b h(s r100, boolean r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "button");
        if (r100.f116203m == true) goto L5;
        if (r102 == null) goto L8;
        boolean r103 = r102.booleanValue();
    L9:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r104 = g(r100, r101, r103);
        if (r104 == null) goto L13;
        return r104;
    L13:
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L17;
        if (r101 == false) goto L22;
        return d(r100);
    L22:
        return e(r100);
    L17:
        if (r101 == false) goto L20;
        Intrinsics.checkNotNullParameter(r100, "button");
        return null;
    L20:
        return f(r100);
    L8:
        r103 = false;
        goto L9
    L5:
        return new u();
    }
}
