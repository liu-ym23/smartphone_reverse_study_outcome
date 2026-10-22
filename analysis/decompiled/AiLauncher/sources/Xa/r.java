package Xa;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferOverflow;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B-\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"LXa/r;", ExifInterface.GPS_DIRECTION_TRUE, "", "LXa/b;", "upstream", "", "extraBufferCapacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/coroutines/d;", "context", "<init>", "(LXa/b;ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/coroutines/d;)V", Const.INTENT_KEY_APIKEY, "LXa/b;", Const.INTENT_KEY_PKGNAME, "I", "c", "Lkotlinx/coroutines/channels/BufferOverflow;", Const.INTENT_KEY_UMID, "Lkotlin/coroutines/d;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class r<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final b<T> upstream;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int extraBufferCapacity;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final BufferOverflow onBufferOverflow;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final kotlin.coroutines.d context;

    /* JADX WARN: Multi-variable type inference failed */
    public r(b<? extends T> bVar, int i10, BufferOverflow bufferOverflow, kotlin.coroutines.d dVar) {
        this.upstream = bVar;
        this.extraBufferCapacity = i10;
        this.onBufferOverflow = bufferOverflow;
        this.context = dVar;
    }
}
