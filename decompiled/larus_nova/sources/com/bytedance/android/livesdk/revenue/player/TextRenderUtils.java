package com.bytedance.android.livesdk.revenue.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.net.Uri;
import android.text.Spannable;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.dress.config.TextAlignType;
import com.bytedance.android.live.profit.player.PlayerService;
import com.bytedance.android.live.profit.player.o;
import com.bytedance.android.live.profit.player.s;
import com.bytedance.android.livesdkapi.depend.live.player.MaskSrc;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class TextRenderUtils implements com.bytedance.android.live.profit.player.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.player.b f157232a;

    public static final class a {
    }

    public static final class b<T1, T2, R> implements BiFunction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextRenderUtils f157233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f157234b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f157235c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f157236d;

        public b(TextRenderUtils r100, int r101, int r102, boolean r103) {
            this.f157233a = r100;
            this.f157234b = r101;
            this.f157235c = r102;
            this.f157236d = r103;
        }

        @Override // io.reactivex.functions.BiFunction
        public final Object apply(Object r100, Object r101) {
            s r102 = (s) r100;
            s r103 = (s) r101;
            Intrinsics.checkNotNullParameter(r102, "res");
            Intrinsics.checkNotNullParameter(r103, "defaultRes");
            Bitmap r104 = (Bitmap) r102.b();
            if (r104 != null) goto L5;
            r104 = (Bitmap) r103.b();
        L5:
            if (r104 != null) goto L7;
            int r105 = s.f88364a;
            return s.a.a(new Error("avatar load failed"));
        L7:
            Bitmap r106 = Bitmap.createBitmap(this.f157234b, this.f157235c, Bitmap.Config.ARGB_8888);
            Canvas r107 = new Canvas(r106);
            Paint r108 = new Paint();
            TextRenderUtils r109 = this.f157233a;
            int r110 = this.f157234b;
            int r111 = this.f157235c;
            r109.getClass();
            Bitmap r112 = TextRenderUtils.i(r104, r110, r111);
            Shader.TileMode r113 = Shader.TileMode.CLAMP;
            r108.setShader(new BitmapShader(r112, r113, r113));
            if (this.f157236d == true) goto L10;
            r107.drawRect(0.0f, 0.0f, this.f157234b, this.f157235c, r108);
        L11:
            int r114 = s.f88364a;
            return new s.c(r106);
        L10:
            float r115 = this.f157234b / 2.0f;
            r107.drawCircle(r115, this.f157235c / 2.0f, r115, r108);
            goto L11
        }
    }

    public static final class c<T> implements SingleOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DataSource f157237a;

        public static final class a extends BaseBitmapDataSubscriber {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SingleEmitter f157238a;

            public a(SingleEmitter r100) {
                this.f157238a = r100;
            }

            @Override // com.facebook.datasource.BaseDataSubscriber
            public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
                SingleEmitter r101 = this.f157238a;
                int r102 = s.f88364a;
                RxUtilKt.l(r101, s.a.a(new Error("image load failed")));
            }

            @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
            public final void onNewResultImpl(Bitmap r100) {
                SingleEmitter r101 = this.f157238a;
                if (r100 != null) goto L5;
                int r102 = s.f88364a;
                s r103 = s.a.a(new Error("image load failed"));
            L9:
                RxUtilKt.l(r101, r103);
                return;
            L5:
                int r104 = s.f88364a;
                Bitmap.Config r105 = r100.getConfig();
                if (r105 != null) goto L8;
                r105 = Bitmap.Config.ARGB_8888;
            L8:
                r103 = new s.c(r100.copy(r105, true));
                goto L9
            }
        }

        public c(DataSource r100) {
            this.f157237a = r100;
        }

        @Override // io.reactivex.SingleOnSubscribe
        public final void subscribe(SingleEmitter<s<Bitmap>> r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            this.f157237a.subscribe(new a(r100), UiThreadImmediateExecutorService.getInstance());
        }
    }

    public static final class d implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DataSource f157239a;

        public d(DataSource r100) {
            this.f157239a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f157239a.close();
        }
    }

    public static final class e<T1, T2, T3, R> implements Function3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f157240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f157241b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o.e f157242c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ o.e f157243d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ o.e f157244e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ o.e f157245f;

        public e(TextRenderUtils r100, boolean r101, int r102, o.e r103, o.e r104, o.e r105, o.e r106) {
            this.f157240a = r101;
            this.f157241b = r102;
            this.f157242c = r103;
            this.f157243d = r104;
            this.f157244e = r105;
            this.f157245f = r106;
        }

        @Override // io.reactivex.functions.Function3
        public final Object apply(Object r310, Object r410, Object r411) {
            s r100 = (s) r310;
            s r101 = (s) r410;
            s r102 = (s) r411;
            Intrinsics.checkNotNullParameter(r100, "textRes");
            Intrinsics.checkNotNullParameter(r101, "avatarRes");
            Intrinsics.checkNotNullParameter(r102, "borderRes");
            Bitmap r110 = (Bitmap) r100.b();
            if (r110 != null) goto L10;
            int r103 = s.f88364a;
            Throwable r104 = r100.a();
            if (r104 == null) goto L8;
            String r105 = r104.getMessage();
            if (r105 == null) goto L8;
        L59:
            return s.a.a(new Error(r105));
        L8:
            r105 = "draw text failed";
            goto L59
        L10:
            Bitmap r210 = (Bitmap) r101.b();
            Bitmap r311 = (Bitmap) r102.b();
            int r106 = s.f88364a;
            MaskSrc[] r107 = new MaskSrc[4];
            if (this.f157240a == true) goto L13;
        L15:
            int r108 = this.f157242c.f88346a;
        L16:
            int r109 = r108;
            if (this.f157240a == true) goto L19;
        L21:
            int r111 = this.f157242c.f88347b;
        L22:
            r107[0] = new MaskSrc("{default_image}", 1, r109, r111, null, null, 0, false, r110, false, 240, null);
            o.e r112 = this.f157243d;
            if (r112 == null) goto L25;
            int r113 = r112.f88346a;
        L26:
            if (r112 == null) goto L28;
            int r114 = r112.f88347b;
        L29:
            r107[1] = new MaskSrc("{default_avatar}", 1, r113, r114, null, null, 0, false, r210, false, 240, null);
            o.e r115 = this.f157244e;
            if (r115 == null) goto L32;
            int r211 = r115.f88346a;
        L33:
            if (r115 == null) goto L35;
            int r212 = r115.f88347b;
        L36:
            r107[2] = new MaskSrc("{default_avatar_border}", 1, r211, r212, null, null, 0, false, r311, false, 240, null);
            o.e r116 = this.f157245f;
            if (r116 == null) goto L39;
            int r117 = r116.f88346a;
        L40:
            if (r116 == null) goto L42;
            int r118 = r116.f88347b;
        L43:
            r107[3] = new MaskSrc("{click_area}", 1, r117, r118, null, null, 0, false, null, false, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_TIMEOUT, null);
            List r119 = CollectionsKt.listOf(r107);
            ArrayList r120 = new ArrayList();
            Iterator r121 = r119.iterator();
        L45:
            if (r121.hasNext() == false) goto L53;
            Object r122 = r121.next();
            if (((MaskSrc) r122).getBitmap() == null) goto L49;
            boolean r123 = true;
        L50:
            if (r123 == false) goto L45;
            r120.add(r122);
            goto L45
        L49:
            r123 = false;
            goto L50
        L53:
            return new s.c(r120);
        L42:
            r118 = 0;
            goto L43
        L39:
            r117 = 0;
            goto L40
        L35:
            r212 = 0;
            goto L36
        L32:
            r211 = 0;
            goto L33
        L28:
            r114 = 0;
            goto L29
        L25:
            r113 = 0;
            goto L26
        L19:
            if (this.f157241b >= 0) goto L21;
            r111 = UtilityKotlinExtentionsKt.k(r110.getHeight()) * 2;
            goto L22
        L13:
            if (this.f157241b >= 0) goto L15;
            r108 = UtilityKotlinExtentionsKt.k(r110.getWidth()) * 2;
            goto L16
        }
    }

    static {
    }

    public TextRenderUtils(PlayerService.a r100) {
        Intrinsics.checkNotNullParameter(r100, "deps");
        this.f157232a = r100;
    }

    public static Single g(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        if (Intrinsics.areEqual(r100, Uri.EMPTY) == false) goto L6;
        int r101 = s.f88364a;
        return Single.just(s.a.a(new Error("invalid uri")));
    L6:
        ImageRequest r102 = ImageRequestBuilder.newBuilderWithSource(r100).setImageDecodeOptions(new ImageDecodeOptionsBuilder().setForceStaticImage(true).build()).build();
        DataSource<CloseableReference<CloseableImage>> r103 = Fresco.getImagePipeline().fetchDecodedImage(r102, null);
        return Single.create(new c(r103)).doOnDispose(new d(r103));
    }

    public static String h(String r100) {
        StringBuilder r101 = new StringBuilder();
        if (StringsKt.endsWith$default(r100, "...", false, 2, null) == false) goto L8;
        r100 = r100.substring(0, r100.length() - 3);
        if (r100.length() < 2) goto L10;
        r100 = r100.substring(0, r100.length() - 1);
    L10:
        r101.append(r100);
        r101.append("...");
        return r101.toString();
    L8:
        if (r100.length() < 2) goto L10;
        r100 = r100.substring(0, r100.length() - 1);
        goto L10
    }

    public final yb2.a f(Map<String, ? extends c5> r100) {
        yb2.a r101 = new yb2.a();
        if (this.f157232a.isAnchor() == false) goto L5;
    L6:
        r101.f567072k = true;
    L7:
        r101.f567073l = r100;
        return r101;
    L5:
        if (((com.bytedance.android.livesdk.revenue.service.interact.d) vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class)).isAudienceLinkEngineOn() == false) goto L7;
        goto L6
    }

    public static final float c(TextRenderUtils r100, Context r101, Spannable r102) {
        r100.getClass();
        TextView r103 = new TextView(r101);
        r103.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        r103.setMaxLines(1);
        r103.setText(r102);
        r103.measure(0, 0);
        return r103.getMeasuredWidth() / r103.getMeasuredHeight();
    }

    public static Bitmap i(Bitmap r100, int r101, int r102) {
        Bitmap.Config r103 = r100.getConfig();
        if (r103 != null) goto L5;
        r103 = Bitmap.Config.ARGB_8888;
    L5:
        Bitmap r104 = Bitmap.createBitmap(r101, r102, r103);
        new Canvas(r104).drawBitmap(r100, new Rect(0, 0, r100.getWidth(), r100.getHeight()), new Rect(0, 0, r101, r102), null);
        return r104;
    }

    public static Bitmap e(Context r100, Spannable r101, int r102, int r110, TextAlignType r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spannable");
        Intrinsics.checkNotNullParameter(r111, "align");
        if (r102 == 0) goto L28;
        if (r110 == 0) goto L31;
        TextView r103 = new TextView(r100);
        r103.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        r103.setMaxLines(1);
        r103.setText(r101);
        r103.measure(0, 0);
        int r104 = r103.getMeasuredWidth();
        int r105 = r103.getMeasuredHeight();
        if (r104 == 0) goto L29;
        if (r105 == 0) goto L32;
        r103.layout(0, 0, r104, r105);
        Bitmap r106 = Bitmap.createBitmap(r104, r105, Bitmap.Config.ARGB_8888);
        r103.draw(new Canvas(r106));
        float r107 = r104 / r105;
        float r108 = r102 / r110;
        if (r107 <= r108) goto L13;
        Pair r109 = TuplesKt.to(Integer.valueOf(r103.getMeasuredWidth()), Integer.valueOf((int) (r103.getMeasuredWidth() / r108)));
    L14:
        int r112 = ((Number) r109.component1()).intValue();
        int r113 = ((Number) r109.component2()).intValue();
        Bitmap r114 = Bitmap.createBitmap(r112, r113, Bitmap.Config.ARGB_8888);
        if (r114 == null) goto L30;
        Canvas r115 = new Canvas(r114);
        int r116 = com.bytedance.android.livesdk.revenue.player.c.f157246a[r111.ordinal()];
        if (r116 == 1) goto L25;
        if (r116 != 2) goto L20;
        float r117 = 0.0f;
    L26:
        r115.drawBitmap(r106, r117, (r113 / 2) - (r103.getMeasuredHeight() / 2), null);
        return i(r114, r102, r110);
    L20:
        if (r116 != 3) goto L23;
        r117 = r112 - r103.getMeasuredWidth();
        goto L26
    L23:
        throw new NoWhenBranchMatchedException();
    L25:
        r117 = (r112 - r103.getMeasuredWidth()) / 2;
        goto L26
    L30:
        return null;
    L13:
        r109 = TuplesKt.to(Integer.valueOf((int) (r103.getMeasuredHeight() * r108)), Integer.valueOf(r103.getMeasuredHeight()));
        goto L14
    L32:
        return null;
    L29:
        return null;
    L31:
        return null;
    L28:
        return null;
    }

    @Override // com.bytedance.android.live.profit.player.e
    public final Single<s<Bitmap>> b(Context r110, a5 r111, Map<String, ? extends c5> r112, int r113, int r114, TextAlignType r115) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r115, "align");
        Intrinsics.checkNotNullParameter(r111, "text");
        return Single.create(new h(this, r111, r112)).map(new com.bytedance.android.livesdk.revenue.player.d(this, false, r110, r113, r114, r115, r111));
    }

    public final Single<s<Bitmap>> d(Context r100, Uri r101, Uri r102, boolean r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "image");
        if (r104 <= 0) goto L11;
        if (r105 <= 0) goto L11;
        Single r106 = g(r101);
        if (r102 != null) goto L10;
        r102 = Uri.EMPTY;
    L10:
        return Single.zip(r106, g(r102), new b(this, r104, r105, r103));
    L11:
        int r107 = s.f88364a;
        return Single.just(s.a.a(new Error("unexpected size: " + r104 + Permission.EXECUTE + r105)));
    }

    @Override // com.bytedance.android.live.profit.player.e
    public final Single<s<List<MaskSrc>>> a(final Context r110, String r210, final a5 r211, final Map<String, ? extends c5> r212, final TextAlignType r213, final String r214, final String r215, final int r216, final boolean r217, o.e r218) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r210, "path");
        Intrinsics.checkNotNullParameter(r211, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r213, "textAlignType");
        Intrinsics.checkNotNullParameter(r214, "avatarUrl");
        TextRenderUtils$prepareUserInfoForMp4$1 r100 = TextRenderUtils$prepareUserInfoForMp4$1.INSTANCE;
        List<c5> r101 = r211.getPieces();
        if (r101 == null) goto L14;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L14;
        c5 r103 = (c5) r102.next();
        if (r103.getType() != PieceType.IMAGE.getPieceType()) goto L6;
        b5 r104 = r103.getFormat();
        if (r104 == null) goto L6;
        if (r104.getFontSize() != 0) goto L6;
        r103.setFormat(r211.getDefaultFormat());
    L14:
        s<o> r105 = this.f157232a.K(r210);
        if ((r105 instanceof s.c) == false) goto L17;
        o r106 = r105.b();
    L18:
        if (r106 == null) goto L20;
        o.c r107 = r106.a("{default_image}");
    L21:
        if (r107 == null) goto L23;
        boolean r111 = r107.c();
    L24:
        if (r107 == null) goto L26;
        o.e r112 = r107.b();
    L27:
        if (r112 == null) goto L29;
        if (r106 == null) goto L34;
        o.c r108 = r106.a("{click_area}");
        if (r108 == null) goto L34;
        o.e r113 = r108.b();
    L35:
        if (r106 == null) goto L39;
        o.c r109 = r106.a("{default_avatar}");
        if (r109 == null) goto L39;
        final o.e r114 = r109.b();
    L40:
        if (r106 == null) goto L44;
        o.c r115 = r106.a("{default_avatar_border}");
        if (r115 == null) goto L44;
        o.e r116 = r115.b();
    L45:
        final o.e r117 = r112;
        final boolean r118 = r111;
        final o.e r119 = r116;
        return Single.zip(new TextRenderUtils$prepareUserInfoForMp4$2(this, r216, r110, r211, r212, r117, r213, r118).invoke(), new TextRenderUtils$prepareUserInfoForMp4$3(this, r114, r214, r110).invoke(), new TextRenderUtils$prepareUserInfoForMp4$4(this, r119, r215, r217, r110).invoke(), new e(this, r111, r216, r112, r114, r116, r113));
    L44:
        r116 = null;
    L39:
        r114 = null;
    L34:
        r113 = null;
        goto L35
    L29:
        return TextRenderUtils$prepareUserInfoForMp4$1.INSTANCE.invoke2("text element size query failed");
    L26:
        r112 = r218;
        goto L27
    L23:
        r111 = false;
        goto L24
    L20:
        r107 = null;
        goto L21
    L17:
        int r120 = x8.a.f562881a;
        x8.a.c("TextRenderUtils", r105.a(), false);
        r106 = null;
        goto L18
    }
}
