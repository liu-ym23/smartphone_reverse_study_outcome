package com.stepos.ailauncher.migu.play;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.migu.music.ipc.sdk.R$string;
import com.stepos.ailauncher.foundation.R$drawable;
import com.stepos.ailauncher.foundation.appstore.AppDetailRepository;
import com.stepos.ailauncher.foundation.appstore.api.AppDetail;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.migu.play.g0;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import io.ktor.http.ContentDisposition;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0006X\u0086D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/migu/play/g0;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/migu/play/g0$a;", "c", "(Landroid/content/Context;)Lcom/stepos/ailauncher/migu/play/g0$a;", "", "PACKAGE_NAME", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "", "COLOR_CARD_BG", "I", "COLOR_SUBTITLE", "COLOR_BTN_TEXT", Const.INTENT_KEY_APIKEY, "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class g0 {
    public static final g0 INSTANCE = new g0();
    private static final String PACKAGE_NAME = "cmccwm.mobilemusic";
    private static final int COLOR_CARD_BG = Color.parseColor("#2C2C2E");
    private static final int COLOR_SUBTITLE = Color.argb(128, 255, 255, 255);
    private static final int COLOR_BTN_TEXT = Color.argb(230, 0, 0, 0);

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001BQ\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010!\u001a\u00020\u00152\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00150\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00150\u001e¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010%R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010&R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010'R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010'R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010'R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010(R\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010'R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010)R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010*R\u0016\u0010+\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/stepos/ailauncher/migu/play/g0$a;", "", "Landroid/view/View;", Parameters.ROOT, "Landroid/widget/ImageView;", "logo", "Landroid/widget/TextView;", "title", ContentDisposition.Parameters.Size, "publisher", "Landroid/widget/FrameLayout;", "actionHost", "labelButton", "Lcom/stepos/ailauncher/migu/play/r;", "progressRing", "", "fallbackPublisher", "<init>", "(Landroid/view/View;Landroid/widget/ImageView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/FrameLayout;Landroid/widget/TextView;Lcom/stepos/ailauncher/migu/play/r;Ljava/lang/String;)V", "Lcom/stepos/ailauncher/foundation/appstore/api/AppDetail;", "detail", "LY8/t;", "c", "(Lcom/stepos/ailauncher/foundation/appstore/api/AppDetail;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "()V", "Lcom/stepos/ailauncher/migu/play/MiguCardSurface;", "surface", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/migu/play/MiguCardSurface;)V", "Lkotlin/Function0;", "onInstall", "onOpen", "e", "(Lp9/a;Lp9/a;)V", "Landroid/view/View;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Landroid/view/View;", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "Landroid/widget/FrameLayout;", "Lcom/stepos/ailauncher/migu/play/r;", "Ljava/lang/String;", "mode", "Lcom/stepos/ailauncher/migu/play/MiguCardSurface;", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        private final FrameLayout actionHost;
        private final String fallbackPublisher;
        private final TextView labelButton;
        private final ImageView logo;
        private MiguCardSurface mode;
        private final r progressRing;
        private final TextView publisher;
        private final View root;
        private final TextView size;
        private final TextView title;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.migu.play.g0$a$a, reason: collision with other inner class name */
        public static final /* synthetic */ class C0320a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[MiguCardSurface.values().length];
                try {
                    iArr[MiguCardSurface.DOWNLOADING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[MiguCardSurface.DONE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[MiguCardSurface.INSTALL.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public a(View root, ImageView logo, TextView title, TextView size, TextView publisher, FrameLayout actionHost, TextView labelButton, r progressRing, String fallbackPublisher) {
            kotlin.jvm.internal.p.i(root, "root");
            kotlin.jvm.internal.p.i(logo, "logo");
            kotlin.jvm.internal.p.i(title, "title");
            kotlin.jvm.internal.p.i(size, "size");
            kotlin.jvm.internal.p.i(publisher, "publisher");
            kotlin.jvm.internal.p.i(actionHost, "actionHost");
            kotlin.jvm.internal.p.i(labelButton, "labelButton");
            kotlin.jvm.internal.p.i(progressRing, "progressRing");
            kotlin.jvm.internal.p.i(fallbackPublisher, "fallbackPublisher");
            this.root = root;
            this.logo = logo;
            this.title = title;
            this.size = size;
            this.publisher = publisher;
            this.actionHost = actionHost;
            this.labelButton = labelButton;
            this.progressRing = progressRing;
            this.fallbackPublisher = fallbackPublisher;
            this.mode = MiguCardSurface.INSTALL;
        }

        public static final void f(a aVar, InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2, View view) {
            int i10 = C0320a.$EnumSwitchMapping$0[aVar.mode.ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    interfaceC5063a.invoke();
                    return;
                } else if (i10 != 3) {
                    return;
                }
            }
            interfaceC5063a2.invoke();
        }

        public static final Y8.t h(a aVar, AppDetail appDetail) {
            if (aVar.root.isAttachedToWindow()) {
                aVar.c(appDetail);
            }
            return Y8.t.f7040a;
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x004e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void c(com.stepos.ailauncher.foundation.appstore.api.AppDetail r5) {
            /*
                r4 = this;
                if (r5 != 0) goto L3
                return
            L3:
                java.lang.String r0 = r5.getName()
                r1 = 0
                if (r0 == 0) goto L19
                boolean r2 = La.H.x0(r0)
                if (r2 != 0) goto L11
                goto L12
            L11:
                r0 = r1
            L12:
                if (r0 == 0) goto L19
                android.widget.TextView r2 = r4.title
                r2.setText(r0)
            L19:
                java.lang.String r0 = r5.getSizeText()
                if (r0 == 0) goto L26
                boolean r2 = La.H.x0(r0)
                if (r2 != 0) goto L26
                goto L27
            L26:
                r0 = r1
            L27:
                if (r0 != 0) goto L31
                android.widget.TextView r0 = r4.size
                r2 = 8
                r0.setVisibility(r2)
                goto L3c
            L31:
                android.widget.TextView r2 = r4.size
                r3 = 0
                r2.setVisibility(r3)
                android.widget.TextView r2 = r4.size
                r2.setText(r0)
            L3c:
                android.widget.TextView r0 = r4.publisher
                java.lang.String r5 = r5.getPublisher()
                if (r5 == 0) goto L4e
                boolean r2 = La.H.x0(r5)
                if (r2 != 0) goto L4b
                r1 = r5
            L4b:
                if (r1 == 0) goto L4e
                goto L50
            L4e:
                java.lang.String r1 = r4.fallbackPublisher
            L50:
                r0.setText(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.migu.play.g0.a.c(com.stepos.ailauncher.foundation.appstore.api.AppDetail):void");
        }

        public final void d(MiguCardSurface surface) {
            kotlin.jvm.internal.p.i(surface, "surface");
            this.mode = surface;
            int i10 = C0320a.$EnumSwitchMapping$0[surface.ordinal()];
            if (i10 == 1) {
                this.labelButton.setVisibility(8);
                this.progressRing.setVisibility(0);
                this.progressRing.setProgress(MiguInstallState.INSTANCE.g());
                this.actionHost.setClickable(true);
                this.actionHost.setContentDescription("下载中");
            } else if (i10 == 2) {
                this.progressRing.setVisibility(8);
                this.labelButton.setVisibility(0);
                this.labelButton.setText("打开");
                this.actionHost.setContentDescription("打开");
            } else if (i10 == 3) {
                this.progressRing.setVisibility(8);
                this.labelButton.setVisibility(0);
                this.labelButton.setText("安装");
                this.actionHost.setContentDescription("安装");
            }
            R5.b.INSTANCE.c("music.storeGuide.mode", Y8.j.a("surface", surface.name()), Y8.j.a("progress", MiguInstallState.INSTANCE.g()));
        }

        public final void e(final InterfaceC5063a<Y8.t> onInstall, final InterfaceC5063a<Y8.t> onOpen) {
            kotlin.jvm.internal.p.i(onInstall, "onInstall");
            kotlin.jvm.internal.p.i(onOpen, "onOpen");
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.stepos.ailauncher.migu.play.e0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g0.a.f(this.f27513a, onOpen, onInstall, view);
                }
            };
            this.actionHost.setOnClickListener(onClickListener);
            this.labelButton.setOnClickListener(onClickListener);
        }

        public final void g() {
            AppDetailRepository appDetailRepository = AppDetailRepository.INSTANCE;
            g0 g0Var = g0.INSTANCE;
            AppDetail appDetailP = appDetailRepository.p(g0Var.f());
            if (appDetailP != null) {
                c(appDetailP);
            }
            appDetailRepository.i(g0Var.f(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.migu.play.f0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return g0.a.h(this.f27516a, (AppDetail) obj);
                }
            });
        }

        /* renamed from: i, reason: from getter */
        public final View getRoot() {
            return this.root;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/migu/play/g0$b", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends ViewOutlineProvider {
        final /* synthetic */ Context $context;

        public b(Context context) {
            this.$context = context;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), g0.d(this.$context, 10.0f));
        }
    }

    public static final int d(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static final void e(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        view.invalidateOutline();
    }

    public final a c(Context context) {
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(context.getString(R$string.dialog_app_developer_label));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.e(objB) != null) {
            objB = "中国移动";
        }
        kotlin.jvm.internal.p.h(objB, "getOrElse(...)");
        String str = (String) objB;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R$drawable.ic_card_didi_app_store);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(d(context, 16.0f), d(context, 16.0f)));
        linearLayout.addView(imageView);
        TextView textView = new TextView(context);
        textView.setText(DidiCardProvider.DEFAULT_STORE_NAME);
        textView.setTextColor(-1);
        textView.setTextSize(2, 13.0f);
        textView.setMaxLines(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginStart(d(context, 4.0f));
        textView.setLayoutParams(layoutParams);
        linearLayout.addView(textView);
        ImageView imageView2 = new ImageView(context);
        imageView2.setImageResource(com.stepos.ailauncher.migu.R$drawable.ic_migu_login_app);
        imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView2.setLayoutParams(new LinearLayout.LayoutParams(d(context, 56.0f), d(context, 56.0f)));
        imageView2.setClipToOutline(true);
        imageView2.setOutlineProvider(new b(context));
        imageView2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.migu.play.d0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                g0.e(view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        });
        TextView textView2 = new TextView(context);
        textView2.setText("咪咕音乐");
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 16.0f);
        textView2.setTypeface(textView2.getTypeface(), 1);
        textView2.setMaxLines(1);
        TextView textView3 = new TextView(context);
        textView3.setVisibility(8);
        int i10 = COLOR_SUBTITLE;
        textView3.setTextColor(i10);
        textView3.setTextSize(2, 12.0f);
        textView3.setMaxLines(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = d(context, 2.0f);
        textView3.setLayoutParams(layoutParams2);
        TextView textView4 = new TextView(context);
        textView4.setText(str);
        textView4.setTextColor(i10);
        textView4.setTextSize(2, 12.0f);
        textView4.setMaxLines(1);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(16);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams3.setMarginStart(d(context, 8.0f));
        linearLayout2.setLayoutParams(layoutParams3);
        linearLayout2.addView(textView2);
        linearLayout2.addView(textView3);
        linearLayout2.addView(textView4);
        TextView textView5 = new TextView(context);
        textView5.setText("安装");
        textView5.setGravity(17);
        textView5.setTextColor(COLOR_BTN_TEXT);
        textView5.setTextSize(2, 15.0f);
        textView5.setTypeface(textView5.getTypeface(), 1);
        textView5.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r rVar = new r(context, null, 2, null);
        rVar.setVisibility(8);
        rVar.setLayoutParams(new FrameLayout.LayoutParams(d(context, 20.0f), d(context, 20.0f), 17));
        FrameLayout frameLayout = new FrameLayout(context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(d(context, 1000.0f));
        gradientDrawable.setColor(-1);
        frameLayout.setBackground(gradientDrawable);
        frameLayout.setMinimumWidth(d(context, 70.0f));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(d(context, 70.0f), d(context, 38.0f));
        layoutParams4.setMarginStart(d(context, 12.0f));
        frameLayout.setLayoutParams(layoutParams4);
        frameLayout.setClickable(true);
        frameLayout.setFocusable(true);
        frameLayout.addView(textView5);
        frameLayout.addView(rVar);
        LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(16);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams5.topMargin = d(context, 12.0f);
        linearLayout3.setLayoutParams(layoutParams5);
        linearLayout3.addView(imageView2);
        linearLayout3.addView(linearLayout2);
        linearLayout3.addView(frameLayout);
        LinearLayout linearLayout4 = new LinearLayout(context);
        linearLayout4.setOrientation(1);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius(d(context, 20.0f));
        gradientDrawable2.setColor(COLOR_CARD_BG);
        linearLayout4.setBackground(gradientDrawable2);
        linearLayout4.setPadding(d(context, 16.0f), d(context, 16.0f), d(context, 16.0f), d(context, 16.0f));
        linearLayout4.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        linearLayout4.addView(linearLayout);
        linearLayout4.addView(linearLayout3);
        a aVar = new a(linearLayout4, imageView2, textView2, textView3, textView4, frameLayout, textView5, rVar, str);
        AppDetail appDetailP = AppDetailRepository.INSTANCE.p(PACKAGE_NAME);
        if (appDetailP != null) {
            aVar.c(appDetailP);
        }
        return aVar;
    }

    public final String f() {
        return PACKAGE_NAME;
    }
}
