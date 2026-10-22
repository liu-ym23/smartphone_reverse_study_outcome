package com.stepos.activeview.handler;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import com.stepos.activeview.handler.EventHandler;
import com.stepos.activeview.json.Event;
import com.stepos.activeview.listener.OnEventListener;
import com.stepos.activeview.utils.IntentUtils;

/* loaded from: classes.dex */
public class ClickHandler extends EventHandler implements View.OnClickListener {
    public ClickHandler(View view, String str, Event event) {
        super(view, str, event);
        view.setOnClickListener(this);
    }

    private static void handleIntentUriEvent(Context context, Event event) {
        if (event == null) {
            return;
        }
        IntentUtils.handleActionUri(context, event.getAction(), event.getArgs());
    }

    private void performClick() {
        String action = this.mEvent.getAction();
        action.getClass();
        if (action.equals(Event.ACTION_TYPE_TOAST)) {
            Toast.makeText(this.mView.getContext(), this.mEvent.getArgs(), 0).show();
        } else {
            handleIntentUriEvent(this.mView.getContext(), this.mEvent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnEventListener onEventListener = this.mOnEventListener;
        if (onEventListener == null || !onEventListener.onClick(this.mId, this.mEvent.getAction(), this.mEvent.getArgs())) {
            performClick();
        }
        EventHandler.Callback callback = this.mCallback;
        if (callback != null) {
            callback.clickCallback();
        }
    }
}
