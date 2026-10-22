package Z6;

import F9.C0234l;
import com.volcengine.tos.model.object.DownloadEventListener;
import com.volcengine.tos.model.object.DownloadFileCheckpoint;
import com.volcengine.tos.model.object.DownloadPartInfo;
import com.volcengine.tos.model.object.HeadObjectV2Input;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public final class c extends h implements g {

    /* renamed from: a, reason: collision with root package name */
    public final DownloadFileCheckpoint f1599a;
    public HeadObjectV2Input b;
    public final DownloadPartInfo c;
    public boolean d;
    public String e;
    public boolean f;
    public DownloadEventListener g;
    public C0234l h;
    public long i;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicLong f1600j;

    public c(DownloadFileCheckpoint downloadFileCheckpoint, int i, AtomicLong atomicLong) {
        this.f1599a = downloadFileCheckpoint;
        this.c = downloadFileCheckpoint.getDownloadPartInfos().get(i);
        this.f1600j = atomicLong;
    }

    @Override // Z6.g
    public final Object a() {
        return this.c;
    }

    @Override // Z6.h
    public final Callable b() {
        return new b(this, 0);
    }
}
