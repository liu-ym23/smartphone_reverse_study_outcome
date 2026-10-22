package com.bytedance.android.livesdk.gamesticker.t01;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gamesticker.t01.anim.TaskState;
import com.bytedance.android.livesdk.gamesticker.t01.anim.e;
import com.bytedance.android.livesdk.gamesticker.t01.anim.f;
import com.bytedance.android.livesdk.gamesticker.t01.anim.g;
import com.bytedance.android.livesdk.gamesticker.t01.anim.i;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010'\u001a\u00020\u0003¢\u0006\u0004\b(\u0010)J)\u0010\t\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0012\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001b\u0010\u0017\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001a\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\u0016R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\"\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b!\u0010\u001e¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdk/gamesticker/t01/T01GameStickerView;", "Landroid/widget/FrameLayout;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", RemoteMessageConst.Notification.VISIBILITY, "", "onChange", "setVisibilityChangeListener", "Lcom/bytedance/android/livesdk/gamesticker/t01/T01GameRoleView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getFirstRoleView", "()Lcom/bytedance/android/livesdk/gamesticker/t01/T01GameRoleView;", "firstRoleView", "b", "getSecondRoleView", "secondRoleView", "Lcom/bytedance/android/livesdk/gamesticker/t01/T01GameLiveView;", "c", "getFirstLiveView", "()Lcom/bytedance/android/livesdk/gamesticker/t01/T01GameLiveView;", "firstLiveView", "d", "getSecondLiveView", "secondLiveView", "Landroid/view/View;", "e", "getStickerBgView", "()Landroid/view/View;", "stickerBgView", "f", "getContainerView", "containerView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class T01GameStickerView extends FrameLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f125722k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f125723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f125724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f125725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f125726d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f125727e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f125728f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f125729g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function1<? super Integer, Unit> f125730h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f125731i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final g f125732j;

    public static final class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ T01GameStickerView f125733a;

        public a(T01GameStickerView r100) {
            this.f125733a = r100;
        }

        @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.f
        public final void a(com.bytedance.android.livesdk.gamesticker.t01.anim.b r100) {
            Intrinsics.checkNotNullParameter(r100, "task");
            T01GameStickerView r101 = this.f125733a;
            r100.e();
            int r102 = T01GameStickerView.f125722k;
            r101.getClass();
            this.f125733a.g();
        }

        @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.f
        public final void b(com.bytedance.android.livesdk.gamesticker.t01.anim.b r100) {
            Intrinsics.checkNotNullParameter(r100, "task");
            T01GameStickerView r101 = this.f125733a;
            r100.e();
            int r102 = T01GameStickerView.f125722k;
            r101.getClass();
        }
    }

    public static final class b implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ T01GameStickerView f125734a;

        @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.i
        public final View V2() {
            return T01GameStickerView.a(this.f125734a);
        }

        @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.i
        public final T01GameRoleView a() {
            return T01GameStickerView.e(this.f125734a);
        }

        @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.i
        public final T01GameLiveView b() {
            return T01GameStickerView.d(this.f125734a);
        }

        @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.i
        public final T01GameLiveView c() {
            return T01GameStickerView.b(this.f125734a);
        }

        @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.i
        public final T01GameRoleView d() {
            return T01GameStickerView.c(this.f125734a);
        }

        @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.i
        public final float getHeight() {
            if (this.f125734a.getHeight() == 0) goto L8;
            int r100 = this.f125734a.getHeight();
        L6:
            return r100;
        L8:
            if (this.f125734a.getMeasuredHeight() == 0) goto L10;
            r100 = this.f125734a.getMeasuredHeight();
            goto L6
        L10:
            r100 = s1.f(28.0f);
            goto L6
        }

        public b(T01GameStickerView r100) {
            this.f125734a = r100;
        }
    }

    public T01GameStickerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public T01GameStickerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final View getContainerView() {
        return (View) this.f125728f.getValue();
    }

    private final T01GameLiveView getFirstLiveView() {
        return (T01GameLiveView) this.f125725c.getValue();
    }

    private final T01GameRoleView getFirstRoleView() {
        return (T01GameRoleView) this.f125723a.getValue();
    }

    private final T01GameLiveView getSecondLiveView() {
        return (T01GameLiveView) this.f125726d.getValue();
    }

    private final T01GameRoleView getSecondRoleView() {
        return (T01GameRoleView) this.f125724b.getValue();
    }

    private final View getStickerBgView() {
        return (View) this.f125727e.getValue();
    }

    public final void f() {
        if (this.f125732j.f125766a.isEmpty() == true) goto L5;
        com.bytedance.android.livesdk.gamesticker.t01.anim.b r100 = this.f125732j.f125766a.peek();
        if (r100 != null) goto L9;
        return;
    L9:
        Iterator<com.bytedance.android.livesdk.gamesticker.t01.anim.b> r101 = null;
        if (Intrinsics.areEqual(r100.e(), "ShowContainerTask") == false) goto L12;
    L13:
        TaskState r102 = r100.f125757a;
        if (r102 != TaskState.CREATE) goto L17;
        r100.e();
        r100.a();
    L19:
        g r103 = this.f125732j;
        T01GameStickerView$clearAboutContainerTask$1 r104 = T01GameStickerView$clearAboutContainerTask$1.INSTANCE;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "filter");
        LinkedList<com.bytedance.android.livesdk.gamesticker.t01.anim.b> r105 = r103.f125766a;
        Intrinsics.checkNotNullParameter(r104, "filter");
        if (r105 == null) goto L22;
        r101 = r105.iterator();
    L22:
        if (r101 == null) goto L34;
        if (r101.hasNext() != true) goto L35;
        if (r104.invoke(r101.next()).booleanValue() == false) goto L22;
        r101.remove();
        return;
    L35:
        return;
    L34:
        return;
    L17:
        if (r102 != TaskState.END) goto L19;
        g r106 = this.f125732j;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r100, "task");
        r100.f125758b = null;
        r100.f125759c = null;
        r106.f125766a.remove(r100);
        goto L19
    L12:
        if (Intrinsics.areEqual(r100.e(), "HideContainerTask") == false) goto L19;
    }

    public final void g() {
        if (this.f125732j.f125766a.isEmpty() == true) goto L5;
        com.bytedance.android.livesdk.gamesticker.t01.anim.b r100 = this.f125732j.f125766a.peek();
        if (r100 != null) goto L9;
        return;
    L9:
        r100.e();
        Objects.toString(r100.f125757a);
        TaskState r101 = r100.f125757a;
        if (r101 != TaskState.CREATE) goto L13;
        r100.d();
        return;
    L13:
        if (r101 != TaskState.END) goto L17;
        g r102 = this.f125732j;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "task");
        r100.f125758b = null;
        r100.f125759c = null;
        r102.f125766a.remove(r100);
        g();
        return;
    L17:
        return;
    }

    public final void j() {
        g r100 = this.f125732j;
        Iterator<com.bytedance.android.livesdk.gamesticker.t01.anim.b> r101 = r100.f125766a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        com.bytedance.android.livesdk.gamesticker.t01.anim.b r102 = r101.next();
        r102.f125758b = null;
        r102.f125759c = null;
        r102.a();
        goto L4
    L6:
        r100.f125766a.clear();
        getFirstRoleView().setRoleInfo(null);
        getSecondRoleView().setRoleInfo(null);
        getFirstLiveView().setLiveInfo(null);
        getSecondLiveView().setLiveInfo(null);
        this.f125730h = null;
    }

    public static final /* synthetic */ View a(T01GameStickerView r100) {
        return r100.getContainerView();
    }

    public static final /* synthetic */ T01GameLiveView b(T01GameStickerView r100) {
        return r100.getFirstLiveView();
    }

    public static final /* synthetic */ T01GameRoleView c(T01GameStickerView r100) {
        return r100.getFirstRoleView();
    }

    public static final /* synthetic */ T01GameLiveView d(T01GameStickerView r100) {
        return r100.getSecondLiveView();
    }

    public static final /* synthetic */ T01GameRoleView e(T01GameStickerView r100) {
        return r100.getSecondRoleView();
    }

    public final void h(boolean r100) {
        if (this.f125731i.V2().getVisibility() != 8) goto L6;
        f();
        return;
    L6:
        if (r100 == false) goto L8;
        this.f125732j.a(new com.bytedance.android.livesdk.gamesticker.t01.anim.a(new T01GameStickerView$hideContainerView$1(this)));
    L11:
        g();
        return;
    L8:
        f();
        this.f125731i.V2().setVisibility(8);
        Function1<? super Integer, Unit> r101 = this.f125730h;
        if (r101 == null) goto L11;
        Unit r102 = r101.invoke(8);
        goto L11
    }

    public final void i(int r100) {
        if (this.f125729g == r100) goto L5;
    L7:
        View r101 = getStickerBgView();
        if (r100 != 0) goto L10;
        Drawable r102 = s1.m(R.drawable.ttlive_bg_hok_sticker_vertical);
    L11:
        r101.setBackground(r102);
        this.f125729g = r100;
        return;
    L10:
        r102 = s1.m(R.drawable.ttlive_bg_hok_sticker_landscape);
        goto L11
    L5:
        if (getStickerBgView().getBackground() == null) goto L7;
    }

    public final void k(boolean r100) {
        if (this.f125731i.V2().getVisibility() != 0) goto L6;
        f();
        return;
    L6:
        if (r100 == false) goto L8;
        this.f125732j.a(new e(new T01GameStickerView$showContainerView$1(this)));
    L11:
        g();
        return;
    L8:
        f();
        this.f125731i.V2().setTranslationY(0.0f);
        this.f125731i.V2().setVisibility(0);
        Function1<? super Integer, Unit> r101 = this.f125730h;
        if (r101 == null) goto L11;
        Unit r102 = r101.invoke(0);
        goto L11
    }

    public final void setVisibilityChangeListener(Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onChange");
        this.f125730h = r100;
    }

    public T01GameStickerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f125723a = LazyKt.lazy(new T01GameStickerView$firstRoleView$2(this));
        this.f125724b = LazyKt.lazy(new T01GameStickerView$secondRoleView$2(this));
        this.f125725c = LazyKt.lazy(new T01GameStickerView$firstLiveView$2(this));
        this.f125726d = LazyKt.lazy(new T01GameStickerView$secondLiveView$2(this));
        this.f125727e = LazyKt.lazy(new T01GameStickerView$stickerBgView$2(this));
        this.f125728f = LazyKt.lazy(new T01GameStickerView$containerView$2(this));
        b r103 = new b(this);
        this.f125731i = r103;
        this.f125732j = new g(new a(this), r103);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_game_t01_sticker_view, this);
        getFirstRoleView().setRoleInfo(null);
        getSecondRoleView().setRoleInfo(null);
        getFirstLiveView().setLiveInfo(null);
        getSecondLiveView().setLiveInfo(null);
    }

    public /* synthetic */ T01GameStickerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
