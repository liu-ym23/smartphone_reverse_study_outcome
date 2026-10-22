package com.android.ttcjpaysdk.kmp.common.ui.overlay;

import androidx.compose.runtime.Composer;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\t¢\u0006\u0002\u0010\rJ&\u0010\u000e\u001a\u0015\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\b\t2\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\u000fR+\u0010\u0004\u001a\u001f\u0012\u0004\u0012\u00020\u0006\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/ui/overlay/CJOverlayContentRegistry;", "", "<init>", "()V", "contents", "", "", "Lkotlin/Function1;", "", "Landroidx/compose/runtime/Composable;", MiPushClient.COMMAND_REGISTER, "name", "content", "(Ljava/lang/String;Lkotlin/jvm/functions/Function3;)V", MonitorConstants.CONNECT_TYPE_GET, "(Ljava/lang/String;)Lkotlin/jvm/functions/Function3;", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJOverlayContentRegistry {
    public static final int $stable = 0;
    public static final CJOverlayContentRegistry INSTANCE = null;
    private static final Map<String, Function3<String, Composer, Integer, Unit>> contents = null;

    private CJOverlayContentRegistry() {
    }

    static {
        INSTANCE = new CJOverlayContentRegistry();
        contents = new LinkedHashMap();
        $stable = 8;
    }

    public final Function3<String, Composer, Integer, Unit> get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return contents.get(r100);
    }

    public final void register(String r100, Function3<? super String, ? super Composer, ? super Integer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "content");
        contents.put(r100, r101);
    }
}
