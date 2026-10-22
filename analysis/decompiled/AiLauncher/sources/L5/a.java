package L5;

import La.H;
import android.content.Context;
import android.content.SharedPreferences;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0002\r\u000fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0013\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"LL5/a;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "packageName", "activityName", "LY8/t;", "c", "(Ljava/lang/String;Ljava/lang/String;)V", "LL5/a$b;", Const.INTENT_KEY_PKGNAME, "()LL5/a$b;", Const.INTENT_KEY_APIKEY, "()V", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "preferences", "Landroid/content/SharedPreferences;", "Companion", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    private static final C0073a Companion = new C0073a(null);

    @Deprecated
    public static final String KEY_ACTIVITY = "activity";

    @Deprecated
    public static final String KEY_PACKAGE = "package";

    @Deprecated
    public static final String PREFERENCES_NAME = "express_scene_recovery";
    private final SharedPreferences preferences;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"LL5/a$a;", "", "<init>", "()V", "", "PREFERENCES_NAME", "Ljava/lang/String;", "KEY_PACKAGE", "KEY_ACTIVITY", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: L5.a$a, reason: collision with other inner class name */
    public static final class C0073a {
        public /* synthetic */ C0073a(i iVar) {
            this();
        }

        public C0073a() {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"LL5/a$b;", "", "", "packageName", "activityName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: L5.a$b, reason: from toString */
    public static final /* data */ class Scene {
        private final String activityName;
        private final String packageName;

        public Scene(String packageName, String activityName) {
            p.i(packageName, "packageName");
            p.i(activityName, "activityName");
            this.packageName = packageName;
            this.activityName = activityName;
        }

        /* renamed from: a, reason: from getter */
        public final String getActivityName() {
            return this.activityName;
        }

        /* renamed from: b, reason: from getter */
        public final String getPackageName() {
            return this.packageName;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Scene)) {
                return false;
            }
            Scene scene = (Scene) other;
            return p.d(this.packageName, scene.packageName) && p.d(this.activityName, scene.activityName);
        }

        public int hashCode() {
            return (this.packageName.hashCode() * 31) + this.activityName.hashCode();
        }

        public String toString() {
            return "Scene(packageName=" + this.packageName + ", activityName=" + this.activityName + ")";
        }
    }

    public a(Context context) {
        p.i(context, "context");
        this.preferences = context.getApplicationContext().getSharedPreferences(PREFERENCES_NAME, 0);
    }

    public final void a() {
        this.preferences.edit().clear().apply();
    }

    public final Scene b() {
        String string = this.preferences.getString("package", null);
        String string2 = this.preferences.getString("activity", null);
        if (string == null || H.x0(string) || string2 == null || H.x0(string2)) {
            return null;
        }
        return new Scene(string, string2);
    }

    public final void c(String packageName, String activityName) {
        p.i(packageName, "packageName");
        if (H.x0(packageName) || activityName == null || H.x0(activityName)) {
            a();
        } else {
            this.preferences.edit().putString("package", packageName).putString("activity", activityName).apply();
        }
    }
}
