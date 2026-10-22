package com.stepos.agentframework.floatcard.view;

import E4.FloatCardRequest;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import b.AbstractC1417G;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.floatcard.R$color;
import com.stepos.agentframework.floatcard.R$dimen;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0006*\u0001\u001f\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00062\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0011\u0010\u0003J\u0019\u0010\u0012\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0012\u0010\fR\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/stepos/agentframework/floatcard/view/FloatCardActivity;", "Landroidx/appcompat/app/d;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "Lkotlin/Function0;", "onEnd", "v", "(Lp9/a;)V", "onDestroy", "u", "Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;", "container", "Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;", "", "cardId", "Ljava/lang/String;", "", "dismissing", "Z", "", "dismissToken", "I", "com/stepos/agentframework/floatcard/view/FloatCardActivity$b", "dispatcher", "Lcom/stepos/agentframework/floatcard/view/FloatCardActivity$b;", "Companion", Const.INTENT_KEY_APIKEY, "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FloatCardActivity extends androidx.appcompat.app.d {
    public static final String EXTRA_CARD_ID = "float_card_id";
    private FloatCardContainerView container;
    private int dismissToken;
    private boolean dismissing;
    private String cardId = "";
    private final b dispatcher = new b();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/agentframework/floatcard/view/FloatCardActivity$b", "LE4/q;", "LE4/d;", "event", "LY8/t;", Const.INTENT_KEY_APIKEY, "(LE4/d;)V", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements E4.q {
        public b() {
        }

        @Override // E4.q
        public void a(E4.d event) {
            kotlin.jvm.internal.p.i(event, "event");
            com.stepos.agentframework.floatcard.ext.d.INSTANCE.c(FloatCardActivity.this.cardId, event);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/agentframework/floatcard/view/FloatCardActivity$c", "Lb/G;", "LY8/t;", "handleOnBackPressed", "()V", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends AbstractC1417G {
        public c() {
            super(true);
        }

        @Override // b.AbstractC1417G
        public void handleOnBackPressed() {
            FloatCardActivity.this.v(null);
        }
    }

    public static final Y8.t w(int i10, FloatCardActivity floatCardActivity, InterfaceC5063a interfaceC5063a) {
        if (i10 != floatCardActivity.dismissToken) {
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
            return Y8.t.f7040a;
        }
        floatCardActivity.finish();
        floatCardActivity.overridePendingTransition(0, 0);
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        return Y8.t.f7040a;
    }

    public static final void x(FloatCardActivity floatCardActivity, View view) {
        floatCardActivity.v(null);
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) throws Resources.NotFoundException {
        super.onCreate(savedInstanceState);
        FloatCardContainerView floatCardContainerView = new FloatCardContainerView(this, null, 0, 6, null);
        this.container = floatCardContainerView;
        setContentView(floatCardContainerView, new FrameLayout.LayoutParams(-1, -1));
        FloatCardContainerView floatCardContainerView2 = this.container;
        if (floatCardContainerView2 == null) {
            kotlin.jvm.internal.p.A("container");
            floatCardContainerView2 = null;
        }
        floatCardContainerView2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.floatcard.view.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatCardActivity.x(this.f23290a, view);
            }
        });
        getOnBackPressedDispatcher().m(this, new c());
        u(getIntent());
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        com.stepos.agentframework.floatcard.ext.d dVar = com.stepos.agentframework.floatcard.ext.d.INSTANCE;
        dVar.b(this);
        if (isFinishing() && this.cardId.length() > 0) {
            dVar.d(this.cardId);
        }
        super.onDestroy();
    }

    @Override // b.q, android.app.Activity
    public void onNewIntent(Intent intent) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        u(intent);
    }

    public final void u(Intent intent) throws Resources.NotFoundException {
        String stringExtra = intent != null ? intent.getStringExtra(EXTRA_CARD_ID) : null;
        if (stringExtra == null) {
            stringExtra = "";
        }
        com.stepos.agentframework.floatcard.ext.d dVar = com.stepos.agentframework.floatcard.ext.d.INSTANCE;
        FloatCardRequest floatCardRequestE = dVar.e(stringExtra);
        if (stringExtra.length() == 0 || floatCardRequestE == null) {
            finish();
            overridePendingTransition(0, 0);
            return;
        }
        if (!this.dismissing) {
            FloatCardContainerView floatCardContainerView = this.container;
            if (floatCardContainerView == null) {
                kotlin.jvm.internal.p.A("container");
                floatCardContainerView = null;
            }
            if (kotlin.jvm.internal.p.d(floatCardContainerView.e(), stringExtra)) {
                this.cardId = stringExtra;
                dVar.a(stringExtra, this);
                return;
            }
        }
        if (this.cardId.length() > 0 && !kotlin.jvm.internal.p.d(this.cardId, stringExtra)) {
            dVar.d(this.cardId);
        }
        this.cardId = stringExtra;
        this.dismissing = false;
        this.dismissToken++;
        dVar.a(stringExtra, this);
        int iC = androidx.core.content.a.c(this, R$color.float_card_bg);
        float dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.float_card_corner_radius);
        p pVar = new p(this, floatCardRequestE, this.dispatcher);
        pVar.setBackground(H4.a.INSTANCE.a(iC, dimensionPixelSize));
        pVar.setClickable(true);
        FloatCardContainerView floatCardContainerView2 = this.container;
        if (floatCardContainerView2 == null) {
            kotlin.jvm.internal.p.A("container");
            floatCardContainerView2 = null;
        }
        FloatCardContainerView.q(floatCardContainerView2, pVar, false, 2, null);
        int i10 = (int) ((20 * getResources().getDisplayMetrics().density) + 0.5f);
        ViewGroup.LayoutParams layoutParams = pVar.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.leftMargin = i10;
            layoutParams2.rightMargin = i10;
            layoutParams2.bottomMargin = i10;
            pVar.setLayoutParams(layoutParams2);
        }
    }

    public final void v(final InterfaceC5063a<Y8.t> onEnd) {
        if (this.dismissing) {
            if (onEnd != null) {
                onEnd.invoke();
                return;
            }
            return;
        }
        this.dismissing = true;
        final int i10 = this.dismissToken + 1;
        this.dismissToken = i10;
        FloatCardContainerView floatCardContainerView = this.container;
        if (floatCardContainerView == null) {
            kotlin.jvm.internal.p.A("container");
            floatCardContainerView = null;
        }
        floatCardContainerView.f(this.cardId, new InterfaceC5063a() { // from class: com.stepos.agentframework.floatcard.view.r
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FloatCardActivity.w(i10, this, onEnd);
            }
        });
    }
}
