package rb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;
import qb.AbstractC5171a;
import qb.C5172b;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001a¨\u0006\u001e"}, d2 = {"Lrb/D;", "Lrb/c;", "Lqb/a;", "json", "Lqb/b;", UxipConstants.f30680s, "<init>", "(Lqb/a;Lqb/b;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "index", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/String;", "tag", "Lqb/i;", "G", "(Ljava/lang/String;)Lqb/i;", "decodeElementIndex", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lqb/b;", "X", "()Lqb/b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "I", ContentDisposition.Parameters.Size, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "currentIndex", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: rb.D, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5249D extends AbstractC5253c {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final C5172b value;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final int size;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public int currentIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5249D(AbstractC5171a json, C5172b value) {
        super(json, value, null, 4, null);
        kotlin.jvm.internal.p.i(json, "json");
        kotlin.jvm.internal.p.i(value, "value");
        this.value = value;
        this.size = getValue().size();
        this.currentIndex = -1;
    }

    @Override // pb.AbstractC5115p0
    public String A(SerialDescriptor descriptor, int index) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        return String.valueOf(index);
    }

    @Override // rb.AbstractC5253c
    public qb.i G(String tag) {
        kotlin.jvm.internal.p.i(tag, "tag");
        return getValue().get(Integer.parseInt(tag));
    }

    @Override // rb.AbstractC5253c
    /* renamed from: X, reason: from getter */
    public C5172b getValue() {
        return this.value;
    }

    @Override // ob.c
    public int decodeElementIndex(SerialDescriptor descriptor) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        int i10 = this.currentIndex;
        if (i10 >= this.size - 1) {
            return -1;
        }
        int i11 = i10 + 1;
        this.currentIndex = i11;
        return i11;
    }
}
