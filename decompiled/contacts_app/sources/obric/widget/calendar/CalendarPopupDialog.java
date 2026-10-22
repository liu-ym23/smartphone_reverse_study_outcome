package obric.widget.calendar;

import android.content.Context;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import java.util.Calendar;
import obric.util.CalendarUtils;
import obric.widget.OnTimeSetListener;
import obric.widget.R;
import obric.widget.support.PopupMenu;

/* JADX INFO: loaded from: classes5.dex */
public class CalendarPopupDialog extends PopupMenu implements View.OnClickListener {
    protected CalendarView mCalendarView;
    private OnTimeSetListener mCallBack;
    private Calendar mCurrentCal;
    private long mCurrentTimeMills;
    private long mMaxTimeMills;
    private long mMinTimeMills;
    protected TimePicker1Day mTimePickEx;

    public CalendarPopupDialog(Context context, OnTimeSetListener callBack) {
        this(context, callBack, System.currentTimeMillis(), System.currentTimeMillis(), CalendarUtils.getMaxTimeMills());
    }

    public CalendarPopupDialog(Context context, OnTimeSetListener callBack, long currentTimeMills, long minTimeMills, long maxTimeMills) {
        super(context);
        this.mCallBack = callBack;
        this.mContentAreaWidth = context.getResources().getDimensionPixelOffset(R.dimen.calendar_popup_window_width);
        initViews();
        initDatas(currentTimeMills, minTimeMills, maxTimeMills);
    }

    protected void initDatas(long currentTimeMills, long minTimeMills, long maxTimeMills) {
        this.mCurrentTimeMills = currentTimeMills;
        this.mMaxTimeMills = maxTimeMills;
        this.mMinTimeMills = minTimeMills;
    }

    protected void setOnClickListerners() {
        this.mMenuPanelView.findViewById(R.id.cancel).setOnClickListener(this);
        this.mMenuPanelView.findViewById(R.id.confirm).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int r3 = v.getId();
        if (r3 != R.id.cancel) goto L6;
        dismiss();
        return;
    L6:
        if (r3 != R.id.confirm) goto L10;
        Time r4 = this.mCalendarView.getCurrentTime();
        r4.hour = this.mTimePickEx.getCurrentHour().intValue();
        r4.minute = this.mTimePickEx.getCurrentMinute().intValue();
        notifyAndDismiss(r4.normalize(true));
        return;
    }

    private void notifyAndDismiss(long time) {
        OnTimeSetListener r0 = this.mCallBack;
        if (r0 == null) goto L5;
        r0.onTimeSet(time);
    L5:
        dismiss();
    }

    @Override // obric.widget.support.PopupMenu
    protected void prepareShow() {
        this.mCalendarView.initTimes(this.mMinTimeMills, this.mCurrentTimeMills, this.mMaxTimeMills);
        Calendar r0 = Calendar.getInstance();
        this.mCurrentCal = r0;
        r0.setTimeInMillis(this.mCurrentTimeMills);
        this.mTimePickEx.setCurrentHour(Integer.valueOf(this.mCurrentCal.get(11)));
        this.mTimePickEx.setCurrentMinute(Integer.valueOf(this.mCurrentCal.get(12)));
        setOnClickListerners();
    }

    private void initViews() {
        this.mMenuPanelView = LayoutInflater.from(this.mContext).inflate(R.layout.calendar_select_time_dialog, null);
        this.mCalendarView = (CalendarView) this.mMenuPanelView.findViewById(R.id.calendar_view);
        this.mTimePickEx = (TimePicker1Day) this.mMenuPanelView.findViewById(R.id.time_picker);
    }

    @Override // obric.widget.support.PopupMenu
    public int getPopupWindowWidth() {
        return super.getPopupWindowWidth();
    }

    @Override // obric.widget.support.PopupMenu
    public int getLeftRightShadowWidth() {
        return super.getLeftRightShadowWidth();
    }

    @Override // obric.widget.support.PopupMenu
    public int getMenuPanelBgRoundCornerRadius() {
        return super.getMenuPanelBgRoundCornerRadius();
    }

    @Override // obric.widget.support.PopupMenu
    public void showCenter() {
        super.showCenter();
    }

    public void setRightButtonText(CharSequence text) {
        if (this.mMenuPanelView == null) goto L8;
        Button r1 = (Button) this.mMenuPanelView.findViewById(R.id.confirm);
        if (r1 == null) goto L9;
        r1.setText(text);
        return;
    L9:
        return;
    }

    public void setRightButtonText(int resId) {
        setRightButtonText(this.mContext.getResources().getString(resId));
    }

    public void setLeftButtonText(CharSequence text) {
        if (this.mMenuPanelView == null) goto L8;
        Button r1 = (Button) this.mMenuPanelView.findViewById(R.id.cancel);
        if (r1 == null) goto L9;
        r1.setText(text);
        return;
    L9:
        return;
    }

    public void setLeftButtonText(int resId) {
        setLeftButtonText(this.mContext.getResources().getString(resId));
    }
}
