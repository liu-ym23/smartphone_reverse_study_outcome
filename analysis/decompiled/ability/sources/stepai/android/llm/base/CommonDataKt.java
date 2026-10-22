package stepai.android.llm.base;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0003"}, d2 = {"isError", "", "Lstepai/android/llm/base/Result;", "llmbase_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CommonDataKt {
    public static final boolean isError(Result result) {
        return result == null || result.getErr() != null;
    }
}
