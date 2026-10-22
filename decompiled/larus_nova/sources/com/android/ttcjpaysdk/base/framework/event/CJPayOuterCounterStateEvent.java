package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPayOuterCounterStateEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "state", "", "params", "", "", "(ILjava/util/Map;)V", "getParams", "()Ljava/util/Map;", "getState", "()I", "isLaunch", "", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayOuterCounterStateEvent extends BaseEvent {
    public static final Companion Companion = null;
    private static final int STATE_DESTROY = 3;
    private static final int STATE_HIDE = 2;
    private static final int STATE_LAUNCH = 0;
    private static final int STATE_SHOW = 1;
    private final Map<String, String> params;
    private final int state;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\b\u001a\u00020\t2\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPayOuterCounterStateEvent$Companion;", "", "()V", "STATE_DESTROY", "", "STATE_HIDE", "STATE_LAUNCH", "STATE_SHOW", "toLaunch", "Lcom/android/ttcjpaysdk/base/framework/event/CJPayOuterCounterStateEvent;", "params", "", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final CJPayOuterCounterStateEvent toLaunch(Map<String, String> r100) {
            return new CJPayOuterCounterStateEvent(0, r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CJPayOuterCounterStateEvent toLaunch$default(Companion r100, Map r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = null;
        L6:
            return r100.toLaunch(r101);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final boolean isLaunch() {
        if (this.state != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final Map<String, String> getParams() {
        return this.params;
    }

    public final int getState() {
        return this.state;
    }

    public CJPayOuterCounterStateEvent(int r100, Map<String, String> r101) {
        this.state = r100;
        this.params = r101;
    }

    public /* synthetic */ CJPayOuterCounterStateEvent(int r100, Map r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
