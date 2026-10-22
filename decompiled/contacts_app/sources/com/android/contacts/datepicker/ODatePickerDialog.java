package com.android.contacts.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.android.contacts.R;
import com.obric.oui.picker.reels.pickers.OReelPickerDate;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.time.ClockFormat;
import com.obric.oui.time.TimeDateUtil;
import com.obric.oui.time.TimeStyle;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class ODatePickerDialog extends Dialog {
    private DatePickerUtils.OnDateSetListener mCallBack;
    private int mChangeDayOfMonth;
    private int mChangeMonthOfYear;
    private int mChangeYear;
    private Context mContext;
    private int mDayOfMonth;
    private LocalDate mLocalDate;
    private int mMonthOfYear;
    private DatePickerUtils.DatePickerType mPickerType;
    private OSheet mSheet;
    private int mYear;

    static /* synthetic */ int access$002(ODatePickerDialog r0, int r1) {
        r0.mYear = r1;
        return r1;
    }

    static /* synthetic */ int access$100(ODatePickerDialog r0) {
        return r0.mChangeYear;
    }

    static /* synthetic */ int access$202(ODatePickerDialog r0, int r1) {
        r0.mMonthOfYear = r1;
        return r1;
    }

    static /* synthetic */ int access$300(ODatePickerDialog r0) {
        return r0.mChangeMonthOfYear;
    }

    static /* synthetic */ int access$402(ODatePickerDialog r0, int r1) {
        r0.mDayOfMonth = r1;
        return r1;
    }

    static /* synthetic */ int access$500(ODatePickerDialog r0) {
        return r0.mChangeDayOfMonth;
    }

    static /* synthetic */ void access$600(ODatePickerDialog r0) {
        r0.tryNotifyDateSet();
    }

    public ODatePickerDialog(Context r18, DatePickerUtils.OnDateSetListener r19, int r20, int r21, int r22, DatePickerUtils.DatePickerType r23) {
        super(r18, R.style.PickTimeDialogTheme2);
        this.mContext = r18;
        this.mPickerType = r23;
        this.mCallBack = r19;
        this.mLocalDate = LocalDate.of(r20, r21, r22);
        this.mYear = r20;
        this.mMonthOfYear = r21;
        this.mDayOfMonth = r22;
        this.mChangeYear = r20;
        this.mChangeMonthOfYear = r21;
        this.mChangeDayOfMonth = r22;
        OSheet r2 = new OSheet(this.mContext, 0);
        this.mSheet = r2;
        r2.setHeader(OSheet.Header.ACTION, null, null, "选择日期", null, false, new AnonymousClass1(this), new AnonymousClass2(this), null, null, null, null, null, null);
        this.mSheet.setBodyView(genContentView());
        this.mSheet.setCancelable(true);
        this.mSheet.setOnDismissListener(new AnonymousClass3(this));
        this.mSheet.setOnCancelListener(new AnonymousClass4(this));
    }

    private View genContentView() {
        OReelPickerDate.Builder r0 = new OReelPickerDate.Builder();
        r0.setYearRange(1900, LocalDate.now().getYear());
        r0.setSelected(LocalDate.of(this.mYear, this.mMonthOfYear, this.mDayOfMonth));
        r0.setOnChangedListener(new ODatePickerDialog$$ExternalSyntheticLambda0(this));
        return r0.build(this.mContext, null, 0).asView();
    }

    /* JADX INFO: renamed from: lambda$genContentView$0$com-android-contacts-datepicker-ODatePickerDialog, reason: not valid java name */
    /* synthetic */ void m161x3d29dc25(LocalDate r3) {
        this.mChangeYear = r3.getYear();
        this.mChangeMonthOfYear = r3.getMonthValue();
        int r4 = r3.getDayOfMonth();
        this.mChangeDayOfMonth = r4;
        updateTitle(this.mChangeYear, this.mChangeMonthOfYear, r4);
    }

    private void tryNotifyDateSet() {
        DatePickerUtils.OnDateSetListener r0 = this.mCallBack;
        if (r0 == null) goto L6;
        r0.onDateSet(this.mYear, this.mMonthOfYear, this.mDayOfMonth);
        return;
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        dismiss();
    }

    private void updateTitle(int r1, int r2, int r3) {
        LocalDate r4 = LocalDate.of(r1, r2, r3);
        this.mLocalDate = r4;
        Date r5 = Date.from(r4.atStartOfDay(ZoneId.systemDefault()).toInstant());
        if (DatePickerUtils.seemsUnsetYear(r1, this.mPickerType) == false) goto L5;
        TimeDateUtil.formatTime(TimeStyle.FULL_MD, r5, ClockFormat.H24, false);
        return;
    L5:
        TimeDateUtil.formatTime(TimeStyle.FULL_YMD, r5, ClockFormat.H24, false);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        this.mSheet.show();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.mSheet.dismiss();
        this.mChangeYear = this.mYear;
        this.mChangeMonthOfYear = this.mMonthOfYear;
        this.mChangeDayOfMonth = this.mDayOfMonth;
    }

    public void updateDate(int r1, int r2, int r3, DatePickerUtils.DatePickerType r4) {
        this.mPickerType = r4;
        updateTitle(r1, r2, r3);
    }
}
