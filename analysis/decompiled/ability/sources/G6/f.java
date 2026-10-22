package G6;

import B9.Q;
import F9.C0234l;
import X6.l;
import a.AbstractC0291a;
import a7.AbstractC0307c;
import android.content.Context;
import android.content.DialogInterface;
import com.stepos.policy.sdk.PolicyManager;
import com.stepos.widget.panel.StepOSLiteSheetSurface;
import com.volcengine.tos.TosClientException;
import com.volcengine.tos.model.object.UploadFileV2Checkpoint;
import com.volcengine.tos.model.object.UploadFileV2Input;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;
import stepos.support.v7.app.P;

/* loaded from: classes3.dex */
public final class f implements P {

    /* renamed from: a, reason: collision with root package name */
    public boolean f682a;
    public final Object b;
    public final Object c;
    public Object d;
    public Object e;
    public Serializable f;
    public Object g;
    public final Object h;

    public f(StepOSLiteSheetSurface stepOSLiteSheetSurface) {
        this.b = stepOSLiteSheetSurface;
        this.c = new D6.f(stepOSLiteSheetSurface);
        this.h = new c(new e(this, 0), new Q(this, 11), new Ba.f(12));
    }

    public static UploadFileV2Checkpoint c(String str) throws IOException {
        AbstractC0307c.a(str, "checkpointFilePath is null");
        File file = new File(str);
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[(int) file.length()];
            fileInputStream.read(bArr);
            UploadFileV2Checkpoint uploadFileV2Checkpoint = (UploadFileV2Checkpoint) a7.f.b.readValue(bArr, new l());
            fileInputStream.close();
            return uploadFileV2Checkpoint;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public void a() {
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        c cVar = (c) this.h;
        cVar.f679a = true;
        cVar.b = true;
        cVar.f = null;
        cVar.g = null;
        D6.f fVar = (D6.f) this.c;
        fVar.f383a.removeCallbacks(fVar.c);
        fVar.d();
        ((StepOSLiteSheetSurface) this.b).setBackground(null);
    }

    public void b(String str) {
        UploadFileV2Input uploadFileV2Input = (UploadFileV2Input) this.b;
        if (((UploadFileV2Checkpoint) this.d).getUploadPartInfos() == null || ((UploadFileV2Checkpoint) this.d).getUploadPartInfos().size() == 0 || str == null) {
            return;
        }
        ((UploadFileV2Checkpoint) this.d).getUploadPartInfos().sort(new M.d(8));
        long hashCrc64ecma = ((UploadFileV2Checkpoint) this.d).getUploadPartInfos().get(0).getHashCrc64ecma();
        for (int i = 1; i < ((UploadFileV2Checkpoint) this.d).getUploadPartInfos().size(); i++) {
            hashCrc64ecma = U7.a.r(hashCrc64ecma, ((UploadFileV2Checkpoint) this.d).getUploadPartInfos().get(i).getHashCrc64ecma(), ((UploadFileV2Checkpoint) this.d).getUploadPartInfos().get(i).getPartSize());
        }
        if (AbstractC0291a.s(U7.a.M(hashCrc64ecma), str)) {
            return;
        }
        if (uploadFileV2Input.isEnableCheckpoint()) {
            new File(uploadFileV2Input.getCheckpointFile()).delete();
        }
        throw new TosClientException("tos: expect crc64 " + str + ", actual crc64 " + hashCrc64ecma, null);
    }

    @Override // stepos.support.v7.app.P
    public void onPermissionClick(DialogInterface dialogInterface, boolean z10, boolean z11) {
        if (z11 && this.f682a) {
            PolicyManager.autoUploadRecord((Context) this.b, (String) this.c, (String) this.d, (String) this.e, (String[]) this.f, (String) this.g, "2");
        }
        ((P) this.h).onPermissionClick(dialogInterface, z10, z11);
    }

    public f(UploadFileV2Input uploadFileV2Input, C0234l c0234l, boolean z10) {
        AbstractC0307c.a(uploadFileV2Input, "UploadFileV2Input");
        AbstractC0307c.a(uploadFileV2Input.getFilePath(), "UploadFilePath");
        String bucket = uploadFileV2Input.getBucket();
        String key = uploadFileV2Input.getKey();
        AbstractC0307c.b(bucket);
        AbstractC0307c.c(key);
        AbstractC0307c.a(c0234l, "TosObjectRequestHandler");
        this.b = uploadFileV2Input;
        this.c = c0234l;
        this.f682a = z10;
        this.h = new AtomicLong(0L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(boolean z10, Context context, String str, String str2, String str3, String[] strArr, String str4, P p) {
        this.f682a = z10;
        this.b = context;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = strArr;
        this.g = str4;
        this.h = p;
    }
}
