package ad2;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.bduploader.BDImageInfo;
import com.ss.bduploader.BDImageUploader;
import com.ss.bduploader.BDImageUploaderListener;
import io.reactivex.ObservableEmitter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class l implements BDImageUploaderListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, Long> f2970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ObservableEmitter f2971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BDImageUploader f2972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f2973d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ CallContext f2974e;

    @Override // com.ss.bduploader.BDImageUploaderListener
    public final void onLog(int r100, int r101, String r102) {
    }

    @Override // com.ss.bduploader.BDImageUploaderListener
    public final int imageUploadCheckNetState(int r100, int r101) {
        return DownloadUtils.isNetworkConnected(s1.getContext()) ? 1 : 0;
    }

    @Override // com.ss.bduploader.BDImageUploaderListener
    public final void onNotify(int r100, long r101, BDImageInfo r102) {
        if (r100 != 0) goto L4;
        this.f2972c.close();
        this.f2971b.onComplete();
        return;
    L4:
        if (r100 == 1) goto L28;
        String r103 = null;
        if (r100 != 2) goto L8;
        this.f2972c.close();
        ObservableEmitter r104 = this.f2971b;
        StringBuilder r105 = new StringBuilder("BDUpload failed,");
        if (r102 == null) goto L23;
        Long r106 = Long.valueOf(r102.mErrorCode);
    L24:
        r105.append(r106);
        r105.append(", ");
        if (r102 == null) goto L27;
        r103 = r102.mErrorMsg;
    L27:
        r105.append(r103);
        r104.onError(new Throwable(r105.toString()));
        return;
    L23:
        r106 = null;
        goto L24
    L8:
        if (r100 != 6) goto L10;
        if (r102 != null) goto L19;
        this.f2971b.onError(new Throwable("Complete with empty result"));
        return;
    L19:
        this.f2971b.onNext(TuplesKt.to(Integer.valueOf(r102.mFileIndex), new com.bytedance.android.livesdk.jsbridge.methods.upload.models.a(r102.mImageTosKey, r102.mEncryptionMeta)));
        return;
    L10:
        if (r100 != 7) goto L37;
        this.f2972c.close();
        ObservableEmitter r107 = this.f2971b;
        StringBuilder r108 = new StringBuilder("single upload fail ");
        if (r102 == null) goto L15;
        r103 = r102.mErrorMsg;
    L15:
        r108.append(r103);
        r107.onError(new Throwable(r108.toString()));
        return;
    L37:
        return;
    L28:
        if (r102 == null) goto L35;
        this.f2970a.put(Integer.valueOf(r102.mFileIndex), Long.valueOf(r102.mProgress));
        int r109 = (int) ((CollectionsKt.sumOfLong(((LinkedHashMap) this.f2970a).values()) / ((double) (this.f2973d * 100))) * ((double) 100));
        CallContext r110 = this.f2974e;
        JSONObject r111 = new JSONObject();
        r111.put("progress", r109);
        Unit r112 = Unit.INSTANCE;
        r110.b("subscribe.upload.progress", r111);
        return;
    }

    public l(ObservableEmitter r100, BDImageUploader r101, int r102, CallContext r103) {
        this.f2971b = r100;
        this.f2972c = r101;
        this.f2973d = r102;
        this.f2974e = r103;
        this.f2970a = new LinkedHashMap();
    }
}
