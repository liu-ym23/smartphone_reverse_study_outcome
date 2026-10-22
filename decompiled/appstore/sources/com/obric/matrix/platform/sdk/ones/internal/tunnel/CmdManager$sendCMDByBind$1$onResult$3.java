package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import com.obric.matrix.proto.Response;
import io.reactivex.MaybeEmitter;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "errorCode", "", "errorMsg", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class CmdManager$sendCMDByBind$1$onResult$3 extends Lambda implements Function2<Integer, String, Unit> {
    final /* synthetic */ int $cmd;
    final /* synthetic */ MaybeEmitter<Pair<Integer, Response>> $emitter;

    public CmdManager$sendCMDByBind$1$onResult$3(int r10, MaybeEmitter<Pair<Integer, Response>> r11) {
        this.$cmd = r10;
        this.$emitter = r11;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Unit mo0invoke(Integer r10, String r11) {
        invoke(r10.intValue(), r11);
        return Unit.f21064a;
    }

    public final void invoke(int r10, @NotNull String r11) {
        q.g(r11, "errorMsg");
        a.a(a.f11931a, this.$cmd, this.$emitter, null, r10, r11);
    }
}
