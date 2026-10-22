package Z6;

import F9.C0234l;
import com.volcengine.tos.model.object.ObjectMetaRequestOptions;
import com.volcengine.tos.model.object.UploadEventListener;
import com.volcengine.tos.model.object.UploadFileV2Checkpoint;
import com.volcengine.tos.model.object.UploadPartInfo;
import com.volcengine.tos.model.object.UploadPartV2Output;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public final class i extends h implements g {

    /* renamed from: a, reason: collision with root package name */
    public final UploadFileV2Checkpoint f1605a;
    public final UploadPartInfo b;
    public boolean c;
    public String d;
    public UploadEventListener e;
    public C0234l f;
    public UploadPartV2Output g;
    public ObjectMetaRequestOptions h;
    public long i;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicLong f1606j;

    public i(UploadFileV2Checkpoint uploadFileV2Checkpoint, int i, AtomicLong atomicLong) {
        this.f1605a = uploadFileV2Checkpoint;
        this.b = uploadFileV2Checkpoint.getUploadPartInfos().get(i);
        this.f1606j = atomicLong;
    }

    @Override // Z6.g
    public final Object a() {
        return this.g;
    }

    @Override // Z6.h
    public final Callable b() {
        return new b(this, 2);
    }
}
