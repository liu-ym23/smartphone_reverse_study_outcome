package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.gift.model.ComboHintInfo;
import com.bytedance.android.livesdk.gift.model.ComboHintScene;
import com.bytedance.android.livesdk.gift.model.ComboHintType;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import defpackage.l0;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001=B'\b\u0007\u0012\u0006\u00107\u001a\u000206\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000108\u0012\b\b\u0002\u0010:\u001a\u00020.¢\u0006\u0004\b;\u0010<J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002R.\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010)\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0012\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R\"\u0010,\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0012\u001a\u0004\b,\u0010\u0014\"\u0004\b-\u0010\u0016R*\u00105\u001a\u00020.2\u0006\u0010\b\u001a\u00020.8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006>"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/newcombo/ComboProgressAnimationViewNew;", "Landroid/widget/FrameLayout;", "", "Lcom/bytedance/android/livesdk/gift/model/u;", "getComboHintList", "Lcom/bytedance/android/livesdk/gift/model/l;", "getTargetGiftComboHint", "Lcom/bytedance/android/livesdk/gift/model/h2;", "value", ce.f26396k, "Lcom/bytedance/android/livesdk/gift/model/h2;", "getGift", "()Lcom/bytedance/android/livesdk/gift/model/h2;", "setGift", "(Lcom/bytedance/android/livesdk/gift/model/h2;)V", PbRequest.SwitchType.GIFT, "", "l", "Z", "getBanHint", "()Z", "setBanHint", "(Z)V", "banHint", "Lcom/bytedance/android/livesdk/gift/model/l1;", "m", "Lcom/bytedance/android/livesdk/gift/model/l1;", "getBuffInfo", "()Lcom/bytedance/android/livesdk/gift/model/l1;", "setBuffInfo", "(Lcom/bytedance/android/livesdk/gift/model/l1;)V", "buffInfo", "Lcom/bytedance/android/livesdk/gift/model/n;", OfficeSDKRequestTag.KEY_NEW_USER, "Lcom/bytedance/android/livesdk/gift/model/n;", "getDiyInfo", "()Lcom/bytedance/android/livesdk/gift/model/n;", "setDiyInfo", "(Lcom/bytedance/android/livesdk/gift/model/n;)V", "diyInfo", "o", "isGroupSend", "setGroupSend", "p", "isSeriesSend", "setSeriesSend", "", "q", "I", "getComboButtonStyle", "()I", "setComboButtonStyle", "(I)V", "comboButtonStyle", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ComboProgressAnimationViewNew extends FrameLayout {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f126740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnimatorSet f126741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnimatorSet f126742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AnimatorSet f126743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AnimatorSet f126744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f126745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f126746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f126747h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f126748i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList<com.bytedance.android.livesdk.gift.platform.core.model.e> f126749j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public h2 f126750k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f126751l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public l1 f126752m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.bytedance.android.livesdk.gift.model.n f126753n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f126754o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f126755p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f126756q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f126757r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f126758s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Map<Integer, Boolean> f126759t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Disposable f126760u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public com.bytedance.android.livesdk.gift.model.v f126761v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public com.bytedance.android.livesdk.gift.model.u f126762w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final HSImageView f126763x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final View f126764y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final TextView f126765z;

    public static final class a {
    }

    public static final class b implements p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComboProgressAnimationViewNew f126766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f126767b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f126768c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f126769d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.gift.model.v f126770e;

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void a(ImageInfo r100, Animatable r101) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void b(py.k r100, Exception r101) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void d(ImageInfo r100) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void e(py.k r100) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void c(py.k r100, int r101, int r102, boolean r103) {
            HSImageView r104 = this.f126766a.f126763x;
            Long r105 = null;
            if (r104 == null) goto L5;
            ViewGroup.LayoutParams r106 = r104.getLayoutParams();
        L7:
            if ((r106 instanceof ViewGroup.LayoutParams) == false) goto L20;
            float r107 = r101 / r102;
            HSImageView r108 = this.f126766a.f126763x;
            if (r108 == null) goto L11;
            ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        L12:
            if (r109 == null) goto L14;
            r109.height = (int) this.f126766a.getContext().getResources().getDimension(R.dimen.ttlive_gift_combo_hint_view_height_new);
        L14:
            if (r109 == null) goto L16;
            r109.width = (int) (r109.height * r107);
        L16:
            HSImageView r110 = this.f126766a.f126763x;
            if (r110 == null) goto L20;
            r110.setLayoutParams(r109);
            goto L20
        L11:
            r109 = null;
        L20:
            if (b02.a.e() == false) goto L22;
        L28:
            ComboProgressAnimationViewNew.a(this.f126766a, true, true);
            h2 r111 = this.f126766a.getGift();
            if (r111 == null) goto L31;
            r105 = Long.valueOf(r111.getId());
        L31:
            com.bytedance.android.livesdk.gift.platform.core.utils.h.q(r105, this.f126767b, this.f126768c, Integer.valueOf(this.f126769d), this.f126770e.getName());
            return;
        L22:
            if ((new SecureRandom().nextInt(10) % 2) != 0) goto L24;
            float r112 = -5.0f;
        L25:
            HSImageView r113 = this.f126766a.f126763x;
            if (r113 == null) goto L28;
            r113.setRotation(r112);
            goto L28
        L24:
            r112 = 5.0f;
            goto L25
        L5:
            r106 = null;
            goto L7
        }

        public b(ComboProgressAnimationViewNew r100, int r101, String r102, int r103, com.bytedance.android.livesdk.gift.model.v r104) {
            this.f126766a = r100;
            this.f126767b = r101;
            this.f126768c = r102;
            this.f126769d = r103;
            this.f126770e = r104;
        }
    }

    public static final class c implements p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.gift.model.l f126771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.gift.model.m f126772b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ComboProgressAnimationViewNew f126773c;

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void a(ImageInfo r100, Animatable r101) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void b(py.k r100, Exception r101) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void d(ImageInfo r100) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void e(py.k r100) {
        }

        public c(com.bytedance.android.livesdk.gift.model.l r100, com.bytedance.android.livesdk.gift.model.m r101, ComboProgressAnimationViewNew r102) {
            this.f126771a = r100;
            this.f126772b = r101;
            this.f126773c = r102;
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void c(py.k r100, int r101, int r102, boolean r103) {
            HSImageView r104 = this.f126773c.f126763x;
            Integer r105 = null;
            if (r104 == null) goto L5;
            ViewGroup.LayoutParams r106 = r104.getLayoutParams();
        L7:
            if ((r106 instanceof ViewGroup.LayoutParams) == false) goto L20;
            float r107 = r101 / r102;
            HSImageView r108 = this.f126773c.f126763x;
            if (r108 == null) goto L11;
            ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        L12:
            if (r109 == null) goto L14;
            r109.height = (int) this.f126773c.getContext().getResources().getDimension(R.dimen.ttlive_gift_combo_hint_view_height_new);
        L14:
            if (r109 == null) goto L16;
            r109.width = (int) (r109.height * r107);
        L16:
            HSImageView r110 = this.f126773c.f126763x;
            if (r110 == null) goto L20;
            r110.setLayoutParams(r109);
            goto L20
        L11:
            r109 = null;
        L20:
            if (b02.a.e() == false) goto L22;
        L28:
            ComboProgressAnimationViewNew.a(this.f126773c, true, false);
            h2 r111 = this.f126773c.getGift();
            if (r111 == null) goto L31;
            Long r112 = Long.valueOf(r111.getId());
        L32:
            com.bytedance.android.livesdk.gift.model.m r113 = this.f126772b;
            int r114 = r113.leftGiftCount;
            if (this.f126771a.dataList.indexOf(r113) != (this.f126771a.dataList.size() - 1)) goto L35;
            String r115 = "2";
        L36:
            h2 r116 = this.f126773c.getGift();
            if (r116 == null) goto L41;
            com.bytedance.android.livesdk.gift.model.l r117 = l0.a(r116);
            if (r117 == null) goto L41;
            r105 = Integer.valueOf(r117.bizType);
        L41:
            com.bytedance.android.livesdk.gift.platform.core.utils.h.q(r112, r114, r115, r105, "");
            return;
        L35:
            r115 = "1";
            goto L36
        L31:
            r112 = null;
            goto L32
        L22:
            if ((new SecureRandom().nextInt(10) % 2) != 0) goto L24;
            float r118 = -5.0f;
        L25:
            HSImageView r119 = this.f126773c.f126763x;
            if (r119 == null) goto L28;
            r119.setRotation(r118);
            goto L28
        L24:
            r118 = 5.0f;
            goto L25
        L5:
            r106 = null;
            goto L7
        }
    }

    public static final class d implements p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComboProgressAnimationViewNew f126774a;

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void a(ImageInfo r100, Animatable r101) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void b(py.k r100, Exception r101) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void d(ImageInfo r100) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void e(py.k r100) {
        }

        public d(ComboProgressAnimationViewNew r100) {
            this.f126774a = r100;
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void c(py.k r100, int r101, int r102, boolean r103) {
            if (GiftManagerKt.s().size() > 0) goto L5;
        L7:
            HSImageView r104 = this.f126774a.f126763x;
            ViewGroup.LayoutParams r105 = null;
            if (r104 == null) goto L10;
            ViewGroup.LayoutParams r106 = r104.getLayoutParams();
        L12:
            if ((r106 instanceof ViewGroup.LayoutParams) == false) goto L24;
            float r107 = r101 / r102;
            HSImageView r108 = this.f126774a.f126763x;
            if (r108 == null) goto L16;
            r105 = r108.getLayoutParams();
        L16:
            if (r105 == null) goto L18;
            r105.height = (int) this.f126774a.getContext().getResources().getDimension(R.dimen.ttlive_gift_combo_hint_view_height_new);
        L18:
            if (r105 == null) goto L20;
            r105.width = (int) (r105.height * r107);
        L20:
            HSImageView r109 = this.f126774a.f126763x;
            if (r109 == null) goto L24;
            r109.setLayoutParams(r105);
        L24:
            if (b02.a.e() == false) goto L26;
        L32:
            ComboProgressAnimationViewNew.a(this.f126774a, false, false);
            return;
        L26:
            if ((new SecureRandom().nextInt(10) % 2) != 0) goto L28;
            float r110 = -5.0f;
        L29:
            HSImageView r111 = this.f126774a.f126763x;
            if (r111 == null) goto L32;
            r111.setRotation(r110);
            goto L32
        L28:
            r110 = 5.0f;
            goto L29
        L10:
            r106 = null;
            goto L12
        L5:
            if (this.f126774a.f126740a >= ((com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(GiftManagerKt.s(), 0)).comboCount) goto L7;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComboProgressAnimationViewNew f126775a;

        public e(ComboProgressAnimationViewNew r100) {
            this.f126775a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            Disposable r102 = this.f126775a.f126760u;
            if (r102 == null) goto L5;
            r102.dispose();
        L5:
            ComboProgressAnimationViewNew r103 = this.f126775a;
            r103.f126760u = null;
            r103.f126761v = null;
            r103.f126762w = null;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f126776a = null;

        static {
            f126776a = new f();
        }

        public f() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    static {
    }

    public ComboProgressAnimationViewNew(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ComboProgressAnimationViewNew(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void g() {
        this.f126740a = 0;
        this.f126746g = false;
        HSImageView r100 = this.f126763x;
        if (r100 == null) goto L5;
        r100.setScaleX(0.0f);
    L5:
        HSImageView r101 = this.f126763x;
        if (r101 == null) goto L8;
        r101.setScaleY(0.0f);
    L8:
        b();
        ((LinkedHashMap) this.f126759t).clear();
        h2 r102 = this.f126750k;
        if (r102 == null) goto L11;
        Long r103 = Long.valueOf(r102.getId());
    L12:
        j(r103);
        View r104 = this.f126764y;
        if (r104 == null) goto L15;
        r104.setVisibility(8);
    L15:
        AnimatorSet r105 = this.f126742c;
        if (r105 == null) goto L18;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r105);
    L18:
        AnimatorSet r106 = this.f126744e;
        if (r106 == null) goto L21;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r106);
    L21:
        AnimatorSet r107 = this.f126743d;
        if (r107 == null) goto L24;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r107);
    L24:
        AnimatorSet r108 = this.f126741b;
        if (r108 == null) goto L28;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r108);
        return;
    L28:
        return;
    L11:
        r103 = null;
        goto L12
    }

    private final com.bytedance.android.livesdk.gift.model.l getTargetGiftComboHint() {
        l1 r100 = this.f126752m;
        if (r100 == null) goto L8;
        h2 r101 = GiftManagerKt.l(r100.getBuffGiftId());
        if (r101 != null) goto L7;
        return null;
    L7:
        return l0.a(r101);
    L8:
        h2 r102 = this.f126750k;
        if (r102 != null) goto L11;
        return null;
    L11:
        return l0.a(r102);
    }

    public final void b() {
        AnimatorSet r100 = this.f126741b;
        if (r100 != null) goto L5;
    L12:
        this.f126741b = null;
        return;
    L5:
        if (r100.isRunning() != true) goto L12;
        AnimatorSet r101 = this.f126741b;
        if (r101 == null) goto L9;
        r101.removeAllListeners();
    L9:
        AnimatorSet r102 = this.f126741b;
        if (r102 == null) goto L12;
        r102.cancel();
        goto L12
    }

    public final void f() {
        if (this.f126740a > this.f126747h) goto L5;
    L12:
        Object r100 = getContext().getSystemService("vibrator");
        if (r100 == null) goto L17;
        ((Vibrator) r100).vibrate(50);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
    L5:
        if (this.f126748i == true) goto L12;
        HSImageView r101 = this.f126763x;
        if (r101 == null) goto L9;
        r101.setScaleX(0.0f);
    L9:
        HSImageView r102 = this.f126763x;
        if (r102 == null) goto L12;
        r102.setScaleY(0.0f);
        goto L12
    }

    public final void h() {
        Disposable r100 = this.f126760u;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f126760u = Observable.timer(3000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this), f.f126776a);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        h2 r100 = this.f126750k;
        if (r100 == null) goto L5;
        Long r101 = Long.valueOf(r100.getId());
    L6:
        j(r101);
        super.onDetachedFromWindow();
        Disposable r102 = this.f126760u;
        if (r102 == null) goto L10;
        r102.dispose();
        return;
    L10:
        return;
    L5:
        r101 = null;
        goto L6
    }

    private final List<com.bytedance.android.livesdk.gift.model.u> getComboHintList() {
        i12.e r100 = i12.o.b();
        if (r100 == null) goto L5;
        Object r101 = com.bytedance.android.scope.m.f163449e.d(r100, GiftExtraRepo.class);
    L6:
        GiftExtraRepo r102 = (GiftExtraRepo) r101;
        if (r102 != null) goto L9;
        return null;
    L9:
        l1 r103 = this.f126752m;
        if (r103 == null) goto L18;
        g0 r104 = r102.q(r103.getBuffGiftId());
        if (r104 == null) goto L18;
        ComboHintInfo r105 = r104.getComboHintInfo();
        if (r105 == null) goto L18;
        List<com.bytedance.android.livesdk.gift.model.u> r106 = r105.getComboHintList();
        if (r106 == null) goto L18;
        return r106;
    L18:
        com.bytedance.android.livesdk.gift.model.n r107 = this.f126753n;
        if (r107 == null) goto L24;
        ComboHintInfo r108 = r107.getComboHintInfo();
        if (r108 != null) goto L23;
        return null;
    L23:
        return r108.getComboHintList();
    L24:
        h2 r109 = this.f126750k;
        if (r109 == null) goto L33;
        g0 r110 = r102.q(r109.getId());
        if (r110 == null) goto L34;
        ComboHintInfo r111 = r110.getComboHintInfo();
        if (r111 != null) goto L31;
        return null;
    L31:
        return r111.getComboHintList();
    L34:
        return null;
    L33:
        return null;
    L5:
        r101 = null;
        goto L6
    }

    public final boolean getBanHint() {
        return this.f126751l;
    }

    public final l1 getBuffInfo() {
        return this.f126752m;
    }

    public final int getComboButtonStyle() {
        return this.f126756q;
    }

    public final com.bytedance.android.livesdk.gift.model.n getDiyInfo() {
        return this.f126753n;
    }

    public final h2 getGift() {
        return this.f126750k;
    }

    public final void j(Long r100) {
        if (r100 == null) goto L5;
        long r101 = r100.longValue();
        String r102 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId() + String.valueOf(r101);
        HashMap<String, Boolean> r103 = ay1.b.i();
        r103.put(r102, Boolean.valueOf(this.f126757r));
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        ay1.b.f16692i0.setValue(null, ay1.b.f16675a[72], r103);
        return;
    }

    public final void setBanHint(boolean r100) {
        this.f126751l = r100;
    }

    public final void setBuffInfo(l1 r100) {
        this.f126752m = r100;
    }

    public final void setComboButtonStyle(int r100) {
        this.f126756q = r100;
        View r101 = this.f126764y;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 != 1) goto L7;
        Drawable r102 = s1.m(R.drawable.ttlive_gift_rare_shop_combo_count_bg);
    L8:
        r101.setBackground(r102);
        return;
    L7:
        r102 = s1.m(R.drawable.ttlive_gift_combo_count_bg);
        goto L8
    }

    public final void setDiyInfo(com.bytedance.android.livesdk.gift.model.n r100) {
        this.f126753n = r100;
    }

    public final void setGift(h2 r100) {
        Long r101 = null;
        if (r100 == null) goto L5;
        com.bytedance.android.livesdk.gift.model.l r102 = l0.a(r100);
    L6:
        this.f126749j.clear();
        boolean r103 = false;
        if (r102 == null) goto L11;
        List<com.bytedance.android.livesdk.gift.model.m> r104 = r102.dataList;
        if (r104 == null) goto L11;
        int r105 = r104.size();
    L12:
        if (r105 <= 0) goto L84;
        int r106 = 0;
        int r107 = 0;
    L15:
        if (r106 >= GiftManagerKt.s().size()) goto L51;
        if (r102 == null) goto L20;
        List<com.bytedance.android.livesdk.gift.model.m> r108 = r102.dataList;
        if (r108 == null) goto L20;
        int r109 = r108.size();
    L21:
        if (r107 >= r109) goto L51;
        com.bytedance.android.livesdk.gift.platform.core.model.e r110 = (com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(GiftManagerKt.s(), r106);
        if (r102 == null) goto L25;
        int r111 = r102.curLeftGiftCount;
    L26:
        if (r102 == null) goto L32;
        List<com.bytedance.android.livesdk.gift.model.m> r112 = r102.dataList;
        if (r112 == null) goto L32;
        com.bytedance.android.livesdk.gift.model.m r113 = (com.bytedance.android.livesdk.gift.model.m) ListProtector.get(r112, r107);
        if (r113 == null) goto L32;
        int r114 = r113.leftGiftCount;
    L33:
        int r115 = (r111 - r114) + 1;
        int r116 = r110.comboCount;
        if (r116 < r115) goto L35;
        com.bytedance.android.livesdk.gift.platform.core.model.e r117 = new com.bytedance.android.livesdk.gift.platform.core.model.e();
        r117.comboCount = r115;
        if (r102 == null) goto L45;
        List<com.bytedance.android.livesdk.gift.model.m> r118 = r102.dataList;
        if (r118 == null) goto L45;
        com.bytedance.android.livesdk.gift.model.m r119 = (com.bytedance.android.livesdk.gift.model.m) ListProtector.get(r118, r107);
        if (r119 == null) goto L45;
        py.k r120 = r119.hintImg;
    L46:
        r117.comboEffectImg = r120;
        if (r117.comboCount <= 0) goto L49;
        this.f126749j.add(r117);
    L49:
        r107 = r107 + 1;
    L45:
        r120 = null;
        goto L46
    L35:
        if (r116 <= 0) goto L37;
        this.f126749j.add(r110);
    L37:
        r106 = r106 + 1;
    L32:
        r114 = 0;
        goto L33
    L25:
        r111 = 0;
    L20:
        r109 = 0;
    L51:
        if (r106 >= GiftManagerKt.s().size()) goto L56;
        com.bytedance.android.livesdk.gift.platform.core.model.e r121 = (com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(GiftManagerKt.s(), r106);
        if (r121.comboCount <= 0) goto L55;
        this.f126749j.add(r121);
    L55:
        r106 = r106 + 1;
    L56:
        if (r102 == null) goto L60;
        List<com.bytedance.android.livesdk.gift.model.m> r122 = r102.dataList;
        if (r122 == null) goto L60;
        int r123 = r122.size();
    L61:
        if (r107 >= r123) goto L85;
        if (r102 == null) goto L64;
        int r124 = r102.curLeftGiftCount;
    L65:
        if (r102 == null) goto L71;
        List<com.bytedance.android.livesdk.gift.model.m> r125 = r102.dataList;
        if (r125 == null) goto L71;
        com.bytedance.android.livesdk.gift.model.m r126 = (com.bytedance.android.livesdk.gift.model.m) ListProtector.get(r125, r107);
        if (r126 == null) goto L71;
        int r127 = r126.leftGiftCount;
    L72:
        int r128 = (r124 - r127) + 1;
        com.bytedance.android.livesdk.gift.platform.core.model.e r129 = new com.bytedance.android.livesdk.gift.platform.core.model.e();
        r129.comboCount = r128;
        if (r102 == null) goto L79;
        List<com.bytedance.android.livesdk.gift.model.m> r130 = r102.dataList;
        if (r130 == null) goto L79;
        com.bytedance.android.livesdk.gift.model.m r131 = (com.bytedance.android.livesdk.gift.model.m) ListProtector.get(r130, r107);
        if (r131 == null) goto L79;
        py.k r132 = r131.hintImg;
    L80:
        r129.comboEffectImg = r132;
        if (r129.comboCount <= 0) goto L83;
        this.f126749j.add(r129);
    L83:
        r107 = r107 + 1;
    L79:
        r132 = null;
    L71:
        r127 = 0;
        goto L72
    L64:
        r124 = 0;
    L85:
        if (r100 == null) goto L87;
        r101 = Long.valueOf(r100.getId());
    L87:
        if (r101 == null) goto L92;
        long r133 = r101.longValue();
        Boolean r134 = ay1.b.i().get(((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId() + String.valueOf(r133));
        if (r134 == null) goto L91;
        r103 = r134.booleanValue();
    L91:
        this.f126757r = r103;
    L92:
        this.f126750k = r100;
        return;
    L60:
        r123 = 0;
        goto L61
    L84:
        this.f126749j.addAll(GiftManagerKt.s());
    L11:
        r105 = 0;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public final void setGroupSend(boolean r100) {
        this.f126754o = r100;
    }

    public final void setSeriesSend(boolean r100) {
        this.f126755p = r100;
    }

    public static int c(int r100, List r101) {
        if (r101 == null) goto L10;
        Iterator r102 = r101.iterator();
        int r103 = 99999;
    L6:
        if (r102.hasNext() == false) goto L11;
        com.bytedance.android.livesdk.gift.model.v r104 = (com.bytedance.android.livesdk.gift.model.v) r102.next();
        if (r104.getCount() <= r100) goto L6;
        r103 = Math.min(r103, ((int) r104.getCount()) - r100);
    L11:
        if (r103 != 99999) goto L19;
        return 0;
    L19:
        return r103;
    L10:
        r103 = 99999;
        goto L11
    }

    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v3 */
    public final void e(int r210, int r211) {
        int r100 = this.f126740a;
        if (r100 != r210) goto L6;
        return;
    L6:
        if (r100 <= r210) goto L13;
        this.f126746g = false;
        HSImageView r101 = this.f126763x;
        if (r101 == null) goto L10;
        r101.setScaleX(0.0f);
    L10:
        HSImageView r102 = this.f126763x;
        if (r102 == null) goto L13;
        r102.setScaleY(0.0f);
    L13:
        this.f126740a = r210;
        if (r210 != 0) goto L16;
        return;
    L16:
        Disposable r103 = this.f126760u;
        if (r103 != null) goto L19;
    L41:
        List<com.bytedance.android.livesdk.gift.model.u> r104 = getComboHintList();
        h2 r105 = this.f126750k;
        if (r105 == null) goto L44;
        long r106 = r105.getPrimaryEffectId();
    L45:
        ?? r110 = 1;
        if (this.f126755p == true) goto L203;
        if (this.f126751l == true) goto L203;
        if (r104 == null) goto L203;
        Iterator r107 = r104.iterator();
    L52:
        if (r107.hasNext() == false) goto L203;
        com.bytedance.android.livesdk.gift.model.u r111 = (com.bytedance.android.livesdk.gift.model.u) r107.next();
        String r112 = "";
        if (r111.getComboHintScene() != ComboHintScene.SEND_TOGETHER.getScene()) goto L133;
        ArrayList r113 = new ArrayList();
        GiftContext r114 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r114 == null) goto L62;
        com.bytedance.live.datacontext.m<Boolean> r115 = r114.isIntercept();
        if (r115 == null) goto L62;
        Boolean r116 = r115.getValue();
        if (r116 == null) goto L62;
        boolean r117 = r116.booleanValue();
    L63:
        GiftContext r118 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r118 == null) goto L72;
        com.bytedance.live.datacontext.n<i02.a> r119 = r118.getCurrentSendTogetherInfo();
        if (r119 == null) goto L72;
        i02.a r120 = r119.getValue();
        if (r120 == null) goto L72;
        Integer r121 = r120.f487856c;
        if (r121 == null) goto L72;
        int r122 = r121.intValue();
    L73:
        GiftContext r123 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r123 == null) goto L80;
        com.bytedance.live.datacontext.n<i02.a> r124 = r123.getCurrentSendTogetherInfo();
        if (r124 == null) goto L80;
        i02.a r108 = r124.getValue();
        if (r108 == null) goto L80;
        List<i02.e> r109 = r108.f487855b;
    L81:
        if (r109 == null) goto L86;
        Iterator<T> r125 = r109.iterator();
    L84:
        if (r125.hasNext() == false) goto L86;
        r113.addAll(((i02.e) r125.next()).f487869a);
    L86:
        boolean r126 = r113.contains(Integer.valueOf((int) r106));
        if (r117 == true) goto L99;
        if (r126 == false) goto L99;
        GiftContext r127 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r127 == null) goto L97;
        com.bytedance.live.datacontext.m<Integer> r128 = r127.getMsgCount();
        if (r128 == null) goto L97;
        Integer r129 = r128.getValue();
        if (r129 == null) goto L97;
        int r130 = r129.intValue();
    L98:
        int r131 = r122 + r130;
    L100:
        List<com.bytedance.android.livesdk.gift.model.v> r132 = r111.getComboHintData();
        if (r132 == null) goto L133;
        int r133 = r132.size();
        int r134 = 0;
    L103:
        if (r134 >= r133) goto L133;
        com.bytedance.android.livesdk.gift.model.v r135 = (com.bytedance.android.livesdk.gift.model.v) ListProtector.get(r132, r134);
        if (r135.getComboHintType() == ComboHintType.COMMON.getType()) goto L107;
        int r136 = r133;
        if (r135.getComboHintType() != ComboHintType.FIRST_TIME.getType()) goto L131;
        if (this.f126757r == true) goto L131;
        this.f126757r = r110;
        h2 r137 = this.f126750k;
        if (r137 == null) goto L125;
        Long r138 = Long.valueOf(r137.getId());
    L126:
        j(r138);
        if (this.f126754o == true) goto L131;
        this.f126761v = r135;
        this.f126762w = r111;
        d(r135, 0, 3, "");
        h();
        return;
    L125:
        r138 = null;
    L131:
        r134 = r134 + 1;
        r133 = r136;
        goto L103
    L107:
        if (((r131 + r210) - r211) != (r135.getCount() - 1)) goto L116;
        r136 = r133;
        Boolean r139 = (Boolean) ((LinkedHashMap) this.f126759t).get(Integer.valueOf((int) r135.getCount()));
        if (r139 == null) goto L111;
        boolean r140 = r139.booleanValue();
    L112:
        if (r140 == true) goto L131;
        this.f126757r = r110;
        this.f126759t.put(Integer.valueOf((int) r135.getCount()), Boolean.TRUE);
        d(r135, 0, 3, "");
        this.f126761v = r135;
        this.f126762w = r111;
        h();
        return;
    L111:
        r140 = false;
        goto L112
    L116:
        r136 = r133;
    L97:
        r130 = 0;
    L99:
        r131 = 0;
    L80:
        r109 = null;
    L72:
        r122 = 0;
    L62:
        r117 = false;
    L133:
        if (r111.getComboHintScene() != ComboHintScene.SEND_GOLD.getScene()) goto L200;
        List<com.bytedance.android.livesdk.gift.model.v> r141 = r111.getComboHintData();
        if (r141 == null) goto L200;
        int r142 = r141.size() - r110;
        if (r142 < 0) goto L200;
        int r143 = 0;
    L139:
        com.bytedance.android.livesdk.gift.model.v r144 = (com.bytedance.android.livesdk.gift.model.v) ListProtector.get(r141, r143);
        if (r144.getComboHintType() != ComboHintType.COMMON.getType()) goto L150;
        if (r210 == ((int) r144.getCount())) goto L143;
    L197:
        Iterator r145 = r107;
    L198:
        if (r143 == r142) goto L201;
        r143 = r143 + 1;
        r107 = r145;
    L201:
        r107 = r145;
        r110 = 1;
        goto L52
    L143:
        int r146 = c(r210, r111.getComboHintData());
        String r147 = r144.getName();
        if (r147 == null) goto L147;
        r112 = r147;
    L147:
        d(r144, r146, 4, r112);
        this.f126761v = r144;
        this.f126762w = r111;
        h();
        return;
    L150:
        if (r144.getComboHintType() != ComboHintType.FIRST_TIME.getType()) goto L197;
        h2 r148 = this.f126750k;
        if (r148 == null) goto L154;
        Long r149 = Long.valueOf(r148.getId());
    L156:
        if (r149 == null) goto L172;
        r149.longValue();
        int r150 = Calendar.getInstance().get(6);
        HashMap<Long, Pair<Integer, Integer>> r151 = ay1.b.r();
        if (r151 != null) goto L160;
    L159:
        r145 = r107;
    L171:
        boolean r152 = true;
    L174:
        if (r152 == false) goto L198;
        if (this.f126758s == true) goto L198;
        this.f126758s = true;
        String r153 = r144.getName();
        if (r153 == null) goto L182;
        r112 = r153;
    L182:
        d(r144, 0, 4, r112);
        this.f126761v = r144;
        this.f126762w = r111;
        h();
        h2 r154 = this.f126750k;
        if (r154 == null) goto L185;
        Long r155 = Long.valueOf(r154.getId());
    L186:
        if (r155 == null) goto L297;
        r155.longValue();
        int r156 = Calendar.getInstance().get(6);
        HashMap<Long, Pair<Integer, Integer>> r157 = ay1.b.r();
        Pair<Integer, Integer> r158 = r157.get(r155);
        if (r158 != null) goto L191;
        r158 = new Pair(Integer.valueOf(r156), 0);
    L191:
        if (r158.getFirst().intValue() == r156) goto L193;
        Pair<Integer, Integer> r159 = new Pair(Integer.valueOf(r156), 1);
    L194:
        r157.put(r155, r159);
        Intrinsics.checkNotNullParameter(r157, "<set-?>");
        ay1.b.f16704o0.setValue(null, ay1.b.f16675a[79], r157);
        return;
    L193:
        r159 = new Pair(Integer.valueOf(r156), Integer.valueOf(r158.getSecond().intValue() + 1));
        goto L194
    L297:
        return;
    L185:
        r155 = null;
        goto L186
    L160:
        Pair<Integer, Integer> r160 = r151.get(r149);
        if (r160 == null) goto L159;
        r145 = r107;
        Integer r161 = (Integer) ((HashMap) nz1.a.M.getValue(null, nz1.a.f521324a[37])).get(r149);
        if (r161 != null) goto L166;
        r161 = 3;
    L166:
        int r162 = r161.intValue();
        if (r160.getFirst().intValue() != r150) goto L171;
        if (r160.getSecond().intValue() <= r162) goto L171;
    L173:
        r152 = false;
        goto L174
    L172:
        r145 = r107;
        goto L173
    L154:
        r149 = null;
    L200:
        r145 = r107;
    L203:
        if (this.f126745f == true) goto L216;
        if (this.f126751l == true) goto L216;
        com.bytedance.android.livesdk.gift.model.l r163 = getTargetGiftComboHint();
        if (r163 == null) goto L216;
        Iterator<com.bytedance.android.livesdk.gift.model.m> r164 = r163.dataList.iterator();
    L210:
        if (r164.hasNext() == false) goto L216;
        com.bytedance.android.livesdk.gift.model.m r165 = r164.next();
        if (r165.leftGiftCount != ((r163.curLeftGiftCount - r210) + 1)) goto L210;
        ImageLoader.bindImage(this.f126763x, r165.hintImg, new c(r163, r165, this));
        return;
    L216:
        if (this.f126756q == 0) goto L218;
    L231:
        TextView r166 = this.f126765z;
        if (r166 == null) goto L234;
        r166.setText(String.valueOf(r210));
    L234:
        View r167 = this.f126764y;
        if (r167 != null) goto L237;
    L238:
        AnimatorSet r168 = this.f126742c;
        if (r168 == null) goto L243;
        boolean r169 = true;
        if (r168.isRunning() != true) goto L244;
    L275:
        i(0, false);
        return;
    L244:
        AnimatorSet r170 = this.f126741b;
        if (r170 != null) goto L247;
    L249:
        AnimatorSet r171 = this.f126744e;
        if (r171 == null) goto L252;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r171);
    L252:
        AnimatorSet r172 = this.f126743d;
        if (r172 == null) goto L255;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r172);
    L255:
        TextView r173 = this.f126765z;
        if (r173 == null) goto L258;
        r173.setVisibility(0);
    L258:
        View r174 = this.f126764y;
        if (r174 == null) goto L261;
        r174.setAlpha(1.0f);
    L261:
        TextView r175 = this.f126765z;
        if (r175 == null) goto L275;
        AnimatorSet r176 = com.bytedance.android.live.revenue.common.e.c(r175, new float[]{r175.getScaleX(), 1.2f});
        r176.setDuration(50);
        AnimatorSet r177 = com.bytedance.android.live.revenue.common.e.c(r175, new float[]{1.2f, 1.0f});
        r177.setDuration(200);
        r177.setStartDelay(50);
        r177.setInterpolator(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
        ObjectAnimator r178 = ObjectAnimator.ofFloat(this.f126764y, "alpha", new float[]{1.0f, 0.0f});
        r178.setDuration(250);
        r178.setStartDelay(1000);
        this.f126744e = new AnimatorSet();
        AnimatorSet r179 = new AnimatorSet();
        com.bytedance.android.live.revenue.common.e.a(r179, new ComboProgressAnimationViewNew$startComboCountContinueAnimation$$inlined$let$lambda$1(this));
        Unit r180 = Unit.INSTANCE;
        this.f126743d = r179;
        AnimatorSet r181 = this.f126744e;
        if (r181 == null) goto L266;
        r181.playTogether(new Animator[]{r176, r177});
    L266:
        AnimatorSet r182 = this.f126743d;
        if (r182 == null) goto L269;
        r182.play(r178);
    L269:
        AnimatorSet r183 = this.f126744e;
        if (r183 == null) goto L272;
        r183.start();
    L272:
        AnimatorSet r184 = this.f126743d;
        if (r184 == null) goto L275;
        r184.start();
        goto L275
    L247:
        if (r170.isRunning() != r169) goto L249;
    L243:
        r169 = true;
        goto L244
    L237:
        if (r167.getVisibility() == 8) goto L275;
    L218:
        if (this.f126751l == true) goto L231;
        int r185 = GiftManagerKt.s().size();
        int r186 = 0;
    L220:
        if (r186 >= r185) goto L231;
        if (this.f126745f == true) goto L231;
        com.bytedance.android.livesdk.gift.platform.core.model.e r187 = (com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(GiftManagerKt.s(), r186);
        if (r210 == r187.comboCount) goto L226;
        r186 = r186 + 1;
        goto L220
    L226:
        if (r186 != (GiftManagerKt.s().size() - 1)) goto L228;
        boolean r188 = true;
    L229:
        this.f126746g = r188;
        ImageLoader.bindImage(this.f126763x, r187.comboEffectImg, new d(this));
        goto L231
    L228:
        r188 = false;
        goto L229
    L44:
        r106 = -1;
        goto L45
    L19:
        if (r103.isDisposed() == true) goto L41;
        com.bytedance.android.livesdk.gift.model.v r189 = this.f126761v;
        if (r189 == null) goto L41;
        h2 r190 = this.f126750k;
        if (r190 == null) goto L25;
        Long r191 = Long.valueOf(r190.getId());
    L26:
        com.bytedance.android.livesdk.gift.model.u r192 = this.f126762w;
        if (r192 == null) goto L29;
        List<com.bytedance.android.livesdk.gift.model.v> r193 = r192.getComboHintData();
    L30:
        int r194 = c(r210, r193);
        com.bytedance.android.livesdk.gift.model.u r195 = this.f126762w;
        if (r195 != null) goto L33;
    L35:
        if (r195 != null) goto L37;
    L39:
        int r196 = 0;
    L40:
        com.bytedance.android.livesdk.gift.platform.core.utils.h.n(r191, r194, Integer.valueOf(r196), r189.getName(), r189.getName());
        goto L41
    L37:
        if (r195.getComboHintScene() != ComboHintScene.SEND_GOLD.getScene()) goto L39;
        r196 = 4;
        goto L40
    L33:
        if (r195.getComboHintScene() != ComboHintScene.SEND_TOGETHER.getScene()) goto L35;
        r196 = 3;
        goto L40
    L29:
        r193 = null;
        goto L30
    L25:
        r191 = null;
        goto L26
    }

    public final void i(final long r110, boolean r111) {
        View r100 = this.f126764y;
        if (r100 == null) goto L7;
        if (r100.getVisibility() != 0) goto L7;
        return;
    L7:
        if (r111 == true) goto L13;
        AnimatorSet r112 = this.f126741b;
        if (r112 == null) goto L13;
        if (r112.isRunning() != true) goto L13;
        return;
    L13:
        AnimatorSet r113 = this.f126743d;
        if (r113 == null) goto L16;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r113);
    L16:
        View r114 = this.f126764y;
        if (r114 == null) goto L32;
        AnimatorSet r101 = com.bytedance.android.live.revenue.common.e.c(r114, new float[]{0.0f, 1.05f});
        r101.setDuration(250);
        r101.setStartDelay(r110);
        r101.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        AnimatorSet r102 = com.bytedance.android.live.revenue.common.e.c(r114, new float[]{1.05f, 1.0f});
        r102.setDuration(200);
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r114, "alpha", new float[]{0.0f, 1.0f});
        r103.setDuration(250);
        r103.setStartDelay(r110);
        ObjectAnimator r115 = ObjectAnimator.ofFloat(r114, "alpha", new float[]{1.0f, 0.0f});
        r115.setDuration(250);
        r115.setStartDelay(1000 + r110);
        AnimatorSet r104 = new AnimatorSet();
        r104.playSequentially(new Animator[]{r101, r102});
        AnimatorSet r105 = new AnimatorSet();
        Function1<Animator, Unit> r106 = new ComboProgressAnimationViewNew$startComboContainerShowAnimator$$inlined$let$lambda$1(this, r110);
        Intrinsics.checkNotNullParameter(r105, "$this$doOnStart");
        Intrinsics.checkNotNullParameter(r106, "callback");
        r105.addListener(new com.bytedance.android.live.revenue.common.d(r106));
        Unit r107 = Unit.INSTANCE;
        this.f126742c = r105;
        AnimatorSet r108 = new AnimatorSet();
        com.bytedance.android.live.revenue.common.e.a(r108, new ComboProgressAnimationViewNew$startComboContainerShowAnimator$$inlined$let$lambda$2(this, r110));
        this.f126743d = r108;
        AnimatorSet r116 = this.f126742c;
        if (r116 == null) goto L21;
        r116.playTogether(new Animator[]{r104, r103});
    L21:
        AnimatorSet r117 = this.f126743d;
        if (r117 == null) goto L24;
        r117.play(r115);
    L24:
        AnimatorSet r118 = this.f126742c;
        if (r118 == null) goto L27;
        r118.start();
    L27:
        AnimatorSet r119 = this.f126743d;
        if (r119 == null) goto L33;
        r119.start();
        return;
    L33:
        return;
    }

    public ComboProgressAnimationViewNew(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ArrayList<com.bytedance.android.livesdk.gift.platform.core.model.e> r103 = new ArrayList();
        this.f126749j = r103;
        this.f126759t = new LinkedHashMap();
        LayoutInflater.from(r100).inflate(R.layout.ttlive_base_gift_combo_progress_new, this);
        this.f126763x = (HSImageView) findViewById(R.id.special_combo_iv);
        this.f126764y = findViewById(R.id.combo_count_container);
        TextView r104 = (TextView) findViewById(R.id.combo_count);
        this.f126765z = r104;
        int r105 = GiftManagerKt.s().size();
        if (r105 <= 0) goto L6;
        this.f126747h = ((com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(GiftManagerKt.s(), r105 - 1)).comboCount;
    L6:
        if (r103.isEmpty() == false) goto L15;
        r103.addAll(GiftManagerKt.s());
    L15:
        Typeface r106 = Typeface.createFromAsset(r100.getAssets(), "font/ttlive_gift_combo_opt.ttf");     // Catch: Exception -> L12
        if (r104 == null) goto L17;
        r104.setTypeface(r106);     // Catch: Exception -> L12
        return;
    L17:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        jy0.b.c("ComboProgressAnimationViewNew", "load font asset exception: " + e.getMessage(), null, 4);
    }

    public static final void a(final ComboProgressAnimationViewNew r110, final boolean r111, final boolean r112) {
        r110.f126748i = r111;
        r110.b();
        AnimatorSet r100 = r110.f126744e;
        if (r100 == null) goto L5;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r100);
    L5:
        AnimatorSet r101 = r110.f126742c;
        if (r101 == null) goto L8;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r101);
    L8:
        AnimatorSet r102 = r110.f126743d;
        if (r102 == null) goto L11;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r102);
    L11:
        HSImageView r103 = r110.f126763x;
        View r104 = r110.f126764y;
        if (r103 == null) goto L28;
        if (r104 == null) goto L29;
        TextView r105 = r110.f126765z;
        if (r105 == null) goto L17;
        r105.setScaleX(1.0f);
    L17:
        TextView r106 = r110.f126765z;
        if (r106 == null) goto L20;
        r106.setScaleY(1.0f);
    L20:
        HSImageView r107 = r110.f126763x;
        if (r107 == null) goto L23;
        r107.setScaleX(0.0f);
    L23:
        HSImageView r108 = r110.f126763x;
        if (r108 == null) goto L26;
        r108.setScaleY(1.0f);
    L26:
        AnimatorSet r109 = com.bytedance.android.live.revenue.common.e.c(r104, new float[]{1.0f, 0.0f});
        r109.setDuration(150);
        r109.setInterpolator(new PathInterpolator(0.26f, 0.0f, 0.6f, 0.2f));
        com.bytedance.android.live.revenue.common.e.a(r109, new ComboProgressAnimationViewNew$startSpecialComboAnimation$$inlined$lets$lambda$1(r110, r112, r111));
        AnimatorSet r113 = com.bytedance.android.live.revenue.common.e.c(r103, new float[]{0.0f, 1.05f});
        r113.setStartDelay(100);
        r113.setDuration(250);
        r113.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        AnimatorSet r114 = com.bytedance.android.live.revenue.common.e.c(r103, new float[]{1.05f, 1.0f});
        r114.setDuration(200);
        r114.setStartDelay(350);
        ObjectAnimator r115 = ObjectAnimator.ofFloat(r103, "alpha", new float[]{0.0f, 1.0f});
        r115.setStartDelay(100);
        r115.setDuration(250);
        AnimatorSet r116 = com.bytedance.android.live.revenue.common.e.c(r103, new float[]{1.0f, 0.0f});
        r116.setDuration(150);
        r116.setStartDelay(1100);
        r116.setInterpolator(new PathInterpolator(0.26f, 0.0f, 0.6f, 0.2f));
        AnimatorSet r117 = new AnimatorSet();
        r117.playTogether(new Animator[]{r109, r113, r114, r115, r116});
        r117.addListener(new j(r110, r112, r111));
        Unit r118 = Unit.INSTANCE;
        r110.f126741b = r117;
        r117.start();
        return;
    L29:
        return;
    }

    public /* synthetic */ ComboProgressAnimationViewNew(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void d(com.bytedance.android.livesdk.gift.model.v r110, int r111, int r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, "each");
        Intrinsics.checkNotNullParameter(r113, "showTime");
        ImageLoader.bindImage(this.f126763x, r110.getHintImg(), new b(this, r111, r113, r112, r110));
    }
}
