package com.bytedance.android.livesdk.livecommerce.iron.ui;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.c0;
import com.bytedance.android.ec.core.utils.font.ECFontHelper;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.AutoSizeTextView;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.live.p;
import com.bytedance.android.ec.model.live.q;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.RemoteGroupHeadImageView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.t0;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.generic.RoundingParams;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003 !\"B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/ECCustomizedElementView;", "Landroid/widget/LinearLayout;", "Lkotlin/Function0;", "", "callback", "setCountDownEndCallback", "", "getShowContent", "", "Lcom/bytedance/android/ec/model/live/b;", "getCurrentData", "Lbk2/d;", "h", "Lkotlin/Lazy;", "getDisposableContext", "()Lbk2/d;", "disposableContext", "Lcom/bytedance/android/livesdk/livecommerce/iron/ui/ECCustomizedElementView$a;", "<set-?>", RXScreenCaptureService.KEY_INDEX, "Lcom/bytedance/android/livesdk/livecommerce/iron/ui/ECCustomizedElementView$a;", "getAnimatorState", "()Lcom/bytedance/android/livesdk/livecommerce/iron/ui/ECCustomizedElementView$a;", "animatorState", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCustomizedElementView extends LinearLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f148866k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<com.bytedance.android.ec.model.live.b> f148867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ECCustomizedCountDownView f148868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f148869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q f148870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f148871e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Animator f148872f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Animator f148873g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f148874h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f148875i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ECCustomizedElementView$countDownTickListener$1 f148876j;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.iron.ui.ECCustomizedElementView$a$a, reason: collision with other inner class name */
        public static final class C2303a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C2303a f148877a = null;

            static {
                f148877a = new C2303a();
            }

            public C2303a() {
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f148878a = null;

            static {
                f148878a = new b();
            }

            public b() {
            }
        }

        public a() {
        }
    }

    public static final class b {
    }

    public final class c extends TextView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Disposable f148879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.bytedance.android.ec.model.live.i f148880b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ECCustomizedElementView f148881c;

        public static final class a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f148882a;

            public a(c r100) {
                this.f148882a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Long r101 = (Long) r100;
                com.bytedance.android.ec.model.live.i r102 = this.f148882a.f148880b;
                if (r102 == null) goto L20;
                List<String> r103 = r102.c();
                if (r103 != null) goto L7;
                return;
            L7:
                if ((!r103.isEmpty()) == true) goto L10;
                r103 = null;
            L10:
                if (r103 != null) goto L12;
                return;
            L12:
                if (r101.longValue() < r103.size()) goto L16;
                c r104 = this.f148882a;
                Disposable r105 = r104.f148879a;
                if (r105 == null) goto L23;
                bk2.d r106 = ECCustomizedElementView.a(r104.f148881c);
                Intrinsics.checkNotNullParameter(r105, "$this$disposeFrom");
                Intrinsics.checkNotNullParameter(r106, "disposableContext");
                r106.remove(r105);
                return;
            L23:
                return;
            L16:
                this.f148882a.setText((CharSequence) CollectionsKt.getOrNull(r103, (int) r101.longValue()));
                if (r101.longValue() != (((long) r103.size()) - 1)) goto L25;
                this.f148882a.animate().scaleX(1.2f).scaleY(1.2f).setDuration(200).withEndAction(new com.bytedance.android.livesdk.livecommerce.iron.ui.b(this)).start();
                return;
            L25:
                return;
            }
        }

        public final void a() {
            int r100 = t0.f153116a;
            com.bytedance.android.ec.model.live.i r101 = this.f148880b;
            if (r101 == null) goto L5;
            long r102 = r101.a();
        L6:
            this.f148879a = bk2.c.a(t0.a(200, r102, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this)), ECCustomizedElementView.a(this.f148881c));
            return;
        L5:
            r102 = 200;
            goto L6
        }

        public final float getLoopEndingTextWidth() {
            com.bytedance.android.ec.model.live.i r100 = this.f148880b;
            if (r100 == null) goto L7;
            List<String> r101 = r100.c();
            if (r101 == null) goto L7;
            String r102 = (String) CollectionsKt.lastOrNull(r101);
        L8:
            if (r102 != null) goto L10;
        L13:
            boolean r103 = true;
        L14:
            if (r103 == false) goto L17;
            return 0.0f;
        L17:
            return getPaint().measureText(r102);
        L10:
            if (r102.length() == 0) goto L13;
            r103 = false;
        L7:
            r102 = null;
            goto L8
        }

        public c(ECCustomizedElementView r100, com.bytedance.android.ec.model.live.i r101, Context r102) {
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f148881c = r100;
            String r103 = null;
            boolean r104 = false;
            super(r102, null, 0);
            this.f148880b = r101;
            setMaxLines(1);
            if (r101 == null) goto L12;
            Integer r105 = Integer.valueOf(r101.e());
            if (r105.intValue() <= 0) goto L7;
            r104 = true;
        L7:
            if (r104 == true) goto L10;
            r105 = null;
        L10:
            if (r105 == null) goto L12;
            float r106 = r105.intValue();
        L13:
            setTextSize(1, r106);
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            if (r101 != null) goto L16;
        L18:
            setEllipsize(TextUtils.TruncateAt.END);
            int r107 = s.f45717a;
            if (r101 == null) goto L21;
            r103 = r101.d();
        L21:
            Integer r108 = s.b(r103);
            if (r108 == null) goto L24;
            int r109 = r108.intValue();
        L25:
            setTextColor(r109);
            return;
        L24:
            r109 = -16777216;
            goto L25
        L16:
            if (r101.b() != true) goto L18;
            setTypeface(Typeface.DEFAULT_BOLD);
        L12:
            r106 = 12.0f;
            goto L13
        }
    }

    static {
    }

    public ECCustomizedElementView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECCustomizedElementView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final bk2.d getDisposableContext() {
        return (bk2.d) this.f148874h.getValue();
    }

    public final String getShowContent() {
        List<com.bytedance.android.ec.model.live.b> r100 = this.f148867a;
        if (r100 == null) goto L31;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L13;
        Object r103 = r102.next();
        if (((com.bytedance.android.ec.model.live.b) r103).o() != 20) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L6;
        r101.add(r103);
        goto L6
    L10:
        r104 = false;
        goto L11
    L13:
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r106 = r101.iterator();
    L15:
        if (r106.hasNext() == false) goto L22;
        com.bytedance.android.ec.model.live.l r107 = ((com.bytedance.android.ec.model.live.b) r106.next()).n();
        if (r107 == null) goto L19;
        String r108 = r107.j();
    L20:
        r105.add(r108);
        goto L15
    L19:
        r108 = null;
        goto L20
    L22:
        return CollectionsKt.joinToString$default(r105, null, null, null, 0, null, null, 63, null);
    L31:
        return null;
    }

    public final void e() {
        removeAllViews();
        this.f148867a = null;
        this.f148870d = null;
        this.f148868b = null;
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.f153222a.c(this.f148876j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        getDisposableContext().clearDisposable();
        c r100 = this.f148869c;
        if (r100 == null) goto L7;
        Disposable r101 = r100.f148879a;
        if (r101 == null) goto L7;
        r101.dispose();
    L7:
        super.onDetachedFromWindow();
    }

    public final a getAnimatorState() {
        return this.f148875i;
    }

    public final List<com.bytedance.android.ec.model.live.b> getCurrentData() {
        return this.f148867a;
    }

    public static final /* synthetic */ bk2.d a(ECCustomizedElementView r100) {
        return r100.getDisposableContext();
    }

    public static float k(TextView r100) {
        TextPaint r101 = r100.getPaint();
        CharSequence r102 = r100.getText();
        if (r102 == null) goto L6;
        String r103 = r102.toString();
        if (r103 == null) goto L6;
    L8:
        return r101.measureText(r103);
    L6:
        r103 = "";
        goto L8
    }

    public final View f(ECUrlModel r110) {
        LinearLayout r100 = new LinearLayout(getContext());
        r100.setOrientation(0);
        r100.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        Float r101 = null;
        float r102 = 22.0f;
        if (r110 == null) goto L13;
        Float r103 = Float.valueOf(r110.getWidth());
        if (r103.floatValue() <= 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L11;
        r103 = null;
    L11:
        if (r103 == null) goto L13;
        float r105 = r103.floatValue();
    L14:
        if (r110 == null) goto L23;
        Float r106 = Float.valueOf(r110.getHeight());
        if (r106.floatValue() <= 0) goto L18;
        boolean r107 = true;
    L19:
        if (r107 == false) goto L21;
        r101 = r106;
    L21:
        if (r101 == null) goto L23;
        r102 = r101.floatValue();
        goto L23
    L18:
        r107 = false;
    L23:
        if (r110 == null) goto L46;
        List<String> r111 = r110.getUrlList();
        if (r111 == null) goto L46;
        ArrayList r108 = new ArrayList();
        Iterator<T> r112 = r111.iterator();
    L28:
        if (r112.hasNext() == false) goto L32;
        Object r109 = r112.next();
        if (a2.b((String) r109) == false) goto L28;
        r108.add(r109);
        goto L28
    L32:
        Iterator r113 = r108.iterator();
        int r114 = 0;
    L34:
        if (r113.hasNext() == false) goto L46;
        Object r115 = r113.next();
        int r116 = r114 + 1;
        if (r114 >= 0) goto L38;
        CollectionsKt.throwIndexOverflow();
    L38:
        String r117 = (String) r115;
        RemoteGroupHeadImageView r118 = new RemoteGroupHeadImageView(getContext());
        r118.getHierarchy().setRoundingParams(RoundingParams.asCircle());
        if (r114 == 0) goto L41;
        boolean r119 = true;
    L42:
        r118.setClip(r119);
        LinearLayout.LayoutParams r120 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.d(Float.valueOf(r105)), UtilityKotlinExtentionsKt.d(Float.valueOf(r102)));
        if (r114 == 0) goto L45;
        int r121 = UtilityKotlinExtentionsKt.d(Float.valueOf(-2.5f));
        r120.setMarginStart(r121);
        r120.leftMargin = r121;
    L45:
        y.d(r118, r117);
        r100.addView(r118, r120);
        r114 = r116;
        goto L34
    L41:
        r119 = false;
    L46:
        return r100;
    L7:
        r104 = false;
    L13:
        r105 = 22.0f;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v22, types: [android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.ec.core.widget.AutoSizeTextView] */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.Number] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v38 */
    /* JADX WARN: Type inference failed for: r8v43 */
    /* JADX WARN: Type inference failed for: r8v44 */
    /* JADX WARN: Type inference failed for: r8v45 */
    /* JADX WARN: Type inference failed for: r8v46 */
    /* JADX WARN: Type inference failed for: r8v47 */
    /* JADX WARN: Type inference failed for: r8v48 */
    /* JADX WARN: Type inference failed for: r8v49 */
    /* JADX WARN: Type inference failed for: r8v5, types: [android.util.AttributeSet] */
    /* JADX WARN: Type inference failed for: r8v50 */
    /* JADX WARN: Type inference failed for: r8v51 */
    /* JADX WARN: Type inference failed for: r8v52 */
    /* JADX WARN: Type inference failed for: r8v53 */
    public final View j(com.bytedance.android.ec.model.live.b r210) {
        int r100 = r210.o();
        boolean r101 = true;
        if (r100 != 1) goto L5;
        ?? r102 = f(r210.a());
    L232:
        if (r210.e() == false) goto L235;
        if (r102 == 0) goto L235;
        r102.setTag("cart_add_destination");
    L235:
        return r102;
    L5:
        if (r100 == 2) goto L229;
        int r103 = 0;
        if (r100 == 3) goto L225;
        ?? r104 = 0;
        Long r105 = null;
        com.bytedance.android.ec.model.live.f r106 = null;
        ECUrlModel r107 = null;
        String r108 = null;
        if (r100 == 4) goto L224;
        float r109 = 12.0f;
        if (r100 == 5) goto L223;
        int r110 = 6;
        switch(r100) {
            case 20: goto L93;
            case 21: goto L86;
            case 22: goto L79;
            case 23: goto L75;
            case 24: goto L63;
            case 25: goto L17;
            default: goto L15;
        };
    L17:
        final com.bytedance.android.ec.model.live.e r111 = r210.c();
        final ECCustomizedElementView r112 = new ECCustomizedElementView(getContext(), r104, r110, r103);
        if (r111 == null) goto L62;
        r112.setGravity(17);
        Integer r113 = Integer.valueOf(r111.f());
        if (r113.intValue() <= 0) goto L22;
        boolean r114 = true;
    L23:
        if (r114 == true) goto L26;
        r113 = null;
    L26:
        int r115 = -2;
        if (r113 == null) goto L29;
        r112.setLayoutParams(new LinearLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(Integer.valueOf(r113.intValue()))));
    L29:
        ECUrlModel r116 = r111.b();
        if (r116 == null) goto L52;
        Integer r117 = Integer.valueOf(r116.getWidth());
        if (r117.intValue() <= 0) goto L34;
        boolean r118 = true;
    L35:
        if (r118 == true) goto L38;
        r117 = null;
    L38:
        if (r117 == null) goto L40;
        r115 = UtilityKotlinExtentionsKt.d(r117);
    L40:
        Integer r119 = Integer.valueOf(r116.getHeight());
        if (r119.intValue() <= 0) goto L43;
        boolean r120 = true;
    L44:
        if (r120 == true) goto L47;
        r119 = null;
    L47:
        if (r119 != null) goto L50;
        r119 = Integer.valueOf(getHeight());
    L50:
        r112.setLayoutParams(new LinearLayout.LayoutParams(r115, UtilityKotlinExtentionsKt.d(r119)));
        if (h0.g(r116, null, new ECCustomizedElementView$createBlockGroup$$inlined$also$lambda$1(r112, this, r111)) == null) goto L52;
    L55:
        ViewExtensionsKt.f(r112, UtilityKotlinExtentionsKt.c(Integer.valueOf(r111.h())), UtilityKotlinExtentionsKt.c(Integer.valueOf(r111.h())), UtilityKotlinExtentionsKt.c(Integer.valueOf(r111.h())), UtilityKotlinExtentionsKt.c(Integer.valueOf(r111.h())), false);
        List<com.bytedance.android.ec.model.live.b> r121 = r111.e();
        if (r121 == null) goto L58;
        r112.b(r121, false);
    L58:
        final p r122 = r111.g();
        if (r122 == null) goto L61;
        com.bytedance.android.ec.core.widget.f.c(r112, null, "bind_key_live_promotion_list", new ECCustomizedElementView$createBlockGroup$$inlined$also$lambda$2(r122, r111, r112, this, r111), 1);
    L61:
        postDelayed(new com.bytedance.android.livesdk.livecommerce.iron.ui.c(r111, r112, this), 100);
        goto L62
    L43:
        r120 = false;
        goto L44
    L34:
        r118 = false;
    L52:
        String r123 = r111.a();
        if (r123 == null) goto L55;
        int r124 = s.f45717a;
        r112.setBackgroundColor(s.a(r123, th.a.a(getContext(), R.color.transparent)));
        goto L55
    L22:
        r114 = false;
    L62:
        r102 = r112;
        goto L232
    L63:
        com.bytedance.android.ec.model.live.h r125 = r210.j();
        if (r125 == null) goto L66;
        ECUrlModel r126 = r125.b();
    L67:
        com.bytedance.android.ec.model.live.h r127 = r210.j();
        if (r127 == null) goto L70;
        Integer r128 = Integer.valueOf(r127.c());
    L71:
        com.bytedance.android.ec.model.live.h r129 = r210.j();
        if (r129 == null) goto L74;
        r106 = r129.a();
    L74:
        r102 = h(r126, r128, r106);
        goto L232
    L70:
        r128 = null;
        goto L71
    L66:
        r126 = null;
        goto L67
    L75:
        com.bytedance.android.ec.model.live.c r130 = r210.g();
        if (r130 == null) goto L78;
        r107 = r130.a();
    L78:
        r102 = f(r107);
        goto L232
    L79:
        q r131 = (q) r210.f47887a.getValue();
        com.bytedance.android.ec.model.live.g r132 = r210.i();
        if (r132 == null) goto L82;
        r108 = r132.a();
    L82:
        com.bytedance.android.ec.model.live.g r133 = r210.i();
        if (r133 == null) goto L85;
        r109 = r133.d();
    L85:
        r102 = g(r131, r108, Float.valueOf(r109));
        goto L232
    L86:
        com.bytedance.android.ec.model.live.d r134 = r210.h();
        if (r134 == null) goto L89;
        r104 = Integer.valueOf(r134.a());
    L89:
        Space r135 = new Space(getContext());
        if (r104 == 0) goto L92;
        r103 = (int) UtilityKotlinExtentionsKt.c(r104);
    L92:
        r135.setMinimumWidth(r103);
        r102 = r135;
        goto L232
    L93:
        com.bytedance.android.ec.model.live.l r136 = r210.n();
        if (r136 == null) goto L96;
        String r137 = r136.j();
    L97:
        com.bytedance.android.ec.model.live.l r138 = r210.n();
        if (r138 == null) goto L100;
        Integer r139 = r138.i();
    L101:
        com.bytedance.android.ec.model.live.l r140 = r210.n();
        if (r140 == null) goto L104;
        String r141 = r140.b();
    L105:
        com.bytedance.android.ec.model.live.l r142 = r210.n();
        if (r142 != null) goto L108;
    L110:
        boolean r143 = false;
    L111:
        com.bytedance.android.ec.model.live.l r144 = r210.n();
        if (r144 == null) goto L114;
        ECUrlModel r145 = r144.f();
    L115:
        com.bytedance.android.ec.model.live.l r146 = r210.n();
        if (r146 == null) goto L118;
        Long r147 = Long.valueOf(r146.h());
    L119:
        com.bytedance.android.ec.model.live.l r148 = r210.n();
        if (r148 == null) goto L122;
        Integer r149 = r148.d();
    L123:
        com.bytedance.android.ec.model.live.l r150 = r210.n();
        if (r150 == null) goto L126;
        Integer r151 = r150.e();
    L127:
        com.bytedance.android.ec.model.live.l r152 = r210.n();
        if (r152 == null) goto L130;
        Integer r153 = r152.g();
    L131:
        r102 = i(r137, r139, r141, r143, r145, r147, r149, r151, r153);
        goto L232
    L130:
        r153 = null;
        goto L131
    L126:
        r151 = null;
        goto L127
    L122:
        r149 = null;
        goto L123
    L118:
        r147 = null;
        goto L119
    L114:
        r145 = null;
        goto L115
    L108:
        if (r142.a() != true) goto L110;
        r143 = true;
        goto L111
    L104:
        r141 = null;
        goto L105
    L100:
        r139 = null;
        goto L101
    L96:
        r137 = null;
        goto L97
    L15:
        switch(r100) {
            case 27: goto L148;
            case 28: goto L133;
            case 29: goto L132;
            default: goto L16;
        };
    L16:
        r102 = 0;
        goto L232
    L132:
        c r154 = new c(this, r210.k(), getContext());
        this.f148869c = r154;
        r102 = r154;
        goto L232
    L133:
        final com.bytedance.android.ec.model.live.j r155 = r210.l();
        final PriceView r156 = new PriceView(getContext(), null, 0, 14);
        if (r155 == null) goto L147;
        Long r157 = Long.valueOf(r155.d());
        if (r157.longValue() <= 0) goto L138;
        boolean r158 = true;
    L139:
        if (r158 == false) goto L141;
        r105 = r157;
    L141:
        if (r105 == null) goto L143;
        r109 = r105.longValue();
    L143:
        r156.setTextSize(1, r109);
        r156.C(new ECCustomizedElementView$createPriceElement$$inlined$also$lambda$1(r155, r156, r155));
        if (r155.e() <= 0) goto L146;
        r156.setMaxWidth(UtilityKotlinExtentionsKt.c(Long.valueOf(r155.e())));
    L146:
        r156.setPadding(0, UtilityKotlinExtentionsKt.d(Long.valueOf(r155.d() / ((long) 4))), 0, 0);
        r156.setIncludeFontPadding(false);
        goto L147
    L138:
        r158 = false;
    L147:
        r102 = r156;
        goto L232
    L148:
        com.bytedance.android.ec.model.live.k r159 = r210.m();
        ?? r160 = new AutoSizeTextView(getContext(), r104, r110, r103);
        SpannableStringBuilder r161 = new SpannableStringBuilder();
        if (r159 == null) goto L210;
        List<com.bytedance.android.ec.model.live.b> r162 = r159.a();
        if (r162 == null) goto L210;
        ArrayList r163 = new ArrayList();
        Iterator r164 = r162.iterator();
    L153:
        int r165 = 20;
        if (r164.hasNext() == false) goto L164;
        Object r166 = r164.next();
        com.bytedance.android.ec.model.live.b r167 = (com.bytedance.android.ec.model.live.b) r166;
        if (r167.o() != 20) goto L158;
    L161:
        boolean r168 = true;
    L162:
        if (r168 == false) goto L153;
        r163.add(r166);
        goto L153
    L158:
        if (r167.o() == 21) goto L161;
        r168 = false;
        goto L162
    L164:
        Iterator r169 = r163.iterator();
        int r170 = 0;
        int r171 = 12;
    L166:
        if (r169.hasNext() == false) goto L209;
        Object r172 = r169.next();
        int r173 = r170 + 1;
        if (r170 >= 0) goto L170;
        CollectionsKt.throwIndexOverflow();
    L170:
        com.bytedance.android.ec.model.live.b r174 = (com.bytedance.android.ec.model.live.b) r172;
        if (r174.o() != r165) goto L204;
        com.bytedance.android.ec.model.live.l r175 = r174.n();     // Catch: Throwable -> L206
        if (r175 == null) goto L208;
        if (a2.b(r175.j()) == true) goto L179;
        r175 = null;
    L179:
        if (r175 == null) goto L208;
        if (r170 != 0) goto L193;
        Integer r176 = r175.i();     // Catch: Throwable -> L206
        if (r176 != null) goto L184;
    L192:
        r171 = 12;
        goto L193
    L184:
        if (r176.intValue() <= 0) goto L186;
        boolean r177 = true;
    L187:
        if (r177 == true) goto L190;
        r176 = null;
    L190:
        if (r176 == null) goto L192;
        r171 = r176.intValue();     // Catch: Throwable -> L206
        goto L193
    L186:
        r177 = false;
    L193:
        String r178 = r175.j();     // Catch: Throwable -> L206
        if (r178 != null) goto L196;
        r178 = "";
    L196:
        SpannableString r179 = new SpannableString(r178);     // Catch: Throwable -> L206
        if (a2.b(r175.b()) == false) goto L200;
        r179.setSpan(new ForegroundColorSpan(Color.parseColor(r175.b())), 0, r178.length(), 33);     // Catch: Throwable -> L206
    L200:
        if (r175.a() == false) goto L202;
        int r180 = 1;
    L203:
        r179.setSpan(new StyleSpan(r180), 0, r178.length(), 33);     // Catch: Throwable -> L206
        r161.append(r179);     // Catch: Throwable -> L206
        goto L208
    L202:
        r180 = 0;
    L208:
        r170 = r173;
        r165 = 20;
        goto L166
    L204:
        r161.append(new SpannableString(" "));     // Catch: Throwable -> L206
    L206:
        th = move-exception;
        ECExceptionMonitor.e(th);
        goto L208
    L209:
        int r181 = r171;
    L211:
        r160.setText(r161);
        r160.setBaseTextSize(UtilityKotlinExtentionsKt.c(Integer.valueOf(r181)));
        r160.setTextSize(1, r181);
        if (r159 == null) goto L222;
        Long r182 = Long.valueOf(r159.b());
        if (r182.longValue() > 0) goto L217;
        r101 = false;
    L217:
        if (r101 == false) goto L219;
        Long r183 = r182;
    L220:
        if (r183 == null) goto L222;
        r160.setViewMaxWidth(UtilityKotlinExtentionsKt.d(Long.valueOf(r183.longValue())));
        goto L222
    L219:
        r183 = null;
    L222:
        r102 = r160;
    L210:
        r181 = 12;
        goto L211
    L223:
        r102 = g((q) r210.f47887a.getValue(), r210.t(), Float.valueOf(12.0f));
        goto L232
    L224:
        r102 = h(r210.q(), null, null);
        goto L232
    L225:
        Integer r184 = Integer.valueOf(r210.b());
        Space r185 = new Space(getContext());
        if (r184 == null) goto L228;
        r103 = (int) UtilityKotlinExtentionsKt.c(r184);
    L228:
        r185.setMinimumWidth(r103);
        r102 = r185;
        goto L232
    L229:
        r102 = i(r210.s(), Integer.valueOf(r210.p()), r210.t(), r210.d(), null, null, null, null, null);
        goto L232
    }

    public final void setCountDownEndCallback(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f148871e = r100;
    }

    public final void b(List<com.bytedance.android.ec.model.live.b> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if ((!Intrinsics.areEqual(this.f148867a, r100)) == true) goto L5;
        if (r101 == true) goto L5;
    L17:
        c r102 = this.f148869c;
        if (r102 == null) goto L26;
        r102.a();
        return;
    L26:
        return;
    L5:
        Animator r103 = this.f148872f;
        if (r103 == null) goto L8;
        r103.cancel();
    L8:
        this.f148872f = null;
        Animator r104 = this.f148873g;
        if (r104 == null) goto L11;
        r104.cancel();
    L11:
        this.f148873g = null;
        e();
        this.f148875i = a.C2303a.f148877a;
        this.f148867a = r100;
        Iterator<T> r105 = r100.iterator();
    L13:
        if (r105.hasNext() == false) goto L17;
        View r106 = j((com.bytedance.android.ec.model.live.b) r105.next());
        if (r106 == null) goto L13;
        addView(r106);
        goto L13
    }

    public final void c(List r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "data");
        boolean r100 = true;
        boolean r101 = !Intrinsics.areEqual(this.f148867a, r110);
        Animator r102 = this.f148872f;
        if (r102 == null) goto L5;
        r102.cancel();
    L5:
        View r103 = null;
        this.f148872f = null;
        Animator r104 = this.f148873g;
        if (r104 == null) goto L8;
        r104.cancel();
    L8:
        this.f148873g = null;
        e();
        this.f148875i = a.C2303a.f148877a;
        this.f148867a = r110;
        Iterator r112 = r110.iterator();
        int r105 = -1;
        View r106 = null;
        float r107 = 0.0f;
        int r108 = 0;
    L10:
        if (r112.hasNext() == false) goto L61;
        Object r109 = r112.next();
        int r113 = r108 + 1;
        if (r108 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        com.bytedance.android.ec.model.live.b r114 = (com.bytedance.android.ec.model.live.b) r109;
        View r115 = j(r114);
        if (r115 == null) goto L60;
        int r116 = r114.o();
        if (r116 != 20) goto L19;
        com.bytedance.android.ec.model.live.l r117 = r114.n();
        if (r117 == null) goto L50;
        if (r117.c() != true) goto L50;
        if (r106 != null) goto L50;
        r105 = r108;
        r106 = r115;
    L50:
        if ((r115 instanceof TextView) == true) goto L52;
        View r118 = null;
    L53:
        TextView r119 = (TextView) r118;
        if (r119 == null) goto L58;
        float r120 = k(r119);
    L56:
        r107 = r107 + r120;
    L58:
        if (r107 > r111) goto L97;
        addView(r115);
    L97:
        c r121 = this.f148869c;
        if (r121 == null) goto L108;
        r121.a();
        return;
    L108:
        return;
    L52:
        r118 = r115;
        goto L53
    L19:
        if (r116 != 21) goto L21;
        com.bytedance.android.ec.model.live.d r122 = r114.h();
        if (r122 == null) goto L42;
        r120 = UtilityKotlinExtentionsKt.c(Integer.valueOf(r122.a()));
    L42:
        r120 = 0.0f;
        goto L56
    L21:
        if (r116 == 24) goto L34;
        switch(r116) {
            case 27: goto L28;
            case 28: goto L28;
            case 29: goto L24;
            default: goto L58;
        };
    L24:
        c r123 = this.f148869c;
        if (r123 == null) goto L42;
        r120 = r123.getLoopEndingTextWidth();
        goto L56
    L28:
        if ((r115 instanceof TextView) == true) goto L30;
        View r124 = null;
    L31:
        TextView r125 = (TextView) r124;
        if (r125 == null) goto L58;
        r120 = k(r125);
        goto L56
    L30:
        r124 = r115;
        goto L31
    L34:
        com.bytedance.android.ec.model.live.h r126 = r114.j();
        if (r126 == null) goto L42;
        ECUrlModel r127 = r126.b();
        if (r127 == null) goto L42;
        r120 = UtilityKotlinExtentionsKt.c(Integer.valueOf(r127.getWidth()));
    L60:
        r108 = r113;
        goto L10
    L61:
        Float r128 = Float.valueOf(r111 - r107);
        if (r128.floatValue() <= 0) goto L64;
        boolean r129 = true;
    L65:
        if (r129 == true) goto L68;
        r128 = null;
    L68:
        if (r128 == null) goto L97;
        float r130 = r128.floatValue();
        if ((r106 instanceof TextView) == false) goto L73;
        r103 = r106;
    L73:
        TextView r131 = (TextView) r103;
        if (r131 == null) goto L95;
        String r132 = r131.getText().toString();
        if (r131.getPaint().measureText(r132) <= r130) goto L95;
    L79:
        if (r132.length() <= 0) goto L81;
        boolean r133 = true;
    L83:
        if (r133 == false) goto L88;
        if (r131.getPaint().measureText(r132.concat("… ")) <= r130) goto L88;
        r132 = r132.substring(0, r132.length() - 1);
    L88:
        if (r132.length() > 0) goto L91;
        r100 = false;
    L91:
        if (r100 == false) goto L93;
        String r134 = r132.concat("… ");
    L94:
        float r135 = r131.getPaint().measureText(r134);
        r131.setText(r134);
        ViewGroup.LayoutParams r136 = r131.getLayoutParams();
        r136.width = (int) r135;
        r131.setLayoutParams(r136);
        goto L95
    L93:
        r134 = "";
        goto L94
    L81:
        r133 = false;
    L95:
        if (r106 == null) goto L97;
        addView(r106, r105);
        goto L97
    L64:
        r129 = false;
        goto L65
    }

    public final void d(List r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "data");
        if ((!Intrinsics.areEqual(this.f148867a, r110)) == false) goto L86;
        Animator r100 = this.f148872f;
        if (r100 == null) goto L8;
        r100.cancel();
    L8:
        View r101 = null;
        this.f148872f = null;
        Animator r102 = this.f148873g;
        if (r102 == null) goto L11;
        r102.cancel();
    L11:
        this.f148873g = null;
        e();
        this.f148875i = a.C2303a.f148877a;
        this.f148867a = r110;
        com.bytedance.android.ec.model.live.b r103 = (com.bytedance.android.ec.model.live.b) CollectionsKt.getOrNull(r110, r110.size() - 1);
        if (r103 != null) goto L14;
    L20:
        View r104 = null;
    L21:
        float r105 = 0.0f;
    L22:
        Iterator r106 = r110.iterator();
        int r112 = 0;
    L24:
        if (r106.hasNext() == false) goto L84;
        Object r113 = r106.next();
        int r114 = r112 + 1;
        if (r112 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        com.bytedance.android.ec.model.live.b r115 = (com.bytedance.android.ec.model.live.b) r113;
        View r116 = j(r115);
        if (r116 == null) goto L83;
        int r117 = r115.o();
        if (r117 != 20) goto L33;
        boolean r118 = r116 instanceof TextView;
        if (r118 == true) goto L60;
        View r119 = r101;
    L61:
        TextView r120 = (TextView) r119;
        if (r120 == null) goto L83;
        float r121 = k(r120) + r105;
        float r122 = r111;
        if (r121 <= r122) goto L81;
        Float r123 = Float.valueOf(r122 - r105);
        if (r123.floatValue() <= 0) goto L68;
        boolean r107 = true;
    L69:
        if (r107 == true) goto L72;
        r123 = null;
    L72:
        if (r123 == null) goto L83;
        float r108 = r123.floatValue();
        if (r118 == true) goto L76;
        View r109 = null;
    L77:
        TextView r124 = (TextView) r109;
        if (r124 == null) goto L80;
        r124.setMaxWidth((int) r108);
        r124.setEllipsize(TextUtils.TruncateAt.END);
        r124.setMaxLines(1);
    L80:
        addView(r116);
        goto L84
    L76:
        r109 = r116;
        goto L77
    L68:
        r107 = false;
        goto L69
    L81:
        addView(r116);
        r105 = r121;
        goto L83
    L60:
        r119 = r116;
        goto L61
    L33:
        if (r117 == 21) goto L52;
        if (r117 == 24) goto L44;
        if (r117 != 29) goto L83;
        c r125 = this.f148869c;
        if (r125 == null) goto L41;
        float r126 = r125.getLoopEndingTextWidth();
    L42:
        r105 = r105 + r126;
        addView(r116);
        goto L83
    L41:
        r126 = 0.0f;
        goto L42
    L44:
        if (r112 >= (r110.size() - 1)) goto L83;
        com.bytedance.android.ec.model.live.h r127 = r115.j();
        if (r127 == null) goto L50;
        ECUrlModel r128 = r127.b();
        if (r128 == null) goto L50;
        float r129 = UtilityKotlinExtentionsKt.c(Integer.valueOf(r128.getWidth()));
    L51:
        r105 = r105 + r129;
        addView(r116);
    L50:
        r129 = 0.0f;
        goto L51
    L52:
        com.bytedance.android.ec.model.live.d r130 = r115.h();
        if (r130 == null) goto L55;
        float r131 = UtilityKotlinExtentionsKt.c(Integer.valueOf(r130.a()));
    L56:
        r105 = r105 + r131;
        addView(r116);
        goto L83
    L55:
        r131 = 0.0f;
    L83:
        r112 = r114;
        r101 = null;
    L84:
        if (r104 == null) goto L86;
        addView(r104);
        goto L86
    L14:
        if (r103.o() != 24) goto L20;
        r104 = j(r103);
        com.bytedance.android.ec.model.live.h r132 = r103.j();
        if (r132 == null) goto L21;
        ECUrlModel r133 = r132.b();
        if (r133 == null) goto L21;
        r105 = UtilityKotlinExtentionsKt.c(Integer.valueOf(r133.getWidth()));
    L86:
        c r134 = this.f148869c;
        if (r134 == null) goto L95;
        r134.a();
        return;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.livesdk.livecommerce.iron.ui.ECCustomizedElementView$countDownTickListener$1] */
    public ECCustomizedElementView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f148874h = LazyKt.lazy(ECCustomizedElementView$disposableContext$2.INSTANCE);
        this.f148875i = a.C2303a.f148877a;
        this.f148876j = new ECCustomizedElementView$countDownTickListener$1(this);
        setOrientation(0);
        setGravity(16);
        setBaselineAligned(false);
    }

    public final ECCustomizedCountDownView g(q r110, String r111, Float r112) {
        long r100 = SystemClock.elapsedRealtime();
        if (r110 == null) goto L24;
        long r101 = r110.f47890a;
        long r102 = r110.f47891b;
        if (r101 <= r100) goto L8;
    L10:
        boolean r103 = false;
    L11:
        if (r103 == true) goto L14;
        r110 = null;
    L14:
        if (r110 == null) goto L24;
        this.f148870d = r110;
        ECCustomizedCountDownView r104 = new ECCustomizedCountDownView(getContext(), null, 6, 0);
        r104.setMaxLines(1);
        Integer r113 = s.b(r111);
        if (r113 == null) goto L18;
        int r114 = r113.intValue();
    L19:
        r104.setTextColor(r114);
        if (r112 == null) goto L22;
        float r115 = r112.floatValue();
    L23:
        r104.setTextSize(1, r115);
        r104.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r104.setEllipsize(TextUtils.TruncateAt.END);
        r104.x(r110.f47891b - r100);
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.f153222a.b(this.f148876j);
        Unit r116 = Unit.INSTANCE;
        this.f148868b = r104;
        return r104;
    L22:
        r115 = 12.0f;
        goto L23
    L18:
        r114 = -16777216;
        goto L19
    L8:
        if (r102 <= r100) goto L10;
        r103 = true;
    L24:
        this.f148870d = null;
        this.f148868b = null;
        Function0<Unit> r117 = this.f148871e;
        if (r117 == null) goto L29;
        Unit r118 = r117.invoke();
        return null;
    L29:
        return null;
    }

    public final View h(ECUrlModel r110, Integer r111, com.bytedance.android.ec.model.live.f r112) {
        int r100 = 0;
        if (r112 != null) goto L31;
        ECDraweeView r113 = new ECDraweeView(getContext(), null, 0, 6, null);
        r113.setAutoPlayAnimation(true);
        if (r110 == null) goto L10;
        String r101 = r110.getFirstUrl();
        if (r101 == null) goto L10;
        String r102 = r101;
    L12:
        if (r110 == null) goto L14;
        int r103 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r110.getWidth()));
    L15:
        Integer r104 = Integer.valueOf(r103);
        if (r110 == null) goto L18;
        int r105 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r110.getHeight()));
    L19:
        h0.e(r113, r102, null, r104, Integer.valueOf(r105), 96);
        if (r110 == null) goto L22;
        int r106 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r110.getWidth()));
    L23:
        if (r110 == null) goto L25;
        r100 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r110.getHeight()));
    L25:
        r113.setLayoutParams(new LinearLayout.LayoutParams(r106, r100));
        if (r111 != null) goto L28;
    L30:
        return r113;
    L28:
        if (r111.intValue() <= 0) goto L30;
        r113.setCornerRadius(UtilityKotlinExtentionsKt.c(r111));
        goto L30
    L22:
        r106 = 0;
        goto L23
    L18:
        r105 = 0;
        goto L19
    L14:
        r103 = 0;
    L10:
        r102 = "";
        goto L12
    L31:
        ConstraintLayout r114 = new ConstraintLayout(getContext());
        ECDraweeView r107 = new ECDraweeView(getContext(), null, 0, 6, null);
        r107.setAutoPlayAnimation(true);
        r107.setId(ViewCompat.generateViewId());
        if (r110 == null) goto L37;
        String r108 = r110.getFirstUrl();
        if (r108 == null) goto L37;
        String r109 = r108;
    L39:
        if (r110 == null) goto L41;
        int r115 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r110.getWidth()));
    L42:
        Integer r116 = Integer.valueOf(r115);
        if (r110 == null) goto L45;
        int r117 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r110.getHeight()));
    L46:
        h0.e(r107, r109, null, r116, Integer.valueOf(r117), 96);
        if (r110 == null) goto L49;
        int r118 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r110.getWidth()));
    L50:
        if (r110 == null) goto L52;
        int r119 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r110.getHeight()));
    L53:
        ConstraintLayout.LayoutParams r120 = new ConstraintLayout.LayoutParams(r118, r119);
        r120.topToTop = 0;
        r120.leftToLeft = 0;
        Unit r121 = Unit.INSTANCE;
        r107.setLayoutParams(r120);
        r114.addView(r107);
        TextView r122 = new TextView(getContext());
        Long r123 = Long.valueOf(r112.e());
        if (r123.longValue() <= 0) goto L56;
        boolean r124 = true;
    L57:
        if (r124 == true) goto L60;
        r123 = null;
    L60:
        if (r123 == null) goto L62;
        float r125 = r123.longValue();
    L63:
        r122.setTextSize(1, r125);
        ConstraintLayout.LayoutParams r126 = new ConstraintLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(Long.valueOf(r112.f())));
        r126.topToTop = 0;
        r126.rightToRight = r107.getId();
        r126.setMargins(0, 0, -UtilityKotlinExtentionsKt.d(2), 0);
        r122.setLayoutParams(r126);
        r122.setGravity(17);
        r122.setText(r112.h());
        int r127 = s.f45717a;
        Integer r128 = s.b(r112.d());
        if (r128 == null) goto L66;
        int r129 = r128.intValue();
    L67:
        r122.setTextColor(r129);
        r122.setPadding(UtilityKotlinExtentionsKt.d(Long.valueOf(r112.g())), 0, UtilityKotlinExtentionsKt.d(Long.valueOf(r112.g())), 0);
        GradientDrawable r130 = new GradientDrawable();
        Integer r131 = s.b(r112.a());
        if (r131 == null) goto L70;
        r130.setColor(r131.intValue());
    L70:
        Integer r132 = s.b(r112.b());
        if (r132 == null) goto L73;
        r130.setStroke(1, r132.intValue());
    L73:
        r130.setCornerRadius(UtilityKotlinExtentionsKt.c(Long.valueOf(r112.c())));
        r122.setBackground(r130);
        r114.addView(r122);
        return r114;
    L66:
        r129 = -16777216;
        goto L67
    L62:
        r125 = 12.0f;
        goto L63
    L56:
        r124 = false;
        goto L57
    L52:
        r119 = 0;
        goto L53
    L49:
        r118 = 0;
        goto L50
    L45:
        r117 = 0;
        goto L46
    L41:
        r115 = 0;
    L37:
        r109 = "";
        goto L39
    }

    public /* synthetic */ ECCustomizedElementView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final View i(String r110, Integer r111, String r112, boolean r113, ECUrlModel r114, Long r115, Integer r116, Integer r117, Integer r118) {
        float r100 = 12.0f;
        AttributeSet r101 = null;
        int r102 = 0;
        if (r115 != null) goto L5;
    L19:
        TextView r103 = new TextView(getContext());
    L20:
        if (r118 != null) goto L22;
    L30:
        int r104 = 1;
    L31:
        r103.setMaxLines(r104);
        if (r111 != null) goto L34;
    L42:
        r103.setTextSize(1, r100);
        r103.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r103.setText(r110);
        int r105 = FontFamilyType.DOUYIN_SANS.getType();
        if (r116 != null) goto L46;
    L48:
        int r106 = FontFamilyType.DOUYIN_NUMBER_ABC.getType();
        if (r116 != null) goto L52;
    L54:
        Typeface r107 = null;
    L55:
        if (r107 == null) goto L57;
        r103.setTypeface(r107);
    L62:
        r103.setEllipsize(TextUtils.TruncateAt.END);
        Integer r108 = s.b(r112);
        if (r108 == null) goto L65;
        int r109 = r108.intValue();
    L66:
        r103.setTextColor(r109);
        if (r114 == null) goto L71;
        View r119 = h(r114, null, null);
        ConstraintLayout r120 = new ConstraintLayout(getContext());
        r120.setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        ConstraintLayout.LayoutParams r121 = new ConstraintLayout.LayoutParams(r119.getLayoutParams());
        r121.topToTop = 0;
        r121.bottomToBottom = 0;
        r121.leftToLeft = 0;
        r121.rightToRight = 0;
        Unit r122 = Unit.INSTANCE;
        r120.addView(r119, r121);
        r103.setIncludeFontPadding(false);
        ConstraintLayout.LayoutParams r123 = new ConstraintLayout.LayoutParams(r103.getLayoutParams());
        r123.topToTop = 0;
        r123.bottomToBottom = 0;
        r123.leftToLeft = 0;
        r123.rightToRight = 0;
        r120.addView(r103, r123);
        return r120;
    L71:
        return r103;
    L65:
        r109 = -16777216;
        goto L66
    L57:
        if (r117 == null) goto L59;
        int r124 = c0.f45558a;
        c0.b(r103, r117.intValue());
    L61:
        Unit r125 = Unit.INSTANCE;
        goto L62
    L59:
        if (r113 == false) goto L61;
        r103.setTypeface(Typeface.DEFAULT_BOLD);
        goto L61
    L52:
        if (r116.intValue() != r106) goto L54;
        r107 = ECFontHelper.f45592e.b("DouyinNumberABC", 400, false);
        goto L55
    L46:
        if (r116.intValue() != r105) goto L48;
        r107 = ECFontHelper.f45592e.b("DouyinSans", 400, false);
        goto L55
    L34:
        if (r111.intValue() <= 0) goto L36;
        boolean r126 = true;
    L37:
        if (r126 == false) goto L39;
        Integer r127 = r111;
    L40:
        if (r127 == null) goto L42;
        r100 = r127.intValue();
        goto L42
    L39:
        r127 = null;
        goto L40
    L36:
        r126 = false;
        goto L37
    L22:
        if (r118.intValue() <= 0) goto L24;
        boolean r128 = true;
    L25:
        if (r128 == false) goto L27;
        Integer r129 = r118;
    L28:
        if (r129 == null) goto L30;
        r104 = r129.intValue();
        goto L31
    L27:
        r129 = null;
        goto L28
    L24:
        r128 = false;
        goto L25
    L5:
        if (r115.longValue() <= 0) goto L19;
        AutoSizeTextView r130 = new AutoSizeTextView(getContext(), r101, 6, r102);
        if (r111 != null) goto L9;
    L17:
        float r131 = 12.0f;
    L18:
        r130.setBaseTextSize(UtilityKotlinExtentionsKt.c(Float.valueOf(r131)));
        r130.setViewMaxWidth(UtilityKotlinExtentionsKt.d(r115));
        r103 = r130;
        goto L20
    L9:
        if (r111.intValue() <= 0) goto L11;
        boolean r132 = true;
    L12:
        if (r132 == false) goto L14;
        Integer r133 = r111;
    L15:
        if (r133 == null) goto L17;
        r131 = r133.intValue();
        goto L18
    L14:
        r133 = null;
        goto L15
    L11:
        r132 = false;
        goto L12
    }
}
