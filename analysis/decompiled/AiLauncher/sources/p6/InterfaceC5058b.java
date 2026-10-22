package p6;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lp6/b;", "", "", "key", UxipConstants.f30680s, "", "putString", "(Ljava/lang/String;Ljava/lang/String;)Z", "default", "getString", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "storage_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: p6.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC5058b {
    static /* synthetic */ String a(InterfaceC5058b interfaceC5058b, String str, String str2, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getString");
        }
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        return interfaceC5058b.getString(str, str2);
    }

    String getString(String key, String str);

    boolean putString(String key, String value);
}
