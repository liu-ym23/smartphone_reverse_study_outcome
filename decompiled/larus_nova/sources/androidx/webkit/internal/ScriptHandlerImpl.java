package androidx.webkit.internal;

import androidx.webkit.ScriptHandler;
import java.lang.reflect.InvocationHandler;
import nvc.a;
import org.chromium.support_lib_boundary.ScriptHandlerBoundaryInterface;

/* JADX INFO: loaded from: classes17.dex */
public class ScriptHandlerImpl extends ScriptHandler {
    private ScriptHandlerBoundaryInterface mBoundaryInterface;

    @Override // androidx.webkit.ScriptHandler
    public void remove() {
        this.mBoundaryInterface.remove();
    }

    private ScriptHandlerImpl(ScriptHandlerBoundaryInterface r100) {
        this.mBoundaryInterface = r100;
    }

    public static ScriptHandlerImpl toScriptHandler(InvocationHandler r100) {
        return new ScriptHandlerImpl((ScriptHandlerBoundaryInterface) a.a(ScriptHandlerBoundaryInterface.class, r100));
    }
}
