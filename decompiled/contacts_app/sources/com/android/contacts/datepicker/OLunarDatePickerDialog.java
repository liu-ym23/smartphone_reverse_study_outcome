package com.android.contacts.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.android.contacts.R;
import com.android.contacts.lunar.LunarCalendar;
import com.obric.oui.sheet.v2.OSheet;
import java.time.LocalDate;
import obric.widget.DatePickerEx;

/* JADX INFO: loaded from: classes.dex */
public class OLunarDatePickerDialog extends Dialog {
    private final DatePickerUtils.OnLunarDateSetListener mCallBack;
    private LunarCalendar mChangeLunarData;
    private Context mContext;
    private LunarCalendar mCurrentLunarData;
    private DatePickerUtils.DatePickerType mPickerType;
    private OSheet mSheet;

    static /* synthetic */ LunarCalendar access$002(OLunarDatePickerDialog r0, LunarCalendar r1) {
        r0.mCurrentLunarData = r1;
        return r1;
    }

    static /* synthetic */ LunarCalendar access$100(OLunarDatePickerDialog r0) {
        return r0.mChangeLunarData;
    }

    static /* synthetic */ void access$200(OLunarDatePickerDialog r0) {
        r0.tryNotifyDateSet();
    }

    public OLunarDatePickerDialog(Context r19, DatePickerUtils.OnLunarDateSetListener r20, LunarCalendar r21, DatePickerEx.DatePickerType r22) {
        super(r19, R.style.PickTimeDialogTheme);
        this.mContext = r19;
        this.mCallBack = r20;
        this.mCurrentLunarData = r21;
        this.mChangeLunarData = r21;
        this.mPickerType = DatePickerUtils.DatePickerType.BIRTHDAY_LUNAR;
        OSheet r3 = new OSheet(this.mContext, 0);
        this.mSheet = r3;
        r3.setHeader(OSheet.Header.ACTION, null, null, "选择日期", null, false, new AnonymousClass1(this), new AnonymousClass2(this), null, null, null, null, null, null);
        this.mSheet.setBodyView(genContentView(r21));
        this.mSheet.setCancelable(true);
        this.mSheet.setOnCancelListener(new AnonymousClass3(this));
    }

    private void updateTitle(LunarCalendar r1) {
        r1.getString();
    }

    private View genContentView(LunarCalendar r6) {
        int r0 = r6.get(1);
        int r1 = r6.get(2);
        int r7 = r6.get(5);
        OReelPickerLunarDate.Builder r2 = new OReelPickerLunarDate.Builder();
        r2.setYearRange(1900, LocalDate.now().getYear());
        r2.setSelected(r0, r1, r7);
        r2.setOnChangedListener(new OLunarDatePickerDialog$$ExternalSyntheticLambda0(this));
        return r2.build(this.mContext, null, 0).asView();
    }

    /* JADX INFO: renamed from: lambda$genContentView$0$com-android-contacts-datepicker-OLunarDatePickerDialog, reason: not valid java name */
    /* synthetic */ void m162x52a90019(OReelPickerLunarDate.SelectionDate r4) {
        LunarCalendar r0 = new LunarCalendar();
        this.mChangeLunarData = r0;
        r0.set(r4.getYear(), r4.getMonth(), r4.getDay());
        updateTitle(this.mChangeLunarData);
        this.mCurrentLunarData = this.mChangeLunarData;
    }

    private void tryNotifyDateSet() {
        DatePickerUtils.OnLunarDateSetListener r0 = this.mCallBack;
        if (r0 == null) goto L6;
        r0.onDateSet(this.mCurrentLunarData);
        return;
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        dismiss();
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
        this.mChangeLunarData = this.mCurrentLunarData;
    }
}
