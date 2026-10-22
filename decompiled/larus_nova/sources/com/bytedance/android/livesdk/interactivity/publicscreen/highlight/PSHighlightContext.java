package com.bytedance.android.livesdk.interactivity.publicscreen.highlight;

import android.content.Context;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.IPSHighlightCompLifecycle$State;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.e;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.h;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.m;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.s;
import com.bytedance.android.livesdk.interactivity.publicscreen.highlight.data.PSHighlightCommonCompLauncher;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposables;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u0012\b\u00104\u001a\u0004\u0018\u000103¢\u0006\u0004\b8\u00109J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0007\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001b\u0010\"\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\t\u0010!R\u001b\u0010&\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010 \u001a\u0004\b$\u0010%R\u001b\u0010\r\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010 \u001a\u0004\b)\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u001c\u0010/\u001a\u0004\u0018\u00010.8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001c\u00104\u001a\u0004\u0018\u0001038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/highlight/PSHighlightContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/k;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/j;", KtvSubElement.CONTAINER, "", "bindContainer", "getContainer", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/h;", "getLaunchManager", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/m$c;", "getTriggerMapper", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/l;", "stateCenter", "release", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/AbsPSHighlightComp;", "comp", "show", "dismiss", "Lcom/bytedance/live/datacontext/n;", "container$delegate", "Lcom/bytedance/live/datacontext/p;", "()Lcom/bytedance/live/datacontext/n;", "", "hasComponentShow", "Z", "getHasComponentShow", "()Z", "setHasComponentShow", "(Z)V", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/highlight/b;", "launchManager$delegate", "Lkotlin/Lazy;", "()Lcom/bytedance/android/livesdk/interactivity/publicscreen/highlight/b;", "launchManager", "mapper$delegate", "getMapper", "()Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/m$c;", "mapper", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/s;", "stateCenter$delegate", "getStateCenter", "()Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/s;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "roomContext", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "getRoomContext", "()Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "<init>", "(Landroid/content/Context;Lcom/bytedance/ies/sdk/widgets/DataCenter;Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PSHighlightContext extends DataContext implements k {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p container$delegate;
    private Context context;
    private final DataCenter dataCenter;
    private boolean hasComponentShow;
    private final Lazy launchManager$delegate;
    private final Lazy mapper$delegate;
    private final MiddlewareRoomContext roomContext;
    private final Lazy stateCenter$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(PSHighlightContext.class, KtvSubElement.CONTAINER, "getContainer()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
    }

    private final n<j> getContainer() {
        return (n) this.container$delegate.a(this, $$delegatedProperties[0]);
    }

    private final b getLaunchManager() {
        return (b) this.launchManager$delegate.getValue();
    }

    private final m.c getMapper() {
        return (m.c) this.mapper$delegate.getValue();
    }

    private final s getStateCenter() {
        return (s) this.stateCenter$delegate.getValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k
    /* JADX INFO: renamed from: getContainer, reason: collision with other method in class */
    public j mo8241getContainer() {
        return getContainer().getValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k
    /* JADX INFO: renamed from: getLaunchManager, reason: collision with other method in class */
    public h mo8242getLaunchManager() {
        return getLaunchManager();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k
    public m.c getTriggerMapper() {
        return getMapper();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k
    public void release() {
        b r100 = getLaunchManager();
        ArrayList r101 = (ArrayList) r100.f138920a;
        if ((!r101.isEmpty()) == true) goto L6;
        r101 = null;
    L6:
        if (r101 == null) goto L15;
        List r102 = CollectionsKt.toList(r101);
        if (r102 == null) goto L15;
        Iterator r103 = r102.iterator();
    L11:
        if (r103.hasNext() == false) goto L15;
        i r104 = (i) r103.next();
        Intrinsics.checkNotNullParameter(r104, "launcher");
        if (((ArrayList) r100.f138920a).remove(r104) == false) goto L11;
        r104.onUnload();
    L15:
        ((ArrayList) getMapper().f133451a).clear();
        getStateCenter().getClass();
        getContainer().setValue(null);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k
    public l stateCenter() {
        return getStateCenter();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k
    public DataCenter getDataCenter() {
        return this.dataCenter;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k
    public boolean getHasComponentShow() {
        return this.hasComponentShow;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k
    public MiddlewareRoomContext getRoomContext() {
        return this.roomContext;
    }

    public static final /* synthetic */ Context access$getContext$p(PSHighlightContext r100) {
        return r100.context;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k
    public void bindContainer(j r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        getContainer().setValue(r100);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k
    public void dismiss(AbsPSHighlightComp r100) {
        Intrinsics.checkNotNullParameter(r100, "comp");
        j r101 = getContainer().getValue();
        if (r101 == null) goto L5;
        r101.a(r100);
    L5:
        r100.h(IPSHighlightCompLifecycle$State.Destroyed);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k
    public void setHasComponentShow(boolean r100) {
        this.hasComponentShow = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k
    public void show(AbsPSHighlightComp r100) {
        Intrinsics.checkNotNullParameter(r100, "comp");
        IPSHighlightCompLifecycle$State r101 = r100.f133403b.f64752a;
        IPSHighlightCompLifecycle$State r102 = IPSHighlightCompLifecycle$State.Created;
        if (r101.isAtLeast(r102) == true) goto L5;
        r100.h(r102);
    L5:
        r100.h(IPSHighlightCompLifecycle$State.Started);
        j r103 = getContainer().getValue();
        if (r103 == null) goto L9;
        r103.b(r100);
        return;
    }

    public static final /* synthetic */ void access$setContext$p(PSHighlightContext r100, Context r101) {
        r100.context = r101;
    }

    public PSHighlightContext(Context r100, DataCenter r101, MiddlewareRoomContext r102) {
        this.context = r100;
        this.dataCenter = r101;
        this.roomContext = r102;
        this.container$delegate = q.c(this);
        this.launchManager$delegate = LazyKt.lazy(new PSHighlightContext$launchManager$2(this));
        this.mapper$delegate = LazyKt.lazy(PSHighlightContext$mapper$2.INSTANCE);
        this.stateCenter$delegate = LazyKt.lazy(AnonymousClass2.INSTANCE);
        b r103 = getLaunchManager();
        r103.getClass();
        PSHighlightCommonCompLauncher r104 = new PSHighlightCommonCompLauncher();
        Intrinsics.checkNotNullParameter(r104, "launcher");
        if (((ArrayList) r103.f138920a).contains(r104) == true) goto L5;
        ((ArrayList) r103.f138920a).add(r104);
        r104.f(r103.f138921b, r103.f138922c);
    L5:
        Disposables.fromAction(new a(r103, r104));
        m.c r105 = getMapper();
        r105.getClass();
        e r106 = new e();
        Intrinsics.checkNotNullParameter(r106, "factory");
        if (((ArrayList) r105.f133451a).contains(r106) == true) goto L9;
        ((ArrayList) r105.f133451a).add(r106);
        return;
    }
}
