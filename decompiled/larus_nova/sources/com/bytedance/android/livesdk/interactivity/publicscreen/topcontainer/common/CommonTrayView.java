package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.base.model.message.m6;
import com.bytedance.android.live.base.model.message.n5;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.bytedance.android.livesdk.interactivity.common.combinedtext.CombinedTextRenderView;
import com.bytedance.android.livesdk.interactivity.common.combinedtext.DisplayImageListView;
import com.bytedance.android.livesdk.interactivity.common.combinedtext.DisplayTextView;
import com.bytedance.android.livesdk.interactivity.common.combinedtext.o;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\"B'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u001b\u0010\f\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/common/CommonTrayView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/base/model/message/n5;", "msg", "", "setContent", "setBackground", "Lcom/bytedance/android/livesdk/utils/q4$b;", ce.f26396k, "Lkotlin/Lazy;", "getComboAnim", "()Lcom/bytedance/android/livesdk/utils/q4$b;", "comboAnim", "Ljava/lang/Runnable;", "l", "getComboRunnable", "()Ljava/lang/Runnable;", "comboRunnable", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/common/a;", "m", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/common/a;", "getComboStats", "()Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/common/a;", "setComboStats", "(Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/common/a;)V", "comboStats", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonTrayView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f139775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CombinedTextRenderView f139776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f139777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f139778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f139779e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f139780f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f139781g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<Long> f139782h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<Long> f139783i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function0<Unit> f139784j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f139785k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f139786l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common.a f139787m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CombinedTextRenderView.a f139788n;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonTrayView f139789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f139790b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ n5 f139791c;

        public b(CommonTrayView r100, String r101, n5 r102) {
            this.f139789a = r100;
            this.f139790b = r101;
            this.f139791c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ALogger.i("CommonTrayView", "handle schema " + this.f139790b);
            IBaseLiveActionHandler r101 = (IBaseLiveActionHandler) k.f(IBaseLiveActionHandler.class);
            if (r101 == null) goto L5;
            r101.handle(this.f139789a.getContext(), this.f139790b);
        L5:
            int r102 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common.b.f139797a;
            n5 r103 = this.f139791c;
            Intrinsics.checkNotNullParameter(r103, "msg");
            com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common.b.a("livesdk_common_tray_click", r103);
        }
    }

    public static final class c implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n5 f139792a;

        public c(n5 r100) {
            this.f139792a = r100;
        }

        @Override // com.bytedance.android.livesdk.interactivity.common.combinedtext.o
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "schema");
            ALogger.i("CommonTrayView", "handle schema " + r100);
            int r101 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common.b.f139797a;
            n5 r102 = this.f139792a;
            Intrinsics.checkNotNullParameter(r102, "msg");
            com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common.b.a("livesdk_common_tray_click", r102);
        }
    }

    public static final class d implements a3.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n5 f139794a;

        @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
        public final void onFail() {
            ALogger.e("CommonTrayView", "load background image failed. msgId=" + this.f139794a.getMessageId());
        }

        public d(n5 r100) {
            this.f139794a = r100;
        }

        @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
        public final void a(NinePatchDrawable r100) {
            Intrinsics.checkNotNullParameter(r100, "ninePatchDrawable");
            ALogger.i("CommonTrayView", "load background image success");
        }
    }

    static {
    }

    public CommonTrayView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommonTrayView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final q4.b getComboAnim() {
        return (q4.b) this.f139785k.getValue();
    }

    private final Runnable getComboRunnable() {
        return (Runnable) this.f139786l.getValue();
    }

    public final void e() {
        this.f139781g = false;
        if (getComboAnim().b() == false) goto L5;
        getComboAnim().a();
    L5:
        removeCallbacks(getComboRunnable());
        this.f139777c.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    public final com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common.a getComboStats() {
        return this.f139787m;
    }

    public static final /* synthetic */ q4.b a(CommonTrayView r100) {
        return r100.getComboAnim();
    }

    public static final /* synthetic */ Runnable b(CommonTrayView r100) {
        return r100.getComboRunnable();
    }

    private final void setBackground(n5 r100) {
        n5.a r101 = r100.getBackground();
        Drawable r102 = null;
        if (r101 == null) goto L5;
        py.k r103 = r101.backgroundImage;
    L6:
        n5.a r104 = r100.getBackground();
        if (r104 == null) goto L9;
        String r105 = r104.backgroundColor;
    L10:
        if (r103 == null) goto L12;
        this.f139776b.setBackground(null);
        int r106 = a3.f114402d;
        a3.a.a(this.f139776b, r103, new d(r100), 0.0f);
        return;
    L12:
        Drawable r107 = this.f139776b.getBackground();
        if ((r107 instanceof GradientDrawable) == false) goto L16;
        r102 = r107;
    L16:
        GradientDrawable r108 = (GradientDrawable) r102;
        if (r108 == null) goto L26;
        r108.setColor(Color.parseColor(r105));     // Catch: Exception -> L20
        ALogger.i("CommonTrayView", "use bg color " + r105);     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        ALogger.e("CommonTrayView", "parse color " + r105 + " failed", e);
        return;
    L26:
        return;
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    private final void setContent(n5 r100) {
        com.bytedance.android.live.base.model.message.d r101 = r100.getContent();
        if (r101 != null) goto L5;
        return;
    L5:
        this.f139776b.a(r101, this.f139788n);
    }

    public final void c(n5 r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        setContent(r100);
        setBackground(r100);
        com.bytedance.android.live.base.model.message.d r101 = r100.getContent();
        if (r101 == null) goto L7;
        m6 r102 = r101.c();
        if (r102 == null) goto L7;
        String r103 = r102.a();
    L8:
        if (r103 != null) goto L10;
    L13:
        boolean r104 = true;
    L14:
        if (r104 == true) goto L16;
        this.f139775a.setOnClickListener(new b(this, r103, r100));
        this.f139776b.setOnSchemaHandleListener(new c(r100));
        return;
    L16:
        this.f139775a.setOnClickListener(null);
        this.f139776b.setOnSchemaHandleListener(null);
        return;
    L10:
        if (r103.length() == 0) goto L13;
        r104 = false;
    L7:
        r103 = null;
        goto L8
    }

    public final void setComboStats(com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common.a r100) {
        this.f139787m = r100;
    }

    public final void d(n5.b r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "comboInfo");
        Intrinsics.checkNotNullParameter(r101, "onFinish");
        List<Long> r102 = r100.numList;
        List<Long> r103 = r100.durationList;
        List<Long> r104 = r102;
        if (r104 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == true) goto L24;
        List<Long> r106 = r103;
        if (r106 != null) goto L13;
    L16:
        boolean r107 = true;
    L17:
        if (r107 == true) goto L25;
        ALogger.i("CommonTrayView", "start combo");
        if (this.f139781g == false) goto L22;
        e();
    L22:
        this.f139784j = r101;
        this.f139779e = r100.seqId;
        this.f139780f = 0;
        ((ArrayList) this.f139782h).clear();
        ((ArrayList) this.f139783i).clear();
        ((ArrayList) this.f139782h).addAll(r104);
        ((ArrayList) this.f139783i).addAll(r106);
        this.f139778d.setText(String.valueOf(((Number) ListProtector.get(r102, 0)).longValue()));
        this.f139777c.setVisibility(0);
        this.f139781g = true;
        post(getComboRunnable());
        return;
    L25:
        return;
    L13:
        if (r106.isEmpty() == true) goto L16;
        r107 = false;
        goto L17
    L24:
        return;
    L5:
        if (r104.isEmpty() == true) goto L8;
        r105 = false;
        goto L9
    }

    public CommonTrayView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_view_common_tray, this);
        this.f139775a = (ViewGroup) findViewById(R.id.common_tray_container);
        CombinedTextRenderView r103 = (CombinedTextRenderView) findViewById(R.id.content);
        this.f139776b = r103;
        r103.setGravity(16);
        this.f139777c = findViewById(R.id.combo_body);
        TextView r104 = (TextView) findViewById(R.id.combo_count_x);
        this.f139778d = (TextView) findViewById(R.id.combo_count);
        this.f139782h = new ArrayList();
        this.f139783i = new ArrayList();
        this.f139785k = LazyKt.lazy(new CommonTrayView$comboAnim$2(this));
        this.f139786l = LazyKt.lazy(new CommonTrayView$comboRunnable$2(this));
        this.f139788n = new CombinedTextRenderView.a(new DisplayTextView.a(UtilityKotlinExtentionsKt.h(14), true, true, 1662), new DisplayImageListView.a(UtilityKotlinExtentionsKt.i(22), UtilityKotlinExtentionsKt.i(22)));
    }

    public /* synthetic */ CommonTrayView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
