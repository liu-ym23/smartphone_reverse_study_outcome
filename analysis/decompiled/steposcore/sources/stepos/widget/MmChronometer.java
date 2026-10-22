package stepos.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.RemotableViewMethod;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.android.internal.R;
import java.util.Locale;

@RemoteViews.RemoteView
/* loaded from: classes.dex */
public class MmChronometer extends TextView {
    private long mBase;
    private ForegroundColorSpan mColorSpan;
    private long mElapsedTime;
    private boolean mRunning;
    private long mUpdateInterval;
    private Runnable mUpdateTimer;
    private int millisecondColor;

    public MmChronometer(Context context) {
        super(context);
        this.mUpdateInterval = 10L;
        this.mUpdateTimer = new Runnable() { // from class: stepos.widget.MmChronometer.1
            @Override // java.lang.Runnable
            public void run() {
                if (MmChronometer.this.mRunning) {
                    MmChronometer.this.mElapsedTime = SystemClock.elapsedRealtime() - MmChronometer.this.mBase;
                    MmChronometer.this.updateText();
                    MmChronometer.this.postDelayed(this, MmChronometer.this.mUpdateInterval);
                }
            }
        };
        init(null);
    }

    public MmChronometer(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mUpdateInterval = 10L;
        this.mUpdateTimer = new Runnable() { // from class: stepos.widget.MmChronometer.1
            @Override // java.lang.Runnable
            public void run() {
                if (MmChronometer.this.mRunning) {
                    MmChronometer.this.mElapsedTime = SystemClock.elapsedRealtime() - MmChronometer.this.mBase;
                    MmChronometer.this.updateText();
                    MmChronometer.this.postDelayed(this, MmChronometer.this.mUpdateInterval);
                }
            }
        };
        init(attrs);
    }

    public MmChronometer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mUpdateInterval = 10L;
        this.mUpdateTimer = new Runnable() { // from class: stepos.widget.MmChronometer.1
            @Override // java.lang.Runnable
            public void run() {
                if (MmChronometer.this.mRunning) {
                    MmChronometer.this.mElapsedTime = SystemClock.elapsedRealtime() - MmChronometer.this.mBase;
                    MmChronometer.this.updateText();
                    MmChronometer.this.postDelayed(this, MmChronometer.this.mUpdateInterval);
                }
            }
        };
        init(attrs);
    }

    public MmChronometer(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mUpdateInterval = 10L;
        this.mUpdateTimer = new Runnable() { // from class: stepos.widget.MmChronometer.1
            @Override // java.lang.Runnable
            public void run() {
                if (MmChronometer.this.mRunning) {
                    MmChronometer.this.mElapsedTime = SystemClock.elapsedRealtime() - MmChronometer.this.mBase;
                    MmChronometer.this.updateText();
                    MmChronometer.this.postDelayed(this, MmChronometer.this.mUpdateInterval);
                }
            }
        };
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        this.millisecondColor = getCurrentTextColor();
        if (attrs != null) {
            TypedArray typedArray = getResources().obtainAttributes(attrs, R.styleable.MmChronometer);
            this.millisecondColor = typedArray.getColor(0, getCurrentTextColor());
            typedArray.recycle();
        }
        this.mColorSpan = new ForegroundColorSpan(this.millisecondColor);
        updateText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText() {
        long hours = this.mElapsedTime / 3600000;
        long minutes = (this.mElapsedTime % 3600000) / 60000;
        long seconds = (this.mElapsedTime % 60000) / 1000;
        long milliseconds = this.mElapsedTime % 1000;
        String hms = String.format(Locale.getDefault(), "%02d:%02d:%02d:", Long.valueOf(hours), Long.valueOf(minutes), Long.valueOf(seconds));
        String numStr = String.format("%03d", Long.valueOf(milliseconds));
        char m1 = numStr.charAt(0);
        char m2 = numStr.charAt(1);
        SpannableString time = new SpannableString(hms + m1 + m2);
        time.setSpan(this.mColorSpan, time.length() - 2, time.length(), 33);
        setText(time);
    }

    private void start() {
        this.mBase = SystemClock.elapsedRealtime() - this.mElapsedTime;
        this.mRunning = true;
        updateText();
        postDelayed(this.mUpdateTimer, this.mUpdateInterval);
    }

    private void stop() {
        this.mRunning = false;
        removeCallbacks(this.mUpdateTimer);
    }

    @RemotableViewMethod
    public void setMillisecondColor(int color) {
        this.millisecondColor = color;
        this.mColorSpan = new ForegroundColorSpan(this.millisecondColor);
    }

    @RemotableViewMethod
    public void setStart(boolean isStart) {
        if (isStart) {
            start();
        } else {
            stop();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }
}
