package obric.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import obric.util.CalendarUtils;

/* JADX INFO: loaded from: classes5.dex */
public class DateTimePickerDialog extends Dialog implements View.OnClickListener {
    private final OnTimeSetListener mCallBack;
    private final DateTimePicker mDateTimePicker;
    private final View mTitleBar;
    private final MenuDialogTitleBar mTitleParent;

    public DateTimePickerDialog(Context context, OnTimeSetListener callBack, long currentTimeMills) {
        this(context, callBack, currentTimeMills, currentTimeMills, CalendarUtils.getMaxTimeMills());
    }

    public DateTimePickerDialog(Context context, OnTimeSetListener callBack, long currentTimeMills, long mMinTimeMIlls, long maxTimeMills) {
        super(context, R.style.PickTimeDialogTheme);
        this.mCallBack = callBack;
        setContentView(R.layout.date_time_picker_dialog);
        MenuDialogTitleBar r1 = (MenuDialogTitleBar) findViewById(R.id.menu_dialog_title_bar_parent);
        this.mTitleParent = r1;
        this.mTitleBar = findViewById(R.id.menu_dialog_title_bar_container);
        DateTimePicker r3 = (DateTimePicker) findViewById(R.id.date_time_picker);
        this.mDateTimePicker = r3;
        r3.init(currentTimeMills, mMinTimeMIlls, maxTimeMills, null);
        r1.setLeftButtonVisibility(0);
        r1.addCompleteImage(false);
        r1.addCancelImage(true);
        r1.setOnLeftButtonClickListener(this);
        r1.setOnRightButtonClickListener(this);
        getWindow().setGravity(80);
        getWindow().setLayout(-1, -2);
        setCanceledOnTouchOutside(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int r2 = v.getId();
        if (r2 != R.id.btn_cancel_left) goto L6;
        dismiss();
        return;
    L6:
        if (r2 != R.id.btn_cancel_right) goto L10;
        tryNotifyDateSet();
        dismiss();
        return;
    }

    private void tryNotifyDateSet() {
        if (this.mCallBack == null) goto L6;
        this.mDateTimePicker.clearFocus();
        this.mCallBack.onTimeSet(this.mDateTimePicker.getCurrentMills());
        return;
    }

    @Override // android.app.Dialog
    protected void onStop() {
        this.mDateTimePicker.clearFocus();
        super.onStop();
    }

    public void updateTitle(String title) {
        this.mTitleParent.setTitle(title);
    }

    public void setRightImageRes(int resId) {
        MenuDialogTitleBar r0 = this.mTitleParent;
        if (r0 == null) goto L6;
        r0.setRightImageRes(resId);
        return;
    }

    public void setLeftImageRes(int resId) {
        MenuDialogTitleBar r0 = this.mTitleParent;
        if (r0 == null) goto L6;
        r0.setLeftImageViewRes(resId);
        return;
    }

    @Deprecated
    public void setRightButtonText(CharSequence text) {
        MenuDialogTitleBar r0 = this.mTitleParent;
        if (r0 == null) goto L6;
        r0.setRightButtonText(text);
        return;
    }

    @Deprecated
    public void setRightButtonText(int resId) {
        setRightButtonText(getContext().getResources().getString(resId));
    }

    @Deprecated
    public void setLeftButtonText(CharSequence text) {
        MenuDialogTitleBar r0 = this.mTitleParent;
        if (r0 == null) goto L6;
        r0.setLeftButtonText(text);
        return;
    }

    @Deprecated
    public void setLeftButtonText(int resId) {
        setLeftButtonText(getContext().getResources().getString(resId));
    }
}
