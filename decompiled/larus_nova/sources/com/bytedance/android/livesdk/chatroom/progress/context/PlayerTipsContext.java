package com.bytedance.android.livesdk.chatroom.progress.context;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.e;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R.\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/progress/context/PlayerTipsContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/k;", "Lcom/bytedance/android/livesdk/chatroom/progress/context/a;", "mShowPlayerTipEvent$delegate", "Lcom/bytedance/live/datacontext/p;", "getMShowPlayerTipEvent", "()Lcom/bytedance/live/datacontext/k;", "mShowPlayerTipEvent", "", "mHidePlayerTipEvent$delegate", "getMHidePlayerTipEvent", "mHidePlayerTipEvent", "", "", "showMap", "Ljava/util/Map;", "getShowMap", "()Ljava/util/Map;", "setShowMap", "(Ljava/util/Map;)V", "Lcom/bytedance/live/datacontext/m;", "isTipsShowing$delegate", "isTipsShowing", "()Lcom/bytedance/live/datacontext/m;", "getPlayerTipShowing", "()Z", "playerTipShowing", "<init>", "()V", "vs-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerTipsContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p isTipsShowing$delegate;
    private final p mHidePlayerTipEvent$delegate;
    private final p mShowPlayerTipEvent$delegate;
    private Map<String, Boolean> showMap;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(PlayerTipsContext.class, "mShowPlayerTipEvent", "getMShowPlayerTipEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerTipsContext.class, "mHidePlayerTipEvent", "getMHidePlayerTipEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerTipsContext.class, "isTipsShowing", "isTipsShowing()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
    }

    public final k<String> getMHidePlayerTipEvent() {
        return (k) this.mHidePlayerTipEvent$delegate.a(this, $$delegatedProperties[1]);
    }

    public final k<a> getMShowPlayerTipEvent() {
        return (k) this.mShowPlayerTipEvent$delegate.a(this, $$delegatedProperties[0]);
    }

    public final m<Boolean> isTipsShowing() {
        return (m) this.isTipsShowing$delegate.a(this, $$delegatedProperties[2]);
    }

    public final boolean getPlayerTipShowing() {
        Iterator<Map.Entry<String, Boolean>> r100 = this.showMap.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        if (r100.next().getValue().booleanValue() == false) goto L4;
        return true;
    L9:
        return false;
    }

    public PlayerTipsContext() {
        this.mShowPlayerTipEvent$delegate = e.b(this);
        this.mHidePlayerTipEvent$delegate = e.b(this);
        this.showMap = new LinkedHashMap();
        this.isTipsShowing$delegate = q.d(this, Boolean.FALSE);
    }

    public final Map<String, Boolean> getShowMap() {
        return this.showMap;
    }

    public final void setShowMap(Map<String, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.showMap = r100;
    }
}
