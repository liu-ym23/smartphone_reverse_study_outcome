package qb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlinx.serialization.json.internal.WriteMode;
import lb.InterfaceC4883a;
import rb.C5246A;
import rb.C5266p;
import rb.I;
import rb.L;
import rb.M;
import rb.P;
import rb.S;
import sb.AbstractC5465c;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00152\u00020\u0001:\u0001\rB\u0019\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\r\u001a\u00020\f\"\u0004\b\u0000\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\b\b\u0001\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0015\u001a\u00020\u0014\"\u0004\b\u0000\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0018\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00142\b\b\u0001\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u001f\u001a\u0004\b \u0010!R \u0010(\u001a\u00020\"8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0012\u0010#\u0012\u0004\b&\u0010'\u001a\u0004\b$\u0010%\u0082\u0001\u0002)*¨\u0006+"}, d2 = {"Lqb/a;", "Llb/x;", "Lqb/f;", "configuration", "Lsb/c;", "serializersModule", "<init>", "(Lqb/f;Lsb/c;)V", ExifInterface.GPS_DIRECTION_TRUE, "Llb/m;", "serializer", UxipConstants.f30680s, "", Const.INTENT_KEY_APIKEY, "(Llb/m;Ljava/lang/Object;)Ljava/lang/String;", "Llb/a;", "deserializer", "string", "c", "(Llb/a;Ljava/lang/String;)Ljava/lang/Object;", "Lqb/i;", Const.INTENT_KEY_UMID, "(Llb/m;Ljava/lang/Object;)Lqb/i;", "element", Const.INTENT_KEY_PKGNAME, "(Llb/a;Lqb/i;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Lqb/i;", "Lqb/f;", "e", "()Lqb/f;", "Lsb/c;", "getSerializersModule", "()Lsb/c;", "Lrb/p;", "Lrb/p;", "f", "()Lrb/p;", "get_schemaCache$kotlinx_serialization_json$annotations", "()V", "_schemaCache", "Lqb/a$a;", "Lqb/u;", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: qb.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5171a implements lb.x {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final JsonConfiguration configuration;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final AbstractC5465c serializersModule;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final C5266p _schemaCache;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lqb/a$a;", "Lqb/a;", "<init>", "()V", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: qb.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion extends AbstractC5171a {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public Companion() {
            super(new JsonConfiguration(false, false, false, false, false, false, null, false, false, null, false, false, null, false, false, false, null, 131071, null), sb.d.a(), null);
        }
    }

    public /* synthetic */ AbstractC5171a(JsonConfiguration jsonConfiguration, AbstractC5465c abstractC5465c, kotlin.jvm.internal.i iVar) {
        this(jsonConfiguration, abstractC5465c);
    }

    @Override // lb.x
    public final <T> String a(lb.m<? super T> serializer, T value) {
        kotlin.jvm.internal.p.i(serializer, "serializer");
        C5246A c5246a = new C5246A();
        try {
            rb.z.a(this, c5246a, serializer, value);
            return c5246a.toString();
        } finally {
            c5246a.g();
        }
    }

    public final <T> T b(InterfaceC4883a<? extends T> deserializer, i element) {
        kotlin.jvm.internal.p.i(deserializer, "deserializer");
        kotlin.jvm.internal.p.i(element, "element");
        return (T) P.a(this, element, deserializer);
    }

    public final <T> T c(InterfaceC4883a<? extends T> deserializer, String string) {
        kotlin.jvm.internal.p.i(deserializer, "deserializer");
        kotlin.jvm.internal.p.i(string, "string");
        L lA = M.a(this, string);
        T t10 = (T) new I(this, WriteMode.OBJ, lA, deserializer.getDescriptor(), null).decodeSerializableValue(deserializer);
        lA.x();
        return t10;
    }

    public final <T> i d(lb.m<? super T> serializer, T value) {
        kotlin.jvm.internal.p.i(serializer, "serializer");
        return S.d(this, value, serializer);
    }

    /* renamed from: e, reason: from getter */
    public final JsonConfiguration getConfiguration() {
        return this.configuration;
    }

    /* renamed from: f, reason: from getter */
    public final C5266p get_schemaCache() {
        return this._schemaCache;
    }

    public final i g(String string) {
        kotlin.jvm.internal.p.i(string, "string");
        return (i) c(q.f38674a, string);
    }

    @Override // lb.k
    public AbstractC5465c getSerializersModule() {
        return this.serializersModule;
    }

    public AbstractC5171a(JsonConfiguration jsonConfiguration, AbstractC5465c abstractC5465c) {
        this.configuration = jsonConfiguration;
        this.serializersModule = abstractC5465c;
        this._schemaCache = new C5266p();
    }
}
