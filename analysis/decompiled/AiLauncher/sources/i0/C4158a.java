package i0;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\nR\u0018\u0010\u000f\u001a\u00060\u0002j\u0002`\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e¨\u0006\u0012"}, d2 = {"Li0/a;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Object;", "Ljava/util/concurrent/atomic/AtomicReference;", "Li0/c;", "Landroidx/compose/runtime/internal/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", C3081a.FOCUS_MAP_NAME, "Landroidx/compose/runtime/platform/SynchronizedObject;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Object;", "writeMutex", "c", "mainThreadValue", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: i0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4158a<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AtomicReference<c> map = new AtomicReference<>(b.f33063a);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Object writeMutex = new Object();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public T mainThreadValue;

    public final T a() {
        long jA = e.a();
        return jA == d.a() ? this.mainThreadValue : (T) this.map.get().b(jA);
    }
}
