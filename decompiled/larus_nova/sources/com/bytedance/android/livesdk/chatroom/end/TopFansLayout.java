package com.bytedance.android.livesdk.chatroom.end;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public class TopFansLayout extends LinearLayout implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f106028a;

    public interface a {
    }

    public void setDataCenter(DataCenter r100) {
    }

    public void setFollowVisible(boolean r100) {
    }

    public void setTopFansCallBack(a r100) {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.f106028a.clear();
    }

    public TopFansLayout(Context r100) {
        super(r100);
        new ArrayList();
        this.f106028a = new CompositeDisposable();
    }

    public TopFansLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        new ArrayList();
        this.f106028a = new CompositeDisposable();
    }

    public TopFansLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        new ArrayList();
        this.f106028a = new CompositeDisposable();
    }
}
