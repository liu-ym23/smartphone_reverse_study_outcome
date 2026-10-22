package com.stepos.ailauncher.chat.view;

import A7.C0746n;
import android.content.Context;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0017R\u0014\u0010\u001d\u001a\u00020\u001a8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/chat/view/B6;", "Ly7/C;", "LA7/n;", "initial", "<init>", "(LA7/n;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "()LA7/n;", "Landroid/view/View;", "view", "params", "Ly7/s;", "f", "(Landroid/view/View;LA7/n;)Ly7/s;", "", "radiusPx", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(F)Z", "Landroid/content/Context;", "context", "isSupported", "(Landroid/content/Context;)Z", "LA7/n;", "binding", "Ly7/s;", "", "getId", "()Ljava/lang/String;", "id", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class B6 implements y7.C<C0746n> {
    private final /* synthetic */ y7.C<C0746n> $$delegate_0;
    private y7.s binding;
    private final C0746n initial;
    private C0746n params;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/view/B6$a", "Ly7/s;", "Ly7/F;", "params", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ly7/F;)V", "release", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements y7.s {
        private final /* synthetic */ y7.s $$delegate_0;
        final /* synthetic */ y7.s $delegate;
        final /* synthetic */ B6 this$0;

        public a(y7.s sVar, B6 b62) {
            this.$delegate = sVar;
            this.this$0 = b62;
            this.$$delegate_0 = sVar;
        }

        @Override // y7.s
        public void a(y7.F params) {
            kotlin.jvm.internal.p.i(params, "params");
            this.$delegate.a(params);
            if (params instanceof C0746n) {
                this.this$0.params = (C0746n) params;
            }
        }

        @Override // y7.s
        public void release() {
            if (this.this$0.binding == this.$delegate) {
                this.this$0.binding = null;
                this.this$0.params = null;
            }
            this.$delegate.release();
        }
    }

    public B6(C0746n initial) {
        kotlin.jvm.internal.p.i(initial, "initial");
        this.$$delegate_0 = y7.G.f43879a.b();
        this.initial = initial;
    }

    @Override // y7.C
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public y7.s a(View view, C0746n params) {
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(params, "params");
        y7.s sVarA = y7.G.f43879a.b().a(view, params);
        if (sVarA == null) {
            return null;
        }
        this.binding = sVarA;
        this.params = params;
        return new a(sVarA, this);
    }

    @Override // y7.C
    /* renamed from: g, reason: from getter and merged with bridge method [inline-methods] */
    public C0746n get$params() {
        return this.initial;
    }

    @Override // y7.C
    public String getId() {
        return this.$$delegate_0.getId();
    }

    public final boolean h(float radiusPx) {
        C0746n c0746n;
        y7.s sVar = this.binding;
        if (sVar == null || (c0746n = this.params) == null) {
            return false;
        }
        c0746n.n(radiusPx);
        sVar.a(c0746n);
        return true;
    }

    @Override // y7.C
    public boolean isSupported(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return this.$$delegate_0.isSupported(context);
    }
}
