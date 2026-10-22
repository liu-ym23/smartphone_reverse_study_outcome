package p8;

import android.content.Context;
import com.bytedanceos.common.core.account.cloudsync.http.download.DownloadExcutor;
import com.bytedanceos.common.core.account.cloudsync.util.CloudSyncFile;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: p8.a$a, reason: collision with other inner class name */
    public class C0340a implements DownloadExcutor.DownloadProgressListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f23352a;

        public C0340a(Context r10) {
            this.f23352a = r10;
        }

        @Override // com.bytedanceos.common.core.account.cloudsync.http.download.DownloadExcutor.DownloadProgressListener
        public void onCompleted(CloudSyncFile r10) {
            b.i("AccountsUtil", "onCompleted()");
        }

        @Override // com.bytedanceos.common.core.account.cloudsync.http.download.DownloadExcutor.DownloadProgressListener
        public void onError(CloudSyncFile r10) {
            b.i("AccountsUtil", "onError()");
            b.a(this.f23352a, "verification.png");
        }

        @Override // com.bytedanceos.common.core.account.cloudsync.http.download.DownloadExcutor.DownloadProgressListener
        public void onPause(CloudSyncFile r10) {
        }

        @Override // com.bytedanceos.common.core.account.cloudsync.http.download.DownloadExcutor.DownloadProgressListener
        public void onProgress(CloudSyncFile r10) {
        }

        @Override // com.bytedanceos.common.core.account.cloudsync.http.download.DownloadExcutor.DownloadProgressListener
        public void onStart(CloudSyncFile r10) {
        }

        @Override // com.bytedanceos.common.core.account.cloudsync.http.download.DownloadExcutor.DownloadProgressListener
        public void onStop(CloudSyncFile r10) {
        }
    }

    public static void a(Context r10, String r11) {
        b.i("AccountsUtil", "downloadAccountVerificationIcon()");
        new com.bytedanceos.common.core.account.cloudsync.http.download.a().c(r11, b.c(r10) + "/verification.png", new C0340a(r10));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        b.a(r10, "verification.png");
    }

    public static File b(Context r10) {
        File r11 = new File(r10.getFilesDir() + "/verification.png");
        if (r11.exists() == true) goto L6;
        return null;
    L6:
        return r11;
    }
}
