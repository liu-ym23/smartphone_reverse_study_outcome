package pb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import java.lang.ref.SoftReference;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u00028\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\n¨\u0006\f"}, d2 = {"Lpb/n0;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "Lkotlin/Function0;", "factory", Const.INTENT_KEY_APIKEY, "(Lp9/a;)Ljava/lang/Object;", "Ljava/lang/ref/SoftReference;", "Ljava/lang/ref/SoftReference;", SkillStoreKt.SKILL_DOC_TYPE_REFERENCE, "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: pb.n0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5111n0<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public volatile SoftReference<T> reference = new SoftReference<>(null);

    public final synchronized T a(InterfaceC5063a<? extends T> factory) {
        kotlin.jvm.internal.p.i(factory, "factory");
        T t10 = this.reference.get();
        if (t10 != null) {
            return t10;
        }
        T tInvoke = factory.invoke();
        this.reference = new SoftReference<>(tInvoke);
        return tInvoke;
    }
}
