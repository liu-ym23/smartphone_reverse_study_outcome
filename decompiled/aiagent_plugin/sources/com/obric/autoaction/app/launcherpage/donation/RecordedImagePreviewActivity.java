package com.obric.autoaction.app.launcherpage.donation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.q;
import com.obric.autoaction.app.launcherpage.a.al;
import com.obric.autoaction.app.launcherpage.a.ay;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.oui.banner.OBanner;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: RecordedImagePreviewActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RecordedImagePreviewActivity extends AppCompatActivity {
    public static final c Companion = null;
    public static final String KEY_START_INDEX = "start_index";
    private static WeakReference<List<com.obric.autoaction.app.launcherpage.donation.model.c>> screenOperationsRef;
    private ay binding;
    private final List<com.obric.autoaction.app.launcherpage.donation.model.c> screenOperations;
    private int startIndex;

    /* JADX INFO: compiled from: RecordedImagePreviewActivity.kt */
    public static final class a implements com.obric.oui.banner.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autoaction.app.launcherpage.donation.model.c f23695a;

        public a(com.obric.autoaction.app.launcherpage.donation.model.c r2) {
            o.e(r2, "screenOperation");
            this.f23695a = r2;
        }

        public final com.obric.autoaction.app.launcherpage.donation.model.c a() {
            return this.f23695a;
        }

        @Override // com.obric.oui.banner.b
        public String b() {
            return b.r.a();
        }
    }

    /* JADX INFO: compiled from: RecordedImagePreviewActivity.kt */
    public static final class b extends com.obric.oui.banner.d {
        public static final a r = null;

        /* JADX INFO: compiled from: RecordedImagePreviewActivity.kt */
        public static final class a implements com.obric.oui.banner.f {
            public /* synthetic */ a(d.h.b.h r1) {
                this();
            }

            @Override // com.obric.oui.banner.f
            public String a() {
                return "image_view";
            }

            private a() {
            }

            @Override // com.obric.oui.banner.f
            public com.obric.oui.banner.d a(ViewGroup r3) {
                o.e(r3, "parent");
                al r2 = al.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r3, false);
                o.c(r2, "inflate(...)");
                RelativeLayout r4 = r2.b();
                o.c(r4, "getRoot(...)");
                return (com.obric.oui.banner.d) ZeusTransformUtils.preCheckCast(new b((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin")), com.obric.oui.banner.d.class, "com.obric.aiagent.plugin");
            }
        }

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.donation.RecordedImagePreviewActivity$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: RecordedImagePreviewActivity.kt */
        public static final class C0529b implements com.bumptech.glide.request.g<Bitmap> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f23696a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ al f23697b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ b f23698c;

            public static /* synthetic */ void lambda$zqvKJOKAbr9L_dxflniUlo4JqY0(Bitmap r0, al r1, b r2) {
                a(r0, r1, r2);
            }

            C0529b(String r1, al r2, b r3) {
                this.f23696a = r1;
                this.f23697b = r2;
                this.f23698c = r3;
            }

            @Override // com.bumptech.glide.request.g
            public /* synthetic */ boolean a(Bitmap r9, Object r10, com.bumptech.glide.request.target.i<Bitmap> r11, com.bumptech.glide.load.a r12, boolean r13) {
                com.bumptech.glide.request.target.i<Bitmap> r5 = (com.bumptech.glide.request.target.i) ZeusTransformUtils.wrapperContextForParams(r11, com.bumptech.glide.request.target.i.class, "com.obric.aiagent.plugin");
                return a2((Bitmap) ZeusTransformUtils.preCheckCast(r9, Bitmap.class, "com.obric.aiagent.plugin"), r10, r5, r12, r13);
            }

            @Override // com.bumptech.glide.request.g
            public boolean a(q r1, Object r2, com.bumptech.glide.request.target.i<Bitmap> r3, boolean r4) {
                com.bumptech.glide.request.target.i r5 = (com.bumptech.glide.request.target.i) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.target.i.class, "com.obric.aiagent.plugin");
                Loog.INSTANCE.e("BannerImageViewViewHolder", "load image failed, url: " + this.f23696a);
                return true;
            }

            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
            public boolean a2(final Bitmap r1, Object r2, com.bumptech.glide.request.target.i<Bitmap> r3, com.bumptech.glide.load.a r4, boolean r5) {
                com.bumptech.glide.request.target.i r6 = (com.bumptech.glide.request.target.i) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.target.i.class, "com.obric.aiagent.plugin");
                ImageView r7 = this.f23697b.f22749a;
                final al r8 = this.f23697b;
                final b r0 = this.f23698c;
                r7.post(new $$Lambda$RecordedImagePreviewActivity$b$b$zqvKJOKAbr9L_dxflniUlo4JqY0(r1, r8, r0));
                return true;
            }

            private static final void a(Bitmap r2, al r3, b r4) {
                if (r2 != null) goto L4;
                return;
            L4:
                if (r2.getWidth() <= r2.getHeight()) goto L6;
                r3.f22749a.setImageBitmap(b.a(r4, r2));
                return;
            L6:
                r3.f22749a.setImageBitmap(r2);
            }
        }

        static {
            r = new a(null);
        }

        /* JADX INFO: renamed from: lambda$x-exIno3qeDRjl236-E45Y6vt7c, reason: not valid java name */
        public static /* synthetic */ void m503lambda$xexIno3qeDRjl236E45Y6vt7c(al r0, View r1) {
            a(r0, r1);
        }

        public b(View r2) {
            o.e(r2, "view");
            super(r2);
        }

        public static final /* synthetic */ Bitmap a(b r0, Bitmap r1) {
            return r0.a(r1);
        }

        @Override // com.obric.oui.banner.d
        public void a(com.obric.oui.banner.b r11) {
            com.obric.oui.banner.b r12 = (com.obric.oui.banner.b) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.oui.banner.b.class, "com.obric.aiagent.plugin");
            o.e(r12, "data");
            final al r0 = al.a(this.f2390a);
            o.c(r0, "bind(...)");
            com.obric.autoaction.app.launcherpage.donation.model.c r2 = ((a) ZeusTransformUtils.preCheckCast(r12, a.class, "com.obric.aiagent.plugin")).a();
            Bitmap r3 = r2.b();
            if (r3 != null) goto L5;
        L8:
            String r13 = ((a) ZeusTransformUtils.preCheckCast(r12, a.class, "com.obric.aiagent.plugin")).a().c();
            if (r13 != null) goto L11;
        L19:
            r0.f22749a.setOnClickListener(new $$Lambda$RecordedImagePreviewActivity$b$xexIno3qeDRjl236E45Y6vt7c(r0));
            r0.f22750b.setText((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r2.a()), CharSequence.class, "com.obric.aiagent.plugin"));
            return;
        L11:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L13;
            boolean r4 = true;
        L14:
            if (r4 == true) goto L17;
            r13 = null;
        L17:
            if (r13 == null) goto L19;
            Glide.with((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f2390a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).clear((View) ZeusTransformUtils.preCheckCast(r0.f22749a, View.class, "com.obric.aiagent.plugin"));
            Glide.with((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f2390a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).asBitmap().a(r13).a((com.bumptech.glide.request.g) ZeusTransformUtils.preCheckCast(new C0529b(r13, r0, this), com.bumptech.glide.request.g.class, "com.obric.aiagent.plugin")).b();
            goto L19
        L13:
            r4 = false;
            goto L14
        L5:
            if (r3.getWidth() <= r3.getHeight()) goto L7;
            Matrix r8 = new Matrix();
            r8.postRotate(90.0f);
            Bitmap r5 = Bitmap.createBitmap(r3, 0, 0, r3.getWidth(), r3.getHeight(), r8, true);
            o.c(r5, "createBitmap(...)");
            r0.f22749a.setImageBitmap(r5);
            goto L8
        L7:
            r0.f22749a.setImageBitmap(r3);
            goto L8
        }

        private static final void a(al r1, View r2) {
            Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.f22749a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r3, Activity.class) == false) goto L5;
            Activity r4 = (Activity) ZeusTransformUtils.preCheckCast(r3, Activity.class, "com.obric.aiagent.plugin");
        L6:
            if (r4 == null) goto L9;
            r4.finish();
            return;
        L9:
            return;
        L5:
            r4 = null;
            goto L6
        }

        private final Bitmap a(Bitmap r8) {
            if (r8 == null) goto L4;
            Matrix r5 = new Matrix();
            r5.postRotate(90.0f);
            return Bitmap.createBitmap(r8, 0, 0, r8.getWidth(), r8.getHeight(), r5, true);
        L4:
            return null;
        }
    }

    /* JADX INFO: compiled from: RecordedImagePreviewActivity.kt */
    public static final class c {
        public /* synthetic */ c(d.h.b.h r1) {
            this();
        }

        private c() {
        }

        public final void a(Context r2, List<com.obric.autoaction.app.launcherpage.donation.model.c> r3, int r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            o.e(r1, "context");
            o.e(r5, "screenOperations");
            RecordedImagePreviewActivity.access$setScreenOperationsRef$cp(new WeakReference(r5));
            Intent r6 = new Intent(r1, RecordedImagePreviewActivity.class);
            if (ZeusTransformUtils.instanceOf(r1, Activity.class) == true) goto L5;
            r6.addFlags(268435456);
        L5:
            r6.putExtra(RecordedImagePreviewActivity.KEY_START_INDEX, r4);
            ZeusTransformUtils.startActivity(r1, r6, "com.obric.aiagent.plugin");
        }
    }

    static {
        Companion = new c(null);
    }

    public RecordedImagePreviewActivity() {
        this.screenOperations = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void access$setScreenOperationsRef$cp(WeakReference r0) {
        screenOperationsRef = r0;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        this.startIndex = getIntent().getIntExtra(KEY_START_INDEX, 0);
        ay r5 = ay.a(getLayoutInflater());
        o.c(r5, "inflate(...)");
        this.binding = r5;
        if (r5 != null) goto L5;
        o.c("binding");
        r5 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r5.b(), View.class, "com.obric.aiagent.plugin"));
        com.gyf.immersionbar.g.a((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.aiagent.plugin")).a(com.gyf.immersionbar.b.f13828c).a();
        WeakReference<List<com.obric.autoaction.app.launcherpage.donation.model.c>> r6 = screenOperationsRef;
        if (r6 == null) goto L15;
        List r7 = (List) ZeusTransformUtils.preCheckCast(r6.get(), List.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L15;
        if (r7.isEmpty() == false) goto L13;
        finish();
        return;
    L13:
        this.screenOperations.addAll((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin"));
        initView();
        return;
    L15:
        ((RecordedImagePreviewActivity) ZeusTransformUtils.preCheckCast(this, RecordedImagePreviewActivity.class, "com.obric.aiagent.plugin")).finish();
    }

    private final void initView() {
        if (this.screenOperations.isEmpty() == false) goto L5;
        return;
    L5:
        ay r0 = this.binding;
        if (r0 != null) goto L8;
        o.c("binding");
        r0 = null;
    L8:
        OBanner r1 = r0.f22797a;
        r1.registerViewHolder((com.obric.oui.banner.f) ZeusTransformUtils.preCheckCast(b.r, com.obric.oui.banner.f.class, "com.obric.aiagent.plugin"));
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(this.screenOperations, Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r4 = r2.iterator();
    L9:
        boolean r5 = true;
        if (r4.hasNext() == false) goto L25;
        Object r6 = r4.next();
        com.obric.autoaction.app.launcherpage.donation.model.c r7 = (com.obric.autoaction.app.launcherpage.donation.model.c) ZeusTransformUtils.preCheckCast(r6, com.obric.autoaction.app.launcherpage.donation.model.c.class, "com.obric.aiagent.plugin");
        if (r7.b() != null) goto L23;
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r7.c(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L16;
    L19:
        boolean r9 = true;
    L20:
        if (r9 == false) goto L23;
        r5 = false;
        goto L23
    L16:
        if (r8.length() == 0) goto L19;
        r9 = false;
    L23:
        if (r5 == false) goto L9;
        r3.add(r6);
        goto L9
    L25:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r10, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r10.iterator();
    L27:
        if (r12.hasNext() == false) goto L29;
        r11.add(new a((com.obric.autoaction.app.launcherpage.donation.model.c) ZeusTransformUtils.preCheckCast(r12.next(), com.obric.autoaction.app.launcherpage.donation.model.c.class, "com.obric.aiagent.plugin")));
        goto L27
    L29:
        r1.setData((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin"));
        r1.initViewPager2();
        r1.setInfiniteSwitchEnabled(false);
        int r13 = this.startIndex;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(p.c((Iterable) ZeusTransformUtils.preCheckCast(this.screenOperations, Iterable.class, "com.obric.aiagent.plugin"), this.startIndex + 1), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, Collection.class) == true) goto L32;
    L34:
        Iterator r15 = r14.iterator();
        int r16 = 0;
    L36:
        if (r15.hasNext() == false) goto L53;
        com.obric.autoaction.app.launcherpage.donation.model.c r17 = (com.obric.autoaction.app.launcherpage.donation.model.c) ZeusTransformUtils.preCheckCast(r15.next(), com.obric.autoaction.app.launcherpage.donation.model.c.class, "com.obric.aiagent.plugin");
        if (r17.b() != null) goto L48;
        CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(r17.c(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r18 != null) goto L42;
    L45:
        boolean r19 = true;
    L46:
        if (r19 == false) goto L48;
        boolean r20 = true;
    L49:
        if (r20 == false) goto L36;
        r16 = r16 + 1;
        if (r16 >= 0) goto L36;
        p.d();
        goto L36
    L42:
        if (r18.length() == 0) goto L45;
        r19 = false;
    L48:
        r20 = false;
    L53:
        r1.getViewPager2().setCurrentItem(Math.max(0, r13 - r16), false);
        return;
    L32:
        if (((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L34;
        r16 = 0;
        goto L53
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        ay r0 = this.binding;
        if (r0 == null) goto L8;
        if (r0 != null) goto L6;
        o.c("binding");
        r0 = null;
    L6:
        r0.f22797a.release();
        return;
    }
}
