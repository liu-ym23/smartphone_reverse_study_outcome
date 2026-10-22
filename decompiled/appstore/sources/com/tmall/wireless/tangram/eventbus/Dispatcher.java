package com.tmall.wireless.tangram.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class Dispatcher extends Handler implements IDispatcher {
    private IDispatcherDelegate mDispatcherDelegate;

    public Dispatcher(IDispatcherDelegate r10) {
        super(Looper.getMainLooper());
        this.mDispatcherDelegate = r10;
    }

    @Override // com.tmall.wireless.tangram.eventbus.IDispatcher
    public boolean enqueue(@NonNull Event r10) {
        Message r11 = obtainMessage();
        r11.obj = r10;
        return sendMessage(r11);
    }

    @Override // android.os.Handler
    public void handleMessage(Message r10) {
        super.handleMessage(r10);
        IDispatcherDelegate r11 = this.mDispatcherDelegate;
        if (r11 == null) goto L5;
        r11.dispatch((Event) r10.obj);
    L5:
        EventPool.sharedInstance().release((Event) r10.obj);
    }

    @Override // com.tmall.wireless.tangram.eventbus.IDispatcher
    public void start() {
    }

    @Override // com.tmall.wireless.tangram.eventbus.IDispatcher
    public void stopSelf() {
        removeCallbacksAndMessages(null);
    }

    @Override // com.tmall.wireless.tangram.eventbus.IDispatcher
    public boolean enqueue(@NonNull List<Event> r10) {
        int r11 = r10.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        Message r13 = obtainMessage();
        r13.obj = r10.get(r12);
        sendMessage(r13);
        r12 = r12 + 1;
        goto L3
    L5:
        return true;
    }
}
