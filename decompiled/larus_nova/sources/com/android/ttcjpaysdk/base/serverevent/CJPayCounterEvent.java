package com.android.ttcjpaysdk.base.serverevent;

import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/base/serverevent/CJPayCounterEvent;", "", "()V", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayCounterEvent {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/serverevent/CJPayCounterEvent$Companion;", "", "()V", "buildCounterCloseEvent", "Lorg/json/JSONObject;", "processInfo", "bizNO", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final JSONObject buildCounterCloseEvent(JSONObject r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "processInfo");
            Intrinsics.checkNotNullParameter(r101, "bizNO");
            JSONObject r102 = new JSONObject();
            KtSafeMethodExtensionKt.safePut(r102, "process_info", r100);
            KtSafeMethodExtensionKt.safePut(r102, "biz_no", r101);
            return r102;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CJPayCounterEvent() {
    }
}
