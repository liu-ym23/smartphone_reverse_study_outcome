package kotlinx.serialization.descriptors;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import nb.AbstractC4959l;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u0014\u0010 \u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006$À\u0006\u0003"}, d2 = {"Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "", "index", "", "e", "(I)Ljava/lang/String;", "name", "c", "(Ljava/lang/String;)I", "", "", "f", "(I)Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(I)Lkotlinx/serialization/descriptors/SerialDescriptor;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ljava/lang/String;", "serialName", "Lnb/l;", "getKind", "()Lnb/l;", "kind", Const.INTENT_KEY_PKGNAME, "()Z", "isNullable", "isInline", Const.INTENT_KEY_UMID, "()I", "elementsCount", "getAnnotations", "()Ljava/util/List;", "annotations", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SerialDescriptor {
    default boolean b() {
        return false;
    }

    int c(String name);

    int d();

    String e(int index);

    List<Annotation> f(int index);

    SerialDescriptor g(int index);

    default List<Annotation> getAnnotations() {
        return C1173v.m();
    }

    AbstractC4959l getKind();

    String h();

    boolean i(int index);

    default boolean isInline() {
        return false;
    }
}
