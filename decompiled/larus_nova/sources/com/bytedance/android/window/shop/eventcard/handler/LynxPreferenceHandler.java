package com.bytedance.android.window.shop.eventcard.handler;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class LynxPreferenceHandler implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LynxPreferenceHandler f187797a = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/window/shop/eventcard/handler/LynxPreferenceHandler$LynxPreferenceOperation;", "", "", WikiFolderPushPlugin.OPT, "Ljava/lang/String;", "getOperation", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "GET", "SET", "REMOVE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LynxPreferenceOperation extends Enum<LynxPreferenceOperation> {
        public static final a Companion = null;
        public static final LynxPreferenceOperation GET = null;
        public static final LynxPreferenceOperation REMOVE = null;
        public static final LynxPreferenceOperation SET = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LynxPreferenceOperation[] f187798a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Map<String, LynxPreferenceOperation> f187799b = null;
        private final String operation;

        public static final class a {
            public a() {
            }
        }

        static {
            int r100 = 0;
            LynxPreferenceOperation r101 = new LynxPreferenceOperation("GET", 0, MonitorConstants.CONNECT_TYPE_GET);
            GET = r101;
            LynxPreferenceOperation r102 = new LynxPreferenceOperation("SET", 1, "set");
            SET = r102;
            LynxPreferenceOperation r103 = new LynxPreferenceOperation("REMOVE", 2, "remove");
            REMOVE = r103;
            f187798a = new LynxPreferenceOperation[]{r101, r102, r103};
            Companion = new a();
            LynxPreferenceOperation[] r104 = values();
            LinkedHashMap r105 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r104.length), 16));
            int r106 = r104.length;
        L3:
            if (r100 >= r106) goto L5;
            LynxPreferenceOperation r107 = r104[r100];
            r105.put(r107.operation, r107);
            r100 = r100 + 1;
            goto L3
        L5:
            f187799b = r105;
        }

        public static LynxPreferenceOperation valueOf(String r100) {
            return (LynxPreferenceOperation) r27.a.a(LynxPreferenceOperation.class, r100);
        }

        public static LynxPreferenceOperation[] values() {
            return (LynxPreferenceOperation[]) f187798a.clone();
        }

        public static final /* synthetic */ Map access$getMapping$cp() {
            return f187799b;
        }

        public final String getOperation() {
            return this.operation;
        }

        public LynxPreferenceOperation(String r100, int r101, String r102) {
            super(r100, r101);
            this.operation = r102;
        }
    }

    public LynxPreferenceHandler() {
    }

    @Override // com.bytedance.android.window.shop.eventcard.handler.a
    public final void release() {
    }

    static {
        f187797a = new LynxPreferenceHandler();
    }

    @Override // com.bytedance.android.window.shop.eventcard.handler.a
    public final Map<String, Object> a(int r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        Object r102 = r101.get("preference_key");
        LynxPreferenceOperation r103 = null;
        if ((r102 instanceof String) == true) goto L5;
        r102 = null;
    L5:
        String r104 = (String) r102;
        if (r104 == null) goto L8;
        LynxPreferenceOperation.a r105 = LynxPreferenceOperation.Companion;
        Object r106 = r101.get("preference_action");
        if ((r106 instanceof String) == true) goto L12;
        r106 = null;
    L12:
        String r107 = (String) r106;
        r105.getClass();
        if (r107 == null) goto L16;
        r103 = (LynxPreferenceOperation) LynxPreferenceOperation.access$getMapping$cp().get(r107);
    L16:
        if (r103 == null) goto L18;
        int r108 = e.f187806a[r103.ordinal()];
        if (r108 != 1) goto L22;
        ConcurrentHashMap<String, Object> r109 = fp3.a.f478232a;
        Intrinsics.checkNotNullParameter(r104, "key");
        return MapsKt.mapOf(TuplesKt.to(r104, fp3.a.f478232a.get(r104)));
    L22:
        if (r108 != 2) goto L24;
        Object r110 = r101.get("preference_value");
        if (r110 == null) goto L32;
        ConcurrentHashMap<String, Object> r111 = fp3.a.f478232a;
        Intrinsics.checkNotNullParameter(r104, "key");
        Intrinsics.checkNotNullParameter(r110, "value");
        return MapsKt.mapOf(TuplesKt.to(r104, fp3.a.f478232a.put(r104, r110)));
    L32:
        return MapsKt.emptyMap();
    L24:
        if (r108 != 3) goto L28;
        ConcurrentHashMap<String, Object> r112 = fp3.a.f478232a;
        Intrinsics.checkNotNullParameter(r104, "key");
        return MapsKt.mapOf(TuplesKt.to(r104, fp3.a.f478232a.remove(r104)));
    L28:
        throw new NoWhenBranchMatchedException();
    L18:
        return MapsKt.emptyMap();
    L8:
        return MapsKt.emptyMap();
    }
}
