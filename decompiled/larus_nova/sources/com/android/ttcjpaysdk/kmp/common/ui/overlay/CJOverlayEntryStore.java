package com.android.ttcjpaysdk.kmp.common.ui.overlay;

import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.kmp.common.ui.CJHostUi;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007J\u0015\u0010\u0010\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/ui/overlay/CJOverlayEntryStore;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "entries", "", "", "overlayIds", MiPushClient.COMMAND_REGISTER, "", "entryId", "entry", "(Ljava/lang/String;Ljava/lang/Object;)V", "bindOverlayId", "overlayId", MonitorConstants.CONNECT_TYPE_GET, "(Ljava/lang/String;)Ljava/lang/Object;", "remove", "dismissAndRemove", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJOverlayEntryStore<T> {
    public static final int $stable = 8;
    private final Map<String, T> entries;
    private final Map<String, String> overlayIds;

    public CJOverlayEntryStore() {
        this.entries = new LinkedHashMap();
        this.overlayIds = new LinkedHashMap();
    }

    public final void dismissAndRemove(String r100) {
        Intrinsics.checkNotNullParameter(r100, "entryId");
        String r101 = this.overlayIds.remove(r100);
        this.entries.remove(r100);
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L12;
        CJHostUi.INSTANCE.dismissOverlay(r101);
        return;
    L12:
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final T get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "entryId");
        return this.entries.get(r100);
    }

    public final void remove(String r100) {
        Intrinsics.checkNotNullParameter(r100, "entryId");
        this.entries.remove(r100);
        this.overlayIds.remove(r100);
    }

    public final void bindOverlayId(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "entryId");
        Intrinsics.checkNotNullParameter(r101, "overlayId");
        this.overlayIds.put(r100, r101);
    }

    public final void register(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "entryId");
        this.entries.put(r100, r101);
    }
}
