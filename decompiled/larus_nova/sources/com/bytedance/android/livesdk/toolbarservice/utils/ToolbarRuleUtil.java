package com.bytedance.android.livesdk.toolbarservice.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class ToolbarRuleUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f158604a = 0;

    public static final class Rule {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lazy f158605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Lazy f158606b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Lazy f158607c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final DataCenter f158608d;

        public Rule(DataCenter r100) {
            this.f158608d = r100;
            this.f158605a = LazyKt.lazy(new ToolbarRuleUtil$Rule$groupSequence$2(this));
            this.f158606b = LazyKt.lazy(new ToolbarRuleUtil$Rule$buttonSequence$2(this));
            this.f158607c = LazyKt.lazy(ToolbarRuleUtil$Rule$needForceDefault$2.INSTANCE);
        }

        public final int a(Integer r100) {
            List r101 = (List) this.f158605a.getValue();
            int r102 = CollectionsKt.indexOf(r101, r100);
            if (r102 != (-1)) goto L7;
            ALogger.i("ToolbarRuleUtil", "cant find priority by group id :" + r100);
            return -1;
        L7:
            return r101.size() - r102;
        }
    }

    static {
    }
}
