package com.bytedance.android.livesdk.dslservice;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livesdk.dsl.api.DSLType;
import com.bytedance.android.livesdk.dsl.api.IDSLManagerService;
import com.bytedance.android.livesdk.dslservice.slice.cache.e;
import com.bytedance.android.livesdk.dslservice.slice.cache.f;
import com.bytedance.android.livesdk.dslservice.util.DSLTemplateCenter;
import com.bytedance.android.livesdk.dslservice.util.q;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import j70.h;
import java.util.HashMap;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yt1.n;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J0\u0010\u0013\u001a\u00020\u0012\"\b\b\u0000\u0010\f*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/dslservice/DSLServiceImpl;", "Lcom/bytedance/android/livesdk/dsl/api/IDSLManagerService;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lyt1/n;", "createDSLManager", "createDummy", "Lzt1/c;", "createDSLTemplateCenter", "Landroid/view/View;", ExifInterface.GPS_DIRECTION_TRUE, "", "name", "Lyt1/f;", "customProvider", "type", "", "registerCustomViewManger", "Lj70/h;", "Lh70/b;", "getDescriptor", "Lyt1/q;", "key", "", "hasLocalGlobalCache", "onClear", "<init>", "()V", "dslservice-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class DSLServiceImpl implements IDSLManagerService {
    @Override // com.bytedance.android.livesdk.dsl.api.IDSLManagerService
    public void onClear() {
        com.bytedance.android.livesdk.dslservice.util.a.f122964d.d(AnonymousClass1.INSTANCE);     // Catch: Throwable -> L8
        SlcRenderContext r100 = com.bytedance.android.livesdk.dslservice.slice.cache.b.f122934a;     // Catch: Throwable -> L8
        if (r100 == null) goto L6;
        r100.d();     // Catch: Throwable -> L8
    L6:
        com.bytedance.android.livesdk.dslservice.slice.cache.b.f122934a = null;     // Catch: Throwable -> L8
        f.f122939b.b().evictAll();     // Catch: Throwable -> L8
        cu1.b.f465418b.b().evictAll();     // Catch: Throwable -> L8
        DSLTemplateCenter.f122954e.clear();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        SafetyGuard.a(null, th, "SliceLoadError");
    }

    @Override // com.bytedance.android.livesdk.dsl.api.IDSLManagerService
    public n createDummy() {
        return new q();
    }

    @Override // com.bytedance.android.livesdk.dsl.api.IDSLManagerService
    public h<? extends h70.b> getDescriptor() {
        return new d();
    }

    public DSLServiceImpl() {
        k.l(IDSLManagerService.class, this);
    }

    @Override // com.bytedance.android.livesdk.dsl.api.IDSLManagerService
    public zt1.c createDSLTemplateCenter(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        return new DSLTemplateCenter(r100);
    }

    @Override // com.bytedance.android.livesdk.dsl.api.IDSLManagerService
    public boolean hasLocalGlobalCache(yt1.q r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (e.f122937b.a(r100) == null) goto L5;
    L8:
        return true;
    L5:
        if (cu1.a.f465417b.a(r100) != null) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdk.dsl.api.IDSLManagerService
    public n createDSLManager(Context r100, DataCenter r101) {
        return new c();
    }

    @Override // com.bytedance.android.livesdk.dsl.api.IDSLManagerService
    public <T extends View> void registerCustomViewManger(String r100, yt1.f<T> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "customProvider");
        Intrinsics.checkNotNullParameter(r102, "type");
        int r103 = r102.hashCode();
        if (r103 == (-1994808941)) goto L11;
        if (r103 == 79973746) goto L8;
    L16:
        com.bytedance.android.livesdk.dslservice.view.b.a(r100, r101);
        return;
    L8:
        if (r102.equals(DSLType.Slice) == false) goto L16;
        com.bytedance.android.livesdk.dslservice.view.b.b(r100, r101);
        return;
    L11:
        if (r102.equals(DSLType.LynxAir) == false) goto L16;
        HashMap<String, yt1.f<? extends View>> r104 = com.bytedance.android.livesdk.dslservice.view.b.f123014a;
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        HashMap<String, yt1.f<? extends View>> r105 = com.bytedance.android.livesdk.dslservice.view.b.f123015b;
        if (r105.containsKey(r100) == true) goto L20;
        r105.put(r100, r101);
        return;
    }
}
