package stepai.android.llm.base.log;

import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u001b\u0010\b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lstepai/android/llm/base/log/ILLMLogger;", "", "", "tag", "LC7/r;", "printI", "(Ljava/lang/String;Ljava/lang/String;)V", "printE", "printV", "getChildTag", "()Ljava/lang/String;", "childTag", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ILLMLogger {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void printE(ILLMLogger iLLMLogger, String receiver, String tag) {
            k.f(receiver, "$receiver");
            k.f(tag, "tag");
            ILLMLoggerKt.logWithChunks(6, tag, iLLMLogger.getChildTag(), receiver);
        }

        public static void printI(ILLMLogger iLLMLogger, String receiver, String tag) {
            k.f(receiver, "$receiver");
            k.f(tag, "tag");
            ILLMLoggerKt.logWithChunks(4, tag, iLLMLogger.getChildTag(), receiver);
        }

        public static void printV(ILLMLogger iLLMLogger, String receiver, String tag) {
            k.f(receiver, "$receiver");
            k.f(tag, "tag");
            ILLMLoggerKt.logWithChunks(2, tag, iLLMLogger.getChildTag(), receiver);
        }
    }

    String getChildTag();

    void printE(String str, String str2);

    void printI(String str, String str2);

    void printV(String str, String str2);
}
