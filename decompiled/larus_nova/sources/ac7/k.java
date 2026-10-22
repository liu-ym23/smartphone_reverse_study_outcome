package ac7;

import com.huawei.hms.framework.common.ContainerUtils;
import kotlin.TypeCastException;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class k extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2758a = 0;

    public static final class a {
        public static k a(String r100) {
            int r101 = StringsKt.indexOf$default(r100, ContainerUtils.KEY_VALUE_DELIMITER, 0, false, 6, null);
            boolean r102 = StringsKt.startsWith$default(r100, "!", false, 2, null);
            if (r102 == false) goto L5;
            String r103 = r100.substring(1);
        L6:
            if (r101 < 1) goto L10;
            int r104 = r101 - 1;
            if (r100.charAt(r104) != '!') goto L10;
            boolean r105 = true;
        L11:
            if (r104 >= 0) goto L13;
            k r106 = new l(r103);
        L18:
            if (r102 == true) goto L20;
            return r106;
        L20:
            return new h(r106);
        L13:
            if (r103 == null) goto L22;
            String r107 = r103.substring(0, r104);
            String r108 = r103.substring(r101 + 1);
            if (r105 == false) goto L17;
            r106 = new i(r107, r108);
            goto L18
        L17:
            r106 = new f(r107, r108);
            goto L18
        L22:
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        L10:
            r104 = r101;
            r105 = false;
            goto L11
        L5:
            r103 = r100;
            goto L6
        }
    }

    static {
    }

    public k() {
    }
}
