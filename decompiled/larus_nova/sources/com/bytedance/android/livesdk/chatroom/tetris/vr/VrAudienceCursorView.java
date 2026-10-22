package com.bytedance.android.livesdk.chatroom.tetris.vr;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010o\u001a\u00020n\u0012\u0006\u0010q\u001a\u00020p¢\u0006\u0004\br\u0010sJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002R.\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0016\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R:\u0010!\u001a\u001a\u0012\u0004\u0012\u00020\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00040\u00190\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R:\u0010%\u001a\u001a\u0012\u0004\u0012\u00020\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00040\u00190\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00105\u001a\u00020.8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u0010=\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010E\u001a\u00020>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010M\u001a\u00020F8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010Q\u001a\u00020F8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010H\u001a\u0004\bO\u0010J\"\u0004\bP\u0010LR\"\u0010U\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010\u0011\u001a\u0004\bS\u0010\u0013\"\u0004\bT\u0010\u0015R\"\u0010Y\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010\u0011\u001a\u0004\bW\u0010\u0013\"\u0004\bX\u0010\u0015R\"\u0010]\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010\u0011\u001a\u0004\b[\u0010\u0013\"\u0004\b\\\u0010\u0015R\"\u0010a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010\u0011\u001a\u0004\b_\u0010\u0013\"\u0004\b`\u0010\u0015R\"\u0010e\u001a\u00020>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010@\u001a\u0004\bc\u0010B\"\u0004\bd\u0010DR\"\u0010i\u001a\u00020>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010@\u001a\u0004\bg\u0010B\"\u0004\bh\u0010DR\"\u0010m\u001a\u00020>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010@\u001a\u0004\bk\u0010B\"\u0004\bl\u0010D¨\u0006t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/tetris/vr/VrAudienceCursorView;", "Landroid/widget/FrameLayout;", "", "angle", "", "setVrAngle", "getViewSize", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "value", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "setDataCenter", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "dataCenter", "b", FaceService.girlLabel, "getVrCursorAngle", "()F", "setVrCursorAngle", "(F)V", "vrCursorAngle", "", "", "Lkotlin/Function1;", "Lcom/bytedance/android/livesdk/chatroom/tetris/vr/a;", "c", "Ljava/util/Map;", "getDragPosFilters", "()Ljava/util/Map;", "setDragPosFilters", "(Ljava/util/Map;)V", "dragPosFilters", "d", "getLandingPosFilters", "setLandingPosFilters", "landingPosFilters", "Lio/reactivex/disposables/Disposable;", "e", "Lio/reactivex/disposables/Disposable;", "getEventListener", "()Lio/reactivex/disposables/Disposable;", "setEventListener", "(Lio/reactivex/disposables/Disposable;)V", "eventListener", "Landroid/view/LayoutInflater;", "f", "Landroid/view/LayoutInflater;", "getInflater", "()Landroid/view/LayoutInflater;", "setInflater", "(Landroid/view/LayoutInflater;)V", "inflater", "Landroid/widget/ImageView;", ce.f26391f, "Landroid/widget/ImageView;", "getVrCursor", "()Landroid/widget/ImageView;", "setVrCursor", "(Landroid/widget/ImageView;)V", "vrCursor", "", "h", "Z", "getCursorFocused", "()Z", "setCursorFocused", "(Z)V", "cursorFocused", "", RXScreenCaptureService.KEY_INDEX, "I", "getRootWidth", "()I", "setRootWidth", "(I)V", "rootWidth", ce.f26395j, "getRootHeight", "setRootHeight", "rootHeight", ce.f26396k, "getRootLeft", "setRootLeft", "rootLeft", "l", "getRootTop", "setRootTop", "rootTop", "m", "getCursorWidth", "setCursorWidth", "cursorWidth", OfficeSDKRequestTag.KEY_NEW_USER, "getCursorHeight", "setCursorHeight", "cursorHeight", "o", "getCursorPosChanged", "setCursorPosChanged", "cursorPosChanged", "q", "getFirstMeasure", "setFirstMeasure", "firstMeasure", "r", "getCursorMoved", "setCursorMoved", "cursorMoved", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VrAudienceCursorView extends FrameLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f111865s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DataCenter f111866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f111867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, Function1<com.bytedance.android.livesdk.chatroom.tetris.vr.a, Unit>> f111868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, Function1<com.bytedance.android.livesdk.chatroom.tetris.vr.a, Unit>> f111869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f111870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LayoutInflater f111871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f111872g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f111873h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f111874i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f111875j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f111876k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f111877l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f111878m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f111879n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f111880o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public o f111881p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f111882q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f111883r;

    public static final class a {
    }

    static {
    }

    public final LayoutInflater getInflater() {
        LayoutInflater r100 = this.f111871f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inflater");
    L5:
        return r100;
    }

    private final void getViewSize() {
        this.f111874i = getMeasuredWidth();
        this.f111875j = getMeasuredHeight();
        this.f111876k = a1.f(this);
        this.f111877l = a1.h(this);
        ImageView r100 = this.f111872g;
        if (r100 == null) goto L5;
        this.f111878m = r100.getMeasuredWidth();
        this.f111879n = r100.getMeasuredHeight();
    L5:
        Function1<com.bytedance.android.livesdk.chatroom.tetris.vr.a, Unit> r101 = new VrAudienceCursorView$addScreenEdgeForbidRegin$edgeFilter$1(this);
        this.f111868c.put("edge", r101);
        this.f111869d.put("edge", r101);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r100 = this.f111870e;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public final boolean getCursorFocused() {
        return this.f111873h;
    }

    public final float getCursorHeight() {
        return this.f111879n;
    }

    public final boolean getCursorMoved() {
        return this.f111883r;
    }

    public final boolean getCursorPosChanged() {
        return this.f111880o;
    }

    public final float getCursorWidth() {
        return this.f111878m;
    }

    public final DataCenter getDataCenter() {
        return this.f111866a;
    }

    public final Map<String, Function1<com.bytedance.android.livesdk.chatroom.tetris.vr.a, Unit>> getDragPosFilters() {
        return this.f111868c;
    }

    public final Disposable getEventListener() {
        return this.f111870e;
    }

    public final boolean getFirstMeasure() {
        return this.f111882q;
    }

    public final Map<String, Function1<com.bytedance.android.livesdk.chatroom.tetris.vr.a, Unit>> getLandingPosFilters() {
        return this.f111869d;
    }

    public final int getRootHeight() {
        return this.f111875j;
    }

    public final float getRootLeft() {
        return this.f111876k;
    }

    public final float getRootTop() {
        return this.f111877l;
    }

    public final int getRootWidth() {
        return this.f111874i;
    }

    public final ImageView getVrCursor() {
        return this.f111872g;
    }

    public final float getVrCursorAngle() {
        return this.f111867b;
    }

    public static final void a(VrAudienceCursorView r100) {
        r100.getViewSize();
    }

    private final void setVrAngle(final float r100) {
        UtilityKotlinExtentionsKt.s(0, false, false, new AnonymousClass1(this, r100), 7);
    }

    public final void d(com.bytedance.android.livesdk.chatroom.tetris.vr.a r100) {
        Intrinsics.checkNotNullParameter(r100, ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION);
        float r101 = 2;
        float r102 = (r100.f111914a - (this.f111878m / r101)) - this.f111876k;
        float r103 = (r100.f111915b - (this.f111879n / r101)) - this.f111877l;
        ImageView r104 = this.f111872g;
        if (r104 == null) goto L6;
        r104.setTranslationX(r102);
        r104.setTranslationY(r103);
        return;
    }

    public final void setCursorFocused(boolean r100) {
        this.f111873h = r100;
    }

    public final void setCursorHeight(float r100) {
        this.f111879n = r100;
    }

    public final void setCursorMoved(boolean r100) {
        this.f111883r = r100;
    }

    public final void setCursorPosChanged(boolean r100) {
        this.f111880o = r100;
    }

    public final void setCursorWidth(float r100) {
        this.f111878m = r100;
    }

    public final void setDataCenter(DataCenter r100) {
        this.f111866a = r100;
    }

    public final void setDragPosFilters(Map<String, Function1<com.bytedance.android.livesdk.chatroom.tetris.vr.a, Unit>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f111868c = r100;
    }

    public final void setEventListener(Disposable r100) {
        this.f111870e = r100;
    }

    public final void setFirstMeasure(boolean r100) {
        this.f111882q = r100;
    }

    public final void setInflater(LayoutInflater r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f111871f = r100;
    }

    public final void setLandingPosFilters(Map<String, Function1<com.bytedance.android.livesdk.chatroom.tetris.vr.a, Unit>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f111869d = r100;
    }

    public final void setRootHeight(int r100) {
        this.f111875j = r100;
    }

    public final void setRootLeft(float r100) {
        this.f111876k = r100;
    }

    public final void setRootTop(float r100) {
        this.f111877l = r100;
    }

    public final void setRootWidth(int r100) {
        this.f111874i = r100;
    }

    public final void setVrCursor(ImageView r100) {
        this.f111872g = r100;
    }

    public final void setVrCursorAngle(float r100) {
        this.f111867b = r100;
        ImageView r101 = this.f111872g;
        if (r101 == null) goto L6;
        r101.setRotation(r100);
        return;
    }

    public VrAudienceCursorView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f111868c = new LinkedHashMap();
        this.f111869d = new LinkedHashMap();
        LayoutInflater r102 = LayoutInflater.from(r100);
        this.f111871f = r102;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inflater");
    L5:
        View r103 = r102.inflate(R.layout.ttlive_view_vr_audience_cursor, this, true);
        Object r104 = null;
        if ((r103 instanceof ViewGroup) == true) goto L8;
        r103 = null;
    L8:
        ViewGroup r105 = (ViewGroup) r103;
        if (r105 == null) goto L19;
        Object r106 = SequencesKt.last(UtilityKotlinExtentionsKt.g(r105));
        if ((r106 instanceof ImageView) == false) goto L15;
        r104 = r106;
    L15:
        ImageView r107 = (ImageView) r104;
        if (r107 == null) goto L19;
        this.f111872g = r107;
    L19:
        this.f111882q = true;
    }

    public static final /* synthetic */ void c(VrAudienceCursorView r100, float r101) {
        r100.setVrAngle(r101);
    }

    public final void e(float r100, float r101) {
        if (this.f111872g != null) goto L5;
        return;
    L5:
        float r102 = this.f111878m;
        com.bytedance.android.livesdk.chatroom.tetris.vr.a r103 = new com.bytedance.android.livesdk.chatroom.tetris.vr.a(r100, r101, r102);
        float r104 = r103.f111914a;
        float r105 = this.f111876k;
        float r106 = r104 - r105;
        int r107 = this.f111874i;
        if (r106 >= (r107 / 2)) goto L8;
        r103.f111914a = (r102 / 2) + r105;
    L9:
        Iterator<Map.Entry<String, Function1<com.bytedance.android.livesdk.chatroom.tetris.vr.a, Unit>>> r108 = this.f111869d.entrySet().iterator();
    L11:
        if (r108.hasNext() == false) goto L13;
        r108.next().getValue().invoke(r103);
        goto L11
    L13:
        d(r103);
        return;
    L8:
        r103.f111914a = (r107 + r105) - (r102 / 2);
        goto L9
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = getMeasuredWidth();
        int r103 = getMeasuredHeight();
        if (r102 == this.f111874i) goto L5;
    L6:
        ViewTreeObserver r104 = getViewTreeObserver();
        r104.addOnPreDrawListener(new p(this, r104));
        return;
    L5:
        if (r103 != this.f111875j) goto L6;
    }

    public static final boolean b(VrAudienceCursorView r100, float r101, float r102) {
        if (r100.f111872g == null) goto L19;
        r100.getViewSize();
        ImageView r103 = r100.f111872g;
        Intrinsics.checkNotNull(r103);
        if (r101 < (r103.getTranslationX() + r100.f111876k)) goto L15;
        ImageView r104 = r100.f111872g;
        Intrinsics.checkNotNull(r104);
        if (r102 < (r104.getTranslationY() + r100.f111877l)) goto L16;
        ImageView r105 = r100.f111872g;
        Intrinsics.checkNotNull(r105);
        float r106 = r105.getTranslationX() + r100.f111876k;
        ImageView r107 = r100.f111872g;
        Intrinsics.checkNotNull(r107);
        if (r101 > (r106 + r107.getMeasuredWidth())) goto L17;
        ImageView r108 = r100.f111872g;
        Intrinsics.checkNotNull(r108);
        float r109 = r108.getTranslationY() + r100.f111877l;
        ImageView r110 = r100.f111872g;
        Intrinsics.checkNotNull(r110);
        if (r102 > (r109 + r110.getMeasuredHeight())) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L16:
        return false;
    L15:
        return false;
    L19:
        return false;
    }
}
