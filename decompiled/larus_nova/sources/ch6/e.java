package ch6;

import com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybGuestLinkGetAction;
import com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybLinkCallScene;
import com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybMainLinkGetAction;
import com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybMediaGetAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public interface e {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final a f23782c0 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f23783a = null;

        public a() {
        }

        static {
            f23783a = new a();
        }

        public static e a(MultiLinkHybLinkCallScene r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "callScene");
            Intrinsics.checkNotNullParameter(r101, "actionTypeStr");
            int r102 = d.f23781a[r100.ordinal()];
            e r103 = null;
            int r104 = 0;
            if (r102 != 1) goto L5;
            MultiLinkHybMediaGetAction.Companion.getClass();
            Intrinsics.checkNotNullParameter(r101, "actionTypeStr");
            MultiLinkHybMediaGetAction[] r105 = MultiLinkHybMediaGetAction.values();
            int r106 = r105.length;
        L28:
            if (r104 >= r106) goto L33;
            MultiLinkHybMediaGetAction r107 = r105[r104];
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
            return new g();
        L5:
            if (r102 != 2) goto L7;
            MultiLinkHybMainLinkGetAction.Companion.getClass();
            Intrinsics.checkNotNullParameter(r101, "actionTypeStr");
            MultiLinkHybMainLinkGetAction[] r108 = MultiLinkHybMainLinkGetAction.values();
            int r109 = r108.length;
        L19:
            if (r104 >= r109) goto L24;
            MultiLinkHybMainLinkGetAction r110 = r108[r104];
            if (Intrinsics.areEqual(r110.getActionType(), r101) == true) goto L22;
            r104 = r104 + 1;
            goto L19
        L22:
            r103 = r110;
        L24:
            if (r103 != null) goto L46;
            return new g();
        L7:
            if (r102 != 3) goto L43;
            MultiLinkHybGuestLinkGetAction.Companion.getClass();
            Intrinsics.checkNotNullParameter(r101, "actionTypeStr");
            MultiLinkHybGuestLinkGetAction[] r111 = MultiLinkHybGuestLinkGetAction.values();
            int r112 = r111.length;
        L10:
            if (r104 >= r112) goto L15;
            MultiLinkHybGuestLinkGetAction r113 = r111[r104];
            if (Intrinsics.areEqual(r113.getActionType(), r101) == true) goto L13;
            r104 = r104 + 1;
            goto L10
        L13:
            r103 = r113;
        L15:
            if (r103 != null) goto L46;
            return new g();
        L43:
            return new g();
        }
    }

    static {
        f23782c0 = a.f23783a;
    }
}
