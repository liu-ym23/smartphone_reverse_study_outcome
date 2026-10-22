package ch6;

import com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybGuestLinkChangeAction;
import com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybLinkCallScene;
import com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybMainLinkChangeAction;
import com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybMediaChangeAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public interface b {

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final a f23777a0 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f23778a = null;

        public a() {
        }

        static {
            f23778a = new a();
        }

        public static b a(MultiLinkHybLinkCallScene r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "callScene");
            Intrinsics.checkNotNullParameter(r101, "actionTypeStr");
            int r102 = ch6.a.f23776a[r100.ordinal()];
            b r103 = null;
            int r104 = 0;
            if (r102 != 1) goto L5;
            MultiLinkHybMediaChangeAction.Companion.getClass();
            Intrinsics.checkNotNullParameter(r101, "actionTypeStr");
            MultiLinkHybMediaChangeAction[] r105 = MultiLinkHybMediaChangeAction.values();
            int r106 = r105.length;
        L28:
            if (r104 >= r106) goto L33;
            MultiLinkHybMediaChangeAction r107 = r105[r104];
            if (Intrinsics.areEqual(r107.getActionType(), r101) == true) goto L31;
            r104 = r104 + 1;
            goto L28
        L31:
            r103 = r107;
        L33:
            if (r103 == null) goto L36;
        L46:
            return r103;
        L36:
            return new f();
        L5:
            if (r102 != 2) goto L7;
            MultiLinkHybMainLinkChangeAction.Companion.getClass();
            Intrinsics.checkNotNullParameter(r101, "actionTypeStr");
            MultiLinkHybMainLinkChangeAction[] r108 = MultiLinkHybMainLinkChangeAction.values();
            int r109 = r108.length;
        L19:
            if (r104 >= r109) goto L24;
            MultiLinkHybMainLinkChangeAction r110 = r108[r104];
            if (Intrinsics.areEqual(r110.getActionType(), r101) == true) goto L22;
            r104 = r104 + 1;
            goto L19
        L22:
            r103 = r110;
        L24:
            if (r103 != null) goto L46;
            return new f();
        L7:
            if (r102 != 3) goto L43;
            MultiLinkHybGuestLinkChangeAction.Companion.getClass();
            Intrinsics.checkNotNullParameter(r101, "actionTypeStr");
            MultiLinkHybGuestLinkChangeAction[] r111 = MultiLinkHybGuestLinkChangeAction.values();
            int r112 = r111.length;
        L10:
            if (r104 >= r112) goto L15;
            MultiLinkHybGuestLinkChangeAction r113 = r111[r104];
            if (Intrinsics.areEqual(r113.getActionType(), r101) == true) goto L13;
            r104 = r104 + 1;
            goto L10
        L13:
            r103 = r113;
        L15:
            if (r103 != null) goto L46;
            return new f();
        L43:
            return new f();
        }
    }

    static {
        f23777a0 = a.f23778a;
    }
}
