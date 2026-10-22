package stepai.aios.guiexecutor.handler;

import android.graphics.Point;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import stepai.aios.guiagent.config.Action;

@J7.c(c = "stepai.aios.guiexecutor.handler.ClickCommandHandler", f = "ClickCommandHandler.kt", l = {227, 231, 234}, m = "performDoubleTap", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ClickCommandHandler$performDoubleTap$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Point f6182a;
    public Action b;
    public int c;
    public boolean d;
    public /* synthetic */ Object e;
    public final /* synthetic */ c f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickCommandHandler$performDoubleTap$1(c cVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return this.f.a(null, 0, null, this);
    }
}
