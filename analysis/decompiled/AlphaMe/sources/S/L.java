package S;

import java.io.File;
import java.io.FileOutputStream;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes.dex */
public final class L extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public M f1717a;

    /* renamed from: b, reason: collision with root package name */
    public File f1718b;

    /* renamed from: c, reason: collision with root package name */
    public FileOutputStream f1719c;

    /* renamed from: d, reason: collision with root package name */
    public FileOutputStream f1720d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f1721e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ M f1722f;

    /* renamed from: g, reason: collision with root package name */
    public int f1723g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L(M m4, Continuation continuation) {
        super(continuation);
        this.f1722f = m4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f1721e = obj;
        this.f1723g |= Integer.MIN_VALUE;
        return this.f1722f.k(null, this);
    }
}
