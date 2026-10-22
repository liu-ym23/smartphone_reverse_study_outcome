package qb;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import mb.C4931a;
import nb.AbstractC4959l;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lqb/E;", "Lkotlinx/serialization/KSerializer;", "Lqb/D;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "c", "(Lkotlinx/serialization/encoding/Encoder;Lqb/D;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", Const.INTENT_KEY_PKGNAME, "(Lkotlinx/serialization/encoding/Decoder;)Lqb/D;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", Const.INTENT_KEY_APIKEY, "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class E implements KSerializer<D> {

    /* renamed from: a, reason: collision with root package name */
    public static final E f38623a = new E();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final SerialDescriptor descriptor = a.f38625b;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014R \u0010\u0019\u001a\u00020\u00068\u0016X\u0097D¢\u0006\u0012\n\u0004\b\n\u0010\u0015\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001d\u001a\u00020\u001a8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u00128VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020\u00128VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0014\u0010$\u001a\u00020\u00048\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0\f8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Lqb/E$a;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "<init>", "()V", "", "index", "", "e", "(I)Ljava/lang/String;", "name", "c", "(Ljava/lang/String;)I", "", "", "f", "(I)Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(I)Lkotlinx/serialization/descriptors/SerialDescriptor;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)Z", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ljava/lang/String;", "getSerialName$annotations", "serialName", "Lnb/l;", "getKind", "()Lnb/l;", "kind", Const.INTENT_KEY_PKGNAME, "()Z", "isNullable", "isInline", Const.INTENT_KEY_UMID, "()I", "elementsCount", "getAnnotations", "()Ljava/util/List;", "annotations", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements SerialDescriptor {

        /* renamed from: b, reason: collision with root package name */
        public static final a f38625b = new a();

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public static final String serialName = "kotlinx.serialization.json.JsonObject";

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SerialDescriptor f38627a = C4931a.k(C4931a.H(kotlin.jvm.internal.y.f34840a), q.f38674a).getDescriptor();

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean b() {
            return this.f38627a.b();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public int c(String name) {
            kotlin.jvm.internal.p.i(name, "name");
            return this.f38627a.c(name);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        /* renamed from: d */
        public int getElementsCount() {
            return this.f38627a.getElementsCount();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public String e(int index) {
            return this.f38627a.e(index);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public List<Annotation> f(int index) {
            return this.f38627a.f(index);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public SerialDescriptor g(int index) {
            return this.f38627a.g(index);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public List<Annotation> getAnnotations() {
            return this.f38627a.getAnnotations();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public AbstractC4959l getKind() {
            return this.f38627a.getKind();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        /* renamed from: h */
        public String getSerialName() {
            return serialName;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean i(int index) {
            return this.f38627a.i(index);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        /* renamed from: isInline */
        public boolean getIsInline() {
            return this.f38627a.getIsInline();
        }
    }

    @Override // lb.InterfaceC4883a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public D deserialize(Decoder decoder) {
        kotlin.jvm.internal.p.i(decoder, "decoder");
        r.g(decoder);
        return new D((Map) C4931a.k(C4931a.H(kotlin.jvm.internal.y.f34840a), q.f38674a).deserialize(decoder));
    }

    @Override // lb.m
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, D value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        r.h(encoder);
        C4931a.k(C4931a.H(kotlin.jvm.internal.y.f34840a), q.f38674a).serialize(encoder, value);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }
}
