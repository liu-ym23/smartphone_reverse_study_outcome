package com.bytedance.android.livesdkapi.sti.framework;

import android.content.Context;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020#H\u0016J)\u0010&\u001a\u0002H'\"\f\b\u0001\u0010'*\u00020\u0017*\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H'0*H\u0016¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020.H\u0016J \u0010/\u001a\u0002002\u0006\u00101\u001a\u00020.2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000203H\u0016J\u0010\u00105\u001a\u0002062\u0006\u00101\u001a\u00020.H\u0016J\u0015\u00107\u001a\u00020#2\u0006\u00108\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00109J\b\u0010:\u001a\u00020#H\u0016J3\u0010;\u001a\u0002H<\"\u0004\b\u0001\u0010<2\u001d\u0010=\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u0002H<0>¢\u0006\u0002\b?H\u0082\b¢\u0006\u0002\u0010@J\u0018\u0010A\u001a\u00020.2\u0006\u0010-\u001a\u00020.2\u0006\u0010B\u001a\u00020\nH\u0016J\u0014\u0010C\u001a\u00020#2\f\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003J\b\u0010E\u001a\u00020#H\u0016JP\u0010F\u001a\u00020#2\u0006\u0010G\u001a\u00020\n2\b\u0010H\u001a\u0004\u0018\u00018\u00002\b\u0010I\u001a\u0004\u0018\u00010\n2%\u0010J\u001a!\u0012\u0013\u0012\u00110\n¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(M\u0012\u0006\u0012\u0004\u0018\u00010N\u0018\u00010>H\u0016¢\u0006\u0002\u0010OJ\u0010\u0010P\u001a\u00020#2\u0006\u0010Q\u001a\u00020NH\u0016J\f\u0010R\u001a\u00020S*\u00020TH\u0016J\f\u0010U\u001a\u00020S*\u00020TH\u0016J\f\u0010V\u001a\u00020S*\u00020TH\u0016J\f\u0010W\u001a\u00020S*\u00020TH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR.\u0010\u001f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00032\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006X"}, d2 = {"Lcom/bytedance/android/livesdkapi/sti/framework/IconServiceProxy;", "STATE", "", "Lcom/bytedance/android/livesdkapi/sti/framework/IIconService;", "()V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "countDownMs", "", "getCountDownMs", "()Ljava/lang/Long;", "countDownObservable", "Lio/reactivex/Observable;", "getCountDownObservable", "()Lio/reactivex/Observable;", "countDownSec", "getCountDownSec", "currentState", "getCurrentState", "()Ljava/lang/Object;", "currentView", "Lcom/bytedance/android/livesdkapi/sti/framework/IconTemplate;", "getCurrentView", "()Lcom/bytedance/android/livesdkapi/sti/framework/IconTemplate;", "dataContext", "Landroidx/lifecycle/ViewModel;", "getDataContext", "()Landroidx/lifecycle/ViewModel;", "<set-?>", "serviceImpl", "getServiceImpl", "()Lcom/bytedance/android/livesdkapi/sti/framework/IIconService;", "activateIcon", "", "changeTempWidth", "clearCountDown", "createIconTemplate", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/livesdkapi/sti/framework/Instantiable;", "templateClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/bytedance/android/livesdkapi/sti/framework/IconTemplate;", "getTempShowTime", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "", "imageViewOf", "Landroid/widget/ImageView;", "resId", "widthDp", "", "heightDp", "inflateEntryView", "Lcom/bytedance/android/livesdkapi/sti/framework/IIconModel$EntryView;", "moveToState", "state", "(Ljava/lang/Object;)V", "performClick", "proxy", "R", "thisScope", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "registerShowTempState", "showTime", "setServiceImpl", "impl", "showNormalState", "startCountDown", "milliseconds", "nextState", VideoThumbInfo.KEY_INTERVAL, "transformer", "Lkotlin/ParameterName;", "name", "sec", "", "(JLjava/lang/Object;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", "updateLabel", "txt", "bindModel", "", "Lio/reactivex/disposables/Disposable;", "bindState", "unbindModel", "unbindState", "livedynamic-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IconServiceProxy<STATE> implements IIconService<STATE> {
    private IIconService<STATE> serviceImpl;

    public IconServiceProxy() {
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public void activateIcon() {
        IIconService<STATE> r100 = getServiceImpl();
        if (r100 == null) goto L7;
        r100.activateIcon();
        return;
    L7:
        throw new IllegalStateException("Implementation of IIconService is not set".toString());
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITempShortTouchService
    public void changeTempWidth() {
        IIconService<STATE> r100 = getServiceImpl();
        if (r100 == null) goto L7;
        r100.changeTempWidth();
        return;
    L7:
        throw new IllegalStateException("Implementation of IIconService is not set".toString());
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public void clearCountDown() {
        IIconService<STATE> r100 = getServiceImpl();
        if (r100 == null) goto L7;
        r100.clearCountDown();
        return;
    L7:
        throw new IllegalStateException("Implementation of IIconService is not set".toString());
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public Context getContext() {
        IIconService<STATE> r100 = getServiceImpl();
        if (r100 == null) goto L7;
        return r100.getContext();
    L7:
        throw new IllegalStateException("Implementation of IIconService is not set".toString());
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public Long getCountDownMs() {
        IIconService<STATE> r100 = getServiceImpl();
        if (r100 == null) goto L7;
        return r100.getCountDownMs();
    L7:
        throw new IllegalStateException("Implementation of IIconService is not set".toString());
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public Observable<Long> getCountDownObservable() {
        IIconService<STATE> r100 = getServiceImpl();
        if (r100 == null) goto L7;
        return r100.getCountDownObservable();
    L7:
        throw new IllegalStateException("Implementation of IIconService is not set".toString());
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public Long getCountDownSec() {
        IIconService<STATE> r100 = getServiceImpl();
        if (r100 == null) goto L7;
        return r100.getCountDownSec();
    L7:
        throw new IllegalStateException("Implementation of IIconService is not set".toString());
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public STATE getCurrentState() {
        IIconService<STATE> r100 = getServiceImpl();
        if (r100 == null) goto L7;
        return r100.getCurrentState();
    L7:
        throw new IllegalStateException("Implementation of IIconService is not set".toString());
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public IconTemplate getCurrentView() {
        IIconService<STATE> r100 = getServiceImpl();
        if (r100 == null) goto L7;
        return r100.getCurrentView();
    L7:
        throw new IllegalStateException("Implementation of IIconService is not set".toString());
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public ViewModel getDataContext() {
        IIconService<STATE> r100 = getServiceImpl();
        if (r100 == null) goto L7;
        return r100.getDataContext();
    L7:
        throw new IllegalStateException("Implementation of IIconService is not set".toString());
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public void performClick() {
        IIconService<STATE> r100 = getServiceImpl();
        if (r100 == null) goto L7;
        r100.performClick();
        return;
    L7:
        throw new IllegalStateException("Implementation of IIconService is not set".toString());
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITempShortTouchService
    public void showNormalState() {
        IIconService<STATE> r100 = getServiceImpl();
        if (r100 == null) goto L7;
        r100.showNormalState();
        return;
    L7:
        throw new IllegalStateException("Implementation of IIconService is not set".toString());
    }

    public final IIconService<STATE> getServiceImpl() {
        return this.serviceImpl;
    }

    public static final /* synthetic */ IIconService access$getServiceImpl$p(IconServiceProxy r100) {
        return r100.serviceImpl;
    }

    private final <R> R proxy(Function1<? super IIconService<STATE>, ? extends R> r100) {
        IIconService<STATE> r101 = getServiceImpl();
        if (r101 == null) goto L7;
        return r100.invoke(r101);
    L7:
        throw new IllegalStateException("Implementation of IIconService is not set".toString());
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public boolean bindModel(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$bindModel");
        IIconService<STATE> r101 = getServiceImpl();
        if (r101 == null) goto L7;
        return r101.bindModel(r100);
    L7:
        throw new IllegalStateException("Implementation of IIconService is not set".toString());
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public boolean bindState(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$bindState");
        IIconService<STATE> r101 = getServiceImpl();
        if (r101 == null) goto L7;
        return r101.bindState(r100);
    L7:
        throw new IllegalStateException("Implementation of IIconService is not set".toString());
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public <T extends IconTemplate & Instantiable> T createIconTemplate(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "templateClass");
        IIconService<STATE> r101 = getServiceImpl();
        if (r101 == null) goto L7;
        return (T) r101.createIconTemplate(r100);
    L7:
        throw new IllegalStateException("Implementation of IIconService is not set".toString());
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITempShortTouchService
    public long getTempShowTime(int r100) {
        IIconService<STATE> r101 = getServiceImpl();
        if (r101 == null) goto L7;
        return r101.getTempShowTime(r100);
    L7:
        throw new IllegalStateException("Implementation of IIconService is not set".toString());
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public IIconModel.EntryView inflateEntryView(int r100) {
        IIconService<STATE> r101 = getServiceImpl();
        if (r101 == null) goto L7;
        return r101.inflateEntryView(r100);
    L7:
        throw new IllegalStateException("Implementation of IIconService is not set".toString());
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public void moveToState(STATE r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        IIconService<STATE> r101 = getServiceImpl();
        if (r101 == null) goto L7;
        r101.moveToState(r100);
        return;
    L7:
        throw new IllegalStateException("Implementation of IIconService is not set".toString());
    }

    public final void setServiceImpl(IIconService<STATE> r100) {
        Intrinsics.checkNotNullParameter(r100, "impl");
        this.serviceImpl = r100;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public boolean unbindModel(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$unbindModel");
        IIconService<STATE> r101 = getServiceImpl();
        if (r101 == null) goto L7;
        return r101.unbindModel(r100);
    L7:
        throw new IllegalStateException("Implementation of IIconService is not set".toString());
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public boolean unbindState(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$unbindState");
        IIconService<STATE> r101 = getServiceImpl();
        if (r101 == null) goto L7;
        return r101.unbindState(r100);
    L7:
        throw new IllegalStateException("Implementation of IIconService is not set".toString());
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public void updateLabel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "txt");
        IIconService<STATE> r101 = getServiceImpl();
        if (r101 == null) goto L7;
        r101.updateLabel(r100);
        return;
    L7:
        throw new IllegalStateException("Implementation of IIconService is not set".toString());
    }

    public static final /* synthetic */ void access$setServiceImpl$p(IconServiceProxy r100, IIconService r101) {
        r100.serviceImpl = r101;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITempShortTouchService
    public int registerShowTempState(int r100, long r101) {
        IIconService<STATE> r102 = getServiceImpl();
        if (r102 == null) goto L7;
        return r102.registerShowTempState(r100, r101);
    L7:
        throw new IllegalStateException("Implementation of IIconService is not set".toString());
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public ImageView imageViewOf(int r100, float r101, float r102) {
        IIconService<STATE> r103 = getServiceImpl();
        if (r103 == null) goto L7;
        return r103.imageViewOf(r100, r101, r102);
    L7:
        throw new IllegalStateException("Implementation of IIconService is not set".toString());
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public void startCountDown(long r100, STATE r101, Long r110, Function1<? super Long, String> r111) {
        IIconService<STATE> r102 = getServiceImpl();
        if (r102 == null) goto L7;
        r102.startCountDown(r100, r101, r110, r111);
        return;
    L7:
        throw new IllegalStateException("Implementation of IIconService is not set".toString());
    }
}
