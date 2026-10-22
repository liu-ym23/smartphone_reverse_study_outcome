package ge;

import com.obric.download.base.DownloadInfo;
import com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO;
import com.smt.obric.appstore.domain.app.entity.AppStatus;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
public abstract class f {
    public static final Object a(AppInstallTaskDAO r18, long r19, AppStatus r21, DownloadInfo r22, Continuation r23) {
        Long r10 = tf.a.d(r22.getStatus());
        Integer r11 = r22.getErrorCode();
        if (r11 == null) goto L6;
        Long r12 = tf.a.d(r11.intValue());
    L8:
        return r18.updateDownloadStatus(r19, r21, r10, r12, r22.getErrorMsg(), r22.getProgress(), r22.getTargetFilePath(), r22.getCurBytes(), r22.getTotalBytes(), tf.a.b((float) r22.getSpeed()), r22.getLastModifiedTime(), r23);
    L6:
        r12 = null;
        goto L8
    }

    public static final Object b(AppInstallTaskDAO r20, String r21, long r22, AppStatus r24, DownloadInfo r25, Continuation r26) {
        long r10 = r25.getId();
        Long r11 = tf.a.d(r25.getStatus());
        Integer r12 = r25.getErrorCode();
        if (r12 == null) goto L6;
        Long r13 = tf.a.d(r12.intValue());
    L8:
        return r20.updateDownloadStatusByAppPkg(r21, r22, r10, r24, r11, r13, r25.getErrorMsg(), r25.getProgress(), r25.getTargetFilePath(), r25.getCurBytes(), r25.getTotalBytes(), tf.a.b((float) r25.getSpeed()), r25.getLastModifiedTime(), r26);
    L6:
        r13 = null;
        goto L8
    }
}
