package com.bytedance.android.live.liveinteract.revenue.fight.view;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.voicechat.fight.view.FightTitleTextView;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.view.NoPaddingTextView;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.texturerender.VideoSurfaceTexture;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import jc1.k;
import je0.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\bB'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/fight/view/TeamFightTitleLayout;", "Landroid/widget/LinearLayout;", "", VideoSurfaceTexture.KEY_TIME, "", "setFightingState", "setPenalState", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "isStartMode", "()Z", "setStartMode", "(Z)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TeamFightTitleLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f78267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f78268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f78269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FightTitleTextView f78270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final NoPaddingTextView f78271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f78272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HSImageView f78273g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f78274h;

    public static final class a {
    }

    static {
    }

    public TeamFightTitleLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TeamFightTitleLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        if (this.f78268b == false) goto L10;
        UtilityKotlinExtentionsKt.t(this.f78269c);
        UtilityKotlinExtentionsKt.t(this.f78270d);
        UtilityKotlinExtentionsKt.t(this.f78271e);
        UtilityKotlinExtentionsKt.w(this.f78272f);
        UtilityKotlinExtentionsKt.w(this.f78273g);
        View r100 = this.f78272f;
        int r101 = s1.f(72.0f);
        String r102 = this.f78270d.getText().toString();
        TextPaint r103 = new TextPaint();
        r103.setTextSize(s1.e(11.0f));
        float r104 = r103.measureText(r102);
        float r105 = this.f78270d.getPaint().measureText(r102);
        if (r105 > r104) goto L7;
    L9:
        UIUtils.updateLayout(r100, r101, -3);
        this.f78273g.setBackgroundResource(R.drawable.ttlive_anchor_invite_btn);
        return;
    L7:
        if (r104 <= 0) goto L9;
        r101 = (int) (r101 * (r105 / r104));
        goto L9
    L10:
        UtilityKotlinExtentionsKt.t(this.f78272f);
        UtilityKotlinExtentionsKt.t(this.f78273g);
        UtilityKotlinExtentionsKt.t(this.f78271e);
        UtilityKotlinExtentionsKt.w(this.f78270d);
        UtilityKotlinExtentionsKt.w(this.f78269c);
        this.f78270d.setText(s1.B(R.string.ttlive_team_fight_preparing));
        this.f78269c.setBackgroundResource(R.drawable.ttlive_team_fight_title_layout_bg_default);
        UIUtils.updateLayout(this.f78269c, s1.f(68.0f), -3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((!Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE)) == false) goto L16;
        Disposable r100 = this.f78274h;
        if (r100 == null) goto L7;
        r100.dispose();
    L7:
        Disposable r101 = ((IMiddlewareUserService) k.n(IMiddlewareUserService.class)).user().u().observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this));
        Disposable r102 = this.f78274h;
        if (r102 == null) goto L10;
        r102.dispose();
    L10:
        this.f78274h = r101;
        if (com.bytedance.android.live.liveinteract.utils.e.b() == false) goto L16;
        if (TeamFightContext.Companion.d() == false) goto L16;
        this.f78268b = true;
    L16:
        if (TeamFightContext.Companion.d() == false) goto L19;
        a();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r100 = this.f78274h;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public final void b(long r100) {
        UIUtils.setViewVisibility(this.f78271e, 0);
        this.f78271e.setText(p6.d(r100));
    }

    public final void setFightingState(long r100) {
        this.f78267a = false;
        this.f78269c.setAlpha(1.0f);
        UtilityKotlinExtentionsKt.t(this.f78272f);
        UtilityKotlinExtentionsKt.t(this.f78273g);
        UtilityKotlinExtentionsKt.w(this.f78270d);
        this.f78270d.setPkTitle(s1.B(R.string.ttlive_team_fight));
        this.f78270d.setTextSize(2, 12.0f);
        a1.m(this.f78270d, s1.f(2.0f));
        UtilityKotlinExtentionsKt.w(this.f78269c);
        this.f78269c.setAlpha(1.0f);
        this.f78269c.setBackgroundResource(R.drawable.ttlive_team_fight_title_layout_bg_default);
        UIUtils.updateLayout(this.f78269c, -2, -3);
        if (this.f78268b == false) goto L5;
        UtilityKotlinExtentionsKt.t(this.f78272f);
        UtilityKotlinExtentionsKt.t(this.f78273g);
    L5:
        b(r100);
    }

    public final void setPenalState(long r100) {
        this.f78267a = false;
        this.f78269c.setAlpha(1.0f);
        UtilityKotlinExtentionsKt.t(this.f78272f);
        UtilityKotlinExtentionsKt.t(this.f78273g);
        UtilityKotlinExtentionsKt.w(this.f78269c);
        this.f78269c.setAlpha(1.0f);
        this.f78269c.setBackgroundResource(R.drawable.ttlive_team_fight_title_layout_bg_default);
        UtilityKotlinExtentionsKt.w(this.f78270d);
        FightTitleTextView r101 = this.f78270d;
        int r102 = h.f498793a;
        Map r103 = (Map) ((Map) vm2.d.K1.getValue(null, vm2.d.f555776a[138(0x8a, float:1.93E-43)])).get(String.valueOf(7));
        if (r103 == null) goto L6;
        String r104 = (String) r103.get(String.valueOf(4));
        if (r104 == null) goto L6;
    L7:
        r101.setPkTitle(r104);
        a1.m(this.f78270d, s1.f(2.0f));
        if (this.f78268b == false) goto L10;
        UtilityKotlinExtentionsKt.t(this.f78272f);
        UtilityKotlinExtentionsKt.t(this.f78273g);
    L10:
        b(r100);
        return;
    L6:
        r104 = s1.B(R.string.ttlive_live_interact_penalty_title_peak_management);
        goto L7
    }

    public final void setStartMode(boolean r100) {
        this.f78267a = r100;
    }

    public TeamFightTitleLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setClipChildren(false);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_team_fight_info_layout, this, true);
        setOrientation(0);
        this.f78272f = findViewById(R.id.title_start_btn);
        this.f78269c = (ViewGroup) findViewById(R.id.title_content);
        FightTitleTextView r103 = (FightTitleTextView) findViewById(R.id.tv_fight_title);
        this.f78270d = r103;
        NoPaddingTextView r104 = (NoPaddingTextView) findViewById(R.id.tv_time);
        this.f78271e = r104;
        this.f78273g = (HSImageView) findViewById(R.id.title_start_effect);
        r103.setTypeface(Typeface.DEFAULT);
        r103.getPaint().setFakeBoldText(true);
        r103.setGradient(false);
        r103.setTextSize(2, 12.0f);
        ck0.c r105 = new ck0.c();
        ck0.a r106 = new ck0.a(getContext());
        r103.getClass();
        Intrinsics.checkNotNullParameter(r105, "textStyle");
        Intrinsics.checkNotNullParameter(r106, "numStyle");
        r103.f80286f = r105;
        r103.f80287g = r106;
        r104.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/clarity_mono_bold.otf"));
        r104.setPadding(0, 0, 0, s1.f(1.0f));
    }

    public /* synthetic */ TeamFightTitleLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
