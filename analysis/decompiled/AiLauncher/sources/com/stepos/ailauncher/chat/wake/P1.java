package com.stepos.ailauncher.chat.wake;

import Z8.C1173v;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.List;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/P1;", "", "", "Lcom/stepos/ailauncher/chat/wake/N1;", "guards", "<init>", "(Ljava/util/List;)V", "Landroid/content/Context;", "context", "", "source", "", Const.INTENT_KEY_UMID, "(Landroid/content/Context;Ljava/lang/String;)Z", "Ljava/util/List;", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class P1 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Y8.h<P1> DEFAULT$delegate = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.O1
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return P1.b();
        }
    });
    private static final String TAG = "WakeGuardChain";
    private final List<N1> guards;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/P1$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/wake/P1;", "DEFAULT$delegate", "LY8/h;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/chat/wake/P1;", "DEFAULT", "", "TAG", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.wake.P1$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final P1 a() {
            return (P1) P1.DEFAULT$delegate.getValue();
        }

        public Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public P1(List<? extends N1> guards) {
        kotlin.jvm.internal.p.i(guards, "guards");
        this.guards = guards;
    }

    public static final P1 b() {
        return new P1(C1173v.p(N.INSTANCE, V.INSTANCE, B.INSTANCE, C3160s.INSTANCE, C3163t.INSTANCE, C3143m.INSTANCE, K.INSTANCE, I.INSTANCE, C3115e.INSTANCE, WakeMethodSwitchGuard.INSTANCE, O.INSTANCE, S.INSTANCE, C3123g.INSTANCE, M.INSTANCE));
    }

    public final boolean d(Context context, String source) {
        kotlin.jvm.internal.p.i(context, "context");
        for (N1 n12 : this.guards) {
            if (!n12.a(context, source)) {
                C4148a.d(TAG, "denied by " + n12.getName() + " source=" + source, false, 4, null);
                return false;
            }
        }
        return true;
    }
}
