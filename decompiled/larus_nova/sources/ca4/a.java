package ca4;

import com.bytedance.bdp.bdpbase.core.BdpError;
import com.bytedance.bdp.bdpbase.core.BdpPluginStateListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements InvocationHandler {
    public a() {
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r100, Method r101, Object[] r102) throws Throwable {
        r101.getName();
        if (r102 == null) goto L5;
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L13;
        Object r105 = r102[r104];
        if ((r105 instanceof BdpPluginStateListener) == false) goto L11;
        ((BdpPluginStateListener) r105).onFailed(new BdpError(404, "service impl not found"));
    L11:
        r104 = r104 + 1;
        goto L7
    L13:
        return r101.getDefaultValue();
    L5:
        return r101.getDefaultValue();
    }
}
