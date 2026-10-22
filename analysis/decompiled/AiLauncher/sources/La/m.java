package La;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import kotlin.Metadata;
import v9.C5680i;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0015J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u0000H&¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"LLa/m;", "", "next", "()LLa/m;", "Lv9/i;", Const.INTENT_KEY_APIKEY, "()Lv9/i;", "range", "", "getValue", "()Ljava/lang/String;", UxipConstants.f30680s, "LLa/k;", Const.INTENT_KEY_UMID, "()LLa/k;", "groups", "", "c", "()Ljava/util/List;", "groupValues", "LLa/m$b;", Const.INTENT_KEY_PKGNAME, "()LLa/m$b;", "destructured", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface m {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public static b a(m mVar) {
            return new b(mVar);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"LLa/m$b;", "", "LLa/m;", "match", "<init>", "(LLa/m;)V", Const.INTENT_KEY_APIKEY, "LLa/m;", "()LLa/m;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final m match;

        public b(m match) {
            kotlin.jvm.internal.p.i(match, "match");
            this.match = match;
        }

        /* renamed from: a, reason: from getter */
        public final m getMatch() {
            return this.match;
        }
    }

    C5680i a();

    b b();

    List<String> c();

    InterfaceC0961k d();

    String getValue();

    m next();
}
