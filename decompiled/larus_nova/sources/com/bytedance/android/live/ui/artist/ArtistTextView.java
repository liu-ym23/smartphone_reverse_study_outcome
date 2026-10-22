package com.bytedance.android.live.ui.artist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.Spanned;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.col.s.ce;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010j\u001a\u00020i\u0012\n\b\u0002\u0010l\u001a\u0004\u0018\u00010k\u0012\b\b\u0002\u0010m\u001a\u00020 ¢\u0006\u0004\bn\u0010oJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R*\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R*\u0010.\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R*\u00102\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010)\u001a\u0004\b0\u0010+\"\u0004\b1\u0010-R*\u00106\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020 8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010\"\u001a\u0004\b4\u0010$\"\u0004\b5\u0010&R*\u0010:\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010\u001a\u001a\u0004\b8\u0010\u001c\"\u0004\b9\u0010\u001eR*\u0010B\u001a\u00020;2\u0006\u0010\u0018\u001a\u00020;8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR*\u0010F\u001a\u00020;2\u0006\u0010\u0018\u001a\u00020;8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010=\u001a\u0004\bD\u0010?\"\u0004\bE\u0010AR*\u0010J\u001a\u00020;2\u0006\u0010\u0018\u001a\u00020;8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010=\u001a\u0004\bH\u0010?\"\u0004\bI\u0010AR\"\u0010N\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010\"\u001a\u0004\bL\u0010$\"\u0004\bM\u0010&R\"\u0010R\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010\"\u001a\u0004\bP\u0010$\"\u0004\bQ\u0010&RE\u0010^\u001a%\u0012\u0013\u0012\u00110T¢\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020;\u0018\u00010Sj\u0004\u0018\u0001`W8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]RE\u0010c\u001a%\u0012\u0013\u0012\u00110T¢\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020;\u0018\u00010Sj\u0004\u0018\u0001`_8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010Y\u001a\u0004\ba\u0010[\"\u0004\bb\u0010]RE\u0010h\u001a%\u0012\u0013\u0012\u00110T¢\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020;\u0018\u00010Sj\u0004\u0018\u0001`d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010Y\u001a\u0004\bf\u0010[\"\u0004\bg\u0010]¨\u0006p"}, d2 = {"Lcom/bytedance/android/live/ui/artist/ArtistTextView;", "Landroid/view/View;", "", "getMaxLineWidth", "Lcom/bytedance/android/live/ui/artist/f;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/live/ui/artist/f;", "getTextPaint", "()Lcom/bytedance/android/live/ui/artist/f;", "textPaint", "Landroid/text/TextPaint;", "b", "Landroid/text/TextPaint;", "getTextPaintForSpan", "()Landroid/text/TextPaint;", "textPaintForSpan", "Lcom/bytedance/android/live/ui/artist/TextArtist;", "<set-?>", "c", "Lcom/bytedance/android/live/ui/artist/TextArtist;", "getTextArtist", "()Lcom/bytedance/android/live/ui/artist/TextArtist;", "textArtist", "", "value", "d", "Ljava/lang/CharSequence;", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "text", "", "e", "I", "getTextColor", "()I", "setTextColor", "(I)V", "textColor", "f", FaceService.girlLabel, "getTextSize", "()F", "setTextSize", "(F)V", "textSize", ce.f26391f, "getExtraLineSpacing", "setExtraLineSpacing", "extraLineSpacing", "h", "getMaxLines", "setMaxLines", "maxLines", RXScreenCaptureService.KEY_INDEX, "getEllipsis", "setEllipsis", "ellipsis", "", ce.f26395j, "Z", "getAlwaysUseAreaWidthForDisplay", "()Z", "setAlwaysUseAreaWidthForDisplay", "(Z)V", "alwaysUseAreaWidthForDisplay", ce.f26396k, "getNeedAddFakeSpace", "setNeedAddFakeSpace", "needAddFakeSpace", "l", "getIncludeFontPadding", "setIncludeFontPadding", "includeFontPadding", "m", "getMaxWidth", "setMaxWidth", "maxWidth", OfficeSDKRequestTag.KEY_NEW_USER, "getMeasureWidth", "setMeasureWidth", "measureWidth", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "Lkotlin/ParameterName;", "name", "Lcom/bytedance/android/live/ui/artist/OnTextContentClick;", "p", "Lkotlin/jvm/functions/Function1;", "getOnTextContentClick", "()Lkotlin/jvm/functions/Function1;", "setOnTextContentClick", "(Lkotlin/jvm/functions/Function1;)V", "onTextContentClick", "Lcom/bytedance/android/live/ui/artist/OnTextContentDoubleClick;", "q", "getOnTextContentDoubleClick", "setOnTextContentDoubleClick", "onTextContentDoubleClick", "Lcom/bytedance/android/live/ui/artist/OnTextContentLongClick;", "r", "getOnTextContentLongClick", "setOnTextContentLongClick", "onTextContentLongClick", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ArtistTextView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f101995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextPaint f101996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextArtist f101997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f101998d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f101999e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f102000f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f102001g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f102002h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CharSequence f102003i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f102004j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f102005k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f102006l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f102007m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f102008n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final RectF f102009o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function1<? super MotionEvent, Boolean> f102010p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Function1<? super MotionEvent, Boolean> f102011q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Function1<? super MotionEvent, Boolean> f102012r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.bytedance.android.live.ui.artist.a f102013s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f102014t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final GestureDetector f102015u;

    public static final class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArtistTextView f102016a;

        public a(ArtistTextView r100) {
            this.f102016a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            if (ArtistTextView.a(this.f102016a, r100) == null) goto L5;
            Intrinsics.checkNotNullParameter(this.f102016a, "widget");
        L5:
            Function1<MotionEvent, Boolean> r101 = this.f102016a.getOnTextContentDoubleClick();
            if (r101 == null) goto L10;
            Boolean r102 = r101.invoke(r100);
            if (r102 == null) goto L10;
            boolean r103 = r102.booleanValue();
        L11:
            if (r103 == false) goto L14;
            return true;
        L14:
            return false;
        L10:
            r103 = false;
            goto L11
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            ArtistTextView r101 = this.f102016a;
            r101.f102014t = false;
            com.bytedance.android.live.ui.artist.a r102 = ArtistTextView.a(r101, r100);
            if (r102 == null) goto L7;
            ArtistTextView r103 = this.f102016a;
            r103.f102013s = r102;
            r103.invalidate();
            return true;
        L7:
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            if (ArtistTextView.a(this.f102016a, r100) == null) goto L5;
            Intrinsics.checkNotNullParameter(this.f102016a, "widget");
        L5:
            Function1<MotionEvent, Boolean> r101 = this.f102016a.getOnTextContentLongClick();
            if (r101 == null) goto L9;
            Boolean r102 = r101.invoke(r100);
            return;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            ArtistTextView r101 = this.f102016a;
            if (r101.f102014t == false) goto L6;
            r101.f102014t = false;
            return false;
        L6:
            com.bytedance.android.live.ui.artist.a r102 = ArtistTextView.a(r101, r100);
            if (r102 == null) goto L9;
            boolean r103 = r102.a();
        L10:
            if (r103 == true) goto L18;
            Function1<MotionEvent, Boolean> r104 = this.f102016a.getOnTextContentClick();
            if (r104 == null) goto L16;
            Boolean r105 = r104.invoke(r100);
            if (r105 == null) goto L16;
            boolean r106 = r105.booleanValue();
        L17:
            if (r106 == true) goto L18;
            return false;
        L16:
            r106 = false;
        L18:
            return true;
        L9:
            r103 = false;
            goto L10
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            if (this.f102016a.getOnTextContentDoubleClick() != null) goto L11;
            ArtistTextView r101 = this.f102016a;
            com.bytedance.android.live.ui.artist.a r102 = r101.f102013s;
            if (r102 != null) goto L10;
            Function1<MotionEvent, Boolean> r103 = r101.getOnTextContentClick();
            if (r103 == null) goto L9;
            Boolean r104 = r103.invoke(r100);
        L9:
            this.f102016a.f102014t = true;
            goto L11
        L10:
            r102.a();
            this.f102016a.f102014t = true;
        L11:
            ArtistTextView r105 = this.f102016a;
            com.bytedance.android.live.ui.artist.a r106 = r105.f102013s;
            r105.invalidate();
            this.f102016a.f102013s = null;
            return super.onSingleTapUp(r100);
        }
    }

    public ArtistTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ArtistTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final float getMaxLineWidth() {
        return this.f101997c.e();
    }

    public final boolean getAlwaysUseAreaWidthForDisplay() {
        return this.f102004j;
    }

    public final CharSequence getEllipsis() {
        return this.f102003i;
    }

    public final float getExtraLineSpacing() {
        return this.f102001g;
    }

    public final boolean getIncludeFontPadding() {
        return this.f102006l;
    }

    public final int getMaxLines() {
        return this.f102002h;
    }

    public final int getMaxWidth() {
        return this.f102007m;
    }

    public final int getMeasureWidth() {
        return this.f102008n;
    }

    public final boolean getNeedAddFakeSpace() {
        return this.f102005k;
    }

    public final Function1<MotionEvent, Boolean> getOnTextContentClick() {
        return this.f102010p;
    }

    public final Function1<MotionEvent, Boolean> getOnTextContentDoubleClick() {
        return this.f102011q;
    }

    public final Function1<MotionEvent, Boolean> getOnTextContentLongClick() {
        return this.f102012r;
    }

    public final CharSequence getText() {
        return this.f101998d;
    }

    public final TextArtist getTextArtist() {
        return this.f101997c;
    }

    public final int getTextColor() {
        return this.f101999e;
    }

    public final f getTextPaint() {
        return this.f101995a;
    }

    public final TextPaint getTextPaintForSpan() {
        return this.f101996b;
    }

    public final float getTextSize() {
        return this.f102000f;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        r100.save();
        r100.translate(getPaddingLeft(), getPaddingTop());
        getHeight();
        getPaddingTop();
        getPaddingBottom();
        this.f101997c.b(r100, this.f102008n);
        r100.restore();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        CharSequence r101 = this.f101998d;
        if ((r101 instanceof Spanned) == true) goto L5;
        CharSequence r102 = null;
    L6:
        Spanned r103 = (Spanned) r102;
        if (r103 == null) goto L11;
        com.bytedance.android.live.ui.artist.a[] r104 = (com.bytedance.android.live.ui.artist.a[]) r103.getSpans(0, r101.length(), com.bytedance.android.live.ui.artist.a.class);
        if (r104 == null) goto L11;
        int r105 = r104.length;
    L12:
        if (r105 == 0) goto L14;
    L20:
        if (r100 == null) goto L22;
        Integer r106 = Integer.valueOf(r100.getActionMasked());
    L23:
        if (r106 != null) goto L26;
    L28:
        getContext();
        if (r100 != null) goto L31;
        return false;
    L31:
        return this.f102015u.onTouchEvent(r100);
    L26:
        if (r106.intValue() != 3) goto L28;
        invalidate();
        this.f102013s = null;
        goto L28
    L22:
        r106 = null;
        goto L23
    L14:
        if (this.f102010p != null) goto L20;
        if (this.f102012r != null) goto L20;
        if (this.f102011q != null) goto L20;
        return false;
    L11:
        r105 = 0;
        goto L12
    L5:
        r102 = r101;
        goto L6
    }

    public final void setAlwaysUseAreaWidthForDisplay(boolean r100) {
        this.f102004j = r100;
        this.f101997c.f102029l = r100;
        requestLayout();
    }

    public final void setEllipsis(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f102003i = r100;
        this.f101997c.l(r100);
        requestLayout();
    }

    public final void setExtraLineSpacing(float r100) {
        this.f102001g = r100;
        this.f101997c.f102026i = r100;
        requestLayout();
    }

    public final void setIncludeFontPadding(boolean r100) {
        this.f102006l = r100;
        this.f101997c.f102031n = r100;
        requestLayout();
    }

    public final void setMaxLines(int r100) {
        this.f102002h = r100;
        TextArtist r101 = this.f101997c;
        r101.getClass();
        r101.C = Math.max(0, r100);
        requestLayout();
    }

    public final void setMaxWidth(int r100) {
        this.f102007m = r100;
    }

    public final void setMeasureWidth(int r100) {
        this.f102008n = r100;
    }

    public final void setNeedAddFakeSpace(boolean r100) {
        this.f102005k = r100;
        this.f101997c.f102030m = r100;
        requestLayout();
    }

    public final void setOnTextContentClick(Function1<? super MotionEvent, Boolean> r100) {
        this.f102010p = r100;
    }

    public final void setOnTextContentDoubleClick(Function1<? super MotionEvent, Boolean> r100) {
        this.f102011q = r100;
    }

    public final void setOnTextContentLongClick(Function1<? super MotionEvent, Boolean> r100) {
        this.f102012r = r100;
    }

    public final void setText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f101998d = r100;
        this.f101995a.setTextSize(this.f102000f);
        this.f101995a.setColor(this.f101999e);
        TextArtist r101 = new TextArtist(r100, this.f101995a, this.f101996b, true);
        r101.f102027j = this.f101999e;
        r101.f102028k = this.f102000f;
        r101.f102026i = this.f102001g;
        r101.C = Math.max(0, this.f102002h);
        r101.l(this.f102003i);
        r101.f102029l = this.f102004j;
        r101.f102031n = this.f102006l;
        r101.f102030m = this.f102005k;
        Unit r102 = Unit.INSTANCE;
        this.f101997c = r101;
        requestLayout();
    }

    public final void setTextColor(int r100) {
        this.f101999e = r100;
    }

    public final void setTextSize(float r100) {
        this.f102000f = r100;
        this.f101995a.setTextSize(r100);
        TextArtist r101 = this.f101997c;
        r101.f102028k = this.f102000f;
        requestLayout();
    }

    public static final com.bytedance.android.live.ui.artist.a a(ArtistTextView r110, MotionEvent r111) {
        CharSequence r100 = r110.f101998d;
        if ((r100 instanceof Spanned) == true) goto L5;
        r100 = null;
    L5:
        Spanned r101 = (Spanned) r100;
        if (r101 == null) goto L59;
        float r102 = r111.getX();
        float r103 = r111.getY();
        TextArtist r104 = r110.f101997c;
        float r105 = r102 - r110.getPaddingLeft();
        float r106 = r103 - r110.getPaddingTop();
        int r107 = r104.c();
        int r108 = 0;
        int r109 = 0;
        float r112 = 0.0f;
    L9:
        int r113 = -1;
        if (r109 >= r107) goto L21;
        float r114 = r104.f102037t[((IntRange) ListProtector.get(r104.f102038u, r109)).getFirst()];
        Paint.FontMetrics r115 = r104.G;
        float r116 = r115.descent;
        float r117 = 2;
        float r118 = (r104.f102026i / r117) + ((r104.f102017J / r117) - (((r116 - r115.ascent) / r117) - r116));
        if (r112 <= 0.0f) goto L14;
        float r119 = r112 + r118;
    L15:
        float r120 = r118 + r114;
        if (r106 < r119) goto L20;
        if (r106 > r120) goto L20;
        LocalTestManager.a(new Class[]{wy.a.class});
    L22:
        int r121 = r104.c();
        if (r109 < 0) goto L35;
        if (r121 <= r109) goto L35;
        IntRange r122 = (IntRange) ListProtector.get(r104.f102038u, r109);
        int r123 = r122.getFirst();
        int r124 = r122.getLast();
        if (r123 > r124) goto L35;
    L28:
        float r125 = r104.f102036s[r123];
        float r126 = r104.f102035r[r123] + r125;
        if (r105 >= r125) goto L31;
    L33:
        if (r123 == r124) goto L35;
        r123 = r123 + 1;
        goto L28
    L31:
        if (r105 > r126) goto L33;
    L36:
        if (r123 >= 0) goto L38;
    L53:
        Object[] r127 = r101.getSpans(r113, r113, com.bytedance.android.live.ui.artist.a.class);
        if (r127 == null) goto L56;
        Arrays.sort(r127, new b(r101));
    L56:
        com.bytedance.android.live.ui.artist.a[] r128 = (com.bytedance.android.live.ui.artist.a[]) r127;
        if (r128 == null) goto L59;
        return (com.bytedance.android.live.ui.artist.a) ArraysKt.lastOrNull(r128);
    L38:
        if (r123 >= r104.f102021d) goto L53;
        int r129 = 0;
    L40:
        if (r108 >= r123) goto L52;
        Object r130 = ListProtector.get(r104.f102020c, r108);
        if ((r130 instanceof Character) == false) goto L45;
    L50:
        int r131 = 1;
    L51:
        r129 = r129 + r131;
        r108 = r108 + 1;
        goto L40
    L45:
        if ((r130 instanceof String) == false) goto L48;
        r131 = ((String) r130).length();
        goto L51
    L48:
        if ((r130 instanceof d) == false) goto L50;
        r131 = ((d) r130).f102047a.length();
        goto L51
    L52:
        r113 = r129;
    L35:
        r123 = -1;
    L20:
        r109 = r109 + 1;
        r112 = r114;
        goto L9
    L14:
        r119 = 0.0f;
        goto L15
    L21:
        r109 = -1;
    L59:
        return null;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getMode(r101);
        int r104 = View.MeasureSpec.getSize(r100);
        int r105 = View.MeasureSpec.getSize(r101);
        if (r102 != 1073741824) goto L7;
        if (r103 != 1073741824) goto L7;
        this.f102008n = (r104 - getPaddingLeft()) - getPaddingRight();
        setMeasuredDimension(r104, r105);
        return;
    L7:
        int r106 = this.f102007m;
        if (r106 > 0) goto L10;
        int r107 = r104 - getPaddingLeft();
        int r108 = getPaddingRight();
    L11:
        int r109 = r107 - r108;
        this.f102008n = r109;
        this.f101997c.a(this.f102009o, r109);
        if (r102 == 1073741824) goto L15;
        r104 = (((int) (this.f102009o.width() + 0.5f)) + getPaddingLeft()) + getPaddingRight();
    L15:
        if (r103 == 1073741824) goto L18;
        r105 = (((int) (this.f102009o.height() + 0.5f)) + getPaddingTop()) + getPaddingBottom();
    L18:
        setMeasuredDimension(r104, r105);
        return;
    L10:
        r107 = r106 - getPaddingLeft();
        r108 = getPaddingRight();
        goto L11
    }

    public ArtistTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        f r103 = new f();
        this.f101995a = r103;
        TextPaint r104 = new TextPaint(1);
        this.f101996b = r104;
        this.f101997c = new TextArtist("", r103, r104, true);
        this.f101998d = "";
        this.f101999e = -1;
        this.f102000f = s1.e(16.0f);
        this.f102001g = s1.e(2.0f);
        this.f102002h = Integer.MAX_VALUE;
        this.f102003i = "";
        this.f102004j = true;
        Paint r105 = new Paint();
        r105.setStyle(Paint.Style.STROKE);
        r105.setStrokeWidth(s1.e(0.5f));
        r105.setColor(ColorProtector.parseColor("#C6C7C9"));
        Unit r106 = Unit.INSTANCE;
        this.f102009o = new RectF();
        this.f102015u = new GestureDetector(r100, new a(this));
    }

    public /* synthetic */ ArtistTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
