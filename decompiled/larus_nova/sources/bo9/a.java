package bo9;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a implements pub.a {

    /* JADX INFO: renamed from: bo9.a$a, reason: collision with other inner class name */
    public static final class C0323a {
    }

    static {
    }

    public a() {
    }

    @Override // pub.a
    public final boolean F(MmRecordingSource r100) {
        if (r100 != MmRecordingSource.DOUBAO_GLASSES) goto L5;
    L8:
        boolean r101 = true;
    L9:
        FLogger.f375446a.i("MmRecordingFullAudioFileConfImpl", "shouldKeepFullAudioFile, source=" + r100 + ", keep=" + r101);
        return r101;
    L5:
        if (r100 == MmRecordingSource.DOUBAO_EARBUDS) goto L8;
        r101 = false;
        goto L9
    }

    @Override // pub.a
    public final PolarisFileWrapper r0(String r100, String r110) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r110, "meetingId");
        PolarisFileWrapper r101 = new PolarisFileWrapper(AppHost.f326268a.getApplication().getFilesDir(), "minutes_full_audio/" + r100 + '/' + r110);     // Catch: Exception -> L11
        if (r101.exists() == false) goto L6;
    L9:
        FLogger.f375446a.i("MmRecordingFullAudioFileConfImpl", "provideFullAudioBaseDir, path=" + r101.getAbsolutePath());     // Catch: Exception -> L11
        return r101;
    L6:
        if (r101.mkdirs() == true) goto L9;
        FLogger.f375446a.e("MmRecordingFullAudioFileConfImpl", "provideFullAudioBaseDir mkdirs failed, path=" + r101.getAbsolutePath());     // Catch: Exception -> L11
        return null;
    L11:
        e = move-exception;
        FLogger.f375446a.e("MmRecordingFullAudioFileConfImpl", "provideFullAudioBaseDir error, " + e.getMessage());
        return null;
    }
}
