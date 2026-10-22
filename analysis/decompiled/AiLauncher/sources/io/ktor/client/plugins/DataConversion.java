package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.util.AttributeKey;
import io.ktor.util.converters.DataConversion;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\t\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/client/plugins/DataConversion;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/util/converters/DataConversion$Configuration;", "Lio/ktor/util/converters/DataConversion;", "<init>", "()V", "Lkotlin/Function1;", "LY8/t;", "block", "prepare", "(Lp9/l;)Lio/ktor/util/converters/DataConversion;", "plugin", "Lio/ktor/client/HttpClient;", "scope", W4.b.STEP_INSTALL, "(Lio/ktor/util/converters/DataConversion;Lio/ktor/client/HttpClient;)V", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DataConversion implements HttpClientPlugin<DataConversion.Configuration, io.ktor.util.converters.DataConversion> {
    public static final DataConversion INSTANCE = new DataConversion();
    private static final AttributeKey<io.ktor.util.converters.DataConversion> key;

    static {
        InterfaceC5755n interfaceC5755nM;
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(io.ktor.util.converters.DataConversion.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(io.ktor.util.converters.DataConversion.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        key = new AttributeKey<>("DataConversion", new TypeInfo(interfaceC5745dB, interfaceC5755nM));
    }

    private DataConversion() {
    }

    @Override // io.ktor.client.plugins.HttpClientPlugin
    public AttributeKey<io.ktor.util.converters.DataConversion> getKey() {
        return key;
    }

    @Override // io.ktor.client.plugins.HttpClientPlugin
    public void install(io.ktor.util.converters.DataConversion plugin, HttpClient scope) {
        kotlin.jvm.internal.p.i(plugin, "plugin");
        kotlin.jvm.internal.p.i(scope, "scope");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.ktor.client.plugins.HttpClientPlugin
    public io.ktor.util.converters.DataConversion prepare(InterfaceC5074l<? super DataConversion.Configuration, Y8.t> block) {
        kotlin.jvm.internal.p.i(block, "block");
        DataConversion.Configuration configuration = new DataConversion.Configuration();
        block.invoke(configuration);
        return new io.ktor.util.converters.DataConversion(configuration);
    }
}
