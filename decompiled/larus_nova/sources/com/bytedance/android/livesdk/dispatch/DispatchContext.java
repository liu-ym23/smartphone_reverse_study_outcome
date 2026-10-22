package com.bytedance.android.livesdk.dispatch;

import com.bytedance.android.livesdk.dispatch.instance.generated.AnchorAnnouncementProxy;
import com.bytedance.android.livesdk.dispatch.instance.generated.AnchorPerfWidgetInstanceProxy;
import com.bytedance.android.livesdk.dispatch.instance.generated.DislikeProxy;
import com.bytedance.android.livesdk.dispatch.instance.generated.StableModeContextProxy;
import com.bytedance.android.livesdk.dispatch.instance.generated.StatusPanelProxy;
import com.bytedance.android.livesdk.dispatch.instance.generated.SubscribeAnchorProxy;
import com.bytedance.android.livesdk.dispatch.instance.generated.TestProxy;
import com.bytedance.android.livesdk.dispatch.instance.generated.UserProxy;
import com.bytedance.android.livesdk.dispatch.utils.DispatchLogUtil;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002R#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR#\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\nR#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\nR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/dispatch/DispatchContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "initProxy", "", "", "Lst1/a;", "instances", "Ljava/util/Map;", "getInstances", "()Ljava/util/Map;", "needInjectInstances", "getNeedInjectInstances", "", "logStartTime", "getLogStartTime", "", "hasInit", "Z", "getHasInit", "()Z", "setHasInit", "(Z)V", "Lio/reactivex/disposables/Disposable;", "disposable", "Lio/reactivex/disposables/Disposable;", "getDisposable", "()Lio/reactivex/disposables/Disposable;", "setDisposable", "(Lio/reactivex/disposables/Disposable;)V", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DispatchContext extends DataContext {
    private Disposable disposable;
    private boolean hasInit;
    private final Map<String, st1.a> instances;
    private final Map<String, Long> logStartTime;
    private final Map<String, st1.a> needInjectInstances;

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DispatchContext f122248a;

        public a(DispatchContext r100) {
            this.f122248a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            DispatchLogUtil.a("release all proxy");
            Iterator<T> r100 = this.f122248a.getInstances().values().iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((st1.a) r100.next()).c();
            goto L4
        L6:
            Disposable r101 = this.f122248a.getDisposable();
            if (r101 == null) goto L11;
            r101.dispose();
            return;
        }
    }

    public final void initProxy() {
        LinkedHashMap r100 = new LinkedHashMap();
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("Dislike", new DislikeProxy());
        r101.put("SubscribeAnchor", new SubscribeAnchorProxy());
        r101.put("User", new UserProxy());
        r101.put("AnchorStatusCenter", new StatusPanelProxy());
        Map<String, st1.a> r102 = this.instances;
        r100.put("AnchorPerfWidget", new AnchorPerfWidgetInstanceProxy());
        r100.put("Test", new TestProxy());
        r100.put("AnchorAnnouncement", new AnchorAnnouncementProxy());
        r101.put("StableMode", new StableModeContextProxy());
        r102.putAll(r100);
        this.instances.putAll(r101);
        this.needInjectInstances.putAll(r101);
        this.hasInit = true;
    }

    public DispatchContext() {
        this.instances = new LinkedHashMap();
        this.needInjectInstances = new LinkedHashMap();
        this.logStartTime = new LinkedHashMap();
        this.disposable = getOnCleared().subscribe(new a(this));
    }

    public final Disposable getDisposable() {
        return this.disposable;
    }

    public final boolean getHasInit() {
        return this.hasInit;
    }

    public final Map<String, st1.a> getInstances() {
        return this.instances;
    }

    public final Map<String, Long> getLogStartTime() {
        return this.logStartTime;
    }

    public final Map<String, st1.a> getNeedInjectInstances() {
        return this.needInjectInstances;
    }

    public final void setDisposable(Disposable r100) {
        this.disposable = r100;
    }

    public final void setHasInit(boolean r100) {
        this.hasInit = r100;
    }
}
