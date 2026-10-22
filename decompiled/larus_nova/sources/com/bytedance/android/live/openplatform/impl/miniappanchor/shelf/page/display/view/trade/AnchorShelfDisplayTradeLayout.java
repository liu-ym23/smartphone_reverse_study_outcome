package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.trade;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\n\u000bB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/view/trade/AnchorShelfDisplayTradeLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorShelfDisplayTradeLayout extends LinearLayout {

    public interface a {
        int a();

        int b();

        int c();
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f84561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f84562b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f84563c;

        public b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "rootView");
            this.f84563c = r100;
            this.f84561a = (TextView) r100.findViewById(R.id.trade_value_text);
            this.f84562b = (TextView) r100.findViewById(R.id.trade_title_text);
        }
    }

    public AnchorShelfDisplayTradeLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorShelfDisplayTradeLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a(d r110, final a r210) {
        a r100 = r210;
        Intrinsics.checkNotNullParameter(r110, "unitList");
        Intrinsics.checkNotNullParameter(r100, "config");
        if (r110.f84567b.isEmpty() == false) goto L5;
        return;
    L5:
        removeAllViews();
        Iterator<T> r111 = r110.f84567b.iterator();
    L7:
        if (r111.hasNext() == false) goto L16;
        final c r112 = (c) r111.next();
        r110.getType();
        View r113 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_mini_app_shelf_page_anchor_trade_unit_layout, this, false);
        final b r114 = new b(r113);
        Intrinsics.checkNotNullParameter(r112, Scraps.INNER_UNIT);
        Intrinsics.checkNotNullParameter(r100, "config");
        TextView r115 = r114.f84561a;
        double r101 = CastDoubleProtector.parseDouble(r112.f84565b);     // Catch: Throwable -> L11
    L12:
        final long r102 = (long) Math.floor(r101);
        com.bytedance.android.live.openplatform.impl.base.utils.text.c r116 = new com.bytedance.android.live.openplatform.impl.base.utils.text.c(new SpannableStringBuilder());
        r116.d(r210.a(), new AnchorShelfDisplayTradeLayout$TradeUnitViewHolder$buildText$$inlined$buildSpannedString$lambda$1(r114, r210, r102, r112));
        if (r102 < 10000) goto L15;
        com.bytedance.android.live.openplatform.impl.base.utils.text.b.a.a(r116, UtilityKotlinExtentionsKt.i(2));
        r116.d(r210.c(), new AnchorShelfDisplayTradeLayout$TradeUnitViewHolder$buildText$$inlined$buildSpannedString$lambda$2(r114, r210, r102, r112));
    L15:
        r115.setText(new SpannedString(r116.f84078a));
        r114.f84562b.setText(r112.f84564a);
        r114.f84562b.setTextSize(r210.b());
        addView(r113);
        r100 = r210;
    L11:
        r101 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L12
    }

    public AnchorShelfDisplayTradeLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ AnchorShelfDisplayTradeLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
