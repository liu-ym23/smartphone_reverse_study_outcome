package com.stepos.ailauncher.agent.aispace.skill.feishu;

import Ua.C1060i;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001fBG\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\"\u0010\f\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u0013\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\t2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0017R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0018R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0019R0\u0010\f\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001aR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/PollingManager;", ExifInterface.GPS_DIRECTION_TRUE, "", "LUa/M;", "scope", "", "intervalMs", "", "maxAttempts", "Lkotlin/Function1;", "Le9/c;", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/o0;", "fetcher", "<init>", "(LUa/M;JILp9/l;)V", "LY8/t;", "onUpdate", "Lkotlin/Function0;", "onTimeout", Const.INTENT_KEY_UMID, "(Lp9/l;Lp9/a;)V", "e", "()V", "LUa/M;", "J", "I", "Lp9/l;", "Lkotlinx/coroutines/g;", "job", "Lkotlinx/coroutines/g;", "Companion", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PollingManager<T> {
    private static final String TAG = "AILauncher-Poller";
    private final InterfaceC5074l<InterfaceC4014c<? super o0<T>>, Object> fetcher;
    private final long intervalMs;
    private kotlinx.coroutines.g job;
    private final int maxAttempts;
    private final Ua.M scope;

    /* JADX WARN: Multi-variable type inference failed */
    public PollingManager(Ua.M scope, long j10, int i10, InterfaceC5074l<? super InterfaceC4014c<? super o0<T>>, ? extends Object> fetcher) {
        kotlin.jvm.internal.p.i(scope, "scope");
        kotlin.jvm.internal.p.i(fetcher, "fetcher");
        this.scope = scope;
        this.intervalMs = j10;
        this.maxAttempts = i10;
        this.fetcher = fetcher;
    }

    public final void d(InterfaceC5074l<? super T, Y8.t> onUpdate, InterfaceC5063a<Y8.t> onTimeout) {
        kotlin.jvm.internal.p.i(onUpdate, "onUpdate");
        kotlin.jvm.internal.p.i(onTimeout, "onTimeout");
        e();
        this.job = C1060i.d(this.scope, null, null, new PollingManager$start$2(onUpdate, this, onTimeout, null), 3, null);
    }

    public final void e() {
        kotlinx.coroutines.g gVar = this.job;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.job = null;
    }
}
