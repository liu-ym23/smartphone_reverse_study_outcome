package com.stepos.ailauncher.chat.view;

import A1.g;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import coil.a;
import coil.c;
import coil.decode.i;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a3\u0010\r\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e\u001a\u0013\u0010\u000f\u001a\u00020\u0006*\u00020\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u0004*\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\"\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019\"\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Landroid/widget/ImageView;", "imageView", "Landroid/widget/TextView;", "charView", "", "iconUrl", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/widget/ImageView;Landroid/widget/TextView;Ljava/lang/String;)V", "", "fallbackRes", "", "circleCrop", Const.INTENT_KEY_PKGNAME, "(Landroid/widget/ImageView;Ljava/lang/String;IZ)V", Const.INTENT_KEY_UMID, "(Landroid/widget/ImageView;)V", "e", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/content/Context;", "context", "Lcoil/c;", "f", "(Landroid/content/Context;)Lcoil/c;", "TAG", "Ljava/lang/String;", "svgLoader", "Lcoil/c;", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.a9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2765a9 {
    private static final String TAG = "StoreIcon";
    private static volatile coil.c svgLoader;

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/stepos/ailauncher/chat/view/a9$a", "LA1/g$b;", "LA1/g;", "request", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(LA1/g;)V", Const.INTENT_KEY_APIKEY, "LA1/e;", "result", Const.INTENT_KEY_UMID, "(LA1/g;LA1/e;)V", "LA1/o;", "c", "(LA1/g;LA1/o;)V", "coil-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.a9$a */
    public static final class a implements g.b {
        final /* synthetic */ TextView $charView$inlined;
        final /* synthetic */ TextView $charView$inlined$1;
        final /* synthetic */ ImageView $imageView$inlined;
        final /* synthetic */ String $url$inlined;

        public a(String str, ImageView imageView, TextView textView, TextView textView2) {
            this.$url$inlined = str;
            this.$imageView$inlined = imageView;
            this.$charView$inlined = textView;
            this.$charView$inlined$1 = textView2;
        }

        @Override // A1.g.b
        public void a(A1.g request) {
        }

        @Override // A1.g.b
        public void b(A1.g request) {
        }

        @Override // A1.g.b
        public void c(A1.g request, A1.o result) {
            this.$charView$inlined$1.setVisibility(8);
        }

        @Override // A1.g.b
        public void d(A1.g request, A1.e result) {
            C4148a.t(C2765a9.TAG, "icon failed (char slot) " + this.$url$inlined, result.getThrowable(), false, 8, null);
            this.$imageView$inlined.setImageDrawable(null);
            this.$charView$inlined.setVisibility(0);
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/stepos/ailauncher/chat/view/a9$b", "LA1/g$b;", "LA1/g;", "request", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(LA1/g;)V", Const.INTENT_KEY_APIKEY, "LA1/e;", "result", Const.INTENT_KEY_UMID, "(LA1/g;LA1/e;)V", "LA1/o;", "c", "(LA1/g;LA1/o;)V", "coil-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.a9$b */
    public static final class b implements g.b {
        final /* synthetic */ String $url$inlined;
        final /* synthetic */ String $url$inlined$1;

        public b(String str, String str2) {
            this.$url$inlined = str;
            this.$url$inlined$1 = str2;
        }

        @Override // A1.g.b
        public void a(A1.g request) {
        }

        @Override // A1.g.b
        public void b(A1.g request) {
        }

        @Override // A1.g.b
        public void c(A1.g request, A1.o result) {
            C4148a.d(C2765a9.TAG, "icon loaded (default slot) " + this.$url$inlined$1, false, 4, null);
        }

        @Override // A1.g.b
        public void d(A1.g request, A1.e result) {
            C4148a.t(C2765a9.TAG, "icon failed (default slot) " + this.$url$inlined, result.getThrowable(), false, 8, null);
        }
    }

    public static final void a(ImageView imageView, TextView charView, String str) {
        kotlin.jvm.internal.p.i(imageView, "imageView");
        kotlin.jvm.internal.p.i(charView, "charView");
        String strE = e(str);
        imageView.setVisibility(0);
        imageView.setImageDrawable(null);
        charView.setVisibility(0);
        if (strE == null) {
            d(imageView);
            return;
        }
        Context context = imageView.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        coil.c cVarF = f(context);
        g.a aVarR = new g.a(imageView.getContext()).d(strE).r(imageView);
        aVarR.t(new D1.a());
        aVarR.h(new a(strE, imageView, charView, charView));
        cVarF.c(aVarR.c());
    }

    public static final void b(ImageView imageView, String str, int i10, boolean z10) {
        kotlin.jvm.internal.p.i(imageView, "imageView");
        String strE = e(str);
        if (strE == null) {
            d(imageView);
            imageView.setImageResource(i10);
            return;
        }
        Context context = imageView.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        coil.c cVarF = f(context);
        g.a aVarR = new g.a(imageView.getContext()).d(strE).r(imageView);
        aVarR.k(i10);
        aVarR.g(i10);
        if (z10) {
            aVarR.t(new D1.a());
        }
        aVarR.h(new b(strE, strE));
        cVarF.c(aVarR.c());
    }

    public static /* synthetic */ void c(ImageView imageView, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z10 = true;
        }
        b(imageView, str, i10, z10);
    }

    public static final void d(ImageView imageView) {
        F1.k.a(imageView);
    }

    public static final String e(String str) {
        String string;
        if (str == null || (string = La.H.D1(str).toString()) == null || !La.D.V(string, "http", true)) {
            return null;
        }
        return string;
    }

    public static final coil.c f(Context context) {
        coil.c cVarE;
        coil.c cVar = svgLoader;
        if (cVar != null) {
            return cVar;
        }
        synchronized (coil.c.class) {
            cVarE = svgLoader;
            if (cVarE == null) {
                Context applicationContext = context.getApplicationContext();
                kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
                c.a aVarD = new c.a(applicationContext).d(false);
                a.C0194a c0194a = new a.C0194a();
                c0194a.a(new i.b(false, 1, null));
                cVarE = aVarD.i(c0194a.e()).e();
                svgLoader = cVarE;
            }
        }
        return cVarE;
    }
}
