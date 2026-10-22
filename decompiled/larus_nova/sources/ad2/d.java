package ad2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.bduploader.BDVideoInfo;
import com.ss.bduploader.BDVideoUploader;
import com.ss.bduploader.BDVideoUploaderListener;
import io.reactivex.ObservableEmitter;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements BDVideoUploaderListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BDVideoUploader f2948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ObservableEmitter f2949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CallContext f2950c;

    @Override // com.ss.bduploader.BDVideoUploaderListener
    public final String getStringFromExtern(int r100) {
        return null;
    }

    @Override // com.ss.bduploader.BDVideoUploaderListener
    public final void onLog(int r100, int r101, String r102) {
    }

    @Override // com.ss.bduploader.BDVideoUploaderListener
    public final int videoUploadCheckNetState(int r100, int r101) {
        return r100;
    }

    @Override // com.ss.bduploader.BDVideoUploaderListener
    public final void onUploadVideoStage(int r100, long r101) {
        ALogger.d("UploadHelper", "stage: " + r100 + ", timestamp: " + r101);
    }

    public d(BDVideoUploader r100, ObservableEmitter r101, CallContext r102) {
        this.f2948a = r100;
        this.f2949b = r101;
        this.f2950c = r102;
    }

    @Override // com.ss.bduploader.BDVideoUploaderListener
    public final void onNotify(int r100, long r101, BDVideoInfo r102) {
        if (r100 == 0) goto L20;
        Long r103 = null;
        String r104 = null;
        if (r100 != 1) goto L6;
        CallContext r105 = this.f2950c;
        JSONObject r106 = new JSONObject();
        if (r102 == null) goto L19;
        r103 = Long.valueOf(r102.mProgress);
    L19:
        r106.put("progress", r103);
        Unit r107 = Unit.INSTANCE;
        r105.b("subscribe.upload.progress", r106);
        return;
    L6:
        if (r100 != 2) goto L27;
        this.f2948a.close();
        ObservableEmitter r108 = this.f2949b;
        StringBuilder r109 = new StringBuilder("BDUpload failed,");
        if (r102 == null) goto L11;
        Long r110 = Long.valueOf(r102.mErrorCode);
    L12:
        r109.append(r110);
        r109.append(", ");
        if (r102 == null) goto L15;
        r104 = r102.mErrorMsg;
    L15:
        r109.append(r104);
        r108.onError(new Throwable(r109.toString()));
        return;
    L11:
        r110 = null;
        goto L12
    L27:
        return;
    L20:
        if (r102 != null) goto L23;
        this.f2948a.close();
        this.f2949b.onError(new Throwable("Complete with empty result"));
        return;
    L23:
        this.f2949b.onNext(new com.bytedance.android.livesdk.jsbridge.methods.upload.models.d(r102.mVideoId, r102.mCoverUri, r102.mVideoMediaInfo));
        this.f2948a.close();
    }
}
