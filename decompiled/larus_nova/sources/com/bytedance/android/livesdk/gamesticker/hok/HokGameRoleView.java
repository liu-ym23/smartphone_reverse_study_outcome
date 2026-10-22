package com.bytedance.android.livesdk.gamesticker.hok;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.model.c3;
import com.bytedance.lighten.core.CircleOptions;
import com.bytedance.lighten.loader.SmartImageView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import df6.q;
import df6.u;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003J\b\u0010\t\u001a\u00020\bH\u0016R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/gamesticker/hok/HokGameRoleView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/gamesticker/hok/e;", "Lcom/bytedance/android/livesdk/chatroom/model/c3;", "roleInfo", "", "setRoleInfo", "getRoleInfo", "Landroid/view/View;", "getView", "Landroid/widget/TextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getRoleNameView", "()Landroid/widget/TextView;", "roleNameView", "Lcom/bytedance/lighten/loader/SmartImageView;", "b", "getRoleIconView", "()Lcom/bytedance/lighten/loader/SmartImageView;", "roleIconView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HokGameRoleView extends LinearLayout implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f125549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f125550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f125551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f125552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c3 f125553e;

    public HokGameRoleView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HokGameRoleView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final SmartImageView getRoleIconView() {
        return (SmartImageView) this.f125550b.getValue();
    }

    private final TextView getRoleNameView() {
        return (TextView) this.f125549a.getValue();
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.e
    public final void D2() {
        setRoleInfo(null);
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.e
    public View getView() {
        return this;
    }

    public final c3 getRoleInfo() {
        return this.f125553e;
    }

    public final void setRoleInfo(c3 r100) {
        String r101 = "";
        if (r100 != null) goto L6;
        this.f125553e = r100;
        setVisibility(8);
        this.f125551c = "";
        this.f125552d = "";
        return;
    L6:
        String r102 = r100.a();
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L40;
        String r104 = r100.b();
        if (r104 != null) goto L17;
    L20:
        boolean r105 = true;
    L21:
        if (r105 == true) goto L40;
        String r106 = r100.a();
        if (r106 != null) goto L25;
        r106 = "";
    L25:
        this.f125551c = r106;
        String r107 = r100.b();
        if (r107 == null) goto L29;
        r101 = r107;
    L29:
        this.f125552d = r101;
        if (this.f125551c.length() <= 0) goto L32;
        boolean r108 = true;
    L33:
        if (r108 == true) goto L35;
    L119:
        boolean r109 = false;
    L120:
        if (r109 == false) goto L123;
        this.f125553e = r100;
        setVisibility(0);
        int r110 = g.f125606a;
        g.a(getRoleNameView().getPaint(), 500);
        getRoleNameView().setText(this.f125551c);
        u r111 = q.e(this.f125552d);
        CircleOptions.a r112 = new CircleOptions.a();
        r112.f254607a = true;
        r111.f468289o = new CircleOptions(r112);
        r111.f468277c = getRoleIconView().getContext();
        r111.f468294t = getRoleIconView();
        r111.b("game_sticker");
        r111.f468283i = R.drawable.ttlive_game_hok_empty;
        r111.d(new f("role_icon"));
        return;
    L123:
        return;
    L35:
        if (this.f125552d.length() <= 0) goto L37;
        boolean r113 = true;
    L38:
        if (r113 == false) goto L119;
    L118:
        r109 = true;
        goto L120
    L37:
        r113 = false;
        goto L38
    L32:
        r108 = false;
        goto L33
    L17:
        if (r104.length() == 0) goto L20;
        r105 = false;
    L40:
        String r114 = r100.e();
        if (r114 != null) goto L43;
    L46:
        boolean r115 = true;
    L47:
        if (r115 == true) goto L74;
        String r116 = r100.f();
        if (r116 != null) goto L51;
    L54:
        boolean r117 = true;
    L55:
        if (r117 == true) goto L74;
        String r118 = r100.e();
        if (r118 != null) goto L59;
        r118 = "";
    L59:
        this.f125551c = r118;
        String r119 = r100.f();
        if (r119 == null) goto L63;
        r101 = r119;
    L63:
        this.f125552d = r101;
        if (this.f125551c.length() <= 0) goto L66;
        boolean r120 = true;
    L67:
        if (r120 == false) goto L119;
        if (this.f125552d.length() <= 0) goto L71;
        boolean r121 = true;
    L72:
        if (r121 == false) goto L119;
    L71:
        r121 = false;
        goto L72
    L66:
        r120 = false;
        goto L67
    L51:
        if (r116.length() == 0) goto L54;
        r117 = false;
    L74:
        String r122 = r100.d();
        if (r122 != null) goto L77;
    L80:
        boolean r123 = true;
    L81:
        if (r123 == true) goto L109;
        String r124 = r100.c();
        if (r124 != null) goto L85;
    L88:
        boolean r125 = true;
    L89:
        if (r125 == true) goto L109;
        String r126 = r100.d();
        if (r126 != null) goto L93;
        r126 = "";
    L93:
        this.f125551c = r126;
        String r127 = r100.c();
        if (r127 == null) goto L97;
        r101 = r127;
    L97:
        this.f125552d = r101;
        if (this.f125551c.length() <= 0) goto L100;
        boolean r128 = true;
    L101:
        if (r128 == false) goto L119;
        if (this.f125552d.length() <= 0) goto L105;
        boolean r129 = true;
    L106:
        if (r129 == false) goto L119;
    L105:
        r129 = false;
        goto L106
    L100:
        r128 = false;
        goto L101
    L85:
        if (r124.length() == 0) goto L88;
        r125 = false;
    L109:
        if (this.f125551c.length() <= 0) goto L111;
        boolean r130 = true;
    L112:
        if (r130 == false) goto L119;
        if (this.f125552d.length() <= 0) goto L116;
        boolean r131 = true;
    L117:
        if (r131 == false) goto L119;
    L116:
        r131 = false;
        goto L117
    L111:
        r130 = false;
        goto L112
    L77:
        if (r122.length() == 0) goto L80;
        r123 = false;
        goto L81
    L43:
        if (r114.length() == 0) goto L46;
        r115 = false;
        goto L47
    L9:
        if (r102.length() == 0) goto L12;
        r103 = false;
        goto L13
    }

    public HokGameRoleView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f125549a = LazyKt.lazy(new HokGameRoleView$roleNameView$2(this));
        this.f125550b = LazyKt.lazy(new HokGameRoleView$roleIconView$2(this));
        this.f125551c = "";
        this.f125552d = "";
        LayoutInflater.from(r100).inflate(R.layout.ttlive_game_hok_role_view, this);
    }

    public /* synthetic */ HokGameRoleView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
