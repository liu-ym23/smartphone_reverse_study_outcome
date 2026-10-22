package a1c;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.ttvideoengine.utils.TTVideoEngineLogListener;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements TTVideoEngineLogListener {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // com.ss.ttvideoengine.utils.TTVideoEngineLogListener
    public final void consoleLog(String r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L10;
        Log.i("LarkTTVideoEngineLogListener", "ENGINE_LOG_" + r100);
        return;
    L10:
        return;
    L5:
        if (new Regex(AppbrandHostConstants.SCHEMA_INSPECT.SESSION).containsMatchIn(r100) == true) goto L7;
        r101 = true;
        goto L7
    }
}
