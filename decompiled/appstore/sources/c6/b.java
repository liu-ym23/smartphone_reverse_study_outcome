package c6;

import com.bytedance.platform.godzilla.GodzillaCore;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer;
import com.bytedance.platform.godzilla.plugin.StartType;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends a implements UncaughtExceptionConsumer {
    public b() {
    }

    @Override // c6.a
    public void c() {
        super.c();
        if (e() == false) goto L6;
        GodzillaCore.INSTANCE.addUncaughtExceptionConsumer(this);
        Logger.c(a(), "start called.");
        return;
    }

    @Override // c6.a
    public StartType d() {
        return StartType.REGISTER_EXCEPTION;
    }

    public abstract boolean e();
}
