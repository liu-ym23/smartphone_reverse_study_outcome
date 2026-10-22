package u9;

import com.media.cache.VideoCacheException;
import com.obric.capabilitykit.common.ErrorCode;
import java.io.FileNotFoundException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static int a(Throwable r10) {
        if ((r10 instanceof SocketTimeoutException) == false) goto L7;
        return 1000;
    L7:
        if ((r10 instanceof FileNotFoundException) == false) goto L11;
        return 1001;
    L11:
        if ((r10 instanceof VideoCacheException) == false) goto L26;
        VideoCacheException r11 = (VideoCacheException) r10;
        if (r11.getMsg().equals("File Length Cannot be fetched") == false) goto L17;
        return 2000;
    L17:
        if (r11.getMsg().equals("M3U8 File content error") == false) goto L21;
        return ErrorCode.Clock.TIMER_NOT_EXIST_ERROR;
    L21:
        if (r11.getMsg().equals("MimeType is null") == false) goto L24;
        return ErrorCode.Clock.UNSUPPORTED_CREATE_ALARM_RINGING_AFTER_24_HOURS_ERROR;
    L24:
        r11.getMsg().equals("MimeType not found");
        return -1;
    L26:
        if ((r10 instanceof UnknownHostException) == false) goto L31;
        return 1002;
    L31:
        return -1;
    }
}
