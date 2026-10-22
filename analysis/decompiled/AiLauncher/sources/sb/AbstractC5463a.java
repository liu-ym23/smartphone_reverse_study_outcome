package sb;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0007\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00052\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H¦\u0002¢\u0006\u0004\b\u0007\u0010\b\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lsb/a;", "", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "typeArgumentsSerializers", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)Lkotlinx/serialization/KSerializer;", Const.INTENT_KEY_PKGNAME, "Lsb/a$a;", "Lsb/a$b;", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: sb.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5463a {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001J&\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00032\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lsb/a$a;", "Lsb/a;", "", "Lkotlinx/serialization/KSerializer;", "typeArgumentsSerializers", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)Lkotlinx/serialization/KSerializer;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lkotlinx/serialization/KSerializer;", Const.INTENT_KEY_PKGNAME, "()Lkotlinx/serialization/KSerializer;", "serializer", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: sb.a$a, reason: collision with other inner class name */
    public static final class C0520a extends AbstractC5463a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final KSerializer<?> serializer;

        @Override // sb.AbstractC5463a
        public KSerializer<?> a(List<? extends KSerializer<?>> typeArgumentsSerializers) {
            p.i(typeArgumentsSerializers, "typeArgumentsSerializers");
            return this.serializer;
        }

        public final KSerializer<?> b() {
            return this.serializer;
        }

        public boolean equals(Object other) {
            return (other instanceof C0520a) && p.d(((C0520a) other).serializer, this.serializer);
        }

        public int hashCode() {
            return this.serializer.hashCode();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001J&\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00032\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R1\u0010\u000b\u001a\u001c\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00078\u0006¢\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lsb/a$b;", "Lsb/a;", "", "Lkotlinx/serialization/KSerializer;", "typeArgumentsSerializers", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)Lkotlinx/serialization/KSerializer;", "Lkotlin/Function1;", "Lp9/l;", Const.INTENT_KEY_PKGNAME, "()Lp9/l;", Const.JSON_KEY_PROVIDER, "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: sb.a$b */
    public static final class b extends AbstractC5463a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC5074l<List<? extends KSerializer<?>>, KSerializer<?>> provider;

        @Override // sb.AbstractC5463a
        public KSerializer<?> a(List<? extends KSerializer<?>> typeArgumentsSerializers) {
            p.i(typeArgumentsSerializers, "typeArgumentsSerializers");
            return this.provider.invoke(typeArgumentsSerializers);
        }

        public final InterfaceC5074l<List<? extends KSerializer<?>>, KSerializer<?>> b() {
            return this.provider;
        }
    }

    public abstract KSerializer<?> a(List<? extends KSerializer<?>> typeArgumentsSerializers);
}
