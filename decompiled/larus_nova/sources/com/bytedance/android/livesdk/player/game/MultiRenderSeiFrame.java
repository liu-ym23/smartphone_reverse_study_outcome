package com.bytedance.android.livesdk.player.game;

import com.bytedance.android.livesdk.player.LivePlayerService;
import com.bytedance.android.livesdk.r0;
import com.bytedance.android.livesdkapi.model.PlayerExtraRenderConfig;
import com.bytedance.android.livesdkapi.model.PlayerMultiDisplay;
import com.bytedance.android.livesdkapi.model.RenderAreaInfo;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class MultiRenderSeiFrame {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f155378h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f155379i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f155380j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<Integer> f155381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f155382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f155383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f155384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f155385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f155386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f155387g;

    public static final class a {
        public a() {
        }

        public static String b(String r100) {
            Object r101 = null;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L34
            int r103 = StringsKt.indexOf$default(r100, "multi_view_data", 0, false, 6, null);     // Catch: Throwable -> L34
            if (r103 != (-1)) goto L6;
            return null;
        L6:
            int r104 = r100.length();     // Catch: Throwable -> L34
        L8:
            if (r103 >= r104) goto L12;
            if (r100.charAt(r103) == '{') goto L12;
            r103 = r103 + 1;     // Catch: Throwable -> L34
        L12:
            if (r103 < r104) goto L14;
        L16:
            int r105 = -1;
        L17:
            if (r105 != (-1)) goto L19;
            return null;
        L19:
            int r106 = 0;
        L20:
            if (r103 >= r104) goto L30;
            if (r100.charAt(r103) != '{') goto L25;
            r106 = r106 + 1;     // Catch: Throwable -> L34
        L27:
            if (r106 == 0) goto L30;
            r103 = r103 + 1;     // Catch: Throwable -> L34
            goto L20
        L25:
            if (r100.charAt(r103) != '}') goto L27;
            r106 = r106 - 1;     // Catch: Throwable -> L34
        L30:
            if (r106 != 0) goto L33;
            return r100.substring(r105, r103 + 1);
        L33:
            return null;
        L14:
            if (r100.charAt(r103) != '{') goto L16;
            r105 = r103;
        L34:
            th = move-exception;
            Result.Companion r107 = Result.Companion;
            Object r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            if (Result.m9455isFailureimpl(r108) == true) goto L40;
            r101 = r108;
        L40:
            return (String) r101;
        }

        public static MultiRenderSeiFrame a(String r100, List r101) {
            Intrinsics.checkNotNullParameter(r101, "displayIds");
            boolean r102 = false;
            if (r100 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == true) goto L34;
            String r104 = null;
            if (StringsKt.contains$default(r100, "multi_view_data", false, 2, null) == false) goto L34;
            if (r0.f156921a.getValue().getSeiOpt() == false) goto L27;
            String r105 = b(r100);
            if (r105 != null) goto L18;
        L19:
            r102 = true;
        L21:
            if ((!r102) == false) goto L23;
            r104 = r105;
        L23:
            if (r104 == null) goto L25;
            int r106 = r104.hashCode();
        L28:
            MultiRenderSeiFrame$Companion$frameFifoCache$2.AnonymousClass1 r107 = (MultiRenderSeiFrame$Companion$frameFifoCache$2.AnonymousClass1) MultiRenderSeiFrame.f155378h.getValue();
            Integer r108 = Integer.valueOf(r106);
            MultiRenderSeiFrame r109 = r107.get(r108);
            if (r109 != null) goto L31;
            r109 = new MultiRenderSeiFrame(r100);
            r107.put(r108, r109);
        L31:
            MultiRenderSeiFrame r110 = r109;
            Intrinsics.checkNotNullParameter(r101, "<set-?>");
            r110.f155381a = r101;
            return r110;
        L25:
            return (MultiRenderSeiFrame) MultiRenderSeiFrame.f155379i.getValue();
        L18:
            if (r105.length() != 0) goto L21;
        L27:
            r106 = r100.hashCode();
        L34:
            return (MultiRenderSeiFrame) MultiRenderSeiFrame.f155379i.getValue();
        L5:
            if (r100.length() == 0) goto L8;
            r103 = false;
            goto L9
        }
    }

    static {
        f155380j = new a();
        f155378h = LazyKt.lazy(MultiRenderSeiFrame$Companion$frameFifoCache$2.INSTANCE);
        f155379i = LazyKt.lazy(MultiRenderSeiFrame$Companion$emptyFrame$2.INSTANCE);
    }

    public final List<PlayerMultiDisplay> e() {
        List r100 = (List) this.f155385e.getValue();
        if (r100 == null) goto L10;
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L17;
        Object r103 = r102.next();
        if (this.f155381a.contains(Integer.valueOf(((PlayerMultiDisplay) r103).getDisplayId())) == false) goto L6;
        r101.add(r103);
        goto L6
    L17:
        return r101;
    L10:
        return null;
    }

    public final PlayerMultiDisplay b() {
        List<PlayerMultiDisplay> r100 = e();
        Object r101 = null;
        if (r100 == null) goto L15;
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if (((PlayerMultiDisplay) r103).isCommon() == false) goto L6;
        r101 = r103;
    L11:
        return (PlayerMultiDisplay) r101;
    L15:
        return null;
    }

    public final PlayerMultiDisplay d() {
        List<PlayerMultiDisplay> r100 = e();
        if (r100 == null) goto L14;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        Object r102 = r101.next();
        if (((PlayerMultiDisplay) r102).isLandscape() == false) goto L6;
    L11:
        PlayerMultiDisplay r103 = (PlayerMultiDisplay) r102;
        if (r103 == null) goto L14;
        return r103;
    L10:
        r102 = null;
    L14:
        return b();
    }

    public MultiRenderSeiFrame(String r100) {
        this.f155387g = r100;
        this.f155381a = CollectionsKt.emptyList();
        this.f155382b = LazyKt.lazy(new MultiRenderSeiFrame$multiViewDataJSONObject$2(this));
        this.f155383c = LazyKt.lazy(new MultiRenderSeiFrame$multiViewDataStr$2(this));
        this.f155384d = LazyKt.lazy(new MultiRenderSeiFrame$multiViewDataTs$2(this));
        this.f155385e = LazyKt.lazy(new MultiRenderSeiFrame$_multiViewData$2(this));
        final PlayerExtraRenderConfig r101 = (PlayerExtraRenderConfig) LivePlayerService.INSTANCE.getConfig(PlayerExtraRenderConfig.class);
        this.f155386f = LazyKt.lazy(new MultiRenderSeiFrame$decimalOpt$2(r101));
    }

    public final PlayerMultiDisplay c(boolean r100) {
        if (r100 == false) goto L16;
        List<PlayerMultiDisplay> r101 = e();
        if (r101 == null) goto L21;
        Iterator<T> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if (((PlayerMultiDisplay) r103).isPortrait() == false) goto L7;
    L12:
        PlayerMultiDisplay r104 = (PlayerMultiDisplay) r103;
        if (r104 == null) goto L21;
        return r104;
    L11:
        r103 = null;
    L21:
        return b();
    L16:
        return d();
    }

    public final RenderAreaInfo a(JSONObject r100, boolean r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        float r102 = f(r100, "x");
        float r103 = f(r100, "y");
        float r104 = f(r100, "w");
        float r105 = f(r100, "h");
        if (SetsKt.setOf(new Float[]{Float.valueOf(r102), Float.valueOf(r103), Float.valueOf(r104), Float.valueOf(r105)}).contains(Float.valueOf(Float.NaN)) == false) goto L8;
        return null;
    L8:
        if (r101 == false) goto L24;
        if (((Boolean) this.f155386f.getValue()).booleanValue() == false) goto L18;
        if (new BigDecimal(String.valueOf(r102)).add(new BigDecimal(String.valueOf(r104))).compareTo(BigDecimal.ONE) <= 0) goto L15;
        r104 = BigDecimal.ONE.subtract(new BigDecimal(String.valueOf(r102))).setScale(7, RoundingMode.DOWN).floatValue();
    L15:
        if (new BigDecimal(String.valueOf(r103)).add(new BigDecimal(String.valueOf(r105))).compareTo(BigDecimal.ONE) <= 0) goto L24;
        r105 = BigDecimal.ONE.subtract(new BigDecimal(String.valueOf(r103))).setScale(7, RoundingMode.DOWN).floatValue();
        goto L24
    L18:
        if ((r102 + r104) < 1.0f) goto L21;
        r104 = 1.0f - r102;
    L21:
        if ((r103 + r105) < 1.0f) goto L24;
        r105 = 1.0f - r103;
    L24:
        return new RenderAreaInfo(r102, r103, r104, r105);
    }

    public final float f(JSONObject r100, String r101) {
        double r102 = r100.optDouble(r101);
        if (((Boolean) this.f155386f.getValue()).booleanValue() == false) goto L8;
        if (Double.isNaN(r102) == true) goto L8;
        return new BigDecimal(String.valueOf(r102)).setScale(7, RoundingMode.DOWN).floatValue();
    L8:
        return (float) r102;
    }
}
