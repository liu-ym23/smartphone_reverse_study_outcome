package p7;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \u001e*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0014B;\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0005\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR%\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001b\u001a\u0004\b\u0017\u0010\u001cR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u0014\u0010\u001a¨\u0006\u001f"}, d2 = {"Lp7/a;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "abilityName", "result", "", "meta", "customData", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Ljava/util/Map;Ljava/lang/Object;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getAbilityName", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Object;", "c", "()Ljava/lang/Object;", "Ljava/util/Map;", "()Ljava/util/Map;", Const.INTENT_KEY_UMID, "e", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* renamed from: p7.a, reason: case insensitive filesystem and from toString */
/* loaded from: classes.dex */
public final /* data */ class AbilityResult<T> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String abilityName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final T result;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final Map<String, Object> meta;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final Object customData;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b\"\u0004\b\u0001\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u00012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lp7/a$a;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "", "abilityName", "result", "Lp7/b;", "appUI", "custom", "Lp7/a;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/Object;Lp7/b;Ljava/lang/Object;)Lp7/a;", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* renamed from: p7.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final <T> AbilityResult<T> a(String abilityName, T result, AppUI appUI, Object custom) {
            p.i(abilityName, "abilityName");
            HashMap map = new HashMap();
            if (appUI != null) {
                map.put("appUI", appUI);
            }
            return new AbilityResult<>(abilityName, result, map, custom);
        }

        public Companion() {
        }
    }

    public AbilityResult(String abilityName, T t10, Map<String, ? extends Object> map, Object obj) {
        p.i(abilityName, "abilityName");
        this.abilityName = abilityName;
        this.result = t10;
        this.meta = map;
        this.customData = obj;
    }

    /* renamed from: a, reason: from getter */
    public final Object getCustomData() {
        return this.customData;
    }

    public final Map<String, Object> b() {
        return this.meta;
    }

    public final T c() {
        return this.result;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AbilityResult)) {
            return false;
        }
        AbilityResult abilityResult = (AbilityResult) other;
        return p.d(this.abilityName, abilityResult.abilityName) && p.d(this.result, abilityResult.result) && p.d(this.meta, abilityResult.meta) && p.d(this.customData, abilityResult.customData);
    }

    public int hashCode() {
        int iHashCode = this.abilityName.hashCode() * 31;
        T t10 = this.result;
        int iHashCode2 = (iHashCode + (t10 == null ? 0 : t10.hashCode())) * 31;
        Map<String, Object> map = this.meta;
        int iHashCode3 = (iHashCode2 + (map == null ? 0 : map.hashCode())) * 31;
        Object obj = this.customData;
        return iHashCode3 + (obj != null ? obj.hashCode() : 0);
    }

    public String toString() {
        return "AbilityResult(abilityName=" + this.abilityName + ", result=" + this.result + ", meta=" + this.meta + ", customData=" + this.customData + ")";
    }
}
