package M0;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0002\n\u0007B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H¦\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00010\tH&¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"LM0/a;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "LM0/a$a;", "key", Const.INTENT_KEY_PKGNAME, "(LM0/a$a;)Ljava/lang/Object;", "", Const.INTENT_KEY_APIKEY, "()Ljava/util/Map;", "Landroidx/datastore/preferences/core/MutablePreferences;", "c", "()Landroidx/datastore/preferences/core/MutablePreferences;", Const.INTENT_KEY_UMID, "()LM0/a;", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract class a {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0012"}, d2 = {"LM0/a$a;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "name", "<init>", "(Ljava/lang/String;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: M0.a$a, reason: collision with other inner class name */
    public static final class C0079a<T> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final String name;

        public C0079a(String name) {
            p.i(name, "name");
            this.name = name;
        }

        /* renamed from: a, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public boolean equals(Object other) {
            if (other instanceof C0079a) {
                return p.d(this.name, ((C0079a) other).name);
            }
            return false;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return this.name;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R\u001a\u0010\u000b\u001a\u00028\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n¨\u0006\f"}, d2 = {"LM0/a$b;", ExifInterface.GPS_DIRECTION_TRUE, "", "LM0/a$a;", Const.INTENT_KEY_APIKEY, "LM0/a$a;", "()LM0/a$a;", "key", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Object;", "()Ljava/lang/Object;", UxipConstants.f30680s, "datastore-preferences-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b<T> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final C0079a<T> key;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final T value;

        public final C0079a<T> a() {
            return this.key;
        }

        public final T b() {
            return this.value;
        }
    }

    public abstract Map<C0079a<?>, Object> a();

    public abstract <T> T b(C0079a<T> key);

    public final MutablePreferences c() {
        return new MutablePreferences(kotlin.collections.a.C(a()), false);
    }

    public final a d() {
        return new MutablePreferences(kotlin.collections.a.C(a()), true);
    }
}
