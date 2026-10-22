package com.bytedance.android.live.broadcastgame.opengame;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.te0;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerFrameLayout;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\n¢\u0006\u0004\b\u001d\u0010\u001eJ\u0014\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/GameIntroCard;", "Lcom/bytedance/android/livesdk/widget/roundcorner/RoundCornerFrameLayout;", "Lcom/bytedance/android/live/broadcastgame/openplatform/miniapp/card/a;", "Lcom/bytedance/android/live/broadcastgame/api/openplatform/a;", "", "color", "", "setGradientBackground", "info", "setData", "", "getType", "Lkotlin/Function0;", "c", "Lkotlin/jvm/functions/Function0;", "getOnClickBlock", "()Lkotlin/jvm/functions/Function0;", "setOnClickBlock", "(Lkotlin/jvm/functions/Function0;)V", "onClickBlock", "d", "getOnCloseBlock", "setOnCloseBlock", "onCloseBlock", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameIntroCard extends RoundCornerFrameLayout implements com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.a<com.bytedance.android.live.broadcastgame.api.openplatform.a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<Integer, View> f59698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f59699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f59700d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GameIntroCard f59701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.broadcastgame.api.openplatform.a f59702b;

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.GameIntroCard$a$a, reason: collision with other inner class name */
        public static final class ViewOnClickListenerC0981a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f59703a;

            public ViewOnClickListenerC0981a(a r100) {
                this.f59703a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                Function0<Unit> r101 = this.f59703a.f59701a.getOnCloseBlock();
                if (r101 == null) goto L6;
                Unit r102 = r101.invoke();
                return;
            }
        }

        public static final class b implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f59704a;

            public b(a r100) {
                this.f59704a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                Function0<Unit> r101 = this.f59704a.f59701a.getOnClickBlock();
                if (r101 == null) goto L6;
                Unit r102 = r101.invoke();
                return;
            }
        }

        public a(GameIntroCard r100, com.bytedance.android.live.broadcastgame.api.openplatform.a r101) {
            this.f59701a = r100;
            this.f59702b = r101;
        }

        public final void a() {
            boolean r100 = false;
            if (te0.f121292a.getValue().c() != 1) goto L5;
            boolean r101 = true;
        L6:
            String r102 = this.f59702b.f59394c;
            if (r102 != null) goto L9;
        L12:
            boolean r103 = true;
        L14:
            if (r103 == true) goto L18;
            if (r101 == true) goto L18;
            LayoutInflater.from(this.f59701a.getContext()).inflate(R.layout.ttlive_op_game_introduce_card, this.f59701a);
            float r104 = 4;
            com.bytedance.android.live.broadcastgame.opengame.utils.i.a((SimpleDraweeView) this.f59701a.a(R.id.ttlive_card_cover), this.f59702b.f59394c, new PointF(0.0f, 0.0f), UtilityKotlinExtentionsKt.h(r104), UtilityKotlinExtentionsKt.h(r104), 0.0f, 0.0f, 98);
        L28:
            ((TextView) this.f59701a.a(R.id.ttlive_description)).setText(this.f59702b.f59397f);
            ((TextView) this.f59701a.a(R.id.ttlive_card_btn)).setText(this.f59702b.f59398g);
            ((ImageView) this.f59701a.a(R.id.iv_close)).setOnClickListener(new ViewOnClickListenerC0981a(this));
            this.f59701a.setOnClickListener(new b(this));
            return;
        L18:
            LayoutInflater.from(this.f59701a.getContext()).inflate(R.layout.ttlive_op_game_introduce_card_default, this.f59701a);
            float r105 = 8;
            com.bytedance.android.live.broadcastgame.opengame.utils.i.a((SimpleDraweeView) this.f59701a.a(R.id.ttlive_card_cover), this.f59702b.f59393b, new PointF(0.0f, 0.0f), UtilityKotlinExtentionsKt.h(r105), UtilityKotlinExtentionsKt.h(r105), UtilityKotlinExtentionsKt.h(r105), UtilityKotlinExtentionsKt.h(r105), 2);
            String r106 = this.f59702b.f59396e;
            if (r106 != null) goto L21;
        L22:
            r100 = true;
        L24:
            if (r100 == false) goto L26;
            ((TextView) this.f59701a.a(R.id.ttlive_app_name)).setText(this.f59702b.f59395d);
        L27:
            GameIntroCard.b(this.f59701a, this.f59702b.f59399h);
            goto L28
        L26:
            ((TextView) this.f59701a.a(R.id.ttlive_app_name)).setText(this.f59702b.f59396e);
            goto L27
        L21:
            if (r106.length() != 0) goto L24;
        L9:
            if (r102.length() == 0) goto L12;
            r103 = false;
            goto L14
        L5:
            r101 = false;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public GameIntroCard(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GameIntroCard(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.a
    public int getType() {
        return 99;
    }

    public Function0<Unit> getOnClickBlock() {
        return this.f59699c;
    }

    public Function0<Unit> getOnCloseBlock() {
        return this.f59700d;
    }

    private final void setGradientBackground(String r100) {
        int[] r101 = new int[2];
        r101[1] = 0;
        r101[0] = Color.parseColor(r100);     // Catch: Exception -> L5
    L6:
        GradientDrawable r102 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, r101);
        r102.setCornerRadius(s1.f(5.0f));
        r102.setGradientType(0);
        a(R.id.game_card_bg).setBackground(r102);
        a(R.id.game_card_bg).setVisibility(0);
        return;
    L5:
        r101[0] = ColorProtector.parseColor("#3D05A8F4");
        goto L6
    }

    public final View a(int r100) {
        if (this.f59698b != null) goto L5;
        this.f59698b = new LinkedHashMap();
    L5:
        View r101 = this.f59698b.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f59698b.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    /* JADX INFO: renamed from: setData, reason: avoid collision after fix types in other method */
    public void setData2(com.bytedance.android.live.broadcastgame.api.openplatform.a r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        post(new a(this, r100));
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.a
    public void setOnClickBlock(Function0<Unit> r100) {
        this.f59699c = r100;
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.a
    public void setOnCloseBlock(Function0<Unit> r100) {
        this.f59700d = r100;
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.a
    public /* bridge */ /* synthetic */ void setData(com.bytedance.android.live.broadcastgame.api.openplatform.a r100) {
        setData2(r100);
    }

    public static final /* synthetic */ void b(GameIntroCard r100, String r101) {
        r100.setGradientBackground(r101);
    }

    public GameIntroCard(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f59698b = new LinkedHashMap();
        J(UtilityKotlinExtentionsKt.i(5), UtilityKotlinExtentionsKt.i(5), UtilityKotlinExtentionsKt.i(5), UtilityKotlinExtentionsKt.i(5));
    }

    public /* synthetic */ GameIntroCard(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
