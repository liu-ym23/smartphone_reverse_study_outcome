package com.bytedance.android.livesdkapi.sti.framework;

import android.content.Context;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.doubao.relax.profile.edit.ProfileEditRelaxPage;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import jc1.a;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB%\b\u0002\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0002\u0010\u000bJ\t\u00102\u001a\u000203H\u0096\u0001J\t\u00104\u001a\u000203H\u0096\u0001J\t\u00105\u001a\u000203H\u0096\u0001J*\u00106\u001a\u0002H7\"\f\b\u0001\u00107*\u00020\u001e*\u0002082\f\u00109\u001a\b\u0012\u0004\u0012\u0002H70:H\u0096\u0001¢\u0006\u0002\u0010;J\b\u0010<\u001a\u00020=H\u0016J\u0011\u0010>\u001a\u00020\u00112\u0006\u0010?\u001a\u00020\u0007H\u0096\u0001J#\u0010@\u001a\u00020A2\b\b\u0001\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020DH\u0097\u0001J\u0013\u0010F\u001a\u00020G2\b\b\u0001\u0010B\u001a\u00020\u0007H\u0096\u0001J\u0016\u0010H\u001a\u0002032\u0006\u0010I\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010JJ\b\u0010K\u001a\u000203H\u0016J\b\u0010L\u001a\u000203H&J\u0014\u0010L\u001a\u0002032\f\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004J\b\u0010N\u001a\u000203H\u0016J\u0018\u0010O\u001a\u0002032\u0006\u0010P\u001a\u00020G2\u0006\u0010Q\u001a\u00020RH\u0016J\b\u0010S\u001a\u000203H\u0016J\u0010\u0010T\u001a\u0002032\u0006\u0010?\u001a\u00020\u0007H\u0016J\t\u0010U\u001a\u000203H\u0096\u0001J\u0019\u0010V\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u0011H\u0096\u0001J\u0006\u0010X\u001a\u000203J\t\u0010Y\u001a\u000203H\u0096\u0001JW\u0010Z\u001a\u0002032\u0006\u0010[\u001a\u00020\u00112\n\b\u0002\u0010\\\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u00112'\b\u0002\u0010^\u001a!\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(b\u0012\u0006\u0012\u0004\u0018\u00010=\u0018\u00010_H\u0096\u0001¢\u0006\u0002\u0010cJ\u0011\u0010d\u001a\u0002032\u0006\u0010e\u001a\u00020=H\u0096\u0001J\r\u0010f\u001a\u00020g*\u00020hH\u0096\u0001J\r\u0010i\u001a\u00020g*\u00020hH\u0096\u0001J\r\u0010j\u001a\u00020g*\u00020hH\u0096\u0001J\r\u0010k\u001a\u00020g*\u00020hH\u0096\u0001R\u0012\u0010\f\u001a\u00020\rX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0011X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013R\u0012\u0010\u001a\u001a\u00028\u0000X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0012\u0010!\u001a\u00020\"X\u0096\u0005¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u0016\u0010\u0005\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010.\u001a\u0004\b-\u0010\u001cR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010'¨\u0006l"}, d2 = {"Lcom/bytedance/android/livesdkapi/sti/framework/AbsIconModel;", "STATE", "", "Lcom/bytedance/android/livesdkapi/sti/framework/IIconModel;", "Lcom/bytedance/android/livesdkapi/sti/framework/IIconService;", "initialState", "typeId", "", "(Ljava/lang/Object;I)V", "proxy", "Lcom/bytedance/android/livesdkapi/sti/framework/IconServiceProxy;", "(Ljava/lang/Object;ILcom/bytedance/android/livesdkapi/sti/framework/IconServiceProxy;)V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "countDownMs", "", "getCountDownMs", "()Ljava/lang/Long;", "countDownObservable", "Lio/reactivex/Observable;", "getCountDownObservable", "()Lio/reactivex/Observable;", "countDownSec", "getCountDownSec", "currentState", "getCurrentState", "()Ljava/lang/Object;", "currentView", "Lcom/bytedance/android/livesdkapi/sti/framework/IconTemplate;", "getCurrentView", "()Lcom/bytedance/android/livesdkapi/sti/framework/IconTemplate;", "dataContext", "Landroidx/lifecycle/ViewModel;", "getDataContext", "()Landroidx/lifecycle/ViewModel;", "iconHeight", "getIconHeight", "()I", "setIconHeight", "(I)V", "iconWidth", "getIconWidth", "setIconWidth", ProfileEditRelaxPage.METHOD_GET_INITIAL_STATE, "Ljava/lang/Object;", "getProxy", "()Lcom/bytedance/android/livesdkapi/sti/framework/IconServiceProxy;", "getTypeId", "activateIcon", "", "changeTempWidth", "clearCountDown", "createIconTemplate", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/livesdkapi/sti/framework/Instantiable;", "templateClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/bytedance/android/livesdkapi/sti/framework/IconTemplate;", "getIconDesc", "", "getTempShowTime", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "imageViewOf", "Landroid/widget/ImageView;", "resId", "widthDp", "", "heightDp", "inflateEntryView", "Lcom/bytedance/android/livesdkapi/sti/framework/IIconModel$EntryView;", "moveToState", "state", "(Ljava/lang/Object;)V", LynxVideoManagerLite.EVENT_ON_APPEAR, WidgetCostModule.TYPE_ON_CREATE, "service", LiveCommonConstants.REASON_ON_DEDTROY, "onEntryEvent", "entryView", "event", "Lcom/bytedance/android/livesdkapi/sti/framework/IIconModel$EntryEvent;", "onHideTempState", "onShowTempState", "performClick", "registerShowTempState", "showTime", "requestDispose", "showNormalState", "startCountDown", "milliseconds", "nextState", VideoThumbInfo.KEY_INTERVAL, "transformer", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "sec", "(JLjava/lang/Object;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", "updateLabel", "txt", "bindModel", "", "Lio/reactivex/disposables/Disposable;", "bindState", "unbindModel", "unbindState", "livedynamic-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsIconModel<STATE> implements IIconModel<STATE>, IIconService<STATE> {
    private int iconHeight;
    private int iconWidth;
    private final STATE initialState;
    private final IconServiceProxy<STATE> proxy;
    private final int typeId;

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public void activateIcon() {
        this.proxy.activateIcon();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public boolean bindModel(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$bindModel");
        return this.proxy.bindModel(r100);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public boolean bindState(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$bindState");
        return this.proxy.bindState(r100);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITempShortTouchService
    public void changeTempWidth() {
        this.proxy.changeTempWidth();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public void clearCountDown() {
        this.proxy.clearCountDown();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public <T extends IconTemplate & Instantiable> T createIconTemplate(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "templateClass");
        return (T) this.proxy.createIconTemplate(r100);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public Context getContext() {
        return this.proxy.getContext();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public Long getCountDownMs() {
        return this.proxy.getCountDownMs();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public Observable<Long> getCountDownObservable() {
        return this.proxy.getCountDownObservable();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public Long getCountDownSec() {
        return this.proxy.getCountDownSec();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public STATE getCurrentState() {
        return this.proxy.getCurrentState();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public IconTemplate getCurrentView() {
        return this.proxy.getCurrentView();
    }

    public ViewModel getDataContext() {
        return this.proxy.getDataContext();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public String getIconDesc() {
        return "";
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITempShortTouchService
    public long getTempShowTime(int r100) {
        return this.proxy.getTempShowTime(r100);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    @Deprecated(message = "计划删除，请勿新增使用")
    public ImageView imageViewOf(int r100, float r101, float r102) {
        return this.proxy.imageViewOf(r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public IIconModel.EntryView inflateEntryView(int r100) {
        return this.proxy.inflateEntryView(r100);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public void moveToState(STATE r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.proxy.moveToState(r100);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public void onAppear() {
    }

    public abstract void onCreate();

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public void onDestroy() {
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public void onEntryEvent(IIconModel.EntryView r100, IIconModel.EntryEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "entryView");
        Intrinsics.checkNotNullParameter(r101, "event");
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public void onHideTempState() {
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public void onShowTempState(int r100) {
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public void performClick() {
        this.proxy.performClick();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITempShortTouchService
    public int registerShowTempState(int r100, long r101) {
        return this.proxy.registerShowTempState(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITempShortTouchService
    public void showNormalState() {
        this.proxy.showNormalState();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public void startCountDown(long r100, STATE r101, Long r110, Function1<? super Long, String> r111) {
        this.proxy.startCountDown(r100, r101, r110, r111);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public boolean unbindModel(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$unbindModel");
        return this.proxy.unbindModel(r100);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public boolean unbindState(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$unbindState");
        return this.proxy.unbindState(r100);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public void updateLabel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "txt");
        this.proxy.updateLabel(r100);
    }

    public final void requestDispose() {
        IIconService<STATE> r100 = this.proxy.getServiceImpl();
        if ((r100 instanceof Disposable) == true) goto L5;
        r100 = null;
    L5:
        Disposable r101 = (Disposable) r100;
        if (r101 == null) goto L9;
        r101.dispose();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public long getDynamicPriorityShortTouch() {
        return IIconModel.DefaultImpls.getDynamicPriorityShortTouch(this);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public boolean isEnhancedStyleShortTouch() {
        return IIconModel.DefaultImpls.isEnhancedStyleShortTouch(this);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public int getIconHeight() {
        return this.iconHeight;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public int getIconWidth() {
        return this.iconWidth;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public STATE getInitialState() {
        return this.initialState;
    }

    public final IconServiceProxy<STATE> getProxy() {
        return this.proxy;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public int getTypeId() {
        return this.typeId;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IShortTouchLifeCycle
    public void onPause() {
        IIconModel.DefaultImpls.onPause(this);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IShortTouchLifeCycle
    public void onResume() {
        IIconModel.DefaultImpls.onResume(this);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final void onCreate(IIconService<STATE> r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        this.proxy.setServiceImpl(r100);
        onCreate();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public void setIconHeight(int r100) {
        this.iconHeight = r100;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public void setIconWidth(int r100) {
        this.iconWidth = r100;
    }

    public AbsIconModel(STATE r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "initialState");
        this(r100, r101, new IconServiceProxy());
    }

    private AbsIconModel(STATE r100, int r101, IconServiceProxy<STATE> r102) {
        this.initialState = r100;
        this.typeId = r101;
        this.proxy = r102;
        float r103 = 36;
        this.iconWidth = (int) UIUtils.dip2Px(a.b(), r103);
        this.iconHeight = (int) UIUtils.dip2Px(a.b(), r103);
    }
}
