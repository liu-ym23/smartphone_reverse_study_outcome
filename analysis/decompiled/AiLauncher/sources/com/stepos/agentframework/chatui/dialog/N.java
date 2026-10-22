package com.stepos.agentframework.chatui.dialog;

import Z8.C1172u;
import Z8.C1173v;
import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Selection;
import android.text.Spannable;
import android.view.View;
import android.view.Window;
import android.view.textclassifier.TextClassifier;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.a0;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$layout;
import com.stepos.agentframework.R$style;
import com.stepos.agentframework.chatui.panelui.PanelHomePolicy;
import com.stepos.ame.sdk.SkillStoreKt;
import h8.C4148a;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 52\u00020\u0001:\u00016B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0010J\u0017\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\"\u001a\u00020!2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020!2\u0006\u0010$\u001a\u00020\u0002H\u0002¢\u0006\u0004\b%\u0010&R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010'R\u001c\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010+\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010'R\u0016\u0010.\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00103\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/stepos/agentframework/chatui/dialog/N;", "Landroid/app/Dialog;", "Landroid/content/Context;", "context", "", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Landroid/view/View;", "ownerRoot", "<init>", "(Landroid/content/Context;Ljava/lang/String;Landroid/view/View;)V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "show", "()V", "o", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "F", "Landroid/widget/TextView;", "textView", "v", "(Landroid/widget/TextView;)V", "Landroidx/core/view/a0;", "listenerInsets", "m", "(Landroid/widget/TextView;Landroidx/core/view/a0;)V", "", "s", "(Landroidx/core/view/a0;)I", "u", "()I", "", "n", "(Landroid/view/View;)Z", "ctx", "p", "(Landroid/content/Context;)Z", "Ljava/lang/String;", "Ljava/lang/ref/WeakReference;", "ownerRootRef", "Ljava/lang/ref/WeakReference;", "contentTextView", "Landroid/widget/TextView;", "panelLayerId", "panelTracked", "Z", "Lcom/stepos/agentframework/chatui/panelui/a;", "recentsVisibility", "Lcom/stepos/agentframework/chatui/panelui/a;", "lastWindowInsets", "Landroidx/core/view/a0;", "Companion", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class N extends Dialog {
    private static final int SELECTION_HANDLE_MIN_DP = 48;
    private static final String TAG = "SelectTxtDialog";
    private final String content;
    private TextView contentTextView;
    private a0 lastWindowInsets;
    private final WeakReference<View> ownerRootRef;
    private final String panelLayerId;
    private boolean panelTracked;
    private final com.stepos.agentframework.chatui.panelui.a recentsVisibility;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final LinkedHashSet<N> activeInstances = new LinkedHashSet<>();

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR$\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentframework/chatui/dialog/N$a;", "", "<init>", "()V", "Landroid/view/View;", "ownerRoot", "", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;)Z", "", "TAG", "Ljava/lang/String;", "", "SELECTION_HANDLE_MIN_DP", "I", "Ljava/util/LinkedHashSet;", "Lcom/stepos/agentframework/chatui/dialog/N;", "Lkotlin/collections/LinkedHashSet;", "activeInstances", "Ljava/util/LinkedHashSet;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.dialog.N$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final boolean a(View ownerRoot) {
            Object objB;
            boolean z10 = false;
            for (N n10 : Z8.F.m1(N.activeInstances)) {
                if (n10.isShowing() && n10.n(ownerRoot)) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        n10.o();
                        z10 = true;
                        objB = Result.b(Y8.t.f7040a);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objB = Result.b(C4849c.a(th));
                    }
                    Throwable thE = Result.e(objB);
                    if (thE != null) {
                        C4148a.u(N.TAG, "dismissAllShowingForWake failed: " + thE.getMessage(), false, 4, null);
                    }
                }
            }
            return z10;
        }

        public Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(Context context, String content, View view) {
        super(context, R$style.SelectTxtDialog);
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(content, "content");
        this.content = content;
        this.ownerRootRef = new WeakReference<>(view);
        this.panelLayerId = "select_txt_" + System.identityHashCode(this);
        this.recentsVisibility = new com.stepos.agentframework.chatui.panelui.a(this);
    }

    public static final boolean B(N n10) {
        return n10.isShowing();
    }

    public static final Y8.t C(N n10) {
        n10.dismiss();
        return Y8.t.f7040a;
    }

    public static final boolean D(N n10) {
        return n10.recentsVisibility.b();
    }

    public static final boolean E(N n10) {
        return n10.recentsVisibility.a();
    }

    public static final void q(N n10, View view) {
        n10.dismiss();
    }

    public static final void r(N n10, DialogInterface dialogInterface) {
        n10.F();
        activeInstances.remove(n10);
        n10.contentTextView = null;
        n10.lastWindowInsets = null;
    }

    public static final int t(a0 a0Var) {
        return Math.max(a0Var.f(a0.o.e()).f41980d, a0Var.f(a0.o.i()).f41980d);
    }

    public static final a0 w(N n10, TextView textView, View view, a0 insets) {
        kotlin.jvm.internal.p.i(view, "<unused var>");
        kotlin.jvm.internal.p.i(insets, "insets");
        n10.lastWindowInsets = insets;
        n10.m(textView, insets);
        return insets;
    }

    public static final void x(N n10, TextView textView, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        n10.m(textView, n10.lastWindowInsets);
    }

    public static final void y(N n10, TextView textView) {
        n10.m(textView, n10.lastWindowInsets);
    }

    public static final void z(N n10, TextView textView) {
        n10.m(textView, n10.lastWindowInsets);
    }

    public final void A() {
        if (this.panelTracked) {
            return;
        }
        this.panelTracked = true;
        com.stepos.agentframework.chatui.panelui.f fVar = com.stepos.agentframework.chatui.panelui.f.INSTANCE;
        String str = this.panelLayerId;
        PanelHomePolicy panelHomePolicy = PanelHomePolicy.DISMISS_TOP_ONLY;
        View view = this.ownerRootRef.get();
        fVar.b(str, panelHomePolicy, view != null ? view.getRootView() : null, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.dialog.G
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(N.B(this.f22885a));
            }
        }, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.dialog.H
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return N.C(this.f22886a);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.dialog.I
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(N.D(this.f22887a));
            }
        }, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.dialog.J
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(N.E(this.f22888a));
            }
        });
    }

    public final void F() {
        if (this.panelTracked) {
            this.panelTracked = false;
            com.stepos.agentframework.chatui.panelui.f.INSTANCE.c(this.panelLayerId);
        }
    }

    public final void m(TextView textView, a0 listenerInsets) {
        int iU = u() + s(listenerInsets);
        if (textView.getPaddingBottom() != iU) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), iU);
        }
        int width = textView.getWidth();
        int height = textView.getHeight();
        int paddingBottom = textView.getPaddingBottom();
        textView.setSystemGestureExclusionRects((width <= 0 || height <= 0 || paddingBottom <= 0) ? C1173v.m() : C1172u.e(new Rect(0, C5685n.f(height - paddingBottom, 0), width, height)));
    }

    public final boolean n(View ownerRoot) {
        View view;
        return ownerRoot == null || (view = this.ownerRootRef.get()) == null || view == ownerRoot;
    }

    public final void o() {
        TextView textView = this.contentTextView;
        if (textView != null) {
            textView.cancelLongPress();
            CharSequence text = textView.getText();
            Spannable spannable = text instanceof Spannable ? (Spannable) text : null;
            if (spannable != null) {
                Selection.removeSelection(spannable);
            }
            textView.clearFocus();
        }
        dismiss();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R$layout.dia_select_txt);
        Window window = getWindow();
        if (window != null) {
            Context context = window.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            if (!p(context)) {
                window.setType(2038);
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setGravity(80);
            window.setLayout(-1, (int) (window.getContext().getResources().getDisplayMetrics().heightPixels * 0.6f));
            window.setDimAmount(0.4f);
            window.addFlags(2);
        }
        ImageView imageView = (ImageView) findViewById(R$id.ivClose);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.dialog.E
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    N.q(this.f22883a, view);
                }
            });
        }
        TextView textView = (TextView) findViewById(R$id.tvContent);
        this.contentTextView = textView;
        if (textView != null) {
            textView.setText(this.content);
        }
        if (textView != null) {
            textView.setTextClassifier(TextClassifier.NO_OP);
        }
        if (textView != null) {
            v(textView);
        }
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.stepos.agentframework.chatui.dialog.F
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                N.r(this.f22884a, dialogInterface);
            }
        });
    }

    public final boolean p(Context ctx) {
        while (ctx instanceof ContextWrapper) {
            if (ctx instanceof Activity) {
                return true;
            }
            ctx = ((ContextWrapper) ctx).getBaseContext();
        }
        return false;
    }

    public final int s(a0 listenerInsets) {
        t0.e eVarG;
        View decorView;
        if (listenerInsets != null) {
            Integer numValueOf = Integer.valueOf(t(listenerInsets));
            if (numValueOf.intValue() <= 0) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                return numValueOf.intValue();
            }
        }
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        int i10 = 0;
        if (p(context)) {
            return 0;
        }
        Window window = getWindow();
        a0 a0VarB = (window == null || (decorView = window.getDecorView()) == null) ? null : androidx.core.view.N.B(decorView);
        if (a0VarB != null) {
            Integer numValueOf2 = Integer.valueOf(t(a0VarB));
            Integer num = numValueOf2.intValue() > 0 ? numValueOf2 : null;
            if (num != null) {
                return num.intValue();
            }
        }
        if (a0VarB != null && (eVarG = a0VarB.g(a0.o.e())) != null) {
            i10 = eVarG.f41980d;
        }
        if (i10 > 0) {
            return i10;
        }
        O6.b bVar = O6.b.INSTANCE;
        Context context2 = getContext();
        kotlin.jvm.internal.p.h(context2, "getContext(...)");
        return bVar.a(context2);
    }

    @Override // android.app.Dialog
    public void show() {
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        if (!p(context) && !Settings.canDrawOverlays(getContext())) {
            C4148a.h(TAG, "skip show: no activity token and overlay permission denied, context=" + getContext().getClass().getName(), false, 4, null);
            return;
        }
        super.show();
        if (isShowing()) {
            activeInstances.add(this);
            A();
            final TextView textView = this.contentTextView;
            if (textView != null) {
                androidx.core.view.N.e0(textView);
                textView.post(new Runnable() { // from class: com.stepos.agentframework.chatui.dialog.D
                    @Override // java.lang.Runnable
                    public final void run() {
                        N.z(this.f22881a, textView);
                    }
                });
            }
        }
    }

    public final int u() {
        int i10 = (int) (48 * getContext().getResources().getDisplayMetrics().density);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.textSelectHandleRight});
        kotlin.jvm.internal.p.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
            int intrinsicHeight = drawable != null ? drawable.getIntrinsicHeight() : 0;
            typedArrayObtainStyledAttributes.recycle();
            return Math.max(i10, intrinsicHeight);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void v(final TextView textView) {
        androidx.core.view.N.u0(textView, new androidx.core.view.A() { // from class: com.stepos.agentframework.chatui.dialog.K
            @Override // androidx.core.view.A
            public final a0 a(View view, a0 a0Var) {
                return N.w(this.f22889a, textView, view, a0Var);
            }
        });
        textView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.stepos.agentframework.chatui.dialog.L
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                N.x(this.f22891a, textView, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        });
        androidx.core.view.N.e0(textView);
        textView.post(new Runnable() { // from class: com.stepos.agentframework.chatui.dialog.M
            @Override // java.lang.Runnable
            public final void run() {
                N.y(this.f22893a, textView);
            }
        });
    }
}
