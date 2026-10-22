package com.obric.aiagent.executionengine.capabilitymanager.data;

import android.app.Application;
import android.content.Context;
import androidx.room.o;
import androidx.room.p;
import com.obric.aiagent.platform.depend.IAppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.h;

/* JADX INFO: compiled from: CapabilityDatabase.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class CapabilityDatabase extends p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f16426e = null;
    private static final f<CapabilityDatabase> f = null;

    /* JADX INFO: compiled from: CapabilityDatabase.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final CapabilityDatabase a() {
            return (CapabilityDatabase) ZeusTransformUtils.preCheckCast(CapabilityDatabase.p().b(), CapabilityDatabase.class, "com.obric.aiagent.plugin");
        }
    }

    public static /* synthetic */ CapabilityDatabase lambda$RsVWquDKnog3NwTLWVXSXW6VQE8() {
        return q();
    }

    public abstract com.obric.aiagent.executionengine.capabilitymanager.data.b.a o();

    public static final /* synthetic */ f p() {
        return f;
    }

    public CapabilityDatabase() {
    }

    static {
        f16426e = new a(null);
        f = g.a($$Lambda$CapabilityDatabase$RsVWquDKnog3NwTLWVXSXW6VQE8.INSTANCE);
    }

    private static final CapabilityDatabase q() {
        return (CapabilityDatabase) ZeusTransformUtils.preCheckCast(o.a((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), CapabilityDatabase.class, "capability_db").a().b(), CapabilityDatabase.class, "com.obric.aiagent.plugin");
    }
}
