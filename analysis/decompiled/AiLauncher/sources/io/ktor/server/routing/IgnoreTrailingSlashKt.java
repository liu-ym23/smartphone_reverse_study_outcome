package io.ktor.server.routing;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.application.ApplicationPlugin;
import io.ktor.server.application.CreatePluginUtilsKt;
import io.ktor.server.application.PluginBuilder;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\"\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003\"\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"(\u0010\u000f\u001a\u00020\n*\u00020\t2\u0006\u0010\u000b\u001a\u00020\n8@@BX\u0080\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lio/ktor/util/AttributeKey;", "LY8/t;", "IgnoreTrailingSlashAttributeKey", "Lio/ktor/util/AttributeKey;", "Lio/ktor/server/application/ApplicationPlugin;", "IgnoreTrailingSlash", "Lio/ktor/server/application/ApplicationPlugin;", "getIgnoreTrailingSlash", "()Lio/ktor/server/application/ApplicationPlugin;", "Lio/ktor/server/application/ApplicationCall;", "", UxipConstants.f30680s, "(Lio/ktor/server/application/ApplicationCall;)Z", "setIgnoreTrailingSlash", "(Lio/ktor/server/application/ApplicationCall;Z)V", "ignoreTrailingSlash", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class IgnoreTrailingSlashKt {
    private static final ApplicationPlugin<Y8.t> IgnoreTrailingSlash;
    private static final AttributeKey<Y8.t> IgnoreTrailingSlashAttributeKey;

    static {
        InterfaceC5755n interfaceC5755nM;
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(Y8.t.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(Y8.t.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        IgnoreTrailingSlashAttributeKey = new AttributeKey<>("IgnoreTrailingSlashAttributeKey", new TypeInfo(interfaceC5745dB, interfaceC5755nM));
        IgnoreTrailingSlash = CreatePluginUtilsKt.createApplicationPlugin("IgnoreTrailingSlash", new InterfaceC5074l() { // from class: io.ktor.server.routing.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return IgnoreTrailingSlashKt.IgnoreTrailingSlash$lambda$0((PluginBuilder) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t IgnoreTrailingSlash$lambda$0(PluginBuilder createApplicationPlugin) {
        kotlin.jvm.internal.p.i(createApplicationPlugin, "$this$createApplicationPlugin");
        createApplicationPlugin.onCall(new IgnoreTrailingSlashKt$IgnoreTrailingSlash$1$1(null));
        return Y8.t.f7040a;
    }

    public static final boolean getIgnoreTrailingSlash(ApplicationCall applicationCall) {
        kotlin.jvm.internal.p.i(applicationCall, "<this>");
        return applicationCall.getAttributes().contains(IgnoreTrailingSlashAttributeKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setIgnoreTrailingSlash(ApplicationCall applicationCall, boolean z10) {
        if (z10) {
            applicationCall.getAttributes().put(IgnoreTrailingSlashAttributeKey, Y8.t.f7040a);
        } else {
            applicationCall.getAttributes().remove(IgnoreTrailingSlashAttributeKey);
        }
    }

    public static final ApplicationPlugin<Y8.t> getIgnoreTrailingSlash() {
        return IgnoreTrailingSlash;
    }
}
