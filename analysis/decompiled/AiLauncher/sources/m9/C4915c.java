package m9;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\"\u001e\u0010\u0006\u001a\u00020\u0001*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Ljava/nio/file/Path;", "", Const.INTENT_KEY_APIKEY, "(Ljava/nio/file/Path;)Ljava/lang/String;", "getExtension$annotations", "(Ljava/nio/file/Path;)V", "extension", "kotlin-stdlib-jdk7"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/io/path/PathsKt")
/* renamed from: m9.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C4915c extends C4914b {
    public static String a(Path path) {
        String string;
        String strQ1;
        p.i(path, "<this>");
        Path fileName = path.getFileName();
        return (fileName == null || (string = fileName.toString()) == null || (strQ1 = H.q1(string, '.', "")) == null) ? "" : strQ1;
    }
}
