package androidx.core.net;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0086\b\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0004H\u0086\b¨\u0006\u0005"}, d2 = {"toFile", "Ljava/io/File;", "Landroid/net/Uri;", "toUri", "", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class UriKt {
    public static final File toFile(Uri r100) {
        if (Intrinsics.areEqual(r100.getScheme(), "file") == false) goto L11;
        String r101 = r100.getPath();
        if (r101 == null) goto L9;
        return new File(r101);
    L9:
        throw new IllegalArgumentException(("Uri path is null: " + r100).toString());
    L11:
        throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + r100).toString());
    }

    public static final Uri toUri(File r100) {
        return Uri.fromFile(r100);
    }

    public static final Uri toUri(String r100) {
        return UriProtector.parse(r100);
    }
}
