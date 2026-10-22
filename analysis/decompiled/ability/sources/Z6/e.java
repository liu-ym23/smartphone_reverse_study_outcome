package Z6;

import F9.C0234l;
import com.volcengine.tos.model.object.CopyEventListener;
import com.volcengine.tos.model.object.CopyPartInfo;
import com.volcengine.tos.model.object.ObjectMetaRequestOptions;
import com.volcengine.tos.model.object.ResumableCopyObjectCheckpoint;
import com.volcengine.tos.model.object.UploadPartCopyV2Output;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class e extends h implements g {

    /* renamed from: a, reason: collision with root package name */
    public ResumableCopyObjectCheckpoint f1602a;
    public String b;
    public CopyPartInfo c;
    public boolean d;
    public String e;
    public CopyEventListener f;
    public C0234l g;
    public UploadPartCopyV2Output h;
    public ObjectMetaRequestOptions i;

    /* renamed from: j, reason: collision with root package name */
    public long f1603j;

    @Override // Z6.g
    public final Object a() {
        return this.h;
    }

    @Override // Z6.h
    public final Callable b() {
        return new b(this, 1);
    }
}
