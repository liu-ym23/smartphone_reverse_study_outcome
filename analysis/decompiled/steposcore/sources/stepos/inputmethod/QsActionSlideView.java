package stepos.inputmethod;

import android.content.Context;
import android.inputmethodservice.InputMethodService;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class QsActionSlideView extends FrameLayout {
    private static final String TAG = "QsActionSlideView";
    private GestureDetector mGestureDetector;

    private static class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        private final InputMethodService mIms;
        private float mStartX = 0.0f;

        MyGestureListener(InputMethodService ims) {
            this.mIms = ims;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent ev) {
            this.mStartX = ev.getX();
            return true;
        }

        private void sendCombinationKeyEvents(int keyEventCode) {
            sendCombinationKeyEvents(keyEventCode, false, false, false);
        }

        private void sendCombinationKeyEvents(int keyEventCode, boolean alt, boolean ctrl, boolean shift) {
            int metaState = 0;
            long eventTime = SystemClock.uptimeMillis();
            if (alt) {
                metaState = 0 | 18;
            }
            if (ctrl) {
                metaState |= 12288;
            }
            if (shift) {
                metaState |= 65;
            }
            if (alt) {
                sendDownKeyEvent(eventTime, 57);
            }
            if (ctrl) {
                sendDownKeyEvent(eventTime, 113);
            }
            if (shift) {
                sendDownKeyEvent(eventTime, 59);
            }
            sendDownKeyEvent(eventTime, keyEventCode, metaState);
            sendUpKeyEvent(eventTime, keyEventCode, metaState);
            if (shift) {
                sendUpKeyEvent(eventTime, 59);
            }
            if (ctrl) {
                sendUpKeyEvent(eventTime, 113);
            }
            if (alt) {
                sendUpKeyEvent(eventTime, 57);
            }
        }

        private void sendDownKeyEvent(long eventTime, int keyEventCode) {
            sendDownKeyEvent(eventTime, keyEventCode, 0);
        }

        private void sendUpKeyEvent(long eventTime, int keyEventCode) {
            sendUpKeyEvent(eventTime, keyEventCode, 0);
        }

        private void sendUpKeyEvent(long eventTime, int keyEventCode, int metaState) {
            InputConnection inputConnection = this.mIms.getCurrentInputConnection();
            inputConnection.sendKeyEvent(new KeyEvent(eventTime, SystemClock.uptimeMillis(), 1, keyEventCode, 0, metaState, -1, 0, 6));
        }

        private void sendDownKeyEvent(long eventTime, int keyEventCode, int metaState) {
            InputConnection inputConnection = this.mIms.getCurrentInputConnection();
            inputConnection.sendKeyEvent(new KeyEvent(eventTime, eventTime, 0, keyEventCode, 0, metaState, -1, 0, 6));
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.d(QsActionSlideView.TAG, "onScroll=" + distanceX + ",velocityY=" + distanceY + ",distanceX+" + distanceX);
            if (Math.abs(distanceX) < ViewConfiguration.getMinimumFlingVelocity() && Math.abs(e2.getX() - this.mStartX) > 30.0f && Math.abs(distanceX) > Math.abs(distanceY) * 5.0f) {
                sendCombinationKeyEvents(distanceX > 0.0f ? 21 : 22);
                this.mStartX = e2.getX();
                return true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (Math.abs(velocityX) > 2000.0f) {
                sendCombinationKeyEvents(54, false, true, velocityX > 0.0f);
                Log.d(QsActionSlideView.TAG, "onFling velocityX=" + velocityX + ",velocityY=" + velocityY);
            }
            return true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (this.mGestureDetector != null) {
            return this.mGestureDetector.onTouchEvent(event);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mGestureDetector = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mContext instanceof InputMethodService) {
            this.mGestureDetector = new GestureDetector(this.mContext, new MyGestureListener((InputMethodService) this.mContext));
        }
    }

    public QsActionSlideView(Context context) {
        super(context);
    }

    public QsActionSlideView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public QsActionSlideView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public QsActionSlideView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
