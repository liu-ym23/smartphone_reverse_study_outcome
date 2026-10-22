package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/PKRankUnlockView;", "Landroid/widget/FrameLayout;", "Lkotlin/Function0;", "", SendEventContainerMethodParamModel.EventKinds.onClick, "setOnRandomMatchBtnClick", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PKRankUnlockView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f96906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f96907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f96908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f96909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f96910e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f96911f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f96912g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f96913h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public zy0.d f96914i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f96915j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function0<Unit> f96916k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f96917l;

    public static final class a implements Function1<yy0.d, Unit> {
        public a() {
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(yy0.d r100) {
            yy0.d r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "p1");
            r101.d(PKRankUnlockView$callBackObject$1$invoke$1.INSTANCE);
            return Unit.INSTANCE;
        }
    }

    public PKRankUnlockView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PKRankUnlockView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        zy0.d r100 = this.f96914i;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public final void setOnRandomMatchBtnClick(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, SendEventContainerMethodParamModel.EventKinds.onClick);
        this.f96916k = r100;
    }

    public PKRankUnlockView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f96916k = PKRankUnlockView$onRandomBtnClick$1.INSTANCE;
        View r103 = FrameLayout.inflate(r100, R.layout.ttlive_item_pk_rank_unlock_view, this);
        HSImageView r104 = (HSImageView) r103.findViewById(R.id.rank_locked_img);
        this.f96910e = (TextView) r103.findViewById(R.id.rank_locked_img_tip);
        this.f96906a = (FrameLayout) r103.findViewById(R.id.rank_progress_container);
        this.f96907b = r103.findViewById(R.id.rank_progress);
        this.f96908c = (TextView) r103.findViewById(R.id.rank_unlock_detail);
        this.f96909d = (TextView) r103.findViewById(R.id.rank_new_title);
        this.f96911f = (TextView) r103.findViewById(R.id.rank_unlock_progress);
        this.f96912g = (TextView) r103.findViewById(R.id.random_match_btn);
        this.f96913h = (TextView) r103.findViewById(R.id.rank_new_season_label);
        this.f96917l = new a();
    }

    public /* synthetic */ PKRankUnlockView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
