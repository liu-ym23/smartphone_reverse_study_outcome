package s8;

import android.text.TextUtils;
import com.bytedanceos.common.data.AppFilter;
import com.bytedanceos.common.model.AppInfo;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppFilter f24533a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AppFilter f24534b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AppFilter f24535c = null;

    public class a implements AppFilter {
        public a() {
        }

        @Override // com.bytedanceos.common.data.AppFilter
        public boolean filter(AppInfo r10) {
            if (1 == r10.mAppType) goto L7;
            return false;
        L7:
            return true;
        }
    }

    /* JADX INFO: renamed from: s8.b$b, reason: collision with other inner class name */
    public class C0378b implements AppFilter {
        public C0378b() {
        }

        @Override // com.bytedanceos.common.data.AppFilter
        public boolean filter(AppInfo r10) {
            if (r10 != null) goto L5;
        L40:
            return false;
        L5:
            if (r10.appSource == null) goto L40;
            if ("com.lbt.gms".equals(r10.appPackageName) == false) goto L10;
            return true;
        L10:
            String r11 = r10.appSource;
            r11.hashCode();
            byte r12 = -1;
            switch(r11.hashCode()) {
                case -2092690800: goto L34;
                case -1407250528: goto L30;
                case -1091966885: goto L26;
                case 102477: goto L22;
                case 814389169: goto L18;
                case 1362212369: goto L14;
                default: goto L37;
            };
        L37:
            switch(r12) {
                case 0: goto L39;
                case 1: goto L39;
                case 2: goto L39;
                case 3: goto L39;
                case 4: goto L39;
                case 5: goto L39;
                default: goto L38;
            };
        L38:
            return false;
        L39:
            return true;
        L14:
            if (r11.equals("sys_app_silence") == false) goto L37;
            r12 = 5;
            goto L37
        L18:
            if (r11.equals("sys_app_default") == false) goto L37;
            r12 = 4;
            goto L37
        L22:
            if (r11.equals("gms") == false) goto L37;
            r12 = 3;
            goto L37
        L26:
            if (r11.equals("sys_app_force") == false) goto L37;
            r12 = 2;
            goto L37
        L30:
            if (r11.equals("launcher") == false) goto L37;
            r12 = 1;
            goto L37
        L34:
            if (r11.equals("sys_app_silence_mobile") == false) goto L37;
            r12 = 0;
            goto L37
        }
    }

    public class c implements AppFilter {
        public c() {
        }

        @Override // com.bytedanceos.common.data.AppFilter
        public boolean filter(AppInfo r10) {
            if (r10 != null) goto L4;
        L7:
            return true;
        L4:
            if (TextUtils.isEmpty(r10.appName) == true) goto L7;
            return false;
        }
    }

    static {
        f24533a = new a();
        f24534b = new C0378b();
        f24535c = new c();
    }

    public static AppFilter a() {
        return f24535c;
    }

    public static AppFilter b() {
        return f24533a;
    }

    public static AppFilter c() {
        return f24534b;
    }
}
