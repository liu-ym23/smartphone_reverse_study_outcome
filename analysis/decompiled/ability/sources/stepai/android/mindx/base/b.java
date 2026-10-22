package stepai.android.mindx.base;

import java.util.Map;
import stepai.android.llm.base.log.ILLMLogger;

/* loaded from: classes4.dex */
public final class b implements ILLMLogger {

    /* renamed from: a, reason: collision with root package name */
    public static final b f6198a = new b();
    public static Map b = kotlin.collections.a.M();
    public static final String c = "LLMRemoteTraceProvider";

    @Override // stepai.android.llm.base.log.ILLMLogger
    public final String getChildTag() {
        return c;
    }

    @Override // stepai.android.llm.base.log.ILLMLogger
    public final void printE(String str, String str2) {
        ILLMLogger.DefaultImpls.printE(this, str, str2);
    }

    @Override // stepai.android.llm.base.log.ILLMLogger
    public final void printI(String str, String str2) {
        ILLMLogger.DefaultImpls.printI(this, str, str2);
    }

    @Override // stepai.android.llm.base.log.ILLMLogger
    public final void printV(String str, String str2) {
        ILLMLogger.DefaultImpls.printV(this, str, str2);
    }
}
