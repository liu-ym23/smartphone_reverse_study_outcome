package com.bytedance.android.livesdk.widget.playertips;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.config.ge1;
import com.bytedance.live.datacontext.n;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nv2.d;
import sh6.b;
import sh6.c;
import t70.k;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/widget/playertips/PlayerTipsTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Ld90/a;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerTipsTetris extends LiveTetris<d90.a> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ImageView f161934o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f161935p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f161936q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f161937r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CompositeDisposable f161938s;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerTipsTetris f161939a;

        public a(PlayerTipsTetris r100) {
            this.f161939a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ge1 r101 = (ge1) c.b((b) r100);
            if (r101 == null) goto L23;
            PlayerTipsTetris r102 = this.f161939a;
            r102.getClass();
            ALogger.d("PlayerTipsLog", "PlayerTipsTetris " + r102.hashCode() + " onChanged " + r101 + ' ');
            int r103 = r101.f120275a;
            if (r103 != 1) goto L19;
            r102.V(r101.f120279e, 0);
            TextView r104 = r102.f161935p;
            if (r104 == null) goto L9;
            r104.setText(r101.f120277c);
        L9:
            TextView r105 = r102.f161936q;
            if (r105 == null) goto L12;
            r105.setText(r101.f120278d);
        L12:
            TextView r106 = r102.f161936q;
            if (r106 == null) goto L15;
            r106.setOnClickListener(new nv2.c(r102, r101));
        L15:
            ImageView r107 = r102.f161934o;
            if (r107 == null) goto L24;
            r107.setOnClickListener(new d(r102, r101));
            return;
        L24:
            return;
        L19:
            if (r103 != 2) goto L21;
            r102.V(true, 8);
            return;
        L21:
            r102.V(true, 8);
            return;
        }
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void O() {
        ALogger.d("PlayerTipsLog", "PlayerTipsTetris onViewCreated");
        n r100 = nv2.b.b();
        if (r100 == null) goto L5;
        Observable r101 = r100.a();
    L6:
        if (r101 == null) goto L10;
        Disposable r102 = r101.subscribe(new a(this));
        if (r102 == null) goto L10;
        RxUtilKt.c(r102, this.f161938s);
    L10:
        nv2.b.c(new ge1(0, 0, 127));
        return;
    L5:
        r101 = null;
        goto L6
    }

    public PlayerTipsTetris() {
        this.f161938s = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void onDestroy() {
        super.onDestroy();
        this.f161938s.dispose();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final View G(k r100) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r101 = r100.b(R.layout.ttlive_widget_player_tips);
        r101.setVisibility(8);
        this.f161934o = (ImageView) r101.findViewById(R.id.imv_close_tips);
        this.f161935p = (TextView) r101.findViewById(R.id.tv_tips_content);
        this.f161936q = (TextView) r101.findViewById(R.id.tv_agree_tips);
        this.f161937r = r101;
        return r101;
    }

    public final void V(boolean r100, int r101) {
        View r102 = this.f161937r;
        if (r102 == null) goto L5;
        r102.setVisibility(r101);
    L5:
        ImageView r103 = this.f161934o;
        if (r103 == null) goto L11;
        if (r100 == false) goto L9;
        int r104 = r101;
    L10:
        r103.setVisibility(r104);
        goto L11
    L9:
        r104 = 8;
    L11:
        View r105 = this.f161937r;
        if (r105 == null) goto L14;
        r105.setVisibility(r101);
    L14:
        TextView r106 = this.f161936q;
        if (r106 == null) goto L17;
        r106.setVisibility(r101);
    L17:
        TextView r107 = this.f161935p;
        if (r107 == null) goto L21;
        r107.setVisibility(r101);
        return;
    }
}
