package ib;

import com.autonavi.aps.amapapi.config.Const;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\"\u0014\u0010\u0007\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006¨\u0006\b"}, d2 = {"", "path", "Lib/f;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lib/f;", "", "C", "SystemPathSeparator", "kotlinx-io-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final char f33136a = File.separatorChar;

    public static final f a(String path) {
        p.i(path, "path");
        return new f(new File(path));
    }
}
