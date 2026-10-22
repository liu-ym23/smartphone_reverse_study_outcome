package io.ktor.http.content;

import Z8.C1173v;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import w9.C5757p;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000&\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\"#\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"4\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"", "spec", "Lio/ktor/http/content/EntityTagVersion;", "EntityTagVersion", "(Ljava/lang/String;)Lio/ktor/http/content/EntityTagVersion;", "Lio/ktor/util/AttributeKey;", "", "Lio/ktor/http/content/Version;", "VersionListProperty", "Lio/ktor/util/AttributeKey;", "getVersionListProperty", "()Lio/ktor/util/AttributeKey;", "Lio/ktor/http/content/OutgoingContent;", UxipConstants.f30680s, "getVersions", "(Lio/ktor/http/content/OutgoingContent;)Ljava/util/List;", "setVersions", "(Lio/ktor/http/content/OutgoingContent;Ljava/util/List;)V", "versions", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VersionsKt {
    private static final AttributeKey<List<Version>> VersionListProperty;

    static {
        InterfaceC5755n interfaceC5755nN;
        InterfaceC5745d interfaceC5745dB = t.b(List.class);
        try {
            interfaceC5755nN = t.n(List.class, C5757p.INSTANCE.d(t.m(Version.class)));
        } catch (Throwable unused) {
            interfaceC5755nN = null;
        }
        VersionListProperty = new AttributeKey<>("VersionList", new TypeInfo(interfaceC5745dB, interfaceC5755nN));
    }

    public static final EntityTagVersion EntityTagVersion(String spec) {
        p.i(spec, "spec");
        return EntityTagVersion.INSTANCE.parseSingle(spec);
    }

    public static final AttributeKey<List<Version>> getVersionListProperty() {
        return VersionListProperty;
    }

    public static final List<Version> getVersions(OutgoingContent outgoingContent) {
        p.i(outgoingContent, "<this>");
        List<Version> list = (List) outgoingContent.getProperty(VersionListProperty);
        return list == null ? C1173v.m() : list;
    }

    public static final void setVersions(OutgoingContent outgoingContent, List<? extends Version> value) {
        p.i(outgoingContent, "<this>");
        p.i(value, "value");
        outgoingContent.setProperty(VersionListProperty, value);
    }
}
