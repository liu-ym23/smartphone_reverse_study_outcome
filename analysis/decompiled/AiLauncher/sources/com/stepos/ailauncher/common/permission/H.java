package com.stepos.ailauncher.common.permission;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.permission.AbstractC3187d;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/common/permission/H;", "", "<init>", "()V", "", "", "permissions", "Lcom/stepos/ailauncher/common/permission/SceneRequestMode;", "mode", "onceKey", "Lcom/stepos/ailauncher/common/permission/c;", "checker", "Lcom/stepos/ailauncher/common/permission/a;", "store", "Lcom/stepos/ailauncher/common/permission/d;", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;Lcom/stepos/ailauncher/common/permission/SceneRequestMode;Ljava/lang/String;Lcom/stepos/ailauncher/common/permission/c;Lcom/stepos/ailauncher/common/permission/a;)Lcom/stepos/ailauncher/common/permission/d;", "permission_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class H {
    public static final H INSTANCE = new H();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SceneRequestMode.values().length];
            try {
                iArr[SceneRequestMode.ON_DEMAND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SceneRequestMode.ONCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final AbstractC3187d a(List<String> permissions, SceneRequestMode mode, String onceKey, InterfaceC3186c checker, InterfaceC3184a store) {
        kotlin.jvm.internal.p.i(permissions, "permissions");
        kotlin.jvm.internal.p.i(mode, "mode");
        kotlin.jvm.internal.p.i(checker, "checker");
        kotlin.jvm.internal.p.i(store, "store");
        List<String> list = permissions;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (!checker.a((String) it.next())) {
                    int i10 = a.$EnumSwitchMapping$0[mode.ordinal()];
                    if (i10 == 1) {
                        return AbstractC3187d.b.INSTANCE;
                    }
                    if (i10 == 2) {
                        return (onceKey == null || !store.a(onceKey)) ? AbstractC3187d.b.INSTANCE : AbstractC3187d.c.INSTANCE;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        return AbstractC3187d.a.INSTANCE;
    }
}
