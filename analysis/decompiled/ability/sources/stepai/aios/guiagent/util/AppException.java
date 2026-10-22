package stepai.aios.guiagent.util;

import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lstepai/aios/guiagent/util/AppException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "F1/a", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AppException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f6174a = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppException(AppErrorType appErrorType, String str, String str2, String message, int i) {
        super(message, null);
        k.f(message, "message");
    }
}
