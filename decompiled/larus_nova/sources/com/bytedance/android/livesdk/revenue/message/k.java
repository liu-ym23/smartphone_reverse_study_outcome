package com.bytedance.android.livesdk.revenue.message;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes11.dex */
public abstract class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final vh6.d<c> f157186c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.util.l f157187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, b<?>> f157188b;

    public static final class a {
    }

    public final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e<T> f157189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<T> f157190b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f157191c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ k f157192d;

        public final e<T> a() {
            e<T> r100 = this.f157189a;
            if (r100 != null) goto L10;
            com.bytedance.android.live.revenue.core.util.l r101 = this.f157192d.f157187a;
            vh6.d<c> r102 = k.f157186c;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r102, "key");
            Object r103 = r101.f91040a.get(r102);
            if (r103 != null) goto L8;
            r103 = null;
        L8:
            Intrinsics.checkNotNull(r103);
            RevWrdsSettingItemImpl r104 = ((c) r103).a(this.f157190b, this.f157191c);
            this.f157189a = r104;
            return r104;
        L10:
            return r100;
        }

        public b(k r100, Class r101) {
            Intrinsics.checkNotNullParameter(r101, "type");
            Intrinsics.checkNotNullParameter("LotteryInfoSyncData", "key");
            this.f157192d = r100;
            this.f157190b = r101;
            this.f157191c = "LotteryInfoSyncData";
        }
    }

    public interface c {
        RevWrdsSettingItemImpl a(Class r100, String r101);
    }

    static {
        f157186c = new vh6.d(Reflection.getOrCreateKotlinClass(c.class));
    }

    public k() {
        this.f157187a = new com.bytedance.android.live.revenue.core.util.l();
        this.f157188b = new LinkedHashMap();
    }
}
