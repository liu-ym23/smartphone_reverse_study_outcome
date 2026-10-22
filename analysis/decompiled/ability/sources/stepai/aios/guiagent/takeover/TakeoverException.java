package stepai.aios.guiagent.takeover;

import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002¨\u0006\u0003"}, d2 = {"Lstepai/aios/guiagent/takeover/TakeoverException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TakeoverException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final TakeoverErrorType f6158a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TakeoverException(TakeoverErrorType takeoverErrorType, String message, Throwable th) {
        super(message, th);
        k.f(message, "message");
        this.f6158a = takeoverErrorType;
    }
}
