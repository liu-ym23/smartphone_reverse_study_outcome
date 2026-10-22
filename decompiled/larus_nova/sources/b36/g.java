package b36;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public interface g {
    boolean a();

    CharSequence getMethod();

    Map<String, String> getRequestHeaders();

    Uri getUrl();

    boolean isForMainFrame();

    boolean isRedirect();
}
