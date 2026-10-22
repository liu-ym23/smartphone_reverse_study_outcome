package com.obric.oui.textswitcher;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.ViewSwitcher;
import java.util.Timer;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.h;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005*\u0001$\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0017\u001a\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/obric/oui/textswitcher/OTextSwitcher;", "Landroid/widget/TextSwitcher;", "Lcom/obric/oui/textswitcher/IOTextSwitcher;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/obric/oui/textswitcher/b;", "spec", "", "build", "(Lcom/obric/oui/textswitcher/b;)V", "startAfterBuild", "()V", "stopAnim", "", "a", "Z", "hadStart", "Landroid/os/Handler;", "b", "Lkotlin/Lazy;", "getMUiHander", "()Landroid/os/Handler;", "mUiHander", "Ljava/util/Timer;", "c", "Ljava/util/Timer;", "mOTextSwitcherTimer", "Landroid/widget/ViewSwitcher$ViewFactory;", "d", "getDefaultViewFactory", "()Landroid/widget/ViewSwitcher$ViewFactory;", "defaultViewFactory", "com/obric/oui/textswitcher/OTextSwitcher$a", "e", "Lcom/obric/oui/textswitcher/OTextSwitcher$a;", "textSwitcherOnAttachStateChangeListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTextSwitcher extends TextSwitcher implements IOTextSwitcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f17351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f17352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Timer f17353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f17354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f17355e;

    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OTextSwitcher f17356a;

        public a(OTextSwitcher r10) {
            this.f17356a = r10;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r10) {
            q.g(r10, "v");
            h.a("the o textview switcher component had attach to window");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r10) {
            q.g(r10, "v");
            h.a("the o textview switcher component had detach to window");
            this.f17356a.stopAnim();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OTextSwitcher(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ b a(OTextSwitcher r10) {
        r10.getClass();
        return null;
    }

    private final ViewSwitcher.ViewFactory getDefaultViewFactory() {
        return (ViewSwitcher.ViewFactory) this.f17354d.getValue();
    }

    private final Handler getMUiHander() {
        return (Handler) this.f17352b.getValue();
    }

    @Override // com.obric.oui.textswitcher.IOTextSwitcher
    public void build(b r10) {
        q.g(r10, "spec");
        if (getChildCount() <= 0) goto L5;
        removeAllViews();
    L5:
        removeOnAttachStateChangeListener(this.f17355e);
        addOnAttachStateChangeListener(this.f17355e);
    }

    @Override // com.obric.oui.textswitcher.IOTextSwitcher
    public void startAfterBuild() {
        new Ref$IntRef();
    }

    @Override // com.obric.oui.textswitcher.IOTextSwitcher
    public void stopAnim() {
        this.f17351a = false;
        clearAnimation();     // Catch: Exception -> L9
        Timer r10 = this.f17353c;     // Catch: Exception -> L9
        if (r10 == null) goto L7;
        r10.cancel();     // Catch: Exception -> L9
    L7:
        this.f17353c = null;     // Catch: Exception -> L9
        Unit r11 = Unit.f21064a;     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        h.a(q.p("Try exception occur ", e.getMessage()));
        Unit r12 = Unit.f21064a;
    }

    public /* synthetic */ OTextSwitcher(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public OTextSwitcher(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        this.f17352b = kotlin.b.b(OTextSwitcher$mUiHander$2.INSTANCE);
        this.f17354d = kotlin.b.b(new OTextSwitcher$defaultViewFactory$2(r10, this));
        this.f17355e = new a(this);
    }
}
