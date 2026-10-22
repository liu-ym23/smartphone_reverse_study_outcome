package com.stepos.activeview.handler;

import android.view.View;
import com.stepos.activeview.json.Event;
import com.stepos.activeview.listener.OnEventListener;

/* loaded from: classes.dex */
public abstract class EventHandler {
    protected Callback mCallback;
    protected Event mEvent;
    protected String mId;
    protected OnEventListener mOnEventListener;
    protected View mView;

    public interface Callback {
        void clickCallback();
    }

    public EventHandler(View view, String str, Event event) {
        this.mView = view;
        this.mEvent = event;
        this.mId = str;
    }

    public static EventHandler registerEventHandler(View view, String str, Event event) {
        String type = event.getType();
        type.getClass();
        if (type.equals("click")) {
            return new ClickHandler(view, str, event);
        }
        return null;
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void setOnEventListener(OnEventListener onEventListener) {
        this.mOnEventListener = onEventListener;
    }
}
