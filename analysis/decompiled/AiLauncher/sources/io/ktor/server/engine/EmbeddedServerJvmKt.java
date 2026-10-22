package io.ktor.server.engine;

import La.H;
import com.fasterxml.jackson.core.JsonPointer;
import java.io.File;
import java.net.URL;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006*D\b\u0002\u0010\f\"\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00072\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0007¨\u0006\r"}, d2 = {"Ljava/net/URL;", "url", "", "pattern", "", "checkUrlMatches", "(Ljava/net/URL;Ljava/lang/String;)Z", "Lkotlin/Function2;", "Lio/ktor/server/application/Application;", "Le9/c;", "LY8/t;", "", "ApplicationModule", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EmbeddedServerJvmKt {
    public static final boolean checkUrlMatches(URL url, String pattern) {
        char c10;
        String strS;
        kotlin.jvm.internal.p.i(url, "url");
        kotlin.jvm.internal.p.i(pattern, "pattern");
        String path = url.getPath();
        if (path == null || (strS = La.D.S(path, (c10 = File.separatorChar), JsonPointer.SEPARATOR, false, 4, null)) == null) {
            return false;
        }
        return H.e0(strS, La.D.S(pattern, c10, JsonPointer.SEPARATOR, false, 4, null), true);
    }
}
