package com.bytedance.android.livesdk.gamesticker.t01;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.model.t3;
import com.bytedance.android.livesdk.gamesticker.hok.f;
import com.bytedance.android.livesdk.gamesticker.hok.g;
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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u0004\u0018\u00010\u0003R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0017\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000e¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/gamesticker/t01/T01GameRoleView;", "Landroid/widget/FrameLayout;", "", "Lcom/bytedance/android/livesdk/chatroom/model/t3;", "roleInfo", "", "setRoleInfo", "Landroid/view/View;", "getView", "getRoleInfo", "Landroid/widget/TextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getRoleNameView", "()Landroid/widget/TextView;", "roleNameView", "Lcom/bytedance/lighten/loader/SmartImageView;", "b", "getRoleIconView", "()Lcom/bytedance/lighten/loader/SmartImageView;", "roleIconView", "c", "getRoleTagView", "roleTagView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class T01GameRoleView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f125715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f125716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f125717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f125718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f125719e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f125720f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public t3 f125721g;

    public T01GameRoleView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public T01GameRoleView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final SmartImageView getRoleIconView() {
        return (SmartImageView) this.f125716b.getValue();
    }

    private final TextView getRoleNameView() {
        return (TextView) this.f125715a.getValue();
    }

    private final TextView getRoleTagView() {
        return (TextView) this.f125717c.getValue();
    }

    public View getView() {
        return this;
    }

    public final t3 getRoleInfo() {
        return this.f125721g;
    }

    public final void setRoleInfo(t3 r100) {
        int r101 = 8;
        String r102 = "";
        if (r100 != null) goto L6;
        this.f125721g = r100;
        setVisibility(8);
        this.f125718d = "";
        this.f125719e = "";
        return;
    L6:
        String r103 = r100.b();
        if (r103 != null) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == true) goto L34;
        String r105 = r100.a();
        if (r105 != null) goto L17;
    L20:
        boolean r106 = true;
    L21:
        if (r106 == true) goto L34;
        String r107 = r100.b();
        if (r107 != null) goto L26;
        r107 = "";
    L26:
        this.f125718d = r107;
        String r108 = r100.a();
        if (r108 != null) goto L29;
        r108 = "";
    L29:
        this.f125719e = r108;
        String r109 = r100.c();
        if (r109 == null) goto L33;
        r102 = r109;
    L33:
        this.f125720f = r102;
        boolean r110 = true;
    L35:
        if (r110 == false) goto L44;
        this.f125721g = r100;
        setVisibility(0);
        int r111 = g.f125606a;
        g.a(getRoleNameView().getPaint(), 500);
        getRoleNameView().setText(this.f125718d);
        getRoleTagView().setText(this.f125720f);
        TextView r112 = getRoleTagView();
        if (this.f125720f.length() <= 0) goto L39;
        boolean r113 = true;
    L40:
        if (r113 == false) goto L42;
        r101 = 0;
    L42:
        r112.setVisibility(r101);
        u r114 = q.e(this.f125719e);
        CircleOptions.a r115 = new CircleOptions.a();
        r115.f254607a = true;
        r114.f468289o = new CircleOptions(r115);
        r114.f468277c = getRoleIconView().getContext();
        r114.f468294t = getRoleIconView();
        r114.b("game_sticker");
        r114.f468283i = R.drawable.ttlive_game_hok_empty;
        r114.d(new f("role_icon"));
        return;
    L39:
        r113 = false;
        goto L40
    L44:
        return;
    L17:
        if (r105.length() == 0) goto L20;
        r106 = false;
    L34:
        r110 = false;
        goto L35
    L9:
        if (r103.length() == 0) goto L12;
        r104 = false;
        goto L13
    }

    public T01GameRoleView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f125715a = LazyKt.lazy(new T01GameRoleView$roleNameView$2(this));
        this.f125716b = LazyKt.lazy(new T01GameRoleView$roleIconView$2(this));
        this.f125717c = LazyKt.lazy(new T01GameRoleView$roleTagView$2(this));
        this.f125718d = "";
        this.f125719e = "";
        this.f125720f = "";
        LayoutInflater.from(r100).inflate(R.layout.ttlive_game_t01_role_view, this);
    }

    public /* synthetic */ T01GameRoleView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
