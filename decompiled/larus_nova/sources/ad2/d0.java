package ad2;

import android.net.Uri;
import bytedance.io.BdFileSystem;
import com.bytedance.android.live.core.utils.s1;
import com.ss.bduploader.BDMediaDataReader;
import java.io.BufferedInputStream;
import java.io.InputStream;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d0 implements BDMediaDataReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InputStream f2951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BufferedInputStream f2952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f2953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f2954d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.bduploader.BDMediaDataReader
    public final int close(int r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        BufferedInputStream r102 = this.f2952b;     // Catch: Throwable -> L8
        if (r102 == null) goto L5;
        r102.close();     // Catch: Throwable -> L8
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L8
        return 0;
    L5:
        r103 = null;
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return 0;
    }

    @Override // com.ss.bduploader.BDMediaDataReader
    public final int open(int r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(BdFileSystem.getInputStream(s1.getContext(), this.f2953c));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r102) == false) goto L9;
        r102 = null;
    L9:
        InputStream r103 = (InputStream) r102;
        this.f2951a = r103;
        if (r103 == null) goto L12;
        return 1;
    L12:
        return -1;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public d0(Uri r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        this.f2953c = r100;
        this.f2954d = r101;
    }

    @Override // com.ss.bduploader.BDMediaDataReader
    public final long getValue(int r100, int r101) {
        if (r101 == 0) goto L4;
        return 0;
    L4:
        return this.f2954d;
    }

    @Override // com.ss.bduploader.BDMediaDataReader
    public final int read(int r100, long r101, byte[] r102, int r103) {
        if (this.f2951a != null) goto L7;
        return -1;
    L7:
        if (r101 <= this.f2954d) goto L10;
        return 0;
    L10:
        BufferedInputStream r104 = new BufferedInputStream(this.f2951a);
        this.f2952b = r104;
        return r104.read(r102);
    }
}
