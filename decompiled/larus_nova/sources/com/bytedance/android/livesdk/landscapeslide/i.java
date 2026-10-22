package com.bytedance.android.livesdk.landscapeslide;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f147014c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f147015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MatchMode f147016b;

    public static final class a {
        @JvmStatic
        public static boolean a(List r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "list");
            Intrinsics.checkNotNullParameter(r101, "inputSource");
            Iterator r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L15;
            i r103 = (i) r102.next();
            r103.getClass();
            Intrinsics.checkNotNullParameter(r101, "inputSource");
            MatchMode r104 = r103.f147016b;
            int r105 = j.f147017a[r104.ordinal()];
            if (r105 != 1) goto L8;
            boolean r106 = Intrinsics.areEqual(r103.f147015a, r101);
        L13:
            if (r106 == false) goto L4;
            return true;
        L8:
            if (r105 != 2) goto L11;
            r106 = Pattern.matches(r103.f147015a, r101);
            goto L13
        L11:
            throw new NoWhenBranchMatchedException();
        L15:
            return false;
        }
    }

    static {
    }

    public i(String r100, MatchMode r101) {
        Intrinsics.checkNotNullParameter(r100, "validSource");
        Intrinsics.checkNotNullParameter(r101, "matchMode");
        this.f147015a = r100;
        this.f147016b = r101;
    }
}
