package stepai.aios.guiagent.pipeline;

import Aa.d;
import Aa.e;
import J7.c;
import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import stepai.aios.guiagent.model.TakeoverReasonType;
import za.h;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline", f = "ExecutionPipeline.kt", l = {1423, 1434, 1443, 1454, 1469, 1475}, m = "handleTakeover", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ExecutionPipeline$handleTakeover$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public e f6070a;
    public za.e b;
    public d c;
    public Bitmap d;
    public String e;
    public h f;
    public TakeoverReasonType g;
    public String h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f6071j;
    public final /* synthetic */ b k;
    public int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$handleTakeover$1(b bVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.k = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6071j = obj;
        this.l |= Integer.MIN_VALUE;
        return this.k.v(null, null, this);
    }
}
