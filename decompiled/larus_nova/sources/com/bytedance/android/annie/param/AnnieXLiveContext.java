package com.bytedance.android.annie.param;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService;
import com.obric.aivoice.core.data.IdlKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b'\u0010(J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R0\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0003\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006)"}, d2 = {"Lcom/bytedance/android/annie/param/AnnieXLiveContext;", "Lc7/a;", "Landroid/net/Uri;", "uri", "", "reload", "release", "Lcom/bytedance/android/annie/service/business/latch/IAnnieBusinessLatchService$b;", "latchProcess", "Lcom/bytedance/android/annie/service/business/latch/IAnnieBusinessLatchService$b;", "getLatchProcess", "()Lcom/bytedance/android/annie/service/business/latch/IAnnieBusinessLatchService$b;", "setLatchProcess", "(Lcom/bytedance/android/annie/service/business/latch/IAnnieBusinessLatchService$b;)V", IdlKeys.Args_GrantUri, "Landroid/net/Uri;", "Lcom/bytedance/ies/bullet/base/utils/logger/a;", "logContext", "Lcom/bytedance/ies/bullet/base/utils/logger/a;", "getLogContext", "()Lcom/bytedance/ies/bullet/base/utils/logger/a;", "setLogContext", "(Lcom/bytedance/ies/bullet/base/utils/logger/a;)V", "", "", "", "globalProps", "Ljava/util/Map;", "getGlobalProps", "()Ljava/util/Map;", "setGlobalProps", "(Ljava/util/Map;)V", "getUri", "()Landroid/net/Uri;", "Lb7/b;", "commonLifecycle", "Landroid/os/Bundle;", "bundle", "initialUuid", "<init>", "(Landroid/net/Uri;Lb7/b;Landroid/os/Bundle;Ljava/lang/String;Lcom/bytedance/android/annie/service/business/latch/IAnnieBusinessLatchService$b;)V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class AnnieXLiveContext extends c7.a {
    private Uri _uri;
    private Map<String, ? extends Object> globalProps;
    private IAnnieBusinessLatchService.b latchProcess;
    private com.bytedance.ies.bullet.base.utils.logger.a logContext;

    public final void release() {
        setCommonLifecycle(null);
    }

    public final Map<String, Object> getGlobalProps() {
        return this.globalProps;
    }

    public final IAnnieBusinessLatchService.b getLatchProcess() {
        return this.latchProcess;
    }

    public final com.bytedance.ies.bullet.base.utils.logger.a getLogContext() {
        return this.logContext;
    }

    public final Uri getUri() {
        return this._uri;
    }

    public final void reload(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this._uri = r100;
    }

    public final void setGlobalProps(Map<String, ? extends Object> r100) {
        this.globalProps = r100;
    }

    public final void setLatchProcess(IAnnieBusinessLatchService.b r100) {
        this.latchProcess = r100;
    }

    public final void setLogContext(com.bytedance.ies.bullet.base.utils.logger.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.logContext = r100;
    }

    public AnnieXLiveContext(Uri r100, b7.b r101, Bundle r102, String r103, IAnnieBusinessLatchService.b r104) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        super(r101, r102, r103);
        this.latchProcess = r104;
        setMonitorID(getUuid());
        if (r102 == null) goto L5;
        r102.putString("annie_uuid_key", getUuid());
    L5:
        this._uri = r100;
        com.bytedance.ies.bullet.base.utils.logger.a r105 = new com.bytedance.ies.bullet.base.utils.logger.a();
        r105.a("session_id", getUuid());
        this.logContext = r105;
    }

    public /* synthetic */ AnnieXLiveContext(Uri r100, b7.b r101, Bundle r110, String r111, IAnnieBusinessLatchService.b r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 4) == 0) goto L5;
        Bundle r102 = null;
    L7:
        if ((r113 & 8) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r113 & 16) == 0) goto L13;
        IAnnieBusinessLatchService.b r104 = null;
    L14:
        this(r100, r101, r102, r103, r104);
        return;
    L13:
        r104 = r112;
        goto L14
    L9:
        r103 = r111;
        goto L11
    L5:
        r102 = r110;
        goto L7
    }
}
