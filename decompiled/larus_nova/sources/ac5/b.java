package ac5;

import com.bytedance.ee.bear.list.homepage.navigation.NavigationEnum;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes16.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final String a(int r100) {
        if (r100 != NavigationEnum.MY_SPACE.f228307id) goto L6;
        return WikiSpaceType.PERSONAL;
    L6:
        if (r100 != NavigationEnum.SHARED_SPACE.f228307id) goto L9;
        return "shared";
    L9:
        if (r100 != NavigationEnum.FAVORITE.f228307id) goto L12;
        return "favorites";
    L12:
        if (r100 != NavigationEnum.MANUAL_OFFLINE.f228307id) goto L14;
        return OperationName.OPERATION_OFFLINE_AVAILABLE;
    L14:
        return "";
    }
}
