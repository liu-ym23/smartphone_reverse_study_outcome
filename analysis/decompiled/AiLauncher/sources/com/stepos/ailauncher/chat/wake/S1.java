package com.stepos.ailauncher.chat.wake;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006JI\u0010\u000e\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u001e\u0010\f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\u0004\u0012\u00020\u000b0\n0\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/S1;", "", "<init>", "()V", "", Const.INTENT_KEY_PKGNAME, "()Z", "Lkotlin/Function0;", "isValid", "", "Lkotlin/Function1;", "LY8/t;", "steps", "onReady", "c", "(Lp9/a;Ljava/util/List;Lp9/a;)V", "Lcom/stepos/ailauncher/chat/wake/S1$a;", "active", "Lcom/stepos/ailauncher/chat/wake/S1$a;", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class S1 {
    private a active;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/S1$a;", "", "Lkotlin/Function0;", "", "isValid", "<init>", "(Lp9/a;)V", "Lp9/a;", Const.INTENT_KEY_APIKEY, "()Lp9/a;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        private final InterfaceC5063a<Boolean> isValid;

        public a(InterfaceC5063a<Boolean> isValid) {
            kotlin.jvm.internal.p.i(isValid, "isValid");
            this.isValid = isValid;
        }

        public final InterfaceC5063a<Boolean> a() {
            return this.isValid;
        }
    }

    public static final void d(final S1 s12, final a aVar, final List<? extends InterfaceC5074l<? super InterfaceC5063a<Y8.t>, Y8.t>> list, final InterfaceC5063a<Y8.t> interfaceC5063a, final int i10) {
        if (s12.active != aVar) {
            return;
        }
        if (!aVar.a().invoke().booleanValue()) {
            s12.active = null;
        } else if (i10 == list.size()) {
            s12.active = null;
            interfaceC5063a.invoke();
        } else {
            final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            list.get(i10).invoke(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.R1
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return S1.e(ref$BooleanRef, i10, s12, aVar, list, interfaceC5063a);
                }
            });
        }
    }

    public static final Y8.t e(Ref$BooleanRef ref$BooleanRef, int i10, S1 s12, a aVar, List list, InterfaceC5063a interfaceC5063a) {
        if (!ref$BooleanRef.f34815a) {
            ref$BooleanRef.f34815a = true;
            d(s12, aVar, list, interfaceC5063a, i10 + 1);
        }
        return Y8.t.f7040a;
    }

    public final boolean b() {
        a aVar = this.active;
        if (aVar == null) {
            return false;
        }
        if (aVar.a().invoke().booleanValue()) {
            return true;
        }
        this.active = null;
        return false;
    }

    public final void c(InterfaceC5063a<Boolean> isValid, List<? extends InterfaceC5074l<? super InterfaceC5063a<Y8.t>, Y8.t>> steps, InterfaceC5063a<Y8.t> onReady) {
        kotlin.jvm.internal.p.i(isValid, "isValid");
        kotlin.jvm.internal.p.i(steps, "steps");
        kotlin.jvm.internal.p.i(onReady, "onReady");
        if (b()) {
            return;
        }
        a aVar = new a(isValid);
        this.active = aVar;
        d(this, aVar, steps, onReady, 0);
    }
}
