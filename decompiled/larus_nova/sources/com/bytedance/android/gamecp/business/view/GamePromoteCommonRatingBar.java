package com.bytedance.android.gamecp.business.view;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.camera.video.AudioStats;
import com.bytedance.android.gamecp.business.v;
import com.bytedance.android.gamecp.common.utils.ToastUtil;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.android.gamecp.host_api.model.Room;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import wu.l3;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003345B'\b\u0007\u0012\u0006\u0010-\u001a\u00020,\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.\u0012\b\b\u0002\u00100\u001a\u00020\u0004¢\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001b\u0010+\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010%\u001a\u0004\b*\u0010'¨\u00066"}, d2 = {"Lcom/bytedance/android/gamecp/business/view/GamePromoteCommonRatingBar;", "Landroid/view/View;", "", "getStarProgressWidth", "", "getProgress", "progress", "", "setProgress", "Lcom/bytedance/android/gamecp/business/view/GamePromoteCommonRatingBar$b;", "listener", "setOnCommonRatingBarScoreListener", "m", FaceService.girlLabel, "getScore", "()F", "setScore", "(F)V", com.bytedance.android.ec.core.event.a.KEY_SCORE, "Lcom/bytedance/android/gamecp/business/v;", OfficeSDKRequestTag.KEY_NEW_USER, "Lcom/bytedance/android/gamecp/business/v;", "getGameInfo", "()Lcom/bytedance/android/gamecp/business/v;", "setGameInfo", "(Lcom/bytedance/android/gamecp/business/v;)V", "gameInfo", "", "o", "Z", "getNeedNetworkRequest", "()Z", "setNeedNetworkRequest", "(Z)V", "needNetworkRequest", "Landroid/graphics/Bitmap;", "p", "Lkotlin/Lazy;", "getStarBitmap", "()Landroid/graphics/Bitmap;", "starBitmap", "q", "getStarBgBitmap", "starBgBitmap", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "StarType", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GamePromoteCommonRatingBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f56468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f56469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f56470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f56471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f56472e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f56473f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f56474g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f56475h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f56476i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f56477j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f56478k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f56479l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f56480m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public v f56481n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f56482o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f56483p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f56484q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f56485r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f56486s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f56487t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public b f56488u;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/gamecp/business/view/GamePromoteCommonRatingBar$StarType;", "", EffectConstants.NORMAL, "HALF", "WHOLE", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum StarType extends Enum<StarType> {
        public static final StarType HALF = null;
        public static final StarType NORMAL = null;
        public static final StarType WHOLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StarType[] f56489a = null;

        static {
            StarType r100 = new StarType(EffectConstants.NORMAL, 0);
            NORMAL = r100;
            StarType r101 = new StarType("HALF", 1);
            HALF = r101;
            StarType r102 = new StarType("WHOLE", 2);
            WHOLE = r102;
            f56489a = new StarType[]{r100, r101, r102};
        }

        public static StarType valueOf(String r100) {
            return (StarType) r27.a.a(StarType.class, r100);
        }

        public static StarType[] values() {
            return (StarType[]) f56489a.clone();
        }

        public StarType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void a(float r100);

        boolean b(float r100, int r101);
    }

    public static class b implements a {
        public b() {
        }

        @Override // com.bytedance.android.gamecp.business.view.GamePromoteCommonRatingBar.a
        public boolean b(float r100, int r101) {
            return false;
        }
    }

    public GamePromoteCommonRatingBar(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GamePromoteCommonRatingBar(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final Bitmap getStarBgBitmap() {
        return (Bitmap) this.f56484q.getValue();
    }

    private final Bitmap getStarBitmap() {
        return (Bitmap) this.f56483p.getValue();
    }

    private final float getStarProgressWidth() {
        float r100 = (this.f56479l / 100.0f) * this.f56468a;
        int r101 = this.f56473f;
        if (r101 != StarType.HALF.ordinal()) goto L6;
        float r102 = b(r100) * this.f56470c;
        int r103 = (int) r100;
        float r104 = this.f56469b;
    L10:
        return r102 + (r103 * ((int) r104));
    L6:
        if (r101 != StarType.WHOLE.ordinal()) goto L8;
        r102 = ((float) Math.ceil(r100)) * this.f56470c;
        r103 = (int) r100;
        r104 = this.f56469b;
        goto L10
    L8:
        r102 = this.f56470c * r100;
        r103 = (int) r100;
        r104 = this.f56469b;
        goto L10
    }

    public final v getGameInfo() {
        return this.f56481n;
    }

    public final boolean getNeedNetworkRequest() {
        return this.f56482o;
    }

    public final int getProgress() {
        return this.f56479l;
    }

    public final float getScore() {
        return this.f56480m;
    }

    public static float b(float r100) {
        double r101 = r100;
        double r102 = r101 % 0.5d;
        if (r102 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        return r100;
    L5:
        float r103 = (float) Math.rint(r101);
        if (r103 >= r100) goto L13;
        if (r102 >= 0.25d) goto L11;
        return r103;
    L11:
        return r103 + 0.5f;
    L13:
        if (r103 > r100) goto L15;
        return r100;
    L15:
        if (r102 < 0.25d) goto L17;
        return r103;
    L17:
        return r103 - 0.5f;
    }

    public final float a(int r100) {
        float r101 = (r100 / 100.0f) * this.f56468a;
        int r102 = this.f56473f;
        if (r102 != StarType.HALF.ordinal()) goto L6;
        return b(r101);
    L6:
        if (r102 == StarType.WHOLE.ordinal()) goto L8;
        return r101;
    L8:
        return (float) Math.ceil(r101);
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (this.f56474g == true) goto L9;
        if (this.f56475h == true) goto L9;
        return false;
    L9:
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        if (this.f56472e != (-1)) goto L5;
        return;
    L5:
        int r100 = r110.save();
        int r101 = this.f56468a;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L9;
        r110.drawBitmap(getStarBgBitmap(), (this.f56470c + ((int) this.f56469b)) * r102, 0.0f, this.f56476i);
        r102 = r102 + 1;
        goto L6
    L9:
        if (this.f56471d != (-1)) goto L11;
        r110.drawRect(0.0f, 0.0f, getStarProgressWidth(), getHeight(), this.f56478k);
    L12:
        r110.restoreToCount(r100);
        return;
    L11:
        Paint r103 = this.f56477j;
        Bitmap r104 = getStarBitmap();
        Shader.TileMode r105 = Shader.TileMode.REPEAT;
        r103.setShader(new BitmapShader(r104, r105, r105));
        r110.drawRect(0.0f, 0.0f, getStarProgressWidth(), getHeight(), this.f56477j);
        goto L12
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        Integer r102 = Integer.valueOf(r100.getAction());
    L7:
        if (r102 == null) goto L36;
        if (r102.intValue() != 0) goto L36;
        if (l3.f561345a.getValue().booleanValue() == false) goto L34;
        v r103 = this.f56481n;
        if (r103 == null) goto L34;
        String r104 = r103.packageName;
        if (r104 == null) goto L34;
        Room r105 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        if (r105 == null) goto L20;
        String r106 = r105.getIdStr();
    L21:
        if (r106 != null) goto L23;
        boolean r107 = false;
    L24:
        if (r107 == false) goto L26;
        r101 = r104;
    L26:
        if (r101 == null) goto L34;
        getContext().getPackageManager().getPackageInfo(r101, 1);     // Catch: PackageManager.NameNotFoundException -> L30
        boolean r108 = true;
    L31:
        if (r108 == true) goto L34;
        ToastUtil.b(y0.i(R.string.ttlive_game_promote_comment_install_check_tips), 0);
        return false;
    L30:
        r108 = false;
        goto L31
    L23:
        r107 = !com.bytedance.android.gamecp.host_api.a.b().getLiveService().isAnchor();
        goto L24
    L20:
        r106 = null;
    L34:
        this.f56486s = r100.getX();
        this.f56487t = r100.getY();
    L79:
        return true;
    L36:
        if (r102 != null) goto L39;
    L48:
        if (r102 != null) goto L51;
    L53:
        if (r102 == null) goto L79;
        if (r102.intValue() != 3) goto L79;
    L57:
        int r109 = (int) ((r100.getX() / getWidth()) * 100);
        if (this.f56475h == false) goto L63;
        if (Math.abs(r100.getX() - this.f56486s) <= this.f56485r) goto L63;
        setProgress(r109);
    L63:
        if (this.f56474g == true) goto L65;
    L78:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L79
    L65:
        if (Math.abs(r100.getY() - this.f56487t) > this.f56485r) goto L78;
        if (Math.abs(r100.getX() - this.f56486s) > this.f56485r) goto L78;
        if (new Rect(0, 0, getWidth(), getHeight()).contains((int) r100.getX(), (int) r100.getY()) == false) goto L78;
        b r110 = this.f56488u;
        if (r110 != null) goto L73;
    L75:
        setProgress(r109);
        getParent().requestDisallowInterceptTouchEvent(true);
        b r111 = this.f56488u;
        if (r111 == null) goto L79;
        r111.a(this.f56480m);
        goto L79
    L73:
        if (r110.b(a(r109), r109) != true) goto L75;
        return true;
    L51:
        if (r102.intValue() != 1) goto L53;
    L39:
        if (r102.intValue() != 2) goto L48;
        if (this.f56475h == true) goto L43;
    L47:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L79
    L43:
        if ((Math.abs(r100.getX() - this.f56486s) - Math.abs(r100.getY() - this.f56487t)) < this.f56485r) goto L47;
        if (new Rect(0, 0, getWidth(), getHeight()).contains((int) r100.getX(), (int) r100.getY()) == false) goto L47;
        getParent().requestDisallowInterceptTouchEvent(true);
        setProgress((int) ((r100.getX() / getWidth()) * 100));
        goto L79
    L5:
        r102 = null;
        goto L7
    }

    public final void setGameInfo(v r100) {
        this.f56481n = r100;
    }

    public final void setNeedNetworkRequest(boolean r100) {
        this.f56482o = r100;
    }

    public final void setOnCommonRatingBarScoreListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f56488u = r100;
    }

    public final void setProgress(int r100) {
        if (r100 >= 0) goto L5;
        r100 = 0;
    L5:
        if (r100 <= 100) goto L7;
        r100 = 100;
    L7:
        this.f56479l = r100;
        this.f56480m = a(r100);
        postInvalidate();
    }

    public final void setScore(float r100) {
        this.f56480m = r100;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = getMeasuredHeight();
        this.f56470c = r102;
        int r103 = this.f56468a;
        setMeasuredDimension((r103 * r102) + ((r103 - 1) * ((int) this.f56469b)), r102);
    }

    public GamePromoteCommonRatingBar(final Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        this.f56468a = 5;
        this.f56470c = 30;
        this.f56471d = -1;
        this.f56472e = -1;
        StarType r102 = StarType.NORMAL;
        this.f56473f = r102.ordinal();
        ColorProtector.parseColor("#F7B500");
        Paint r103 = new Paint();
        r103.setAntiAlias(true);
        Unit r104 = Unit.INSTANCE;
        this.f56476i = r103;
        Paint r105 = new Paint();
        r105.setAntiAlias(true);
        this.f56477j = r105;
        Paint r106 = new Paint();
        r106.setAntiAlias(true);
        r106.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f56478k = r106;
        this.f56483p = LazyKt.lazy(new GamePromoteCommonRatingBar$starBitmap$2(this, r100));
        this.f56484q = LazyKt.lazy(new GamePromoteCommonRatingBar$starBgBitmap$2(this, r100));
        TypedArray r107 = r100.obtainStyledAttributes(r101, new int[]{R.attr.starBgDrawable, R.attr.starClickable, R.attr.starColor, R.attr.starCount, R.attr.starDrawable, R.attr.starPadding, R.attr.starScrollable, R.attr.starType});
        this.f56468a = r107.getInt(3, 5);
        this.f56469b = r107.getDimension(5, 10.0f);
        this.f56471d = r107.getResourceId(4, -1);
        this.f56472e = r107.getResourceId(0, -1);
        this.f56473f = r107.getInt(7, r102.ordinal());
        r106.setColor(r107.getColor(2, ColorProtector.parseColor("#F7B500")));
        this.f56474g = r107.getBoolean(1, false);
        this.f56475h = r107.getBoolean(6, false);
        r107.recycle();
        this.f56485r = ViewConfiguration.get(r100).getScaledTouchSlop();
    }

    public /* synthetic */ GamePromoteCommonRatingBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
