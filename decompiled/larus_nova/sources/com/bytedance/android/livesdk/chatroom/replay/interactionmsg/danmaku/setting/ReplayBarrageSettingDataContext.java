package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting;

import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.config.ReplayBarrageSetting;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.config.ReplayBarrageSettingFont;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000  2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\rR!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001d\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/setting/ReplayBarrageSettingDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/livesdk/chatroom/vs_base/base/setting/config/ReplayBarrageSetting;", "barrageSetting$delegate", "Lcom/bytedance/live/datacontext/p;", "getBarrageSetting", "()Lcom/bytedance/live/datacontext/n;", "barrageSetting", "Lcom/bytedance/live/datacontext/j;", "Liq1/a;", "loggerHelper$delegate", "getLoggerHelper", "()Lcom/bytedance/live/datacontext/j;", "loggerHelper", "Lcom/bytedance/live/datacontext/i;", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable$delegate", "getCompositeDisposable", "()Lcom/bytedance/live/datacontext/i;", "compositeDisposable", "Lcom/bytedance/live/datacontext/m;", "", "dialogShow$delegate", "getDialogShow", "()Lcom/bytedance/live/datacontext/m;", "dialogShow", "getDefaultSetting", "()Lcom/bytedance/android/livesdk/chatroom/vs_base/base/setting/config/ReplayBarrageSetting;", "defaultSetting", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayBarrageSettingDataContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "ReplayBarrageSettingDataContext";
    private final p barrageSetting$delegate;
    private final p compositeDisposable$delegate;
    private final p dialogShow$delegate;
    private final p loggerHelper$delegate;

    public static final class a {
        public final ReplayBarrageSettingDataContext getContext() {
            DataContext r100 = d.d(ReplayBarrageSettingDataContext.TAG);
            if ((r100 instanceof ReplayBarrageSettingDataContext) == true) goto L6;
            r100 = null;
        L6:
            return (ReplayBarrageSettingDataContext) r100;
        }

        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ReplayBarrageSettingDataContext.class, "barrageSetting", "getBarrageSetting()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayBarrageSettingDataContext.class, "loggerHelper", "getLoggerHelper()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayBarrageSettingDataContext.class, "compositeDisposable", "getCompositeDisposable()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ReplayBarrageSettingDataContext.class, "dialogShow", "getDialogShow()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    public final n<ReplayBarrageSetting> getBarrageSetting() {
        return (n) this.barrageSetting$delegate.a(this, $$delegatedProperties[0]);
    }

    public final i<CompositeDisposable> getCompositeDisposable() {
        return (i) this.compositeDisposable$delegate.a(this, $$delegatedProperties[2]);
    }

    public final m<Boolean> getDialogShow() {
        return (m) this.dialogShow$delegate.a(this, $$delegatedProperties[3]);
    }

    public final j<iq1.a> getLoggerHelper() {
        return (j) this.loggerHelper$delegate.a(this, $$delegatedProperties[1]);
    }

    public final ReplayBarrageSetting getDefaultSetting() {
        ReplayBarrageSetting r100 = new ReplayBarrageSetting();
        r100.setBarrageArea(0.45f);
        r100.setFontSize(ReplayBarrageSettingFont.MID);
        r100.setAlpha(75.0f);
        return r100;
    }

    public ReplayBarrageSettingDataContext() {
        this.barrageSetting$delegate = q.c(this);
        this.loggerHelper$delegate = ConstantKt.c(this);
        this.compositeDisposable$delegate = ConstantKt.a(this, new CompositeDisposable(), ReplayBarrageSettingDataContext$compositeDisposable$2.INSTANCE);
        this.dialogShow$delegate = q.d(this, Boolean.FALSE);
    }
}
