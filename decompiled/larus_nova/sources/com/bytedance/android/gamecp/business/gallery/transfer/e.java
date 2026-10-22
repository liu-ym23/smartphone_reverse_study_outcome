package com.bytedance.android.gamecp.business.gallery.transfer;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.gamecp.business.gallery.transfer.adapter.GalleryAdapter;
import com.bytedance.android.gamecp.business.gallery.transfer.adapter.TransferAdapter;
import com.bytedance.android.gamecp.business.gallery.view.image.TransferImage;
import com.bytedance.android.gamecp.business.gallery.view.indicator.NumberIndicator;
import com.bytedance.android.gamecp.business.gallery.view.indicator.TitleIndicator;
import com.bytedance.android.gamecp.common.ui.DouyinLoadingLayout;
import com.bytedance.android.gamecp.host_api.model.l;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes44.dex */
public final class e extends FrameLayout implements ws.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TransferImage f53266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BounceBackViewPager f53267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GalleryAdapter f53268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.gamecp.business.gallery.transfer.d f53269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f53270e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<Integer> f53271f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f53272g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f53273h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f53274i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f53275j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.android.gamecp.business.gallery.transfer.a f53276k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f53277l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f53278m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f53279n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f53280o;

    public class a extends ViewPager.SimpleOnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f53281a;

        public a(e r100) {
            this.f53281a = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            e r101 = this.f53281a;
            com.bytedance.android.gamecp.business.gallery.transfer.d r102 = r101.f53269d;
            if (r102 != null) goto L5;
            return;
        L5:
            int r103 = r102.f53265u;
            int r104 = 1;
            if (r100 != r103) goto L8;
            r101.c(r100 - 1);
            return;
        L8:
            r102.f53245a = r100 % r103;
            if (r102.f53249e == false) goto L11;
            e.a(r101, r100, 0);
        L14:
            e r105 = this.f53281a;
            com.bytedance.android.gamecp.business.gallery.transfer.d.c r106 = r105.f53269d.f53262r;
            if (r106 == null) goto L22;
            BounceBackViewPager r107 = r105.f53267b;
            if (r107 == null) goto L23;
            r106.call(r107.getCurrentItem());
            return;
        L23:
            return;
        L22:
            return;
        L11:
            e r108 = this.f53281a;
            if (r104 > r108.f53273h) goto L14;
            e.a(r108, r100, r104);
            r104 = r104 + 1;
            goto L11
        }
    }

    public class b implements TransferAdapter.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f53282a;

        public b(e r100) {
            this.f53282a = r100;
        }
    }

    public class c implements TransferImage.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f53283a;

        public c(e r100) {
            this.f53283a = r100;
        }

        public final void b(int r100, float r101) {
            e r102 = this.f53283a;
            float r103 = 255.0f * r101;
            r102.f53274i = r103;
            r102.setBackgroundColor(r102.d(r103));
            com.bytedance.android.gamecp.business.gallery.transfer.d r104 = this.f53283a.f53269d;
            if (r104 != null) goto L5;
            return;
        L5:
            if (r101 <= 0.05d) goto L7;
            return;
        L7:
            if (r100 != 2) goto L17;
            List r105 = r104.f53251g;
            if (r105 != null) goto L11;
            r105 = new ArrayList();
        L11:
            ImageView r106 = (ImageView) ListProtector.get(r105, this.f53283a.f53269d.f53245a);
            if (r106 == null) goto L18;
            r106.setVisibility(0);
            return;
        L18:
            return;
        }

        public final void a(int r100, int r101, int r102) {
            e r103 = this.f53283a;
            r103.f53275j = false;
            if (r101 != 100) goto L18;
            if (r100 == 1) goto L8;
            if (r100 != 2) goto L33;
            r103.f();
        L33:
            this.f53283a.getClass();
            return;
        L8:
            e.b(r103);
            BounceBackViewPager r104 = this.f53283a.f53267b;
            if (r104 == null) goto L11;
            r104.setVisibility(0);
        L11:
            TransferImage r105 = this.f53283a.f53266a;
            if (r105 == null) goto L33;
            ViewGroup r106 = (ViewGroup) r105.getParent();
            if (r106 == null) goto L33;
            r106.removeView(r105);
            goto L33
        L18:
            if (r100 == 1) goto L23;
            if (r100 != 2) goto L33;
            if (r102 != 201) goto L33;
            r103.f();
            goto L33
        L23:
            if (r102 != 201) goto L33;
            e.b(r103);
            BounceBackViewPager r107 = this.f53283a.f53267b;
            if (r107 == null) goto L27;
            r107.setVisibility(0);
        L27:
            TransferImage r108 = this.f53283a.f53266a;
            if (r108 == null) goto L33;
            ViewGroup r109 = (ViewGroup) r108.getParent();
            if (r109 == null) goto L33;
            r109.removeView(r108);
            goto L33
        }
    }

    public interface d {
    }

    public final void f() {
        this.f53275j = false;
        Set<Integer> r100 = this.f53271f;
        if (r100 == null) goto L5;
        ((HashSet) r100).clear();
    L5:
        com.bytedance.android.gamecp.business.gallery.transfer.d r101 = this.f53269d;
        if (r101 == null) goto L15;
        xs.a r102 = r101.f53256l;
        if (r102 == null) goto L15;
        View r103 = r102.f564936a;
        if (r103 == null) goto L15;
        ViewGroup r104 = (ViewGroup) r103.getParent();
        if (r104 == null) goto L15;
        r104.removeView(r102.f564936a);
    L15:
        removeAllViews();
        d r105 = this.f53270e;
        if (r105 == null) goto L28;
        h r106 = (h) r105;
        AlertDialog r107 = r106.f53289b;     // Catch: Exception -> L22
        if (r107 == null) goto L24;
        h.a(r107);     // Catch: Exception -> L22
    L24:
        r106.f53292e = false;
        return;
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L24
    }

    public int getCurrentPosition() {
        BounceBackViewPager r100 = this.f53267b;
        if (r100 != null) goto L5;
        return -1;
    L5:
        if (this.f53269d != null) goto L8;
        return -1;
    L8:
        return r100.getCurrentItem() % this.f53269d.f53265u;
    }

    public Context getActivityContext() {
        return this.f53272g;
    }

    public TransferAdapter getTransAdapter() {
        return this.f53268c;
    }

    public com.bytedance.android.gamecp.business.gallery.transfer.d getTransConfig() {
        return this.f53269d;
    }

    public TransferImage.b getTransListener() {
        return this.f53280o;
    }

    public com.bytedance.android.gamecp.business.gallery.transfer.d getTransferConfig() {
        return this.f53269d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public e(Context r100) {
        super(r100);
        this.f53273h = 1;
        this.f53277l = true;
        this.f53278m = new a(this);
        this.f53279n = new b(this);
        this.f53280o = new c(this);
        this.f53272g = r100;
        this.f53271f = new HashSet();
    }

    public static void b(e r100) {
        com.bytedance.android.gamecp.business.gallery.transfer.d r101 = r100.f53269d;
        if (r101 == null) goto L32;
        xs.a r102 = r101.f53256l;
        if (r102 != null) goto L7;
        return;
    L7:
        if (r101.f53265u < 1) goto L9;
    L10:
        r102.f564939d = r100;
        View r103 = LayoutInflater.from(r100.getContext()).inflate(R.layout.gamecp_game_promote_comment_gallery_topbar, r100, false);
        r102.f564936a = r103;
        r102.f564937b = (NumberIndicator) r103.findViewById(R.id.preview_indicator);
        TitleIndicator r104 = (TitleIndicator) r102.f564936a.findViewById(R.id.preview_title);
        r102.f564938c = r104;
        r104.setMovementMethod(ScrollingMovementMethod.getInstance());
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-1, -2);
        r105.gravity = 80;
        r100.addView(r102.f564936a, r105);
        BounceBackViewPager r106 = r100.f53267b;
        View r107 = r102.f564936a;
        if (r107 != null) goto L13;
        return;
    L13:
        if (r102.f564937b != null) goto L15;
        return;
    L15:
        if (r102.f564939d == null) goto L40;
        r107.setVisibility(0);
        int r108 = ((e) r102.f564939d).getTransferConfig().f53265u;
        r102.f564937b.setRealSize(r108);
        r102.f564937b.setViewPager(r106);
        if (r108 > 1) goto L20;
        r102.f564937b.setVisibility(8);
    L21:
        TitleIndicator r109 = r102.f564938c;
        if (r109 == null) goto L37;
        ws.a r110 = r102.f564939d;
        r109.setTextSize(17.0f);
        r109.f53369a = r110;
        if (r106 != null) goto L26;
        return;
    L26:
        if (r106.getAdapter() != null) goto L28;
        return;
    L28:
        if (r109.f53369a == null) goto L41;
        r109.setVisibility(0);
        r106.removeOnPageChangeListener(r109.f53370b);
        r106.addOnPageChangeListener(r109.f53370b);
        r109.f53370b.onPageSelected(r106.getCurrentItem());
        return;
    L41:
        return;
    L37:
        return;
    L20:
        r102.f564937b.setVisibility(0);
        goto L21
    L40:
        return;
    L9:
        if (r101.f53259o == true) goto L10;
        return;
    }

    public final boolean c(int r100) {
        if (this.f53275j == true) goto L48;
        TransferImage r101 = this.f53266a;
        if (r101 != null) goto L7;
    L9:
        com.bytedance.android.gamecp.business.gallery.transfer.d r102 = this.f53269d;
        if (r102 != null) goto L12;
        return false;
    L12:
        com.bytedance.android.gamecp.business.gallery.transfer.d.b r103 = r102.f53260p;
        if (r103 == null) goto L15;
        r103.call(r100);
    L15:
        int r104 = this.f53269d.f53250f;
        TransferImage r105 = null;
        if (r104 <= 0) goto L19;
        if (r100 < r104) goto L19;
        this.f53266a = null;
    L32:
        if (this.f53266a != null) goto L34;
        f();
    L35:
        com.bytedance.android.gamecp.business.gallery.transfer.d r106 = this.f53269d;
        if (r106 == null) goto L47;
        xs.a r107 = r106.f53256l;
        if (r107 == null) goto L47;
        if (r106.f53265u < 2) goto L42;
    L43:
        View r108 = r107.f564936a;
        if (r108 == null) goto L47;
        r108.setVisibility(8);
        goto L47
    L42:
        if (r106.f53259o == true) goto L43;
    L47:
        return true;
    L34:
        this.f53267b.setVisibility(4);
    L19:
        com.bytedance.android.gamecp.business.gallery.transfer.c r109 = new com.bytedance.android.gamecp.business.gallery.transfer.c(this);
        com.bytedance.android.gamecp.business.gallery.transfer.d r110 = getTransConfig();
        if (r110 == null) goto L30;
        List r111 = r110.f53251g;
        if (r111 != null) goto L26;
        r111 = new ArrayList();
    L26:
        if (r111.size() <= r100) goto L30;
        if (ListProtector.get(r111, r100) == null) goto L30;
        r105 = r109.a((ImageView) ListProtector.get(r111, r100));
        r109.b((String) ListProtector.get(r110.f53253i, r100), r105, false);
        addView(r105, 1);
    L30:
        this.f53266a = r105;
        goto L32
    L7:
        if (r101.getState() != 2) goto L9;
    L48:
        return false;
    }

    public final int d(float r100) {
        com.bytedance.android.gamecp.business.gallery.transfer.d r101 = this.f53269d;
        if (r101 != null) goto L6;
        return 0;
    L6:
        int r102 = r101.f53247c;
        return Color.argb(Math.round(r100), Color.red(r102), Color.green(r102), Color.blue(r102));
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [vs.a] */
    public final void e(int r110) {
        com.bytedance.android.gamecp.business.gallery.transfer.d r100 = this.f53269d;
        if (r100 == null) goto L57;
        List<String> r101 = r100.f53252h;
        if (r101 == null) goto L61;
        int r102 = r110 % r101.size();
        com.bytedance.android.gamecp.business.gallery.transfer.c r103 = new com.bytedance.android.gamecp.business.gallery.transfer.c(this);
        TransferAdapter r111 = getTransAdapter();
        if (r111 == null) goto L62;
        com.bytedance.android.gamecp.business.gallery.transfer.d r104 = getTransConfig();
        if (r104 == null) goto L63;
        TransferImage r105 = r111.f(r102);
        if (r105 == null) goto L64;
        vs.e r106 = r104.a();
        if (r106 == null) goto L65;
        ys.a r107 = r104.f53255k;
        if (r107 == null) goto L66;
        FrameLayout r112 = r111.g(r102);
        Context r108 = r112.getContext();
        FrameLayout.LayoutParams r109 = new FrameLayout.LayoutParams(-1, -1);
        DouyinLoadingLayout r113 = new DouyinLoadingLayout(r108);
        r113.setLayoutParams(r109);
        r112.addView(r113, r112.getChildCount());
        r107.f568984a.put(r102, r113);
        r113.setVisibility(0);
        if (r104.f53249e == false) goto L25;
        r103.c(r105.getDrawable(), r102, r105, r107);
        return;
    L25:
        List<String> r114 = r104.f53253i;
        if (r114 == null) goto L59;
        final vs.d r115 = (vs.d) r106;
        if (r115.b((String) ListProtector.get(r114, r102)) == false) goto L50;
        final com.bytedance.android.gamecp.business.gallery.transfer.b r116 = new com.bytedance.android.gamecp.business.gallery.transfer.b(r103, r104, r102, r105, r107);
        l r117 = new l();
        ?? r118 = new vs.a(r115, r116);
        ImagePipeline r119 = ImagePipelineFactory.getInstance().getImagePipeline();
        Priority r120 = Priority.MEDIUM;
        Bitmap.Config r121 = Bitmap.Config.RGB_565;
        if (r117.a() != null) goto L32;
    L45:
        ImageRequest[] r122 = new ImageRequest[0];
    L47:
        if (r122.length == 0) goto L67;
        DataSource<CloseableReference<CloseableImage>> r123 = r119.fetchDecodedImage(r122[0], null);
        r123.subscribe(new vs.c(r123, r118), CallerThreadExecutor.getInstance());
        return;
    L67:
        return;
    L32:
        if (r117.a().size() == 0) goto L45;
        ArrayList r124 = new ArrayList();
        Iterator<String> r125 = r117.a().iterator();
    L36:
        if (r125.hasNext() == false) goto L42;
        String r126 = r125.next();
        if (StringUtils.isEmpty(r126) == true) goto L36;
        ImageDecodeOptionsBuilder r127 = new ImageDecodeOptionsBuilder();
        r127.setBitmapConfig(r121);
        r127.setPreDecodeFrameCount(1);
        r127.setDecodeAllFrames(false);
        ImageDecodeOptions r128 = new ImageDecodeOptions(r127);
        r124.add(ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r126)).setRequestPriority(r120).setImageDecodeOptions(r128).build());
        goto L36
    L42:
        if (r124.size() != 0) goto L44;
        r122 = new ImageRequest[0];
        goto L47
    L44:
        r122 = (ImageRequest[]) r124.toArray(new ImageRequest[r124.size()]);
        goto L47
    L50:
        r103.c(r104.b(), r102, r105, r107);
        return;
    L59:
        return;
    L66:
        return;
    L65:
        return;
    L64:
        return;
    L63:
        return;
    L62:
        return;
    L61:
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (r100.getPointerCount() != 1) goto L40;
        TransferImage r101 = this.f53266a;
        if (r101 == null) goto L40;
        boolean r102 = false;
        if (r101.f53316w == false) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L40;
        if (this.f53277l == false) goto L40;
        com.bytedance.android.gamecp.business.gallery.transfer.a r104 = this.f53276k;
        if (r104 == null) goto L40;
        r104.getClass();
        if (r100.getPointerCount() != 1) goto L37;
        int r105 = r100.getAction();
        if (r105 == 0) goto L30;
        if (r105 != 1) goto L24;
        r104.f53227d = 0.0f;
        goto L37
    L24:
        if (r105 != 2) goto L37;
        if ((r100.getRawY() - r104.f53227d) <= r104.f53229f) goto L37;
        r102 = true;
        goto L37
    L30:
        r104.f53226c = r100.getRawX();
        r104.f53227d = r100.getRawY();
        VelocityTracker r106 = r104.f53225b;
        if (r106 != null) goto L33;
        r104.f53225b = VelocityTracker.obtain();
    L34:
        VelocityTracker r107 = r104.f53225b;
        if (r107 == null) goto L37;
        r107.addMovement(r100);
        goto L37
    L33:
        r106.clear();
    L37:
        if (r102 == false) goto L40;
        return true;
    L9:
        if (r101.f53317x == true) goto L12;
        r103 = false;
    L40:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        com.bytedance.android.gamecp.business.gallery.transfer.a r100 = this.f53276k;
        if (r100 == null) goto L63;
        if (this.f53277l == false) goto L63;
        int r101 = r110.getAction();
        if (r101 != 0) goto L9;
        r100.f53226c = r110.getRawX();
        r100.f53227d = r110.getRawY();
        goto L63
    L9:
        if (r101 == 1) goto L44;
        if (r101 == 2) goto L16;
        if (r101 != 3) goto L63;
        VelocityTracker r102 = r100.f53225b;
        if (r102 == null) goto L63;
        r102.recycle();
        r100.f53225b = null;
        goto L63
    L16:
        VelocityTracker r103 = r100.f53225b;
        if (r103 == null) goto L19;
        r103.addMovement(r110);
    L19:
        e r104 = r100.f53224a;
        if (r104 == null) goto L63;
        if (r104.getTransferConfig() == null) goto L63;
        if (r100.f53224a.getTransferConfig().f53256l == null) goto L63;
        float r105 = r110.getRawX() - r100.f53226c;
        float r106 = r110.getRawY() - r100.f53227d;
        float r107 = Math.abs(r106);
        float r108 = Math.max(1.0f - ((r107 / r100.f53224a.getHeight()) * 1.2f), 0.6f);
        r100.f53228e = r108;
        float r109 = 1.0f - r108;
        float r111 = ((r109 * r109) * r100.f53224a.getHeight()) * 0.5f;
        e r112 = r100.f53224a;
        r112.f53274i = 255.0f - (Math.min((r107 / r112.getHeight()) * 2.4f, 0.8f) * 255.0f);
        e r113 = r100.f53224a;
        float r114 = r113.f53274i;
        if (r114 >= 0.0f) goto L28;
        r114 = 0.0f;
    L28:
        r113.f53274i = r114;
        BounceBackViewPager r115 = r113.f53267b;
        if (r115 == null) goto L63;
        if (r115.getTranslationY() < 0.0f) goto L38;
        e r116 = r100.f53224a;
        r116.setBackgroundColor(r116.d(r116.f53274i));
        xs.a r117 = r100.f53224a.getTransferConfig().f53256l;
        int r118 = Math.round(r100.f53224a.f53274i);
        View r119 = r117.f564936a;
        if (r119 == null) goto L36;
        r119.setAlpha(r118 / 255.0f);
    L36:
        r115.setTranslationX(r105);
        r115.setTranslationY(r106 - r111);
        r115.setScaleX(r100.f53228e);
        r115.setScaleY(r100.f53228e);
        goto L63
    L38:
        if (r100.f53224a.getTransConfig() == null) goto L63;
        e r120 = r100.f53224a;
        r120.setBackgroundColor(r120.getTransConfig().f53247c);
        View r121 = r100.f53224a.getTransferConfig().f53256l.f564936a;
        if (r121 == null) goto L43;
        r121.setAlpha(255 / 255.0f);
    L43:
        r115.setTranslationX(r105);
        r115.setTranslationY(r106);
        goto L63
    L44:
        VelocityTracker r122 = r100.f53225b;
        if (r122 == null) goto L47;
        r122.addMovement(r110);
        r100.f53225b.computeCurrentVelocity(1000);
    L47:
        e r123 = r100.f53224a;
        if (r123 == null) goto L60;
        BounceBackViewPager r124 = r123.f53267b;
        if (r124 == null) goto L60;
        if (r124.getTranslationY() <= 0.0f) goto L54;
        e r125 = r100.f53224a;
        r125.c(r125.getCurrentPosition());
        goto L60
    L54:
        e r126 = r100.f53224a;
        if (r126 == null) goto L60;
        BounceBackViewPager r127 = r126.f53267b;
        if (r127 == null) goto L60;
        ObjectAnimator r128 = ObjectAnimator.ofFloat(r127, LiveDegradeFpsAnimator.SCALE_X, new float[]{r127.getScaleX(), 1.0f});
        ObjectAnimator r129 = ObjectAnimator.ofFloat(r127, LiveDegradeFpsAnimator.SCALE_Y, new float[]{r127.getScaleX(), 1.0f});
        ObjectAnimator r130 = ObjectAnimator.ofFloat(r127, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r127.getTranslationX(), 0.0f});
        ObjectAnimator r131 = ObjectAnimator.ofFloat(r127, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r127.getTranslationY(), 0.0f});
        AnimatorSet r132 = new AnimatorSet();
        r132.playTogether(new Animator[]{r128, r129, r130, r131});
        r132.start();
    L60:
        r100.f53226c = 0.0f;
        r100.f53227d = 0.0f;
    L63:
        return super.onTouchEvent(r110);
    }

    public void setOnLayoutResetListener(d r100) {
        this.f53270e = r100;
    }

    public static void a(e r100, int r101, int r102) {
        int r103 = r101 - r102;
        int r104 = r102 + r101;
        r100.e(r101);
        Set<Integer> r105 = r100.f53271f;
        HashSet r106 = (HashSet) r105;
        r106.add(Integer.valueOf(r101));
        if (r103 < 0) goto L7;
        Set<Integer> r107 = r100.f53271f;
        HashSet r108 = (HashSet) r107;
        if (r108.contains(Integer.valueOf(r103)) == true) goto L7;
        r100.e(r103);
        Set<Integer> r109 = r100.f53271f;
        HashSet r110 = (HashSet) r109;
        r110.add(Integer.valueOf(r103));
    L7:
        com.bytedance.android.gamecp.business.gallery.transfer.d r111 = r100.f53269d;
        if (r111 == null) goto L17;
        List<String> r112 = r111.f53252h;
        if (r112 != null) goto L12;
        return;
    L12:
        if (r104 >= r112.size()) goto L19;
        Set<Integer> r113 = r100.f53271f;
        HashSet r114 = (HashSet) r113;
        if (r114.contains(Integer.valueOf(r104)) == true) goto L20;
        r100.e(r104);
        Set<Integer> r115 = r100.f53271f;
        HashSet r116 = (HashSet) r115;
        r116.add(Integer.valueOf(r104));
        return;
    L20:
        return;
    L19:
        return;
    }
}
