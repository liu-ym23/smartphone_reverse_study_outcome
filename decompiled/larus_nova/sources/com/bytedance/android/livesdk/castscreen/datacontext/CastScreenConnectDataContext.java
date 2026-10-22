package com.bytedance.android.livesdk.castscreen.datacontext;

import com.bytedance.android.livesdk.castscreen.views.CastScreenViewModel;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.b;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/datacontext/CastScreenConnectDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "isCastScreenPlaying", "isCastScreenLinking", "Lcom/bytedance/live/datacontext/m;", "castScreenPlaying$delegate", "Lcom/bytedance/live/datacontext/p;", "getCastScreenPlaying", "()Lcom/bytedance/live/datacontext/m;", "castScreenPlaying", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class CastScreenConnectDataContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "CastScreenConnectDataContext";
    private final p castScreenPlaying$delegate;

    public static final class a {
        public a() {
        }

        public static CastScreenConnectDataContext a(DataCenter r100) {
            DataContext r101 = null;
            if (r100 != null) goto L5;
            return null;
        L5:
            DataContext r102 = d.d(Integer.valueOf(r100.hashCode() - 1897823386));
            if ((r102 instanceof CastScreenConnectDataContext) == false) goto L10;
            r101 = r102;
        L10:
            return (CastScreenConnectDataContext) r101;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(CastScreenConnectDataContext.class, "castScreenPlaying", "getCastScreenPlaying()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    public final m<Boolean> getCastScreenPlaying() {
        return (m) this.castScreenPlaying$delegate.a(this, $$delegatedProperties[0]);
    }

    public CastScreenConnectDataContext() {
        this.castScreenPlaying$delegate = q.d(this, Boolean.FALSE);
        b.a(this, TAG);
    }

    public final boolean isCastScreenLinking(DataCenter r100) {
        CastScreenViewModel.Companion.getClass();
        CastScreenViewModel r101 = CastScreenViewModel.a.b(r100);
        if (r101 == null) goto L7;
        m<Boolean> r102 = r101.getCastOrMirrorScreenMode();
        if (r102 == null) goto L7;
        Boolean r103 = r102.getValue();
    L8:
        boolean r104 = getCastScreenPlaying().getValue().booleanValue();
        Logger.d(TAG, "isCastScreenLinking castScreenMode=" + r103 + "，castScreenPlaying=" + r104);
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L12;
        if (r104 == true) goto L12;
        return true;
    L12:
        return false;
    L7:
        r103 = null;
        goto L8
    }

    public final boolean isCastScreenPlaying(DataCenter r100) {
        if (CastScreenViewModel.Companion == null) goto L13;
        CastScreenViewModel r101 = CastScreenViewModel.a.b(r100);
        if (r101 == null) goto L13;
        m<Boolean> r102 = r101.getCastOrMirrorScreenMode();
        if (r102 == null) goto L13;
        if (r102.getValue().booleanValue() != true) goto L13;
        if (getCastScreenPlaying().getValue().booleanValue() == false) goto L13;
        return true;
    L13:
        return false;
    }
}
